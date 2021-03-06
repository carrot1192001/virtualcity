<%@page import="com.youku.adssp.om.YesDsp"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.io.IOException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.torque.TorqueException"%>
<%@page import="org.apache.torque.util.Criteria"%>
<%@page import="org.apache.torque.Torque"%>
<%@page import="com.youku.atm.om.*"%>
<%@page import="com.youku.adssp.om.*"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="org.apache.torque.TorqueException"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="com.youku.atm.easycast.*"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="redis.clients.jedis.Jedis"%>
<%@page import="redis.clients.jedis.JedisPool"%>
<%@page import="redis.clients.jedis.JedisPoolConfig"%>

<%
	String base = request.getContextPath(); 
	String ip = InetAddress.getLocalHost().getHostAddress();
	//String remote_ip = request.getRemoteAddr();
	//List<Channel> y_channelList = EasyCastUtil.getAllConfigChannels("ykn");
	//List<Channel> t_channelList = EasyCastUtil.getAllConfigChannels("tdn");	
	//List<Channel> sy_channelList = EasyCastUtil.getAllConfigChannels("SY");	
	
	//List<Channel> yzw_channelList = EasyCastUtil.getAllConfigChannels("zw");
	//List<Channel> tzw_channelList = EasyCastUtil.getAllConfigChannels("35");	
	//List<Area> areaList = EasyCastUtil.getAllConfigAreas("province");
	//List<Area> stateList = EasyCastUtil.getAllConfigAreas("state");
	List ips = EasyCastUtil.getLocalIP();
    //campaign
    List<Campaign> campaignList_show = EasyCastUtil.getAllConfigCampaigns_show(1);
    List<Campaign> campaignList_click = EasyCastUtil.getAllConfigCampaigns_click(2);
    List<Campaign> campaignList_over = EasyCastUtil.getAllConfigCampaigns_over(3);
    List<Campaign> campaignList_skip = EasyCastUtil.getAllConfigCampaigns_skip(4);
    List<Campaign> campaignList_preload = EasyCastUtil.getAllConfigCampaigns_preload(5);
    List<HPosition> hPosition = EasyCastUtil.getHposition("%?????????%");
    List<AdPosition> infoFlowAdPosition = EasyCastUtil.getInfoFlowAdPosition("%?????????%", "yk","h", "31");
    List<AdPosition> focusCirclePicsPos = EasyCastUtil.getInfoFlowAdPosition("%APP-????????????-?????????%", "yk","h", "18");
    //List<AdPosition> spotlightPos = EasyCastUtil.getInfoFlowAdPosition("%?????????%", "yk","h","31");
    List<AdPosition> pcfeedsvideo = EasyCastUtil.getInfoFlowAdPosition("%????????????%", "yk","h","27");
    //List<YesDsp> yesDspPos = EasyCastUtil.getYesDsp();
    List<YesDsp> yesDspPos = YesDspPeer.doSelect(new Criteria("adssp"));
	List<Platform> osList = PlatformPeer.doSelect(new Criteria());
	
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxIdle(20);
    jedisPoolConfig.setMaxTotal(40);
    jedisPoolConfig.setMinIdle(10);

    JedisPool pool = new JedisPool(jedisPoolConfig, "localhost", 6379, 1000, null);

    Jedis jedis = null;
    
    jedis = pool.getResource();
	  
    Set<String> keys = jedis.keys("*");
    
    int margin1 = 0;
    int margin2 = 0;
    int margin3 = 0;
    int margin4 = 0;
    int margin5 = 0;
    int margin6 = 0;
    int margin7 = 0;
    
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>????????????-<%=ip%></title>
<link rel="shortcut icon" href="alimamalogo.jpg" type="image/x-icon"/>
<link rel="stylesheet" href="<%=base%>/js/ajax/jquery/themes/jquery-ui-1.8.16.custom/css/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" media="all" />
<link href="/js/ajax/css/jquery-ui-timepicker-addon.css" type="text/css" />
<link href="/js/ajax/css/demos.css" rel="stylesheet" type="text/css" />
<script src="<%=base%>/js/ajax/jquery/jquery-1.6.2.min.js" type="text/javascript"></script>
<script src="<%=base%>/js/ajax/jquery/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
<script src="<%=base%>/js/ajax/jquery/ui/i18n/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
<script src="<%=base%>/js/ajax/jquery/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<style type="text/css">
/* WebKit browsers */
::-webkit-input-placeholder {
	color: #00FF00;
}
/* Mozilla Firefox 4 to 18 */
:-moz-placeholder {
	color: #00FF00;
	opacity: 1;
}
/* Mozilla Firefox 19+ */
::-moz-placeholder {
	color: #00FF00;
	opacity: 1;
}
/* Internet Explorer 10+ */
:-ms-input-placeholder {
	color: #00FF00;
}
</style>
<script type="text/javascript">
	var $j = jQuery.noConflict();
	
	$j(function() {
        $j("#startDateRow").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            timeFormat: 'hh:mm:ss',  
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=endDateRow]").datepicker("option" , "minDate" , dateText);
           }
        });
        
        $j("#endDateRow").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            showMonthAfterYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=startDateRow]").datepicker("option" , "maxDate" , dateText);
        }});
   	});
	
	$j(function() {
        $j("#startDateRow_show").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=endDateRow]").datepicker("option" , "minDate" , dateText);
           }
        });
        
        $j("#endDateRow_show").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            showMonthAfterYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=startDateRow]").datepicker("option" , "maxDate" , dateText);
        }});
   	});
	
	$j(function() {
        $j("#startDateRow_click").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=endDateRow]").datepicker("option" , "minDate" , dateText);
           }
        });
        
    $j("#endDateRow_click").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            showMonthAfterYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=startDateRow]").datepicker("option" , "maxDate" , dateText);
        }});
   	});
	
	$j(function() {
        $j("#startDateRow_over").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=endDateRow]").datepicker("option" , "minDate" , dateText);
           }
        });
        
    $j("#endDateRow_over").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            showMonthAfterYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=startDateRow]").datepicker("option" , "maxDate" , dateText);
        }});
   	});
	
	$j(function() {
        $j("#startDateRow_skip").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=endDateRow]").datepicker("option" , "minDate" , dateText);
           }
        });
        
    $j("#endDateRow_skip").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            showMonthAfterYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=startDateRow]").datepicker("option" , "maxDate" , dateText);
        }});
   	});
	
	$j(function() {
        $j("#startDateRow_preload").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=endDateRow]").datepicker("option" , "minDate" , dateText);
           }
        });
        
    $j("#endDateRow_preload").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            showMonthAfterYear: true,
            onSelect: function(dateText, inst) {
                $j(this).parent().parent().find("[name=startDateRow]").datepicker("option" , "maxDate" , dateText);
        }});
   	});

	$j(function() {
        $j("#timePicker_starttime").timepicker({
        	timeFormat: 'HH:mm:ss',
            changeMonth: true,
            changeYear: true,
        });
        
    $j("#timePicker_endtime").timepicker({
    	    timeFormat: 'HH:mm:ss',
            changeMonth: true,
            changeYear: true,});
   	});
	
	function $(id){
		return document.getElementById(id);
	}
	
	function initform(){
		//init ad_type_select
		var ad_type_select = $("ad_type");		
		ad_type_select.options.add(new Option("?????????","160"));
		ad_type_select.options.add(new Option("?????????","164"));
		ad_type_select.options.add(new Option("?????????","163"));
		ad_type_select.options.add(new Option("?????????","161"));
		ad_type_select.options.add(new Option("???crazy","168"));
		ad_type_select.options.add(new Option("???Ad selector","169"));
		ad_type_select.options.add(new Option("??????????????????","167"));
		ad_type_select.options.add(new Option("?????????","165"));
		ad_type_select.options.add(new Option("????????????","175"));
		ad_type_select.options.add(new Option("?????????","162"));
		ad_type_select.options.add(new Option("????????????(???????????????)/?????????","170"));
		ad_type_select.options.add(new Option("????????????","171"));
		ad_type_select.options.add(new Option("????????????","172"));
		ad_type_select.options.add(new Option("???????????????","205"));
		ad_type_select.options.add(new Option("???????????????","207"));
		ad_type_select.options.add(new Option("????????????","6"));
	}	
	function toggle(targetid){
	    if (document.getElementById){
	        target=document.getElementById(targetid);
	            if (target.style.display=="block"){
	                target.style.display="none";
	            } else {
	                target.style.display="block";
	            }
	    }
	}	
	function validate()
	{
		submitOK="true"
		var x = document.getElementsByName("resolution_hd2");
		var y = document.getElementsByName("resolution_mp4");
		var z = document.getElementsByName("resolution_flv");
		//x[i].checked == true		
		if((x[0].checked == true && x[1].checked == false && x[2].checked == false && x[3].checked == false) || (y[0].checked == true && y[1].checked == false && y[2].checked == false && y[3].checked == false) || (z[0].checked == true && z[1].checked == false && z[2].checked == false && z[3].checked == false)){
			 alert("???????????????????????????????????????????????????????????????!!!");

			 submitOK="false";
		}		
		submitOK1="true"
		var x1= document.getElementById("pc_vf_y_ideaurl");
		var x2= document.getElementById("m_vf_ideaurl");
		var x3= document.getElementById("pc_hvideo_vf_h5");
		var obj1 = document.getElementById("ad_type");
        
		if((x1.value==""&&obj1.value=="160"&&x3.value=="")||(x2.value==""&&obj1.value=="70")){
			alert("??????url????????????null!!!");
			submitOK1="false";
		}	
		if (submitOK=="false"||submitOK1=="false")
		 {
		 return false
		 }
	}
	
	setInterval("r()",500);
	function r(){
	 var f = document.getElementById("m2link");
	 var temp =  ("green" == f.style.color) ? "blue" : "red";
	 f.style.color =  ("red"==f.style.color) ? "green": temp;
	}  	
	function changeAdType(os_type){
		var ad_type_select = $("ad_type");
		ad_type_select.options.length = 0;	
		if(os_type == "p"){
			ad_type_select.options.add(new Option("?????????","160"));
			ad_type_select.options.add(new Option("?????????","164"));
			ad_type_select.options.add(new Option("?????????","163"));
			ad_type_select.options.add(new Option("?????????","161"));
			ad_type_select.options.add(new Option("???crazy","168"));
			ad_type_select.options.add(new Option("???Ad selector","169"));
			ad_type_select.options.add(new Option("??????????????????","167"));
			ad_type_select.options.add(new Option("?????????/????????????","165"));
			ad_type_select.options.add(new Option("????????????","175"));
			ad_type_select.options.add(new Option("?????????","162"));
			ad_type_select.options.add(new Option("????????????(???????????????)/?????????","170"));
			ad_type_select.options.add(new Option("????????????","171"));	
			ad_type_select.options.add(new Option("????????????","172"));
			ad_type_select.options.add(new Option("???????????????","205"));
			ad_type_select.options.add(new Option("???????????????","207"));
			ad_type_select.options.add(new Option("????????????","6"));
			
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			
			$("pcdevice").style.display = "";
			$("mdevice").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("isVidLimit").checked = false;
			$("isVidLimit").disabled = false;
			$("m_os_div").style.display = "none" ;
			$("pc_os_div").style.display = "" ;
			$("millwardbrown_div").style.display = "";
			//millwardbrown_app_div
			$("millwardbrown_app_div").style.display = "";			
			//youku_survey_url
			$("youku_survey_url").style.display = "none";
			$("tudou_survey_url").style.display = "none";			
			$("survey_show_url").style.display = "none";
			$("survey_click_url").style.display = "none";
			$("survey_entry_text").style.display = "none";
			$("otherh5showurl").style.display = "none";
			$("ies_monitor").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("outtime").style.display = "";
			$("vhtml_type").style.display = "none";
			$("isCast_barkidea").style.display = "";
            $("khclickurl").style.display = "";
            $("othershowurl").style.display = "";
            
            $("khspreadshowurl").style.display = "none";
            $("otherclickurl").style.display = "";        
			$("mb_app_click_way").style.display = "none" ;		
			$("os_div").style.display = "none";			
			$("all_os").checked = false;
			$("normal_pc").checked = true;
			$("normal_pc_vob").checked = true;
			$("normal_pc_vb").checked = true;
			$("normal_pc_tp").checked = true;
			$("bottom_left").checked = true;
			$("zero_minute").checked = true;
			var items = document.getElementsByName("chk_os");
			
			for(i = 0; i < items.length; i++){
				items[i].checked = false;
			}

			$("cast_type_div").style.display = "none";
			
			$("pc_vf").style.display = "";
			$("pc_biaoban").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			//pc_overlay_float
			$("pc_overlay_float").style.display = "none";
			//pc_seeds
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			//mb_focus_circle_pic
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";

			$("pc_vi").style.display = "none";
			$("show_campaign_div").style.display = "none";
			$("show_v_position_div").style.display = "none";
			$("show_vo_position_div").style.display = "none";
			$("click_campaign_div").style.display = "none";
			$("over_campaign_div").style.display = "none";
			$("skip_campaign_div").style.display = "none";
			$("preload_campaign_div").style.display = "none";
			$("is_show_campaign").checked = false;
			$("is_show_campaign").disabled = false;
			$("is_click_campaign").checked = false;
			$("is_click_campaign").disabled = false;
			$("is_over_campaign").checked = false;
			$("is_over_campaign").disabled = false;			
			$("is_ir").checked = false;
			$("is_ir").disabled = false;
			$("priority").disabled = false;
			$("total_lun").disabled = false;
			$("percent").disabled = false;
			$("is_show_v_position").checked = false;
			$("is_show_v_position").disabled = false;
			$("is_show_vo_position").disabled = false;
			$("m_issdk").style.display = "none";
			$("resolution").style.display = "none";
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			$("is_show_v_position").style.display = "";
			$("is_show_vo_position").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			$("loader").style.display = "none";
			$("pc_custom_text").style.display = "none";
			$("yk_second_class").style.display = "none";
			$("td_second_class").style.display = "none";

		} else if (os_type == "m") {
			
			ad_type_select.options.add(new Option("????????????","70"));
			ad_type_select.options.add(new Option("????????????","71"));
			ad_type_select.options.add(new Option("????????????","73"));
			ad_type_select.options.add(new Option("????????????/????????????","74"));
			ad_type_select.options.add(new Option("???????????????","75"));	
			ad_type_select.options.add(new Option("????????????","76"));
			ad_type_select.options.add(new Option("????????????","80"));
			ad_type_select.options.add(new Option("????????????","72"));
			ad_type_select.options.add(new Option("???????????????","3"));
			ad_type_select.options.add(new Option("??????app?????????banner(?????????????????????10/10)","4"));
			ad_type_select.options.add(new Option("??????app?????????banner","5"));
			ad_type_select.options.add(new Option("APP???????????????/????????????banner","61"));
			ad_type_select.options.add(new Option("??????????????????","81"));
			ad_type_select.options.add(new Option("??????????????????","82"));
			ad_type_select.options.add(new Option("???????????????","173"));
			ad_type_select.options.add(new Option("ott????????????(sy)","200"));
			ad_type_select.options.add(new Option("ott????????????(sy)","201"));
			ad_type_select.options.add(new Option("ott????????????(sy)/?????????????????????","202"));
			ad_type_select.options.add(new Option("ott??????????????????(sy)-???/?????????","203"));
			ad_type_select.options.add(new Option("feeds??????(??????)","174"));
			ad_type_select.options.add(new Option("???????????????","204"));
			ad_type_select.options.add(new Option("??????????????????/?????????","83"));
			ad_type_select.options.add(new Option("?????????????????????","84"));
			ad_type_select.options.add(new Option("?????????????????????","85"));
			ad_type_select.options.add(new Option("???????????????","206"));
								
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			
			$("isVidLimit").checked = false;
			$("isVidLimit").disabled = false;
			
			$("m_os_div").style.display = "block" ;
			$("pc_os_div").style.display = "none" ;
			$("millwardbrown_div").style.display = "";
			$("millwardbrown_app_div").style.display = "";
			$("youku_survey_url").style.display = "none";
			$("tudou_survey_url").style.display = "none";
			
			$("survey_show_url").style.display = "none";
			$("survey_click_url").style.display = "none";
			$("survey_entry_text").style.display = "none";

			$("ies_monitor").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
            //mb_app_click_way
            $("mb_app_click_way").style.display = "" ;
			$("all_os").checked = false;	
			$("outtime").style.display = "";
			$("vhtml_type").style.display = "none";
			$("isCast_barkidea").style.display = "";
            $("khclickurl").style.display = "";
            $("othershowurl").style.display = "";
            $("khspreadshowurl").style.display = "none";
            $("otherclickurl").style.display = "";
            $("otherh5showurl").style.display = "";
            //$("mb_click_ways").style.display = "";
            $("vhtml_yt_banner_pip").style.display = "none";
            $("vhtml_yt_banner_flash").style.display = "none";
            $("vhtml_yt_promoted_video").style.display = "none";
            $("vhtml_m_playing_page_web").style.display = "none";
            $("m_web_video_banner").style.display = "none";
			$("cast_type_div").style.display = "none";
//			$("cast_type").value = "0";
//			$("cast_type").disabled = false;
			$("mdevice").style.display = "";
			$("pcdevice").style.display = "none";
			
			$("m_vf").style.display = "";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";			
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";

			$("mb_vf_buyingbyseeing").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			//m_mhtml,m_searchBanner
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			//m_playingBanner
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
//			$("cast_level_msg_div").style.display = "none";
			$("show_campaign_div").style.display = "none";
			
			//$("show_priority_div").style.display = "none";
			//v_position
			$("show_v_position_div").style.display = "none";
			$("show_vo_position_div").style.display = "none";
			//$("show_os_pc_div").style.display = "none";
			$("click_campaign_div").style.display = "none";
			$("over_campaign_div").style.display = "none";
			$("skip_campaign_div").style.display = "none";
			$("preload_campaign_div").style.display = "none";
			$("is_show_campaign").checked = false;
			$("is_show_campaign").disabled = false;
			$("is_click_campaign").checked = false;
			$("is_click_campaign").disabled = false;
			$("is_over_campaign").checked = false;
			$("is_over_campaign").disabled = false;
			$("is_ir").checked = false;
			$("is_ir").disabled = false;
			//$("is_show_priority").checked = false;
			$("priority").disabled = false;
			$("total_lun").disabled = false;
			$("percent").disabled = false;
			//is_show_v_position
			$("is_show_v_position").checked = false;
			//
			$("is_show_v_position").disabled = false;
			$("is_show_vo_position").disabled = false;
			$("m_issdk").style.display = "";
			
			//$("usehd").style.display = "";
			//resolution
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";

			$("skiptimethreshold").style.display = "none";
			$("clientplayovertime").style.display = "none";
			
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			$("is_show_vo_position").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("mb_click").style.display = "";
			$("loader").style.display = "none";
			//pc_custom_text
			$("pc_custom_text").style.display = "none";
			$("yk_second_class").style.display = "none";
			$("td_second_class").style.display = "none";

		}else {
			//$("vt2").disabled = true;
			//$("vt0").selected = true;
			
			//ad_type_select.options.add(new Option("youku_???????????????PIP???????????????????????????","322"));
			
			//"youku_???????????????????????????banner ???????????????","320"(original)
			ad_type_select.options.add(new Option("??????-PC_??????_WEB-????????????-BANNER-?????????????????????-???????????????","61204"));
			
			//youku_???????????????banner1???????????????","324"
			ad_type_select.options.add(new Option("??????-PC_??????_WEB-????????????-BANNER-?????????????????????-??????\"?????????\"???banner","61201"));
			//ad_type_select.options.add(new Option("youku_?????????????????????PIP???UGC???","325"));
			
			//"youku_???????????????????????????????????????-?????????","323"
			ad_type_select.options.add(new Option("??????-PC_??????_WEB-????????????-??????-?????????????????????-????????????","61202"));
			
			//youku_????????????????????????????????????RTB?????????","321"
			ad_type_select.options.add(new Option("??????-PC_??????_WEB-????????????-??????-?????????????????????-????????????","61203"));
			//ad_type_select.options.add(new Option("youku_???????????????-????????? ????????????","327"));
			ad_type_select.options.add(new Option("youku_??????web ?????????","326"));
			//ad_type_select.options.add(new Option("tudou_???????????????banner1","346"));
			//ad_type_select.options.add(new Option("tudou_UGC?????????banner (300*250)","345"));
			//ad_type_select.options.add(new Option("tudou_???????????????-??????????????????????????????banner","340"));
			//ad_type_select.options.add(new Option("tudou_???????????????-???????????????????????? PIP","341"));
			//ad_type_select.options.add(new Option("tudou_???????????????-???????????????????????? PIP","344"));
			//ad_type_select.options.add(new Option("tudou_???????????????-?????????????????????????????????","342"));
			//ad_type_select.options.add(new Option("tudou_???????????????-????????????","343"));
			ad_type_select.options.add(new Option("????????????_promoted_video_ads(1430192600)","1430192600"));
			ad_type_select.options.add(new Option("????????????_promoted_video_ads(1430192617)","1430192617"));
			
			ad_type_select.options.add(new Option("m???????????????(youku_??????phone-web???_?????????banner)","1425020640"));	
			ad_type_select.options.add(new Option("m???????????????(youku_??????ipad-web???_?????????banner)","1427883541"));	
			
			ad_type_select.options.add(new Option("?????????web?????????Banner","20"));	
			ad_type_select.options.add(new Option("youku_????????????VIDEO_BANNER (??????)","145"));	
			ad_type_select.options.add(new Option("youku_????????????-????????????_??????","501"));	
			ad_type_select.options.add(new Option("youku_????????????-????????????_??????_?????????","173"));	
			ad_type_select.options.add(new Option("youku_??????????????????","849"));	
			
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_os_div").style.display = "" ;
			$("pc_os_div").style.display = "none" ;
			$("millwardbrown_div").style.display = "none";
			$("millwardbrown_app_div").style.display = "none";
			$("youku_survey_url").style.display = "none";
			$("tudou_survey_url").style.display = "none";
			
			$("survey_show_url").style.display = "none";
			$("survey_click_url").style.display = "none";
			$("survey_entry_text").style.display = "none";
			$("ies_monitor").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("outtime").style.display = "none";
			$("vhtml_type").style.display = "";
			$("isCast_barkidea").style.display = "none";
			$("khclickurl").style.display = "none";
			$("othershowurl").style.display = "none";
			$("khspreadshowurl").style.display = "none";
			$("otherclickurl").style.display = "";
			$("otherh5showurl").style.display = "none";
			//$("mb_click_ways").style.display = "none";
			//vhtml_yt_banner_pip
			$("vhtml_yt_banner_pip").style.display = "";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("all_os").checked = false;	

			$("cast_type_div").style.display = "none";
//			$("cast_type").value = "0";
//			$("cast_type").disabled = false;
			$("mdevice").style.display = "";
			$("pcdevice").style.display = "none";
			
			$("m_vf").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("show_campaign_div").style.display = "none";
			
			//$("show_priority_div").style.display = "none";
			//v_position
			$("show_v_position_div").style.display = "none";
			$("show_vo_position_div").style.display = "none";
			//$("show_os_pc_div").style.display = "none";
			$("click_campaign_div").style.display = "none";
			$("over_campaign_div").style.display = "none";
			$("skip_campaign_div").style.display = "none";
			$("is_show_campaign").checked = false;
			$("is_show_campaign").disabled = false;
			$("is_click_campaign").checked = false;
			$("is_click_campaign").disabled = false;
			$("is_over_campaign").checked = false;
			$("is_over_campaign").disabled = false;
			$("is_ir").checked = false;
			$("is_ir").disabled = false;
			//$("is_show_priority").checked = false;
			$("priority").disabled = false;
			$("total_lun").disabled = false;
			$("percent").disabled = false;
			//is_show_v_position
			$("is_show_v_position").checked = false;
			//
			$("is_show_v_position").disabled = false;
			$("is_show_vo_position").disabled = false;
			$("m_issdk").style.display = "none";
			//$("usehd").style.display = "";
			//resolution
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			$("is_show_vo_position").style.display = "none";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("mb_click").style.display = "";
			$("loader").style.display = "none";
			//pc_custom_text
			$("pc_custom_text").style.display = "none";
			$("yk_second_class").style.display = "none";
			$("td_second_class").style.display = "none";

		}
	}

	function hideCampAndVideogroup(ad_type){
		if(ad_type == 165){	
			$("is_show_campaign").checked = false;
			$("is_show_campaign").disabled = false;
			$("is_click_campaign").checked = false;
			$("is_click_campaign").disabled = false;
			$("is_over_campaign").checked = false;
			$("is_over_campaign").disabled = false;
			$("is_ir").checked = false;
			$("is_ir").disabled = false;
			//$("is_show_priority").checked = false;
			$("priority").disabled = false;
			$("total_lun").disabled = false;
			$("percent").disabled = false;
			//is_show_v_position
			$("is_show_v_position").checked = false;
			$("is_show_v_position").disabled = false;
			//
			$("is_show_vo_position").disabled = false;
			$("show_campaign_div").style.display = "none";
			
			//$("show_priority_div").style.display = "none";
			//v_position
			$("show_v_position_div").style.display = "none";
			$("show_vo_position_div").style.display = "none";
			//$("show_os_pc_div").style.display = "none";
			$("click_campaign_div").style.display = "none";
			$("over_campaign_div").style.display = "none";
			$("skip_campaign_div").style.display = "none";
			$("preload_campaign_div").style.display = "none";
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("clientplayovertime").style.display = "none";
			$("khspreadshowurl").style.display = "none";

		} else {
			$("is_show_campaign").disabled = false;
			$("is_click_campaign").disabled = false;
			$("is_over_campaign").disabled = false;
			$("is_ir").checked = false;
			$("is_ir").disabled = false;
			$("priority").disabled = false;
			//total_lun
			$("total_lun").disabled = false;
			$("percent").disabled = false;
			//is_show_v_position
			$("is_show_v_position").disabled = false;
			$("is_show_vo_position").disabled = false;
			//$("khspreadshowurl").style.display = "none";
		}

		if(ad_type == 74 || ad_type == 75 || ad_type == 175){
			$("cast_type_div").style.display = "";	
//			$("cast_level_msg_div").style.display = "none";

			if(ad_type == 74){
//				$("cast_type").value="2";
//				$("cast_type").disabled = true;
//				$("cast_level_msg_div").style.display = "";
			}

			if(ad_type == 75 || ad_type == 175){
				//all_channel
				$("all_channel").checked = false;
				$("all_channel").disabled = true;
				$("isVidLimit").checked = false;
				$("isVidLimit").disabled = true;
				
				$("videogroup_div").style.display = "none";
//				$("cast_type").value="2";
//				$("cast_type").disabled = true;
//				$("cast_level_msg_div").style.display = "";
			} else {
				$("isVidLimit").disabled = false;
				$("all_channel").disabled = false;
				
			}
		} else {
			$("cast_type_div").style.display = "none";
			$("isVidLimit").disabled = false;
			$("all_channel").disabled = false;
		}
		if(ad_type == 160){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";			
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			//$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			//resolution
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		if(ad_type == 164){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			//$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			//resolution
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("clientplayovertime").style.display = "none";
			
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			
		}
		if(ad_type == 163){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			//resolution
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		if(ad_type == 165){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			//resolution
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		if(ad_type == 161){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			//resolution
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		if(ad_type == 167){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("clientplayovertime").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		if(ad_type == 168){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			$("clickurl").style.display = "none";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("clientplayovertime").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		if(ad_type == 169){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			$("clickurl").style.display = "none";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("clientplayovertime").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		
		//pc_mi(iku_kaijitu_pc)
		if(ad_type == 175){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			//document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = true;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			$("clickurl").style.display = "none";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
		    $("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("clientplayovertime").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		//pc_tiepian
		if(ad_type == 162){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//pc_?????????????????????????????????
		if(ad_type == 170){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			//?????????????????????????????????
			$("pc_vf_buyingbyseeing").style.display = "";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//pc_????????????
		if(ad_type == 171){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			//?????????????????????????????????
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//pc_????????????
		if(ad_type == 172){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			//?????????????????????????????????
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("otherclickurl").style.display = "";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			$("clickurl").style.display = "none";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		
		//pc???????????????
		if(ad_type == 205){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			//?????????????????????????????????
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("otherclickurl").style.display = "";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			$("clickurl").style.display = "none";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		
		//????????????
		if(ad_type == 6){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "";
			$("mb_overlay_float").style.display = "none";			
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			//$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			//resolution
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//mdevice
		if(ad_type == 70){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		if(ad_type == 71){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			//$("mb_overlay_float").style.display = "none";
			
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			

		}
		if(ad_type == 73){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("m_vp_ideaurl").style.display = "";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			

		}
		if(ad_type == 74){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("otherclickurl").style.display = "";
			$("otherh5showurl").style.display = "none";			
			$("clickurl").style.display = "";
			//$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		if(ad_type == 75){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=true;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=true;
			document.getElementById("app_d").disabled=true;
			document.getElementById("game_sdk").disabled=true;
			$("khspreadshowurl").style.display = "none";
			//document.getElementById("all_channel_div").style.display="";
			//$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("m_mi").style.display = "";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		
		if(ad_type == 76){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_sdk").value=0;
			$("m_ztsdk").value=0;
			$("m_qtsdk").value=0;
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			var trss = document.getElementsByClassName("quanping_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
		}
		
		//mb_????????????
		if(ad_type == 82){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			$("clickurl").style.display = "none";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			$("otherclickurl").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
		}
		
		//mo
		if(ad_type == 80){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		//mb_tiepian
		if(ad_type == 72){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_vtp").style.display = "";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}

		
		//??????_?????????????????????????????????
		if(ad_type == 83){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;

			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";			
		}
		
		//????????????????????????
		if(ad_type == 84){
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=true;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=true;
			document.getElementById("app_d").disabled=true;
			document.getElementById("game_sdk").disabled=true;
			$("khspreadshowurl").style.display = "none";
			//document.getElementById("all_channel_div").style.display="";
			//$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("m_mi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";	
		}
		
		if(ad_type == 85){

			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=true;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=true;
			document.getElementById("app_d").disabled=true;
			document.getElementById("game_sdk").disabled=true;
			$("khspreadshowurl").style.display = "none";
			//document.getElementById("all_channel_div").style.display="";
			//$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("m_mi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";	
		}
		
		  //mhtml(?????????)-youku_????????????????????????????????????
		if(ad_type == 3){
			document.getElementById("reserve_shua").disabled=true;
			document.getElementById("reserve_cpm").disabled=true;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").disabled=true;
			document.getElementById("reserve_lunbo").selected=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = true;
			
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		//mhtml(??????app?????????banner)
		if(ad_type == 4){
			document.getElementById("reserve_shua").disabled=true;
			document.getElementById("reserve_cpm").disabled=true;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").disabled=true;
			document.getElementById("reserve_lunbo").selected=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = true;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		//mvhtml(??????app?????????banner)
		if(ad_type == 5){
			document.getElementById("reserve_shua").disabled=true;
			document.getElementById("reserve_cpm").disabled=true;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		//mhtml(APP???????????????)
		if(ad_type == 61){
			document.getElementById("reserve_shua").selected=true;
			document.getElementById("reserve_cpm").disabled=true;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").disabled=true;
			document.getElementById("reserve_lunbo").disabled=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			//document.getElementById("all_channel_div").style.display="none";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = true;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		//????????????_promoted_video_ads(1429860427);????????????_promoted_video_ads(1430199248)
		if(ad_type == 1430192600 || ad_type == 1430192617){
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			
			document.getElementById("reserve_cpc").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").disabled=true;
			document.getElementById("reserve_lunbo").disabled=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("reserve_shua").disabled=true;
			
			document.getElementById("youku_promoted_video_ads").selected=true;
			document.getElementById("youku_playing_banner_pip").disabled=true;
			document.getElementById("youku_playing_banner_flash").disabled=true;
			document.getElementById("youku_playing_custom").disabled=true;
			document.getElementById("tudou_playing_banner_pip").disabled=true;
			document.getElementById("tudou_playing_banner_flash").disabled=true;
			document.getElementById("youku_custom").disabled=true;
			document.getElementById("tudou_custom").disabled=true;
			document.getElementById("youku_promoted_video_ads").disabled=false;
			document.getElementById("m_playing").disabled=true;
			
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			//$("m_searchBanner").style.display = "";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		//(youku_??????phone-web???_?????????banner);(youku_??????ipad-web???_?????????banner)
       if(ad_type == 1425020640 || ad_type == 1427883541){
    	    $("m_searchBanner").style.display = "none";
    	    $("m_playingBanner").style.display = "none";
    	    $("m_homepage").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "";
			$("m_web_video_banner").style.display = "none";
			$("khspreadshowurl").style.display = "none";
			//m_searchBanner
			
			document.getElementById("reserve_shua").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").disabled=true;
			document.getElementById("reserve_lunbo").disabled=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			
			document.getElementById("m_playing").selected=true;
			document.getElementById("youku_playing_banner_pip").disabled=true;
			document.getElementById("youku_playing_banner_flash").disabled=true;
			document.getElementById("youku_playing_custom").disabled=true;
			document.getElementById("tudou_playing_banner_pip").disabled=true;
			document.getElementById("tudou_playing_banner_flash").disabled=true;
			document.getElementById("youku_custom").disabled=true;
			document.getElementById("tudou_custom").disabled=true;
			document.getElementById("youku_promoted_video_ads").disabled=true;
			document.getElementById("m_playing").disabled=false;
			document.getElementById("m_web_video_banner").disabled=true;
			
			document.getElementById("all_channel_div").style.display="";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			//$("m_searchBanner").style.display = "";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		//(??????web?????????banner)
       if(ad_type == 20){
    	    $("m_searchBanner").style.display = "none";
    	    $("m_playingBanner").style.display = "none";
    	    $("m_homepage").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			
			$("m_web_video_banner").style.display = "";
			$("khspreadshowurl").style.display = "none";
			//m_searchBanner
			
			document.getElementById("reserve_shua").disabled=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").disabled=true;
			document.getElementById("reserve_lunbo").selected=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			
			document.getElementById("m_playing").selected=true;
			document.getElementById("youku_playing_banner_pip").disabled=true;
			document.getElementById("youku_playing_banner_flash").disabled=true;
			document.getElementById("youku_playing_custom").disabled=true;
			document.getElementById("tudou_playing_banner_pip").disabled=true;
			document.getElementById("tudou_playing_banner_flash").disabled=true;
			document.getElementById("youku_custom").disabled=true;
			document.getElementById("tudou_custom").disabled=true;
			document.getElementById("youku_promoted_video_ads").disabled=true;
			document.getElementById("m_playing").disabled=true;
			document.getElementById("m_web_home_banner").disabled=false;
			
			
			document.getElementById("all_channel_div").style.display="";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			//$("m_searchBanner").style.display = "";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		if(ad_type == 81){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("pc_biaoban").style.display = "none";

			$("mb_biaoban").style.display = "";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//???????????????
		if(ad_type == 173){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

            //$("otherh5showurl").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//feed???????????????
		if(ad_type == 174){
			//reserve_time
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_lunbo").disabled=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("reserve_shua").disabled=true;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//???????????????
		if(ad_type == 204){
			//reserve_time
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("reserve_shua").disabled=true;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//ott??????????????????
		if(ad_type == 200){
			//reserve_time
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//ott????????????
		if(ad_type == 201){
			//reserve_time
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

            //$("otherh5showurl").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//ott????????????
		if(ad_type == 202){
			//reserve_time
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

            //$("otherh5showurl").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		
		//ott??????????????????
		if(ad_type == 203){
			//reserve_time
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

            //$("otherh5showurl").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			
		}
		//mb???????????????
		if(ad_type == 206){
			//reserve_time
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").selected=true;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			document.getElementById("webview").disabled=false;
			document.getElementById("browser").disabled=false;
			document.getElementById("app_player").disabled=false;
			document.getElementById("app_s").disabled=false;
			document.getElementById("app_d").disabled=false;
			document.getElementById("game_sdk").disabled=false;
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";
			$("mb_focus_circle_pic").style.display = "none";
			$("ott_display").style.display = "none";
			$("ott_poweroff").style.display = "none";
			$("ott_screensaver").style.display = "none";
			$("ott_dis_rec").style.display = "none";
			$("m_isp").style.display = "none";
			$("m_feed").style.display = "none";
			$("m_feedAd").style.display = "none";
			$("mb_biaoban").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_playingBanner").style.display = "none";
			$("m_homepage").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			$("mb_bf").style.display = "";
			$("pc_bf").style.display = "none";
			//$("usehd").style.display = "";

            //$("otherh5showurl").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";			
		}
		
		if(ad_type == 207){
			document.getElementById("reserve_cpm").selected=true;
			document.getElementById("reserve_cpm").disabled=false;
			document.getElementById("reserve_priority").disabled=false;
			document.getElementById("reserve_time").disabled=false;
			document.getElementById("reserve_lunbo").disabled=false;
			document.getElementById("reserve_percent").disabled=false;
			document.getElementById("reserve_cpc").disabled=false;
			document.getElementById("reserve_cpv").disabled=false;
			document.getElementById("reserve_cpp").disabled=false;
			document.getElementById("reserve_shua").disabled=false;
			document.getElementById("all_channel_div").style.display="";
			$("khspreadshowurl").style.display = "none";
			$("all_channel").checked = false;
			$("all_channel").disabled = false;
			$("pc_vf").style.display = "none";
			$("pc_biaoban").style.display = "none";

			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("m_web_video_banner").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vf_buyingbyseeing").style.display = "none";
			$("mb_vf_buyingbyseeing").style.display = "none";
			$("pc_overlay_float").style.display = "none";
			$("pc_seeds").style.display = "none";
			$("mb_overlay_float").style.display = "none";			
			$("mb_focus_circle_pic").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			//$("clickurl").style.display = "";
			$("mb_bf").style.display = "none";
			$("pc_bf").style.display = "";
			//$("usehd").style.display = "";
			//resolution
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";		
		}
		
	}
	
	function show_campaign_div(obj){
		if(obj.checked){
			$("show_campaign_div").style.display = "";
		} else {
			$("show_campaign_div").style.display = "none";
		}
	}
	
	function is_ir_div(obj){
		if(obj.checked){
			$("is_ir_div").style.display = "";

		} else {
			$("is_ir_div").style.display = "none";

		}
	}

	
	function clear_show_campaign(obj){
		if(obj!=''){
			document.getElementById('campaignList_show').options[0].selected=true;
			document.getElementById('campaign_show_name').value="";
			document.getElementById('startDateRow_show').value="";
			document.getElementById('endDateRow_show').value="";
			document.getElementById('campaign_sequence_show').value="";
			document.getElementById('campaign_days_show').value="";
			document.getElementById('campaign_day_limit_show').value="";
			document.getElementById('campaign_num_limit_show').value="";
		}
		
	}
	
	function clear_click_campaign(obj){
		if(obj!=''){
			document.getElementById('campaignList_click').options[0].selected=true;
			document.getElementById('campaign_click_name').value="";
			document.getElementById('startDateRow_click').value="";
			document.getElementById('endDateRow_click').value="";
			document.getElementById('campaign_sequence_click').value="";
			document.getElementById('campaign_days_click').value="";
			document.getElementById('campaign_day_limit_click').value="";
			document.getElementById('campaign_num_limit_click').value="";
		}
		
	}
	
	function clear_over_campaign(obj){
		if(obj!=''){
			document.getElementById('campaignList_over').options[0].selected=true;
			document.getElementById('campaign_over_name').value="";
			document.getElementById('startDateRow_over').value="";
			document.getElementById('endDateRow_over').value="";
			document.getElementById('campaign_sequence_over').value="";
			document.getElementById('campaign_days_over').value="";
			document.getElementById('campaign_day_limit_over').value="";
			document.getElementById('campaign_num_limit_over').value="";
		}
		
	}
	
	function clear_skip_campaign(obj){
		if(obj!=''){
			document.getElementById('campaignList_skip').options[0].selected=true;
			document.getElementById('campaign_skip_name').value="";
			document.getElementById('startDateRow_skip').value="";
			document.getElementById('endDateRow_skip').value="";
			document.getElementById('campaign_sequence_skip').value="";
			document.getElementById('campaign_days_skip').value="";
			document.getElementById('campaign_day_limit_skip').value="";
			document.getElementById('campaign_num_limit_skip').value="";
		}
		
	}
	
	function clear_preload_campaign(obj){
		if(obj!=''){
			document.getElementById('campaignList_preload').options[0].selected=true;
			document.getElementById('campaign_preload_name').value="";
			document.getElementById('startDateRow_preload').value="";
			document.getElementById('endDateRow_preload').value="";
			document.getElementById('campaign_sequence_preload').value="";
			document.getElementById('campaign_days_preload').value="";
			document.getElementById('campaign_day_limit_preload').value="";
			document.getElementById('campaign_num_limit_preload').value="";
		}
		
	}
	
	function show_priority_div(obj){
		if (obj!=''){
			  if(obj=="2"){
			  document.getElementById("priority").style.display="";
			  document.getElementById("total_lun").style.display="none";
			  document.getElementById("percent").style.display="none";
			  }else if(obj=="4"){
			   document.getElementById("total_lun").style.display="";
			   document.getElementById("priority").style.display="none";
			   document.getElementById("percent").style.display="none";
			  }else if(obj=="5"){
				  document.getElementById("percent").style.display="";
				  document.getElementById("priority").style.display="none";
				  document.getElementById("total_lun").style.display="none";
			  }else{
				  document.getElementById("percent").style.display="none";
				  document.getElementById("priority").style.display="none";
				  document.getElementById("total_lun").style.display="none";
			  }
			}else{
			document.getElementById("priority").style.display="none";
			document.getElementById("total_lun").style.display="none";
			}
	}
	
	function hideVhtmlAndVideogroup(obj){
		
		if (obj!=''){
			  if(obj=="1"||obj=="4"){
			  $("vhtml_yt_banner_pip").style.display = "";
			  $("vhtml_yt_banner_flash").style.display = "none";
			  $("vhtml_yt_promoted_video").style.display = "none";
			  $("vhtml_m_playing_page_web").style.display = "none";
			  $("html_youku_custom").style.display = "none";
			  
			  
			  }else if(obj=="2"||obj=="5"){
				  $("vhtml_yt_banner_pip").style.display = "none";
				  $("vhtml_yt_banner_flash").style.display = "";
				  $("vhtml_yt_promoted_video").style.display = "none";
				  $("vhtml_m_playing_page_web").style.display = "none";
				  $("html_youku_custom").style.display = "none";
			  }else if(obj=="8"){
				  $("vhtml_yt_banner_pip").style.display = "none";
				  $("vhtml_yt_banner_flash").style.display = "none";
				  $("vhtml_yt_promoted_video").style.display = "";
				  $("vhtml_m_playing_page_web").style.display = "none";
				  $("html_youku_custom").style.display = "none";
			  }else if(obj=="9"){
				  $("vhtml_yt_banner_pip").style.display = "none";
				  $("vhtml_yt_banner_flash").style.display = "none";
				  $("vhtml_yt_promoted_video").style.display = "none";
				  $("vhtml_m_playing_page_web").style.display = "";
				  $("html_youku_custom").style.display = "none";
				  
			  }else if(obj=="6"){
				  $("vhtml_yt_banner_pip").style.display = "none";
				  $("vhtml_yt_banner_flash").style.display = "none";
				  $("vhtml_yt_promoted_video").style.display = "none";
				  $("vhtml_m_playing_page_web").style.display = "none";
				  $("html_youku_custom").style.display = "";
			  }else{
				  
			  }
			}else{
			document.getElementById("priority").style.display="none";
			document.getElementById("total_lun").style.display="none";
			
			}

	}
	
	function show_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_show");
 
			var strs= new Array(); //??????????????? 
			strs=items.value.split("$"); //???????????? 
			
			document.getElementById("campaign_show_name").value=strs[0];
			document.getElementById("startDateRow_show").value=strs[1];
			document.getElementById("endDateRow_show").value=strs[2];
			
			var strs1= new Array(); //??????????????? 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_show").value="0";
				document.getElementById("campaign_day_limit_show").value="0";
			}else{
				strs1=strs[3].split(";"); //???????????? 
				
				document.getElementById("campaign_days_show").value=strs1[0];
				document.getElementById("campaign_day_limit_show").value=strs1[1];
			}		
			document.getElementById("campaign_num_limit_show").value=strs[4];
			
		}

	}
	
	function click_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_click");
 
			var strs= new Array(); //??????????????? 
			strs=items.value.split("$"); //???????????? 
			
			document.getElementById("campaign_click_name").value=strs[0];
			document.getElementById("startDateRow_click").value=strs[1];
			document.getElementById("endDateRow_click").value=strs[2];
			
			var strs1= new Array(); //??????????????? 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_click").value="0";
				document.getElementById("campaign_day_limit_click").value="0";
			}else{
				strs1=strs[3].split(";"); //???????????? 
				
				document.getElementById("campaign_days_click").value=strs1[0];
				document.getElementById("campaign_day_limit_click").value=strs1[1];
			}			
			document.getElementById("campaign_num_limit_click").value=strs[4];
			
		}

	}
	
	function over_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_over");
 
			var strs= new Array(); //??????????????? 
			strs=items.value.split("$"); //???????????? 
			
			document.getElementById("campaign_over_name").value=strs[0];
			document.getElementById("startDateRow_over").value=strs[1];
			document.getElementById("endDateRow_over").value=strs[2];
			
			var strs1= new Array(); //??????????????? 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_over").value="0";
				document.getElementById("campaign_day_limit_over").value="0";
			}else{
				strs1=strs[3].split(";"); //???????????? 
				
				document.getElementById("campaign_days_over").value=strs1[0];
				document.getElementById("campaign_day_limit_over").value=strs1[1];
			}			
			document.getElementById("campaign_num_limit_over").value=strs[4];
			
		}

	}
	
	function skip_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_skip");
 
			var strs= new Array(); //??????????????? 
			strs=items.value.split("$"); //???????????? 
			
			document.getElementById("campaign_skip_name").value=strs[0];
			document.getElementById("startDateRow_skip").value=strs[1];
			document.getElementById("endDateRow_skip").value=strs[2];
			
			var strs1= new Array(); //??????????????? 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_skip").value="0";
				document.getElementById("campaign_day_limit_skip").value="0";
			}else{
				strs1=strs[3].split(";"); //???????????? 
				
				document.getElementById("campaign_days_skip").value=strs1[0];
				document.getElementById("campaign_day_limit_skip").value=strs1[1];
			}			
			document.getElementById("campaign_num_limit_skip").value=strs[4];
			
		}

	}
	
	function preload_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_preload");
 
			var strs= new Array(); //??????????????? 
			strs=items.value.split("$"); //???????????? 
			
			document.getElementById("campaign_preload_name").value=strs[0];
			document.getElementById("startDateRow_preload").value=strs[1];
			document.getElementById("endDateRow_preload").value=strs[2];
			
			var strs1= new Array(); //??????????????? 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_preload").value="0";
				document.getElementById("campaign_day_limit_preload").value="0";
			}else{
				strs1=strs[3].split(";"); //???????????? 
				
				document.getElementById("campaign_days_preload").value=strs1[0];
				document.getElementById("campaign_day_limit_preload").value=strs1[1];
			}			
			document.getElementById("campaign_num_limit_preload").value=strs[4];
			
		}

	}
	
	//v_position
	function show_v_position_div(obj){
		if(obj.checked){
			$("show_v_position_div").style.display = "";
		} else {
			$("show_v_position_div").style.display = "none";
		}
	}
	
	function show_vo_position_div(obj){
		if(obj.checked){
			$("show_vo_position_div").style.display = "";
		} else {
			$("show_vo_position_div").style.display = "none";
		}
	}
	
	function show_biaoban_position_div(obj){
		if(obj.checked){
			$("show_biaoban_position_div").style.display = "";
		} else {
			$("show_biaoban_position_div").style.display = "none";
		}
	}
	
	function show_jiaobiao_position_div(obj){
		if(obj.checked){
			$("show_jiaobiao_position_div").style.display = "";
		} else {
			$("show_jiaobiao_position_div").style.display = "none";
		}
	}
	
	function show_screensaver_position_div(obj){
		if(obj.checked){
			$("show_ screensaver_position_div").style.display = "";
		} else {
			$("show_ screensaver_position_div").style.display = "none";
		}
	}
	
	function show_disrec_position_div(obj){
		if(obj.checked){
			$("show_ disrec_position_div").style.display = "";
		} else {
			$("show_ disrec_position_div").style.display = "none";
		}
	}
	
	function show_xiami_lunbo_position_div(obj){
		if(obj.checked){
			$("show_xiami_lunbo_position_div").style.display = "";
		} else {
			$("show_xiami_lunbo_position_div").style.display = "none";
		}
	}
	
	function show_bf_position_div(obj){
		if(obj.checked){
			$("show_bf_position_div").style.display = "";
		} else {
			$("show_bf_position_div").style.display = "none";
		}
	}
	
	function show_hs_2_5_a_v_7_div(obj){
		if(obj.checked){
			$("show_hs_2_5_a_v_7_div").style.display = "";
		} else {
			$("show_hs_2_5_a_v_7_div").style.display = "none";
		}
	}
	
	function show_yk_2_5_a_v_7_div(obj){
		if(obj.checked){
			$("show_yk_2_5_a_v_7_div").style.display = "";
		} else {
			$("show_yk_2_5_a_v_7_div").style.display = "none";
		}
	}
	
	function show_os_pc_div(obj){
		if(!obj.checked){
			$("show_pc_div").style.display = "";
		} else {
			$("show_pc_div").style.display = "none";
		}
	}
	
	function click_campaign_div(obj){
		if(obj.checked){
			$("click_campaign_div").style.display = "";
		} else {
			$("click_campaign_div").style.display = "none";
		}
	}
	
	function over_campaign_div(obj){
		if(obj.checked){
			$("over_campaign_div").style.display = "";
		} else {
			$("over_campaign_div").style.display = "none";
		}
	}
	
	function skip_campaign_div(obj){
		if(obj.checked){
			$("skip_campaign_div").style.display = "";
		} else {
			$("skip_campaign_div").style.display = "none";
		}
	}
	
	function preload_campaign_div(obj){
		if(obj.checked){
			$("preload_campaign_div").style.display = "";
		} else {
			$("preload_campaign_div").style.display = "none";
		}
	}

	function show_videogroup_div(obj){
		if(obj.checked){
			$("videogroup_div").style.display = "";
		} else {
			$("videogroup_div").style.display = "none";
		}
	}
	
	function show_keywords_div(obj){
		if(obj.checked){
			$("keywords_div").style.display = "";
		} else {
			$("keywords_div").style.display = "none";
		}
	}
	
	function show_faceoff_div(obj){
		if(obj.checked){
			$("faceoff_div").style.display = "";
		} else {
			$("faceoff_div").style.display = "none";
		}
	}
	
	function show_users_div(obj){
		if(obj.checked){
			$("users_div").style.display = "";
		} else {
			$("users_div").style.display = "none";
		}
	}
	
	function show_deeplink_div(obj){
		if(obj.checked){
			$("deeplink_div").style.display = "";
		} else {
			$("deeplink_div").style.display = "none";
		}
	}
	
	function show_pids_div(obj){
		if(obj.checked){
			$("pids_div").style.display = "";
		} else {
			$("pids_div").style.display = "none";
		}
	}
	
	function show_partnerId_div(obj){
		if(obj.checked){
			$("partnerId_div").style.display = "";
		} else {
			$("partnerId_div").style.display = "none";
		}
	}
	
	function show_parameter_div(obj){
		if(obj.checked){
			$("parameters_div").style.display = "";
		} else {
			$("parameters_div").style.display = "none";
		}
	}
	
	function show_scene_div(obj){
		if(obj.checked){
			$("scene_div").style.display = "";
		} else {
			$("scene_div").style.display = "none";
		}
	}
	
	function show_goods_div(obj){
		if(obj.checked){
			$("goods_div").style.display = "";
		} else {
			$("goods_div").style.display = "none";
		}
	}
	
	function show_tag_div(obj){
		if(obj.checked){
			$("tag_div").style.display = "";
		} else {
			$("tag_div").style.display = "none";
		}
	}
	
	function show_overlayFloat_div(obj){
		if(obj.checked){
			$("overlayfloat_div").style.display = "";
		} else {
			$("overlayfloat_div").style.display = "none";
		}
	}
	
	function show_pressdownfloat_div(obj){
		if(obj.checked){
			$("pressdownfloat_div").style.display = "";
		} else {
			$("pressdownfloat_div").style.display = "none";
		}
	}
	
	function show_deviceFocus_div(obj){
		if(obj.checked){
			$("devicefocus_div").style.display = "";
		} else {
			$("devicefocus_div").style.display = "none";
		}
	}
	
	function disabled_parameters(obj){
		if(obj!=''){
			if(obj =="1"){
				//var obj1 = document.getElementById("parameter_values");
				document.getElementById("time").selected=true;
				document.getElementById("time").disabled=false
				document.getElementById("cannot").disabled=false
				document.getElementById("episode").disabled=false
				document.getElementById("tvb").disabled=true
				document.getElementById("yes").disabled=true
				document.getElementById("no").disabled=true
				document.getElementById("Playgoods").disabled=true
			}else if(obj =="2"){
				document.getElementById("tvb").selected=true;
				document.getElementById("time").disabled=true
				document.getElementById("cannot").disabled=true
				document.getElementById("episode").disabled=true
				document.getElementById("tvb").disabled=false
				document.getElementById("yes").disabled=true
				document.getElementById("no").disabled=true
				document.getElementById("Playgoods").disabled=true
			}else if(obj =="3" || obj == "5"){
				document.getElementById("yes").selected=true;
				document.getElementById("time").disabled=true
				document.getElementById("cannot").disabled=true
				document.getElementById("episode").disabled=true
				document.getElementById("tvb").disabled=true
				document.getElementById("yes").disabled=false
				document.getElementById("no").disabled=false
				document.getElementById("Playgoods").disabled=true
			}else if(obj =="4"){
				document.getElementById("Playgoods").selected=true;
				document.getElementById("time").disabled=true
				document.getElementById("cannot").disabled=true
				document.getElementById("episode").disabled=true
				document.getElementById("tvb").disabled=true
				document.getElementById("yes").disabled=true
				document.getElementById("no").disabled=true
				document.getElementById("Playgoods").disabled=false
			}else if(obj == "12"){
				
				document.getElementById("isp_cmcc").selected=true;
				document.getElementById("time").disabled=true
				document.getElementById("cannot").disabled=true
				document.getElementById("episode").disabled=true
				document.getElementById("tvb").disabled=true
				document.getElementById("yes").disabled=true
				document.getElementById("no").disabled=true
				document.getElementById("Playgoods").disabled=true
				document.getElementById("temperature").disabled=true
				document.getElementById("Unicast_len").disabled=true
				document.getElementById("Unicast").disabled=true
				document.getElementById("screensize1").disabled=true
				document.getElementById("screensize2").disabled=true
				document.getElementById("programmeid").disabled=true
				document.getElementById("childrenchannelkey1").disabled=true
				document.getElementById("childrenchannelkey2").disabled=true
				document.getElementById("childrenchannelkey3").disabled=true
				document.getElementById("isp_cmcc").disabled=false
				document.getElementById("isp_ctcc").disabled=false
				document.getElementById("isp_cucc").disabled=false
				
			}
		}
	}
	
	function sow_type_selected(obj){
		if(obj!=''){
			if(obj =="0"){
				$("sow_rate_setting").style.display = "none";
				$("sow_threshold_setting").style.display = "none";
			}else if(obj =="1"){
				$("sow_rate_setting").style.display = "";
				$("sow_threshold_setting").style.display = "none";
			}else{
				$("sow_rate_setting").style.display = "none";
				$("sow_threshold_setting").style.display = "";
			}
		}
	}
	
	function ir_type_selected(obj){
		if(obj!=''){
			if(obj =="0"){
				document.getElementById("dsp_info").disabled = false;
				document.getElementById("clientDSPpushurl_text").disabled = false;
				document.getElementById("otherDSPpushurl_text").disabled = false;
			}else{
				document.getElementById("dsp_info").disabled = true;
				document.getElementById("clientDSPpushurl_text").disabled = true;
				document.getElementById("otherDSPpushurl_text").disabled = true;
			}
		}
	}
	
	function check_resolution_hd2()
	{
		document.getElementById("resolution_hd2").checked=true
		}
	function check_resolution_hd2_broadcasting(){
		//resolution_hd2_broadcasting
		document.getElementById("resolution_hd2_broadcasting1").checked=false
		document.getElementById("resolution_hd2_broadcasting2").checked=false
		document.getElementById("resolution_hd2_broadcasting3").checked=false
		
	}
	
	function check_resolution_mp4()
	{
		//resolution_mp4_1_broadcasting1
		document.getElementById("resolution_mp4").checked=true
		}
	function check_resolution_mp4_broadcasting(){
		//resolution_hd2_broadcasting
		document.getElementById("resolution_mp4_1_broadcasting1").checked=false
		document.getElementById("resolution_mp4_2_broadcasting2").checked=false
		document.getElementById("resolution_mp4_3_broadcasting3").checked=false
		
	}
	
	function check_resolution_flv()
	{
		document.getElementById("resolution_flv").checked=true
		}
	//check_resolution_flv_broadcasting
	function check_resolution_flv_broadcasting(){
		//resolution_hd2_broadcasting
		document.getElementById("resolution_flv1_broadcasting1").checked=false
		document.getElementById("resolution_flv2_broadcasting2").checked=false
		document.getElementById("resolution_flv3_broadcasting3").checked=false
		
	}
	
//	function show_millwardbrown_div(obj){
//		var div = $("millwardbrown_div");

//		if(obj == 1){
//			div.innerHTML = " <br>?????????????????????<input type='text' name='millwardbrown_entryname' value='millwardbrown' size='60'/> <br><br>?????????Millwardbrown???????????????<input type='text' name='millwardbrown_expose_y_url' value='http://atm.youku.com/test-youkuexposevc' size='60'/> <br><br>?????????Millwardbrown???????????????<input type='text' name='millwardbrown_expose_t_url' value='http://atm.youku.com/test-tudouexposevc' size='60'/> <br><br>???????????????????????????<input type='text' name='millwardbrown_click_url' value='http://atm.youku.com/test-millwardbrown_click_url' size='60'/>";
//			div.style.display = "";
//		} else if(obj == 2){
//			div.innerHTML = " <br>?????????Millwardbrown???????????????<input type='text' name='millwardbrown_control_y_url' value='http://atm.youku.com/test-youkucontrolvc' size='60'/> <br><br>?????????Millwardbrown???????????????<input type='text' name='millwardbrown_control_t_url' value='http://atm.youku.com/test-tudoucontrolvc' size='60'/>";
//			div.style.display = "";
//		} else {
//			$("millwardbrown_div").style.display = "none";
//		}
//	}

    function show_millwardbrown_div(obj){
		if (obj!=''){
			  if(obj=="1"){
			  document.getElementById("youku_survey_url").style.display="";
			  document.getElementById("tudou_survey_url").style.display="";

			  }else if(obj=="2"){
				  document.getElementById("youku_survey_url").style.display="";
				  document.getElementById("tudou_survey_url").style.display="";
			  }else{
				  document.getElementById("youku_survey_url").style.display="none";
				  document.getElementById("tudou_survey_url").style.display="none";
			  }
			}else{
				  document.getElementById("youku_survey_url").style.display="none";
				  document.getElementById("tudou_survey_url").style.display="none";
			}
	}
    
    function show_millwardbrown_div_app(obj){
		if (obj!=''){
			  if(obj=="1"){
			  document.getElementById("survey_show_url").style.display="";
			  document.getElementById("survey_click_url").style.display="";
			  document.getElementById("survey_entry_text").style.display="";

			  }else if(obj=="2"){
				  document.getElementById("survey_show_url").style.display="";
				  document.getElementById("survey_click_url").style.display="";
				  document.getElementById("survey_entry_text").style.display="";
			  }else{
				  document.getElementById("survey_show_url").style.display="none";
				  document.getElementById("survey_click_url").style.display="none";
				  document.getElementById("survey_entry_text").style.display="none";
			  }
			}else{
				  document.getElementById("survey_show_url").style.display="none";
				  document.getElementById("survey_click_url").style.display="none";
				  document.getElementById("survey_entry_text").style.display="none";
			}
	}
    //hidden_customtext_url_clientcustomclick_url(this.value)
    function hidden_customtext_url_clientcustomclick_url(obj){
    	if(obj!=''){
    		if(obj=="?????????"){
    			document.getElementById("customtext_url").disabled=true;
    			document.getElementById("clientcustomclick_url").disabled=true;
    		}else{
    			document.getElementById("customtext_url").disabled=false;
    			document.getElementById("clientcustomclick_url").disabled=false;
    		}
    		}

    }

	function setChannelChecked(item,checked,type){
		var cancheck = false;
		if(item.title=="youku"&&type==1){
			cancheck = true;
		}
		if(item.title=="tudou"&&type==2){
			cancheck = true;
		}
				
		if(cancheck){
			item.checked = checked;
		}
	}
	
	function setOsChecked(item,checked,type){
		var cancheck = false;
		if(item.title=="youku"&&type==1){
			cancheck = true;
		}
		if(item.title=="tudou"&&type==2){
			cancheck = true;
		}
				
		if(cancheck){
			item.checked = checked;
		}
	}
	function show_channel_div(obj,type){
		if(!obj.checked){
			$("channel_div").style.display = "";
			$("yk_all_channel").style.display = "";
			$("td_all_channel").style.display = "";
			$("youku_yk_zw").style.display = "";
			$("tudou_td_zw").style.display = "";
			$("youku_yk_zn").style.display = "";
			$("tudou_td_zn").style.display = "";
			$("xy").style.display = "";
			$("xiami").style.display = "";
			if(type==0){
				document.getElementsByName("yk_all_channel")[0].checked=false;
				document.getElementsByName("td_all_channel")[0].checked=false;
				document.getElementsByName("youku_yk_zw")[0].checked=false;
				document.getElementsByName("tudou_td_zw")[0].checked=false;
				document.getElementsByName("youku_yk_zn")[0].checked=false;
				document.getElementsByName("tudou_td_zn")[0].checked=false;
				document.getElementsByName("xy")[0].checked=false;
				document.getElementsByName("xiami")[0].checked=false;
			}
			var items = document.getElementsByName("chk_channel");
			
			for(i = 0; i < items.length; i++){
				setChannelChecked(items[i],false,type);
			}
		} else {
			if(type==0){
				$("channel_div").style.display = "none";
				$("yk_all_channel").style.display = "none";
				$("td_all_channel").style.display = "none";
				$("youku_yk_zw").style.display = "none";
				$("tudou_td_zw").style.display = "none";
				$("youku_yk_zn").style.display = "none";
				$("tudou_td_zn").style.display = "none";
				$("xy").style.display = "none";
				$("xiami").style.display = "none";
				document.getElementsByName("yk_all_channel")[0].checked=false;
				document.getElementsByName("td_all_channel")[0].checked=false;
				document.getElementsByName("youku_yk_zw")[0].checked=false;
				document.getElementsByName("tudou_td_zw")[0].checked=false;
				document.getElementsByName("youku_yk_zn")[0].checked=false;
				document.getElementsByName("tudou_td_zn")[0].checked=false;
				document.getElementsByName("xy")[0].checked=false;
				document.getElementsByName("xiami")[0].checked=false;
			}

			var items = document.getElementsByName("chk_channel");
			
			for(i = 0; i < items.length; i++){
				if(type==0){
					items[i].checked = false;
					continue;
				}
				setChannelChecked(items[i],true,type);
			}
		}
	}
	
	function show_area_div(obj){
		
		if(!obj.checked){
			$("area_div").style.display = "";
		}else{
			$("area_div").style.display = "none";
		}
	}
	function tiepian_m(obj,type){
		if(type == 0){
			$("outtime").style.display = "";
			var trs = document.getElementsByClassName("h5_idea_phone");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			//h5_vf_showtime
			var trss1 = document.getElementsByClassName("h5_vf_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("qiantie_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			var trss2 = document.getElementsByClassName("h5_hvideo_1");
			for(i=0;i<trss2.length;i++){
				trss2[i].style.display = "none";
			}
			
			var trss3 = document.getElementsByClassName("h5_hvideo_2");
			for(i=0;i<trss3.length;i++){
				trss3[i].style.display = "none";
			}
			
			var trss4 = document.getElementsByClassName("Phone-H5");
			for(i=0;i<trss4.length;i++){
				trss4[i].style.display = "none";
			}
			
			var trss5 = document.getElementsByClassName("Pad-H5");
			for(i=0;i<trss5.length;i++){
				trss5[i].style.display = "none";
			}
			
			var trss6 = document.getElementsByClassName("main_h5_mf_url_t");
			for(i=0;i<trss6.length;i++){
				trss6[i].style.display = "none";
			}
			
			var trss7 = document.getElementsByClassName("h5_mf_url_t1");
			for(i=0;i<trss7.length;i++){
				trss7[i].style.display = "none";
			}
			
			var trss8 = document.getElementsByClassName("h5_mf_url_t2");
			for(i=0;i<trss8.length;i++){
				trss8[i].style.display = "none";
			}
			
			var trss9 = document.getElementsByClassName("mf_url_onebuy_type");
			for(i=0;i<trss9.length;i++){
				trss9[i].style.display = "none";
			}
			
			var trss10 = document.getElementsByClassName("mf_goodid");
			for(i=0;i<trss10.length;i++){
				trss10[i].style.display = "none";
			}
			
			var trss11 = document.getElementsByClassName("mf_taobaoerid");
			for(i=0;i<trss11.length;i++){
				trss11[i].style.display = "none";
			}
			
			var trss12 = document.getElementsByClassName("mf_onebuy_h5");
			for(i=0;i<trss12.length;i++){
				trss12[i].style.display = "none";
			}
			
			var trss13 = document.getElementsByClassName("ott_onebuy_png");
			for(i=0;i<trss13.length;i++){
				trss13[i].style.display = "none";
			}
			
			var trss14 = document.getElementsByClassName("mf_onebuy_h5_width_height");
			for(i=0;i<trss14.length;i++){
				trss14[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			//$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";			
			$("onebuyurl").style.display = "none";
			
		} else if(type == 1){
			$("outtime").style.display = "";	
			var trs = document.getElementsByClassName("h5_idea_phone");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "";
			}
			
			var trss1 = document.getElementsByClassName("h5_vf_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("qiantie_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			var trss2 = document.getElementsByClassName("h5_hvideo_1");
			for(i=0;i<trss2.length;i++){
				trss2[i].style.display = "";
			}
			
			var trss3 = document.getElementsByClassName("h5_hvideo_2");
			for(i=0;i<trss3.length;i++){
				trss3[i].style.display = "";
			}
			
			var trss4 = document.getElementsByClassName("Phone-H5");
			for(i=0;i<trss4.length;i++){
				trss4[i].style.display = "";
			}
			
			var trss5 = document.getElementsByClassName("Pad-H5");
			for(i=0;i<trss5.length;i++){
				trss5[i].style.display = "";
			}
			
			var trss6 = document.getElementsByClassName("main_h5_mf_url_t");
			for(i=0;i<trss6.length;i++){
				trss6[i].style.display = "";
			}
			
			var trss7 = document.getElementsByClassName("h5_mf_url_t1");
			for(i=0;i<trss7.length;i++){
				trss7[i].style.display = "";
			}
			
			var trss8 = document.getElementsByClassName("h5_mf_url_t2");
			for(i=0;i<trss8.length;i++){
				trss8[i].style.display = "";
			}
			
			var trss9 = document.getElementsByClassName("mf_url_onebuy_type");
			for(i=0;i<trss9.length;i++){
				trss9[i].style.display = "none";
			}
			
			var trss10 = document.getElementsByClassName("mf_goodid");
			for(i=0;i<trss10.length;i++){
				trss10[i].style.display = "none";
			}
			
			var trss11 = document.getElementsByClassName("mf_taobaoerid");
			for(i=0;i<trss11.length;i++){
				trss11[i].style.display = "none";
			}
			
			var trss12 = document.getElementsByClassName("mf_onebuy_h5");
			for(i=0;i<trss12.length;i++){
				trss12[i].style.display = "none";
			}
			
			var trss13 = document.getElementsByClassName("ott_onebuy_png");
			for(i=0;i<trss13.length;i++){
				trss13[i].style.display = "none";
			}
			var trss14 = document.getElementsByClassName("mf_onebuy_h5_width_height");
			for(i=0;i<trss14.length;i++){
				trss14[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
			$("onebuyurl").style.display = "none";
			
		}else if(type == 2) {
			$("outtime").style.display = "";	
			var trs = document.getElementsByClassName("h5_idea_phone");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("qiantie_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss1 = document.getElementsByClassName("h5_vf_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss2 = document.getElementsByClassName("h5_hvideo_1");
			for(i=0;i<trss2.length;i++){
				trss2[i].style.display = "none";
			}
			
			var trss3 = document.getElementsByClassName("h5_hvideo_2");
			for(i=0;i<trss3.length;i++){
				trss3[i].style.display = "none";
			}
			
			var trss4 = document.getElementsByClassName("Phone-H5");
			for(i=0;i<trss4.length;i++){
				trss4[i].style.display = "none";
			}
			
			var trss5 = document.getElementsByClassName("Pad-H5");
			for(i=0;i<trss5.length;i++){
				trss5[i].style.display = "none";
			}
			
			var trss6 = document.getElementsByClassName("main_h5_mf_url_t");
			for(i=0;i<trss6.length;i++){
				trss6[i].style.display = "none";
			}
			
			var trss7 = document.getElementsByClassName("h5_mf_url_t1");
			for(i=0;i<trss7.length;i++){
				trss7[i].style.display = "none";
			}
			
			var trss8 = document.getElementsByClassName("h5_mf_url_t2");
			for(i=0;i<trss8.length;i++){
				trss8[i].style.display = "none";
			}
			
			var trss9 = document.getElementsByClassName("mf_url_onebuy_type");
			for(i=0;i<trss9.length;i++){
				trss9[i].style.display = "none";
			}
			
			var trss10 = document.getElementsByClassName("mf_goodid");
			for(i=0;i<trss10.length;i++){
				trss10[i].style.display = "none";
			}
			
			var trss11 = document.getElementsByClassName("mf_taobaoerid");
			for(i=0;i<trss11.length;i++){
				trss11[i].style.display = "none";
			}
			
			var trss12 = document.getElementsByClassName("mf_onebuy_h5");
			for(i=0;i<trss12.length;i++){
				trss12[i].style.display = "none";
			}
			
			var trss13 = document.getElementsByClassName("ott_onebuy_png");
			for(i=0;i<trss13.length;i++){
				trss13[i].style.display = "none";
			}
			var trss14 = document.getElementsByClassName("mf_onebuy_h5_width_height");
			for(i=0;i<trss14.length;i++){
				trss14[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "";
			$("clientcustomclickurl").style.display = "";
			$("clientskipurl").style.display = "";
			$("clientfeeurl").style.display = "";
			$("othercustomtextclickurl").style.display = "";
			$("otherskipurl").style.display = "";
			$("otherfeepurl").style.display = "";
			$("chargingthreshold").style.display = "";
			$("skiptimethreshold").style.display = "";
			$("outtime").style.display = "none";			
			$("khplayingurl").style.display = "none";			
			$("clientplayovertime").style.display = "";
			$("onebuyurl").style.display = "none";
		}else{
			
			$("outtime").style.display = "";
			var trs = document.getElementsByClassName("h5_idea_phone");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			//h5_vf_showtime
			var trss1 = document.getElementsByClassName("h5_vf_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("qiantie_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			var trss2 = document.getElementsByClassName("h5_hvideo_1");
			for(i=0;i<trss2.length;i++){
				trss2[i].style.display = "none";
			}
			
			var trss3 = document.getElementsByClassName("h5_hvideo_2");
			for(i=0;i<trss3.length;i++){
				trss3[i].style.display = "none";
			}
			
			var trss4 = document.getElementsByClassName("Phone-H5");
			for(i=0;i<trss4.length;i++){
				trss4[i].style.display = "none";
			}
			
			var trss5 = document.getElementsByClassName("Pad-H5");
			for(i=0;i<trss5.length;i++){
				trss5[i].style.display = "none";
			}
			
			var trss6 = document.getElementsByClassName("main_h5_mf_url_t");
			for(i=0;i<trss6.length;i++){
				trss6[i].style.display = "none";
			}
			
			var trss7 = document.getElementsByClassName("h5_mf_url_t1");
			for(i=0;i<trss7.length;i++){
				trss7[i].style.display = "none";
			}
			
			var trss8 = document.getElementsByClassName("h5_mf_url_t2");
			for(i=0;i<trss8.length;i++){
				trss8[i].style.display = "none";
			}
			
			var trss9 = document.getElementsByClassName("mf_url_onebuy_type");
			for(i=0;i<trss9.length;i++){
				trss9[i].style.display = "";
			}
			
			var trss10 = document.getElementsByClassName("mf_goodid");
			for(i=0;i<trss10.length;i++){
				trss10[i].style.display = "";
			}
			
			var trss11 = document.getElementsByClassName("mf_taobaoerid");
			for(i=0;i<trss11.length;i++){
				trss11[i].style.display = "";
			}
			
			var trss12 = document.getElementsByClassName("mf_onebuy_h5");
			for(i=0;i<trss12.length;i++){
				trss12[i].style.display = "";
			}
			
			var trss13 = document.getElementsByClassName("ott_onebuy_png");
			for(i=0;i<trss13.length;i++){
				trss13[i].style.display = "";
			}
			
			var trss14 = document.getElementsByClassName("mf_onebuy_h5_width_height");
			for(i=0;i<trss14.length;i++){
				trss14[i].style.display = "";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			//$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
			$("onebuyurl").style.display = "";
			
		}
	}
	
	function tiepian_mb(obj,type){
		if(type == 0){
			$("outtime").style.display = "";
			var trs = document.getElementsByClassName("h5_idea_phone_mb");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mb");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			//h5_vb_showtime
			var trss1 = document.getElementsByClassName("h5_vb_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("houtie_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			//$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
			
		} else if(type == 1){
			$("outtime").style.display = "";	
			var trs = document.getElementsByClassName("h5_idea_phone_mb");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mb");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "";
			}
			
			var trss1 = document.getElementsByClassName("h5_vb_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("houtie_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
			
		}else{
			$("outtime").style.display = "";	
			var trs = document.getElementsByClassName("h5_idea_phone_mb");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mb");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			var trss1 = document.getElementsByClassName("h5_vb_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("houtie_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			$("customtexturl").style.display = "";
			$("clientcustomclickurl").style.display = "";
			$("clientskipurl").style.display = "";
			$("clientfeeurl").style.display = "";
			$("othercustomtextclickurl").style.display = "";
			$("otherskipurl").style.display = "";
			$("otherfeepurl").style.display = "";
			$("chargingthreshold").style.display = "";
			$("skiptimethreshold").style.display = "";
			$("outtime").style.display = "none";			
			$("khplayingurl").style.display = "none";			
			$("clientplayovertime").style.display = "";
		}
	}
	
	function tiepian_mo(obj,type){
		if(type == 0){
			$("outtime").style.display = "";
			var trs = document.getElementsByClassName("h5_idea_phone_mo");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mo");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			//h5_vo_showtime
			var trss1 = document.getElementsByClassName("h5_vo_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("zhongcha_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			//$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
			
		} else if(type == 1){
			$("outtime").style.display = "";	
			var trs = document.getElementsByClassName("h5_idea_phone_mo");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mo");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "";
			}
			
			var trss1 = document.getElementsByClassName("h5_vo_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("zhongcha_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
			
		}else{
			$("outtime").style.display = "";	
			var trs = document.getElementsByClassName("h5_idea_phone_mo");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mo");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			var trss1 = document.getElementsByClassName("h5_vo_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("zhongcha_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			$("customtexturl").style.display = "";
			$("clientcustomclickurl").style.display = "";
			$("clientskipurl").style.display = "";
			$("clientfeeurl").style.display = "";
			$("othercustomtextclickurl").style.display = "";
			$("otherskipurl").style.display = "";
			$("otherfeepurl").style.display = "";
			$("chargingthreshold").style.display = "";
			$("skiptimethreshold").style.display = "";
			$("outtime").style.display = "none";			
			$("khplayingurl").style.display = "none";			
			$("clientplayovertime").style.display = "";
		}
	}
	
	function tiepian_mtp(obj,type){
		if(type == 0){
			$("outtime").style.display = "";
			var trs = document.getElementsByClassName("h5_idea_phone_mtp");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mtp");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			//h5_vtp_showtime
			var trss1 = document.getElementsByClassName("h5_vtp_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("tiepian_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			//$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
			
		} else if(type == 1){
			$("outtime").style.display = "";	
			var trs = document.getElementsByClassName("h5_idea_phone_mtp");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mtp");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "";
			}
			
			var trss1 = document.getElementsByClassName("h5_vtp_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("zhongcha_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
			
			
		}else{
			$("outtime").style.display = "";	
			var trs = document.getElementsByClassName("h5_idea_phone_mtp");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			
			var trsss = document.getElementsByClassName("h5_idea_pad_mtp");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			
			var trss1 = document.getElementsByClassName("h5_vtp_showtime");
			for(i=0;i<trss1.length;i++){
				trss1[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("zhongcha_idea");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			
			$("customtexturl").style.display = "";
			$("clientcustomclickurl").style.display = "";
			$("clientskipurl").style.display = "";
			$("clientfeeurl").style.display = "";
			$("othercustomtextclickurl").style.display = "";
			$("otherskipurl").style.display = "";
			$("otherfeepurl").style.display = "";
			$("chargingthreshold").style.display = "";
			$("skiptimethreshold").style.display = "";
			$("outtime").style.display = "none";			
			$("khplayingurl").style.display = "none";			
			$("clientplayovertime").style.display = "";
		}
	}
	
	function app_search_banner(type){
		if(type == 1){
			var tr1 = document.getElementsByClassName("app_search_banner_youkupip_url");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "";
			}
			var tr2 = document.getElementsByClassName("app_search_banner_youkupip_clickurl");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "";
			}
			var tr3 = document.getElementsByClassName("app_search_banner_youkupip_showurl");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "";
			}
			var tr4 = document.getElementsByClassName("app_search_banner_tudoupip_url");
			for(i=0;i<tr4.length;i++){
				tr4[i].style.display = "";
			}
			var tr5 = document.getElementsByClassName("app_search_banner_tudoupip_clickurl");
			for(i=0;i<tr5.length;i++){
				tr5[i].style.display = "";
			}
			var tr6 = document.getElementsByClassName("app_search_banner_tudoupip_showurl");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "";
			}
		}else{
			var tr1 = document.getElementsByClassName("app_search_banner_youkupip_url");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "none";
			}
			var tr2 = document.getElementsByClassName("app_search_banner_youkupip_clickurl");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "none";
			}
			var tr3 = document.getElementsByClassName("app_search_banner_youkupip_showurl");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "none";
			}
			var tr4 = document.getElementsByClassName("app_search_banner_tudoupip_url");
			for(i=0;i<tr4.length;i++){
				tr4[i].style.display = "none";
			}
			var tr5 = document.getElementsByClassName("app_search_banner_tudoupip_clickurl");
			for(i=0;i<tr5.length;i++){
				tr5[i].style.display = "none";
			}
			var tr6 = document.getElementsByClassName("app_search_banner_tudoupip_showurl");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "none";
			}
		}
	}
	
	function app_feedAd(type){
		if(type == 1){
			var tr1 = document.getElementsByClassName("m_feedAd_png_url_750_350");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "";
			}
			var tr6 = document.getElementsByClassName("m_feedAd_png_url_750_280");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "";
			}
			var tr2 = document.getElementsByClassName("m_feedAd_prompt");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "";
			}
			var tr3 = document.getElementsByClassName("m_feedAd_video_thumbnail");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "none";
			}
			var tr4 = document.getElementsByClassName("m_feedAd_video_url");
			for(i=0;i<tr4.length;i++){
				tr4[i].style.display = "none";
			}
			var tr5 = document.getElementsByClassName("m_feedAd_length");
			for(i=0;i<tr5.length;i++){
				tr5[i].style.display = "none";
			}
			var tr6 = document.getElementsByClassName("m_feedAd_brandlogo");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "";
			}
			
			var tr7 = document.getElementsByClassName("m_feedAd_normal_pos");
			for(i=0;i<tr7.length;i++){
				tr7[i].style.display = "";
			}				

		}else{
			var tr1 = document.getElementsByClassName("m_feedAd_png_url_750_350");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "none";
			}
			var tr6 = document.getElementsByClassName("m_feedAd_png_url_750_280");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "none";
			}
			var tr2 = document.getElementsByClassName("m_feedAd_prompt");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "";
			}
			var tr3 = document.getElementsByClassName("m_feedAd_video_thumbnail");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "";
			}
			var tr4 = document.getElementsByClassName("m_feedAd_video_url");
			for(i=0;i<tr4.length;i++){
				tr4[i].style.display = "";
			}
			var tr5 = document.getElementsByClassName("m_feedAd_length");
			for(i=0;i<tr5.length;i++){
				tr5[i].style.display = "";
			}
			
			var tr6 = document.getElementsByClassName("m_feedAd_brandlogo");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "";
			}
			var tr7 = document.getElementsByClassName("m_feedAd_normal_pos");
			for(i=0;i<tr7.length;i++){
				tr7[i].style.display = "";
			}		
		}
		var tr8 = document.getElementsByClassName("m_feedAd_png_url_spotlight");
		for(i=0;i<tr8.length;i++){
			tr8[i].style.display = "none";
		}
		
		var tr9 = document.getElementsByClassName("m_feedAd_video_url_spotlight");
		for(i=0;i<tr9.length;i++){
			tr9[i].style.display = "none";
		}
		
		var tr10 = document.getElementsByClassName("m_feedAd_addescript_spotlight");
		for(i=0;i<tr10.length;i++){
			tr10[i].style.display = "none";
		}
		
		var tr11 = document.getElementsByClassName("m_feedAd_prompt_spotlight");
		for(i=0;i<tr11.length;i++){
			tr11[i].style.display = "none";
		}
		
		var tr12 = document.getElementsByClassName("m_feedAd_adname_spotlight");
		for(i=0;i<tr12.length;i++){
			tr12[i].style.display = "none";
		}
		
		var tr13 = document.getElementsByClassName("m_feedAd_spotlight_pos");
		for(i=0;i<tr13.length;i++){
			tr13[i].style.display = "none";
		}
		
		var tr14 = document.getElementsByClassName("m_feedAd_video_url_spotlight");
		for(i=0;i<tr14.length;i++){
			tr14[i].style.display = "none";
		}
		
		var tr15 = document.getElementsByClassName("m_feedAd_thumbnail_url_spotlight");
		for(i=0;i<tr15.length;i++){
			tr15[i].style.display = "none";
		}
		
	}
	
	function app_feedAd_overall(type){
		if(type == 1){
			var tr1 = document.getElementsByClassName("m_feedAd_png_url_750_350");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "";
			}
			var tr6 = document.getElementsByClassName("m_feedAd_png_url_750_280");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "";
			}
			var tr2 = document.getElementsByClassName("m_feedAd_prompt");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "";
			}
			var tr3 = document.getElementsByClassName("m_feedAd_video_thumbnail");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "none";
			}
			var tr4 = document.getElementsByClassName("m_feedAd_video_url");
			for(i=0;i<tr4.length;i++){
				tr4[i].style.display = "none";
			}
			var tr5 = document.getElementsByClassName("m_feedAd_length");
			for(i=0;i<tr5.length;i++){
				tr5[i].style.display = "none";
			}
			var tr6 = document.getElementsByClassName("m_feedAd_brandlogo");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "";
			}
			
			var tr7 = document.getElementsByClassName("m_feedAd_video_normal");
			for(i=0;i<tr7.length;i++){
				tr7[i].style.display = "";
			}
			
			var tr8 = document.getElementsByClassName("m_feedAd_normal_pos");
			for(i=0;i<tr8.length;i++){
				tr8[i].style.display = "";
			}
			
			var tr9 = document.getElementsByClassName("m_feedAd_png_url_spotlight");
			for(i=0;i<tr9.length;i++){
				tr9[i].style.display = "none";
			}
			
			var tr10 = document.getElementsByClassName("m_feedAd_brandlogo_spotlight");
			for(i=0;i<tr10.length;i++){
				tr10[i].style.display = "none";
			}
			
			var tr11 = document.getElementsByClassName("m_feedAd_addescript_spotlight");
			for(i=0;i<tr11.length;i++){
				tr11[i].style.display = "none";
			}
			
			var tr12 = document.getElementsByClassName("m_feedAd_prompt_spotlight");
			for(i=0;i<tr12.length;i++){
				tr12[i].style.display = "none";
			}
			
			var tr13 = document.getElementsByClassName("m_feedAd_adname_spotlight");
			for(i=0;i<tr13.length;i++){
				tr13[i].style.display = "none";
			}
			
			
			var tr14 = document.getElementsByClassName("m_feedAd_spotlight_pos");
			for(i=0;i<tr14.length;i++){
				tr14[i].style.display = "none";
			}
			
			var tr15 = document.getElementsByClassName("m_feedAd_video_url_spotlight");
			for(i=0;i<tr15.length;i++){
				tr15[i].style.display = "none";
			}
			
			var tr16 = document.getElementsByClassName("m_feedAd_thumbnail_url_spotlight");
			for(i=0;i<tr16.length;i++){
				tr16[i].style.display = "none";
			}
			
			var tr17 = document.getElementsByClassName("m_feedAd_video_kandian");
			for(i=0;i<tr17.length;i++){
				tr17[i].style.display = "none";
			}

		}else{
			var tr1 = document.getElementsByClassName("m_feedAd_png_url_750_350");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "none";
			}
			var tr6 = document.getElementsByClassName("m_feedAd_png_url_750_280");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "none";
			}
			var tr2 = document.getElementsByClassName("m_feedAd_prompt");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "none";
			}
			var tr3 = document.getElementsByClassName("m_feedAd_video_thumbnail");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "none";
			}
			var tr4 = document.getElementsByClassName("m_feedAd_video_url");
			for(i=0;i<tr4.length;i++){
				tr4[i].style.display = "none";
			}
			var tr5 = document.getElementsByClassName("m_feedAd_length");
			for(i=0;i<tr5.length;i++){
				tr5[i].style.display = "none";
			}
			
			var tr6 = document.getElementsByClassName("m_feedAd_brandlogo");
			for(i=0;i<tr6.length;i++){
				tr6[i].style.display = "none";
			}
			
			var tr7 = document.getElementsByClassName("m_feedAd_video_normal");
			for(i=0;i<tr7.length;i++){
				tr7[i].style.display = "none";
			}
			
			var tr8 = document.getElementsByClassName("m_feedAd_normal_pos");
			for(i=0;i<tr8.length;i++){
				tr8[i].style.display = "none";
			}
			
			var tr9 = document.getElementsByClassName("m_feedAd_png_url_spotlight");
			for(i=0;i<tr9.length;i++){
				tr9[i].style.display = "";
			}
			
			var tr10 = document.getElementsByClassName("m_feedAd_brandlogo_spotlight");
			for(i=0;i<tr10.length;i++){
				tr10[i].style.display = "";
			}
			
			var tr11 = document.getElementsByClassName("m_feedAd_addescript_spotlight");
			for(i=0;i<tr11.length;i++){
				tr11[i].style.display = "";
			}
			
			var tr12 = document.getElementsByClassName("m_feedAd_prompt_spotlight");
			for(i=0;i<tr12.length;i++){
				tr12[i].style.display = "";
			}
			
			var tr13 = document.getElementsByClassName("m_feedAd_adname_spotlight");
			for(i=0;i<tr13.length;i++){
				tr13[i].style.display = "";
			}
			
			var tr14 = document.getElementsByClassName("m_feedAd_spotlight_pos");
			for(i=0;i<tr14.length;i++){
				tr14[i].style.display = "";
			}
			
			var tr15 = document.getElementsByClassName("m_feedAd_video_url_spotlight");
			for(i=0;i<tr15.length;i++){
				tr15[i].style.display = "";
			}
			
			var tr16 = document.getElementsByClassName("m_feedAd_thumbnail_url_spotlight");
			for(i=0;i<tr16.length;i++){
				tr16[i].style.display = "";
			}
			
			var tr17 = document.getElementsByClassName("m_feedAd_video_kandian");
			for(i=0;i<tr17.length;i++){
				tr17[i].style.display = "";
			}
			
		}
	}
	
	function app_playing_banner(type){
		if(type == 1){
			var tr1 = document.getElementsByClassName("app_playing_banner_url");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "";
			}
			var tr2 = document.getElementsByClassName("app_playing_banner_clickurl");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "";
			}
			var tr3 = document.getElementsByClassName("app_playing_banner_showurl");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "";
			}
			var tr4 = document.getElementsByClassName("app_playing_banner_clickmonitor_url");
			for(i=0;i<tr4.length;i++){
				tr4[i].style.display = "";
			}
		}else{
			var tr1 = document.getElementsByClassName("app_playing_banner_url");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "none";
			}
			var tr2 = document.getElementsByClassName("app_playing_banner_clickurl");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "none";
			}
			var tr3 = document.getElementsByClassName("app_playing_banner_showurl");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "none";
			}
			var tr4 = document.getElementsByClassName("app_playing_banner_clickmonitor_url");
			for(i=0;i<tr4.length;i++){
				tr4[i].style.display = "none";
			}

		}
	}
	
	function app_homepage(type){
		if(type == 1){
			var tr1 = document.getElementsByClassName("app_homepage_url");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "";
			}
			var tr2 = document.getElementsByClassName("app_homepage_clickurl");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "";
			}
			var tr3 = document.getElementsByClassName("app_homepage_showurl");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "";
			}

		}else{
			var tr1 = document.getElementsByClassName("app_homepage_url");
			for(i=0;i<tr1.length;i++){
				tr1[i].style.display = "none";
			}
			var tr2 = document.getElementsByClassName("app_homepage_clickurl");
			for(i=0;i<tr2.length;i++){
				tr2[i].style.display = "none";
			}
			var tr3 = document.getElementsByClassName("app_homepage_showurl");
			for(i=0;i<tr3.length;i++){
				tr3[i].style.display = "none";
			}
		}
	}
	
	function tiepian_pc(obj,type){
		if(type == 0){
			$("outtime").style.display = "";
			var trs = document.getElementsByClassName("pc_loader");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			//pc_loader_vf_showtime
			var trsss = document.getElementsByClassName("pc_loader_vf_showtime");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			var trsss1 = document.getElementsByClassName("pc_loader_vob_showtime");
			for(i=0;i<trsss1.length;i++){
				trsss1[i].style.display = "none";
			}
			var trsss2 = document.getElementsByClassName("pc_loader_vb_showtime");
			for(i=0;i<trsss2.length;i++){
				trsss2[i].style.display = "none";
			}
			var trsss3 = document.getElementsByClassName("pc_loader_tp_showtime");
			for(i=0;i<trsss3.length;i++){
				trsss3[i].style.display = "none";
			}
			var trsss4 = document.getElementsByClassName("pc_hvideo_vf_h5");
			for(i=0;i<trsss4.length;i++){
				trsss4[i].style.display = "none";
			}
			
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			//chargingthreshold
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			//$("outtime").style.display = "none";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
		} else if(type == 1){
			$("outtime").style.display = "";
			var trs = document.getElementsByClassName("pc_loader");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
			var trsss = document.getElementsByClassName("pc_loader_vf_showtime");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "";
			}
			var trsss1 = document.getElementsByClassName("pc_loader_vob_showtime");
			for(i=0;i<trsss1.length;i++){
				trsss1[i].style.display = "";
			}
			var trsss2 = document.getElementsByClassName("pc_loader_vb_showtime");
			for(i=0;i<trsss2.length;i++){
				trsss2[i].style.display = "";
			}
			var trsss3 = document.getElementsByClassName("pc_loader_tp_showtime");
			for(i=0;i<trsss3.length;i++){
				trsss3[i].style.display = "";
			}
			
			var trsss4 = document.getElementsByClassName("pc_hvideo_vf_h5");
			for(i=0;i<trsss4.length;i++){
				trsss4[i].style.display = "";
			}
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "none";
			}
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
			$("skiptimethreshold").style.display = "none";
			$("outtime").style.display = "";			
			$("khplayingurl").style.display = "";			
			$("clientplayovertime").style.display = "none";
		}else{
			$("outtime").style.display = "";
			var trs = document.getElementsByClassName("pc_loader");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			var trsss = document.getElementsByClassName("pc_loader_vf_showtime");
			for(i=0;i<trsss.length;i++){
				trsss[i].style.display = "none";
			}
			var trsss1 = document.getElementsByClassName("pc_loader_vob_showtime");
			for(i=0;i<trsss1.length;i++){
				trsss1[i].style.display = "none";
			}
			var trsss2 = document.getElementsByClassName("pc_loader_vb_showtime");
			for(i=0;i<trsss2.length;i++){
				trsss2[i].style.display = "none";
			}
			var trsss3 = document.getElementsByClassName("pc_loader_tp_showtime");
			for(i=0;i<trsss3.length;i++){
				trsss3[i].style.display = "none";
			}
			var trsss4 = document.getElementsByClassName("pc_hvideo_vf_h5");
			for(i=0;i<trsss4.length;i++){
				trsss4[i].style.display = "none";
			}
			var trss = document.getElementsByClassName("custom_text");
			for(i=0;i<trss.length;i++){
				trss[i].style.display = "";
			}
			$("customtexturl").style.display = "";
			$("clientcustomclickurl").style.display = "";
			$("clientskipurl").style.display = "";
			$("clientfeeurl").style.display = "";
			$("othercustomtextclickurl").style.display = "";
			$("otherskipurl").style.display = "";
			$("otherfeepurl").style.display = "";
			$("chargingthreshold").style.display = "";
			$("skiptimethreshold").style.display = "";
			$("outtime").style.display = "none";			
			$("khplayingurl").style.display = "none";			
			$("clientplayovertime").style.display = "";
			
		}
	}
	
	
	function secondClass(obj,type){
		if(type == 1&&obj.checked){

			var trs = document.getElementsByClassName("yk_second_class");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
		} else {

			var trs = document.getElementsByClassName("yk_second_class");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
		}
		if(type == 2&&obj.checked){
			var trs = document.getElementsByClassName("td_second_class");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
		}else{
			var trs = document.getElementsByClassName("td_second_class");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
		}
		
		if(type == 3&&obj.checked){
			var trs = document.getElementsByClassName("sy_second_class");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
		}else{
			var trs = document.getElementsByClassName("sy_second_class");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
		}
		
	}


	function show_os_div(obj,type){
		if(!obj.checked){
			$("os_div").style.display = "";
			$("yk_all_os").style.display = "";
			$("td_all_os").style.display = "";
			if(type==0){
				document.getElementsByName("yk_all_os")[0].checked=false;
				document.getElementsByName("td_all_os")[0].checked=false;
			}
			var items = document.getElementsByName("chk_os");

			for(i = 0; i < items.length; i++){
				setOsChecked(items[i],false,type);
			}
		} else {
			if(type==0){
				$("os_div").style.display = "none";
				$("yk_all_os").style.display = "none";
				$("td_all_os").style.display = "none";
				document.getElementsByName("yk_all_os")[0].checked=false;
				document.getElementsByName("td_all_os")[0].checked=false;
			}
			
			var items = document.getElementsByName("chk_os");
			if(type==1){
				starti = 0;
			}
			if(type==2){
				starti = 8;
			}
			for(i = starti; i < items.length; i++){
				if(type==0){
					items[i].checked = false;
					continue;
				}
				setOsChecked(items[i],true,type);
				if (type == 2) {
					setOsChecked(items[items.length - 1], false, type);
				}
			}
		}
	}

	
	function show_sdkid(sdk,tname){
		if(sdk!=0){
			var trs = document.getElementsByClassName(tname);
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
		}else{
			var trs = document.getElementsByClassName(tname);
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "";
			}
		}
	}
	
	function show_m_qiantie_install_tip(m_qiantie_install){
		if(m_qiantie_install!=0){
			var trs = document.getElementsByClassName("m_qiantie_install_icon");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			var trs1 = document.getElementsByClassName("m_qiantie_install_text");
			for(ii=0;ii<trs1.length;ii++){
				trs1[ii].style.display = "none";
			}
			
		}else{
			var trs2 = document.getElementsByClassName("m_qiantie_install_icon");
			for(i=0;i<trs2.length;i++){
				trs2[i].style.display = "";
			}
			
			var trs3 = document.getElementsByClassName("m_qiantie_install_text");
			for(ii=0;ii<trs3.length;ii++){
				trs3[ii].style.display = "";
			}
			
		}
	}
	
	function show_m_houtie_install_tip(m_houtie_install){
		if(m_houtie_install!=0){
			var trs = document.getElementsByClassName("m_houtie_install_icon");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			var trs1 = document.getElementsByClassName("m_houtie_install_text");
			for(ii=0;ii<trs1.length;ii++){
				trs1[ii].style.display = "none";
			}
			
		}else{
			var trs2 = document.getElementsByClassName("m_houtie_install_icon");
			for(i=0;i<trs2.length;i++){
				trs2[i].style.display = "";
			}
			
			var trs3 = document.getElementsByClassName("m_houtie_install_text");
			for(ii=0;ii<trs3.length;ii++){
				trs3[ii].style.display = "";
			}			
		}
	}
	
	function show_m_zhongcha_install_tip(m_zhongcha_install){
		if(m_zhongcha_install!=0){
			var trs = document.getElementsByClassName("m_zhongcha_install_icon");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			var trs1 = document.getElementsByClassName("m_zhongcha_install_text");
			for(ii=0;ii<trs1.length;ii++){
				trs1[ii].style.display = "none";
			}
			
		}else{
			var trs2 = document.getElementsByClassName("m_zhongcha_install_icon");
			for(i=0;i<trs2.length;i++){
				trs2[i].style.display = "";
			}
			
			var trs3 = document.getElementsByClassName("m_zhongcha_install_text");
			for(ii=0;ii<trs3.length;ii++){
				trs3[ii].style.display = "";
			}			
		}
	}
	
	function show_m_zanting_install_tip(m_zanting_install){
		if(m_zanting_install!=0){
			var trs = document.getElementsByClassName("m_zanting_install_icon");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			var trs1 = document.getElementsByClassName("m_zanting_install_text");
			for(ii=0;ii<trs1.length;ii++){
				trs1[ii].style.display = "none";
			}
			
		}else{
			var trs2 = document.getElementsByClassName("m_zanting_install_icon");
			for(i=0;i<trs2.length;i++){
				trs2[i].style.display = "";
			}
			
			var trs3 = document.getElementsByClassName("m_zanting_install_text");
			for(ii=0;ii<trs3.length;ii++){
				trs3[ii].style.display = "";
			}			
		}
	}
	
	function show_m_fullscreen_install_tip(m_fullscreen_install){
		if(m_fullscreen_install!=0){
			var trs = document.getElementsByClassName("m_fullscreen_install_icon");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			var trs1 = document.getElementsByClassName("m_fullscreen_install_text");
			for(ii=0;ii<trs1.length;ii++){
				trs1[ii].style.display = "none";
			}
			
		}else{
			var trs2 = document.getElementsByClassName("m_fullscreen_install_icon");
			for(i=0;i<trs2.length;i++){
				trs2[i].style.display = "";
			}
			
			var trs3 = document.getElementsByClassName("m_fullscreen_install_text");
			for(ii=0;ii<trs3.length;ii++){
				trs3[ii].style.display = "";
			}			
		}
	}
	
	function show_m_playing_banner_install_tip(m_playing_banner_install){
		if(m_playing_banner_install!=0){
			var trs = document.getElementsByClassName("m_playing_banner_install_icon");
			for(i=0;i<trs.length;i++){
				trs[i].style.display = "none";
			}
			var trs1 = document.getElementsByClassName("m_playing_banner_install_text");
			for(ii=0;ii<trs1.length;ii++){
				trs1[ii].style.display = "none";
			}
			
		}else{
			var trs2 = document.getElementsByClassName("m_playing_banner_install_icon");
			for(i=0;i<trs2.length;i++){
				trs2[i].style.display = "";
			}
			
			var trs3 = document.getElementsByClassName("m_playing_banner_install_text");
			for(ii=0;ii<trs3.length;ii++){
				trs3[ii].style.display = "";
			}			
		}
	}
	
	function show_pause_width_height(control,WH){
		if(control!=1){
			pause_WH=WH.split("&&"); //???????????? 
			var trs_normal = document.getElementsByClassName(pause_WH[0]);
			for(i=0;i<trs_normal.length;i++){
				trs_normal[i].style.display = "";
			}
			var trs_fullscreen = document.getElementsByClassName(pause_WH[1]);
			for(i=0;i<trs_fullscreen.length;i++){
				trs_fullscreen[i].style.display = "";
			}
			
		}else{
			pause_WH=WH.split("&&"); //???????????? 
			var trs_normal = document.getElementsByClassName(pause_WH[0]);
			for(i=0;i<trs_normal.length;i++){
				trs_normal[i].style.display = "none";
			}
			var trs_fullscreen = document.getElementsByClassName(pause_WH[1]);
			for(i=0;i<trs_fullscreen.length;i++){
				trs_fullscreen[i].style.display = "none";
			}
		}
	}
	
	function checkIdeaUrl(ob_name){
		if(ob_name.value.indexOf('.tudou.com')>0){
			ob_name.value = '';
			alert("no support url pls use youku video url!!");
			return ob_name;
		}
	}
	function checkclickUrl(ob_name){
			alert(ob_name.value);
	}
	function checkadlen(ob_name)
	{
	    var id_list = "";
	    var x = document.getElementsByName("vc_time_spot");
	    for (i=0; i<x.length; i++) {
	        if (x[i].checked == true) {
	            id_list += ","+x[i].value;
	        }
	    }
	    if(id_list.substr(1) == "0"){
	    	if(ob_name.value != "-1" && (ob_name.value < 0 || ob_name.value > 45) ){
	    		ob_name.value = '';
	    		alert("???0???????????????????????????0-45?????????");
	    		return ob_name;
	    	}
	    }else{
		    if(id_list.substr(1) == "1"){
		    	if(ob_name.value != "-1" && (ob_name.value < 0 || ob_name.value > 180) ){
		    		ob_name.value = '';
		    		alert("???1???????????????????????????0-180?????????");
		    		return ob_name;
		    	}
		    }else{
		    	if(ob_name.value != "-1" && (ob_name.value < 0 || ob_name.value > 120) ){
		    		ob_name.value = '';
		    		alert("?????????????????????????????????0-120?????????");
		    		return ob_name;
		    	}
		    }
	    }

	}
	function getvalue(str)
	{   
		if(str == "0"){
			document.getElementById("pc_vc_showtime").value="45";
		}else if(str == "1"){
			document.getElementById("pc_vc_showtime").value="180";
		}else{
			document.getElementById("pc_vc_showtime").value="120";
		}
	    

	}
	/***??????????????????****/
	/***BY TONYLINZHEN****/
	function CutChr()
	{
	var x=document.getElementById("pc_crazy_y_js");
	var str=x.value;
	while(/[\u4E00-\u9FA5]+/.test(str)){
	str=str.replace(/[\u4E00-\u9FA5]+/,""); 
	x.value=str;
	}
	}
