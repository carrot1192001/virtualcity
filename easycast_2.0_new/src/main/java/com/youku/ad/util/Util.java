package com.youku.ad.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Util {
	
	public static String requestGet(String url){ 
		return requestGet(url,15000);
	}
	
	public static InputStream requestGetStream(String url,int timeout){
		HttpClient client = new HttpClient();
		//String result = null;
		GetMethod method = new GetMethod(url);
		
		method.setRequestHeader("Accept","*/*");
		method.setRequestHeader("Connection","close");
		method.setRequestHeader("Accept-Language","zh-cn");
		method.setRequestHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		method.setRequestHeader("Cache-Control","no-cache");
		method.getParams().setSoTimeout(timeout);
		
		
		method.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		try {
			client.executeMethod(method);     
			return method.getResponseBodyAsStream();
//			 java.io.BufferedReader l_reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));   
//             String   sCurrentLine   =   "";   
//             String   sTotalString   =   "";   
//             while   ((sCurrentLine   =   l_reader.readLine())   !=   null){   
//                     sTotalString+=sCurrentLine;   
//             }
//             result = sTotalString;
		} catch (Exception e) {
			System.out.println("请求url失败:"+url);
			e.printStackTrace();
			return null;
		}
		//return result;
	}
	
	public static String requestGet(String url,int timeout){
		HttpClient client = new HttpClient();
		String result = null;
		GetMethod method = new GetMethod(url);
		
		method.setRequestHeader("Accept","*/*");
		method.setRequestHeader("Connection","close");
		method.setRequestHeader("Accept-Language","zh-cn");
		method.setRequestHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		method.setRequestHeader("Cache-Control","no-cache");
		method.getParams().setSoTimeout(timeout);
	//	method.setFollowRedirects(true);
	//	method.setRequestHeader("Cookie",cookie);
		
		
		method.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		try {
			client.executeMethod(method);
			result = method.getResponseBodyAsString();
		} catch (Exception e) {
			System.out.println("请求url失败:"+url);
			e.printStackTrace();
		}finally{
			method.releaseConnection();
		}
		return result;
	}
	
	public static String requestPost(String url){
		HttpClient client = new HttpClient();
		String result = null;
		HttpMethod method = new PostMethod(url); 

		method.setRequestHeader("Accept","*/*");
		method.setRequestHeader("Connection","close");
		method.setRequestHeader("Accept-Language","zh-cn");
		method.setRequestHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		method.setRequestHeader("Cache-Control","no-cache");
	//	method.setFollowRedirects(true);
	//	method.setRequestHeader("Cookie",cookie);
		
		
		method.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		try {
			client.executeMethod(method);
			result = method.getResponseBodyAsString();
		} catch (Exception e) {
			System.out.println("请求url失败:"+url);
			e.printStackTrace();
		}finally{
			method.releaseConnection();
		}
		return result;
	}
	
	/** 判断当前URL，是否可能为优酷转义后的URL。false为不可能。*/
	public static boolean isCovertURL(String url){
		boolean result = false;
		
		if(url.indexOf("_esc") > -1){
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 转换URL中的 & 为 $$
	 * @param url
	 * @return
	 */
	public static String covertUrl(String url)
	{
		try{
			/*老版本的替换规则，有冲突，改进
		url=url.replaceAll("%", "!9999!");	
		url=url.replaceAll("&", "!url!");
		url=url.replaceAll("#", "!35!");
		url=url.replaceAll("=", "!61!");
		url=url.replaceAll("\\?", "!63!");
		url=url.replaceAll("×", "!215!");
		url=url.replaceAll("\\+", "!20!");
		*/
			url=url.replaceAll("%", "percent_esc");	
			url=url.replaceAll("&", "and_esc");
			url=url.replaceAll("#", "sharp_esc");
			url=url.replaceAll("=", "equal_esc");
			url=url.replaceAll("\\?", "interrogation_esc");
			url=url.replaceAll("\\+", "add_esc");
			url=url.replaceAll("\\$", "dollar_esc");
		return url;
		}catch(Exception e){
			e.printStackTrace();
			return url;
		}
	}
	
	/**
	 * 转换URL中的 $$ 为 & ,covertUrl的反方法
	 * 使用前建议调用isCovertURL方法，为true再执行。
	 * @param url
	 * @return
	 */
	public static String backCovertUrl(String url)
	{	
		try{
		//url=URLDecoder.decode(url,"utf-8");
		
		//新的替换规则
		url=url.replaceAll("and_esc","&");
		url=url.replaceAll("sharp_esc", "#");
		url=url.replaceAll("equal_esc","=");
		url=url.replaceAll("interrogation_esc","?");
		url=url.replaceAll("percent_esc", "%");
		url=url.replaceAll("add_esc", "+");
		url=url.replaceAll("dollar_esc","\\$");
			
			
		//兼容以前老版本的转换
		//顺序很重要	
		url=url.replaceAll("!url!","&");
		url=url.replaceAll("!35!", "#");
		url=url.replaceAll("!61!","=");
		url=url.replaceAll("!63!","?");
		url=url.replaceAll("!215!","×");
		url=url.replaceAll("!9999!", "%");
		url=url.replaceAll("!20!", "+");
		return url;
		}catch(Exception e){
			e.printStackTrace();
			return url;
		}
	}
	
	/**
	 * 自定义的md5加密，注意不要修改key值
	 * @param str
	 * @return
	 */
	public static String getMD5Str(String str) {   
		str="youkuatm"+str+"atm5!%^&*(#0";
		return md5(str);
    }
	
	
	/**
	 * 标准的md5加密
	 * @param str
	 * @return
	 */
	public static String md5(String str) {   
        MessageDigest messageDigest = null;   
        try {   
            messageDigest = MessageDigest.getInstance("MD5");   
            messageDigest.reset();   
            messageDigest.update(str.getBytes("UTF-8"));   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
   
        byte[] byteArray = messageDigest.digest();   
        StringBuffer md5StrBuff = new StringBuffer();   
        for (int i = 0; i < byteArray.length; i++) {               
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)   
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));   
            else   
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));   
        }   
        return md5StrBuff.toString();   
    }   
	
	
	public static String doubleEncode(String s,String encode){
		try{
		s=URLEncoder.encode(s,encode);
		return URLEncoder.encode(s,encode);
		}catch(Exception e){
			e.printStackTrace();
			return s;
		}
	}
	
	public static int getValueAt(Integer[] array,int position)
	{
		Arrays.sort(array);
		return array.length>=position?array[array.length-position]:0;
	}
	
