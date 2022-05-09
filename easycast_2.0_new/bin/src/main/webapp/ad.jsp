<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.io.IOException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.torque.TorqueException"%>
<%@page import="org.apache.torque.util.Criteria"%>
<%@page import="org.apache.torque.Torque"%>
<%@page import="com.youku.atm.om.*"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="org.apache.torque.TorqueException"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="com.youku.atm.easycast.*"%>
<%@page import="java.util.List"%>
<%
	String base = request.getContextPath(); 
	String ip = InetAddress.getLocalHost().getHostAddress();
	List<Channel> y_channelList = EasyCastUtil.getAllConfigChannels("ykn");
	List<Channel> t_channelList = EasyCastUtil.getAllConfigChannels("tdn");
	List<Area> areaList = EasyCastUtil.getAllConfigAreas("province");
    //campaign
    List<Campaign> campaignList_show = EasyCastUtil.getAllConfigCampaigns_show(1);
    List<Campaign> campaignList_click = EasyCastUtil.getAllConfigCampaigns_click(2);
    List<Campaign> campaignList_over = EasyCastUtil.getAllConfigCampaigns_over(3);
    List<Campaign> campaignList_skip = EasyCastUtil.getAllConfigCampaigns_skip(4);
    List<Campaign> campaignList_preload = EasyCastUtil.getAllConfigCampaigns_preload(5);
    
	List<Platform> osList = PlatformPeer.doSelect(new Criteria());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广告投放 - <%=ip%></title>
