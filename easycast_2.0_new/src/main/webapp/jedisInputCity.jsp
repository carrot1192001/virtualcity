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
<%@page import="redis.clients.jedis.Jedis"%>
<%@page import="redis.clients.jedis.JedisPool"%>
<%@page import="redis.clients.jedis.JedisPoolConfig"%>
<%@page import="com.youku.atm.easycast.*"%>
<%@page import="com.youku.atm.om.*"%>
<%


	// redis初始化相关信息

	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	jedisPoolConfig.setMaxIdle(20);
	jedisPoolConfig.setMaxTotal(40);
	jedisPoolConfig.setMinIdle(10);
	JedisPool pool = new JedisPool(jedisPoolConfig, "localhost", 6379, 1000, null);
	Jedis jedis = null;
	jedis = pool.getResource();

	Area area = null;
	String areaId = null;
	String areaName = null;

	Area second_Class = null;
	String secondArealid = null;
	String secondAreavalue = null;

	try {
		List<Area> areaList = EasyCastUtil.getAllConfigAreas("province");
		for(int i = 0; i < areaList.size(); i++){
			HashMap map = new HashMap();
			JSONObject jsonObject = new JSONObject();
			area = areaList.get(i);
			areaId = area.getId();
			areaName = area.getName();

			List<Area> secondClass = EasyCastUtil.getAllConfigCitys(area.getId());
			for (int ii = 0; ii < secondClass.size(); ii++) {
				second_Class = secondClass.get(ii);
				secondArealid = second_Class.getId();
				secondAreavalue = second_Class.getName();
				jsonObject.put(secondArealid, secondAreavalue);
			}

			map.put(areaName, jsonObject.toString());
			jedis.hmset(areaId, map);
		}
		Set<String> keys = jedis.keys("*");

		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println("key is : " + str);
			System.out.println("####values_inner is " + jedis.hgetAll(str));
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		// 还回pool中
		if (jedis != null) {
			jedis.close();
		}
	}
	pool.close();

	
	out.println("jedis input city success !!!!<br/>");
			
%>