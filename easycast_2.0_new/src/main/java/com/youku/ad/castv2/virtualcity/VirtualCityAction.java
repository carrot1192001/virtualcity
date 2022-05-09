package com.youku.ad.castv2.virtualcity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youku.ad.util.StringUtil;
import com.youku.ad.util.Util;
import com.youku.ad.util.CookieManager;

public class VirtualCityAction
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		PrintWriter out = response.getWriter();

		String prov = request.getParameter("prov");
		String city = request.getParameter("city");
		String sign = request.getParameter("sign");
		int time = parseInt(request.getParameter("time"));

		if(prov==null || !provSet.contains(prov) || city==null || city.length()==0)
		{
			out.println("1,省市不正确");
			return;
		}
		if(sign ==  null || sign.length() == 0) {
			out.println("2,验证码不正确");
			return;
		}
		sign = sign.toLowerCase();

		long now = System.currentTimeMillis();

		String ip = com.youku.ad.mobile.caster.MCastUtils.getRemoteIp(request);

		CookieManager cookieManager = new CookieManager(request, response);

		String vcookie = cookieManager.getCookie("vsign");

		if(vcookie == null) {
			out.println("2,验证码不正确");
			return;
		}

		String[] ck = vcookie.split("_");
		if(ck.length==2 && StringUtil.isPositiveInteger(ck[0])) {
			long expire = parseLong(ck[0]);
			if(expire < now) {
				out.println("3,验证码过时，请换一个");
				return;
			}
			if(!ck[1].equals(Util.md5(sign+"_"+ip+"_"+expire+"_"+ VirtualCookie.virtualCitySecretKey))) {
				out.println("4,验证码不正确");
				return;
			}
		}

		if(time <= 0 || time > 5*60) {
			out.println("5,时间不正确");
			return;
		}

		long expire = now + time * 60 * 1000;
		String vck = prov + "_" + city + "_" + expire;

		vck = vck + "_" + VirtualCookie.makeMD5(prov, city, expire);
		Cookie cookie=new Cookie("vcity", vck);
		cookie.setDomain(".atm.youku.com");
		cookie.setPath("/");
		cookie.setMaxAge(time * 60);
		response.addCookie(cookie);		

		out.println("0,设置完成");
	}

	static int parseInt(String str) {
		if(str == null || str.length() == 0)
			return 0;
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
		}
		return 0;
	}
	static long parseLong(String str) {
		if(str == null || str.length() == 0)
			return 0;
		try{
			return Long.parseLong(str);
		}catch(Exception e){
		}
		return 0;
	}

	static HashSet hashset(Object... param) {
		HashSet set = new HashSet();
		for(int i=0;i<param.length;i++)
			set.add(param[i]);
		return set;
	}


	static Set<String> provSet = hashset(
	"11","31","12","50","52","36","15","42","43","22",
	"35","37","45","44","51","34","62","71","81","32",
	"21","14","46","41","61","13","23","33","65","53",
	"63","64","82","54","99"
	);

}
