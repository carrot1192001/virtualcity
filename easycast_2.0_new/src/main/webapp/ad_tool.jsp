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
	String ip = InetAddress.getLocalHost().getHostAddress();
    String base = request.getContextPath(); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广告tool-<%=ip%></title>
<link rel="shortcut icon" href="alimamalogo.jpg" type="image/x-icon"/>
<link rel="stylesheet" href="<%=base%>/js/ajax/jquery/themes/jquery-ui-1.8.16.custom/css/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" media="all" />
<script src="<%=base%>/js/ajax/jquery.min.js"></script>
<script src="<%=base%>/js/ajax/md5.js"></script>
<script src="<%=base%>/js/ajax/jquery/jquery-1.6.2.min.js" type="text/javascript"></script>
<script src="<%=base%>/js/ajax/jquery/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
<script src="<%=base%>/js/ajax/jquery/ui/i18n/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>

<style>
.dstyle1 {
font-size:13px;
font-weight: bold;
color: #ff6600;
}
.dstyle2 {
font-size:13px;
font-weight: bold;
color: #ffffff;
}
/* WebKit browsers */
::-webkit-input-placeholder {
	color: #FF0000;
}
/* Mozilla Firefox 4 to 18 */
:-moz-placeholder {
	color: #FF0000;
	opacity: 1;
}
/* Mozilla Firefox 19+ */
::-moz-placeholder {
	color: #FF0000;
	opacity: 1;
}
/* Internet Explorer 10+ */
:-ms-input-placeholder {
	color: #FF0000;
}
</style>

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
	
var $jj = jQuery.noConflict();

$jj(function() {
    $jj("#startDateRow_new").datepicker({
        dateFormat: 'yy-mm-dd',
        changeMonth: true,
        changeYear: true,
        onSelect: function(dateText, inst) {
            $jj(this).parent().parent().find("[name=endDateRow_new]").datepicker("option" , "minDate" , dateText);
       }
    });
    
    $jj("#endDateRow_new").datepicker({
        dateFormat: 'yy-mm-dd',
        changeMonth: true,
        changeYear: true,
        showMonthAfterYear: true,
        onSelect: function(dateText, inst) {
            $jj(this).parent().parent().find("[name=startDateRow_new]").datepicker("option" , "maxDate" , dateText);
    }});
	});

setInterval("r()",500);
setInterval("r1()",500);

function r(){
 var f = document.getElementById("m2link");
 var temp =  ("green" == f.style.color) ? "blue" : "red";
 f.style.color =  ("red"==f.style.color) ? "green": temp;
}  

function r1(){
	 var f = document.getElementById("m2link_tair");
	 var temp =  ("green" == f.style.color) ? "blue" : "red";
	 f.style.color =  ("red"==f.style.color) ? "green": temp;
	}  

function calc_md5() {
	$("#md5_out").html( hex_md5($("#md5_in").val()));
}
function calc_base64_enc() {
	$("#md5_out").html( base64enc($("#md5_in").val()));
}
function calc_base64_dec() {
	$("#md5_out").html( base64dec($("#md5_in").val()));
}
function calc_vid() {
	// http://v.youku.com/v_show/id_XNTgxNjQ4MzA4.html
	var v, ev;
	var str = $("#md5_in").val();
	if(str.indexOf("X") >= 0) {
		str = str.substring(str.indexOf("X") + 1, str.length);
		if(str.indexOf(".") >= 0)
			str = str.substring(0, str.indexOf("."));
		ev = "X"+ str;
		v = parseInt(base64dec(str)) / 4;
		$("#md5_out").html(""+ v);
	}else{
		v = str;
		ev = "X" + base64enc("" + parseInt(str) * 4);
		$("#md5_out").html( ev);
	}
	$("#md5_out").append(" <a target=_blank href='http://v.youku.com/v_show/id_"+ev+".html'>html</a>");
	$("#md5_out").append(" <a target=_blank href='http://v.youku.com/player/getPlayList/VideoIDS/"+v+"'>json</a>");
	$("#md5_out").append(" <a target=_blank href='http://v.youku.com/player/getPlayList/VideoIDS/"+v+"/Pf/2'>3gphd-json</a>");
	$("#md5_out").append(" <a target=_blank href='http://10.103.12.71/video.show?q=videoid%3A"+ev+"&fc=&fd=title%20point&pn=1&pl=10&ob=createtime%3Adesc&ft=json&cl=test_page&h=1'>中插点</a>");
}