//	WHY add 10-07-29
//	为查询video的分类
	private static String FIELDS = "title videoid seconds category thumburl desc total_vv createyear createmonth".replaceAll(" ", "+");
	private static String URL_PREFIX = "http://10.101.88.223/video.video?fd="+FIELDS+"&q=videoid%3A";
	public static String  fillVideoInfo(int vid ) throws Exception{
			String videoType = "";
			try {
				URL url = new URL(URL_PREFIX+vid);
				URLConnection conn = url.openConnection();
				JSONParser json = new JSONParser();
				JSONObject obj = (JSONObject) json.parse(new InputStreamReader(conn.getInputStream()));
				Long count = (Long) obj.get("total");
				if(count != 1){
					return "";
				}
				
				JSONObject results = (JSONObject) ((JSONArray) obj.get("results")).toArray()[0];
				
				videoType = (String) results.get("category");
				
				
			} catch (MalformedURLException e) {
				throw new Exception("vid:"+vid,e);
			} catch (Throwable e2) {
				throw new Exception("vid:"+vid,e2);
			}
			return videoType;
		
	}
	
	/**
	 * 替代jdk的split方法，提供高性能
	 * @param s 要拆分的字符串
	 * @param delimiter 分隔符
	 * @return 字符串数组
	 */
	public static String[] split(String s, String delimiter){
		if (s == null) {
			return null;
		}
		int delimiterLength;
		int stringLength = s.length();
		if (delimiter == null || (delimiterLength = delimiter.length()) == 0){
			return new String[] {s};
		}
		int count;
		int start;
		int end;

		count = 0;
		start = 0;
		while((end = s.indexOf(delimiter, start)) != -1){
			count++;
			start = end + delimiterLength;
		}
		count++;

		String[] result = new String[count];

		count = 0;
		start = 0;
		while((end = s.indexOf(delimiter, start)) != -1){
			result[count] = (s.substring(start, end));
			count++;
			start = end + delimiterLength;
		}
		end = stringLength;
		result[count] = s.substring(start, end);

		return (result);
	}
	
	/**
	 * 替代jdk的split方法，提供高性能
	 * @param s 要拆分的字符串
	 * @param delimiter 分隔符
	 * @return 字符串数组
	 */
	public static String[] split(String s, String delimiter, int size){
		if (s == null) {
			return null;
		}
		int delimiterLength;
		int stringLength = s.length();
		if (delimiter == null || (delimiterLength = delimiter.length()) == 0){
			return new String[] {s};
		}
		int count;
		int start;
		int end;
		String[] result = new String[size];
		count = 0;
		start = 0;
		while((end = s.indexOf(delimiter, start)) != -1){
			result[count] = (s.substring(start, end));
			count++;
			start = end + delimiterLength;
		}
		end = stringLength;
		result[count] = s.substring(start, end);
		return (result);
	}
	
	/**
	 * 获取ip的长整型表示<br>
	 * @param ip  -- ip字符串
	 * @return ip_long -- ip长整型
	 */
	public static long getIPLong(String ip) {
		long iplong = 0;
		String[] ipArray = ip.split("\\.");
		int length = ipArray.length;
		for(int i=0; i<length; i++) {
			long temp = Long.valueOf(ipArray[i]);
			int moveTime = 24 - 8*i;
			temp = temp << moveTime;
			iplong += temp;
		}
		return iplong;
	}
	
	public static void main(String[] args)
	{
	}
}
