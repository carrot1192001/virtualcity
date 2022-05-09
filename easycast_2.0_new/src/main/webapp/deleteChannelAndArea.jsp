<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.torque.Torque"%>
<%@page import="com.youku.atm.easycast.DBConnection"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
    String root = getServletContext().getRealPath("/");
    Torque.init(root + "WEB-INF/classes/conf/Torque.properties");

	DBConnection.getInstance("atm").execSql("delete from channel;");
	
	DBConnection.getInstance("atm").execSql("delete from area;");
	
	out.println("delete channel success !!!!<br/>");
			
%>