function video_dot_old() {
	// http://v.youku.com/v_show/id_XNTgxNjQ4MzA4.html
	var v, ev,showid;
	var str = $("#md5_in").val();
	
	v = str.replace(/id_/g, "#");
	ev = v.replace(/.html/g, "#");
    
	showid = ev.split("#");
	
	$("#md5_out").html(" <a target=_blank href='http://val.atm06.heyi.test/dot?custom=1&rid=1533957305601337&stoken=&vid="+showid[1]+"'>videodot</a>");
	
}

function video_dot_new() {
	// http://v.youku.com/v_show/id_XNTgxNjQ4MzA4.html
	var v, ev,showid;
	var str = $("#md5_in").val();
	
	v = str.replace(/id_/g, "#");
	ev = v.replace(/.html/g, "#");
    
	showid = ev.split("#");
	
	$("#md5_out").html(" <a target=_blank href='http://11.162.84.245/dot/video?custom=1&rid=1533957305601337&stoken=&avs=7.4.6.77475&aw=a&bd=apple&bt=phone&dprm=3000&dvh=2208&dvw=1242&guid=7066707c5bdc38af1621eaf94a6fe779&idfa=A1F93DBC-4359-4B27-88E1-DC4EF98E52F6&isp=%E4%B8%AD%E5%9B%BD%E8%81%94%E9%80%9A_46001&mdl=iPhone9%2C2&net=1000&os=ios&osv=11.4.1&ouid=63665a4c3285293f53f70bddd31873393ff22e50&pid=64b6847e992c4c45&site=1&sver=1.0.36&utdid=WEeEzBjhlT0DAB%2BfFyG13puN&v="+showid[1]+"'>videodot</a>");
	
}

function url2vid() {
}
function base64enc(s) {
	var r = [], i=0, j=0, n=s.length, z = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".split("");;
	for( ; i<n; i+=3) {
		var a = s.charCodeAt(i), b = i+1<n?s.charCodeAt(i+1):0, c = i+2<n?s.charCodeAt(i+2):0;
		r[j++] = z[a>>2];
		r[j++] = z[((a & 3)<<4)|(b>>4)];
		r[j++] = i+1<n?z[((b&15)<<2)|(c>>6)]:"=";
		r[j++] = i+2<n?z[c&63]:"=";
	}
	return r.join("");
}
function base64dec(s) {
	var r = [], i, j, n=s.length, z = {}, w = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".split("");
	for(i=0;i<64;i++) z[w[i]] = i;
	for(i=0,j=0;i<n;i+=4) {
		r[j++] = String.fromCharCode(z[s.charAt(i)] << 2 | ((z[s.charAt(i+1)]>>4) & 3));
		if(s.charAt(i+2) != "=")
			r[j++] = String.fromCharCode((z[s.charAt(i+1)] & 15) << 4 | ((z[s.charAt(i+2)]>>2) & 15));
		if(s.charAt(i+3) != "=")
			r[j++] = String.fromCharCode((z[s.charAt(i+2)] & 3) << 6 | (z[s.charAt(i+3)] & 63));
	}
	return r.join("");
}


