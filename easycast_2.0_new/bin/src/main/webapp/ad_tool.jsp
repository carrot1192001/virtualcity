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
<title>联调tool -<%=ip%></title>
<link rel="stylesheet" href="<%=base%>/js/ajax/jquery/themes/jquery-ui-1.8.16.custom/css/ui-lightness/jquery-ui-1.8.16.custom.css" type="text/css" media="all" />
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

setInterval("r()",500);

function r(){
 var f = document.getElementById("m2link");
 var temp =  ("green" == f.style.color) ? "blue" : "red";
 f.style.color =  ("red"==f.style.color) ? "green": temp;
}  


</script>
</head>
<body onload="initform()">
<div id="main_page" style="display:">
<table>
	<tr>
		<td style="width:70px"></td>
		<td>
			<form action="action_tool.jsp" method="post" >
			service ip = <%=ip%><p>
		              调整投放优先级: <br>
            cast_id(投放id):<input type="text" name="cast_id" /><br>
            cast_priority:<input type="text" name="cast_priority" /><br><br>
            <a id="m2link"> 屏蔽广告(慎用):</a><br>
            <span style="color:red" >屏蔽广告(慎用)-&gt;</span>
            idea_id(素材id): <input type="text" name="idea_id" /><br><br>  
                                          广告延期：<br>
                                          延期的素材id: <input type="text" name="delay_idea_id" /><br><br>                              
                                          投放时间：<input type="text"   id ="startDateRow"  name="startDateRow"> - <input type="text"  id ="endDateRow"  name="endDateRow"><font color='red'>  *</font> <br><br>           
			<input type="submit" value="submit" >
			</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>