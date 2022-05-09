<%@page import="com.geekplus.ark.om.TWorkstation"%>
<%@page import="com.geekplus.ark.om.TWorkstationPeer"%>
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
    List ips = EasyCastUtil.getLocalIP();
    //List<TWorkstation> cellcodes = TWorkstationPeer.doSelect(new Criteria());
    List<TWorkstation> cellcodes = EasyCastUtil.getCellcodes("%工作站%");
    List<TWorkstation> shelfcodes = EasyCastUtil.getCellcodes("%货架点%");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>easycast_ark_workflow<%=ips%></title>
<link rel="shortcut icon" href="geekplus1.jpg" type="image/x-icon"/>
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

function show_os_pc_div(obj){
	if(!obj.checked){
		$("show_pc_div").style.display = "";
	} else {
		$("show_pc_div").style.display = "none";
	}
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

function launchWorkflow(){
	frm.action = "actionTool2"
	}
function pauseWorkflow() {
	frm.action = "actionTool3"
	}

</script>
</head>
<body onload="initform()">
<div id="main_page" style="display:">
<table>
	<tr>
		<td style="width:70px"></td>
		<td>
			<form action="" method="post" name="frm">
			service ip = <%=ips%><p>
		    <a id="m2link"> ark流程优先级-数字越小优先级越大: </a><br>
            
    <!-- 单选框 -->
	流程编辑：<br>
	<div>流程种类:
		<label><input type="radio" name="sex" value="单节点流程">单节点流程</label>
		<label><input type="radio" name="sex" value="多节点流程">多节点流程</label>
		<label><input type="radio" name="sex" value="1">手动触发</label>
		<label><input type="radio" name="sex" value="2">自动触发</label>
	</div>
	<div>触发流程种类:
		<label><input type="radio" name="sex" value="1">手动触发</label>
		<label><input type="radio" name="sex" value="2">自动触发</label>
	</div>
	<!-- 复选框 -->
	<!--
	<div>
		工作站：
		<label><input type="checkbox" name="like" value="0">w1</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w2</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w3</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w4</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w5</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w6</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w8</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w9</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w10</label>&nbsp
		<label><input type="checkbox" name="like" value="1">w11</label>&nbsp
	</div><br>   
	-->
		<!-- cellcode_all_start -->
				
				<div id="pc_os_div" style="display:">
				工作站平台：<input type="checkbox" id="pc_all_os" name="pc_all_os" onclick="show_os_pc_div(this)" value="1" > workstation <br><br>
				
                <div id="show_pc_div" style="display:">
                <table style="border: solid thin green">
						<%
							for (int i = 0; i < cellcodes.size() ; i++) {
								TWorkstation os = cellcodes.get(i);

								if(i % 5 == 0){
									out.println("<tr>");
								}
						%>
						<%
						        if(os.getStatus() == 1){
						%>
						     <%      
						             if(os.getStatus() == 1){
						     %>
						            <td>
									<input type="checkbox" name="chk_os_pc" title="工作站名称&&工作站cellcode" value="<%=os.getWorkstationName() + ":" + os.getStopPointIds()%>"><%=os.getWorkstationName() + ":" + os.getStopPointIds() %>
								    </td>
						     <%         	 
						             }else{
						     %> 
						            <td>
									<input type="checkbox" name="chk_os_pc" title="不限_PC_不限_WEB(pc_web)" checked value="<%=os.getWorkstationName() + ":" + os.getStopPointIds()%>"><%=os.getStopPointIds() %>
								    </td>      	 
						     <%         
						             }
						     %>
						    
						        
						<%		      	
						        }
						%>
								
						<%
								if(i % 5 == 4){
									out.println("</tr>");
								}
							}
						%>
						<tr></tr><tr></tr>
	                
					</table>
					<br>
				</div>
				</div>
				<!-- cellcode_all_end -->  <br><br>
				<!-- shelfcode_all_start -->
				
				<div id="pc_os_div" style="display:">
				货架区域：<input type="checkbox" id="pc_all_os" name="pc_all_os" onclick="show_os_pc_div(this)" value="1" > shelfcodes <br><br>
				
                <div id="show_pc_div" style="display:">
                <table style="border: solid thin green">
						<%
							for (int i = 0; i < shelfcodes.size() ; i++) {
								TWorkstation os = shelfcodes.get(i);

								if(i % 5 == 0){
									out.println("<tr>");
								}
						%>
						<%
						        if(os.getStatus() == 1){
						%>
						     <%      
						             if(os.getStatus() == 1){
						     %>
						            <td>
									<input type="checkbox" name="chk_os_pc" title="工作站名称&&工作站cellcode" value="<%=os.getWorkstationName() + ":" + os.getStopPointIds()%>"><%=os.getWorkstationName() + ":" + os.getStopPointIds() %>
								    </td>
						     <%         	 
						             }else{
						     %> 
						            <td>
									<input type="checkbox" name="chk_os_pc" title="不限_PC_不限_WEB(pc_web)" checked value="<%=os.getWorkstationName() + ":" + os.getStopPointIds()%>"><%=os.getStopPointIds() %>
								    </td>      	 
						     <%         
						             }
						     %>
						    
						        
						<%		      	
						        }
						%>
								
						<%
								if(i % 5 == 4){
									out.println("</tr>");
								}
							}
						%>
						<tr></tr><tr></tr>
	                
					</table>
					<br>
				</div>
				</div>
				<!-- shelfcode_all_end -->        
		
		 南京工厂联调:<br>	
         <a id="m2link_workflow1"> 机器人线路-1:</a><br>
         <span style="color:red" >工作流程-1名称-&gt;</span>
         <input type="text" name="workflow1" size="20" /> &nbsp&nbsp&nbsp
         <span style="color:red" >货架名称1-&gt;</span>
         <input type="text" name="cellcode1" size="20" /> &nbsp&nbsp&nbsp        
         <span style="color:red" >执行次数-&gt;</span>
         <input type="text" name="time1" size="10" />&nbsp&nbsp&nbsp         
         <input type="submit" value="停止" onclick="pauseWorkflow()"><br><br>
         
         <a id="m2link_workflow2"> 机器人线路-2:</a><br>
         <span style="color:red" >工作流程-2名称-&gt;</span>
         <input type="text" name="workflow2" size="20" /> &nbsp&nbsp&nbsp    
         <span style="color:red" >货架名称2-&gt;</span>
         <input type="text" name="cellcode2" size="20" /> &nbsp&nbsp&nbsp     
         <span style="color:red" >执行次数-&gt;</span>
         <input type="text" name="time2" size="10" />&nbsp&nbsp&nbsp         
         <input type="submit" value="停止" ><br><br>
         
         <a id="m2link_workflow1"> 机器人线路-3:</a><br>
         <span style="color:red" >工作流程-3名称-&gt;</span>
         <input type="text" name="workflow3" size="20" /> &nbsp&nbsp&nbsp
         <span style="color:red" >货架名称3-&gt;</span>
         <input type="text" name="cellcode3" size="20" /> &nbsp&nbsp&nbsp           
         <span style="color:red" >执行次数-&gt;</span>
         <input type="text" name="time3"  size="10" />&nbsp&nbsp&nbsp         
         <input type="submit" value="停止" ><br><br>
         
         <a id="m2link_workflow4"> 机器人线路-4:</a><br>
         <span style="color:red" >工作流程-4名称-&gt;</span>
         <input type="text" name="workflow4" size="20" /> &nbsp&nbsp&nbsp 
         <span style="color:red" >货架名称4-&gt;</span>
         <input type="text" name="cellcode4" size="20" /> &nbsp&nbsp&nbsp          
         <span style="color:red" >执行次数-&gt;</span>
         <input type="text" name="time4" size="10" />&nbsp&nbsp&nbsp         
         <input type="submit" value="停止" ><br><br>
         
         <a id="m2link_workflow5"> 机器人线路-5:</a><br>
         <span style="color:red" >工作流程-5名称-&gt;</span>
         <input type="text" name="workflow5" size="20" /> &nbsp&nbsp&nbsp  
         <span style="color:red" >货架名称5-&gt;</span>
         <input type="text" name="cellcode5" size="20" /> &nbsp&nbsp&nbsp         
         <span style="color:red" >执行次数-&gt;</span>
         <input type="text" name="time5" size="10" />&nbsp&nbsp&nbsp         
         <input type="submit" value="停止" ><br><br>
         
         <a id="m2link_workflow6"> 机器人线路-6:</a><br>
         <span style="color:red" >工作流程-6名称-&gt;</span>
         <input type="text" name="workflow6" size="20" /> &nbsp&nbsp&nbsp  
         <span style="color:red" >货架名称6-&gt;</span>
         <input type="text" name="cellcode6" size="20" /> &nbsp&nbsp&nbsp         
         <span style="color:red" >执行次数-&gt;</span>
         <input type="text" name="time6" size="10" />&nbsp&nbsp&nbsp         
         <input type="submit" value="停止" ><br><br>
         
         <a id="m2link_workflow7"> 机器人线路-7:</a><br>
         <span style="color:red" >工作流程-7名称-&gt;</span>
         <input type="text" name="workflow7" size="20" /> &nbsp&nbsp&nbsp  
         <span style="color:red" >货架名称7-&gt;</span>
         <input type="text" name="cellcode7" size="20" /> &nbsp&nbsp&nbsp         
         <span style="color:red" >执行次数-&gt;</span>
         <input type="text" name="time7" size="10" />&nbsp&nbsp&nbsp         
         <input type="submit" value="停止" ><br><br>
         <input type="submit" value="发起ark工作流程" onclick="launchWorkflow()"><br><br>
         	
	
	Geek+搬运项目常用地址:<br>
        <div>
        <a href="http://172.16.41.248/static/venus/#/dInfo" target="_blank">venus</a><br>
        <a href="http://172.16.41.248/static/html/admin/" target="_blank">rhino</a><br>        
        <a href="http://172.16.41.248/static/rms/#/monitor/robotControl" target="_blank">rms</a><br>        
        <a href="http://172.16.41.248/static/ark/#/flowNodeConfig" target="_blank">ark</a>
        </div><br>
        
        Geek+搬运项目服务器urls:<br>
        <div>
        <p><font size="3" face="arial" color="red"></font></p>
        <p><font size="3" face="arial" color="red">http://172.16.41.248/static/venus/#/dInfo</font></p>
        <p><font size="3" face="arial" color="red">http://172.16.41.248/static/html/admin/</font></p>
        <p><font size="3" face="arial" color="red">http://172.16.41.248/static/rms/#/monitor/robotControl</font></p>
        <p><font size="3" face="arial" color="red">http://172.16.41.248/static/ark/#/flowNodeConfig</font></p>      
        </div><br>
        
        Geek+搬运项目其它常用地址:<br>
        <div>
        <p><font size="3" face="arial" color="red"></font></p>
        <p><font size="3" face="arial" color="red">swagger地址：http://172.16.3.48:8089/ark-web/swagger-ui.html</font></p>
        <p><font size="3" face="arial" color="red">confluence地址：https://confluence.geekplus.cc/pages/viewpage.action?pageId=66420872</font></p>
        <p><font size="3" face="arial" color="red">jira地址：https://jira.geekplus.cc/browse/SLAM-1392</font></p>     
        </div>
	
            <a id="m2link_urlencode"> urlencode:</a><br>
            <span style="color:red" >urlencode-&gt;</span>
            <input type="text" name="idea_url_encode" size="50" /><br><br> 
            <a id="m2link_urldecode"> urldecode:</a><br>
            <span style="color:red" >urldecode-&gt;</span>
            <input type="text" name="idea_url_decode" size="50" /><br><br> 
		<div>
			tool: <textarea id="md5_in" name="md5_in" placeholder="计算md5,base64编码,解码" rows="8" cols="90"></textarea>
		</div>
		
		<div>
			编码(utf8+base64): <textarea id="base64_utf8_encode" name="base64_utf8_encode" placeholder="base64_utf8_encode(submit)" rows="1" cols="90"></textarea>
		</div>
		
		<div>
			解码(utf8+base64): <textarea id="base64_utf8_decode" name="base64_utf8_decode" placeholder="base64_utf8_decode(submit)" rows="1" cols="90"></textarea>
		</div>

		<div>
			<input type="button" value="base64编码" onclick="calc_base64_enc()">
			<input type="button" value="解码" onclick="calc_base64_dec()">
		</div><br><br>       
<br>
		<div>
			<span id="md5_out"></span>
		</div>
<br>
            
			<input type="submit" value="submit" >
			</form>
		</td>
	</tr>


</table>
</div>
</body>
</html>