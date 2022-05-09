<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>

<jsp:useBean id="user" class="com.youku.atm.easycast.UserBean" scope="request"/>
<jsp:setProperty name="user" property="*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<% 
	session.setAttribute("user",user);
	String username=user.getUsername();
 %>
 
 <%=username %>,欢迎您来到FUCK网!<br>
 您的IP是:<%=request.getRemoteAddr() %><br>
你的主机是:<%=request.getRemoteHost() %><br>
你使用的协议是:<%=request.getProtocol() %><br>
你目前的地址是:<%=request.getRealPath("/") %>
你的主机端口是:<%=request.getRemotePort() %>
</body>
</html>