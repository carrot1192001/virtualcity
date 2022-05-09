package com.youku.atm.easycast;

import org.apache.jcs.utils.timing.SleepUtil;
import java.util.*;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Matcher;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.torque.util.Criteria;
import com.youku.atm.easycast.*;
import com.youku.atm.easycast.Base64.Decoder;
import com.youku.atm.easycast.Base64.Encoder;
import com.youku.atm.om.*;
import java.io.BufferedReader;
import java.security.MessageDigest;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;
import org.apache.torque.Torque;

import java.io.BufferedReader;
import java.security.MessageDigest;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.alibaba.fastjson.JSONObject;
import com.youku.atm.busmodule.utils.LogUtil;

import org.apache.commons.logging.Log;
import java.text.ParseException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
//import com.youku.atm.easycast.TairOpt;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//import java.util.Base64.Decoder;
//import java.util.Base64.Encoder;

public class ActionTool3 extends AbstractAdServlet {
	private static final long serialVersionUID = 7381169134016556647L;
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final Log logger = LogUtil.getLog();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 流程-1 参数
		String workflowName1 = request.getParameter("workflow1");

	    String result = "";
		try {
			pauseWorkflow(workflowName1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<a href='ark_tool.jsp'>返回</a>" + "#########" + result + "########ok");
	}

	void jedisInput() {
	}

	void jedisInputChannel() {
	}

	void pauseWorkflow(String workflowName1) {

		try {
			// Torque.init("F:\\gary_geek\\w_geek_test_socket\\src\\main\\resources\\Torque.properties");
			String root = getServletContext().getRealPath("/");
			Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
		} catch (TorqueException e1) {
			// TODO Auto-generated catch block
		}

		Boolean a1 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName1 + "'");
		System.out.println("a1 is #################### : " + a1);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// System.out.println("ok");
		// new ActionTool().jedisInput();

		try {
			Torque.init("F:\\gary_geek\\easycast_2.0_new\\src\\main\\resources\\conf\\Torque2.properties");

		} catch (TorqueException e1) {
			// TODO Auto-generated catch block
		}

		String workflowName1 = "rms_multi-robot_testing";

		Boolean a1 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName1 + "'");

		System.out.println("a1 is #################### : " + a1);
	}

}
