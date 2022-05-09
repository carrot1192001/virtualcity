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

	//channel
	Channel channel = null;
	String channelId = null;
	String channleName = null;

	Channel second_Class = null;
	String secondChannelid = null;
	String secondChannelvalue = null;
	
	//area
	Area area = null;
	String areaId = null;
	String areaName = null;

	Area area_Class = null;
	String secondAreaid = null;
	String secondAreavalue = null;
	

	try {
		List<Channel> y_channelList = EasyCastUtil.getAllConfigChannels("ykn");
		for (int i = 0; i < y_channelList.size(); i++) {
			HashMap map = new HashMap();
			JSONObject jsonObject = new JSONObject();
			channel = y_channelList.get(i);
			channelId = "ykn_" + channel.getId();
			channleName = channel.getName();

			List<Channel> secondClass = EasyCastUtil.getAllConfigChannels(channel.getId());
			for (int ii = 0; ii < secondClass.size(); ii++) {
				second_Class = secondClass.get(ii);
				secondChannelid = "ykn_" + second_Class.getId();
				secondChannelvalue = second_Class.getName();
				jsonObject.put(secondChannelid, secondChannelvalue);
			}

			map.put(channleName, jsonObject.toString());
			jedis.hmset(channelId, map);
		}
		
		List<Channel> t_channelList = EasyCastUtil.getAllConfigChannels("tdn");
		for (int i = 0; i < t_channelList.size(); i++) {
			HashMap map = new HashMap();
			JSONObject jsonObject = new JSONObject();
			channel = t_channelList.get(i);
			channelId = "tdn_" + channel.getId();
			channleName = channel.getName();

			List<Channel> secondClass = EasyCastUtil.getAllConfigChannels(channel.getId());
			for (int ii = 0; ii < secondClass.size(); ii++) {
				second_Class = secondClass.get(ii);
				secondChannelid = "tdn_" + second_Class.getId();
				secondChannelvalue = second_Class.getName();
				jsonObject.put(secondChannelid, secondChannelvalue);
			}

			map.put(channleName, jsonObject.toString());
			jedis.hmset(channelId, map);
		}
		
		List<Channel> yzw_channelList = EasyCastUtil.getAllConfigChannels("zw");
		for (int i = 0; i < yzw_channelList.size(); i++) {
			HashMap map = new HashMap();
			JSONObject jsonObject = new JSONObject();
			channel = yzw_channelList.get(i);
			channelId = "ykzw_" + channel.getId();
			channleName = channel.getName();

			List<Channel> secondClass = EasyCastUtil.getAllConfigChannels(channel.getId());
			for (int ii = 0; ii < secondClass.size(); ii++) {
				second_Class = secondClass.get(ii);
				secondChannelid = "ykzw_" + second_Class.getId();
				secondChannelvalue = second_Class.getName();
				jsonObject.put(secondChannelid, secondChannelvalue);
			}

			map.put(channleName, jsonObject.toString());
			jedis.hmset(channelId, map);
		}
		
		List<Channel> tzw_channelList = EasyCastUtil.getAllConfigChannels("35");
		for (int i = 0; i < tzw_channelList.size(); i++) {
			HashMap map = new HashMap();
			JSONObject jsonObject = new JSONObject();
			channel = tzw_channelList.get(i);
			channelId = "tdzw_" + channel.getId();
			channleName = channel.getName();

			List<Channel> secondClass = EasyCastUtil.getAllConfigChannels(channel.getId());
			for (int ii = 0; ii < secondClass.size(); ii++) {
				second_Class = secondClass.get(ii);
				secondChannelid = "tdzw_" + second_Class.getId();
				secondChannelvalue = second_Class.getName();
				jsonObject.put(secondChannelid, secondChannelvalue);
			}

			map.put(channleName, jsonObject.toString());
			jedis.hmset(channelId, map);
		}
		
		List<Channel> sy_channelList = EasyCastUtil.getAllConfigChannels("SY");
		for (int i = 0; i < sy_channelList.size(); i++) {
			HashMap map = new HashMap();
			JSONObject jsonObject = new JSONObject();
			channel = sy_channelList.get(i);
			channelId = "shuyu_" + channel.getId();
			channleName = channel.getName();

			List<Channel> secondClass = EasyCastUtil.getAllConfigChannels(channel.getId());
			for (int ii = 0; ii < secondClass.size(); ii++) {
				second_Class = secondClass.get(ii);
				secondChannelid = "shuyu_" + second_Class.getId();
				secondChannelvalue = second_Class.getName();
				jsonObject.put(secondChannelid, secondChannelvalue);
			}

			map.put(channleName, jsonObject.toString());
			jedis.hmset(channelId, map);
		}
		
		//area
		//List<Channel> sy_channelList = EasyCastUtil.getAllConfigChannels("SY");
		List<Area> areaList = EasyCastUtil.getAllConfigAreas("province");
		for (int i = 0; i < areaList.size(); i++) {
			HashMap map = new HashMap();
			JSONObject jsonObject = new JSONObject();
			area = areaList.get(i);
			areaId = "province_" + area.getId();
			areaName = area.getName();

			List<Area> secondClass = EasyCastUtil.getAllConfigCitys(area.getId());
			for (int ii = 0; ii < secondClass.size(); ii++) {
				area_Class = secondClass.get(ii);
				secondAreaid = "province_" + area_Class.getId();
				secondAreavalue = area_Class.getName();
				jsonObject.put(secondAreaid, secondAreavalue);
			}

			map.put(areaName, jsonObject.toString());
			jedis.hmset(areaId, map);
		}
		
		List<Area> stateList = EasyCastUtil.getAllConfigAreas("state");
		for (int i = 0; i < stateList.size(); i++) {
			HashMap map = new HashMap();
			JSONObject jsonObject = new JSONObject();
			area = stateList.get(i);
			areaId = "state_" + area.getId();
			areaName = area.getName();

			List<Area> countrys = EasyCastUtil.getAllConfigCountrys(area.getId());
			for (int ii = 0; ii < countrys.size(); ii++) {
				area_Class = countrys.get(ii);
				secondAreaid = "state_" + area_Class.getId();
				secondAreavalue = area_Class.getName();
				jsonObject.put(secondAreaid, secondAreavalue);
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

	
	out.println("jedis input channel success !!!!<br/>");
			
%>