</script>
</head>
<body onload="initform()">
<table>
	<tr>
		<td style="width:70px"></td>
		<td>
			<form action="action" onsubmit="return validate()" method="post" >
			service ip = <%=ip%><p>
				?????????
				<input type="radio" name="os_type" value="p" onclick="changeAdType(this.value)" checked> PC &nbsp;&nbsp;
				<input type="radio" name="os_type" value="m" onclick="changeAdType(this.value)" > ??????  &nbsp;&nbsp;
				<input type="radio" name="os_type" value="vhtml" onclick="changeAdType(this.value)" > vhtml/mhtml <br><br>

				???????????????
				<select name="ad_type" id="ad_type" onchange="hideCampAndVideogroup(this.value)"></select><br>
				<div id="cast_type_div" style="display:none">
					<div id="mobile_theater_loops" >                   
					</div>		
				</div>
				
				<div id="vhtml_type" style="display:none">???????????????
				<select name="vhtml_type" onChange="hideVhtmlAndVideogroup(this.value)">
								<option id = "youku_playing_banner_pip" value="1" selected>???????????????banner ??????</option>
								<option id = "youku_playing_banner_flash" value="2" >???????????????banner flash(h5)</option>
								<option id = "youku_playing_custom" value="3" >???????????????banner ?????????</option>
								<option id = "youku_custom" value="6" >?????????????????????</option>
								<!--  
								<option value="8" >?????????????????????(1429860427)</option>
								<option value="9" >?????????????????????(1430199248)</option>
								
								<option value="10" >youku_??????phone-web???_?????????banner(1425020640)</option>
								<option value="11" >youku_??????ipad-web???_?????????banner(1427883541)</option>
								-->
								<option id = "youku_promoted_video_ads" value="8" >?????????????????????(1430192600-??????/1430192617-??????)</option>
								<option id = "m_playing" value="9" >m?????????(1425020640/1427883541)</option>
								<option id = "m_web_home_banner" value="10" >?????????WEB?????????banner</option>
							</select><br><br>
				</div>
				<!-- v_position -->
				
				???????????????
				<select name="order_type" >
								<option id = "sale_order" value="0" selected>????????????</option>
								<option id = "market_order" value="1" >????????????</option>
								<option id = "test_order" value="2" >????????????</option>
				</select><br><br>
				
				???????????????
				<select name="marketing_type" >
								<option id = "blank" value="0" selected>?????????</option>
								<option id = "multi-marketing" value="1" >????????????</option>
								<option id = "material-marketing" value="2" >????????????</option>
								<option id = "content-switch" value="3" >????????????</option>
								<option id = "inner-pushing" value="4" >????????????</option>
				</select><br><br>
								
				<input type="checkbox" id="is_show_v_position" name="is_show_v_position" value="1" onclick=show_v_position_div(this) > ???????????????????????? <br><br>
				<div id="show_v_position_div" style="display:none">				
                <table id="v_position_table" style="border: solid thin red">
                <tr>
				<td>??????????????????:<input type="checkbox" name="v_position" value="2" > ????????????
				        <input type="checkbox" name="v_position" value="3"> ????????????
				        <input type="checkbox" name="v_position" value="9"> ????????????
				        <input type="checkbox" name="v_position" value="20"> ????????????
				        <input type="checkbox" name="v_position" value="21"> ????????????
				        <input type="checkbox" name="v_position" value="22"> ????????????
				        <input type="checkbox" name="v_position" value="-11"> ???????????????
				        <input type="checkbox" name="v_position" value="-12"> ???????????????
				        <input type="checkbox" name="v_position" value="-13"> ???????????????
				        <br></tr>
				</tr>
				<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="mutex" value="1"> ????????????
				</td>
				</tr>
				</table><br>		
				</div>
				
				<!-- zhongcha_position -->
				<input type="checkbox" id="is_show_vo_position" name="is_show_vo_position" value="1" onclick=show_vo_position_div(this)> ???????????????????????? <br><br>
				<div id="show_vo_position_div" style="display:none">				
                <table id="vo_position_table" style="border: solid thin red">
                <tr>
				<td>??????????????????:<input type="checkbox" name="vo_position" value="10013" > ???????????????
				        <input type="checkbox" name="vo_position" value="10014"> ???????????????
				        <input type="checkbox" name="vo_position" value="10015"> ???????????????
				        <input type="checkbox" name="vo_position" value="10016"> ???????????????
				        <input type="checkbox" name="vo_position" value="-211"> ??????1??????
				        <input type="checkbox" name="vo_position" value="-212"> ??????1??????
				        <input type="checkbox" name="vo_position" value="-221"> ??????2??????
				        <input type="checkbox" name="vo_position" value="-222"> ??????2??????
				        <input type="checkbox" name="vo_position" value="-231"> ??????3??????
				        <input type="checkbox" name="vo_position" value="-232"> ??????3??????				        
				        <br></tr>
				<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="vo_position" value="40"> ??????1-1
				<input type="checkbox" name="vo_position" value="41"> ??????1-2
				<input type="checkbox" name="vo_position" value="42"> ??????1-3
				<input type="checkbox" name="vo_position" value="43"> ??????1-4
				<input type="checkbox" name="vo_position" value="44"> ??????1-5
				</td>
				</tr>
				</table><br>		
				</div>
				
				<!-- ?????????????????? -->
				<input type="checkbox" id="is_show_biaoban_position" name="is_show_biaoban_position" value="1" onclick=show_biaoban_position_div(this)> ???????????????????????????????????? <br><br>
				<div id="show_biaoban_position_div" style="display:none">				
                <table id="biaoban_position_table" style="border: solid thin red">
                <tr>
				<td>??????????????????:<input type="checkbox" name="biaoban_position" value="1300" > ??????????????????
				        <input type="checkbox" name="biaoban_position" value="1301"> ??????????????????1
				        <input type="checkbox" name="biaoban_position" value="1302"> ??????????????????2
				        <input type="checkbox" name="biaoban_position" value="1303"> ??????????????????3
				        <input type="checkbox" name="biaoban_position" value="1304"> ??????????????????4
				        <input type="checkbox" name="biaoban_position" value="1305"> ??????????????????5
				        <input type="checkbox" name="biaoban_position" value="1310"> ??????????????????
				        <br></tr>
				<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="biaoban_position" value="10020"> ??????1-1
				<input type="checkbox" name="biaoban_position" value="10021"> ??????1-1
				<input type="checkbox" name="biaoban_position" value="10026"> ??????1-2
				<input type="checkbox" name="biaoban_position" value="10022"> ??????2-1
				<input type="checkbox" name="biaoban_position" value="10030"> ??????1-1
				</td>
				</tr>
				</table><br>		
				</div>
				
				
				<!-- jiaobiao?????? -->
				<input type="checkbox" id="is_show_jiaobiao_position" name="is_show_jiaobiao_position" value="1" onclick=show_jiaobiao_position_div(this)> ?????????????????????????????? <br><br>
				<div id="show_jiaobiao_position_div" style="display:none">				
                <table id="jiaobiao_position_table" style="border: solid thin red">
                <tr>
				<td>??????????????????:<input type="checkbox" name="jiaobiao_position" value="10" > ??????1(??????????????????)
				        <input type="checkbox" name="jiaobiao_position" value="180"> ??????2
				        <input type="checkbox" name="jiaobiao_position" value="181"> ??????3
				        <input type="checkbox" name="jiaobiao_position" value="182"> ??????4
				        <br></tr>
				</table><br>		
				</div>
				
				<!-- ?????????????????? -->
				<input type="checkbox" id="is_show_screensaver_position" name="is_show_screensaver_position" value="1" onclick=show_screensaver_position_div(this)> ?????????????????????????????? <br><br>
				<div id="show_ screensaver_position_div" style="display:none">				
                <table id="screensaver_position_table" style="border: solid thin red">
                <tr>
				<td>??????????????????:<input type="checkbox" name="screensaver_position" value="900" > ??????1
				        <input type="checkbox" name="screensaver_position" value="901"> ??????2
				        <input type="checkbox" name="screensaver_position" value="902"> ??????3
				        <input type="checkbox" name="screensaver_position" value="903"> ??????4
						<input type="checkbox" name="screensaver_position" value="904"> ??????5
						<input type="checkbox" name="screensaver_position" value="905"> ??????6
						<input type="checkbox" name="screensaver_position" value="906"> ??????7
						<input type="checkbox" name="screensaver_position" value="907"> ??????8
						<input type="checkbox" name="screensaver_position" value="908"> ??????9
						<input type="checkbox" name="screensaver_position" value="909"> ??????10						
				        <br></tr>
				</table><br>		
				</div>
				
				<!--  ???????????????????????? -->
				<input type="checkbox" id="is_show_disrec_position" name="is_show_disrec_position" value="1" onclick=show_disrec_position_div(this) disabled > ???????????????????????????????????? <br><br>
				<div id="show_ disrec_position_div" style="display:none">				
                <table id="disrec_position_table" style="border: solid thin red">
                <tr>
				<td>????????????????????????:<input type="checkbox" name="disrec_position" value="400" >  ????????????1
				        <input type="checkbox" name="disrec_position" value="401">  ????????????2
				        <input type="checkbox" name="disrec_position" value="402">  ????????????3					
				        <br></tr>
				</table><br>		
				</div>
				
				<!--  ????????????????????? -->
				<input type="checkbox" id="is_show_xiami_lunbo_position" name="is_show_xiami_lunbo_position" value="1" onclick=show_xiami_lunbo_position_div(this)> ????????????????????????????????????????????? <br><br>
				<div id="show_xiami_lunbo_position_div" style="display:none">				
                <table id="xiami_lunbo_position_table" style="border: solid thin red">
                <tr>
				<td>???????????????????????????:<input type="checkbox" name="xiami_lunbo_position" value="60502,60603" >  ???????????????1
				        <input type="checkbox" name="xiami_lunbo_position" value="60503,60604">  ???????????????2
				        <input type="checkbox" name="xiami_lunbo_position" value="60504,60605">  ???????????????3	
						<input type="checkbox" name="xiami_lunbo_position" value="60505,60606">  ???????????????4
						<input type="checkbox" name="xiami_lunbo_position" value="60506,60607">  ???????????????5
						<input type="checkbox" name="xiami_lunbo_position" value="205">  ???????????????6
						<input type="checkbox" name="xiami_lunbo_position" value="206">  ???????????????7
						<input type="checkbox" name="xiami_lunbo_position" value="207">  ???????????????8
						<input type="checkbox" name="xiami_lunbo_position" value="208">  ???????????????9
						<input type="checkbox" name="xiami_lunbo_position" value="209">  ???????????????10					
				        <br></tr>
				</table><br></div>

                <!--  ??????????????? -->
				<input type="checkbox" id="is_bf_position" name="is_bf_position" value="1" onclick=show_bf_position_div(this)> ????????????????????????????????? <br><br>
				<div id="show_bf_position_div" style="display:none">				
                <table id="bf_position_table" style="border: solid thin red">
                <tr>
				<td>?????????????????????:<input type="checkbox" name="bf_position" value="61082,61083,61084,61085,61086,61087,61134,61135,61136,61137" >  ????????????1(???iku???)
				        <input type="checkbox" name="bf_position" value="62077,62080,62082,62084,62086">  ????????????2
				        <input type="checkbox" name="bf_position" value="62078,62081,62083,62085,62087">  ????????????3
				        <input type="checkbox" name="bf_position" value="61088,61089,61090,61091,61092,61093,61138,61139,61140,61141,61215">  ???????????????
				        <input type="checkbox" name="bf_position" value="61076,61077,61078,61079,61080,61081,61130,61131,61132,61133,61213">  ????????????1	
				        <input type="checkbox" name="bf_position" value="61429,61430">  ????????????2
						<input type="checkbox" name="bf_position" value="61314,61214,61129,61128,61127,61126,61108,61107,61106,61105,61104,61103">  ????????????					
				        <br></tr>
				</table><br>		
				</div>

				<!-- priority start -->
				????????????:
							<select name="product_reserve_method" onChange="show_priority_div(this.value)">
								<option id = "reserve_cpm" value="1" selected>cpm</option>
								<option id = "reserve_priority" value="2" >????????????</option>
								<option id = "reserve_time" value="3" >?????????</option>
								<option id = "reserve_lunbo" value="4" >??????</option>
								<option id = "reserve_percent" value="5" >?????????</option>
								<option id = "reserve_cpc" value="6" >cpc</option>
								<option id = "reserve_cpv" value="7" >cpv</option>
								<option id = "reserve_cpp" value="8" >cpp</option>
								<option id = "reserve_shua" value="9" >shua</option>
							</select><br><br>
				<div id="priority" style="display:none">
				????????????????????????<input type="text" name="priority" value="1" size="1" id="priority"><br><br>
				</div>
				
				<!-- lunbo -->
				<div id="total_lun" style="display:none">
				??????(????????????????????????10??????????????????10???)???<input type="text" name="total_lun" value="10" size="1" id="total_lun"><br><br>
				</div>
				
				<!-- percent -->
				<div id="percent" style="display:none">
				?????????(%)???<input type="text" name="percent" value="50" size="1" id="percent"><br><br>
				</div>
				
				<!--
				<input type="checkbox" id="is_show_priority" name="is_show_priority" value="1" onclick=show_priority_div(this)> ?????????????????? (????????????)<br><br>			
				-->
				<!--
				<div id="show_priority_div" style="display:none">
					????????????????????????<input type="text" name="priority" value="1" /><font color='red'></font><br><br>
				</div>
                -->
				<!-- priority end -->
				????????????(Y/M/D)???<input type="text"   id ="startDateRow"  name="startDateRow"> - <input type="text"  id ="endDateRow"  name="endDateRow"><font color='red'>  *</font>
				<br><br>
				???????????????(H/M)???<input type="text" id="timePicker_starttime" name="timePicker_starttime" value = "00:00:00"> -
                <input type="text" id="timePicker_endtime" name="timePicker_endtime" value="23:59:59" >
                <br><br>
				<div id="all_channel_div" style="display:">
				???????????????<input type="checkbox" id="all_channel" name="all_channel" onclick="show_channel_div(this,0)" value="1" > ????????? <br>
				</div>
				<table><td>
				<div id="yk_all_channel" style="display:none"><input type="checkbox" id="all_channel" name="all_channel" onclick="show_channel_div(this,1)" value="6">???????????????</div>
				</td><td>
				<div id="td_all_channel" style="display:none"><input type="checkbox" id="all_channel" name="all_channel" onclick="show_channel_div(this,2)" value="7">???????????????</div>
				</td><td>
				<div id="youku_yk_zn" style="display:none"><input type="checkbox" id="all_channel" name="all_channel"  value="4">????????????</div>
				</td><td>
				<div id="tudou_td_zn" style="display:none"><input type="checkbox" id="all_channel" name="all_channel"  value="5">????????????</div>
				</td><td>
				<div id="youku_yk_zw" style="display:none"><input type="checkbox" id="all_channel" name="all_channel"  value="2">????????????</div>
				</td><td>
				<div id="tudou_td_zw" style="display:none"><input type="checkbox" id="all_channel" name="all_channel"  value="3">????????????</div>
				</td><td>
				<div id="xy" style="display:none"><input type="checkbox" id="all_channel" name="all_channel"  value="8">??????</div>
				</td><td>
				<div id="xiami" style="display:none"><input type="checkbox" id="all_channel" name="all_channel"  value="9">??????</div>
				</td></table>
				<div id="channel_div" style="display:none">
                <table style="border: solid thin green">
                			    <tr>
                			      <td>
						            <font color='red'>?????????</font><br>
						           </td>
						        </tr>
						<%  Iterator<String> it1 = keys.iterator();
							for(int i = 0; i < keys.size(); i++){							
								if(i % 7 == 0){
									out.println("<tr>");
								}
						%>					  
						<%
						while (it1.hasNext()) {
							String str = it1.next();
							if(str.startsWith("ykn")){
								if(margin1 % 7 == 0){
									out.println("<tr>");
								}
							Map<String, String> channel = jedis.hgetAll(str);
							for (String channelfirstname : channel.keySet()) {
						%>
						  
						   <td valign="top"><table style="border: solid thin blue">
								<tr>
								  <td>
								    <font color='red'>???????????????</font><br>
									<input type="checkbox" name="chk_channel"  title="youku" value="<%=str + ":??????" + channelfirstname%>"><%="??????" + channelfirstname %><br>
									<font color='red'>???????????????</font>
									<input type="checkbox" name="second_class_checkbox" value="1" onclick="secondClass(this,1)">
								  </td>
								</tr>
						<%
				          String secondchannelinfoall = channel.get(channelfirstname);
				          String fileter = secondchannelinfoall.substring(1,secondchannelinfoall.length()-1).replace("\"", "");
				          String secondFirstChannelKeyValues[] = new String[2]; 
				          String[] secondchannelinfospecific = fileter.split(",");

						for(int ii = 0; ii < secondchannelinfospecific.length; ii++){
							
							    if(fileter.equals("")){
									secondFirstChannelKeyValues[0] = "";
									secondFirstChannelKeyValues[1] = "";
							    }else{
							    	secondFirstChannelKeyValues = secondchannelinfospecific[ii].split(":"); 
							    }							
						%>						  	
							<tr class="yk_second_class" id="yk_second_class" style="display:none;">
							  <td>
							  <input type="checkbox" name="chk_channel"  title="youku" value="<%=secondFirstChannelKeyValues[0] + ":??????" + secondFirstChannelKeyValues[1]%>"><%="??????" + secondFirstChannelKeyValues[1] %>
							  </td>
							</tr>					  						
						<%	
						}
						%>									
						   </table></td>

						<%
						}
							if(margin1 % 7 == 6){
								out.println("<tr>");
							}
							margin1 ++ ;
						}						

						}
						%>
						<%					
								if(i % 7 == 6){
									out.println("</tr>");
								}
							}
						%>
						<tr></tr><tr></tr>
						
						
						<%Iterator<String> it11 = keys.iterator();
							for(int i = 0; i < keys.size(); i++){							
								if(i % 7 == 0){
									out.println("<tr>");
								}
						%>					  
						<%
						while (it11.hasNext()) {
							String str = it11.next();
							if(str.startsWith("tdn")){
								if(margin2 % 7 == 0){
									out.println("<tr>");
								}
							Map<String, String> channel = jedis.hgetAll(str);
							for (String channelfirstname : channel.keySet()) {
						%>
						  
						   <td valign="top"><table style="border: solid thin blue">
								<tr>
								  <td>
								    <font color='red'>???????????????</font><br>
									<input type="checkbox" name="chk_channel"  title="tudou" value="<%=str + ":??????" + channelfirstname%>"><%="??????" + channelfirstname %><br>
									<font color='red'>???????????????</font>
									<input type="checkbox" name="second_class_checkbox" value="2" onclick="secondClass(this,2)">
								  </td>
								</tr>
						<%
				          String secondchannelinfoall = channel.get(channelfirstname);
				          String fileter = secondchannelinfoall.substring(1,secondchannelinfoall.length()-1).replace("\"", "");
				          String secondFirstChannelKeyValues[] = new String[2]; 
				          String[] secondchannelinfospecific = fileter.split(",");

						for(int ii = 0; ii < secondchannelinfospecific.length; ii++){
							
							    if(fileter.equals("")){
									secondFirstChannelKeyValues[0] = "";
									secondFirstChannelKeyValues[1] = "";
							    }else{
							    	secondFirstChannelKeyValues = secondchannelinfospecific[ii].split(":"); 
							    }							
						%>						  	
							<tr class="td_second_class" id="td_second_class" style="display:none;">
							  <td>
							  <input type="checkbox" name="chk_channel"  title="tudou" value="<%=secondFirstChannelKeyValues[0] + ":??????" + secondFirstChannelKeyValues[1]%>"><%="??????" + secondFirstChannelKeyValues[1] %>
							  </td>
							</tr>					  						
						<%	
						}
						%>									
						   </table></td>

						<%
						}
							if(margin2 % 7 == 6){
								out.println("<tr>");
							}
							margin2 ++ ;
						}
						}
						%>
						<%					
								if(i % 7 == 6){
									out.println("</tr>");
								}
							}
						%>						
						        <tr>
                			      <td></br></br>
						            <font color='red'>?????????</font><br>
						           </td>
						        </tr>
						        
					   <%Iterator<String> it111 = keys.iterator();
							for(int i = 0; i < keys.size(); i++){							
								if(i % 7 == 0){
									out.println("<tr>");
								}
						%>					  
						<%
						while (it111.hasNext()) {
							String str = it111.next();
							if(str.startsWith("ykzw")){
								if(margin3 % 7 == 0){
									out.println("<tr>");
								}
							Map<String, String> channel = jedis.hgetAll(str);
							for (String channelfirstname : channel.keySet()) {
						%>
						  
						   <td valign="top"><table style="border: solid thin blue">
								<tr>
								  <td>
								    <font color='red'>???????????????</font><br>
									<input type="checkbox" name="chk_channel"  title="youku_zw" value="<%=str + ":??????zw" + channelfirstname%>"><%="??????" + channelfirstname %><br>
								  </td>
								</tr>						  					  						
						<%	
						}
						%>									
						   </table></td>

						<%
						if(margin3 % 7 == 6){
							out.println("<tr>");
						}
						margin3 ++ ;
						}
						}
						%>
						<%					
								if(i % 7 == 6){
									out.println("</tr>");
								}
							}
						%>						
						<tr></tr><tr></tr>
						
					   <%Iterator<String> it1111 = keys.iterator();
							for(int i = 0; i < keys.size(); i++){							
								if(i % 7 == 0){
									out.println("<tr>");
								}
						%>					  
						<%
						while (it1111.hasNext()) {
							String str = it1111.next();
							if(str.startsWith("tdzw")){
								if(margin4 % 7 == 0){
									out.println("<tr>");
								}
							Map<String, String> channel = jedis.hgetAll(str);
							for (String channelfirstname : channel.keySet()) {
						%>
						  
						   <td valign="top"><table style="border: solid thin blue">
								<tr>
								  <td>
								    <font color='red'>???????????????</font><br>
									<input type="checkbox" name="chk_channel"  title="tudou_zw" value="<%=str + ":??????zw" + channelfirstname%>"><%="??????" + channelfirstname %><br>
								  </td>
								</tr>						  					  						
						<%	
						}
						%>									
						   </table></td>

						<%
						if(margin4 % 7 == 6){
							out.println("<tr>");
						}
						margin4 ++ ;
						}
						}
						%>
						<%					
								if(i % 7 == 6){
									out.println("</tr>");
								}
							}
						%>
						
						<tr></tr><tr></tr>
						
				        <tr>
                			      <td></br></br>
						            <font color='red'>???????????????</font><br>
						           </td>
						</tr>
												
						<%Iterator<String> it11111 = keys.iterator();
							for(int i = 0; i < keys.size(); i++){							
								if(i % 7 == 0){
									out.println("<tr>");
								}
						%>					  
						<%
						while (it11111.hasNext()) {
							String str = it11111.next();
							if(str.startsWith("shuyu")){
								if(margin5 % 7 == 0){
									out.println("<tr>");
								}
							Map<String, String> channel = jedis.hgetAll(str);
							for (String channelfirstname : channel.keySet()) {
						%>
						  
						   <td valign="top"><table style="border: solid thin blue">
								<tr>
								  <td>
								    <font color='red'>?????????????????????</font><br>
									<input type="checkbox" name="chk_channel"  title="shuyu" value="<%=str + ":??????" + channelfirstname%>"><%="??????" + channelfirstname %><br>
									<font color='red'>???????????????</font>
									<input type="checkbox" name="second_class_checkbox" value="3" onclick="secondClass(this,3)">
								  </td>
								</tr>
						<%
				          String secondchannelinfoall = channel.get(channelfirstname);
				          String fileter = secondchannelinfoall.substring(1,secondchannelinfoall.length()-1).replace("\"", "");
				          String secondFirstChannelKeyValues[] = new String[2]; 
				          String[] secondchannelinfospecific = fileter.split(",");

						for(int ii = 0; ii < secondchannelinfospecific.length; ii++){
							
							    if(fileter.equals("")){
									secondFirstChannelKeyValues[0] = "";
									secondFirstChannelKeyValues[1] = "";
							    }else{
							    	secondFirstChannelKeyValues = secondchannelinfospecific[ii].split(":"); 
							    }							
						%>						  	
							<tr class="sy_second_class" id="sy_second_class" style="display:none;">
							  <td>
							  <input type="checkbox" name="chk_channel"  title="sy" value="<%=secondFirstChannelKeyValues[0] + ":??????" + secondFirstChannelKeyValues[1]%>"><%="??????" + secondFirstChannelKeyValues[1] %>
							  </td>
							</tr>					  						
						<%	
						}
						%>									
						   </table></td>

						<%
						}
							if(margin5 % 7 == 6){
								out.println("<tr>");
							}
							margin5 ++ ;
						}
						}
						%>
						<%					
								if(i % 7 == 6){
									out.println("</tr>");
								}
							}
						%>						
						<tr></tr><tr></tr>
						
					</table>
					
				</div><br>
				
				<!-- ??????_start -->
				
				???????????????<input type="checkbox" id="all_area" name="all_area" onclick="show_area_div(this)" value="1" checked> ?????????<br>
				<div id="area_div" style="display:none">
                <table style="border: solid thin red">
						<%Iterator<String> it_area = keys.iterator();
							for(int i = 0; i < keys.size(); i++){							
								if(i % 5 == 0){
									out.println("<tr>");
								}
						%>					  
						<%
						while (it_area.hasNext()) {
							String str = it_area.next();
							if(str.startsWith("province")){
								if(margin6 % 5 == 0){
									out.println("<tr>");
								}
							Map<String, String> province = jedis.hgetAll(str);
							for (String provincefirstname : province.keySet()) {
						%>
						  
						   <td valign="top"><table style="border: solid thin blue">
								<tr>
								  <td>
								    <font color='red'>?????????</font><br>
									<input type="checkbox" name="chk_area"  title="china" value="<%=str + ":" + provincefirstname%>"><%="" + provincefirstname %><br>
									<font color='red'>?????????</font>
								  </td>
								</tr>
						<%
				          String secondprovinceinfoall = province.get(provincefirstname);
				          String fileter = secondprovinceinfoall.substring(1,secondprovinceinfoall.length()-1).replace("\"", "");
				          String secondFirstProvincekeyValues[] = new String[2]; 
				          String[] secondprovinceinfospecific = fileter.split(",");

						for(int ii = 0; ii < secondprovinceinfospecific.length; ii++){
							
							    if(fileter.equals("")){
							    	secondFirstProvincekeyValues[0] = "";
							    	secondFirstProvincekeyValues[1] = "";
							    }else{
							    	secondFirstProvincekeyValues = secondprovinceinfospecific[ii].split(":"); 
							    }							
						%>						  	
							<tr>
							  <td>
							  <input type="checkbox" name="chk_area"  title="city" value="<%=secondFirstProvincekeyValues[0] + ":" + secondFirstProvincekeyValues[1]%>"><%=secondFirstProvincekeyValues[1] %>
							  </td>
							</tr>				  						
						<%	
						}
						%>									
						   </table></td>

						<%
						}
							if(margin6 % 5 == 4){
								out.println("<tr>");
							}
							margin6 ++ ;
						}
						}
						%>
						<%					
								if(i % 5== 4){
									out.println("</tr>");
								}
							}
						%>
						<%Iterator<String> it_state = keys.iterator();
							for(int i = 0; i < keys.size(); i++){							
								if(i % 2 == 0){
									out.println("<tr>");
								}
						%>					  
						<%
						while (it_state.hasNext()) {
							String str = it_state.next();
							if(str.startsWith("state")){
								if(margin7 % 2 == 0){
									out.println("<tr>");
								}
							Map<String, String> state = jedis.hgetAll(str);
							for (String statefirstname : state.keySet()) {
						%>
						  
						   <td valign="top"><table style="border: solid thin blue">
								<tr>
								  <td>
								    <font color='red'>?????????</font><br>
									<input type="checkbox" name="chk_area"  title="state" value="<%=str + ":" + statefirstname%>"><%="" + statefirstname %><br>
									<font color='red'>???????????????</font>
								  </td>
								</tr>
						<%
				          String secondstateinfoall = state.get(statefirstname);
				          String fileter = secondstateinfoall.substring(1,secondstateinfoall.length()-1).replace("\"", "");
				          String secondFirstStatekeyValues[] = new String[2]; 
				          String[] secondstateinfospecific = fileter.split(",");

						for(int ii = 0; ii < secondstateinfospecific.length; ii++){
							
							    if(fileter.equals("")){
									secondFirstStatekeyValues[0] = "";
									secondFirstStatekeyValues[1] = "";
							    }else{
							    	secondFirstStatekeyValues = secondstateinfospecific[ii].split(":"); 
							    }							
						%>						  	
							<tr>
							  <td>
							  <input type="checkbox" name="chk_area"  title="country" value="<%=secondFirstStatekeyValues[0] + ":" + secondFirstStatekeyValues[1]%>"><%=secondFirstStatekeyValues[1] %>
							  </td>
							</tr>				  						
						<%	
						}
						%>									
						   </table></td>

						<%
						}
							if(margin7 % 2 == 1){
								out.println("<tr>");
							}
							margin7 ++ ;
						}
						}
						%>
						<%					
								if(i % 2== 1){
									out.println("</tr>");
								}
							}
						%>					
		
							
						<tr></tr><tr></tr>
				</table>
				</div><br>
				<!-- ??????_end -->
				
				<!-- pc??????_start -->
				
				<div id="pc_os_div" style="display:">
				pc?????????<input type="checkbox" id="pc_all_os" name="pc_all_os" onclick="show_os_pc_div(this)" value="1" > ????????? <br><br>
				
                <div id="show_pc_div" style="display:none">
                <table style="border: solid thin green">
						<%
							for (int i = 0; i < osList.size() ; i++) {
								Platform os = osList.get(i);

								if(i % 4 == 0){
									out.println("<tr>");
								}
						%>
						<%
						        if(os.getName().contains("pc") || os.getName().contains("PC")){
						%>
						     <%      
						             if(os.getValue().equals("0_5_3_0")||os.getValue().equals("0_5_3_w")){
						     %>
						            <td>
									<input type="checkbox" name="chk_os_pc" title="??????_PC_??????_WEB(pc_web)" checked value="<%=os.getValue() + ":" + os.getName()%>"><%=os.getName() %>
								    </td>
						     <%         	 
						             }else{
						     %> 
						            <td>
									<input type="checkbox" name="chk_os_pc" title="YK_PC_??????_APP_iku" value="<%=os.getValue()+ ":" + os.getName()%>"><%=os.getName() %>
								    </td>      	 
						     <%         
						             }
						     %>
						    
						        
						<%		      	
						        }
						%>
								
						<%
								if(i % 4 == 3){
									out.println("</tr>");
								}
							}
						%>
						<tr></tr><tr></tr>
	                
					</table>
					<br>
				</div>
				</div>
				<!-- pc??????_end -->
				
				<div id="m_os_div" style="display:none">
				
			              ???????????????<input type="checkbox" id="all_os" name="all_os" onclick="show_os_div(this,0)" value="1" > ????????? <br>
				<table><td>
				<div id="yk_all_os" style="display:none"><input type="checkbox" id="all_os" name="yk_all_os" onclick="show_os_div(this,1)" value="1">????????????</div>
				</td><td>
				<div id="td_all_os" style="display:none"><input type="checkbox" id="all_os" name="td_all_os" onclick="show_os_div(this,2)" value="1">????????????</div>
				</td></table>
				<div id="os_div" style="display:none">
                <table style="border: solid thin green">
						<%
							for (int i = 0; i < osList.size() ; i++) {
								Platform os = osList.get(i);

								if(i % 4 == 0){
									out.println("<tr>");
								}
						%>
								<td>
									<input type="checkbox" name="chk_os" title="youku" value="<%=os.getValue() + ":" + os.getName()%>"><%=os.getName() %>
								</td>
						<%
								if(i % 4 == 3){
									out.println("</tr>");
								}
							}
						%>
						<tr></tr><tr></tr>
	
					</table>
				</div><br>
				</div>
				
				<input type="checkbox" id="is_show_campaign" name="is_show_campaign" value="1" onclick=show_campaign_div(this)> ????????????show_campaign<br><br>
				<div id="show_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>???????????????<br><br></td>
				</tr>
				
				<tr>
				<td>
				?????????<select name="campaignList_show" id="campaignList_show" onChange="show_campaign(this.value)">
				        <%
							for (int i = -1; i < campaignList_show.size() ; i++) {
								if(i==-1){
						%>			
									<option value="" selected>
						<%
								}else{
									Campaign campaign = campaignList_show.get(i);
									String daylimit = campaign.getDaylimit();
									if(daylimit.contains("@")){
										String daylimits[] = daylimit.split("@");
					   %>
					               <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=daylimits[0]%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}else{
						%>
						           <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=campaign.getDaylimit()%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}
								
						%>	                    
									                        
						<%					
							}
							}
						%>
						</select>
						<button type="button" onclick=clear_show_campaign(this)>??????</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				?????????<input type="text" name="campaign_show_name" value="" size="30" id="campaign_show_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text"   id ="startDateRow_show"  name="startDateRow_show" value="" > - <input type="text"  id ="endDateRow_show"  name="endDateRow_show" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text" name="campaign_sequence_show" value="0" size="3" id="campaign_sequence_show"> <font color='red'>(1-3???????????????1???3???,0????????????????????????,4???????????????4???)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>????????????N??????????????????<input type="text" name="campaign_days_show" id="campaign_days_show" size="2" value="0" /> ??? <input type="text" name="campaign_day_limit_show" id="campaign_day_limit_show" size="2" value="0" /> ??? <font color='red'>(?????????0???0??????0???0????????????????????????)</font><br><br></td>
				<tr>
				<tr>
					<td>??????????????????????????????<input type="text" name="campaign_num_limit_show" id="campaign_num_limit_show" size="2" value="10" /> ??? <font color='red'>(0?????????n+???????????????????????????99,?????????????????????)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
				
				<input type="checkbox" id="is_click_campaign" name="is_click_campaign" value="2" onclick=click_campaign_div(this)> ????????????click_campaign<br><br>
				<div id="click_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>???????????????<br><br></td>
				</tr>
				
				<tr>
				<td>
				?????????<select name="campaignList_click" id="campaignList_click" onChange="click_campaign(this.value)">
				        <%
							for (int i = -1; i < campaignList_click.size() ; i++) {
								if(i==-1){
						%>			
									<option value="" selected>
						<%
								}else{
									Campaign campaign = campaignList_click.get(i);
									String daylimit = campaign.getDaylimit();
									if(daylimit.contains("@")){
										String daylimits[] = daylimit.split("@");
					   %>
					               <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=daylimits[0]%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}else{
						%>
						           <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=campaign.getDaylimit()%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}
								
						%>	                    
									                        
						<%					
							}
							}
						%>
						</select>
						<button type="button" onclick=clear_click_campaign(this)>??????</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				?????????<input type="text" name="campaign_click_name" value="" size="30" id="campaign_click_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text"   id ="startDateRow_click"  name="startDateRow_click" value="" > - <input type="text"  id ="endDateRow_click"  name="endDateRow_click" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text" name="campaign_sequence_click" value="0" size="3" id="campaign_sequence_click"> <font color='red'>(1-3???????????????1???3???,0??????????????????,4???????????????4???)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>????????????N??????????????????<input type="text" name="campaign_days_click" id="campaign_days_click" size="2" value="1" /> ??? <input type="text" name="campaign_day_limit_click" id="campaign_day_limit_click" size="2" value="3" /> ??? <font color='red'>(0????????????)</font><br><br></td>
				<tr>
				<tr>
					<td>??????????????????????????????<input type="text" name="campaign_num_limit_click" id="campaign_num_limit_click" size="2" value="10" /> ??? <font color='red'>(0?????????n+???????????????????????????99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
			
			    <input type="checkbox" id="is_over_campaign" name="is_over_campaign" value="3" onclick=over_campaign_div(this)> ????????????over_campaign<br><br>
				<div id="over_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>???????????????<br><br></td>
				</tr>
				
				<tr>
				<td>
				?????????<select name="campaignList_over" id="campaignList_over" onChange="over_campaign(this.value)">
				        <%
							for (int i = -1; i < campaignList_over.size() ; i++) {
								if(i==-1){
						%>			
									<option value="" selected>
						<%
								}else{
									Campaign campaign = campaignList_over.get(i);
									String daylimit = campaign.getDaylimit();
									if(daylimit.contains("@")){
										String daylimits[] = daylimit.split("@");
					   %>
					               <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=daylimits[0]%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}else{
						%>
						           <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=campaign.getDaylimit()%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}
								
						%>	                    
									                        
						<%					
							}
							}
						%>
						</select>
						<button type="button" onclick=clear_over_campaign(this)>??????</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				?????????<input type="text" name="campaign_over_name" value="" size="30" id="campaign_over_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text"   id ="startDateRow_over"  name="startDateRow_over" value="" > - <input type="text"  id ="endDateRow_over"  name="endDateRow_over" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text" name="campaign_sequence_over" value="0" size="3" id="campaign_sequence_over"> <font color='red'>(1-3???????????????1???3???,0??????????????????,4???????????????4???)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>????????????N??????????????????<input type="text" name="campaign_days_over" id="campaign_days_over" size="2" value="1" /> ??? <input type="text" name="campaign_day_limit_over" id="campaign_day_limit_over" size="2" value="3" /> ??? <font color='red'>(0????????????)</font><br><br></td>
				<tr>
				<tr>
					<td>??????????????????????????????<input type="text" name="campaign_num_limit_over" id="campaign_num_limit_over" size="2" value="10" /> ??? <font color='red'>(0?????????n+???????????????????????????99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
				
				<input type="checkbox" id="is_skip_campaign" name="is_skip_campaign" value="4" onclick=skip_campaign_div(this)> ????????????skip_campaign<br><br>
				<div id="skip_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>?????????????????????<br><br></td>
				</tr>
				
				<tr>
				<td>
				?????????<select name="campaignList_skip" id="campaignList_skip" onChange="skip_campaign(this.value)">
				        <%
							for (int i = -1; i < campaignList_skip.size() ; i++) {
								if(i==-1){
						%>			
									<option value="" selected>
						<%
								}else{
									Campaign campaign = campaignList_skip.get(i);
									String daylimit = campaign.getDaylimit();
									if(daylimit.contains("@")){
										String daylimits[] = daylimit.split("@");
					   %>
					               <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=daylimits[0]%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}else{
						%>
						           <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=campaign.getDaylimit()%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}
								
						%>               
						<%					
							}
							}
						%>
						</select>
						<button type="button" onclick=clear_skip_campaign(this)>??????</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				?????????<input type="text" name="campaign_skip_name" value="" size="30" id="campaign_skip_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text"   id ="startDateRow_skip"  name="startDateRow_skip" value="" > - <input type="text"  id ="endDateRow_skip"  name="endDateRow_skip" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text" name="campaign_sequence_skip" value="0" size="3" id="campaign_sequence_skip"> <font color='red'>(1-3???????????????1???3???,0??????????????????,4???????????????4???)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>????????????N??????????????????<input type="text" name="campaign_days_skip" id="campaign_days_skip" size="2" value="1" /> ??? <input type="text" name="campaign_day_limit_skip" id="campaign_day_limit_skip" size="2" value="3" /> ??? <font color='red'>(0????????????)</font><br><br></td>
				<tr>
				<tr>
					<td>??????????????????????????????<input type="text" name="campaign_num_limit_skip" id="campaign_num_limit_skip" size="2" value="10" /> ??? <font color='red'>(0?????????n+???????????????????????????99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
				
				<!-- preload -->
				<input type="checkbox" id="is_preload_campaign" name="is_preload_campaign" value="5" onclick=preload_campaign_div(this)> ????????????preload_campaign<br><br>
				<div id="preload_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>preload?????????<br><br></td>
				</tr>				
				<tr>
				<td>
				?????????<select name="campaignList_preload" id="campaignList_preload" onChange="preload_campaign(this.value)">
				        <%
							for (int i = -1; i < campaignList_preload.size() ; i++) {
								if(i==-1){
						%>			
									<option value="" selected>
						<%
								}else{
									Campaign campaign = campaignList_preload.get(i);
									String daylimit = campaign.getDaylimit();
									if(daylimit.contains("@")){
										String daylimits[] = daylimit.split("@");
					   %>
					               <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=daylimits[0]%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}else{
						%>
						           <option value="<%=campaign.getName()%>$<%=campaign.getStartDate().toString().substring(0, 10)%>$<%=campaign.getEndDate().toString().substring(0, 10)%>$<%=campaign.getDaylimit()%>$<%=campaign.getNumlimit()%>"><%=campaign.getName() %>
						<%			
									}
								
						%>	                    
									                        
						<%					
							}
							}
						%>
						</select>
						<button type="button" onclick=clear_preload_campaign(this)>??????</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				?????????<input type="text" name="campaign_preload_name" value="" size="30" id="campaign_preload_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text"   id ="startDateRow_preload"  name="startDateRow_preload" value="" > - <input type="text"  id ="endDateRow_preload"  name="endDateRow_preload" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				?????????<input type="text" name="campaign_sequence_preload" value="0" size="3" id="campaign_sequence_preload"> <font color='red'>(1-3???????????????1???3???,0??????????????????,4???????????????4???)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>????????????N??????????????????<input type="text" name="campaign_days_preload" id="campaign_days_preload" size="2" value="1" /> ??? <input type="text" name="campaign_day_limit_preload" id="campaign_day_limit_preload" size="2" value="3" /> ??? <font color='red'>(0????????????)</font><br><br></td>
				<tr>
				<tr>
					<td>??????????????????????????????<input type="text" name="campaign_num_limit_preload" id="campaign_num_limit_preload" size="2" value="10" /> ??? <font color='red'>(0?????????n+???????????????????????????99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
				
				<input type="checkbox" id="isVidLimit" name="isVidLimit" value="1"  onclick=show_videogroup_div(this)> ????????????????????? <br>
				<div id="videogroup_div" style="display:none"><br>
					????????????id????????????????????????????????????id???<br>
					????????????id???????????????????????????id???<br>
					????????????id??????(??????d)<br>
					??????????????????id??????(??????v,??????0-999)<br>
					????????????(ev????????????????????????1-42||1001)<br>
					note:youku?????????(E.g,http://v.youku.com/v_show/id_XODczMzU0NTAw.html)<br>
					<textarea id="video_group_area1" name="video_group_area1" placeholder="??????vid?????????id????????????yks????????????(ad_tool.jsp)" rows="10" cols="100"></textarea><br><br><br>
					????????????id????????????????????????????????????id??????????????????????????????????????????<br>
					????????????id???????????????????????????id???<br>
					????????????id??????(??????d)<br>
					??????????????????id??????(??????v,??????0-999)<br>
					note:tudou?????????(E.g,http://www.tudou.com/programs/view/1J8Cr28HQNU/ ?????????http://www.tudou.com/albumplay/ynpl4a9iYlc/Ck3kaCmoT2E.html)
					     ?????????http://www.tudou.com/listplay/ZHUghm--12U/6zj1PHYGT14.html<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/programs/view/([a-zA-Z_0-9\\-]{11}).*|" +  // ??????????????????<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/id/?(\\d+)|" +<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/album/id(\\d+).html|" +<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/p/a(\\d+).html|" +<br>
					"http\\:\\/\\/\\[??????\\](\\d+)-.*|" +      //???????????????????????????<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/albumcover/([a-zA-Z_0-9\\-]{11}).html|" + //???????????????????????????????????? <br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/listcover/([a-zA-Z_0-9\\-]{11}).html|" +<br>
		 	       
					"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|" +  // ??????????????? <br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/([a-zA-Z_0-9\\-]{11}).html|" +  // ??????????????? <br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|" + // ???????????????<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/([a-zA-Z_0-9\\-]{11}).html|" + // ???????????????<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/oplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|" + // ???????????????<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/plcover/([a-zA-Z_0-9\\-]{11}).*|" + //// ????????????<br>
					<textarea id="video_group_area2" name="video_group_area2" rows="10" cols="100"></textarea><br><br><br>
					??????????????????<br>
					??????(??????ID--lid)?????????????????????lid?????????id??????????????????????????????????????????<br>
					note:??????????????????????????????????????????<br>
					<textarea id="video_group_area4" name="video_group_area4" placeholder="????????????ID:908079????????????????????????" rows="10" cols="100"></textarea><br><br><br>
					??????????????????<br>
					??????(??????URL??????)???????????????????????????URL???????????????url????????????????????????<br>
					note:??????????????????????????????????????????<br>
					<textarea id="video_group_area5" name="video_group_area5" placeholder="??????????????????url?????????yks??????????????????????????????????????????ID" rows="10" cols="100"></textarea><br><br><br>
					????????????<br>
					??????(????????????id:908079;????????????id:769151;????????????id:234256)<br>
					note:??????????????????????????????????????????<br>
					<textarea id="video_group_area3" name="video_group_area3" placeholder="????????????id:908079????????????????????????" rows="10" cols="100"></textarea><br><br><br>
				</div><br>
				
				<!-- ??????????????? -->
				<input type="checkbox" id="isVidKeywords" name="isVidKeywords" value="1"  onclick=show_keywords_div(this)> ?????????????????????<br>
				<div id="keywords_div" style="display:none"><br>
				<textarea id="vid_keywords" name="vid_keywords" placeholder="???????????????????????????????????????????????????" rows="5" cols="80"></textarea><br><br>
				</div><br>
				<!-- ????????????-->
				<input type="checkbox" id="isVidUser" name="isVidUser" value="1"  onclick=show_users_div(this)> ??????????????????<br>
				<div id="users_div" style="display:none"><br>
				<textarea id="vid_users" name="vid_users" placeholder="???????????????????????????????????????userId????????????1_userId(youku),2_userId(tudou)" rows="5" cols="80"></textarea><br><br>
				</div><br>
				<!-- ????????????-->
				<input type="checkbox" id="isVidPid" name="isVidPid" value="1"  onclick=show_pids_div(this)> ??????????????????<br>
				<div id="pids_div" style="display:none"><br>
				<textarea id="vid_pids" name="vid_pids" placeholder="????????????????????????id" rows="5" cols="80"></textarea><br><br>
				</div><br>
				<!-- ??????????????????-->
				<input type="checkbox" id="isVidPartnerId" name="isVidPartnerId" value="1"  onclick=show_partnerId_div(this)> ????????????????????????<br>
				<div id="partnerId_div" style="display:none"><br>
				<textarea id="vid_partnerId" name="vid_partnerId" placeholder="?????????????????????id" rows="5" cols="80"></textarea><br><br>
				</div><br>
				<!-- ????????????-->
				<input type="checkbox" id="isVidParameter" name="isVidParameter" value="1"  onclick=show_parameter_div(this)> ??????????????????<br>
				<div id="parameters_div" style="display:none"><br>
				<select id ="parameter_names" name="parameter_names" onChange=disabled_parameters(this.value)>
				                <option value="nothing" selected></option>
								<option value="tt" >????????????</option>
								<option value="prd" >?????????</option>
								<option value="vip" >vip??????</option>
								<option value="paid" >??????????????????</option>
								<option value="temp" >??????</option>
								<option value="aq" >??????????????????</option>
								<option value="4" >channel</option>
								<option value="7" >??????</option>
								<option value="8" >?????????????????????</option>
								<option value="9" >??????id</option>
								<option value="11" >?????????????????????</option>
								<option value="screensize" >????????????</option>
								<option value="isp" >isp???????????????</option>
								<option value="box" >OTT??????</option>
								<option value="vr" >????????????</option>
								<option value="brand" >????????????</option>
								<option value="vp" disabled="" >?????????????????????</option>
								<option value="vit" >vit?????????live?????????</option>							
								
				</select>&nbsp;&nbsp;
								<select id ="parameter_values" name="parameter_values">
								<option id = "nothing" value= "" selected></option>
								<option id = "time" value="time" >???????????????</option>
								<option id = "cannot" value="cannot" >?????????</option>
								<option id = "episode" value="episode" >???????????????</option>
								<option id = "tvb" value="tvb" >tvb</option>
								<option id ="yes" value="5" >???</option>
								<option id = "no" value="6" >???</option>
								<option id = "Playgoods" value="7" >??????_??????</option>
								<option id = "temperature" value="8" >25?????????</option>
								<option id = "Unicast_len" value="9" >0-3??????</option>
								<option id = "Unicast" value="10" >???</option>	
								<option id = "screensize1" value="11" >4.7</option>
								<option id = "screensize2" value="12" >5.0</option>
								<option id = "programmeid" value="13" >?????????</option>	
								<option id = "childrenchannelkey1" value="14" >0-3???</option>
								<option id = "childrenchannelkey2" value="15" >4-6???</option>
								<option id = "childrenchannelkey3" value="16" >7-10???</option>
								<option id = "isp_cmcc" value="CMCC" >CMCC:????????????</option>
								<option id = "isp_ctcc" value="CTCC" >CTCC:????????????</option>
								<option id = "isp_cucc" value="CUCC" >CUCC:????????????</option>
								<option id = "ott_tianmao" value="1" >????????????</option>
								<option id = "ott_lianmeng" value="2" >????????????</option>
								<option id = "ott_yitiji" value="3" >?????????</option>
								<option id = "vr_video" value="1" >????????????</option>
								<option id = "common_video" value="0" >????????????</option>
								<option id = "brand1" value="huawei" >??????</option>
								<option id = "brand2" value="apple" >??????</option>
								<option id = "brand3" value="GiONEE" >??????</option>
								<option id = "brand4" value="htc" >htc</option>
								<option id = "brand5" value="lg" >LG</option>
								<option id = "brand6" value="moto" >??????</option>
								<option id = "brand7" value="motorola" >????????????</option>		
								<option id = "brand8" value="Nokia" >Nokia</option>	
								<option id = "brand9" value="OPPO" >OPPO</option>		
								<option id = "brand10" value="samsung" >??????</option>		
								<option id = "brand11" value="sony" >??????</option>		
								<option id = "brand12" value="vivo" >vivo</option>		
								<option id = "brand13" value="Xiaomi" >??????</option>	
								<option id = "vp00001" value="10017" disabled="" >vp-10017</option>
								<option id = "vp00001" value="10018" disabled="" >vp-10018</option>	
								<option id = "vp00001" value="10019" disabled="" >vp-10019</option>
								<option id = "vp00001" value="10020" disabled="" >vp-10020</option>
								<option id = "vp00001" value="10021" disabled="" >vp-10021</option>	
							  <option id = "vit51" value="51" >???????????????</option>	
							  <option id = "vit52" value="52" >?????????</option>				
														
				</select>
				</div><br>
				
				<!--????????????-->
				<input type="checkbox" id="isVidScene" name="isVidScene" value="1"  onclick=show_scene_div(this)> ????????????????????????(?????????,???????????????)<br>
				<div id="scene_div" style="display:none"><br>
				<textarea id="vid_scene" name="vid_scene" placeholder="???????????????????????????????????????(scene)??????" rows="5" cols="80"></textarea><br><br>
				</div><br>
				
				<!--????????????-->
				<input type="checkbox" id="isVidGoods" name="isVidGoods" value="1"  onclick=show_goods_div(this)> ????????????????????????<br>
				<div id="goods_div" style="display:none"><br>
				<textarea id="vid_goods" name="vid_goods" placeholder="?????????????????????????????????????????????" rows="5" cols="80"></textarea><br><br>
				</div><br>
				
				<!--????????????-->
				<input type="checkbox" id="isVidTag" name="isVidTag" value="1"  onclick=show_tag_div(this)> ????????????????????????<br>
				<div id="tag_div" style="display:none"><br>
				<textarea id="vid_tag" name="vid_tag" placeholder="??????:key|value ????????????:http://10.100.14.102:8081/set?key=1440501277285mTC&value=1022929&servicename=dmpservice" rows="5" cols="80"></textarea><br><br>
				</div><br>
				
				<!--???????????????-->
				<input type="checkbox" id="isOverlayFloat" name="isOverlayFloat" value="1"  onclick=show_overlayFloat_div(this)> ???????????????????????????<br>
				<div id="overlayfloat_div" style="display:none"><br>
				<textarea id="overlayfloat" name="overlayfloat" placeholder="????????????????????????ID(float)" rows="5" cols="80"></textarea><br><br>
				</div><br>
				
				<!--????????????-->
				<input type="checkbox" id="isPressDownFloat" name="isPressDownFloat" value="1"  onclick=show_pressdownfloat_div(this)> vit?????????????????????&?????????<br>
				<div id="pressdownfloat_div" style="display:none"><br>
				<textarea id="pressdownfloat" name="pressdownfloat" placeholder="????????????0-?????????1-?????????2-?????????3-????????????4-?????????5-???????????????6-?????????7-MV???8-????????????9-?????????(videotype????????????????????????????????????),51-???????????????,52-?????????" rows="5" cols="80"></textarea><br><br>
				</div><br>
				
				<!--???????????????-->
				<input type="checkbox" id="isDeviceFocus" name="isDeviceFocus" value="1"  onclick=show_deviceFocus_div(this)> ?????????????????????<br>
				<div id="devicefocus_div" style="display:none"><br>
				<textarea id="DeviceFocus" name="DeviceFocus" placeholder="IOS:IDFA->Openuuid->Mac;Android:IMEI(im)->Androidaid(adi)->Mac;OTT:MAC->aid->im" rows="5" cols="80"></textarea><br><br>
				</div><br>
								
				<!--????????????-->
				<input type="checkbox" id="isFaceoff" name="isFaceoff" value="1"  onclick=show_faceoff_div(this)> ????????????????????????<br>
				<div id="faceoff_div" style="display:none"><br>
                {'castEmbed':[{'video_id_yk':123,'video_id_td':123,'breakId':'adunit01_start', 'startTime':1200, 'showTime':15 },{'video_id_yk':456,'video_id_td':123,'breakId':'adunit02_start', 'startTime':1100, 'showTime':15}]}<br><br>
				<textarea id="vid_faceoff" name="vid_faceoff" placeholder="??????json" rows="5" cols="80"></textarea><br><br>
				</div><br>
				
				<!-- ????????????(0:????????????????????????????????????/1:c2s/2:s2s) -->
				<input type="checkbox" id="is_ir" name="is_ir" value="1" onclick=is_ir_div(this)> ????????????????????????<br><br>
				<div id="is_ir_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>???????????????</td>
					<td>
							<select id ="ir_type" name="ir_type">
				                <option value="0" selected>???????????????</option>
								<option value="1" >ClientToServer</option>	
								<option value="2" >ServerToServer</option>								
				</select>&nbsp&nbsp</td>
				<td>DSP?????????</td>
                        <td>
				        <select name="yes_SspDsp_pos" id="yes_SspDsp_pos" >
						<%
							for (int i = -1; i < yesDspPos.size() ; i++) {
								if(i==-1){							
						%>		
								   <option value="" selected> </option>   
						<%
								}else{
									YesDsp yessspPos = yesDspPos.get(i);
					   %>           
					               <option value="<%=yessspPos.getId()%>"><%=URLDecoder.decode(yessspPos.getDspname(), "UTF-8")%></option>                 											                        
						<%									
							}}
						%>							                        
						</select>
						</td>					
				</tr>
				<tr>
				<td>???????????????</td>
				<td><input type="text" id= "dsp_url_length" name="dsp_url_length" size="5" />&nbsp&nbsp</td>
				<td>???????????????</td>
				<td>
							<select id ="creative_effect_type" name="creative_effect_type" >
				                <option value="1" selected>??????</option>
								<option value="3" >??????</option>	
								<option value="7" >??????SDK</option>
															
				</select></td>
				</tr>
				</table><br>
				</div>
				
				<!-- priority_setting:start -->
				<div id="priority_setting" style="display:"> 
		                            ???????????????(???????????????weight?????????)???<input type="checkbox" name="priority_setting_ad" onclick="toggle('priority_setting_ad')" /><br><br>
	            </div>
	    	            
	            <div id="priority_setting_ad" style="display:none">
	            <table id="priority_setting_ad_table" style="border: solid thin blue">
	            <tr>
	            <td>???????????????(??????)???&nbsp&nbsp</td>
	            <td>vip?????????(??????)???&nbsp&nbsp</td> 
	            <td>??????????????????(??????)???&nbsp&nbsp</td> 
	            <td>???????????????(??????)???&nbsp&nbsp</td>
	            </tr>
	            <tr>
	            
	            <td>
				<select id ="product_priority" name="product_priority">
								<option value="1" selected>1</option>
								<option value="2" >2</option>
								<option value="3" >3</option>
								<option value="4" >4</option>
								<option value="5" >5</option>
								<option value="6" >6</option>
								<option value="7" >7</option>
								<option value="8" >8</option>
								<option value="9" >9</option>
								<option value="10" >10</option>
								<option value="11" >11</option>
								<option value="12" >12</option>
								<option value="13" >13</option>
								<option value="14" >14</option>
								<option value="15" >15</option>
								<option value="16" >16</option>
								<option value="17" >17</option>
								<option value="18" >18</option>
								<option value="19" >19</option>
								<option value="20" >20</option>
								<option value="21" >21</option>
								<option value="22" >22</option>
								<option value="23" >23</option>
								<option value="24" >24</option>
								<option value="25" >25</option>
								<option value="26" >26</option>
								<option value="27" >27</option>
								<option value="28" >28</option>
								<option value="29" >29</option>
								<option value="30" >30</option>
								<option value="31" >31</option>
								<option value="32" >33</option>
								<option value="33" >33</option>
								<option value="34" >34</option>
								<option value="35" >35</option>
								<option value="36" >36</option>
								<option value="37" >37</option>
								<option value="38" >38</option>
								<option value="39" >39</option>
								<option value="40" >40</option>
								<option value="41" >41</option>
								<option value="42" >42</option>
								<option value="43" >43</option>
								<option value="44" >44</option>
								<option value="45" >45</option>
								<option value="46" >46</option>
								<option value="47" >47</option>
								<option value="48" >48</option>
								<option value="49" >49</option>
								<option value="50" >50</option>
								<option value="51" >51</option>
								<option value="52" >52</option>
								<option value="53" >53</option>
								<option value="54" >54</option>
								<option value="55" >55</option>
								<option value="56" >56</option>
								<option value="57" >57</option>
								<option value="58" >58</option>
								<option value="59" >59</option>
								<option value="60" >60</option>
								<option value="61" >61</option>
								<option value="62" >62</option>
								<option value="63" >63</option>
								<option value="64" >64</option>
								<option value="65" >65</option>
								<option value="66" >66</option>
								<option value="67" >67</option>
								<option value="68" >68</option>
								<option value="69" >69</option>
								<option value="70" >70</option>
								<option value="71" >71</option>
								<option value="72" >72</option>
								<option value="73" >73</option>
								<option value="74" >74</option>
								<option value="75" >75</option>
								<option value="76" >76</option>
								<option value="77" >77</option>
								<option value="78" >78</option>
								<option value="79" >79</option>
								<option value="80" >80</option>
								<option value="81" >81</option>
								<option value="82" >82</option>
								<option value="83" >83</option>
								<option value="84" >84</option>
								<option value="85" >85</option>
								<option value="86" >86</option>
								<option value="87" >87</option>
								<option value="88" >88</option>
								<option value="89" >89</option>
								<option value="90" >90</option>
								<option value="91" >91</option>
								<option value="92" >92</option>
								<option value="93" >93</option>
								<option value="94" >94</option>
								<option value="95" >95</option>
								<option value="96" >96</option>
								<option value="97" >97</option>
								<option value="98" >98</option>
								<option value="99" >99</option>
								<option value="100" >100</option>
				</select>
				</td>
	            
				<td>
				<select id ="vip_priority" name="vip_priority">
				                <option value="???" selected>???</option>
								<option value="1" >V-01</option>
								<option value="2" >V-02</option>
								<option value="3" >V-03</option>
								<option value="4" >V-04</option>
								<option value="5" >V-05</option>
								<option value="6" >V-06</option>
								<option value="7" >V-07</option>
								<option value="8" >V-08</option>
								<option value="9" >V-09</option>
								<option value="10" >V-10</option>
								<option value="11" >V-11</option>
								<option value="12" >V-12</option>
								<option value="13" >V-13</option>
								<option value="14" >V-14</option>
								<option value="15" >V-15</option>
								<option value="16" >V-16</option>
								<option value="17" >V-17</option>
								<option value="18" >V-18</option>
								<option value="19" >V-19</option>
								<option value="20" >V-20</option>
								<option value="21" >V-21</option>
								<option value="22" >V-22</option>
								<option value="23" >V-23</option>
				</select>
				</td>
				<td>
				<select id ="custom_priority" name="custom_priority">
				                <option value="E" selected>E</option>
								<option value="V" >V</option>
								<option value="A" >A</option>
								<option value="B" >B</option>
								<option value="C" >C</option>
								<option value="D" >D</option>
								<option value="S" >S</option>
								<option value="Z" >Z</option>
								<option value="VR" >VR</option>
								<option value="AR" >AR</option>
								<option value="BR" >BR</option>
								<option value="CR" >CR</option>
								<option value="DR" >DR</option>
								<option value="ER" >ER</option>
								<option value="SR" >SR</option>
								
				</select>
				</td>
				<td>
                <input type="text" name="custom_num_priority" value="" size="5" id="custom_num_priority">
				<br></td>	
				</tr>
	            </table><br>
	            </div>	              
				<!-- priority_setting:end -->
				
				<!-- interact_effect -->
				???????????????<select id ="interact_effect_type" name="interact_effect_type" >
				                <option value="1" selected>??????</option>
								<option value="2" >??????</option>
								<option value="3" >??????</option>
								<option value="4" >crazy</option>
								<option value="23" >????????????</option>
								<option value="6" >trueview</option>
								<option value="7" >??????sdk</option>
								<option value="25" >??????</option>
								<option value="26" >???????????????</option>
								<option value="27" >???????????????</option>
								<option value="28" >????????????(??????)</option>
								<option value="30" >????????????</option>
								<option value="31" >???????????????</option>
								<option value="32" >???????????????</option>
								<option value="34" >?????????????????????</option>
								<option value="43" >???????????????</option>
								<option value="35" >????????????</option>		
								<option value="56" >??????????????????(????????????????????????)</option>
								<option value="48" >?????????</option>
								<option value="49" >????????????</option>
								<option value="148" >?????????????????????</option>	
								<option value="60" >???????????????</option>	
								<option value="46" >??????gif?????????</option>
								<option value="161" >taobaoshake</option>	
								<option value="162" >taobaononshake</option>
								<option value="168" >OTT?????????????????????</option>
												
				</select><br><br>
				
				<!-- interact_effect -->
				
				???????????????<select id ="sow_type" name="sow_type" onChange=sow_type_selected(this.value)>
				                <option value="0" selected>???????????????</option>
								<option value="1" >????????????</option>
								<option value="2" >????????????</option>								
				</select><br>
				
				<div id="sow_rate_setting" style="display:none"> 
			              ???????????????<input type="text" name="sow_rate" /> cookies???????????????<input type="text" name="cookies_time"/><br>
	            </div>
	            
	            <div id="sow_threshold_setting" style="display:none"> 
			              ?????????<input type="text" name="sow_threshold" /><br>
	            </div><br>
	            
				<!-- sow_type -->
				<!--546(10.10.72.19 poll.youku.com ???????????????s?????????)-????????????
                547-???????????????????????????http://poll.youku.com/mobile/s.sdo?o=c411abdf91e29757be8050de6840110d&s=546&uid=##IDFA##!!##GUID##    ????????????http://poll.youku.com/mobile/r.sdo?o=c411abdf91e29757be8050de6840110d&s=546&uid=##IDFA##!!##GUID##
                541-??????pc???????????????http://poll.youku.com/cast/s.sdo?o=101aac5a18fd32e3c5bd0d0de6284707&s=541   ????????????http://poll.youku.com/cast/r.sdo?o=101aac5a18fd32e3c5bd0d0de6284707&s=541
                542-??????pc 
				-->
				
				<div id="millwardbrown_div" style="display:">					
				Millwardbrown(PC/??????web) ???????????????
				<select name="millwardbrown_ad_type" id="ad_type_pc_web" onChange=show_millwardbrown_div(this.value) >
					<option id="vt0" value="-1" selected>???????????????</option>
					<option value="1">Expose?????????</option>
					<option id="vt2" value="2">Control?????????</option>
				</select>			
				</div>
				
				<div id="youku_survey_url" style="display:none">
				?????????????????????<input type="text" name="youku_survey_url" value="http://poll.youku.com/cast/s.sdo?o=50aa63a69683db867cefd65249874d22&s=1014&ca=851727&ie=624582" size="90" id="youku_survey_url">
				</div>
				<div id="tudou_survey_url" style="display:none">
				?????????????????????<input type="text" name="tudou_survey_url" value="http://poll.youku.com/cast/s.sdo?o=50aa63a69683db867cefd65249874d22&s=1014&ca=851727&ie=624582" size="90" id="tudou_survey_url">
				</div><br>
				
				<!-- app_millwardbrown -->
				<div id="millwardbrown_app_div" style="display:">
				Millwardbrown(APP) ???????????????
				<select name="millwardbrown_ad_type_APP" id="ad_type_APP" onChange=show_millwardbrown_div_app(this.value)>
					<option id="vt0_APP" value="-1" selected>???????????????</option>
					<option value="1">Expose?????????</option>
					<option value="2">Control?????????</option>
				</select>
				</div>
				
				<div id="survey_show_url" style="display:none">
				?????????????????????<input type="text" name="survey_show_url_app" value="http://poll.youku.com/mobile/s.sdo?o=cb4fc3f3008965aa4e7f0be5857c0876&s=1017&ca=851727&ie=624582&uid=##IDFA##!!##GUID##" size="90" id="youku_survey_url">
				</div>
				<div id="survey_click_url" style="display:none">
				?????????????????????<input type="text" name="survey_click_url_app" value="http://poll.youku.com/mobile/welcome.sdo?o=cb4fc3f3008965aa4e7f0be5857c0876&s=1017&ca=851727&ie=624582&uid=##IDFA##!!##GUID##" size="90" id="tudou_survey_url">
				</div>
				<div id="survey_entry_text" style="display:none">
				?????????????????????<input type="text" name="survey_entry_text_app" value="????????????" size="50" id="tudou_survey_url">
				</div><br>
				
				<!-- app_millwardbrown -->

				<!--<div id="clickurl" style="display:">???????????????<input type="text" name="click_url" value="http://yktd.m.cn.miaozhen.com/r/k=2017210&p=6z8Fl&dx=0&rt=2&ns=211.157.171.226&ni=__IESID__&v=__LOC__&nd=__DRA__&np=__POS__&nn=__APP__&vo=324d71340&vr=2&o=http://gxbr.cnzz.com/r.php?t=http%3A%2F%2Fmobile.tmall.com%2Fmobile%2Fpage%2Fllb%3Fshareid%3D61581192%26_bind%3Dtrue%26asac%3DD5JJFW716103XOLRS2OX%26lpid%3D97811%26lpt%3D1%26lsid%3D2064892827%26mm_gxbid%3D1_227016_1fa12b2eeb2f6674ee9fc8316bb4236e&v=9b770a7c6578" size="140"/>-->
				<div id="clickurl" style="display:">???????????????<textarea id="click_url" name="click_url" rows="1" cols="200">http://yktd.m.cn.miaozhen.com/r/k=2017210&p=6z8Fl&dx=0&rt=2&ns=211.157.171.226&ni=__IESID__&v=__LOC__&nd=__DRA__&np=__POS__&nn=__APP__&vo=324d71340&vr=2&o=http://gxbr.cnzz.com/r.php?t=http%3A%2F%2Fmobile.tmall.com%2Fmobile%2Fpage%2Fllb%3Fshareid%3D61581192%26_bind%3Dtrue%26asac%3DD5JJFW716103XOLRS2OX%26lpid%3D97811%26lpt%3D1%26lsid%3D2064892827%26mm_gxbid%3D1_227016_1fa12b2eeb2f6674ee9fc8316bb4236e&v=9b770a7c6578</textarea>

				</div><br>
				<div id="mb_app_click_way" style="display:none"> ??????app?????????????????????

				  <select name="mb_click" id="mb_click" >
                                <option id="webview" value="1" selected="selected">??????webview(??????)</option>							
								<option id="browser" value="0">??????????????????</option>
								<option id="app_player" value="2">app????????????(???????????????id)</option>
								<option id="app_s" value="3">app????????????</option>
								<option id="app_d" value="4">app????????????</option>
								<option id="game_sdk" value="6">???????????????sdk</option>
								<option id="app_ali_sdk" value="5">???????????????sdk</option>
								<option id="sy_uri_rec" value="8">app???URI?????????</option>
								<option id="app_lid" value="11">app????????????</option>
								<option id="app_pp_sdk_assis" value="9">PP??????SDK</option>
								<option id="app_coolScr" value="10">????????????(??????)</option>
								<option id="app_coolScr" value="13">feeds_h5</option>
								<option id="app_coolScr" value="14">feeds_appstore</option>
								<option id="app_coolScr" value="15">???????????????</option>
								<option id="app_coolScr" value="16">????????????</option>
								
				  </select><br><br>
				</div>
				</div>
				
				<!--<div id="khoverurl" style="display:">??????????????????????????????????????????<input type="text" name="over_url" value="http://t.cr-nielsen.com/hat?_t=i&_htsinfo=SSYyJjgwMDAwMDI1JjEwMDA1ODc0JjMwMTAxNzkyJrSr" size="90"/> <br><br></div>-->
				<div id="khoverurl" style="display:">??????????????????????????????????????????<textarea id="over_url" name="over_url" rows="1" cols="100">http://t.cr-nielsen.com/hat?_t=i&_htsinfo=SSYyJjgwMDAwMDI1JjEwMDA1ODc0JjMwMTAxNzkyJrSr</textarea> <br><br></div>
							
				<div id="outtime" style="display:">????????????????????????(???)???<input type="text" name="over_url_time" value="0" size="1"/> <br><br></div>
				<div id="clientplayovertime" style="display:none">??????????????????????????????????????????(???)???<input type="text" name="clientplayover_time" id= "clientplayover_time" value="0" size="1"/> <br><br></div>
				
				<!--<div id="khshowurl" style="display:">????????????????????????????????????<input type="text" name="show_url" placeholder="http://yktd.m.cn.miaozhen.com/x/k=2009598&p=6w7S4&dx=0&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&nd=__DRA__&np=__POS__&nn=__APP__&o=" size="100"/> <br><br></div>-->				
				<!-- test_multi_monitors -->
				<div id="khshowurl" style="display:">????????????????????????????????????<textarea id="show_url" name="show_url" rows="1" cols="100">http://yktd.m.cn.miaozhen.com/x/k=2009598&p=6w7S4&dx=0&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&nd=__DRA__&np=__POS__&nn=__APP__&o=</textarea> <br><br></div>
				<!-- test_multi_monitors -->
				
				<div id="khspreadshowurl" style="display:none">??????????????????????????????????????????<input type="text" name="spread_show_url" value="ipad not support" size="100"/> <br><br></div>
				
				<!--<div id="khclickurl" style="display:">????????????????????????????????????<input type="text" name="click_kh_url" value="http://vyk.admaster.com.cn/i/a12668,b200212069,c2864,i0,m202,h" size="70"/> <br><br></div>-->
			    <div id="khclickurl" style="display:">????????????????????????????????????<textarea id="click_kh_url" name="click_kh_url" rows="1" cols="100">http://vyk.admaster.com.cn/i/a12668,b200212069,c2864,i0,m202,h</textarea> <br><br></div>
				
				<!--<div id="khplayingurl" style="display:">???????????????????????????????????????<input type="text" name="playing_url" value="http://yktd.m.cn.miaozhen.com/x.gif?k=2001665&p=6rC7e&rt=2&ns=[M_ADIP]&ni=[M_IESID]&v=[M_LOC]&o=" size="100"/> <br><br></div>-->
				<div id="khplayingurl" style="display:">???????????????????????????????????????<textarea id="playing_url" name="playing_url" rows="1" cols="100">http://yktd.m.cn.miaozhen.com/x.gif?k=2001665&p=6rC7e&rt=2&ns=[M_ADIP]&ni=[M_IESID]&v=[M_LOC]&o=</textarea> <br><br></div>
				
				<!--<div id="othershowurl" style="display:">?????????????????????????????????????????????<input type="text" name="iso_url" value="http://yktd.m.cn.miaozhen.com/x/k=2004830&p=6sjJN&dx=0&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&o=" size="100"/> <br><br></div>-->
				<div id="othershowurl" style="display:">?????????????????????????????????????????????<textarea id="iso_url" name="iso_url" rows="1" cols="100">http://yktd.m.cn.miaozhen.com/x/k=2004830&p=6sjJN&dx=0&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&o=</textarea> <br><br></div>
				
				<!--  
				<div id="MTurl" style="display:">?????????????????????MT??????????????????????????????????????? ???<input type="text" name="mt_url" value="http://www.baidu.com?mt" size="40"/> <br><br></div>
				-->
				<!--<div id="otherclickurl" style="display:">???????????????????????????????????????<input type="text" name="iso_click_url" value="http://yktd.m.cn.miaozhen.com/r/k=2004830&p=6sjJN&ae=1000968&dx=0&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&vo=387e6cecc&&vr=2&o=" size="120"/> <br><br></div>-->
				<div id="otherclickurl" style="display:">???????????????????????????????????????<textarea id="iso_click_url" name="iso_click_url" rows="1" cols="100">http://yktd.m.cn.miaozhen.com/r/k=2004830&p=6sjJN&ae=1000968&dx=0&rt=2&ns=__IP__&ni=__IESID__&v=__LOC__&vo=387e6cecc&&vr=2&o=</textarea> <br><br></div>
				
				<!--<div id="otherh5showurl" style="display:none">?????????????????????????????????????????????????????????<input type="text" name="iso_h5_url" value="http://t.cr-nielsen.com/hat?_t=i&_htsinfo=SSYyJjgwMDAwMDI1JjEwMDA1MjAwJjMwMDkyNzA2JkEE" size="90"/> <br><br></div>-->
				<div id="otherh5showurl" style="display:none">?????????????????????????????????????????????????????????<textarea id="iso_h5_url" name="iso_h5_url" rows="1" cols="100">http://t.cr-nielsen.com/hat?_t=i&_htsinfo=SSYyJjgwMDAwMDI1JjEwMDA1MjAwJjMwMDkyNzA2JkEE</textarea> <br><br></div>
				
				<div id="customtexturl" style="display:none">??????????????????????????????<input type="text" name="customtext_url" id="customtext_url" value="http://v.youku.com/v_show/id_XMTMwNzkwNzcyNA==.html" size="40"/> <br><br></div>
				<div id="clientcustomclickurl" style="display:none">???????????????????????????????????????????????????<input type="text" name="clientcustomclick_url" id="clientcustomclick_url" value="http://www.clientcustomclickurl.com" size="40"/> <br><br></div>
				<div id="clientskipurl" style="display:none">????????????????????????????????????<input type="text" name="clientskip_url" value="http://www.clientskipurl.com" size="40"/> <br><br></div>
				<div id="clientfeeurl" style="display:none">????????????????????????????????????<input type="text" name="clientfee_url" value="http://www.clientfeeurl.com" size="40"/> <br><br></div>
				<div id="othercustomtextclickurl" style="display:none">????????????????????????????????????????????????????????????<input type="text" name="othercustomtextclick_url" value="http://www.othercustomtextclickurl.com" size="40"/> <br><br></div>
				<div id="otherskipurl" style="display:none">???????????????????????????????????????<input type="text" name="otherskip_url" value="http://www.otherskipurl.com" size="40"/> <br><br></div>
				<div id="otherfeepurl" style="display:none">???????????????????????????????????????<input type="text" name="otherfeep_url" value="http://www.otherfeepurl.com" size="40"/> <br><br></div>
				<div id="chargingthreshold" style="display:none">???????????????<input type="text" name="chargingthreshold_text" value="15" size="15"/> <br><br></div>
				<div id="skiptimethreshold" style="display:none">?????????????????????<input type="text" name="skiptimethreshold_text" value="5" size="15"/> <br><br></div>
				<div id="clientDSPpushurl" style="display:">???????????????DSP?????????????????????<input type="text" name="clientDSPpushurl_text" id= "clientDSPpushurl_text" value="" size="40"/> <br><br></div>
				<div id="otherDSPpushurl" style="display:">?????????????????????DSP?????????????????????<input type="text" name="otherDSPpushurl_text" id= "otherDSPpushurl_text" value="" size="40"/> <br><br></div>
				<div id="onebuyurl" style="display:">??????????????????????????????<input type="text" name="onebuyurl_text" id= "onebuyurl_text" value="" size="100"/> <br><br></div>
				
				<div id="ies_monitor" style="display:">ies??????????????????
				<select name="ies_monitor">
								<option value="1" selected>?????????</option>
								<option value="2" >admaster</option>
								<option value="3" >miaozhen</option>
				</select><br></div><br>
				
				<div id="m_issdk" style="display:none">				
				????????????:
					<select name="m_issdk" >
						<option value="0" selected>API??????</option>
						<option value="1" >sdk??????</option>
						<option value="2" >??????sdk??????</option>
						<option value="3" >??????sdk</option>
						<option value="10" >??????API??????</option>
					</select><br><br>
				</div>
				
				<div id="charge_type" style="display:">				
				????????????:
					<select name="charge_type" >
						<option value="0" selected>????????????</option>
						<option value="1" >???????????????????????????</option>
					</select><br><br>
				</div>
												
				<!-- is_bark -->
				<div id="isCast_barkidea" style="display:">	
				<input type="checkbox" id="isCast_bark" name="isCast_bark" value="1" > ????????????????????? <br><br>
				</div>
				
			    <!-- is_vr -->
				<div id="isCast_barkidea" style="display:">	
				<input type="checkbox" id="isIdea_vr" name="isIdea_vr" value="1" > ?????????vr?????? <br><br>
				</div>
				
				<!-- ??????deeplink*-->
				<input type="checkbox" id="isDeeplink" name="isDeeplink" value="1"  onclick=show_deeplink_div(this)> ??????deeplink<br>
				<div id="deeplink_div" style="display:none"><br>
				<textarea id="vid_deeplink" name="vid_deeplink" placeholder="vipshop://goHome?tra_from=tra%3Azq03mkyy%3A%3A%3A%3A" rows="5" cols="80"></textarea><br><br>
				</div><br>
				
				?????????????????????
				<div id="pcdevice" style="display:">
				<div id = "pc_vf" style="display:">
				<table id="pc_vf_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>?????????</b></td>
					</tr>
					<tr>
						<td>??????????????????(??????????????????????????????)</td>
						<td><input type="text" name="pc_vf_y_ideaurl" id="pc_vf_y_ideaurl"  placeholder="????????????  http://???https://???????????? flv???flv???html???swf ?????????????????????" size="100" ></td>
					</tr>
					<tr>
						<td>PIP????????????</td>
						<td><input type="text" name="pc_vf_pipurl" size="100"></td>
					</tr>
					<tr class="pc_loader" id="loader" style="display:none;">
					    <td >loader?????????</td>
						<td >
						    <select name="loader_type">
								<option value="1" selected>??????loader</option>
								<option value="2" >??????loader</option>
								<option value="3" >????????????loader</option>
							</select>
						</td>
					</tr>
					<tr class="pc_hvideo_vf_h5" id="pc_hvideo_vf_h5" style="display:none;">
					    <td >pc_????????????_h5????????????(??????????????????):</td>
						<td >
                        <input type="text" name="pc_hvideo_vf_h5" id = "pc_hvideo_vf_h5" size="100" value = "http://r1.ykimg.com/material/0A03/201711/111/97797/baiye1101/pc/index.js">
						</td>
					</tr>
					<tr class="pc_loader_vf_showtime" id="loader_vf_showtime" style="display:none;">
					    <td >???????????????</td>
						<td >
                        <input type="text" name="pc_vf_loader_showtime" id = "pc_vf_loader_showtime" size="5" value = "">
						</td>
					</tr>
					
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >??????????????????</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????" >????????????</option>
								<option value="?????????" >?????????</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>????????????</td>
						<td><input type="radio" id="normal_pc" name="pvimpression_pc" onclick="tiepian_pc(this,0)" value="0" checked>????????????
							<input type="radio" id="vpaid_pc" name="pvimpression_pc" onclick="tiepian_pc(this,1)" value="1">????????????
							<input type="radio" id="customtext" name="pvimpression_pc" onclick="tiepian_pc(this,2)" value="2">trueview</td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
				</table><br>
				</div>
				
				<div id = "pc_vp" style="display:none">
				<table id="pc_vp_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>?????????</b></td>
					</tr>
					<tr>
						<td>??????????????????(?????????flash?????????)</td>
						<td><input type="text" name="pc_vp_y_ideaurl" size="100"></td>
					</tr>
					
					<tr>
						<td>??????????????????(PC????????????(H5))</td>
						<td><input type="text" name="pc_vp_y_ideaurl_h5" size="100"></td>
					</tr>
					
					<tr>
						<td>???????????????????????????(?????????flash?????????)</td>
						<td><input type="text" name="pc_vp_y_full_ideaurl" size="100"></td>
					</tr>
					
					<tr>
						<td>???????????????????????????(??????PC????????????(H5))</td>
						<td><input type="text" name="pc_vp_y_full_ideaurl_h5" size="100"></td>
					</tr>
					
					<tr>
						<td>??????????????????(?????????flash?????????)</td>
						<td><input type="text" name="pc_vp_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>???????????????????????????(?????????flash?????????)</td>
						<td><input type="text" name="pc_vp_t_full_ideaurl" size="100"></td>
					</tr>

					<tr>
						<td>??????????????????</td>
						<td>
							<select name="pc_vp_ideacontrol" onchange="show_pause_width_height(this.value,'normal_pc_zanting&&fullscreen_pc_zanting')">
								<option value="1" selected>???????????????</option>
								<option value="2" >?????????????????????</option>
								<option value="0" >???????????????</option>
								<option value="4" >??????????????????????????????????????????</option>
							</select>
						</td>
					</tr>
					
					<tr class="normal_pc_zanting" id="normal_pc_zanting_id" style="display:none;">
					    <td >PC???????????????</td>
						<td >??????<input type="text" name="pc_normal_zanting_width" id = "pc_normal_zanting_width" size="5" value = "">
						                 ??????<input type="text" name="pc_normal_zanting_height" id = "pc_normal_zanting_height" size="5" value = "">
						</td>
					</tr>
					<tr class="fullscreen_pc_zanting" id="fullscreen_pc_zanting_id" style="display:none;">
					    <td >??????PC???????????????</td>
						<td >??????<input type="text" name="pc_fullscreen_zanting_width" id = "pc_fullscreen_zanting_width" size="5" value = "">
						                 ??????<input type="text" name="pc_fullscreen_zanting_height" id = "pc_fullscreen_zanting_height" size="5" value = "">
						</td>
					</tr>					
					<tr>
						<td colSpan="2"></td>
					</tr>
				</table><br>
				</div>
				<div id = "pc_vob" style="display:none">
				<table id="pc_vob_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>?????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="pc_vob_ideaurl" placeholder="????????????  http://???https://???????????? flv???flv???html???swf ?????????????????????" size="100"   ></td>
					</tr>
					<tr>
						<td>PIP????????????</td>
						<td><input type="text" name="pc_vob_pipurl" size="100"></td>
					</tr>
					<tr class="pc_loader" id="loader" style="display:none;">
					    <td >loader?????????</td>
						<td >
						    <select name="loader_type_vob">
								<option value="1" selected>??????loader</option>
								<option value="2" >??????loader</option>
								<option value="3" >????????????loader</option>
							</select>
						</td>
					</tr>
					<tr class="pc_loader_vob_showtime" id="loader_vob_showtime" style="display:none;">
					    <td >???????????????</td>
						<td >
                        <input type="text" name="pc_vob_loader_showtime" id = "pc_vob_loader_showtime" size="5" value = "">
						</td>
					</tr>
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >??????????????????</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????" >????????????</option>
								<option value="?????????" >?????????</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="radio" id="normal_pc_vob" name="pvimpression_pc_vob" onclick="tiepian_pc(this,0)" value="0" checked>????????????
							<input type="radio" id="vpaid_pc" name="pvimpression_pc_vob" onclick="tiepian_pc(this,1)" value="1">????????????
							<input type="radio" id="customtext" name="pvimpression_pc_vob" onclick="tiepian_pc(this,2)" value="2">trueview</td>
					</tr>
				</table><br>
				</div>
				<div id = "pc_vb" style="display:none">
				<table id="pc_vb_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>?????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="pc_vb_ideaurl" placeholder="????????????  http://???https://???????????? flv???flv???html???swf ?????????????????????" size="100"  ></td>
					</tr>
					<tr class="pc_loader" id="loader" style="display:none;">
					    <td >loader?????????</td>
						<td >
						    <select name="loader_type_vb">
								<option value="1" selected>??????loader</option>
								<option value="2" >??????loader</option>
								<option value="3" >????????????loader</option>
							</select>
						</td>
					</tr>
					<tr class="pc_loader_vb_showtime" id="loader_vb_showtime" style="display:none;">
					    <td >???????????????</td>
						<td >
                        <input type="text" name="pc_vb_loader_showtime" id = "pc_vb_loader_showtime" size="5" value = "">
						</td>
					</tr>
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >??????????????????</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????" >????????????</option>
								<option value="?????????" >?????????</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="radio" id="normal_pc_vb" name="pvimpression_pc_vb" onclick="tiepian_pc(this,0)" value="0" checked>????????????
							<input type="radio" id="vpaid_pc" name="pvimpression_pc_vb" onclick="tiepian_pc(this,1)" value="1">????????????
							<input type="radio" id="customtext" name="pvimpression_pc_vb" onclick="tiepian_pc(this,2)" value="2">trueview</td>
					</tr>
				</table><br>
				</div>
				
				<div id = "pc_tp" style="display:none">
				<table id="pc_tp_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>?????????</b></td>
					</tr>
					<tr>
						<td>????????????(?????????flv??????)</td>
						<td><input type="text" name="pc_tp_ideaurl" size="100"  ></td>
					</tr>
					<tr class="pc_loader" id="loader" style="display:none;">
					    <td >loader?????????</td>
						<td >
						    <select name="loader_type_tp">
								<option value="1" selected>??????loader</option>
								<option value="2" >??????loader</option>
								<option value="3" >????????????loader</option>
							</select>
						</td>
					</tr>
					<tr class="pc_loader_tp_showtime" id="loader_tp_showtime" style="display:none;">
					    <td >???????????????</td>
						<td >
                        <input type="text" name="pc_tp_loader_showtime" id = "pc_tp_loader_showtime" size="5" value = "">
						</td>
					</tr>
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >??????????????????</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????" >????????????</option>
								<option value="?????????" >?????????</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="radio" id="normal_pc_tp" name="pvimpression_pc_tp" onclick="tiepian_pc(this,0)" value="0" checked>????????????
							<input type="radio" id="vpaid_pc" name="pvimpression_pc_tp" onclick="tiepian_pc(this,1)" value="1">????????????
							<input type="radio" id="customtext" name="pvimpression_pc_tp" onclick="tiepian_pc(this,2)" value="2">trueview</td>
					</tr>
				</table><br>
				</div>
				
				<!-- ????????????(pc-????????????) -->
				<div id = "pc_vf_buyingbyseeing" style="display:none">
				<table id="pc_vf_buyingbyseeing_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>?????????????????????????????????</b></td>
					</tr>
					<tr>
						<td>????????????????????????-PC(flash)(?????????swf??????)</td>
						<td><input type="text" name="pc_vf_buyingbyseeing_ideaurl_flash" size="100"  ></td>
					</tr>
					
					<tr>
						<td>????????????/??????/??????????????????-PC(??????)</td>
						<td><input type="text" name="pc_vf_buyingbyseeing_ideaurl_png" size="100"  ></td>
					</tr>
					
					<tr>
						<td>????????????/??????/??????????????????-PC(H5)</td>
						<td><input type="text" name="pc_vf_buyingbyseeing_ideaurl_h5" size="100"  ></td>
					</tr>
					
					<tr>
						<td>??????????????????</td>
						<td>
							<select name="pc_vf_buyingbyseeing_rightpx2">
							    <option value="0" >???????????????</option>
								<option value="1" >????????????????????????????????????</option>
								<option value="2" >????????????????????????????????????????????????</option>
								<option value="3" selected >?????????????????????????????????</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>??????????????????(??????)</td>
						<td>
							<select name="pc_scenario_location" id="pc_scenario_location">
								<option value="1334,750,50,460,440,150" selected>???????????????(??????)</option>
								<option value="1334,750,50,550,266,150">????????????</option>
								<option value="1334,750,50,400,12,300">????????????</option>
								<option value="1334,750,50,590,360,90">????????????(??????)</option>
								<option value="1334,750,1018,550,266,150">????????????</option>
								<option value="1334,750,1164,400,120,300">????????????</option>
								<option value="1334,750,924,550,360,90">????????????(??????)</option>
							</select>													
						</td>
					</tr>
				</table><br>
				</div>
				
				<div id = "pc_crazy" style="display:none">
				<table id="pc_crazy_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>???crazy</b></td>
					</tr>
					<tr>
						<td>??????js??????</td>
						<td><textarea type="text" id ="textarea" name="pc_crazy_y_js" rows="10" cols="80"></textarea></td>
						<!--  
						<td><input type="button" value="filter" onclick="CutChr()"></td>
						-->
					</tr>
					<tr>
						<td>??????????????????(?????????flash)</td>
						<td><input type="text" name="pc_crazy_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="pc_crazy_youkutudou_length" value="" size="2"></td>
					</tr>
				</table><br>
				</div>
				<div id = "pc_selector" style="display:none">
				<table id="pc_selector_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>???AD selector</b></td>
					</tr>
					<tr>
						<td>??????js??????</td>
						<td><input type="text" name="pc_selector_y_js" size="100"></td>
					</tr>
					<tr>
						<td>??????????????????(?????????flash)</td>
						<td><input type="text" name="pc_selector_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="pc_selector_youkutudou_length" value="" size="100"></td>
					</tr>
					<!--  
					<tr>
						<td><input type="button" value="filter" onclick="CutChr()"></td>
					</tr>
					-->
				</table><br>
				</div>
				<div id = "pc_shortfull" style="display:none">
				<table id="pc_shortfull_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>??????????????????</b></td>
					</tr>
					<tr>
						<td>??????????????????(?????????flash)</td>
						<td><input type="text" name="pc_shortfull_y_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>??????????????????(?????????flash)</td>
						<td><input type="text" name="pc_shortfull_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>flash???</td>
						<td><input type="text" name="pc_shortfull_youkutudou_width" value="" size="2"></td>
					</tr>
					<tr>
						<td>flash???</td>
						<td><input type="text" name="pc_shortfull_youkutudou_height" value="" size="2"></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="pc_shortfull_youkutudou_length" value="" size="2"></td>
					</tr>
				</table><br>
				</div>
				<div id = "pc_vc" style="display:none">
				<table id="pc_vc_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>?????????</b></td>
					</tr>
					<tr>
						<td>??????????????????????????????(flash????????????)</td>
						<td><input type="text" name="pc_vc_y_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>??????????????????????????????(H5????????????)-??????/????????????</td>
						<td><input type="text" name="pc_vc_y_ideaurl_h5" size="100"></td>
					</tr>
					<tr>
						<td>??????????????????????????????(??????????????????)</td>
						<td><input type="text" name="pc_vc_y_ideaurl_img" size="100"></td>
					</tr>
					<tr>
						<td>????????????????????????</td>
						<td>
							<select name="pc_vc_y_rightpx2">
							    <option value="0" >???????????????</option>
								<option value="1" >????????????????????????????????????(CF1)</option>
								<option value="2" >????????????????????????????????????????????????(CF2)</option>
								<option value="3" selected >?????????????????????????????????(CF3)</option>
								<option value="4" >????????????????????????????????????????????????(CF4)</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>??????????????????????????????(?????????flash??????????????????)</td>
						<td><input type="text" name="pc_vc_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>????????????????????????</td>
						<td>
							<select name="pc_vc_t_rightpx2">
							    <option value="0" >???????????????</option>
								<option value="1" >????????????????????????????????????(CF1)</option>
								<option value="2" >????????????????????????????????????????????????(CF2)</option>
								<option value="3" selected >?????????????????????????????????(CF3)</option>
								<option value="4" >????????????????????????????????????????????????(CF4)</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>??????????????????</td>
						<td><input type="radio" id="bottom_left" name="pc_vc_position" value="0" checked>??????
						    <input type="radio" id="bottom_right" name="pc_vc_position" value="1">??????
							<input type="radio" id="bottom_center" name="pc_vc_position" value="2">??????
							<input type="radio" id="top_left" name="pc_vc_position" value="3">??????
							<input type="radio" id="top_right" name="pc_vc_position" value="4">??????
							<input type="radio" id="top_center" name="pc_vc_position" value="5">??????</td>
							
					</tr>
					<!-- comment
					<tr>
						<td>???????????????</td>
						<td><input type="radio" id="zero_minute" name="vc_time_spot" value="0" onclick="getvalue(this.value)" checked>0??????
						    <input type="radio" id="one_minute" name="vc_time_spot" value="1" onclick="getvalue(this.value)">1??????
							<input type="radio" id="five_minute" name="vc_time_spot" value="5" onclick="getvalue(this.value)">5??????
							<input type="radio" id="twenty_minitue" name="vc_time_spot" value="20" onclick="getvalue(this.value)">20???????????????</td>		
					</tr>
					-->
					<tr>
						<td>????????????</td>
					<!-- comment	
						<td><input type="text" name="pc_vc_showtime" id = "pc_vc_showtime" size="5" value = "45" onmouseout="checkadlen(this)"></td>
					-->
						<td><input type="text" name="pc_vc_showtime" id = "pc_vc_showtime" size="5" value = "45"></td>
					</tr>
					<tr>
						<td>?????????????????????</td>
						<td><input type="text" name="pc_vc_width" id = "pc_vc_width" size="5" value = ""></td>
					</tr>
					<tr>
						<td>?????????????????????</td>
						<td><input type="text" name="pc_vc_height" id = "pc_vc_height" size="5" value = ""></td>
					</tr>
					
					
					 <tr>
						<td>pc??????????????????</td>
						<td>
							<select name="pc_vc_close_method">
								<option value="1" selected>????????????</option>
								<option value="2" >??????</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>??????????????????(??????)</td>
						<td>
							<select name="pc_vc_location" id="pc_vc_location">
								<option value="1334,750,50,460,440,150" selected>?????????</option>
								<option value="1334,750,50,550,266,150">??????(????????????)</option>
								<option value="1334,750,50,400,120,300">??????(????????????)</option>
								<option value="1334,750,50,590,360,90">??????(????????????)</option>
								<option value="1334,750,1018,550,266,150">??????(????????????)</option>
								<option value="1334,750,1164,400,120,300">??????(????????????)</option>
								<option value="1334,750,924,550,360,90">??????(????????????)</option>
								<option value="1334,750,0,450,1334,300">????????????</option>
							</select>													
						</td>
					</tr>
					
					<tr>
						<td colSpan="2" color="red"></td>
					</tr>
				</table><br>
				</div>

                <!-- pc_mi_iku_kaijitu -->
                <div id = "pc_vi" style="display:none">
				<table id="m_mi_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>????????????</b></td>
					</tr>
					<tr>
						<td>???????????? PCIKU-1024x650(???????????????)</td>
						<td><input type="text" name="m_iku_pc_ideaurl_650" size="100"></td>
					</tr>
					<tr>
						<td>???????????? PCIKU-1270x720(???????????????)</td>
						<td><input type="text" name="m_iku_pc_ideaurl_720" size="100"></td>
					</tr>
					
					<tr>
						<td>????????????</td>
						<td><input type="text" name="m_mi_atv_t_pc_iku" value="5" size="5"></td>
					</tr>
				</table><br>
				</div>
				
				<div id = "pc_biaoban" style="display:none">
				<table id="pc_biaoban_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>????????????</b></td>
					</tr>
					<tr>
						<td>??????????????????</td>
						<td><input type="text" name="pc_biaoban_y_ideaurl" id="pc_biaoban_y_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
				</table><br>
				</div>
				
				<div id = "pc_faceoff" style="display:none">
				<table id="pc_faceoff_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>pc????????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="pc_faceoff_ideaurl" id="pc_faceoff_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
				</table><br>
				</div>
				
				<div id = "pc_bf" style="display:none">
				<table id="pc_bf_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>pc_bf???????????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="pc_bf_ideaurl" id="pc_bf_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
				</table><br>
				</div> 
				
			    <div id = "pc_overlay_float" style="display:none">
				<table id="pc_overlay_float_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>PC???????????????</b></td>
					</tr>
					<tr>
						<td>????????????????????????</td>
						<td><input type="text" name="pc_overlay_float_pic_ideaurl" id="pc_overlay_float_pic_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
					
					<tr>
						<td>??????flash????????????</td>
						<td><input type="text" name="pc_overlay_float_swf_ideaurl" id="pc_overlay_float_swf_ideaurl" size="100" ></td>
					</tr>
					
					<tr>
						<td>??????h5????????????</td>
						<td><input type="text" name="pc_overlay_float_h5_ideaurl" id="pc_overlay_float_h5_ideaurl" size="100" ></td>
					</tr>
					
				</table><br>
				</div>
				
				<div id = "pc_seeds" style="display:none">
				<table id="pc_seeds_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>PC???????????????</b></td>
					</tr>
					<tr>
						<td>??????????????????</td>
						<td><input type="text" name="pc_seeds_ideaurl" id="pc_seeds_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
					
					<tr>
						<td>??????</td>
						<td><input type="text" name="pc_seeds_title" id="pc_seeds_title" size="100" ></td>
					</tr>
					
					<tr>
						<td>??????</td>
						<td><input type="text" name="pc_seeds_cover" id="pc_seeds_cover" size="100" ></td>
					</tr>
					
					<tr class="pc_feedsvideo_pos" id="pc_feedsvideo_pos" style="display:;">
						<td>pc???????????????????????????*</td>
						<td>
				        <select name="pc_feeds_pos" id="pc_feeds_pos" >
						<%
							for (int i = -1; i < pcfeedsvideo.size() ; i++) {
								if(i==-1){							
						%>		
								   <option value="" selected> </option>   
						<%
								}else{
								   AdPosition adPositionFeedsVideo = pcfeedsvideo.get(i);
					   %>
					               <option value="<%=adPositionFeedsVideo.getId()%>"><%=adPositionFeedsVideo.getName() + "("+ adPositionFeedsVideo.getPageComment() + ") " + "?????????:" + adPositionFeedsVideo.getReqPoint()%></option>                   											                        
						<%									
							}}
						%>							                        
						</select>
						</td>
					</tr>
					
				</table><br>
				</div>
				          
				</div>
				
				<div id="mdevice" style="display:none">
				<div id = "m_vf" style="display:">
				<table id="m_vf_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>????????????</b></td>
					</tr>
					
					<tr>
						<td>????????????</td>
						<td>
							<select name="m_qtsdk" id="m_qtsdk" onchange="show_sdkid(this.value,'qiantie_idea')">
								<option value="0">????????????</option>
								<%
									
										List<SdkName> sdklist = SdkNamePeer.doSelect(new Criteria());
										for(int j=0;j<sdklist.size();j++) {
											int sdkid = sdklist.get(j).getId();
								%>
								<option value="<%=sdkid%>"><%=sdklist.get(j).getName()%>??????</option><%
										}
									
								%>
							</select>							
							
						</td>
					</tr>
					
					<tr class="qiantie_idea" id="m_vf_ideaurl_mb">
						<td>????????????(?????????flv??????)-hvideo?????????  <font color='red'>*</font>
						<td><input type="text" name="m_vf_ideaurl" id="m_vf_ideaurl" placeholder="????????????  http://???https://???????????? flv???flv???html???swf ?????????????????????" size="100"  ></td>
					</tr>
					
					<tr>
						<td>PIP????????????</td>
						<td><input type="text" name="m_vf_pipurl" size="100"></td>
					</tr>
					
					<tr class="h5_idea_phone" id="m_h5_vf_ideaurl_phone" style="display:none;">
						<td>phone?????????????????????</td>
						<td><input type="text" name="m_h5_vf_ideaurl_phone" size="100" ></td>
					</tr>
					
					<tr class="h5_idea_pad" id="m_h5_vf_ideaurl_pad" style="display:none;">
						<td>pad?????????????????????</td>
						<td><input type="text" name="m_h5_vf_ideaurl_pad" size="100" ></td>
					</tr>
					
					<tr class="h5_hvideo_1" id="h5_hvideo_1" style="display:none;">
						<td>????????????1??????:</td>
						<td><input type="text" name="h5_hvideo_1_url" size="100" ></td>
					</tr>
					
					<tr class="h5_hvideo_2" id="h5_hvideo_2" style="display:none;">
						<td>????????????2??????:</td>
						<td><input type="text" name="h5_hvideo_2_url" size="100" ></td>
					</tr>
					
					<tr class="Phone-H5" id="Phone-H5" style="display:none;">
						<td>Phone-H5??????:</td>
						<td><input type="text" name="Phone-H5_url" size="100" ></td>
					</tr>
					
					<tr class="Pad-H5" id="Pad-H5" style="display:none;">
						<td>Pad-H5??????:</td>
						<td><input type="text" name="Pad-H5_url" size="100" ></td>
					</tr>
					
					<tr class="main_h5_mf_url_t" id="main_h5_mf_url_t" style="display:none;">
						<td>??????????????????(???)<font color='red'>*</font>
						<td><input type="text" name="main_h5_mf_url_t" size="10" ></td>
					</tr>
					
					<tr class="h5_mf_url_t1" id="h5_mf_url_t1" style="display:none;">
						<td>????????????1????????????(???)<font color='red'>*</font>
						<td><input type="text" name="h5_mf_url_t1" size="10" ></td>
					</tr>
					
					<tr class="h5_mf_url_t2" id="h5_mf_url_t2" style="display:none;">
						<td>????????????2????????????(???)<font color='red'>*</font>
						<td><input type="text" name="h5_mf_url_t2" size="10" ></td>
					</tr>
					
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >??????????????????</td>
						<td >
						    <select name="custom_text_mf" id="custom_text_mf" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????" >????????????</option>
								<option value="?????????" >?????????</option>
							</select>
						</td>
					</tr>
					
					<tr class="mf_url_onebuy_type" id="mf_url_onebuy_type" style="display:none;">
					    <td >???????????????</td>
						<td >
						    <select name="mf_oneBuy_type" id="mf_oneBuy_type" >
								<option value="26" selected>??????</option>
								<option value="27" >??????</option>
							</select>
						</td>
					</tr>
					
					<tr class="mf_goodid" id="mf_goodid" style="display:none;">
						<td>??????ID<font color='red'>*</font>
						<td><input type="text" name="mf_good_id" size="20" ></td>
					</tr>
					
					<tr class="mf_taobaoerid" id="mf_taobaoerid" style="display:none;">
						<td>??????ID<font color='red'>*</font>
						<td><input type="text" name="mf_taobaoer_id" size="20" ></td>
					</tr>
					
					<tr class="mf_onebuy_h5" id="mf_onebuy_h5" style="display:none;">
						<td>h5????????????(phone&&pad)
						<td><input type="text" name="mf_onebuy_h5_url" placeholder="http://r1.ykimg.com/material/0A03/AD_guoqiang/h5corner/266x150/index1018.html" size="100" ></td>
					</tr>
					
					<tr class="mf_onebuy_h5_width_height" id="mf_onebuy_h5_width_height" style="display:none;">
						<td>h5?????????,???
						<td><input type="text" name="mf_onebuy_h5_width" value="0" size="10" >
						<input type="text" name="mf_onebuy_h5_height" value="0" size="10" ></td>
					</tr>
					
					<tr class="ott_onebuy_png" id="ott_onebuy_png" style="display:none;">
						<td>???????????????????????????(??????-ott&phone&pad)
						<td><input type="text" name="ott_onebuy_png_url" placeholder="http://r1.ykimg.com/material/0A03/daily/201808/0815/3001346/1534304237866/0D0100005B73A4786395103042443537.jpg" size="150" ></td>
					</tr>
					
					<tr>
						<td>????????????</td>
						<td><input type="radio" id="normal" name="pvimpression" onclick="tiepian_m(this,0)" value="0" checked>????????????
							<input type="radio" id="vpaid" name="pvimpression" onclick="tiepian_m(this,1)" value="1">????????????
							<input type="radio" id="customtext_m" name="pvimpression" onclick="tiepian_m(this,2)" value="2">trueview
							<input type="radio" id="onebuttonbuy" name="pvimpression" onclick="tiepian_m(this,3)" value="3">?????????</td>
					</tr>
					
					<tr>
						<td>?????????????????????</td>
						<td>
							<select name="m_qiantie_install_tip" id="m_qiantie_install_tip" onchange="show_m_qiantie_install_tip(this.value)">
								<option value="1" selected>NO</option>
								<option value="0">YES</option>
							</select>													
						</td>
					</tr>
					
					<tr class="m_qiantie_install_icon" id="m_qiantie_install" style="display:none;">
						<td>icon????????????(90*90)</td>
						<td><input type="text" name="m_qiantie_install_icon_ideaurl" id="m_qiantie_install_icon_ideaurl" placeholder="??????gif???jpg???jpeg???png???bmp??????" size="100"  ></td>
					</tr>
					<tr class="m_qiantie_install_text" id="m_qiantie_install_hit" style="display:none;">
						<td>??????????????????</td>
						<td><input type="text" name="m_qiantie_install_hitcontent" id="m_qiantie_install_hitcontent" placeholder="??????14?????????" size="100"  ></td>
					</tr>
					
				</table><br>
				</div>
				<div id = "m_vb" style="display:none">
				<table id="m_vb_table" style="border: solid thin blue">
					<tr class="houtie_idea" id="m_vb_ideaurl_mb">
						<td colSpan="2"><b>????????????</b></td>
					</tr>
					<tr>
						<td>????????????(?????????flv??????)</td>
						<td><input type="text" name="m_vb_ideaurl" placeholder="????????????  http://???https://???????????? flv???flv???html???swf ?????????????????????" size="100"  ></td>
					</tr>
					
					<tr class="h5_idea_phone_mb" id="m_h5_vb_ideaurl_phone" style="display:none;">
						<td>phone?????????????????????</td>
						<td><input type="text" name="m_h5_vb_ideaurl_phone" size="100" ></td>
					</tr>
					
					<tr class="h5_idea_pad_mb" id="m_h5_vb_ideaurl_pad" style="display:none;">
						<td>pad?????????????????????</td>
						<td><input type="text" name="m_h5_vb_ideaurl_pad" size="100" ></td>
					</tr>
					
					<tr class="h5_vb_showtime" id="h5_vb_ideaurl_showtime" style="display:none;">
						<td>????????????</td>
						<td><input type="text" name="h5_vb_ideaurl_showtime" size="10" ></td>
					</tr>
					
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >??????????????????</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????" >????????????</option>
								<option value="?????????" >?????????</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>????????????</td>
						<td><input type="radio" id="normal" name="pvimpression_mb" onclick="tiepian_mb(this,0)" value="0" checked>????????????
							<input type="radio" id="vpaid" name="pvimpression_mb" onclick="tiepian_mb(this,1)" value="1">????????????
							<input type="radio" id="customtext_m" name="pvimpression_mb" onclick="tiepian_mb(this,2)" value="2">trueview</td>
					</tr>
					
					<tr>
						<td>?????????????????????</td>
						<td>
							<select name="m_houtie_install_tip" id="m_houtie_install_tip" onchange="show_m_houtie_install_tip(this.value)">
								<option value="1" selected>NO</option>
								<option value="0">YES</option>
							</select>													
						</td>
					</tr>
					
					<tr class="m_houtie_install_icon" id="m_houtie_install" style="display:none;">
						<td>icon????????????(90*90)</td>
						<td><input type="text" name="m_houtie_install_icon_ideaurl" id="m_houtie_install_icon_ideaurl" placeholder="??????gif???jpg???jpeg???png???bmp??????" size="100"  ></td>
					</tr>
					<tr class="m_houtie_install_text" id="m_houtie_install_hit" style="display:none;">
						<td>??????????????????</td>
						<td><input type="text" name="m_houtie_install_hitcontent" id="m_houtie_install_hitcontent" placeholder="??????14?????????" size="100"  ></td>
					</tr>
					
				</table><br>
				</div>
				
				
				<div id = "m_vtp" style="display:none">
				<table id="m_vtp_table" style="border: solid thin blue">
					<tr class="tiepian_idea" id="m_vtp_ideaurl_mtp">
						<td colSpan="2"><b>????????????</b></td>
					</tr>
					<tr>
						<td>????????????(?????????flv??????)</td>
						<td><input type="text" name="m_vtp_ideaurl" size="100"  ></td>
					</tr>
					
					<tr class="h5_idea_phone_mtp" id="m_h5_vtp_ideaurl_phone" style="display:none;">
						<td>phone?????????????????????</td>
						<td><input type="text" name="m_h5_vtp_ideaurl_phone" size="100" ></td>
					</tr>
					
					<tr class="h5_idea_pad_mtp" id="m_h5_vtp_ideaurl_pad" style="display:none;">
						<td>pad?????????????????????</td>
						<td><input type="text" name="m_h5_vtp_ideaurl_pad" size="100" ></td>
					</tr>
					
					<tr class="h5_vtp_showtime" id="h5_vtp_ideaurl_showtime" style="display:none;">
						<td>????????????</td>
						<td><input type="text" name="h5_vtp_ideaurl_showtime" size="10" ></td>
					</tr>
					
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >??????????????????</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????" >????????????</option>
								<option value="?????????" >?????????</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>????????????</td>
						<td><input type="radio" id="normal" name="pvimpression_mtp" onclick="tiepian_mtp(this,0)" value="0" checked>????????????
							<input type="radio" id="vpaid" name="pvimpression_mtp" onclick="tiepian_mtp(this,1)" value="1">????????????
							<input type="radio" id="customtext_m" name="pvimpression_mtp" onclick="tiepian_mtp(this,2)" value="2">trueview</td>
					</tr>
					
				</table><br>
				</div>
				
				
				<div id = "m_vp" style="display:none">
				<table id="m_vp_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>????????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td>
							<select name="m_ztsdk" id="m_ztsdk" onchange="show_sdkid(this.value,'zanting_idea')">
								<option value="0">????????????</option>
								<%
									
										//List<SdkName> sdklist = SdkNamePeer.doSelect(new Criteria());
										for(int j=0;j<sdklist.size();j++) {
											int sdkid = sdklist.get(j).getId();
								%>
								<option value="<%=sdkid%>"><%=sdklist.get(j).getName()%>??????</option><%
										}
									
								%>
							</select>
							
							
						</td>
					</tr>
					<tr class="zanting_idea" id="m_vp_ideaurl">
						<td>????????????(????????????gif???png???video????????????)</td>
						<td><input type="text" name="m_vp_ideaurl" size="100"></td>
					</tr>
					<tr class="zanting_idea_ott" id="m_vp_ott_ideaurl">
						<td>OTT????????????(???????????????)</td>
						<td><input type="text" name="m_vp_ott_ideaurl" size="100"></td>
					</tr>
					<tr class="zanting_qr_text" >
						<td>OTT???????????????:</td>
					</tr>
					<tr class="zanting_is_qr" >
						<td>???????????????</td>
						<td>
						<select name="m_vp_is_qr" >
						<option value="0" selected>???</option>
						<option value="1" >???</option>
					    </select>
						</td>
					</tr>
					<tr class="zanting_vq_url" id="m_vp_vq_url">
						<td>?????????Logo??????</td>
						<td><input type="text" name="m_vp_vq_url" size="100"></td>
					</tr>
					
					<tr>
						<td>?????????????????????</td>
						<td>
							<select name="m_zanting_install_tip" id="m_zanting_install_tip" onchange="show_m_zanting_install_tip(this.value)">
								<option value="1" selected>NO</option>
								<option value="0">YES</option>
							</select>													
						</td>
					</tr>
					
					<tr class="m_zanting_install_icon" id="m_zanting_install" style="display:none;">
						<td>icon????????????(90*90)</td>
						<td><input type="text" name="m_zanting_install_icon_ideaurl" id="m_zanting_install_icon_ideaurl" placeholder="??????gif???jpg???jpeg???png???bmp??????" size="100"  ></td>
					</tr>
					<tr class="m_zanting_install_text" id="m_zanting_install_hit" style="display:none;">
						<td>??????????????????</td>
						<td><input type="text" name="m_zanting_install_hitcontent" id="m_zanting_install_hitcontent" placeholder="??????14?????????" size="100"  ></td>
					</tr>
					
				</table><br>
				</div>
				<div id = "m_vc" style="display:none">
				<table id="m_vc_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>????????????</b></td>
					</tr>
					<tr>
						<td>????????????????????????(???????????????*)</td>
						<td><input type="text" name="m_vc_openstatus_pageurl" size="100"></td>
					</tr>
					<tr>
						<td>????????????????????????(???????????????)(???????????????*)</td>
						<td><input type="text" name="m_vc_closestatus_pageurl" size="100"></td>
					</tr>
					<tr>
						<td>????????????(PAD-W*H)(???????????????*)</td>
						<td><input type="text" name="m_vc_pad" size="100"></td>
					</tr>
					<tr>
						<td>????????????(PHONE-W*H)(???????????????*)</td>
						<td><input type="text" name="m_vc_phone" size="100"></td>
					</tr>
					
					<tr>
						<td>H5????????????(???????????????*)</td>
						<td><input type="text" name="m_vc_h5" size="100"></td>
					</tr>
					
					<tr>
						<td>OTT????????????(??????)</td>
						<td><input type="text" name="m_ott_vc" size="100"></td>
					</tr>
					
					<tr>
						<td>??????????????????(??????)</td>
						<td>
							<select name="m_mc_location" id="m_mc_location">
								<option value="1334,750,50,460,440,150" selected>?????????</option>
								<option value="1334,750,50,550,266,150">??????(????????????)</option>
								<option value="1334,750,50,400,120,300">??????(????????????)</option>
								<option value="1334,750,50,590,360,90">??????(????????????)</option>
								<option value="1334,750,1018,550,266,150">??????(????????????)</option>
								<option value="1334,750,1164,400,120,300">??????(????????????)</option>
								<option value="1334,750,924,550,360,90">??????(????????????)</option>
								<option value="1334,750,0,450,1334,300">????????????</option>
							</select>													
						</td>
					</tr>
					
					<tr>
						<td>????????????(???????????????*)</td>
						<td><input type="text" name="m_mc_atv_t" value="15" size="5"></td>
					</tr>
				</table><br>
				</div>
				<div id = "m_mi" style="display:none">
				<table id="m_mi_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>???????????????</b></td>
					</tr>
					<tr>
						<td>???????????? iPad-1024*768(2048*1536)(???????????????)</td>
						<td><input type="text" name="m_mi_ipad_ideaurl_768" size="100"></td>
					</tr>
					<!--  
					<tr>
						<td>???????????? iPad-768*1004(???????????????)</td>
						<td><input type="text" name="m_mi_ipad_ideaurl_1004" size="100"></td>
					</tr>
					-->
					<tr>
						<td>???????????? iPhone-640*960(???????????????)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_940" size="100"></td>
					</tr>
					<tr>
						<td>???????????? iPhone-640*1136(???????????????)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_1116" size="100"></td>
					</tr>
					<tr>
						<td>???????????? iphone6-750*1334(???????????????)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_1334" size="100"></td>
					</tr>
					<tr>
						<td>???????????? iphone6 Plus-828*1472(???????????????)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_1920" size="100"></td>
					</tr>
					<tr>
						<td>???????????? IPhoneX-1125*2436</td>
						<td><input type="text" name="m_mi_iphonex_ideaurl_1125" size="100"></td>
					</tr>
					
					<tr>
						<td>???????????? AndroidPhone-Xiami_720*1280(??????)</td>
						<td><input type="text" name="m_mi_aphone_ideaurl_xiami" size="100"></td>
					</tr>
					
					<tr>
						<td>???????????? AndroidPAD-800*1280(???????????????)</td>
						<td><input type="text" name="m_mi_apad_ideaurl_800" size="100"></td>
					</tr>
					<tr>
						<td>???????????? AndroidPAD-600*1024(???????????????)</td>
						<td><input type="text" name="m_mi_apad_ideaurl_600" size="100"></td>
					</tr>
					
					<tr>
						<td>???????????? AndroidPAD-768*1024(???????????????)</td>
						<td><input type="text" name="m_mi_apad_ideaurl_768" size="100"></td>
					</tr>
					
					<tr>
						<td>???????????? AndroidPhone-720*1280(???????????????)</td>
						<td><input type="text" name="m_mi_aphone_ideaurl_1280" size="100"></td>
					</tr>
					<tr>
						<td>???????????? AndroidPhone-480*800(???????????????)</td>
						<td><input type="text" name="m_mi_aphone_ideaurl_800" size="100"></td>
					</tr>
					
					<!-- ??????Android????????????(??????Mate10,opp r15 vivo x21) ?????? 2280*1280????????????????????? ????????????????????????  ??????????????????ADM???????????? ???????????? 2280*1280 ???????????????-->
					<tr>
						<td>???????????? AndroidPhone-2280*1280(???????????????-??????Mate10,opp r15 vivo x21)</td>
						<td><input type="text" name="m_mi_aphone_ideaurl_2280" size="100"></td>
					</tr>
					
					<tr>
						<td>???????????? AndroidTV-1280*720(???????????????)</td>
						<td><input type="text" name="m_mi_atv_ideaurl_720" size="100"></td>
					</tr>
					<tr>
						<td>???????????? iphone-1080*1920(??????)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_xiami" size="100"></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="m_mi_atv_t" value="5" size="5"></td>
					</tr>
					<tr>
						<td>????????????1</td>
						<td><input type="text" name="m_mi_atv_text" value="????????????????????????(???????????????idea_monitor.content)-TI" size="50"> <font color='red'>  *</font>
					</tr>
					<tr>
						<td>????????????2</td>
						<td><input type="text" name="m_mi_atv_text1" value="??????,??????(???????????????idea_url.text2)-TX" size="50"></td>
					</tr>
					<tr>
						<td>????????????????????????</td>
						<td><input type="text" name="co_banner_idea" value="" size="100"></td>
					</tr>
					<tr>
						<td>pad??????????????????(??????????????????(??????))</td>
						<td><textarea id="text" name="m_mi_ipad_landscape_idea" placeholder="???????????????????????????????????????????????????????????????????????????" rows="10" cols="120"></textarea></td>
					</tr>
					<tr>
						<td>phone??????????????????(??????????????????(??????))</td>
						<td><textarea id="text" name="m_mi_iphone_portrait_idea" placeholder="???????????????????????????????????????????????????????????????????????????" rows="10" cols="120"></textarea></td>
					</tr>
					
					<tr>
						<td>iphonex??????????????????</td>
						<td><textarea id="text" name="m_mi_iphonex_video_idea" placeholder="???????????????????????????????????????????????????????????????????????????" rows="10" cols="120"></textarea></td>
					</tr>
									
					<tr>
						<td>??????????????????</td>
						<td>
							<select name="skip_button_text" id="skip_button_text" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????">????????????</option>
							</select>													
						</td>
					</tr>
										
				</table><br>
				</div>
							
				<!-- ????????????-->
				<div id = "m_mQP" style="display:none">
				<table id="m_mQP_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>????????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td>
							<select name="m_sdk" id="m_sdk" onchange="show_sdkid(this.value,'quanping_idea')">
								<option value="0">????????????</option>
								<%
									
										sdklist = SdkNamePeer.doSelect(new Criteria());
										for(int j=0;j<sdklist.size();j++) {
											int sdkid = sdklist.get(j).getId();
								%>
								<option value="<%=sdkid%>"><%=sdklist.get(j).getName()%>??????</option><%
										}
									
								%>
							</select>
							
							
						</td>
					</tr>
					<tr class="quanping_idea" id="m_mQP_ideaurl">
						<td>???????????? YK(IPAD-1024*768)</td>
						<td><input type="text" name="m_mqp_ipad_ideaurl_748" size="100"></td>
					</tr>
					<tr class="quanping_idea" id="m_mQP_ideaurl">
						<td>???????????? YK(IPhone-854*480)</td>
						<td><input type="text" name="m_mqp_iphone_ideaurl_480" size="100"></td>
					</tr>
					<tr class="quanping_idea" id="m_mQP_ideaurl">
						<td>???????????? YK(AndroidPAD-1280*720)</td>
						<td><input type="text" name="m_mqp_androidpad_ideaurl_720" size="100"></td>
					</tr>
					<tr class="quanping_idea" id="m_mQP_ideaurl">
						<td>???????????? YK(AndroidPhone-854*480)</td>
						<td><input type="text" name="m_mqp_androidphone_ideaurl_480" size="100"></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="m_quanping_showtime" id = "m_quanping_showtime" size="5" value = "5" ></td>
					</tr>
					
					<tr>
						<td>?????????????????????</td>
						<td>
							<select name="m_fullscreen_install_tip" id="m_fullscreen_install_tip" onchange="show_m_fullscreen_install_tip(this.value)">
								<option value="1" selected>NO</option>
								<option value="0">YES</option>
							</select>													
						</td>
					</tr>
					
					<tr class="m_fullscreen_install_icon" id="m_fullscreen_install" style="display:none;">
						<td>icon????????????(90*90)</td>
						<td><input type="text" name="m_fullscreen_install_icon_ideaurl" id="m_fullscreen_install_icon_ideaurl" placeholder="??????gif???jpg???jpeg???png???bmp??????" size="100"  ></td>
					</tr>
					<tr class="m_fullscreen_install_text" id="m_fullscreen_install_hit" style="display:none;">
						<td>??????????????????</td>
						<td><input type="text" name="m_fullscreen_install_hitcontent" id="m_fullscreen_install_hitcontent" placeholder="??????14?????????" size="100"  ></td>
					</tr>
					
				</table><br>
				</div>
				
				<!-- ????????????-->
			    <div id = "m_mo" style="display:none">
				<table id="m_mo_table" style="border: solid thin blue">
					<tr class="zhongcha_idea" id="m_vo_ideaurl_mo">
						<td colSpan="2"><b>????????????</b></td>
					</tr>
					<tr>
						<td>????????????(?????????flv??????)</td>
						<td><input type="text" name="m_mo_ideaurl" placeholder="????????????  http://???https://???????????? flv???flv???html???swf ?????????????????????" size="100" ></td>
					</tr>
					
					<tr class="h5_idea_phone_mo" id="m_h5_vo_ideaurl_phone" style="display:none;">
						<td>phone?????????????????????</td>
						<td><input type="text" name="m_h5_vo_ideaurl_phone" size="100" ></td>
					</tr>
					
					<tr class="h5_idea_pad_mo" id="m_h5_vo_ideaurl_pad" style="display:none;">
						<td>pad?????????????????????</td>
						<td><input type="text" name="m_h5_vo_ideaurl_pad" size="100" ></td>
					</tr>
					
					<tr class="h5_vo_showtime" id="h5_vo_ideaurl_showtime" style="display:none;">
						<td>????????????</td>
						<td><input type="text" name="h5_vo_ideaurl_showtime" size="10" ></td>
					</tr>
					
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >??????????????????</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="????????????" selected>????????????</option>
								<option value="????????????" >????????????</option>
								<option value="?????????" >?????????</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>????????????</td>
						<td><input type="radio" id="normal" name="pvimpression_mo" onclick="tiepian_mo(this,0)" value="0" checked>????????????
							<input type="radio" id="vpaid" name="pvimpression_mo" onclick="tiepian_mo(this,1)" value="1">????????????
							<input type="radio" id="customtext_m" name="pvimpression_mo" onclick="tiepian_mo(this,2)" value="2">trueview</td>
					</tr>
					
					<tr>
						<td>?????????????????????</td>
						<td>
							<select name="m_zhongcha_install_tip" id="m_zhongcha_install_tip" onchange="show_m_zhongcha_install_tip(this.value)">
								<option value="1" selected>NO</option>
								<option value="0">YES</option>
							</select>													
						</td>
					</tr>
					
					<tr class="m_zhongcha_install_icon" id="m_zhongcha_install" style="display:none;">
						<td>icon????????????(90*90)</td>
						<td><input type="text" name="m_zhongcha_install_icon_ideaurl" id="m_zhongcha_install_icon_ideaurl" placeholder="??????gif???jpg???jpeg???png???bmp??????" size="100"  ></td>
					</tr>
					<tr class="m_zhongcha_install_text" id="m_zhongcha_install_hit" style="display:none;">
						<td>??????????????????</td>
						<td><input type="text" name="m_zhongcha_install_hitcontent" id="m_zhongcha_install_hitcontent" placeholder="??????14?????????" size="100"  ></td>
					</tr>
					
				</table><br>
				</div>
				<!-- ???????????? end -->	
	            
	            <!-- mb_???????????? -->
	            <div id = "mb_biaoban" style="display:none">
				<table id="mb_biaoban_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>??????????????????</b></td>
					</tr>
					<tr>
						<td>??????????????????</td>
						<td><input type="text" name="mb_biaoban_y_ideaurl" id="mb_biaoban_y_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
				</table><br>
				</div>
	            
				<!-- ?????????start -->
				<div id = "m_mhtml" style="display:none">
				<table id="m_mhtml_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>?????????(1411701755)-ipad??????????????????</b></td>
					</tr>
					<tr>
						<td>??????????????????</td>
						<td><input type="text" name="m_mhtml_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>????????????*</td>
						<td><input type="text" name="m_mhtml_text_content" size="100" ></td>
					</tr>
					<tr>
						<td>????????????(?????????????????????)*</td>
						<td><input type="text" name="m_mhtml_clickurl" size="100" ></td>
					</tr>
					<tr>
						<td>????????????????????????class??????)</td>
						<td><input type="text" name="m_mhtml_textlayout" size="100" ></td>
					</tr>
					<tr>
						<td>??????????????????</td>
						<td><input type="text" name="m_mhtml_show" size="100" ></td>
					</tr>
					<tr>
						<td>??????????????????</td>
						<td><input type="text" name="m_mhtml_click" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- ?????????end -->
				
				<!-- ??????app?????????banner_start -->
				<div id = "m_searchBanner" style="display:none">
				<table id="m_searchBanner_table" style="border: solid thin blue">
				    <tr>
						<td colSpan="2"><b>??????app?????????banner(1430711337)mhtml-ipad??????????????????</b></td>
					</tr>
					<tr>
						<td>????????????*</td>
						<td>
							<select name="app_search_banner_type" onChange=app_search_banner(this.value)>
								<option value="1" selected>????????????</option>
								<option value="2" >??????sdk</option>
							</select>
						</td>
					</tr>
					<tr class="app_search_banner_youkupip_url" id="app_search_banner_youkupip_url" style="display:;">
						<td>????????????????????????</td>
						<td><input type="text" name="app_search_banner_youkupip_url" size="100" ></td>
					</tr>
					<tr class="app_search_banner_youkupip_clickurl" id="app_search_banner_youkupip_clickurl" style="display:;">
						<td>?????????????????????????????????</td>
						<td><input type="text" name="app_search_banner_youkupip_clickurl" size="100" ></td>
					</tr>
					<tr class="app_search_banner_youkupip_showurl" id="app_search_banner_youkupip_showurl" style="display:;">
						<td>????????????????????????</td>
						<td><input type="text" name="app_search_banner_youkupip_showurl" size="100" ></td>
					</tr>
					
					<tr class="app_search_banner_youkupip_clickmonitorurl" id="app_search_banner_youkupip_clickmonitorurl" style="display:;">
						<td>????????????????????????</td>
						<td><input type="text" name="app_search_banner_youkupip_clickmonitor" size="100" ></td>
					</tr>
					
					<tr class="app_search_banner_tudoupip_url" id="app_search_banner_tudoupip_url" style="display:;">
						<td>????????????????????????</td>
						<td><input type="text" name="app_search_banner_tudoupip_url" size="100" ></td>
					</tr>
					<tr class="app_search_banner_tudoupip_clickurl" id="app_search_banner_tudoupip_clickurl" style="display:;">
						<td>??????????????????</td>
						<td><input type="text" name="app_search_banner_tudoupip_clickurl" size="100" ></td>
					</tr>
					<tr class="app_search_banner_tudoupip_showurl" id="app_search_banner_tudoupip_showurl" style="display:;">
						<td>??????????????????</td>
						<td><input type="text" name="app_search_banner_tudoupip_showurl" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- ??????app?????????banner_end -->
				
				<!-- ??????app?????????banner_start -->
				<div id = "m_playingBanner" style="display:none">
				<table id="m_playingBanner_table" style="border: solid thin blue">
				    <tr>
						<td colSpan="2"><b>???????????????banner(mvhtml)</b></td>
					</tr>					
					<tr>
						<td>????????????*</td>
						<td>
							<select name="app_playing_banner_pos">
								<option value="1433218285" selected>??????Android_phone/android_pad/iphone?????????banner(1433218285)-????????????</option>
								<option value="1441874967" >??????ipad?????????banner(1433218286-????????????/1441874967-????????????)-????????????</option>
								<option value="60675" >??????-PHONE_IOS_APP-????????????-BANNER-?????????????????????</option>
								<option value="60676" >??????-PAD_IOS_APP-????????????-BANNER-?????????????????????</option>
								<option value="60689" >??????-PHONE_ANDROID_WEB-????????????-BANNER-?????????????????????</option>
								<option value="60690" >??????-PHONE_ANDROID_APP-????????????-BANNER-?????????????????????</option>
							</select>
						</td>
					</tr>					
					<tr>
						<td>????????????*</td>
						<td>
							<select name="app_playing_banner_type" onChange=app_playing_banner(this.value)>
								<option value="1" selected>????????????</option>
								<option value="2" >??????sdk</option>
							</select>
						</td>
					</tr>
					<tr class="app_playing_banner_url" id="app_playing_banner_url" style="display:;">
						<td>????????????</td>
						<td><input type="text" name="app_playing_banner_url" size="100" ></td>
					</tr>
					<tr class="app_playing_banner_clickurl" id="app_playing_banner_clickurl" style="display:;">
						<td>????????????</td>
						<td><input type="text" name="app_playing_banner_clickurl" size="100" ></td>
					</tr>
					<tr class="app_playing_banner_showurl" id="app_playing_banner_showurl" style="display:;">
						<td>???????????????????????????</td>
						<td><input type="text" name="app_playing_banner_showurl" size="100" ></td>
					</tr>
					<tr class="app_playing_banner_clickmonitor_url" id="app_playing_banner_clickmonitor_url" style="display:;">
						<td>??????????????????</td>
						<td><input type="text" name="app_playing_banner_clickmonitor_url" size="100" ></td>
					</tr>
					
					<tr>
						<td>?????????????????????</td>
						<td>
							<select name="m_playing_banner_install_tip" id="m_playing_banner_install_tip" onchange="show_m_playing_banner_install_tip(this.value)">
								<option value="1" selected>NO</option>
								<option value="0">YES</option>
							</select>													
						</td>
					</tr>
					
					<tr class="m_playing_banner_install_icon" id="m_playing_banner_install" style="display:none;">
						<td>icon????????????(90*90)</td>
						<td><input type="text" name="m_playing_banner_install_icon_ideaurl" id="m_playing_banner_install_icon_ideaurl" placeholder="??????gif???jpg???jpeg???png???bmp??????" size="100"  ></td>
					</tr>
					<tr class="m_playing_banner_install_text" id="m_playing_banner_install_hit" style="display:none;">
						<td>??????????????????</td>
						<td><input type="text" name="m_playing_banner_install_hitcontent" id="m_playing_banner_install_hitcontent" placeholder="??????14?????????" size="100"  ></td>
					</tr>
					
				</table><br>
				</div>
				<!-- ??????app?????????banner_end -->
				
				<!-- ??????APP???????????????_start -->
				<div id = "m_homepage" style="display:none">
				<table id="m_homepage_table" style="border: solid thin blue">
				    <tr>
						<td colSpan="2"><b>??????APP???????????????(mhtml)/????????????banner(m)</b></td>
					</tr>					
					<tr>
						<td>????????????*</td>
						<td>
							<select name="app_homepage_pos">
								<option value="1442484559" selected>youku_????????????-phone??????(1442484559)</option>
								<option value="1444645658" >tudou_????????????-phone??????(1444645658)</option>
								<option value="1459510553" >youku_ipad_??????(1459510553)</option>
								<option value="1459510815" >youku_ipad_??????(1459510815)</option>
								<option value="60512" >??????-PHONE_IOS_APP-????????????-BANNER-??????(BANNER_??????)</option>
								<option value="60513" >??????-PHONE_IOS_APP-????????????-BANNER-??????(BANNER_??????)</option>
								<option value="60613" >??????-PHONE_ANDROID_APP-????????????-BANNER-??????(BANNER_??????)</option>
								<option value="60614" >??????-PHONE_ANDROID_APP-????????????-BANNER-??????(BANNER_??????)</option>
							</select>
						</td>
					</tr>					
					<tr>
						<td>????????????*</td>
						<td>
							<select name="app_homepage_type" onChange=app_homepage(this.value)>
								<option value="1" selected>????????????</option>
								<option value="2" >??????sdk</option>
							</select>
						</td>
					</tr>
					<tr class="app_homepage_url" id="app_homepage_url" style="display:;">
						<td>????????????</td>
						<td><input type="text" name="app_homepage_url" size="100" ></td>
					</tr>
					<tr class="app_homepage_clickurl" id="app_homepage_clickurl" style="display:;">
						<td>????????????</td>
						<td><input type="text" name="app_homepage_clickurl" size="100" ></td>
					</tr>
					<tr class="app_homepage_showurl" id="app_homepage_showurl" style="display:;">
						<td>???????????????????????????</td>
						<td><input type="text" name="app_homepage_showurl" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- ??????APP???????????????_end -->
				
				<!-- vhtml_youku_banner_start -->
				<div id = "vhtml_yt_banner_pip" style="display:none">
				<table id="vhtml_yt_banner_pip_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>??????&&???????????????banner ??????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="vhtml_yt_banner_pip_url" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- vhtml_youku_banner_end -->
				
				<!-- vhtml_youku_banner_start -->
				<div id = "vhtml_yt_banner_flash" style="display:none">
				<table id="vhtml_yt_banner_flash_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>???????????????banner_flash(h5)</b></td>
					</tr>
					<tr>
						<td>flash(h5)????????????</td>
						<td><input type="text" name="vhtml_yt_banner_h5_url" size="100" ></td>
					</tr>
					<tr>
						<td>flash?????????</td>
						<td><input type="text" name="vhtml_yt_banner_h5_width" size="100" ></td>
					</tr>
					<tr>
						<td>flash?????????</td>
						<td><input type="text" name="vhtml_yt_banner_h5_height" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- vhtml_youku_banner_end -->
				
				<!-- vhtml_promoted_video_start -->
				<div id = "vhtml_yt_promoted_video" style="display:none">
				<table id="vhtml_yt_promoted_video_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>?????????????????????(promoted video ads)</b></td>
					</tr>
					<tr>
						<td>????????????????????????</td>
						<td><input type="text" name="vhtml_yt_promoted_video_ads_url" size="100" ></td>
					</tr>
					<tr>
						<td>?????????????????????????????????</td>
						<td><input type="text" name="vhtml_yt_promoted_client_show_url" size="100" ></td>
					</tr>
					<tr>
						<td>???????????????????????????</td>
						<td><input type="text" name="vhtml_yt_promoted_other_show_url" size="100" ></td>
					</tr>
					<tr>
						<td>?????????????????????????????????</td>
						<td><input type="text" name="vhtml_yt_promoted_client_click_url" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- vhtml_promoted_video_end -->
				
				<!-- vhtml_m?????????_web_start -->
				<div id = "vhtml_m_playing_page_web" style="display:none">
				<table id="vhtml_m_playing_page_web_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>m?????????(web)</b></td>
					</tr>
					<tr>
						<td>???????????????</td>
						<td><textarea id="text" name="vhtml_m_playing_page_url" rows="10" cols="100"></textarea></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="vhtml_m_playing_page_click_url" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- vhtml_m?????????_web_end -->
				
				<!-- web_m_homepage_banner_start -->
				<div id = "m_web_video_banner" style="display:none">
				<table id="m_web_video_banner_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>web_m_homepage_banner(html_web)</b></td>
					</tr>
					<tr>
						<td>????????????*</td>
						<td>
							<select name="m_web_video_banner_pos">
								<option value="1448505355" selected>?????????web??????banner(1448505355)</option>
								
							</select>
						</td>
					</tr>
					<tr>
						<td>???????????????</td>
						<td><textarea id="text" name="html_video_banner_ads_url" rows="10" cols="100"></textarea></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="html_video_banner_click_url" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- web_m_homepage_banner_end -->
				
				<!-- html_custom_start -->
				<div id = "html_youku_custom" style="display:none">
				<table id="html_youku_custom_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>youku_???????????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><textarea id="text" name="html_youku_custom_url" rows="10" cols="100"></textarea></td>
					</tr>
				</table><br>
				</div>
				<!-- html_custom_end -->
				
				<!-- isp_start -->
				<div id = "m_isp" style="display:none">
				<table id="m_isp_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>???????????????</b></td>
					</tr>
					<tr>
						<td>???????????????(??????)-????????????</td>
						<td><input type="text" name="m_isp_png_url" size="100"></td>
					</tr>
					<tr>
						<td>title(??????(?????????????????????????????????????????????)(????????????))-???????????? </td>
						<td><input type="text" name="m_isp_title" size="100"></td>
					</tr>
					<tr>
						<td>text(?????????????????????????????????????????????)-???????????? </td>
						<td><input type="text" name="m_isp_tipcontent" size="100"></td>
					</tr>
					<tr>
						<td>text1(??????????????????????????????????????????????????????????????????) <font color='red'>  *</font>
						<td><input type="text" name="m_isp_buttontext" size="100"></td>
					</tr>

				</table><br>
				</div>
				<!-- isp_custom_end -->
				
				<!-- ????????????(??????-????????????) -->
				<div id = "mb_vf_buyingbyseeing" style="display:none">
				<table id="mb_vf_buyingbyseeing_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>?????????????????????????????????</b></td>
					</tr>
					<tr>
						<td>????????????????????????</td>
						<td><input type="text" name="mb_vf_buyingbyseeing_ideaurl" size="100" value="http://r1.ykimg.com/material/0A03/A1/201806/0622/3006105/1529661391727/h5_0_0_C432A732A020495189D0E6EC2D90AFF3/index.html" ></td>
					</tr>
					<tr>
						<td>OTT????????????(????????????,ott????????????,???????????????)</td>
						<td><input type="text" name="mb_vf_ott_buyingbyseeing_ideaurl" size="100"  ></td>
					</tr>						
					<tr>
						<td>????????????????????????</td>
						<td>
							<select name="control_type_mobile">
							    <option value="1" selected >CF1(????????????????????????????????????)</option>
								<option value="2" >CF2(????????????????????????????????????????????????)</option>
								<option value="3" >CF2(?????????????????????????????????)</option>
								<option value="4" >CF4(??????????????????????????????????????????)</option>
							</select>
						</td>
					</tr>				
					<tr>
						<td>????????????????????????</td>
						<td>
							<select name="ideaShowLocation">
							    <option value="1" selected >?????????</option>
								<option value="0" >??????</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>??????????????????(??????)</td>
						<td>
							<select name="ideaShowPositionCorn" id="ideaShowPositionCorn">
								<option value="1334,750,50,460,440,150" selected>?????????(???????????????)-??????</option>
								<option value="1334,750,50,550,266,150">??????(????????????)</option>
								<option value="1334,750,50,400,120,300">??????(????????????)</option>
								<option value="1334,750,50,590,360,90">??????(????????????)-??????</option>
								<option value="1334,750,1018,550,266,150">??????(????????????)</option>
								<option value="1334,750,1164,400,120,300">??????(????????????)</option>
								<option value="1334,750,924,550,360,90">??????(????????????)-??????</option>
							</select>													
						</td>
					</tr>
										
				</table><br>
				</div>
				
				<!-- ????????????????????? -->
				<div id = "mb_focus_circle_pic" style="display:none">
				<table id="mb_focus_circle_pic_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>???????????????(??????????????????????????????????????????????????????de,????????????)</b></td>
					</tr>
					<tr>
						<td>??????????????????-(750*350(phone)-?????? /750*420(phone)-??????)-phone?????????????????????</td>
						<td><input type="text" name="mb_focus_circle_pic_ideaurl" size="100"  ></td>
					</tr>
					
					<tr>
						<td>??????????????????-738*315(ipad)-ipad???????????????????????????</td>
						<td><input type="text" name="mb_focus_circle_pic_ideaurl_ipad" size="100"  ></td>
					</tr>
					
					<tr>
						<td>????????????</td>
						<td><input type="text" name="mb_focus_circle_pic_text" size="100"  ></td>
					</tr>						
					<tr>
						<td>????????????????????????*</td>
						<td>
				        <select name="mb_focus_circle_pic_pos" id="mb_focus_circle_pic_pos" >
						<%
							for (int i = -1; i < focusCirclePicsPos.size() ; i++) {
								if(i==-1){							
						%>		
								   <option value="" selected> </option>   
						<%
								}else{
								   AdPosition focusCirclePics = focusCirclePicsPos.get(i);
					   %>
					               <option value="<%=focusCirclePics.getId()%>"><%=focusCirclePics.getName()%></option>                   											                        
						<%									
							}}
						%>							                        
						</select>
						</td>
					</tr>												
				</table><br>
				</div>
				
				<!-- mb_feed_start -->
				<div id = "m_feed" style="display:none">
				<table id="m_feed_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>Feed??????</b></td>
					</tr>
					<tr>
						<td>?????????logo????????????</td>
						<td><input type="text" name="m_feed_logo_url" size="100"></td>
					</tr>
					<tr>
						<td>???????????????</td>
						<td><input type="text" name="m_feed_customer" size="100"></td>
					</tr>
					<tr>
						<td>????????????????????? </td>
						<td><input type="text" name="m_feed_video_thumbnail" size="100"></td>
					</tr>
					<tr>
						<td>????????????<font color='red'>  *</font>
						<td><input type="text" name="m_feed_buttontext" size="100"></td>
					</tr>
					<tr>
						<td>????????????????????????  *</font>
						<td><input type="text" name="m_feed_video_url" size="100"></td>
					</tr>
					<tr>
						<td>????????????*</td>
						<td>
							<select name="app_feed_pos">
								<option value="60500" selected>??????-PHONE_IOS_APP-????????????-????????????-??????-????????????_??????</option>
								<option value="60501" >??????-PHONE_IOS_APP-????????????-????????????-??????-????????????_??????</option>
								<option value="60601" >??????-PHONE_ANDROID_APP-????????????-????????????-??????-????????????_??????</option>
								<option value="60602" >??????-PHONE_ANDROID_APP-????????????-????????????-??????-????????????_??????</option>
							</select>
						</td>
					</tr>	
				</table><br>
				</div>
				<!-- mb_feed_end -->
				
				<!-- mb_feedAd_start -->
				<div id = "m_feedAd" style="display:none">
				<table id="m_feedAd_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>???????????????</b></td>
					</tr>
					<tr class="m_feedAd_type" id="m_feedAd_type" style="display:;">
						<td>???????????????*</td>
						<td>
							<select name="feedAd_type_overall" onChange=app_feedAd_overall(this.value)>
								<option value="1" selected>???????????????(???????????????)</option>
								<option value="2" >?????????(??????single)</option>
							</select>
						</td>
					</tr>
					
					<tr class="m_feedAd_video_normal" id="m_feedAd_video_normal" style="display:none;">
						<td>????????????*</td>
						<td>
							<select name="feedAd_type" onChange=app_feedAd(this.value)>
								<option value="1" selected>??????</option>
								<option value="2" >??????</option>
							</select>
						</td>
					</tr>
					<tr class="m_feedAd_video_thumbnail" id="m_feedAd_video_thumbnail" style="display:none;">
						<td>?????????????????????(phone-750*350) </td>
						<td><input type="text" name="m_feedAd_video_thumbnail" size="100"></td>
					</tr>
					<tr class="m_feedAd_video_url" id="m_feedAd_video_url" style="display:none;">
						<td>?????????????????? *</font>
						<td><input type="text" name="m_feedAd_video_url" size="100"></td>
					</tr>
					<tr class="m_feedAd_png_url_750_350" id="m_feedAd_png_url_750_350" style="display:;">
						<td>????????????(phone-750*350) *</font>
						<td><input type="text" name="m_feedAd_png_url_750_350" size="100"></td>
					</tr>
					<tr class="m_feedAd_png_url_750_280" id="m_feedAd_png_url_750_280" style="display:;">
						<td>????????????(phone-750*280) *</font>
						<td><input type="text" name="m_feedAd_png_url_750_280" size="100"></td>
					</tr>
					<tr class="m_feedAd_prompt" id="m_feedAd_prompt" style="display:;">
						<td>??????????????????<font color='red'>  *</font>
						<td><input type="text" name="m_feedAd_prompt" size="100"></td>
					</tr>
					<tr class="m_feedAd_brandlogo" id="m_feedAd_brandlogo" style="display:;">
						<td>??????Logo(195*35)</td>
						<td><input type="text" name="m_feedAd_brandlogo" size="100"></td>
					</tr>
					<tr class="m_feedAd_length" id="m_feedAd_length" style="display:none;">
						<td>????????????<font color='red'>  *</font>
						<td><input type="text" name="m_feedAd_length" size="100"></td>
					</tr>
					<tr class="m_feedAd_normal_pos" id="m_feedAd_brandlogo" style="display:;">
						<td>????????????*</td>
						<td>
				        <select name="app_Adfeed_pos" id="app_Adfeed_pos" >
						<%
							for (int i = -1; i < infoFlowAdPosition.size() ; i++) {
								if(i==-1){							
						%>		
								   <option value="" selected> </option>   
						<%
								}else{
								   AdPosition adPositionInfoFlow = infoFlowAdPosition.get(i);
					   %>
					               <option value="<%=adPositionInfoFlow.getId()%>"><%=adPositionInfoFlow.getName() + "("+ adPositionInfoFlow.getPageComment() + ") " + "?????????:" + adPositionInfoFlow.getReqPoint()%></option>                   											                        
						<%									
							}}
						%>							                        
						</select>
						</td>
					</tr>		
					
					<tr class="m_feedAd_video_kandian" id="m_feedAd_video_kandian" style="display:none;">
						<td>????????????*</td>
						<td>
							<select name="feedAd_type_kandian">
								<option value="1" selected>??????</option>
								<option value="2" >??????</option>
							</select>
						</td>
					</tr>
					
					<tr class="m_feedAd_png_url_spotlight" id="m_feedAd_png_url_spotlight" style="display:none;">
						<td>???????????????????????????(phone)-????????? *</font>
						<td><input type="text" name="m_feedAd_png_url_spotlight" size="100"></td>
					</tr>
					
					<tr class="m_feedAd_video_url_spotlight" id="m_feedAd_video_url_spotlight" style="display:none;">
						<td>???????????????????????????(phone)-????????? *</font>
						<td><input type="text" name="m_feedAd_video_url_spotlight" size="100"></td>
					</tr>
					
					<tr class="m_feedAd_thumbnail_url_spotlight" id="m_feedAd_thumbnail_url_spotlight" style="display:none;">
						<td>????????????????????????????????????(phone)- *</font>
						<td><input type="text" name="m_feedAd_thumbnail_url_spotlight" size="100"></td>
					</tr>
					
					<tr class="m_feedAd_brandlogo_spotlight" id="m_feedAd_brandlogo_spotlight" style="display:none;">
						<td>??????logo(phone-48*48) </font>
						<td><input type="text" name="m_feedAd_brandlogo_spotlight" size="100"></td>
					</tr>
					
					<tr class="m_feedAd_addescript_spotlight" id="m_feedAd_addescript_spotlight" style="display:none;">
						<td>??????(????????????) *</font>
						<td><input type="text" name="m_feedAd_addescript_spotlight" size="100"></td>
					</tr>
					
					<tr class="m_feedAd_prompt_spotlight" id="m_feedAd_prompt_spotlight" style="display:none;">
						<td>??????????????????(????????????) *</font>
						<td><input type="text" name="m_feedAd_prompt_spotlight" size="100"></td>
					</tr>
					
					<tr class="m_feedAd_adname_spotlight" id="m_feedAd_adname_spotlight" style="display:none;">
						<td>??????????????? *</font>
						<td><input type="text" name="m_feedAd_adname_spotlight" size="100"></td>
					</tr>
					
					<tr class="m_feedAd_spotlight_pos" id="m_feedAd_spotlight_pos" style="display:none;">
						<td>???????????????????????????*</td>
						<td>
				        <select name="app_Adfeed_spotlight_pos" id="app_Adfeed_spotlight_pos" >
						<%
							for (int i = -1; i < infoFlowAdPosition.size() ; i++) {
								if(i==-1){							
						%>		
								   <option value="" selected> </option>   
						<%
								}else{
								   AdPosition adPositionSpotlight = infoFlowAdPosition.get(i);
					   %>
					               <option value="<%=adPositionSpotlight.getId()%>"><%=adPositionSpotlight.getName() + "("+ adPositionSpotlight.getPageComment() + ") " + "?????????:" + adPositionSpotlight.getReqPoint()%></option>                   											                        
						<%									
							}}
						%>							                        
						</select>
						</td>
					</tr>
						
				</table><br>
				</div>
				<!-- mb_feedAd_end -->
				
				<!-- ott_display_start -->
				<div id = "ott_display" style="display:">
				<table id="ott_display_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>OTT????????????(??????/??????)</b></td>
					</tr>	
					
					<tr>
						<td>??????/??????*</td>
						<td>
							<select name="app_ott_display_type">
								<option value="1" selected>??????</option>
								<option value="2" >??????</option>
							</select>
						</td>
					</tr>	
									
					<tr class="ott_display_idea" id="ott_display_ideaurl_mb">
						<td>????????????(??????/??????)</td>
						<td><textarea id="ott_display_ideaurl" name="ott_display_ideaurl" rows="2" cols="130">http://ott-idea-video-output.alicdn.com/ott-idea-video/daily/201806/0621/3001319/1529565440113/FJrnkzDbtVNzqJRMVAfEVUptCQxtpyMzyoj.mp4</textarea></td>
					</tr>
					
					<tr class="ott_display_biterate" id="ott_display_bite_rate">
						<td>??????</td>
						<td><input type="text" name="ott_display_biterate" id="ott_display_biterate" placeholder="100" size="10"  ></td>
					</tr>
					
					<tr class="ott_display_volume" id="ott_display_bite_volume">
						<td>??????</td>
						<td><input type="text" name="ott_display_volume" id="ott_display_volume" placeholder="M720H264" size="10"  ></td>
					</tr>
										
					<tr class="ott_display_showtime" id="ott_display_ideaurl_showtime">
						<td>????????????</td>
						<td><input type="text" name="ott_display_ideaurl_showtime" size="10" ></td>
					</tr>					
				</table><br>
				</div>
				<!-- ott_display_end -->
				
				<!-- ott_poweroff_start -->
				<div id = "ott_poweroff" style="display:">
				<table id="ott_poweroff_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>OTT????????????</b></td>
					</tr>					
					<tr class="ott_poweroff_idea" id="ott_poweroff_ideaurl_mb">
						<td>????????????(1920*1080)</td>
						<td><input type="text" name="ott_poweroff_ideaurl" id="ott_poweroff_ideaurl" placeholder="????????????  http://???https://???????????? jpg???png?????????????????????" size="100"  ></td>
					</tr>		
					<tr class="ott_poweroff_showtime" id="ott_poweroff_ideaurl_showtime">
						<td>????????????</td>
						<td><input type="text" name="poweroff_showtime" size="10" ></td>
					</tr>								
				</table><br>
				</div>
				<!-- ott_poweroff_end -->
				
				<!-- ott_screensaver_start -->
				<div id = "ott_screensaver" style="display:">
				<table id="ott_screensaver_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>OTT????????????</b></td>
					</tr>					
					<tr class="ott_screensaver_idea" id="ott_screensaver_ideaurl_mb">
						<td>????????????(1920*1080)</td>
						<td><input type="text" name="ott_screensaver_ideaurl" id="ott_screensaver_ideaurl" placeholder="????????????  http://???https://???????????? jpg???png?????????????????????" size="100"  ></td>
					</tr>
					<tr class="ott_screensaver_showtime" id="ott_screensaver_ideaurl_showtime">
						<td>????????????</td>
						<td><input type="text" name="screensaver_showtime" size="10" ></td>
					</tr>									
				</table><br>
				</div>
				<!-- ott_screensaver_end -->
				
				<!-- ott_dis_rec_start -->
				<div id = "ott_dis_rec" style="display:">
				<table id="ott_dis_rec_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>OTT????????????(???/?????????)</b></td>
					</tr>					
					<tr class="ott_dis_rec_idea" id="ott_dis_rec_ideaurl_mb">
						<td>????????????(1920*1080)</td>
						<td><input type="text" name="ott_dis_rec_ideaurl" id="ott_dis_rec_ideaurl" placeholder="????????????  http://???https://???????????? jpg???png?????????????????????" size="100"  ></td>
					</tr>
					<tr class="ott_dis_rec_showtime" id="ott_dis_rec_ideaurl_showtime">
						<td>????????????</td>
						<td><input type="text" name="ott_dis_rec_ideaurl_showtime" size="10" ></td>
					</tr>								
				</table><br>
				</div>
				<!-- ott_dis_rec_end -->
				
				<div id = "mb_overlay_float" style="display:none">
				<table id="mb_overlay_float_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>?????????????????????</b></td>
					</tr>
					<tr>
						<td>????????????????????????</td>
						<td><input type="text" name="mb_overlay_float_pic_ideaurl" id="mb_overlay_float_pic_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
					
					<tr>
						<td>??????flash????????????</td>
						<td><input type="text" name="mb_overlay_float_swf_ideaurl" id="mb_overlay_float_swf_ideaurl" size="100" ></td>
					</tr>
					
					<tr>
						<td>??????h5????????????</td>
						<td><input type="text" name="mb_overlay_float_h5_ideaurl" id="mb_overlay_float_h5_ideaurl" size="100" ></td>
					</tr>
					
				</table><br>
				</div>
				
				<div id = "mb_faceoff" style="display:none">
				<table id="mb_faceoff_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>mb????????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="mb_faceoff_ideaurl" id="mb_faceoff_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
				</table><br>
				</div>    
				
				<div id = "mb_bf" style="display:none">
				<table id="mb_bf_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>mb???????????????</b></td>
					</tr>
					<tr>
						<td>????????????</td>
						<td><input type="text" name="mb_bf_ideaurl" id="mb_bf_ideaurl" size="100" ></td>
					</tr>
					<tr>
						<td colSpan="3" color="red"></td>
					</tr>
				</table><br>
				</div>   
														
				</div>
				<!--
				<div id="usehd" style="display:">
				??????????????????<input type="radio" name="usehd" value="0" checked> ????????????
				        <input type="radio" name="usehd" value="2"> ????????????
				        <input type="radio" name="usehd" value="1"> ????????????<br><br>				
				</div>
	            -->
	            <!-- ??????????????? start -->
	            <div id="resolution_setting" style="display:">                         
	                                          ??????????????????<input type="checkbox" name="resolution_setting" onclick="toggle('resolution')" /><br><br>
	            </div>                           
				<div id="resolution" style="display:none">
				<table id="resolution_table" style="border: solid thin blue">
				<tr>
						<td colSpan="2" id="m2link" color="red">??????????????????(???????????????????????????????????????????????????????????????)<br><br></td>
				</tr>
				<tr>
				<td>??????????????????<input type="checkbox" name="resolution_hd2" id="resolution_hd2" value="1" onclick="check_resolution_hd2_broadcasting()" checked> ?????? &nbsp&nbsp
				???????????????<input type="checkbox" name="resolution_hd2" id="resolution_hd2_broadcasting1" value="4" onclick="check_resolution_hd2()" checked> ??????
				      <input type="checkbox" name="resolution_hd2" id="resolution_hd2_broadcasting2" value="2" onclick="check_resolution_hd2()" checked> ??????
				      <input type="checkbox" name="resolution_hd2" id="resolution_hd2_broadcasting3" value="1" onclick="check_resolution_hd2()" checked> ?????? <br><br></td>	
				</tr>
				<tr>
				<td>??????????????????<input type="checkbox" name="resolution_mp4" id="resolution_mp4" value="1" onclick="check_resolution_mp4_broadcasting()" checked> ?????? &nbsp&nbsp
				???????????????<input type="checkbox" name="resolution_mp4" id="resolution_mp4_1_broadcasting1" value="4" onclick="check_resolution_mp4()" checked> ??????
				      <input type="checkbox" name="resolution_mp4" id="resolution_mp4_2_broadcasting2" value="2" onclick="check_resolution_mp4()" checked> ??????
				      <input type="checkbox" name="resolution_mp4" id="resolution_mp4_3_broadcasting3" value="1" onclick="check_resolution_mp4()" checked> ?????? <br><br></td>
				</tr>
				<tr>      
			    <td>??????????????????<input type="checkbox" name="resolution_flv" id="resolution_flv" value="1" onclick="check_resolution_flv_broadcasting()" checked> ?????? &nbsp&nbsp
				???????????????<input type="checkbox" name="resolution_flv" id="resolution_flv1_broadcasting1" value="4" onclick="check_resolution_flv()" checked> ??????
				      <input type="checkbox" name="resolution_flv" id="resolution_flv2_broadcasting2" value="2" onclick="check_resolution_flv()" checked> ??????
				      <input type="checkbox" name="resolution_flv" id="resolution_flv3_broadcasting3" value="1" onclick="check_resolution_flv()" checked> ?????? <br></td>
				</tr>				
				</table>
				<br>
				</div>
				<!-- ??????????????? end -->	
				 
				<input type="submit" value="??????" >
			</form>
		</td>
	</tr>
</table>

<script type="text/javascript">
function today(){
    var today=new Date();
    var h=today.getFullYear();
    var m=today.getMonth()+1;
    var d=today.getDate();
    return h+"-"+m+"-"+d;
}
document.getElementById("startDateRow").value = today();
document.getElementById("endDateRow").value = today();
</script>
<script>
	$().ready(function(e) {
		$("#timePicker_starttime").hunterTimePicker();
		$("#timePicker_endtime").hunterTimePicker();
	});
</script>
</body>
</html>