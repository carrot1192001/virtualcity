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
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.torque.util.Criteria;
import com.youku.atm.easycast.*;
import com.youku.atm.easycast.Base64.Decoder;
import com.youku.atm.easycast.Base64.Encoder;
import com.youku.atm.om.*;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
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

public class ActionTool2 extends AbstractAdServlet {
	private static final long serialVersionUID = 7381169134016556647L;
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final Log logger = LogUtil.getLog();
	// private static Jedis jedis;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String root = getServletContext().getRealPath("/");
		try {
			Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
		} catch (TorqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int times1 = 0;
		int times2 = 0;
		int times3 = 0;
		int times4 = 0;
		int times5 = 0;
		int times6 = 0;
		int times7 = 0;

		String IP = request.getRemoteAddr();

		// workflow-1 参数
		String workflowName1 = request.getParameter("workflow1");
		String stringInt1 = request.getParameter("time1");
		if (stringInt1 != null && !"".equals(stringInt1)) {
			times1 = Integer.parseInt(stringInt1);
		}
		String cellcode1 = request.getParameter("cellcode1");

		// workflow-2 参数
		String workflowName2 = request.getParameter("workflow2");
		String stringInt2 = request.getParameter("time2");
		if (stringInt2 != null && !"".equals(stringInt2)) {
			times2 = Integer.parseInt(stringInt2);
		}
		String cellcode2 = request.getParameter("cellcode2");

		// workflow-3 参数
		String workflowName3 = request.getParameter("workflow3");
		String stringInt3 = request.getParameter("time3");
		if (stringInt3 != null && !"".equals(stringInt3)) {
			times3 = Integer.parseInt(stringInt3);
		}
		String cellcode3 = request.getParameter("cellcode3");

		// workflow-4 参数
		String workflowName4 = request.getParameter("workflow4");
		String stringInt4 = request.getParameter("time4");
		if (stringInt4 != null && !"".equals(stringInt4)) {
			times4 = Integer.parseInt(stringInt4);
		}
		String cellcode4 = request.getParameter("cellcode4");

		// workflow-5 参数
		String workflowName5 = request.getParameter("workflow5");
		String stringInt5 = request.getParameter("time5");
		if (stringInt5 != null && !"".equals(stringInt5)) {
			times5 = Integer.parseInt(stringInt5);
		}
		String cellcode5 = request.getParameter("cellcode5");

		// workflow-6 参数
		String workflowName6 = request.getParameter("workflow6");
		String stringInt6 = request.getParameter("time6");
		if (stringInt6 != null && !"".equals(stringInt6)) {
			times6 = Integer.parseInt(stringInt6);
		}
		String cellcode6 = request.getParameter("cellcode6");

		// workflow-7 参数
		String workflowName7 = request.getParameter("workflow7");
		String stringInt7 = request.getParameter("time7");
		if (stringInt7 != null && !"".equals(stringInt7)) {
			times7 = Integer.parseInt(stringInt7);
		}
		String cellcode7 = request.getParameter("cellcode7");

		String result = "";

		try {
			result = launchWorkflow(workflowName1, times1, cellcode1, workflowName2, times2, cellcode2, workflowName3,
					times3, cellcode3, workflowName4, times4, cellcode4, workflowName5, times5, cellcode5,
					workflowName6, times6, cellcode6, workflowName7, times7, cellcode7, IP);

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

	void resinRestart() {
	}

	public String fileRead(String fileName) throws Exception {
		File file = new File(fileName);
		FileReader reader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(reader);
		StringBuilder sb = new StringBuilder();
		String s = "";
		while ((s = bReader.readLine()) != null) {
			sb.append(s + "\n");
			System.out.println(s);
		}
		bReader.close();
		String str = sb.toString();
		System.out.println(str);
		return str;
	}

	public void detailTableContent(String workflowName, String shelfcode, int time, String caseDescription, String ip)
			throws Exception {
		// 读取模板
		// String root = getServletContext().getRealPath("/");
		// String root = getServletContext().getRealPath("/");
		// Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
		String root = getServletContext().getRealPath("/");

		// 第一种：获取类加载的根路径 D:\git\daotie\daotie\target\classes
		File f = new File(this.getClass().getResource("/").getPath());
		System.out.println("f is :##########" + f);

		// 获取当前类的所在工程路径; 如果不加“/” 获取当前类的加载目录 D:\git\daotie\daotie\target\classes\my
		File f2 = new File(this.getClass().getResource("").getPath());
		System.out.println("f2 is :#########" + f2);

		String ReportContent = fileRead(root + "castInfo.template");
		File reportFile = new File(root + "castInfo.jsp");
		// 替换关键信息
		ReportContent = ReportContent.replace("$workflowName", workflowName);
		ReportContent = ReportContent.replace("$shelfcodeName", shelfcode);
		ReportContent = ReportContent.replace("$remote_ip", ip);
		ReportContent = ReportContent.replace("$time", time + "");
		ReportContent = ReportContent.replace("$date", new Date().toString());
		ReportContent = ReportContent.replace("$Description", caseDescription);

		// 重新写单个用例报告
		FileOutputStream fw = new FileOutputStream(reportFile, true);
		PrintWriter bw = new PrintWriter(fw);
		bw.write(ReportContent);

		bw.close();
		fw.close();

	}

	String launchWorkflow(String workflowName1, int times1, String cellcode1, String workflowName2, int times2,
			String cellcode2, String workflowName3, int times3, String cellcode3, String workflowName4, int times4,
			String cellcode4, String workflowName5, int times5, String cellcode5, String workflowName6, int times6,
			String cellcode6, String workflowName7, int times7, String cellcode7, String ip) {

		int number1 = 0, number2 = 0, number3 = 0, number4 = 0, number5 = 0, number6 = 0, number7 = 0;

		try {
			// Torque.init("F:\\gary_geek\\w_geek_test_socket\\src\\main\\resources\\Torque.properties");

			// 第一种：获取类加载的根路径 D:\git\daotie\daotie\target\classes
			File f = new File(this.getClass().getResource("/").getPath());
			System.out.println("f is :##########" + f);

			// 获取当前类的所在工程路径; 如果不加“/” 获取当前类的加载目录 D:\git\daotie\daotie\target\classes\my
			File f2 = new File(this.getClass().getResource("").getPath());
			System.out.println("f2 is :#########" + f2);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}

		Boolean a1 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName1 + "'");
		System.out.println("a1 is #################### : " + a1);

		Boolean a2 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName2 + "'");
		System.out.println("a2 is #################### : " + a2);

		Boolean a3 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName3 + "'");
		System.out.println("a3 is #################### : " + a3);

