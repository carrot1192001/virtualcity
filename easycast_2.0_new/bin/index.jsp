<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.youku.atm.cacher.deliver.*,
com.youku.atm.cacher.val.*,
com.youku.atm.cacher.html.*,
com.youku.atm.cacher.direction.*,
com.youku.atm.cacher.protect.*,
com.youku.atm.cacher.vtime.*"

%>
<title>cacher加载</title>
<%
String task = request.getParameter("task");

if("lunbo".equals(task))
{
        new LunboLoader().run();
}
if("percent".equals(task))
{
        new PercentLoader().run();
}
if("priority".equals(task))
{
        new PriorityLoader().run();
}
if("val".equals(task))
{
        new ValAdLoader().run();
}
if("vhtml".equals(task))
{
        new VHtmlLoader().run();
}
if("direction".equals(task))
{
        new DirectionLoader().run();
}
if("protect".equals(task))
{
        new ProtectLoader().run();
}
if("vtime".equals(task))
{
        new VTimeLoader().run();
}
if("overflow".equals(task))
{
        new OverflowLoader().run();
}

%>

