<%@ page
	contentType="text/html; charset=utf-8"
	import="java.util.*"
	import="com.youku.ad.util.*"
	import="com.youku.ad.castv2.virtualcity.VirtualCityAction"
%><%!
	VirtualCityAction vcityaction = new VirtualCityAction();
%><%

	vcityaction.service(request, response);

%>