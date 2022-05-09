package com.youku.atm.easycast;

import org.apache.jcs.utils.timing.SleepUtil;
import java.util.*;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Matcher;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.torque.util.Criteria;
import com.youku.atm.easycast.*;
import com.youku.atm.easycast.Base64.Decoder;
import com.youku.atm.easycast.Base64.Encoder;
import com.youku.atm.om.*;
import java.io.BufferedReader;
import java.security.MessageDigest;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;
import org.apache.torque.Torque;

import java.io.BufferedReader;
import java.security.MessageDigest;
import java.io.PrintWriter;
import java.io.StringWriter;
import com.youku.atm.busmodule.utils.LogUtil;

import org.apache.commons.logging.Log;
import java.text.ParseException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
//import com.youku.atm.easycast.TairOpt;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//import java.util.Base64.Decoder;
//import java.util.Base64.Encoder;

public class ActionTool extends AbstractAdServlet {
	private static final long serialVersionUID = 7381169134016556647L;
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final Log logger = LogUtil.getLog();
	// private static Jedis jedis;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tair_opt = request.getParameter("tair_opt");
		String tair_name = request.getParameter("tair_name");
		String tair_key = request.getParameter("tair_key");
		String tair_value = request.getParameter("tair_value");
		String cast_id = request.getParameter("cast_id");
		String cast_priority = request.getParameter("cast_priority");
		String idea_id = request.getParameter("idea_id");

		// 老adm系统delay
		String startDateRow = request.getParameter("startDateRow");
		String endDateRow = request.getParameter("endDateRow");
		String delay_idea_id = request.getParameter("delay_idea_id");

		// 新adm系统delay
		String startDateRow_new = request.getParameter("startDateRow_new");
		String endDateRow_new = request.getParameter("endDateRow_new");
		String delay_cast_id_new = request.getParameter("delay_cast_id_new");

