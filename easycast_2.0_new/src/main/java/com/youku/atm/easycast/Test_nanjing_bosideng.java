package com.youku.atm.easycast;

import java.util.ArrayList;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;

import com.alibaba.fastjson.JSONObject;

public class Test_nanjing_bosideng {
	
	public static void main(String[] args) {
		int number = 0;
		int number1 = 0;
		
		try {
			Torque.init("F:\\gary_geek\\w_geek_test_socket\\src\\main\\resources\\Torque.properties");
		} catch (TorqueException e1) {
			// TODO Auto-generated catch block
		}
		
//		Boolean a1 = DBConnection.getInstance("ark").execSql("truncate t_workflow ");
//		Boolean a2 = DBConnection.getInstance("ark").execSql("truncate t_workflow_task ");
//
//		System.out.println("a1 is : " + a1);
//		System.out.println("a2 is : " + a2);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		//第一次启动流程：
		JSONObject params = new JSONObject();
		params.put("binCode", "A000002" + "F1A");
		params.put("chooseStrategy", 1);
		params.put("configType", 0);
		params.put("count", 0);
		params.put("extraParam", "testArkRpc");

		params.put("shelfCode", "A000002");

		params.put("shelfSide", "F");
		params.put("shelfType", 0);
		params.put("workflowCode", "rms_multi-robot_testing");
		params.put("workflowWorkId", 0);

		String res = HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params);
		
		while(true) {
			
			//第一组
			ArrayList al = DBConnection.getInstance("ark").execQuerySql6("SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = 'rms_multi-robot_testing'");
			String calcSqlNo = (al.get(0).toString()).substring(1, al.get(0).toString().length() - 1);
			
			int totalWorkflow = Integer.parseInt(calcSqlNo);

			System.out.println("The first workflowtotal :" + totalWorkflow);
			
			//第二组
			ArrayList al1 = DBConnection.getInstance("ark").execQuerySql6("SELECT count(*) from t_workflow where work_status = 30 and workflow_config_name = 'rms_multi-robot_testing1'");
			String calcSqlNo1 = (al1.get(0).toString()).substring(1, al1.get(0).toString().length() - 1);
			
			int totalWorkflow1 = Integer.parseInt(calcSqlNo1);

			System.out.println("The second workflowtotal :" + totalWorkflow1);

			if(totalWorkflow==(number+1)) {	
				
				//控制循环次数
				if((number+1) == 10) {
					break;
				}
				
				String res1 = HttpRequestUtils.doPost("http://172.16.3.48:8089/ark-web/api/test/workflowStart", params);
				System.out.println("result is :" + res1);				
				number = number + 1;
				
			}else if(totalWorkflow1==(number1+1)){
				//do dopost
				number1 = number1 + 1;
			}else {
				//to do nothing;
			}	
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
