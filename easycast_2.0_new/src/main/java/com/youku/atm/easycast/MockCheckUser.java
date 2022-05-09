package com.youku.atm.easycast;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MockCheckUser implements CheckUserInterface{
	
	public boolean checkUsre(UserBean user) {
		
		try{
			
			if(!user.username.equals("")&&user.username!=null){
				if(!user.password.equals("")&&user.password!=null){
//					
//					String sql1 = "select userName from dbuser where userName = '"
//							+ user.username + "';";
//					
//					System.out.println("sql1 is : " + sql1);
//					
//					@SuppressWarnings("rawtypes")
//					ArrayList al1 = DBConnection.getInstance("atm").execQuerySql7(sql1);
//
//					if(al1 != null){
//						
//						String sql2 = "select userPwd from dbuser where userName = '"
//								+ user.username + "';";
//						
//						@SuppressWarnings("rawtypes")
//						ArrayList al2 = DBConnection.getInstance("atm").execQuerySql7(sql2);
//						
//						String c = (al2.get(0).toString()).substring(1, al2.get(0)
//								.toString().length() - 1)
//								+ "";
//						//System.out.println("cast_way is: " + c);
//						
//						if(user.password.equals(c)){
//						  return true;	
//						}
//					}
					
					if(user.username.equals("Gary")&&user.password.equals("88481013")){
						return true;	
					}
					
				}
							
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return false;
		
	}

}
