package com.youku.atm.easycast;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;

import javax.imageio.ImageIO;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.SqlEnum;

import com.geekplus.ark.om.TWorkstation;
import com.geekplus.ark.om.TWorkstationPeer;
import com.youku.adssp.om.YesDsp;
import com.youku.adssp.om.YesDspPeer;
import com.youku.atm.busmodule.utils.StringUtil;
import com.youku.atm.easycast.IdeaUrlConstant;
import com.youku.atm.om.AreaPeer;
import com.youku.atm.om.Campaign;
import com.youku.atm.om.CampaignPeer;
import com.youku.atm.om.Channel;
import com.youku.atm.om.Area;
import com.youku.atm.om.ChannelPeer;
import com.youku.atm.om.HPosition;
import com.youku.atm.om.HPositionPeer;
import com.youku.atm.om.Platform;
import com.youku.atm.om.PlatformPeer;
import com.youku.atm.om.AdPosition;
import com.youku.atm.om.AdPositionPeer;


public class EasyCastUtil {
	/**
	 * 取得可用于配置属性页面的分类
	 * 
	 * @return 可用于配置属性页面的分类List
	 */

	private static Pattern regex_vid = Pattern.compile("\\w+X(.+).html?");
	private static final int buffer = 2048;

	/**
	 * 获取机器所有网卡的IP（ipv4）
	 * 
	 * @return
	 */
	public static List<String> getLocalIP() {
		List<String> ipList = new ArrayList<String>();
		InetAddress ip = null;
		try {
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
					.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
				// 遍历所有ip
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (null == ip || "".equals(ip)) {
						continue;
					}
					String sIP = ip.getHostAddress();
					if (sIP == null || sIP.indexOf(":") > -1) {
						continue;
					}
					ipList.add(sIP);
					System.out.println(sIP);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipList;
	}

	public static List<Channel> getAllConfigChannels(String site) {
		List<String> whiteChannelId = new ArrayList<String>(); // 配置中不出现下列无用频道
		whiteChannelId.add("i");
		whiteChannelId.add("k");
		// whiteChannelId.add("w"); //纪录片
		// 过滤所有人群begin
		whiteChannelId.add("c1");
		whiteChannelId.add("c2");
		whiteChannelId.add("c3");
		whiteChannelId.add("c4");
		whiteChannelId.add("c5");
		whiteChannelId.add("c6");
		whiteChannelId.add("c7");
		whiteChannelId.add("c8");
		whiteChannelId.add("c9");
		whiteChannelId.add("c10");
		// 过滤所有人群end
		whiteChannelId.add("wi"); // 过滤ipad频道
		Criteria c_ccc = new Criteria();
		c_ccc.addNotIn(ChannelPeer.ID, whiteChannelId);
		c_ccc.add(ChannelPeer.PARENT_ID, site);
		List<Channel> channelList = null;
		try {
			channelList = ChannelPeer.doSelect(c_ccc);
		} catch (TorqueException e) {
		}
		return channelList;
	}

	// getAllarea
	public static List<Area> getAllConfigAreas(String province) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(AreaPeer.LEVEL, province);
		List<Area> areaList = null;
		try {
			areaList = AreaPeer.doSelect(c_ccc);
		} catch (TorqueException e) {
		}
		return areaList;
	}

