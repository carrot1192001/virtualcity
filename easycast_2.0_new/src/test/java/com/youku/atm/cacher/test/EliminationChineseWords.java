package com.youku.atm.cacher.test;

public class EliminationChineseWords {
	
	public static void main(String[] args) {
		
		String str_VarMboxRead = "<th>退信原因：<th>     <td colspan=2>     <p>    DATA    ʧ ܶԷ                     ʻ    ʼ   <p> ";
		System.out.println("change chinese before VarMboxRead="
				+ str_VarMboxRead);
	    //去掉中午字符， ("[\u4e00-\u9fa5]+")这个字符区间，所有 ASCII：[\x00-\x7F] 
		String str_Result = "", str_OneStr = "";
		for (int z = 0; z < str_VarMboxRead.length(); z++) {
			str_OneStr = str_VarMboxRead.substring(z, z + 1);
//			if (!str_OneStr.matches("[\u4e00-\u9fa5]+")) {
			if (str_OneStr.matches("[\\x00-\\x7F]+")) {
				str_Result = str_Result + str_OneStr;
			}
		}
		System.out.println("change chinese after VarMboxRead="
				+ str_Result);
		
	}

}
