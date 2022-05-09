package com.youku.ad.mobile.caster;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.http.HttpServletRequest;

import com.youku.atm.busmodule.utils.LogUtil;
import com.youku.atm.om.*;
import org.apache.commons.logging.Log;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.youku.ad.util.Util;


public class MCastUtils {
	private static final Log logger = LogUtil.getLog();
	private static Random random = new Random();
	
	private static int marketNumlimitDefault = 2;
	private static final int VIRTUAL_CAMPAIN_ID_PARAM = 10000;
	
	private static Set<Integer> testIdeaSet = new HashSet<Integer>();
	
	static{
		testIdeaSet.add(187323);
		testIdeaSet.add(187200);
		testIdeaSet.add(186696);
		testIdeaSet.add(187504);
		testIdeaSet.add(185699);
		testIdeaSet.add(186132); 
	}
	/**
	 * 获得客户Ip
	 * @param request
	 * @n     -1 最后一个 -2 倒数第二个
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static String getRemoteIp(HttpServletRequest request) {
		return getRemoteIp(request, -1);
	}
	@SuppressWarnings({ "unchecked", "unused" })
	public static String getRemoteIp(HttpServletRequest request, int n) {
		String ip = "", ip2 = "";
		Enumeration ips = request.getHeaders("X-Forwarded-For");
			//遍历取到最后一个X-Forwarded-For
		while(ips.hasMoreElements() ){
			ip2 = ip;
			ip = (String) ips.nextElement();
		}
		if((ip2 == null || ip2.length() == 0) && ip != null && ip.length() > 0) {
			ip2 = ip;
		}
		if(n == -1) {
			ip2 = ip;
		}
		//判断其它类型
		if(ip2==null||ip2.equals("")|| ip2.equals("unknown") ){
			ip2 = request.getRemoteAddr();
		}

		return ip2;
	}



}