	// getAllcitys
	public static List<Area> getAllConfigCitys(String city) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(AreaPeer.PARENT_ID, city);
		List<Area> areaList = null;
		try {
			areaList = AreaPeer.doSelect(c_ccc);
		} catch (TorqueException e) {

		}
		return areaList;
	}

	// getAllstates
	public static List<Area> getAllConfigStates(String state) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(AreaPeer.LEVEL, state);
		List<Area> areaList = null;
		try {
			areaList = AreaPeer.doSelect(c_ccc);
		} catch (TorqueException e) {
		}
		return areaList;
	}

	// getAllcountrys
	public static List<Area> getAllConfigCountrys(String country) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(AreaPeer.PARENT_ID, country);
		List<Area> areaList = null;
		try {
			areaList = AreaPeer.doSelect(c_ccc);
		} catch (TorqueException e) {
		}
		return areaList;

	}

	// getAllPlatform
	public static List<Platform> getAllConfigPlatforms(String site) {

		Criteria c_ccc = new Criteria();
		c_ccc.add(PlatformPeer.SITE, site);
		List<Platform> platformList = null;
		try {
			platformList = PlatformPeer.doSelect(c_ccc);
		} catch (TorqueException e) {
		}
		return platformList;
	}

	// getAllCampaign_show
	public static List<Campaign> getAllConfigCampaigns_show(int type) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(CampaignPeer.TYPE, 1);
		List<Campaign> campaignList_show = null;
		try {
			campaignList_show = CampaignPeer.doSelect(c_ccc);
		} catch (TorqueException e) {

		}
		return campaignList_show;
	}

	// getAllCampaign_click
	public static List<Campaign> getAllConfigCampaigns_click(int type) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(CampaignPeer.TYPE, 2);
		List<Campaign> campaignList_click = null;
		try {
			campaignList_click = CampaignPeer.doSelect(c_ccc);
		} catch (TorqueException e) {
		}
		return campaignList_click;
	}

	// getAllCampaign_over
	public static List<Campaign> getAllConfigCampaigns_over(int type) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(CampaignPeer.TYPE, 3);
		List<Campaign> campaignList_over = null;
		try {
			campaignList_over = CampaignPeer.doSelect(c_ccc);
		} catch (TorqueException e) {

		}
		return campaignList_over;
	}

	// getAllCampaign_skip
	public static List<Campaign> getAllConfigCampaigns_skip(int type) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(CampaignPeer.TYPE, 4);
		List<Campaign> campaignList_skip = null;
		try {
			campaignList_skip = CampaignPeer.doSelect(c_ccc);
		} catch (TorqueException e) {
		}
		return campaignList_skip;
	}

	// getAllCampaign_preload
	public static List<Campaign> getAllConfigCampaigns_preload(int type) {
		Criteria c_ccc = new Criteria();
		c_ccc.add(CampaignPeer.TYPE, 5);
		// c_ccc.add(CampaignPeer.TYPE,5,SqlEnum.LIKE);

		List<Campaign> campaignList_preload = null;
		try {
			campaignList_preload = CampaignPeer.doSelect(c_ccc);
		} catch (TorqueException e) {

		}
		return campaignList_preload;
	}

	public static List<HPosition> getHposition(String name) {

		Criteria c_ccc = new Criteria();
		Object object = name;
		c_ccc.add(HPositionPeer.NAME, object, SqlEnum.LIKE);
		// c_ccc.add(column, value, comparison);

		List<HPosition> hPosition = null;
		try {
			hPosition = HPositionPeer.doSelect(c_ccc);
			System.out.println("++++++++++" + hPosition.get(1).getName());
		} catch (TorqueException e) {
		}
		return hPosition;
	}

	// 信息流获取新广告位(也可获取4个参数的广告位list信息-name,media,type,pos_type)
	public static List<AdPosition> getInfoFlowAdPosition(String name, String media, String type, String pos_type) {

		Criteria c_ccc = new Criteria();
		Object object = name;
		c_ccc.add(AdPositionPeer.NAME, object, SqlEnum.LIKE);
		c_ccc.add(AdPositionPeer.MEDIA, media);
		c_ccc.add(AdPositionPeer.TYPE, type);
		String[] pos_type_spotlight = pos_type.split(",");
		c_ccc.addIn(AdPositionPeer.POS_TYPE, pos_type_spotlight);
		List<AdPosition> adPosition = null;
		try {
			adPosition = AdPositionPeer.doSelect(c_ccc);
			System.out.println("++++++++++" + adPosition.get(1).getName());
		} catch (TorqueException e) {
		}
		return adPosition;
	}

	// ssp二期新广告位(String pos_sub_type,String type,String pos_type,String seq_num)
	public static String getAdposition(String... args) {
		String ssp_new_position = "";
		Criteria c_ccc = new Criteria();
		List<AdPosition> adPosition = null;
		if (args.length == 4) {
			List<String> pos_sub_type_lists = new ArrayList<String>();
			pos_sub_type_lists.add(args[0]);
			if (!"101".equals(args[0])) {
				c_ccc.addIn(AdPositionPeer.POS_SUB_TYPE, pos_sub_type_lists);
			} else {
				c_ccc.addNotIn(AdPositionPeer.POS_SUB_TYPE, pos_sub_type_lists);
			}
			c_ccc.add(AdPositionPeer.TYPE, args[1]);
			String[] pos_type = args[2].split(",");
			c_ccc.addIn(AdPositionPeer.POS_TYPE, pos_type);
			c_ccc.add(AdPositionPeer.SEQ_NUM, args[3]);
		}
		if (args.length == 3) {
			List<String> pos_sub_type_lists = new ArrayList<String>();
			pos_sub_type_lists.add(args[0]);
			// System.out.println("########## args[0] is : " + args[0] + "
			// ################");
			if (!"101".equals(args[0])) {
				c_ccc.addIn(AdPositionPeer.POS_SUB_TYPE, pos_sub_type_lists);
				// System.out.println("##########not 101");
			} else {
				c_ccc.addNotIn(AdPositionPeer.POS_SUB_TYPE, pos_sub_type_lists);
				// System.out.println("########## 101");
			}
			c_ccc.add(AdPositionPeer.TYPE, args[1]);
			String[] pos_type = args[2].split(",");
			c_ccc.addIn(AdPositionPeer.POS_TYPE, pos_type);

		}
		if (args.length == 2) {
			c_ccc.add(AdPositionPeer.TYPE, args[0]);
			String[] pos_type = args[1].split(",");
			c_ccc.addIn(AdPositionPeer.POS_TYPE, pos_type);
		}
		try {
			adPosition = AdPositionPeer.doSelect(c_ccc);
			for (int i = 0; i < adPosition.size(); i++) {
				ssp_new_position = ssp_new_position + adPosition.get(i).getId() + ",";
			}
			// System.out.println("adPosition###############::::" + ssp_new_position);
		} catch (TorqueException e) {
		}
		return ssp_new_position.substring(0, ssp_new_position.length() - 1);
	}

