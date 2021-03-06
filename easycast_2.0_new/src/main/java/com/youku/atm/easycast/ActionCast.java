package com.youku.atm.easycast;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;
//import com.tudou.itemcodecrypt.ItemCodeCrypt;
import com.youku.atm.busmodule.utils.LogUtil;
import com.youku.atm.easycast.GifDecoder.GifImage;
import com.youku.atm.om.AdCast;
import com.youku.atm.om.AdCastPeer;
import com.youku.atm.om.AdOrder;
import com.youku.atm.om.AdOrderPeer;
import com.youku.atm.om.AdPosition;
import com.youku.atm.om.AdType;
import com.youku.atm.om.Area;
import com.youku.atm.om.Campaign;
import com.youku.atm.om.CastArea;
import com.youku.atm.om.CastCampaign;
import com.youku.atm.om.CastChannel;
import com.youku.atm.om.CastCpm;
import com.youku.atm.om.CastDirection;
import com.youku.atm.om.CastDq;
import com.youku.atm.om.CastEmbed;
import com.youku.atm.om.CastHposition;
import com.youku.atm.om.CastIdea;
import com.youku.atm.om.CastKey;
import com.youku.atm.om.CastPaid;
import com.youku.atm.om.CastPartnerid;
import com.youku.atm.om.CastPlatform;
import com.youku.atm.om.CastPosition;
import com.youku.atm.om.CastPrd;
import com.youku.atm.om.CastTag;
import com.youku.atm.om.CastUser;
import com.youku.atm.om.CastVideogroup;
import com.youku.atm.om.Channel;
import com.youku.atm.om.Dc;
import com.youku.atm.om.HPosition;
import com.youku.atm.om.HcastCpm;
import com.youku.atm.om.HideaCpm;
import com.youku.atm.om.HideaTime;
import com.youku.atm.om.Idea;
import com.youku.atm.om.IdeaCpm;
import com.youku.atm.om.IdeaMonitor;
import com.youku.atm.om.IdeaSurvey;
import com.youku.atm.om.IdeaThumbnail;
import com.youku.atm.om.IdeaTime;
import com.youku.atm.om.IdeaUrl;
import com.youku.atm.om.ProtectAd;
import com.youku.atm.om.SdkConfig;
import com.youku.atm.om.VPosition;
import com.youku.atm.om.VhcastCpm;
import com.youku.atm.om.VhideaCpm;
import com.youku.atm.om.VhideaTime;
import com.youku.atm.om.VideoGroupList;
/**
 * jsp->servlet
 * 
 * @date 2016???12???05???
 * @author Gary
 */
//@Controller
//@RequestMapping("/manager/")
public class ActionCast extends AbstractAdServlet {
	private static final long serialVersionUID = 8251193706749635L;
	final int NEW_ADSELECTOR = 169; //???ADSelector
	final int NEW_SPECIALAD = 168; //??????????????????????????????
	final int NEW_SHORTFULL = 167; //??????????????????
	final int NEW_ZANZHUBB = 166; //???????????????
	final int NEW_JIAOBIAO = 165; //?????????
	final int NEW_ZANTING = 164; //?????????
	final int NEW_ZHONGCHA = 163; //?????????
	final int NEW_TIEPIAN = 162; //?????????
	final int NEW_HOUTIE = 161; //?????????
	final int NEW_QIANTIE = 160; //?????????
	final int NEW_KAIJITU = 175; //????????????
	final int NEW_BUYINGSEEING = 170; //????????????
	final int NEW_JUCHANGBIAOBAN = 171; //????????????
	final int NEW_OVERLAY_FLOAT = 205; //???????????????
	final int MB_JUCHANGBIAOBAN = 81; //??????????????????
	final int NEW_FACEOFF = 172; //????????????
	final int MB_FACEOFF = 82; //??????????????????	
	final int IMPRESSION = 1; //????????????
	//??????
	final int MB_QIANTIE = 70; //????????????
	final int MB_HOUTIE = 71; //????????????
	final int MB_TIEPIAN = 72; //????????????
	final int MB_ZANTING = 73; //????????????
	final int MB_JIAOBIAO = 74; //????????????
	final int MB_KAIJITU = 75; //???????????????
	final int MB_QUANPING = 76; //????????????
	final int MB_ZHONGCHA = 80; //????????????
	final int MB_ISP = 173; //???????????????
	final int MB_FEED = 174; //Feed????????????
	final int OTT_DISPLAY = 200; //OTT?????????????????????(??????)
	final int OTT_POWEROFF = 201; //OTT????????????
	final int OTT_SCREENSAVER = 202; //OTT????????????
	final int OTT_DIS_REC = 203; //OTT????????????
	final int YOUKU_FEEDAD = 204; //???????????????
	final int MB_scenario = 83; //?????????????????????
	final int MB_OVERLAY_FLOAT = 84; //??????????????????????????????
	final int MB_FOCUS_CIRCLE = 85; //????????????????????????	
	final int MB_WENZILIAN = 3; //mhtml(?????????)
	final int MB_APPSEARCHBANNER = 4; //mhtml(app?????????banner)
	final int MB_APP_PLAYING_BANNER = 5; //mVhtml(app?????????banner)
	//MB_APP_HOMEPAGE
	final int MB_APP_HOMEPAGE = 61; //mhtml(MB_APP_HOMEPAGE)	
	final int MB_BF = 206; //mb???????????????
	final int PC_BF = 207; //pc???????????????
	final int PC_FEEDS = 6; //pc????????????
	
	
	//vhtml
	final int yk_vhtml_banner = 1; //youku_???????????????PIP???????????????????????????
	final int yk_vhtml_right_relative_banner = 61204; //youku_???????????????????????????banner ???????????????	-??????-PC_??????_WEB-????????????-BANNER-?????????????????????-???????????????
	//cause "final int MB_WENZILIAN = 3; //mhtml(?????????)"?????????so,choose "16"
	final int yk_vhtml_banner1 = 61201; //youku_???????????????banner1???????????????	- ??????-PC_??????_WEB-????????????-BANNER-?????????????????????-??????\"?????????\"???banner
	//?????????final int MB_APPSEARCHBANNER = 4; //mhtml(app?????????banner)
	final int yk_vhtml_righttop = 19; //youku_?????????????????????PIP???UGC???
	final int yk_vhtml_comments = 61202; //youku_???????????????????????????????????????-?????????-??????-PC_??????_WEB-????????????-??????-?????????????????????-????????????
	final int yk_vhtml_RTB = 61203; //youku_????????????????????????????????????RTB?????????-??????-PC_??????_WEB-????????????-??????-?????????????????????-????????????
	final int yk_vhtml_survey = 9; //youku_???????????????-????????? ????????????
	final int yk_vhtml_mb_web = 10; //youku_??????web ?????????
	final int tudou_vhtml_banner1 = 11; //tudou_???????????????banner1
	final int tudou_vhtml_UGC_banner = 12; //tudou_UGC?????????banner (300*250)
	final int tudou_vhtml_righttop = 13; //tudou_???????????????-??????????????????????????????banner
	final int tudou_vhtml_rightcenter = 14; //tudou_???????????????-???????????????????????? PIP
	final int tudou_vhtml_rightdown = 15; //tudou_???????????????-???????????????????????? PIP
	final int tudou_vhtml_commentDown = 16; //tudou_???????????????-?????????????????????????????????
	final int tudou_vhtml_survey = 17; //tudou_???????????????-????????????		
	//????????????_promoted_video_ads
	final int promoted_video_ads_1430192600 = 1430192600; //????????????_promoted_video_ads(1430192600)
	final int promoted_video_ads_1430192617 = 1430192617; //????????????_promoted_video_ads(1430192617)	
	//m???????????????
	final int m_playing_youku_phone_web_1425020640 = 1425020640; //youku_??????phone-web???_?????????banner
	final int m_playing_youku_ipad_web_1427883541 = 1427883541; //youku_??????ipad-web???_?????????banner
	final int m_homepage_banner_web = 20;	
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected static final Log logger = LogUtil.getLog();
	//@Override
	//@RequestMapping("action.do")
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String remote_ip = request.getRemoteAddr();
		String os_type = request.getParameter("os_type");
		String ad_type = request.getParameter("ad_type");
		String cast_type = request.getParameter("cast_type");

		String all_area = request.getParameter("all_area");
		String[] chk_area = request.getParameterValues("chk_area");
		String all_channel = request.getParameter("all_channel");
		String[] chk_channel = request.getParameterValues("chk_channel");
		//??????????????????
		String[] v_position = request.getParameterValues("v_position");
		//??????zhongcha
		String[] vo_position = request.getParameterValues("vo_position");
	    //????????????
	    String[] jiaobiao_position = request.getParameterValues("jiaobiao_position");
		//atm2.0??????????????????priority???
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
		String is_click_campaign = request.getParameter("is_click_campaign");
		String is_over_campaign = request.getParameter("is_over_campaign");
		String campaign_day_limit_show = request.getParameter("campaign_day_limit_show");
		String campaign_days_show = request.getParameter("campaign_days_show");
		//campaign_days_click
		String campaign_days_click = request.getParameter("campaign_days_click");
		String campaign_days_over = request.getParameter("campaign_days_over");
		//atm2.0_priority
		String is_show_priority = request.getParameter("is_show_priority");
	    //add product_reservation_method
	    String product_reserve_method = request.getParameter("product_reserve_method");
		String campaign_period_times = request.getParameter("campaign_period_times");
		String campaign_num_limit_show = request.getParameter("campaign_num_limit_show");
		int campaign_num_limit_show_int = Integer.parseInt(campaign_num_limit_show);		
		String campaign_num_limit_click = request.getParameter("campaign_num_limit_click");
		int campaign_num_limit_click_int = Integer.parseInt(campaign_num_limit_click);
		String campaign_num_limit_over = request.getParameter("campaign_num_limit_over");
		int campaign_num_limit_over_int = Integer.parseInt(campaign_num_limit_over);
		String campaign_day_limit_click = request.getParameter("campaign_day_limit_click");
		String campaign_day_limit_over = request.getParameter("campaign_day_limit_over");	
		String campaign_click_freq = request.getParameter("campaign_click_freq");
		String isVidLimit = request.getParameter("isVidLimit");
		String video_group_area1 = request.getParameter("video_group_area1");
		String video_group_area2 = request.getParameter("video_group_area2");
		String video_group_area3 = request.getParameter("video_group_area3");
		String video_group_area4 = request.getParameter("video_group_area4");
		//yks????????????id(??????s)
		String video_group_area5 = request.getParameter("video_group_area5");
		
		//Millwardbrown(PC/??????web) ????????????
		String millwardbrown_ad_type = request.getParameter("millwardbrown_ad_type");
		//Millwardbrown(PC/??????web)-??????????????????
		String youku_survey_url = request.getParameter("youku_survey_url");
		//Millwardbrown(PC/??????web)-??????????????????
		String tudou_survey_url = request.getParameter("tudou_survey_url");
		//Millwardbrown(APP) ???????????????
		String millwardbrown_ad_type_APP = request.getParameter("millwardbrown_ad_type_APP");
		//Millwardbrown(APP)-??????????????????
		String survey_show_url_app = request.getParameter("survey_show_url_app");
		String survey_entry_text_app = request.getParameter("survey_entry_text_app");
		String survey_click_url_app = request.getParameter("survey_click_url_app");
		//????????????
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
		//??????????????????
		String is_show_v_position = request.getParameter("is_show_v_position");		
		//??????????????????
		String is_show_vo_position = request.getParameter("is_show_vo_position");		
		//??????????????????
		String is_show_jiaobiao_position = request.getParameter("is_show_jiaobiao_position");		
		//?????????
		String pc_vf_y_ideaurl = request.getParameter("pc_vf_y_ideaurl");	
		//??????pip??????
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
		//pvimpression_mb
		String pvimpression_mb = request.getParameter("pvimpression_mb");
		int m_vb_impression = 0;
		if (pvimpression_mb != null) {
			m_vb_impression = Integer.parseInt(pvimpression_mb);
		}	
		String pvimpression_mo = request.getParameter("pvimpression_mo");
		int m_vo_impression = 0;
		if (pvimpression_mo != null) {
			m_vo_impression = Integer.parseInt(pvimpression_mo);
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
		//?????????
		String pc_vp_y_ideaurl = request.getParameter("pc_vp_y_ideaurl");
		String pc_vp_y_full_ideaurl = request.getParameter("pc_vp_y_full_ideaurl");
		String pc_vp_t_ideaurl = request.getParameter("pc_vp_t_ideaurl");
		String pc_vp_t_full_ideaurl = request.getParameter("pc_vp_t_full_ideaurl");
		String pc_vp_ideacontrol = request.getParameter("pc_vp_ideacontrol");
		//pc_vp_y_ideaurl
		String pc_vp_y_ideaurl_h5 = request.getParameter("pc_vp_y_ideaurl_h5");
		String pc_vp_y_full_ideaurl_h5 = request.getParameter("pc_vp_y_full_ideaurl_h5");	
		//?????????
		String pc_vob_ideaurl = request.getParameter("pc_vob_ideaurl");
		String pc_vob_pipurl = request.getParameter("pc_vob_pipurl");
		//?????????
		String pc_vb_ideaurl = request.getParameter("pc_vb_ideaurl");
		//???crazy
		//String pc_crazy_y_js = request.getParameter("pc_crazy_y_js");
		//String pc_crazy_t_ideaurl = request.getParameter("pc_crazy_t_ideaurl");
		//???AD selector
		//String pc_selector_y_js = request.getParameter("pc_selector_y_js");
		//String pc_selector_t_ideaurl = request.getParameter("pc_selector_t_ideaurl");
		//??????????????????
		//String pc_shortfull_y_ideaurl = request.getParameter("pc_shortfull_y_ideaurl");
		//String pc_shortfull_t_ideaurl = request.getParameter("pc_shortfull_t_ideaurl");
		//?????????
		String pc_vc_y_ideaurl = request.getParameter("pc_vc_y_ideaurl");
		//pc_vc_y_ideaurl_img
		String pc_vc_y_ideaurl_img = request.getParameter("pc_vc_y_ideaurl_img");
		String pc_vc_y_ideaurl_h5 = request.getParameter("pc_vc_y_ideaurl_h5");
		String pc_vc_y_rightpx2 = request.getParameter("pc_vc_y_rightpx2");
		String pc_vc_t_ideaurl = request.getParameter("pc_vc_t_ideaurl");
		String pc_vc_t_rightpx2 = request.getParameter("pc_vc_t_rightpx2");
		String pc_vc_position = request.getParameter("pc_vc_position");
		String pc_vc_tiepian_pos = request.getParameter("vc_time_spot");
		String pc_vc_showtime = request.getParameter("pc_vc_showtime");
		//????????????
		String m_vf_ideaurl = request.getParameter("m_vf_ideaurl");
		//h5??????_phone
		String m_h5_vf_ideaurl_phone = request.getParameter("m_h5_vf_ideaurl_phone");
		//h5??????_pad
		String m_h5_vf_ideaurl_pad = request.getParameter("m_h5_vf_ideaurl_pad");		
		//m_h5_vb_ideaurl_phone,m_h5_vb_ideaurl_pad
		String m_h5_vb_ideaurl_phone = request.getParameter("m_h5_vb_ideaurl_phone");
		String m_h5_vb_ideaurl_pad = request.getParameter("m_h5_vb_ideaurl_pad");	
		String m_h5_vo_ideaurl_phone = request.getParameter("m_h5_vo_ideaurl_phone");
		String m_h5_vo_ideaurl_pad = request.getParameter("m_h5_vo_ideaurl_pad");	
		//????????????
		String m_vb_ideaurl = request.getParameter("m_vb_ideaurl");
		//????????????
		String m_vp_ideaurl = request.getParameter("m_vp_ideaurl");
		//OTT??????
		String m_vp_ott_ideaurl = request.getParameter("m_vp_ott_ideaurl");
		//????????????
		String m_vc_openstatus_pageurl = request.getParameter("m_vc_openstatus_pageurl");
		String m_vc_closestatus_pageurl = request.getParameter("m_vc_closestatus_pageurl");
		//???????????????
		String m_mi_ipad_ideaurl_768 = request.getParameter("m_mi_ipad_ideaurl_768");
		String m_mi_ipad_ideaurl_1004 = request.getParameter("m_mi_ipad_ideaurl_1004");
		String m_mi_iphone_ideaurl_940 = request.getParameter("m_mi_iphone_ideaurl_940");
		String m_mi_iphone_ideaurl_1116 = request.getParameter("m_mi_iphone_ideaurl_1116");
		//m_mi_iphone_ideaurl_1334,m_mi_iphone_ideaurl_1920
		String m_mi_iphone_ideaurl_1334 = request.getParameter("m_mi_iphone_ideaurl_1334");
		String m_mi_iphone_ideaurl_1920 = request.getParameter("m_mi_iphone_ideaurl_1920");	
		String m_mi_iphone_ideaurl_xiami = request.getParameter("m_mi_iphone_ideaurl_xiami");
		String m_mi_aphone_ideaurl_xiami = request.getParameter("m_mi_aphone_ideaurl_xiami");	
		String m_mi_apad_ideaurl_800 = request.getParameter("m_mi_apad_ideaurl_800");
		String m_mi_apad_ideaurl_600 = request.getParameter("m_mi_apad_ideaurl_600");
		//m_mi_apad_ideaurl_768
		String m_mi_apad_ideaurl_768 = request.getParameter("m_mi_apad_ideaurl_768");
		String m_mi_aphone_ideaurl_1280 = request.getParameter("m_mi_aphone_ideaurl_1280");
		String m_mi_aphone_ideaurl_800 = request.getParameter("m_mi_aphone_ideaurl_800");
		String m_mi_atv_ideaurl_720 = request.getParameter("m_mi_atv_ideaurl_720");
	    //m_mi_iphonex_ideaurl_1125
	    String m_mi_iphonex_ideaurl_1125 = request.getParameter("m_mi_iphonex_ideaurl_1125");
		//iku_kaijitu
		//m_iku_pc_ideaurl_650,m_iku_pc_ideaurl_720,
		String m_iku_pc_ideaurl_650 = request.getParameter("m_iku_pc_ideaurl_650");
		String m_iku_pc_ideaurl_720 = request.getParameter("m_iku_pc_ideaurl_720");
		//????????????
		String m_mqp_ipad_ideaurl_748 = request.getParameter("m_mqp_ipad_ideaurl_748");
		String m_mqp_iphone_ideaurl_480 = request.getParameter("m_mqp_iphone_ideaurl_480");
		String m_mqp_androidpad_ideaurl_720 = request.getParameter("m_mqp_androidpad_ideaurl_720");
		String m_mqp_androidphone_ideaurl_480 = request.getParameter("m_mqp_androidphone_ideaurl_480");
		String m_quanping_showtime = request.getParameter("m_quanping_showtime");
		String m_mo_ideaurl = request.getParameter("m_mo_ideaurl");		
		//PC_TIEPIAN
		String pc_tp_ideaurl = request.getParameter("pc_tp_ideaurl");
		//MB_TIEPIAN
		String m_vtp_ideaurl = request.getParameter("m_vtp_ideaurl");    
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
		String campaign_days_skip = request.getParameter("campaign_days_skip");
		String campaign_num_limit_skip = request.getParameter("campaign_num_limit_skip");
		int campaign_num_limit_skip_int = Integer.parseInt(campaign_num_limit_skip);
		String campaign_day_limit_skip = request.getParameter("campaign_day_limit_skip");
		String campaignList_skip = request.getParameter("campaignList_skip");
		String campaign_skip_name = request.getParameter("campaign_skip_name");
		String startDateRow_skip = request.getParameter("startDateRow_skip");
		String endDateRow_skip = request.getParameter("endDateRow_skip");
		String campaign_sequence_skip = request.getParameter("campaign_sequence_skip");	
		//preload_camp_show
		String is_preload_campaign = request.getParameter("is_preload_campaign");
		String campaign_days_preload = request.getParameter("campaign_days_preload");
		String campaign_num_limit_preload = request.getParameter("campaign_num_limit_preload");
		int campaign_num_limit_preload_int = Integer.parseInt(campaign_num_limit_preload);
		String campaign_day_limit_preload = request.getParameter("campaign_day_limit_preload");
		String campaignList_preload = request.getParameter("campaignList_preload");
		String campaign_preload_name = request.getParameter("campaign_preload_name");
		String startDateRow_preload = request.getParameter("startDateRow_preload");
		String endDateRow_preload = request.getParameter("endDateRow_preload");
		String campaign_sequence_preload = request.getParameter("campaign_sequence_preload");			
		//???????????????_new
		
		String resolution_setting = request.getParameter("resolution_setting");
		String[] resolution_hd2 = request.getParameterValues("resolution_hd2");
		String[] resolution_mp4 = request.getParameterValues("resolution_mp4");
		String[] resolution_flv = request.getParameterValues("resolution_flv");	
		//trueview
		String customtext_url = request.getParameter("customtext_url");
		String clientcustomclick_url = request.getParameter("clientcustomclick_url");
		String clientskip_url = request.getParameter("clientskip_url");
		System.out.println("?????????????????????????????????:" + clientskip_url);
		String clientfee_url = request.getParameter("clientfee_url");
		String othercustomtextclick_url = request.getParameter("othercustomtextclick_url");
		String otherskip_url = request.getParameter("otherskip_url");
		String otherfeep_url = request.getParameter("otherfeep_url");
		//custom_text
		String custom_text = request.getParameter("custom_text");
		String custom_text_mf = request.getParameter("custom_text_mf");		
		//ies_monitor(admaster.com)
		String ies_monitor = request.getParameter("ies_monitor");		
		String isCast_bark = request.getParameter("isCast_bark");		
		//pc_vf_loader_showtime,pc_vob_loader_showtime,pc_vb_loader_showtime,pc_tp_loader_showtime
		String pc_vf_loader_showtime = request.getParameter("pc_vf_loader_showtime");
		String pc_vob_loader_showtime = request.getParameter("pc_vob_loader_showtime");
		String pc_vb_loader_showtime = request.getParameter("pc_vb_loader_showtime");
		String pc_tp_loader_showtime = request.getParameter("pc_tp_loader_showtime");	
		//pc_hvideo_vf_h5
		String pc_hvideo_vf_h5 = request.getParameter("pc_hvideo_vf_h5");
		//pc_selector_youkutudou_length,pc_crazy_youkutudou_length,pc_shortfull_youkutudou_length,pc_shortfull_youkutudou_width,pc_shortfull_youkutudou_height
		//String pc_selector_youkutudou_length = request.getParameter("pc_selector_youkutudou_length");
		//String pc_crazy_youkutudou_length = request.getParameter("pc_crazy_youkutudou_length");
		//String pc_shortfull_youkutudou_length = request.getParameter("pc_shortfull_youkutudou_length");
		//String pc_shortfull_youkutudou_width = request.getParameter("pc_shortfull_youkutudou_width");
		//String pc_shortfull_youkutudou_height = request.getParameter("pc_shortfull_youkutudou_height");	
		//pc_vc_width,pc_vc_height,pc_vc_close_method
		String pc_vc_width = request.getParameter("pc_vc_width");
		String pc_vc_height = request.getParameter("pc_vc_height");
		String pc_vc_close_method = request.getParameter("pc_vc_close_method");
		//pc_vc_location
		String pc_vc_location = request.getParameter("pc_vc_location");
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
	    String m_mhtml_show = request.getParameter("m_mhtml_show");
	    String m_mhtml_click = request.getParameter("m_mhtml_click");
	    //mhtml_app_search_banner
	    String app_search_banner_type = request.getParameter("app_search_banner_type");    
	    String app_search_banner_youkupip_url = request.getParameter("app_search_banner_youkupip_url");
	    String app_search_banner_youkupip_clickurl = request.getParameter("app_search_banner_youkupip_clickurl");
	    String app_search_banner_youkupip_showurl = request.getParameter("app_search_banner_youkupip_showurl");
	    String app_search_banner_youkupip_clickmonitor = request.getParameter("app_search_banner_youkupip_clickmonitor");
//	    String app_search_banner_tudoupip_url = request.getParameter("app_search_banner_tudoupip_url");
//	    String app_search_banner_tudoupip_clickurl = request.getParameter("app_search_banner_tudoupip_clickurl");
//	    String app_search_banner_tudoupip_showurl = request.getParameter("app_search_banner_tudoupip_showurl");    
	    //mvhtml app_playing_banner
	    String app_playing_banner_type = request.getParameter("app_playing_banner_type");
	    String app_playing_banner_pos = request.getParameter("app_playing_banner_pos");    
	    String app_playing_banner_url = request.getParameter("app_playing_banner_url");
	    String app_playing_banner_clickurl = request.getParameter("app_playing_banner_clickurl");
	    String app_playing_banner_showurl = request.getParameter("app_playing_banner_showurl");
	    String app_playing_banner_clickmonitor_url = request.getParameter("app_playing_banner_clickmonitor_url");    
	    String vhtml_yt_promoted_client_show_url = request.getParameter("vhtml_yt_promoted_client_show_url");
	    String vhtml_yt_promoted_other_show_url = request.getParameter("vhtml_yt_promoted_other_show_url");
	    String vhtml_yt_promoted_client_click_url = request.getParameter("vhtml_yt_promoted_client_click_url");
	    //vhtml_yt_promoted_video_ads_url
	    String vhtml_yt_promoted_video_ads_url = request.getParameter("vhtml_yt_promoted_video_ads_url");   
	    //is_ir
	    String is_ir = request.getParameter("is_ir");
	    String ir_type = request.getParameter("ir_type");
	    String dsp_info = request.getParameter("dsp_info");
	    String dsp_url_length = request.getParameter("dsp_url_length");
	    String creative_effect_type = request.getParameter("creative_effect_type");    
	    String clientDSPpushurl_text = request.getParameter("clientDSPpushurl_text");
	    String otherDSPpushurl_text = request.getParameter("otherDSPpushurl_text");    
	    //???????????????
	    String isVidKeywords = request.getParameter("isVidKeywords");
	    String vid_keywords = request.getParameter("vid_keywords");    
	    //????????????
	    String isVidUser = request.getParameter("isVidUser");
	    String vid_users = request.getParameter("vid_users");    
	    //????????????
	    String mutex = request.getParameter("mutex");    
	    //back to ??????????????????????????????????????????(???)--??? trueview???"???????????????????????????"???"????????????????????????",trueview???"????????????????????????(???)"???"?????????????????????"
	    String clientplayover_time = request.getParameter("clientplayover_time");   
	    String pc_vf_buyingbyseeing_ideaurl_flash = request.getParameter("pc_vf_buyingbyseeing_ideaurl_flash");  
	    //pc_vf_buyingbyseeing_ideaurl_h5
	    String pc_vf_buyingbyseeing_ideaurl_h5 = request.getParameter("pc_vf_buyingbyseeing_ideaurl_h5"); 
	    //pc_vf_buyingbyseeing_ideaurl_png
	    String pc_vf_buyingbyseeing_ideaurl_png = request.getParameter("pc_vf_buyingbyseeing_ideaurl_png");
	    String pc_vf_buyingbyseeing_rightpx2 = request.getParameter("pc_vf_buyingbyseeing_rightpx2");
	    //pc_scenario_location
	    String pc_scenario_location = request.getParameter("pc_scenario_location");    
	    //????????????????????????????????????
	    String mb_vf_buyingbyseeing_ideaurl = request.getParameter("mb_vf_buyingbyseeing_ideaurl");
	    String mb_vf_ott_buyingbyseeing_ideaurl = request.getParameter("mb_vf_ott_buyingbyseeing_ideaurl");
	    String control_type_mobile = request.getParameter("control_type_mobile");
	    String ideaShowLocation = request.getParameter("ideaShowLocation");
	    String ideaShowPositionCorn = request.getParameter("ideaShowPositionCorn");  
	    String isVidScene = request.getParameter("isVidScene");
	    String vid_scene = request.getParameter("vid_scene");
	    String isVidGoods = request.getParameter("isVidGoods");
	    String vid_goods = request.getParameter("vid_goods");    
	    String isVidTag = request.getParameter("isVidTag");
	    String vid_tag = request.getParameter("vid_tag");    
	    String isVidPartnerId = request.getParameter("isVidPartnerId");
	    String vid_partnerId = request.getParameter("vid_partnerId");   
	    String isVidPid = request.getParameter("isVidPid");
	    String vid_pids = request.getParameter("vid_pids");    
	    //???????????????"????????????"????????????
	    String m_mi_atv_text = request.getParameter("m_mi_atv_text");    
	    String m_mi_atv_text1 = request.getParameter("m_mi_atv_text1");  
	    //????????????
	    String co_banner_idea = request.getParameter("co_banner_idea");
	    String m_mi_ipad_landscape_idea = request.getParameter("m_mi_ipad_landscape_idea");
	    String m_mi_iphone_portrait_idea = request.getParameter("m_mi_iphone_portrait_idea");   
	    //m_mi_iphonex_video_idea
	    String m_mi_iphonex_video_idea = request.getParameter("m_mi_iphonex_video_idea");  
	    String m_mi_atv_t = request.getParameter("m_mi_atv_t");    
	    //xiami??????????????????
	    String skip_button_text = request.getParameter("skip_button_text");	    
	    //app???????????????
	    String app_homepage_pos = request.getParameter("app_homepage_pos");
	    String app_homepage_type = request.getParameter("app_homepage_type");
	    String app_homepage_url = request.getParameter("app_homepage_url");
	    String app_homepage_clickurl = request.getParameter("app_homepage_clickurl");
	    String app_homepage_showurl = request.getParameter("app_homepage_showurl");    
	    //????????????
	    String is_show_biaoban_position = request.getParameter("is_show_biaoban_position");
	    String[] biaoban_position = request.getParameterValues("biaoban_position");
	    String pc_biaoban_y_ideaurl = request.getParameter("pc_biaoban_y_ideaurl");
	    String mb_biaoban_y_ideaurl = request.getParameter("mb_biaoban_y_ideaurl");    
	    //pc_??????(width&&height setting)
	    String pc_normal_zanting_width = request.getParameter("pc_normal_zanting_width");
	    String pc_normal_zanting_height = request.getParameter("pc_normal_zanting_height");
	    String pc_fullscreen_zanting_width = request.getParameter("pc_fullscreen_zanting_width");
	    String pc_fullscreen_zanting_height = request.getParameter("pc_fullscreen_zanting_height");   
	    //??????H5_VB(?????????web?????????banner)
	     String html_video_banner_ads_url = request.getParameter("html_video_banner_ads_url");
	     String html_video_banner_click_url = request.getParameter("html_video_banner_click_url");    
	     String m_web_video_banner_pos = request.getParameter("m_web_video_banner_pos");
	     String vhtml_m_playing_page_url = request.getParameter("vhtml_m_playing_page_url");
	     String vhtml_m_playing_page_click_url = request.getParameter("vhtml_m_playing_page_click_url");    
	     String m_vc_pad = request.getParameter("m_vc_pad");
	     String m_vc_phone = request.getParameter("m_vc_phone");
	     String m_vc_h5 = request.getParameter("m_vc_h5");
	     String m_ott_vc = request.getParameter("m_ott_vc");
	     //m_mc_location
	     String m_mc_location = request.getParameter("m_mc_location");
	     String m_mc_atv_t = request.getParameter("m_mc_atv_t");  
	     //????????????    
	     String isFaceoff = request.getParameter("isFaceoff");
	     String vid_faceoff = request.getParameter("vid_faceoff");  
	     //???????????????
	     String m_isp_png_url = request.getParameter("m_isp_png_url");
	     String m_isp_title = request.getParameter("m_isp_title");
	     String m_isp_tipcontent = request.getParameter("m_isp_tipcontent");
	     String m_isp_buttontext = request.getParameter("m_isp_buttontext");
	     //vr
	     String isIdea_vr = request.getParameter("isIdea_vr");
	     String interact_effect_type = request.getParameter("interact_effect_type");
	     //deeplink
	     String isDeeplink = request.getParameter("isDeeplink");
	     String vid_deeplink = request.getParameter("vid_deeplink");
	     //???????????????
	     String m_vp_is_qr = request.getParameter("m_vp_is_qr");
	     String m_vp_vq_url = request.getParameter("m_vp_vq_url");
	     //FEED
	     String m_feed_logo_url = request.getParameter("m_feed_logo_url");
	     String m_feed_customer = request.getParameter("m_feed_customer");
	     String m_feed_video_thumbnail = request.getParameter("m_feed_video_thumbnail");
	     String m_feed_buttontext = request.getParameter("m_feed_buttontext");
	     String m_feed_video_url = request.getParameter("m_feed_video_url");
	     String app_feed_pos = request.getParameter("app_feed_pos");
	     String app_Adfeed_pos = request.getParameter("app_Adfeed_pos");
	     String feedAd_type_overall = request.getParameter("feedAd_type_overall");
	     String m_feedAd_png_url_spotlight = request.getParameter("m_feedAd_png_url_spotlight");
	     String m_feedAd_video_url_spotlight = request.getParameter("m_feedAd_video_url_spotlight");
	     String m_feedAd_thumbnail_url_spotlight = request.getParameter("m_feedAd_thumbnail_url_spotlight");
	     
	     String m_feedAd_brandlogo_spotlight = request.getParameter("m_feedAd_brandlogo_spotlight");
	     String m_feedAd_addescript_spotlight = request.getParameter("m_feedAd_addescript_spotlight");
	     String m_feedAd_prompt_spotlight = request.getParameter("m_feedAd_prompt_spotlight");
	     String m_feedAd_adname_spotlight = request.getParameter("m_feedAd_adname_spotlight");
	     String app_Adfeed_spotlight_pos = request.getParameter("app_Adfeed_spotlight_pos");
	     
	     //skiptimethreshold_text
	     String skiptimethreshold_text = request.getParameter("skiptimethreshold_text");
	     String ott_display_ideaurl = request.getParameter("ott_display_ideaurl");    
	     String app_ott_display_type = request.getParameter("app_ott_display_type");
	     String ott_display_ideaurl_showtime = request.getParameter("ott_display_ideaurl_showtime"); 
	     //???????????????(ott????????????p=18)
	     String ott_display_biterate = request.getParameter("ott_display_biterate"); 
	     String ott_display_volume = request.getParameter("ott_display_volume"); 
	     
	     String ott_dis_rec_ideaurl = request.getParameter("ott_dis_rec_ideaurl");    
	     String ott_dis_rec_ideaurl_showtime = request.getParameter("ott_dis_rec_ideaurl_showtime");
	     String is_show_disrec_position = request.getParameter("is_show_disrec_position");
	     String[] disrec_position = request.getParameterValues("disrec_position");  
	     String is_show_xiami_lunbo_position = request.getParameter("is_show_xiami_lunbo_position");
	     String[] xiami_lunbo_position = request.getParameterValues("xiami_lunbo_position");  
	     String ott_screensaver_ideaurl = request.getParameter("ott_screensaver_ideaurl");
	     String is_show_screensaver_position = request.getParameter("is_show_screensaver_position");
	     String[] screensaver_position = request.getParameterValues("screensaver_position");    
	     String screensaver_showtime = request.getParameter("screensaver_showtime");  
	     String ott_poweroff_ideaurl = request.getParameter("ott_poweroff_ideaurl");
	     String poweroff_showtime = request.getParameter("poweroff_showtime");  
	     String product_priority = request.getParameter("product_priority"); 
	     String m_qiantie_install_tip = request.getParameter("m_qiantie_install_tip");
	     String m_qiantie_install_icon_ideaurl = request.getParameter("m_qiantie_install_icon_ideaurl");   
	     String m_qiantie_install_hitcontent = request.getParameter("m_qiantie_install_hitcontent");
	     String m_houtie_install_tip = request.getParameter("m_houtie_install_tip");
	     String m_houtie_install_icon_ideaurl = request.getParameter("m_houtie_install_icon_ideaurl");    
	     String m_houtie_install_hitcontent = request.getParameter("m_houtie_install_hitcontent");
	     String m_zhongcha_install_tip = request.getParameter("m_zhongcha_install_tip");
	     String m_zhongcha_install_icon_ideaurl = request.getParameter("m_zhongcha_install_icon_ideaurl");    
	     String m_zhongcha_install_hitcontent = request.getParameter("m_zhongcha_install_hitcontent");
	     String m_zanting_install_tip = request.getParameter("m_zanting_install_tip");
	     String m_zanting_install_icon_ideaurl = request.getParameter("m_zanting_install_icon_ideaurl");    
	     String m_zanting_install_hitcontent = request.getParameter("m_zanting_install_hitcontent");
	     String m_fullscreen_install_tip = request.getParameter("m_fullscreen_install_tip");
	     String m_fullscreen_install_icon_ideaurl = request.getParameter("m_fullscreen_install_icon_ideaurl");    
	     String m_fullscreen_install_hitcontent = request.getParameter("m_fullscreen_install_hitcontent");
	     String m_playing_banner_install_tip = request.getParameter("m_playing_banner_install_tip");
	     String m_playing_banner_install_icon_ideaurl = request.getParameter("m_playing_banner_install_icon_ideaurl");    
	     String m_playing_banner_install_hitcontent = request.getParameter("m_playing_banner_install_hitcontent");
	     //???????????????????????????????????????
	     String m_feedAd_video_thumbnail = request.getParameter("m_feedAd_video_thumbnail");
	     String m_feedAd_video_url = request.getParameter("m_feedAd_video_url");
	     String m_feedAd_png_url_750_350 = request.getParameter("m_feedAd_png_url_750_350");
	     String m_feedAd_png_url_750_280 = request.getParameter("m_feedAd_png_url_750_280");
	     String m_feedAd_prompt = request.getParameter("m_feedAd_prompt");
	     String m_feedAd_brandlogo = request.getParameter("m_feedAd_brandlogo");
	     String m_feedAd_length = request.getParameter("m_feedAd_length");     
	     String charge_type = request.getParameter("charge_type");
	     String m_vf_pipurl = request.getParameter("m_vf_pipurl");
	     //pc_overlay_float_pic_ideaurl,pc_overlay_float_swf_ideaurl,pc_overlay_float_h5_ideaurl
	     String pc_overlay_float_pic_ideaurl = request.getParameter("pc_overlay_float_pic_ideaurl");
	     String pc_overlay_float_swf_ideaurl = request.getParameter("pc_overlay_float_swf_ideaurl");
	     String pc_overlay_float_h5_ideaurl = request.getParameter("pc_overlay_float_h5_ideaurl");
	     //overlayfloat
	     String isOverlayFloat = request.getParameter("isOverlayFloat");
	     String overlayfloat = request.getParameter("overlayfloat");
	     
	     String isPressDownFloat = request.getParameter("isPressDownFloat");
	     String pressdownfloat = request.getParameter("pressdownfloat");
	     
	     //deviceFocus
	     String isDeviceFocus = request.getParameter("isDeviceFocus");
	     String DeviceFocus = request.getParameter("DeviceFocus");
	     
	     
	     //mb_overlay_float_pic_ideaurl,mb_overlay_float_h5_ideaurl
	     String mb_overlay_float_pic_ideaurl = request.getParameter("mb_overlay_float_pic_ideaurl");
	     String mb_overlay_float_h5_ideaurl = request.getParameter("mb_overlay_float_h5_ideaurl");
	     //????????????
	     String order_type = request.getParameter("order_type");
	     String marketing_type = request.getParameter("marketing_type");
	     //????????????????????????
	     String mb_focus_circle_pic_ideaurl = request.getParameter("mb_focus_circle_pic_ideaurl");
	     //mb_focus_circle_pic_ideaurl_ipad
	     String mb_focus_circle_pic_ideaurl_ipad = request.getParameter("mb_focus_circle_pic_ideaurl_ipad");
	     String mb_focus_circle_pic_text = request.getParameter("mb_focus_circle_pic_text");
	     String mb_focus_circle_pic_pos = request.getParameter("mb_focus_circle_pic_pos");
	     //ssp?????????????????????
	     String yk_2_5_a_v_7 = request.getParameter("yk_2_5_a_v_7");
	     String yk_2_5_a_v_7_p = request.getParameter("yk_2_5_a_v_7_p"); 
	     int ad_type_id = Integer.parseInt(ad_type);

	     //???????????????
	     String h5_hvideo_1_url = request.getParameter("h5_hvideo_1_url");
	     String h5_hvideo_2_url = request.getParameter("h5_hvideo_2_url");
	     String Phone_H5_url = request.getParameter("Phone-H5_url");
	     String Pad_H5_url = request.getParameter("Pad-H5_url");
	     String main_h5_mf_url_t = request.getParameter("main_h5_mf_url_t");
	     String h5_mf_url_t1 = request.getParameter("h5_mf_url_t1");
	     String h5_mf_url_t2 = request.getParameter("h5_mf_url_t2");  
	     
	     //???????????????
	     String is_bf_position = request.getParameter("is_bf_position");  
	     String bf_position = request.getParameter("bf_position");  
	     
	     String mb_bf_ideaurl = request.getParameter("mb_bf_ideaurl"); 
	     String pc_bf_ideaurl = request.getParameter("pc_bf_ideaurl"); 
	     String feedAd_type = request.getParameter("feedAd_type"); 
	     //feedAd_type,feedAd_type_kandian
	     String feedAd_type_kandian = request.getParameter("feedAd_type_kandian"); 
	     //pc_feeds_pos,pc_seeds_ideaurl,pc_seeds_title,pc_seeds_cover
	     String pc_feeds_pos = request.getParameter("pc_feeds_pos"); 
	     String pc_seeds_ideaurl = request.getParameter("pc_seeds_ideaurl"); 
	     String pc_seeds_title = request.getParameter("pc_seeds_title"); 
	     String pc_seeds_cover = request.getParameter("pc_seeds_cover"); 
	     //vhtml_yt_banner_pip_url,vhtml_yt_banner_h5_url,vhtml_yt_banner_h5_width,vhtml_yt_banner_h5_height
	     String vhtml_yt_banner_pip_url = request.getParameter("vhtml_yt_banner_pip_url");
	     String vhtml_yt_banner_h5_url = request.getParameter("vhtml_yt_banner_h5_url");
	     String vhtml_yt_banner_h5_width = request.getParameter("vhtml_yt_banner_h5_width");
	     String vhtml_yt_banner_h5_height = request.getParameter("vhtml_yt_banner_h5_height");
	     
	     //time???????????????	     
	     String timePicker_starttime = request.getParameter("timePicker_starttime"); 
	     String timePicker_endtime = request.getParameter("timePicker_endtime");
	     
	     String vhtml_type = request.getParameter("vhtml_type");
	     
	     //ott???????????????
	     String mf_oneBuy_type = request.getParameter("mf_oneBuy_type");
	     String mf_good_id = request.getParameter("mf_good_id");
	     String mf_taobaoer_id = request.getParameter("mf_taobaoer_id");
	     String mf_onebuy_h5_url = request.getParameter("mf_onebuy_h5_url");
	     String ott_onebuy_png_url = request.getParameter("ott_onebuy_png_url");
	     String onebuyurl_text = request.getParameter("onebuyurl_text");
	     String mf_onebuy_h5_width = request.getParameter("mf_onebuy_h5_width");
	     String mf_onebuy_h5_height = request.getParameter("mf_onebuy_h5_height");
	     
	 	EasyCastUtil.screenShots();
	 	EasyCastUtil.updateHostName("pre-yks.youku.com", "140.205.173.181");
	 	String cast_info = insertCast(ad_type_id, start_date, end_date,
	 			all_area, chk_area, all_channel, chk_channel, v_position,vo_position,jiaobiao_position,
	 			priority, total_lun,percent,all_os,pc_all_os, chk_os, chk_os_pc,isVidLimit, video_group_area1,
	 			video_group_area2, cast_type, pc_vc_tiepian_pos,
	 			is_show_campaign, is_click_campaign, is_over_campaign,
	 			campaign_num_limit_show_int, campaign_day_limit_show,campaign_days_show,campaign_days_click,campaign_days_over,
	 			campaign_num_limit_click_int, campaign_day_limit_click,
	 			campaign_num_limit_over_int, campaign_day_limit_over,is_skip_campaign,campaign_days_skip,campaign_num_limit_skip_int,campaign_day_limit_skip,
	 			campaignList_skip,campaign_skip_name,startDateRow_skip,endDateRow_skip,campaign_sequence_skip,
	 			is_preload_campaign,campaign_days_preload,campaign_num_limit_preload_int,campaign_day_limit_preload,
	 			campaignList_preload,campaign_preload_name,startDateRow_preload,endDateRow_preload,campaign_sequence_preload,
	 			is_show_priority, product_reserve_method,pc_vf_impression,m_vb_impression,m_vo_impression, pc_vf_impression_pc,pc_vob_impression_pc,pc_vb_impression_pc,pc_tp_impression_pc,m_ztsdk,
	 			m_sdk,resolution_hd2,resolution_mp4,resolution_flv,
	 			campaignList_show,campaign_show_name,startDateRow_show,endDateRow_show,campaign_sequence_show,
	 			campaignList_click,campaign_click_name,startDateRow_click,endDateRow_click,campaign_sequence_click,
	 			campaignList_over,campaign_over_name,startDateRow_over,endDateRow_over,campaign_sequence_over,is_show_v_position,is_show_vo_position,is_show_jiaobiao_position,isCast_bark,parameter_values,parameter_names,isVidParameter,
	 			is_ir,ir_type,dsp_info,creative_effect_type,app_playing_banner_pos,app_homepage_pos,
	 			isVidKeywords,vid_keywords,isVidUser,vid_users,mutex,isVidScene,vid_scene,isVidGoods,vid_goods,isVidTag,vid_tag,isVidPartnerId,vid_partnerId,isVidPid,vid_pids,is_show_biaoban_position,biaoban_position,m_web_video_banner_pos,isFaceoff,vid_faceoff,interact_effect_type,video_group_area3,video_group_area4,video_group_area5,app_feed_pos,app_Adfeed_pos,skiptimethreshold_text,product_priority,is_show_screensaver_position,screensaver_position,is_show_disrec_position,disrec_position,is_show_xiami_lunbo_position,xiami_lunbo_position,charge_type,order_type,marketing_type,isOverlayFloat,overlayfloat,isPressDownFloat,pressdownfloat,mb_focus_circle_pic_pos,yk_2_5_a_v_7,yk_2_5_a_v_7_p,chargingthreshold_text,is_bf_position,bf_position,resolution_setting,isDeviceFocus,DeviceFocus,feedAd_type,feedAd_type_overall,app_Adfeed_spotlight_pos,pc_feeds_pos,feedAd_type_kandian,timePicker_starttime,timePicker_endtime);
	     
	 	String[] split_cast_info = cast_info.split(":");
	 	String[] cast_id_info = (split_cast_info[0].trim()).split("=");
	 	System.out.println("cast_info is :" + cast_info);
	 	System.out.println("cast_id_info[1] is :" + split_cast_info[1]);
	 	int cast_id = Integer.parseInt(cast_id_info[1]);
	 	
	 	int idea_id = insertIdea(ad_type_id, cast_id, ad_type_id,
	 			click_url, mb_click, over_url, outtime, show_url,
	 			click_kh_url,playing_url, iso_url, mt_url, iso_click_url, iso_h5_url,
	 			m_issdk, m_sdk, m_ztsdk, m_qtsdk, pc_vf_y_ideaurl,
	 			pc_vf_pipurl,loader_type, loader_type_vob,loader_type_vb,loader_type_tp,pc_vf_impression, m_vb_impression,m_vo_impression,pc_vf_impression_pc,pc_vob_impression_pc,pc_vb_impression_pc,pc_tp_impression_pc,pc_vp_y_ideaurl,pc_vp_y_ideaurl_h5,
	 			pc_vp_y_full_ideaurl, pc_vp_y_full_ideaurl_h5,pc_vp_t_ideaurl,
	 			pc_vp_t_full_ideaurl, pc_vp_ideacontrol, pc_vob_ideaurl,
	 			pc_vob_pipurl, pc_vb_ideaurl,
	 			pc_vc_y_ideaurl, pc_vc_y_ideaurl_img,pc_vc_y_ideaurl_h5,pc_vc_y_rightpx2,
	 			pc_vc_t_ideaurl, pc_vc_t_rightpx2, pc_vc_position,
	 			pc_vc_showtime, m_vf_ideaurl, m_h5_vf_ideaurl_phone,m_h5_vf_ideaurl_pad,m_h5_vb_ideaurl_phone,m_h5_vb_ideaurl_pad,m_h5_vo_ideaurl_phone,m_h5_vo_ideaurl_pad,
	 			m_vb_ideaurl, m_vp_ideaurl, m_vc_openstatus_pageurl,
	 			m_vc_closestatus_pageurl, m_mi_ipad_ideaurl_768,
	 			m_mi_ipad_ideaurl_1004, m_mi_iphone_ideaurl_940,
	 			m_mi_iphone_ideaurl_1116, m_mi_iphone_ideaurl_1334,
	 			m_mi_iphone_ideaurl_1920,m_mi_iphone_ideaurl_xiami, m_mi_aphone_ideaurl_xiami,m_mi_apad_ideaurl_800,
	 			m_mi_apad_ideaurl_600, m_mi_apad_ideaurl_768, m_mi_aphone_ideaurl_1280,
	 			m_mi_aphone_ideaurl_800, m_mi_atv_ideaurl_720, m_mi_atv_t,m_iku_pc_ideaurl_650,m_iku_pc_ideaurl_720,
	 			m_mqp_ipad_ideaurl_748, m_mqp_iphone_ideaurl_480,
	 			m_mqp_androidpad_ideaurl_720,
	 			m_mqp_androidphone_ideaurl_480, m_quanping_showtime,
	 			m_mo_ideaurl, cast_type, is_show_priority,product_reserve_method,chk_os,resolution_hd2,resolution_mp4,resolution_flv,pc_tp_ideaurl,m_vtp_ideaurl,ies_monitor,
	 			customtext_url,clientcustomclick_url,clientskip_url,clientfee_url,othercustomtextclick_url,otherskip_url,otherfeep_url,custom_text,custom_text_mf,
	 			pc_vf_loader_showtime,pc_vob_loader_showtime,pc_vb_loader_showtime,pc_tp_loader_showtime,
	 			pc_vc_width,pc_vc_height,pc_vc_close_method,pc_vc_location,chargingthreshold_text,m_mhtml_text_content,m_mhtml_clickurl,m_mhtml_show,m_mhtml_click,
	             is_ir, ir_type, dsp_url_length, clientDSPpushurl_text, otherDSPpushurl_text,
	 			app_search_banner_type, app_playing_banner_type, app_search_banner_youkupip_url, app_search_banner_youkupip_clickurl, app_search_banner_youkupip_showurl, app_search_banner_youkupip_clickmonitor,
	 			vhtml_yt_promoted_client_show_url, vhtml_yt_promoted_other_show_url, vhtml_yt_promoted_client_click_url, vhtml_yt_promoted_video_ads_url,
	 			app_playing_banner_url, app_playing_banner_clickurl, app_playing_banner_showurl, app_playing_banner_clickmonitor_url,clientplayover_time,pc_vf_buyingbyseeing_ideaurl_flash,pc_vf_buyingbyseeing_ideaurl_h5,pc_vf_buyingbyseeing_ideaurl_png,pc_vf_buyingbyseeing_rightpx2,pc_scenario_location,m_mi_atv_text,m_mi_atv_text1,co_banner_idea,m_mi_ipad_landscape_idea,m_mi_iphone_portrait_idea,skip_button_text,app_homepage_type,app_homepage_url,app_homepage_clickurl,app_homepage_showurl,pc_biaoban_y_ideaurl,mb_biaoban_y_ideaurl,
	 			pc_normal_zanting_width,pc_normal_zanting_height,pc_fullscreen_zanting_width,pc_fullscreen_zanting_height,html_video_banner_ads_url,vhtml_m_playing_page_url,m_vc_pad,m_vc_phone,m_vc_h5,m_ott_vc,m_mc_location,m_mc_atv_t,m_isp_png_url,m_isp_title,m_isp_tipcontent,m_isp_buttontext,isIdea_vr,m_vp_is_qr,m_vp_vq_url,m_vp_ott_ideaurl,m_feed_logo_url,m_feed_customer,m_feed_video_thumbnail,m_feed_buttontext,m_feed_video_url,ott_display_ideaurl,app_ott_display_type,ott_display_ideaurl_showtime,ott_dis_rec_ideaurl,ott_dis_rec_ideaurl_showtime,ott_screensaver_ideaurl,screensaver_showtime,ott_poweroff_ideaurl,poweroff_showtime,m_feedAd_video_thumbnail,m_feedAd_video_url,m_feedAd_png_url_750_350,m_feedAd_png_url_750_280,m_feedAd_prompt,m_feedAd_brandlogo,m_feedAd_length,interact_effect_type,charge_type,m_vf_pipurl,mb_vf_buyingbyseeing_ideaurl,mb_vf_ott_buyingbyseeing_ideaurl,control_type_mobile,ideaShowLocation,ideaShowPositionCorn,pc_overlay_float_pic_ideaurl,pc_overlay_float_swf_ideaurl,pc_overlay_float_h5_ideaurl,mb_overlay_float_pic_ideaurl,mb_overlay_float_h5_ideaurl,mb_focus_circle_pic_ideaurl,mb_focus_circle_pic_text,mb_focus_circle_pic_ideaurl_ipad,m_mi_iphonex_ideaurl_1125,pc_hvideo_vf_h5,isDeeplink,vid_deeplink,m_mi_iphonex_video_idea,h5_hvideo_1_url,h5_hvideo_2_url,Phone_H5_url,Pad_H5_url,main_h5_mf_url_t,h5_mf_url_t1,h5_mf_url_t2,mb_bf_ideaurl,pc_bf_ideaurl,ott_display_biterate,ott_display_volume,feedAd_type_overall,m_feedAd_png_url_spotlight,m_feedAd_brandlogo_spotlight,m_feedAd_addescript_spotlight,m_feedAd_prompt_spotlight,m_feedAd_adname_spotlight,pc_seeds_ideaurl,pc_seeds_title,pc_seeds_cover,vhtml_type,vhtml_yt_banner_pip_url,vhtml_yt_banner_h5_url,vhtml_yt_banner_h5_width,vhtml_yt_banner_h5_height,m_feedAd_video_url_spotlight,m_feedAd_thumbnail_url_spotlight,feedAd_type,feedAd_type_kandian,mf_oneBuy_type,mf_good_id,mf_taobaoer_id,mf_onebuy_h5_url,ott_onebuy_png_url,onebuyurl_text,mf_onebuy_h5_width,mf_onebuy_h5_height);
	     
	 	 insertCastIdea(ad_type_id,cast_id,idea_id,m_issdk,ies_monitor,mb_click); 
	 	
	 	 insetSdkConfig(m_sdk,m_ztsdk,chk_os,ad_type_id,cast_id,idea_id);

	     //response.setContentType("text/html");  
	     response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();  
    	 out.println(getAdTypeName(ad_type_id) + " " + cast_info + ", ??????id=" + idea_id);
    	 out.println("<a href='ad.jsp'>??????</a>");
	}


