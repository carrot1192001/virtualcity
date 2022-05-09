package com.youku.atm.cacher.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestStringToDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = "2012-03-11";
		try {
			Date date=sdf.parse(strDate);
			 System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int a =2;
		int[] d = {2};
		System.out.println(d[0]);
          
	}

}
