<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>消息提示</title>
  </head>
        <% String message = (String)request.getAttribute("message");%>
        <% out.println("<a href='upload.jsp'>返回</a>");%>
        <% out.println("<a href=" + message + ">链接</a>");%>
        <% out.println(message);%>
</html>