	private void insertCastIdea(int ad_type_id,int cast_id, int idea_id, int m_issdk, String ies_monitor, String mb_click) {
		// TODO Auto-generated method stub
		try {				
			ArrayList al = DBConnection.getInstance("atm").execQuerySql6("select id from cast_idea order by id desc limit 1");
			String a = (al.get(0).toString()).substring(1, al.get(0).toString().length() - 1) + "";
			int i = Integer.parseInt(a);					
			CastIdea castIdea = new CastIdea();
			castIdea.setId(i+1);
			castIdea.setCastId(cast_id);
			castIdea.setIdeaId(idea_id);
			castIdea.setStatus(1);
			if (ad_type_id == MB_QIANTIE || ad_type_id == MB_HOUTIE || ad_type_id == MB_ZHONGCHA || ad_type_id == MB_ZANTING || ad_type_id == MB_JIAOBIAO || ad_type_id == MB_KAIJITU || ad_type_id == MB_QUANPING || ad_type_id== MB_TIEPIAN || ad_type_id == NEW_JUCHANGBIAOBAN || ad_type_id == NEW_OVERLAY_FLOAT || ad_type_id == MB_OVERLAY_FLOAT || ad_type_id == MB_FOCUS_CIRCLE || ad_type_id == MB_JUCHANGBIAOBAN || ad_type_id == NEW_FACEOFF || ad_type_id == MB_FACEOFF || ad_type_id == MB_ISP || ad_type_id == OTT_DISPLAY || ad_type_id == OTT_DIS_REC || ad_type_id == OTT_SCREENSAVER || ad_type_id == OTT_POWEROFF ||ad_type_id == MB_BF || ad_type_id == YOUKU_FEEDAD ) {
				castIdea.setIssdk(m_issdk);
			}else{
				castIdea.setIssdk(0);
			}
			
            if("2".equals(ies_monitor)){
            	castIdea.setIesorg("admaster.com");
            }else if("3".equals(ies_monitor)){
            	castIdea.setIesorg("miaozhen.com");
            }else {
            	castIdea.setIesorg("");
            }           
            castIdea.setCuf(Integer.parseInt(mb_click));
            castIdea.setUpdateTime(new Date());
            castIdea.setMst(0);
            //???????????? 0-????????????1-miaozhen'
            castIdea.setMonitorAddType(0);
            castIdea.save();
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getStackTrace(), e);
		}
		
	}


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
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	
	public static boolean isNumeric(String str){ 
	     Pattern pattern = Pattern.compile("[0-9]*"); 
	     return pattern.matcher(str).matches();    
	}
    
	//idea_monitor type=1??????type=10 ????????????(todo)-?????????1=????????????/10???????????????????????????
	public String covertUrl(String url) {
		try {
			/*?????????????????????????????????????????????
			url=url.replaceAll("%", "!9999!");	
			url=url.replaceAll("&", "!url!");
			url=url.replaceAll("#", "!35!");
			url=url.replaceAll("=", "!61!");
			url=url.replaceAll("\\?", "!63!");
			url=url.replaceAll("??", "!215!");
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
	
	public static String revertUrl(String url) {
		try {
			/*?????????????????????????????????????????????			
			url=url.replaceAll("!9999!", "%");	
			url=url.replaceAll("!url!", "&");
			url=url.replaceAll("!35!", "#");
			url=url.replaceAll("!61!", "=");
			url=url.replaceAll("!63!", "\\?");
			url=url.replaceAll("!215!", "??");
			url=url.replaceAll("!20!", "\\+");
			 */
			url = url.replaceAll("percent_esc", "%");
			url = url.replaceAll("and_esc", "&");
			url = url.replaceAll("sharp_esc", "#");
			url = url.replaceAll("equal_esc", "=");
			url = url.replaceAll("interrogation_esc", "\\?");
			url = url.replaceAll("add_esc", "\\+");
			url = url.replaceAll("dollar_esc", "\\$");
					
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			return url;
		}
	}

	public boolean checkIdeaUrlFormat(String pc_vf_y_ideaurl) {

		if ((pc_vf_y_ideaurl != null && pc_vf_y_ideaurl.length() > 0 && pc_vf_y_ideaurl.indexOf("v.youku.com") > 0 && pc_vf_y_ideaurl.endsWith(".html"))) {
			return true;
		} else {
			return false;
		}
	}

	String getAdTypeName(int ad_type) {
		switch (ad_type) {
		case NEW_QIANTIE:
			return "?????????";
		case NEW_ZANTING:
			return "?????????";
		case NEW_ZHONGCHA:
			return "?????????";
		case NEW_HOUTIE:
			return "?????????";
		case NEW_SPECIALAD:
			return "???crazy";
		case NEW_ADSELECTOR:
			return "???Ad selector";
		case NEW_JIAOBIAO:
			return "?????????";
		case NEW_KAIJITU:
			return "????????????";
		case NEW_SHORTFULL:
			return "??????????????????";
		case NEW_TIEPIAN:
			return "?????????";
		case NEW_BUYINGSEEING:
			return "PC???????????????(???????????????)";	
		case MB_scenario:
			return "?????????????????????";	
		case MB_FOCUS_CIRCLE:
			return "????????????????????????";				
		case NEW_JUCHANGBIAOBAN:
			return "????????????";		
		case NEW_OVERLAY_FLOAT:
			return "PC??????????????????";	
		case MB_OVERLAY_FLOAT:
			return "????????????????????????";	
		case MB_JUCHANGBIAOBAN:
			return "??????????????????";	
		case NEW_FACEOFF:
			return "????????????";		
		case MB_FACEOFF:
			return "??????????????????";		
		case MB_QIANTIE:
			return "????????????";
		case MB_BF:
			return "?????????????????????";	
		case PC_BF:
			return "pc???????????????";	
		case PC_FEEDS:
			return "pc????????????";	
		case MB_HOUTIE:
			return "????????????";
		case MB_ZANTING:
			return "????????????";
		case MB_JIAOBIAO:
			return "????????????";
		case MB_KAIJITU:
			return "???????????????";
		case MB_QUANPING:
			return "????????????";
		case MB_ZHONGCHA:
			return "????????????";
		case MB_TIEPIAN:
			return "????????????";
		case MB_ISP:
			return "???????????????";	
		case MB_FEED:
			return "Feed????????????";
		case YOUKU_FEEDAD:
			return "YOUKU???????????????";
		case OTT_DISPLAY:
			return "ott????????????/????????????";	
		case OTT_POWEROFF:
			return "ott??????????????????";
		case OTT_SCREENSAVER:
			return "ott??????????????????/?????????????????????";
		case OTT_DIS_REC:
			return "ott??????????????????";	
		case MB_WENZILIAN:
			return "?????????????????????";
			//MB_APPSEARCHBANNER
		case MB_APPSEARCHBANNER:
			return "??????app?????????banner";	
		case MB_APP_PLAYING_BANNER:
			return "??????app?????????banner";
		case MB_APP_HOMEPAGE:
			return "??????app??????/???????????????banner";
		case yk_vhtml_banner:
			return "youku_???????????????PIP???????????????????????????";
		case yk_vhtml_right_relative_banner:
			return "youku_???????????????????????????banner ???????????????-??????-PC_??????_WEB-????????????-BANNER-?????????????????????-???????????????";	
		case yk_vhtml_banner1:
			return "youku_???????????????banner1???????????????-??????-PC_??????_WEB-????????????-BANNER-?????????????????????-??????\\\"?????????\\\"???banner";		
		case yk_vhtml_righttop:
			return "youku_?????????????????????PIP???UGC???";		
		case yk_vhtml_comments:
			return "youku_???????????????????????????????????????-?????????-??????-PC_??????_WEB-????????????-??????-?????????????????????-????????????";	
		case yk_vhtml_RTB:
			return "youku_????????????????????????????????????RTB?????????-??????-PC_??????_WEB-????????????-??????-?????????????????????-????????????";	
		case yk_vhtml_survey:
			return "youku_???????????????-????????? ????????????";	
		case yk_vhtml_mb_web:
			return "youku_??????web ?????????";	
		case tudou_vhtml_banner1:
			return "tudou_???????????????banner1";	
		case tudou_vhtml_UGC_banner:
			return "tudou_UGC?????????banner (300*250)";		
		case tudou_vhtml_righttop:
			return "tudou_???????????????-??????????????????????????????banner";	
		case tudou_vhtml_rightcenter:
			return "tudou_???????????????-???????????????????????? PIP";	
		case tudou_vhtml_rightdown:
			return "tudou_???????????????-???????????????????????? PIP";		
		case tudou_vhtml_commentDown:
			return "tudou_???????????????-?????????????????????????????????";	
		case tudou_vhtml_survey:
			return "tudou_???????????????-????????????";	
		case promoted_video_ads_1430192600:
			return "????????????_promoted_video_ads_1430192600";	
		case promoted_video_ads_1430192617:
			return "????????????_promoted_video_ads_1430192617";	
		case m_playing_youku_phone_web_1425020640:
			return "youku_??????phone-web???_?????????banner_1425020640";	
		case m_playing_youku_ipad_web_1427883541:
			return "youku_??????ipad-web???_?????????banner_1427883541";
		case m_homepage_banner_web:
			return "??????H5_VB(??????web?????????banner)";			
		default:
			return "??????";
		}
	}
	int getMaxSaleOrder() {
		Criteria c = new Criteria();
		//c.add(AdOrderPeer.ORDER_TYPE, AdOrder_C.ORDER_TYPE_SALE);
		c.add(AdOrderPeer.STATUS, 3);
		int[] type ={0};
		c.addIn(AdOrderPeer.TYPE, type);  
		int[] marketing_type={0};
		c.addIn(AdOrderPeer.MARKETING_TYPE, marketing_type);  
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
	
	int getMaxMarketOrder() {
		Criteria c = new Criteria();
		//c.add(AdOrderPeer.ORDER_TYPE, AdOrder_C.ORDER_TYPE_SALE);
		c.add(AdOrderPeer.STATUS, 3);
		int[] type ={1};
		c.addIn(AdOrderPeer.TYPE, type);   
		int[] marketing_type={0};
		c.addIn(AdOrderPeer.MARKETING_TYPE, marketing_type);
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
	
	int getMaxTestOrder() {
		Criteria c = new Criteria();
		//c.add(AdOrderPeer.ORDER_TYPE, AdOrder_C.ORDER_TYPE_SALE);
		c.add(AdOrderPeer.STATUS, 3);
		int[] type ={2};
		c.addIn(AdOrderPeer.TYPE, type);
		int[] marketing_type={0};
		c.addIn(AdOrderPeer.MARKETING_TYPE, marketing_type);
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
	
	int getAdorderId(String order_type,String marketing_type) {
		Criteria c = new Criteria();
		//c.add(AdOrderPeer.ORDER_TYPE, AdOrder_C.ORDER_TYPE_SALE);
		c.add(AdOrderPeer.STATUS, 3);
		int[] type = {Integer.parseInt(order_type)};
		c.addIn(AdOrderPeer.TYPE, type);
		int[] order_marketing_type= {Integer.parseInt(marketing_type)};
		c.addIn(AdOrderPeer.MARKETING_TYPE, order_marketing_type);
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
	
	String insertCast(int ad_type, String start_date, String end_date,String all_area, String[] chk_area, String all_channel,String[] chk_channel, String[] v_position,String[] vo_position, String[] jiaobiao_position,String priority,String total_lun,String percent,String all_os, String pc_all_os,String[] chk_os,String[] chk_os_pc, String isVidLimit,
			String video_group_area1, String video_group_area2,String cast_type, String pc_vc_tiepian_pos,String is_show_campaign, String is_click_campaign,String is_over_campaign, int campaign_num_limit_show_int,String campaign_day_limit_show, String campaign_days_show, String campaign_days_click,String campaign_days_over,int campaign_num_limit_click_int,String campaign_day_limit_click, int campaign_num_limit_over_int,String campaign_day_limit_over, String is_skip_campaign,String campaign_days_skip,int campaign_num_limit_skip_int,
			String campaign_day_limit_skip, String campaignList_skip,String campaign_skip_name,String startDateRow_skip,String endDateRow_skip,String campaign_sequence_skip,String is_preload_campaign,String campaign_days_preload,int campaign_num_limit_preload_int,String campaign_day_limit_preload, String campaignList_preload,String campaign_preload_name,String startDateRow_preload,String endDateRow_preload,String campaign_sequence_preload,
			String is_show_priority,String product_reserve_method,int pc_vf_impression,int m_vb_impression,int m_vo_impression, int pc_vf_impression_pc, int pc_vob_impression_pc,int pc_vb_impression_pc,int pc_tp_impression_pc,int m_ztsdk, int m_sdk,String[] resolution_hd2,String[] resolution_mp4,String[] resolution_flv,String campaignList_show,String campaign_show_name,String startDateRow_show,String endDateRow_show,String campaign_sequence_show,String campaignList_click,String campaign_click_name,String startDateRow_click,String endDateRow_click,String campaign_sequence_click,
			String campaignList_over,String campaign_over_name,String startDateRow_over,String endDateRow_over,String campaign_sequence_over,String is_show_v_position,String is_show_vo_position,String is_show_jiaobiao_position,String isCast_bark,String parameter_values,String parameter_names,String isVidParameter,String is_ir,String ir_type,String dsp_info,String creative_effect_type,String app_playing_banner_pos,String app_homepage_pos,String isVidKeywords,String vid_keywords,String isVidUser,String vid_users,String mutex,String isVidScene,String vid_scene,String isVidGoods,String vid_goods,String isVidTag,String vid_tag,String isVidPartnerId,String vid_partnerId,String isVidPid,String vid_pids,String is_show_biaoban_position,String[] biaoban_position,String m_web_video_banner_pos,
			String isFaceoff,String vid_faceoff,String interact_effect_type,String video_group_area3,String video_group_area4,String video_group_area5,String app_feed_pos,String app_Adfeed_pos,String skiptimethreshold_text,String product_priority,String is_show_screensaver_position,String[] screensaver_position,String is_show_disrec_position,String[] disrec_position,String is_show_xiami_lunbo_position,String[] xiami_lunbo_position,String charge_type,String order_type,String marketing_type,String isOverlayFloat,String overlayfloat,String isPressDownFloat,String pressdownfloat,String mb_focus_circle_pic_pos,String yk_2_5_a_v_7,String yk_2_5_a_v_7_p,String chargingthreshold_text,String is_bf_position,String bf_position,String resolution_setting,String isDeviceFocus,String DeviceFocus,String feedAd_type,String feedAd_type_overall,String app_Adfeed_spotlight_pos,String pc_feeds_pos,String feedAd_type_kandian,String timePicker_starttime,String timePicker_endtime) {
		//String name = ad_type + "_" + System.currentTimeMillis();
		try {
			//String root = getServletContext().getRealPath("/");
			//Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
			AdCast cast = new AdCast();
			ArrayList al10 = DBConnection.getInstance("atm").execQuerySql6("select id from ad_order order by id desc limit 1");
			if (al10.size() == 0) {
				//????????????
				AdOrder adOrder = new AdOrder();
				adOrder.setId(1);
				adOrder.setName("teset_order1");
				adOrder.setCustomId(1);
				adOrder.setCustomName("test1");
				adOrder.setType(0);
				adOrder.setStatus(3);
				adOrder.save();			
				//????????????
				AdOrder adOrder1 = new AdOrder();
				adOrder1.setId(2);
				adOrder1.setName("teset_order2");
				adOrder1.setCustomId(1);
				adOrder1.setCustomName("test2");
				adOrder1.setType(1);
				adOrder1.setStatus(3);
				adOrder1.save();
			}           
			int order_id = 0;
			if(order_type.equals("0")){
				order_id = getMaxSaleOrder();
			}else if(order_type.equals("1")){
				order_id = getMaxMarketOrder();
			}else{
				order_id = getMaxTestOrder();
			}
			
			order_id = getAdorderId(order_type, marketing_type);
			
			//int order_id = getMaxSaleOrder();
			String name1 = (order_id + 1) + "_" + ad_type + "_" + System.currentTimeMillis();
			int iiii;		
			ArrayList al = DBConnection.getInstance("atm").execQuerySql6("select id from ad_cast order by id desc limit 1");
			if (al.size() == 0) {
				cast.setId(1);
			} else {
				String a = (al.get(0).toString()).substring(1, al.get(0).toString().length() - 1) + "";
				iiii = Integer.parseInt(a);
				cast.setId(iiii + 1);
				//cast.setId(1112681991);
				  //cast.setId(1000000000);
			}
			cast.setOrderId(order_id);
			cast.setCustomerId(1);
			cast.setProductId(1);
			cast.setName(name1);
			cast.setInteractEffect(1);
			if (ad_type == NEW_QIANTIE || ad_type == MB_QIANTIE || ad_type == NEW_ZHONGCHA || ad_type == MB_ZHONGCHA || ad_type == NEW_HOUTIE || ad_type == MB_HOUTIE || ad_type == NEW_TIEPIAN || ad_type == MB_TIEPIAN) {
				//cast.setAdTypeId(162);
				if(pc_vf_impression==2 || pc_vf_impression_pc==2 || pc_vob_impression_pc ==2 || m_vo_impression == 2 || m_vb_impression ==2 || pc_vb_impression_pc ==2){
					cast.setChargeTime(Integer.parseInt(chargingthreshold_text));
				}
				if(ad_type == NEW_HOUTIE || ad_type == MB_HOUTIE) {
					cast.setResourceType("32");
				}
				if(ad_type == NEW_ZHONGCHA || ad_type == MB_ZHONGCHA) {
					cast.setResourceType("33");
				}
				if(ad_type == NEW_QIANTIE || ad_type == MB_QIANTIE) {
					//resource_type?????????ad_position.pos_type
					cast.setResourceType("35");
				}
				
			}
			
			if (ad_type == NEW_JIAOBIAO || ad_type == MB_JIAOBIAO) {
				//cast.setAdTypeId(165);								

				if("1".equals(isPressDownFloat)&&isPressDownFloat!=null){
					//????????????
					cast.setResourceType("17");
				}else {
					//????????????
					cast.setResourceType("25");
				}
				
			}
			if (ad_type == NEW_ZANTING || ad_type == MB_ZANTING) {
				//cast.setAdTypeId(164);
				cast.setResourceType("26");
			}
			if (ad_type == MB_QUANPING) {
				//cast.setAdTypeId(76);
				cast.setResourceType("35");
				cast.setInteractEffect(146);
			}
			if (ad_type == NEW_KAIJITU || ad_type == MB_KAIJITU) {
				//cast.setAdTypeId(75);
				cast.setResourceType("24");
			}
			if (ad_type == NEW_SHORTFULL) {
				//cast.setAdTypeId(167);
				cast.setResourceType("35");
				//cast.setInteractEffect(2);
			}
			if (ad_type == NEW_SPECIALAD) {
				//cast.setAdTypeId(168);
				cast.setResourceType("35");
			}
			if(ad_type == NEW_ADSELECTOR){
				//cast.setAdTypeId(169);
				cast.setResourceType("35");
			}		
			if(ad_type == MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER||ad_type == MB_APP_HOMEPAGE || ad_type == m_homepage_banner_web){
				//cast.setAdTypeId(3);
				if(ad_type == MB_WENZILIAN){
					cast.setResourceType("6");
				}
				if(ad_type == MB_APPSEARCHBANNER){
					cast.setResourceType("2");
				}
				if(ad_type == MB_APP_HOMEPAGE){
					//????????????banner
					cast.setResourceType("2");
				}
				if(ad_type == m_homepage_banner_web){
					//cast.setResourceType("2");??????????????????
				}
			}	
			if(ad_type == NEW_BUYINGSEEING || ad_type == MB_scenario){
				//cast.setAdTypeId(170);
				if("49".equals(interact_effect_type)){
					cast.setResourceType("9");
				}else if("48".equals(interact_effect_type)){
					cast.setResourceType("8");
				}
				
			}		
			if(ad_type == NEW_FACEOFF || ad_type == MB_FACEOFF){
				//cast.setAdTypeId(172);//????????????????????????
				cast.setResourceType("11");
			}	
	
			if(ad_type == NEW_JUCHANGBIAOBAN || ad_type == MB_JUCHANGBIAOBAN){
				//cast.setAdTypeId(171);
				cast.setResourceType("23");
			}			
			if(ad_type == NEW_OVERLAY_FLOAT || ad_type == MB_OVERLAY_FLOAT){
				//cast.setAdTypeId(205);
		        cast.setDirectWay("a*p*g*float");
		        cast.setInteractEffect(60);
		        cast.setResourceType("4");
			}		
			if(ad_type == MB_ISP){
				//cast.setAdTypeId(173);
				cast.setInteractEffect(144);
				cast.setResourceType("36");
			}		
			if(ad_type == MB_FEED){
				//cast.setAdTypeId(174);
				cast.setDirectWay("a*p");
				cast.setCastWay("time");//??????
				cast.setResourceType("16");
				
			}
			if(ad_type == YOUKU_FEEDAD){
				//cast.setAdTypeId(204);
				cast.setDirectWay("a*c*p");
				//cast.setCastWay("time");//??????
				if("1".equals(feedAd_type_overall)) {
					//cast.setResourceType("31");
					if("1".equals(feedAd_type)) {
						cast.setInteractEffect(54);
					}else {
						cast.setInteractEffect(32);
					}
				}else {
					//cast.setResourceType("31");ssp????????????????????????165??? ??????147
					if("1".equals(feedAd_type_kandian)) {
						cast.setInteractEffect(147);
					}else {
						cast.setInteractEffect(165);
					}
					
				}
				
				cast.setResourceType("31");
				
			}		
			if(ad_type == OTT_DISPLAY){
				//cast.setAdTypeId(200);
				cast.setDirectWay("a*c*p");
				cast.setResourceType("22");
			}			
			if(ad_type == OTT_POWEROFF){
				//cast.setAdTypeId(201);
				cast.setDirectWay("a*c*p");
				cast.setResourceType("21");
			}		
			if(ad_type == OTT_SCREENSAVER || ad_type == MB_FOCUS_CIRCLE){
				//cast.setAdTypeId(202);
				cast.setDirectWay("a*c*p");
//				if(ad_type == OTT_SCREENSAVER){
//					cast.setResourceType("20");
//				}else{
//					cast.setResourceType("18");
//				}
				if("9".equals(all_channel)) {
					cast.setResourceType("18");
					cast.setInteractEffect(140);
				}else {
					cast.setResourceType("20");
					cast.setInteractEffect(136);
				}
				
			}		
			if(ad_type == OTT_DIS_REC){
				//cast.setAdTypeId(203);
				cast.setDirectWay("a*c*p");
				cast.setResourceType("19");
				cast.setInteractEffect(136);
			}		
			
			if(ad_type == MB_BF || ad_type == PC_BF) {
				if("1".equals(is_bf_position)&&bf_position!=null) {
					if(bf_position.equals("61082,61083,61084,61085,61086,61087,61109")) {
						cast.setResourceType("30");
						cast.setInteractEffect(1);
					}
					if(bf_position.equals("61088,61089,61090,61091,61092,61093")) {
						cast.setResourceType("29");
						cast.setInteractEffect(1);
					}
					if(bf_position.equals("61076,61077,61078,61079,61080,61081,61110")) {
						cast.setResourceType("28");
						cast.setInteractEffect(1);
					}
					if(bf_position.equals("61162,61163,61164,61165,61166,61167")) {
						cast.setResourceType("38");
						cast.setInteractEffect(1);
					}
				}
			}
			
			if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617){
               //cast.setAdTypeId(1101);
               cast.setResourceType("34");
			}
			//m?????????&&app???????????????
			if(ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541 || ad_type == MB_APP_PLAYING_BANNER ){
				//cast.setAdTypeId(1100);
				if("60675".equals(app_playing_banner_pos)||"60690".equals(app_playing_banner_pos)) {
					cast.setInteractEffect(114);
				}
				if("60676".equals(app_playing_banner_pos)) {
					cast.setInteractEffect(113);
				}
				cast.setResourceType("2");
			}
			if(ad_type == yk_vhtml_banner||ad_type == yk_vhtml_right_relative_banner||ad_type == yk_vhtml_banner1||ad_type == yk_vhtml_righttop||ad_type == yk_vhtml_comments||ad_type == yk_vhtml_RTB||ad_type == yk_vhtml_survey||
					ad_type == yk_vhtml_mb_web||ad_type == tudou_vhtml_banner1||ad_type == tudou_vhtml_UGC_banner||ad_type == tudou_vhtml_righttop||ad_type == tudou_vhtml_rightcenter||ad_type == tudou_vhtml_rightdown||
					ad_type == tudou_vhtml_commentDown||ad_type == tudou_vhtml_survey){
				//cast.setAdTypeId(1100);
				if(ad_type == yk_vhtml_right_relative_banner) {
					cast.setInteractEffect(153);
					cast.setResourceType("2");
				}
			}

            if("1".equals(isVidLimit)){
            	cast.setDirectWay("a*c*p*g");
            }else if(ad_type == MB_FEED || ad_type == YOUKU_FEEDAD){
            	cast.setDirectWay("a*c*p");
            }else{
            	cast.setDirectWay("a*c*p");
            }
            
			if("box".equals(parameter_names)){
				cast.setDirectWay("a*c*p*g*dq*box*brand");
			}		
			cast.setCastWay("cpm*camp");
			//ad_cast. interact_effect????????????????????????1.??????,2.??????,3.??????,4.crazy,5.adselector"???
			//cast.setInteractEffect(1);
			if (ad_type == NEW_SHORTFULL) {
				cast.setInteractEffect(2);
			}
			if (ad_type == NEW_SPECIALAD) {
				cast.setInteractEffect(4);
			}
			if (ad_type == NEW_ADSELECTOR) {
				cast.setInteractEffect(1);
			}
			
			if (ad_type == PC_FEEDS) {
				cast.setInteractEffect(143);
				cast.setResourceType("27");
			}
			
			if (ad_type == MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER||ad_type == MB_APP_HOMEPAGE||ad_type == m_playing_youku_phone_web_1425020640||ad_type ==m_playing_youku_ipad_web_1427883541
					|| ad_type == m_homepage_banner_web) {
				if(ad_type == MB_APPSEARCHBANNER) {
					cast.setInteractEffect(154);
				}
				if(ad_type == MB_APP_HOMEPAGE) {
					cast.setInteractEffect(117);
				}
				if(ad_type == MB_WENZILIAN) {
					cast.setInteractEffect(135);
				}
				cast.setCastWay("lun");
			}		
			cast.setSpeedType(0);	
			if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617){
				cast.setCastWay("cpc");
				cast.setSpeedType(1);
			}
			
			if (pc_vf_impression == 1 || m_vb_impression == 1 ||  m_vo_impression == 1) {
				System.out.println("---------" + interact_effect_type + "---------------");
				int m_interact_effect_type = Integer.parseInt(interact_effect_type);
				if(m_interact_effect_type == 23){
					cast.setInteractEffect(23);
				}else{
					cast.setInteractEffect(3);	
				}
			}
			//copyright_0???????????????,1???????????????" default="0"
			cast.setIsCopyright(0);
			cast.setPrice(1.0);
			//cast.setSpeedType(0);
			//type_priority(0:?????????/1:??????)
			//select type_priority ,count(*) from ad_cast group by type_priority; 
			cast.setTypePriority(5);
			cast.setProductPriority(Integer.parseInt(product_priority));
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
			//????????????
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
			    cast.setCastWay("cpc");
			}			
			//cpv
			if(product_reserve_method_cast == 7){
			    cast.setCastWay("cpv*camp");
			}		
			//mhtml(?????????)
			if(product_reserve_method_cast == 9){
			    cast.setCastWay("lun");
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
			//????????????loader??????
			if(pc_vf_impression_pc==1||pc_vob_impression_pc==1||pc_vb_impression_pc==1||pc_tp_impression_pc==1){
				cast.setInteractEffect(3);
			}		
			//trueview
			if(((product_reserve_method_cast == 7&&((pc_vf_impression_pc==2)||(pc_vf_impression==2)))||(product_reserve_method_cast == 7&&((pc_vf_impression_pc==2)||(pc_vf_impression==2))))
					||((product_reserve_method_cast == 7&&pc_vob_impression_pc==2)||(product_reserve_method_cast == 7&&pc_vb_impression_pc==2))
					||((product_reserve_method_cast == 7&&pc_tp_impression_pc==2)||(product_reserve_method_cast == 1&&pc_vob_impression_pc==2))
					||((product_reserve_method_cast == 1&&pc_vb_impression_pc==2)||(product_reserve_method_cast == 1&&pc_tp_impression_pc==2))||(product_reserve_method_cast == 1&&pc_vf_impression==2)||(product_reserve_method_cast == 1&&((pc_vf_impression_pc==2)||(pc_vf_impression==2))) || (product_reserve_method_cast == 4&&pc_vf_impression==2) || m_vo_impression == 2 || pc_vf_impression_pc == 2 || pc_vob_impression_pc == 2){
			    //cast.setCastWay("cpv*camp");
			    cast.setInteractEffect(6);
				cast.setSpeedType(1);
			}
			//?????????????????????????????????????????????????????????????????????,????????????????????? ??????????????????,?????????,????????????,???????????????,?????????-????????? ???
			if("25".equals(interact_effect_type) || "26".equals(interact_effect_type) || "27".equals(interact_effect_type) || "28".equals(interact_effect_type) || "30".equals(interact_effect_type) || "31".equals(interact_effect_type) || "32".equals(interact_effect_type) || "34".equals(interact_effect_type) || "35".equals(interact_effect_type) || "43".equals(interact_effect_type) || "56".equals(interact_effect_type) || "48".equals(interact_effect_type) ||"49".equals(interact_effect_type)||"148".equals(interact_effect_type) ||"161".equals(interact_effect_type) ||"162".equals(interact_effect_type) || "6".equals(interact_effect_type) || "168".equals(interact_effect_type)){
				cast.setInteractEffect(Integer.parseInt(interact_effect_type));
			}		
			int iil;			
			ArrayList alll = DBConnection.getInstance("atm").execQuerySql6("select id from ad_cast order by id desc limit 1");
			if (alll.size() == 0){
				iil = 0;
			}else{
				String aaal = (alll.get(0).toString()).substring(1, al.get(0).toString().length() - 1) + "";
				iil = Integer.parseInt(aaal);
			}
			
			//??????pdb??????s2s????????????????????????tanx???dspname??????(???????????????)-dspid=11142,dealid???????????????
			if("1".equals(is_ir)&&is_ir != null){
				if("2".equals(ir_type)){
					if(!"".equals(dsp_info)){
						cast.setDspId(dsp_info);
						cast.setDealId("0"+(iil + 1)); 
						cast.setInteractEffect(Integer.parseInt(creative_effect_type));
						cast.setPdbType(2);
					}else{
						cast.setDspId("0");
						cast.setDealId("0"); 
						//????????????sdk
						cast.setInteractEffect(Integer.parseInt(creative_effect_type));	
						cast.setPdbType(2);
					}					
				}else if("1".equals(ir_type)){
					cast.setDspId("0");
					cast.setDealId("0"+(iil + 1)); 
					cast.setInteractEffect(Integer.parseInt(creative_effect_type));
					cast.setPdbType(1);
				}else {
					cast.setDspId("0");
					cast.setDealId("0"); 
					cast.setPdbType(0);
				}
			}else{
				cast.setDspId("0");
				cast.setDealId("0"); 
				cast.setPdbType(0);
			}
			if(!"".equals(skiptimethreshold_text)&&skiptimethreshold_text != null){
				cast.setSkipTime(Integer.parseInt(skiptimethreshold_text));
			}
			cast.setChargeType(Integer.parseInt(charge_type));
			cast.setIsAiidTa(0);	
			cast.setOutside(0);
			//todo list
			//???????????????????????????????????????????????????pdb????????????atm??????pbak???1??????????????????cpm???cpv??????pbak???0
			cast.setPbak(0);
			cast.setIsArea(0);
			
			//?????????????????????ad_cast??????,?????????cast_position.mutex??????
			
			if(mutex != null){
				cast.setMutex(1);
			}else{
				cast.setMutex(0);
			}		
			
			cast.save();
			
			//adssp
			//String sql3dc = "select id from yes_dsp order by id desc limit 1;";
//			String sql3dc = "select dspname from yes_dsp where id = 11265;";
//			ArrayList al3dc = DBConnection.getInstance("adssp").execQuerySql8(sql3dc);
//			int dd110;
//			//catch al3dc is null exception
//			if (al3dc.size() == 0) {
//				dd110 = 0;
//			} else {
//				String c = (al3dc.get(0).toString()).substring(1, al3dc.get(0).toString().length() - 1) + "";
//				//dd110 = Integer.parseInt(c);
//				//c= new String(c.getBytes("ISO-8859-1"),"utf-8"); 
//				System.out.println("dd110110############################### is: " + c);
//			}
				
			//??????dc???
			//cal current dc table the latest dc_id:
			String sql2dc = "select id from dc order by id desc limit 1;";
			ArrayList al2dc = DBConnection.getInstance("atm").execQuerySql6(sql2dc);
			int dd;
			//catch al2dc is null exception
			if (al2dc.size() == 0) {
				dd = 0;
			} else {
				String c = (al2dc.get(0).toString()).substring(1, al2dc.get(0).toString().length() - 1) + "";
				dd = Integer.parseInt(c);
				System.out.println("dd is: " + dd);
			}
			insertDc(cast.getStartDate(), cast.getEndDate(), is_show_priority,product_reserve_method);
			//todo(??????sql????????????)
			String startTimeAdCast = start_date + " 00:00:00";
			String endTimeAdCast = end_date + " 23:59:59";
			String sql = "select id from dc where target_date >= " + "'" + startTimeAdCast + "'" + " and target_date <= " + "'" + endTimeAdCast + "'" + " and id>" + dd + ";";
			ArrayList al1dc = DBConnection.getInstance("atm").execQuerySql6(sql);
			//String a = (al1dc.get(0).toString()).substring(1,al.get(0).toString().length()-1) + "";
			//	int i = Integer.parseInt(a);
			System.out.println("sql1111111 is: " + sql + " al1dc.size= " + al1dc.size());
			int kk[] = new int[al1dc.size()];
			System.out.println("dc length is : " + kk.length);
			for (int iii = 0; iii < al1dc.size(); iii++) {
				String aaa = (al1dc.get(iii).toString()).substring(1, al1dc.get(0).toString().length() - 1) + "";
				int k = Integer.parseInt(aaa);
				kk[iii] = k;
				System.out.println("kk[" + iii + "] is:" + kk[iii]);
			}  
					
			//EasyCastUtil.getAdposition("101", "v", "7");
			String area_result = "";
			if(ad_type == m_homepage_banner_web){	
				
			}else{
				area_result = insertCastArea(all_area, cast.getId(), chk_area);
			}
			String allChannelInfo = "";
			if("1".equals(isVidLimit)){
				//do nothing
			}else if(ad_type == m_homepage_banner_web){
				
			}else{
				allChannelInfo = insertCastChannel(all_channel, cast.getId(), chk_channel);
			}
			insertCastPosition(cast.getId(), ad_type, pc_vc_tiepian_pos,
					v_position,vo_position,jiaobiao_position,is_show_v_position,is_show_vo_position,is_show_jiaobiao_position,video_group_area1,mutex,app_playing_banner_pos,app_homepage_pos,is_show_biaoban_position,biaoban_position,m_web_video_banner_pos,app_feed_pos,app_Adfeed_pos,is_show_screensaver_position,screensaver_position,is_show_disrec_position,disrec_position,is_show_xiami_lunbo_position,xiami_lunbo_position,all_channel,mb_focus_circle_pic_pos,yk_2_5_a_v_7,yk_2_5_a_v_7_p,interact_effect_type,is_bf_position,bf_position,app_Adfeed_spotlight_pos,feedAd_type_overall,pc_feeds_pos);
			if(ad_type == m_homepage_banner_web){
				insertHcastCpm(cast.getId(), cast.getStartDate(), cast.getEndDate(), product_reserve_method,total_lun,percent);
			}else if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617 || ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541){
				insertVhcastCpm(cast.getId(), cast.getStartDate(), cast.getEndDate(), product_reserve_method,total_lun,percent);
			}else{
				insertCastCpm(kk,cast.getId(), cast.getStartDate(), cast.getEndDate(), product_reserve_method,total_lun,percent,m_ztsdk, m_sdk);
			}
            //????????????
            insertCastFaceoff(ad_type,cast.getId(),isFaceoff,vid_faceoff);
			//insertCastDq
            if(resolution_setting != null) {
            	insertCastDq(cast.getId(),resolution_hd2,resolution_mp4,resolution_flv);
            }
			
			//insertCastDirection
			insertCastDirection(ad_type,cast.getId(),parameter_names,parameter_values);
			
			String pc_platform_all = "";
			if (ad_type == NEW_QIANTIE || ad_type == PC_BF || ad_type == NEW_ZHONGCHA || ad_type == NEW_HOUTIE || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR || ad_type ==NEW_SHORTFULL ||ad_type ==NEW_KAIJITU || ad_type ==NEW_TIEPIAN 
					|| ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617 || ad_type == NEW_JUCHANGBIAOBAN || ad_type == NEW_OVERLAY_FLOAT) {
				pc_platform_all = insertCastPlatform(ad_type,cast.getId(),pc_all_os,chk_os_pc);
			}
			String mb_platform = "";
			if (ad_type == MB_QIANTIE ||ad_type == MB_BF|| ad_type == MB_HOUTIE
					|| ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO
					|| ad_type == MB_ZANTING || ad_type == MB_QUANPING
					|| ad_type == MB_KAIJITU || ad_type ==MB_TIEPIAN || ad_type ==MB_WENZILIAN || ad_type ==MB_APPSEARCHBANNER ||ad_type == MB_APP_HOMEPAGE|| ad_type == MB_APP_PLAYING_BANNER ||ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541 || ad_type == MB_JUCHANGBIAOBAN  || ad_type == MB_ISP || ad_type == MB_FEED || ad_type == YOUKU_FEEDAD || ad_type == OTT_DISPLAY || ad_type == OTT_DIS_REC || ad_type == OTT_SCREENSAVER || ad_type == OTT_POWEROFF || ad_type == MB_scenario || ad_type == MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
				mb_platform = insertCastSubOs(ad_type, cast.getId(), all_os, chk_os);
			}
			//campaign
			if ("1".equals(is_show_campaign)) {
				if((campaignList_show=="")||("".equals(campaignList_show))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6("select id from campaign order by id desc limit 1");
					if (al1.size() == 0) {
						campaign.setId(1);
					} else {
						String d = (al1.get(0).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_show_name=="")||("".equals(campaign_show_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_" + ad_type + "_" + System.currentTimeMillis();
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
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_show);
					castCampaign.save();
				}else{
					//campaignList_show
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_show.substring(campaignList_show.lastIndexOf("("),campaignList_show.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_show);
					castCampaign.save();
				}	
			}
			if ("2".equals(is_click_campaign)) {
				if((campaignList_click=="")||("".equals(campaignList_click))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6("select id from campaign order by id desc limit 1");
					if (al1.size() == 0) {
						campaign.setId(1);
					} else {
						String d = (al1.get(0).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_click_name=="")||("".equals(campaign_click_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_" + ad_type + "_" + System.currentTimeMillis();
    					campaign.setName("("+(i1 + 1)+")"+campaign_name);
                    }else{
    					campaign.setName("("+(i1 + 1)+")"+campaign_click_name);
                    }
					campaign.setType(2);
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
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_click);
					castCampaign.save();
				}else{
					//campaignList_click
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_click.substring(campaignList_click.lastIndexOf("("),campaignList_click.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_click);
					castCampaign.save();
				}	
			}
			if ("3".equals(is_over_campaign)) {
				if((campaignList_over=="")||("".equals(campaignList_over))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6("select id from campaign order by id desc limit 1");
					if (al1.size() == 0) {
						campaign.setId(1);
					} else {
						String d = (al1.get(0).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_over_name=="")||("".equals(campaign_over_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_" + ad_type + "_" + System.currentTimeMillis();
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
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_over);
					castCampaign.save();
				}else{
					//campaignList_over
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_over.substring(campaignList_over.lastIndexOf("("),campaignList_over.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_over);
					castCampaign.save();
				}
			}
			if ("4".equals(is_skip_campaign)) {
				if((campaignList_skip=="")||("".equals(campaignList_skip))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6("select id from campaign order by id desc limit 1");
					if (al1.size() == 0) {
						campaign.setId(1);
					} else {
						String d = (al1.get(0).toString()).substring(1, al1.get(0).toString().length() - 1)	+ "";
						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_skip_name=="")||("".equals(campaign_skip_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_" + ad_type + "_" + System.currentTimeMillis();
    					campaign.setName("("+(i1 + 1)+")"+campaign_name);
                    }else{
    					campaign.setName("("+(i1 + 1)+")"+campaign_skip_name);
                    }
					campaign.setType(4);
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
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_skip);
					castCampaign.save();
				}else{
					//campaignList_skip
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_skip.substring(campaignList_skip.lastIndexOf("("),campaignList_skip.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_skip);
					castCampaign.save();
				}			
			}
			if ("5".equals(is_preload_campaign)) {
				if((campaignList_preload=="")||("".equals(campaignList_preload))){
					int i1=0;					
					Campaign campaign = new Campaign();
					//set campaign id
					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6("select id from campaign order by id desc limit 1");
					if (al1.size() == 0) {
						campaign.setId(1);
					} else {
						String d = (al1.get(0).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
						i1 = Integer.parseInt(d);
						campaign.setId(i1 + 1);
					}
                    if((campaign_preload_name=="")||("".equals(campaign_preload_name))){
    					String campaign_name = "campaign_" + cast.getId() + "_" + ad_type + "_" + System.currentTimeMillis();
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
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_preload);
					castCampaign.save();
				}else{
					//campaignList_preload
					CastCampaign castCampaign = new CastCampaign();
					castCampaign.setCastId(cast.getId());
					String str=campaignList_preload.substring(campaignList_preload.lastIndexOf("("),campaignList_preload.lastIndexOf(")"));
					String s=str.substring(1,str.length());
					castCampaign.setCampaignId(Integer.parseInt(s));
					//????????????
					castCampaign.setCampaignNum(campaign_sequence_preload);
					castCampaign.save();
				}	
			}      
			String videoGroupInfo = "";
			if ("1".equals(isVidLimit)) {
				videoGroupInfo = insertCastVideoGroupList(cast.getId(),video_group_area1, video_group_area2, video_group_area3,video_group_area4,video_group_area5);
			}else{
				videoGroupInfo = "?????????????????????";
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
			//???????????????
			if("1".equals(isVidKeywords)&&isVidKeywords!=null){
				String keyWords[] = vid_keywords.split("\r?\n");
				for(int i = 0; i < keyWords.length ; i++){
					CastKey castKey = new CastKey();
					castKey.setCastId(cast.getId());
					castKey.setDirectName("key");
					castKey.setDirectValue(keyWords[i]);
					castKey.setIsPositive(1);
					castKey.save();			
				}
			}			
			//????????????
			if("1".equals(isVidUser)&&isVidUser!=null){
				String users[] = vid_users.split("\r?\n");
				for(int i = 0; i < users.length ; i++){
					CastUser castUser = new CastUser();
					castUser.setCastId(cast.getId());
					castUser.setDirectName("user");
					castUser.setDirectValue(users[i]);
					castUser.setIsPositive(1);
					castUser.save();					
				}
			}			
			//???????????????????????????
			if("1".equals(isVidScene)&&isVidScene!=null){
				String scenes[] = vid_scene.split("\r?\n");
				for(int i = 0; i < scenes.length ; i++){
					CastDirection CastScene = new CastDirection();
					CastScene.setCastId(cast.getId());
					CastScene.setDirectName("scene");
					CastScene.setDirectValue(scenes[i]);
					CastScene.setIsPositive(1);
					CastScene.save();			
				}
			}						
			//???????????????????????????
			if("1".equals(isVidGoods)&&isVidGoods!=null){
				String goods[] = vid_goods.split("\r?\n");
				for(int i = 0; i < goods.length ; i++){
					CastDirection castGoods = new CastDirection();
					castGoods.setCastId(cast.getId());
					castGoods.setDirectName("goods");
					castGoods.setDirectValue(goods[i]);
					castGoods.setIsPositive(1);
					castGoods.save();			
				}
			}
			//????????????
			if("1".equals(isVidTag)&&isVidTag!=null){
				String tag[] = vid_tag.split("\r?\n");
				for(int i = 0; i < tag.length ; i++){
					CastTag castTag = new CastTag();
					castTag.setCastId(cast.getId());
					castTag.setDirectName("tag");
					String tagKeyValue[] = (tag[i]).split("\\|");
					for(int ky= 0;ky<tagKeyValue.length;ky++){
					     System.out.println("---------" + tagKeyValue[ky] + "---------------");
					}
					castTag.setDirectValue(tagKeyValue[1]);
					EasyCastUtil.setDmpServer(tagKeyValue[0], tagKeyValue[1]);
					castTag.setIsPositive(1);
					castTag.save();			
				}
			}			
			//??????????????????
			if("1".equals(isVidPartnerId)&&isVidPartnerId!=null){
				String partnerID[] = vid_partnerId.split("\r?\n");
				for(int i = 0; i < partnerID.length ; i++){
					CastPartnerid castPartnerId = new CastPartnerid();
					castPartnerId.setCastId(cast.getId());
					castPartnerId.setDirectName("partnerid");
					castPartnerId.setDirectValue(partnerID[i]);
					castPartnerId.setIsPositive(1);
					castPartnerId.save();				
				}
			}			
			//????????????
			if("1".equals(isVidPid)&&isVidPid!=null){
				String pids[] = vid_pids.split("\r?\n");
				for(int i = 0; i < pids.length ; i++){
					CastDirection castDirection = new CastDirection();
					castDirection.setCastId(cast.getId());
					castDirection.setDirectName("pid");
					castDirection.setDirectValue(pids[i]);
					castDirection.setIsPositive(1);
					castDirection.save();					
				}
			}			
			//?????????????????????
			if("1".equals(isOverlayFloat)&&isOverlayFloat!=null){
				String overlayFloat[] = overlayfloat.split("\r?\n");
				for(int i = 0; i < overlayFloat.length ; i++){
					CastDirection castDirection = new CastDirection();
					castDirection.setCastId(cast.getId());
					castDirection.setDirectName("float");
					castDirection.setDirectValue(overlayFloat[i]);
					castDirection.setIsPositive(1);
					castDirection.save();					
				}
			}	
			
			//????????????
			if("1".equals(isPressDownFloat)&&isPressDownFloat!=null){
				String pressDownFloat[] = pressdownfloat.split("\r?\n");
				for(int i = 0; i < pressDownFloat.length ; i++){
					CastDirection castDirection = new CastDirection();
					castDirection.setCastId(cast.getId());
					castDirection.setDirectName("vit");
					castDirection.setDirectValue(pressDownFloat[i]);
					castDirection.setIsPositive(1);
					castDirection.save();					
				}
			}	
			
			//???????????????
			if("1".equals(isDeviceFocus)&&isDeviceFocus!=null){
				String deviceFocus[] = DeviceFocus.split("\r?\n");
				for(int i = 0; i < deviceFocus.length ; i++){
					CastDirection castDirection = new CastDirection();
					castDirection.setCastId(cast.getId());
					castDirection.setDirectName("device");
					castDirection.setDirectValue(deviceFocus[i]);
					castDirection.setIsPositive(1);
					castDirection.save();					
				}
			}	
			
			//?????????time????????????24??????
			if(product_reserve_method_cast == 3){
				
				    Date utilDate1 = null;
				    Date utilDate2 = null;
				    String time1 = timePicker_starttime;
				    String time2 = timePicker_endtime;
					CastDirection castDirection = new CastDirection();
					castDirection.setCastId(cast.getId());
					castDirection.setDirectName("time");
					
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");// yyyy-mm-dd, ?????????????????????, ???????????????mm?????????: ???

					utilDate1 = sdf.parse(time1);
					utilDate2 = sdf.parse(time2);

					SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");

					String startTime = sdf1.format(utilDate1);
					String endTime = sdf1.format(utilDate2);
					
					castDirection.setDirectValue(startTime + "-" + endTime);
					castDirection.setIsPositive(1);
					castDirection.save();					
			}	
			
			return "??????id=" + cast.getId() + ":" + area_result + ":" + allChannelInfo + ":" + mb_platform + ":" + pc_platform_all + ":" + videoGroupInfo;
		} catch (Exception e) {
			//System.out.println(e);
			//logger.error(e.getStackTrace(),e);
			//System.out.println("***************" + e.getStackTrace());
			logger.error(e.getStackTrace(), e);
		}
		return "-1";
	}
	String insertCastArea(String all_area, int cast_id, String[] chk_area) {
		if (!"1".equals(all_area)&&chk_area != null) {
			String cast_result_area = "";
			for (String area_id : chk_area) {
				String[] area_value = area_id.split(":");
				System.out.println("area is**: " + area_id);
				cast_result_area = cast_result_area + area_value[1] + ",";
				try {
					CastArea castArea = new CastArea();
					castArea.setCastId(cast_id);
					castArea.setDirectName("area");
					String[] areaSpecific = area_value[0].split("_");
					castArea.setDirectValue(areaSpecific[1]);
					castArea.setIsPositive(1);
					castArea.save();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return "????????????(" + cast_result_area.substring(0,cast_result_area.length()-1) + ")";
		} else {
			List<Area> areaList = EasyCastUtil.getAllConfigAreas("province");
			try {
				//?????????????????????????????????????????????????????????????????????
				CastArea castArea = new CastArea();
				castArea.setCastId(cast_id);
				castArea.setDirectName("area");
				castArea.setDirectValue("86");
				castArea.setIsPositive(1);
				castArea.save();
				
				CastArea castArea1 = new CastArea();
				castArea1.setCastId(cast_id);
				castArea1.setDirectName("area");
				castArea1.setDirectValue("90");
				castArea1.setIsPositive(1);
				castArea1.save();
				
				return " ????????????(??????)";				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
              return "cast_area exception";
	}
	String insertCastChannel(String all_channel, int cast_id, String[] chk_channel) {
		 String channel_info = "";
		if (!"1".equals(all_channel)) {         
			try{
				if("2".equals(all_channel)){
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue("zw");
					//castChannel.setChannelId(channel_id);
					castChannel.setIsPositive(1);
					castChannel.save();
					channel_info = channel_info + "???????????? ";
				}			
				if("3".equals(all_channel)){
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue("35");
					//castChannel.setChannelId(channel_id);
					castChannel.setIsPositive(1);
					castChannel.save();
					channel_info = channel_info + "???????????? ";
				}			
				if("4".equals(all_channel)){
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue("ykn");
					//castChannel.setChannelId(channel_id);
					castChannel.setIsPositive(1);
					castChannel.save();
					channel_info = channel_info + "???????????? ";
				}			
				if("5".equals(all_channel)){
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue("tdn");
					//castChannel.setChannelId(channel_id);
					castChannel.setIsPositive(1);
					castChannel.save();
					channel_info = channel_info + "????????????";
				}			
				if("6".equals(all_channel)){
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue("yk");
					//castChannel.setChannelId(channel_id);
					castChannel.setIsPositive(1);
					castChannel.save();
					channel_info = channel_info + "???????????????";
				}			
				if("7".equals(all_channel)){
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue("td");
					//castChannel.setChannelId(channel_id);
					castChannel.setIsPositive(1);
					castChannel.save();
					channel_info = channel_info + "tudou?????????";
				}			
				if("8".equals(all_channel)){
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue("xy");
					//castChannel.setChannelId(channel_id);
					castChannel.setIsPositive(1);
					castChannel.save();
					channel_info = channel_info + "feed(??????)?????????";
				}
			}catch (Exception e){
				e.printStackTrace();
			}		
			if (chk_channel != null && !"".equals(chk_channel) && !"2".equals(all_channel) && !"3".equals(all_channel) && !"4".equals(all_channel) && !"5".equals(all_channel) && !"6".equals(all_channel) && !"7".equals(all_channel)) {
				for (String channel_id : chk_channel) {
					try {
						String[] channelInfo = channel_id.split(":");
						CastChannel castChannel = new CastChannel();
						castChannel.setCastId(cast_id);
						castChannel.setDirectName("channel");
						String[] channelSpecificInfo = channelInfo[0].split("_");
						castChannel.setDirectValue(channelSpecificInfo[1]);
						//castChannel.setChannelId(channel_id);
						castChannel.setIsPositive(1);
						castChannel.save();
						channel_info = channel_info + channelInfo[1] + ",";					
					} catch (Exception e) {
						e.printStackTrace();
					}
				}		
				return "????????????(" + channel_info.substring(0,channel_info.length()-1) + ")";		
			}

		} else {
			List<Channel> y_channelList = EasyCastUtil.getAllConfigChannels("ykn");
			List<Channel> t_channelList = EasyCastUtil.getAllConfigChannels("tdn");
			for (Channel channel : y_channelList) {
				try {
					CastChannel castChannel = new CastChannel();
					castChannel.setCastId(cast_id);
					castChannel.setDirectName("channel");
					castChannel.setDirectValue(channel.getId());
					castChannel.setIsPositive(1);
					castChannel.save();
					//return "???????????????youku?????????";
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
					//return "??????????????????????????????";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return "????????????(?????????????????????)";
		}
		
		return channel_info;
		
	}	
	String insertCastVideoGroupList(int cast_id,String video_group_area1,String video_group_area2,String video_group_area3,String video_group_area4,String video_group_area5){
	    try{
			if (video_group_area1 != null && !"".equals(video_group_area1)) {		
				String vid[] = video_group_area1.split("\r?\n");
			    //System.out.println("vid[0] is : " + vid[0] );
			    //System.out.println("vid[1] is : " + vid[1] );
				String video_id = insertVideoGroup(video_group_area1);
				String vids[] = video_id.split(" ");	
	            for(int i = 0; i < vid.length ; i++){
					VideoGroupList videoGroupList = new VideoGroupList();
					String sql3 = "select id from video_group_list order by id desc limit 1;";
					ArrayList al3 = DBConnection.getInstance("atm").execQuerySql6(sql3);
					if (al3.size() == 0) {
						videoGroupList.setId(1);
					} else {
						String e = (al3.get(0).toString()).substring(1, al3.get(0).toString().length() - 1) + "";
						int f = Integer.parseInt(e);
						System.out.println("f is: " + f);
						videoGroupList.setId(f + 1);
					}		
					if(((isNumeric(vids[i])==true)&&(vids[i].length() == 6))||((isNumeric(vids[i])==true)&&(vids[i].length() == 5))){
						//????????????s--???5??????6???
						videoGroupList.setType(3);
					}else if((isNumeric(vids[i])==true)&&(vids[i].length() == 7)){
						videoGroupList.setType(2);
					}else if(((isNumeric(vids[i])==true)&&((Integer.parseInt(vids[i]))<=999))||((isNumeric(vids[i])==true)&&((Integer.parseInt(vids[i]))>0))){
						//??????????????????setType(7)?????????youku??????
						videoGroupList.setType(1);
					}else{
						videoGroupList.setType(1);
					}
					videoGroupList.setValue(vids[i]);		
					String sql5 = "select video_group_id from video_group_list order by video_group_id desc limit 1;";
					ArrayList al5 = DBConnection.getInstance("atm").execQuerySql6(sql5);
					if (al5.size() == 0) {
						videoGroupList.setVideoGroupId(1);
					} else {
						String e1 = (al5.get(0).toString()).substring(1, al5.get(0).toString().length() - 1) + "";
						int f1 = Integer.parseInt(e1);
						System.out.println("f1 is: " + f1);
						if(i==0) {
							videoGroupList.setVideoGroupId(f1 + 1);
						}else {
							videoGroupList.setVideoGroupId(f1);
						}
						
					}				
					//videoGroupList.setVideoGroupId(Integer.parseInt(vids[i]));
					videoGroupList.setStatus(1);
					videoGroupList.save();
					if(i==0) {
	                    CastDirection castDirection = new CastDirection();
	                    castDirection.setCastId(cast_id);
	                    castDirection.setDirectName("videogroup");
	                    castDirection.setDirectValue(videoGroupList.getVideoGroupId() + "");
	                    castDirection.setIsPositive(1);
	                    castDirection.save();					
					}

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
					ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
					if (al4.size() == 0) {
						videoGroupList1.setId(1);
					} else {
						String g = (al4.get(0).toString()).substring(1, al4.get(0).toString().length() - 1)	+ "";
						int h = Integer.parseInt(g);
						System.out.println("h is: " + h);
						videoGroupList1.setId(h + 1);
					}		
					if((isNumeric(vids[i])==true)&&((vids[i].length() == 6)||(vids[i].length() == 5))){
						videoGroupList1.setType(6);
					}else if((isNumeric(vids[i])==true)&&(vids[i].length() == 7)){
						videoGroupList1.setType(5);
					}else if(((isNumeric(vids[i])==true)&&((Integer.parseInt(vids[i]))<=999))||((isNumeric(vids[i])==true)&&((Integer.parseInt(vids[i]))>0))){
						videoGroupList1.setType(4);
					}else{
						videoGroupList1.setType(4);
					}				
					//video_id = insertVideoGroupTD(video_group_area2);
					videoGroupList1.setValue(vids[i]);		
					String sql6 = "select video_group_id from video_group_list order by video_group_id desc limit 1;";
					ArrayList al6 = DBConnection.getInstance("atm").execQuerySql6(sql6);
					if (al6.size() == 0) {
						videoGroupList1.setVideoGroupId(1);
					} else {
						String e2 = (al6.get(0).toString()).substring(1, al6.get(0).toString().length() - 1) + "";
						int f2 = Integer.parseInt(e2);
						System.out.println("f2 is: " + f2);
						
						if(i==0) {
							videoGroupList1.setVideoGroupId(f2 + 1);
						}else {
							videoGroupList1.setVideoGroupId(f2);
						}
						
						//videoGroupList1.setVideoGroupId(f2 + 1);
					}		
					//videoGroupList1.setVideoGroupId(Integer.parseInt(vids[i]));
					videoGroupList1.setStatus(1);
					videoGroupList1.save();
					//insertVideoGroup(cast.getId(), video_group_area1);
					if(i==0) {
	                    CastDirection castDirection = new CastDirection();
	                    castDirection.setCastId(cast_id);
	                    castDirection.setDirectName("videogroup");
	                    castDirection.setDirectValue(videoGroupList1.getVideoGroupId() + "");
	                    castDirection.setIsPositive(1);
	                    castDirection.save();	
					}
				}		
			}	
			
			if(video_group_area4 != null && !"".equals(video_group_area4)){				
				String vid[] = video_group_area4.split("\r?\n");
				String video_id = insertVideoGroup(video_group_area4);
				String vids[] = video_id.split(" ");		
	            for(int i = 0; i < vid.length ; i++){
					VideoGroupList videoGroupList = new VideoGroupList();
					String sql3 = "select id from video_group_list order by id desc limit 1;";
					ArrayList al3 = DBConnection.getInstance("atm").execQuerySql6(sql3);
					if (al3.size() == 0) {
						videoGroupList.setId(1);
					} else {
						String e = (al3.get(0).toString()).substring(1, al3.get(0).toString().length() - 1) + "";
						int f = Integer.parseInt(e);
						System.out.println("f is: " + f);
						videoGroupList.setId(f + 1);
					}
					videoGroupList.setType(8);
				    videoGroupList.setValue(vids[i]);		
					String sql5 = "select video_group_id from video_group_list order by video_group_id desc limit 1;";
					ArrayList al5 = DBConnection.getInstance("atm").execQuerySql6(sql5);
					if (al5.size() == 0) {
						videoGroupList.setVideoGroupId(1);
					} else {
						String e1 = (al5.get(0).toString()).substring(1, al5.get(0).toString().length() - 1) + "";
						int f1 = Integer.parseInt(e1);
						System.out.println("f1 is: " + f1);
						
						if(i==0) {
							videoGroupList.setVideoGroupId(f1 + 1);
						}else {
							videoGroupList.setVideoGroupId(f1);
						}
						
						//videoGroupList.setVideoGroupId(f1 + 1);
					}			
					//videoGroupList.setVideoGroupId(Integer.parseInt(vids[i]));
					videoGroupList.setStatus(1);
					videoGroupList.save();
					
					if(i==0) {
	                    CastDirection castDirection = new CastDirection();
	                    castDirection.setCastId(cast_id);
	                    castDirection.setDirectName("videogroup");
	                    castDirection.setDirectValue(videoGroupList.getVideoGroupId() + "");
	                    castDirection.setIsPositive(1);
	                    castDirection.save();
					}
					
	            }			
			}
			
			//yks????????????id
			if(video_group_area5 != null && !"".equals(video_group_area5)){				
				String vid[] = video_group_area5.split("\r?\n");
				String video_id = insertVideoGroupProgrammeId(video_group_area5);
				String vids[] = video_id.split(" ");		
	            for(int i = 0; i < vid.length ; i++){
					VideoGroupList videoGroupList = new VideoGroupList();
					String sql3 = "select id from video_group_list order by id desc limit 1;";
					ArrayList al3 = DBConnection.getInstance("atm").execQuerySql6(sql3);
					if (al3.size() == 0) {
						videoGroupList.setId(1);
					} else {
						String e = (al3.get(0).toString()).substring(1, al3.get(0).toString().length() - 1) + "";
						int f = Integer.parseInt(e);
						System.out.println("f is: " + f);
						videoGroupList.setId(f + 1);
					}
					videoGroupList.setType(3);
				    videoGroupList.setValue(vids[i]);		
					String sql5 = "select video_group_id from video_group_list order by video_group_id desc limit 1;";
					ArrayList al5 = DBConnection.getInstance("atm").execQuerySql6(sql5);
					if (al5.size() == 0) {
						videoGroupList.setVideoGroupId(1);
					} else {
						String e1 = (al5.get(0).toString()).substring(1, al5.get(0).toString().length() - 1) + "";
						int f1 = Integer.parseInt(e1);
						System.out.println("f1 is: " + f1);
						
						if(i==0) {
							videoGroupList.setVideoGroupId(f1 + 1);
						}else {
							videoGroupList.setVideoGroupId(f1);
						}
						
						//videoGroupList.setVideoGroupId(f1 + 1);
					}			
					//videoGroupList.setVideoGroupId(Integer.parseInt(vids[i]));
					videoGroupList.setStatus(1);
					videoGroupList.save();
					
					if(i==0) {
	                    CastDirection castDirection = new CastDirection();
	                    castDirection.setCastId(cast_id);
	                    castDirection.setDirectName("videogroup");
	                    castDirection.setDirectValue(videoGroupList.getVideoGroupId() + "");
	                    castDirection.setIsPositive(1);
	                    castDirection.save();
					}
					
	            }			
			}
			
			if(video_group_area3 != null && !"".equals(video_group_area3)){
				String[] sy_resource = null;
				if(video_group_area3.contains(":")){
					sy_resource = video_group_area3.split(":");
				}else if(video_group_area3.contains("???")){
					sy_resource = video_group_area3.split("???");
				}
					VideoGroupList videoGroupList = new VideoGroupList();
					String sql3 = "select id from video_group_list order by id desc limit 1;";
					ArrayList al3 = DBConnection.getInstance("atm").execQuerySql6(sql3);
						String e = (al3.get(0).toString()).substring(1, al3.get(0).toString().length() - 1) + "";
						int f = Integer.parseInt(e);
						System.out.println("f is: " + f);
						videoGroupList.setId(f + 1);			
					if(sy_resource[0].contains("??????")){
						videoGroupList.setType(9);
					}else if(sy_resource[0].contains("??????")){
						videoGroupList.setType(11);
					}
					videoGroupList.setValue(sy_resource[1]);					
					String sql5 = "select video_group_id from video_group_list order by video_group_id desc limit 1;";
					ArrayList al5 = DBConnection.getInstance("atm").execQuerySql6(sql5);
						String e1 = (al5.get(0).toString()).substring(1, al5.get(0).toString().length() - 1) + "";
						int f1 = Integer.parseInt(e1);
						System.out.println("f1 is: " + f1);
						videoGroupList.setVideoGroupId(f1 + 1);
					//videoGroupList.setVideoGroupId(Integer.parseInt(vids[i]));
					videoGroupList.setStatus(1);
					videoGroupList.save();
                    CastDirection castDirection = new CastDirection();
                    castDirection.setCastId(cast_id);
                    castDirection.setDirectName("videogroup");
                    castDirection.setDirectValue(videoGroupList.getVideoGroupId() + "");
                    castDirection.setIsPositive(1);
                    castDirection.save();  
					CastDirection cd1 = new CastDirection();
					cd1.setCastId(cast_id);
					cd1.setDirectName("znw");
					cd1.setDirectValue("0");
					cd1.setIsPositive(1);
					cd1.save();
	            }
			
	    } catch (Exception e){
          	e.printStackTrace();		
	    }
		return "???????????????(youku-" + video_group_area1 + "::tudou-" + video_group_area2 + "::??????-" + video_group_area3 + "::YOUKU??????-" + video_group_area4 + "::YOUKU??????id(??????s)-" + video_group_area5 + ")";
	}
	void insertCastPosition(int cast_id, int ad_type, String pc_vc_tiepian_pos,
			String[] v_position,String[] vo_position,String[] jiaobiao_position,String is_show_v_position,String is_show_vo_position,String is_show_jiaobiao_position,String video_group_area1,String mutex,String app_playing_banner_pos,String app_homepage_pos,String is_show_biaoban_position,String[] biaoban_position,String m_web_video_banner_pos,String app_feed_pos,String app_Adfeed_pos,String is_show_screensaver_position,String[] screensaver_position,String is_show_disrec_position,String[] disrec_position,String is_show_xiami_lunbo_position,String[] xiami_lunbo_position,String all_channel,String mb_focus_circle_pic_pos,String yk_2_5_a_v_7,String yk_2_5_a_v_7_p,String interact_effect_type,String is_bf_position,String bf_position,String app_Adfeed_spotlight_pos,String feedAd_type_overall,String pc_feeds_pos) {
		try {
			if (ad_type == NEW_QIANTIE || ad_type == MB_QIANTIE) {
				if("1".equals(is_show_v_position)&&v_position!=null){
					String ssp_new_v_qiantie = "";
					for (String v_position_id : v_position) {
						if(!"-11".equals(v_position_id)&&!"-12".equals(v_position_id)&&!"-13".equals(v_position_id)) {
							CastPosition castPosition = new CastPosition();
							castPosition.setCastId(cast_id);
							castPosition.setDirectName("adposition");
							castPosition.setDirectValue(v_position_id);                
							if(mutex != null){
								castPosition.setMutex(1);
							}else{
								castPosition.setMutex(0);
							}						
							castPosition.setIsPositive(1);
							castPosition.save();
						}

						int v_position_int = Integer.parseInt(v_position_id);
						switch(v_position_int){
						case(2):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("1", "v", "35") + "," ;
						    break;
						case(3):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("2", "v", "35") + "," ;
						    break;
						case(9):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("3", "v", "35") + "," ;
						    break;
						case(20):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("4", "v", "35") + "," ;
						    break;
						case(21):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("5", "v", "35") + "," ;
						    break;
						case(22):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("6", "v", "35") + "," ;
						    break;
						case(-11):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("-1", "v", "35") + "," ;
					        break;
						case(-12):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("-2", "v", "35") + "," ;
					        break;
						case(-13):
							ssp_new_v_qiantie = ssp_new_v_qiantie + EasyCastUtil.getAdposition("-3", "v", "35") + "," ;
					        break;
						default: 
							System.out.println("default"); 
							break; 
						}
					}
					//ssp???????????????
					CastPosition castPosition = new CastPosition();
					castPosition.setCastId(cast_id);
					castPosition.setDirectName("position");
					castPosition.setDirectValue(ssp_new_v_qiantie.substring(0, ssp_new_v_qiantie.length()-1));
					if(mutex != null){
						castPosition.setMutex(1);
					}else{
						castPosition.setMutex(0);
					}	
					castPosition.setIsPositive(1);
					castPosition.save();				
				}else{
					CastPosition castPosition1 = new CastPosition();
					castPosition1.setCastId(cast_id);
					castPosition1.setDirectName("adposition");
					castPosition1.setDirectValue("10001");
					castPosition1.setMutex(0);
					castPosition1.setIsPositive(1);
					castPosition1.save();				
					//ssp???????????????
					String adPositions = EasyCastUtil.getAdposition("101", "v", "35");
					CastPosition castPosition2 = new CastPosition();
					castPosition2.setCastId(cast_id);
					castPosition2.setDirectName("position");
					castPosition2.setDirectValue(adPositions);
					castPosition2.setMutex(0);
					castPosition2.setIsPositive(1);
					castPosition2.save();
				}
			}
			if (ad_type == NEW_HOUTIE || ad_type == MB_HOUTIE) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("5");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();				
				//ssp???????????????
				String adPositions = EasyCastUtil.getAdposition("v", "32");
				CastPosition castPosition2 = new CastPosition();
				castPosition2.setCastId(cast_id);
				castPosition2.setDirectName("position");
				castPosition2.setDirectValue(adPositions);
				castPosition2.setMutex(0);
				castPosition2.setIsPositive(1);
				castPosition2.save();
			}		
			
			if(ad_type == MB_BF || ad_type == PC_BF) {
				if("1".equals(is_bf_position)&&bf_position!=null) {
					CastPosition castPosition = new CastPosition();
					castPosition.setCastId(cast_id);
					castPosition.setDirectName("position");
					castPosition.setDirectValue(bf_position);
					castPosition.setMutex(0);
					castPosition.setIsPositive(1);
					castPosition.save();
				}
			}
			
			if(ad_type == PC_FEEDS) {
					CastPosition castPosition = new CastPosition();
					castPosition.setCastId(cast_id);
					castPosition.setDirectName("position");
					castPosition.setDirectValue(pc_feeds_pos);
					castPosition.setMutex(0);
					castPosition.setIsPositive(1);
					castPosition.save();
			}
			
			if (ad_type == NEW_TIEPIAN || ad_type == MB_TIEPIAN) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("0");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();			
				//ssp???????????????
				String adPositions = EasyCastUtil.getAdposition("101", "v", "35,33,32");
				CastPosition castPosition2 = new CastPosition();
				castPosition2.setCastId(cast_id);
				castPosition2.setDirectName("position");
				castPosition2.setDirectValue(adPositions);
				castPosition2.setMutex(0);
				castPosition2.setIsPositive(1);
				castPosition2.save();
			}    
         if (ad_type == NEW_JIAOBIAO || ad_type == MB_JIAOBIAO) {
        	 if("1".equals(interact_effect_type)){
        		 if("1".equals(is_show_jiaobiao_position)&&jiaobiao_position!=null){
 					String ssp_new_v_jiaobiao = "";
 					for (String jiaobiao_position_id : jiaobiao_position) {
 						CastPosition castPosition = new CastPosition();
 						castPosition.setCastId(cast_id);
 						castPosition.setDirectName("adposition");
 						castPosition.setDirectValue(jiaobiao_position_id);                						
 						castPosition.setIsPositive(1);
 						castPosition.save();
 						int jiaobiao_position_int = Integer.parseInt(jiaobiao_position_id);
 						switch(jiaobiao_position_int){
 						case(10):
 							//????????????????????????(pos_type=25/17)
 							ssp_new_v_jiaobiao = ssp_new_v_jiaobiao + EasyCastUtil.getAdposition("0", "v", "25") + "," ;
 						    break;
 						case(180):
 							ssp_new_v_jiaobiao = ssp_new_v_jiaobiao + EasyCastUtil.getAdposition("1", "v", "25") + "," ;
 						    break;
 						case(181):
 							ssp_new_v_jiaobiao = ssp_new_v_jiaobiao + EasyCastUtil.getAdposition("2", "v", "25") + "," ;
 						    break;
 						case(182):
 							ssp_new_v_jiaobiao = ssp_new_v_jiaobiao + EasyCastUtil.getAdposition("3", "v", "25") + "," ;
 						    break;
 						default: 
 							System.out.println("default"); 
 							break; 
 						}
 					}
 					//ssp???????????????
 					CastPosition castPosition = new CastPosition();
 					castPosition.setCastId(cast_id);
 					castPosition.setDirectName("position");
 					castPosition.setDirectValue(ssp_new_v_jiaobiao.substring(0, ssp_new_v_jiaobiao.length()-1));	
 					castPosition.setIsPositive(1);
 					castPosition.save();
 	        }else{
 		            CastPosition castPosition1 = new CastPosition();
 		            castPosition1.setCastId(cast_id);
 		            castPosition1.setDirectName("adposition");
 		            castPosition1.setDirectValue("10004");
 		            castPosition1.setMutex(0);
 		            castPosition1.setIsPositive(1);
 		            castPosition1.save();		            
 					String adPositions = EasyCastUtil.getAdposition("v", "25");
 					CastPosition castPosition2 = new CastPosition();
 					castPosition2.setCastId(cast_id);
 					castPosition2.setDirectName("position");
 					castPosition2.setDirectValue(adPositions);
 					castPosition2.setMutex(0);
 					castPosition2.setIsPositive(1);
 					castPosition2.save();
 	             } 
        	 }else if("35".equals(interact_effect_type)){
		            CastPosition castPosition1 = new CastPosition();
		            castPosition1.setCastId(cast_id);
		            castPosition1.setDirectName("adposition");
		            castPosition1.setDirectValue("10004");
		            castPosition1.setMutex(0);
		            castPosition1.setIsPositive(1);
		            castPosition1.save();		            
					String adPositions = EasyCastUtil.getAdposition("v", "17");
					CastPosition castPosition2 = new CastPosition();
					castPosition2.setCastId(cast_id);
					castPosition2.setDirectName("position");
					castPosition2.setDirectValue(adPositions);
					castPosition2.setMutex(0);
					castPosition2.setIsPositive(1);
					castPosition2.save();
        	 }
	         
          }            
			if (ad_type == NEW_ZHONGCHA || ad_type == MB_ZHONGCHA) {
				if("1".equals(is_show_vo_position)&&vo_position!=null){
					String ssp_new_v_zhongcha = "";
					for (String vo_position_id : vo_position) {
						CastPosition castPosition = new CastPosition();
						castPosition.setCastId(cast_id);
						castPosition.setDirectName("adposition");
						castPosition.setDirectValue(vo_position_id);                						
						castPosition.setIsPositive(1);
						castPosition.save();
						int vo_position_int = Integer.parseInt(vo_position_id);
						switch(vo_position_int){
						case(10013):
							ssp_new_v_zhongcha = ssp_new_v_zhongcha + EasyCastUtil.getAdposition("0", "v", "33") + "," ;
						    break;
						case(10014):
							ssp_new_v_zhongcha = ssp_new_v_zhongcha + EasyCastUtil.getAdposition("1", "v", "33") + "," ;
						    break;
						case(10015):
							ssp_new_v_zhongcha = ssp_new_v_zhongcha + EasyCastUtil.getAdposition("2", "v", "33") + "," ;
						    break;
						case(10016):
							ssp_new_v_zhongcha = ssp_new_v_zhongcha + EasyCastUtil.getAdposition("3", "v", "33") + "," ;
						    break;
						case(40):
							ssp_new_v_zhongcha = ssp_new_v_zhongcha + EasyCastUtil.getAdposition("0", "v", "33", "1") + "," ;
						    break;
						case(41):
							ssp_new_v_zhongcha = ssp_new_v_zhongcha + EasyCastUtil.getAdposition("0", "v", "33", "2") + "," ;
						    break;
						case(42):
							ssp_new_v_zhongcha = ssp_new_v_zhongcha + EasyCastUtil.getAdposition("0", "v", "33", "3") + "," ;
						    break;
						case(43):
							ssp_new_v_zhongcha = ssp_new_v_zhongcha + EasyCastUtil.getAdposition("0", "v", "33", "4") + "," ;
						    break;
						default: 
							System.out.println("default"); 
							break; 
						}
					}
					//ssp???????????????
					CastPosition castPosition = new CastPosition();
					castPosition.setCastId(cast_id);
					castPosition.setDirectName("position");
					castPosition.setDirectValue(ssp_new_v_zhongcha.substring(0, ssp_new_v_zhongcha.length()-1));	
					castPosition.setIsPositive(1);
					castPosition.save();
				}else{
					CastPosition castPosition1 = new CastPosition();
					castPosition1.setCastId(cast_id);
					castPosition1.setDirectName("adposition");
					castPosition1.setDirectValue("10002");
					castPosition1.setMutex(0);
					castPosition1.setIsPositive(1);
					castPosition1.save();				
					//ssp???????????????(???????????????????????????)
					String adPositions = EasyCastUtil.getAdposition("v", "33");
					CastPosition castPosition2 = new CastPosition();
					castPosition2.setCastId(cast_id);
					castPosition2.setDirectName("position");
					castPosition2.setDirectValue(adPositions);
					castPosition2.setMutex(0);
					castPosition2.setIsPositive(1);
					castPosition2.save();					
				}
			}
			if (ad_type == NEW_ZANTING || ad_type == MB_ZANTING) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("4");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();				
				//select count(*) from ad_position where type = 'v' and pos_type in (26);
				String adPositions = EasyCastUtil.getAdposition("v","26");
				CastPosition castPosition2 = new CastPosition();
				castPosition2.setCastId(cast_id);
				castPosition2.setDirectName("position");
				castPosition2.setDirectValue(adPositions);
				castPosition2.setMutex(0);
				castPosition2.setIsPositive(1);
				castPosition2.save();
				
			}
			
			//???????????????????????????todo
			if (ad_type == MB_QUANPING) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("310");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();			
				//ssp???????????????(??????????????????????????????????????????)
				String adPositions = EasyCastUtil.getAdposition("1","v","35");
				CastPosition castPosition2 = new CastPosition();
				castPosition2.setCastId(cast_id);
				castPosition2.setDirectName("position");
				castPosition2.setDirectValue(adPositions);
				
				castPosition2.setMutex(0);
				castPosition2.setIsPositive(1);
				castPosition2.save();
			}
			if (ad_type == MB_KAIJITU || ad_type == NEW_KAIJITU) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("300");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();				
				String adPositions = EasyCastUtil.getAdposition("a","24");
				CastPosition castPosition1 = new CastPosition();
				castPosition1.setCastId(cast_id);
				castPosition1.setDirectName("position");
				castPosition1.setDirectValue(adPositions);
				castPosition1.setMutex(0);
				castPosition1.setIsPositive(1);
				castPosition1.save();				
			}
			if (ad_type == NEW_SHORTFULL) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("2");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();			
				//ssp???????????????
				String adPositions = EasyCastUtil.getAdposition("1", "v", "35");
				CastPosition castPosition1 = new CastPosition();
				castPosition1.setCastId(cast_id);
				castPosition1.setDirectName("position");
				castPosition1.setDirectValue(adPositions);
				castPosition1.setMutex(0);
				castPosition1.setIsPositive(1);
				castPosition1.save();
			}
			if (ad_type == NEW_SPECIALAD) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("2");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();
				
				//ssp???????????????
				String adPositions = EasyCastUtil.getAdposition("1", "v", "35");
				CastPosition castPosition1 = new CastPosition();
				castPosition1.setCastId(cast_id);
				castPosition1.setDirectName("position");
				castPosition1.setDirectValue(adPositions);
				castPosition1.setMutex(0);
				castPosition1.setIsPositive(1);
				castPosition1.save();
			}
			//ad_type == NEW_ADSELECTOR
			if (ad_type == NEW_ADSELECTOR) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("2");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();				
				//ssp???????????????
				String adPositions = EasyCastUtil.getAdposition("1", "v", "35");
				CastPosition castPosition1 = new CastPosition();
				castPosition1.setCastId(cast_id);
				castPosition1.setDirectName("position");
				castPosition1.setDirectValue(adPositions);
				castPosition1.setMutex(0);
				castPosition1.setIsPositive(1);
				castPosition1.save();
			}			
			//ad_type == MB_WENZILIAN
			if (ad_type == MB_WENZILIAN) {
				CastHposition castHposition = new CastHposition();
				castHposition.setCastId(cast_id);
				castHposition.setDirectName("hposition");
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6("select id from h_position where value = 1411701755;");
				if (al11.size() == 0) {
					ArrayList al12 = DBConnection.getInstance("atm").execQuerySql6("select id from h_position order by id desc limit 1");
					String a = (al12.get(0).toString()).substring(1, al12.get(0).toString().length() - 1) + "";
					int i = Integer.parseInt(a);
					//idea.setId(i + 1);				
					HPosition h_Position = new HPosition();
					h_Position.setId(i + 1);
					h_Position.setParentId(-1);
					h_Position.setName("youku_????????????????????????????????????");
					h_Position.setType(6);
					h_Position.setValue(1411701755);
					h_Position.setTemplet("");
					h_Position.setStatus(1);
					h_Position.save();					
					castHposition.setDirectValue(i + 1);
					castHposition.setIsPositive(1);
					castHposition.save();
				}else{					
					String adPositions = EasyCastUtil.getAdposition("914", "h", "6");
					CastPosition castPosition = new CastPosition();
					castPosition.setCastId(cast_id);
					castPosition.setDirectName("position");
					castPosition.setDirectValue(adPositions);
					castPosition.setMutex(0);
					castPosition.setIsPositive(1);
					castPosition.save();
					
				}			
			}		
			//ad_type == m_homepage_banner_web
			//??????????????????
			if (ad_type == m_homepage_banner_web) {
				CastHposition castHposition = new CastHposition();
				castHposition.setCastId(cast_id);
				castHposition.setDirectName("hposition");
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6("select id from h_position where value = " + m_web_video_banner_pos + ";");
					String a = (al11.get(0).toString()).substring(1, al11.get(0).toString().length() - 1) + "";
					int i = Integer.parseInt(a);
					castHposition.setDirectValue(i);
					castHposition.setIsPositive(1);
					castHposition.save();							
			}		
		
			//ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541
			//??????????????????
			if (ad_type == m_playing_youku_phone_web_1425020640) {
		        System.out.println("#######"+ "m_playing_youku_phone_web_1425020640");
				CastHposition castHposition = new CastHposition();
				castHposition.setCastId(cast_id);
				castHposition.setDirectName("hposition");
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6("select id from h_position where value = 1425020640;");
					String a = (al11.get(0).toString()).substring(1, al11.get(0).toString().length() - 1) + "";
					int i = Integer.parseInt(a);
					castHposition.setDirectValue(i);
					castHposition.setIsPositive(1);
					castHposition.save();							
			}
			//??????????????????
			if (ad_type == m_playing_youku_ipad_web_1427883541) {
				CastHposition castHposition = new CastHposition();
				castHposition.setCastId(cast_id);
				castHposition.setDirectName("hposition");
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6("select id from h_position where value = 1427883541;");
					String a = (al11.get(0).toString()).substring(1, al11.get(0).toString().length() - 1) + "";
					int i = Integer.parseInt(a);
					castHposition.setDirectValue(i);
					castHposition.setIsPositive(1);
					castHposition.save();							
			}
			
			//???????????????(??????????????????????????????)
			if (ad_type == YOUKU_FEEDAD) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("position");
				if("1".equals(feedAd_type_overall)) {
					castPosition.setDirectValue(app_Adfeed_pos);
				}else {
					castPosition.setDirectValue(app_Adfeed_spotlight_pos);
				}
				
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();					
			}	
			
			//ad_type == NEW_BUYINGSEEING
			if (ad_type == NEW_BUYINGSEEING || ad_type == MB_scenario) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6("select id from v_position where id = 500;");
				if (al11.size() == 0) {				
					VPosition v_Position = new VPosition();
					v_Position.setId(500);
					v_Position.setParentId(-1);
					v_Position.setName("????????????");
					v_Position.setManageType("s");
					v_Position.setPs(0);
					v_Position.setAdSeq(1);
					v_Position.setType(1);
					v_Position.setStatus(1);
					v_Position.save();				
					castPosition.setDirectValue("500");
					castPosition.setIsPositive(1);
					castPosition.save();
				}else{
					String adPositions = "";
					castPosition.setDirectValue("500");
					castPosition.setIsPositive(1);
					castPosition.save();

					adPositions = EasyCastUtil.getAdposition("v", "8,9");
					CastPosition castPosition1 = new CastPosition();
					castPosition1.setCastId(cast_id);
					castPosition1.setDirectName("position");
					castPosition1.setDirectValue(adPositions);
					castPosition1.setMutex(0);
					castPosition1.setIsPositive(1);
					castPosition1.save();
				}	
			}			
			//???????????????//ad_type == MB_ISP
			if (ad_type == MB_ISP) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6("select id from v_position where id = 600;");
				if (al11.size() == 0) {			
					VPosition v_Position = new VPosition();
					v_Position.setId(600);
					v_Position.setParentId(-1);
					v_Position.setName("???????????????");
					v_Position.setManageType("n");
					v_Position.setPs(0);
					v_Position.setAdSeq(-1);
					v_Position.setType(1);
					v_Position.setStatus(1);
					v_Position.save();				
					castPosition.setDirectValue("600");
					castPosition.setIsPositive(1);
					castPosition.save();
				}else{
					castPosition.setDirectValue("600");
					castPosition.setIsPositive(1);
					castPosition.save();
					
					//???????????????????????????
					String adPositions = EasyCastUtil.getAdposition("928", "h","36");
					CastPosition castPosition1 = new CastPosition();
					castPosition1.setCastId(cast_id);
					castPosition1.setDirectName("position");
					castPosition1.setDirectValue(adPositions);
					castPosition1.setMutex(0);
					castPosition1.setIsPositive(1);
					castPosition1.save();
				}	
			}			
			//ott????????????/??????(??????)
			if (ad_type == OTT_DISPLAY) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("700");
				castPosition.setIsPositive(1);
				castPosition.save();	
				
				String adPositions = EasyCastUtil.getAdposition("a","22");
				CastPosition castPosition1 = new CastPosition();
				castPosition1.setCastId(cast_id);
				castPosition1.setDirectName("position");
				castPosition1.setDirectValue(adPositions);
				castPosition1.setMutex(0);
				castPosition1.setIsPositive(1);
				castPosition1.save();				
			}			
			if (ad_type == OTT_DIS_REC) {
		         if("1".equals(is_show_disrec_position)&&disrec_position!=null){
			         for (String DISREC_position_id : disrec_position) {
				        CastPosition castPosition = new CastPosition();
				        castPosition.setCastId(cast_id);
				        castPosition.setDirectName("adposition");
				        castPosition.setDirectValue(DISREC_position_id);
				        castPosition.setMutex(0);
				        castPosition.setIsPositive(1);
				        castPosition.save();
			             }
		        }else{
			            CastPosition castPosition1 = new CastPosition();
			            castPosition1.setCastId(cast_id);
			            castPosition1.setDirectName("adposition");
			            //??????ott??????????????????????????????(11001->400)
			            castPosition1.setDirectValue("400");
			            castPosition1.setMutex(0);
			            castPosition1.setIsPositive(1);
			            castPosition1.save();
			            
						String adPositions = EasyCastUtil.getAdposition("a","19");
						CastPosition castPosition2 = new CastPosition();
						castPosition2.setCastId(cast_id);
						castPosition2.setDirectName("position");
						castPosition2.setDirectValue(adPositions);
						castPosition2.setMutex(0);
						castPosition2.setIsPositive(1);
						castPosition2.save();		            
		         }
			}
			
			//?????????????????????????????????"???"?????????
			if (ad_type == OTT_SCREENSAVER && "9".equals(all_channel)) {
		         if("1".equals(is_show_xiami_lunbo_position)&&is_show_xiami_lunbo_position!=null){
			         for (String XIAMI_lunbo_position_id : xiami_lunbo_position) {
				        CastPosition castPosition = new CastPosition();
				        castPosition.setCastId(cast_id);
				        castPosition.setDirectName("position");
				        castPosition.setDirectValue(XIAMI_lunbo_position_id);
				        castPosition.setMutex(0);
				        castPosition.setIsPositive(1);
				        castPosition.save();
			             }
		        }else{
		        	String xiami_position = "";
		        	List<AdPosition> xiamiAdPosition = EasyCastUtil.getInfoFlowAdPosition("%??????%", "xm","h", "18");
					CastPosition castPosition2 = new CastPosition();
					castPosition2.setCastId(cast_id);
					castPosition2.setDirectName("position");
					for(int i=0;i<xiamiAdPosition.size();i++){
						xiami_position = xiami_position + xiamiAdPosition.get(i).getId() + ",";
					}
					castPosition2.setDirectValue(xiami_position.substring(0, xiami_position.length()-1));
					castPosition2.setMutex(0);
					castPosition2.setIsPositive(1);
					castPosition2.save();
		         }
			}			
			if (ad_type == OTT_POWEROFF) {
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");
				castPosition.setDirectValue("800");
				castPosition.setIsPositive(1);
				castPosition.save();		
				
				String adPositions = EasyCastUtil.getAdposition("a","21");
				CastPosition castPosition1 = new CastPosition();
				castPosition1.setCastId(cast_id);
				castPosition1.setDirectName("position");
				castPosition1.setDirectValue(adPositions);
				castPosition1.setMutex(0);
				castPosition1.setIsPositive(1);
				castPosition1.save();
				
			}	
			
			//ott??????"??????"???????????????"???"?????????
			if (ad_type == OTT_SCREENSAVER && !"9".equals(all_channel)) {
		         if("1".equals(is_show_screensaver_position)&&screensaver_position!=null){
			         for (String SCREENSAVER_position_id : screensaver_position) {
				        CastPosition castPosition = new CastPosition();
				        castPosition.setCastId(cast_id);
				        castPosition.setDirectName("adposition");
				        castPosition.setDirectValue(SCREENSAVER_position_id);
				        castPosition.setMutex(0);
				        castPosition.setIsPositive(1);
				        castPosition.save();
			             }
		        }else{
			            CastPosition castPosition1 = new CastPosition();
			            castPosition1.setCastId(cast_id);
			            castPosition1.setDirectName("adposition");
			            castPosition1.setDirectValue("11000");
			            castPosition1.setMutex(0);
			            castPosition1.setIsPositive(1);
			            castPosition1.save();	
			            
						String adPositions = EasyCastUtil.getAdposition("a","20");
						CastPosition castPosition2 = new CastPosition();
						castPosition2.setCastId(cast_id);
						castPosition2.setDirectName("position");
						castPosition2.setDirectValue(adPositions);
						castPosition2.setMutex(0);
						castPosition2.setIsPositive(1);
						castPosition2.save();	
		         }		         
			}			
			//????????????
			if(ad_type == NEW_JUCHANGBIAOBAN || ad_type == MB_JUCHANGBIAOBAN){
				if("1".equals(is_show_biaoban_position)&&biaoban_position!=null){
					for (String biaoban_position_id : biaoban_position) {
						CastPosition castPosition = new CastPosition();
						castPosition.setCastId(cast_id);
						castPosition.setDirectName("adposition");
						castPosition.setDirectValue(biaoban_position_id);
						castPosition.setMutex(0);
						castPosition.setIsPositive(1);
						castPosition.save();
					}
				}else{
					CastPosition castPosition1 = new CastPosition();
					castPosition1.setCastId(cast_id);
					castPosition1.setDirectName("adposition");
					castPosition1.setDirectValue("10005");
					castPosition1.setMutex(0);
					castPosition1.setIsPositive(1);
					castPosition1.save();
					
					String adPositions = EasyCastUtil.getAdposition("v","23");
					CastPosition castPosition2 = new CastPosition();
					castPosition2.setCastId(cast_id);
					castPosition2.setDirectName("position");
					castPosition2.setDirectValue(adPositions);
					castPosition2.setMutex(0);
					castPosition2.setIsPositive(1);
					castPosition2.save();	
				}				
			}	
			
			if(ad_type == NEW_OVERLAY_FLOAT || ad_type == MB_OVERLAY_FLOAT){				
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("adposition");				
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6("select id from v_position where id = 20000");				
				if (al11.size() == 0) {				
					VPosition vPosition = new VPosition();
					vPosition.setId(20000);
					vPosition.setParentId(-1);
					vPosition.setName("???????????????");
					vPosition.setManageType("cf");
					vPosition.setPs(0);
					vPosition.setAdSeq(1);
					vPosition.setType(1);
					vPosition.setStatus(1);
					vPosition.save();					
					castPosition.setDirectValue("20000");
					castPosition.setIsPositive(1);
					castPosition.save();
				}else{
					castPosition.setDirectValue("20000");
					castPosition.setIsPositive(1);
					castPosition.save();
					
					String adPositions = EasyCastUtil.getAdposition("v","4");
					CastPosition castPosition2 = new CastPosition();
					castPosition2.setCastId(cast_id);
					castPosition2.setDirectName("position");
					castPosition2.setDirectValue(adPositions);
					castPosition2.setMutex(0);
					castPosition2.setIsPositive(1);
					castPosition2.save();	
				}	
			}			
			if(ad_type == MB_FOCUS_CIRCLE){
				//????????????
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("position");
				castPosition.setDirectValue(mb_focus_circle_pic_pos);
				castPosition.setIsPositive(1);
				castPosition.save();
			}			
			
			if(ad_type == MB_APPSEARCHBANNER){
				CastHposition castHposition = new CastHposition();
				castHposition.setCastId(cast_id);
				castHposition.setDirectName("hposition");				
				ArrayList al11 = DBConnection.getInstance("atm").execQuerySql6("select id from h_position where value = 1430711337;");	
				if (al11.size() == 0) {
					ArrayList al12 = DBConnection.getInstance("atm").execQuerySql6("select id from h_position order by id desc limit 1");
					String a = (al12.get(0).toString()).substring(1, al12.get(0).toString().length() - 1) + "";
					int i = Integer.parseInt(a);
					//idea.setId(i + 1);			
					HPosition h_Position = new HPosition();
					h_Position.setId(i + 1);
					h_Position.setParentId(-1);
					h_Position.setName("??????app?????????banner???");
					h_Position.setType(6);
					h_Position.setValue(1430711337);
					h_Position.setTemplet("");
					h_Position.setStatus(1);
					h_Position.save();				
					castHposition.setDirectValue(i + 1);
					castHposition.setIsPositive(1);
					castHposition.save();
				}else{
					String adPositions = EasyCastUtil.getAdposition("914","h","2");
					CastPosition castPosition2 = new CastPosition();
					castPosition2.setCastId(cast_id);
					castPosition2.setDirectName("position");
					castPosition2.setDirectValue(adPositions);
					castPosition2.setMutex(0);
					castPosition2.setIsPositive(1);
					castPosition2.save();				
				}
			}			
					
			if(ad_type == MB_APP_PLAYING_BANNER){				
					CastPosition castPosition = new CastPosition();
					castPosition.setCastId(cast_id);
					castPosition.setDirectName("position");
					castPosition.setDirectValue(app_playing_banner_pos);
					castPosition.setMutex(0);
					castPosition.setIsPositive(1);
					castPosition.save();	
			}		
			
			//??????FEED
			if(ad_type == MB_FEED){
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("position");
				castPosition.setDirectValue(app_feed_pos);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();				
			}
			
			if(ad_type == MB_APP_HOMEPAGE){
				
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("position");
				castPosition.setDirectValue(app_homepage_pos);
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();	
			}		
			if(ad_type == promoted_video_ads_1430192600){
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("position");
				castPosition.setDirectValue("60680");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();	

			}			
			if(ad_type == promoted_video_ads_1430192617){
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("position");
				castPosition.setDirectValue("60681");
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();	
			}
			if(ad_type == yk_vhtml_right_relative_banner || ad_type == yk_vhtml_banner1 || ad_type == yk_vhtml_comments || ad_type == yk_vhtml_RTB){
				CastPosition castPosition = new CastPosition();
				castPosition.setCastId(cast_id);
				castPosition.setDirectName("position");
				if(ad_type == yk_vhtml_right_relative_banner) {
					castPosition.setDirectValue("61204");
				}
				
				if(ad_type == yk_vhtml_banner1) {
					castPosition.setDirectValue("61201");
				}
				
				if(ad_type == yk_vhtml_comments) {
					castPosition.setDirectValue("61202");
				}
				
				if(ad_type == yk_vhtml_RTB) {
					castPosition.setDirectValue("61203");
				}
				
				castPosition.setMutex(0);
				castPosition.setIsPositive(1);
				castPosition.save();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void insertCastCpm(int kk[],int cast_id, Date startDate, Date endDate, String product_reserve_method,String total_lun,String percent,int m_ztsdk, int m_sdk) {
		Date temp = startDate;
		Calendar calendar;
		int j = 0;
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
					castCpm.setCpm(0);
					castCpm.setCpc(0);
					castCpm.setCpv(0);
					castCpm.setCpp(0);				
				}

				if(product_reserve_method_castCpm == 5){
				   castCpm.setPercent(Integer.parseInt(percent));	
					castCpm.setCpm(0);
					castCpm.setCpc(0);
					castCpm.setCpv(0);
					castCpm.setCpp(0);	
				}			
				if(product_reserve_method_castCpm == 9){
					castCpm.setLun("1/1");	
					castCpm.setCpm(0);
					castCpm.setCpc(0);
					castCpm.setCpv(0);
					castCpm.setCpp(0);
					castCpm.setPercent(0);
					}		
				
				if ((product_reserve_method_castCpm == 2) || (product_reserve_method_castCpm == 4) || (product_reserve_method_castCpm == 3) || (product_reserve_method_castCpm == 5) || (product_reserve_method_castCpm == 9) || m_sdk != 0 || m_ztsdk != 0) {
					castCpm.setDcId(0);
					castCpm.setDcId2(0);
				} else {
					castCpm.setDcId(kk[j]);
					castCpm.setDcId2(0);
				}
				
				castCpm.setTargetDate(temp);
				castCpm.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			j++;
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
				int product_reserve_method_idea_time = Integer.parseInt(product_reserve_method);
				if(product_reserve_method_idea_time == 1){
					hcastCpm.setCpm(1000);
				}
				if(product_reserve_method_idea_time == 4){
					hcastCpm.setLun("10");
				}
				hcastCpm.setCpc(0);								
				hcastCpm.setPercent(0);
				hcastCpm.setTargetDate(temp);
				hcastCpm.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			temp = EasyCastUtil.getTomorrow(temp);
		}
	}	
	void insertVhcastCpm(int cast_id, Date startDate, Date endDate, String product_reserve_method,String total_lun,String percent) {
		Date temp = startDate;
		Calendar calendar;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);
			try {
				VhcastCpm vhCastCpm = new VhcastCpm();
				vhCastCpm.setCastId(cast_id);
				//vhCastCpm.setLun("10");
				if(Integer.parseInt(product_reserve_method)==6){
					vhCastCpm.setCpm(0);
					vhCastCpm.setCpc(1000);	
					vhCastCpm.setLun("");
				}else if(Integer.parseInt(product_reserve_method)==1){
					vhCastCpm.setCpm(1000);
					vhCastCpm.setCpc(0);
					vhCastCpm.setLun("");
				}else if(Integer.parseInt(product_reserve_method)==9){
					vhCastCpm.setCpm(0);
					vhCastCpm.setCpc(0);	
					vhCastCpm.setLun("10");
				}								
				vhCastCpm.setPercent(0);
				vhCastCpm.setTargetDate(temp);
				vhCastCpm.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			temp = EasyCastUtil.getTomorrow(temp);
		}
	}	
	void insertCastDq(int cast_id,String[] resolution_hd2,String[] resolution_mp4,String[] resolution_flv){
		try{
			CastDirection castDq = new CastDirection();
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
	
	void insertCastDirection(int ad_type,int cast_id,String parameter_names,String parameter_values){
			if(!"".equals(parameter_names)&&parameter_names!=null && !"".equals(parameter_values)&&parameter_values!=null){
				try{
					CastDirection cd = new CastDirection();
					cd.setCastId(cast_id);
					cd.setDirectName(parameter_names);
					cd.setDirectValue(parameter_values);
					cd.setIsPositive(1);
					cd.save();					
				}catch (Exception e){
					e.printStackTrace();
				}
			}
	}
		
	void insertCastFaceoff(int ad_type,int cast_id,String isFaceoff,String vid_faceoff){
	if(ad_type == NEW_FACEOFF || ad_type == MB_FACEOFF){
		System.out.println("into faceoff is : " + ad_type);
		if("1".equals(isFaceoff)&&isFaceoff!=null){
			try {
				JSONObject obj = new JSONObject(vid_faceoff);
				Iterator it = obj.keys();
				while (it.hasNext()) {
					String key = (String) it.next();
					System.out.println("key is: " + key);
					String value = obj.getString(key);
					System.out.println("value is: " + value);
					JSONArray array = obj.getJSONArray(key);
					for(int i=0;i<array.length();i++){
						JSONObject jsonobject = array.getJSONObject(i);
						CastEmbed ce = new CastEmbed();
						ce.setCastId(cast_id);
						System.out.println("cast_id is : " + cast_id);
						//ce.setVideoId(jsonobject.getString("videoId"));
						ce.setVideoIdYk(jsonobject.getString("video_id_yk"));
						ce.setVideoIdTd(jsonobject.getString("video_id_td"));
						ce.setBreakId(jsonobject.getString("breakId"));				
						int faceoffStartTime = Integer.parseInt(jsonobject.getString("startTime"));
						int faceoffShowTime = Integer.parseInt(jsonobject.getString("showTime"));
						ce.setStartTime(faceoffStartTime);
						ce.setShowTime(faceoffShowTime);						
						ce.save();
					}
				}
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
	String insertCastPlatform(int ad_type_id,int cast_id,String pc_all_os,String[] chk_os_pc) {
		String ad_type = getAdTypeName(ad_type_id);
		List<String> chk_os_pc_list = new ArrayList<String>();
        String pc_all_platform = "";
		if ("1".equals(pc_all_os)) {//???????????????
			for (String os_pc : chk_os_pc) {
				String[] pc_platform = os_pc.split(":");
				chk_os_pc_list.add(pc_platform[0]);
				pc_all_platform = pc_all_platform + pc_platform[1] + ",";
			}
		} else if (chk_os_pc != null) {
			for (String os_pc : chk_os_pc) {
				String[] pc_platform = os_pc.split(":");
				chk_os_pc_list.add(pc_platform[0]);
				pc_all_platform = pc_all_platform + pc_platform[1] + ",";
			}
		}
		if (!ad_type.startsWith("??????")) {
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
	    return "??????pc??????(" + pc_all_platform.substring(0, pc_all_platform.length()-1) + ")";

	}
	String insertCastSubOs(int ad_type_id, int cast_id, String all_os,
			String[] chk_os) {
		String ad_type = getAdTypeName(ad_type_id);
		List<String> chk_os_list = new ArrayList<String>();
        String all_mb_platform = "";
		if ("1".equals(all_os)) {//???????????????
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
			chk_os_list.add("0_5_2_a");
			//chk_os_list.add("0_5_3_0");
			all_mb_platform = "???????????????,";						
		} else if (chk_os != null) {
			for (String os : chk_os) {
				String[] spec_os = os.split(":");
				chk_os_list.add(spec_os[0]);
				all_mb_platform = all_mb_platform + spec_os[1] + ",";
			}
		}else {
			all_mb_platform = "??????????????????????????????(?????????????????????),";
		}
		if ((chk_os_list != null)&&(ad_type.startsWith("??????")||ad_type.startsWith("youku_??????phone-web???_?????????banner")||ad_type.startsWith("youku_??????ipad-web???_?????????banner") || ad_type.startsWith("?????????") || ad_type.startsWith("Feed") || ad_type.startsWith("YOUKU") || ad_type.startsWith("ott"))) {
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
		     return "????????????(" + all_mb_platform.substring(0, all_mb_platform.length()-1) + ")";
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
				//(root@localhost) [atm]> select * from protect where name like '%????????????%??????%';

				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//| id  | name                                     | manage_type | parent | priority | resource_id | color | starttime           | endtime             | status |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//|  14 | ?????????????????????????????????_??????              | f,o,b       |     -1 |       30 |          99 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//|  11 | ???????????????????????????_??????                  | f,o,b       |     -1 |       30 |          96 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 104 | ??????????????????_??????                        | f,o,b       |     -1 |       30 |         197 |     1 | 2014-12-26 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 113 | ??????????????????????????????_??????                | f,o,b       |     -1 |       30 |         207 |     1 | 2015-01-21 00:00:00 | 2020-12-31 23:59:59 |      1 |
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
				//(root@localhost) [atm]> select * from protect where name like '%????????????%??????%';
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//| id  | name                                     | manage_type | parent | priority | resource_id | color | starttime           | endtime             | status |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//|  15 | ?????????????????????????????????_??????              | p           |     -1 |       30 |         100 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//|  12 | ???????????????????????????_??????                  | p           |     -1 |       30 |          97 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 105 | ??????????????????_??????                        | p           |     -1 |       30 |         198 |     1 | 2014-12-26 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 114 | ??????????????????????????????_??????                | p           |     -1 |       30 |         208 |     1 | 2015-01-21 00:00:00 | 2020-12-31 23:59:59 |      1 |
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
				//(root@localhost) [atm]> select * from protect where name like '%????????????%??????%';
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//| id  | name                                     | manage_type | parent | priority | resource_id | color | starttime           | endtime             | status |
				//+-----+------------------------------------------+-------------+--------+----------+-------------+-------+---------------------+---------------------+--------+
				//|  16 | ?????????????????????????????????_??????              | c           |     -1 |       30 |         101 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//|  13 | ???????????????????????????_??????                  | c           |     -1 |       30 |          98 |     1 | 2014-09-10 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 106 | ??????????????????_??????                        | c           |     -1 |       30 |         199 |     1 | 2014-12-26 00:00:00 | 2015-12-31 23:59:59 |      1 |
				//| 115 | ??????????????????????????????_??????                | c           |     -1 |       30 |         209 |     1 | 2015-01-21 00:00:00 | 2020-12-31 23:59:59 |      1 |
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
	int insertIdea(int ad_type, int cast_id, int ad_type_id, String click_url, String mb_click,
			String over_url, int outtime, String show_url, String click_kh_url,String playing_url,
			String iso_url, String mt_url, String iso_click_url,
			String iso_h5_url, int m_issdk, int m_sdk, int m_ztsdk,
			int m_qtsdk, String pc_vf_y_ideaurl, String pc_vf_pipurl,String loader_type,String loader_type_vob,String loader_type_vb,String loader_type_tp,
			int pc_vf_impression, int m_vb_impression,int m_vo_impression,int pc_vf_impression_pc,int pc_vob_impression_pc,int pc_vb_impression_pc,int pc_tp_impression_pc,String pc_vp_y_ideaurl,String pc_vp_y_ideaurl_h5,
			String pc_vp_y_full_ideaurl, String pc_vp_y_full_ideaurl_h5,String pc_vp_t_ideaurl,
			String pc_vp_t_full_ideaurl, String pc_vp_ideacontrol,
			String pc_vob_ideaurl, String pc_vob_pipurl,
			String pc_vb_ideaurl,
			String pc_vc_y_ideaurl,String pc_vc_y_ideaurl_img,String pc_vc_y_ideaurl_h5,
			String pc_vc_y_rightpx2, String pc_vc_t_ideaurl,
			String pc_vc_t_rightpx2, String pc_vc_position,
			String pc_vc_showtime, String m_vf_ideaurl, String m_h5_vf_ideaurl_phone,String m_h5_vf_ideaurl_pad,String m_h5_vb_ideaurl_phone,String m_h5_vb_ideaurl_pad,String m_h5_vo_ideaurl_phone,String m_h5_vo_ideaurl_pad,
			String m_vb_ideaurl, String m_vp_ideaurl,
			String m_vc_openstatus_pageurl, String m_vc_closestatus_pageurl,
			String m_mi_ipad_ideaurl_768, String m_mi_ipad_ideaurl_1004,
			String m_mi_iphone_ideaurl_940, String m_mi_iphone_ideaurl_1116,
			String m_mi_iphone_ideaurl_1334, String m_mi_iphone_ideaurl_1920,String m_mi_iphone_ideaurl_xiami,String m_mi_aphone_ideaurl_xiami,
			String m_mi_apad_ideaurl_800, String m_mi_apad_ideaurl_600, String m_mi_apad_ideaurl_768,
			String m_mi_aphone_ideaurl_1280, String m_mi_aphone_ideaurl_800,
			String m_mi_atv_ideaurl_720,String m_mi_atv_t,String m_iku_pc_ideaurl_650,String m_iku_pc_ideaurl_720, String m_mqp_ipad_ideaurl_748,
			String m_mqp_iphone_ideaurl_480,
			String m_mqp_androidpad_ideaurl_720,
			String m_mqp_androidphone_ideaurl_480, String m_quanping_showtime,
			String m_mo_ideaurl, String cast_type,String is_show_priority,String product_reserve_method, String[] chk_os,String[] resolution_hd2,String[] resolution_mp4,String[] resolution_flv,
			String pc_tp_ideaurl,String m_vtp_ideaurl,String ies_monitor,
			String customtext_url,String clientcustomclick_url,String clientskip_url,String clientfee_url,String othercustomtextclick_url,String otherskip_url,String otherfeep_url,String custom_text,String custom_text_mf,
			String pc_vf_loader_showtime,String pc_vob_loader_showtime,String pc_vb_loader_showtime,String pc_tp_loader_showtime,
			String pc_vc_width,String pc_vc_height,String pc_vc_close_method,String pc_vc_location,String chargingthreshold_text,String m_mhtml_text_content,String m_mhtml_clickurl,String m_mhtml_show,String m_mhtml_click,
            String is_ir,String ir_type,String dsp_url_length,String clientDSPpushurl_text,String otherDSPpushurl_text,
			String app_search_banner_type,String app_playing_banner_type,String app_search_banner_youkupip_url,String app_search_banner_youkupip_clickurl,String app_search_banner_youkupip_showurl,String app_search_banner_youkupip_clickmonitor,
			String vhtml_yt_promoted_client_show_url,String vhtml_yt_promoted_other_show_url,String vhtml_yt_promoted_client_click_url,String vhtml_yt_promoted_video_ads_url,
			String app_playing_banner_url,String app_playing_banner_clickurl,String app_playing_banner_showurl,String app_playing_banner_clickmonitor_url,String clientplayover_time,String pc_vf_buyingbyseeing_ideaurl_flash,String pc_vf_buyingbyseeing_ideaurl_h5,String pc_vf_buyingbyseeing_ideaurl_png,String pc_vf_buyingbyseeing_rightpx2,String pc_scenario_location,String m_mi_atv_text,String m_mi_atv_text1,String co_banner_idea,String m_mi_ipad_landscape_idea,String m_mi_iphone_portrait_idea,String skip_button_text,String app_homepage_type,String app_homepage_url,String app_homepage_clickurl,String app_homepage_showurl,String pc_biaoban_y_ideaurl,String mb_biaoban_y_ideaurl,
			String pc_normal_zanting_width,String pc_normal_zanting_height,String pc_fullscreen_zanting_width,String pc_fullscreen_zanting_height,String html_video_banner_ads_url,String vhtml_m_playing_page_url,String m_vc_pad,String m_vc_phone,String m_vc_h5,String m_ott_vc,String m_mc_location,String m_mc_atv_t,String m_isp_png_url,String m_isp_title,String m_isp_tipcontent,String m_isp_buttontext,String isIdea_vr,String m_vp_is_qr,String m_vp_vq_url,String m_vp_ott_ideaurl,String m_feed_logo_url,String m_feed_customer,String m_feed_video_thumbnail,String m_feed_buttontext,String m_feed_video_url,String ott_display_ideaurl,String app_ott_display_type,String ott_display_ideaurl_showtime,String ott_dis_rec_ideaurl,String ott_dis_rec_ideaurl_showtime,String ott_screensaver_ideaurl,String screensaver_showtime,String ott_poweroff_ideaurl,String poweroff_showtime,String m_feedAd_video_thumbnail,String m_feedAd_video_url,String m_feedAd_png_url_750_350,String m_feedAd_png_url_750_280,String m_feedAd_prompt,String m_feedAd_brandlogo,String m_feedAd_length,String interact_effect_type,String charge_type,String m_vf_pipurl,String mb_vf_buyingbyseeing_ideaurl,String mb_vf_ott_buyingbyseeing_ideaurl,String control_type_mobile,String ideaShowLocation,String ideaShowPositionCorn,String pc_overlay_float_pic_ideaurl,String pc_overlay_float_swf_ideaurl,String pc_overlay_float_h5_ideaurl,String mb_overlay_float_pic_ideaurl,String mb_overlay_float_h5_ideaurl,String mb_focus_circle_pic_ideaurl,String mb_focus_circle_pic_text,String mb_focus_circle_pic_ideaurl_ipad,String m_mi_iphonex_ideaurl_1125,String pc_hvideo_vf_h5,String isDeeplink,String vid_deeplink,String m_mi_iphonex_video_idea,String h5_hvideo_1_url,String h5_hvideo_2_url,String Phone_H5_url,String Pad_H5_url,String main_h5_mf_url_t,String h5_mf_url_t1,String h5_mf_url_t2,String mb_bf_ideaurl,String pc_bf_ideaurl,String ott_display_biterate,String ott_display_volume,String feedAd_type_overall,String m_feedAd_png_url_spotlight,String m_feedAd_brandlogo_spotlight,String m_feedAd_addescript_spotlight,String m_feedAd_prompt_spotlight,String m_feedAd_adname_spotlight,String pc_seeds_ideaurl,String pc_seeds_title,String pc_seeds_cover,String vhtml_type,String vhtml_yt_banner_pip_url,String vhtml_yt_banner_h5_url,String vhtml_yt_banner_h5_width,String vhtml_yt_banner_h5_height,String m_feedAd_video_url_spotlight,String m_feedAd_thumbnail_url_spotlight,String feedAd_type,String feedAd_type_kandian,String mf_oneBuy_type,String mf_good_id,String mf_taobaoer_id,String mf_onebuy_h5_url,String ott_onebuy_png_url,String onebuyurl_text,String mf_onebuy_h5_width,String mf_onebuy_h5_height) {
		String name = cast_id + "_" + ad_type_id + "_" + System.currentTimeMillis();
		try {
			//atm2.0_easycast
			//AdCast cast = AdCastPeer.retrieveByPK(cast_id);
			Idea idea = new Idea();
			ArrayList al = DBConnection.getInstance("atm").execQuerySql6("select id from idea order by id desc limit 1");
			if (al.size() == 0) {
				idea.setId(1);
			} else {
				String a = (al.get(0).toString()).substring(1, al.get(0).toString().length() - 1) + "";
				int i = Integer.parseInt(a);
				idea.setId(i + 1);
				//idea.setId(1076243711);
				//idea.setId(100000000);
			}
			idea.setCastId(0);
			idea.setName(name);
			idea.setShowtime(15);
			idea.setIPriority(1);
			idea.setCount(0);
			idea.setNumlimit(1000);
            insertIdeaDq(idea,resolution_hd2,resolution_mp4,resolution_flv);    
            idea.setIesorg("0");
//            if("2".equals(ies_monitor)){
//            	idea.setIesorg("admaster.com");
//            }else if("3".equals(ies_monitor)){
//            	idea.setIesorg("miaozhen.com");
//            }else {
//            	idea.setIesorg("");
//            }           
//			idea.setCuf(Integer.parseInt(mb_click));
			idea.setCuf(0);			
			idea.setControltype(1);
			//TODO issdk
//			if (ad_type_id == MB_QIANTIE || ad_type_id == MB_HOUTIE || ad_type_id == MB_ZHONGCHA || ad_type_id == MB_ZANTING || ad_type_id == MB_JIAOBIAO || ad_type_id == MB_KAIJITU || ad_type_id == MB_QUANPING || ad_type== MB_TIEPIAN || ad_type == NEW_JUCHANGBIAOBAN || ad_type == NEW_OVERLAY_FLOAT || ad_type == MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE || ad_type == MB_JUCHANGBIAOBAN || ad_type == NEW_FACEOFF || ad_type == MB_FACEOFF || ad_type == MB_ISP || ad_type == OTT_DISPLAY || ad_type == OTT_DIS_REC || ad_type == OTT_SCREENSAVER || ad_type == OTT_POWEROFF) {
//				idea.setIssdk(m_issdk);
//			}
			//???????????????idea.sdkid
			idea.setSdkid(0);
			if(ad_type_id == MB_ZANTING){
				idea.setSdkid(m_ztsdk);
			}
			if(ad_type_id == MB_QUANPING){
				idea.setSdkid(m_sdk);
			}			
			if((ad_type_id == MB_APPSEARCHBANNER&&app_search_banner_type.equals("2"))||(ad_type_id == MB_APP_PLAYING_BANNER&&app_playing_banner_type.equals("2"))||(ad_type_id == MB_APP_HOMEPAGE&&app_homepage_type.equals("2"))){
				idea.setSdkid(10);
				idea.setCuf(0);
			}
			idea.setStatus(1);
			//pc qiantie
			if (ad_type == NEW_QIANTIE) {
				idea.setShowtime(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl));
				if(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl)==0){
					if(pc_vf_impression_pc==1&&!"".equals(pc_vf_loader_showtime)){
						idea.setShowtime(Integer.parseInt(pc_vf_loader_showtime));
					}else if(pc_vf_y_ideaurl.contains("tudou.com")){
						//todo tudou_url:http://v2.tudou.com/f?sj=1&ft=redir&id=229356520&sid=11000&hd=2
						idea.setShowtime(15);
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
			//????????????SHOWTIME
			if (ad_type == NEW_BUYINGSEEING || ad_type == MB_scenario) {
				//todo
					idea.setShowtime(15);
			}			
			//????????????
			if (ad_type == NEW_JUCHANGBIAOBAN) {
				idea.setShowtime(EasyCastUtil.getVideoLength(pc_biaoban_y_ideaurl));
			}			
			if (ad_type == MB_JUCHANGBIAOBAN) {
				idea.setShowtime(EasyCastUtil.getVideoLength(mb_biaoban_y_ideaurl));
			}
			if (ad_type == NEW_OVERLAY_FLOAT || ad_type == MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
				idea.setShowtime(0);
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
				//idea.setShowtime(15);
			}
			//n???????????????
			if (ad_type == MB_BF) {
				idea.setShowtime(EasyCastUtil.getVideoLength(mb_bf_ideaurl));
			}
			
			if (ad_type == PC_BF) {
				idea.setShowtime(EasyCastUtil.getVideoLength(pc_bf_ideaurl));
			}
			
			//????????????????????????
			if(ad_type == PC_FEEDS) {
				idea.setShowtime(EasyCastUtil.getVideoLength(pc_seeds_ideaurl));	
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
			//?????????????????????CF3
			if (ad_type == NEW_BUYINGSEEING) {
				idea.setControltype(Integer.parseInt(pc_vf_buyingbyseeing_rightpx2));
				idea.setLocType(pc_scenario_location);
			}	
			if(ad_type == MB_scenario){
				idea.setControlTypeMobile(Integer.parseInt(control_type_mobile));
				idea.setIdeaShowLocation(Integer.parseInt(ideaShowLocation));
				idea.setLocType(ideaShowPositionCorn);
			}

			if (ad_type == NEW_JIAOBIAO) {
				if (pc_vc_showtime != null && !"".equals(pc_vc_showtime)) {
					if("35".equals(interact_effect_type)) {
						//??????????????????120s
						idea.setShowtime(120);
					}else {
						idea.setShowtime(Integer.parseInt(pc_vc_showtime));
					}
					
					idea.setCloseMethod(Integer.parseInt(pc_vc_close_method));
				} else {
					idea.setShowtime(0);
				}
                idea.setLocType(pc_vc_location);
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
				//????????????pc_location
				idea.setLocationType("");
			}
			if (ad_type == NEW_ZANTING) {
				idea.setShowtime(0);
				idea.setControltype(Integer.parseInt(pc_vp_ideacontrol));
			}
			if (ad_type == MB_ZANTING || ad_type == MB_ISP) {
				idea.setShowtime(0);

			}
			if (ad_type == MB_QUANPING) {
				idea.setShowtime(Integer.parseInt(m_quanping_showtime));
			}
			if (ad_type == NEW_SHORTFULL) {
				idea.setShowtime(5);
			}			
			if (ad_type == MB_KAIJITU) {
				idea.setShowtime(Integer.parseInt(m_mi_atv_t));
			}			 
			if (ad_type == MB_JIAOBIAO) {
				if("35".equals(interact_effect_type)) {
					//??????????????????120s
					idea.setShowtime(120);
				}else {
					idea.setShowtime(Integer.parseInt(m_mc_atv_t));
				}
				
				idea.setLocType(m_mc_location);
			}		
			if (ad_type == MB_WENZILIAN||ad_type == MB_APPSEARCHBANNER || ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617 || ad_type == MB_APP_PLAYING_BANNER || ad_type == MB_APP_HOMEPAGE) {
				idea.setShowtime(0);
			}		
			//trueview(charge_time)
			//????????????idea?????????????????????????????????????????????????????????????????????????????????????????????????????????15??????????????????????????????>=15??????????????????15???????????????????????????<15??????????????????????????????
			//todo
			if(ad_type == NEW_QIANTIE){
				if(pc_vf_impression_pc==2){
					if(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl)==0||pc_vf_y_ideaurl.contains("tudou.com")){
						idea.setChargeTime(Integer.parseInt(chargingthreshold_text));
					}else if(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl)>=Integer.parseInt(chargingthreshold_text)){
						idea.setChargeTime(Integer.parseInt(chargingthreshold_text));
						//idea.setChargeTime(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl));
					}else{
						idea.setChargeTime(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl));
					}
					//idea.setChargeTime(15);
				}
			}else if(ad_type == MB_QIANTIE){
				if(pc_vf_impression==2){
					if(EasyCastUtil.getVideoLength(m_vf_ideaurl)==0||m_vf_ideaurl.contains("tudou.com")){
						idea.setChargeTime(Integer.parseInt(chargingthreshold_text));
					}else if(EasyCastUtil.getVideoLength(m_vf_ideaurl)>=Integer.parseInt(chargingthreshold_text)){
						idea.setChargeTime(Integer.parseInt(chargingthreshold_text));
						//idea.setChargeTime(EasyCastUtil.getVideoLength(pc_vf_y_ideaurl));
					}else{
						idea.setChargeTime(EasyCastUtil.getVideoLength(m_vf_ideaurl));
					}
					//idea.setChargeTime(15);
				}
			}
							
			//is_ir,dsp_url_length,creative_effect_type
			if("1".equals(is_ir)){
				if(!"".equals(dsp_url_length)){
					idea.setShowtime(Integer.parseInt(dsp_url_length));			
				}else{
					idea.setShowtime(15);
				}
			}
			if(isIdea_vr != null){
				//idea.setIsvr(Integer.parseInt(isIdea_vr));
			}
			if(ad_type == OTT_DISPLAY){
				if(ott_display_ideaurl_showtime != null && !"".equals(ott_display_ideaurl_showtime)){
					idea.setShowtime(Integer.parseInt(ott_display_ideaurl_showtime));
				}				
			}		
			if(ad_type == OTT_DIS_REC){
				if(ott_dis_rec_ideaurl_showtime != null && !"".equals(ott_dis_rec_ideaurl_showtime)){
					idea.setShowtime(Integer.parseInt(ott_dis_rec_ideaurl_showtime));
				}			
			}	
			if(ad_type == OTT_SCREENSAVER){	
				if(screensaver_showtime != null && !"".equals(screensaver_showtime)){
					idea.setShowtime(Integer.parseInt(screensaver_showtime));
				}				
			}	
			if(ad_type == OTT_POWEROFF){
				if(poweroff_showtime != null && !"".equals(poweroff_showtime)){
					idea.setShowtime(Integer.parseInt(poweroff_showtime));
				}				
			}
			if(ad_type == MB_FEED){
				int mb_feed_length = EasyCastUtil.getVideoLength(m_feed_video_url);
				idea.setShowtime(mb_feed_length);
			}		
			if(ad_type == YOUKU_FEEDAD){
				if(m_feedAd_length != null && !"".equals(m_feedAd_length)){
					idea.setShowtime(Integer.parseInt(m_feedAd_length));
				}
				if("2".equals(feedAd_type)&&!"".equals(m_feedAd_video_url_spotlight)) {
					idea.setShowtime(Integer.parseInt(m_feedAd_video_url_spotlight));
				}
			}
			if(isDeeplink != null){
				idea.setDpCuf(Integer.parseInt(isDeeplink));
			}
			idea.save();
			
//			//cal current dc table the latest dc_id:
//			String sql2 = "select id from dc order by id desc limit 1;";
//			ArrayList al2 = DBConnection.getInstance("atm").execQuerySql6(sql2);
//			int dd;
//			//catch al2 is null exception
//			if (al2.size() == 0) {
//				dd = 0;
//			} else {
//				String c = (al2.get(0).toString()).substring(1, al2.get(0).toString().length() - 1) + "";
//				dd = Integer.parseInt(c);
//				System.out.println("dd is: " + dd);
//			}
//			insertDc(cast.getStartDate(), cast.getEndDate(), is_show_priority,product_reserve_method);
//			//todo(??????sql????????????)
//			String sql = "select id from dc where target_date >= " + "'" + cast.getStartDate() + "'" + " and target_date <= " + "'" + cast.getEndDate() + "'" + " and id>" + dd + ";";
//			ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
//			//String a = (al1.get(0).toString()).substring(1,al.get(0).toString().length()-1) + "";
//			//	int i = Integer.parseInt(a);
//			System.out.println("sql1111111 is: " + sql);
//			int kk[] = new int[al1.size()];
//			System.out.println("dc length is : " + kk.length);
//			for (int iii = 0; iii < al1.size(); iii++) {
//				String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
//				int k = Integer.parseInt(aaa);
//				kk[iii] = k;
//				System.out.println("kk[" + iii + "] is:" + kk[iii]);
//			}     
			
			insertIdeaMonitor(ad_type, cast_id,idea.getId(), click_url, click_kh_url,playing_url,show_url, over_url, iso_url, mt_url, iso_click_url,iso_h5_url,outtime,customtext_url,clientcustomclick_url,clientskip_url,clientfee_url,othercustomtextclick_url,otherskip_url,otherfeep_url,pc_vf_impression_pc,pc_vf_impression,m_vb_impression,m_vo_impression,pc_vob_impression_pc,pc_vb_impression_pc,pc_tp_impression_pc,custom_text,custom_text_mf,idea,m_mhtml_clickurl,m_mhtml_show,m_mhtml_click,app_search_banner_type,app_search_banner_youkupip_url,app_search_banner_youkupip_clickurl,app_search_banner_youkupip_showurl,app_search_banner_youkupip_clickmonitor,is_ir,ir_type,clientDSPpushurl_text,otherDSPpushurl_text,vhtml_yt_promoted_client_show_url,vhtml_yt_promoted_other_show_url,vhtml_yt_promoted_client_click_url,app_playing_banner_clickurl,app_playing_banner_showurl,app_playing_banner_clickmonitor_url,app_playing_banner_type,clientplayover_time,m_mi_atv_text,m_mi_atv_text1,co_banner_idea,m_mi_ipad_landscape_idea,m_mi_iphone_portrait_idea,skip_button_text,app_homepage_type,app_homepage_url,app_homepage_clickurl,app_homepage_showurl,chk_os,app_ott_display_type,interact_effect_type,charge_type,feedAd_type,feedAd_type_kandian,onebuyurl_text);
            
			//idea_time;idea_cpm????????????
//			if(ad_type == m_homepage_banner_web){
//				insertHideaTime(kk,idea.getId(),cast.getStartDate(),cast.getEndDate(),product_reserve_method);
//			}else if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617 || ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541){
//				insertVhideaTime(kk, idea.getId(), cast.getStartDate(),cast.getEndDate(),is_show_priority,product_reserve_method,m_ztsdk,m_sdk);
//			}else{
//				insertIdeaTime(kk, idea.getId(), cast.getStartDate(), cast.getEndDate(),is_show_priority,product_reserve_method,m_ztsdk,m_sdk);
//			}
//			
//			if(ad_type == m_homepage_banner_web){
//            	insertHideaCpm(idea.getId(), cast.getStartDate(), cast.getEndDate(),product_reserve_method);	
//            }  
//            
//            if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617 || ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541){
//            	insertVhideaCpm(idea.getId(), product_reserve_method,cast.getStartDate(), cast.getEndDate());
//            }else{
//    			insertIdeaCpm(idea.getId(), cast.getStartDate(), cast.getEndDate());
//            }
            
			insertIdeaUrl(ad_type, cast_id,idea.getId(), pc_vf_y_ideaurl,pc_vf_pipurl, loader_type,loader_type_vob,loader_type_vb,loader_type_tp,m_vf_ideaurl,pc_vb_ideaurl, m_vb_ideaurl, pc_vob_ideaurl,pc_vob_pipurl, m_mo_ideaurl,pc_vc_y_ideaurl, pc_vc_y_ideaurl_img,pc_vc_y_ideaurl_h5,pc_vc_t_ideaurl, m_vc_openstatus_pageurl,m_vc_closestatus_pageurl, pc_vp_y_ideaurl,pc_vp_y_ideaurl_h5,pc_vp_y_full_ideaurl, pc_vp_y_full_ideaurl_h5,pc_vp_t_ideaurl,
					pc_vp_t_full_ideaurl, m_vp_ideaurl, m_mqp_ipad_ideaurl_748,
					m_mqp_iphone_ideaurl_480, m_mqp_androidpad_ideaurl_720,
					m_mqp_androidphone_ideaurl_480, m_mi_ipad_ideaurl_768,
					m_mi_ipad_ideaurl_1004, m_mi_iphone_ideaurl_940,
					m_mi_iphone_ideaurl_1116, m_mi_iphone_ideaurl_1334,
					m_mi_iphone_ideaurl_1920,m_mi_iphone_ideaurl_xiami,m_mi_aphone_ideaurl_xiami,m_mi_apad_ideaurl_800,
					m_mi_apad_ideaurl_600, m_mi_apad_ideaurl_768, m_mi_aphone_ideaurl_1280,
					m_mi_aphone_ideaurl_800, m_mi_atv_ideaurl_720,m_iku_pc_ideaurl_650,m_iku_pc_ideaurl_720,
					pc_vf_impression,m_vb_impression,m_vo_impression,pc_vf_impression_pc,pc_vob_impression_pc,pc_vb_impression_pc,pc_tp_impression_pc,
					m_h5_vf_ideaurl_phone, m_h5_vf_ideaurl_pad,m_h5_vb_ideaurl_phone,m_h5_vb_ideaurl_pad,m_h5_vo_ideaurl_phone,m_h5_vo_ideaurl_pad,chk_os,pc_tp_ideaurl,m_vtp_ideaurl,
					pc_vc_width,pc_vc_height,m_mhtml_text_content,app_search_banner_type,app_search_banner_youkupip_url,app_search_banner_youkupip_clickurl,app_search_banner_youkupip_showurl,app_search_banner_youkupip_clickmonitor,vhtml_yt_promoted_video_ads_url,
					is_ir,app_homepage_type,app_homepage_url,app_homepage_clickurl,app_homepage_showurl,m_ztsdk,m_sdk,app_playing_banner_url,app_playing_banner_type,pc_vf_buyingbyseeing_ideaurl_flash,pc_vf_buyingbyseeing_ideaurl_h5,pc_vf_buyingbyseeing_ideaurl_png,pc_biaoban_y_ideaurl,mb_biaoban_y_ideaurl,pc_normal_zanting_width,pc_normal_zanting_height,pc_fullscreen_zanting_width,pc_fullscreen_zanting_height,pc_vp_ideacontrol,html_video_banner_ads_url,vhtml_m_playing_page_url,m_vc_pad,m_vc_phone,m_vc_h5,m_ott_vc,m_mc_location,m_mc_atv_t,m_isp_png_url,m_isp_title,m_isp_tipcontent,m_isp_buttontext,m_mi_atv_text1,co_banner_idea,m_mi_ipad_landscape_idea,m_mi_iphone_portrait_idea,skip_button_text,m_vp_is_qr,m_vp_vq_url,m_vp_ott_ideaurl,m_feed_logo_url,m_feed_customer,m_feed_video_thumbnail,m_feed_buttontext,m_feed_video_url,ott_display_ideaurl,app_ott_display_type,ott_dis_rec_ideaurl,ott_dis_rec_ideaurl_showtime,ott_screensaver_ideaurl,ott_poweroff_ideaurl,poweroff_showtime,m_feedAd_video_thumbnail,m_feedAd_video_url,m_feedAd_png_url_750_350,m_feedAd_png_url_750_280,m_feedAd_prompt,m_feedAd_brandlogo,m_feedAd_length,m_vf_pipurl,mb_vf_buyingbyseeing_ideaurl,mb_vf_ott_buyingbyseeing_ideaurl,pc_overlay_float_pic_ideaurl,pc_overlay_float_swf_ideaurl,pc_overlay_float_h5_ideaurl,mb_overlay_float_pic_ideaurl,mb_overlay_float_h5_ideaurl,mb_focus_circle_pic_ideaurl,mb_focus_circle_pic_text,mb_focus_circle_pic_ideaurl_ipad,m_mi_iphonex_ideaurl_1125,pc_hvideo_vf_h5,isDeeplink,vid_deeplink,m_mi_iphonex_video_idea,h5_hvideo_1_url,h5_hvideo_2_url,Phone_H5_url,Pad_H5_url,main_h5_mf_url_t,h5_mf_url_t1,h5_mf_url_t2,mb_bf_ideaurl,pc_bf_ideaurl,ott_display_biterate,ott_display_volume,feedAd_type_overall,m_feedAd_png_url_spotlight,m_feedAd_brandlogo_spotlight,m_feedAd_addescript_spotlight,m_feedAd_prompt_spotlight,m_feedAd_adname_spotlight,pc_seeds_title,pc_seeds_cover,pc_seeds_ideaurl,vhtml_type,vhtml_yt_banner_pip_url,vhtml_yt_banner_h5_url,vhtml_yt_banner_h5_width,vhtml_yt_banner_h5_height,m_feedAd_video_url_spotlight,m_feedAd_thumbnail_url_spotlight,mf_oneBuy_type,mf_good_id,mf_taobaoer_id,mf_onebuy_h5_url,ott_onebuy_png_url,mf_onebuy_h5_width,mf_onebuy_h5_height);
			//insertIdeaSurvey(ad_type, idea.getId(), survey_entry_text_app,youku_survey_url, tudou_survey_url,survey_click_url_app,millwardbrown_ad_type_APP,survey_show_url_app);
			return idea.getId();
		} catch (Exception e) {
			//e.printStackTrace();
			//logger.error(e.getStackTrace(),e);
			//System.out.println("***************" + e.getStackTrace());
			logger.error(e.getStackTrace(), e);
		}
		return -1;
	}
	void insetSdkConfig(int m_sdk,int m_ztsdk,String[] chk_os,int ad_type_id,int cast_id,int idea_id){
		try{	
			for (String os : chk_os) {
				//chk_os_list.add(os);
				if((ad_type_id == MB_QUANPING) &&(m_sdk != 0)){
					SdkConfig sdk_config = new SdkConfig();
					String[] platforms = os.split("_");
					if(platforms[2].equals("0")){
						sdk_config.setDeviceId(1);
						sdk_config.setAdTypeId(76);
						sdk_config.setSdkId(m_sdk);
						sdk_config.setStatus(2);
						sdk_config.setManualPercent(100);
						sdk_config.setAutoPercent(100);
						sdk_config.setCastId(cast_id);
						sdk_config.setIdeaId(idea_id);
						//sdk_config.save();
					}
					if(platforms[2].equals("1")){
						sdk_config.setDeviceId(3);
						sdk_config.setAdTypeId(76);
						sdk_config.setSdkId(m_sdk);
						sdk_config.setStatus(2);
						sdk_config.setManualPercent(100);
						sdk_config.setAutoPercent(100);
						sdk_config.setCastId(cast_id);
						sdk_config.setIdeaId(idea_id);
						//sdk_config.save();
					}
					sdk_config.save();
				}
				if((ad_type_id == MB_ZANTING) &&(m_ztsdk != 0)){
					SdkConfig sdk_config = new SdkConfig();
					String[] platforms = os.split("_");					
					if(platforms[2].equals("0")){
						sdk_config.setDeviceId(1);
						sdk_config.setAdTypeId(164);
						sdk_config.setSdkId(m_ztsdk);
						sdk_config.setStatus(2);
						sdk_config.setManualPercent(100);
						sdk_config.setAutoPercent(100);
						sdk_config.setCastId(cast_id);
						sdk_config.setIdeaId(idea_id);
						sdk_config.save();
					}
					if(platforms[2].equals("1")){
						System.out.println("###########"+"zanting_sdk"+"##########" );
						sdk_config.setDeviceId(3);
						sdk_config.setAdTypeId(164);
						sdk_config.setSdkId(m_ztsdk);
						sdk_config.setStatus(2);
						sdk_config.setManualPercent(100);
						sdk_config.setAutoPercent(100);
						sdk_config.setCastId(cast_id);
						sdk_config.setIdeaId(idea_id);
						sdk_config.save();
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			String sql2 = "select id from dc where id = 0;";
			ArrayList al2 = DBConnection.getInstance("atm").execQuerySql6(sql2);
			if(al2.size() == 0){
				Dc dc = new Dc();
				dc.setId(0);
				dc.setTargetDate(new Date());
				dc.setCpm(0);
				dc.setCpc(0);
				dc.setCpv(0);
				dc.setCpp(0);
				dc.save();			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			Date temp = startDate;
			Calendar calendar;
			while (temp.compareTo(endDate) <= 0) {
				calendar = Calendar.getInstance();
				calendar.setTime(temp);
				try {
					Dc dc = new Dc();
					dc.setTargetDate(temp);
					int product_reserve_method_dc = Integer.parseInt(product_reserve_method);
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
					int product_reserve_method_idea_time = Integer.parseInt(product_reserve_method);
					if ((product_reserve_method_idea_time == 2) || (product_reserve_method_idea_time == 4) || (product_reserve_method_idea_time == 3) || (product_reserve_method_idea_time == 5) || (product_reserve_method_idea_time == 9) || m_sdk != 0 || m_ztsdk != 0) {
						ideaTime.setDcId(0);
						ideaTime.setDcId2(0);
					} else {
						ideaTime.setDcId(kk[j]);
						ideaTime.setDcId2(0);
					}
					ideaTime.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			j++;
			temp = EasyCastUtil.getTomorrow(temp);
		}
	}	
	
	void insertVhideaTime(int kk[], int idea_id, Date startDate, Date endDate ,String is_show_priority,String product_reserve_method, int m_ztsdk, int m_sdk) {		
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
				VhideaTime vhideaTime = new VhideaTime();
				vhideaTime.setIdeaId(idea_id);
				vhideaTime.setStatus(1);
				vhideaTime.setStarttime(calendar.getTime());                   
					calendar.set(Calendar.HOUR, 23);
					calendar.set(Calendar.MINUTE, 59);
					calendar.set(Calendar.SECOND, 59);
					vhideaTime.setEndtime(calendar.getTime());
					int product_reserve_method_idea_time = Integer
							.parseInt(product_reserve_method);
					if ((product_reserve_method_idea_time == 2) || (product_reserve_method_idea_time == 4) || (product_reserve_method_idea_time == 3) || (product_reserve_method_idea_time == 5) || (product_reserve_method_idea_time == 9) || m_sdk != 0 || m_ztsdk != 0) {
						vhideaTime.setDcId(0);
					} else {
						vhideaTime.setDcId(kk[j]);
					}
					vhideaTime.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			j++;
			temp = EasyCastUtil.getTomorrow(temp);
		}
	}	
	void insertHideaTime(int kk[],int idea_id, Date startDate, Date endDate, String product_reserve_method) {
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
					int product_reserve_method_idea_time = Integer.parseInt(product_reserve_method);
					if ((product_reserve_method_idea_time == 2) || (product_reserve_method_idea_time == 4) || (product_reserve_method_idea_time == 3) || (product_reserve_method_idea_time == 5)) {
						hIdeaTime.setDcId(0);
					} else {
						hIdeaTime.setDcId(kk[j]);
					}
					hIdeaTime.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			j++;
			temp = EasyCastUtil.getTomorrow(temp);
		}
	}
	void insertIdeaMonitor(int ad_type, int cast_id,int idea_id, String click_url,
			String click_kh_url, String playing_url,String show_url, String over_url,
			String iso_url, String mt_url, String iso_click_url,
			String iso_h5_url, int outtime,String customtext_url,String clientcustomclick_url,String clientskip_url,String clientfee_url,String othercustomtextclick_url,String otherskip_url,String otherfeep_url,int pc_vf_impression_pc,int pc_vf_impression,int m_vb_impression,int m_vo_impression,int pc_vob_impression_pc,int pc_vb_impression_pc,int pc_tp_impression_pc,String custom_text,String custom_text_mf,
			Idea idea,String m_mhtml_clickurl,String m_mhtml_show,String m_mhtml_click,String app_search_banner_type,String app_search_banner_youkupip_url,String app_search_banner_youkupip_clickurl,String app_search_banner_youkupip_showurl,String app_search_banner_youkupip_clickmonitor,
			String is_ir,String ir_type,String clientDSPpushurl_text,String otherDSPpushurl_text,
			String vhtml_yt_promoted_client_show_url,String vhtml_yt_promoted_other_show_url,String vhtml_yt_promoted_client_click_url,String app_playing_banner_clickurl,String app_playing_banner_showurl,String app_playing_banner_clickmonitor_url,String app_playing_banner_type,String clientplayover_time,String m_mi_atv_text,String m_mi_atv_text1,String co_banner_idea,String m_mi_ipad_landscape_idea,String m_mi_iphone_portrait_idea,String skip_button_text,String app_homepage_type,String app_homepage_url,String app_homepage_clickurl,String app_homepage_showurl,String[] chk_os,String app_ott_display_type,String interact_effect_type,String charge_type,String feedAd_type,String feedAd_type_kandian,String onebuyurl_text) {
		try {
			if(!"".equals(click_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_APP_PLAYING_BANNER&&ad_type != m_homepage_banner_web &&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF){
				String click_urls[] = click_url.split("\r?\n");
				for(int i = 0; i < click_urls.length ; i++){
					IdeaMonitor ideaMonitor = new IdeaMonitor();
					ideaMonitor.setIdeaId(idea_id);
					ideaMonitor.setType(1);
					ideaMonitor.setSite(0);		
					if (ad_type == NEW_QIANTIE || ad_type == PC_BF || ad_type == NEW_HOUTIE || ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR || ad_type==NEW_KAIJITU || ad_type==NEW_TIEPIAN || ad_type==NEW_JUCHANGBIAOBAN || ad_type == NEW_OVERLAY_FLOAT) {
						ideaMonitor.setBt(1);
					}
					if (ad_type == MB_QIANTIE || ad_type == MB_BF || ad_type == MB_HOUTIE || ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO || ad_type == MB_ZANTING || ad_type == MB_QUANPING || ad_type == MB_KAIJITU || ad_type==MB_TIEPIAN || ad_type==MB_JUCHANGBIAOBAN || ad_type == MB_ISP || ad_type==MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
						ideaMonitor.setBt(2);
					}		
					if (((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))) || ((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w"))) || ad_type == MB_FEED || ad_type == YOUKU_FEEDAD) {
						ideaMonitor.setBt(0);
					}
					ideaMonitor.setMt(-1);
					if(!"".equals(m_mi_atv_text)&&ad_type==MB_KAIJITU){
						ideaMonitor.setContent(m_mi_atv_text);
					}
					if (!"".equals(click_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_APP_PLAYING_BANNER&&ad_type != m_homepage_banner_web &&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
						ideaMonitor.setUrl(covertUrl(click_urls[i]));
						ideaMonitor.setSeq(i);
						ideaMonitor.setCastId(cast_id);
						//ott???????????????????????????????????????????????????
						if(chk_os != null&&chk_os[0].contains("0_5_2_a")&&pc_vf_impression==3) {
							
						}else {
							ideaMonitor.save();	
						}
						
					}		
				}
			}
			
			if(ad_type == MB_APPSEARCHBANNER){
				if(app_search_banner_type.equals("1")){
					IdeaMonitor ideaMonitor = new IdeaMonitor();
					ideaMonitor.setIdeaId(idea_id);
					ideaMonitor.setType(1);
					ideaMonitor.setSite(0);
					if(!"".equals(app_search_banner_youkupip_clickurl)){
						ideaMonitor.setSite(1);				
						ideaMonitor.setUrl(covertUrl(app_search_banner_youkupip_clickurl));
					}
//					if(!"".equals(app_search_banner_tudoupip_clickurl)){
//	                    ideaMonitor.setSite(2);					
//						ideaMonitor.setUrl(covertUrl(app_search_banner_tudoupip_clickurl));
//					}
					ideaMonitor.setBt(0);
					ideaMonitor.setCastId(cast_id);
					ideaMonitor.save();
					
					//??????????????????
					if(!"".equals(app_search_banner_youkupip_clickmonitor)) {
						IdeaMonitor ideaMonitor1 = new IdeaMonitor();
						ideaMonitor1.setIdeaId(idea_id);
						ideaMonitor1.setType(2);
						ideaMonitor1.setSite(0);
						if(!"".equals(app_search_banner_youkupip_clickurl)){
							ideaMonitor1.setSite(1);				
							ideaMonitor1.setUrl(covertUrl(app_search_banner_youkupip_clickmonitor));
						}
						ideaMonitor1.setBt(0);
						ideaMonitor1.setCastId(cast_id);
						ideaMonitor1.save();
					}
				}
			}			
			if(ad_type == MB_APP_HOMEPAGE){
				if(app_homepage_type.equals("1")){
					IdeaMonitor ideaMonitor = new IdeaMonitor();
					ideaMonitor.setIdeaId(idea_id);
					ideaMonitor.setType(1);
					ideaMonitor.setSite(0);
					if(!"".equals(app_homepage_clickurl)){				
						//app_ipad???????????????youku?????????
						ideaMonitor.setSite(0);				
						ideaMonitor.setUrl(app_homepage_clickurl);
					}
					ideaMonitor.setBt(0);
					ideaMonitor.setCastId(cast_id);
					ideaMonitor.save();
				}
			}			
			if(ad_type == MB_APP_PLAYING_BANNER){
				if(app_playing_banner_type.equals("1")){
					if(!"".equals(app_playing_banner_clickurl)){
						IdeaMonitor ideaMonitor = new IdeaMonitor();
						ideaMonitor.setIdeaId(idea_id);
						ideaMonitor.setType(1);
						ideaMonitor.setSite(0);				
						ideaMonitor.setUrl(covertUrl(app_playing_banner_clickurl));
						ideaMonitor.setBt(2);
						ideaMonitor.setCastId(cast_id);
						ideaMonitor.save();
					}
				}
			}
			
			if(ad_type == MB_WENZILIAN){
					if(!"".equals(m_mhtml_clickurl)){
						IdeaMonitor ideaMonitor = new IdeaMonitor();
						ideaMonitor.setIdeaId(idea_id);
						ideaMonitor.setType(1);
						ideaMonitor.setSite(0);				
						ideaMonitor.setUrl(covertUrl(m_mhtml_clickurl));
						ideaMonitor.setBt(2);
						ideaMonitor.setCastId(cast_id);
						ideaMonitor.save();
					}
					if(!"".equals(m_mhtml_show)){
						IdeaMonitor ideaMonitor1 = new IdeaMonitor();
						ideaMonitor1.setIdeaId(idea_id);
						ideaMonitor1.setType(3);
						ideaMonitor1.setSite(0);				
						ideaMonitor1.setUrl(covertUrl(m_mhtml_show));
						ideaMonitor1.setBt(2);
						ideaMonitor1.setCastId(cast_id);
						ideaMonitor1.save();
					}
					if(!"".equals(m_mhtml_click)){
						IdeaMonitor ideaMonitor2 = new IdeaMonitor();
						ideaMonitor2.setIdeaId(idea_id);
						ideaMonitor2.setType(2);
						ideaMonitor2.setSite(0);				
						ideaMonitor2.setUrl(covertUrl(m_mhtml_click));
						ideaMonitor2.setBt(2);
						ideaMonitor2.setCastId(cast_id);
						ideaMonitor2.save();
					}
				
			}
						
			IdeaMonitor ideaMonitor1 = new IdeaMonitor();
			ideaMonitor1.setIdeaId(idea_id);
			ideaMonitor1.setType(2);
            ideaMonitor1.setSite(0);           
			if (ad_type == NEW_QIANTIE || ad_type == PC_BF|| ad_type == NEW_HOUTIE || ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU || ad_type==NEW_TIEPIAN || ad_type==NEW_JUCHANGBIAOBAN || ad_type == NEW_OVERLAY_FLOAT) {
				ideaMonitor1.setBt(1);
			}
			if (ad_type == MB_QIANTIE ||ad_type == MB_BF|| ad_type == MB_HOUTIE || ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO || ad_type == MB_ZANTING || ad_type == MB_QUANPING || ad_type == MB_KAIJITU || ad_type==MB_TIEPIAN || ad_type==MB_JUCHANGBIAOBAN || ad_type == MB_ISP ||ad_type==MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
				ideaMonitor1.setBt(2);
			}			
			if (((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))) || ((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w"))) || ad_type == MB_FEED || ad_type == YOUKU_FEEDAD || ad_type == OTT_DISPLAY || ad_type == OTT_DIS_REC) {
				ideaMonitor1.setBt(0);
			}		
			ideaMonitor1.setMt(-1);
			if (!"".equals(click_kh_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_APP_PLAYING_BANNER&&ad_type != m_homepage_banner_web &&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
				ideaMonitor1.setUrl(click_kh_url);
				ideaMonitor1.setCastId(cast_id);
				
				//ott???????????????????????????????????????????????????
				if(chk_os != null&&chk_os[0].contains("0_5_2_a")&&pc_vf_impression==3) {
					
				}else {
					ideaMonitor1.save();
				}
				
			}			
			if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617){
				if(!"".equals(vhtml_yt_promoted_client_click_url)){
					ideaMonitor1.setSite(1);				
					ideaMonitor1.setUrl(covertUrl(vhtml_yt_promoted_client_click_url));
					ideaMonitor1.setBt(1);
					ideaMonitor1.setCastId(cast_id);
					ideaMonitor1.save();

				}
			}			
			//mvhtml
			if(ad_type == MB_APP_PLAYING_BANNER){
				if(app_playing_banner_type.equals("1")){
					if(!"".equals(app_playing_banner_clickmonitor_url)){
						ideaMonitor1.setSite(0);				
						ideaMonitor1.setUrl(covertUrl(app_playing_banner_clickmonitor_url));
						ideaMonitor1.setBt(0);
						ideaMonitor1.setCastId(cast_id);
						ideaMonitor1.save();
					}
				}else{
				}
			}
			IdeaMonitor ideaMonitor2 = new IdeaMonitor();
			ideaMonitor2.setIdeaId(idea_id);
			ideaMonitor2.setType(3);
			//??????????????????interact_effect=32 ,chargeTime=1
			if((charge_type.equals("1")&&interact_effect_type.equals("32"))||"2".equals(feedAd_type) || "2".equals(feedAd_type_kandian)){
				ideaMonitor2.setType(20);
			}
			ideaMonitor2.setSite(0);		
			if (ad_type == NEW_QIANTIE || ad_type == PC_BF|| ad_type == NEW_HOUTIE || ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU ||ad_type==NEW_TIEPIAN || ad_type == MB_APPSEARCHBANNER || ad_type==NEW_JUCHANGBIAOBAN || ad_type == NEW_FACEOFF || ad_type == NEW_OVERLAY_FLOAT) {
				ideaMonitor2.setBt(1);
			}
			if (ad_type == MB_QIANTIE ||ad_type == MB_BF|| ad_type == MB_HOUTIE || ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO || ad_type == MB_ZANTING || ad_type == MB_QUANPING || ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN || ad_type==MB_JUCHANGBIAOBAN || ad_type == MB_FACEOFF || ad_type == MB_ISP || ad_type==MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
				ideaMonitor2.setBt(2);
			}			
			if (((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))) || ((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w"))) || ad_type == MB_FEED || ad_type == YOUKU_FEEDAD|| ad_type == OTT_DISPLAY || ad_type == OTT_DIS_REC || ad_type == OTT_SCREENSAVER || ad_type == OTT_POWEROFF) {
				ideaMonitor2.setBt(0);
			}
			ideaMonitor2.setMt(-1);

			if (!"".equals(show_url)&&ad_type != MB_WENZILIAN &&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_APP_PLAYING_BANNER&&ad_type != m_homepage_banner_web) {
				ideaMonitor2.setUrl(show_url);
				ideaMonitor2.setCastId(cast_id);
				ideaMonitor2.save();
			}			
			if(ad_type == MB_APPSEARCHBANNER){
				if(app_search_banner_type.equals("1")){
					if(!"".equals(app_search_banner_youkupip_showurl)){
						ideaMonitor2.setSite(1);				
						ideaMonitor2.setUrl(app_search_banner_youkupip_showurl);
					}
//					if(!"".equals(app_search_banner_tudoupip_showurl)){
//						ideaMonitor2.setSite(2);					
//						ideaMonitor2.setUrl(app_search_banner_tudoupip_showurl);
//					}
					ideaMonitor2.setBt(0);
					ideaMonitor2.setCastId(cast_id);
					ideaMonitor2.save();
				}else {
				}
			}else if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617){
				if(!"".equals(vhtml_yt_promoted_client_show_url)){
					ideaMonitor2.setSite(1);				
					ideaMonitor2.setUrl(vhtml_yt_promoted_client_show_url);
					ideaMonitor2.setBt(1);
					ideaMonitor2.setCastId(cast_id);
					ideaMonitor2.save();
				}
			}else if(ad_type == MB_APP_PLAYING_BANNER){
				if(app_playing_banner_type.equals("1")){
					if(!"".equals(app_playing_banner_showurl)){
						ideaMonitor2.setSite(0);				
						ideaMonitor2.setUrl(app_playing_banner_showurl);
						ideaMonitor2.setBt(0);
						ideaMonitor2.setCastId(cast_id);
						ideaMonitor2.save();
					}
				}else{
				}
			}else if(ad_type == MB_APP_HOMEPAGE){
				if(app_homepage_type.equals("1")){
					if(!"".equals(app_homepage_showurl)){
						ideaMonitor2.setSite(0);				
						ideaMonitor2.setUrl(app_homepage_showurl);
						ideaMonitor2.setBt(0);
						ideaMonitor2.setCastId(cast_id);
						ideaMonitor2.setCastId(cast_id);
						ideaMonitor2.save();			
					}
				}else{
				}
			}
			IdeaMonitor ideaMonitor3 = new IdeaMonitor();
			ideaMonitor3.setIdeaId(idea_id);
			if (outtime != 0&&!"".equals(playing_url)) {
				ideaMonitor3.setType(5);
				ideaMonitor3.setMt(outtime);
				ideaMonitor3.setSite(0);
				if (ad_type == NEW_QIANTIE || ad_type == PC_BF || ad_type == NEW_HOUTIE || ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU || ad_type==NEW_TIEPIAN || ad_type==NEW_JUCHANGBIAOBAN || ad_type == NEW_OVERLAY_FLOAT) {
					ideaMonitor3.setBt(1);
				}
				if (ad_type == MB_QIANTIE ||ad_type == MB_BF|| ad_type == MB_HOUTIE || ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO || ad_type == MB_ZANTING || ad_type == MB_QUANPING || ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN|| ad_type==MB_JUCHANGBIAOBAN || ad_type==MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
					ideaMonitor3.setBt(2);
				}
				if((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a")) ||((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w")))){
					ideaMonitor3.setBt(3);
				}
				if (!"".equals(over_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_APP_PLAYING_BANNER&&ad_type != m_homepage_banner_web &&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
					if(((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))||(ad_type == MB_ZANTING)||(ad_type == MB_JIAOBIAO)||(ad_type == MB_KAIJITU)){
					}else{
						ideaMonitor3.setUrl(playing_url);
						ideaMonitor3.setCastId(cast_id);
						ideaMonitor3.save();
					}
				}
			} 					
			IdeaMonitor ideaMonitor17 = new IdeaMonitor();
			ideaMonitor17.setIdeaId(idea_id);
			ideaMonitor17.setSite(0);			
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE || ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU || ad_type==NEW_TIEPIAN || ad_type==NEW_JUCHANGBIAOBAN || ad_type == NEW_OVERLAY_FLOAT) {
				ideaMonitor17.setBt(1);
			}
			if (ad_type == MB_QIANTIE ||ad_type == MB_BF|| ad_type == MB_HOUTIE || ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO || ad_type == MB_ZANTING || ad_type == MB_QUANPING || ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN || ad_type==MB_JUCHANGBIAOBAN || ad_type==MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
				ideaMonitor17.setBt(2);
			}			
			if (((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))) || ((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w"))) || ad_type == MB_FEED || ad_type == YOUKU_FEEDAD|| ad_type == OTT_DISPLAY || ad_type == OTT_DIS_REC) {
				ideaMonitor17.setBt(0);
			}			
			if (!"".equals(over_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_APP_PLAYING_BANNER&&ad_type != MB_JIAOBIAO&&ad_type != m_homepage_banner_web &&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF && ad_type != MB_ISP && ad_type != OTT_DIS_REC && ad_type != OTT_SCREENSAVER && ad_type != OTT_POWEROFF && ad_type != MB_FEED && ad_type != YOUKU_FEEDAD && !"2".equals(app_ott_display_type)) {
				ideaMonitor17.setType(4);
				if(((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))){
					if("0".equals(clientplayover_time)){
						ideaMonitor17.setType(4);
						ideaMonitor17.setMt(-1);
					}else if(!"0".equals(clientplayover_time)&&clientplayover_time != null&&!"".equals(clientplayover_time)){
						ideaMonitor17.setType(5);
						ideaMonitor17.setMt(Integer.parseInt(clientplayover_time));
					}
				}
				ideaMonitor17.setUrl(over_url);
				ideaMonitor17.setCastId(cast_id);
				ideaMonitor17.save();
			}
			IdeaMonitor ideaMonitor4 = new IdeaMonitor();
			ideaMonitor4.setIdeaId(idea_id);
			ideaMonitor4.setType(6);
			//ideaMonitor4.setSite(0);
			if((charge_type.equals("1")&&interact_effect_type.equals("32"))||"2".equals(feedAd_type) || "2".equals(feedAd_type_kandian)){
				ideaMonitor4.setType(20);
			}
			ideaMonitor4.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == PC_BF|| ad_type == NEW_HOUTIE || ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU ||ad_type==NEW_TIEPIAN || ad_type==NEW_JUCHANGBIAOBAN || ad_type == NEW_FACEOFF || ad_type == NEW_OVERLAY_FLOAT) {
				ideaMonitor4.setBt(1);
			}
			if (ad_type == MB_QIANTIE ||ad_type == MB_BF|| ad_type == MB_HOUTIE || ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO || ad_type == MB_ZANTING || ad_type == MB_QUANPING || ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN  || ad_type==MB_JUCHANGBIAOBAN || ad_type == MB_FACEOFF || ad_type == MB_ISP || ad_type==MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
				ideaMonitor4.setBt(2);
			}			
			if (((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))) || ((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w"))) || ad_type == MB_FEED || ad_type == YOUKU_FEEDAD || ad_type == OTT_DISPLAY || ad_type == OTT_DIS_REC || ad_type == OTT_SCREENSAVER || ad_type == OTT_POWEROFF) {
				ideaMonitor4.setBt(0);
			}			
			ideaMonitor4.setMt(-1);
			if (!"".equals(iso_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_APP_PLAYING_BANNER&&ad_type != m_homepage_banner_web) {
				ideaMonitor4.setUrl(iso_url);
				ideaMonitor4.setCastId(cast_id);
				ideaMonitor4.save();
				
			}			
			if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617){
				if(!"".equals(vhtml_yt_promoted_other_show_url)){
					ideaMonitor4.setSite(1);				
					ideaMonitor4.setUrl(vhtml_yt_promoted_other_show_url);
					ideaMonitor4.setBt(1);
					ideaMonitor4.setCastId(cast_id);
					ideaMonitor4.save();
				}
			}
			IdeaMonitor ideaMonitor5 = new IdeaMonitor();
			ideaMonitor5.setIdeaId(idea_id);
			ideaMonitor5.setType(7);
			//ideaMonitor5.setSite(0);
			ideaMonitor5.setSite(0);			
			if (ad_type == NEW_QIANTIE || ad_type == PC_BF|| ad_type == NEW_HOUTIE || ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU ||ad_type==NEW_TIEPIAN || ad_type==NEW_JUCHANGBIAOBAN || ad_type == NEW_OVERLAY_FLOAT) {
				ideaMonitor5.setBt(1);
			}
			if (ad_type == MB_QIANTIE ||ad_type == MB_BF|| ad_type == MB_HOUTIE || ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO || ad_type == MB_ZANTING || ad_type == MB_QUANPING || ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN|| ad_type==MB_JUCHANGBIAOBAN || ad_type == MB_ISP || ad_type==MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
				ideaMonitor5.setBt(2);
			}			
			if (((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))) ||((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w")))|| ad_type == MB_FEED || ad_type == YOUKU_FEEDAD || ad_type == OTT_DISPLAY || ad_type == OTT_DIS_REC) {
				ideaMonitor5.setBt(0);
			}			
			ideaMonitor5.setMt(-1);
			if (!"".equals(iso_click_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_APP_PLAYING_BANNER&&ad_type != MB_JIAOBIAO&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
				ideaMonitor5.setUrl(iso_click_url);
				ideaMonitor5.setCastId(cast_id);
				
				//ott???????????????????????????????????????????????????
				if(chk_os != null&&chk_os[0].contains("0_5_2_a")&&pc_vf_impression==3) {
					
				}else {
					ideaMonitor5.save();	
				}
			}
			IdeaMonitor ideaMonitor6 = new IdeaMonitor();
			ideaMonitor6.setIdeaId(idea_id);
			ideaMonitor6.setType(8);
			ideaMonitor6.setSite(0);
			if (ad_type == NEW_QIANTIE || ad_type == NEW_HOUTIE || ad_type == NEW_ZHONGCHA || ad_type == NEW_JIAOBIAO || ad_type == NEW_ZANTING || ad_type == NEW_SHORTFULL || ad_type == NEW_SPECIALAD || ad_type == NEW_ADSELECTOR ||ad_type ==NEW_KAIJITU ||ad_type==NEW_TIEPIAN || ad_type==NEW_JUCHANGBIAOBAN || ad_type ==NEW_OVERLAY_FLOAT) {
				ideaMonitor6.setBt(1);
			}
			if (ad_type == MB_QIANTIE ||ad_type == MB_BF|| ad_type == MB_HOUTIE || ad_type == MB_ZHONGCHA || ad_type == MB_JIAOBIAO || ad_type == MB_ZANTING || ad_type == MB_QUANPING || ad_type == MB_KAIJITU ||ad_type==MB_TIEPIAN|| ad_type==MB_JUCHANGBIAOBAN || ad_type==MB_OVERLAY_FLOAT || ad_type == MB_FOCUS_CIRCLE) {
				ideaMonitor6.setBt(2);
			}
			ideaMonitor6.setMt(-1);
			if (!"".equals(iso_h5_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != MB_JIAOBIAO&&(pc_vf_impression == 1 || m_vb_impression == 1 || m_vo_impression == 1 )&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
				ideaMonitor6.setUrl(iso_h5_url);
				ideaMonitor6.setCastId(cast_id);
				ideaMonitor6.save();
			}			
			//trueview
			//???????????????????????????(type=10)
			if(!"?????????".equals(custom_text)||!"?????????".equals(custom_text_mf)){
				IdeaMonitor ideaMonitor7 = new IdeaMonitor();
				ideaMonitor7.setIdeaId(idea_id);
				ideaMonitor7.setType(10);
				ideaMonitor7.setSite(0);
				if (((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))) {
					ideaMonitor7.setBt(1);
					if(ad_type==MB_QIANTIE){
						ideaMonitor7.setBt(2);
					}
					ideaMonitor7.setMt(-1);
					if(ad_type == NEW_QIANTIE || ad_type == NEW_ZHONGCHA || ad_type == MB_ZHONGCHA){
						ideaMonitor7.setContent(custom_text);
					}else if(ad_type == MB_QIANTIE){
						ideaMonitor7.setContent(custom_text_mf);
					}
	                
					if (!"".equals(customtext_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
						ideaMonitor7.setUrl(covertUrl(customtext_url));
						ideaMonitor7.setCastId(cast_id);
						ideaMonitor7.save();
					}			
				}				
				//????????????????????????????????????????????????(type=11)
				IdeaMonitor ideaMonitor8 = new IdeaMonitor();
				ideaMonitor8.setIdeaId(idea_id);
				ideaMonitor8.setType(11);
				ideaMonitor8.setSite(0);
				if (((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))) {
					ideaMonitor8.setBt(1);
					if(ad_type==MB_QIANTIE){
						ideaMonitor8.setBt(2);
					}
					ideaMonitor8.setMt(-1);
					if (!"".equals(clientcustomclick_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
						ideaMonitor8.setUrl(clientcustomclick_url);
						ideaMonitor8.setCastId(cast_id);
						ideaMonitor8.save();
					}			
				}
			}			
			//?????????????????????????????????(type=9)
			IdeaMonitor ideaMonitor9 = new IdeaMonitor();
			ideaMonitor9.setIdeaId(idea_id);
			ideaMonitor9.setType(9);
			ideaMonitor9.setSite(0);
			if (((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))) {
				ideaMonitor9.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor9.setBt(2);
				}
				if((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))||((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w")))){
					ideaMonitor9.setBt(3);
				}
				ideaMonitor9.setMt(-1);
				if (!"".equals(clientskip_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
					//System.out.println("?????????????????????????????????:" + clientskip_url);
					ideaMonitor9.setUrl(clientskip_url);
					ideaMonitor9.setCastId(cast_id);
					ideaMonitor9.save();
				}			
			}		
			//?????????????????????????????????(type=5)
			IdeaMonitor ideaMonitor10 = new IdeaMonitor();
			ideaMonitor10.setIdeaId(idea_id);
			ideaMonitor10.setType(5);
			//ideaMonitor10.setSite(0);
			ideaMonitor10.setSite(0);		
			if (((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))) {
				ideaMonitor10.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor10.setBt(2);
				}
				if((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))||((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w")))){
					ideaMonitor10.setBt(3);
				}
				if(idea.getChargeTime()==0){
					ideaMonitor10.setMt(-1);
				}else{
					ideaMonitor10.setMt(idea.getChargeTime());	
				}

				if (!"".equals(clientfee_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
					ideaMonitor10.setUrl(clientfee_url);
					ideaMonitor10.setCastId(cast_id);
					ideaMonitor10.save();
				}			
			}			
			//?????????????????????????????????????????????????????????(type=11)
			IdeaMonitor ideaMonitor11 = new IdeaMonitor();
			ideaMonitor11.setIdeaId(idea_id);
			ideaMonitor11.setType(11);
			ideaMonitor11.setSite(0);
			if (((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))) {
				ideaMonitor11.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor11.setBt(2);
				}
				ideaMonitor11.setMt(-1);

				if (!"".equals(othercustomtextclick_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
					ideaMonitor11.setUrl(othercustomtextclick_url);
					ideaMonitor11.setCastId(cast_id);
					ideaMonitor11.save();
				}			
			}
			//????????????????????????????????????(type=9)
			IdeaMonitor ideaMonitor12 = new IdeaMonitor();
			ideaMonitor12.setIdeaId(idea_id);
			ideaMonitor12.setType(9);
			ideaMonitor12.setSite(0);
			if (((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))) {
				ideaMonitor12.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor12.setBt(2);
				}
				if((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))||((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w")))){
					ideaMonitor12.setBt(3);
				}
				ideaMonitor12.setMt(-1);

				if (!"".equals(otherskip_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
					ideaMonitor12.setUrl(otherskip_url);
					ideaMonitor12.setCastId(cast_id);
					ideaMonitor12.save();
				}			
			}			
			//????????????????????????????????????(type=5)
			IdeaMonitor ideaMonitor13 = new IdeaMonitor();
			ideaMonitor13.setIdeaId(idea_id);
			ideaMonitor13.setType(5);
			ideaMonitor13.setSite(0);
			if (((ad_type == NEW_QIANTIE)&&(pc_vf_impression_pc==2))||((ad_type == NEW_HOUTIE)&&(pc_vb_impression_pc==2))||((ad_type == NEW_ZHONGCHA)&&(pc_vob_impression_pc==2))||((ad_type == NEW_TIEPIAN)&&(pc_tp_impression_pc==2))||((ad_type == MB_QIANTIE)&&(pc_vf_impression==2))) {
				ideaMonitor13.setBt(1);
				if(ad_type==MB_QIANTIE){
					ideaMonitor13.setBt(2);
				}
				if((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_a"))||((chk_os != null) && (chk_os.length == 1) && (chk_os[0].contains("0_5_2_w")))){
					ideaMonitor13.setBt(3);
				}
				if(idea.getChargeTime()==0){
					ideaMonitor13.setMt(-1);
				}else{
					ideaMonitor13.setMt(idea.getChargeTime());
				}
				if (!"".equals(otherfeep_url)&&ad_type != MB_WENZILIAN&&ad_type != MB_APPSEARCHBANNER&&ad_type != MB_APP_HOMEPAGE&&ad_type != promoted_video_ads_1430192600&&ad_type != promoted_video_ads_1430192617&&ad_type != m_homepage_banner_web&&ad_type != NEW_FACEOFF && ad_type != MB_FACEOFF) {
					ideaMonitor13.setUrl(otherfeep_url);
					ideaMonitor13.setCastId(cast_id);
					ideaMonitor13.save();
				}			
			}	
			
			if("1".equals(is_ir)&&!"0".equals(ir_type)){
				if(!"".equals(clientDSPpushurl_text)){
					IdeaMonitor ideaMonitor15 = new IdeaMonitor();
					ideaMonitor15.setIdeaId(idea_id);
					ideaMonitor15.setType(12);
					ideaMonitor15.setSite(0);
					ideaMonitor15.setBt(0);
					ideaMonitor15.setUrl(clientDSPpushurl_text);
					ideaMonitor15.setMt(-1);
					ideaMonitor15.setCastId(cast_id);
					ideaMonitor15.save();
				}
				if(!"".equals(otherDSPpushurl_text)){
					IdeaMonitor ideaMonitor16 = new IdeaMonitor();
					ideaMonitor16.setIdeaId(idea_id);
					ideaMonitor16.setType(12);
					ideaMonitor16.setSite(0);
					ideaMonitor16.setBt(0);
					ideaMonitor16.setUrl(otherDSPpushurl_text);
					ideaMonitor16.setMt(-1);
					ideaMonitor16.setCastId(cast_id);
					ideaMonitor16.save();
				}
			}else{
			}
			
			//ott?????????
			if(!"".equals(onebuyurl_text)&&onebuyurl_text != null) {
				IdeaMonitor ideaMonitor18 = new IdeaMonitor();
				ideaMonitor18.setIdeaId(idea_id);
				ideaMonitor18.setType(26);
				ideaMonitor18.setSite(0);
				ideaMonitor18.setBt(0);
				ideaMonitor18.setUrl(onebuyurl_text);
				ideaMonitor18.setMt(-1);
				ideaMonitor18.setCastId(cast_id);
				ideaMonitor18.save();
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
	void insertVhideaCpm(int idea_id,String product_reserve_method, Date startDate, Date endDate) {

		Date temp = startDate;
		Calendar calendar;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);
			try {
				VhideaCpm vhideaCpm = new VhideaCpm();
				vhideaCpm.setIdeaId(idea_id);
				if(Integer.parseInt(product_reserve_method)==1){
					vhideaCpm.setCpm(1000);
					vhideaCpm.setCpc(0);
				}else if(Integer.parseInt(product_reserve_method)==6){
					vhideaCpm.setCpm(0);
					vhideaCpm.setCpc(1000);
				}
				vhideaCpm.setRate(0);
				vhideaCpm.setTargetDate(temp);
				vhideaCpm.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			temp = EasyCastUtil.getTomorrow(temp);
		}
	}	
	//insertHideaCpm
		void insertHideaCpm(int idea_id, Date startDate, Date endDate ,String product_reserve_method) {
		Date temp = startDate;
		Calendar calendar;
		while (temp.compareTo(endDate) <= 0) {
			calendar = Calendar.getInstance();
			calendar.setTime(temp);
			try {
				HideaCpm hIdeaCpm = new HideaCpm();
				hIdeaCpm.setIdeaId(idea_id);
				int product_reserve_method_idea_time = Integer.parseInt(product_reserve_method);
				if(product_reserve_method_idea_time == 1){
					hIdeaCpm.setCpm(1000);
					hIdeaCpm.setRate(0);
				}
				if(product_reserve_method_idea_time == 3){
					hIdeaCpm.setCpm(0);
					hIdeaCpm.setRate(100);
				}				
				hIdeaCpm.setCpc(0);				
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
			String pc_vob_ideaurl,String pc_vob_pipurl, String m_mo_ideaurl, String pc_vc_y_ideaurl,String pc_vc_y_ideaurl_img,String pc_vc_y_ideaurl_h5,
			String pc_vc_t_ideaurl, String m_vc_openstatus_pageurl,
			String m_vc_closestatus_pageurl, String pc_vp_y_ideaurl,String pc_vp_y_ideaurl_h5,
			String pc_vp_y_full_ideaurl, String pc_vp_y_full_ideaurl_h5,String pc_vp_t_ideaurl,
			String pc_vp_t_full_ideaurl, String m_vp_ideaurl,
			String m_mqp_ipad_ideaurl_748, String m_mqp_iphone_ideaurl_480,
			String m_mqp_androidpad_ideaurl_720,
			String m_mqp_androidphone_ideaurl_480,
			String m_mi_ipad_ideaurl_768, String m_mi_ipad_ideaurl_1004,
			String m_mi_iphone_ideaurl_940, String m_mi_iphone_ideaurl_1116,
			String m_mi_iphone_ideaurl_1334, String m_mi_iphone_ideaurl_1920,String m_mi_iphone_ideaurl_xiami,String m_mi_aphone_ideaurl_xiami,
			String m_mi_apad_ideaurl_800, String m_mi_apad_ideaurl_600, String m_mi_apad_ideaurl_768,
			String m_mi_aphone_ideaurl_1280, String m_mi_aphone_ideaurl_800,
			String m_mi_atv_ideaurl_720, String m_iku_pc_ideaurl_650,String m_iku_pc_ideaurl_720,
			int pc_vf_impression,int m_vb_impression,int m_vo_impression,
			int pc_vf_impression_pc,int pc_vob_impression_pc,int pc_vb_impression_pc,int pc_tp_impression_pc, String m_h5_vf_ideaurl_phone,String m_h5_vf_ideaurl_pad,String m_h5_vb_ideaurl_phone,String m_h5_vb_ideaurl_pad,String m_h5_vo_ideaurl_phone,String m_h5_vo_ideaurl_pad,
			String[] chk_os,String pc_tp_ideaurl,String m_vtp_ideaurl,
			String pc_vc_width,String pc_vc_height,String m_mhtml_text_content,
			String app_search_banner_type,String app_search_banner_youkupip_url,String app_search_banner_youkupip_clickurl,String app_search_banner_youkupip_showurl,String app_search_banner_youkupip_clickmonitor,String vhtml_yt_promoted_video_ads_url,
			String is_ir,String app_homepage_type,String app_homepage_url,String app_homepage_clickurl,String app_homepage_showurl,
			int m_ztsdk,int m_sdk,String app_playing_banner_url,String app_playing_banner_type,String pc_vf_buyingbyseeing_ideaurl_flash,String pc_vf_buyingbyseeing_ideaurl_h5,String pc_vf_buyingbyseeing_ideaurl_png,String pc_biaoban_y_ideaurl,String mb_biaoban_y_ideaurl,String pc_normal_zanting_width,String pc_normal_zanting_height,String pc_fullscreen_zanting_width,String pc_fullscreen_zanting_height,String pc_vp_ideacontrol,String html_video_banner_ads_url,String vhtml_m_playing_page_url,String m_vc_pad,String m_vc_phone,String m_vc_h5,String m_ott_vc,String m_mc_location,String m_mc_atv_t,String m_isp_png_url,String m_isp_title,String m_isp_tipcontent,String m_isp_buttontext,String m_mi_atv_text1,String co_banner_idea,String m_mi_ipad_landscape_idea,String m_mi_iphone_portrait_idea,String skip_button_text,String m_vp_is_qr,String m_vp_vq_url,String m_vp_ott_ideaurl,String m_feed_logo_url,String m_feed_customer,String m_feed_video_thumbnail,String m_feed_buttontext,String m_feed_video_url,String ott_display_ideaurl,String app_ott_display_type,String ott_dis_rec_ideaurl,String ott_dis_rec_ideaurl_showtime,String ott_screensaver_ideaurl,String ott_poweroff_ideaurl,String poweroff_showtime,String m_feedAd_video_thumbnail,String m_feedAd_video_url,String m_feedAd_png_url_750_350,String m_feedAd_png_url_750_280,String m_feedAd_prompt,String m_feedAd_brandlogo,String m_feedAd_length,String m_vf_pipurl,String mb_vf_buyingbyseeing_ideaurl,String mb_vf_ott_buyingbyseeing_ideaurl,String pc_overlay_float_pic_ideaurl,String pc_overlay_float_swf_ideaurl,String pc_overlay_float_h5_ideaurl,String mb_overlay_float_pic_ideaurl,String mb_overlay_float_h5_ideaurl,String mb_focus_circle_pic_ideaurl,String mb_focus_circle_pic_text,String mb_focus_circle_pic_ideaurl_ipad,String m_mi_iphonex_ideaurl_1125,String pc_hvideo_vf_h5,String isDeeplink,String vid_deeplink,String m_mi_iphonex_video_idea,String h5_hvideo_1_url,String h5_hvideo_2_url,String Phone_H5_url,String Pad_H5_url,String main_h5_mf_url_t,String h5_mf_url_t1,String h5_mf_url_t2,String mb_bf_ideaurl,String pc_bf_ideaurl,String ott_display_biterate,String ott_display_volume,String feedAd_type_overall,String m_feedAd_png_url_spotlight,String m_feedAd_brandlogo_spotlight,String m_feedAd_addescript_spotlight,String m_feedAd_prompt_spotlight,String m_feedAd_adname_spotlight,String pc_seeds_title,String pc_seeds_cover,String pc_seeds_ideaurl,String vhtml_type,String vhtml_yt_banner_pip_url,String vhtml_yt_banner_h5_url,String vhtml_yt_banner_h5_width,String vhtml_yt_banner_h5_height,String m_feedAd_video_url_spotlight,String m_feedAd_thumbnail_url_spotlight,String mf_oneBuy_type,String mf_good_id,String mf_taobaoer_id,String mf_onebuy_h5_url,String ott_onebuy_png_url,String mf_onebuy_h5_width,String mf_onebuy_h5_height) {
		try {
			System.out.println("++++++++++++++++" + "go into idea_url " + "+++++++++++++++++++++");
			if (ad_type == NEW_QIANTIE) {
				//to do to set content idea_url
				if (pc_vf_impression_pc == 1 && pc_hvideo_vf_h5 == null && "".equals(pc_hvideo_vf_h5)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(1);
					ideaUrl.setType(1);
					System.out.println("pc_vf_impression_pc is: " + pc_vf_impression_pc);
					String pc_vf_y_ideaurl_encode = URLEncoder.encode(pc_vf_y_ideaurl,"utf-8");
					if("1".equals(loader_type)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/INT_VPAIDAdRenderer.swf?url=" + pc_vf_y_ideaurl_encode);
					}else if("2".equals(loader_type)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/VPAIDAdRenderer.swf?url=" + pc_vf_y_ideaurl_encode);
					}else{
						ideaUrl.setContent("http://static.atm.youku.com/idea/iab/vpaid/V2_INT_VPAIDAdRenderer.swf?url="	+ pc_vf_y_ideaurl_encode);
					}
					ideaUrl.setIdeaWidth(20);
					ideaUrl.setIdeaHeight(10);
					ideaUrl.save();
				}	
				
				if(pc_vf_impression_pc == 1&&pc_hvideo_vf_h5 != null && !"".equals(pc_hvideo_vf_h5)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(18);
					ideaUrl1.setContent(pc_hvideo_vf_h5.trim());
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.save();	
				}
				
				if(pc_vf_impression_pc != 1){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(1);
					ideaUrl1.setContent(pc_vf_y_ideaurl.trim());
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.save();				
				}
				
				if(pc_vf_pipurl != null && !"".equals(pc_vf_pipurl)){		
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(1);
					ideaUrl2.setType(2);
					ideaUrl2.setContent(pc_vf_pipurl.trim());
					ideaUrl2.setIdeaWidth(20);
					ideaUrl2.setIdeaHeight(10);
					ideaUrl2.save();	
				}	
				
			}
			
			if (ad_type == MB_QIANTIE) {
				System.out.println("chk_os:=======" + "go into MB_QIANTIE" + "==========");
				
				//ott?????????idea_url??????type=43???????????????????????????????????????
				if(pc_vf_impression != 3) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					//System.out.println("chk_os:=======" + chk_os[0] + "==========");
				    ideaUrl.setSite(0);	
					ideaUrl.setBt(0);
					ideaUrl.setType(1);
					//to do to set content idea_url
					ideaUrl.setContent(m_vf_ideaurl.trim());
					ideaUrl.setIdeaWidth(20);
					ideaUrl.setIdeaHeight(10);
					
					//??????????????????????????????
					ideaUrl.setSeq(0);
					if(!"".equals(main_h5_mf_url_t)&&main_h5_mf_url_t!=null){
				       ideaUrl.setShowtime(Integer.parseInt(main_h5_mf_url_t));
					}
					
					ideaUrl.save();
				} else if (pc_vf_impression == 3){
					String content = "";
					
					//String template = "{\"METADATA\": {\"UPDATE_NODE\": {\"CDN_NODE\": [\"RS\"]}},\"RS\": \"http://v.youku.com/v_show/id_XNzU0MTEyMzg4.html\",\"VID\": 951711286,\"RST\": \"hvideo\",\"IE\": \"3002048\",\"INTERACTION\": {\"URL\":\"http://taobao.com\", \"RST\":\"html/img\",\"TYPE\":26,\"WIDTH\":120,\"HEIGHT\":64,\"GOODSINFO\":{\"ID\":\"42841816210\",\"SKUID\":\"mm_26632322_6858406_23810104\" }}}";
				    if(!"".equals(m_vf_ideaurl)&&m_vf_ideaurl!=null&&!"".equals(mf_oneBuy_type)&&mf_oneBuy_type!=null&&!"".equals(mf_good_id)&&mf_good_id!=null&&!"".equals(mf_taobaoer_id)&&mf_taobaoer_id!=null) {
				    	String videoVid = insertVideoGroup(m_vf_ideaurl);
    					IdeaUrl ideaUrl1 = new IdeaUrl();
    					ideaUrl1.setIdeaId(idea_id);
    					ideaUrl1.setSite(0);
    					//ideaUrl1.setBt(2);
                        if(!"".equals(mf_onebuy_h5_url)&&mf_onebuy_h5_url!=null) {
                        	content = "{\"METADATA\": {\"UPDATE_NODE\": {\"CDN_NODE\": [\"RS\"]}},\"RS\": \"" + m_vf_ideaurl + "\",\"VID\": " + videoVid + ",\"RST\": \"video\",\"IE\": \"" + idea_id + "\",\"INTERACTION\": {\"URL\":\"" + mf_onebuy_h5_url + "\", \"RST\":\"html\",\"TYPE\":" + mf_oneBuy_type + ",\"WIDTH\":" + mf_onebuy_h5_width + ",\"HEIGHT\":" + mf_onebuy_h5_height + ",\"GOODSINFO\":{\"ID\":\"" + mf_good_id + "\",\"SKUID\":\"" + mf_taobaoer_id + "\"}}}";
        					ideaUrl1.setIdeaWidth(Integer.parseInt(mf_onebuy_h5_width));
        					ideaUrl1.setIdeaHeight(Integer.parseInt(mf_onebuy_h5_height));
                        }
                        
                        if(!"".equals(ott_onebuy_png_url)&&ott_onebuy_png_url!=null) {
                        	
        					
        					URL url = new URL(ott_onebuy_png_url);
        					URLConnection connection = url.openConnection();
        					connection.setDoOutput(true);
        					BufferedImage image = ImageIO.read(connection.getInputStream());
        					int srcWidth = image.getWidth(); // ????????????
        					int srcHeight = image.getHeight(); // ????????????
                        	
                        	content = "{\"METADATA\": {\"UPDATE_NODE\": {\"CDN_NODE\": [\"RS\"]}},\"RS\": \"" + m_vf_ideaurl + "\",\"VID\": " + videoVid + ",\"RST\": \"video\",\"IE\": \"" + idea_id + "\",\"INTERACTION\": {\"URL\":\"" + ott_onebuy_png_url + "\", \"RST\":\"img\",\"TYPE\":" + mf_oneBuy_type + ",\"WIDTH\":" + srcWidth + ",\"HEIGHT\":" + srcHeight + ",\"GOODSINFO\":{\"ID\":\"" + mf_good_id + "\",\"SKUID\":\"" + mf_taobaoer_id + "\"}}}";
                        	
                        	ideaUrl1.setIdeaWidth(srcWidth);
        					ideaUrl1.setIdeaHeight(srcHeight);
                        }
    					ideaUrl1.setBt(0);
    					ideaUrl1.setType(43);
    					ideaUrl1.setContent(content.trim());
    					ideaUrl1.save(); 			    	
				    }
				}
				
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
					if(!"".equals(h5_hvideo_1_url)&&h5_hvideo_1_url!=null&&!"".equals(h5_mf_url_t1)&&h5_mf_url_t1!=null){
						IdeaUrl ideaUrl3 = new IdeaUrl();
						ideaUrl3.setIdeaId(idea_id);
						ideaUrl3.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl3.setBt(0);
						ideaUrl3.setType(1);
						ideaUrl3.setContent(h5_hvideo_1_url.trim());
						ideaUrl3.setIdeaWidth(20);
						ideaUrl3.setIdeaHeight(10);
						ideaUrl3.setSeq(1);
						ideaUrl3.setShowtime(Integer.parseInt(h5_mf_url_t1));
						ideaUrl3.save();
					}
					
					if(!"".equals(h5_hvideo_2_url)&&h5_hvideo_2_url!=null&&!"".equals(h5_mf_url_t2)&&h5_mf_url_t2!=null){
						IdeaUrl ideaUrl4 = new IdeaUrl();
						ideaUrl4.setIdeaId(idea_id);
						ideaUrl4.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl4.setBt(0);
						ideaUrl4.setType(1);
						ideaUrl4.setContent(h5_hvideo_2_url.trim());
						ideaUrl4.setIdeaWidth(20);
						ideaUrl4.setIdeaHeight(10);
						ideaUrl4.setSeq(2);
						ideaUrl4.setShowtime(Integer.parseInt(h5_mf_url_t2));
						ideaUrl4.save();
					}
					//????????????????????????(iphone)
					if(!"".equals(Phone_H5_url)&&Phone_H5_url!=null){
						IdeaUrl ideaUrl5 = new IdeaUrl();
						ideaUrl5.setIdeaId(idea_id);
						ideaUrl5.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl5.setBt(4);
						ideaUrl5.setType(16);
						ideaUrl5.setContent(Phone_H5_url.trim());
						ideaUrl5.setIdeaWidth(20);
						ideaUrl5.setIdeaHeight(10);
						ideaUrl5.save();
					}
					//????????????????????????(ipad)
					if(!"".equals(Pad_H5_url)&&Pad_H5_url!=null){
						IdeaUrl ideaUrl6 = new IdeaUrl();
						ideaUrl6.setIdeaId(idea_id);
						ideaUrl6.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl6.setBt(5);
						ideaUrl6.setType(16);
						ideaUrl6.setContent(Pad_H5_url.trim());
						ideaUrl6.setIdeaWidth(20);
						ideaUrl6.setIdeaHeight(10);
						ideaUrl6.save();
					}
				}
				
				
				if(!"".equals(m_vf_pipurl)&&m_vf_pipurl!=null){
					IdeaUrl ideaUrl5 = new IdeaUrl();
					ideaUrl5.setIdeaId(idea_id);
					ideaUrl5.setSite(1);
					//ideaUrl1.setBt(2);
					ideaUrl5.setBt(2);
					ideaUrl5.setType(2);
					ideaUrl5.setContent(m_vf_pipurl.trim());
					ideaUrl5.setIdeaWidth(0);
					ideaUrl5.setIdeaHeight(0);
					ideaUrl5.save();
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
					ideaUrl.setContent(pc_vb_ideaurl.trim());
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
				ideaUrl.setContent(m_vb_ideaurl.trim());
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
				//m_h5_vb_ideaurl_phone,m_h5_vb_ideaurl_pad
				if (m_vb_impression == 1) {
					if(!"".equals(m_h5_vb_ideaurl_phone)&&m_h5_vb_ideaurl_phone!=null){
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl1.setBt(4);
						ideaUrl1.setType(16);
						ideaUrl1.setContent(m_h5_vb_ideaurl_phone.trim());
						ideaUrl1.setIdeaWidth(20);
						ideaUrl1.setIdeaHeight(10);
						ideaUrl1.save();
					}
					if(!"".equals(m_h5_vb_ideaurl_pad)&&m_h5_vb_ideaurl_pad!=null){
						IdeaUrl ideaUrl2 = new IdeaUrl();
						ideaUrl2.setIdeaId(idea_id);
						ideaUrl2.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl2.setBt(5);
						ideaUrl2.setType(16);
						ideaUrl2.setContent(m_h5_vb_ideaurl_pad.trim());
						ideaUrl2.setIdeaWidth(20);
						ideaUrl2.setIdeaHeight(10);
						ideaUrl2.save();
					}
				}
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
					ideaUrl.setContent(pc_vob_ideaurl.trim());
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
					ideaUrl1.setContent(pc_vob_pipurl.trim());
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
				ideaUrl.setContent(m_mo_ideaurl.trim());
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
				
				if (m_vo_impression == 1) {
					if(!"".equals(m_h5_vo_ideaurl_phone)&&m_h5_vo_ideaurl_phone!=null){
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl1.setBt(4);
						ideaUrl1.setType(16);
						ideaUrl1.setContent(m_h5_vo_ideaurl_phone.trim());
						ideaUrl1.setIdeaWidth(20);
						ideaUrl1.setIdeaHeight(10);
						ideaUrl1.save();
					}
					if(!"".equals(m_h5_vo_ideaurl_pad)&&m_h5_vo_ideaurl_pad!=null){
						IdeaUrl ideaUrl2 = new IdeaUrl();
						ideaUrl2.setIdeaId(idea_id);
						ideaUrl2.setSite(0);
						//ideaUrl1.setBt(2);
						ideaUrl2.setBt(5);
						ideaUrl2.setType(16);
						ideaUrl2.setContent(m_h5_vo_ideaurl_pad.trim());
						ideaUrl2.setIdeaWidth(20);
						ideaUrl2.setIdeaHeight(10);
						ideaUrl2.save();
					}
				}
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
    					ideaUrl.setIdeaWidth(0);
    					ideaUrl.setIdeaHeight(0);
    				}
    				ideaUrl.save();
                }
                
				IdeaUrl ideaUrl2 = new IdeaUrl();
				ideaUrl2.setIdeaId(idea_id);
				ideaUrl2.setSite(1);
				ideaUrl2.setBt(1);
				ideaUrl2.setType(7);
                if(pc_vc_y_ideaurl_img != null&&!"".equals(pc_vc_y_ideaurl_img)){
    				ideaUrl2.setContent(pc_vc_y_ideaurl_img);
    				if(!"".equals(pc_vc_width)||!"".equals(pc_vc_height)){
    					ideaUrl2.setIdeaWidth(Integer.parseInt(pc_vc_width));
    					ideaUrl2.setIdeaHeight(Integer.parseInt(pc_vc_height));
    				}else{
    					URL url = new URL(pc_vc_y_ideaurl_img);
    					URLConnection connection = url.openConnection();
    					connection.setDoOutput(true);
    					int width = 0;
    					int height = 0;
    					if(pc_vc_y_ideaurl_img.endsWith("gif")) {
    						GifImage gifImage = GifDecoder.read(connection.getInputStream());
    						width = gifImage.getWidth();
    						height = gifImage.getHeight();
    					}else {
        					BufferedImage image = ImageIO.read(connection.getInputStream());
        					width = image.getWidth(); // ????????????
        					height = image.getHeight(); // ????????????
    					}
    					
    					ideaUrl2.setIdeaWidth(width);
    					ideaUrl2.setIdeaHeight(height);

    				}
    				ideaUrl2.save();
                }
                
                IdeaUrl ideaUrl3 = new IdeaUrl();
				ideaUrl3.setIdeaId(idea_id);
				ideaUrl3.setSite(1);
				ideaUrl3.setBt(1);
				ideaUrl3.setType(18);
				if(pc_vc_y_ideaurl_h5 != null&&!"".equals(pc_vc_y_ideaurl_h5)){
    				ideaUrl3.setContent(pc_vc_y_ideaurl_h5);
    				if(!"".equals(pc_vc_width)||!"".equals(pc_vc_height)){
    					ideaUrl3.setIdeaWidth(Integer.parseInt(pc_vc_width));
    					ideaUrl3.setIdeaHeight(Integer.parseInt(pc_vc_height));
    				}else{
    					ideaUrl3.setIdeaWidth(0);
    					ideaUrl3.setIdeaHeight(0);
    				}
    				ideaUrl3.save();
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
				ideaUrl.setBt(5);
				ideaUrl.setType(7);
                if(m_vc_pad != null && !"".equals(m_vc_pad)){
    				ideaUrl.setContent(m_vc_pad.trim());
    				ideaUrl.setIdeaWidth(20);
    				ideaUrl.setIdeaHeight(10);
    				ideaUrl.save();
                }

				IdeaUrl ideaUrl1 = new IdeaUrl();
				ideaUrl1.setIdeaId(idea_id);
				ideaUrl1.setSite(0);
				ideaUrl1.setBt(4);
				ideaUrl1.setType(7);
                if(m_vc_phone != null && !"".equals(m_vc_phone)){
    				ideaUrl1.setContent(m_vc_phone.trim());
    				ideaUrl1.setIdeaWidth(20);
    				ideaUrl1.setIdeaHeight(10);
    				ideaUrl1.save();
                }
                
				IdeaUrl ideaUrl2 = new IdeaUrl();
				ideaUrl2.setIdeaId(idea_id);
				ideaUrl2.setSite(0);
				ideaUrl2.setBt(2);
				ideaUrl2.setType(7);

				if(m_vc_openstatus_pageurl != null && !"".equals(m_vc_openstatus_pageurl)){
					ideaUrl2.setContent(m_vc_openstatus_pageurl.trim());
					ideaUrl2.setIdeaWidth(20);
					ideaUrl2.setIdeaHeight(10);
					ideaUrl2.save();
				}

				IdeaUrl ideaUrl3 = new IdeaUrl();
				ideaUrl3.setIdeaId(idea_id);
				ideaUrl3.setSite(0);
				ideaUrl3.setBt(2);
				ideaUrl3.setType(8);
				
				if(m_vc_closestatus_pageurl != null && !"".equals(m_vc_closestatus_pageurl)){
					ideaUrl3.setContent(m_vc_closestatus_pageurl.trim());
					ideaUrl3.setIdeaWidth(20);
					ideaUrl3.setIdeaHeight(10);
					ideaUrl3.save();
				}
				
				IdeaUrl ideaUrl4 = new IdeaUrl();
				ideaUrl4.setIdeaId(idea_id);
				ideaUrl4.setSite(0);
				ideaUrl4.setBt(2);
				ideaUrl4.setType(18);
                if(m_vc_h5 != null && !"".equals(m_vc_h5)){
    				ideaUrl4.setContent(m_vc_h5.trim());
    				ideaUrl4.setIdeaWidth(0);
    				ideaUrl4.setIdeaHeight(0);
    				ideaUrl4.save();
                }
                
				IdeaUrl ideaUrl5 = new IdeaUrl();
				ideaUrl5.setIdeaId(idea_id);
				//ott???site??????0???????????????????????????site=1,??????site=11
				ideaUrl5.setSite(0);
				ideaUrl5.setBt(3);
				ideaUrl5.setType(1);
                if(m_ott_vc != null && !"".equals(m_ott_vc)){
    				ideaUrl5.setContent(m_ott_vc.trim());
    				ideaUrl5.setIdeaWidth(0);
    				ideaUrl5.setIdeaHeight(0);
    				ideaUrl5.save();
                }

			}

			if (ad_type == NEW_ZANTING) {
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(1);
				ideaUrl.setBt(1);
				ideaUrl.setType(5);

				if (pc_vp_y_ideaurl != null && !"".equals(pc_vp_y_ideaurl)) {
					ideaUrl.setContent(pc_vp_y_ideaurl.trim());
					if(!"1".equals(pc_vp_ideacontrol)&&!"".equals(pc_normal_zanting_width)&&!"".equals(pc_normal_zanting_height)){
						ideaUrl.setIdeaWidth(Integer.parseInt(pc_normal_zanting_width));
						ideaUrl.setIdeaHeight(Integer.parseInt(pc_normal_zanting_height));
					}
					ideaUrl.save();
				}				
				
				IdeaUrl ideaUrl4 = new IdeaUrl();
				ideaUrl4.setIdeaId(idea_id);
				ideaUrl4.setSite(1);
				ideaUrl4.setBt(1);
				ideaUrl4.setType(18);

				if (pc_vp_y_ideaurl_h5 != null && !"".equals(pc_vp_y_ideaurl_h5)) {
					ideaUrl4.setContent(pc_vp_y_ideaurl_h5.trim());
					if(!"1".equals(pc_vp_ideacontrol)&&!"".equals(pc_normal_zanting_width)&&!"".equals(pc_normal_zanting_height)){
						ideaUrl4.setIdeaWidth(Integer.parseInt(pc_normal_zanting_width));
						ideaUrl4.setIdeaHeight(Integer.parseInt(pc_normal_zanting_height));
					}
					ideaUrl4.save();
				}	


				IdeaUrl ideaUrl1 = new IdeaUrl();
				ideaUrl1.setIdeaId(idea_id);
				ideaUrl1.setSite(1);
				ideaUrl1.setBt(1);
				ideaUrl1.setType(4);

				if (pc_vp_y_full_ideaurl != null
						&& !"".equals(pc_vp_y_full_ideaurl)) {
					ideaUrl1.setContent(pc_vp_y_full_ideaurl.trim());
					if(!"1".equals(pc_vp_ideacontrol)&&!"".equals(pc_fullscreen_zanting_width)&&!"".equals(pc_fullscreen_zanting_height)){
						ideaUrl1.setIdeaWidth(Integer.parseInt(pc_fullscreen_zanting_width));
						ideaUrl1.setIdeaHeight(Integer.parseInt(pc_fullscreen_zanting_height));
					}
					ideaUrl1.save();
				}
				
				IdeaUrl ideaUrl5 = new IdeaUrl();
				ideaUrl5.setIdeaId(idea_id);
				ideaUrl5.setSite(1);
				ideaUrl5.setBt(1);
				ideaUrl5.setType(31);

				if (pc_vp_y_full_ideaurl_h5 != null && !"".equals(pc_vp_y_full_ideaurl_h5)) {
					ideaUrl5.setContent(pc_vp_y_full_ideaurl_h5.trim());
					if(!"1".equals(pc_vp_ideacontrol)&&!"".equals(pc_normal_zanting_width)&&!"".equals(pc_normal_zanting_height)){
						ideaUrl5.setIdeaWidth(Integer.parseInt(pc_normal_zanting_width));
						ideaUrl5.setIdeaHeight(Integer.parseInt(pc_normal_zanting_height));
					}
					ideaUrl5.save();
				}	
				
				IdeaUrl ideaUrl2 = new IdeaUrl();
				ideaUrl2.setIdeaId(idea_id);
				ideaUrl2.setSite(2);
				ideaUrl2.setBt(1);
				ideaUrl2.setType(5);

				if (pc_vp_t_ideaurl != null && !"".equals(pc_vp_t_ideaurl)) {
					ideaUrl2.setContent(pc_vp_t_ideaurl.trim());
					if(!"1".equals(pc_vp_ideacontrol)&&!"".equals(pc_normal_zanting_width)&&!"".equals(pc_normal_zanting_height)){
						ideaUrl2.setIdeaWidth(Integer.parseInt(pc_normal_zanting_width));
						ideaUrl2.setIdeaHeight(Integer.parseInt(pc_normal_zanting_height));
					}
					ideaUrl2.save();
				}

				IdeaUrl ideaUrl3 = new IdeaUrl();
				ideaUrl3.setIdeaId(idea_id);
				ideaUrl3.setSite(2);
				ideaUrl3.setBt(1);
				ideaUrl3.setType(4);
				if (pc_vp_t_full_ideaurl != null && !"".equals(pc_vp_t_full_ideaurl)) {
					ideaUrl3.setContent(pc_vp_t_full_ideaurl.trim());
					if(!"1".equals(pc_vp_ideacontrol)&&!"".equals(pc_fullscreen_zanting_width)&&!"".equals(pc_fullscreen_zanting_height)){
						ideaUrl3.setIdeaWidth(Integer.parseInt(pc_fullscreen_zanting_width));
						ideaUrl3.setIdeaHeight(Integer.parseInt(pc_fullscreen_zanting_height));
					}
					ideaUrl3.save();
				}
			}
			if (ad_type == MB_ZANTING) {
				if(m_vp_ideaurl != null && !"".equals(m_vp_ideaurl)){
					//m_vp_ideaurl
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);		
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(6);
					if (m_vp_ideaurl != null && !"".equals(m_vp_ideaurl)) {
						ideaUrl.setContent(m_vp_ideaurl.trim());
					}					
					//m_ztsdk,m_sdk
					if(m_ztsdk != 0){
						ideaUrl.setContent("http://static.atm.youku.com/idea/201504/0415/76356/1024768.jpg");
					}
					ideaUrl.save();
				}				
				if(m_vp_ott_ideaurl != null && !"".equals(m_vp_ott_ideaurl)){
					System.out.println("##########" + m_vp_ott_ideaurl + "#############");
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(6);
	                ideaUrl2.setContent(m_vp_ott_ideaurl.trim());
					ideaUrl2.save();
				}			
				if("1".equals(m_vp_is_qr)&&!"".equals(m_vp_vq_url)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(0);					
					ideaUrl1.setType(25);
					ideaUrl1.setContent(m_vp_vq_url.trim());					
					ideaUrl1.save();
				}			

			}
			
			//iku_kaijitu_pc
			if(ad_type == NEW_KAIJITU){
				//m_iku_pc_ideaurl_650,m_iku_pc_ideaurl_720
				if (m_iku_pc_ideaurl_650 != null && !"".equals(m_iku_pc_ideaurl_650)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(9);
					ideaUrl.setContent(m_iku_pc_ideaurl_650.trim());
					ideaUrl.setIdeaWidth(1024);
					ideaUrl.setIdeaHeight(650);
					ideaUrl.save();
				}
				
				if (m_iku_pc_ideaurl_720 != null && !"".equals(m_iku_pc_ideaurl_720)) {
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(9);
					ideaUrl2.setContent(m_iku_pc_ideaurl_720.trim());
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
					System.out.println("pc_vf_impression_pc is: " + pc_vf_impression_pc);
					String pc_tp_ideaurl_encode = URLEncoder.encode(pc_tp_ideaurl,"utf-8");
					if("1".equals(loader_type_tp)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/INT_VPAIDAdRenderer.swf?url=" + pc_tp_ideaurl);
					}else if("2".equals(loader_type_tp)){
						ideaUrl.setContent("http://static.atm.youku.com/ssh/VPAIDAdRenderer.swf?url=" + pc_tp_ideaurl);
					}else{
						ideaUrl.setContent("http://static.atm.youku.com/idea/iab/vpaid/V2_INT_VPAIDAdRenderer.swf?url=" + pc_tp_ideaurl_encode);
					}
				} else {
					ideaUrl.setContent(pc_tp_ideaurl.trim());
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
				ideaUrl.setBt(0);
				ideaUrl.setType(1);
				//to do to set content idea_url
				ideaUrl.setContent(m_vtp_ideaurl.trim());
				ideaUrl.setIdeaWidth(20);
				ideaUrl.setIdeaHeight(10);
				ideaUrl.save();
			}

			if (ad_type == MB_KAIJITU) {
				if (m_mi_ipad_ideaurl_768 != null && !"".equals(m_mi_ipad_ideaurl_768)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(9);
					ideaUrl.setContent(m_mi_ipad_ideaurl_768.trim());
					ideaUrl.setIdeaWidth(1024);
					ideaUrl.setIdeaHeight(768);
					ideaUrl.setText2(m_mi_atv_text1);
					ideaUrl.setOs("0");
					ideaUrl.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl.save();
				}

				if (m_mi_ipad_ideaurl_1004 != null && !"".equals(m_mi_ipad_ideaurl_1004)) {
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(0);
					ideaUrl1.setType(9);
					ideaUrl1.setContent(m_mi_ipad_ideaurl_1004.trim());
					ideaUrl1.setIdeaWidth(768);
					ideaUrl1.setIdeaHeight(1004);
					ideaUrl1.setText2(m_mi_atv_text1);
					ideaUrl1.setOs("0");
					ideaUrl1.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl1.save();
				}

				if (m_mi_iphone_ideaurl_940 != null && !"".equals(m_mi_iphone_ideaurl_940)) {
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(9);
					ideaUrl2.setContent(m_mi_iphone_ideaurl_940.trim());
					ideaUrl2.setIdeaWidth(640);
					ideaUrl2.setIdeaHeight(960);
					ideaUrl2.setText2(m_mi_atv_text1);
					ideaUrl2.setOs("0");
					ideaUrl2.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl2.save();
				}

				if (m_mi_iphone_ideaurl_1116 != null && !"".equals(m_mi_iphone_ideaurl_1116)) {
					IdeaUrl ideaUrl3 = new IdeaUrl();
					ideaUrl3.setIdeaId(idea_id);
					ideaUrl3.setSite(0);
					ideaUrl3.setBt(0);
					ideaUrl3.setType(9);
					ideaUrl3.setContent(m_mi_iphone_ideaurl_1116.trim());
					ideaUrl3.setIdeaWidth(640);
					ideaUrl3.setIdeaHeight(1136);
					ideaUrl3.setText2(m_mi_atv_text1);
					ideaUrl3.setOs("0");
					ideaUrl3.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl3.save();
				}
				if (m_mi_iphone_ideaurl_1334 != null && !"".equals(m_mi_iphone_ideaurl_1334)) {
					IdeaUrl ideaUrl4 = new IdeaUrl();
					ideaUrl4.setIdeaId(idea_id);
					ideaUrl4.setSite(0);
					ideaUrl4.setBt(0);
					ideaUrl4.setType(9);
					ideaUrl4.setContent(m_mi_iphone_ideaurl_1334.trim());
					ideaUrl4.setIdeaWidth(750);
					ideaUrl4.setIdeaHeight(1134);
					ideaUrl4.setText2(m_mi_atv_text1);
					ideaUrl4.setOs("0");
					ideaUrl4.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl4.save();
				}

				if (m_mi_iphone_ideaurl_1920 != null && !"".equals(m_mi_iphone_ideaurl_1920)) {
					IdeaUrl ideaUrl5 = new IdeaUrl();
					ideaUrl5.setIdeaId(idea_id);
					ideaUrl5.setSite(0);
					ideaUrl5.setBt(0);
					ideaUrl5.setType(9);
					ideaUrl5.setContent(m_mi_iphone_ideaurl_1920.trim());
					ideaUrl5.setIdeaWidth(828);
					ideaUrl5.setIdeaHeight(1472);
					ideaUrl5.setText2(m_mi_atv_text1);
					ideaUrl5.setOs("0");
					ideaUrl5.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl5.save();
				}
				
				if (m_mi_iphone_ideaurl_xiami != null && !"".equals(m_mi_iphone_ideaurl_xiami)) {
					IdeaUrl ideaUrl15 = new IdeaUrl();
					ideaUrl15.setIdeaId(idea_id);
					ideaUrl15.setSite(13);
					ideaUrl15.setBt(2);
					ideaUrl15.setType(9);
					ideaUrl15.setContent(m_mi_iphone_ideaurl_xiami.trim());
					ideaUrl15.setIdeaWidth(1080);
					ideaUrl15.setIdeaHeight(1920);
					ideaUrl15.setText2(m_mi_atv_text1);
					ideaUrl15.setOs("0");
					ideaUrl15.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl15.save();
				}
				
				//m_mi_aphone_ideaurl_xiami
					if (m_mi_aphone_ideaurl_xiami != null && !"".equals(m_mi_aphone_ideaurl_xiami)) {
					IdeaUrl ideaUrl16 = new IdeaUrl();
					ideaUrl16.setIdeaId(idea_id);
					ideaUrl16.setSite(13);
					ideaUrl16.setBt(2);
					ideaUrl16.setType(9);
					ideaUrl16.setContent(m_mi_aphone_ideaurl_xiami.trim());
					ideaUrl16.setIdeaWidth(720);
					ideaUrl16.setIdeaHeight(1280);
					ideaUrl16.setText2(m_mi_atv_text1);
					ideaUrl16.setOs("1");
					ideaUrl16.setSkipTx(skip_button_text);//?????????????????????
					ideaUrl16.save();
				}

				if (m_mi_apad_ideaurl_800 != null && !"".equals(m_mi_apad_ideaurl_800)) {
					IdeaUrl ideaUrl6 = new IdeaUrl();
					ideaUrl6.setIdeaId(idea_id);
					ideaUrl6.setSite(0);
					ideaUrl6.setBt(0);
					ideaUrl6.setType(9);
					ideaUrl6.setContent(m_mi_apad_ideaurl_800.trim());
					ideaUrl6.setIdeaWidth(800);
					ideaUrl6.setIdeaHeight(1280);
					ideaUrl6.setText2(m_mi_atv_text1);
					ideaUrl6.setOs("1");
					ideaUrl6.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl6.save();
				}

				if (m_mi_apad_ideaurl_600 != null && !"".equals(m_mi_apad_ideaurl_600)) {
					IdeaUrl ideaUrl7 = new IdeaUrl();
					ideaUrl7.setIdeaId(idea_id);
					ideaUrl7.setSite(0);
					ideaUrl7.setBt(0);
					ideaUrl7.setType(9);
					ideaUrl7.setContent(m_mi_apad_ideaurl_600.trim());
					ideaUrl7.setIdeaWidth(600);
					ideaUrl7.setIdeaHeight(1024);
					ideaUrl7.setText2(m_mi_atv_text1);
					ideaUrl7.setOs("1");
					ideaUrl7.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl7.save();
				}

				if (m_mi_aphone_ideaurl_1280 != null && !"".equals(m_mi_aphone_ideaurl_1280)) {
					IdeaUrl ideaUrl8 = new IdeaUrl();
					ideaUrl8.setIdeaId(idea_id);
					ideaUrl8.setSite(0);
					ideaUrl8.setBt(0);
					ideaUrl8.setType(9);
					ideaUrl8.setContent(m_mi_aphone_ideaurl_1280.trim());
					ideaUrl8.setIdeaWidth(720);
					ideaUrl8.setIdeaHeight(1280);
					ideaUrl8.setText2(m_mi_atv_text1);
					ideaUrl8.setOs("1");
					ideaUrl8.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl8.save();
				}

				if (m_mi_aphone_ideaurl_800 != null && !"".equals(m_mi_aphone_ideaurl_800)) {
					IdeaUrl ideaUrl9 = new IdeaUrl();
					ideaUrl9.setIdeaId(idea_id);
					ideaUrl9.setSite(0);
					ideaUrl9.setBt(0);
					ideaUrl9.setType(9);
					ideaUrl9.setContent(m_mi_aphone_ideaurl_800.trim());
					ideaUrl9.setIdeaWidth(480);
					ideaUrl9.setIdeaHeight(800);
					ideaUrl9.setText2(m_mi_atv_text1);
					ideaUrl9.setOs("1");
					ideaUrl9.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl9.save();
				}

				if (m_mi_atv_ideaurl_720 != null && !"".equals(m_mi_atv_ideaurl_720)) {
					IdeaUrl ideaUrl10 = new IdeaUrl();
					ideaUrl10.setIdeaId(idea_id);
					ideaUrl10.setSite(0);
					ideaUrl10.setBt(3);
					ideaUrl10.setType(9);
					ideaUrl10.setContent(m_mi_atv_ideaurl_720.trim());
					ideaUrl10.setIdeaWidth(1280);
					ideaUrl10.setIdeaHeight(720);
					//ideaUrl10.setIdeaWidth(1024);
					//ideaUrl10.setIdeaHeight(768);
					ideaUrl10.setText2(m_mi_atv_text1);
					//os???null,?????????1--????????????????????????????????????0:IOS???1:ADR???2:WIN???uc??????????????????uc?????????0???1
					ideaUrl10.setOs("");
					ideaUrl10.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl10.save();
				}				
				
				if (m_mi_apad_ideaurl_768 != null && !"".equals(m_mi_apad_ideaurl_768)) {
					IdeaUrl ideaUrl11 = new IdeaUrl();
					ideaUrl11.setIdeaId(idea_id);
					ideaUrl11.setSite(0);
					ideaUrl11.setBt(0);
					ideaUrl11.setType(9);
					ideaUrl11.setContent(m_mi_apad_ideaurl_768.trim());
					ideaUrl11.setIdeaWidth(768);
					ideaUrl11.setIdeaHeight(1024);
					ideaUrl11.setText2(m_mi_atv_text1);
					ideaUrl11.setOs("1");
					ideaUrl11.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl11.save();
				}
                //????????????
				if (co_banner_idea != null && !"".equals(co_banner_idea)) {
					IdeaUrl ideaUrl12 = new IdeaUrl();
					ideaUrl12.setIdeaId(idea_id);
					ideaUrl12.setSite(0);
					ideaUrl12.setBt(0);
					//todo list type
					ideaUrl12.setType(28);
					ideaUrl12.setContent(co_banner_idea.trim());
					ideaUrl12.setIdeaWidth(-1);
					ideaUrl12.setIdeaHeight(-1);
					ideaUrl12.setText2(m_mi_atv_text1);
					ideaUrl12.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl12.save();
				}
				
				
				//MB_KAIJITU_default_5s
					if (m_mi_ipad_landscape_idea != null && !"".equals(m_mi_ipad_landscape_idea)) {
						String m_mi_ipad_landscape_idea_arrays[] = m_mi_ipad_landscape_idea.split("\r?\n");
						
						for(int i = 0; i < m_mi_ipad_landscape_idea_arrays.length; i++) {
							String widthAndHeight = EasyCastUtil.getUrlInfo("dimension", m_mi_ipad_landscape_idea_arrays[i]);
							String[] dimension = widthAndHeight.split(",");
							int width = Integer.parseInt(dimension[0]);
							int height = Integer.parseInt(dimension[1]);
							IdeaUrl ideaUrl13 = new IdeaUrl();
							ideaUrl13.setIdeaId(idea_id);
							ideaUrl13.setSite(0);
							ideaUrl13.setBt(0);
							//todo list type
							ideaUrl13.setType(29);
							ideaUrl13.setContent(m_mi_ipad_landscape_idea_arrays[i].trim());
												
							ideaUrl13.setIdeaWidth(width);
							ideaUrl13.setIdeaHeight(height);
							ideaUrl13.setText2(m_mi_atv_text1);
							ideaUrl13.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
							ideaUrl13.setShowtime(EasyCastUtil.getVideoLength(m_mi_ipad_landscape_idea_arrays[i]));
							
							ideaUrl13.save();
						}

				}
					if (m_mi_iphone_portrait_idea != null && !"".equals(m_mi_iphone_portrait_idea)) {
						String m_mi_iphone_portrait_idea_arrays[] = m_mi_iphone_portrait_idea.split("\r?\n");
						for(int i = 0; i < m_mi_iphone_portrait_idea_arrays.length; i++) {
							String widthAndHeight = EasyCastUtil.getUrlInfo("dimension", m_mi_iphone_portrait_idea_arrays[i]);
							String[] dimension = widthAndHeight.split(",");
							int width = Integer.parseInt(dimension[0]);
							int height = Integer.parseInt(dimension[1]);
							IdeaUrl ideaUrl14 = new IdeaUrl();
							ideaUrl14.setIdeaId(idea_id);
							ideaUrl14.setSite(0);
							ideaUrl14.setBt(0);
							//todo list type
							ideaUrl14.setType(30);
							ideaUrl14.setContent(m_mi_iphone_portrait_idea_arrays[i].trim());
							ideaUrl14.setIdeaWidth(width);
							ideaUrl14.setIdeaHeight(height);
							ideaUrl14.setText2(m_mi_atv_text1);
							ideaUrl14.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
							ideaUrl14.setShowtime(EasyCastUtil.getVideoLength(m_mi_iphone_portrait_idea_arrays[i]));
							ideaUrl14.save();
						}

				}
					
					if (m_mi_iphonex_ideaurl_1125 != null && !"".equals(m_mi_iphonex_ideaurl_1125)) {
					IdeaUrl ideaUrl15 = new IdeaUrl();
					ideaUrl15.setIdeaId(idea_id);
					ideaUrl15.setSite(0);
					ideaUrl15.setBt(2);
					ideaUrl15.setType(9);
					ideaUrl15.setContent(m_mi_iphonex_ideaurl_1125.trim());
					ideaUrl15.setIdeaWidth(1125);
					ideaUrl15.setIdeaHeight(2436);
					ideaUrl15.setText2(m_mi_atv_text1);
					ideaUrl15.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
					ideaUrl15.setIphonex(1);
					ideaUrl15.save();
				}
					
					if (m_mi_iphonex_video_idea != null && !"".equals(m_mi_iphonex_video_idea)) {
						String m_mi_iphonex_video_idea_arrays[] = m_mi_iphonex_video_idea.split("\r?\n");
						for(int i = 0; i < m_mi_iphonex_video_idea_arrays.length; i++) {
							String widthAndHeight = EasyCastUtil.getUrlInfo("dimension", m_mi_iphonex_video_idea_arrays[i]);
							String[] dimension = widthAndHeight.split(",");
							int width = Integer.parseInt(dimension[0]);
							int height = Integer.parseInt(dimension[1]);
							IdeaUrl ideaUrl16 = new IdeaUrl();
							ideaUrl16.setIdeaId(idea_id);
							ideaUrl16.setSite(0);
							ideaUrl16.setBt(2);
							ideaUrl16.setType(30);
							ideaUrl16.setContent(m_mi_iphonex_video_idea_arrays[i].trim());
							ideaUrl16.setIdeaWidth(width);
							ideaUrl16.setIdeaHeight(height);
							ideaUrl16.setText2(m_mi_atv_text1);
							ideaUrl16.setSkipTx(skip_button_text);//?????????????????????,youku?????????????????????
							ideaUrl16.setIphonex(1);
							ideaUrl16.setShowtime(EasyCastUtil.getVideoLength(m_mi_iphonex_video_idea_arrays[i]));
							ideaUrl16.save();
						}
				}
			}

			if (ad_type == MB_QUANPING) {
				if (m_mqp_ipad_ideaurl_748 != null && !"".equals(m_mqp_ipad_ideaurl_748)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(12);
					ideaUrl.setContent(m_mqp_ipad_ideaurl_748.trim());
					ideaUrl.save();
				}

				if (m_mqp_iphone_ideaurl_480 != null && !"".equals(m_mqp_iphone_ideaurl_480)) {
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(0);
					ideaUrl1.setType(13);
					ideaUrl1.setContent(m_mqp_iphone_ideaurl_480.trim());
					ideaUrl1.save();
				}

				if (m_mqp_androidpad_ideaurl_720 != null && !"".equals(m_mqp_androidpad_ideaurl_720)) {
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(14);
					ideaUrl2.setContent(m_mqp_androidpad_ideaurl_720.trim());
					ideaUrl2.save();
				}

				if (m_mqp_androidphone_ideaurl_480 != null && !"".equals(m_mqp_androidphone_ideaurl_480)) {
					IdeaUrl ideaUrl3 = new IdeaUrl();
					ideaUrl3.setIdeaId(idea_id);
					ideaUrl3.setSite(0);
					ideaUrl3.setBt(0);
					ideaUrl3.setType(15);
					ideaUrl3.setContent(m_mqp_androidphone_ideaurl_480.trim());
					ideaUrl3.save();
				}
				
				//m_ztsdk,m_sdk
				if(m_sdk != 0){
					//ideaUrl.setContent("http://static.atm.youku.com/idea/201504/0415/76356/1024768.jpg");
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(12);
					ideaUrl.setContent("http://static.atm.youku.com/idea/201504/0415/76356/1024768.jpg");
					ideaUrl.save();
					
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(0);
					ideaUrl1.setType(13);
					ideaUrl1.setContent("http://static.atm.youku.com/idea/201504/0415/76356/1024768.jpg");
					ideaUrl1.save();
					
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(14);
					ideaUrl2.setContent("http://static.atm.youku.com/idea/201504/0415/76356/1024768.jpg");
					ideaUrl2.save();
					
					IdeaUrl ideaUrl3 = new IdeaUrl();
					ideaUrl3.setIdeaId(idea_id);
					ideaUrl3.setSite(0);
					ideaUrl3.setBt(0);
					ideaUrl3.setType(15);
					ideaUrl3.setContent("http://static.atm.youku.com/idea/201504/0415/76356/1024768.jpg");
					ideaUrl3.save();
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
			//FEED ??????
			if(ad_type==MB_FEED){
				if (m_feed_video_url != null && !"".equals(m_feed_video_url)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(1);
					ideaUrl.setContent(m_feed_video_url);
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
				
				if (m_feed_logo_url != null && !"".equals(m_feed_logo_url)) {
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(0);
					ideaUrl1.setType(21);
					ideaUrl1.setContent(m_feed_logo_url);
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.save();
				}
				
				if (m_feed_customer != null && !"".equals(m_feed_customer)) {
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(0);
					ideaUrl2.setType(22);
					ideaUrl2.setContent(m_feed_customer);
					ideaUrl2.setIdeaWidth(0);
					ideaUrl2.setIdeaHeight(0);
					ideaUrl2.save();
				}
						
				if (m_feed_video_thumbnail != null && !"".equals(m_feed_video_thumbnail)) {
					IdeaUrl ideaUrl4 = new IdeaUrl();
					ideaUrl4.setIdeaId(idea_id);
					ideaUrl4.setSite(0);
					ideaUrl4.setBt(0);
					ideaUrl4.setType(23);
					ideaUrl4.setContent(m_feed_video_thumbnail);
					ideaUrl4.setIdeaWidth(0);
					ideaUrl4.setIdeaHeight(0);
					ideaUrl4.save();
				}
				
				if (m_feed_buttontext != null && !"".equals(m_feed_buttontext)) {
					IdeaUrl ideaUrl3 = new IdeaUrl();
					ideaUrl3.setIdeaId(idea_id);
					ideaUrl3.setSite(0);
					ideaUrl3.setBt(0);
					ideaUrl3.setType(24);
					ideaUrl3.setContent(m_feed_buttontext);
					ideaUrl3.setIdeaWidth(0);
					ideaUrl3.setIdeaHeight(0);
					ideaUrl3.save();
				}
				
			}	
			//?????????????????????????????????
			if(ad_type == YOUKU_FEEDAD){
				if("1".equals(feedAd_type_overall)) {
					if (m_feedAd_video_thumbnail != null && !"".equals(m_feedAd_video_thumbnail)) {
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(0);
						ideaUrl.setBt(0);
						ideaUrl.setType(23);
						ideaUrl.setContent(m_feedAd_video_thumbnail);
						ideaUrl.setIdeaWidth(0);
						ideaUrl.setIdeaHeight(0);
						ideaUrl.save();
					}	
					if (m_feedAd_video_url != null && !"".equals(m_feedAd_video_url)) {
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(0);
						ideaUrl1.setBt(0);
						ideaUrl1.setType(1);
						ideaUrl1.setContent(m_feedAd_video_url);
						ideaUrl1.setIdeaWidth(0);
						ideaUrl1.setIdeaHeight(0);
						ideaUrl1.save();
					}	
					if (m_feedAd_png_url_750_350 != null && !"".equals(m_feedAd_png_url_750_350)) {
						IdeaUrl ideaUrl2 = new IdeaUrl();
						ideaUrl2.setIdeaId(idea_id);
						ideaUrl2.setSite(0);
						ideaUrl2.setBt(0);
						ideaUrl2.setType(17);
						ideaUrl2.setContent(m_feedAd_png_url_750_350);
						ideaUrl2.setIdeaWidth(750);
						ideaUrl2.setIdeaHeight(350);
						ideaUrl2.save();
					}
					
					if (m_feedAd_png_url_750_280 != null && !"".equals(m_feedAd_png_url_750_280)) {
						IdeaUrl ideaUrl5 = new IdeaUrl();
						ideaUrl5.setIdeaId(idea_id);
						ideaUrl5.setSite(0);
						ideaUrl5.setBt(0);
						ideaUrl5.setType(17);
						ideaUrl5.setContent(m_feedAd_png_url_750_280);
						ideaUrl5.setIdeaWidth(750);
						ideaUrl5.setIdeaHeight(280);
						ideaUrl5.save();
					}
					
					if (m_feedAd_prompt != null && !"".equals(m_feedAd_prompt)) {
						IdeaUrl ideaUrl4 = new IdeaUrl();
						ideaUrl4.setIdeaId(idea_id);
						ideaUrl4.setSite(0);
						ideaUrl4.setBt(0);
						ideaUrl4.setType(24);
						ideaUrl4.setContent(m_feedAd_prompt);
						ideaUrl4.setIdeaWidth(0);
						ideaUrl4.setIdeaHeight(0);
						ideaUrl4.save();
					}		
					
					if (m_feedAd_brandlogo != null && !"".equals(m_feedAd_brandlogo)) {
						IdeaUrl ideaUrl5 = new IdeaUrl();
						ideaUrl5.setIdeaId(idea_id);
						ideaUrl5.setSite(0);
						ideaUrl5.setBt(0);
						ideaUrl5.setType(21);
						ideaUrl5.setContent(m_feedAd_brandlogo);
						ideaUrl5.setIdeaWidth(195);
						ideaUrl5.setIdeaHeight(35);
						ideaUrl5.save();
					}	
				}else {
					if (m_feedAd_png_url_spotlight != null && !"".equals(m_feedAd_png_url_spotlight)) {
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(0);
						ideaUrl.setBt(0);
						ideaUrl.setType(1);
						ideaUrl.setContent(m_feedAd_png_url_spotlight);
						
    					URL url = new URL(m_feedAd_png_url_spotlight);
    					URLConnection connection = url.openConnection();
    					connection.setDoOutput(true);
    					BufferedImage image = ImageIO.read(connection.getInputStream());
    					int srcWidth = image.getWidth(); // ????????????
    					int srcHeight = image.getHeight(); // ????????????
						
						ideaUrl.setIdeaWidth(srcWidth);
						ideaUrl.setIdeaHeight(srcHeight);
						ideaUrl.save();
					}	
					if (m_feedAd_addescript_spotlight != null && !"".equals(m_feedAd_addescript_spotlight)) {
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(0);
						ideaUrl1.setBt(0);
						ideaUrl1.setType(22);
						ideaUrl1.setContent(m_feedAd_addescript_spotlight);
						ideaUrl1.setIdeaWidth(0);
						ideaUrl1.setIdeaHeight(0);
						ideaUrl1.save();
					}	
					if (m_feedAd_prompt_spotlight != null && !"".equals(m_feedAd_prompt_spotlight)) {
						IdeaUrl ideaUrl2 = new IdeaUrl();
						ideaUrl2.setIdeaId(idea_id);
						ideaUrl2.setSite(0);
						ideaUrl2.setBt(0);
						ideaUrl2.setType(24);
						ideaUrl2.setContent(m_feedAd_prompt_spotlight);
						ideaUrl2.setIdeaWidth(0);
						ideaUrl2.setIdeaHeight(0);
						ideaUrl2.save();
					}
					
					if (m_feedAd_adname_spotlight != null && !"".equals(m_feedAd_adname_spotlight)) {
						IdeaUrl ideaUrl5 = new IdeaUrl();
						ideaUrl5.setIdeaId(idea_id);
						ideaUrl5.setSite(0);
						ideaUrl5.setBt(0);
						ideaUrl5.setType(41);
						ideaUrl5.setContent(m_feedAd_adname_spotlight);
						ideaUrl5.setIdeaWidth(0);
						ideaUrl5.setIdeaHeight(0);
						ideaUrl5.save();
					}
					
					if (m_feedAd_brandlogo_spotlight != null && !"".equals(m_feedAd_brandlogo_spotlight)) {
						IdeaUrl ideaUrl4 = new IdeaUrl();
						ideaUrl4.setIdeaId(idea_id);
						ideaUrl4.setSite(0);
						ideaUrl4.setBt(0);
						ideaUrl4.setType(21);
						ideaUrl4.setContent(m_feedAd_brandlogo_spotlight);
						ideaUrl4.setIdeaWidth(48);
						ideaUrl4.setIdeaHeight(48);
						ideaUrl4.save();
					}
					
					if (m_feedAd_png_url_750_350 != null && !"".equals(m_feedAd_png_url_750_350)) {
						IdeaUrl ideaUrl5 = new IdeaUrl();
						ideaUrl5.setIdeaId(idea_id);
						ideaUrl5.setSite(0);
						ideaUrl5.setBt(0);
						ideaUrl5.setType(1);
						ideaUrl5.setContent(m_feedAd_png_url_750_350);
						ideaUrl5.setIdeaWidth(750);
						ideaUrl5.setIdeaHeight(350);
						ideaUrl5.save();
					}	
					
					if (m_feedAd_video_url_spotlight != null && !"".equals(m_feedAd_video_url_spotlight)) {
						IdeaUrl ideaUrl6 = new IdeaUrl();
						ideaUrl6.setIdeaId(idea_id);
						ideaUrl6.setSite(0);
						ideaUrl6.setBt(0);
						ideaUrl6.setType(1);
						ideaUrl6.setContent(m_feedAd_video_url_spotlight);
						ideaUrl6.setIdeaWidth(750);
						ideaUrl6.setIdeaHeight(420);
						ideaUrl6.save();
					}
					
					if (m_feedAd_thumbnail_url_spotlight != null && !"".equals(m_feedAd_thumbnail_url_spotlight)) {
						IdeaUrl ideaUrl7 = new IdeaUrl();
						ideaUrl7.setIdeaId(idea_id);
						ideaUrl7.setSite(0);
						ideaUrl7.setBt(0);
						ideaUrl7.setType(23);
						ideaUrl7.setContent(m_feedAd_thumbnail_url_spotlight);
						
    					URL url = new URL(m_feedAd_thumbnail_url_spotlight);
    					URLConnection connection = url.openConnection();
    					connection.setDoOutput(true);
    					BufferedImage image = ImageIO.read(connection.getInputStream());
    					int srcWidth = image.getWidth(); // ????????????
    					int srcHeight = image.getHeight(); // ????????????
						
						ideaUrl7.setIdeaWidth(srcWidth);
						ideaUrl7.setIdeaHeight(srcHeight);
						ideaUrl7.save();
					}
					
				}
				
			}		
			if(ad_type == m_homepage_banner_web){
				if (html_video_banner_ads_url != null && !"".equals(html_video_banner_ads_url)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(1);
					ideaUrl.setBt(0);
					ideaUrl.setType(11);
					ideaUrl.setContent(html_video_banner_ads_url);
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
			}		
			if(ad_type==MB_APPSEARCHBANNER){
				if(app_search_banner_type.equals("1")){
					if (app_search_banner_youkupip_url != null && !"".equals(app_search_banner_youkupip_url)) {						
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
//					if(app_search_banner_tudoupip_url != null && !"".equals(app_search_banner_tudoupip_url)){
//						IdeaUrl ideaUrl1 = new IdeaUrl();
//						ideaUrl1.setIdeaId(idea_id);
//						ideaUrl1.setSite(2);
//						ideaUrl1.setBt(0);
//						ideaUrl1.setType(11);
//						//ideaUrl.setContent(newJs+template);
//						ideaUrl1.setContent(app_search_banner_tudoupip_url);
//						ideaUrl1.setIdeaWidth(0);
//						ideaUrl1.setIdeaHeight(0);
//						ideaUrl1.save();
//					}		
				}else{
				}		        
			}	
		//idea??????????????????????????????jpg???h5
			if(ad_type==MB_APP_HOMEPAGE){
				if(app_homepage_type.equals("1")){
					if (app_homepage_url != null && !"".equals(app_homepage_url)) {						
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(13);
						ideaUrl.setBt(2);
						if(app_homepage_url.contains("v.youku.com/v_show/id_")){
							//?????????????????????http://v.youku.com/v_show/id_XNDI2MTg5MzM2.html
							ideaUrl.setType(1);
						}else{
							//???????????????h5?????????type??????11
							ideaUrl.setType(9);
						}					
						//ideaUrl.setContent(newJs+template);
						ideaUrl.setContent(app_homepage_url);
						ideaUrl.setIdeaWidth(0);
						ideaUrl.setIdeaHeight(0);
						ideaUrl.save();
					}					
				}else{
				}		        			
			}			
			if(ad_type==MB_APP_PLAYING_BANNER){
				if(app_playing_banner_type.equals("1")){
					if (app_playing_banner_url != null && !"".equals(app_playing_banner_url)) {		
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(0);
						ideaUrl.setBt(0);
						ideaUrl.setType(17);
						//ideaUrl.setContent(newJs+template);
						ideaUrl.setContent(app_playing_banner_url);
						
    					URL url = new URL(app_playing_banner_url);
    					URLConnection connection = url.openConnection();
    					connection.setDoOutput(true);
    					BufferedImage image = ImageIO.read(connection.getInputStream());
    					int srcWidth = image.getWidth(); // ????????????
    					int srcHeight = image.getHeight(); // ????????????
						
						ideaUrl.setIdeaWidth(srcWidth);
						ideaUrl.setIdeaHeight(srcHeight);
						ideaUrl.save();
					}	
				}else{
				}	
			}
			//ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541
			//vhtml_m_playing_page_url
			if(ad_type == m_playing_youku_phone_web_1425020640 || ad_type == m_playing_youku_ipad_web_1427883541){
				if(vhtml_m_playing_page_url != null && !"".equals(vhtml_m_playing_page_url)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(1);
					ideaUrl.setBt(0);
					ideaUrl.setType(11);
					ideaUrl.setContent(vhtml_m_playing_page_url);
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
			}
			if(ad_type == promoted_video_ads_1430192600 || ad_type == promoted_video_ads_1430192617){
				if(vhtml_yt_promoted_video_ads_url != null && !"".equals(vhtml_yt_promoted_video_ads_url)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(1);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(1);
					//ideaUrl.setContent(newJs+template);
					ideaUrl1.setContent(vhtml_yt_promoted_video_ads_url);
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.save();
				}
			}
			if(ad_type == NEW_BUYINGSEEING){
				if(pc_vf_buyingbyseeing_ideaurl_flash != null && !"".equals(pc_vf_buyingbyseeing_ideaurl_flash)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(1);
					ideaUrl.setType(1);
					ideaUrl.setContent(pc_vf_buyingbyseeing_ideaurl_flash);
					ideaUrl.setIdeaWidth(20);
					ideaUrl.setIdeaHeight(10);
					ideaUrl.save();
				}
			}		
			if(ad_type == NEW_BUYINGSEEING){
				if(pc_vf_buyingbyseeing_ideaurl_h5 != null && !"".equals(pc_vf_buyingbyseeing_ideaurl_h5)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(18);
					ideaUrl1.setContent(pc_vf_buyingbyseeing_ideaurl_h5);
					ideaUrl1.setIdeaWidth(20);
					ideaUrl1.setIdeaHeight(10);
					ideaUrl1.save();
				}
				
				if(pc_vf_buyingbyseeing_ideaurl_png != null && !"".equals(pc_vf_buyingbyseeing_ideaurl_png)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(7);
					ideaUrl1.setContent(pc_vf_buyingbyseeing_ideaurl_png);
					ideaUrl1.setIdeaWidth(310);
					ideaUrl1.setIdeaHeight(110);
					ideaUrl1.save();
				}
			}
			//ad_type == MB_scenario
			if(ad_type == MB_scenario){
				if(mb_vf_buyingbyseeing_ideaurl != null && !"".equals(mb_vf_buyingbyseeing_ideaurl)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(2);
					//1:uc???????????????1,uc??????,uc??????,UC????????????????????????????????????????????????????????????????????????????????????swf??????????????????????????????2:PC????????????banner?????????3:JS???????????????4:?????????????????????5:?????????????????????6:?????????????????????7:?????????8:??????????????????9:uc??????????????????????????????????????????????????????????????????????????????????????????????????????????????????banner???10:????????????(????????????)???11:???????????????????????????12:????????????ipad app???13:????????????iphone app???14:????????????Android pad app???15:????????????Android phone app???16????????????????????????h5???????????????17?????????app?????????banner???????????? ????????????????????????-1??????18:H5?????????19?????????????????????????????????????????????21: ??????????????????logo(url)???22: ???????????????????????????????????????uc????????????????????????23: ???????????????????????????(url)???uc???????????????2,uc???????????????????????????24: ?????????????????????????????????uc????????????????????????25????????????logo??????(url),26:app??????apk?????????icon, 27:app??????apk??????????????????28??????????????????????????????????????????uc???????????????3???uc?????????????????????29??????????????????????????????(??????ipad)???30??????????????????????????????(??????phone),31:H5????????????
					//todo check
					if(mb_vf_buyingbyseeing_ideaurl.endsWith(".html")) {
						ideaUrl.setType(18);
					}else {
						ideaUrl.setType(9);
					}
					ideaUrl.setContent(mb_vf_buyingbyseeing_ideaurl);
					ideaUrl.setIdeaWidth(20);
					ideaUrl.setIdeaHeight(10);
					ideaUrl.save();
				}
				if(mb_vf_ott_buyingbyseeing_ideaurl != null && !"".equals(mb_vf_ott_buyingbyseeing_ideaurl)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(3);
					//1:uc???????????????1,uc??????,uc??????,UC????????????????????????????????????????????????????????????????????????????????????swf??????????????????????????????2:PC????????????banner?????????3:JS???????????????4:?????????????????????5:?????????????????????6:?????????????????????7:?????????8:??????????????????9:uc??????????????????????????????????????????????????????????????????????????????????????????????????????????????????banner???10:????????????(????????????)???11:???????????????????????????12:????????????ipad app???13:????????????iphone app???14:????????????Android pad app???15:????????????Android phone app???16????????????????????????h5???????????????17?????????app?????????banner???????????? ????????????????????????-1??????18:H5?????????19?????????????????????????????????????????????21: ??????????????????logo(url)???22: ???????????????????????????????????????uc????????????????????????23: ???????????????????????????(url)???uc???????????????2,uc???????????????????????????24: ?????????????????????????????????uc????????????????????????25????????????logo??????(url),26:app??????apk?????????icon, 27:app??????apk??????????????????28??????????????????????????????????????????uc???????????????3???uc?????????????????????29??????????????????????????????(??????ipad)???30??????????????????????????????(??????phone),31:H5????????????
					//todo check
					ideaUrl1.setType(1);
					ideaUrl1.setContent(mb_vf_ott_buyingbyseeing_ideaurl);
					ideaUrl1.setIdeaWidth(20);
					ideaUrl1.setIdeaHeight(10);
					ideaUrl1.save();
				}
			}
			if(ad_type == NEW_JUCHANGBIAOBAN){
				if(pc_biaoban_y_ideaurl != null && !"".equals(pc_biaoban_y_ideaurl)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(1);
					ideaUrl.setType(1);
					ideaUrl.setContent(pc_biaoban_y_ideaurl.trim());
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
			}
			if(ad_type == NEW_OVERLAY_FLOAT){
				if(pc_overlay_float_pic_ideaurl != null && !"".equals(pc_overlay_float_pic_ideaurl)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(1);
					ideaUrl.setType(1);
					ideaUrl.setContent(pc_overlay_float_pic_ideaurl.trim());
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
				if(pc_overlay_float_swf_ideaurl != null && !"".equals(pc_overlay_float_swf_ideaurl)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(1);
					ideaUrl1.setContent(pc_overlay_float_swf_ideaurl.trim());
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.save();
				}
				if(pc_overlay_float_h5_ideaurl != null && !"".equals(pc_overlay_float_h5_ideaurl)){
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(1);
					ideaUrl2.setType(1);
					ideaUrl2.setContent(pc_overlay_float_h5_ideaurl.trim());
					ideaUrl2.setIdeaWidth(0);
					ideaUrl2.setIdeaHeight(0);
					ideaUrl2.save();
				}
			}
			if(ad_type == MB_OVERLAY_FLOAT){
				if(mb_overlay_float_pic_ideaurl != null && !"".equals(mb_overlay_float_pic_ideaurl)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(1);
					ideaUrl.setContent(mb_overlay_float_pic_ideaurl.trim());
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
				if(mb_overlay_float_h5_ideaurl != null && !"".equals(mb_overlay_float_h5_ideaurl)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(0);
					ideaUrl1.setType(1);
					ideaUrl1.setContent(mb_overlay_float_h5_ideaurl.trim());
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.save();
				}
			}	
			//????????????????????????
			if(ad_type == MB_FOCUS_CIRCLE){
				if(mb_focus_circle_pic_ideaurl != null && !"".equals(mb_focus_circle_pic_ideaurl)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(4);
					ideaUrl.setType(1);
					ideaUrl.setContent(mb_focus_circle_pic_ideaurl.trim());
					//ideaUrl.setIdeaWidth(750);
					//ideaUrl.setIdeaHeight(350);
					//ideaUrl.save();
					
					URL url = new URL(mb_focus_circle_pic_ideaurl);
					URLConnection connection = url.openConnection();
					connection.setDoOutput(true);
					BufferedImage image = ImageIO.read(connection.getInputStream());
					int srcWidth = image.getWidth(); // ????????????
					int srcHeight = image.getHeight(); // ????????????
					
					ideaUrl.setIdeaWidth(srcWidth);
					ideaUrl.setIdeaHeight(srcHeight);
					ideaUrl.save();
					
				}
				if(mb_focus_circle_pic_ideaurl_ipad != null && !"".equals(mb_focus_circle_pic_ideaurl_ipad)){
					IdeaUrl ideaUrl2 = new IdeaUrl();
					ideaUrl2.setIdeaId(idea_id);
					ideaUrl2.setSite(0);
					ideaUrl2.setBt(5);
					ideaUrl2.setType(1);
					ideaUrl2.setContent(mb_focus_circle_pic_ideaurl_ipad.trim());
					ideaUrl2.setIdeaWidth(738);
					ideaUrl2.setIdeaHeight(315);
					ideaUrl2.save();
				}
				if(mb_focus_circle_pic_text != null && !"".equals(mb_focus_circle_pic_text)){
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(0);
					ideaUrl1.setBt(2);
					ideaUrl1.setType(22);
					ideaUrl1.setContent(mb_focus_circle_pic_text.trim());
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.save();
				}
			}
			if(ad_type == MB_JUCHANGBIAOBAN){
				if(mb_biaoban_y_ideaurl != null && !"".equals(mb_biaoban_y_ideaurl)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(2);
					ideaUrl.setType(1);
					ideaUrl.setContent(mb_biaoban_y_ideaurl.trim());
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
			}
			if(ad_type == MB_ISP){
				if(m_isp_buttontext != null && !"".equals(m_isp_buttontext)){
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(2);
					ideaUrl.setType(19);
					ideaUrl.setContent(m_isp_png_url.trim());
					ideaUrl.setTitle(m_isp_title);
					ideaUrl.setText1(m_isp_tipcontent);
					ideaUrl.setText2(m_isp_buttontext);
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();
				}
			}
		    if(ad_type == OTT_DISPLAY){
		    	if(ott_display_ideaurl != null && !"".equals(ott_display_ideaurl)){
		    		if("1".equals(app_ott_display_type)){
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(11);
						ideaUrl.setBt(3);
						ideaUrl.setType(1);
						//ott????????????????????????url??????????????????????????????
						ideaUrl.setContent("http://ott-idea-video-output.alicdn.com/ott-idea-video/daily/201806/0621/3001319/1529565440113/FJrnkzDbtVNzqJRMVAfEVUptCQxtpyMzyoj.mp4".trim());
						ideaUrl.setIdeaWidth(0);
						ideaUrl.setIdeaHeight(0);
						ideaUrl.setBitRate("");
						ideaUrl.setVolume("");
						ideaUrl.save();
						
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(11);
						ideaUrl1.setBt(3);
						ideaUrl1.setType(1);
						//ott????????????????????????url??????????????????????????????
						ideaUrl1.setContent("http://ott-idea-video-output.alicdn.com/ott-idea-video/daily/201806/0621/3001319/1529565440113/ee81ecabb5d09d64e89db888075a066a_1529565443458_TS.ts".trim());
						ideaUrl1.setIdeaWidth(0);
						ideaUrl1.setIdeaHeight(0);
						ideaUrl1.setBitRate("T1080H264");
						ideaUrl1.setVolume("90");
						ideaUrl1.save();
						
						IdeaUrl ideaUrl2 = new IdeaUrl();
						ideaUrl2.setIdeaId(idea_id);
						ideaUrl2.setSite(11);
						ideaUrl2.setBt(3);
						ideaUrl2.setType(1);
						//ott????????????????????????url??????????????????????????????
						ideaUrl2.setContent("http://ott-idea-video-output.alicdn.com/ott-idea-video/daily/201806/0621/3001319/1529565440113/cf1a2199ac6886531062e6c1232a6f20_1529565443584_TS.ts".trim());
						ideaUrl2.setIdeaWidth(0);
						ideaUrl2.setIdeaHeight(0);
						ideaUrl2.setBitRate("T1080H264");
						ideaUrl2.setVolume("100");
						ideaUrl2.save();
						
						IdeaUrl ideaUrl3 = new IdeaUrl();
						ideaUrl3.setIdeaId(idea_id);
						ideaUrl3.setSite(11);
						ideaUrl3.setBt(3);
						ideaUrl3.setType(1);
						//ott????????????????????????url??????????????????????????????
						ideaUrl3.setContent("http://ott-idea-video-output.alicdn.com/ott-idea-video/daily/201806/0621/3001319/1529565440113/48d688efb9b2b0801dae4ed1d803736f_1529565443676_MP4.mp4".trim());
						ideaUrl3.setIdeaWidth(0);
						ideaUrl3.setIdeaHeight(0);
						ideaUrl3.setBitRate("M720H264");
						ideaUrl3.setVolume("100");
						ideaUrl3.save();
						
						IdeaUrl ideaUrl4 = new IdeaUrl();
						ideaUrl4.setIdeaId(idea_id);
						ideaUrl4.setSite(11);
						ideaUrl4.setBt(3);
						ideaUrl4.setType(1);
						//ott????????????????????????url??????????????????????????????
						ideaUrl4.setContent("http://ott-idea-video-output.alicdn.com/ott-idea-video/daily/201806/0621/3001319/1529565440113/7e1e621dbd38b232aab75111faeb5e6b_1529565443759_MP4.mp4".trim());
						ideaUrl4.setIdeaWidth(0);
						ideaUrl4.setIdeaHeight(0);
						ideaUrl4.setBitRate("M1080H264");
						ideaUrl4.setVolume("100");
						ideaUrl4.save();
						
		    		}else{
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(11);
						ideaUrl.setBt(3);
						ideaUrl.setType(9);
						ideaUrl.setContent(ott_display_ideaurl.trim());
						ideaUrl.setIdeaWidth(1280);
						ideaUrl.setIdeaHeight(720);
						ideaUrl.setBitRate(ott_display_biterate);
						ideaUrl.setVolume(ott_display_volume);
						ideaUrl.save();
		    		}
		    	}
		    }	    
		    if(ad_type == OTT_DIS_REC){	    	
		    	if(ott_dis_rec_ideaurl != null && !"".equals(ott_dis_rec_ideaurl)){
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(0);
						ideaUrl.setBt(3);
						ideaUrl.setType(9);
						ideaUrl.setContent(ott_dis_rec_ideaurl.trim());
						ideaUrl.setIdeaWidth(1280);
						ideaUrl.setIdeaHeight(720);
						ideaUrl.save();		    		
		    	}
		    }  
		    if(ad_type == OTT_SCREENSAVER){	    	
		    	if(ott_screensaver_ideaurl != null && !"".equals(ott_screensaver_ideaurl)){
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(0);
						ideaUrl.setBt(0);
						ideaUrl.setType(9);
						ideaUrl.setContent(ott_screensaver_ideaurl.trim());
						ideaUrl.setIdeaWidth(1280);
						ideaUrl.setIdeaHeight(720);
						ideaUrl.save();		    		
		    	}
		    }
		    if(ad_type == OTT_POWEROFF){	    	
		    	if(ott_poweroff_ideaurl != null && !"".equals(ott_poweroff_ideaurl)){
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(0);
						ideaUrl.setBt(3);
						ideaUrl.setType(9);
						ideaUrl.setContent(ott_poweroff_ideaurl.trim());
						ideaUrl.setIdeaWidth(1280);
						ideaUrl.setIdeaHeight(720);
						ideaUrl.save();		    		
		    	}
		    }
		    
		    if(isDeeplink != null&&vid_deeplink != null && !"".equals(vid_deeplink)){
				IdeaUrl ideaUrl = new IdeaUrl();
				ideaUrl.setIdeaId(idea_id);
				ideaUrl.setSite(0);
				ideaUrl.setBt(2);
				ideaUrl.setType(37);
				ideaUrl.setContent(vid_deeplink.trim());
				ideaUrl.setIdeaWidth(0);
				ideaUrl.setIdeaHeight(0);
				ideaUrl.save();	
		    }
		    
		    if(ad_type == MB_BF) {
		    	if(mb_bf_ideaurl != null&&!"".equals(mb_bf_ideaurl)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(1);
					ideaUrl.setContent(mb_bf_ideaurl.trim());
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();	
		    	}
		    }
		    
		    if(ad_type == PC_BF) {
		    	if(mb_bf_ideaurl != null&&!"".equals(pc_bf_ideaurl)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(0);
					ideaUrl.setBt(0);
					ideaUrl.setType(1);
					ideaUrl.setContent(pc_bf_ideaurl.trim());
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();	
		    	}
		    }
		    
		    if(ad_type == PC_FEEDS) {
		    	if(pc_seeds_title != null&&!"".equals(pc_seeds_title) && pc_seeds_cover != null&&!"".equals(pc_seeds_cover)) {
					IdeaUrl ideaUrl = new IdeaUrl();
					ideaUrl.setIdeaId(idea_id);
					ideaUrl.setSite(1);
					ideaUrl.setBt(0);
					ideaUrl.setType(1);
					String content = "{\"defaultTitle0\":\"" + pc_seeds_title + "\",\"defaultAdress0\":\"" + pc_seeds_cover + "\",\"promoteUrl\":\"" + pc_seeds_ideaurl + "\"}";
					ideaUrl.setContent(content.trim());
					ideaUrl.setIdeaWidth(0);
					ideaUrl.setIdeaHeight(0);
					ideaUrl.save();	
					
					IdeaUrl ideaUrl1 = new IdeaUrl();
					ideaUrl1.setIdeaId(idea_id);
					ideaUrl1.setSite(1);
					ideaUrl1.setBt(1);
					ideaUrl1.setType(1);
					ideaUrl1.setContent(pc_seeds_ideaurl.trim());
					ideaUrl1.setIdeaWidth(0);
					ideaUrl1.setIdeaHeight(0);
					ideaUrl1.setShowtime(EasyCastUtil.getVideoLength(pc_seeds_ideaurl));
					ideaUrl1.save();	
					
		    	}		    	    	
		    }
		    
		    if(ad_type == yk_vhtml_right_relative_banner || ad_type == yk_vhtml_banner1 || ad_type == yk_vhtml_comments || ad_type == yk_vhtml_RTB) {
		    	if("2".equals(vhtml_type)) {
		    		if(vhtml_yt_banner_h5_url != null&&!"".equals(vhtml_yt_banner_h5_url) && vhtml_yt_banner_h5_width != null&&!"".equals(vhtml_yt_banner_h5_width) && vhtml_yt_banner_h5_height != null&&!"".equals(vhtml_yt_banner_h5_height)) {
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(1);
						ideaUrl.setBt(0);
						ideaUrl.setType(34);
						String url = vhtml_yt_banner_h5_url.substring(vhtml_yt_banner_h5_url.indexOf("//"), vhtml_yt_banner_h5_url.length());   
						String content = "{\"width\":\"" + vhtml_yt_banner_h5_width + "\",\"h5Url\":\"" + url + "\",\"height\":\"" + vhtml_yt_banner_h5_height + "\"}";
						ideaUrl.setContent(content.trim());
						ideaUrl.setIdeaWidth(0);
						ideaUrl.setIdeaHeight(0);
						ideaUrl.save();	
						
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(1);
						ideaUrl1.setBt(0);
						ideaUrl1.setType(34);
						String content1 = "HTML_START\r\n" + 
								"<div style=\"text-align:center\"><div style=\"position: relative; height:106px; width: 316px; margin-left:auto; margin-right: auto; text-align: left\"><iframe width=\"316\" height=\"106\" scrolling=\"no\" frameborder=\"0\" allowtransparency=\"true\" marginheight=\"0\" marginwidth=\"0\" src=\""+ url + "\"></iframe><img src=\"//r1.ykimg.com/material/0A03/201605/0511/test/close-new1.png\" width=\"15px\" height=\"15px\" alt=\"????????????\" onclick=\"this.parentNode.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode.parentNode)\" style=\"position:absolute; left:0; top: 0; cursor: pointer; \"><img src=\"//static.atm.youku.com/idea/201510/1014/test/ad.png\" border=\"0\" style=\"position: absolute; left: 0; bottom: 1px; z-index: 1000;\"></div></div>\r\n" + 
								"HTML_END\r\n" + 
								"SCRIPT_START\r\n" + 
								"SCRIPT_END";
						ideaUrl1.setContent(content1.trim());
						ideaUrl1.setIdeaWidth(0);
						ideaUrl1.setIdeaHeight(0);
						ideaUrl1.save();	
		    		}
		    	}else if("1".equals(vhtml_type)) {
		    		if(vhtml_yt_banner_pip_url != null&&!"".equals(vhtml_yt_banner_pip_url)) {
						IdeaUrl ideaUrl = new IdeaUrl();
						ideaUrl.setIdeaId(idea_id);
						ideaUrl.setSite(1);
						ideaUrl.setBt(0);
						ideaUrl.setType(32);
						String url = vhtml_yt_banner_pip_url.substring(vhtml_yt_banner_pip_url.indexOf("//"), vhtml_yt_banner_pip_url.length()); 
						String content = "{\"picUrl\":\"" + url + "\"}";
						ideaUrl.setContent(content.trim());
						ideaUrl.setIdeaWidth(0);
						ideaUrl.setIdeaHeight(0);
						ideaUrl.save();	
						
						IdeaUrl ideaUrl1 = new IdeaUrl();
						ideaUrl1.setIdeaId(idea_id);
						ideaUrl1.setSite(1);
						ideaUrl1.setBt(0);
						ideaUrl1.setType(32);
						String content1 = "HTML_START\r\n" + 
								"<div style=\"text-align:center???width:316px; height: 106px; position:relative; margin: 0 auto;\"><div style=\"position: relative; height:106px; width: 316px; margin-left:auto; margin-right: auto; text-align: left\"><a href=\"//v2html.atm.youku.com/vhtmlclick?p=!positionid!&pp=!ppositionid!&pg=!pageid!&&ca=!castid!&ie=" + idea_id +"&k=!key!&u=!u!&uri=!userID!&dc=!dcID!\" target=\"_blank\"><img border=\"0\" src=\"" + url + "\" style=\"width:316px; height:106px;\"></a><img src=\"//static.atm.youku.com/idea/201510/1014/test/ad.png\" border=\"0\" style=\"position: absolute; left: 0; bottom: 1px; z-index: 1000;\"></div></div>\r\n" + 
								"HTML_END";
						ideaUrl1.setContent(content1.trim());
						ideaUrl1.setIdeaWidth(0);
						ideaUrl1.setIdeaHeight(0);
						ideaUrl1.save();	
		    		}
		    	}
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
			//int idd = Integer.parseInt(id) >> 2;
			Long idd = Long.parseLong(id)>>2;
			return idd + "";
		}
		return "";
	}
	
	String insertVideoGroupProgrammeId(String video_group_area5) {
		String vids[] = video_group_area5.split("\r?\n");
		String vid_str = "";
		
		for (int i = 0; i < vids.length; i++) {
			String tmp = vids[i];
			tmp = tmp.replaceAll("\\s", "");
			if ("".equals(tmp))
				continue;
			try {
				vid_str += EasyCastUtil.getUrlInfo("showid", tmp) + " ";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("vid_str is: " + vid_str);
		vid_str = vid_str.substring(0, vid_str.length() - 1);
		return vid_str;	
	}
	
	//tudou_video_group

	String insertVideoGroupTD(String video_group_area2) {
		Set<String> vgset = new HashSet();
		String playlist_str = "";
		try {
			String vid_str = "";
			Pattern tudouPattern = Pattern.compile(
							"http\\:\\/\\/\\w+\\.tudou\\.com/programs/view/([a-zA-Z_0-9\\-]{11}).*|"
									+ // ??????????????????
									"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/id/?(\\d+)|"
									+ "http\\:\\/\\/\\w+\\.tudou\\.com/playlist/album/id(\\d+).html|"
									+ "http\\:\\/\\/\\w+\\.tudou\\.com/playlist/p/a(\\d+).html|"
									+ "http\\:\\/\\/\\[??????\\](\\d+)-.*|"
									+ //???????????????????????????
									"http\\:\\/\\/\\w+\\.tudou\\.com/albumcover/([a-zA-Z_0-9\\-]{11}).html|"
									+ //???????????????????????????????????? 
									"http\\:\\/\\/\\w+\\.tudou\\.com/listcover/([a-zA-Z_0-9\\-]{11}).html|"
									+
									"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
									+ // ??????????????? 
									"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/([a-zA-Z_0-9\\-]{11}).html|"
									+ // ??????????????? 
									"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
									+ // ???????????????
									"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/([a-zA-Z_0-9\\-]{11}).html|"
									+ // ???????????????
									"http\\:\\/\\/\\w+\\.tudou\\.com/oplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
									+ // ???????????????
									"http\\:\\/\\/\\w+\\.tudou\\.com/plcover/([a-zA-Z_0-9\\-]{11}).*|"
									+ //// ????????????
									"(\\d+)", Pattern.CASE_INSENSITIVE);

			if (video_group_area2 != null && video_group_area2.length() != 0) {}
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
				intValue = defaultValue;}
		}
		return intValue;
	}

	
	public static void main(String[] args) {
		System.out.println(revertUrl("render.alipay.com/p/f/jfkusjcq/index.htmlinterrogation_escchInfoequal_escch_youku"));
		System.out.println(new ActionCast().insertVideoGroup("https://v.youku.com/v_show/id_XMzY2MTkyNDc3Mg==.html"));
	}
}
