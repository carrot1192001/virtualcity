<%@page import="java.util.*"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.io.IOException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="org.apache.torque.util.Criteria"%>
<%@page import="com.youku.atm.easycast.*"%>
<%@page import="com.youku.atm.om.*"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="org.apache.torque.TorqueException"%>
<%@page import="org.apache.torque.util.Criteria"%>
<%@page import="org.apache.torque.Torque"%>
<%@page import="com.youku.atm.easycast.DBConnection"%>
<%@page import="com.tudou.itemcodecrypt.ItemCodeCrypt"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="com.youku.atm.busmodule.utils.LogUtil"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!final int NEW_ADSELECTOR = 169; //新ADSelector
	final int NEW_SPECIALAD = 168; //新通用播放页特效广告
	final int NEW_SHORTFULL = 167; //新短视频全屏
	final int NEW_ZANZHUBB = 166; //新赞助标版
	final int NEW_JIAOBIAO = 165; //新角标
	final int NEW_ZANTING = 164; //新暂停
	final int NEW_ZHONGCHA = 163; //新中插
	final int NEW_TIEPIAN = 162; //新贴片
	final int NEW_HOUTIE = 161; //新后贴
	final int NEW_QIANTIE = 160; //新前贴
	final int NEW_KAIJITU = 175; //新开机图
	final int IMPRESSION = 1; //互动贴片
	//移动
	final int MB_QIANTIE = 70; //移动前贴
	final int MB_HOUTIE = 71; //移动后贴
	final int MB_TIEPIAN = 72; //移动贴片
	final int MB_ZANTING = 73; //移动暂停
	final int MB_JIAOBIAO = 74; //移动角标
	final int MB_KAIJITU = 75; //移动开机图
	final int MB_QUANPING = 76; //移动全屏
	final int MB_ZHONGCHA = 80; //移动中插
	
	final int MB_WENZILIAN = 3; //mhtml(文字链)
	final int MB_APPSEARCHBANNER = 4; //mhtml(app搜索页banner)
	
	//vhtml
	final int yk_vhtml_banner = 1; //youku_视频播放页PIP全分类（淘宝专用）
	final int yk_vhtml_right_relative_banner = 2; //youku_右侧“相关视频”上banner （全分类）
	
	//cause "final int MB_WENZILIAN = 3; //mhtml(文字链)"占用，so,choose "16"
	final int yk_vhtml_banner1 = 16; //youku_播放页首屏banner1（全分类）
	
	//占用：final int MB_APPSEARCHBANNER = 4; //mhtml(app搜索页banner)
	final int yk_vhtml_righttop = 17; //youku_视频播放页右上PIP（UGC）
	final int yk_vhtml_comments = 5; //youku_评论框上通栏（普通播放页）-全分类
	final int yk_vhtml_RTB = 6; //youku_视频播放页－全分类底通（RTB专用）
	final int yk_vhtml_survey = 7; //youku_视频播放页-全频道 问卷调查
	final int yk_vhtml_mb_web = 8; //youku_移动web 播放页
	final int tudou_vhtml_banner1 = 9; //tudou_播放页首屏banner1
	final int tudou_vhtml_UGC_banner = 10; //tudou_UGC播放页banner (300*250)
	final int tudou_vhtml_righttop = 11; //tudou_视频播放页-（全分类）右侧二屏上banner
	final int tudou_vhtml_rightcenter = 12; //tudou_视频播放页-（全分类）右侧中 PIP
	final int tudou_vhtml_rightdown = 13; //tudou_视频播放页-（全分类）右侧下 PIP
	final int tudou_vhtml_commentDown = 14; //tudou_视频播放页-（全分类）评论上方通栏
	final int tudou_vhtml_survey = 15; //tudou_视频播放页-问卷调查	
	
	//推荐视频_promoted_video_ads
	final int promoted_video_ads_1429860427 = 18; //推荐视频_promoted_video_ads(1429860427)
	final int promoted_video_ads_1430199248 = 19; //推荐视频_promoted_video_ads(1429860427)
	
	//m播放页广告
	final int m_playing_youku_phone_web_1425020640 = 20; //youku_移动phone-web端_播放页banner
	final int m_playing_youku_ipad_web_1427883541 = 21; //youku_移动ipad-web端_播放页banner
	
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final Log logger = LogUtil.getLog();

	//	private static final Log logger = LogUtil.getLog();

	public String getMD5Str(String str) {
		str = "youkuatm" + str + "atm5!%^&*(#0";
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	
	public static boolean isNumeric(String str){ 
	     Pattern pattern = Pattern.compile("[0-9]*"); 
	     return pattern.matcher(str).matches();    
	}

	public String covertUrl(String url) {
		try {
			/*老版本的替换规则，有冲突，改进
			url=url.replaceAll("%", "!9999!");	
			url=url.replaceAll("&", "!url!");
			url=url.replaceAll("#", "!35!");
			url=url.replaceAll("=", "!61!");
			url=url.replaceAll("\\?", "!63!");
			url=url.replaceAll("×", "!215!");
			url=url.replaceAll("\\+", "!20!");
			 */
			url = url.replaceAll("%", "percent_esc");
			url = url.replaceAll("&", "and_esc");
			url = url.replaceAll("#", "sharp_esc");
			url = url.replaceAll("=", "equal_esc");
			url = url.replaceAll("\\?", "interrogation_esc");
			url = url.replaceAll("\\+", "add_esc");
			url = url.replaceAll("\\$", "dollar_esc");
			return url;
			//return URLEncoder.encode(url,"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return url;
		}
	}

	public boolean checkIdeaUrlFormat(String pc_vf_y_ideaurl) {

		if ((pc_vf_y_ideaurl != null && pc_vf_y_ideaurl.length() > 0
				&& pc_vf_y_ideaurl.indexOf("v.youku.com") > 0 && pc_vf_y_ideaurl
					.endsWith(".html"))) {
			return true;

		} else {
			//			logger.error(pc_vf_y_ideaurl + ":url is not valid");
			return false;
		}

	}

	String getAdTypeName(int ad_type) {
		switch (ad_type) {
		case NEW_QIANTIE:
			return "新前贴";
		case NEW_ZANTING:
			return "新暂停";
		case NEW_ZHONGCHA:
			return "新中插";
		case NEW_HOUTIE:
			return "新后贴";
		case NEW_SPECIALAD:
			return "新crazy";
		case NEW_ADSELECTOR:
			return "新Ad selector";
		case NEW_JIAOBIAO:
			return "新角标";
		case NEW_KAIJITU:
			return "新开机图";
		case NEW_SHORTFULL:
			return "新短视频全屏";
		case NEW_TIEPIAN:
			return "新贴片";
		case MB_QIANTIE:
			return "移动前贴";
		case MB_HOUTIE:
			return "移动后贴";
		case MB_ZANTING:
			return "移动暂停";
		case MB_JIAOBIAO:
			return "移动角标";
		case MB_KAIJITU:
			return "移动开机图";
		case MB_QUANPING:
			return "移动全屏";
		case MB_ZHONGCHA:
			return "移动中插";
		case MB_TIEPIAN:
			return "移动贴片";
		case MB_WENZILIAN:
			return "移动移动文字链";
			//MB_APPSEARCHBANNER
		case MB_APPSEARCHBANNER:
			return "移动app搜索页banner";	
		case yk_vhtml_banner:
			return "youku_视频播放页PIP全分类（淘宝专用）";
		case yk_vhtml_right_relative_banner:
			return "youku_右侧“相关视频”上banner （全分类）";	
		case yk_vhtml_banner1:
			return "youku_播放页首屏banner1（全分类）";		
		case yk_vhtml_righttop:
			return "youku_视频播放页右上PIP（UGC）";		
		case yk_vhtml_comments:
			return "youku_评论框上通栏（普通播放页）-全分类";	
		case yk_vhtml_RTB:
			return "youku_视频播放页－全分类底通（RTB专用）";	
		case yk_vhtml_survey:
			return "youku_视频播放页-全频道 问卷调查";	
		case yk_vhtml_mb_web:
			return "youku_移动web 播放页";	
		case tudou_vhtml_banner1:
			return "tudou_播放页首屏banner1";	
		case tudou_vhtml_UGC_banner:
			return "tudou_UGC播放页banner (300*250)";		
		case tudou_vhtml_righttop:
			return "tudou_视频播放页-（全分类）右侧二屏上banner";	
		case tudou_vhtml_rightcenter:
			return "tudou_视频播放页-（全分类）右侧中 PIP";	
		case tudou_vhtml_rightdown:
			return "tudou_视频播放页-（全分类）右侧下 PIP";		
		case tudou_vhtml_commentDown:
			return "tudou_视频播放页-（全分类）评论上方通栏";	
		case tudou_vhtml_survey:
			return "tudou_视频播放页-问卷调查";	
		case promoted_video_ads_1429860427:
			return "推荐视频_promoted_video_ads_1429860427";	
		case promoted_video_ads_1430199248:
			return "推荐视频_promoted_video_ads_1430199248";	
		case m_playing_youku_phone_web_1425020640:
			return "youku_移动phone-web端_播放页banner_1425020640";	
		case m_playing_youku_ipad_web_1427883541:
			return "youku_移动ipad-web端_播放页banner_1427883541";	
		default:
			return "未知";
		}
	}

	int getMaxSaleOrder() {
		Criteria c = new Criteria();
		//c.add(AdOrderPeer.ORDER_TYPE, AdOrder_C.ORDER_TYPE_SALE);
		c.add(AdOrderPeer.STATUS, 3);
		int[] type ={0,2};
		c.addIn(AdOrderPeer.TYPE, type);
	    
		//c.add(AdOrderPeer.LOCK_STATE, AdOrder_C.LOCK_STATE_LOCK);
		c.addDescendingOrderByColumn(AdOrderPeer.ID);

		try {
			List<AdOrder> orderList = AdOrderPeer.doSelect(c);
			return orderList.get(0).getId();
		} catch (TorqueException e) {
			e.printStackTrace();
		}

		return -1;
	}

	int insertCast(int ad_type, String start_date, String end_date,
			String all_area, String[] chk_area, String all_channel,
			String[] chk_channel, String[] v_position,String[] vo_position, String priority,String total_lun,String percent,
			String all_os, String pc_all_os,String[] chk_os,String[] chk_os_pc, String isVidLimit,
			String video_group_area1, String video_group_area2,
			String cast_type, String pc_vc_tiepian_pos,
			String is_show_campaign, String is_click_campaign,
			String is_over_campaign, int campaign_num_limit_show_int,
			String campaign_day_limit_show, String campaign_days_show, String campaign_days_click,String campaign_days_over,int campaign_num_limit_click_int,
			String campaign_day_limit_click, int campaign_num_limit_over_int,
			String campaign_day_limit_over, String is_skip_campaign,String campaign_days_skip,int campaign_num_limit_skip_int,
			String campaign_day_limit_skip, String campaignList_skip,String campaign_skip_name,String startDateRow_skip,String endDateRow_skip,
			String campaign_sequence_skip,
			String is_preload_campaign,String campaign_days_preload,int campaign_num_limit_preload_int,
			String campaign_day_limit_preload, String campaignList_preload,String campaign_preload_name,String startDateRow_preload,String endDateRow_preload,
			String campaign_sequence_preload,
			String is_show_priority,String product_reserve_method,
			int pc_vf_impression,int pc_vf_impression_pc, int pc_vob_impression_pc,int pc_vb_impression_pc,int pc_tp_impression_pc,int m_ztsdk, int m_sdk,
			String[] resolution_hd2,String[] resolution_mp4,String[] resolution_flv,
			String campaignList_show,String campaign_show_name,String startDateRow_show,String endDateRow_show,String campaign_sequence_show,
			String campaignList_click,String campaign_click_name,String startDateRow_click,String endDateRow_click,String campaign_sequence_click,
			String campaignList_over,String campaign_over_name,String startDateRow_over,String endDateRow_over,String campaign_sequence_over,String is_show_v_position,String is_show_vo_position,String isCast_bark,String parameter_values,String parameter_names,String isVidParameter) {

		//String name = ad_type + "_" + System.currentTimeMillis();

		try {
			//String root = getServletContext().getRealPath("/");
			//Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
			AdCast cast = new AdCast();

			ArrayList al10 = DBConnection.getInstance("atm").execQuerySql6(
					"select id from ad_order order by id desc limit 1");

			if (al10.size() == 0) {
				AdOrder adOrder = new AdOrder();
				adOrder.setId(1);
				adOrder.setName("teset_order1");

				adOrder.setCustomId(1);
				adOrder.setCustomName("test");

				adOrder.setType(0);
				adOrder.setStatus(3);
				adOrder.save();
			}

			int order_id = getMaxSaleOrder();
			String name = (order_id + 1) + "_" + ad_type + "_"
					+ System.currentTimeMillis();

			ArrayList al = DBConnection.getInstance("atm").execQuerySql6(
					"select id from ad_cast order by id desc limit 1");

			if (al.size() == 0) {
				cast.setId(1);
			} else {
				String a = (al.get(0).toString()).substring(1, al.get(0)
						.toString().length() - 1)
						+ "";

				int i = Integer.parseInt(a);
				cast.setId(i + 1);
			}

			cast.setOrderId(order_id);
			cast.setCustomerId(1);
			cast.setProductId(1);

			//cast.setName("test_easycast_2.0");
			cast.setName(name);

			if (ad_type == NEW_QIANTIE || ad_type == MB_QIANTIE
					|| ad_type == NEW_ZHONGCHA || ad_type == MB_ZHONGCHA
					|| ad_type == NEW_HOUTIE || ad_type == MB_HOUTIE || ad_type == NEW_TIEPIAN || ad_type == MB_TIEPIAN) {
				cast.setAdTypeId(162);
			}

			if (ad_type == NEW_JIAOBIAO || ad_type == MB_JIAOBIAO) {
				cast.setAdTypeId(165);
			}

			if (ad_type == NEW_ZANTING || ad_type == MB_ZANTING) {
				cast.setAdTypeId(164);
			}

			//MB_QUANPING
			if (ad_type == MB_QUANPING) {
				cast.setAdTypeId(76);
			}
			//MB_KAIJITU
			if (ad_type == NEW_KAIJITU || ad_type == MB_KAIJITU) {
				cast.setAdTypeId(75);
			}
			//NEW_SHORTFULL
			if (ad_type == NEW_SHORTFULL) {
				cast.setAdTypeId(167);
				//cast.setInteractEffect(2);
			}

			//NEW_SPECIALAD
			if (ad_type == NEW_SPECIALAD) {
				cast.setAdTypeId(168);
			}
			if(ad_type == NEW_ADSELECTOR){
				cast.setAdTypeId(169);
			}
			
			if(ad_type == MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER){
				cast.setAdTypeId(3);
			}
			
			//m播放页
			if(ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541 ){
				cast.setAdTypeId(1100);
			}

			if(ad_type == yk_vhtml_banner||ad_type == yk_vhtml_right_relative_banner||ad_type == yk_vhtml_banner1||ad_type == yk_vhtml_righttop||ad_type == yk_vhtml_comments||ad_type == yk_vhtml_RTB||ad_type == yk_vhtml_survey||
					ad_type == yk_vhtml_mb_web||ad_type == tudou_vhtml_banner1||ad_type == tudou_vhtml_UGC_banner||ad_type == tudou_vhtml_righttop||ad_type == tudou_vhtml_rightcenter||ad_type == tudou_vhtml_rightdown||
					ad_type == tudou_vhtml_commentDown||ad_type == tudou_vhtml_survey){
				cast.setAdTypeId(1100);
			}


			cast.setDirectWay("a*c");
			cast.setCastWay("cpm*camp");

			//ad_cast. interact_effect字段（交互效果：1.常规,2.全屏,3.互动,4.crazy,5.adselector"）
			cast.setInteractEffect(1);
			if (ad_type == NEW_SHORTFULL) {
				cast.setInteractEffect(2);
			}
			if (ad_type == NEW_SPECIALAD) {
				cast.setInteractEffect(4);
			}
			if (ad_type == NEW_ADSELECTOR) {
				cast.setInteractEffect(1);
			}
			
			if (ad_type == MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER||ad_type == m_playing_youku_phone_web_1425020640||ad_type ==m_playing_youku_ipad_web_1427883541) {
				cast.setCastWay("shua");
			}
			
			if (pc_vf_impression == 1) {
				cast.setInteractEffect(3);
			}
			//copyright_0无版权要求,1有版权要求" default="0"
			cast.setIsCopyright(0);
			cast.setPrice(1.0);
			cast.setSpeedType(0);
			//type_priority(0:非保量/1:保量)
			//select type_priority ,count(*) from ad_cast group by type_priority; 
			cast.setTypePriority(2);
			cast.setProductPriority(1);
			cast.setVipPriority(1);
			cast.setOrderPriority(1);
			cast.setCustomPriority(1);
			cast.setCustomNumPriority(1);
			cast.setCampPriority(1);
			cast.setAreaPriority(1);
			cast.setChannelPriority(1);
			cast.setPlatformPriority(1);
			cast.setUserPriority(1);
			cast.setKeywordPriority(1);
			cast.setVideogroupPriority(1);

			//定量优化
			//is_show_priority
			int product_reserve_method_cast = Integer.parseInt(product_reserve_method);
			if (product_reserve_method_cast == 2) {
				cast.setRoPriority(Integer.parseInt(priority));
				cast.setCastWay("pior*camp");
			} else {
				cast.setRoPriority(0);
			}
			
			if(product_reserve_method_cast == 4){
			    cast.setCastWay("lun*camp");
			}
			
			if(product_reserve_method_cast == 3){
			    cast.setCastWay("time");
			}
			
			if(product_reserve_method_cast == 5){
			    cast.setCastWay("percent*camp");
			}
			
			//preload
			if(product_reserve_method_cast == 8){
			    cast.setCastWay("cpp*camp");
			}
			//cpc
			if(product_reserve_method_cast == 6){
			    cast.setCastWay("cpc*camp");
			}
			
			//mhtml(文字链)
			if(product_reserve_method_cast == 9){
			    cast.setCastWay("shua");
			}
			
			//is_bark
			if(isCast_bark != null){
				cast.setIsBak(Integer.parseInt(isCast_bark));
			}
			
			if(m_ztsdk !=0){
				cast.setCastWay("fuflow");
			}
			if(m_sdk !=0){
				cast.setCastWay("fuflow");
			}

			cast.setSowType(0);
			cast.setRateM(0);
			cast.setRates(100);
			cast.setThreshold(1.0);
			cast.setRtbType(0);
			cast.setStartDate(sdf.parse(start_date + " 00:00:00"));
			cast.setEndDate(sdf.parse(end_date + " 23:59:59"));
			cast.setRtbid(0);
			
			cast.setIdeaShowType(0);
			if(m_ztsdk !=0){
				cast.setIdeaShowType(1);
			}
			if(m_sdk !=0){
				cast.setIdeaShowType(1);
			}
			cast.setMainCastId(1);
			cast.setStatus(1);
			
			//互动贴片loader素材
			if(pc_vf_impression_pc==1||pc_vob_impression_pc==1||pc_vb_impression_pc==1||pc_tp_impression_pc==1){
				cast.setInteractEffect(3);
			}
			
			//trueview
			if(((product_reserve_method_cast == 7&&((pc_vf_impression_pc==2)||(pc_vf_impression==2)))||(product_reserve_method_cast == 7&&((pc_vf_impression_pc==2)||(pc_vf_impression==2))))
					||((product_reserve_method_cast == 7&&pc_vob_impression_pc==2)||(product_reserve_method_cast == 7&&pc_vb_impression_pc==2))
					||((product_reserve_method_cast == 7&&pc_tp_impression_pc==2)||(product_reserve_method_cast == 1&&pc_vob_impression_pc==2))
					||((product_reserve_method_cast == 1&&pc_vb_impression_pc==2)||(product_reserve_method_cast == 1&&pc_tp_impression_pc==2))){
			    cast.setCastWay("cpv*camp");
			    cast.setInteractEffect(6);
				cast.setSpeedType(1);
			}
			
			cast.save();
			
			insertCastArea(all_area, cast.getId(), chk_area);
			if("1".equals(isVidLimit)){
				//do nothing
			}else{
				insertCastChannel(all_channel, cast.getId(), chk_channel);
			}
			
			insertCastPosition(cast.getId(), ad_type, pc_vc_tiepian_pos,
					v_position,vo_position,is_show_v_position,is_show_vo_position,video_group_area1);
			if(ad_type == MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER){
				insertHcastCpm(cast.getId(), cast.getStartDate(), cast.getEndDate(), product_reserve_method,total_lun,percent);
			}else{
				insertCastCpm(cast.getId(), cast.getStartDate(), cast.getEndDate(), product_reserve_method,total_lun,percent);
			}
			
            
			//insertCastDq
			insertCastDq(cast.getId(),resolution_hd2,resolution_mp4,resolution_flv);

			if (ad_type == NEW_QIANTIE || ad_type == NEW_ZHONGCHA
					|| ad_type == NEW_HOUTIE || ad_type == NEW_JIAOBIAO
					|| ad_type == NEW_ZANTING || ad_type == NEW_SPECIALAD
					|| ad_type == NEW_ADSELECTOR || ad_type ==NEW_SHORTFULL ||ad_type ==NEW_KAIJITU || ad_type ==NEW_TIEPIAN) {
				insertCastPlatform(ad_type,cast.getId(),pc_all_os,chk_os_pc);
			}
			if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU || ad_type ==MB_TIEPIAN || ad_type ==MB_WENZILIAN || ad_type ==MB_APPSEARCHBANNER) {
				insertCastSubOs(ad_type, cast.getId(), all_os, chk_os);
			}

			//campaign
			if ("1".equals(is_show_campaign)) {
				if((campaignList_show=="")||("".equals(campaignList_show))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
							"select id from campaign order by id desc limit 1");

					if (al1.size() == 0) {
						campaign.setId(1);
					} else {

						String d = (al1.get(0).toString()).substring(1, al1.get(0)
								.toString().length() - 1)
								+ "";

						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_show_name=="")||("".equals(campaign_show_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_"
    							+ ad_type + "_" + System.currentTimeMillis();
    					campaign.setName("("+(i1 + 1)+")"+campaign_name);
                    }else{
    					campaign.setName("("+(i1 + 1)+")"+campaign_show_name);
                    }
                    
                    //preload_camp
                    if((pc_vf_impression_pc==1&&product_reserve_method_cast==8)||(pc_vob_impression_pc==1&&product_reserve_method_cast==8)||(pc_vb_impression_pc==1&&product_reserve_method_cast==8)||(pc_tp_impression_pc==1&&product_reserve_method_cast==8)){
                    	campaign.setType(5);
                    }else{
    					campaign.setType(1);
                    }

					//set campaign period
					//startDateRow_show,endDateRow_show
					if(!"".equals(startDateRow_show)&&!"".equals(endDateRow_show)){
						campaign.setStartDate(sdf.parse(startDateRow_show + " 00:00:00"));
						campaign.setEndDate(sdf.parse(endDateRow_show + " 23:59:59"));
					}else{
						campaign.setStartDate(new Date());
						campaign.setEndDate(sdf.parse("2024-06-28 00:00:00"));
					}

					campaign.setNumlimit(campaign_num_limit_show_int);

					campaign.setDaylimit(campaign_days_show + ";" + campaign_day_limit_show);

					campaign.save();

					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					castCampaign.setCampaignId(campaign.getId());
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_show);
					castCampaign.save();
	
				}else{
					//campaignList_show
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_show.substring(campaignList_show.lastIndexOf("("),campaignList_show.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_show);
					castCampaign.save();
				}
				
			}

			if ("2".equals(is_click_campaign)) {
				if((campaignList_click=="")||("".equals(campaignList_click))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
							"select id from campaign order by id desc limit 1");

					if (al1.size() == 0) {
						campaign.setId(1);
					} else {

						String d = (al1.get(0).toString()).substring(1, al1.get(0)
								.toString().length() - 1)
								+ "";

						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_click_name=="")||("".equals(campaign_click_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_"
    							+ ad_type + "_" + System.currentTimeMillis();
    					campaign.setName("("+(i1 + 1)+")"+campaign_name);
                    }else{
    					campaign.setName("("+(i1 + 1)+")"+campaign_click_name);
                    }

					campaign.setType(2);
					//set campaign period
					//startDateRow_click,endDateRow_click
					if(!"".equals(startDateRow_click)&&!"".equals(endDateRow_click)){
						campaign.setStartDate(sdf.parse(startDateRow_click + " 00:00:00"));
						campaign.setEndDate(sdf.parse(endDateRow_click + " 23:59:59"));
					}else{
						campaign.setStartDate(new Date());
						campaign.setEndDate(sdf.parse("2024-06-28 00:00:00"));
					}

					campaign.setNumlimit(campaign_num_limit_click_int);

					campaign.setDaylimit(campaign_days_click + ";" + campaign_day_limit_click);

					campaign.save();

					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					castCampaign.setCampaignId(campaign.getId());
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_click);
					castCampaign.save();
	
				}else{
					//campaignList_click
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_click.substring(campaignList_click.lastIndexOf("("),campaignList_click.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_click);
					castCampaign.save();
				}
				
			}
			if ("3".equals(is_over_campaign)) {
				if((campaignList_over=="")||("".equals(campaignList_over))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
							"select id from campaign order by id desc limit 1");

					if (al1.size() == 0) {
						campaign.setId(1);
					} else {

						String d = (al1.get(0).toString()).substring(1, al1.get(0)
								.toString().length() - 1)
								+ "";

						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_over_name=="")||("".equals(campaign_over_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_"
    							+ ad_type + "_" + System.currentTimeMillis();
    					campaign.setName("("+(i1 + 1)+")"+campaign_name);
                    }else{
    					campaign.setName("("+(i1 + 1)+")"+campaign_over_name);
                    }

					campaign.setType(3);
					//set campaign period
					//startDateRow_over,endDateRow_over
					if(!"".equals(startDateRow_over)&&!"".equals(endDateRow_over)){
						campaign.setStartDate(sdf.parse(startDateRow_over + " 00:00:00"));
						campaign.setEndDate(sdf.parse(endDateRow_over + " 23:59:59"));
					}else{
						campaign.setStartDate(new Date());
						campaign.setEndDate(sdf.parse("2024-06-28 00:00:00"));
					}

					campaign.setNumlimit(campaign_num_limit_over_int);

					campaign.setDaylimit(campaign_days_over + ";" + campaign_day_limit_over);

					campaign.save();

					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					castCampaign.setCampaignId(campaign.getId());
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_over);
					castCampaign.save();
	
				}else{
					//campaignList_over
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_over.substring(campaignList_over.lastIndexOf("("),campaignList_over.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_over);
					castCampaign.save();
				}
				
			}
			
			if ("4".equals(is_skip_campaign)) {
				if((campaignList_skip=="")||("".equals(campaignList_skip))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
							"select id from campaign order by id desc limit 1");

					if (al1.size() == 0) {
						campaign.setId(1);
					} else {

						String d = (al1.get(0).toString()).substring(1, al1.get(0)
								.toString().length() - 1)
								+ "";

						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_skip_name=="")||("".equals(campaign_skip_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_"
    							+ ad_type + "_" + System.currentTimeMillis();
    					campaign.setName("("+(i1 + 1)+")"+campaign_name);
                    }else{
    					campaign.setName("("+(i1 + 1)+")"+campaign_skip_name);
                    }

					campaign.setType(4);
					//set campaign period
					//startDateRow_skip,endDateRow_skip
					if(!"".equals(startDateRow_skip)&&!"".equals(endDateRow_skip)){
						campaign.setStartDate(sdf.parse(startDateRow_skip + " 00:00:00"));
						campaign.setEndDate(sdf.parse(endDateRow_skip + " 23:59:59"));
					}else{
						campaign.setStartDate(new Date());
						campaign.setEndDate(sdf.parse("2024-06-28 00:00:00"));
					}

					campaign.setNumlimit(campaign_num_limit_skip_int);

					campaign.setDaylimit(campaign_days_skip + ";" + campaign_day_limit_skip);

					campaign.save();

					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					castCampaign.setCampaignId(campaign.getId());
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_skip);
					castCampaign.save();
	
				}else{
					//campaignList_skip
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_skip.substring(campaignList_skip.lastIndexOf("("),campaignList_skip.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_skip);
					castCampaign.save();
				}
				
			}
			
			if ("5".equals(is_preload_campaign)) {
				if((campaignList_preload=="")||("".equals(campaignList_preload))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
							"select id from campaign order by id desc limit 1");

					if (al1.size() == 0) {
						campaign.setId(1);
					} else {

						String d = (al1.get(0).toString()).substring(1, al1.get(0)
								.toString().length() - 1)
								+ "";

						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_preload_name=="")||("".equals(campaign_preload_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_"
    							+ ad_type + "_" + System.currentTimeMillis();
    					campaign.setName("("+(i1 + 1)+")"+campaign_name);
                    }else{
    					campaign.setName("("+(i1 + 1)+")"+campaign_preload_name);
                    }

					campaign.setType(5);
					//set campaign period
					//startDateRow_preload,endDateRow_preload
					if(!"".equals(startDateRow_preload)&&!"".equals(endDateRow_preload)){
						campaign.setStartDate(sdf.parse(startDateRow_preload + " 00:00:00"));
						campaign.setEndDate(sdf.parse(endDateRow_preload + " 23:59:59"));
					}else{
						campaign.setStartDate(new Date());
						campaign.setEndDate(sdf.parse("2024-06-28 00:00:00"));
					}

					campaign.setNumlimit(campaign_num_limit_preload_int);

					campaign.setDaylimit(campaign_days_preload + ";" + campaign_day_limit_preload);

					campaign.save();

					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					castCampaign.setCampaignId(campaign.getId());
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_preload);
					castCampaign.save();
	
				}else{
					//campaignList_preload
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_preload.substring(campaignList_preload.lastIndexOf("("),campaignList_preload.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//全程定向
					castCampaign.setCampaignNum(campaign_sequence_preload);
					castCampaign.save();
				}
				
			}
			

			if ("1".equals(isVidLimit)) {
				
				if (video_group_area1 != null && !"".equals(video_group_area1)) {
					
					String vid[] = video_group_area1.split("\r?\n");
				    //System.out.println("vid[0] is : " + vid[0] );
				    //System.out.println("vid[1] is : " + vid[1] );
					String video_id = insertVideoGroup(video_group_area1);
					String vids[] = video_id.split(" ");
					
                    for(int i = 0; i < vid.length ; i++){
        				VideoGroupList videoGroupList = new VideoGroupList();

    					String sql3 = "select id from video_group_list order by id desc limit 1;";
    					ArrayList al3 = DBConnection.getInstance("atm")
    							.execQuerySql6(sql3);

    					if (al3.size() == 0) {
    						videoGroupList.setId(1);
    					} else {
    						String e = (al3.get(0).toString()).substring(1, al3
    								.get(0).toString().length() - 1)
    								+ "";
    						int f = Integer.parseInt(e);
    						System.out.println("f is: " + f);
    						videoGroupList.setId(f + 1);
    					}
    					
    					if((isNumeric(vids[i])==true)&&(vids[i].length() == 6)){
    						videoGroupList.setType(3);
    					}else if((isNumeric(vids[i])==true)&&(vids[i].length() == 7)){
    						videoGroupList.setType(2);
    					}else if((isNumeric(vids[i])==true)&&((Integer.parseInt(vids[i]))<=42)){
    						videoGroupList.setType(7);
    					}else{
    						videoGroupList.setType(1);
    					}

    					videoGroupList.setValue(vids[i]);
    					
    					String sql5 = "select video_group_id from video_group_list order by video_group_id desc limit 1;";
    					ArrayList al5 = DBConnection.getInstance("atm")
    							.execQuerySql6(sql5);

    					if (al5.size() == 0) {
    						videoGroupList.setVideoGroupId(1);
    					} else {
    						String e1 = (al5.get(0).toString()).substring(1, al5
    								.get(0).toString().length() - 1)
    								+ "";
    						int f1 = Integer.parseInt(e1);
    						System.out.println("f1 is: " + f1);
    						videoGroupList.setVideoGroupId(f1 + 1);
    					}
    					
    					//videoGroupList.setVideoGroupId(Integer.parseInt(vids[i]));
    					videoGroupList.setStatus(1);
    					videoGroupList.save();
    					//insertVideoGroup(cast.getId(), video_group_area1);

    					CastVideogroup castVideoGroup = new CastVideogroup();
    					castVideoGroup.setCastId(cast.getId());
    					castVideoGroup.setDirectName("videogroup");
    					castVideoGroup.setDirectValue(videoGroupList
    							.getVideoGroupId());
    					castVideoGroup.setIsPositive(1);
    					castVideoGroup.save();
                    }
	

				}
				if (video_group_area2 != null && !"".equals(video_group_area2)) {
					
					String vid[] = video_group_area2.split("\r?\n");
				    //System.out.println("vid[0] is : " + vid[0] );
				    //System.out.println("vid[1] is : " + vid[1] );
					String video_id = insertVideoGroupTD(video_group_area2);
					System.out.println("video_id is :" + video_id);
					String vids[] = video_id.split(" ");
					
					for(int i = 0; i < vid.length ; i++){
						VideoGroupList videoGroupList1 = new VideoGroupList();

						String sql4 = "select id from video_group_list order by id desc limit 1;";
						ArrayList al4 = DBConnection.getInstance("atm")
								.execQuerySql6(sql4);

						if (al4.size() == 0) {
							videoGroupList1.setId(1);
						} else {
							String g = (al4.get(0).toString()).substring(1, al4
									.get(0).toString().length() - 1)
									+ "";
							int h = Integer.parseInt(g);
							System.out.println("h is: " + h);
							videoGroupList1.setId(h + 1);
						}
						
    					if((isNumeric(vids[i])==true)&&((vids[i].length() == 6)||(vids[i].length() == 5))){
    						videoGroupList1.setType(6);
    					}else if((isNumeric(vids[i])==true)&&(vids[i].length() == 7)){
    						videoGroupList1.setType(5);
    					}else{
    						videoGroupList1.setType(4);
    					}
						
						//video_id = insertVideoGroupTD(video_group_area2);
						videoGroupList1.setValue(vids[i]);
						
						String sql6 = "select video_group_id from video_group_list order by video_group_id desc limit 1;";
    					ArrayList al6 = DBConnection.getInstance("atm")
    							.execQuerySql6(sql6);

    					if (al6.size() == 0) {
    						videoGroupList1.setVideoGroupId(1);
    					} else {
    						String e2 = (al6.get(0).toString()).substring(1, al6
    								.get(0).toString().length() - 1)
    								+ "";
    						int f2 = Integer.parseInt(e2);
    						System.out.println("f2 is: " + f2);
    						videoGroupList1.setVideoGroupId(f2 + 1);
    					}
						
						//videoGroupList1.setVideoGroupId(Integer.parseInt(vids[i]));
						videoGroupList1.setStatus(1);
						videoGroupList1.save();
						//insertVideoGroup(cast.getId(), video_group_area1);

						CastVideogroup castVideoGroup1 = new CastVideogroup();
						castVideoGroup1.setCastId(cast.getId());
						castVideoGroup1.setDirectName("videogroup");
						castVideoGroup1.setDirectValue(videoGroupList1
								.getVideoGroupId());
						castVideoGroup1.setIsPositive(1);
						castVideoGroup1.save();
					}
					

				}

			}
			if("1".equals(isVidParameter)&&isVidParameter!=null){
				if("1".equals(parameter_names)){
					//insertCastPaid
					insertCastPaid(cast.getId(),parameter_values);
					insertProtectAd_Paid(cast.getId(),ad_type);
				}else if("2".equals(parameter_names)){
					insertCastPrd(cast.getId(),parameter_values);

						insertProtectAd_Tvb(cast.getId(),ad_type);

				}
			}
			
			return cast.getId();
		} catch (Exception e) {
			//System.out.println(e);
			//logger.error(e.getStackTrace(),e);
			//System.out.println("***************" + e.getStackTrace());
			logger.error(e.getStackTrace(), e);
		}

		return -1;
	}

	void insertCastArea(String all_area, int cast_id, String[] chk_area) {

		if (!"1".equals(all_area)) {
			for (String area_id : chk_area) {
				try {
					CastArea castArea = new CastArea();
					castArea.setCastId(cast_id);
					castArea.setDirectName("province");
					castArea.setDirectValue(area_id);
					castArea.setIsPositive(1);
					castArea.save();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			List<Area> areaList = EasyCastUtil.getAllConfigAreas("province");

			//			for (Area area : areaList) {
			try {
				CastArea castArea = new CastArea();
				castArea.setCastId(cast_id);
				//castArea.setDirectName(area.getLevel());
				//castArea.setDirectValue(area.getId());
				castArea.setDirectName("area");
				castArea.setDirectValue("86");
				castArea.setIsPositive(1);

				castArea.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//			}

		}

	}

	void insertCastChannel(String all_channel, int cast_id, String[] chk_channel) {
		if (!"1".equals(all_channel)) {

			if (chk_channel != null && !"".equals(chk_channel)) {

				for (String channel_id : chk_channel) {
					try {
						CastChannel castChannel = new CastChannel();
						castChannel.setCastId(cast_id);
						castChannel.setDirectName("channel");
						castChannel.setDirectValue(channel_id);
						//castChannel.setChannelId(channel_id);
						castChannel.setIsPositive(1);
						castChannel.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		} else {
			List<Channel> y_channelList = EasyCastUtil
					.getAllConfigChannels("ykn");
			List<Channel> t_channelList = EasyCastUtil
					.getAllConfigChannels("tdn");

			for (Channel channel : y_channelList) {
				try {
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue(channel.getId());
					castChannel.setIsPositive(1);
					castChannel.save();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (Channel channel : t_channelList) {
				try {
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue(channel.getId());
					castChannel.setIsPositive(1);
					castChannel.save();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	void insertCastPosition(int cast_id, int ad_type, String pc_vc_tiepian_pos,
			String[] v_position,String[] vo_position,String is_show_v_position,String is_show_vo_position,String video_group_area1) {
		try {
			if (ad_type == NEW_QIANTIE || ad_type == MB_QIANTIE) {
				if("1".equals(is_show_v_position)&&v_position!=null){
					for (String v_position_id : v_position) {
						CastPosition castPosition = new CastPosition();
						castPosition.setCastId(cast_id);
						castPosition.setDirectName("adposition");
						
						if(video_group_area1 != null && !"".equals(video_group_area1)){
							String video_id = insertVideoGroup(video_group_area1);
							String vids[] = video_id.split(" ");
							
							if((isNumeric(vids[0])==true)&&((Integer.parseInt(vids[0]))<=42)){
								castPosition
								.setDirectValue(7);
							}else{
								castPosition
								.setDirectValue(Integer.parseInt(v_position_id));
							}
						}else{
							castPosition
							.setDirectValue(Integer.parseInt(v_position_id));
						}

						castPosition.setMutex(0);
						castPosition.setIsPositive(1);
						castPosition.save();
					}
				}else{
					CastPosition castPosition1 = new CastPosition();
					castPosition1.setCastId(cast_id);
					castPosition1.setDirectName("adposition");

					//int outtime = Integer.parseInt(over_url_time);
					//castPosition1.setDirectValue(10001);
					if(video_group_area1 != null && !"".equals(video_group_area1)){
						String video_id = insertVideoGroup(video_group_area1);
						String vids[] = video_id.split(" ");
						
						if((isNumeric(vids[0])==true)&&((Integer.parseInt(vids[0]))<=42)){
							castPosition1
							.setDirectValue(7);
						}else{
							castPosition1
							.setDirectValue(10001);
						}
					}else{
						castPosition1
						.setDirectValue(10001);
					}

					castPosition1.setMutex(0);
					castPosition1.setIsPositive(1);
					castPosition1.save();
				}

			}

			if (ad_type == NEW_HOUTIE || ad_type == MB_HOUTIE) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue(5);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}
			
			if (ad_type == NEW_TIEPIAN || ad_type == MB_TIEPIAN) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue(0);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}

			if (ad_type == NEW_JIAOBIAO) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				//castPosition.setDirectValue(5);

				int pc_vc_tiepian_pos_int = Integer.parseInt(pc_vc_tiepian_pos);
				switch (pc_vc_tiepian_pos_int) {
				case 0: {
					//idea.setToppx("BOTTOM_LEFT");
					castPosition.setDirectValue(10);
					break;
				}
				case 1: {
					castPosition.setDirectValue(180);
					break;

				}
				case 5: {
					castPosition.setDirectValue(181);
					break;

				}
				case 20: {
					castPosition.setDirectValue(182);
					break;

				}
				default: {
					break;
				}
				}

				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}

			if (ad_type == MB_JIAOBIAO) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue(10);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}

			if (ad_type == NEW_ZHONGCHA || ad_type == MB_ZHONGCHA) {
				if("1".equals(is_show_vo_position)&&vo_position!=null){
					for (String vo_position_id : vo_position) {
						CastPosition castPosition = new CastPosition();
						castPosition.setCastId(cast_id);
						castPosition.setDirectName("adposition");
						castPosition
								.setDirectValue(Integer.parseInt(vo_position_id));

						castPosition.setMutex(0);
						castPosition.setIsPositive(1);
						castPosition.save();
					}
				}else{
					CastPosition castPosition1 = new CastPosition();
					castPosition1.setCastId(cast_id);
					castPosition1.setDirectName("adposition");
					castPosition1.setDirectValue(10002);
					castPosition1.setMutex(0);
					castPosition1.setIsPositive(1);
					castPosition1.save();
				}
			}

			if (ad_type == NEW_ZANTING || ad_type == MB_ZANTING) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");

				castPosition.setDirectValue(4);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}

			if (ad_type == MB_QUANPING) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");

				castPosition.setDirectValue(310);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}

			if (ad_type == MB_KAIJITU) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");

				castPosition.setDirectValue(300);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}
			
			if (ad_type == NEW_KAIJITU) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");

				castPosition.setDirectValue(300);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}

			if (ad_type == NEW_SHORTFULL) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");

				castPosition.setDirectValue(2);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}

			if (ad_type == NEW_SPECIALAD) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");

				castPosition.setDirectValue(2);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}
			//ad_type == NEW_ADSELECTOR
			if (ad_type == NEW_ADSELECTOR) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");

				castPosition.setDirectValue(2);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
			}
			
			//ad_type == MB_WENZILIAN
			if (ad_type == MB_WENZILIAN) {
				CastHposition castHposition = new CastHposition();
				castHposition.setCastId(cast_id);
				castHposition.setDirectName("hposition");

				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6(
						"select id from h_position where value = 1411701755;");

				if (al11.size() == 0) {
					ArrayList al12 = DBConnection.getInstance("atm").execQuerySql6(
							"select id from h_position order by id desc limit 1");
					String a = (al12.get(0).toString()).substring(1, al12.get(0)
							.toString().length() - 1)
							+ "";
					int i = Integer.parseInt(a);
					//idea.setId(i + 1);
					
					HPosition h_Position = new HPosition();
					h_Position.setId(i + 1);
					h_Position.setParentId(-1);
					h_Position.setName("youku_移动端搜索结果页文字广告");
					h_Position.setType(6);
					h_Position.setValue(1411701755);
					h_Position.setTemplet("");
					h_Position.setStatus(1);
					h_Position.save();
					
					castHposition.setDirectValue(i + 1);
					castHposition.setIsPositive(1);
					castHposition.save();
				}else{
					String a = (al11.get(0).toString()).substring(1, al11.get(0)
							.toString().length() - 1)
							+ "";
					int i = Integer.parseInt(a);
					castHposition.setDirectValue(i);

					castHposition.setIsPositive(1);
					castHposition.save();
				}
				
			}
			
			if(ad_type == MB_APPSEARCHBANNER){
				CastHposition castHposition = new CastHposition();
				castHposition.setCastId(cast_id);
				castHposition.setDirectName("hposition");
				
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6(
						"select id from h_position where value = 1428660682;");
				
				if (al11.size() == 0) {
					ArrayList al12 = DBConnection.getInstance("atm").execQuerySql6(
							"select id from h_position order by id desc limit 1");
					String a = (al12.get(0).toString()).substring(1, al12.get(0)
							.toString().length() - 1)
							+ "";
					int i = Integer.parseInt(a);
					//idea.setId(i + 1);
					
					HPosition h_Position = new HPosition();
					h_Position.setId(i + 1);
					h_Position.setParentId(-1);
					h_Position.setName("移动app搜索页banner位");
					h_Position.setType(6);
					h_Position.setValue(1428660682);
					h_Position.setTemplet("");
					h_Position.setStatus(1);
					h_Position.save();
					
					castHposition.setDirectValue(i + 1);
					castHposition.setIsPositive(1);
					castHposition.save();
				}else{
					String a = (al11.get(0).toString()).substring(1, al11.get(0)
							.toString().length() - 1)
							+ "";
					int i = Integer.parseInt(a);
					castHposition.setDirectValue(i);

					castHposition.setIsPositive(1);
					castHposition.save();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void insertCastCpm(int cast_id, Date startDate, Date endDate, String product_reserve_method,String total_lun,String percent) {

		Date temp = startDate;
		Calendar calendar;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);

			try {
				CastCpm castCpm = new CastCpm();
				castCpm.setCastId(cast_id);
				castCpm.setCpm(1000);
				castCpm.setCpc(1000);
				castCpm.setCpv(1000);
				castCpm.setCpp(1000);
				
				int product_reserve_method_castCpm = Integer.parseInt(product_reserve_method);
				if(product_reserve_method_castCpm == 4){
				   castCpm.setLun(total_lun + "/10");
				}
				//castCpm.setLun("5/10");
				castCpm.setPercent(0);
				if(product_reserve_method_castCpm == 5){
				   castCpm.setPercent(Integer.parseInt(percent));
				}
				castCpm.setTargetDate(temp);

				castCpm.save();
			} catch (Exception e) {
				e.printStackTrace();
			}

			temp = EasyCastUtil.getTomorrow(temp);
		}

	}
	
	void insertHcastCpm(int cast_id, Date startDate, Date endDate, String product_reserve_method,String total_lun,String percent) {

		Date temp = startDate;
		Calendar calendar;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);

			try {
				HcastCpm hcastCpm = new HcastCpm();
				hcastCpm.setCastId(cast_id);
				hcastCpm.setCpm(0);
				hcastCpm.setCpc(0);				
				hcastCpm.setLun("10");
				hcastCpm.setPercent(0);
				hcastCpm.setTargetDate(temp);

				hcastCpm.save();
			} catch (Exception e) {
				e.printStackTrace();
			}

			temp = EasyCastUtil.getTomorrow(temp);
		}

	}
	
	void insertCastDq(int cast_id,String[] resolution_hd2,String[] resolution_mp4,String[] resolution_flv){
		try{
			CastDq castDq = new CastDq();
			castDq.setCastId(cast_id);
			castDq.setDirectName("dq");
			String castDq_DirectValue_hd2;
			if(resolution_hd2 != null){
				castDq_DirectValue_hd2 = "1";
			}else{
				castDq_DirectValue_hd2 = "0";
			}
			String castDq_DirectValue_mp4;
			if(resolution_mp4 != null){
				castDq_DirectValue_mp4 = "1";
			}else{
				castDq_DirectValue_mp4 = "0";
			}
			String castDq_DirectValue_flv;
			if(resolution_flv != null){
				castDq_DirectValue_flv = "1";
			}else{
				castDq_DirectValue_flv = "0";
			}
			
			castDq.setDirectValue(castDq_DirectValue_hd2 + "," + castDq_DirectValue_mp4 + "," + castDq_DirectValue_flv);
			castDq.setIsPositive(1);
			castDq.save();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	void insertCastPlatform(int ad_type_id,int cast_id,String pc_all_os,String[] chk_os_pc) {
		String ad_type = getAdTypeName(ad_type_id);
		List<String> chk_os_pc_list = new ArrayList<String>();

		if ("1".equals(pc_all_os)) {//选了全平台
//			chk_os_pc_list.add("0_5_3_w");
//			chk_os_pc_list.add("0_5_3_a");
			for (String os_pc : chk_os_pc) {
				chk_os_pc_list.add(os_pc);
			}

		} else if (chk_os_pc != null) {
			for (String os_pc : chk_os_pc) {
				chk_os_pc_list.add(os_pc);
			}
		}

		if (!ad_type.startsWith("移动")) {
			for (String i : chk_os_pc_list) {
				try {
					CastPlatform castPlatform = new CastPlatform();
					castPlatform.setCastId(cast_id);
					castPlatform.setDirectName("subos");
					castPlatform.setDirectValue(i);
					castPlatform.setIsPositive(1);
					castPlatform.save();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	

	}

	void insertCastSubOs(int ad_type_id, int cast_id, String all_os,
			String[] chk_os) {
		String ad_type = getAdTypeName(ad_type_id);
		List<String> chk_os_list = new ArrayList<String>();

		if ("1".equals(all_os)) {//选了全平台
			chk_os_list.add("1_0_0_w");
			chk_os_list.add("1_0_0_a");
			chk_os_list.add("1_0_1_w");
			chk_os_list.add("1_0_1_a");
			chk_os_list.add("1_1_0_w");
			chk_os_list.add("1_1_0_a");
			chk_os_list.add("1_1_1_w");
			chk_os_list.add("1_1_1_a");
			chk_os_list.add("2_0_0_w");
			chk_os_list.add("2_0_0_a");
			chk_os_list.add("2_0_1_w");
			chk_os_list.add("2_0_1_a");
			chk_os_list.add("2_1_0_w");
			chk_os_list.add("2_1_0_a");
			chk_os_list.add("2_1_1_w");
			chk_os_list.add("2_1_1_a");
			chk_os_list.add("1_1_2_a");
			//chk_os_list.add("0_5_3_0");
		} else if (chk_os != null) {
			for (String os : chk_os) {
				chk_os_list.add(os);
			}
		}

		if (ad_type.startsWith("移动")) {
			for (String i : chk_os_list) {
				try {
					CastPlatform castPlatform = new CastPlatform();
					castPlatform.setCastId(cast_id);
					castPlatform.setDirectName("subos");
					castPlatform.setDirectValue(i);
					castPlatform.setIsPositive(1);
					castPlatform.save();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	void insertCastPaid(int cast_id,String parameter_values){
		try{
			if(parameter_values != null&&!"".equals(parameter_values)){
				CastPaid castPaid = new CastPaid();
				castPaid.setCastId(cast_id);
				castPaid.setDirectName("paid");
				castPaid.setDirectValue(parameter_values);
				castPaid.setIsPositive(1);
				castPaid.save();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	void insertCastPrd(int cast_id,String parameter_values){
		try{
			if(parameter_values != null&&!"".equals(parameter_values)){
				CastPrd castPrd = new CastPrd();
				castPrd.setCastId(cast_id);
				castPrd.setDirectName("prd");
				castPrd.setDirectValue(parameter_values);
				castPrd.setIsPositive(1);
				castPrd.save();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	void insertProtectAd_Tvb(int cast_id,int ad_type){
		try{
			if(ad_type==NEW_QIANTIE||ad_type==NEW_HOUTIE||ad_type==NEW_ZHONGCHA||ad_type==MB_QIANTIE||ad_type==MB_HOUTIE||ad_type==MB_ZHONGCHA||ad_type==NEW_TIEPIAN||ad_type==MB_TIEPIAN){
				ProtectAd protectAd = new ProtectAd();
				protectAd.setProtectId(7);
				protectAd.setType(5);
				protectAd.setValue(cast_id+"");
				protectAd.save();
			}else if(ad_type==NEW_ZANTING||ad_type==MB_ZANTING){
				ProtectAd protectAd = new ProtectAd();
				protectAd.setProtectId(8);
				protectAd.setType(5);
				protectAd.setValue(cast_id+"");
				protectAd.save();
			}else if(ad_type==NEW_JIAOBIAO||ad_type==MB_JIAOBIAO){
				ProtectAd protectAd = new ProtectAd();
				protectAd.setProtectId(9);
				protectAd.setType(5);
				protectAd.setValue(cast_id+"");
				protectAd.save();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	void insertProtectAd_Paid(int cast_id,int ad_type){
		try{
			if(ad_type==NEW_QIANTIE||ad_type==NEW_HOUTIE||ad_type==NEW_ZHONGCHA||ad_type==MB_QIANTIE||ad_type==MB_HOUTIE||ad_type==MB_ZHONGCHA||ad_type==NEW_TIEPIAN||ad_type==MB_TIEPIAN){

				
				//(root@localhost) [atm]> select * from protect where name like '%付费视频%贴片%';

				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//| id  | name                                     | manage_type | parent | priority | resource_id | color | starttime           | endtime             | status |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//|  14 | 优酷付费视频按分钟试看_贴片              | f,o,b       |     -1 |       30 |          99 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//|  11 | 优酷付费视频非试看_贴片                  | f,o,b       |     -1 |       30 |          96 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 104 | 土豆付费视频_贴片                        | f,o,b       |     -1 |       30 |         197 |     1 | 2014-12-26 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 113 | 优酷付费视频按集试看_贴片                | f,o,b       |     -1 |       30 |         207 |     1 | 2015-01-21 00:00:00 | 2020-12-31 23:59:59 |      1 |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				ProtectAd protectAd = new ProtectAd();
				protectAd.setProtectId(14);
				protectAd.setType(5);
				protectAd.setValue(cast_id+"");
				protectAd.save();
				
				ProtectAd protectAd1 = new ProtectAd();
				protectAd1.setProtectId(11);
				protectAd1.setType(5);
				protectAd1.setValue(cast_id+"");
				protectAd1.save();
				
				ProtectAd protectAd2 = new ProtectAd();
				protectAd2.setProtectId(104);
				protectAd2.setType(5);
				protectAd2.setValue(cast_id+"");
				protectAd2.save();
				
				ProtectAd protectAd3 = new ProtectAd();
				protectAd3.setProtectId(113);
				protectAd3.setType(5);
				protectAd3.setValue(cast_id+"");
				protectAd3.save();
				
			}else if(ad_type==NEW_ZANTING||ad_type==MB_ZANTING){
				//(root@localhost) [atm]> select * from protect where name like '%付费视频%暂停%';
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//| id  | name                                     | manage_type | parent | priority | resource_id | color | starttime           | endtime             | status |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//|  15 | 优酷付费视频按分钟试看_暂停              | p           |     -1 |       30 |         100 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//|  12 | 优酷付费视频非试看_暂停                  | p           |     -1 |       30 |          97 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 105 | 土豆付费视频_暂停                        | p           |     -1 |       30 |         198 |     1 | 2014-12-26 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 114 | 优酷付费视频按集试看_暂停                | p           |     -1 |       30 |         208 |     1 | 2015-01-21 00:00:00 | 2020-12-31 23:59:59 |      1 |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				ProtectAd protectAd = new ProtectAd();
				protectAd.setProtectId(15);
				protectAd.setType(5);
				protectAd.setValue(cast_id+"");
				protectAd.save();
				
				ProtectAd protectAd1 = new ProtectAd();
				protectAd1.setProtectId(12);
				protectAd1.setType(5);
				protectAd1.setValue(cast_id+"");
				protectAd1.save();
				
				ProtectAd protectAd2 = new ProtectAd();
				protectAd2.setProtectId(105);
				protectAd2.setType(5);
				protectAd2.setValue(cast_id+"");
				protectAd2.save();
				
				ProtectAd protectAd3 = new ProtectAd();
				protectAd3.setProtectId(114);
				protectAd3.setType(5);
				protectAd3.setValue(cast_id+"");
				protectAd3.save();
			}else if(ad_type==NEW_JIAOBIAO||ad_type==MB_JIAOBIAO){
				//(root@localhost) [atm]> select * from protect where name like '%付费视频%角标%';

				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//| id  | name                                     | manage_type | parent | priority | resource_id | color | starttime           | endtime             | status |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//|  16 | 优酷付费视频按分钟试看_角标              | c           |     -1 |       30 |         101 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//|  13 | 优酷付费视频非试看_角标                  | c           |     -1 |       30 |          98 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 106 | 土豆付费视频_角标                        | c           |     -1 |       30 |         199 |     1 | 2014-12-26 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 115 | 优酷付费视频按集试看_角标                | c           |     -1 |       30 |         209 |     1 | 2015-01-21 00:00:00 | 2020-12-31 23:59:59 |      1 |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				ProtectAd protectAd = new ProtectAd();
				protectAd.setProtectId(16);
				protectAd.setType(5);
				protectAd.setValue(cast_id+"");
				protectAd.save();
				
				ProtectAd protectAd1 = new ProtectAd();
				protectAd1.setProtectId(13);
				protectAd1.setType(5);
				protectAd1.setValue(cast_id+"");
				protectAd1.save();
				
				ProtectAd protectAd2 = new ProtectAd();
				protectAd2.setProtectId(106);
				protectAd2.setType(5);
				protectAd2.setValue(cast_id+"");
				protectAd2.save();
				
				ProtectAd protectAd3 = new ProtectAd();
				protectAd3.setProtectId(115);
				protectAd3.setType(5);
				protectAd3.setValue(cast_id+"");
				protectAd3.save();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	int insertIdea(int ad_type, int cast_id, int ad_type_id,
			String is_show_campaign, String campaign_period_times,
			String campaign_click_freq, String millwardbrown_ad_type,
			String youku_survey_url,
			String tudou_survey_url,String millwardbrown_ad_type_APP,
			String survey_show_url_app,
			String survey_entry_text_app,
			String survey_click_url_app, String click_url, String mb_click,
			String over_url, int outtime, String show_url, String click_kh_url,String playing_url,
			String iso_url, String mt_url, String iso_click_url,
			String iso_h5_url, int m_issdk, int m_sdk, int m_ztsdk,
			int m_qtsdk, String pc_vf_y_ideaurl, String pc_vf_pipurl,String loader_type,String loader_type_vob,String loader_type_vb,String loader_type_tp,
			int pc_vf_impression, int pc_vf_impression_pc,int pc_vob_impression_pc,int pc_vb_impression_pc,int pc_tp_impression_pc,String pc_vp_y_ideaurl,
			String pc_vp_y_full_ideaurl, String pc_vp_t_ideaurl,
			String pc_vp_t_full_ideaurl, String pc_vp_ideacontrol,
			String pc_vob_ideaurl, String pc_vob_pipurl,

			String pc_vb_ideaurl, String pc_crazy_y_js,
			String pc_crazy_t_ideaurl, String pc_selector_y_js,
			String pc_selector_t_ideaurl, String pc_shortfull_y_ideaurl,
			String pc_shortfull_t_ideaurl, String pc_vc_y_ideaurl,
			String pc_vc_y_rightpx2, String pc_vc_t_ideaurl,
			String pc_vc_t_rightpx2, String pc_vc_position,
			String pc_vc_showtime, String m_vf_ideaurl, String m_h5_vf_ideaurl_phone,String m_h5_vf_ideaurl_pad,
			String m_vb_ideaurl, String m_vp_ideaurl,
			String m_vc_openstatus_pageurl, String m_vc_closestatus_pageurl,
			String m_mi_ipad_ideaurl_768, String m_mi_ipad_ideaurl_1004,
			String m_mi_iphone_ideaurl_940, String m_mi_iphone_ideaurl_1116,
			String m_mi_iphone_ideaurl_1334, String m_mi_iphone_ideaurl_1920,
			String m_mi_apad_ideaurl_800, String m_mi_apad_ideaurl_600, String m_mi_apad_ideaurl_768,
			String m_mi_aphone_ideaurl_1280, String m_mi_aphone_ideaurl_800,
			String m_mi_atv_ideaurl_720,String m_iku_pc_ideaurl_650,String m_iku_pc_ideaurl_720, String m_mqp_ipad_ideaurl_748,
			String m_mqp_iphone_ideaurl_480,
			String m_mqp_androidpad_ideaurl_720,
			String m_mqp_androidphone_ideaurl_480, String m_quanping_showtime,
			String m_mo_ideaurl, String cast_type,
			String ration_optimize_level, String ration_optimize_period,
			String ration_optimize_numlimit, String is_show_priority,String product_reserve_method, String[] chk_os,String[] resolution_hd2,String[] resolution_mp4,String[] resolution_flv,
			String pc_tp_ideaurl,String m_vtp_ideaurl,String ies_monitor,
			String customtext_url,String clientcustomclick_url,String clientskip_url,String clientfee_url,String othercustomtextclick_url,String otherskip_url,String otherfeep_url,String custom_text,
			String pc_vf_loader_showtime,String pc_vob_loader_showtime,String pc_vb_loader_showtime,String pc_tp_loader_showtime,
			String pc_selector_youkutudou_length,String pc_crazy_youkutudou_length,String pc_shortfull_youkutudou_length,String pc_shortfull_youkutudou_width,String pc_shortfull_youkutudou_height,
			String pc_vc_width,String pc_vc_height,String pc_vc_close_method,String chargingthreshold_text,String m_mhtml_text_content,String m_mhtml_clickurl,
			String app_search_banner_type,String app_search_banner_youkupip_url,String app_search_banner_youkupip_clickurl,String app_search_banner_youkupip_showurl,String app_search_banner_tudoupip_url,String app_search_banner_tudoupip_clickurl,String app_search_banner_tudoupip_showurl) {

		String name = cast_id + "_" + ad_type_id + "_"
				+ System.currentTimeMillis();
		try {
			//atm2.0_easycast
			AdCast cast = AdCastPeer.retrieveByPK(cast_id);
			Idea idea = new Idea();
			ArrayList al = DBConnection.getInstance("atm").execQuerySql6(
					"select id from idea order by id desc limit 1");
			if (al.size() == 0) {
				idea.setId(1);
			} else {
				String a = (al.get(0).toString()).substring(1, al.get(0)
						.toString().length() - 1)
						+ "";
				int i = Integer.parseInt(a);
				idea.setId(i + 1);
			}

			idea.setCastId(cast_id);
			idea.setName(name);
			idea.setShowtime(15);
			idea.setIPriority(1);
			idea.setCount(0);
			idea.setNumlimit(1000);
			//idea.setDq("1");
//			if(usehd == 0){
//				idea.setDq("1,1,1");
//			}
//			if(usehd == 2){
//				idea.setDq("3,3,1");
//			}
//			if(usehd == 1){
//				idea.setDq("7,3,1");
//			}
            insertIdeaDq(idea,resolution_hd2,resolution_mp4,resolution_flv);
            
            if("2".equals(ies_monitor)){
            	idea.setIesorg("admaster.com");
            }else{
            	idea.setIesorg("");
            }
            
			idea.setCuf(Integer.parseInt(mb_click));
			//idea.setCuf(0);
			
			idea.setControltype(1);

			//TODO issdk
			if (ad_type_id == MB_QIANTIE || ad_type_id == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type_id == MB_ZANTING
					|| ad_type_id == MB_JIAOBIAO || ad_type_id == MB_KAIJITU
					|| ad_type_id == MB_QUANPING || ad_type== MB_TIEPIAN) {

				idea.setIssdk(m_issdk);
			}

			//自主投放。idea.sdkid
			idea.setSdkid(0);
			if(ad_type_id == MB_ZANTING){
				idea.setSdkid(m_ztsdk);
			}
			if(ad_type_id == MB_QUANPING){
				idea.setSdkid(m_sdk);
			}
			
			if(ad_type_id == MB_APPSEARCHBANNER&&app_search_banner_type.equals("2")){
				idea.setSdkid(10);
			}

			idea.setStatus(1);

			//pc qiantie
			if (ad_type == NEW_QIANTIE) {
				idea.setShowtime(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl));
				if(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl)==0){
					if(pc_vf_impression_pc==1&&!"".equals(pc_vf_loader_showtime)){
						idea.setShowtime(Integer.parseInt(pc_vf_loader_showtime));
					}else{
						idea.setShowtime(15);
					}				
				}
			}
			
			//PC_TIEPIAN
			if (ad_type == NEW_TIEPIAN) {
				idea.setShowtime(EasyCastUtil.getVideoLength(pc_tp_ideaurl));
				if(EasyCastUtil.getVideoLength(pc_tp_ideaurl)==0){
					if(pc_tp_impression_pc==1&&!"".equals(pc_tp_loader_showtime)){
						idea.setShowtime(Integer.parseInt(pc_tp_loader_showtime));
					}else{
						idea.setShowtime(15);
					}
					
				}
			}
			
			//MB_TIEPIAN
			if (ad_type == MB_TIEPIAN) {
				idea.setShowtime(EasyCastUtil.getVideoLength(m_vtp_ideaurl));
				if(EasyCastUtil.getVideoLength(m_vtp_ideaurl)==0){
					idea.setShowtime(15);
				}
			}

			//MB qiantie
			if (ad_type == MB_QIANTIE) {
				idea.setShowtime(EasyCastUtil.getVideoLength(m_vf_ideaurl));
			}

			if (ad_type == NEW_HOUTIE) {
				idea.setShowtime(EasyCastUtil.getVideoLength(pc_vb_ideaurl));
				if(EasyCastUtil.getVideoLength(pc_vb_ideaurl)==0){
					if(pc_vb_impression_pc==1&&!"".equals(pc_vb_loader_showtime)){
						idea.setShowtime(Integer.parseInt(pc_vb_loader_showtime));
					}else{
						idea.setShowtime(15);
					}				
				}
				
			}

			if (ad_type == MB_HOUTIE) {
				idea.setShowtime(EasyCastUtil.getVideoLength(m_vb_ideaurl));
			}

			if (ad_type == NEW_ZHONGCHA) {
				idea.setShowtime(EasyCastUtil.getVideoLength(pc_vob_ideaurl));
				System.out.println("pc_vob_ideaurl: " + EasyCastUtil.getVideoLength(pc_vob_ideaurl));
				if(EasyCastUtil.getVideoLength(pc_vob_ideaurl)==0){
					
					if(pc_vob_impression_pc==1&&!"".equals(pc_vob_loader_showtime)){
						idea.setShowtime(Integer.parseInt(pc_vob_loader_showtime));
					}else{
						idea.setShowtime(15);
					}				
				}
			}

			if (ad_type == MB_ZHONGCHA) {
				idea.setShowtime(EasyCastUtil.getVideoLength(m_mo_ideaurl));
			}

			if (ad_type == NEW_JIAOBIAO) {
				//int outtime = Integer.parseInt(over_url_time);
				//pc_vc_y_rightpx2
				idea.setControltype(Integer.parseInt(pc_vc_y_rightpx2));
			}

			if (ad_type == NEW_JIAOBIAO) {

				if (pc_vc_showtime != null && !"".equals(pc_vc_showtime)) {
					idea.setShowtime(Integer.parseInt(pc_vc_showtime));
					idea.setCloseMethod(Integer.parseInt(pc_vc_close_method));
				} else {
					idea.setShowtime(0);
				}

				int pc_vc_position_int = Integer.parseInt(pc_vc_position);
				switch (pc_vc_position_int) {
				case 0: {
					idea.setLocationType("BOTTOM_LEFT");
					break;
				}
				case 1: {
					idea.setLocationType("BOTTOM_RIGHT");
					break;

				}
				case 2: {
					idea.setLocationType("BOTTOM_CENTER");
					break;

				}
				case 3: {
					idea.setLocationType("TOP_LEFT");
					break;

				}
				case 4: {
					idea.setLocationType("TOP_RIGHT");
					break;

				}
				case 5: {
					idea.setLocationType("TOP_CENTER");
					break;

				}
				default: {
					break;
				}
				}
			}

			if (ad_type == NEW_ZANTING) {
				idea.setShowtime(0);
				idea.setControltype(Integer.parseInt(pc_vp_ideacontrol));
			}

			if (ad_type == MB_ZANTING) {
				idea.setShowtime(0);

			}

			if (ad_type == MB_QUANPING) {

				idea.setShowtime(Integer.parseInt(m_quanping_showtime));
			}

			if (ad_type == NEW_SHORTFULL) {

				idea.setShowtime(5);
			}
			
			if (ad_type == MB_KAIJITU) {

				idea.setShowtime(5);
			}
			
			if (ad_type == MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER) {

				idea.setShowtime(0);
			}
			
			//trueview(charge_time)
			//素材模板idea表增加计费时长字段，保存素材时对该字段赋值；如产品定义中计费时长阈值为15秒，则当素材真实时长>=15秒时，赋值为15秒，如素材真实时长<15秒，赋值为真实时长；
			//todo
			if(pc_vf_impression_pc==2||pc_vob_impression_pc==2||pc_vb_impression_pc==2||pc_tp_impression_pc==2){
				if(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl)>=Integer.parseInt(chargingthreshold_text)){
					idea.setChargeTime(Integer.parseInt(chargingthreshold_text));
				}else{
					idea.setChargeTime(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl));
				}
				//idea.setChargeTime(15);
			}
			
			if(ad_type == NEW_ADSELECTOR){
				//idea.setShowtime(EasyCastUtil.getVideoLength(pc_selector_y_js));
				if(EasyCastUtil.getVideoLength(pc_selector_y_js)==0||EasyCastUtil.getVideoLength(pc_selector_t_ideaurl)==0){
					if(!"".equals(pc_selector_youkutudou_length)){
						idea.setShowtime(Integer.parseInt(pc_selector_youkutudou_length));
					}else{
						idea.setShowtime(15);
					}					
				}
			}
			
			if(ad_type == NEW_SPECIALAD){
				//idea.setShowtime(EasyCastUtil.getVideoLength(pc_selector_y_js));
				if(EasyCastUtil.getVideoLength(pc_crazy_y_js)==0||EasyCastUtil.getVideoLength(pc_crazy_t_ideaurl)==0){
					if(!"".equals(pc_crazy_youkutudou_length)){
						System.out.println("pc_crazy_youkutudou_length is:"+pc_crazy_youkutudou_length+"end");
						idea.setShowtime(Integer.parseInt(pc_crazy_youkutudou_length));
					}else{
						idea.setShowtime(15);
					}					
				}
			}
			
			if(ad_type == NEW_SHORTFULL){
				//idea.setShowtime(EasyCastUtil.getVideoLength(pc_selector_y_js));
				if(EasyCastUtil.getVideoLength(pc_shortfull_y_ideaurl)==0||EasyCastUtil.getVideoLength(pc_shortfull_t_ideaurl)==0){
					if(!"".equals(pc_shortfull_youkutudou_length)){
						idea.setShowtime(Integer.parseInt(pc_shortfull_youkutudou_length));
					}else{
						idea.setShowtime(15);
					}					
				}

			}

			idea.save();

			//cal current dc table the latest dc_id:
			String sql2 = "select id from dc order by id desc limit 1;";
			ArrayList al2 = DBConnection.getInstance("atm").execQuerySql6(sql2);

			int dd;
			//catch al2 is null exception
			if (al2.size() == 0) {
				dd = 0;
			} else {
				String c = (al2.get(0).toString()).substring(1, al2.get(0)
						.toString().length() - 1)
						+ "";
				dd = Integer.parseInt(c);
				System.out.println("dd is: " + dd);
			}

			//dc
			//			Dc dc = new Dc();
			//			dc.setTargetDate(v);
			//			dc.setCpc(10);
			//			dc.setCpm(1000);
			insertDc(cast.getStartDate(), cast.getEndDate(), is_show_priority,product_reserve_method);

			//			String sql = "update ration_optimize set level = 1000 where level = "
			//					+ ration_optimize_level
			//					+ " and idea_id in ( select id from idea where cast_id in ( select id from ad_cast where ad_type_id = "
			//					+ cast.getAdTypeId() + "));";

			//todo(这个sql包含变量)
			String sql = "select id from dc where target_date >= " + "'"
					+ cast.getStartDate() + "'" + " and target_date <= " + "'"
					+ cast.getEndDate() + "'" + " and id>" + dd + ";";
			ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
			//String a = (al1.get(0).toString()).substring(1,al.get(0).toString().length()-1) + "";
			//	int i = Integer.parseInt(a);
			System.out.println("sql1111111 is: " + sql);
			int kk[] = new int[al1.size()];
			System.out.println("dc length is : " + kk.length);

			for (int iii = 0; iii < al1.size(); iii++) {
				String aaa = (al1.get(iii).toString()).substring(1, al1.get(0)
						.toString().length() - 1)
						+ "";
				int k = Integer.parseInt(aaa);
				kk[iii] = k;
				System.out.println("kk[" + iii + "] is:" + kk[iii]);
			}
            
			if(ad_type == MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER){
				insertHideaTime(idea.getId(), cast.getStartDate(),
						cast.getEndDate());
			}else{
				insertIdeaTime(kk, idea.getId(), cast.getStartDate(),
						cast.getEndDate(),is_show_priority,product_reserve_method,m_ztsdk,m_sdk);

			}

			insertIdeaMonitor(ad_type, idea.getId(), click_url, click_kh_url,playing_url,
					show_url, over_url, iso_url, mt_url, iso_click_url,
					iso_h5_url,outtime,customtext_url,clientcustomclick_url,clientskip_url,clientfee_url,othercustomtextclick_url,otherskip_url,otherfeep_url,pc_vf_impression_pc,pc_vf_impression,pc_vob_impression_pc,pc_vb_impression_pc,pc_tp_impression_pc,custom_text,
					idea,m_mhtml_clickurl,app_search_banner_type,app_search_banner_youkupip_url,app_search_banner_youkupip_clickurl,app_search_banner_youkupip_showurl,app_search_banner_tudoupip_url,app_search_banner_tudoupip_clickurl,app_search_banner_tudoupip_showurl);
            if(ad_type==MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER){
            	insertHideaCpm(idea.getId(), cast.getStartDate(), cast.getEndDate());	
            }
			insertIdeaCpm(idea.getId(), cast.getStartDate(), cast.getEndDate());

			//insertIdeaUrl
			//todo
			insertIdeaUrl(ad_type, cast_id,idea.getId(), pc_vf_y_ideaurl,pc_vf_pipurl, loader_type,loader_type_vob,loader_type_vb,loader_type_tp,m_vf_ideaurl,
					pc_vb_ideaurl, m_vb_ideaurl, pc_vob_ideaurl,pc_vob_pipurl, m_mo_ideaurl,
					pc_vc_y_ideaurl, pc_vc_t_ideaurl, m_vc_openstatus_pageurl,
					m_vc_closestatus_pageurl, pc_vp_y_ideaurl,
					pc_vp_y_full_ideaurl, pc_vp_t_ideaurl,
					pc_vp_t_full_ideaurl, m_vp_ideaurl, m_mqp_ipad_ideaurl_748,
					m_mqp_iphone_ideaurl_480, m_mqp_androidpad_ideaurl_720,
					m_mqp_androidphone_ideaurl_480, m_mi_ipad_ideaurl_768,
					m_mi_ipad_ideaurl_1004, m_mi_iphone_ideaurl_940,
					m_mi_iphone_ideaurl_1116, m_mi_iphone_ideaurl_1334,
					m_mi_iphone_ideaurl_1920, m_mi_apad_ideaurl_800,
					m_mi_apad_ideaurl_600, m_mi_apad_ideaurl_768, m_mi_aphone_ideaurl_1280,
					m_mi_aphone_ideaurl_800, m_mi_atv_ideaurl_720,m_iku_pc_ideaurl_650,m_iku_pc_ideaurl_720,
					pc_shortfull_y_ideaurl, pc_shortfull_t_ideaurl,
					pc_crazy_y_js, pc_crazy_t_ideaurl, pc_vf_impression,pc_vf_impression_pc,pc_vob_impression_pc,pc_vb_impression_pc,pc_tp_impression_pc,
					m_h5_vf_ideaurl_phone, m_h5_vf_ideaurl_pad,pc_selector_y_js, pc_selector_t_ideaurl,chk_os,pc_tp_ideaurl,m_vtp_ideaurl,pc_shortfull_youkutudou_width,pc_shortfull_youkutudou_height,
					pc_vc_width,pc_vc_height,m_mhtml_text_content,app_search_banner_type,app_search_banner_youkupip_url,app_search_banner_youkupip_clickurl,app_search_banner_youkupip_showurl,app_search_banner_tudoupip_url,app_search_banner_tudoupip_clickurl,app_search_banner_tudoupip_showurl);


			insertIdeaSurvey(ad_type, idea.getId(), survey_entry_text_app,
					youku_survey_url, tudou_survey_url,
					survey_click_url_app, millwardbrown_ad_type,millwardbrown_ad_type_APP,
					survey_show_url_app);

			return idea.getId();

		} catch (Exception e) {
			//e.printStackTrace();
			//logger.error(e.getStackTrace(),e);
			//System.out.println("***************" + e.getStackTrace());
			logger.error(e.getStackTrace(), e);
		}

		return -1;

	}
    
	void insertIdeaDq(Idea idea,String[] resolution_hd2,String[] resolution_mp4,String[] resolution_flv){
		try{
			int hd2_result=0;
			if(resolution_hd2 != null){
				for(int i=0;i<resolution_hd2.length;i++){
					int hd2 = Integer.parseInt(resolution_hd2[i]);
				    hd2_result = hd2+ hd2_result;
				}
				hd2_result = hd2_result -1;
			}
			String hd2_dq_result = hd2_result + "";
			
			int mp4_result=0;
			if(resolution_mp4 != null){
				for(int i=0;i<resolution_mp4.length;i++){
					int mp4 = Integer.parseInt(resolution_mp4[i]);
					mp4_result = mp4+ mp4_result;
				}
				mp4_result = mp4_result -1;
			}
			String mp4_dq_result = mp4_result + "";
			
			int flv_result=0;
			if(resolution_flv != null){
				for(int i=0;i<resolution_flv.length;i++){
					int flv = Integer.parseInt(resolution_flv[i]);
					flv_result = flv+ flv_result;
				}
				flv_result = flv_result -1;
			}
			String flv_dq_result = flv_result + "";
			idea.setDq(hd2_dq_result+","+mp4_dq_result+","+flv_dq_result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void insertDc(Date startDate, Date endDate, String is_show_priority,String product_reserve_method) {

			Date temp = startDate;
			Calendar calendar;
			while (temp.compareTo(endDate) <= 0) {
				calendar = Calendar.getInstance();
				calendar.setTime(temp);

				try {
					Dc dc = new Dc();
					dc.setTargetDate(temp);
					int product_reserve_method_dc = Integer
							.parseInt(product_reserve_method);
					if(product_reserve_method_dc==1){
						dc.setCpm(1000);
					}
					if(product_reserve_method_dc==6){
						dc.setCpc(1000);
					}
					if(product_reserve_method_dc==7){
						dc.setCpv(1000);
					}

					if(product_reserve_method_dc==8){
						dc.setCpp(1000);
					}
					
					dc.save();
				} catch (Exception e) {
					e.printStackTrace();
				}

				temp = EasyCastUtil.getTomorrow(temp);
			}
		

	}

	void insertIdeaTime(int kk[], int idea_id, Date startDate, Date endDate ,String is_show_priority,String product_reserve_method, int m_ztsdk, int m_sdk) {
		
		//getDcids
		//int leng = kk.length;
		Date temp = startDate;
		Calendar calendar;
		int j = 0;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);
			//++j;
			try {

					IdeaTime ideaTime = new IdeaTime();
					ideaTime.setIdeaId(idea_id);
					ideaTime.setStatus(1);

					ideaTime.setStarttime(calendar.getTime());
                    
					calendar.set(Calendar.HOUR, 23);
					calendar.set(Calendar.MINUTE, 59);
					calendar.set(Calendar.SECOND, 59);

					ideaTime.setEndtime(calendar.getTime());
					int product_reserve_method_idea_time = Integer
							.parseInt(product_reserve_method);
					if ((product_reserve_method_idea_time == 2)
							|| (product_reserve_method_idea_time == 4)
							|| (product_reserve_method_idea_time == 3)
							|| (product_reserve_method_idea_time == 5)
							|| m_sdk != 0 || m_ztsdk != 0) {
						ideaTime.setDcId(0);
					} else {
						ideaTime.setDcId(kk[j]);
					}

					ideaTime.save();

			} catch (Exception e) {
				e.printStackTrace();
			}

			j++;

			temp = EasyCastUtil.getTomorrow(temp);
		}
	}
	
	void insertHideaTime(int idea_id, Date startDate, Date endDate) {
		
		//getDcids
		//int leng = kk.length;
		Date temp = startDate;
		Calendar calendar;
		int j = 0;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);
			//++j;
			try {

				    HideaTime hIdeaTime = new HideaTime();
				    hIdeaTime.setIdeaId(idea_id);
				    hIdeaTime.setStatus(1);

				    hIdeaTime.setStarttime(calendar.getTime());
                    
					calendar.set(Calendar.HOUR, 23);
					calendar.set(Calendar.MINUTE, 59);
					calendar.set(Calendar.SECOND, 59);

					hIdeaTime.setEndtime(calendar.getTime());
					hIdeaTime.setDcId(0);

					hIdeaTime.save();

			} catch (Exception e) {
				e.printStackTrace();
			}

			j++;

			temp = EasyCastUtil.getTomorrow(temp);
		}
	}

	void insertIdeaMonitor(int ad_type, int idea_id, String click_url,
			String click_kh_url, String playing_url,String show_url, String over_url,
			String iso_url, String mt_url, String iso_click_url,
			String iso_h5_url, int outtime,String customtext_url,String clientcustomclick_url,String clientskip_url,String clientfee_url,String othercustomtextclick_url,String otherskip_url,String otherfeep_url,int pc_vf_impression_pc,int pc_vf_impression,int pc_vob_impression_pc,int pc_vb_impression_pc,int pc_tp_impression_pc,String custom_text,
			Idea idea,String m_mhtml_clickurl,String app_search_banner_type,String app_search_banner_youkupip_url,String app_search_banner_youkupip_clickurl,String app_search_banner_youkupip_showurl,String app_search_banner_tudoupip_url,String app_search_banner_tudoupip_clickurl,String app_search_banner_tudoupip_showurl) {
		try {
			IdeaMonitor ideaMonitor = new IdeaMonitor();
			ideaMonitor.setIdeaId(idea_id);
			ideaMonitor.setType(1);
			ideaMonitor.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO
					|| ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL
					|| ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR || ad_type ==NEW_KAIJITU || ad_type==NEW_TIEPIAN) {
				ideaMonitor.setBt(1);
			}

			if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU || ad_type==MB_TIEPIAN) {
				ideaMonitor.setBt(2);
			}

			ideaMonitor.setMt(-1);

			if (!"".equals(click_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
				ideaMonitor.setUrl(covertUrl(click_url));
				ideaMonitor.save();
			}
			
			if(ad_type == MB_APPSEARCHBANNER){
				if(app_search_banner_type.equals("1")){
					if(!"".equals(app_search_banner_youkupip_clickurl)){
						ideaMonitor.setSite(1);				
						ideaMonitor.setUrl(covertUrl(app_search_banner_youkupip_clickurl));

					}
					if(!"".equals(app_search_banner_tudoupip_clickurl)){
	                    ideaMonitor.setSite(2);					
						ideaMonitor.setUrl(covertUrl(app_search_banner_tudoupip_clickurl));
					}

					ideaMonitor.setBt(0);
					ideaMonitor.save();
				}else{
					//do nothing
				}

			}

			IdeaMonitor ideaMonitor1 = new IdeaMonitor();
			ideaMonitor1.setIdeaId(idea_id);
			ideaMonitor1.setType(2);
			ideaMonitor1.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO
					|| ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL
					|| ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU || ad_type==NEW_TIEPIAN) {
				ideaMonitor1.setBt(1);
			}

			if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU || ad_type==MB_TIEPIAN) {
				ideaMonitor1.setBt(2);
			}
			ideaMonitor1.setMt(-1);

			if (!"".equals(click_kh_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
				ideaMonitor1.setUrl(click_kh_url);
				ideaMonitor1.save();
			}

			IdeaMonitor ideaMonitor2 = new IdeaMonitor();
			ideaMonitor2.setIdeaId(idea_id);
			ideaMonitor2.setType(3);
			ideaMonitor2.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO
					|| ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL
					|| ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU ||ad_type==NEW_TIEPIAN || ad_type == MB_APPSEARCHBANNER) {
				ideaMonitor2.setBt(1);
			}

			if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN) {
				ideaMonitor2.setBt(2);
			}

			ideaMonitor2.setMt(-1);

			if (!"".equals(show_url)&&ad_type != MB_WENZILIAN &&ad_type != MB_APPSEARCHBANNER) {
				ideaMonitor2.setUrl(show_url);
				ideaMonitor2.save();
			}
			
			if(ad_type == MB_APPSEARCHBANNER){
				if(app_search_banner_type.equals("1")){
					if(!"".equals(app_search_banner_youkupip_showurl)){
						ideaMonitor2.setSite(1);				
						ideaMonitor2.setUrl(covertUrl(app_search_banner_youkupip_showurl));

					}
					if(!"".equals(app_search_banner_tudoupip_showurl)){
						ideaMonitor2.setSite(2);					
						ideaMonitor2.setUrl(covertUrl(app_search_banner_tudoupip_showurl));
					}

					ideaMonitor2.setBt(0);
					ideaMonitor2.save();
				}else{
					//do nothing
				}

			}

			IdeaMonitor ideaMonitor3 = new IdeaMonitor();
			ideaMonitor3.setIdeaId(idea_id);

			if (outtime != 0&&!"".equals(playing_url)) {
				ideaMonitor3.setType(5);
				ideaMonitor3.setMt(outtime);
				ideaMonitor3.setSite(0);
				if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
						|| ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO
						|| ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL
						|| ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU || ad_type==NEW_TIEPIAN) {
					ideaMonitor3.setBt(1);
				}

				if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
						|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
						|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
						|| ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN) {
					ideaMonitor3.setBt(2);
				}
				if (!"".equals(over_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
					ideaMonitor3.setUrl(playing_url);
					ideaMonitor3.save();
				}
			} 
			
			
			IdeaMonitor ideaMonitor17 = new IdeaMonitor();
			ideaMonitor17.setIdeaId(idea_id);
			ideaMonitor17.setType(4);
			ideaMonitor17.setMt(-1);

			//			ideaMonitor3.setType(4);
			ideaMonitor17.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO
					|| ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL
					|| ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU || ad_type==NEW_TIEPIAN) {
				ideaMonitor17.setBt(1);
			}

			if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN) {
				ideaMonitor17.setBt(2);
			}
			if (!"".equals(over_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
				ideaMonitor17.setUrl(over_url);
				ideaMonitor17.save();
			}

			IdeaMonitor ideaMonitor4 = new IdeaMonitor();
			ideaMonitor4.setIdeaId(idea_id);
			ideaMonitor4.setType(6);
			ideaMonitor4.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO
					|| ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL
					|| ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU ||ad_type==NEW_TIEPIAN) {
				ideaMonitor4.setBt(1);
			}

			if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN) {
				ideaMonitor4.setBt(2);
			}
			ideaMonitor4.setMt(-1);
			if (!"".equals(iso_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
				ideaMonitor4.setUrl(iso_url);

				ideaMonitor4.save();
			}

			IdeaMonitor ideaMonitor5 = new IdeaMonitor();
			ideaMonitor5.setIdeaId(idea_id);
			ideaMonitor5.setType(7);
			ideaMonitor5.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO
					|| ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL
					|| ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU ||ad_type==NEW_TIEPIAN) {
				ideaMonitor5.setBt(1);
			}

			if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN) {
				ideaMonitor5.setBt(2);
			}
			ideaMonitor5.setMt(-1);
			if (!"".equals(iso_click_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
				ideaMonitor5.setUrl(iso_click_url);

				ideaMonitor5.save();
			}

			IdeaMonitor ideaMonitor6 = new IdeaMonitor();
			ideaMonitor6.setIdeaId(idea_id);
			ideaMonitor6.setType(8);
			ideaMonitor6.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO
					|| ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL
					|| ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU ||ad_type==NEW_TIEPIAN) {
				ideaMonitor6.setBt(1);
			}

			if (ad_type == MB_QIANTIE || ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN) {
				ideaMonitor6.setBt(2);
			}
			ideaMonitor6.setMt(-1);
			if (!"".equals(iso_h5_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
				ideaMonitor6.setUrl(iso_h5_url);

				ideaMonitor6.save();
			}
			
			//trueview
			//自定义文字点击地址(type=10)
			if(!"请选择".equals(custom_text)){
				IdeaMonitor ideaMonitor7 = new IdeaMonitor();
				ideaMonitor7.setIdeaId(idea_id);
				ideaMonitor7.setType(10);
				ideaMonitor7.setSite(0);
				if ((ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
						|| ad_type == NEW_ZHONGCHA ||ad_type==NEW_TIEPIAN ||ad_type==MB_QIANTIE)&&((pc_vf_impression_pc==2)||(pc_vob_impression_pc==2)||(pc_vb_impression_pc==2)||(pc_tp_impression_pc==2)||(pc_vf_impression==2))) {
					ideaMonitor7.setBt(1);
					if(ad_type==MB_QIANTIE){
						ideaMonitor7.setBt(2);
					}
					ideaMonitor7.setMt(-1);
	                ideaMonitor7.setContent(custom_text);
					if (!"".equals(customtext_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
						ideaMonitor7.setUrl(covertUrl(customtext_url));
						ideaMonitor7.save();
					}			
				}
				
				//客户提供的自定义文字点击监测地址(type=11)
				IdeaMonitor ideaMonitor8 = new IdeaMonitor();
				ideaMonitor8.setIdeaId(idea_id);
				ideaMonitor8.setType(11);
				ideaMonitor8.setSite(0);
				if ((ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
						|| ad_type == NEW_ZHONGCHA ||ad_type==NEW_TIEPIAN ||ad_type==MB_QIANTIE)&&((pc_vf_impression_pc==2)||(pc_vob_impression_pc==2)||(pc_vb_impression_pc==2)||(pc_tp_impression_pc==2)||(pc_vf_impression==2))) {
					ideaMonitor8.setBt(1);
					if(ad_type==MB_QIANTIE){
						ideaMonitor8.setBt(2);
					}
					ideaMonitor8.setMt(-1);

					if (!"".equals(clientcustomclick_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
						ideaMonitor8.setUrl(covertUrl(clientcustomclick_url));
						ideaMonitor8.save();
					}			
				}
			}

			
			//客户提供的跳过监测地址(type=9)
			IdeaMonitor ideaMonitor9 = new IdeaMonitor();
			ideaMonitor9.setIdeaId(idea_id);
			ideaMonitor9.setType(9);
			ideaMonitor9.setSite(0);
			if ((ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA ||ad_type==NEW_TIEPIAN||ad_type==MB_QIANTIE)&&((pc_vf_impression_pc==2)||(pc_vob_impression_pc==2)||(pc_vb_impression_pc==2)||(pc_tp_impression_pc==2)||(pc_vf_impression==2))) {
				ideaMonitor9.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor9.setBt(2);
				}
				ideaMonitor9.setMt(-1);

				if (!"".equals(clientskip_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
					//System.out.println("客户提供的跳过监测地址:" + clientskip_url);
					ideaMonitor9.setUrl(covertUrl(clientskip_url));
					//ideaMonitor9.setUrl("ligang");
					ideaMonitor9.save();
				}			
			}
			
			//客户提供的计费监测地址(type=5)
			IdeaMonitor ideaMonitor10 = new IdeaMonitor();
			ideaMonitor10.setIdeaId(idea_id);
			ideaMonitor10.setType(5);
			ideaMonitor10.setSite(0);
			if ((ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA ||ad_type==NEW_TIEPIAN||ad_type==MB_QIANTIE)&&((pc_vf_impression_pc==2)||(pc_vob_impression_pc==2)||(pc_vb_impression_pc==2)||(pc_tp_impression_pc==2)||(pc_vf_impression==2))) {
				ideaMonitor10.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor10.setBt(2);
				}
				
				//to do 15s(idea表增加计费时长字段，保存素材时对该字段赋值；如产品定义中计费时长阈值为15秒，则当素材真实时长>=15秒时，赋值为15秒，如素材真实时长<15秒，赋值为真实时长；)
				//计费时间点的监测地址采用MT字段，type=5 ，CPM传type=5以及MT=计费时长（15或真实时长）给atm ，未来可扩展其他时间点的监测；
//				ArrayList alk = DBConnection.getInstance("atm").execQuerySql6(
//					"select id from idea order by id desc limit 1");
//				
//				String ak = (alk.get(0).toString()).substring(1, alk.get(0)
//						.toString().length() - 1)
//						+ "";
//				int ik = Integer.parseInt(ak);
//				Idea idea = IdeaPeer.retrieveByPK(ik);
				if(idea.getChargeTime()==0){
					ideaMonitor10.setMt(-1);
				}else{
					ideaMonitor10.setMt(idea.getChargeTime());	
				}

				if (!"".equals(clientfee_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
					ideaMonitor10.setUrl(covertUrl(clientfee_url));
					ideaMonitor10.save();
				}			
			}
			
			//标准第三方提供的自定义文字点击监测地址(type=11)
			IdeaMonitor ideaMonitor11 = new IdeaMonitor();
			ideaMonitor11.setIdeaId(idea_id);
			ideaMonitor11.setType(11);
			ideaMonitor11.setSite(0);
			if ((ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA ||ad_type==NEW_TIEPIAN||ad_type==MB_QIANTIE)&&((pc_vf_impression_pc==2)||(pc_vob_impression_pc==2)||(pc_vb_impression_pc==2)||(pc_tp_impression_pc==2)||(pc_vf_impression==2))) {
				ideaMonitor11.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor11.setBt(2);
				}
				ideaMonitor11.setMt(-1);

				if (!"".equals(othercustomtextclick_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
					ideaMonitor11.setUrl(covertUrl(othercustomtextclick_url));
					ideaMonitor11.save();
				}			
			}
			
			//标准第三方的跳过监测地址(type=9)
			IdeaMonitor ideaMonitor12 = new IdeaMonitor();
			ideaMonitor12.setIdeaId(idea_id);
			ideaMonitor12.setType(9);
			ideaMonitor12.setSite(0);
			if ((ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA ||ad_type==NEW_TIEPIAN||ad_type==MB_QIANTIE)&&((pc_vf_impression_pc==2)||(pc_vob_impression_pc==2)||(pc_vb_impression_pc==2)||(pc_tp_impression_pc==2)||(pc_vf_impression==2))) {
				ideaMonitor12.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor12.setBt(2);
				}
				ideaMonitor12.setMt(-1);

				if (!"".equals(otherskip_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
					ideaMonitor12.setUrl(covertUrl(otherskip_url));
					ideaMonitor12.save();
				}			
			}
			
			//标准第三方的计费监测地址(type=5)
			IdeaMonitor ideaMonitor13 = new IdeaMonitor();
			ideaMonitor13.setIdeaId(idea_id);
			ideaMonitor13.setType(5);
			ideaMonitor13.setSite(0);
			if ((ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE
					|| ad_type == NEW_ZHONGCHA ||ad_type==NEW_TIEPIAN||ad_type==MB_QIANTIE)&&((pc_vf_impression_pc==2)||(pc_vob_impression_pc==2)||(pc_vb_impression_pc==2)||(pc_tp_impression_pc==2)||(pc_vf_impression==2))) {
				ideaMonitor13.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor13.setBt(2);
				}
				
				//to do 15s(idea表增加计费时长字段，保存素材时对该字段赋值；如产品定义中计费时长阈值为15秒，则当素材真实时长>=15秒时，赋值为15秒，如素材真实时长<15秒，赋值为真实时长；)
				//计费时间点的监测地址采用MT字段，type=5 ，CPM传type=5以及MT=计费时长（15或真实时长）给atm ，未来可扩展其他时间点的监测；
//				ArrayList alk = DBConnection.getInstance("atm").execQuerySql6(
//					"select id from idea order by id desc limit 1");
//				
//				String ak = (alk.get(0).toString()).substring(1, alk.get(0)
//						.toString().length() - 1)
//						+ "";
//				int ik = Integer.parseInt(ak);
//				Idea idea = IdeaPeer.retrieveByPK(ik);
				if(idea.getChargeTime()==0){
					ideaMonitor13.setMt(-1);
				}else{
					ideaMonitor13.setMt(idea.getChargeTime());
				}
				
				//ideaMonitor13.setMt(15);

				if (!"".equals(otherfeep_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER) {
					ideaMonitor13.setUrl(covertUrl(otherfeep_url));
					ideaMonitor13.save();
				}			
			}
			
			if(ad_type == MB_WENZILIAN){
				IdeaMonitor ideaMonitor14 = new IdeaMonitor();
				ideaMonitor14.setIdeaId(idea_id);
				ideaMonitor14.setType(1);
				ideaMonitor14.setSite(0);
				ideaMonitor14.setBt(0);
				ideaMonitor14.setUrl(m_mhtml_clickurl);
				ideaMonitor14.setMt(-1);
				ideaMonitor14.save();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void insertIdeaCpm(int idea_id, Date startDate, Date endDate) {

		Date temp = startDate;
		Calendar calendar;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);

			try {
				IdeaCpm ideaCpm = new IdeaCpm();
				ideaCpm.setIdeaId(idea_id);
				ideaCpm.setCpm(1000);
				ideaCpm.setCpc(1000);
				ideaCpm.setCpv(1000);
				ideaCpm.setCpp(1000);
				ideaCpm.setRate(100);
				ideaCpm.setTargetDate(temp);

				ideaCpm.save();
			} catch (Exception e) {
				e.printStackTrace();
			}

			temp = EasyCastUtil.getTomorrow(temp);
		}

	}
	//insertHideaCpm
		void insertHideaCpm(int idea_id, Date startDate, Date endDate) {

		Date temp = startDate;
		Calendar calendar;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);

			try {
				HideaCpm hIdeaCpm = new HideaCpm();
				hIdeaCpm.setIdeaId(idea_id);
				hIdeaCpm.setCpm(0);
				hIdeaCpm.setCpc(0);
				hIdeaCpm.setRate(100);
				hIdeaCpm.setTargetDate(temp);

				hIdeaCpm.save();
			} catch (Exception e) {
				e.printStackTrace();
			}

			temp = EasyCastUtil.getTomorrow(temp);
		}

	}

	void insertIdeaUrl(int ad_type, int cast_id,int idea_id, String pc_vf_y_ideaurl,String pc_vf_pipurl,String loader_type,String loader_type_vob,String loader_type_vb,String loader_type_tp,
			String m_vf_ideaurl, String pc_vb_ideaurl, String m_vb_ideaurl,
			String pc_vob_ideaurl,String pc_vob_pipurl, String m_mo_ideaurl, String pc_vc_y_ideaurl,
			String pc_vc_t_ideaurl, String m_vc_openstatus_pageurl,
			String m_vc_closestatus_pageurl, String pc_vp_y_ideaurl,
			String pc_vp_y_full_ideaurl, String pc_vp_t_ideaurl,
			String pc_vp_t_full_ideaurl, String m_vp_ideaurl,
			String m_mqp_ipad_ideaurl_748, String m_mqp_iphone_ideaurl_480,
			String m_mqp_androidpad_ideaurl_720,
			String m_mqp_androidphone_ideaurl_480,
			String m_mi_ipad_ideaurl_768, String m_mi_ipad_ideaurl_1004,
			String m_mi_iphone_ideaurl_940, String m_mi_iphone_ideaurl_1116,
			String m_mi_iphone_ideaurl_1334, String m_mi_iphone_ideaurl_1920,
			String m_mi_apad_ideaurl_800, String m_mi_apad_ideaurl_600, String m_mi_apad_ideaurl_768,
			String m_mi_aphone_ideaurl_1280, String m_mi_aphone_ideaurl_800,
			String m_mi_atv_ideaurl_720, String m_iku_pc_ideaurl_650,String m_iku_pc_ideaurl_720,String pc_shortfull_y_ideaurl,
			String pc_shortfull_t_ideaurl, String pc_crazy_y_js,
			String pc_crazy_t_ideaurl, int pc_vf_impression,
			int pc_vf_impression_pc,int pc_vob_impression_pc,int pc_vb_impression_pc,int pc_tp_impression_pc, String m_h5_vf_ideaurl_phone,String m_h5_vf_ideaurl_pad,
			String pc_selector_y_js, String pc_selector_t_ideaurl,
			String[] chk_os,String pc_tp_ideaurl,String m_vtp_ideaurl,String pc_shortfull_youkutudou_width,String pc_shortfull_youkutudou_height,
			String pc_vc_width,String pc_vc_height,String m_mhtml_text_content,
			String app_search_banner_type,String app_search_banner_youkupip_url,String app_search_banner_youkupip_clickurl,String app_search_banner_youkupip_showurl,String app_search_banner_tudoupip_url,String app_search_banner_tudoupip_clickurl,String app_search_banner_tudoupip_showurl) {
		try {
			if (ad_type == NEW_QIANTIE) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(1);
				ideaUrl.setType(1);
				//to do to set content idea_url
				if (pc_vf_impression_pc == 1) {
					System.out.println("pc_vf_impression_pc is: "
							+ pc_vf_impression_pc);
					String pc_vf_y_ideaurl_encode = URLEncoder.encode(pc_vf_y_ideaurl,"utf-8");
					if("1".equals(loader_type)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/INT_VPAIDAdRenderer.swf?url="
								+ pc_vf_y_ideaurl_encode);
					}else if("2".equals(loader_type)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/VPAIDAdRenderer.swf?url="
								+ pc_vf_y_ideaurl_encode);
					}else{
						ideaUrl.setContent("http://static.atm.youku.com/idea/iab/vpaid/V2_INT_VPAIDAdRenderer.swf?url="
								+ pc_vf_y_ideaurl_encode);
					}

				} else {
					ideaUrl.setContent(pc_vf_y_ideaurl);
				}
				

				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
				
				if(pc_vf_pipurl != null && !"".equals(pc_vf_pipurl)){
					
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(2);
					ideaUrl1.setContent(pc_vf_pipurl);

					ideaUrl1.setIdeaWidth(20);
					ideaUrl1.setIdeaHeight(10);
					ideaUrl1.save();
					
				}

			}

			if (ad_type == MB_QIANTIE) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(2);

				if ((chk_os != null) && (chk_os.length == 1)
						&& (chk_os[0].equals("1_1_2_a"))) {
					ideaUrl.setBt(3);
				}
				ideaUrl.setType(1);
				//to do to set content idea_url
				ideaUrl.setContent(m_vf_ideaurl);
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
				if (pc_vf_impression == 1) {
					if(!"".equals(m_h5_vf_ideaurl_phone)&&m_h5_vf_ideaurl_phone!=null){
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl1.setBt(4);
						ideaUrl1.setType(16);
						ideaUrl1.setContent(m_h5_vf_ideaurl_phone.trim());
						ideaUrl1.setIdeaWidth(20);
						ideaUrl1.setIdeaHeight(10);
						ideaUrl1.save();
					}
					if(!"".equals(m_h5_vf_ideaurl_pad)&&m_h5_vf_ideaurl_pad!=null){
						IdeaUrl ideaUrl2 = new IdeaUrl();
						ideaUrl2.setIdeaId(idea_id);
						ideaUrl2.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl2.setBt(5);
						ideaUrl2.setType(16);
						ideaUrl2.setContent(m_h5_vf_ideaurl_pad.trim());
						ideaUrl2.setIdeaWidth(20);
						ideaUrl2.setIdeaHeight(10);
						ideaUrl2.save();
					}

				}
			}

			if (ad_type == NEW_HOUTIE) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(1);
				ideaUrl.setType(1);
				//to do to set content idea_url
				if (pc_vb_impression_pc == 1) {
					System.out.println("pc_vf_impression_pc is: "
							+ pc_vf_impression_pc);
					String pc_vb_ideaurl_encode = URLEncoder.encode(pc_vb_ideaurl,"utf-8");
					if("1".equals(loader_type_vb)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/INT_VPAIDAdRenderer.swf?url="
								+ pc_vb_ideaurl);
					}else if("2".equals(loader_type_vb)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/VPAIDAdRenderer.swf?url="
								+ pc_vb_ideaurl);
					}else{
						ideaUrl.setContent("http://static.atm.youku.com/idea/iab/vpaid/V2_INT_VPAIDAdRenderer.swf?url="
								+ pc_vb_ideaurl_encode);
					}

				} else {
					ideaUrl.setContent(pc_vb_ideaurl);
				}
				//ideaUrl.setContent(pc_vb_ideaurl);
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
			}

			if (ad_type == MB_HOUTIE) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(2);
				ideaUrl.setType(1);
				//to do to set content idea_url
				ideaUrl.setContent(m_vb_ideaurl);
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
			}

			if (ad_type == NEW_ZHONGCHA) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(1);
				ideaUrl.setType(1);
				//to do to set content idea_url
				if (pc_vob_impression_pc == 1) {
					System.out.println("pc_vf_impression_pc is: "
							+ pc_vf_impression_pc);
					String pc_vob_ideaurl_encode = URLEncoder.encode(pc_vob_ideaurl,"utf-8");
					if("1".equals(loader_type_vob)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/INT_VPAIDAdRenderer.swf?url="
								+ pc_vob_ideaurl);
					}else if("2".equals(loader_type_vob)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/VPAIDAdRenderer.swf?url="
								+ pc_vob_ideaurl);
					}else{
						ideaUrl.setContent("http://static.atm.youku.com/idea/iab/vpaid/V2_INT_VPAIDAdRenderer.swf?url="
								+ pc_vob_ideaurl_encode);
					}

				} else {
					ideaUrl.setContent(pc_vob_ideaurl);
				}
				//ideaUrl.setContent(pc_vob_ideaurl);
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
				if(pc_vob_pipurl != null && !"".equals(pc_vob_pipurl)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(2);
					//to do to set content idea_url
					ideaUrl1.setContent(pc_vob_pipurl);
					ideaUrl1.setIdeaWidth(20);
					ideaUrl1.setIdeaHeight(10);
					ideaUrl1.save();
				}
			}

			//m_mo_ideaurl
			if (ad_type == MB_ZHONGCHA) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(2);
				ideaUrl.setType(1);
				//to do to set content idea_url
				ideaUrl.setContent(m_mo_ideaurl);
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
			}

			if (ad_type == NEW_JIAOBIAO) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(1);
				ideaUrl.setBt(1);
				ideaUrl.setType(7);
                if(pc_vc_y_ideaurl != null&&!"".equals(pc_vc_y_ideaurl)){
    				ideaUrl.setContent(pc_vc_y_ideaurl);
    				if(!"".equals(pc_vc_width)||!"".equals(pc_vc_height)){
    					ideaUrl.setIdeaWidth(Integer.parseInt(pc_vc_width));
    					ideaUrl.setIdeaHeight(Integer.parseInt(pc_vc_height));
    				}else{
    					ideaUrl.setIdeaWidth(20);
    					ideaUrl.setIdeaHeight(10);
    				}

    				ideaUrl.save();
                }


				IdeaUrl ideaUrl1 = new IdeaUrl();
				ideaUrl1.setIdeaId(idea_id);
				ideaUrl1.setSite(2);
				ideaUrl1.setBt(1);
				ideaUrl1.setType(7);
                
				if(pc_vc_t_ideaurl != null&&!"".equals(pc_vc_t_ideaurl)){
					ideaUrl1.setContent(pc_vc_t_ideaurl);
					if(!"".equals(pc_vc_width)||!"".equals(pc_vc_height)){
						ideaUrl1.setIdeaWidth(Integer.parseInt(pc_vc_width));
						ideaUrl1.setIdeaHeight(Integer.parseInt(pc_vc_height));
					}else{
						ideaUrl1.setIdeaWidth(20);
						ideaUrl1.setIdeaHeight(10);
					}
					//ideaUrl1.setIdeaWidth(20);
					//ideaUrl1.setIdeaHeight(10);
					ideaUrl1.save();
				}

			}

			if (ad_type == MB_JIAOBIAO) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(2);
				ideaUrl.setType(7);

				ideaUrl.setContent(m_vc_openstatus_pageurl);
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();

				IdeaUrl ideaUrl1 = new IdeaUrl();
				ideaUrl1.setIdeaId(idea_id);
				ideaUrl1.setSite(0);
				ideaUrl1.setBt(2);
				ideaUrl1.setType(8);

				ideaUrl1.setContent(m_vc_closestatus_pageurl);
				ideaUrl1.setIdeaWidth(20);
				ideaUrl1.setIdeaHeight(10);
				ideaUrl1.save();
			}

			if (ad_type == NEW_ZANTING) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(1);
				ideaUrl.setBt(1);
				ideaUrl.setType(5);

				if (pc_vp_y_ideaurl != null && !"".equals(pc_vp_y_ideaurl)) {
					ideaUrl.setContent(pc_vp_y_ideaurl);
				}

				ideaUrl.save();

				IdeaUrl ideaUrl1 = new IdeaUrl();
				ideaUrl1.setIdeaId(idea_id);
				ideaUrl1.setSite(1);
				ideaUrl1.setBt(1);
				ideaUrl1.setType(4);

				if (pc_vp_y_full_ideaurl != null
						&& !"".equals(pc_vp_y_full_ideaurl)) {
					ideaUrl1.setContent(pc_vp_y_full_ideaurl);
				}

				ideaUrl1.save();

				IdeaUrl ideaUrl2 = new IdeaUrl();
				ideaUrl2.setIdeaId(idea_id);
				ideaUrl2.setSite(2);
				ideaUrl2.setBt(1);
				ideaUrl2.setType(5);

				if (pc_vp_t_ideaurl != null && !"".equals(pc_vp_t_ideaurl)) {
					ideaUrl2.setContent(pc_vp_t_ideaurl);
				}

				ideaUrl2.save();

				IdeaUrl ideaUrl3 = new IdeaUrl();
				ideaUrl3.setIdeaId(idea_id);
				ideaUrl3.setSite(2);
				ideaUrl3.setBt(1);
				ideaUrl3.setType(4);
				if (pc_vp_t_full_ideaurl != null
						&& !"".equals(pc_vp_t_full_ideaurl)) {
					ideaUrl3.setContent(pc_vp_t_full_ideaurl);
				}

				ideaUrl3.save();

			}
			if (ad_type == MB_ZANTING) {
				//m_vp_ideaurl
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(0);
				ideaUrl.setType(6);

				if (m_vp_ideaurl != null && !"".equals(m_vp_ideaurl)) {
					ideaUrl.setContent(m_vp_ideaurl);
				}

				ideaUrl.save();
			}
			
			//iku_kaijitu_pc
			if(ad_type == NEW_KAIJITU){
				//m_iku_pc_ideaurl_650,m_iku_pc_ideaurl_720
				if (m_iku_pc_ideaurl_650 != null
						&& !"".equals(m_iku_pc_ideaurl_650)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(9);
					ideaUrl.setContent(m_iku_pc_ideaurl_650);
					ideaUrl.setIdeaWidth(1024);
					ideaUrl.setIdeaHeight(650);
					ideaUrl.save();
				}
				
				if (m_iku_pc_ideaurl_720 != null
						&& !"".equals(m_iku_pc_ideaurl_720)) {
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(9);
					ideaUrl2.setContent(m_iku_pc_ideaurl_720);
					ideaUrl2.setIdeaWidth(1270);
					ideaUrl2.setIdeaHeight(720);
					ideaUrl2.save();
				}
			}
			
			//PC_TIEPIAN
			if(ad_type == NEW_TIEPIAN){
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(1);
				ideaUrl.setType(1);
				//to do to set content idea_url
								if (pc_tp_impression_pc == 1) {
					System.out.println("pc_vf_impression_pc is: "
							+ pc_vf_impression_pc);
					String pc_tp_ideaurl_encode = URLEncoder.encode(pc_tp_ideaurl,"utf-8");
					if("1".equals(loader_type_tp)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/INT_VPAIDAdRenderer.swf?url="
								+ pc_tp_ideaurl);
					}else if("2".equals(loader_type_tp)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/VPAIDAdRenderer.swf?url="
								+ pc_tp_ideaurl);
					}else{
						ideaUrl.setContent("http://static.atm.youku.com/idea/iab/vpaid/V2_INT_VPAIDAdRenderer.swf?url="
								+ pc_tp_ideaurl_encode);
					}

				} else {
					ideaUrl.setContent(pc_tp_ideaurl);
				}
				//ideaUrl.setContent(pc_tp_ideaurl);
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
			}
			
			//MB_TIEPIAN
			if(ad_type == MB_TIEPIAN){
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(2);

				if ((chk_os != null) && (chk_os.length == 1)
						&& (chk_os[0].equals("1_1_2_a"))) {
					ideaUrl.setBt(3);
				}
				ideaUrl.setType(1);
				//to do to set content idea_url
				ideaUrl.setContent(m_vtp_ideaurl);
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
			}

			if (ad_type == MB_KAIJITU) {
				//m_vp_ideaurl

				if (m_mi_ipad_ideaurl_768 != null
						&& !"".equals(m_mi_ipad_ideaurl_768)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(9);
					ideaUrl.setContent(m_mi_ipad_ideaurl_768);
					ideaUrl.setIdeaWidth(1024);
					ideaUrl.setIdeaHeight(748);
					ideaUrl.save();
				}

				if (m_mi_ipad_ideaurl_1004 != null
						&& !"".equals(m_mi_ipad_ideaurl_1004)) {
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(0);
					ideaUrl1.setType(9);
					ideaUrl1.setContent(m_mi_ipad_ideaurl_1004);
					ideaUrl1.setIdeaWidth(768);
					ideaUrl1.setIdeaHeight(1004);
					ideaUrl1.save();
				}

				if (m_mi_iphone_ideaurl_940 != null
						&& !"".equals(m_mi_iphone_ideaurl_940)) {
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(9);
					ideaUrl2.setContent(m_mi_iphone_ideaurl_940);
					ideaUrl2.setIdeaWidth(640);
					ideaUrl2.setIdeaHeight(940);
					ideaUrl2.save();
				}

				if (m_mi_iphone_ideaurl_1116 != null
						&& !"".equals(m_mi_iphone_ideaurl_1116)) {
					IdeaUrl ideaUrl3 = new IdeaUrl();
					ideaUrl3.setIdeaId(idea_id);
					ideaUrl3.setSite(0);
					ideaUrl3.setBt(0);
					ideaUrl3.setType(9);
					ideaUrl3.setContent(m_mi_iphone_ideaurl_1116);
					ideaUrl3.setIdeaWidth(640);
					ideaUrl3.setIdeaHeight(1136);
					ideaUrl3.save();
				}

				//				if (m_mi_apad_ideaurl_800 != null
				//						&& !"".equals(m_mi_apad_ideaurl_800)) {
				//					IdeaUrl ideaUrl4 = new IdeaUrl();
				//					ideaUrl4.setIdeaId(idea_id);
				//					ideaUrl4.setSite(0);
				//					ideaUrl4.setBt(0);
				//					ideaUrl4.setType(9);
				//					ideaUrl4.setContent(m_mi_apad_ideaurl_800);
				//					ideaUrl4.setIdeaWidth(1280);
				//					ideaUrl4.setIdeaHeight(800);
				//					ideaUrl4.save();
				//				}
				//m_mi_iphone_ideaurl_1334,m_mi_iphone_ideaurl_1920

				if (m_mi_iphone_ideaurl_1334 != null
						&& !"".equals(m_mi_iphone_ideaurl_1334)) {
					IdeaUrl ideaUrl4 = new IdeaUrl();
					ideaUrl4.setIdeaId(idea_id);
					ideaUrl4.setSite(0);
					ideaUrl4.setBt(0);
					ideaUrl4.setType(9);
					ideaUrl4.setContent(m_mi_iphone_ideaurl_1334);
					ideaUrl4.setIdeaWidth(750);
					ideaUrl4.setIdeaHeight(1134);
					ideaUrl4.save();
				}

				if (m_mi_iphone_ideaurl_1920 != null
						&& !"".equals(m_mi_iphone_ideaurl_1920)) {
					IdeaUrl ideaUrl5 = new IdeaUrl();
					ideaUrl5.setIdeaId(idea_id);
					ideaUrl5.setSite(0);
					ideaUrl5.setBt(0);
					ideaUrl5.setType(9);
					ideaUrl5.setContent(m_mi_iphone_ideaurl_1920);
					ideaUrl5.setIdeaWidth(828);
					ideaUrl5.setIdeaHeight(1472);
					ideaUrl5.save();
				}

				if (m_mi_apad_ideaurl_800 != null
						&& !"".equals(m_mi_apad_ideaurl_800)) {
					IdeaUrl ideaUrl6 = new IdeaUrl();
					ideaUrl6.setIdeaId(idea_id);
					ideaUrl6.setSite(0);
					ideaUrl6.setBt(0);
					ideaUrl6.setType(9);
					ideaUrl6.setContent(m_mi_apad_ideaurl_800);
					ideaUrl6.setIdeaWidth(1280);
					ideaUrl6.setIdeaHeight(800);
					ideaUrl6.save();
				}

				if (m_mi_apad_ideaurl_600 != null
						&& !"".equals(m_mi_apad_ideaurl_600)) {
					IdeaUrl ideaUrl7 = new IdeaUrl();
					ideaUrl7.setIdeaId(idea_id);
					ideaUrl7.setSite(0);
					ideaUrl7.setBt(0);
					ideaUrl7.setType(9);
					ideaUrl7.setContent(m_mi_apad_ideaurl_600);
					ideaUrl7.setIdeaWidth(1024);
					ideaUrl7.setIdeaHeight(600);
					ideaUrl7.save();
				}

				if (m_mi_aphone_ideaurl_1280 != null
						&& !"".equals(m_mi_aphone_ideaurl_1280)) {
					IdeaUrl ideaUrl8 = new IdeaUrl();
					ideaUrl8.setIdeaId(idea_id);
					ideaUrl8.setSite(0);
					ideaUrl8.setBt(0);
					ideaUrl8.setType(9);
					ideaUrl8.setContent(m_mi_aphone_ideaurl_1280);
					ideaUrl8.setIdeaWidth(800);
					ideaUrl8.setIdeaHeight(1280);
					ideaUrl8.save();
				}

				if (m_mi_aphone_ideaurl_800 != null
						&& !"".equals(m_mi_aphone_ideaurl_800)) {
					IdeaUrl ideaUrl9 = new IdeaUrl();
					ideaUrl9.setIdeaId(idea_id);
					ideaUrl9.setSite(0);
					ideaUrl9.setBt(0);
					ideaUrl9.setType(9);
					ideaUrl9.setContent(m_mi_aphone_ideaurl_800);
					ideaUrl9.setIdeaWidth(480);
					ideaUrl9.setIdeaHeight(800);
					ideaUrl9.save();
				}

				if (m_mi_atv_ideaurl_720 != null
						&& !"".equals(m_mi_atv_ideaurl_720)) {
					IdeaUrl ideaUrl10 = new IdeaUrl();
					ideaUrl10.setIdeaId(idea_id);
					ideaUrl10.setSite(0);
					ideaUrl10.setBt(0);
					ideaUrl10.setType(9);
					ideaUrl10.setContent(m_mi_atv_ideaurl_720);
					ideaUrl10.setIdeaWidth(1280);
					ideaUrl10.setIdeaHeight(720);
					ideaUrl10.save();
				}				
				
				if (m_mi_apad_ideaurl_768 != null
						&& !"".equals(m_mi_apad_ideaurl_768)) {
					IdeaUrl ideaUrl11 = new IdeaUrl();
					ideaUrl11.setIdeaId(idea_id);
					ideaUrl11.setSite(0);
					ideaUrl11.setBt(0);
					ideaUrl11.setType(9);
					ideaUrl11.setContent(m_mi_apad_ideaurl_768);
					ideaUrl11.setIdeaWidth(1024);
					ideaUrl11.setIdeaHeight(768);
					ideaUrl11.save();
				}

				//MB_KAIJITU_default_5s

			}

			if (ad_type == MB_QUANPING) {

				if (m_mqp_ipad_ideaurl_748 != null
						&& !"".equals(m_mqp_ipad_ideaurl_748)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(12);
					ideaUrl.setContent(m_mqp_ipad_ideaurl_748);
					ideaUrl.save();
				}

				if (m_mqp_iphone_ideaurl_480 != null
						&& !"".equals(m_mqp_iphone_ideaurl_480)) {
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(0);
					ideaUrl1.setType(13);
					ideaUrl1.setContent(m_mqp_iphone_ideaurl_480);
					ideaUrl1.save();
				}

				if (m_mqp_androidpad_ideaurl_720 != null
						&& !"".equals(m_mqp_androidpad_ideaurl_720)) {
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(14);
					ideaUrl2.setContent(m_mqp_androidpad_ideaurl_720);
					ideaUrl2.save();
				}

				if (m_mqp_androidphone_ideaurl_480 != null
						&& !"".equals(m_mqp_androidphone_ideaurl_480)) {
					IdeaUrl ideaUrl3 = new IdeaUrl();
					ideaUrl3.setIdeaId(idea_id);
					ideaUrl3.setSite(0);
					ideaUrl3.setBt(0);
					ideaUrl3.setType(15);
					ideaUrl3.setContent(m_mqp_androidphone_ideaurl_480);
					ideaUrl3.save();
				}

			}

			if (ad_type == NEW_SHORTFULL) {
				if (pc_shortfull_y_ideaurl != null
						&& !"".equals(pc_shortfull_y_ideaurl)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(1);
					ideaUrl.setBt(1);
					ideaUrl.setType(3);
					
				    //TODO,getAdBody.(930,500):pc_shortfull_youkutudou_width,pc_shortfull_youkutudou_height
					ideaUrl.setContent(getAdBody(pc_shortfull_y_ideaurl, "930",
							"500"));
					if(!"".equals(pc_shortfull_youkutudou_width)){
						ideaUrl.setIdeaWidth(Integer.parseInt(pc_shortfull_youkutudou_width));
					}else{
						ideaUrl.setIdeaWidth(930);
					}
					
					if(!"".equals(pc_shortfull_youkutudou_height)){
						ideaUrl.setIdeaWidth(Integer.parseInt(pc_shortfull_youkutudou_height));
					}else{
						ideaUrl.setIdeaHeight(500);
					}				
					
					ideaUrl.save();
				}
				//pc_shortfull_t_ideaurl
				if (pc_shortfull_t_ideaurl != null
						&& !"".equals(pc_shortfull_t_ideaurl)) {
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(2);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(1);
					ideaUrl1.setContent(pc_shortfull_t_ideaurl);
					if(!"".equals(pc_shortfull_youkutudou_width)){
						ideaUrl1.setIdeaWidth(Integer.parseInt(pc_shortfull_youkutudou_width));
					}else{
						ideaUrl1.setIdeaWidth(1000);
					}
					
					if(!"".equals(pc_shortfull_youkutudou_height)){
						ideaUrl1.setIdeaHeight(Integer.parseInt(pc_shortfull_youkutudou_height));
					}else{
						ideaUrl1.setIdeaHeight(497);
					}	
					//ideaUrl1.setIdeaWidth(1000);
					//ideaUrl1.setIdeaHeight(497);
					ideaUrl1.save();
				}
			}

			if (ad_type == NEW_SPECIALAD) {
				if (pc_crazy_y_js != null && !"".equals(pc_crazy_y_js)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(1);
					ideaUrl.setBt(1);
					ideaUrl.setType(3);
					ideaUrl.setContent((String) pc_crazy_y_js);
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
				//pc_shortfull_t_ideaurl
				if (pc_crazy_t_ideaurl != null
						&& !"".equals(pc_crazy_t_ideaurl)) {
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(2);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(1);
					ideaUrl1.setContent(pc_crazy_t_ideaurl);
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.save();
				}
			}

			if (ad_type == NEW_ADSELECTOR) {
				if (pc_selector_y_js != null && !"".equals(pc_selector_y_js)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(1);
					ideaUrl.setBt(1);
					ideaUrl.setType(1);
					ideaUrl.setContent("http://static.atm.youku.com/ssh/VPAIDAdRenderer.swf?url="
							+ pc_selector_y_js);
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
				if (pc_selector_t_ideaurl != null
						&& !"".equals(pc_selector_t_ideaurl)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(2);
					ideaUrl.setBt(1);
					ideaUrl.setType(1);
					ideaUrl.setContent(pc_selector_t_ideaurl);
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
			}
			
			if(ad_type==MB_WENZILIAN){
				if (m_mhtml_text_content != null && !"".equals(m_mhtml_text_content)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(2);
					ideaUrl.setType(11);
					ideaUrl.setContent(m_mhtml_text_content + "!t$p!");
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
			}
			
			if(ad_type==MB_APPSEARCHBANNER){
				if(app_search_banner_type.equals("1")){
					if (app_search_banner_youkupip_url != null && !"".equals(app_search_banner_youkupip_url)) {
						
//						String newJs = "SCRIPT_START var "+"img_"+idea_id+"= document.createElement(\"img\");";
//				        newJs = newJs+"img_"+idea_id+".width=0;";
//				        newJs = newJs+"img_"+idea_id+".height=0;";
//				        newJs = newJs+"img_"+idea_id+".src=\""+app_search_banner_youkupip_showurl+"\";";
//				        newJs = newJs+"document.getElementsByTagName('HEAD').item(0).appendChild("+"img_"+idea_id+");";
//				        newJs = newJs +" SCRIPT_END ";
//				        String template ="HTML_START<div align=\"center\" class=\"mod\" id=\"s_h_!ideaid!\"><a href=\"http://html.atm.youku.com/htmlclick?p=!positionid!&pp=!ppositionid!&pg=!pageid!&&ca=!castid!&ie=!ideaid!&k=!key!&u=!u!&uri=!userID!&dc=!dcID!\" target=\"_blank\"><img src=\"!RES!\" border=\"0\"/></a></div>HTML_END";
//				        template = template.replaceAll("!RES!", app_search_banner_youkupip_url);
//				        template = template.replaceAll("!castid!", cast_id+"");
//				        template = template.replaceAll("!ideaid!", idea_id+"");
//				        String md5 = getMD5Str(app_search_banner_youkupip_clickurl);
//				        template = template.replaceAll("!u!", app_search_banner_youkupip_clickurl+"&md5="+md5);
						
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(1);
						ideaUrl.setBt(0);
						ideaUrl.setType(11);
						//ideaUrl.setContent(newJs+template);
						ideaUrl.setContent(app_search_banner_youkupip_url);
						ideaUrl.setIdeaWidth(0);
						ideaUrl.setIdeaHeight(0);
						ideaUrl.save();
					}
					if(app_search_banner_tudoupip_url != null && !"".equals(app_search_banner_tudoupip_url)){
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(2);
						ideaUrl1.setBt(0);
						ideaUrl1.setType(11);
						//ideaUrl.setContent(newJs+template);
						ideaUrl1.setContent(app_search_banner_tudoupip_url);
						ideaUrl1.setIdeaWidth(0);
						ideaUrl1.setIdeaHeight(0);
						ideaUrl1.save();
					}
					
				}else{
					//do nothing
				}
		        
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void insertIdeaSurvey(int ad_type, int idea_id,
			String survey_entry_text_app, String youku_survey_url,
			String tudou_survey_url, String survey_click_url_app,
			String millwardbrown_ad_type, String millwardbrown_ad_type_APP,String survey_show_url_app) {
		try {
			//1=曝光组(expose实验组)
			if ("1".equals(millwardbrown_ad_type)) {
				
				if(!"".equals(youku_survey_url)){
					//youku
					IdeaSurvey ideaSurvey = new IdeaSurvey();
					ideaSurvey.setIdeaId(idea_id);
					ideaSurvey.setStype(1);
					ideaSurvey.setSite(1);
					ideaSurvey.setAw("w");
					ideaSurvey.setSurveyUrl(youku_survey_url);
					ideaSurvey.save();
				}
				if(!"".equals(tudou_survey_url)){
					//tudou
					IdeaSurvey ideaSurvey1 = new IdeaSurvey();
					ideaSurvey1.setIdeaId(idea_id);
					ideaSurvey1.setStype(1);
					ideaSurvey1.setSite(2);
					ideaSurvey1.setAw("w");
					ideaSurvey1.setSurveyUrl(tudou_survey_url);
					ideaSurvey1.save();
				}
			} else if("2".equals(millwardbrown_ad_type)){
				//2=参照组(control对照组)
				if(!"".equals(youku_survey_url)){
					//youku
					IdeaSurvey ideaSurvey = new IdeaSurvey();
					ideaSurvey.setIdeaId(idea_id);
					ideaSurvey.setStype(2);
					ideaSurvey.setSite(1);
					ideaSurvey.setAw("w");
					ideaSurvey.setSurveyUrl(youku_survey_url);
					ideaSurvey.save();
				}
				if(!"".equals(tudou_survey_url)){
					//tudou
					IdeaSurvey ideaSurvey1 = new IdeaSurvey();
					ideaSurvey1.setIdeaId(idea_id);
					ideaSurvey1.setStype(2);
					ideaSurvey1.setSite(2);
					ideaSurvey1.setAw("w");
					ideaSurvey1.setSurveyUrl(tudou_survey_url);
					ideaSurvey1.save();
				}		

			}
			
			if ("1".equals(millwardbrown_ad_type_APP)) {
				//1=曝光组(expose实验组)
				if(!"".equals(survey_show_url_app)||!"".equals(survey_click_url_app)||!"".equals(survey_entry_text_app)){

					IdeaSurvey ideaSurvey2 = new IdeaSurvey();
					ideaSurvey2.setIdeaId(idea_id);
					ideaSurvey2.setStype(1);
					ideaSurvey2.setSite(0);
					ideaSurvey2.setAw("a");
					ideaSurvey2.setSurveyUrl(survey_show_url_app);
					ideaSurvey2.setClickUrl(survey_click_url_app);

					ideaSurvey2.setSurveyText(survey_entry_text_app);
					ideaSurvey2.setTimeLen(120);
					ideaSurvey2.save();
				}
			} else if("2".equals(millwardbrown_ad_type_APP)){
				//2=参照组(control对照组)
				IdeaSurvey ideaSurvey2 = new IdeaSurvey();
				ideaSurvey2.setIdeaId(idea_id);
				ideaSurvey2.setStype(2);
				ideaSurvey2.setSite(0);
				ideaSurvey2.setAw("a");
				ideaSurvey2.setSurveyUrl(survey_show_url_app);
				ideaSurvey2.setClickUrl(survey_click_url_app);

				ideaSurvey2.setSurveyText(survey_entry_text_app);
				ideaSurvey2.setTimeLen(120);
				ideaSurvey2.save();	

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String insertVideoGroup(String video_group_area1) {
		String vids[] = video_group_area1.split("\r?\n");
		String vid_str = "";
		String playlist_str = "";
		for (int i = 0; i < vids.length; i++) {
			String tmp = vids[i];
			tmp = tmp.replaceAll("\\s", "");
			if ("".equals(tmp))
				continue;
			try {
				vid_str += getResult(tmp) + " ";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("vid_str is: " + vid_str);
		vid_str = vid_str.substring(0, vid_str.length() - 1);
		return vid_str;

	}

	String getResult(String urlString) throws Exception {

		if (urlString == null) {
			return "";
		}

		if (!urlString.toLowerCase().startsWith("http")) {
			return urlString;
		}

		String regex = "\\w+X(.+).html";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(urlString);

		if (m.find()) {
			String id = m.group(1);
			id = Util.decodeBase64(id);
			int idd = Integer.parseInt(id) >> 2;
			return idd + "";
		}

		return "";
	}

	//tudou_video_group

	String insertVideoGroupTD(String video_group_area2) {
		Set<String> vgset = new HashSet();
		String playlist_str = "";
		try {
			String vid_str = "";

			Pattern tudouPattern = Pattern
					.compile(
							"http\\:\\/\\/\\w+\\.tudou\\.com/programs/view/([a-zA-Z_0-9\\-]{11}).*|"
									+ // 单视频播放页
									"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/id/?(\\d+)|"
									+ "http\\:\\/\\/\\w+\\.tudou\\.com/playlist/album/id(\\d+).html|"
									+ "http\\:\\/\\/\\w+\\.tudou\\.com/playlist/p/a(\\d+).html|"
									+ "http\\:\\/\\/\\[作品\\](\\d+)-.*|"
									+ //作品正则表达式匹配
									"http\\:\\/\\/\\w+\\.tudou\\.com/albumcover/([a-zA-Z_0-9\\-]{11}).html|"
									+ //剧集过渡页改版、剧集封面 
									"http\\:\\/\\/\\w+\\.tudou\\.com/listcover/([a-zA-Z_0-9\\-]{11}).html|"
									+

									"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
									+ // 豆单播放页 
									"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/([a-zA-Z_0-9\\-]{11}).html|"
									+ // 豆单播放页 
									"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
									+ // 剧集播放页
									"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/([a-zA-Z_0-9\\-]{11}).html|"
									+ // 剧集播放页
									"http\\:\\/\\/\\w+\\.tudou\\.com/oplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
									+ // 周边播放页
									"http\\:\\/\\/\\w+\\.tudou\\.com/plcover/([a-zA-Z_0-9\\-]{11}).*|"
									+ //// 豆单封面
									"(\\d+)", Pattern.CASE_INSENSITIVE);

			if (video_group_area2 != null && video_group_area2.length() != 0) {
				String vid[] = video_group_area2.split("\r?\n");

				for (int i = 0; i < vid.length; i++) {
					Matcher m = tudouPattern.matcher(vid[i]);
					String tudou_vids = "";

					List<Long> lidlist = new ArrayList<Long>();
					List<Long> aidlist = new ArrayList<Long>();

					while (m.find()) {
						try {
							boolean b = m.matches();
							if (b) {
								tudou_vids += video_group_area2;
							} else {
								tudou_vids += video_group_area2 + "(无法匹配)";
							}
							if (m.group(1) != null) {
								vid_str += ""
										+ ItemCodeCrypt.getItemId(m.group(1));
							} else if (m.group(2) != null) {
								Long pid = stringToLong(m.group(2), -1);
								if (pid != -1)
									lidlist.add(pid);
							} else if (m.group(3) != null) {
								Long albumId = stringToLong(m.group(3), -1);
								if (albumId != -1)
									vid_str += "" + m.group(14);
							} else if (m.group(4) != null) {
								Long albumId = stringToLong(m.group(4), -1);
								if (albumId != -1)
									aidlist.add(albumId);
							} else if (m.group(6) != null) { //剧集过渡页改版      
								Long albumId = ItemCodeCrypt.getItemId(m
										.group(6));
								if (albumId != -1)
									aidlist.add(albumId);
							} else if (m.group(7) != null) {
								Long pid = ItemCodeCrypt.getItemId(m.group(7));
								if (pid != -1)
									lidlist.add(pid);
							} else if (m.group(8) != null) {
								Long pid = ItemCodeCrypt.getItemId(m.group(8));
								if (pid != -1)
									vid_str += "" + pid.toString();
							} else if (m.group(9) != null) {
								Long pid = ItemCodeCrypt.getItemId(m.group(9));
								if (pid != -1)
									lidlist.add(pid); // 节目、豆单
							} else if (m.group(10) != null) {
								Long pid = ItemCodeCrypt.getItemId(m.group(10));
								if (pid != -1)
									vid_str += "" + pid.toString();
							} else if (m.group(11) != null) {
								Long pid = ItemCodeCrypt.getItemId(m.group(11));
								if (pid != -1)
									aidlist.add(pid); // 节目、非豆单
							} else if (m.group(12) != null) {
								Long pid = ItemCodeCrypt.getItemId(m.group(12));
								if (pid != -1)
									vid_str += "" + pid.toString();
							} else if (m.group(13) != null) {
								Long pid = ItemCodeCrypt.getItemId(m.group(13));
								if (pid != -1)
									lidlist.add(pid); // 节目、豆单
							} else if (m.group(14) != null) {
								vid_str += "" + m.group(14);
							}
							System.out.print("tudou vid_str is: " + vid_str);
							//return vid_str;

						} catch (Exception e) {
							System.out.println("Failed to parse item url "
									+ m.group());
						}
						vid_str = vid_str + " ";

					}
				}
				System.out.println(" tudou vid_str is: " + vid_str);
				return vid_str;

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return "null exception";

	}

	public static Long stringToLong(String stringValue, long defaultValue) {
		Long intValue = defaultValue;
		if (stringValue != null) {
			try {
				intValue = Long.parseLong(stringValue);
			} catch (NumberFormatException ex) {
				intValue = defaultValue;
			}
		}
		return intValue;
	}

	String getAdBody(String pc_shortfull_y_ideaurl, String idea2_width,
			String idea2_height) {
		StringBuffer new_shortfull_ad_templet = new StringBuffer(
				"atm_player=document.getElementById('movie_player');atm_player_div=document.getElementById('player');atm_player_sidebar_div=document.getElementById('player_sidebar');atm_pip_pre_div=document.getElementById('ab_pip_pre');");
		new_shortfull_ad_templet
				.append("htmlCode='<object id=\\\"ad_5_crazy_object\\\" classid=\\\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\\\" style=\\\"position:absolute;left:0;top:0;z-index:-1;\\\" width=\\\"!width!px\\\" height=\\\"!height!px\\\" codebase=\\\"http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab\\\"><param name=\\\"movie\\\" value=\\\"!RES!?jsStart=execCrazyStart&jsEnd=execCrazyEnd&url=!u!\\\" /><param name=\\\"quality\\\" value=\\\"high\\\" /><param name=\\\"allowscriptaccess\\\" value=\\\"always\\\" /><param name=\\\"wmode\\\" value=\\\"transparent\\\" /><embed id=\\\"ad_5_crazy_embed\\\" src=\\\"!RES!?jsStart=execCrazyStart&jsEnd=execCrazyEnd&url=!u!\\\" quality=\\\"high\\\" width=\\\"!width!px\\\" height=\\\"!height!px\\\" align=\\\"middle\\\" play=\\\"true\\\" loop=\\\"false\\\" quality=\\\"high\\\" allowscriptaccess=\\\"always\\\" wmode=\\\"transparent\\\" type=\\\"application/x-shockwave-flash\\\" pluginspage=\\\"http://www.adobe.com/go/getflashplayer\\\"></embed></object>';");
		new_shortfull_ad_templet
				.append("function setInnerHTML(id,str){if(!atm_player||!atm_player_div||!atm_pip_pre_div){return;}createAd5CrazyDiv();}function execCrazyStart(){atm_player.style.width='0px';atm_player.style.height='0px';if(atm_player_sidebar_div){atm_player_sidebar_div.style.display='none';};var atm_player_status = atm_player.jsAdStart();if(typeof(atm_player_status)!='undefined'){if(atm_player_status && atm_player_status=='0'){execCrazyEnd();}}}function createAd5CrazyDiv(){var ad_5_crazy_div=document.createElement('div');if(ad_5_crazy_div){ad_5_crazy_div.setAttribute('id','ad_5_crazy_div');if(typeof(page_v5)!='undefined' && page_v5 && page_v5!=null && page_v5=='1'){atm_player_div=document.getElementById('playBox');ad_5_crazy_div.setAttribute('style','position:absolute;top:0;left:50%;margin-left:-465px;z-index:10000;');};atm_player_div.appendChild(ad_5_crazy_div);ad_5_crazy_div.innerHTML=htmlCode;}");
		new_shortfull_ad_templet
				.append("}function removeAd5CrazyDiv(){var ad_5_crazy_div=document.getElementById('ad_5_crazy_div');if(ad_5_crazy_div){ad_5_crazy_div.innerHTML='';ad_5_crazy_div.style.width='1px';ad_5_crazy_div.style.height='1px';ad_5_crazy_div.style.display='none';}}function execCrazyEnd(){removeAd5CrazyDiv();atm_player.style.width='';atm_player.style.height=''; if(typeof(atm_player_sidebar_div)!='undefined' && atm_player_sidebar_div&& atm_player_sidebar_div!=null){atm_player_sidebar_div.style.display='block'};");
		new_shortfull_ad_templet.append("atm_player.jsAdEnd();}");
		new_shortfull_ad_templet
				.append("function adOverTime(){execCrazyEnd();}");
		new_shortfull_ad_templet.append("setInnerHTML();");

		String new_shortfull_str_templete = new_shortfull_ad_templet.toString();
		new_shortfull_str_templete = new_shortfull_str_templete.replace(
				"!RES!", pc_shortfull_y_ideaurl);//flash
		new_shortfull_str_templete = new_shortfull_str_templete.replaceAll(
				"!width!", idea2_width);//flash width
		new_shortfull_str_templete = new_shortfull_str_templete.replaceAll(
				"!height!", idea2_height);//flash height
		new_shortfull_str_templete = new_shortfull_str_templete.replaceAll(
				"!u!", "!5s!");
		new_shortfull_str_templete = new_shortfull_str_templete.replaceAll(
				"!u-img!", "!5s-img!");

		return new_shortfull_str_templete;
	}%>
<%
	String os_type = request.getParameter("os_type");
	String ad_type = request.getParameter("ad_type");
	String cast_type = request.getParameter("cast_type");
	String ration_optimize_level = request
			.getParameter("ration_optimize_level");
	String ration_optimize_period = request
			.getParameter("ration_optimize_period");
	String ration_optimize_numlimit = request
			.getParameter("ration_optimize_numlimit");

	String all_area = request.getParameter("all_area");
	String[] chk_area = request.getParameterValues("chk_area");

	String all_channel = request.getParameter("all_channel");
	String[] chk_channel = request.getParameterValues("chk_channel");

	//定投贴片位置
	String[] v_position = request.getParameterValues("v_position");
	//定投zhongcha
	String[] vo_position = request.getParameterValues("vo_position");

	//atm2.0定量与优化（priority）
	String priority = request.getParameter("priority");
	String total_lun = request.getParameter("total_lun");
	//percent
	String percent = request.getParameter("percent");
	
	String all_os = request.getParameter("all_os");
	//pc_all_os
	String pc_all_os = request.getParameter("pc_all_os");
	String[] chk_os = request.getParameterValues("chk_os");
	//chk_os_pc
	String[] chk_os_pc = request.getParameterValues("chk_os_pc");
	String start_date = request.getParameter("startDateRow");
	String end_date = request.getParameter("endDateRow");
	String is_show_campaign = request.getParameter("is_show_campaign");
	String is_click_campaign = request
			.getParameter("is_click_campaign");
	String is_over_campaign = request.getParameter("is_over_campaign");
	String campaign_day_limit_show = request
			.getParameter("campaign_day_limit_show");
	String campaign_days_show = request
			.getParameter("campaign_days_show");
	//campaign_days_click
	String campaign_days_click = request
			.getParameter("campaign_days_click");
	String campaign_days_over = request
			.getParameter("campaign_days_over");

	//atm2.0_priority
	String is_show_priority = request.getParameter("is_show_priority");
    //add product_reservation_method
    String product_reserve_method = request.getParameter("product_reserve_method");
	String campaign_period_times = request
			.getParameter("campaign_period_times");
	String campaign_num_limit_show = request
			.getParameter("campaign_num_limit_show");
	int campaign_num_limit_show_int = Integer
			.parseInt(campaign_num_limit_show);
	
	String campaign_num_limit_click = request
			.getParameter("campaign_num_limit_click");
	int campaign_num_limit_click_int = Integer
			.parseInt(campaign_num_limit_click);
	String campaign_num_limit_over = request
			.getParameter("campaign_num_limit_over");
	int campaign_num_limit_over_int = Integer
			.parseInt(campaign_num_limit_over);
	String campaign_day_limit_click = request
			.getParameter("campaign_day_limit_click");
	String campaign_day_limit_over = request
			.getParameter("campaign_day_limit_over");
	
	String campaign_click_freq = request
			.getParameter("campaign_click_freq");
	String isVidLimit = request.getParameter("isVidLimit");
	String video_group_area1 = request
			.getParameter("video_group_area1");
	String video_group_area2 = request
			.getParameter("video_group_area2");
	//Millwardbrown(PC/移动web) 投放类型
	String millwardbrown_ad_type = request
			.getParameter("millwardbrown_ad_type");
	//Millwardbrown(PC/移动web)-优酷调研地址
	String youku_survey_url = request
			.getParameter("youku_survey_url");
	//Millwardbrown(PC/移动web)-土豆调研地址
	String tudou_survey_url = request
			.getParameter("tudou_survey_url");
	//Millwardbrown(APP) 投放类型：
	String millwardbrown_ad_type_APP = request
			.getParameter("millwardbrown_ad_type_APP");
	//Millwardbrown(APP)-调研曝光地址
	String survey_show_url_app = request
			.getParameter("survey_show_url_app");
	String survey_entry_text_app = request
			.getParameter("survey_entry_text_app");
	String survey_click_url_app = request
			.getParameter("survey_click_url_app");

	//各种地址
	String click_url = request.getParameter("click_url");
	//mb_app_clickToJumpUrl
	String mb_click = request.getParameter("mb_click");
	String over_url = request.getParameter("over_url");
	String over_url_time = request.getParameter("over_url_time");
	int outtime = 0;
	if(over_url_time != null){
		outtime = Integer.parseInt(over_url_time);	
	}
	
	String show_url = request.getParameter("show_url");
	String click_kh_url = request.getParameter("click_kh_url");
	String playing_url = request.getParameter("playing_url");
	String iso_url = request.getParameter("iso_url");
	String mt_url = request.getParameter("mt_url");

	String iso_click_url = request.getParameter("iso_click_url");

	String iso_h5_url = request.getParameter("iso_h5_url");
	String missdk = request.getParameter("m_issdk");
	int m_issdk = 0;
	if (missdk != null) {
		m_issdk = Integer.parseInt(missdk);
	}

	String msdk = request.getParameter("m_sdk");
	int m_sdk = 0;
	if (msdk != null) {
		m_sdk = Integer.parseInt(msdk);
	}

	String mztsdk = request.getParameter("m_ztsdk");
	int m_ztsdk = 0;
	if (mztsdk != null) {
		m_ztsdk = Integer.parseInt(mztsdk);
	}

	String mqtsdk = request.getParameter("m_qtsdk");
	int m_qtsdk = 0;
	if (mqtsdk != null) {
		m_qtsdk = Integer.parseInt(mqtsdk);
	}
	
	//是否定投位置
	String is_show_v_position = request.getParameter("is_show_v_position");
	
	//中插定投位置
	String is_show_vo_position = request.getParameter("is_show_vo_position");

	//新前贴
	String pc_vf_y_ideaurl = request.getParameter("pc_vf_y_ideaurl");
	
	//前贴pip小图
	String pc_vf_pipurl = request.getParameter("pc_vf_pipurl");
	//loader_type
	String loader_type = request.getParameter("loader_type");
	String loader_type_vob = request.getParameter("loader_type_vob");
	String loader_type_vb = request.getParameter("loader_type_vb");
	String loader_type_tp = request.getParameter("loader_type_tp");
	
	String pvimpression = request.getParameter("pvimpression");
	int pc_vf_impression = 0;
	if (pvimpression != null) {
		pc_vf_impression = Integer.parseInt(pvimpression);
	}
	
	
	String pvimpression_pc = request.getParameter("pvimpression_pc");
	int pc_vf_impression_pc = 0;
	if (pvimpression_pc != null) {
		pc_vf_impression_pc = Integer.parseInt(pvimpression_pc);
	}
	
	String pvimpression_pc_vob = request.getParameter("pvimpression_pc_vob");
	int pc_vob_impression_pc = 0;
	if (pvimpression_pc_vob != null) {
		pc_vob_impression_pc = Integer.parseInt(pvimpression_pc_vob);
	}
	
	String pvimpression_pc_vb = request.getParameter("pvimpression_pc_vb");
	int pc_vb_impression_pc = 0;
	if (pvimpression_pc_vb != null) {
		pc_vb_impression_pc = Integer.parseInt(pvimpression_pc_vb);
	}
	
	String pvimpression_pc_tp = request.getParameter("pvimpression_pc_tp");
	int pc_tp_impression_pc = 0;
	if (pvimpression_pc_tp != null) {
		pc_tp_impression_pc = Integer.parseInt(pvimpression_pc_tp);
	}

	//新暂停
	String pc_vp_y_ideaurl = request.getParameter("pc_vp_y_ideaurl");
	String pc_vp_y_full_ideaurl = request
			.getParameter("pc_vp_y_full_ideaurl");
	String pc_vp_t_ideaurl = request.getParameter("pc_vp_t_ideaurl");
	String pc_vp_t_full_ideaurl = request
			.getParameter("pc_vp_t_full_ideaurl");
	String pc_vp_ideacontrol = request
			.getParameter("pc_vp_ideacontrol");
	//新中插
	String pc_vob_ideaurl = request.getParameter("pc_vob_ideaurl");
	String pc_vob_pipurl = request.getParameter("pc_vob_pipurl");
	//新后贴
	String pc_vb_ideaurl = request.getParameter("pc_vb_ideaurl");
	//新crazy
	String pc_crazy_y_js = request.getParameter("pc_crazy_y_js");

	String pc_crazy_t_ideaurl = request
			.getParameter("pc_crazy_t_ideaurl");
	//新AD selector
	String pc_selector_y_js = request.getParameter("pc_selector_y_js");
	String pc_selector_t_ideaurl = request
			.getParameter("pc_selector_t_ideaurl");
	//新短视频全屏
	String pc_shortfull_y_ideaurl = request
			.getParameter("pc_shortfull_y_ideaurl");
	String pc_shortfull_t_ideaurl = request
			.getParameter("pc_shortfull_t_ideaurl");
	//新角标
	String pc_vc_y_ideaurl = request.getParameter("pc_vc_y_ideaurl");
	String pc_vc_y_rightpx2 = request.getParameter("pc_vc_y_rightpx2");
	String pc_vc_t_ideaurl = request.getParameter("pc_vc_t_ideaurl");
	String pc_vc_t_rightpx2 = request.getParameter("pc_vc_t_rightpx2");
	String pc_vc_position = request.getParameter("pc_vc_position");
	String pc_vc_tiepian_pos = request.getParameter("vc_time_spot");
	String pc_vc_showtime = request.getParameter("pc_vc_showtime");
	//移动前贴
	String m_vf_ideaurl = request.getParameter("m_vf_ideaurl");
	//h5贴片_phone
	String m_h5_vf_ideaurl_phone = request.getParameter("m_h5_vf_ideaurl_phone");
	//h5贴片_pad
	String m_h5_vf_ideaurl_pad = request.getParameter("m_h5_vf_ideaurl_pad");
	//移动后贴
	String m_vb_ideaurl = request.getParameter("m_vb_ideaurl");
	//移动暂停
	String m_vp_ideaurl = request.getParameter("m_vp_ideaurl");
	//移动角标
	String m_vc_openstatus_pageurl = request
			.getParameter("m_vc_openstatus_pageurl");
	String m_vc_closestatus_pageurl = request
			.getParameter("m_vc_closestatus_pageurl");
	//移动开机图
	String m_mi_ipad_ideaurl_768 = request
			.getParameter("m_mi_ipad_ideaurl_768");
	String m_mi_ipad_ideaurl_1004 = request
			.getParameter("m_mi_ipad_ideaurl_1004");
	String m_mi_iphone_ideaurl_940 = request
			.getParameter("m_mi_iphone_ideaurl_940");
	String m_mi_iphone_ideaurl_1116 = request
			.getParameter("m_mi_iphone_ideaurl_1116");
	//m_mi_iphone_ideaurl_1334,m_mi_iphone_ideaurl_1920
	String m_mi_iphone_ideaurl_1334 = request
			.getParameter("m_mi_iphone_ideaurl_1334");
	String m_mi_iphone_ideaurl_1920 = request
			.getParameter("m_mi_iphone_ideaurl_1920");
	String m_mi_apad_ideaurl_800 = request
			.getParameter("m_mi_apad_ideaurl_800");
	String m_mi_apad_ideaurl_600 = request
			.getParameter("m_mi_apad_ideaurl_600");
	//m_mi_apad_ideaurl_768
	String m_mi_apad_ideaurl_768 = request
			.getParameter("m_mi_apad_ideaurl_768");
	String m_mi_aphone_ideaurl_1280 = request
			.getParameter("m_mi_aphone_ideaurl_1280");
	String m_mi_aphone_ideaurl_800 = request
			.getParameter("m_mi_aphone_ideaurl_800");
	String m_mi_atv_ideaurl_720 = request
			.getParameter("m_mi_atv_ideaurl_720");
	//iku_kaijitu
	//m_iku_pc_ideaurl_650,m_iku_pc_ideaurl_720,
	String m_iku_pc_ideaurl_650 = request
			.getParameter("m_iku_pc_ideaurl_650");
	String m_iku_pc_ideaurl_720 = request
			.getParameter("m_iku_pc_ideaurl_720");
	//移动全屏
	String m_mqp_ipad_ideaurl_748 = request
			.getParameter("m_mqp_ipad_ideaurl_748");
	String m_mqp_iphone_ideaurl_480 = request
			.getParameter("m_mqp_iphone_ideaurl_480");
	String m_mqp_androidpad_ideaurl_720 = request
			.getParameter("m_mqp_androidpad_ideaurl_720");
	String m_mqp_androidphone_ideaurl_480 = request
			.getParameter("m_mqp_androidphone_ideaurl_480");
	String m_quanping_showtime = request
			.getParameter("m_quanping_showtime");

	String m_mo_ideaurl = request.getParameter("m_mo_ideaurl");
	
	//PC_TIEPIAN
	String pc_tp_ideaurl = request
			.getParameter("pc_tp_ideaurl");
	//MB_TIEPIAN
	String m_vtp_ideaurl = request
			.getParameter("m_vtp_ideaurl");
    
	//campaign_show
	String campaignList_show = request.getParameter("campaignList_show");
	//campaign_show_name
	String campaign_show_name = request.getParameter("campaign_show_name");
	String startDateRow_show = request.getParameter("startDateRow_show");
	String endDateRow_show = request.getParameter("endDateRow_show");
	String campaign_sequence_show = request.getParameter("campaign_sequence_show");
	
	//campaign_click
	String campaignList_click = request.getParameter("campaignList_click");
	//campaign_click_name
	String campaign_click_name = request.getParameter("campaign_click_name");
	String startDateRow_click = request.getParameter("startDateRow_click");
	String endDateRow_click = request.getParameter("endDateRow_click");
	String campaign_sequence_click = request.getParameter("campaign_sequence_click");
	
	String campaignList_over = request.getParameter("campaignList_over");
	String campaign_over_name = request.getParameter("campaign_over_name");
	String startDateRow_over = request.getParameter("startDateRow_over");
	String endDateRow_over = request.getParameter("endDateRow_over");
	String campaign_sequence_over = request.getParameter("campaign_sequence_over");
	
	//trueview_camp_skip
	String is_skip_campaign = request.getParameter("is_skip_campaign");
	String campaign_days_skip = request
			.getParameter("campaign_days_skip");
	String campaign_num_limit_skip = request
			.getParameter("campaign_num_limit_skip");
	int campaign_num_limit_skip_int = Integer
			.parseInt(campaign_num_limit_skip);
	String campaign_day_limit_skip = request
			.getParameter("campaign_day_limit_skip");
	String campaignList_skip = request.getParameter("campaignList_skip");
	String campaign_skip_name = request.getParameter("campaign_skip_name");
	String startDateRow_skip = request.getParameter("startDateRow_skip");
	String endDateRow_skip = request.getParameter("endDateRow_skip");
	String campaign_sequence_skip = request.getParameter("campaign_sequence_skip");
	
	//preload_camp_show
	String is_preload_campaign = request.getParameter("is_preload_campaign");
	String campaign_days_preload = request
			.getParameter("campaign_days_preload");
	String campaign_num_limit_preload = request
			.getParameter("campaign_num_limit_preload");
	int campaign_num_limit_preload_int = Integer
			.parseInt(campaign_num_limit_preload);
	String campaign_day_limit_preload = request
			.getParameter("campaign_day_limit_preload");
	String campaignList_preload = request.getParameter("campaignList_preload");
	String campaign_preload_name = request.getParameter("campaign_preload_name");
	String startDateRow_preload = request.getParameter("startDateRow_preload");
	String endDateRow_preload = request.getParameter("endDateRow_preload");
	String campaign_sequence_preload = request.getParameter("campaign_sequence_preload");
	
	//素材清晰度
	//String idea_url_resolution = request.getParameter("usehd");
	//int usehd = Integer.parseInt(idea_url_resolution);
	
	//清晰度设置_new
	String[] resolution_hd2 = request.getParameterValues("resolution_hd2");
	String[] resolution_mp4 = request.getParameterValues("resolution_mp4");
	String[] resolution_flv = request.getParameterValues("resolution_flv");
	
	//trueview
	String customtext_url = request.getParameter("customtext_url");
	String clientcustomclick_url = request.getParameter("clientcustomclick_url");
	String clientskip_url = request.getParameter("clientskip_url");
	System.out.println("客户提供的跳过监测地址:" + clientskip_url);
	String clientfee_url = request.getParameter("clientfee_url");
	String othercustomtextclick_url = request.getParameter("othercustomtextclick_url");
	String otherskip_url = request.getParameter("otherskip_url");
	String otherfeep_url = request.getParameter("otherfeep_url");
	//custom_text
	String custom_text = request.getParameter("custom_text");
	
	//ies_monitor(admaster.com)
	String ies_monitor = request.getParameter("ies_monitor");
	
	//is_bark
	String isCast_bark = request.getParameter("isCast_bark");
	
	//pc_vf_loader_showtime,pc_vob_loader_showtime,pc_vb_loader_showtime,pc_tp_loader_showtime
	String pc_vf_loader_showtime = request.getParameter("pc_vf_loader_showtime");
	String pc_vob_loader_showtime = request.getParameter("pc_vob_loader_showtime");
	String pc_vb_loader_showtime = request.getParameter("pc_vb_loader_showtime");
	String pc_tp_loader_showtime = request.getParameter("pc_tp_loader_showtime");
	
	//pc_selector_youkutudou_length,pc_crazy_youkutudou_length,pc_shortfull_youkutudou_length,pc_shortfull_youkutudou_width,pc_shortfull_youkutudou_height
	String pc_selector_youkutudou_length = request.getParameter("pc_selector_youkutudou_length");
	String pc_crazy_youkutudou_length = request.getParameter("pc_crazy_youkutudou_length");
	String pc_shortfull_youkutudou_length = request.getParameter("pc_shortfull_youkutudou_length");
	String pc_shortfull_youkutudou_width = request.getParameter("pc_shortfull_youkutudou_width");
	String pc_shortfull_youkutudou_height = request.getParameter("pc_shortfull_youkutudou_height");
	
	//pc_vc_width,pc_vc_height,pc_vc_close_method
	String pc_vc_width = request.getParameter("pc_vc_width");
	String pc_vc_height = request.getParameter("pc_vc_height");
	String pc_vc_close_method = request.getParameter("pc_vc_close_method");
	//chargingthreshold_text
	String chargingthreshold_text = request.getParameter("chargingthreshold_text");
	
	//parameter_values
	String parameter_values = request.getParameter("parameter_values");
    //parameter_names
    String parameter_names = request.getParameter("parameter_names");
    //isVidParameter
    String isVidParameter = request.getParameter("isVidParameter");
    //m_mhtml_text_content;m_mhtml_clickurl
    String m_mhtml_text_content = request.getParameter("m_mhtml_text_content");
    String m_mhtml_clickurl = request.getParameter("m_mhtml_clickurl");
    
    //mhtml_app_search_banner
    String app_search_banner_type = request.getParameter("app_search_banner_type");
    
    String app_search_banner_youkupip_url = request.getParameter("app_search_banner_youkupip_url");
    String app_search_banner_youkupip_clickurl = request.getParameter("app_search_banner_youkupip_clickurl");
    String app_search_banner_youkupip_showurl = request.getParameter("app_search_banner_youkupip_showurl");
    String app_search_banner_tudoupip_url = request.getParameter("app_search_banner_tudoupip_url");
    String app_search_banner_tudoupip_clickurl = request.getParameter("app_search_banner_tudoupip_clickurl");
    String app_search_banner_tudoupip_showurl = request.getParameter("app_search_banner_tudoupip_showurl");
    
    
	int ad_type_id = Integer.parseInt(ad_type);
	int cast_id = insertCast(ad_type_id, start_date, end_date,
			all_area, chk_area, all_channel, chk_channel, v_position,vo_position,
			priority, total_lun,percent,all_os,pc_all_os, chk_os, chk_os_pc,isVidLimit, video_group_area1,
			video_group_area2, cast_type, pc_vc_tiepian_pos,
			is_show_campaign, is_click_campaign, is_over_campaign,
			campaign_num_limit_show_int, campaign_day_limit_show,campaign_days_show,campaign_days_click,campaign_days_over,
			campaign_num_limit_click_int, campaign_day_limit_click,
			campaign_num_limit_over_int, campaign_day_limit_over,is_skip_campaign,campaign_days_skip,campaign_num_limit_skip_int,campaign_day_limit_skip,
			campaignList_skip,campaign_skip_name,startDateRow_skip,endDateRow_skip,campaign_sequence_skip,
			is_preload_campaign,campaign_days_preload,campaign_num_limit_preload_int,campaign_day_limit_preload,
			campaignList_preload,campaign_preload_name,startDateRow_preload,endDateRow_preload,campaign_sequence_preload,
			is_show_priority, product_reserve_method,pc_vf_impression, pc_vf_impression_pc,pc_vob_impression_pc,pc_vb_impression_pc,pc_tp_impression_pc,m_ztsdk,
			m_sdk,resolution_hd2,resolution_mp4,resolution_flv,
			campaignList_show,campaign_show_name,startDateRow_show,endDateRow_show,campaign_sequence_show,
			campaignList_click,campaign_click_name,startDateRow_click,endDateRow_click,campaign_sequence_click,
			campaignList_over,campaign_over_name,startDateRow_over,endDateRow_over,campaign_sequence_over,is_show_v_position,is_show_vo_position,isCast_bark,parameter_values,parameter_names,isVidParameter);
	int idea_id = insertIdea(ad_type_id, cast_id, ad_type_id,
			is_show_campaign, campaign_period_times,
			campaign_click_freq, millwardbrown_ad_type,
			youku_survey_url, tudou_survey_url,
			millwardbrown_ad_type_APP,survey_show_url_app,
			survey_entry_text_app, survey_click_url_app,
			click_url, mb_click, over_url, outtime, show_url,
			click_kh_url,playing_url, iso_url, mt_url, iso_click_url, iso_h5_url,
			m_issdk, m_sdk, m_ztsdk, m_qtsdk, pc_vf_y_ideaurl,
			pc_vf_pipurl,loader_type, loader_type_vob,loader_type_vb,loader_type_tp,pc_vf_impression, pc_vf_impression_pc,pc_vob_impression_pc,pc_vb_impression_pc,pc_tp_impression_pc,pc_vp_y_ideaurl,
			pc_vp_y_full_ideaurl, pc_vp_t_ideaurl,
			pc_vp_t_full_ideaurl, pc_vp_ideacontrol, pc_vob_ideaurl,
			pc_vob_pipurl, pc_vb_ideaurl, pc_crazy_y_js,
			pc_crazy_t_ideaurl, pc_selector_y_js,
			pc_selector_t_ideaurl, pc_shortfull_y_ideaurl,
			pc_shortfull_t_ideaurl, pc_vc_y_ideaurl, pc_vc_y_rightpx2,
			pc_vc_t_ideaurl, pc_vc_t_rightpx2, pc_vc_position,
			pc_vc_showtime, m_vf_ideaurl, m_h5_vf_ideaurl_phone,m_h5_vf_ideaurl_pad,
			m_vb_ideaurl, m_vp_ideaurl, m_vc_openstatus_pageurl,
			m_vc_closestatus_pageurl, m_mi_ipad_ideaurl_768,
			m_mi_ipad_ideaurl_1004, m_mi_iphone_ideaurl_940,
			m_mi_iphone_ideaurl_1116, m_mi_iphone_ideaurl_1334,
			m_mi_iphone_ideaurl_1920, m_mi_apad_ideaurl_800,
			m_mi_apad_ideaurl_600, m_mi_apad_ideaurl_768, m_mi_aphone_ideaurl_1280,
			m_mi_aphone_ideaurl_800, m_mi_atv_ideaurl_720,m_iku_pc_ideaurl_650,m_iku_pc_ideaurl_720,
			m_mqp_ipad_ideaurl_748, m_mqp_iphone_ideaurl_480,
			m_mqp_androidpad_ideaurl_720,
			m_mqp_androidphone_ideaurl_480, m_quanping_showtime,
			m_mo_ideaurl, cast_type, ration_optimize_level,
			ration_optimize_period, ration_optimize_numlimit,
			is_show_priority,product_reserve_method,chk_os,resolution_hd2,resolution_mp4,resolution_flv,pc_tp_ideaurl,m_vtp_ideaurl,ies_monitor,
			customtext_url,clientcustomclick_url,clientskip_url,clientfee_url,othercustomtextclick_url,otherskip_url,otherfeep_url,custom_text,
			pc_vf_loader_showtime,pc_vob_loader_showtime,pc_vb_loader_showtime,pc_tp_loader_showtime,
			pc_selector_youkutudou_length,pc_crazy_youkutudou_length,pc_shortfull_youkutudou_length,pc_shortfull_youkutudou_width,pc_shortfull_youkutudou_height,
			pc_vc_width,pc_vc_height,pc_vc_close_method,chargingthreshold_text,m_mhtml_text_content,m_mhtml_clickurl,
			app_search_banner_type,app_search_banner_youkupip_url,app_search_banner_youkupip_clickurl,app_search_banner_youkupip_showurl,app_search_banner_tudoupip_url,app_search_banner_tudoupip_clickurl,app_search_banner_tudoupip_showurl);


	//	out.println(getAdTypeName(ad_type_id) + "类型：投放id=" + cast_id);
	//	out.println("<a href='ad.jsp'>返回</a>");
	out.println(getAdTypeName(ad_type_id) + "类型：投放id=" + cast_id
			+ ", 素材id=" + idea_id);
	out.println("<a href='ad.jsp'>返回</a>");
%>