</script>
</head>
<body onload="initform()">
<div id="main_page" style="display:">
<table>
	<tr>
		<td style="width:70px"></td>
		<td>
			<form action="actionTool" method="post" >
			service ip = <%=ip%><p>
		    <a id="m2link"> 调整投放优先级(数字越大优先级越大,默认值为1或者2,尽量不要超过99): </a><br>
            cast_id(是投放id，不是素材id):<input type="text" name="cast_id" placeholder="多个投放id用逗号分开(eg.676898,685767)" size="50"/><br>
            cast_priority:<input type="text" name="cast_priority" placeholder="数字越大优先级越大,默认值为1或者2,尽量不要超过99" size="50"/><br><br>
            
                                          更新素材url地址: <br>
            idea_id(素材id):<input type="text" name="idea_id_url" placeholder="只支持一个素材地址的更新" size="50"/><br>
                                          原始的素材url地址:<textarea id="original_idea_url" name="original_idea_url" placeholder="如果为贴片类型素材可不用填写原始素材地址，其它广告类型必须填写原始素材url地址" rows="10" cols="100"></textarea><br><br>
                                          更新后的素材url地址:<textarea id="update_idea_url" name="update_idea_url" rows="10" cols="100"></textarea><br><br>
                                          
                                          更新点击url地址: <br>
            idea_id(素材id):<input type="text" name="idea_id_url_click" placeholder="只支持一个素材url地址的更新" size="50"/><br>
                                         更新后的点击url地址(原始点击地址无需填写):<textarea id="update_idea_url_click" name="update_idea_url_click" rows="10" cols="100"></textarea><br><br>
<!--           
            <a> 屏蔽广告(可恢复):</a><br>
            <span style="color:red" >屏蔽广告(可恢复)-&gt;</span>
            idea_id(素材id): <input type="text" name="idea_id" placeholder="多个素材id用逗号分开(eg.576898,585767)" size="50" /><br><br>  
