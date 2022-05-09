package com.youku.atm.easycast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.logging.Log;

public class StringUtil {
    //protected static final Log logger = LogUtil.getLog();
    
    private static Random randomGen = new Random();
    
    private static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
            + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    private static char[] numbers = ("0123456789").toCharArray();
    
    private static final String cvt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789+/";
    private static final int fillchar = '=';
    
    /**
     * 替代jdk的split方法，提供高性能
     * 
     * @param s 要拆分的字符串
     * @param delimiter 分隔符
     * @return 字符串数组
     */
    public static String[] split(String s, String delimiter) {
        if (s == null) {
            return null;
        }
        int delimiterLength;
        int stringLength = s.length();
        if (delimiter == null || (delimiterLength = delimiter.length()) == 0) {
            return new String[] {s};
        }
        int count;
        int start;
        int end;
        
        count = 0;
        start = 0;
        while ((end = s.indexOf(delimiter, start)) != -1) {
            count++;
            start = end + delimiterLength;
        }
        count++;
        
        String[] result = new String[count];
        
        count = 0;
        start = 0;
        while ((end = s.indexOf(delimiter, start)) != -1) {
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
     * 
     * @param s 要拆分的字符串
     * @param delimiter 分隔符
     * @return 字符串数组
     */
    public static String[] split(String s, String delimiter, int size) {
        if (s == null) {
            return null;
        }
        int delimiterLength;
        int stringLength = s.length();
        if (delimiter == null || (delimiterLength = delimiter.length()) == 0) {
            return new String[] {s};
        }
        int count;
        int start;
        int end;
        String[] result = new String[size];
        count = 0;
        start = 0;
        while ((end = s.indexOf(delimiter, start)) != -1) {
            result[count] = (s.substring(start, end));
            count++;
            start = end + delimiterLength;
        }
        end = stringLength;
        result[count] = s.substring(start, end);
        return (result);
    }
    
    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        // Create a char buffer to put random letters and numbers in.
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randomGen.nextInt(71)];
        }
        return new String(randBuffer);
    }
    
    public static final String randomNumber(int length) {
        if (length < 1) {
            return null;
        }
        // Create a char buffer to put random letters and numbers in.
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbers[randomGen.nextInt(10)];
        }
        return new String(randBuffer);
    }
    
    public static long parseLong(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
        }
        return 0;
    }
    
    /**
     * 获取ip的长整型表示<br>
     * 
     * @param ip_string -- ip字符串
     * @return ip_long -- ip长整型
     */
    public static long getIPLong(String ip) {
        long iplong = 0;
        String[] ipArray = ip.split("\\.");
        int length = ipArray.length;
        for (int i = 0; i < length; i++) {
            long temp = Long.valueOf(ipArray[i]);
            int moveTime = 24 - 8 * i;
            temp = temp << moveTime;
            iplong += temp;
        }
        return iplong;
    }
    
    // 是否是正整数 str > 0 str = [1-9][0-9]*
    public static boolean isPositiveInteger(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char ch = str.charAt(0);
        if (ch < '1' || ch > '9') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
    
    // 是否是整数 str = 0|-?[1-9][0-9]*
    public static boolean isInteger(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if ("0".equals(str)) {
            return true;
        }
        int i = 0;
        char ch = str.charAt(i++);
        if (ch == '-') {
            ch = str.charAt(i++);
        }
        if (ch < '1' || ch > '9') {
            return false;
        }
        while (i < str.length()) {
            ch = str.charAt(i++);
            if (ch < '0' || ch > '9') {
                return false;
            }
            if (i >= 12) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = str.length(); --i >= 0;) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Encodes a String as a base64 String.
     * 
     * @param data a String to encode.
     * @return a base64 encoded String.
     */
    public static String encodeBase64(String data) {
        if (data != null) {
            return encodeBase64(data.getBytes());
        } else {
            return null;
        }
    }
    
    /**
     * Encodes a byte array into a base64 String.
     * 
     * @param data a byte array to encode.
     * @return a base64 encode String.
     */
    public static String encodeBase64(byte[] data) {
        int c;
        int len = data.length;
        StringBuffer ret = new StringBuffer(((len / 3) + 1) * 4);
        for (int i = 0; i < len; ++i) {
            c = (data[i] >> 2) & 0x3f;
            ret.append(cvt.charAt(c));
            c = (data[i] << 4) & 0x3f;
            if (++i < len) {
                c |= (data[i] >> 4) & 0x0f;
            }
            
            ret.append(cvt.charAt(c));
            if (i < len) {
                c = (data[i] << 2) & 0x3f;
                if (++i < len) {
                    c |= (data[i] >> 6) & 0x03;
                }
                
                ret.append(cvt.charAt(c));
            } else {
                ++i;
                ret.append((char) fillchar);
            }
            
            if (i < len) {
                c = data[i] & 0x3f;
                ret.append(cvt.charAt(c));
            } else {
                ret.append((char) fillchar);
            }
        }
        return ret.toString();
    }
    
    /**
     * Decodes a base64 String.
     * 
     * @param data a base64 encoded String to decode.
     * @return the decoded String.
     */
    public static String decodeBase64(String data) {
        if (data != null) {
            return decodeBase64(data.getBytes());
        } else {
            return null;
        }
    }
    
    /**
     * Decodes a base64 aray of bytes.
     * 
     * @param data a base64 encode byte array to decode.
     * @return the decoded String.
     */
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
                if (fillchar == c) {
                    break;
                }
                
                c = cvt.indexOf((char) c);
                c1 = ((c1 << 4) & 0xf0) | ((c >> 2) & 0xf);
                ret.append((char) c1);
            }
            
            if (++i < len) {
                c1 = data[i];
                if (fillchar == c1) {
                    break;
                }
                
                c1 = cvt.indexOf((char) c1);
                c = ((c << 6) & 0xc0) | c1;
                ret.append((char) c);
            }
        }
        return ret.toString();
    }
    
    public static String gzip(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzipos = new GZIPOutputStream(bos);
            gzipos.write(str.getBytes("iso8859-1"), 0, str.length());
            gzipos.flush();
            gzipos.finish();
            gzipos.close();
            byte[] bytes = bos.toByteArray();
            return encodeBase64(bytes).replace("+", "-").replace("/", "_").replace("=", ".");
        } catch (Exception e) {
            //logger.error(e);
        }
        return "";
    }
    
    public static String ungzip(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] bytes =
                    decodeBase64(str.replace("-", "+").replace("_", "/").replace(".", "=")).getBytes("iso8859-1");
            GZIPInputStream gzipis = new GZIPInputStream(new ByteArrayInputStream(bytes));
            byte[] bs = new byte[256];
            int rn = 0;
            while ((rn = gzipis.read(bs, 0, 256)) >= 0) {
                bos.write(bs, 0, rn);
            }
            gzipis.close();
            return new String(bos.toByteArray());
        } catch (Exception e) {
            //logger.error(e);
        }
        return "";
    }
    
    /**
     * 判断是否指定字符串为空字符串(null或者长度为0)
     * 
     * @param stringValue
     * @return boolean
     */
    public static boolean isEmptyString(String stringValue) {
        if (stringValue == null || stringValue.length() < 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String htmlToJs(String html) {
        StringBuffer sb = new StringBuffer();
        char[] chars = html.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
            case '\'':
                sb.append("\\'");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '\n':
                // sb.append("\\n");
                break;
            case '\r':
                // sb.append("\\r");
                break;
            case '/':
                sb.append("\\/");
                break;
            case '\"':
                sb.append("\\\"");
                break;
            default:
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
	
	public static String jsToHtml(String js) {
        StringBuilder sb = new StringBuilder();
        char[] chars = js.toCharArray();
        for (int i = 0; i < chars.length; i++) {
			if(chars[i] == '\\') {
				i++;
				switch (chars[i]) {
				case '\'':
					sb.append('\'');
					break;
				case '\\':
					sb.append("\\");
					break;
				case 'n':
					sb.append("\n");
					break;
				case 'r':
					sb.append("\r");
					break;
				case '/':
					sb.append("/");
					break;
				case '\"':
					sb.append("\"");
					break;
				default:
					sb.append(chars[i]);
				}
			}else{
				sb.append(chars[i]);
			}
        }
        return sb.toString();
	}

    public static String getDomain(String url) {
        if (url == null || url.length() == 0) {
            return url;
        }
        String[] s = url.split("/");
        String reClick = "";
        if (url.startsWith("http") || url.startsWith("//")) {
            reClick = s[2];
        } else {
            reClick = s[0];
        }

        if (reClick != null && reClick.length() > 0) {
            if (reClick.indexOf("?") > 0) {
                return reClick.split("\\?")[0];
            }
        }
        return reClick;
    }
    
    public static void main(String[] args) {
    	System.out.println(getDomain("http://www.baidu.com/asd"));
    	System.out.println(getDomain("https://www.baidu.com/asd"));
    	System.out.println(getDomain("www.baidu.com/asd"));
    	System.out.println(getDomain("www.baidu.com"));
    	System.out.println(getDomain("//www.baidu.com/asd"));
    	System.out.println(getDomain("//www.baidu.com"));
	}

    /**
     * 替换以regex开头的字符串
     * @param str
     * @param regex
     * @param replacement
     * @return
     */
    public static String replaceFirst(String str, String regex, String replacement) {
    	if (str == null || str.length() == 0) {
    		return str;
    	}
    	String reg = "^" + regex;
    	return str.replaceFirst(reg, replacement);
    }

    public static String escapeHtml(String s){
	       if (s == null || "".equals(s)) {  
	           return s;  
	       }  
	       StringBuilder sb = new StringBuilder(s.length() + 16);  
	       for (int i = 0; i < s.length(); i++) {  
	           char c = s.charAt(i);  
	           switch (c) {  
	           case '<':  
	               sb.append("&lt;");  
	               break; 
	           case '>':  
	               sb.append("&gt;");  
	               break;  
	           case '&':  
	        	   sb.append("&amp;");  
	        	   break;
	           case '\"':  
	               sb.append("&quot;");  
	               break;
	           case '\r':  
	               sb.append("");  
	               break;
	           case '\n':  
	               sb.append("");  
	               break; 
	           default:  
	               sb.append(c);  
	               break;  
	           }  
	       }  
	       return sb.toString(); 
	   }
    
    public static String list2string(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (String v : list) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(v);
            }
        }
        return sb.toString();
    }
    
}