		String idea_id_norevert = request.getParameter("idea_id_norevert");
		String idea_id_norevert_new = request.getParameter("idea_id_norevert_new");
		String idea_id_url = request.getParameter("idea_id_url");
		String original_idea_url = request.getParameter("original_idea_url");
		String update_idea_url = request.getParameter("update_idea_url");
		String idea_id_url_click = request.getParameter("idea_id_url_click");
		String update_idea_url_click = request.getParameter("update_idea_url_click");
		String update_idea_url_convert = covertUrl(update_idea_url_click.replace("\'", "''"));
		// is_resin_restart
		String is_resin_restart = request.getParameter("is_resin_restart");
		String is_resin_restart1 = request.getParameter("is_resin_restart1");
		String idea_url_encode = request.getParameter("idea_url_encode");
		String idea_url_decode = request.getParameter("idea_url_decode");
		String videoyksinfo_programmeid = request.getParameter("videoyksinfo_programmeid");
		String videoyksinfo = request.getParameter("videoyksinfo");
		String videogetflvurl = request.getParameter("videogetflvurl");
		@SuppressWarnings("unused")
		String base64_utf8_encode = request.getParameter("base64_utf8_encode");
		@SuppressWarnings("unused")
		String base64_utf8_decode = request.getParameter("base64_utf8_decode");
		String delayDate = "";
		String delayDateNew = "";
		try {
			delayDate = delayDate(startDateRow, endDateRow, delay_idea_id);
			delayDateNew = delayDateNew(startDateRow_new, endDateRow_new, delay_cast_id_new);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String update_date = update_date(cast_id, cast_priority, idea_id, idea_id_norevert);
		String update_date_new = update_date_new(idea_id_norevert_new);
		String updated_Idea_url = update_Idea_url_id(idea_id_url, original_idea_url, update_idea_url);
		String updated_Idea_url_click = update_Idea_url_id_click(idea_id_url_click, update_idea_url_convert);
		String urlencode = urlEncode(idea_url_encode);
		String urldecode = urlDecode(idea_url_decode);
		String StrjsonToBase64 = Base64encode(base64_utf8_encode);
		String Base64ToStrjson = Base64decode(base64_utf8_decode);

		String file_content_md5 = request.getParameter("file_content_md5");
		String fileContentMd5 = FileContentMd5(file_content_md5);

		// clickurltomess
		String clickurltomess = request.getParameter("clickurltomess");
		String click_url_to_mess = ClickurlToMess(clickurltomess);

		// clickmesstooriginal
		String clickmesstooriginal = request.getParameter("clickmesstooriginal");
		String clickmess_to_original = ClickMesstoOriginal(clickmesstooriginal);

		// url_vid
		String url_vid = request.getParameter("url_vid");
		String urlvid = UrlConvertToVid(url_vid);

		// if("1".equals(is_resin_restart)){
		// resinRestart();
		// }
		// if("2".equals(is_resin_restart1)){
		// resinRestart1();
		// }
		// is_load_ad

		// json = getData(getVidByUrl(ideaUrl), pf);
		String json = "";
		if(videoyksinfo != null && !"".equals(videoyksinfo)) {		
			json = EasyCastUtil.getData(EasyCastUtil.getVidByUrl(videoyksinfo), 2);
		}
		
		String outputVideoFlv = "";
		if(videogetflvurl != null && !"".equals(videogetflvurl)) {		
			
			Map<String, String> getFlvUrl = VideoUtil.getFileUrlByPlayUrl(videogetflvurl);
			
		      for (String key : getFlvUrl.keySet()) {  

		          System.out.println("key= "+ key + " and value= " + getFlvUrl.get(key));
		          
		          outputVideoFlv = outputVideoFlv + key + ":" + getFlvUrl.get(key) + "######  ";
		          
		         }
		}

		// 获取视频showid
		String showidInfo = "";
		if (videoyksinfo_programmeid != null && !"".equals(videoyksinfo_programmeid)) {
			showidInfo = "节目id(参数s):" + EasyCastUtil.getUrlInfo("showid", videoyksinfo_programmeid);
		}

		String is_load_ad = request.getParameter("is_load_ad");
		if ("1".equals(is_load_ad) && is_load_ad != null) {
			EasyCastUtil.load_ad();
		}

		String tairResult = "";


		// jedisInput();
		//jedisInputChannel();

		// tairOpt1(tair_opt, tair_name, tair_key, tair_value);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<a href='ad_tool.jsp'>返回</a>" + update_date + delayDate + "  " + delayDateNew + urlencode
				+ urldecode + StrjsonToBase64 + Base64ToStrjson + fileContentMd5 + urlvid + click_url_to_mess
				+ clickmess_to_original + tairResult + json + showidInfo + outputVideoFlv);
	}


	void jedisInput() {
		// Jedis jedis = new Jedis("11.239.171.222", 6379);
	    // jedis.set("singleJedis", "hello jedis!");
	    // System.out.println(jedis.get("singleJedis"));
	    // jedis.close();

	    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	    jedisPoolConfig.setMaxIdle(20);
	    jedisPoolConfig.setMaxTotal(40);
	    jedisPoolConfig.setMinIdle(10);

	    JedisPool pool = new JedisPool(jedisPoolConfig, "localhost", 6379, 1000, null);

	    Jedis jedis = null;
	    try {
	      jedis = pool.getResource();

	      // jedis.set("pooledJedis2", "hello jedis pool11111!");
	      // System.out.println(jedis.get("pooledJedis2"));

	      HashMap<String, String> map = new HashMap<>();
	      HashMap<String, String> map1 = new HashMap<>();
	      JSONObject jsonObject = new JSONObject();
	      JSONObject jsonObject1 = new JSONObject();
	      // JSONObject jsonObject2=new JSONObject();

	      // jsonObject2.put("jiangsu", "wuxi");
	      jsonObject.put("3058", "yingju");
	      jsonObject.put("3059", "美剧");

	      jsonObject.put("3060", "wuxiaju");
	      jsonObject.put("3061", "jingfeiju");

	      map.put("电视剧", jsonObject.toString());
	      jedis.hmset("d", map);

	      jsonObject1.put("3065", "大陆咨询");
	      jsonObject1.put("3066", "gangtaizixun");

	      jsonObject1.put("3067", "kejizixun");
	      jsonObject1.put("3068", "fazhizixun");

	      map1.put("资讯", jsonObject1.toString());
	      jedis.hmset("z", map1);

	      // List<String> list = jedis.hmget("d", "dianshiju");
	      Set<String> keys = jedis.keys("*");

	      Iterator<String> it = keys.iterator();
	      while (it.hasNext()) {
	        String str = it.next();
	        System.out.println("key is : " + str);
	        // System.out.println("####values is " + jedis.hget(str, "dianshiju"));
	        // String playlist = jedis.hget(str, "dianshiju");
	        // String[] playlistall = playlist.split(",");
	        // for(int i = 0 ;i<playlistall.length; i++) {
	        // System.out.println(playlistall[i]);
	        // }
	        System.out.println("####values_inner is " + jedis.hgetAll(str));
	      }

	      System.out.println("###########################");
	      System.out.println("###########################");

	      Iterator<String> it1 = keys.iterator();
	      while (it1.hasNext()) {
	        String str = it1.next();
	        // System.out.println("####values_inner is " + jedis.hgetAll(str));
	        Map<String, String> channel = jedis.hgetAll(str);
	        System.out.println("频道一级分类id: " + str);
	        // String channelfirstname = channel.keySet();

	        for (String channelfirstname : channel.keySet()) {
	          // System.out.println("key= " + key + " and value= " + map.get(key));
	          System.out.println("频道一级分类name： " + channelfirstname);

	          String secondchannelinfoall = channel.get(channelfirstname);
	          String fileter = secondchannelinfoall.substring(1,secondchannelinfoall.length()-1).replace("\"", "");
	          System.out.println("fileter is :" + fileter);
	          
	          String[] secondchannelinfospecific = fileter.split(",");
	          for (int i = 0; i < secondchannelinfospecific.length; i++) {
	            System.out.println("频道二级分类kv: " + secondchannelinfospecific[i]);
	            //todo
	          }
	        }

	      }

	      // System.out.println("listall is : " + list);
	      // System.out.println(keys);

	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      // 还回pool中
	      if (jedis != null) {
	        jedis.close();
	      }
	    }
	    pool.close();
	}

	void jedisInputChannel() {
		// redis初始化相关信息

		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(20);
		jedisPoolConfig.setMaxTotal(40);
		jedisPoolConfig.setMinIdle(10);
		JedisPool pool = new JedisPool(jedisPoolConfig, "localhost", 6379, 1000, null);
		Jedis jedis = null;
		jedis = pool.getResource();

		Channel channel = null;
		String channelId = null;
		String channleName = null;

		Channel second_Class = null;
		String secondChannelid = null;
		String secondChannelvalue = null;

		try {
			List<Channel> y_channelList = EasyCastUtil.getAllConfigChannels("ykn");
			for (int i = 0; i < y_channelList.size(); i++) {
				HashMap<String, String> map = new HashMap<>();
				JSONObject jsonObject = new JSONObject();
				channel = y_channelList.get(i);
				channelId = channel.getId();
				channleName = channel.getName();

				List<Channel> secondClass = EasyCastUtil.getAllConfigChannels(channel.getId());
				for (int ii = 0; ii < secondClass.size(); ii++) {
					second_Class = secondClass.get(ii);
					secondChannelid = second_Class.getId();
					secondChannelvalue = second_Class.getName();
					jsonObject.put(secondChannelid, secondChannelvalue);
				}

				map.put(channleName, jsonObject.toString());
				jedis.hmset(channelId, map);
			}
			Set<String> keys = jedis.keys("*");

			Iterator<String> it = keys.iterator();
			while (it.hasNext()) {
				String str = it.next();
				System.out.println("key is : " + str);
				System.out.println("####values_inner is " + jedis.hgetAll(str));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 还回pool中
			if (jedis != null) {
				jedis.close();
			}
		}
		pool.close();
	}

	String ClickurlToMess(String clickurltomess) {
		if (clickurltomess != null && !"".equals(clickurltomess)) {
			return "clickurltomess is : " + new ActionCast().covertUrl(clickurltomess);
		}
		return clickurltomess;
	}

	String ClickMesstoOriginal(String clickmesstooriginal) {
		if (clickmesstooriginal != null && !"".equals(clickmesstooriginal)) {
			return "clickmesstooriginal is : " + ActionCast.revertUrl(clickmesstooriginal);
		}
		return clickmesstooriginal;
	}

	String FileContentMd5(String file_content_md5) {

		try {
			if (file_content_md5 != null && !"".equals(file_content_md5)) {
				return "###ideaMd5 is : " + IdeaMd5Util.getUrlFileMd5(file_content_md5, "urlContentMd5", "/opt");
			}

		} catch (Exception ex) {
			return "exception";
		}
		return file_content_md5;
	}

	String UrlConvertToVid(String urlvid) {
		if (urlvid != null && !"".equals(urlvid)) {
			return "####vid is : " + new ActionCast().insertVideoGroup(urlvid);
		}
		return urlvid;
	}

	// void tairOpt1(String opt,String tairName,String key,String value){
	// jedis = RClientFactory.getJedis(tairName);
	// String ret = jedis.auth(tairName);
	// if (!ret.equals("ok")) {
	// System.out.println("ret " + ret);
	// System.out.println("tair init error!!!");
	// jedis.close();
	// System.exit(0);
	// }
	// jedis.setex("1", 3600, "2222");
	// jedis.close();
	// System.exit(0);
	// }
	String update_date(String cast_id, String cast_priority, String idea_id, String idea_id_norevert) {
		try {
			String root = getServletContext().getRealPath("/");
			Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
			String a;
			if (idea_id != null && !"".equals(idea_id)) {
				// int idea_id_int = Integer.parseInt(idea_id);
				DBConnection.getInstance("atm")
						.execSql("update idea_time set status = 0 where idea_id in ( " + idea_id + ")");
			}
			if (idea_id_norevert != null && !"".equals(idea_id_norevert)) {
				// int idea_id_int = Integer.parseInt(idea_id);
				DBConnection.getInstance("atm")
						.execSql("update ad_cast set status = 0 where id in (select cast_id from idea where id = "
								+ idea_id_norevert + ")");
			}
			if (cast_id != null && !"".equals(cast_id) && cast_priority != null && !"".equals(cast_priority)) {
				// int cast_id_int = Integer.parseInt(cast_id);
				// int cast_priority_int = Integer.parseInt(cast_priority);
				DBConnection.getInstance("atm").execSql(
						"update ad_cast set type_priority = " + cast_priority + " where id in (" + cast_id + ")");
			}
		} catch (Exception e) {
			System.out.println(e);
			logger.error(e.getStackTrace(), e);
			System.out.println("***************" + e.getStackTrace());
			logger.error(e.getStackTrace(), e);
		}
		return "##ok##";
	}

	String update_date_new(String idea_id_norevert_new) {
		try {
			String root = getServletContext().getRealPath("/");
			Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
			String a;
			if (idea_id_norevert_new != null && !"".equals(idea_id_norevert_new)) {
				// int idea_id_int = Integer.parseInt(idea_id);
				DBConnection.getInstance("atm")
						.execSql("update cast_idea set status = 0 where idea_id in ( " + idea_id_norevert_new + ")");
			}
		} catch (Exception e) {
			System.out.println(e);
			logger.error(e.getStackTrace(), e);
			System.out.println("***************" + e.getStackTrace());
			logger.error(e.getStackTrace(), e);
		}
		return "####ok##";
	}

	String update_Idea_url_id(String idea_id, String idea_old, String idea_url) {
		String update_url_sql = "";
		int showtime = 0;
		String update_showtime = "";
		if (idea_id != null && !"".equals(idea_id) && idea_url != null && !"".equals(idea_url)
				&& (idea_old == null || "".equals(idea_old))) {
			idea_url = idea_url.trim().replace("\'", "''");
			update_url_sql = "update idea_url set content = '" + idea_url + "' where idea_id = " + idea_id
					+ " and type = 1" + ";";
			DBConnection.getInstance("atm").execSql(update_url_sql);

		}

		if (idea_id != null && !"".equals(idea_id) && idea_url != null && !"".equals(idea_url) && idea_old != null
				&& !"".equals(idea_old)) {
			idea_url = idea_url.trim().replace("\'", "''");
			update_url_sql = "update idea_url set content = '" + idea_url + "' where idea_id = " + idea_id
					+ " and content = '" + idea_old.trim() + "';";
			DBConnection.getInstance("atm").execSql(update_url_sql);

		}

		if (idea_url != null && idea_url.endsWith(".html") && idea_url.contains("v.youku.com")) {
			// check showtime
			showtime = EasyCastUtil.getVideoLength(idea_url);
			update_showtime = "update idea set showtime = '" + showtime + "' where id = " + idea_id + ";";
			DBConnection.getInstance("atm").execSql(update_showtime);
		}

		return "##ok##";
	}

	String update_Idea_url_id_click(String idea_id_url_click, String update_idea_url_click) {
		String update_url_sql = "";
		if (idea_id_url_click != null && !"".equals(idea_id_url_click) && update_idea_url_click != null
				&& !"".equals(update_idea_url_click)) {
			// update_idea_url_click = update_idea_url_click.replace("\'","''");
			// covertUrl(update_idea_url_click);
			update_url_sql = "update idea_monitor set url = '" + update_idea_url_click + "' where idea_id = "
					+ idea_id_url_click + " and type = 1" + ";";
			DBConnection.getInstance("atm").execSql(update_url_sql);
		}
		return "##ok##";
	}

	public static String Base64ToStr(String s) {
		if (s == null)
			return null;

		//BASE64Decoder decoder = new BASE64Decoder();
		try {
			@SuppressWarnings("restriction")
			byte[] b = decryptBASE64(s);

			return new String(b, "UTF-8");

		} catch (Exception e) {
			return null;
		}
	}

	public static String StrToBase64(String s) {
		if (s == null)
			return null;
		//BASE64Encoder encoder = new BASE64Encoder();
		try {

			byte[] textByte = s.getBytes("UTF-8");
			@SuppressWarnings("restriction")
			String base64String = encryptBASE64(textByte);

			return base64String;

		} catch (Exception e) {
			return null;
		}
	}

	// utf+base64_encode
	String Base64encode(String base64_utf8_encode) {

		if (base64_utf8_encode != null && !"".equals(base64_utf8_encode)) {
			return StrToBase64(base64_utf8_encode);
		} else {
			return "##ok##";
		}
	}

	String Base64decode(String base64_utf8_decode) {
		if (base64_utf8_decode != null && !"".equals(base64_utf8_decode)) {
			return Base64ToStr(base64_utf8_decode);
		} else {
			return "##ok##";
		}
	}
	
	/**
     * BASE64Encoder 加密
     * 
     * @param data
     *            要加密的数据
     * @return 加密后的字符串
     */
    public static String encryptBASE64(byte[] data) {
        // BASE64Encoder encoder = new BASE64Encoder();
        // String encode = encoder.encode(data);
        // 从JKD 9开始rt.jar包已废除，从JDK 1.8开始使用java.util.Base64.Encoder
        Encoder encoder = Base64.getEncoder();
        String encode = encoder.encodeToString(data);
        return encode;
    }
    /**
     * BASE64Decoder 解密
     * 
     * @param data
     *            要解密的字符串
     * @return 解密后的byte[]
     * @throws Exception
     */
    public static byte[] decryptBASE64(String data) throws Exception {
        // BASE64Decoder decoder = new BASE64Decoder();
        // byte[] buffer = decoder.decodeBuffer(data);
        // 从JKD 9开始rt.jar包已废除，从JDK 1.8开始使用java.util.Base64.Decoder
        Decoder decoder = Base64.getDecoder();
        byte[] buffer = decoder.decode(data);
        return buffer;
    }

	// idea_monitor type=1或者type=10 才做替换(todo)-类型：1=点击地址/10自定义点击跳转地址
	String covertUrl(String url) {
		try {
			/*
			 * 老版本的替换规则，有冲突，改进 url=url.replaceAll("%", "!9999!"); url=url.replaceAll("&",
			 * "!url!"); url=url.replaceAll("#", "!35!"); url=url.replaceAll("=", "!61!");
			 * url=url.replaceAll("\\?", "!63!"); url=url.replaceAll("×", "!215!");
			 * url=url.replaceAll("\\+", "!20!");
			 */
			url = url.replaceAll("%", "percent_esc");
			url = url.replaceAll("&", "and_esc");
			url = url.replaceAll("#", "sharp_esc");
			url = url.replaceAll("=", "equal_esc");
			url = url.replaceAll("\\?", "interrogation_esc");
			url = url.replaceAll("\\+", "add_esc");
			url = url.replaceAll("\\$", "dollar_esc");
			return url;
			// return URLEncoder.encode(url,"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return url;
		}
	}

	String covertUrltoOposite(String url) {
		try {
			/*
			 * 老版本的替换规则，有冲突，改进 url=url.replaceAll("%", "!9999!"); url=url.replaceAll("&",
			 * "!url!"); url=url.replaceAll("#", "!35!"); url=url.replaceAll("=", "!61!");
			 * url=url.replaceAll("\\?", "!63!"); url=url.replaceAll("×", "!215!");
			 * url=url.replaceAll("\\+", "!20!");
			 */
			url = url.replaceAll("percent_esc", "%");
			url = url.replaceAll("and_esc", "&");
			url = url.replaceAll("sharp_esc", "#");
			url = url.replaceAll("equal_esc", "=");
			url = url.replaceAll("interrogation_esc", "\\?");
			url = url.replaceAll("add_esc", "\\+");
			url = url.replaceAll("dollar_esc", "\\$");
			return url;
			// return URLEncoder.encode(url,"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return url;
		}
	}

	String urlEncode(String url_encode) {
		try {
			if (url_encode != null && !"".equals(url_encode)) {
				return URLEncoder.encode(url_encode, "utf-8");
			} else {
				return "##ok##";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "##ok##";
	}

	String urlDecode(String url_decode) {
		try {
			if (url_decode != null && !"".equals(url_decode)) {
				return URLDecoder.decode(url_decode, "utf-8");
			} else {
				return "##ok##";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "##ok##";
	}

	@SuppressWarnings("unused")
	String delayDateNew(String startDate_date, String endDate_date, String delay_cast_id) throws Exception {

		String consoleOutput = "";

		if (startDate_date != null && !"".equals(startDate_date) && endDate_date != null && !"".equals(endDate_date)
				&& delay_cast_id != null && !"".equals(delay_cast_id)) {

			delay_cast_id = delay_cast_id.replace("，", ",").replace(" ", "").trim();

			String[] adCastDelays = delay_cast_id.split(",");

			for (int m = 0; m < adCastDelays.length; m++) {
				long day;
				Date temp;
				Date temp1;
				Date startDate = sdf.parse(startDate_date);
				Date endDate = sdf.parse(endDate_date);

				int delay_cast_id_int = Integer.parseInt(adCastDelays[m]);
				System.out.println("delay_cast_id_int:" + delay_cast_id_int);
				// check ad_cast.cast_way
				String sql1 = "select cast_way from ad_cast where id in(" + delay_cast_id_int + ");";
				System.out.println("sql1 is:" + sql1);
				ArrayList<?> al2 = DBConnection.getInstance("atm").execQuerySql7(sql1);
				System.out.println("al2 is:" + al2);
				if (al2.isEmpty()) {
					System.out.println("###########al2 is empty");
					consoleOutput = consoleOutput + adCastDelays[m] + "(该投放id) is not existed ;";
					System.out.println("#####" + "consoleOutput is: " + consoleOutput);
					continue;
				}
				String c = (al2.get(0).toString()).substring(1, al2.get(0).toString().length() - 1) + "";
				System.out.println("cast_way is: " + c);
				// check ad_cast.ad_type_id
				String sql11 = "select ad_type_id from ad_cast where id in(" + delay_cast_id_int + ");";
				System.out.println("sql11 is : " + sql11);
				ArrayList<?> al22 = DBConnection.getInstance("atm").execQuerySql6(sql11);
				if (al22.isEmpty()) {
					consoleOutput = consoleOutput + adCastDelays[m] + "(该投放id) is not existed ;";
					continue;
				}
				String cc = (al22.get(0).toString()).substring(1, al22.get(0).toString().length() - 1) + "";
				System.out.println("ad_cast.ad_type_id is : " + cc);

				if (c.contains("cpm") && !cc.contains("1100")) {
					day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
					temp = startDate;
					Calendar calendar;
					while (temp.compareTo(endDate) <= 0) {
						calendar = Calendar.getInstance();
						calendar.setTime(temp);
						try {
							Dc dc = new Dc();
							dc.setTargetDate(temp);
							// dc.setCpc(10);
							dc.setCpm(1000);
							dc.save();
						} catch (Exception e) {
							e.printStackTrace();
						}
						temp = EasyCastUtil.getTomorrow(temp);
					}
					// get dc_id
					String sql = "select id from dc order by id desc limit " + day + ";";
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
					int kk[] = new int[al1.size()];
					for (int iii = 0; iii < al1.size(); iii++) {
						String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
						int k = Integer.parseInt(aaa);
						kk[iii] = k;
					}
					// swap pos
					// int[] nums = { 1, 2, 3, 4, 5, 6 };
					for (int i = 0; i < kk.length / 2; i++) {
						int temp_2 = kk[i];
						kk[i] = kk[kk.length - i - 1];
						kk[kk.length - i - 1] = temp_2;
					}
					int j = 0;
					// String sql4 = "select cast_id from cast_cpm where cast_id in(" +
					// delay_cast_id_int + ") order by id desc limit 1;";
					// ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
					// String d1 = (al4.get(0).toString()).substring(1,
					// al4.get(0).toString().length() - 1) + "";
					// int i1 = Integer.parseInt(d1);
					day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
					temp1 = startDate;
					while (temp1.compareTo(endDate) <= 0) {
						calendar = Calendar.getInstance();
						calendar.setTime(temp1);
						try {
							CastCpm castcpm = new CastCpm();
							castcpm.setCastId(delay_cast_id_int);
							castcpm.setCpm(1000);
							castcpm.setCpc(1000);
							castcpm.setLun("NULL");
							castcpm.setCpv(1000);
							castcpm.setCpp(1000);
							castcpm.setPercent(0);
							castcpm.setDcId(kk[j]);
							castcpm.setDcId2(0);
							castcpm.setTargetDate(temp1);
							castcpm.save();
						} catch (Exception e) {
							e.printStackTrace();
						}
						temp1 = EasyCastUtil.getTomorrow(temp1);
					}

				} else if (c.contains("lun")) {
					System.out.println("New datedelay for lun:++++++++++");
					String sql2 = "select lun from cast_cpm where cast_id in(" + delay_cast_id_int
							+ ") order by id desc limit 1;";
					ArrayList al3 = DBConnection.getInstance("atm").execQuerySql7(sql2);
					String c2 = (al3.get(0).toString()).substring(1, al3.get(0).toString().length() - 1) + "";
					System.out.println("lun is: " + c2);
					// String sql4 = "select cast_id from cast_cpm where cast_id in(" +
					// delay_cast_id_int + ") order by id desc limit 1;";
					// ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
					// String d1 = (al4.get(0).toString()).substring(1,
					// al4.get(0).toString().length() - 1) + "";
					// int i1 = Integer.parseInt(d1);
					day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
					temp1 = startDate;
					Calendar calendar;
					while (temp1.compareTo(endDate) <= 0) {
						calendar = Calendar.getInstance();
						calendar.setTime(temp1);
						try {
							CastCpm castcpm = new CastCpm();
							castcpm.setCastId(delay_cast_id_int);
							castcpm.setCpm(0);
							castcpm.setCpc(0);
							castcpm.setLun(c2);
							castcpm.setPercent(0);
							castcpm.setDcId(0);
							castcpm.setDcId2(0);
							castcpm.setTargetDate(temp1);
							castcpm.save();
						} catch (Exception e) {
							e.printStackTrace();
						}
						temp1 = EasyCastUtil.getTomorrow(temp1);
					}

				} else if (c.contains("cpv")) {
					day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
					temp = startDate;
					Calendar calendar;
					while (temp.compareTo(endDate) <= 0) {
						calendar = Calendar.getInstance();
						calendar.setTime(temp);
						try {
							Dc dc = new Dc();
							dc.setTargetDate(temp);
							// dc.setCpc(10);
							dc.setCpv(1000);
							dc.save();
						} catch (Exception e) {
							e.printStackTrace();
						}
						temp = EasyCastUtil.getTomorrow(temp);
					}
					// get dc_id
					String sql = "select id from dc order by id desc limit " + day + ";";
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
					int kk[] = new int[al1.size()];
					for (int iii = 0; iii < al1.size(); iii++) {
						String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
						int k = Integer.parseInt(aaa);
						kk[iii] = k;
					}
					// swap pos
					// int[] nums = { 1, 2, 3, 4, 5, 6 };
					for (int i = 0; i < kk.length / 2; i++) {
						int temp_2 = kk[i];
						kk[i] = kk[kk.length - i - 1];
						kk[kk.length - i - 1] = temp_2;
					}
					int j = 0;
					// String sql4 = "select cast_id from cast_cpm where cast_id in(" +
					// delay_cast_id_int + ") order by id desc limit 1;";
					// ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
					// String d1 = (al4.get(0).toString()).substring(1,
					// al4.get(0).toString().length() - 1) + "";
					// int i1 = Integer.parseInt(d1);
					day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
					temp1 = startDate;
					while (temp1.compareTo(endDate) <= 0) {
						calendar = Calendar.getInstance();
						calendar.setTime(temp1);
						try {
							CastCpm castcpm = new CastCpm();
							castcpm.setCastId(delay_cast_id_int);
							castcpm.setCpm(1000);
							castcpm.setCpc(1000);
							castcpm.setLun("NULL");
							castcpm.setCpv(1000);
							castcpm.setCpp(1000);
							castcpm.setPercent(0);
							castcpm.setDcId(kk[j]);
							castcpm.setDcId2(0);
							castcpm.setTargetDate(temp1);
							castcpm.save();
						} catch (Exception e) {
							e.printStackTrace();
						}
						temp1 = EasyCastUtil.getTomorrow(temp1);
					}

				} else if (c.contains("time")) {
					System.out.println("time#######################################################");
					// String sql4 = "select cast_id from cast_cpm where cast_id in(" +
					// delay_cast_id_int + ") order by id desc limit 1;";
					// System.out.println("sql4:" + sql4 );
					// ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
					// String d1 = (al4.get(0).toString()).substring(1,
					// al4.get(0).toString().length() - 1) + "";
					// int i1 = Integer.parseInt(d1);
					day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
					temp1 = startDate;
					Calendar calendar;
					while (temp1.compareTo(endDate) <= 0) {
						calendar = Calendar.getInstance();
						calendar.setTime(temp1);
						try {
							CastCpm castcpm = new CastCpm();
							castcpm.setCastId(delay_cast_id_int);
							castcpm.setCpm(1000);
							castcpm.setCpc(1000);
							castcpm.setCpv(1000);
							castcpm.setCpp(1000);
							castcpm.setLun("NULL");
							castcpm.setPercent(0);
							castcpm.setDcId(0);
							castcpm.setDcId2(0);
							castcpm.setTargetDate(temp1);
							castcpm.save();
						} catch (Exception e) {
							e.printStackTrace();
						}
						temp1 = EasyCastUtil.getTomorrow(temp1);
					}
				}

				// return "##ok##";

			}
		}

		return consoleOutput + "##ok##";

	}

	String delayDate(String startDate_date, String endDate_date, String delay_idea_id) throws Exception {
		long day;
		Date temp;
		Date temp_1;
		Date temp_3;
		Date temp_4;
		Date temp_5;
		Date temp_6;
		Date temp_7;
		if (startDate_date != null && !"".equals(startDate_date) && endDate_date != null && !"".equals(endDate_date)
				&& delay_idea_id != null && !"".equals(delay_idea_id)) {
			Date startDate = sdf.parse(startDate_date);
			Date endDate = sdf.parse(endDate_date);
			int delay_idea_id_int = Integer.parseInt(delay_idea_id.trim());
			// check ad_cast.cast_way
			String sql1 = "select cast_way from ad_cast where id in(select cast_id from idea where id = "
					+ delay_idea_id_int + ");";
			ArrayList al2 = DBConnection.getInstance("atm").execQuerySql7(sql1);
			String c = (al2.get(0).toString()).substring(1, al2.get(0).toString().length() - 1) + "";
			System.out.println("cast_way is: " + c);
			// check ad_cast.ad_type_id
			String sql11 = "select ad_type_id from ad_cast where id in(select cast_id from idea where id = "
					+ delay_idea_id_int + ");";
			System.out.println("sql11 is : " + sql11);
			ArrayList al22 = DBConnection.getInstance("atm").execQuerySql6(sql11);
			String cc = (al22.get(0).toString()).substring(1, al22.get(0).toString().length() - 1) + "";
			System.out.println("ad_cast.ad_type_id is : " + cc);

			if (c.contains("cpm") && !cc.contains("1100")) {
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp = startDate;
				Calendar calendar;
				while (temp.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp);
					try {
						Dc dc = new Dc();
						dc.setTargetDate(temp);
						// dc.setCpc(10);
						dc.setCpm(1000);
						dc.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp = EasyCastUtil.getTomorrow(temp);
				}
				// get dc_id
				String sql = "select id from dc order by id desc limit " + day + ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
				int kk[] = new int[al1.size()];
				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
					int k = Integer.parseInt(aaa);
					kk[iii] = k;
				}
				// swap pos
				// int[] nums = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < kk.length / 2; i++) {
					int temp_2 = kk[i];
					kk[i] = kk[kk.length - i - 1];
					kk[kk.length - i - 1] = temp_2;
				}
				temp_1 = startDate;
				int j = 0;
				while (temp_1.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_1);
					// ++j;
					try {
						IdeaTime ideaTime = new IdeaTime();
						ideaTime.setIdeaId(delay_idea_id_int);
						ideaTime.setStatus(1);
						ideaTime.setStarttime(calendar.getTime());
						calendar.set(Calendar.HOUR, 23);
						calendar.set(Calendar.MINUTE, 59);
						calendar.set(Calendar.SECOND, 59);
						ideaTime.setEndtime(calendar.getTime());
						ideaTime.setDcId(kk[j]);
						ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					j++;
					temp_1 = EasyCastUtil.getTomorrow(temp_1);
				}

				String sql4 = "select cast_id from cast_cpm where cast_id in(select cast_id from idea where id = "
						+ delay_idea_id_int + ") order by id desc limit 1;";
				ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
				String d1 = (al4.get(0).toString()).substring(1, al4.get(0).toString().length() - 1) + "";
				int i1 = Integer.parseInt(d1);
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp_4 = startDate;
				while (temp_4.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_4);
					try {
						CastCpm castcpm = new CastCpm();
						castcpm.setCastId(i1);
						castcpm.setCpm(1000);
						castcpm.setCpc(1000);
						castcpm.setLun("NULL");
						castcpm.setCpv(1000);
						castcpm.setCpp(1000);
						castcpm.setPercent(0);
						castcpm.setTargetDate(temp_4);
						castcpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_4 = EasyCastUtil.getTomorrow(temp_4);
				}

				temp_6 = startDate;
				while (temp_6.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_6);
					// ++j;
					try {
						IdeaCpm ideaCpm = new IdeaCpm();
						ideaCpm.setIdeaId(delay_idea_id_int);
						ideaCpm.setCpm(1000);
						ideaCpm.setCpc(1000);
						ideaCpm.setCpv(1000);
						ideaCpm.setCpp(1000);
						ideaCpm.setRate(100);
						ideaCpm.setTargetDate(temp_6);
						ideaCpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_6 = EasyCastUtil.getTomorrow(temp_6);
				}

			} else if (c.contains("lun")) {
				String sql2 = "select lun from cast_cpm where cast_id in(select cast_id from idea where id = "
						+ delay_idea_id_int + ") order by id desc limit 1;";
				ArrayList al3 = DBConnection.getInstance("atm").execQuerySql7(sql2);
				String c2 = (al3.get(0).toString()).substring(1, al3.get(0).toString().length() - 1) + "";
				System.out.println("lun is: " + c2);
				String sql4 = "select cast_id from cast_cpm where cast_id in(select cast_id from idea where id = "
						+ delay_idea_id_int + ") order by id desc limit 1;";
				ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
				String d1 = (al4.get(0).toString()).substring(1, al4.get(0).toString().length() - 1) + "";
				int i1 = Integer.parseInt(d1);
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp_4 = startDate;
				Calendar calendar;
				while (temp_4.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_4);
					try {
						CastCpm castcpm = new CastCpm();
						castcpm.setCastId(i1);
						castcpm.setCpm(0);
						castcpm.setCpc(0);
						castcpm.setLun(c2);
						castcpm.setPercent(0);
						castcpm.setTargetDate(temp_4);
						castcpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_4 = EasyCastUtil.getTomorrow(temp_4);
				}
				temp_3 = startDate;
				while (temp_3.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_3);
					// ++j;
					try {
						IdeaTime ideaTime = new IdeaTime();
						ideaTime.setIdeaId(delay_idea_id_int);
						ideaTime.setStatus(1);
						ideaTime.setStarttime(calendar.getTime());
						calendar.set(Calendar.HOUR, 23);
						calendar.set(Calendar.MINUTE, 59);
						calendar.set(Calendar.SECOND, 59);
						ideaTime.setEndtime(calendar.getTime());
						ideaTime.setDcId(0);
						ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_3 = EasyCastUtil.getTomorrow(temp_3);
				}

				temp_6 = startDate;
				while (temp_6.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_6);
					// ++j;
					try {
						IdeaCpm ideaCpm = new IdeaCpm();
						ideaCpm.setIdeaId(delay_idea_id_int);
						ideaCpm.setCpm(0);
						ideaCpm.setCpc(0);
						ideaCpm.setCpv(0);
						ideaCpm.setRate(100);
						ideaCpm.setTargetDate(temp_6);
						ideaCpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_6 = EasyCastUtil.getTomorrow(temp_6);
				}
			} else if (c.contains("cpp")) {
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp = startDate;
				Calendar calendar;
				while (temp.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp);
					try {
						Dc dc = new Dc();
						dc.setTargetDate(temp);
						// dc.setCpc(10);
						dc.setCpp(1000);
						dc.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp = EasyCastUtil.getTomorrow(temp);
				}
				// get dc_id
				String sql = "select id from dc order by id desc limit " + day + ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
				int kk[] = new int[al1.size()];
				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
					int k = Integer.parseInt(aaa);
					kk[iii] = k;
				}
				// swap pos
				// int[] nums = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < kk.length / 2; i++) {
					int temp_2 = kk[i];
					kk[i] = kk[kk.length - i - 1];
					kk[kk.length - i - 1] = temp_2;
				}
				temp_1 = startDate;
				int j = 0;
				while (temp_1.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_1);
					// ++j;
					try {
						IdeaTime ideaTime = new IdeaTime();
						ideaTime.setIdeaId(delay_idea_id_int);
						ideaTime.setStatus(1);
						ideaTime.setStarttime(calendar.getTime());
						calendar.set(Calendar.HOUR, 23);
						calendar.set(Calendar.MINUTE, 59);
						calendar.set(Calendar.SECOND, 59);
						ideaTime.setEndtime(calendar.getTime());
						ideaTime.setDcId(kk[j]);
						ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					j++;
					temp_1 = EasyCastUtil.getTomorrow(temp_1);
				}
			} else if (c.contains("cpv")) {
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp = startDate;
				Calendar calendar;
				while (temp.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp);
					try {
						Dc dc = new Dc();
						dc.setTargetDate(temp);
						// dc.setCpc(10);
						dc.setCpv(1000);
						dc.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp = EasyCastUtil.getTomorrow(temp);
				}
				// get dc_id
				String sql = "select id from dc order by id desc limit " + day + ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
				int kk[] = new int[al1.size()];
				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
					int k = Integer.parseInt(aaa);
					kk[iii] = k;
				}
				// swap pos
				// int[] nums = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < kk.length / 2; i++) {
					int temp_2 = kk[i];
					kk[i] = kk[kk.length - i - 1];
					kk[kk.length - i - 1] = temp_2;
				}
				temp_1 = startDate;
				int j = 0;
				while (temp_1.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_1);
					// ++j;
					try {
						IdeaTime ideaTime = new IdeaTime();
						ideaTime.setIdeaId(delay_idea_id_int);
						ideaTime.setStatus(1);
						ideaTime.setStarttime(calendar.getTime());
						calendar.set(Calendar.HOUR, 23);
						calendar.set(Calendar.MINUTE, 59);
						calendar.set(Calendar.SECOND, 59);
						ideaTime.setEndtime(calendar.getTime());
						ideaTime.setDcId(kk[j]);
						ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					j++;
					temp_1 = EasyCastUtil.getTomorrow(temp_1);
				}
			} else if (c.contains("time")) {
				System.out.println("time#######################################################");
				String sql4 = "select cast_id from cast_cpm where cast_id in(select cast_id from idea where id = "
						+ delay_idea_id_int + ") order by id desc limit 1;";
				System.out.println("sql4:" + sql4);
				ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
				String d1 = (al4.get(0).toString()).substring(1, al4.get(0).toString().length() - 1) + "";
				int i1 = Integer.parseInt(d1);
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp_4 = startDate;
				Calendar calendar;
				while (temp_4.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_4);
					try {
						CastCpm castcpm = new CastCpm();
						castcpm.setCastId(i1);
						castcpm.setCpm(0);
						castcpm.setCpc(0);
						castcpm.setLun("NULL");
						castcpm.setPercent(0);
						castcpm.setTargetDate(temp_4);
						castcpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_4 = EasyCastUtil.getTomorrow(temp_4);
				}
				temp_3 = startDate;
				while (temp_3.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_3);
					// ++j;
					try {
						IdeaTime ideaTime = new IdeaTime();
						ideaTime.setIdeaId(delay_idea_id_int);
						ideaTime.setStatus(1);
						ideaTime.setStarttime(calendar.getTime());
						calendar.set(Calendar.HOUR, 23);
						calendar.set(Calendar.MINUTE, 59);
						calendar.set(Calendar.SECOND, 59);
						ideaTime.setEndtime(calendar.getTime());
						ideaTime.setDcId(0);
						ideaTime.setDcId2(0);
						ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_3 = EasyCastUtil.getTomorrow(temp_3);
				}

				temp_6 = startDate;
				while (temp_6.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_6);
					// ++j;
					try {
						IdeaCpm ideaCpm = new IdeaCpm();
						ideaCpm.setIdeaId(delay_idea_id_int);
						ideaCpm.setCpm(1000);
						ideaCpm.setCpc(1000);
						ideaCpm.setCpv(1000);
						ideaCpm.setRate(100);
						ideaCpm.setTargetDate(temp_6);
						ideaCpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_6 = EasyCastUtil.getTomorrow(temp_6);
				}
			}
			if (cc.contains("1100") && c.contains("cpm")) {
				System.out.println("cc is: " + cc);
				String sql5 = "select cast_id from idea where id = " + delay_idea_id_int + ";";
				ArrayList al5 = DBConnection.getInstance("atm").execQuerySql6(sql5);
				String d5 = (al5.get(0).toString()).substring(1, al5.get(0).toString().length() - 1) + "";
				int i5 = Integer.parseInt(d5);
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp_5 = startDate;
				Calendar calendar;
				while (temp_5.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_5);
					try {
						VhcastCpm vhcastcpm = new VhcastCpm();
						vhcastcpm.setCastId(i5);
						vhcastcpm.setCpm(1000);
						vhcastcpm.setCpc(0);
						vhcastcpm.setLun("");
						vhcastcpm.setPercent(0);
						vhcastcpm.setTargetDate(temp_5);
						vhcastcpm.save();
						Dc dc = new Dc();
						dc.setTargetDate(temp_5);
						// dc.setCpc(10);
						dc.setCpm(1000);
						dc.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_5 = EasyCastUtil.getTomorrow(temp_5);
				}
				temp_6 = startDate;
				while (temp_6.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_6);
					// ++j;
					try {
						VhideaCpm vhideaCpm = new VhideaCpm();
						vhideaCpm.setIdeaId(delay_idea_id_int);
						vhideaCpm.setCpm(1000);
						vhideaCpm.setCpc(0);
						vhideaCpm.setRate(0);
						vhideaCpm.setTargetDate(temp_6);
						vhideaCpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_6 = EasyCastUtil.getTomorrow(temp_6);
				}
				// get dc_id
				String sql = "select id from dc order by id desc limit " + day + ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
				int kk[] = new int[al1.size()];
				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
					int k = Integer.parseInt(aaa);
					kk[iii] = k;
				}
				// swap pos
				// int[] nums = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < kk.length / 2; i++) {
					int temp_2 = kk[i];
					kk[i] = kk[kk.length - i - 1];
					kk[kk.length - i - 1] = temp_2;
				}
				temp_7 = startDate;
				int j = 0;
				while (temp_7.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_7);
					// ++j;
					try {
						VhideaTime ideaTime = new VhideaTime();
						ideaTime.setIdeaId(delay_idea_id_int);
						ideaTime.setStatus(1);
						ideaTime.setStarttime(calendar.getTime());
						calendar.set(Calendar.HOUR, 23);
						calendar.set(Calendar.MINUTE, 59);
						calendar.set(Calendar.SECOND, 59);
						ideaTime.setEndtime(calendar.getTime());
						ideaTime.setDcId(kk[j]);
						ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					j++;
					temp_7 = EasyCastUtil.getTomorrow(temp_7);
				}
			}
		}
		return "###ok";
	}

	// 重启服务器
	// void resinRestart(){
	// try {
	// SSH ssh = new SSH("10.10.72.208", 22022, "root", "adtest208");
	// //ssh.execCommand("cd /;ls -l> out.txt");
	// //ssh.execCommand("cd /opt/ligang;mysql;source atm-schema_2014_06_12.sql");
	// //ssh.execCommand("mkdir ligangnew_new");
	// ssh.execCommand("service resin restart");
	// ssh.closeconn();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// void resinRestart1(){
	// try {
	// SSH ssh = new SSH("10.10.72.207", 22022, "root", "adtest207");
	// //ssh.execCommand("cd /;ls -l> out.txt");
	// //ssh.execCommand("cd /opt/ligang;mysql;source atm-schema_2014_06_12.sql");
	// //ssh.execCommand("mkdir ligangnew_new");
	// ssh.execCommand("service resin restart");
	// ssh.closeconn();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public static void main(String[] args) {
		// System.out.println("ok");
		//new ActionTool().jedisInput();
	}

}
