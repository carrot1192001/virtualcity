<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@page import="java.util.*"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.io.IOException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.torque.TorqueException"%>
<%@page import="org.apache.torque.util.Criteria"%>
<%@page import="org.apache.torque.Torque"%>
<%@page import="com.youku.atm.om.*"%>

<%@page import="java.io.BufferedReader"%>
<%@page import="org.apache.torque.TorqueException"%>
<%@page import="org.apache.commons.logging.Log"%>
<body>
<%!
String insertCast(){
	String	root = getServletContext().getRealPath("/");
	try{
		Torque.init(root + "WEB-INF/classes/conf/Torque.properties");	
		AdCast cast = new AdCast();
		cast.setId(2021);
		cast.setOrderId(1);
		
		cast.setCustomerId(1);
		cast.setProductId(1);
		cast.setName("test");
		cast.setAdTypeId(162);
		cast.setDirectWay("a*c");
		cast.setCastWay("cpm*camp");
		cast.setInteractEffect(1);
		cast.setIsCopyright(1);
		cast.setPrice(2.0);
		cast.setSpeedType(1);
		cast.setTypePriority(1);
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
		cast.setRoPriority(1);
		cast.setSowType(1);
		cast.setRateM(1);
		cast.setRates(1);
		cast.setThreshold(1.0);
		cast.setRtbType(1);
		Date date = new Date();
		cast.setUpdateTime(date);
	    cast.setStartDate(date);    
	    cast.setEndDate(date);
	    cast.setRtbid(1);
	    cast.setIdeaShowType(1);
	    cast.setMainCastId(1);
	    cast.setStatus(1);
	    cast.save();
	}catch(Exception e){
		System.out.println(e);
	}
	          
return root;
}

%>

<%
String cast_id = insertCast();
out.println("Í¶·Åid=" + cast_id);

%>