<link rel="stylesheet" href="<%=base%>/js/ajax/jquery/themes/jquery-ui-1.8.16.custom/css/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" media="all" />
<script src="<%=base%>/js/ajax/jquery/jquery-1.6.2.min.js" type="text/javascript"></script>
<script src="<%=base%>/js/ajax/jquery/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
<script src="<%=base%>/js/ajax/jquery/ui/i18n/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript">
	var $j = jQuery.noConflict();
	
	$j(function() {
        $j("#startDateRow").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
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

	function $(id){
		return document.getElementById(id);
	}
	
	function initform(){
		//init ad_type_select
		var ad_type_select = $("ad_type");
		
		ad_type_select.options.add(new Option("新前贴","160"));
		ad_type_select.options.add(new Option("新暂停","164"));
		ad_type_select.options.add(new Option("新中插","163"));
		ad_type_select.options.add(new Option("新后贴","161"));
		ad_type_select.options.add(new Option("新crazy","168"));
		ad_type_select.options.add(new Option("新Ad selector","169"));
		ad_type_select.options.add(new Option("新短视频全屏","167"));
		ad_type_select.options.add(new Option("新角标","165"));
		ad_type_select.options.add(new Option("新开机图","175"));
		ad_type_select.options.add(new Option("新贴片","162"));
		
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
			 alert("已选择的播放器设置下至少勾选一项素材清晰度!!!");

			 submitOK="false";
		}
		
		submitOK1="true"
		var x1= document.getElementById("pc_vf_y_ideaurl");
		var x2= document.getElementById("m_vf_ideaurl");
		var obj1 = document.getElementById("ad_type");
        
		if((x1.value==""&&obj1.value=="160")||(x2.value==""&&obj1.value=="70")){
			alert("素材url不应该为null!!!");
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
			ad_type_select.options.add(new Option("新前贴","160"));
			ad_type_select.options.add(new Option("新暂停","164"));
			ad_type_select.options.add(new Option("新中插","163"));
			ad_type_select.options.add(new Option("新后贴","161"));
			ad_type_select.options.add(new Option("新crazy","168"));
			ad_type_select.options.add(new Option("新Ad selector","169"));
			ad_type_select.options.add(new Option("新短视频全屏","167"));
			ad_type_select.options.add(new Option("新角标","165"));
			ad_type_select.options.add(new Option("新开机图","175"));
			ad_type_select.options.add(new Option("新贴片","162"));
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
			document.getElementById("all_channel").style.display="";
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

			$("ies_monitor").style.display = "";
			$("khoverurl").style.display = "";
			//khplayingurl
			$("khplayingurl").style.display = "";
			$("outtime").style.display = "";
			//vhtml_type
			$("vhtml_type").style.display = "none";
			//isCast_barkidea
			$("isCast_barkidea").style.display = "";
            $("khclickurl").style.display = "";
            $("othershowurl").style.display = "";
            $("otherclickurl").style.display = "";
            $("otherh5showurl").style.display = "";
            //mb_click_ways
            //$("mb_click_ways").style.display = "none";

			$("mb_app_click_way").style.display = "none" ;
			
			$("os_div").style.display = "none";
			
			$("all_os").checked = false;
			//$("normal").checked = true;
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
			$("pcdevice").style.display = "";
			$("mdevice").style.display = "none";
			
			$("pc_vf").style.display = "";
			$("pc_vp").style.display = "none";
			//vhtml_yt_banner_pip
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
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
			//$("is_show_priority").checked = false;
			$("priority").disabled = false;
			$("total_lun").disabled = false;
			//percent
			$("percent").disabled = false;
			//is_show_v_position
			$("is_show_v_position").checked = false;
			//
			$("is_show_v_position").disabled = false;
			$("is_show_vo_position").disabled = false;
			$("m_issdk").style.display = "none";
			//$("mb_click").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			$("is_show_vo_position").style.display = "";
			//$("vt2").disabled = false;
			//$("vt0").selected = true;

			$("clickurl").style.display = "none";
			$("loader").style.display = "none";
			//pc_custom_text
			$("pc_custom_text").style.display = "none";
			$("yk_second_class").style.display = "none";
			$("td_second_class").style.display = "none";

		} else if (os_type == "m") {
			
			ad_type_select.options.add(new Option("移动前贴","70"));
			ad_type_select.options.add(new Option("移动后贴","71"));
			ad_type_select.options.add(new Option("移动暂停","73"));
			ad_type_select.options.add(new Option("移动角标","74"));
			ad_type_select.options.add(new Option("移动开机图","75"));	
			ad_type_select.options.add(new Option("移动全屏","76"));
			ad_type_select.options.add(new Option("移动中插","80"));
			ad_type_select.options.add(new Option("移动贴片","72"));
			ad_type_select.options.add(new Option("移动文字链","3"));
			ad_type_select.options.add(new Option("移动app搜索页banner","4"));
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
            $("otherclickurl").style.display = "";
            $("otherh5showurl").style.display = "";
            //$("mb_click_ways").style.display = "";
            $("vhtml_yt_banner_pip").style.display = "none";
            $("vhtml_yt_banner_flash").style.display = "none";
            $("vhtml_yt_promoted_video").style.display = "none";
            $("vhtml_m_playing_page_web").style.display = "none";
			$("cast_type_div").style.display = "none";
//			$("cast_type").value = "0";
//			$("cast_type").disabled = false;
			$("mdevice").style.display = "";
			$("pcdevice").style.display = "none";
			
			$("m_vf").style.display = "";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			//m_mhtml,m_searchBanner
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
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
			
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
			$("is_show_vo_position").style.display = "";
			$("khclickurl").style.display = "";
			$("clickurl").style.display = "";
			//$("mb_click").style.display = "";
			$("loader").style.display = "none";
			//pc_custom_text
			$("pc_custom_text").style.display = "none";
			$("yk_second_class").style.display = "none";
			$("td_second_class").style.display = "none";

		}else {
			//$("vt2").disabled = true;
			//$("vt0").selected = true;
			
			ad_type_select.options.add(new Option("youku_视频播放页PIP全分类（淘宝专用）","322"));
			ad_type_select.options.add(new Option("youku_右侧“相关视频”上banner （全分类）","320"));
			ad_type_select.options.add(new Option("youku_播放页首屏banner1（全分类）","324"));
			ad_type_select.options.add(new Option("youku_视频播放页右上PIP（UGC）","325"));
			ad_type_select.options.add(new Option("youku_评论框上通栏（普通播放页）-全分类","323"));	
			ad_type_select.options.add(new Option("youku_视频播放页－全分类底通（RTB专用）","321"));
			ad_type_select.options.add(new Option("youku_视频播放页-全频道 问卷调查","327"));
			ad_type_select.options.add(new Option("youku_移动web 播放页","326"));
			ad_type_select.options.add(new Option("tudou_播放页首屏banner1","346"));
			ad_type_select.options.add(new Option("tudou_UGC播放页banner (300*250)","345"));
			ad_type_select.options.add(new Option("tudou_视频播放页-（全分类）右侧二屏上banner","340"));
			ad_type_select.options.add(new Option("tudou_视频播放页-（全分类）右侧中 PIP","341"));
			ad_type_select.options.add(new Option("tudou_视频播放页-（全分类）右侧下 PIP","344"));
			ad_type_select.options.add(new Option("tudou_视频播放页-（全分类）评论上方通栏","342"));
			ad_type_select.options.add(new Option("tudou_视频播放页-问卷调查","343"));
			ad_type_select.options.add(new Option("推荐视频_promoted_video_ads(1429860427)","1429860427"));
			ad_type_select.options.add(new Option("推荐视频_promoted_video_ads(1430199248)","1430199248"));
			
			ad_type_select.options.add(new Option("m播放页广告(youku_移动phone-web端_播放页banner)","1425020640"));	
			ad_type_select.options.add(new Option("m播放页广告(youku_移动ipad-web端_播放页banner)","1427883541"));	
			
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
			document.getElementById("all_channel").style.display="";
			
			$("m_os_div").style.display = "none" ;
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
			$("otherclickurl").style.display = "none";
			$("otherh5showurl").style.display = "none";
			//$("mb_click_ways").style.display = "none";
			//vhtml_yt_banner_pip
			$("vhtml_yt_banner_pip").style.display = "";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("all_os").checked = false;	

			$("cast_type_div").style.display = "none";
//			$("cast_type").value = "0";
//			$("cast_type").disabled = false;
			$("mdevice").style.display = "";
			$("pcdevice").style.display = "none";
			
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
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
			$("is_show_campaign").checked = false;
			$("is_show_campaign").disabled = false;
			$("is_click_campaign").checked = false;
			$("is_click_campaign").disabled = false;
			$("is_over_campaign").checked = false;
			$("is_over_campaign").disabled = false;
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

		} else {
			$("is_show_campaign").disabled = false;
			$("is_click_campaign").disabled = false;
			$("is_over_campaign").disabled = false;
			$("priority").disabled = false;
			//total_lun
			$("total_lun").disabled = false;
			$("percent").disabled = false;
			//is_show_v_position
			$("is_show_v_position").disabled = false;
			$("is_show_vo_position").disabled = false;
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
				$("isVidLimit").checked = false;
				$("isVidLimit").disabled = true;
				
				$("all_channel").checked = false;
				$("all_channel").disabled = true;
				
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
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
			
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			
		}
		if(ad_type == 163){
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "none";
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			//$("clickurl").style.display = "none";
			//$("usehd").style.display = "none";
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			//$("clickurl").style.display = "none";
			//$("usehd").style.display = "none";
			$("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "none";
			$("pc_vi").style.display = "";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			//$("clickurl").style.display = "none";
			//$("usehd").style.display = "none";
		    $("customtexturl").style.display = "none";
			$("clientcustomclickurl").style.display = "none";
			$("clientskipurl").style.display = "none";
			$("clientfeeurl").style.display = "none";
			$("othercustomtextclickurl").style.display = "none";
			$("otherskipurl").style.display = "none";
			$("otherfeepurl").style.display = "none";
			$("chargingthreshold").style.display = "none";
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
			document.getElementById("all_channel").style.display="";
			$("pc_vf").style.display = "none";
			$("pc_vp").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_banner_flash").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "none";
			$("pc_vc").style.display = "none";
			$("pc_vb").style.display = "none";
			$("pc_vob").style.display = "none";
			$("pc_crazy").style.display = "none";
			$("pc_selector").style.display = "none";
			$("pc_shortfull").style.display = "none";
			$("pc_tp").style.display = "";
			$("pc_vi").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";
		}
		
		
		//mdevice
		if(ad_type == 70){
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
			document.getElementById("all_channel").style.display="";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "";

			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";

		}
		if(ad_type == 71){
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
			document.getElementById("all_channel").style.display="";
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";

		}
		if(ad_type == 73){
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
			document.getElementById("all_channel").style.display="";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_vp_ideaurl").style.display = "";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";


		}
		if(ad_type == 74){
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
			document.getElementById("all_channel").style.display="";
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "none";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";

		}
		if(ad_type == 75){
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
			document.getElementById("all_channel").style.display="";
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("m_mi").style.display = "";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "none";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "none";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";

		}
		
		if(ad_type == 76){
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
			document.getElementById("all_channel").style.display="";
			$("m_sdk").value=0;
			$("m_ztsdk").value=0;
			$("m_qtsdk").value=0;
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("outtime").style.display = "none";
			$("khoverurl").style.display = "none";
			$("khplayingurl").style.display = "none";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
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
		
		//mtp
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
			document.getElementById("all_channel").style.display="";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "";
			//is_show_v_position
			$("is_show_v_position").style.display = "";

		}
		
		//mo
		if(ad_type == 80){
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
			document.getElementById("all_channel").style.display="";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";

			}
		  //mhtml(文字链)-youku_移动端搜索结果页文字广告
		if(ad_type == 3){
			document.getElementById("reserve_shua").selected=true;
			document.getElementById("reserve_cpm").disabled=true;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").disabled=true;
			document.getElementById("reserve_lunbo").disabled=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			//all_channel
			document.getElementById("all_channel").style.display="none";
			
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "";
			$("m_searchBanner").style.display = "none";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";
			
			}
		
		//mhtml(移动app搜索页banner)
		if(ad_type == 4){
			document.getElementById("reserve_shua").selected=true;
			document.getElementById("reserve_cpm").disabled=true;
			document.getElementById("reserve_priority").disabled=true;
			document.getElementById("reserve_time").disabled=true;
			document.getElementById("reserve_lunbo").disabled=true;
			document.getElementById("reserve_percent").disabled=true;
			document.getElementById("reserve_cpc").disabled=true;
			document.getElementById("reserve_cpv").disabled=true;
			document.getElementById("reserve_cpp").disabled=true;
			document.getElementById("all_channel").style.display="none";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
			$("m_vp").style.display = "none";
			$("m_vc").style.display = "none";
			$("m_vb").style.display = "none";
			$("m_vtp").style.display = "none";
			$("m_mi").style.display = "none";
			$("m_mQP").style.display = "none";
			$("m_mo").style.display = "none";
			$("m_mhtml").style.display = "none";
			$("m_searchBanner").style.display = "";
			$("outtime").style.display = "";
			$("khoverurl").style.display = "";
			$("khplayingurl").style.display = "";
			$("khclickurl").style.display = "";
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";

			}
		//推荐视频_promoted_video_ads(1429860427);推荐视频_promoted_video_ads(1430199248)
		if(ad_type == 1429860427 || ad_type == 1430199248){
			$("m_searchBanner").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "";
			$("vhtml_m_playing_page_web").style.display = "none";
			
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
			
			document.getElementById("all_channel").style.display="none";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
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
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";

			}
		
		//(youku_移动phone-web端_播放页banner);(youku_移动ipad-web端_播放页banner)
       if(ad_type == 1425020640 || ad_type == 1427883541){
    	    $("m_searchBanner").style.display = "none";
			$("vhtml_yt_banner_pip").style.display = "none";
			$("vhtml_yt_promoted_video").style.display = "none";
			$("vhtml_m_playing_page_web").style.display = "";
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
			
			document.getElementById("all_channel").style.display="none";
			$("m_ztsdk").value=0;
			$("m_sdk").value=0;
			$("m_qtsdk").value=0;		
			$("m_vf").style.display = "none";
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
			//$("clickurl").style.display = "";
			//$("usehd").style.display = "";
			$("resolution").style.display = "none";
			//resolution_setting
			$("resolution_setting").style.display = "";
			$("v_position").style.display = "none";
			//is_show_v_position
			$("is_show_v_position").style.display = "none";

			}
		
	}
	
	function show_campaign_div(obj){
		if(obj.checked){
			$("show_campaign_div").style.display = "";
		} else {
			$("show_campaign_div").style.display = "none";
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
			  
			  }else if(obj=="2"||obj=="5"){
				  $("vhtml_yt_banner_pip").style.display = "none";
				  $("vhtml_yt_banner_flash").style.display = "";
				  $("vhtml_yt_promoted_video").style.display = "none";
				  $("vhtml_m_playing_page_web").style.display = "none";
			  }else if(obj=="8"){
				  $("vhtml_yt_banner_pip").style.display = "none";
				  $("vhtml_yt_banner_flash").style.display = "none";
				  $("vhtml_yt_promoted_video").style.display = "";
				  $("vhtml_m_playing_page_web").style.display = "none";
			  }else if(obj=="9"){
				  $("vhtml_yt_banner_pip").style.display = "none";
				  $("vhtml_yt_banner_flash").style.display = "none";
				  $("vhtml_yt_promoted_video").style.display = "none";
				  $("vhtml_m_playing_page_web").style.display = "";
				  
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
 
			var strs= new Array(); //定义一数组 
			strs=items.value.split("$"); //字符分割 
			
			document.getElementById("campaign_show_name").value=strs[0];
			document.getElementById("startDateRow_show").value=strs[1];
			document.getElementById("endDateRow_show").value=strs[2];
			
			var strs1= new Array(); //定义一数组 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_show").value="0";
				document.getElementById("campaign_day_limit_show").value="0";
			}else{
				strs1=strs[3].split(";"); //字符分割 
				
				document.getElementById("campaign_days_show").value=strs1[0];
				document.getElementById("campaign_day_limit_show").value=strs1[1];
			}		
			document.getElementById("campaign_num_limit_show").value=strs[4];
			
		}

	}
	
	function click_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_click");
 
			var strs= new Array(); //定义一数组 
			strs=items.value.split("$"); //字符分割 
			
			document.getElementById("campaign_click_name").value=strs[0];
			document.getElementById("startDateRow_click").value=strs[1];
			document.getElementById("endDateRow_click").value=strs[2];
			
			var strs1= new Array(); //定义一数组 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_click").value="0";
				document.getElementById("campaign_day_limit_click").value="0";
			}else{
				strs1=strs[3].split(";"); //字符分割 
				
				document.getElementById("campaign_days_click").value=strs1[0];
				document.getElementById("campaign_day_limit_click").value=strs1[1];
			}			
			document.getElementById("campaign_num_limit_click").value=strs[4];
			
		}

	}
	
	function over_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_over");
 
			var strs= new Array(); //定义一数组 
			strs=items.value.split("$"); //字符分割 
			
			document.getElementById("campaign_over_name").value=strs[0];
			document.getElementById("startDateRow_over").value=strs[1];
			document.getElementById("endDateRow_over").value=strs[2];
			
			var strs1= new Array(); //定义一数组 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_over").value="0";
				document.getElementById("campaign_day_limit_over").value="0";
			}else{
				strs1=strs[3].split(";"); //字符分割 
				
				document.getElementById("campaign_days_over").value=strs1[0];
				document.getElementById("campaign_day_limit_over").value=strs1[1];
			}			
			document.getElementById("campaign_num_limit_over").value=strs[4];
			
		}

	}
	
	function skip_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_skip");
 
			var strs= new Array(); //定义一数组 
			strs=items.value.split("$"); //字符分割 
			
			document.getElementById("campaign_skip_name").value=strs[0];
			document.getElementById("startDateRow_skip").value=strs[1];
			document.getElementById("endDateRow_skip").value=strs[2];
			
			var strs1= new Array(); //定义一数组 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_skip").value="0";
				document.getElementById("campaign_day_limit_skip").value="0";
			}else{
				strs1=strs[3].split(";"); //字符分割 
				
				document.getElementById("campaign_days_skip").value=strs1[0];
				document.getElementById("campaign_day_limit_skip").value=strs1[1];
			}			
			document.getElementById("campaign_num_limit_skip").value=strs[4];
			
		}

	}
	
	function preload_campaign(obj){
		if(obj!=''){
			var items = document.getElementById("campaignList_preload");
 
			var strs= new Array(); //定义一数组 
			strs=items.value.split("$"); //字符分割 
			
			document.getElementById("campaign_preload_name").value=strs[0];
			document.getElementById("startDateRow_preload").value=strs[1];
			document.getElementById("endDateRow_preload").value=strs[2];
			
			var strs1= new Array(); //定义一数组 
			
			if(strs[3] == null || strs[3] ==""){
				document.getElementById("campaign_days_preload").value="0";
				document.getElementById("campaign_day_limit_preload").value="0";
			}else{
				strs1=strs[3].split(";"); //字符分割 
				
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
	
	function show_parameter_div(obj){
		if(obj.checked){
			$("parameters_div").style.display = "";
		} else {
			$("parameters_div").style.display = "none";
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
//			div.innerHTML = " <br>调研入口名称：<input type='text' name='millwardbrown_entryname' value='millwardbrown' size='60'/> <br><br>优酷：Millwardbrown调研地址：<input type='text' name='millwardbrown_expose_y_url' value='http://atm.youku.com/test-youkuexposevc' size='60'/> <br><br>土豆：Millwardbrown调研地址：<input type='text' name='millwardbrown_expose_t_url' value='http://atm.youku.com/test-tudouexposevc' size='60'/> <br><br>调研问卷点击地址：<input type='text' name='millwardbrown_click_url' value='http://atm.youku.com/test-millwardbrown_click_url' size='60'/>";
//			div.style.display = "";
//		} else if(obj == 2){
//			div.innerHTML = " <br>优酷：Millwardbrown调研地址：<input type='text' name='millwardbrown_control_y_url' value='http://atm.youku.com/test-youkucontrolvc' size='60'/> <br><br>土豆：Millwardbrown调研地址：<input type='text' name='millwardbrown_control_t_url' value='http://atm.youku.com/test-tudoucontrolvc' size='60'/>";
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
    		if(obj=="请选择"){
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
			if(type==0){
				document.getElementsByName("yk_all_channel")[0].checked=false;
				document.getElementsByName("td_all_channel")[0].checked=false;
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
				document.getElementsByName("yk_all_channel")[0].checked=false;
				document.getElementsByName("td_all_channel")[0].checked=false;
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
			
			var trss = document.getElementsByClassName("qiantie_idea");
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
			
			var trss = document.getElementsByClassName("qiantie_idea");
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
			
			var trss = document.getElementsByClassName("qiantie_idea");
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
	    		alert("第0分钟素材时长只能在0-45秒之间");
	    		return ob_name;
	    	}
	    }else{
		    if(id_list.substr(1) == "1"){
		    	if(ob_name.value != "-1" && (ob_name.value < 0 || ob_name.value > 180) ){
		    		ob_name.value = '';
		    		alert("第1分钟素材时长只能在0-180秒之间");
		    		return ob_name;
		    	}
		    }else{
		    	if(ob_name.value != "-1" && (ob_name.value < 0 || ob_name.value > 120) ){
		    		ob_name.value = '';
		    		alert("其它分钟素材时长只能在0-120秒之间");
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
	/***去除中文函数****/
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
			<form action="action.jsp" onsubmit="return validate()" method="post" >
			service ip = <%=ip%><p>
				类型：
				<input type="radio" name="os_type" value="p" onclick="changeAdType(this.value)" checked> PC &nbsp;&nbsp;
				<input type="radio" name="os_type" value="m" onclick="changeAdType(this.value)" > 移动  &nbsp;&nbsp;
				<input type="radio" name="os_type" value="vhtml" onclick="changeAdType(this.value)" > vhtml <br><br>

				广告类型：
				<select name="ad_type" id="ad_type" onchange="hideCampAndVideogroup(this.value)"></select><br>
				<div id="cast_type_div" style="display:none">
					<div id="mobile_theater_loops" >                   
					</div>		
				</div>
				
				<div id="vhtml_type" style="display:none">素材类型：
				<select name="vhtml_type" onChange="hideVhtmlAndVideogroup(this.value)">
								<option id = "youku_playing_banner_pip" value="1" selected>优酷播放页banner 图片</option>
								<option id = "youku_playing_banner_flash" value="2" >优酷播放页banner flash</option>
								<option id = "youku_playing_custom" value="3" >优酷播放页banner 自定义</option>
								<option id = "tudou_playing_banner_pip" value="4" >土豆播放页banner（图片）</option>
								<option id = "tudou_playing_banner_flash" value="5" >土豆播放页banner(flash)</option>
								<option id = "youku_custom" value="6" >优酷自定义广告</option>
								<option id = "tudou_custom" value="7" >土豆自定义广告</option>
								<!--  
								<option value="8" >播放页推荐广告(1429860427)</option>
								<option value="9" >播放页推荐广告(1430199248)</option>
								
								<option value="10" >youku_移动phone-web端_播放页banner(1425020640)</option>
								<option value="11" >youku_移动ipad-web端_播放页banner(1427883541)</option>
								-->
								<option id = "youku_promoted_video_ads" value="8" >播放页推荐广告(1429860427/1430199248)</option>
								<option id = "m_playing" value="9" >m播放页(1425020640/1427883541)</option>
							</select><br><br>
				</div>
				<!-- v_position -->
				<input type="checkbox" id="is_show_v_position" name="is_show_v_position" value="1" onclick=show_v_position_div(this)> 是否定投前贴位置 <br><br>
				<div id="show_v_position_div" style="display:none">				
                <table id="v_position_table" style="border: solid thin red">
                <tr>
				<td>定投前贴点位:<input type="checkbox" name="v_position" value="2" > 第一前贴
				        <input type="checkbox" name="v_position" value="3"> 第二前贴
				        <input type="checkbox" name="v_position" value="9"> 第三前贴
				        <input type="checkbox" name="v_position" value="20"> 第四前贴
				        <input type="checkbox" name="v_position" value="21"> 第五前贴
				        <input type="checkbox" name="v_position" value="22"> 第六前贴
				        <br></tr>
				</tr>
				<tr>
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<input type="checkbox" name="mutex" value="1"> 是否独占
				</td>
				</tr>
				</table><br>		
				</div>
				
				<!-- zhongcha_position -->
				<input type="checkbox" id="is_show_vo_position" name="is_show_vo_position" value="1" onclick=show_vo_position_div(this)> 是否定投中插位置 <br><br>
				<div id="show_vo_position_div" style="display:none">				
                <table id="vo_position_table" style="border: solid thin red">
                <tr>
				<td>定投中插点位:<input type="checkbox" name="vo_position" value="10013" > 中插第一点
				        <input type="checkbox" name="vo_position" value="10014"> 中插第二点
				        <input type="checkbox" name="vo_position" value="10015"> 中插第三点
				        <br></tr>
				</table><br>		
				</div>
			
				<!-- priority start -->
				预订方式:
							<select name="product_reserve_method" onChange="show_priority_div(this.value)">
								<option id = "reserve_cpm" value="1" selected>cpm</option>
								<option id = "reserve_priority" value="2" >定量优化</option>
								<option id = "reserve_time" value="3" >时间段</option>
								<option id = "reserve_lunbo" value="4" >轮替</option>
								<option id = "reserve_percent" value="5" >百分比</option>
								<option id = "reserve_cpc" value="6" >cpc</option>
								<option id = "reserve_cpv" value="7" >cpv</option>
								<option id = "reserve_cpp" value="8" >cpp</option>
								<option id = "reserve_shua" value="9" >shua</option>
							</select><br><br>
				<div id="priority" style="display:none">
				定量优化优先级：<input type="text" name="priority" value="1" size="1" id="priority"><br><br>
				</div>
				
				<!-- lunbo -->
				<div id="total_lun" style="display:none">
				总轮数：<input type="text" name="total_lun" value="5" size="1" id="total_lun"><br><br>
				</div>
				
				<!-- percent -->
				<div id="percent" style="display:none">
				百分比(%)：<input type="text" name="percent" value="50" size="1" id="percent"><br><br>
				</div>
				
				<!--
				<input type="checkbox" id="is_show_priority" name="is_show_priority" value="1" onclick=show_priority_div(this)> 是否定量优化 (移动角标)<br><br>			
				-->
				<!--
				<div id="show_priority_div" style="display:none">
					定量优化优先级：<input type="text" name="priority" value="1" /><font color='red'></font><br><br>
				</div>
                -->
				<!-- priority end -->
				投放时间：<input type="text"   id ="startDateRow"  name="startDateRow"> - <input type="text"  id ="endDateRow"  name="endDateRow"><font color='red'>  *</font>
				<br><br>
				<div id="all_channel" style="display:">
				分类定向：<input type="checkbox" id="all_channel" name="all_channel" onclick="show_channel_div(this,0)" value="1" > 全分类 <br>
				</div>
				<table><td>
				<div id="yk_all_channel" style="display:none"><input type="checkbox" id="all_channel" name="yk_all_channel" onclick="show_channel_div(this,1)" value="1">优酷全分类</div>
				</td><td>
				<div id="td_all_channel" style="display:none"><input type="checkbox" id="all_channel" name="td_all_channel" onclick="show_channel_div(this,2)" value="1">土豆全分类</div>
				</td></table>
				<div id="channel_div" style="display:none">
                <table style="border: solid thin green">
						<%
							for(int i = 0; i < y_channelList.size(); i++){
								Channel channel = y_channelList.get(i);
								
								if(i % 7 == 0){
									out.println("<tr>");
								}
						%>
						  
						   <td valign="top"><table style="border: solid thin blue">
								<tr>
								  <td>
								    <font color='red'>一级分类：</font><br>
									<input type="checkbox" name="chk_channel"  title="youku" value="<%=channel.getId()%>"><%="优酷" + channel.getName() %><br>
									<font color='red'>二级分类：</font>
									<input type="checkbox" name="second_class_checkbox" value="1" onclick="secondClass(this,1)">
								  </td>
								</tr>
						<%
						List<Channel> secondClass = EasyCastUtil.getAllConfigChannels(channel.getId());
						for(int ii = 0;ii < secondClass.size();ii++){
							Channel second_Class = secondClass.get(ii);
						%>						  	
							<tr class="yk_second_class" id="yk_second_class" style="display:none;">
							  <td>
							  <input type="checkbox" name="chk_channel"  title="youku" value="<%=second_Class.getId()%>"><%="优酷" + second_Class.getName() %>
							  </td>
							</tr>					  						
						<%	
						}
						%>									
						   </table></td>

						<%					
								if(i % 7 == 6){
									out.println("</tr>");
								}
							}
						%>
						<tr></tr><tr></tr>
						<%
							for(int i = 0; i < t_channelList.size(); i++){
								Channel channel = t_channelList.get(i);
								
								if(i % 7 == 0){
									out.println("<tr>");
								}
						%>
						   <td valign="top"><table style="border: solid thin green">
								<tr>
								  <td>
								    <font color='red'>一级分类：</font><br>
									<input type="checkbox" name="chk_channel" title="tudou" value="<%=channel.getId()%>"><%="土豆" + channel.getName() %><br>
									<font color='red'>二级分类：</font>
									<input type="checkbox" name="second_class_checkbox" value="2" onclick="secondClass(this,2)">
								  </td>
								</tr>
						<%
						List<Channel> secondClass = EasyCastUtil.getAllConfigChannels(channel.getId());
						for(int ii = 0;ii < secondClass.size();ii++){
							Channel second_Class = secondClass.get(ii);
						%>						  	
							<tr class="td_second_class" id="td_second_class" style="display:none;">
							  <td>
							  <input type="checkbox" name="chk_channel"  title="tudou" value="<%=second_Class.getId()%>"><%="土豆" + second_Class.getName() %>
							  </td>
							</tr>					  						
						<%	
						}
						%>									
						   </table></td>
						<%					
								if(i % 7 == 6){
									out.println("</tr>");
								}
							}
						%>
					</table>
					
				</div><br>
				
				<!-- 定向_start -->
				
				地区定向：<input type="checkbox" id="all_area" name="all_area" onclick="show_area_div(this)" value="1" checked> 全定向<br>
				<div id="area_div" style="display:none">
                <table style="border: solid thin red">
						<%
							for(int i = 0; i < areaList.size(); i++){
								Area area = areaList.get(i);
								
								if(i % 5 == 0){
									out.println("<tr>");
								}
						%>
						   <td valign="top"><table style="border: solid thin green">
								<tr>
								  <td>
								    <font color='red'>省份：</font><br>
									<input type="checkbox" name="chk_area"  title="china" value="<%=area.getId()%>"><%="" + area.getName() %><br>
									<font color='red'>城市：</font>
								  </td>
								</tr>
						<%
						List<Area> secondClass = EasyCastUtil.getAllConfigCitys(area.getId());
						for(int ii = 0;ii < secondClass.size();ii++){
							Area second_Class = secondClass.get(ii);
						%>						  	
							<tr>
							  <td>
							  <input type="checkbox" name="chk_area"  title="city" value="<%=second_Class.getId()%>"><%=second_Class.getName() %>
							  </td>
							</tr>					  						
						<%	
						}
						%>									
						   </table></td>	
						<%					
								if(i % 5 == 4){
									out.println("</tr>");
								}
							}
						%>
						<tr></tr><tr></tr>
				</table>
				</div><br>
				<!-- 定向_end -->
				
				<!-- pc平台_start -->
				
				<div id="pc_os_div" style="display:">
				pc平台：<input type="checkbox" id="pc_all_os" name="pc_all_os" onclick="show_os_pc_div(this)" value="1" > 全平台 <br><br>
				
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
									<input type="checkbox" name="chk_os_pc" title="不限_pc_不限_Web(pc)&&yk_pc_不限_app(iku)" checked value="<%=os.getValue()%>"><%=os.getName() %>
								    </td>
						     <%         	 
						             }else{
						     %> 
						            <td>
									<input type="checkbox" name="chk_os_pc" title="不限_pc_不限_Web(pc)&&yk_pc_不限_app(iku)" value="<%=os.getValue()%>"><%=os.getName() %>
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
				<!-- pc平台_end -->
				
				<div id="m_os_div" style="display:none">
				
			              移动平台：<input type="checkbox" id="all_os" name="all_os" onclick="show_os_div(this,0)" value="1" > 全平台 <br>
				<table><td>
				<div id="yk_all_os" style="display:none"><input type="checkbox" id="all_os" name="yk_all_os" onclick="show_os_div(this,1)" value="1">优酷平台</div>
				</td><td>
				<div id="td_all_os" style="display:none"><input type="checkbox" id="all_os" name="td_all_os" onclick="show_os_div(this,2)" value="1">土豆平台</div>
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
									<input type="checkbox" name="chk_os" title="youku" value="<%=os.getValue()%>"><%=os.getName() %>
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
				
				<input type="checkbox" id="is_show_campaign" name="is_show_campaign" value="1" onclick=show_campaign_div(this)> 是否关联show_campaign<br><br>
				<div id="show_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>曝光频次：<br><br></td>
				</tr>
				
				<tr>
				<td>
				查询：<select name="campaignList_show" id="campaignList_show" onChange="show_campaign(this.value)">
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
						<button type="button" onclick=clear_show_campaign(this)>清空</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				名称：<input type="text" name="campaign_show_name" value="" size="30" id="campaign_show_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				周期：<input type="text"   id ="startDateRow_show"  name="startDateRow_show" value="" > - <input type="text"  id ="endDateRow_show"  name="endDateRow_show" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				次序：<input type="text" name="campaign_sequence_show" value="0" size="3" id="campaign_sequence_show"> <font color='red'>(1-3表示定向第1到3次,0表示全程定向,4表示定向第4次)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>每个用户N天投放次数：<input type="text" name="campaign_days_show" id="campaign_days_show" size="2" value="1" /> 天 <input type="text" name="campaign_day_limit_show" id="campaign_day_limit_show" size="2" value="3" /> 次 <font color='red'>(0为不限制)</font><br><br></td>
				<tr>
				<tr>
					<td>单用户投放次数上限：<input type="text" name="campaign_num_limit_show" id="campaign_num_limit_show" size="2" value="10" /> 次 <font color='red'>(0为不做n+限制，建议不要超过99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
				
				<input type="checkbox" id="is_click_campaign" name="is_click_campaign" value="2" onclick=click_campaign_div(this)> 是否关联click_campaign<br><br>
				<div id="click_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>点击频次：<br><br></td>
				</tr>
				
				<tr>
				<td>
				查询：<select name="campaignList_click" id="campaignList_click" onChange="click_campaign(this.value)">
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
						<button type="button" onclick=clear_click_campaign(this)>清空</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				名称：<input type="text" name="campaign_click_name" value="" size="30" id="campaign_click_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				周期：<input type="text"   id ="startDateRow_click"  name="startDateRow_click" value="" > - <input type="text"  id ="endDateRow_click"  name="endDateRow_click" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				次序：<input type="text" name="campaign_sequence_click" value="0" size="3" id="campaign_sequence_click"> <font color='red'>(1-3表示定向第1到3次,0表示全程定向,4表示定向第4次)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>每个用户N天投放次数：<input type="text" name="campaign_days_click" id="campaign_days_click" size="2" value="1" /> 天 <input type="text" name="campaign_day_limit_click" id="campaign_day_limit_click" size="2" value="3" /> 次 <font color='red'>(0为不限制)</font><br><br></td>
				<tr>
				<tr>
					<td>单用户投放次数上限：<input type="text" name="campaign_num_limit_click" id="campaign_num_limit_click" size="2" value="10" /> 次 <font color='red'>(0为不做n+限制，建议不要超过99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
			
			    <input type="checkbox" id="is_over_campaign" name="is_over_campaign" value="3" onclick=over_campaign_div(this)> 是否关联over_campaign<br><br>
				<div id="over_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>完成频次：<br><br></td>
				</tr>
				
				<tr>
				<td>
				查询：<select name="campaignList_over" id="campaignList_over" onChange="over_campaign(this.value)">
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
						<button type="button" onclick=clear_over_campaign(this)>清空</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				名称：<input type="text" name="campaign_over_name" value="" size="30" id="campaign_over_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				周期：<input type="text"   id ="startDateRow_over"  name="startDateRow_over" value="" > - <input type="text"  id ="endDateRow_over"  name="endDateRow_over" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				次序：<input type="text" name="campaign_sequence_over" value="0" size="3" id="campaign_sequence_over"> <font color='red'>(1-3表示定向第1到3次,0表示全程定向,4表示定向第4次)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>每个用户N天投放次数：<input type="text" name="campaign_days_over" id="campaign_days_over" size="2" value="1" /> 天 <input type="text" name="campaign_day_limit_over" id="campaign_day_limit_over" size="2" value="3" /> 次 <font color='red'>(0为不限制)</font><br><br></td>
				<tr>
				<tr>
					<td>单用户投放次数上限：<input type="text" name="campaign_num_limit_over" id="campaign_num_limit_over" size="2" value="10" /> 次 <font color='red'>(0为不做n+限制，建议不要超过99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
				
				<input type="checkbox" id="is_skip_campaign" name="is_skip_campaign" value="4" onclick=skip_campaign_div(this)> 是否关联skip_campaign<br><br>
				<div id="skip_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>点击跳过频次：<br><br></td>
				</tr>
				
				<tr>
				<td>
				查询：<select name="campaignList_skip" id="campaignList_skip" onChange="skip_campaign(this.value)">
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
						<button type="button" onclick=clear_skip_campaign(this)>清空</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				名称：<input type="text" name="campaign_skip_name" value="" size="30" id="campaign_skip_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				周期：<input type="text"   id ="startDateRow_skip"  name="startDateRow_skip" value="" > - <input type="text"  id ="endDateRow_skip"  name="endDateRow_skip" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				次序：<input type="text" name="campaign_sequence_skip" value="0" size="3" id="campaign_sequence_skip"> <font color='red'>(1-3表示定向第1到3次,0表示全程定向,4表示定向第4次)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>每个用户N天投放次数：<input type="text" name="campaign_days_skip" id="campaign_days_skip" size="2" value="1" /> 天 <input type="text" name="campaign_day_limit_skip" id="campaign_day_limit_skip" size="2" value="3" /> 次 <font color='red'>(0为不限制)</font><br><br></td>
				<tr>
				<tr>
					<td>单用户投放次数上限：<input type="text" name="campaign_num_limit_skip" id="campaign_num_limit_skip" size="2" value="10" /> 次 <font color='red'>(0为不做n+限制，建议不要超过99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
				
				<!-- preload -->
				<input type="checkbox" id="is_preload_campaign" name="is_preload_campaign" value="5" onclick=preload_campaign_div(this)> 是否关联preload_campaign<br><br>
				<div id="preload_campaign_div" style="display:none">
				<table style="border: solid thin green">
				<tr>
					<td>preload频次：<br><br></td>
				</tr>				
				<tr>
				<td>
				查询：<select name="campaignList_preload" id="campaignList_preload" onChange="preload_campaign(this.value)">
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
						<button type="button" onclick=clear_preload_campaign(this)>清空</button><br><br>
				</td>				
				</tr>
				<tr>
				<td>
				名称：<input type="text" name="campaign_preload_name" value="" size="30" id="campaign_preload_name"><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				周期：<input type="text"   id ="startDateRow_preload"  name="startDateRow_preload" value="" > - <input type="text"  id ="endDateRow_preload"  name="endDateRow_preload" value="" ><br><br>
				</td>
				</tr>
				
				<tr>
				<td>
				次序：<input type="text" name="campaign_sequence_preload" value="0" size="3" id="campaign_sequence_preload"> <font color='red'>(1-3表示定向第1到3次,0表示全程定向,4表示定向第4次)</font><br><br>
				</td>
				</tr>
				
				<tr>
					<td>每个用户N天投放次数：<input type="text" name="campaign_days_preload" id="campaign_days_preload" size="2" value="1" /> 天 <input type="text" name="campaign_day_limit_preload" id="campaign_day_limit_preload" size="2" value="3" /> 次 <font color='red'>(0为不限制)</font><br><br></td>
				<tr>
				<tr>
					<td>单用户投放次数上限：<input type="text" name="campaign_num_limit_preload" id="campaign_num_limit_preload" size="2" value="10" /> 次 <font color='red'>(0为不做n+限制，建议不要超过99)</font><br><br></tr></td>
				</tr>
				</table>
				</div>
				
				<input type="checkbox" id="isVidLimit" name="isVidLimit" value="1"  onclick=show_videogroup_div(this)> 是否视频组定投 <br>
				<div id="videogroup_div" style="display:none"><br>
					优酷视频id列表（每行一个视频地址或id）<br>
					优酷节目id列表（每行一个节目id）<br>
					优酷专辑id列表(参数d)<br>
					入口营销(ev参数值，取值范围1-42)<br>
					note:youku单视频(E.g,http://v.youku.com/v_show/id_XODczMzU0NTAw.html)<br>
					<textarea id="video_group_area1" name="video_group_area1" rows="10" cols="100"></textarea><br><br><br>
					土豆视频id列表（每行一个视频地址或id）——需要按照下面的规则填写<br>
					土豆节目id列表（每行一个节目id）<br>
					土豆专辑id列表(参数d)<br>
					note:tudou单视频(E.g,http://www.tudou.com/programs/view/1J8Cr28HQNU/ 或者：http://www.tudou.com/albumplay/ynpl4a9iYlc/Ck3kaCmoT2E.html)<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/programs/view/([a-zA-Z_0-9\\-]{11}).*|" +  // 单视频播放页<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/id/?(\\d+)|" +<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/album/id(\\d+).html|" +<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/p/a(\\d+).html|" +<br>
					"http\\:\\/\\/\\[作品\\](\\d+)-.*|" +      //作品正则表达式匹配<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/albumcover/([a-zA-Z_0-9\\-]{11}).html|" + //剧集过渡页改版、剧集封面 <br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/listcover/([a-zA-Z_0-9\\-]{11}).html|" +<br>
		 	       
					"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|" +  // 豆单播放页 <br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/([a-zA-Z_0-9\\-]{11}).html|" +  // 豆单播放页 <br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|" + // 剧集播放页<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/([a-zA-Z_0-9\\-]{11}).html|" + // 剧集播放页<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/oplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|" + // 周边播放页<br>
					"http\\:\\/\\/\\w+\\.tudou\\.com/plcover/([a-zA-Z_0-9\\-]{11}).*|" + //// 豆单封面<br>
					<textarea id="video_group_area2" name="video_group_area2" rows="10" cols="100"></textarea><br><br>
				</div><br>
				
				<!-- 关键字定投 -->
				<input type="checkbox" id="isVidKeywords" name="isVidKeywords" value="1"  onclick=show_keywords_div(this)> 是否定投关键字<br>
				<div id="keywords_div" style="display:none"><br>
				<textarea id="vid_keywords" name="vid_keywords" rows="5" cols="80"></textarea><br><br>
				</div><br>
				<!-- 用户定投-->
				<!-- 渠道定投-->
				<!-- 参数定投-->
				<input type="checkbox" id="isVidParameter" name="isVidParameter" value="1"  onclick=show_parameter_div(this)> 是否定投参数<br>
				<div id="parameters_div" style="display:none"><br>
				<select id ="parameter_names" name="parameter_names" onChange=disabled_parameters(this.value)>
				                <option value="nothing" selected></option>
								<option value="1" >试看参数</option>
								<option value="2" >出品方</option>
								<option value="3" >vip用户</option>
								<option value="4" >channel</option>
								<option value="5" >是否付费视频</option>
				</select>&nbsp;&nbsp;
								<select id ="parameter_values" name="parameter_values">
								<option id = "nothing" value= "" selected></option>
								<option id = "time" value="time" >按分钟试看</option>
								<option id = "cannot" value="cannot" >非试看</option>
								<option id = "episode" value="episode" >按剧集试看</option>
								<option id = "tvb" value="tvb" >tvb</option>
								<option id ="yes" value="5" >是</option>
								<option id = "no" value="6" >否</option>
								<option id = "Playgoods" value="7" >站外_玩货</option>								
				</select>
				</div><br>
				
				<!-- priority_setting:start -->
				<div id="priority_setting" style="display:"> 
		                            优先级设置：<input type="checkbox" name="priority_setting_ad" onclick="toggle('priority_setting_ad')" /><br><br>
	            </div>
	            <div id="priority_setting_ad" style="display:none">
	            <table id="priority_setting_ad_table" style="border: solid thin blue">
	            <tr>
	            <td>vip优先级(↑↓)：&nbsp&nbsp</td> 
	            <td>广告商优先级(↑↑)：&nbsp&nbsp</td> 
	            <td>优先级数字(↑↑)：&nbsp&nbsp</td>
	            </tr>
	            <tr>
				<td>
				<select id ="vip_priority" name="vip_priority">
				                <option value="无" selected>无</option>
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
				
				<!-- sow_type -->
				播种类型：<select id ="sow_type" name="sow_type" onChange=sow_type_selected(this.value)>
				                <option value="0" selected>无播种控制</option>
								<option value="1" >随机播种</option>
								<option value="2" >优化播种</option>								
				</select><br>
				
				<div id="sow_rate_setting" style="display:none"> 
			              播种比例：<input type="text" name="sow_rate" /> cookies留存时间：<input type="text" name="cookies_time"/><br>
	            </div>
	            
	            <div id="sow_threshold_setting" style="display:none"> 
			              阈值：<input type="text" name="sow_threshold" /><br>
	            </div><br>
	            
				<!-- sow_type -->
				
				<div id="millwardbrown_div" style="display:">					
				Millwardbrown(PC/移动web) 投放类型：
				<select name="millwardbrown_ad_type" id="ad_type_pc_web" onChange=show_millwardbrown_div(this.value) >
					<option id="vt0" value="-1" selected>非调研广告</option>
					<option value="1">Expose实验组</option>
					<option id="vt2" value="2">Control对照组</option>
				</select>			
				</div>
				
				<div id="youku_survey_url" style="display:none">
				优酷调研地址：<input type="text" name="youku_survey_url" value="http://atm.youku.com/test-youkuvc" size="50" id="youku_survey_url">
				</div>
				<div id="tudou_survey_url" style="display:none">
				土豆调研地址：<input type="text" name="tudou_survey_url" value="http://atm.youku.com/test-tudouvc" size="50" id="tudou_survey_url">
				</div><br>
				
				<!-- app_millwardbrown -->
				<div id="millwardbrown_app_div" style="display:">
				Millwardbrown(APP) 投放类型：
				<select name="millwardbrown_ad_type_APP" id="ad_type_APP" onChange=show_millwardbrown_div_app(this.value)>
					<option id="vt0_APP" value="-1" selected>非调研广告</option>
					<option value="1">Expose实验组</option>
					<option value="2">Control对照组</option>
				</select>
				</div>
				
				<div id="survey_show_url" style="display:none">
				调研曝光地址：<input type="text" name="survey_show_url_app" value="http://atm.youku.com/test-millwardbrown_expose_url" size="50" id="youku_survey_url">
				</div>
				<div id="survey_click_url" style="display:none">
				调研点击地址：<input type="text" name="survey_click_url_app" value="http://atm.youku.com/test-millwardbrown_click_url" size="50" id="tudou_survey_url">
				</div>
				<div id="survey_entry_text" style="display:none">
				问卷入口文字：<input type="text" name="survey_entry_text_app" value="millwardbrown" size="50" id="tudou_survey_url">
				</div><br>
				
				<!-- app_millwardbrown -->

				<div id="clickurl" style="display:">点击地址：<input type="text" name="click_url" value="http://www.baidu.com" size="40"/>
				</div><br>
				<div id="mb_app_click_way" style="display:none"> 移动app点击跳转方式：

				  <select name="mb_click" id="mb_click" >
                                <option value="1">弹出webview</option>							
								<option value="0" selected="selected">跳转到浏览器</option>
								<option value="2">app内播放页</option>
								<option value="3">app内节目页</option>
								<option value="4">app内专题页</option>
								<!-- 文字链  -->
								<option value="6">跳转到游戏sdk</option>
								
				  </select><br><br>
				</div>
				</div>
				
				<div id="khoverurl" style="display:">客户提供的播放完成检测地址：<input type="text" name="over_url" value="http://www.baidu.com?over" size="40"/> <br><br></div>
				<div id="outtime" style="display:">播放中监测时间点(秒)：<input type="text" name="over_url_time" value="0" size="1"/> <br><br></div>
				<div id="khshowurl" style="display:">客户提供的曝光监测地址：<input type="text" name="show_url" value="http://admaster.com.cn/i/a10949,b200109684,c1851,i0,m202,h" size="40"/> <br><br></div>
				<div id="khclickurl" style="display:">客户提供的点击监测地址：<input type="text" name="click_kh_url" value="http://www.baidu.com?click" size="40"/> <br><br></div>
				<div id="khplayingurl" style="display:">客户提供的播放中监测地址：<input type="text" name="playing_url" value="http://www.playing.com?" size="40"/> <br><br></div>
				<div id="othershowurl" style="display:">标准第三方公司的曝光监测地址：<input type="text" name="iso_url" value="http://www.baidu.com?iso_show" size="40"/> <br><br></div>
				<!--  
				<div id="MTurl" style="display:">广告播放中达到MT时间点的时候请求此监测地址 ：<input type="text" name="mt_url" value="http://www.baidu.com?mt" size="40"/> <br><br></div>
				-->
				<div id="otherclickurl" style="display:">标准第三方的点击监测地址  ：<input type="text" name="iso_click_url" value="http://www.baidu.com?iso_click" size="40"/> <br><br></div>
				<div id="otherh5showurl" style="display:">标准第三方公司的互动页面曝光监测地址：<input type="text" name="iso_h5_url" value="http://www.shu.com" size="40"/> <br><br></div>
				<div id="customtexturl" style="display:none">自定义文字点击地址：<input type="text" name="customtext_url" id="customtext_url" value="http://www.customtext.com" size="40"/> <br><br></div>
				<div id="clientcustomclickurl" style="display:none">客户提供的自定义文字点击监测地址：<input type="text" name="clientcustomclick_url" id="clientcustomclick_url" value="http://www.clientcustomclickurl.com" size="40"/> <br><br></div>
				<div id="clientskipurl" style="display:none">客户提供的跳过监测地址：<input type="text" name="clientskip_url" value="http://www.clientskipurl.com" size="40"/> <br><br></div>
				<div id="clientfeeurl" style="display:none">客户提供的计费监测地址：<input type="text" name="clientfee_url" value="http://www.clientfeeurl.com" size="40"/> <br><br></div>
				<div id="othercustomtextclickurl" style="display:none">标准第三方提供的自定义文字点击监测地址：<input type="text" name="othercustomtextclick_url" value="http://www.othercustomtextclickurl.com" size="40"/> <br><br></div>
				<div id="otherskipurl" style="display:none">标准第三方的跳过监测地址：<input type="text" name="otherskip_url" value="http://www.otherskipurl.com" size="40"/> <br><br></div>
				<div id="otherfeepurl" style="display:none">标准第三方的计费监测地址：<input type="text" name="otherfeep_url" value="http://www.otherfeepurl.com" size="40"/> <br><br></div>
				<div id="chargingthreshold" style="display:none">计费阙值：<input type="text" name="chargingthreshold_text" value="15" size="15"/> <br><br></div>
				
				<div id="ies_monitor" style="display:">ies第三方检测：
				<select name="ies_monitor">
								<option value="1" selected>不启用</option>
								<option value="2" >admaster</option>
				</select><br></div><br>
				
				<div id="m_issdk" style="display:none">				
				监测方式:
					<select name="m_issdk" >
						<option value="0" selected>API监测</option>
						<option value="1" >sdk监测</option>
						<option value="2" >阿里sdk监测</option>
						<option value="3" >游戏sdk</option>
					</select><br><br>
				</div>
												
				<!-- is_bark -->
				<div id="isCast_barkidea" style="display:">	
				<input type="checkbox" id="isCast_bark" name="isCast_bark" value="1" > 是否是备选素材 <br><br>
				</div>
				
				素材内容填写：
				<div id="pcdevice" style="display:">
				<div id = "pc_vf" style="display:">
				<table id="pc_vf_table" style="border: solid thin red">
					<tr>
						<td colSpan="3"><b>新前贴</b></td>
					</tr>
					<tr>
						<td>优酷素材地址</td>
						<td><input type="text" name="pc_vf_y_ideaurl" id="pc_vf_y_ideaurl" size="100" onmouseout="checkIdeaUrl(this)" ></td>
					</tr>
					<tr>
						<td>PIP小图地址</td>
						<td><input type="text" name="pc_vf_pipurl" size="100"></td>
					</tr>
					<tr class="pc_loader" id="loader" style="display:none;">
					    <td >loader类型：</td>
						<td >
						    <select name="loader_type">
								<option value="1" selected>国内loader</option>
								<option value="2" >国外loader</option>
								<option value="3" >国内测试loader</option>
							</select>
						</td>
					</tr>
					<tr class="pc_loader_vf_showtime" id="loader_vf_showtime" style="display:none;">
					    <td >素材时长：</td>
						<td >
                        <input type="text" name="pc_vf_loader_showtime" id = "pc_vf_loader_showtime" size="5" value = "">
						</td>
					</tr>
					
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >自定义文字：</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="进入官网" selected>进入官网</option>
								<option value="欣赏广告" >欣赏广告</option>
								<option value="请选择" >请选择</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>前贴类型</td>
						<td><input type="radio" id="normal_pc" name="pvimpression_pc" onclick="tiepian_pc(this,0)" value="0" checked>普通贴片
							<input type="radio" id="vpaid_pc" name="pvimpression_pc" onclick="tiepian_pc(this,1)" value="1">互动贴片
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
						<td colSpan="2"><b>新暂停</b></td>
					</tr>
					<tr>
						<td>优酷素材地址(只支持flash或图片)</td>
						<td><input type="text" name="pc_vp_y_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>优酷全屏时素材地址(只支持flash或图片)</td>
						<td><input type="text" name="pc_vp_y_full_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>土豆素材地址(只支持flash或图片)</td>
						<td><input type="text" name="pc_vp_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>土豆全屏时素材地址(只支持flash或图片)</td>
						<td><input type="text" name="pc_vp_t_full_ideaurl" size="100"></td>
					</tr>

					<tr>
						<td>素材控制策略</td>
						<td>
							<select name="pc_vp_ideacontrol">
								<option value="1" selected>播放器控制</option>
								<option value="2" >素材部分自控制</option>
							</select>
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
						<td colSpan="2"><b>新中插</b></td>
					</tr>
					<tr>
						<td>素材地址</td>
						<td><input type="text" name="pc_vob_ideaurl" size="100"  onmouseout="checkIdeaUrl(this)" ></td>
					</tr>
					<tr>
						<td>PIP小图地址</td>
						<td><input type="text" name="pc_vob_pipurl" size="100"></td>
					</tr>
					<tr class="pc_loader" id="loader" style="display:none;">
					    <td >loader类型：</td>
						<td >
						    <select name="loader_type_vob">
								<option value="1" selected>国内loader</option>
								<option value="2" >国外loader</option>
								<option value="3" >国内测试loader</option>
							</select>
						</td>
					</tr>
					<tr class="pc_loader_vob_showtime" id="loader_vob_showtime" style="display:none;">
					    <td >素材时长：</td>
						<td >
                        <input type="text" name="pc_vob_loader_showtime" id = "pc_vob_loader_showtime" size="5" value = "">
						</td>
					</tr>
					<tr>
						<td>中插类型</td>
						<td><input type="radio" id="normal_pc_vob" name="pvimpression_pc_vob" onclick="tiepian_pc(this,0)" value="0" checked>普通贴片
							<input type="radio" id="vpaid_pc" name="pvimpression_pc_vob" onclick="tiepian_pc(this,1)" value="1">互动贴片
							<input type="radio" id="customtext" name="pvimpression_pc_vob" onclick="tiepian_pc(this,2)" value="2">trueview</td>
					</tr>
				</table><br>
				</div>
				<div id = "pc_vb" style="display:none">
				<table id="pc_vb_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>新后贴</b></td>
					</tr>
					<tr>
						<td>素材地址</td>
						<td><input type="text" name="pc_vb_ideaurl" size="100" onmouseout="checkIdeaUrl(this)" ></td>
					</tr>
					<tr class="pc_loader" id="loader" style="display:none;">
					    <td >loader类型：</td>
						<td >
						    <select name="loader_type_vb">
								<option value="1" selected>国内loader</option>
								<option value="2" >国外loader</option>
								<option value="3" >国内测试loader</option>
							</select>
						</td>
					</tr>
					<tr class="pc_loader_vb_showtime" id="loader_vb_showtime" style="display:none;">
					    <td >素材时长：</td>
						<td >
                        <input type="text" name="pc_vb_loader_showtime" id = "pc_vb_loader_showtime" size="5" value = "">
						</td>
					</tr>
					<tr>
						<td>后贴类型</td>
						<td><input type="radio" id="normal_pc_vb" name="pvimpression_pc_vb" onclick="tiepian_pc(this,0)" value="0" checked>普通贴片
							<input type="radio" id="vpaid_pc" name="pvimpression_pc_vb" onclick="tiepian_pc(this,1)" value="1">互动贴片
							<input type="radio" id="customtext" name="pvimpression_pc_vb" onclick="tiepian_pc(this,2)" value="2">trueview</td>
					</tr>
				</table><br>
				</div>
				
				<div id = "pc_tp" style="display:none">
				<table id="pc_tp_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>新贴片</b></td>
					</tr>
					<tr>
						<td>素材地址(只支持flv格式)</td>
						<td><input type="text" name="pc_tp_ideaurl" size="100" onmouseout="checkIdeaUrl(this)" ></td>
					</tr>
					<tr class="pc_loader" id="loader" style="display:none;">
					    <td >loader类型：</td>
						<td >
						    <select name="loader_type_tp">
								<option value="1" selected>国内loader</option>
								<option value="2" >国外loader</option>
								<option value="3" >国内测试loader</option>
							</select>
						</td>
					</tr>
					<tr class="pc_loader_tp_showtime" id="loader_tp_showtime" style="display:none;">
					    <td >素材时长：</td>
						<td >
                        <input type="text" name="pc_tp_loader_showtime" id = "pc_tp_loader_showtime" size="5" value = "">
						</td>
					</tr>
					<tr>
						<td>贴片类型</td>
						<td><input type="radio" id="normal_pc_tp" name="pvimpression_pc_tp" onclick="tiepian_pc(this,0)" value="0" checked>普通贴片
							<input type="radio" id="vpaid_pc" name="pvimpression_pc_tp" onclick="tiepian_pc(this,1)" value="1">互动贴片
							<input type="radio" id="customtext" name="pvimpression_pc_tp" onclick="tiepian_pc(this,2)" value="2">trueview</td>
					</tr>
				</table><br>
				</div>
				
				<div id = "pc_crazy" style="display:none">
				<table id="pc_crazy_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>新crazy</b></td>
					</tr>
					<tr>
						<td>优酷js内容</td>
						<td><textarea type="text" id ="textarea" name="pc_crazy_y_js" rows="10" cols="80"></textarea></td>
						<!--  
						<td><input type="button" value="filter" onclick="CutChr()"></td>
						-->
					</tr>
					<tr>
						<td>土豆素材地址(只支持flash)</td>
						<td><input type="text" name="pc_crazy_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>素材时长</td>
						<td><input type="text" name="pc_crazy_youkutudou_length" value="" size="2"></td>
					</tr>
				</table><br>
				</div>
				<div id = "pc_selector" style="display:none">
				<table id="pc_selector_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>新AD selector</b></td>
					</tr>
					<tr>
						<td>优酷js内容</td>
						<td><input type="text" name="pc_selector_y_js" size="100"></td>
					</tr>
					<tr>
						<td>土豆素材地址(只支持flash)</td>
						<td><input type="text" name="pc_selector_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>素材时长</td>
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
						<td colSpan="2"><b>新短视频全屏</b></td>
					</tr>
					<tr>
						<td>优酷素材地址(只支持flash)</td>
						<td><input type="text" name="pc_shortfull_y_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>土豆素材地址(只支持flash)</td>
						<td><input type="text" name="pc_shortfull_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>flash宽</td>
						<td><input type="text" name="pc_shortfull_youkutudou_width" value="" size="2"></td>
					</tr>
					<tr>
						<td>flash高</td>
						<td><input type="text" name="pc_shortfull_youkutudou_height" value="" size="2"></td>
					</tr>
					<tr>
						<td>素材时长</td>
						<td><input type="text" name="pc_shortfull_youkutudou_length" value="" size="2"></td>
					</tr>
				</table><br>
				</div>
				<div id = "pc_vc" style="display:none">
				<table id="pc_vc_table" style="border: solid thin red">
					<tr>
						<td colSpan="2"><b>新角标</b></td>
					</tr>
					<tr>
						<td>优酷角标广告内容地址(只支持flash或者图片格式)</td>
						<td><input type="text" name="pc_vc_y_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>优酷素材控制策略</td>
						<td>
							<select name="pc_vc_y_rightpx2">
							    <option value="0" >无控制策略</option>
								<option value="1" >播放器控制显示位置和跳转</option>
								<option value="2" >播放器控制显示位置，素材控制跳转</option>
								<option value="3" selected >素材控制显示位置和跳转</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>土豆角标广告内容地址(只支持flash或者图片格式)</td>
						<td><input type="text" name="pc_vc_t_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>土豆素材控制策略</td>
						<td>
							<select name="pc_vc_t_rightpx2">
							    <option value="0" >无控制策略</option>
								<option value="1" >播放器控制显示位置和跳转</option>
								<option value="2" >播放器控制显示位置，素材控制跳转</option>
								<option value="3" selected >素材控制显示位置和跳转</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>素材定位方式</td>
						<td><input type="radio" id="bottom_left" name="pc_vc_position" value="0" checked>左下
						    <input type="radio" id="bottom_right" name="pc_vc_position" value="1">右下
							<input type="radio" id="bottom_center" name="pc_vc_position" value="2">中下
							<input type="radio" id="top_left" name="pc_vc_position" value="3">左上
							<input type="radio" id="top_right" name="pc_vc_position" value="4">右上
							<input type="radio" id="top_center" name="pc_vc_position" value="5">中上</td>
							
					</tr>
					<tr>
						<td>定投时间点</td>
						<td><input type="radio" id="zero_minute" name="vc_time_spot" value="0" onclick="getvalue(this.value)" checked>0分钟
						    <input type="radio" id="one_minute" name="vc_time_spot" value="1" onclick="getvalue(this.value)">1分钟
							<input type="radio" id="five_minute" name="vc_time_spot" value="5" onclick="getvalue(this.value)">5分钟
							<input type="radio" id="twenty_minitue" name="vc_time_spot" value="20" onclick="getvalue(this.value)">20分钟及以后</td>		
					</tr>
					<tr>
						<td>广告时长</td>
						<td><input type="text" name="pc_vc_showtime" id = "pc_vc_showtime" size="5" value = "45" onmouseout="checkadlen(this)"></td>
					</tr>
					<tr>
						<td>素材规格（宽）</td>
						<td><input type="text" name="pc_vc_width" id = "pc_vc_width" size="5" value = ""></td>
					</tr>
					<tr>
						<td>素材规格（高）</td>
						<td><input type="text" name="pc_vc_height" id = "pc_vc_height" size="5" value = ""></td>
					</tr>
					
					
					 <tr>
						<td>pc角标关闭方式</td>
						<td>
							<select name="pc_vc_close_method">
								<option value="1" selected>直接关闭</option>
								<option value="2" >收缩</option>
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
						<td colSpan="2"><b>新开机图</b></td>
					</tr>
					<tr>
						<td>素材地址 PCIKU-1024x650(只支持图片)</td>
						<td><input type="text" name="m_iku_pc_ideaurl_650" size="100"></td>
					</tr>
					<tr>
						<td>素材地址 PCIKU-1270x720(只支持图片)</td>
						<td><input type="text" name="m_iku_pc_ideaurl_720" size="100"></td>
					</tr>
					
					<tr>
						<td>素材时长</td>
						<td><input type="text" name="m_mi_atv_t" value="5" size="5"></td>
					</tr>
				</table><br>
				</div>
                
				</div>
				<div id="mdevice" style="display:none">
				<div id = "m_vf" style="display:">
				<table id="m_vf_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>移动前贴</b></td>
					</tr>
					
					<tr>
						<td>投放通道</td>
						<td>
							<select name="m_qtsdk" id="m_qtsdk" onchange="show_sdkid(this.value,'qiantie_idea')">
								<option value="0">自主投放</option>
								<%
									
										List<SdkName> sdklist = SdkNamePeer.doSelect(new Criteria());
										for(int j=0;j<sdklist.size();j++) {
											int sdkid = sdklist.get(j).getId();
								%>
								<option value="<%=sdkid%>"><%=sdklist.get(j).getName()%>投放</option><%
										}
									
								%>
							</select>							
							
						</td>
					</tr>
					
					<tr class="qiantie_idea" id="m_vf_ideaurl_mb">
						<td>素材地址(只支持flv格式)</td>
						<td><input type="text" name="m_vf_ideaurl" id="m_vf_ideaurl" size="100" onmouseout="checkIdeaUrl(this)" ></td>
					</tr>
					
					<tr class="h5_idea_phone" id="m_h5_vf_ideaurl_phone" style="display:none;">
						<td>phone端互动页面地址</td>
						<td><input type="text" name="m_h5_vf_ideaurl_phone" size="100" ></td>
					</tr>
					
					<tr class="h5_idea_pad" id="m_h5_vf_ideaurl_pad" style="display:none;">
						<td>pad端互动页面地址</td>
						<td><input type="text" name="m_h5_vf_ideaurl_pad" size="100" ></td>
					</tr>
					
					<tr class="custom_text" id="pc_custom_text" style="display:none;">
					    <td >自定义文字：</td>
						<td >
						    <select name="custom_text" id="custom_text" >
								<option value="进入官网" selected>进入官网</option>
								<option value="欣赏广告" >欣赏广告</option>
								<option value="请选择" >请选择</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>贴片类型</td>
						<td><input type="radio" id="normal" name="pvimpression" onclick="tiepian_m(this,0)" value="0" checked>普通贴片
							<input type="radio" id="vpaid" name="pvimpression" onclick="tiepian_m(this,1)" value="1">互动贴片
							<input type="radio" id="customtext_m" name="pvimpression" onclick="tiepian_m(this,2)" value="2">trueview</td>
					</tr>
					
				</table><br>
				</div>
				<div id = "m_vb" style="display:none">
				<table id="m_vb_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>移动后贴</b></td>
					</tr>
					<tr>
						<td>素材地址(只支持flv格式)</td>
						<td><input type="text" name="m_vb_ideaurl" size="100" onmouseout="checkIdeaUrl(this)" ></td>
					</tr>
				</table><br>
				</div>
				
				
				<div id = "m_vtp" style="display:none">
				<table id="m_vtp_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>移动贴片</b></td>
					</tr>
					<tr>
						<td>素材地址(只支持flv格式)</td>
						<td><input type="text" name="m_vtp_ideaurl" size="100" onmouseout="checkIdeaUrl(this)" ></td>
					</tr>
				</table><br>
				</div>
				
				
				<div id = "m_vp" style="display:none">
				<table id="m_vp_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>移动暂停</b></td>
					</tr>
					<tr>
						<td>投放通道</td>
						<td>
							<select name="m_ztsdk" id="m_ztsdk" onchange="show_sdkid(this.value,'zanting_idea')">
								<option value="0">自主投放</option>
								<%
									
										//List<SdkName> sdklist = SdkNamePeer.doSelect(new Criteria());
										for(int j=0;j<sdklist.size();j++) {
											int sdkid = sdklist.get(j).getId();
								%>
								<option value="<%=sdkid%>"><%=sdklist.get(j).getName()%>投放</option><%
										}
									
								%>
							</select>
							
							
						</td>
					</tr>
					<tr class="zanting_idea" id="m_vp_ideaurl">
						<td>素材地址(只支持图片)</td>
						<td><input type="text" name="m_vp_ideaurl" size="100"></td>
					</tr>
				</table><br>
				</div>
				<div id = "m_vc" style="display:none">
				<table id="m_vc_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>移动角标</b></td>
					</tr>
					<tr>
						<td>展开状态页面地址</td>
						<td><input type="text" name="m_vc_openstatus_pageurl" size="100"></td>
					</tr>
					<tr>
						<td>收起状态图片地址(只支持图片)</td>
						<td><input type="text" name="m_vc_closestatus_pageurl" size="100"></td>
					</tr>
				</table><br>
				</div>
				<div id = "m_mi" style="display:none">
				<table id="m_mi_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>移动开机图</b></td>
					</tr>
					<tr>
						<td>素材地址 iPad-1024*768(只支持图片)</td>
						<td><input type="text" name="m_mi_ipad_ideaurl_768" size="100"></td>
					</tr>
					<!--  
					<tr>
						<td>素材地址 iPad-768*1004(只支持图片)</td>
						<td><input type="text" name="m_mi_ipad_ideaurl_1004" size="100"></td>
					</tr>
					-->
					<tr>
						<td>素材地址 iPhone-640*960(只支持图片)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_940" size="100"></td>
					</tr>
					<tr>
						<td>素材地址 iPhone-640*1136(只支持图片)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_1116" size="100"></td>
					</tr>
					<tr>
						<td>素材地址 iphone6-750*1334(只支持图片)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_1334" size="100"></td>
					</tr>
					<tr>
						<td>素材地址 iphone6 Plus-828*1472(只支持图片)</td>
						<td><input type="text" name="m_mi_iphone_ideaurl_1920" size="100"></td>
					</tr>
					<tr>
						<td>素材地址 AndroidPAD-1280*800(只支持图片)</td>
						<td><input type="text" name="m_mi_apad_ideaurl_800" size="100"></td>
					</tr>
					<tr>
						<td>素材地址 AndroidPAD-1024*600(只支持图片)</td>
						<td><input type="text" name="m_mi_apad_ideaurl_600" size="100"></td>
					</tr>
					
					<tr>
						<td>素材地址 AndroidPAD-1024*768(只支持图片)</td>
						<td><input type="text" name="m_mi_apad_ideaurl_768" size="100"></td>
					</tr>
					
					<tr>
						<td>素材地址 AndroidPhone-720*1280(只支持图片)</td>
						<td><input type="text" name="m_mi_aphone_ideaurl_1280" size="100"></td>
					</tr>
					<tr>
						<td>素材地址 AndroidPhone-480*800(只支持图片)</td>
						<td><input type="text" name="m_mi_aphone_ideaurl_800" size="100"></td>
					</tr>
					<tr>
						<td>素材地址 AndroidTV-1280*720(只支持图片)</td>
						<td><input type="text" name="m_mi_atv_ideaurl_720" size="100"></td>
					</tr>
					<tr>
						<td>素材时长</td>
						<td><input type="text" name="m_mi_atv_t" value="5" size="5"></td>
					</tr>
				</table><br>
				</div>
							
				<!-- 移动全屏-->
				<div id = "m_mQP" style="display:none">
				<table id="m_mQP_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>移动全屏</b></td>
					</tr>
					<tr>
						<td>投放通道</td>
						<td>
							<select name="m_sdk" id="m_sdk" onchange="show_sdkid(this.value,'quanping_idea')">
								<option value="0">自主投放</option>
								<%
									
										sdklist = SdkNamePeer.doSelect(new Criteria());
										for(int j=0;j<sdklist.size();j++) {
											int sdkid = sdklist.get(j).getId();
								%>
								<option value="<%=sdkid%>"><%=sdklist.get(j).getName()%>投放</option><%
										}
									
								%>
							</select>
							
							
						</td>
					</tr>
					<tr class="quanping_idea" id="m_mQP_ideaurl">
						<td>素材地址 YK(IPAD-1024*768)</td>
						<td><input type="text" name="m_mqp_ipad_ideaurl_748" size="100"></td>
					</tr>
					<tr class="quanping_idea" id="m_mQP_ideaurl">
						<td>素材地址 YK(IPhone-854*480)</td>
						<td><input type="text" name="m_mqp_iphone_ideaurl_480" size="100"></td>
					</tr>
					<tr class="quanping_idea" id="m_mQP_ideaurl">
						<td>素材地址 YK(AndroidPAD-1280*720)</td>
						<td><input type="text" name="m_mqp_androidpad_ideaurl_720" size="100"></td>
					</tr>
					<tr class="quanping_idea" id="m_mQP_ideaurl">
						<td>素材地址 YK(AndroidPhone-854*480)</td>
						<td><input type="text" name="m_mqp_androidphone_ideaurl_480" size="100"></td>
					</tr>
					<tr>
						<td>广告时长</td>
						<td><input type="text" name="m_quanping_showtime" id = "m_quanping_showtime" size="5" value = "5" ></td>
					</tr>
					
				</table><br>
				</div>
				
				<!-- 移动中插-->
			    <div id = "m_mo" style="display:none">
				<table id="m_mo_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>移动中插</b></td>
					</tr>
					<tr>
						<td>素材地址(只支持flv格式)</td>
						<td><input type="text" name="m_mo_ideaurl" size="100" onmouseout="checkIdeaUrl(this)" ></td>
					</tr>
				</table><br>
				</div>
				<!-- 移动中插 end -->	
	
				<!-- 文字链start -->
				<div id = "m_mhtml" style="display:none">
				<table id="m_mhtml_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>文字链</b></td>
					</tr>
					<tr>
						<td>移动图片地址</td>
						<td><input type="text" name="m_mhtml_ideaurl" size="100"></td>
					</tr>
					<tr>
						<td>文字内容*</td>
						<td><input type="text" name="m_mhtml_text_content" size="100" ></td>
					</tr>
					<tr>
						<td>点击地址*</td>
						<td><input type="text" name="m_mhtml_clickurl" size="100" ></td>
					</tr>
					<tr>
						<td>文字样式（请输入class名称)</td>
						<td><input type="text" name="m_mhtml_textlayout" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- 文字链end -->
				
				<!-- 移动app搜索页banner_start -->
				<div id = "m_searchBanner" style="display:none">
				<table id="m_searchBanner_table" style="border: solid thin blue">
				    <tr>
						<td colSpan="2"><b>移动app搜索页banner</b></td>
					</tr>
					<tr>
						<td>素材类型*</td>
						<td>
							<select name="app_search_banner_type" onChange=app_search_banner(this.value)>
								<option value="1" selected>自有素材</option>
								<option value="2" >阿里sdk</option>
							</select>
						</td>
					</tr>
					<tr class="app_search_banner_youkupip_url" id="app_search_banner_youkupip_url" style="display:;">
						<td>优酷图片素材地址</td>
						<td><input type="text" name="app_search_banner_youkupip_url" size="100" ></td>
					</tr>
					<tr class="app_search_banner_youkupip_clickurl" id="app_search_banner_youkupip_clickurl" style="display:;">
						<td>优酷点击地址</td>
						<td><input type="text" name="app_search_banner_youkupip_clickurl" size="100" ></td>
					</tr>
					<tr class="app_search_banner_youkupip_showurl" id="app_search_banner_youkupip_showurl" style="display:;">
						<td>优酷曝光地址</td>
						<td><input type="text" name="app_search_banner_youkupip_showurl" size="100" ></td>
					</tr>
					<tr class="app_search_banner_tudoupip_url" id="app_search_banner_tudoupip_url" style="display:;">
						<td>土豆图片素材地址</td>
						<td><input type="text" name="app_search_banner_tudoupip_url" size="100" ></td>
					</tr>
					<tr class="app_search_banner_tudoupip_clickurl" id="app_search_banner_tudoupip_clickurl" style="display:;">
						<td>土豆点击地址</td>
						<td><input type="text" name="app_search_banner_tudoupip_clickurl" size="100" ></td>
					</tr>
					<tr class="app_search_banner_tudoupip_showurl" id="app_search_banner_tudoupip_showurl" style="display:;">
						<td>土豆曝光地址</td>
						<td><input type="text" name="app_search_banner_tudoupip_showurl" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- 移动app搜索页banner_end -->
				
				<!-- vhtml_youku_banner_start -->
				<div id = "vhtml_yt_banner_pip" style="display:none">
				<table id="vhtml_yt_banner_pip_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>优酷&&土豆播放页banner 图片</b></td>
					</tr>
					<tr>
						<td>素材地址</td>
						<td><input type="text" name="vhtml_yt_banner_pip_url" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- vhtml_youku_banner_end -->
				
				<!-- vhtml_youku_banner_start -->
				<div id = "vhtml_yt_banner_flash" style="display:none">
				<table id="vhtml_yt_banner_flash_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>优酷&&土豆播放页banner_flash</b></td>
					</tr>
					<tr>
						<td>flash素材地址</td>
						<td><input type="text" name="vhtml_yt_banner_flash_url" size="100" ></td>
					</tr>
					<tr>
						<td>flash素材的图片地址</td>
						<td><input type="text" name="vhtml_yt_banner_flash_pip_url" size="100" ></td>
					</tr>
					<tr>
						<td>flash素材宽</td>
						<td><input type="text" name="vhtml_yt_banner_flash_width" size="100" ></td>
					</tr>
					<tr>
						<td>flash素材高</td>
						<td><input type="text" name="vhtml_yt_banner_flash_height" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- vhtml_youku_banner_end -->
				
				<!-- vhtml_promoted_video_start -->
				<div id = "vhtml_yt_promoted_video" style="display:none">
				<table id="vhtml_yt_promoted_video_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>播放页推荐广告(promoted video ads)</b></td>
					</tr>
					<tr>
						<td>推广视频播放地址</td>
						<td><input type="text" name="vhtml_yt_promoted_video_ads_url" size="100" ></td>
					</tr>
					<tr>
						<td>客户提供的曝光监测地址</td>
						<td><input type="text" name="vhtml_yt_promoted_client_show_url" size="100" ></td>
					</tr>
					<tr>
						<td>第三方曝光监测地址</td>
						<td><input type="text" name="vhtml_yt_promoted_other_show_url" size="100" ></td>
					</tr>
					<tr>
						<td>客户提供的点击监测地址</td>
						<td><input type="text" name="vhtml_yt_promoted_client_click_url" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- vhtml_promoted_video_end -->
				
				<!-- vhtml_m播放页_web_start -->
				<div id = "vhtml_m_playing_page_web" style="display:none">
				<table id="vhtml_m_playing_page_web_table" style="border: solid thin blue">
					<tr>
						<td colSpan="2"><b>m播放页(web)</b></td>
					</tr>
					<tr>
						<td>自定义内容</td>
						<td><textarea id="text" name="vhtml_yt_promoted_video_ads_url" rows="10" cols="100"></textarea></td>
					</tr>
					<tr>
						<td>点击地址</td>
						<td><input type="text" name="vhtml_m_playing_page_click_url" size="100" ></td>
					</tr>
				</table><br>
				</div>
				<!-- vhtml_m播放页_web_end -->
														
				</div>
				<!--
				<div id="usehd" style="display:">
				素材清晰度：<input type="radio" name="usehd" value="0" checked> 标清素材
				        <input type="radio" name="usehd" value="2"> 高清素材
				        <input type="radio" name="usehd" value="1"> 超清素材<br><br>				
				</div>
	            -->
	            <!-- 清晰度设置 start -->
	            <div id="resolution_setting" style="display:">                         
	                                          清晰度设置：<input type="checkbox" name="resolution_setting" onclick="toggle('resolution')" /><br><br>
	            </div>                           
				<div id="resolution" style="display:none">
				<table id="resolution_table" style="border: solid thin blue">
				<tr>
						<td colSpan="2" id="m2link" color="red">素材清晰度：(已选择的播放器设置下至少勾选一项素材清晰度)<br><br></td>
				</tr>
				<tr>
				<td>播放器设置：<input type="checkbox" name="resolution_hd2" id="resolution_hd2" value="1" onclick="check_resolution_hd2_broadcasting()" checked> 超清 &nbsp&nbsp
				素材设置：<input type="checkbox" name="resolution_hd2" id="resolution_hd2_broadcasting1" value="4" onclick="check_resolution_hd2()" checked> 超清
				      <input type="checkbox" name="resolution_hd2" id="resolution_hd2_broadcasting2" value="2" onclick="check_resolution_hd2()" checked> 高清
				      <input type="checkbox" name="resolution_hd2" id="resolution_hd2_broadcasting3" value="1" onclick="check_resolution_hd2()" checked> 标清 <br><br></td>	
				</tr>
				<tr>
				<td>播放器设置：<input type="checkbox" name="resolution_mp4" id="resolution_mp4" value="1" onclick="check_resolution_mp4_broadcasting()" checked> 高清 &nbsp&nbsp
				素材设置：<input type="checkbox" name="resolution_mp4" id="resolution_mp4_1_broadcasting1" value="4" onclick="check_resolution_mp4()" checked> 超清
				      <input type="checkbox" name="resolution_mp4" id="resolution_mp4_2_broadcasting2" value="2" onclick="check_resolution_mp4()" checked> 高清
				      <input type="checkbox" name="resolution_mp4" id="resolution_mp4_3_broadcasting3" value="1" onclick="check_resolution_mp4()" checked> 标清 <br><br></td>
				</tr>
				<tr>      
			    <td>播放器设置：<input type="checkbox" name="resolution_flv" id="resolution_flv" value="1" onclick="check_resolution_flv_broadcasting()" checked> 标清 &nbsp&nbsp
				素材设置：<input type="checkbox" name="resolution_flv" id="resolution_flv1_broadcasting1" value="4" onclick="check_resolution_flv()" checked> 超清
				      <input type="checkbox" name="resolution_flv" id="resolution_flv2_broadcasting2" value="2" onclick="check_resolution_flv()" checked> 高清
				      <input type="checkbox" name="resolution_flv" id="resolution_flv3_broadcasting3" value="1" onclick="check_resolution_flv()" checked> 标清 <br></td>
				</tr>				
				</table>
				<br>
				</div>
				<!-- 清晰度设置 end -->	
				 
				<input type="submit" value="保存" >
			</form>
		</td>
	</tr>
</table>
</body>
</html>