//	public static List<YesDsp> getYesDsp(){
//		Criteria c_ccc = new Criteria("adssp");
//		String aa="test";
//		c_ccc.add(YesDspPeer.DSPNAME, (Object)aa , SqlEnum.LIKE);
//		List<YesDsp> yesDsp = null;
//		try {
//			yesDsp = YesDspPeer.doSelect(c_ccc);
//			System.out.println("yesDspyesDspyesDspyesDspyesDspyesDsp++++++++++" + yesDsp.get(1).getDspname());
//		} catch (TorqueException e) {		
//		}	
//		return yesDsp;	
//		
//	}
	
	public static List<TWorkstation> getCellcodes(String cellcodeType) {

		Criteria c_ccc = new Criteria();
		Object object = cellcodeType;
		c_ccc.add(TWorkstationPeer.WORKSTATION_NAME, object, SqlEnum.LIKE);
		// c_ccc.add(column, value, comparison);

		List<TWorkstation> cellcodesList = null;
		try {
			cellcodesList = TWorkstationPeer.doSelect(c_ccc);
			//System.out.println("++++++++++" + hPosition.get(1).getName());
		} catch (TorqueException e) {
		}
		return cellcodesList;
	}

	/**
	 * 得到当前日期的前一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTomorrow(Date date) {
		Date date_R = new Date(date.getTime() + 24 * 3600 * 1000);
		return date_R;
	}

	public static int getVideoLength(String playurl) {
		// return getVideoLength2(getPlayListJson(playurl));
		String showtime = findValueByKey(playurl, "seconds");
		int videoLen = Math.round(Float.parseFloat(showtime));
		return videoLen;
	}

	public static int getVideoLength2(String json) {
		if (json == null)
			return 0;
		try {
			JSONObject jo = JSONObject.fromObject(json);
			String seconds = jo.getJSONArray("data").getJSONObject(0).getString("seconds");
			int videoLen = Math.round(Float.parseFloat(seconds));
			return videoLen;
		} catch (Throwable e) {
			e.printStackTrace();
			return 15;
		}
	}

//	private static String getPlayListJson(String playurl){
//		String regex = "\\w+X(.+).html?";
//		Pattern p=Pattern.compile(regex); 
//		Matcher m=p.matcher(playurl); 
//		if(m.find()){
//			String id =  m.group(1);
//			id = StringUtil.decodeBase64(id);
//			//int idd = Integer.parseInt(id)>>2;
//			Long idd = Long.parseLong(id)>>2;			
//			//getplaylist切换到yks接口
//			//String json = Util.requestGet("http://v.youku.com/player/getPlayList/VideoIDS/"+idd);
//			//String json = Util.requestGet("http://30.96.74.4/yks/get.json?ct=50&uip=10.100.188.64&pt=video&dv=pc&vid="+idd);
//			//////String json = Util.requestGet("http://106.11.186.41/yks/get.json?ct=50&uip=10.100.188.64&pt=video&dv=pc&vid="+idd);
//			String json = getVideoJson(playurl);
//			//System.out.println(json);
//			return json;
//		}else{
//			return null;
//		}
//	}
	private static String findValueByKey(String url, String key) {
		// String str = getPlayListJson(url);
		String str = getVideoJson(url);
		if (str != null) {
			JSONObject j = JSONObject.fromObject(str);
			if (j.has("dataset") && j.get("dataset") != null) {
				JSONObject jo = (JSONObject) j.getJSONObject("dataset");
				if (jo != null) {
					JSONObject re = jo.getJSONObject("video");
					return re.get(key) != null ? (String) re.get(key) : null;
				}
			}
		}
		return "15";
	}

	public static String calVid(String code) {
		String id = new String(Base64.decodeBase64(code));
		if (StringUtil.isPositiveInteger(id)) {
			return String.valueOf(Long.valueOf(id) >> 2);
		}
		return "";
	}

	public static String getVidByUrl(String urlString) {
		if (urlString == null) {
			return "";
		}
		if (!urlString.toLowerCase().startsWith("http")) {
			return calVid(urlString);
		}
		if (urlString.toLowerCase().startsWith(IdeaUrlConstant.PLAYURL.TUDOU_PREFIX)) {
//			String vid = getTdVidByUrlCode(getTdUrlCode(urlString));
//			return vid == null ? "" : vid;
			return "";
		}
		Matcher m = regex_vid.matcher(urlString);
		if (m.find()) {
			String id = m.group(1);
			return calVid(id);
		}
		return "";
	}

	public static String getData(String idd, int pf) {
//106.11.186.41 vip 下线
		String yksUrl = "http://pre-yks.youku.com";
		if (!StringUtil.isEmptyString(idd)) {
			StringBuilder urlInfo = new StringBuilder(yksUrl).append("/yks/get.json?uip=127.0.0.1&vid=").append(idd)
					.append("&pt=video,error,stream&dv=pc&");
			try {
				if (pf == 1) {
					urlInfo.append("dv=pc");
				}
				if (pf == 2) {
					urlInfo.append("dv=mobile");
				}
				urlInfo.append("&uid=94210860&ct=50&ext={hasMp4:1}");
				return NetUtil.requestGet(urlInfo.toString(), 600000);
			} catch (Exception e) {
				// Ec.CENTER.log("yksService error: " + urlInfo.toString(), e);
			}
		}
		return null;
	}

	public static String getVideoJson(String ideaUrl) {
		String videoVid = getVidByUrl(ideaUrl);
		return getData(videoVid, 2);
	}

	// 调用人群dmpserver接口set
	// cookies:http://10.100.14.102:8081/set?key=1440501277285mTC&value=1022929&servicename=dmpservice
	public static void setDmpServer(String key, String value) {
		String dmpInterface = "http://10.100.14.102:8081/set?key=" + key + "&value=" + value
				+ "&servicename=testdmpservice";
		Util.requestGet(dmpInterface);
	}

	public static String load_ad() {
		return Util.requestGet("http://10.10.72.13/center/loader.jsp?load=All");
	}

	public static void screenShots() {
		try {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage screenshot = (new Robot())
					.createScreenCapture(new Rectangle(0, 0, (int) dimension.getWidth(), (int) dimension.getHeight()));
			File file = new File("/opt/ligang/screen.jpg");
			ImageIO.write(screenshot, "jpg", file);
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean updateHostName(String hostName, String ip) {
		if (StringUtils.isEmpty(hostName) || StringUtils.isEmpty(ip)) {
			try {
				throw new Exception("HostName or Ip can't be null.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (StringUtils.isEmpty(hostName.trim()) || StringUtils.isEmpty(ip.trim())) {
			try {
				throw new Exception("HostName or Ip can't be null.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String splitter = " ";
		String fileName = null;

		// 判断系统
		if ("linux".equalsIgnoreCase(System.getProperty("os.name"))) {
			fileName = "/etc/hosts";
		} else {
			fileName = "C://WINDOWS//system32//drivers//etc//hosts";
		}

		// 更新设定文件
		List<?> lines = null;
		try {
			lines = FileUtils.readLines(new File(fileName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> newLines = new ArrayList<String>();
		boolean findFlag = false;
		boolean updateFlag = false;
		for (Object line : lines) {
			String strLine = (String) line;
			if (StringUtils.isNotEmpty(strLine) && !strLine.startsWith("#")) {
				strLine = strLine.replaceAll("/t", splitter);
				int index = strLine.toLowerCase().indexOf(hostName.toLowerCase());
				if (index != -1) {
					String[] array = strLine.trim().split(splitter);
					for (String name : array) {
						if (hostName.equalsIgnoreCase(name)) {
							findFlag = true;
							if (array[0].equals(ip)) {
								// 如果IP相同，则不更新
								newLines.add(strLine);
								break;
							}
							// 更新成设定好的IP地址
							StringBuilder sb = new StringBuilder();
							sb.append(ip);
							for (int i = 1; i < array.length; i++) {
								sb.append(splitter).append(array[i]);
							}
							newLines.add(sb.toString());
							updateFlag = true;
							break;
						}
					}
					if (findFlag) {
						break;
					}
				}
			}
			newLines.add(strLine);
		}
		// 如果没有Host名，则追加
		if (!findFlag) {
			newLines.add(new StringBuilder(ip).append(splitter).append(hostName).toString());
		}
		if (updateFlag || !findFlag) {
			// 写设定文件
			try {
				FileUtils.writeLines(new File(fileName), newLines);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 确认设定结果
			String formatIp = formatIpv6IP(ip);
			for (int i = 0; i < 20; i++) {
				try {
					boolean breakFlg = false;
					InetAddress[] addressArr = InetAddress.getAllByName(hostName);
					for (InetAddress address : addressArr) {
						if (formatIp.equals(address.getHostAddress())) {
							breakFlg = true;
							break;
						}
					}
					if (breakFlg) {
						break;
					}
				} catch (Exception e) {
					// logger.warn(e.getMessage());
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return updateFlag;
	}

	// unzip
	@SuppressWarnings("unused")
	public static void unZip(String path) {
		int count = -1;
		String savepath = "";
		File file = null;
		InputStream is = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		savepath = path.substring(0, path.lastIndexOf(".")) + File.separator; // 保存解压文件目录
		// String savePath = this.getServletContext().getRealPath("/upload");
		new File(savepath).mkdirs(); // 创建保存目录
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(path, "gbk"); // 解决中文乱码问题
			Enumeration<?> entries = zipFile.getEntries();
			while (entries.hasMoreElements()) {
				byte buf[] = new byte[buffer];
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String filename = entry.getName();
				boolean ismkdir = false;
				if (filename.lastIndexOf("/") != -1) { // 检查此文件是否带有文件夹
					ismkdir = true;
				}
				filename = savepath + filename;
				if (entry.isDirectory()) { // 如果是文件夹先创建
					file = new File(filename);
					file.mkdirs();
					continue;
				}
				file = new File(filename);
				if (!file.exists()) { // 如果是目录先创建
					if (ismkdir) {
						new File(filename.substring(0, filename.lastIndexOf("/"))).mkdirs(); // 目录先创建
					}
				}
				file.createNewFile(); // 创建文件
				is = zipFile.getInputStream(entry);
				fos = new FileOutputStream(file);
				bos = new BufferedOutputStream(fos, buffer);
				while ((count = is.read(buf)) > -1) {
					bos.write(buf, 0, count);
				}
				bos.flush();
				bos.close();
				fos.close();
				is.close();
			}
			zipFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (is != null) {
					is.close();
				}
				if (zipFile != null) {
					zipFile.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static String formatIpv6IP(String ipV6Addr) {
		String strRet = ipV6Addr;
		StringBuffer replaceStr;
		int iCount = 0;
		char ch = ':';

		if (StringUtils.isNotEmpty(ipV6Addr) && ipV6Addr.indexOf("::") > -1) {
			for (int i = 0; i < ipV6Addr.length(); i++) {
				if (ch == ipV6Addr.charAt(i)) {
					iCount++;
				}
			}
			if (ipV6Addr.startsWith("::")) {
				replaceStr = new StringBuffer("0:0:");
				for (int i = iCount; i < 7; i++) {
					replaceStr.append("0:");
				}
			} else if (ipV6Addr.endsWith("::")) {
				replaceStr = new StringBuffer(":0:0");
				for (int i = iCount; i < 7; i++) {
					replaceStr.append(":0");
				}
			} else {
				replaceStr = new StringBuffer(":0:");
				for (int i = iCount; i < 7; i++) {
					replaceStr.append("0:");
				}
			}
			strRet = ipV6Addr.trim().replaceAll("::", replaceStr.toString());
		}

		return strRet;
	}

	private static int arraySearch(String[] array, String key) {
		for (int i = 0; i < array.length; i++) {
			if (key.equals(array[i]))
				return i;
		}
		return -1;
	}

	// 通过yks接口获取视频信息，如：size，width,height
	public static String getUrlInfo(String type, String ideaUrl) {

		// TODO Auto-generated method stub

		String[] dq = new String[] { "flv", "mp4", "hd2" };

		final String[][] tableStHd = {
				// dq hdyks hdtype nhd st
				// 清晰度 K服务接口 清晰度类型 清晰度数字 视频格式
				{ "flv", "mp4sd", "flv", "0", "mp4" }, { "mp4", "mp4hd", "mp4", "1", "mp4" },
				{ "hd2", "mp4hd2v2", "hd2", "2", "mp4" }, { "3gphd", "3gphd", "3gphd", "0", "mp4" },
				{ "m3u8", "mp4sd", "flv", "0", "m3u8" }, { "m3u8_mp4", "mp4hd", "mp4", "1", "m3u8" },
				{ "m3u8_hd2", "mp4hd2v2", "hd2", "2", "m3u8" }, { "m3u8_hd3", "mp4hd3v2", "hd3", "3", "m3u8" },

		};

		int pfMax = arraySearch(dq, "3gphd") >= 0 ? 2 : 1;

		for (int pf = 1; pf <= pfMax; pf++) { // 3gphd 要用 pf=2 来获取 其他的都用 pf=1
			String json = null;
			try {
				json = getData(getVidByUrl(ideaUrl), pf);
				// System.out.println(json);
				if (json == null || json.length() == 0) {
					continue;
				}

				JSONObject jobject = JSONObject.fromObject(json);

				if (!jobject.has("dataset") || jobject.getJSONObject("dataset").isNullObject()) {
					continue;
				}
				if (!jobject.getJSONObject("dataset").has("stream")) {
					continue;
				}

				if ("dimension".equals(type) || "size".equals(type)) {
					JSONArray streamArray = jobject.getJSONObject("dataset").getJSONArray("stream");
					if (streamArray.isEmpty()) {
						continue;
					}

					for (int i = 0; i < (pf == 2 ? 1 : dq.length); i++) {
						String u = null, st = null, hdstr = null, hdtype = null, hdnum = null, size = null,
								width = null, height = null;
						String dq1 = pf == 2 ? "3gphd" : dq[i];

						for (int j = 0; j < tableStHd.length; j++) {
							if (tableStHd[j][0].equals(dq1)) {
								hdstr = tableStHd[j][1];
								hdtype = tableStHd[j][2];
								hdnum = tableStHd[j][3];
								st = tableStHd[j][4];
								break;
							}
						}
						if (pf == 1 && dq[i].equals("3gphd")) {
							continue;
						}

						try {
							if (hdstr == null)
								// if(hdstr == null || !streamfileids.has(hdstr))
								continue;

							JSONObject streamObj = null;
							for (int m = 0; m < streamArray.size(); ++m) {
								if (streamArray.getJSONObject(m).has("stream_type")
										&& streamArray.getJSONObject(m).getString("stream_type").equals(hdstr)) {
									streamObj = streamArray.getJSONObject(m);
									break;
								}
							}

							if (streamObj == null) {
								continue;
							}

							if (st.equals("m3u8")) {

							} else {
								// String key =
								// streamObj.getJSONArray("segs").getJSONObject(0).getString("key");
								// String fileid =
								// streamObj.getJSONArray("segs").getJSONObject(0).getString("fileid");
								if ("size".equals(type)) {
									size = streamObj.getString("size");
									// System.out.println("size is : " + size);
									return size;
								}

								if ("dimension".equals(type)) {
									width = streamObj.getString("width");
									height = streamObj.getString("height");

									// System.out.println("width is : " + width);
									// System.out.println("height is : " + height);

									return width + "," + height;
								}

							}

						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				} else if ("showid".equals(type)) {
					System.out.println("+++++showid ++++");
					Object showid = jobject.getJSONObject("dataset").getJSONObject("cibnShow").get("showid");
//					JSONObject cibnShow = streamArray.getJSONObject("cibnShow");
//					Object showid = cibnShow.get("showid");
					// JSONArray streamArray = (JSONArray)
					// jobject.getJSONObject("dataset").get("cibnShow");
					System.out.println("showid is : " + showid);
//					JSONObject streamObj = null;
//					streamObj = streamArray.getJSONObject(0);
//					String showid=streamObj.getString("showid");
					return showid.toString();

				}

			} catch (JSONException e) {
				// Ec.ADS.log("getFlvUrls error: " + playurl + "\n" + json + "\n\n", e);
			}

		}
		return "unok param is wrong";
	}
	
	public String fileRead(String fileName) throws Exception {
        File file = new File(fileName);
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String s = "";
        while ((s =bReader.readLine()) != null) {
            sb.append(s + "\n");
            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        System.out.println(str );
        return str;
    }
	
	
	public void detailTableContent(String caseName,String caseDescription) throws Exception {
		//读取模板
		//String root = getServletContext().getRealPath("/");
		//String root = getServletContext().getRealPath("/");
		//Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
		
        // 第一种：获取类加载的根路径   D:\git\daotie\daotie\target\classes
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println("f is :##########" + f);

        // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录  D:\git\daotie\daotie\target\classes\my
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println("f2 is :#########" + f2);
		
		String ReportContent = fileRead("F:\\gary_geek\\ark-test\\easycast_2.0_new\\castInfo.template");
		File reportFile=new File("F:\\gary_geek\\ark-test\\easycast_2.0_new\\castInfo.jsp");
		//替换关键信息	
		ReportContent = ReportContent.replace("$CaseID", caseName);
		ReportContent = ReportContent.replace("$CaseName", caseName);
		ReportContent=ReportContent.replace("$Description", caseDescription);
		
		
		//重新写单个用例报告
		FileOutputStream fw=new FileOutputStream(reportFile, true);
		PrintWriter bw=new PrintWriter(fw);
		bw.write(ReportContent);	

		bw.close();
		fw.close();
		
	}

	public static void main(String[] args) throws Exception {
		// test video_group
		// int video_length =
		// EasyCastUtil.getVideoLength("http://v.youku.com/v_show/id_XNjA1MzgxNjY0.html");
		// int video_length =
		// EasyCastUtil.getVideoLength("http://v.youku.com/v_show/id_XNDI2MTg5MzM2.html");
		// System.out.println(EasyCastUtil.load_ad());
		// System.out.println(EasyCastUtil.setDmpServer("1440501277285mTC", "1022929"));
		// System.out.println(video_length+ "ok");
		// System.out.println(new Date(20170326132406L));
		// System.currentTimeMillis();
		// System.out.println("ok");
//		System.out.println(getUrlInfo("dimension", "http://v.youku.com/v_show/id_XMzU5MjMxMDY4NA==.html"));
//		System.out.println(getUrlInfo("showid", "http://v.youku.com/v_show/id_XMzU5MjMxMDY4NA==.html"));
		EasyCastUtil es = new EasyCastUtil();
		es.detailTableContent("Test_ark_move_rms222", "blablades222c");
	}
}
