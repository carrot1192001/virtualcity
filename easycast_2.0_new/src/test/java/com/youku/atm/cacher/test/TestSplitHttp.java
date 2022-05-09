package com.youku.atm.cacher.test;

public class TestSplitHttp {
	
	public static void main(String[] args) {
		String urlwithhttp = "http://r1.ykimg.com/material/0A03/201612/1224/129310/Penguins.jpeg";
	    
		String result = "";
		result = urlwithhttp.substring(urlwithhttp.indexOf("//"), urlwithhttp.length());   
	    System.out.println(result);
	}

}