-->           
            <a id="m2link_oldadm"> 老adm屏蔽广告(慎用，不可恢复):</a><br>
            <span style="color:red" >老adm屏蔽广告(慎用，不可恢复)-&gt;</span>
            idea_id(素材id): <input type="text" name="idea_id_norevert" placeholder="多个素材id用逗号分开(eg.676898,685767)" size="50" /><br><br>  
            
            <a id="m2link_newadm"> 新adm屏蔽广告(慎用，不可恢复):</a><br>
            <span style="color:red" >新adm屏蔽广告(慎用，不可恢复)-&gt;</span>
            idea_id(素材id): <input type="text" name="idea_id_norevert_new" placeholder="多个素材id用逗号分开(eg.676898,685767)" size="50" /><br><br>  
            
                                         老adm 广告延期：<br>
                                          延期的素材id: <input type="text" name="delay_idea_id" placeholder="只支持单个素材id的延期(是素材id,不是投放id)" size="40" /><br>                          
                                          延期投放时间：<input type="text"   id ="startDateRow"  name="startDateRow"> - <input type="text"  id ="endDateRow"  name="endDateRow"><font color='red'>  *</font> <br><br>
            <!--<a target=_blank href="http://10.10.72.207:81/center/loader.jsp?load=All">前端机内存加载</a><br>-->
            
                                         新adm 广告延期：<br>
                                          延期的投放id: <input type="text" name="delay_cast_id_new" placeholder="支持多个投放id的延期(是投放id,不是素材id)-多个投放id必须用逗号分隔" size="80" /><br>                          
                                          延期投放时间：<input type="text"   id ="startDateRow_new"  name="startDateRow_new"> - <input type="text"  id ="endDateRow_new"  name="endDateRow_new"><font color='red'>  *</font> <br><br>
            

            
            <a id="m2link_urlencode"> urlencode:</a><br>
            <span style="color:red" >urlencode-&gt;</span>
            <input type="text" name="idea_url_encode" size="50" /><br><br> 
            <a id="m2link_urldecode"> urldecode:</a><br>
            <span style="color:red" >urldecode-&gt;</span>
            <input type="text" name="idea_url_decode" size="50" /><br><br> 
            <a id="m2link_tair"> tair相关设置(如果提示init error,则该tair有问题):</a><br>
            <select name="tair_opt" >
								<option id = "tair_opt" value="set" selected>set</option>
								<option id = "tair_opt" value="get" >get</option>
								<option id = "tair_opt" value="del" >del</option>
			</select>&nbsp
            tairName: <input type="text" name="tair_name" placeholder="tairname" size="30" /><br>
            key: <input type="text" name="tair_key" placeholder="tair_key" size="30" /><br>
            value: <input type="text" name="tair_value" placeholder="tair_value" size="30" /><br>
		<div>
			tool: <textarea id="md5_in" name="md5_in" placeholder="计算md5,base64编码,解码,vid转化(button),videodot信息(button)" rows="8" cols="90"></textarea>
		</div>
		
		<div>
			编码(utf8+base64): <textarea id="base64_utf8_encode" name="base64_utf8_encode" placeholder="base64_utf8_encode(submit)" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			解码(utf8+base64): <textarea id="base64_utf8_decode" name="base64_utf8_decode" placeholder="base64_utf8_decode(submit)" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			文件下载内容md5: <textarea id="file_content_md5" name="file_content_md5" placeholder="file_content_md5(submit)" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			素材url->vid: <textarea id="url_vid" name="url_vid" placeholder="url_vid(submit)" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			clickurloriginal-clickmess: <textarea id="clickurltomess" name="clickurltomess" placeholder="clickurltomess(submit)" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			clickmess-clickurloriginal: <textarea id="clickmesstooriginal" name="clickmesstooriginal" placeholder="clickmesstooriginal(submit)" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			图片素材pixel(width&height): <textarea id="adcdnurl" name="adcdnurl" placeholder="图片素材分辨率(格式http://或者https://开头的cdn素材地址)" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			yks接口视频详细信息: <textarea id="videoyksinfo" name="videoyksinfo" placeholder="视频url地址" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			getFlvUrl视频接口: <textarea id="videogetflvurl" name="videogetflvurl" placeholder="视频getFlvUrl接口" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			获取视频宽高: <textarea id="videoyksinfo_width_height" name="videoyksinfo_width_height" placeholder="视频url地址" rows="1" cols="90"></textarea>
		</div>

        <div>
			获取节目id(参数s-showid): <textarea id="videoyksinfo_programmeid" name="videoyksinfo_programmeid" placeholder="视频ur->节目id(视频url获取节目id)-submit" rows="1" cols="90"></textarea>
		</div>

		<div>
			<input type="button" value="计算素材url的MD5" onclick="calc_md5()">

			<input type="button" value="base64编码" onclick="calc_base64_enc()">
			<input type="button" value="解码" onclick="calc_base64_dec()">
			<input type="button" value="vid转换(vid->url/url->vid)" onclick="calc_vid()">
			<input type="button" value="videodot_old" onclick="video_dot_old()">
			<input type="button" value="videodot_new" onclick="video_dot_new()">
		</div>
		<div>
		<a href="http://fdapi.pre.youku.com/video.show?q=show_videotype :预告片state:normal&fc=&fd=title show_videotype show_id&pn=1&pl=100&ob=createtime:desc&ft=json&cl=test_page&h=1" target="_blank">vit_info</a>
		<a href="http://gitlab.alibaba-inc.com/heyi-adv-adtest/Documentation/wikis/flvdown-newmaterial" target="_blank">广告素材url集合</a>
		<a href="http://daily.tiddo.alibaba-inc.com/rdb-ant-ops/static/dist/index.html#/list-rdb/cluster" target="_blank">tair集群查询</a>
		<a href="http://orange-console-pre.youku.com/publishRecord.htm?namespaceId=d428de80294e422f8402d9c78590e8a5&version=2120180912184931427" target="_blank">orange配置</a>
		<a href="https://yuque.antfin-inc.com/yk_ad_engine/engine/kzuffl" target="_blank">yes&&mapi环境</a>
		<a href="http://daily.videodot.heyi.test/videodot.html" target="_blank">dot打点系统(日常)</a>
		<a href="http://videodot.youku.com/creative.html" target="_blank">dot打点系统(线上)</a>
		<a href="http://11.161.22.121:8880/update-dot-data" target="_blank">更新打点数据(y-center)</a>
		<a href="http://val.atm06.heyi.test/dot?custom=1&rid=1539856585855738&stoken=&vid=XMjU2NzAyNTY4OA%3D%3D&wt=1&_s_=6f9e4f5621b4071c23fc938f2d79141f&_t_=1539856585" target="_blank">老dot接口</a>    
		<a href="http://m-yes.heyi.test:80/dot/video?bd=vivo&os=Android&utdid=WvzoRU3oxDUDACJa8TE1eOE7&sver=4.1.41&isp=&custom=1&pid=9a89d83e08103905&mac=4C:C0:0A:B3:F4:1D&sid=e9960811886e110a93364119e7cb41cf&site=1&bt=phone&osv=8.1.0&mdl=vivo X21A&v=XMTM4NDYzNzU0OA==&aw=a&guid=12778397e885e9b69c910cb1ddf67ea0&net=1000&aid=ebf71ac9c6c13e4f&avs=7.5.0.80107" target="_blank">新dot接口</a>    
        </div>
        <div>
        <a href="http://11.161.22.121:8880/sync-ssp-data?table=ad_position" target="_blank">update-ad_position</a>
        <a href="https://yuque.antfin-inc.com/arya.lxw/xwqgbi/zil9vv" target="_blank">feed广告位汇总</a>        
        <a href="https://sa.alibaba-inc.com/device/account/user.jsx" target="_blank">push</a>        
        <a href="http://yogurt.youku.com/#" target="_blank">mtop_api</a>
        <a href="https://yuque.antfin-inc.com/aetq/uk1u2x" target="_blank">云雀sdk_team</a>   
        <a href="http://11.239.165.143:8280/mywiki/FrontPage" target="_blank">mywiki</a>
        <a href="http://usertrack.alibaba-inc.com/validate/qrcode" target="_blank">ut埋点(扫左边的二维码)</a>
        </div>
        <div>
        <a href="https://workitem.aone.alibaba-inc.com/project/595315/req?akProjectId=595315#groupBy=moduleIdPath&order_column=cf_101426&order=desc&pageSize=15&sprintIds=74908" target="_blank">广告sdk需求池</a>
        <a href="https://aone.alibaba-inc.com/project/596046/issue?spm=a2o8d.corp_prod_issue_detail.0.0.78065a0aMOYruG" target="_blank">广告sdk-iphone端bugs</a>
        <a href="https://aone.alibaba-inc.com/project/596049/issue?spm=a2o8d.corp_prod_issue_detail.0.0.396f203fRLIeCr" target="_blank">广告sdk-ipad端bugs</a>
        <a href="https://workitem.aone.alibaba-inc.com/project/691346/issue?akProjectId=691346&spm=a2o8d.corp_prod_issue_detail.0.0.4058714aiRvOmP" target="_blank">线上bugs-lists</a>
        <a href="http://pre-yks.youku.com/yks/get.json?cl=openapi&pt=video,stream,error&uip=127.0.0.1&uid=94210860&dv=pc&ext=%7bhasMp4%3a1%7d&ct=50&vid=XMzU5MjMxMDY4NA==" target="_blank">yks接口</a>
        <a href="https://yuque.antfin-inc.com/yk_ad_engine/engine/ey56s2" target="_blank">yks云雀接口文档</a>
        <a href="curl 'http://127.0.0.1/synerNotice?type=idea&id=859449'" target="_blank">syner同步idea接口</a>
        <a href="curl 'http://127.0.0.1/synerNotice?type=adcast&id=1567756'" target="_blank">syner同步ad_cast</a><br>
        <a href="https://vku.youku.com/live/ilproom?id=8003314" target="_blank">直播间地址</a>
        <a href="http://bme-tools.youku.com/#/ems/" target="_blank">ems解析</a>
        <a href="https://appdata.alibaba-inc.com/app/page.htm?spm=a1z7c.8115844-879.0.0.65b7625dmgplKx&pageId=118&clientCode=youku&lang=en-us&country=ALL" target="_blank">版本占比</a>
        <a href="https://yuque.antfin-inc.com/yk_ad_engine/adplat/doc_adm_api_atm_new#2.3-%E7%B4%A0%E6%9D%90%E6%8E%A5%E5%8F%A3" target="_blank">adm-atm-new接口</a>
        <a href="http://mtl3.alibaba-inc.com/project/project_build_config.htm?projectId=46557&buildConfigId=279296" target="_blank">iPhone端1029集成1113发布</a>
        <a href="https://workitem.aone.alibaba-inc.com/project/595315/req?akProjectId=595315&akProjectId=595315#groupBy=moduleIdPath&order_column=cf_101426&order=desc&pageSize=15&sprintIds=81347" target="_blank">1217phone需求</a>
        <a href="https://yuque.antfin-inc.com/aetq/business/tnc5wm" target="_blank">日常6测试广告投放情况</a>
        <div>
        orange配置<br>
        vpm埋点 看onePlay埋点。搜索isHls<br>
        isHls = 1说明播放的是hls。否则是mp4大分片<br>
        </div>
         
        <img src="/orange_qrcode.png"  alt="orange_qrcode" />
        <img src="/ut_qrcode.png"  alt="ut_qrcode" />
        <img src="/point.jpg"  alt="pressdown_point" />
        <div>
        note:
                           开发测试环境跳板机:（ ops_login_sqa_dev 分组）：用于登陆开发测试环境的主机
        </div>
        <div>
                            登陆方式： ssh 个人域账号@跳板机域名
        </div>
        <div>
                            登陆的跳板机域名  登陆验证方式  状态
        </div>
        <div>
        login1.et2sqa.tbsite.net  域密码  正常使用
        </div>
        <div>
        login2.et2sqa.tbsite.net  域密码  正常使用
        </div>
        <div>
        login1.zmfsqa.zmf.tbsite.net  域密码  正常使用
        </div>
        <div>
        login2.zmfsqa.zmf.tbsite.net  域密码  正常使用
        </div>
        <div>
        <p><font size="5" face="arial" color="red">iyes.youku.com/iyes-test.heyi.test</font></p>
        <p><font size="5" face="arial" color="red">http://m-yes.heyi.test/dot/video(164.81域名)   http://iyes-m.atm.heyi.test/dot/video(y-ssp域名)</font></p>
        <p><font size="5" face="arial" color="red">ups:140.205.173.181/ups-pre.youku.com</font></p>
        <p><font size="5" face="arial" color="red">ssp(vip_server):11.239.164.81/106.11.54.168</font></p>
        <p><font size="2" face="arial" color="red">kfc机器：11.239.171.57/11.239.165.143/11.239.163.213</font></p>
        <p><font size="2" face="arial" color="red">iphone7plus(IDFA):A1F93DBC-4359-4B27-88E1-DC4EF98E52F6</font></p>
        <p><font size="2" face="arial" color="red">iphoneX(IDFA):79F4D51-93C1-40CF-B6A1-AB313E96B9F1</font></p>
        
        </div>
        <div>
        (y-ssp:11.162.84.245->11.162.242.127)  (y-mapi:11.161.47.14) (y-center:11.161.22.121) (atm_adserver:11.163.164.4)
        </div>
        <div>
        打点类型。0:场景广告(包括原有的压屏条广告); 1:自定义浮层 2 创意中插、前情提要   3 剧场标版   5:创意后插<br>
        status:<br>
        1正常<br>
        3删除<br>
        SELECT * FROM video_dot WHERE video_id2 LIKE '%641756422%' and type = 2 and status = 1\G;<br>       
        </div>
		</div>
<br>
		<div>
			<span id="md5_out"></span>
		</div>
<br><br>
            
			<input type="submit" value="submit" >
			</form>
		</td>
	</tr>


</table>
</div>
</body>
</html>