package com.youku.atm.easycast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;


public class Util {
	
	public static String requestGet(String url){ 
		return requestGet(url,15000);
	}
	
	public static String requestGet(String url,int timeout){ 
	 	String result = "";
        InputStream in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();

            // 定义 BufferedReader输入流来读取URL的响应
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
            in = connection.getInputStream();
			byte[] buf = new byte[1024];
			int nn = 0;
            while ((nn = in.read(buf)) > 0) {
				bos.write(buf, 0, nn);
            }
			result = new String(bos.toByteArray());
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
}
	

	
    /**
     * click地址转换
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
		//return URLEncoder.encode(url,"utf-8");
		}catch(Exception e){
			e.printStackTrace();
			return url;
		}
	}
	
	/**
	 * 转换URL中的 $$ 为 & ,covertUrl的反方法
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
	
    private static final int fillchar = '=';
    private static final String cvt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz" + "0123456789+/";
	
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
     * Decodes a base64 String.
     * 
     * @param data
     *            a base64 encoded String to decode.
     * @return the decoded String.
     */
    public static String decodeBase64(String data) {
        if (data != null) {
            return decodeBase64(data.getBytes());
        } else {
            return null;
        }
    }
    
    public static String decodeBase64(byte[] data) {
        int c, c1;
        int len = data.length;
        StringBuffer ret = new StringBuffer((len * 3) / 4);
        for (int i = 0; i < len; ++i) {
            c = cvt.indexOf(data[i]);
            ++i;
            c1 = cvt.indexOf(data[i]);
            c = ((c << 2) | ((c1 >> 4) & 0x3));
            ret.append((char) c);
            if (++i < len) {
                c = data[i];
                if (fillchar == c)
                    break;

                c = cvt.indexOf((char) c);
                c1 = ((c1 << 4) & 0xf0) | ((c >> 2) & 0xf);
                ret.append((char) c1);
            }

            if (++i < len) {
                c1 = data[i];
                if (fillchar == c1)
                    break;

                c1 = cvt.indexOf((char) c1);
                c = ((c << 6) & 0xc0) | c1;
                ret.append((char) c);
            }
        }
        return ret.toString();
    }
    
    
	
	
	
	public static void main(String[] args)
	{
		
		
	}
}