		Boolean a4 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName4 + "'");
		System.out.println("a4 is #################### : " + a4);

		Boolean a5 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName5 + "'");
		System.out.println("a5 is #################### : " + a5);

		Boolean a6 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName6 + "'");
		System.out.println("a6 is #################### : " + a6);

		Boolean a7 = DBConnection.getInstance("ark")
				.execSql("delete from t_workflow where workflow_config_name = '" + workflowName7 + "'");
		System.out.println("a7 is #################### : " + a7);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// add error handle workflowname不正确情况下
		// 流程1
		ArrayList ark1 = DBConnection.getInstance("ark").execQuerySql6(
				"SELECT count(*) from t_workflow_config where status = 1 and workflow_name = '" + workflowName1 + "'");
		String totalNo1 = (ark1.get(0).toString()).substring(1, ark1.get(0).toString().length() - 1);

		// 流程2
		ArrayList ark2 = DBConnection.getInstance("ark").execQuerySql6(
				"SELECT count(*) from t_workflow_config where status = 1 and workflow_name = '" + workflowName2 + "'");
		String totalNo2 = (ark2.get(0).toString()).substring(1, ark2.get(0).toString().length() - 1);

		// 流程3
		ArrayList ark3 = DBConnection.getInstance("ark").execQuerySql6(
				"SELECT count(*) from t_workflow_config where status = 1 and workflow_name = '" + workflowName3 + "'");
		String totalNo3 = (ark3.get(0).toString()).substring(1, ark3.get(0).toString().length() - 1);

		// 流程4
		ArrayList ark4 = DBConnection.getInstance("ark").execQuerySql6(
				"SELECT count(*) from t_workflow_config where status = 1 and workflow_name = '" + workflowName4 + "'");
		String totalNo4 = (ark4.get(0).toString()).substring(1, ark4.get(0).toString().length() - 1);

		// 流程5
		ArrayList ark5 = DBConnection.getInstance("ark").execQuerySql6(
				"SELECT count(*) from t_workflow_config where status = 1 and workflow_name = '" + workflowName5 + "'");
		String totalNo5 = (ark5.get(0).toString()).substring(1, ark5.get(0).toString().length() - 1);

		// 流程6
		ArrayList ark6 = DBConnection.getInstance("ark").execQuerySql6(
				"SELECT count(*) from t_workflow_config where status = 1 and workflow_name = '" + workflowName6 + "'");
		String totalNo6 = (ark6.get(0).toString()).substring(1, ark6.get(0).toString().length() - 1);

		// 流程7
		ArrayList ark7 = DBConnection.getInstance("ark").execQuerySql6(
				"SELECT count(*) from t_workflow_config where status = 1 and workflow_name = '" + workflowName7 + "'");
		String totalNo7 = (ark7.get(0).toString()).substring(1, ark7.get(0).toString().length() - 1);

		int workflowTotal1 = Integer.parseInt(totalNo1);
		int workflowTotal2 = Integer.parseInt(totalNo2);
		int workflowTotal3 = Integer.parseInt(totalNo3);
		int workflowTotal4 = Integer.parseInt(totalNo4);
		int workflowTotal5 = Integer.parseInt(totalNo5);
		int workflowTotal6 = Integer.parseInt(totalNo6);
		int workflowTotal7 = Integer.parseInt(totalNo7);

		if (workflowTotal1 != 0 || workflowTotal2 != 0 || workflowTotal3 != 0 || workflowTotal4 != 0
				|| workflowTotal5 != 0 || workflowTotal6 != 0 || workflowTotal7 != 0) {
			// 第一次启动流程(流程1，流程2)
			JSONObject params1 = new JSONObject();
			JSONObject params2 = new JSONObject();
			JSONObject params3 = new JSONObject();
			JSONObject params4 = new JSONObject();
			JSONObject params5 = new JSONObject();
			JSONObject params6 = new JSONObject();
			JSONObject params7 = new JSONObject();

			// 流程1
			if (cellcode1 != null && !"".equals(cellcode1)) {
				params1.put("binCode", cellcode1 + "F1A");
				params1.put("shelfCode", cellcode1);
			} else {
				switch (workflowName1) {
				case "c1":
					params1.put("binCode", "A000001" + "F1A");
					params1.put("shelfCode", "A000001");
					System.out.println("switch_case_workflow_1");
					break;
				default:
					System.out.println("switch_case_workflow_default");
					// 默认赋值shelfcode
					break;
				}
			}

			params1.put("chooseStrategy", 1);
			params1.put("configType", 0);
			params1.put("count", 0);
			params1.put("extraParam", "testArkRpc");

			params1.put("shelfSide", "F");
			params1.put("shelfType", 0);
			// rms_multi-robot_testing
			params1.put("workflowCode", workflowName1);
			params1.put("workflowWorkId", 0);

			// 流程2
			if (cellcode2 != null && !"".equals(cellcode2)) {
				params2.put("binCode", cellcode2 + "F1A");
				params2.put("shelfCode", cellcode2);
			} else {
				switch (workflowName2) {
				case "c2":
					params2.put("binCode", "A000002" + "F1A");
					params2.put("shelfCode", "A000002");
					System.out.println("switch_case_workflow_2");
					break;
				default:
					System.out.println("switch_case_workflow_default");
					// 默认赋值shelfcode
					break;
				}
			}

			params2.put("chooseStrategy", 1);
			params2.put("configType", 0);
			params2.put("count", 0);
			params2.put("extraParam", "testArkRpc");

			params2.put("shelfSide", "F");
			params2.put("shelfType", 0);
			// rms_multi-robot_testing
			params2.put("workflowCode", workflowName2);
			params2.put("workflowWorkId", 0);

			// 流程3
			if (cellcode3 != null && !"".equals(cellcode3)) {
				params3.put("binCode", cellcode3 + "F1A");
				params3.put("shelfCode", cellcode3);
			} else {
				switch (workflowName3) {
				case "c3":
					params3.put("binCode", "A000003" + "F1A");
					params3.put("shelfCode", "A000003");
					System.out.println("switch_case_workflow_3");
					break;
				default:
					System.out.println("switch_case_workflow_default");
					// 默认赋值shelfcode
					break;
				}
			}

			params3.put("chooseStrategy", 1);
			params3.put("configType", 0);
			params3.put("count", 0);
			params3.put("extraParam", "testArkRpc");

			params3.put("shelfSide", "F");
			params3.put("shelfType", 0);
			// rms_multi-robot_testing
			params3.put("workflowCode", workflowName3);
			params3.put("workflowWorkId", 0);

			// 流程4
			if (cellcode4 != null && !"".equals(cellcode4)) {
				params4.put("binCode", cellcode4 + "F1A");
				params4.put("shelfCode", cellcode4);
			} else {
				switch (workflowName4) {
				case "c4":
					params4.put("binCode", "A000004" + "F1A");
					params4.put("shelfCode", "A000004");
					System.out.println("switch_case_workflow_4");
					break;
				default:
					System.out.println("switch_case_workflow_default");
					// 默认赋值shelfcode
					break;
				}
			}

			params4.put("chooseStrategy", 1);
			params4.put("configType", 0);
			params4.put("count", 0);
			params4.put("extraParam", "testArkRpc");

			params4.put("shelfSide", "F");
			params4.put("shelfType", 0);
			// rms_multi-robot_testing
			params4.put("workflowCode", workflowName4);
			params4.put("workflowWorkId", 0);

			// 流程5
			if (cellcode5 != null && !"".equals(cellcode5)) {
				params5.put("binCode", cellcode5 + "F1A");
				params5.put("shelfCode", cellcode5);
			} else {
				switch (workflowName5) {
				case "c5":
					params5.put("binCode", "A000005" + "F1A");
					params5.put("shelfCode", "A000005");
					System.out.println("switch_case_workflow_5");
					break;
				default:
					System.out.println("switch_case_workflow_default");
					// 默认赋值shelfcode
					break;
				}
			}

			params5.put("chooseStrategy", 1);
			params5.put("configType", 0);
			params5.put("count", 0);
			params5.put("extraParam", "testArkRpc");

			params5.put("shelfSide", "F");
			params5.put("shelfType", 0);
			// rms_multi-robot_testing
			params5.put("workflowCode", workflowName5);
			params5.put("workflowWorkId", 0);

			// 流程6
			if (cellcode6 != null && !"".equals(cellcode6)) {
				params6.put("binCode", cellcode6 + "F1A");
				params6.put("shelfCode", cellcode6);
			} else {
				switch (workflowName6) {
				case "c6":
					params6.put("binCode", "A000006" + "F1A");
					params6.put("shelfCode", "A000006");
					System.out.println("switch_case_workflow_6");
					break;
				default:
					System.out.println("switch_case_workflow_default");
					// 默认赋值shelfcode
					break;
				}
			}

			params6.put("chooseStrategy", 1);
			params6.put("configType", 0);
			params6.put("count", 0);
			params6.put("extraParam", "testArkRpc");

			params6.put("shelfSide", "F");
			params6.put("shelfType", 0);
			// rms_multi-robot_testing
			params6.put("workflowCode", workflowName6);
			params6.put("workflowWorkId", 0);

			// 流程7
			if (cellcode7 != null && !"".equals(cellcode7)) {
				params7.put("binCode", cellcode7 + "F1A");
				params7.put("shelfCode", cellcode7);
			} else {
				switch (workflowName7) {
				case "c7":
					params7.put("binCode", "A000007" + "F1A");
					params7.put("shelfCode", "A000007");
					System.out.println("switch_case_workflow_7");
					break;
				default:
					System.out.println("switch_case_workflow_default");
					// 默认赋值shelfcode
					break;
				}
			}

			params7.put("chooseStrategy", 1);
			params7.put("configType", 0);
			params7.put("count", 0);
			params7.put("extraParam", "testArkRpc");

			params7.put("shelfSide", "F");
			params7.put("shelfType", 0);
			// rms_multi-robot_testing
			params7.put("workflowCode", workflowName7);
			params7.put("workflowWorkId", 0);

			if (workflowName1 != null && !"".equals(workflowName1)) {
				HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params1);
				try {
					detailTableContent(workflowName1, params1.get("shelfCode").toString(), times1, "test_ark_rms_move",
							ip);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (workflowName2 != null && !"".equals(workflowName2)) {
				HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params2);
				try {
					detailTableContent(workflowName2, params2.get("shelfCode").toString(), times2, "test_ark_rms_move",
							ip);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (workflowName3 != null && !"".equals(workflowName3)) {
				HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params3);
				try {
					detailTableContent(workflowName3, params3.get("shelfCode").toString(), times3, "test_ark_rms_move",
							ip);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (workflowName4 != null && !"".equals(workflowName4)) {
				HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params4);
				try {
					detailTableContent(workflowName4, params4.get("shelfCode").toString(), times4, "test_ark_rms_move",
							ip);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (workflowName5 != null && !"".equals(workflowName5)) {
				HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params5);
				try {
					detailTableContent(workflowName5, params5.get("shelfCode").toString(), times5, "test_ark_rms_move",
							ip);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (workflowName6 != null && !"".equals(workflowName6)) {
				HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params6);
				try {
					detailTableContent(workflowName6, params6.get("shelfCode").toString(), times6, "test_ark_rms_move",
							ip);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (workflowName7 != null && !"".equals(workflowName7)) {
				HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params7);
				try {
					detailTableContent(workflowName7, params7.get("shelfCode").toString(), times7, "test_ark_rms_move",
							ip);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(5000);
			} catch (Exception e) {

				e.printStackTrace();
			}

			while (true) {

				if (workflowName1 != null && !"".equals(workflowName1)) {
					ArrayList al1 = DBConnection.getInstance("ark").execQuerySql6(
							"SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = '"
									+ workflowName1 + "'");
					String calcSqlNo1 = (al1.get(0).toString()).substring(1, al1.get(0).toString().length() - 1);

					int totalWorkflow1 = Integer.parseInt(calcSqlNo1);

					System.out.println("The first workflowTotal1 :" + totalWorkflow1);

					if (totalWorkflow1 == (number1 + 1)) {
						// 控制循环次数
						if ((number1 + 1) == times1) {
							// break;
						} else {
							String shelfCode = params1.get("shelfCode").toString();
							ArrayList status = DBConnection.getInstance("ark").execQuerySql6(
									"SELECT status from t_base_shelf where shelf_code = '" + shelfCode + "'");
							String shelfStatus = (status.get(0).toString()).substring(1,
									status.get(0).toString().length() - 1);

							if (shelfStatus.equals("1")) {
								HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart",
										params1);
								number1 = number1 + 1;
							}
						}

					}
				}

				if (workflowName2 != null && !"".equals(workflowName2)) {
					ArrayList al2 = DBConnection.getInstance("ark").execQuerySql6(
							"SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = '"
									+ workflowName2 + "'");
					String calcSqlNo2 = (al2.get(0).toString()).substring(1, al2.get(0).toString().length() - 1);

					int totalWorkflow2 = Integer.parseInt(calcSqlNo2);

					System.out.println("The first workflowTotal2 :" + totalWorkflow2);

					if (totalWorkflow2 == (number2 + 1)) {
						// 控制循环次数
						if ((number2 + 1) == times2) {
							// break;
						} else {
							String shelfCode = params2.get("shelfCode").toString();
							ArrayList status = DBConnection.getInstance("ark").execQuerySql6(
									"SELECT status from t_base_shelf where shelf_code = '" + shelfCode + "'");
							String shelfStatus = (status.get(0).toString()).substring(1,
									status.get(0).toString().length() - 1);

							if (shelfStatus.equals("1")) {
								HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart",
										params2);
								number2 = number2 + 1;
							}
						}

					}
				}

				if (workflowName3 != null && !"".equals(workflowName3)) {
					ArrayList al3 = DBConnection.getInstance("ark").execQuerySql6(
							"SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = '"
									+ workflowName3 + "'");
					String calcSqlNo3 = (al3.get(0).toString()).substring(1, al3.get(0).toString().length() - 1);

					int totalWorkflow3 = Integer.parseInt(calcSqlNo3);

					System.out.println("The first workflowTotworkflowName3 :" + totalWorkflow3);

					if (totalWorkflow3 == (number3 + 1)) {
						// 控制循环次数
						if ((number3 + 1) == times3) {
							// break;
						} else {
							String shelfCode = params3.get("shelfCode").toString();
							ArrayList status = DBConnection.getInstance("ark").execQuerySql6(
									"SELECT status from t_base_shelf where shelf_code = '" + shelfCode + "'");
							String shelfStatus = (status.get(0).toString()).substring(1,
									status.get(0).toString().length() - 1);

							if (shelfStatus.equals("1")) {
								HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart",
										params3);
								number3 = number3 + 1;
							}
						}

					}
				}

				if (workflowName4 != null && !"".equals(workflowName4)) {
					ArrayList al4 = DBConnection.getInstance("ark").execQuerySql6(
							"SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = '"
									+ workflowName4 + "'");
					String calcSqlNo4 = (al4.get(0).toString()).substring(1, al4.get(0).toString().length() - 1);

					int totalWorkflow4 = Integer.parseInt(calcSqlNo4);

					System.out.println("The first workflowTotworkflowName4 :" + totalWorkflow4);

					if (totalWorkflow4 == (number4 + 1)) {
						// 控制循环次数
						if ((number4 + 1) == times4) {
							// break;
						} else {
							String shelfCode = params4.get("shelfCode").toString();
							ArrayList status = DBConnection.getInstance("ark").execQuerySql6(
									"SELECT status from t_base_shelf where shelf_code = '" + shelfCode + "'");
							String shelfStatus = (status.get(0).toString()).substring(1,
									status.get(0).toString().length() - 1);

							if (shelfStatus.equals("1")) {
								HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart",
										params4);
								number4 = number4 + 1;
							}
						}

					}
				}

				if (workflowName5 != null && !"".equals(workflowName5)) {
					ArrayList al5 = DBConnection.getInstance("ark").execQuerySql6(
							"SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = '"
									+ workflowName5 + "'");
					String calcSqlNo5 = (al5.get(0).toString()).substring(1, al5.get(0).toString().length() - 1);

					int totalWorkflow5 = Integer.parseInt(calcSqlNo5);

					System.out.println("The first workflowTotworkflowName5 :" + totalWorkflow5);

					if (totalWorkflow5 == (number5 + 1)) {
						// 控制循环次数
						if ((number5 + 1) == times5) {
							// break;
						} else {
							String shelfCode = params5.get("shelfCode").toString();
							ArrayList status = DBConnection.getInstance("ark").execQuerySql6(
									"SELECT status from t_base_shelf where shelf_code = '" + shelfCode + "'");
							String shelfStatus = (status.get(0).toString()).substring(1,
									status.get(0).toString().length() - 1);

							if (shelfStatus.equals("1")) {
								HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart",
										params5);
								number5 = number5 + 1;
							}
						}

					}
				}

				if (workflowName6 != null && !"".equals(workflowName6)) {
					ArrayList al6 = DBConnection.getInstance("ark").execQuerySql6(
							"SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = '"
									+ workflowName6 + "'");
					String calcSqlNo6 = (al6.get(0).toString()).substring(1, al6.get(0).toString().length() - 1);

					int totalWorkflow6 = Integer.parseInt(calcSqlNo6);

					System.out.println("The first workflowTotworkflowName6 :" + totalWorkflow6);

					if (totalWorkflow6 == (number6 + 1)) {
						// 控制循环次数
						if ((number6 + 1) == times6) {
							// break;
						} else {
							String shelfCode = params6.get("shelfCode").toString();
							ArrayList status = DBConnection.getInstance("ark").execQuerySql6(
									"SELECT status from t_base_shelf where shelf_code = '" + shelfCode + "'");
							String shelfStatus = (status.get(0).toString()).substring(1,
									status.get(0).toString().length() - 1);

							if (shelfStatus.equals("1")) {
								HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart",
										params6);
								number6 = number6 + 1;
							}
						}

					}
				}

				if (workflowName7 != null && !"".equals(workflowName7)) {
					ArrayList al7 = DBConnection.getInstance("ark").execQuerySql6(
							"SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = '"
									+ workflowName7 + "'");
					String calcSqlNo7 = (al7.get(0).toString()).substring(1, al7.get(0).toString().length() - 1);

					int totalWorkflow7 = Integer.parseInt(calcSqlNo7);

					System.out.println("The first workflowTotworkflowName7 :" + totalWorkflow7);

					if (totalWorkflow7 == (number7 + 1)) {
						// 控制循环次数
						if ((number7 + 1) == times7) {
							// break;
						} else {
							String shelfCode = params7.get("shelfCode").toString();
							ArrayList status = DBConnection.getInstance("ark").execQuerySql6(
									"SELECT status from t_base_shelf where shelf_code = '" + shelfCode + "'");
							String shelfStatus = (status.get(0).toString()).substring(1,
									status.get(0).toString().length() - 1);

							if (shelfStatus.equals("1")) {
								HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart",
										params7);
								number7 = number7 + 1;
							}
						}

					}
				}

				// min=(a<b)?a:b;
				if (((times1 != 0) ? ((number1 + 1) == times1) : true)
						&& ((times2 != 0) ? ((number2 + 1) == times2) : true)
						&& ((times3 != 0) ? ((number3 + 1) == times3) : true)
						&& ((times4 != 0) ? ((number4 + 1) == times4) : true)
						&& ((times5 != 0) ? ((number5 + 1) == times5) : true)
						&& ((times6 != 0) ? ((number6 + 1) == times6) : true)
						&& ((times7 != 0) ? ((number7 + 1) == times7) : true)) {
					break;
				}

//				if ((number1 + 1) == times1 && (number2 + 1) == times2) {
//					break;
//				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// return "#####ark launched workflow successfully ";
			}
		} else {
			return "###this workflow is not existed###";
		}
		return "#####ark launched workflow successfully####";

	}

	public static void main(String[] args) {

		JSONObject params1 = new JSONObject();
		params1.put("workflowCode", "1");
		System.out.println(params1.containsKey("workflowCode"));

	}

}
