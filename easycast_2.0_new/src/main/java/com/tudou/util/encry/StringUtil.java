package com.tudou.util.encry;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {
    protected static final Log logger = LogFactory.getLog("STDOUTLOG");
    
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
    
    public static final String formatString(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
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
            logger.error(e);
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
            logger.error(e);
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
    
    /**
     * string类型参数处理
     * 
     * @param request
     * 
     * @param param
     * @return
     */
    public static String formatString(HttpServletRequest request, String param) {
        String value = request.getParameter(param);
        if (value == null) {
            return "";
        } else {
            return value.trim();
        }
    }
    
    /**
     * 正整数类型的参数处理,除了正整数其他全部返回0
     * 
     * @param request
     * @param param
     * @return
     */
    public static int getPositiveInteger(HttpServletRequest request, String param) {
        int reuslt = 0;
        String p = formatString(request, param);
        if (p.length() == 0) {
            return 0;
        }
        if (StringUtils.isNumeric(p) && StringUtils.isNotEmpty(p)) {
            reuslt = Integer.parseInt(p);
        }
        if (reuslt < 0) {
            return 0;
        }
        return reuslt;
    }
    
    public static void main(String[] args) {
		
    	//String adInfo = "eyJTS0lQIjoxLCJQUyI6MCwiUkVRSUQiOiIwYmVmYTQ1MTAwMDA1MmE1NWIxNjUyZGQwMDAwMDAzNCIsIkZMT1dFWFAiOnsiREVFUExJTksiOiJBIn0sIlAiOjcsIlZFUiI6IjMuMCIsIlZBTCI6W3siTUsiOjAsIlJTIjoiaHR0cDovL3ZhbGkuY3AzMS5vdHQuY2libnR2Lm5ldC95b3VrdS82Nzc2OEE1QUQ2QTM4NzE2NDQwN0UyMDM3LzAzMDAwODAxMDA1OUE2NzJFMjU0QkEwMDNFODgwM0NBREY4MjBGLTg0RDMtRDMxMi1GQ0U3LTNBOUFGRjYzNDA4Ri5tcDQ/c2lkPTA1MjgxODg2Mjk1NTIxNTUyNTAwOV8wMF9BZjY1YjdjYTA4YmViZDgxY2VjY2NiYTBlMTFhZDVlZGMmc2lnbj04ZjEwYjk0NjZjZjk1NmFkM2Y1MzBkNTdkZWI3MjFmYyZjdHlwZT01MCZoZD0xIiwiVyI6MjAsIlZOIjoiIiwiU0hVIjpbXSwiQlJTIjoiIiwiU1UiOltdLCJTREtJRCI6MCwiQVQiOjcwLCJWU0MiOiIiLCJDVSI6Imh0dHA6Ly95a3RkLm0uY24ubWlhb3poZW4uY29tL3Ivaz0yMDE3MjEwJnA9Nno4RmwmZHg9MCZydD0yJm5zPTIxMS4xNTcuMTcxLjIyNiZuaT1ZT1VUVV8xMDAwMDAxNzY0XzY2NjY2Nzg0MCZ2PV9fTE9DX18mbmQ9X19EUkFfXyZucD1fX1BPU19fJm5uPV9fQVBQX18mdm89MzI0ZDcxMzQwJnZyPTImbz1odHRwOi8vZ3hici5jbnp6LmNvbS9yLnBocD90PWh0dHAlM0ElMkYlMkZtb2JpbGUudG1hbGwuY29tJTJGbW9iaWxlJTJGcGFnZSUyRmxsYiUzRnNoYXJlaWQlM0Q2MTU4MTE5MiUyNl9iaW5kJTNEdHJ1ZSUyNmFzYWMlM0RENUpKRlc3MTYxMDNYT0xSUzJPWCUyNmxwaWQlM0Q5NzgxMSUyNmxwdCUzRDElMjZsc2lkJTNEMjA2NDg5MjgyNyUyNm1tX2d4YmlkJTNEMV8yMjcwMTZfMWZhMTJiMmVlYjJmNjY3NGVlOWZjODMxNmJiNDIzNmUmdj05Yjc3MGE3YzY1NzglMjZhbGlfdHJhY2tpZD03MF8wYmVmYTQ1MTAwMDA1MmE1NWIxNjUyZGQwMDAxMDAzNCIsIlNVRSI6W3siU0RLIjoiMCIsIlUiOiJodHRwOi8vZW1zLnlvdWt1LmNvbS9ldmVudD9lPXRhMVpUekpWeWJCeV9wMUhWVWVPRlhlZEFaR0N1dzZ0ZFctd29pbDlwMU5ya205ZkhRYmJ5SWRJVk1KM0MwemZKRk9TY0FHaTJ5MzEzQU1FZ1BuVUpOY2hwWVF4T1dzTkZSX21TNkRrNkQxYks4ckhHdFZFdjhpZUd5REdkbWwxb0dvOEVfbWpOUTBHWU9tMUt0eGNTSEtEQW45MmY3akZHRHhfNEswSG95ZEZpUmQtOGctVFExZlVPdWlxU1ZLVE9KVTRMWk9wUFRtcXJQZU51dW14d3NZUXg3VDVoQ2ZGYS0zY0lrM2lRQzRaUkxzUzR4aTNXMFZUMk83cU9TcVBNSzNEdThxdVRtNjFLbHQ2Y040NzU3VFhBWGRSdjEtVmRtTnRENWtZNXhIR1N6Q0NjWFU3SlJMYjNhR09TWnNpR1pNT3FTb29NOTRqeE5WclA3dUkwYW1kckFCeVc3eWNpbUhKQlpzSV8yR05nLTVIdW8yQmNKM014Vmt3OXoxSSZwaWQ9NjAwMDYmaHRjaD1fX2h0Y2hfXyZ2ZT0xNSJ9LHsiU0RLIjoiMCIsIlUiOiJodHRwOi8vdmFsLmF0bS55b3VrdS5jb20vb3Zlcj92PTEwMTUwJmN0PWxpdmUxJmFpZGlmPTM2MGE3MTU1ZjMxNzdjYzdlODcwZDNiNThhYWFjYTM2JmNzPSZjYT0xMDAwMDAxNzY0JmllPTY2NjY2Nzg0MCZ1aWQ9MTQwNjUwMTkwMyZjaz1CNTUyMDMyMC0xMUYzLTQ5QzMtOEI0RC04QkQ1MTA3RkIwNEUmYWw9MTUmYmw9MSZzPTEwODkzODcmdGQ9JnN0PTEmdmw9NjAwLjAmYXA9MiZuYXA9NjAwMDYmbnBvPTYwMDA2JmRjPTAmc2lkPTZhMjkyOGZmMTVmZjQ5ZjdhZjJiYmFkOTQxNmI2MTZmJmNyPTEmcHI9MSZvaWR0eXBlPTE0MDMwMyU3QzAmZHE9Zmx2JTdDbXA0JnVyaT0mYmFrPTAmcGM9MTAwJm9uZWlkPSZlZmY9MSZhZHNpZD0xNTI4MTg5NjYxMjk1MDkxODIwNjQmYmQ9YXBwbGUmbWRsPWlQaG9uZTklMkMyJnRhZz0mYWNpcD0xMDYuMTEuMzQuMyZpcD0xMS4yMzkuMTEwLjk2Jmh0Y2g9X19odGNoX18mdHA9NSZwcnA9MSZyZXFpZD0wYmVmYTQ1MTAwMDA1MmE1NWIxNjUyZGQwMDAwMDAzNCZwaWQ9NjRiNjg0N2U5OTJjNGM0NSZhbGlpZD1XY3RqeXE0YW5jOERBSXVXZ1NaTVp2Q1gmcG89MSZ5aWQ9JnNleD0mYWdlPSZkdnc9MCZkdmg9MjIwOCZvc3Y9MTEuMyZuZXQ9MTAwMCZ2cj0wJmxpZD04MDAwMDgwJnNyPSZwYWlkPWZhbHNlJm9pZD0xNDAzMDMmYXRpZD0wJnJlc3Q9MzUmcHZlcj0mc3Zlcj0xLjAuMjgmZnU9MCZ2aXQ9MiZzYz0mc2NpdGlkPSZnZD0mZmxvd21hcms9JnZwPSZhcHBjPSZ3aW50PW1kZXZpY2UmcGx0eXBlPSZhYnQ9JnNraXA9MCZzYXZzPSZvcz0wJmR0PTEmYXZzPTcuMi41Ljk5OSZhbj0mY2lkPSZvbGRCdWNrZXRQYXRoPSZidWNrZXRQYXRoPSZpc0NwbT0wJmlzVGllUGlhbj0xJnBzPTAmcHA9NyZhZHZpZD03NDk1NTcxNzEmbWI9MSZhdz1hJnZjPTAmaWRmYT1CNTUyMDMyMC0xMUYzLTQ5QzMtOEI0RC04QkQ1MTA3RkIwNEUmb3VpZD0xYjIyNGM3N2EwZDhlMWJiNTc5NzBiYmFjNGVjY2IwYjEzMWU3ZWZkJm1hYz0maW09JmFpZD0mZ3VpZD03MDY2NzA3YzViZGMzOGFmMTYyMWVhZjk0YTZmZTc3OSZzcz0wLjAmbG90PSZsYXQ9JmlzcGNvZGU9JnV1aWQ9JmJveD0mZXR5cGU9MzAwIn0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly90LmNyLW5pZWxzZW4uY29tL2hhdD9fdD1pJl9odHNpbmZvPVNTWXlKamd3TURBd01ESTFKakV3TURBMU9EYzBKak13TVRBeE56a3lKclNyIn1dLCJQU1QiOjIsIkNVVSI6IiIsIlNVUiI6W10sIlZJRCI6Ijc0OTU1NzE3MSIsIlZRVCI6Im1wNCIsIkgiOjEwLCJEU1BOQU1FIjoiIiwiU1VQIjpbXSwiVkMiOiIiLCJBTEciOiIiLCJFRiI6MSwiQ1VNIjpbeyJTREsiOiIwIiwiVSI6Imh0dHA6Ly9lbXMueW91a3UuY29tL2NsaWNrP2U9aTBOWTR2R1k2bGpEcl9jOFJBLTN3WV9ZbWhCTFRpUVVRRXQ4MldwZHA1OE9YaXVxSzhCWURfbFBtbFozYVc2dDlMQ0ZWOGxnOGlYMGxtSkN4cGVGM0padnIwQml5SDRNeTV3bFJVbmYxNmxxeGZSTk4zMWZjdXhYU3NTSmtOSXFGdWpKbUIxOHhrSkMtcXhoYUE5VnJRM0I1TnNOQ3hzY0k4MUs0ejVEdktpQWI2cEVFd1c2ZTFMUjFpZnhhS0VqeHFLY3JlSUI2bmg2cTFNSGljNWlsUmtfN1JCdlcxWWFjVlNIQl9LZFhPa05MUHBpczJqYjBxbVVCcFhUVmhRSlh1VS0xSmNkYmxaN3V1ODc2V0dad2FhcnBuYW5qTExqZExha2VNbVljcEdvUGxLeURzYmlIUWllbWVJV2xUMnROM0xVb1NSMGFPLUZUUUVoSzZia0pydnU3VElLNF9tS3JnUk9RVXVtajhPSS01UkFMS1hXQ2FYM01QSV9FUUpBJnBpZD02MDAwNiZodGNoPV9faHRjaF9fJmFsaV90cmFja2lkPTcwXzBiZWZhNDUxMDAwMDUyYTU1YjE2NTJkZDAwMDEwMDM0In0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly92eWsuYWRtYXN0ZXIuY29tLmNuL2kvYTEyNjY4LGIyMDAyMTIwNjksYzI4NjQsaTAsbTIwMixoIn0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly95a3RkLm0uY24ubWlhb3poZW4uY29tL3Ivaz0yMDA0ODMwJnA9NnNqSk4mYWU9MTAwMDk2OCZkeD0wJnJ0PTImbnM9MTA2LjExLjM0LjMmbmk9WU9VVFVfMTAwMDAwMTc2NF82NjY2Njc4NDAmdj1fX0xPQ19fJnZvPTM4N2U2Y2VjYyYmdnI9MiZvPSJ9LHsiU0RLIjoiMCIsIlUiOiJodHRwOi8vdmFsLmF0bS55b3VrdS5jb20vY2xpY2s/dj0xMDE1MCZjdD1saXZlMSZhaWRpZj0zNjBhNzE1NWYzMTc3Y2M3ZTg3MGQzYjU4YWFhY2EzNiZjcz0mY2E9MTAwMDAwMTc2NCZpZT02NjY2Njc4NDAmdWlkPTE0MDY1MDE5MDMmY2s9QjU1MjAzMjAtMTFGMy00OUMzLThCNEQtOEJENTEwN0ZCMDRFJmFsPTE1JmJsPTEmcz0xMDg5Mzg3JnRkPSZzdD0xJnZsPTYwMC4wJmFwPTImbmFwPTYwMDA2Jm5wbz02MDAwNiZkYz0wJnNpZD02YTI5MjhmZjE1ZmY0OWY3YWYyYmJhZDk0MTZiNjE2ZiZjcj0xJnByPTEmb2lkdHlwZT0xNDAzMDMlN0MwJmRxPWZsdiU3Q21wNCZ1cmk9JmJhaz0wJnBjPTEwMCZvbmVpZD0mZWZmPTEmYWRzaWQ9MTUyODE4OTY2MTI5NTA5MTgyMDY0JmJkPWFwcGxlJm1kbD1pUGhvbmU5JTJDMiZ0YWc9JmFjaXA9MTA2LjExLjM0LjMmaXA9MTEuMjM5LjExMC45NiZodGNoPV9faHRjaF9fJnRwPTUmcHJwPTEmcmVxaWQ9MGJlZmE0NTEwMDAwNTJhNTViMTY1MmRkMDAwMDAwMzQmcGlkPTY0YjY4NDdlOTkyYzRjNDUmYWxpaWQ9V2N0anlxNGFuYzhEQUl1V2dTWk1adkNYJnBvPTEmeWlkPSZzZXg9JmFnZT0mZHZ3PTAmZHZoPTIyMDgmb3N2PTExLjMmbmV0PTEwMDAmdnI9MCZsaWQ9ODAwMDA4MCZzcj0mcGFpZD1mYWxzZSZvaWQ9MTQwMzAzJmF0aWQ9MCZyZXN0PTM1JnB2ZXI9JnN2ZXI9MS4wLjI4JmZ1PTAmdml0PTImc2M9JnNjaXRpZD0mZ2Q9JmZsb3dtYXJrPSZ2cD0mYXBwYz0md2ludD1tZGV2aWNlJnBsdHlwZT0mYWJ0PSZza2lwPTAmc2F2cz0mb3M9MCZkdD0xJmF2cz03LjIuNS45OTkmYW49JmNpZD0mb2xkQnVja2V0UGF0aD0mYnVja2V0UGF0aD0maXNDcG09MCZpc1RpZVBpYW49MSZwcz0wJnBwPTcmYWR2aWQ9NzQ5NTU3MTcxJm1iPTEmYXc9YSZ2Yz0wJmlkZmE9QjU1MjAzMjAtMTFGMy00OUMzLThCNEQtOEJENTEwN0ZCMDRFJm91aWQ9MWIyMjRjNzdhMGQ4ZTFiYjU3OTcwYmJhYzRlY2NiMGIxMzFlN2VmZCZtYWM9JmltPSZhaWQ9Jmd1aWQ9NzA2NjcwN2M1YmRjMzhhZjE2MjFlYWY5NGE2ZmU3Nzkmc3M9MC4wJmxvdD0mbGF0PSZpc3Bjb2RlPSZ1dWlkPSZib3g9JmFsaV90cmFja2lkPTcwXzBiZWZhNDUxMDAwMDUyYTU1YjE2NTJkZDAwMDEwMDM0JmV0eXBlPTIwMCJ9XSwiVlAiOjAsIlBSViI6MCwiQ1VGIjoxLCJJRSI6IjY2NjY2Nzg0MCIsIlZEVCI6IiIsIlNVUyI6W3siU0RLIjoiMCIsIlUiOiJodHRwOi8vZW1zLnlvdWt1LmNvbS9pbXA/ZT10YTFaVHpKVnliQnlfcDFIVlVlT0ZYZWRBWkdDdXc2dGRXLXdvaWw5cDFNT1hpdXFLOEJZRF9sUG1sWjNhVzZ0OUxDRlY4bGc4aVgwbG1KQ3hwZUYzT1JLSU5rYkNPSFpRS3VDUllTcGVQVE45YTVic0ljdWx2UzVYR0hXT3VER3NUOFpQVXZmM2JQcXFycXAxRms3T0VMOHJjVFJFUFdManBuR0xGTGFvRFBnS1oxRmNfa2FYRXFJVWN4WUExa2hmRk02UEFWLVVpdmN3dXVIbHM0NG14LXFTdFVyNG15eVYtSmpZdHlodXBMV2xNQ09lOWRoazFoZE5oeTVYVkJFZzhzQWZjUFh5aDBDa2FocXRKWURPRjMzT2syYXpMUGFuaElJRG5PazNDVHRaVmpGd0Q5c01FN3VPbklIaC00TDdJcW1tS1B1UTdQdjB1ejRRMnNtcmFPZWNVb2RpQ195QVNGeGdfZ3VXdDBiNUVPWEVIWTc5dU5lVkt6NS1oUXomcGlkPTYwMDA2Jmh0Y2g9X19odGNoX18ifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL3ZhbC5hdG0ueW91a3UuY29tL3Nob3c/dj0xMDE1MCZjdD1saXZlMSZhaWRpZj0zNjBhNzE1NWYzMTc3Y2M3ZTg3MGQzYjU4YWFhY2EzNiZjcz0mY2E9MTAwMDAwMTc2NCZpZT02NjY2Njc4NDAmdWlkPTE0MDY1MDE5MDMmY2s9QjU1MjAzMjAtMTFGMy00OUMzLThCNEQtOEJENTEwN0ZCMDRFJmFsPTE1JmJsPTEmcz0xMDg5Mzg3JnRkPSZzdD0xJnZsPTYwMC4wJmFwPTImbmFwPTYwMDA2Jm5wbz02MDAwNiZkYz0wJnNpZD02YTI5MjhmZjE1ZmY0OWY3YWYyYmJhZDk0MTZiNjE2ZiZjcj0xJnByPTEmb2lkdHlwZT0xNDAzMDMlN0MwJmRxPWZsdiU3Q21wNCZ1cmk9JmJhaz0wJnBjPTEwMCZvbmVpZD0mZWZmPTEmYWRzaWQ9MTUyODE4OTY2MTI5NTA5MTgyMDY0JmJkPWFwcGxlJm1kbD1pUGhvbmU5JTJDMiZ0YWc9JmFjaXA9MTA2LjExLjM0LjMmaXA9MTEuMjM5LjExMC45NiZodGNoPV9faHRjaF9fJnRwPTUmcHJwPTEmcmVxaWQ9MGJlZmE0NTEwMDAwNTJhNTViMTY1MmRkMDAwMDAwMzQmcGlkPTY0YjY4NDdlOTkyYzRjNDUmYWxpaWQ9V2N0anlxNGFuYzhEQUl1V2dTWk1adkNYJnBvPTEmeWlkPSZzZXg9JmFnZT0mZHZ3PTAmZHZoPTIyMDgmb3N2PTExLjMmbmV0PTEwMDAmdnI9MCZsaWQ9ODAwMDA4MCZzcj0mcGFpZD1mYWxzZSZvaWQ9MTQwMzAzJmF0aWQ9MCZyZXN0PTM1JnB2ZXI9JnN2ZXI9MS4wLjI4JmZ1PTAmdml0PTImc2M9JnNjaXRpZD0mZ2Q9JmZsb3dtYXJrPSZ2cD0mYXBwYz0md2ludD1tZGV2aWNlJnBsdHlwZT0mYWJ0PSZza2lwPTAmc2F2cz0mb3M9MCZkdD0xJmF2cz03LjIuNS45OTkmYW49JmNpZD0mb2xkQnVja2V0UGF0aD0mYnVja2V0UGF0aD0maXNDcG09MCZpc1RpZVBpYW49MSZwcz0wJnBwPTcmYWR2aWQ9NzQ5NTU3MTcxJm1iPTEmYXc9YSZ2Yz0wJmlkZmE9QjU1MjAzMjAtMTFGMy00OUMzLThCNEQtOEJENTEwN0ZCMDRFJm91aWQ9MWIyMjRjNzdhMGQ4ZTFiYjU3OTcwYmJhYzRlY2NiMGIxMzFlN2VmZCZtYWM9JmltPSZhaWQ9Jmd1aWQ9NzA2NjcwN2M1YmRjMzhhZjE2MjFlYWY5NGE2ZmU3Nzkmc3M9MC4wJmxvdD0mbGF0PSZpc3Bjb2RlPSZ1dWlkPSZib3g9JmVyZD0wYmVmYTQ1MTAwMDA1MmE1NWIxNjUyZGQwMDAxMDAzNCJ9LHsiU0RLIjoiMCIsIlUiOiJodHRwOi8veWt0ZC5tLmNuLm1pYW96aGVuLmNvbS94L2s9MjAwOTU5OCZwPTZ3N1M0JmR4PTAmcnQ9MiZucz0xMDYuMTEuMzQuMyZuaT1ZT1VUVV8xMDAwMDAxNzY0XzY2NjY2Nzg0MCZ2PV9fTE9DX18mbmQ9X19EUkFfXyZucD1fX1BPU19fJm5uPV9fQVBQX18mbz0ifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL3lrdGQubS5jbi5taWFvemhlbi5jb20veC9rPTIwMDQ4MzAmcD02c2pKTiZkeD0wJnJ0PTImbnM9MTA2LjExLjM0LjMmbmk9WU9VVFVfMTAwMDAwMTc2NF82NjY2Njc4NDAmdj1fX0xPQ19fJm89In0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly9pcG0uYXRtLnlvdWt1LmNvbS9pcG0/ZGV2aWQ9NDE5MDMzYTY3MWI4M2JmZWU2M2NmOGZlYmNlNzY0NzYmaWQ9MGJlZmE0NTEwMDAwNTJhNTViMTY1MmRkMDAwMDAwMzQmcD03JnJ0PTM1In1dLCJSU1QiOiJ2aWRlbyIsIkFUWCI6IiIsIkFMIjoxNSwiVlQiOjB9LHsiTUsiOjAsIlJTIjoiaHR0cDovL3ZhbGkuY3AzMS5vdHQuY2libnR2Lm5ldC95b3VrdS82OTcyOTlGMEY3MjM5NzE2QUJBQkQ1MENFLzAzMDAwODAxMDA1OUJCNTFGNzIyQUQwMDNFODgwM0Y0NDY0MjJDLUM0OEUtNTE5RS0zQTkyLUQ2M0Y2NzgzQTAzQi5tcDQ/c2lkPTA1MjgxODk1MjcwNjcxMDY3NDQ5M18wMF9BMTYwZDE5NTFjODZiZDIwYWFlY2ZmYjkyYWI1MDZjODYmc2lnbj0xYWFhOTA0ODI1ZDQwNjdjYWRmODU0ZGE4NjU1ZWI0ZCZjdHlwZT01MCZoZD0xIiwiVyI6MjAsIlZOIjoiIiwiU0hVIjpbXSwiQlJTIjoiIiwiU1UiOltdLCJTREtJRCI6MCwiQVQiOjcwLCJWU0MiOiIiLCJDVSI6Imh0dHA6Ly95a3RkLm0uY24ubWlhb3poZW4uY29tL3Ivaz0yMDE3MjEwJnA9Nno4RmwmZHg9MCZydD0yJm5zPTIxMS4xNTcuMTcxLjIyNiZuaT1ZT1VUVV8xMDAwMDAxNzYzXzY2NjY2NzgzOSZ2PV9fTE9DX18mbmQ9X19EUkFfXyZucD1fX1BPU19fJm5uPV9fQVBQX18mdm89MzI0ZDcxMzQwJnZyPTImbz1odHRwOi8vZ3hici5jbnp6LmNvbS9yLnBocD90PWh0dHAlM0ElMkYlMkZtb2JpbGUudG1hbGwuY29tJTJGbW9iaWxlJTJGcGFnZSUyRmxsYiUzRnNoYXJlaWQlM0Q2MTU4MTE5MiUyNl9iaW5kJTNEdHJ1ZSUyNmFzYWMlM0RENUpKRlc3MTYxMDNYT0xSUzJPWCUyNmxwaWQlM0Q5NzgxMSUyNmxwdCUzRDElMjZsc2lkJTNEMjA2NDg5MjgyNyUyNm1tX2d4YmlkJTNEMV8yMjcwMTZfMWZhMTJiMmVlYjJmNjY3NGVlOWZjODMxNmJiNDIzNmUmdj05Yjc3MGE3YzY1NzglMjZhbGlfdHJhY2tpZD03MF8wYmVmYTQ1MTAwMDA1MmE1NWIxNjUyZGQwMDAyMDAzNCIsIlNVRSI6W3siU0RLIjoiMCIsIlUiOiJodHRwOi8vZW1zLnlvdWt1LmNvbS9ldmVudD9lPThNcElBckxibTh1TFRDdVNUdWItQlNLaXVDY2pNa1VKekxsX2owc1R4MEtxdVhNU1FhZXU1d3dPTnNYZDhVSk5sUnVnZmlVcTFlaGwwS01BUVJ5c0xCaUZWNDJmNWVQNFoyVzZVYkU4NEpTVkFacDJyZU15VGJWdm0xVTBoMVRJaDZNU1pJN3llSEp1dWswWnl2WEQ3UmVjZW1UMEF6eGJxSTY4eFJucXlkNnIwbHFzOVVEY3huV2FLaUVoeTNOQlJtVWYwRWZKQ2RpN0JGWHA4TjlSNUVDd1puYXhvVGJhVEhIOTNkYnphY3NXSlR2Y3k1bkU4SVN3bWJaWU5IcGtJME1PczNobk9zdVNYamI3c2Y0NmVEY2VMR0xFU1lEa2RqQWpZaWtfNERuWElfcXM1T0EtQ1lkY281YVZuejBONkJVaWdEWERWTDQ2QWl3eWoybGZrRGJoaFZ1RC1WZzVmQ2Ewb1dwOWtlUGZzelBIMXctV1V5UkNCWUU4ODk4QiZwaWQ9NjAwMzAmaHRjaD1fX2h0Y2hfXyZ2ZT0xNSJ9LHsiU0RLIjoiMCIsIlUiOiJodHRwOi8vdmFsLmF0bS55b3VrdS5jb20vb3Zlcj92PTEwMTUwJmN0PWxpdmUxJmFpZGlmPTM2MGE3MTU1ZjMxNzdjYzdlODcwZDNiNThhYWFjYTM2JmNzPSZjYT0xMDAwMDAxNzYzJmllPTY2NjY2NzgzOSZ1aWQ9MTQwNjUwMTkwMyZjaz1CNTUyMDMyMC0xMUYzLTQ5QzMtOEI0RC04QkQ1MTA3RkIwNEUmYWw9MTUmYmw9MSZzPTEwODkzODcmdGQ9JnN0PTEmdmw9NjAwLjAmYXA9MyZuYXA9NjAwMzAmbnBvPTYwMDMwJmRjPTAmc2lkPTZhMjkyOGZmMTVmZjQ5ZjdhZjJiYmFkOTQxNmI2MTZmJmNyPTEmcHI9MSZvaWR0eXBlPTE0MDMwMyU3QzAmZHE9Zmx2JTdDbXA0JnVyaT0mYmFrPTAmcGM9MTAwJm9uZWlkPSZlZmY9MSZhZHNpZD0xNTI4MTg5NjYxMjk1MDkxODIwNjQmYmQ9YXBwbGUmbWRsPWlQaG9uZTklMkMyJnRhZz0mYWNpcD0xMDYuMTEuMzQuMyZpcD0xMS4yMzkuMTEwLjk2Jmh0Y2g9X19odGNoX18mdHA9NSZwcnA9MSZyZXFpZD0wYmVmYTQ1MTAwMDA1MmE1NWIxNjUyZGQwMDAwMDAzNCZwaWQ9NjRiNjg0N2U5OTJjNGM0NSZhbGlpZD1XY3RqeXE0YW5jOERBSXVXZ1NaTVp2Q1gmcG89MiZ5aWQ9JnNleD0mYWdlPSZkdnc9MCZkdmg9MjIwOCZvc3Y9MTEuMyZuZXQ9MTAwMCZ2cj0wJmxpZD04MDAwMDgwJnNyPSZwYWlkPWZhbHNlJm9pZD0xNDAzMDMmYXRpZD0wJnJlc3Q9MzUmcHZlcj0mc3Zlcj0xLjAuMjgmZnU9MCZ2aXQ9MiZzYz0mc2NpdGlkPSZnZD0mZmxvd21hcms9JnZwPSZhcHBjPSZ3aW50PW1kZXZpY2UmcGx0eXBlPSZhYnQ9JnNraXA9MCZzYXZzPSZvcz0wJmR0PTEmYXZzPTcuMi41Ljk5OSZhbj0mY2lkPSZvbGRCdWNrZXRQYXRoPSZidWNrZXRQYXRoPSZpc0NwbT0wJmlzVGllUGlhbj0xJnBzPTAmcHA9NyZhZHZpZD03NTYyNTIyMjEmbWI9MSZhdz1hJnZjPTAmaWRmYT1CNTUyMDMyMC0xMUYzLTQ5QzMtOEI0RC04QkQ1MTA3RkIwNEUmb3VpZD0xYjIyNGM3N2EwZDhlMWJiNTc5NzBiYmFjNGVjY2IwYjEzMWU3ZWZkJm1hYz0maW09JmFpZD0mZ3VpZD03MDY2NzA3YzViZGMzOGFmMTYyMWVhZjk0YTZmZTc3OSZzcz0wLjAmbG90PSZsYXQ9JmlzcGNvZGU9JnV1aWQ9JmJveD0mZXR5cGU9MzAwIn0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly90LmNyLW5pZWxzZW4uY29tL2hhdD9fdD1pJl9odHNpbmZvPVNTWXlKamd3TURBd01ESTFKakV3TURBMU9EYzBKak13TVRBeE56a3lKclNyIn1dLCJQU1QiOjMsIkNVVSI6IiIsIlNVUiI6W10sIlZJRCI6Ijc1NjI1MjIyMSIsIlZRVCI6Im1wNCIsIkgiOjEwLCJEU1BOQU1FIjoiIiwiU1VQIjpbXSwiVkMiOiIiLCJBTEciOiIiLCJFRiI6MSwiQ1VNIjpbeyJTREsiOiIwIiwiVSI6Imh0dHA6Ly9lbXMueW91a3UuY29tL2NsaWNrP2U9ZHFSTEVKd0JXbkRlTzRnN2o1NDNNaUtpdUNjak1rVUp6TGxfajBzVHgwTFZGNFhHLWZXYWR5b09YcnpCOU9hWGVNOTJaZWpsWFJzRzRsdTBRa19MczJrRlgzbGQwcGxYdllYV2JmbkRWaFNNWnZLMGZ1QmU4NXBYRUM2REpWTlhPVmROVmdYZ0NrNllkX3RnME1fUjNGcFpHc1NHVWRoTHdNSGlvLURFbjR1TUpQSzV3WTdhY3dmYkhZWXhfa2NVU0ZXQS12TnltVjk3ckJXUGpYUlNGWEJPM1ZENVRNSUZUZXdScUJRR0lMZHJmSVFYQWpIUmNaeGdVcWFyLVBTWm5IUHZUQkZvZElvb0hBbTJCQ2FFS1NPbi1jZDAtUHFUQ0gzSGVzRVQtVi1CSDFFSWVKVHNIWERNUWRKSUNnTGMxczFDeVgyY3ZUOGRUaE9nQk9OXy1VQWVXcmtHUnFtWWc1NWgwa3VyV2tLNjJ6Sm80LTRvc05LaHlSU0ptXzRxJnBpZD02MDAzMCZodGNoPV9faHRjaF9fJmFsaV90cmFja2lkPTcwXzBiZWZhNDUxMDAwMDUyYTU1YjE2NTJkZDAwMDIwMDM0In0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly92eWsuYWRtYXN0ZXIuY29tLmNuL2kvYTEyNjY4LGIyMDAyMTIwNjksYzI4NjQsaTAsbTIwMixoIn0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly95a3RkLm0uY24ubWlhb3poZW4uY29tL3Ivaz0yMDA0ODMwJnA9NnNqSk4mYWU9MTAwMDk2OCZkeD0wJnJ0PTImbnM9MTA2LjExLjM0LjMmbmk9WU9VVFVfMTAwMDAwMTc2M182NjY2Njc4Mzkmdj1fX0xPQ19fJnZvPTM4N2U2Y2VjYyYmdnI9MiZvPSJ9LHsiU0RLIjoiMCIsIlUiOiJodHRwOi8vdmFsLmF0bS55b3VrdS5jb20vY2xpY2s/dj0xMDE1MCZjdD1saXZlMSZhaWRpZj0zNjBhNzE1NWYzMTc3Y2M3ZTg3MGQzYjU4YWFhY2EzNiZjcz0mY2E9MTAwMDAwMTc2MyZpZT02NjY2Njc4MzkmdWlkPTE0MDY1MDE5MDMmY2s9QjU1MjAzMjAtMTFGMy00OUMzLThCNEQtOEJENTEwN0ZCMDRFJmFsPTE1JmJsPTEmcz0xMDg5Mzg3JnRkPSZzdD0xJnZsPTYwMC4wJmFwPTMmbmFwPTYwMDMwJm5wbz02MDAzMCZkYz0wJnNpZD02YTI5MjhmZjE1ZmY0OWY3YWYyYmJhZDk0MTZiNjE2ZiZjcj0xJnByPTEmb2lkdHlwZT0xNDAzMDMlN0MwJmRxPWZsdiU3Q21wNCZ1cmk9JmJhaz0wJnBjPTEwMCZvbmVpZD0mZWZmPTEmYWRzaWQ9MTUyODE4OTY2MTI5NTA5MTgyMDY0JmJkPWFwcGxlJm1kbD1pUGhvbmU5JTJDMiZ0YWc9JmFjaXA9MTA2LjExLjM0LjMmaXA9MTEuMjM5LjExMC45NiZodGNoPV9faHRjaF9fJnRwPTUmcHJwPTEmcmVxaWQ9MGJlZmE0NTEwMDAwNTJhNTViMTY1MmRkMDAwMDAwMzQmcGlkPTY0YjY4NDdlOTkyYzRjNDUmYWxpaWQ9V2N0anlxNGFuYzhEQUl1V2dTWk1adkNYJnBvPTImeWlkPSZzZXg9JmFnZT0mZHZ3PTAmZHZoPTIyMDgmb3N2PTExLjMmbmV0PTEwMDAmdnI9MCZsaWQ9ODAwMDA4MCZzcj0mcGFpZD1mYWxzZSZvaWQ9MTQwMzAzJmF0aWQ9MCZyZXN0PTM1JnB2ZXI9JnN2ZXI9MS4wLjI4JmZ1PTAmdml0PTImc2M9JnNjaXRpZD0mZ2Q9JmZsb3dtYXJrPSZ2cD0mYXBwYz0md2ludD1tZGV2aWNlJnBsdHlwZT0mYWJ0PSZza2lwPTAmc2F2cz0mb3M9MCZkdD0xJmF2cz03LjIuNS45OTkmYW49JmNpZD0mb2xkQnVja2V0UGF0aD0mYnVja2V0UGF0aD0maXNDcG09MCZpc1RpZVBpYW49MSZwcz0wJnBwPTcmYWR2aWQ9NzU2MjUyMjIxJm1iPTEmYXc9YSZ2Yz0wJmlkZmE9QjU1MjAzMjAtMTFGMy00OUMzLThCNEQtOEJENTEwN0ZCMDRFJm91aWQ9MWIyMjRjNzdhMGQ4ZTFiYjU3OTcwYmJhYzRlY2NiMGIxMzFlN2VmZCZtYWM9JmltPSZhaWQ9Jmd1aWQ9NzA2NjcwN2M1YmRjMzhhZjE2MjFlYWY5NGE2ZmU3Nzkmc3M9MC4wJmxvdD0mbGF0PSZpc3Bjb2RlPSZ1dWlkPSZib3g9JmFsaV90cmFja2lkPTcwXzBiZWZhNDUxMDAwMDUyYTU1YjE2NTJkZDAwMDIwMDM0JmV0eXBlPTIwMCJ9XSwiVlAiOjAsIlBSViI6MCwiQ1VGIjoxLCJJRSI6IjY2NjY2NzgzOSIsIlZEVCI6IiIsIlNVUyI6W3siU0RLIjoiMCIsIlUiOiJodHRwOi8vZW1zLnlvdWt1LmNvbS9pbXA/ZT04TXBJQXJMYm04dUxUQ3VTVHViLUJTS2l1Q2NqTWtVSnpMbF9qMHNUeDBMVkY0WEctZldhZHlvT1hyekI5T2FYWFJWR3ozdlMtRG9OQlRsLXktRlQ2VkxORHRMUzF5ZllYTGlWTXZPWkw2b2JfVlFZOHdxZmdyUkZyN081Y2RJNHEybGFXaTRzQjNjS2lTZjExSHZiY0RNdzdSckZ3Q1dhNDM0eWlQaU1wdHU0aEVxTUZRSHplNHBHVktGUFAwblBKQ0h5SHBiM2VFUlU3RXFISVZhSG4yZ2Q2LVNLRF92VHp0VFpnbnY2OWFIdUhHMjNtOWJOa2stSWJDUGQ2UVI1M1hoRWYyeUNSeDVXT1U1dnhwNkNEenJBdVNnb1Nzc256OG5xWnJYNVBXc2N4UE9uM0YycGdPdjNzSHNiQ1FidHdpT0ZUWlRCRWZKZFgxS28zWjNpbGNTNUctZHlISUpWR3EwVUZ4N21abVBRbnZCUExNNDVCRXM3LVRHbFpfd0omcGlkPTYwMDMwJmh0Y2g9X19odGNoX18ifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL3ZhbC5hdG0ueW91a3UuY29tL3Nob3c/dj0xMDE1MCZjdD1saXZlMSZhaWRpZj0zNjBhNzE1NWYzMTc3Y2M3ZTg3MGQzYjU4YWFhY2EzNiZjcz0mY2E9MTAwMDAwMTc2MyZpZT02NjY2Njc4MzkmdWlkPTE0MDY1MDE5MDMmY2s9QjU1MjAzMjAtMTFGMy00OUMzLThCNEQtOEJENTEwN0ZCMDRFJmFsPTE1JmJsPTEmcz0xMDg5Mzg3JnRkPSZzdD0xJnZsPTYwMC4wJmFwPTMmbmFwPTYwMDMwJm5wbz02MDAzMCZkYz0wJnNpZD02YTI5MjhmZjE1ZmY0OWY3YWYyYmJhZDk0MTZiNjE2ZiZjcj0xJnByPTEmb2lkdHlwZT0xNDAzMDMlN0MwJmRxPWZsdiU3Q21wNCZ1cmk9JmJhaz0wJnBjPTEwMCZvbmVpZD0mZWZmPTEmYWRzaWQ9MTUyODE4OTY2MTI5NTA5MTgyMDY0JmJkPWFwcGxlJm1kbD1pUGhvbmU5JTJDMiZ0YWc9JmFjaXA9MTA2LjExLjM0LjMmaXA9MTEuMjM5LjExMC45NiZodGNoPV9faHRjaF9fJnRwPTUmcHJwPTEmcmVxaWQ9MGJlZmE0NTEwMDAwNTJhNTViMTY1MmRkMDAwMDAwMzQmcGlkPTY0YjY4NDdlOTkyYzRjNDUmYWxpaWQ9V2N0anlxNGFuYzhEQUl1V2dTWk1adkNYJnBvPTImeWlkPSZzZXg9JmFnZT0mZHZ3PTAmZHZoPTIyMDgmb3N2PTExLjMmbmV0PTEwMDAmdnI9MCZsaWQ9ODAwMDA4MCZzcj0mcGFpZD1mYWxzZSZvaWQ9MTQwMzAzJmF0aWQ9MCZyZXN0PTM1JnB2ZXI9JnN2ZXI9MS4wLjI4JmZ1PTAmdml0PTImc2M9JnNjaXRpZD0mZ2Q9JmZsb3dtYXJrPSZ2cD0mYXBwYz0md2ludD1tZGV2aWNlJnBsdHlwZT0mYWJ0PSZza2lwPTAmc2F2cz0mb3M9MCZkdD0xJmF2cz03LjIuNS45OTkmYW49JmNpZD0mb2xkQnVja2V0UGF0aD0mYnVja2V0UGF0aD0maXNDcG09MCZpc1RpZVBpYW49MSZwcz0wJnBwPTcmYWR2aWQ9NzU2MjUyMjIxJm1iPTEmYXc9YSZ2Yz0wJmlkZmE9QjU1MjAzMjAtMTFGMy00OUMzLThCNEQtOEJENTEwN0ZCMDRFJm91aWQ9MWIyMjRjNzdhMGQ4ZTFiYjU3OTcwYmJhYzRlY2NiMGIxMzFlN2VmZCZtYWM9JmltPSZhaWQ9Jmd1aWQ9NzA2NjcwN2M1YmRjMzhhZjE2MjFlYWY5NGE2ZmU3Nzkmc3M9MC4wJmxvdD0mbGF0PSZpc3Bjb2RlPSZ1dWlkPSZib3g9JmVyZD0wYmVmYTQ1MTAwMDA1MmE1NWIxNjUyZGQwMDAyMDAzNCJ9LHsiU0RLIjoiMCIsIlUiOiJodHRwOi8veWt0ZC5tLmNuLm1pYW96aGVuLmNvbS94L2s9MjAwNDgzMCZwPTZzakpOJmR4PTAmcnQ9MiZucz0xMDYuMTEuMzQuMyZuaT1ZT1VUVV8xMDAwMDAxNzYzXzY2NjY2NzgzOSZ2PV9fTE9DX18mbz0ifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL3lrdGQubS5jbi5taWFvemhlbi5jb20veC9rPTIwMDk1OTgmcD02dzdTNCZkeD0wJnJ0PTImbnM9MTA2LjExLjM0LjMmbmk9WU9VVFVfMTAwMDAwMTc2M182NjY2Njc4Mzkmdj1fX0xPQ19fJm5kPV9fRFJBX18mbnA9X19QT1NfXyZubj1fX0FQUF9fJm89In1dLCJSU1QiOiJ2aWRlbyIsIkFUWCI6IiIsIkFMIjoxNSwiVlQiOjB9XSwiRkciOjB9";
    	String adInfo = "eyJ2aXBfdGlwcyI6eyJsYWJlbCI6IuS8muWRmOWFjeW5vyIsImxpbmsiOiJodHRwczovL2g1LnZpcC55b3VrdS5jb20vYnV5P3NjbT0yMDE0MDY5My4wLjIwMF82MTRfMTI0NS4wIn0sIlNLSVAiOjEsIlBTIjowLCJSRVFJRCI6IjBiOGUwZTVjMDAwMjk4OTA1YjE3NjgxNjAwMDAyYTg3IiwiRkxPV0VYUCI6eyJERVRBSUxTIjoiQyIsIkRFRVBMSU5LIjoiQiJ9LCJQIjo3LCJWRVIiOiIzLjAiLCJWQUwiOlt7Ik1LIjowLCJWUCI6MCwiUlMiOiJodHRwOi8vdmFsaS5jcDMxLm90dC5jaWJudHYubmV0L3lvdWt1LzY1NzMwNDg4NkMwNDc3MUM1NkU4RTRGNDQvMDMwMDA4MDEwMDVBRjUwOEY2QUZDRDAwM0U4ODAzRjlBOTYzQTktMjg1Qy1CQjkzLUJFQjItMjk0MDVDMzZGMTE2Lm1wND9zaWQ9MDUyODI1NzEzNTQzMTE0MzEyNDkzXzAwX0EyNjk4ZGE0ZjA5NzBjZTE1NDFlOWY2NzY2MDUwMzU2MyZzaWduPWVhMjU1ODk2YmQ1YjM4ZTAxNmZiNzM4MDUzYzQ5MTE5JmN0eXBlPTUwJmhkPTEiLCJXIjowLCJWTiI6IiIsIlZUIjowLCJTSFUiOltdLCJCUlMiOiIiLCJTVSI6W10sIlNES0lEIjowLCJBVCI6NzAsIlZTQyI6IiIsIkNVIjoiIiwiUlNUIjoidmlkZW8iLCJQU1QiOjIsIkNVVSI6IiIsIlZJRCI6Ijg5OTcwNDg2MCIsIlZRVCI6Im1wNCIsIkgiOjAsIkRTUE5BTUUiOiIiLCJWQyI6IiIsIkFMRyI6IiIsIkVGIjoxLCJTVVMiOlt7IlNESyI6IjAiLCJVIjoiaHR0cDovL2Vtcy55b3VrdS5jb20vaW1wP2U9c2pkWnQ1R2dYQ29xa1RNOUx0aWhpMFNzWTl0eFhBcXV6bW5va216QmluMzdFMlk3OTJJNWtTbmo3VU5JM2F5TENMSHlFYTNEN0J0QjRkUDIxR1FJdlNmcnlmemJqcHQzcDRQVTdJb3pMdkUwQ0drUlNneHBUY2gxTVNFZ1lPOHhzR2lHS0RiOU1RTHI0elYxOWVNanhKYUZwc2FEeTJOMW1xa0tma1labFJCVVdlTHZOMWRHZXR4X3liU1hpZmRxeFIyUmF2ckxZQUp3YWhoQl9YMkJhX2tFSzVsUHROSFhJdnM5eTVYa0U1R3k0aHYtcWxtNHFKY1pMSktmRlp6Q0toNFpyVkNpZ3M0c1BjLVdaRkJ4SFJqeC1RbXZXdVJFOVdqdjN2NUdrbWNTTzhFWU5mdGhIQXIxQlVmNjRJZnJCemxHUkJzMFNGSVZvNlJGU2MtdlpJMFlXWjRYWnJWeHJJTnM3UGZjLWVwWGZQZUYtLUw5dWdPd1B6Y25LLVgzeFlYdVUweE9STmVNd1RXa0xmdExBUXd3NjQtVm5YdngwLUhDV3BSREtJcEFzTUpMcVVPS0RRcXpRbDhiMXBKc1k0c21xXzA4NE9aWEpxZG5kckRIUV90ZkVocXRfOWNjTjVSYzk1SE1mRWMwWm55VkdadU15UVlXYjNDcVo3MGNmZkNjTHJONUZOLWp5bmlrWUVqb1dGR1o2bVhzX2VuRTlTRGFCc3A4cG5jUlZNanIyaTNnR1lVUUtGWWdaZF9Od0hOMXlFYlhkQmstaVF6SWpsb00zNHB5NzRCOGdYbzhxR0VWTVc4d2FWa0ZyX1p6dVc5RDE0bWxNenJHb0xJWEx2M2gxOUVQZzc0d2lWQkNwcG4yMFByU2YxM29RR3hqNW5IcnJzcC1ZaTdrdHZ6Y0drUnlZdnBzeFRDbElKanQmcGlkPTYwMDA2Jmh0Y2g9X19odGNoX18ifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL3ZhbC5hdG0ueW91a3UuY29tL3Nob3c/dj05MTA2NzcyMTgmY3Q9bGl2ZTEmYWlkaWY9NWIzZmFkMmUzOTJmMjg5MTgyNjk5OWM1NGMyN2FmY2MmY3M9JmNhPTUwODgwNjMmaWU9MzAwNjk1NyZ1aWQ9JmNrPTJFRTcxMkFGLUY3MkUtNDhDNS05NTIzLUZGMUY1NUQwQjk0NCZhbD0xNSZibD0xJnM9NDA1MTA4JnRkPSZzdD0xJnZsPTYwMC4wJmFwPTImbmFwPTYwMDA2Jm5wbz02MDAwNiZkYz0xMTQ4NjYzNCZzaWQ9YmFlMWMxM2VmZmZhNDM2MTk4YTc5OWZiNGU0ODI2NDcmY3I9MSZwcj0zNjgwJm9pZHR5cGU9MzAwNDgxNiU3QzAmZHE9YXV0byU3Q21wNCZ1cmk9JmJhaz0wJnBjPTQ5NTAmb25laWQ9JmVmZj0xJmFkc2lkPTE1MjgyNjA2MzAwOTM1OTM4NDgxMiZiZD1hcHBsZSZtZGw9aVBob25lMTAlMkMzJnRhZz0mYWNpcD0xMDYuMTEuMzQuMTkmaXA9MTEuMTM5LjExMy40MCZodGNoPV9faHRjaF9fJnRwPTImcHJwPTM0JnJlcWlkPTBiOGUwZTVjMDAwMjk4OTA1YjE3NjgxNjAwMDAyYTg3JnBpZD02NGI2ODQ3ZTk5MmM0YzQ1JmFsaWlkPVd1bEQ0UjZ6NU9rREFJUFhZaVFycFRZcyZwbz0xJnlpZD0mc2V4PSZhZ2U9JmR2dz0xMTI1JmR2aD0yNDM2Jm9zdj0xMS4zLjEmbmV0PTEwMDAmdnI9JmxpZD04MDAwODQyJnNyPSZwYWlkPWZhbHNlJm9pZD0zMDA0ODE2JmF0aWQ9MCZyZXN0PTM1JnB2ZXI9JnN2ZXI9MS4wLjI4JmZ1PTAmdml0PSZzYz0mc2NpdGlkPSZnZD0mZmxvd21hcms9YWR4X3BfYmlkJTNBZGVmYXVsdCU3Q2FkeF92X2JpZCUzQW1vZGVsdjMlN0NzZGtfdWUlM0FDJTdDYWR4X21peF9iaWQlM0FFJTdDYWRfZiUzQUIlN0NhZF91ZSUzQWRlZiU3Q3ltYiUzQWRlZiU3Q2FkY2xvc2UlM0FkZWZhdWx0JTdDY2FjaGVfb3B0JTNBQiU3Q2FkY3RyJTNBQiU3Q2RzcF9yYW5rJTNBQSU3Q2ZlZWQlM0FCJTdDcHJvJTNBQyU3Q2NsaWNrX3plcm8lM0FkZWZhdWx0JTdDZmVlZHNfc29ydF9hbGdvJTNBZXhwMyU3Q3lrZmVlZCUzQWRlZmF1bHQlN0NwYXVzZV9jbG9zZSUzQWRlZmF1bHQlN0NmZWVkX2RicCUzQUIlN0NhZHhfZGJwJTNBQSZ2cD0mYXBwYz0md2ludD1tZGV2aWNlJnBsdHlwZT0mYWJ0PSZza2lwPTAmc2F2cz0mb3M9MCZkdD0xJmF2cz03LjMuMi43MDUzOCZhbj0mY2lkPSZvbGRCdWNrZXRQYXRoPTItOCZidWNrZXRQYXRoPTItOCZpc0NwbT0xJmlzVGllUGlhbj0xJnBzPTAmcHA9NyZhZHZpZD04OTk3MDQ4NjAmbWI9MSZhdz1hJnZjPWZhbHNlJmlkZmE9MkVFNzEyQUYtRjcyRS00OEM1LTk1MjMtRkYxRjU1RDBCOTQ0Jm91aWQ9Y2Q2OWE3Y2UxODM0Y2I4ZWRhZDZhZGVlZWU4ZmJhNWE0NzIzYjdjMCZtYWM9JmltPSZhaWQ9Jmd1aWQ9NzA2NjcwN2M1YmRjMzhhZjE2MjFlYWY5NGE2ZmU3Nzkmc3M9MC4wJmxvdD0mbGF0PSZpc3Bjb2RlPUNVQ0MmdXVpZD0mYm94PSZlcmQ9MGI4ZTBlNWMwMDAyOTg5MDViMTc2ODE2MDAwMTJhODcifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL2lwbS5hdG0ueW91a3UuY29tL2lwbT9kZXZpZD0wYmY5MWNlNzQ2OGU0ZTNmYWJhZjRiOWQyZjZiNjhhNyZpZD0wYjhlMGU1YzAwMDI5ODkwNWIxNzY4MTYwMDAwMmE4NyZwPTcmcnQ9MzUifV0sIlBSViI6MCwiQ1VGIjowLCJWRFQiOiIiLCJDVU0iOlt7IlNESyI6IjAiLCJVIjoiaHR0cDovL2Vtcy55b3VrdS5jb20vY2xpY2s/ZT1aRkI1QnlwV3c0dDVIM3dsS1h3c1cxRGJpbE5HNk8tUUpEWlUxRktQd2xJR1ZDSi16RV81TkkxUEpYR0FiZlZVQzFWeWIyT2Q4U2dlY0hycTVxVldsaFU0TlVkZ3RTMEZIWi03WWVULUdFLTc2a3RIQWZxUDZ3anFIYnVvSXd5QmVxRFE2MkZmM05lMDRuaVR5NFZIQm9zWVEzSWpLaHVtemxhVHFpUVlwWEJRa2U5bXJadVI0c0NpVnZYVmNmdGM0aXgwd3prQk9jUWVkQlZZR1RXeTE1WVhhVHFKQTFpYXNFY2FOYlNfYjBsYXlrVmlDWHhwYk5ycFk1dG5YMmFnNVBSVkhScEpURG1uWGY0d1BhN1E0VjhQTHpSMVI2Ml9TZURBOHFpX3hSdmZHbGY5eEQ2OHREaVE2aEFYQ29PVElWTENRVDRULW5YSktKSHhKa3dwNlN0N0NmV0F4M181RjF5RHlQcFkwZHlBX2FQaGJ5OEpRN2dnM25QNktKckQ0d19fT1o3NjZLOGRCYUVraUhaeGtsMGpJa1YzS1FobEw0bGk4TFJSMllLM0JjLUpHTU1sLXZSSkxkbGVTUlpCc1pzQ0NkQ29Sa1dxUzdXRkhrUVdacDZyLXJfcUVfZkJpWVlEQTJKNGRacG9JcFN6WkpMb2FHOU8zUWVaN2tNdDBCaC1VYU5lWmNFWkNPU05DbDZ5UWhaTmNJejVMQkstS2N2YUg5SWdBUDhUNEZTYUhWOHNBQTI1Rm9RTjY0VlR0N2ZGZzdLODdfZXNBTk9IR2NrTEZYdHdMYjJhSThjOFRuUy1nMjRkVk1WbnNSMlI4cEZHSl9zX2xrYjkxMmJscmRYX1dwVmdFbTBKM0QzeUxiLXhDRWdMemR2R1BwTlpTWDdyUUpxcThQWGtzYWtMaDZBdWZseEE2X0tXSXljcWJGaUxENjJFZ0l3eTZyQzhoSUk5T1EmcGlkPTYwMDA2Jmh0Y2g9X19odGNoX18ifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL3ZhbC5hdG0ueW91a3UuY29tL2NsaWNrP3Y9OTEwNjc3MjE4JmN0PWxpdmUxJmFpZGlmPTViM2ZhZDJlMzkyZjI4OTE4MjY5OTljNTRjMjdhZmNjJmNzPSZjYT01MDg4MDYzJmllPTMwMDY5NTcmdWlkPSZjaz0yRUU3MTJBRi1GNzJFLTQ4QzUtOTUyMy1GRjFGNTVEMEI5NDQmYWw9MTUmYmw9MSZzPTQwNTEwOCZ0ZD0mc3Q9MSZ2bD02MDAuMCZhcD0yJm5hcD02MDAwNiZucG89NjAwMDYmZGM9MTE0ODY2MzQmc2lkPWJhZTFjMTNlZmZmYTQzNjE5OGE3OTlmYjRlNDgyNjQ3JmNyPTEmcHI9MzY4MCZvaWR0eXBlPTMwMDQ4MTYlN0MwJmRxPWF1dG8lN0NtcDQmdXJpPSZiYWs9MCZwYz00OTUwJm9uZWlkPSZlZmY9MSZhZHNpZD0xNTI4MjYwNjMwMDkzNTkzODQ4MTImYmQ9YXBwbGUmbWRsPWlQaG9uZTEwJTJDMyZ0YWc9JmFjaXA9MTA2LjExLjM0LjE5JmlwPTExLjEzOS4xMTMuNDAmaHRjaD1fX2h0Y2hfXyZ0cD0yJnBycD0zNCZyZXFpZD0wYjhlMGU1YzAwMDI5ODkwNWIxNzY4MTYwMDAwMmE4NyZwaWQ9NjRiNjg0N2U5OTJjNGM0NSZhbGlpZD1XdWxENFI2ejVPa0RBSVBYWWlRcnBUWXMmcG89MSZ5aWQ9JnNleD0mYWdlPSZkdnc9MTEyNSZkdmg9MjQzNiZvc3Y9MTEuMy4xJm5ldD0xMDAwJnZyPSZsaWQ9ODAwMDg0MiZzcj0mcGFpZD1mYWxzZSZvaWQ9MzAwNDgxNiZhdGlkPTAmcmVzdD0zNSZwdmVyPSZzdmVyPTEuMC4yOCZmdT0wJnZpdD0mc2M9JnNjaXRpZD0mZ2Q9JmZsb3dtYXJrPWFkeF9wX2JpZCUzQWRlZmF1bHQlN0NhZHhfdl9iaWQlM0Ftb2RlbHYzJTdDc2RrX3VlJTNBQyU3Q2FkeF9taXhfYmlkJTNBRSU3Q2FkX2YlM0FCJTdDYWRfdWUlM0FkZWYlN0N5bWIlM0FkZWYlN0NhZGNsb3NlJTNBZGVmYXVsdCU3Q2NhY2hlX29wdCUzQUIlN0NhZGN0ciUzQUIlN0Nkc3BfcmFuayUzQUElN0NmZWVkJTNBQiU3Q3BybyUzQUMlN0NjbGlja196ZXJvJTNBZGVmYXVsdCU3Q2ZlZWRzX3NvcnRfYWxnbyUzQWV4cDMlN0N5a2ZlZWQlM0FkZWZhdWx0JTdDcGF1c2VfY2xvc2UlM0FkZWZhdWx0JTdDZmVlZF9kYnAlM0FCJTdDYWR4X2RicCUzQUEmdnA9JmFwcGM9JndpbnQ9bWRldmljZSZwbHR5cGU9JmFidD0mc2tpcD0wJnNhdnM9Jm9zPTAmZHQ9MSZhdnM9Ny4zLjIuNzA1MzgmYW49JmNpZD0mb2xkQnVja2V0UGF0aD0yLTgmYnVja2V0UGF0aD0yLTgmaXNDcG09MSZpc1RpZVBpYW49MSZwcz0wJnBwPTcmYWR2aWQ9ODk5NzA0ODYwJm1iPTEmYXc9YSZ2Yz1mYWxzZSZpZGZhPTJFRTcxMkFGLUY3MkUtNDhDNS05NTIzLUZGMUY1NUQwQjk0NCZvdWlkPWNkNjlhN2NlMTgzNGNiOGVkYWQ2YWRlZWVlOGZiYTVhNDcyM2I3YzAmbWFjPSZpbT0mYWlkPSZndWlkPTcwNjY3MDdjNWJkYzM4YWYxNjIxZWFmOTRhNmZlNzc5JnNzPTAuMCZsb3Q9JmxhdD0maXNwY29kZT1DVUNDJnV1aWQ9JmJveD0mYWxpX3RyYWNraWQ9NzBfMGI4ZTBlNWMwMDAyOTg5MDViMTc2ODE2MDAwMTJhODcmZXR5cGU9MjAwIn1dLCJJRSI6IjMwMDY5NTciLCJTVUUiOlt7IlNESyI6IjAiLCJVIjoiaHR0cDovL2Vtcy55b3VrdS5jb20vZXZlbnQ/ZT1VWHZxSWdnTjlzR3VnQUVtOGhVYTRvUEZzNzc0alhLTmdEZUtPelJudjIxU3dOVVBTUi05VlpaSjRacWIweXlucm9IMTFXNm1JbHNZbW5iZmpFVnZ6T2R6dHlidVlPQXBHOUtndkE4VGxQOEE4cDUxN1pWYWYtVS1MMm9SbzNCYU1XN1AwNHlqNXVSNlVYcElLNzlQeGo1eFpUdVZnbS14Y2lQMjNXam8wVEllcVhLcjZDT1p1MWxFS2N2Z25ILWFfenRHWm9hbVdOa25WM2M0Q3RPQ3lxMzQxQk5KTE85WVM3SWNSRm11cFhqLVRuNExmZzFKVTZ2b1dNeWdKVUp5bEhGUVJIUDFBR2lTOHM1c3A1YnlqdVo4b2VmTVRSc1FuSC1TRGV5bnUyOE01bGhVRXZGd211TGxqNlZZMmczNHc1MnhUcWpCT091bTRYRVRoWFA4RThKQTJXR0lvUENmNUIwU195TVZKRXhkTC15M2E2QTZQbk1zTUlEcmtHbWJZb2s4MEZnVy10TkF4Z3FZejdPaFdBTEVGWEwydjBwOUVGNFNpY0poN3FyQ3Q4amRpQm9HUGo5ZF9iQXVYMU43bnJCSElPeDhSaWRjX3BzbXhQOFJ6dTgtQnVybF9CN1RRV0NWRWJVNllVTEF3ZzhLTGhoWHVac3NnNUdNMkstUGo4Z1dELW0zZnNwdFYwQXBhdnhyTzZsLThZalJlRE54QjdWblFDYzN4ZWl6bmxhQ1V1MTNKOWs3TEtELXhKeGo3eXBoWE5GSTU0VHZiTUF4NHZ1RklpTmd2QXI1d1FlVEtPdFlvTERQV29HdWxINVRYdm9QM2Y1NXlLMEtjdFRSUjEzN2d4ZkpsNldVOWlGWFVILTBBaFVUNXZ0TEtBWndOMGo4RE9HWUZ3YmRsbThJSmZmNG1heFJ3X29icHNrQ3FEX3ZRNkVBWmdsMXczU215ZU1uWkEmcGlkPTYwMDA2Jmh0Y2g9X19odGNoX18mdmU9MTUifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL3ZhbC5hdG0ueW91a3UuY29tL292ZXI/dj05MTA2NzcyMTgmY3Q9bGl2ZTEmYWlkaWY9NWIzZmFkMmUzOTJmMjg5MTgyNjk5OWM1NGMyN2FmY2MmY3M9JmNhPTUwODgwNjMmaWU9MzAwNjk1NyZ1aWQ9JmNrPTJFRTcxMkFGLUY3MkUtNDhDNS05NTIzLUZGMUY1NUQwQjk0NCZhbD0xNSZibD0xJnM9NDA1MTA4JnRkPSZzdD0xJnZsPTYwMC4wJmFwPTImbmFwPTYwMDA2Jm5wbz02MDAwNiZkYz0xMTQ4NjYzNCZzaWQ9YmFlMWMxM2VmZmZhNDM2MTk4YTc5OWZiNGU0ODI2NDcmY3I9MSZwcj0zNjgwJm9pZHR5cGU9MzAwNDgxNiU3QzAmZHE9YXV0byU3Q21wNCZ1cmk9JmJhaz0wJnBjPTQ5NTAmb25laWQ9JmVmZj0xJmFkc2lkPTE1MjgyNjA2MzAwOTM1OTM4NDgxMiZiZD1hcHBsZSZtZGw9aVBob25lMTAlMkMzJnRhZz0mYWNpcD0xMDYuMTEuMzQuMTkmaXA9MTEuMTM5LjExMy40MCZodGNoPV9faHRjaF9fJnRwPTImcHJwPTM0JnJlcWlkPTBiOGUwZTVjMDAwMjk4OTA1YjE3NjgxNjAwMDAyYTg3JnBpZD02NGI2ODQ3ZTk5MmM0YzQ1JmFsaWlkPVd1bEQ0UjZ6NU9rREFJUFhZaVFycFRZcyZwbz0xJnlpZD0mc2V4PSZhZ2U9JmR2dz0xMTI1JmR2aD0yNDM2Jm9zdj0xMS4zLjEmbmV0PTEwMDAmdnI9JmxpZD04MDAwODQyJnNyPSZwYWlkPWZhbHNlJm9pZD0zMDA0ODE2JmF0aWQ9MCZyZXN0PTM1JnB2ZXI9JnN2ZXI9MS4wLjI4JmZ1PTAmdml0PSZzYz0mc2NpdGlkPSZnZD0mZmxvd21hcms9YWR4X3BfYmlkJTNBZGVmYXVsdCU3Q2FkeF92X2JpZCUzQW1vZGVsdjMlN0NzZGtfdWUlM0FDJTdDYWR4X21peF9iaWQlM0FFJTdDYWRfZiUzQUIlN0NhZF91ZSUzQWRlZiU3Q3ltYiUzQWRlZiU3Q2FkY2xvc2UlM0FkZWZhdWx0JTdDY2FjaGVfb3B0JTNBQiU3Q2FkY3RyJTNBQiU3Q2RzcF9yYW5rJTNBQSU3Q2ZlZWQlM0FCJTdDcHJvJTNBQyU3Q2NsaWNrX3plcm8lM0FkZWZhdWx0JTdDZmVlZHNfc29ydF9hbGdvJTNBZXhwMyU3Q3lrZmVlZCUzQWRlZmF1bHQlN0NwYXVzZV9jbG9zZSUzQWRlZmF1bHQlN0NmZWVkX2RicCUzQUIlN0NhZHhfZGJwJTNBQSZ2cD0mYXBwYz0md2ludD1tZGV2aWNlJnBsdHlwZT0mYWJ0PSZza2lwPTAmc2F2cz0mb3M9MCZkdD0xJmF2cz03LjMuMi43MDUzOCZhbj0mY2lkPSZvbGRCdWNrZXRQYXRoPTItOCZidWNrZXRQYXRoPTItOCZpc0NwbT0xJmlzVGllUGlhbj0xJnBzPTAmcHA9NyZhZHZpZD04OTk3MDQ4NjAmbWI9MSZhdz1hJnZjPWZhbHNlJmlkZmE9MkVFNzEyQUYtRjcyRS00OEM1LTk1MjMtRkYxRjU1RDBCOTQ0Jm91aWQ9Y2Q2OWE3Y2UxODM0Y2I4ZWRhZDZhZGVlZWU4ZmJhNWE0NzIzYjdjMCZtYWM9JmltPSZhaWQ9Jmd1aWQ9NzA2NjcwN2M1YmRjMzhhZjE2MjFlYWY5NGE2ZmU3Nzkmc3M9MC4wJmxvdD0mbGF0PSZpc3Bjb2RlPUNVQ0MmdXVpZD0mYm94PSZldHlwZT0zMDAifV0sIkFUWCI6IiIsIkFMIjoxNX0seyJNSyI6MCwiVlAiOjAsIlJTIjoiaHR0cDovL3ZhbGkuY3AzMS5vdHQuY2libnR2Lm5ldC95b3VrdS82OTc4MDUxODQ2NDM4NzE2NDQ0QjQ1RURCLzAzMDAwODAxMDA1QUY5MDIzNjU2RjgwMDNFODgwM0E5MDE1NkZDLUZFNUUtRENCRS1GRTdCLURDQTc0NjVBRjdBQS5tcDQ/c2lkPTA1MjgyNTkyMjUwMTcxMDE3OTEyNV8wMF9BNzYwMzI3YWUwM2MwYTU5MDNhNDMyN2QyMTg3MGM0OTYmc2lnbj01NWMzMjBiYjljNjA1NWQ0NDIwYzk0NjA4OGJmMDA0YiZjdHlwZT01MCZoZD0xIiwiVyI6MCwiVk4iOiIiLCJWVCI6MCwiU0hVIjpbXSwiQlJTIjoiIiwiU1UiOltdLCJTREtJRCI6MCwiQVQiOjcwLCJWU0MiOiIiLCJDVSI6IiIsIlJTVCI6InZpZGVvIiwiUFNUIjozLCJDVVUiOiIiLCJWSUQiOiI5MDEzMDUzMDYiLCJWUVQiOiJtcDQiLCJTVVMiOlt7IlNESyI6IjAiLCJVIjoiaHR0cDovL2Vtcy55b3VrdS5jb20vaW1wP2U9ZGVkN3VHbXJteklPWlRUY3FVelhaQ3BxeG0tV0hsaGtWZzl5bVZ5ZkRqN1JIa2xqTU5HSzdEaDJwYktuZnZtbU9kVHdRTnd5R0c2ZzRiTlBkRWpTbWU5TWdWXzRoVVFvSGFiQTJQS2pBcnZOQzlFN3c4N3hlTEF0RkhIUFFCamNMUXhCLXpyRlZHbnlXOGNVcmVYbFlfQUZlMUVZZ2JMVWU5U3hkTlhWNnB0aERYRktDOVA4RGpFRkhxajhGN3ZNVS1STTFiYkdoRWdKTFNPbUkzdS01dnVldnNrVnNHb05ac0dLcEM4V29Ma0ZMU2hoZGZXQUcxcUJFa3EwRmdpRUtpdklaZFpvLUM1U1pPVTRpbzRFSkRibk5QZVFNOHpRUzd1VkZPOE5RLVJKd0h2XzIzN0VESG5ndzBKaFJ5V3JQR2pGZVNtVXJnZ3hjQ2NSbHZnVlQtcFoyVGpDQWZSbG9ZcWR0RmZwNU1PZWl1UGs0aHAtZHdua09xMVVwNklmcFJGSG5WbDA1MVFsa2FUQ0piTFZSN3poc0MxT2FVMW0xekpiX1MxQzUzbmRYdXZDMjk3MFBFYkhybzQydkpxQ0tmNWRNYkxsWXlKMmphd2xhVkJZWGdsWVZlM1pPdWRCQjNWWGpjNVU0My1FcnVMZHptMG9uZlVwek1HMWs0aVF6ZGhGS3ZhNjZMQWJGcVZXWnVSdzNOMFdDa01HVlA1ZnZZN3BudkhyTElSVlpDakJXbWhCeHJfeUxOREZFUHVTV1ZLNW45OFlLY1dSQ3ItUVlUaWRORVVVTWpBYUVvdUtWclphR0NtZ1h5VE9jbm5EazF6NXA1ZlVsLVNaMFczNlF4cWo5czdzNFYtRFZOM3ZaQzBTSkd6a1JBNzhXUzJXNDVsc1Q0Z1B3TTBnR3RtRWllMjZvQlllTE0xQmxQcS0mcGlkPTYwMDMwJmh0Y2g9X19odGNoX18ifSx7IlNESyI6IjAiLCJVIjoiaHR0cDovL3ZhbC5hdG0ueW91a3UuY29tL3Nob3c/dj05MTA2NzcyMTgmY3Q9bGl2ZTEmYWlkaWY9NWIzZmFkMmUzOTJmMjg5MTgyNjk5OWM1NGMyN2FmY2MmY3M9JmNhPTUwOTE2MzgmaWU9MzAwNzE4MiZ1aWQ9JmNrPTJFRTcxMkFGLUY3MkUtNDhDNS05NTIzLUZGMUY1NUQwQjk0NCZhbD0xNSZibD0xJnM9NDA1MTA4JnRkPSZzdD0xJnZsPTYwMC4wJmFwPTMmbmFwPTYwMDMwJm5wbz02MDAzMCZkYz0xMTU2MTUwOCZzaWQ9YmFlMWMxM2VmZmZhNDM2MTk4YTc5OWZiNGU0ODI2NDcmY3I9MSZwcj0zNjgxJm9pZHR5cGU9MzAwNTAyNiU3QzAmZHE9YXV0byU3Q21wNCZ1cmk9JmJhaz0wJnBjPTQ1MDAmb25laWQ9JmVmZj0xJmFkc2lkPTE1MjgyNjA2MzAwOTM1OTM4NDgxMiZiZD1hcHBsZSZtZGw9aVBob25lMTAlMkMzJnRhZz0mYWNpcD0xMDYuMTEuMzQuMTkmaXA9MTEuMTM5LjExMy40MCZodGNoPV9faHRjaF9fJnRwPTImcHJwPTM0JnJlcWlkPTBiOGUwZTVjMDAwMjk4OTA1YjE3NjgxNjAwMDAyYTg3JnBpZD02NGI2ODQ3ZTk5MmM0YzQ1JmFsaWlkPVd1bEQ0UjZ6NU9rREFJUFhZaVFycFRZcyZwbz0yJnlpZD0mc2V4PSZhZ2U9JmR2dz0xMTI1JmR2aD0yNDM2Jm9zdj0xMS4zLjEmbmV0PTEwMDAmdnI9JmxpZD04MDAwODQyJnNyPSZwYWlkPWZhbHNlJm9pZD0zMDA1MDI2JmF0aWQ9MCZyZXN0PTM1JnB2ZXI9JnN2ZXI9MS4wLjI4JmZ1PTAmdml0PSZzYz0mc2NpdGlkPSZnZD0mZmxvd21hcms9YWR4X3BfYmlkJTNBZGVmYXVsdCU3Q2FkeF92X2JpZCUzQW1vZGVsdjMlN0NzZGtfdWUlM0FDJTdDYWR4X21peF9iaWQlM0FFJTdDYWRfZiUzQUIlN0NhZF91ZSUzQWRlZiU3Q3ltYiUzQWRlZiU3Q2FkY2xvc2UlM0FkZWZhdWx0JTdDY2FjaGVfb3B0JTNBQiU3Q2FkY3RyJTNBQiU3Q2RzcF9yYW5rJTNBQSU3Q2ZlZWQlM0FCJTdDcHJvJTNBQyU3Q2NsaWNrX3plcm8lM0FkZWZhdWx0JTdDZmVlZHNfc29ydF9hbGdvJTNBZXhwMyU3Q3lrZmVlZCUzQWRlZmF1bHQlN0NwYXVzZV9jbG9zZSUzQWRlZmF1bHQlN0NmZWVkX2RicCUzQUIlN0NhZHhfZGJwJTNBQSZ2cD0mYXBwYz0md2ludD1tZGV2aWNlJnBsdHlwZT0mYWJ0PSZza2lwPTAmc2F2cz0mb3M9MCZkdD0xJmF2cz03LjMuMi43MDUzOCZhbj0mY2lkPSZvbGRCdWNrZXRQYXRoPTItOCZidWNrZXRQYXRoPTItOCZpc0NwbT0xJmlzVGllUGlhbj0xJnBzPTAmcHA9NyZhZHZpZD05MDEzMDUzMDYmbWI9MSZhdz1hJnZjPWZhbHNlJmlkZmE9MkVFNzEyQUYtRjcyRS00OEM1LTk1MjMtRkYxRjU1RDBCOTQ0Jm91aWQ9Y2Q2OWE3Y2UxODM0Y2I4ZWRhZDZhZGVlZWU4ZmJhNWE0NzIzYjdjMCZtYWM9JmltPSZhaWQ9Jmd1aWQ9NzA2NjcwN2M1YmRjMzhhZjE2MjFlYWY5NGE2ZmU3Nzkmc3M9MC4wJmxvdD0mbGF0PSZpc3Bjb2RlPUNVQ0MmdXVpZD0mYm94PSZlcmQ9MGI4ZTBlNWMwMDAyOTg5MDViMTc2ODE2MDAwMjJhODcifV0sIkgiOjAsIkRTUE5BTUUiOiIiLCJWQyI6IiIsIkFMRyI6IiIsIkVGIjoxLCJQUlYiOjAsIkNVRiI6MCwiVkRUIjoiIiwiQ1VNIjpbeyJTREsiOiIwIiwiVSI6Imh0dHA6Ly9lbXMueW91a3UuY29tL2NsaWNrP2U9ZEhJblo3MlEzanF0RTBibGdDWG5PdzRldmtGb3gzLUFtLTFadWY1a2hKMkdJd0NUY2pXVE8wcmlvX1d1eTF1dEMwNEtlLXdJWEM1bW9IanJuTnJLU2xPejh4NF9UNF9uY0xCRi0yTi1sdHZBMUd5dVF1dWoydm1EUEdaVHVtQTlwX3NOZHYtSUYxVFBwV3JkSVdLcnF4b1hlMG5LTlFYemw2cjBaLXlYOXltNnNqVWM2QnNoUDBKLWc2akpORGZwUU4yRmdnbkRvbTYzT0hUS3YzQVVZZHEzVEpKdlg4MlNZNmVxNi1LYXhzZTBVYUY3ZUQ4R2hFbGpnaWx4Q3JqTVptbkVkLXhjUkNnSkY1TzFfUzBmQW8tMEI5YnNnZnBKeGtqYUx3UlY5bEd6cUw3aGU4UTdhTm1hRVpFN2JMTGJHR3dWelJCN0preGxVcXlVMl8tN3BiQi1sNXlEaV8tT1ZOT1ZkVkpTMUJIQVQyZ1JsMmxkQVExakhvNDRQdVpxRkM0eG9xNWYtYnlQc1ZjeVdzS3RFU1R3ZnUwUXFlZUNrUENkbndNUnVCaFVLTTVoSmc3QWRLdjdDOFc4WG5CRVNaM0JBd1dzMDBVZXdZV3QyY29KTEtjdWkwcVNwQzJtUThvYzc0WmN6UURnd3RaSEFuNnJRbktRd2ctLVNfSlJpRXpibjI5ejgwcS1wUVM0TnlJUk9mLTZxRDdMLUM3d0JyVXU0OFFEd1YwTUltaVFLQ1hVdkZPZXFueE8yaFhWV0VuZTczVDNkcVpOdUx3czREOHNPVk4tc0FxR2I0azhyNUlLcDd6Rkx2WVZmQklWTHRTV0pEOHJ5SGFvVFZ1U0d5dEpkc0pXd1BUeFpiV0FJbzVmbVJBcTBzMkNfUnFtajV2ZUNHUjV5TXlYSW9rRmpjNmZiR3ZqaHN4elAtWEFxRF92UTZFQVpnbDF3M1NteWVNblpBJnBpZD02MDAzMCZodGNoPV9faHRjaF9fIn0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly92YWwuYXRtLnlvdWt1LmNvbS9jbGljaz92PTkxMDY3NzIxOCZjdD1saXZlMSZhaWRpZj01YjNmYWQyZTM5MmYyODkxODI2OTk5YzU0YzI3YWZjYyZjcz0mY2E9NTA5MTYzOCZpZT0zMDA3MTgyJnVpZD0mY2s9MkVFNzEyQUYtRjcyRS00OEM1LTk1MjMtRkYxRjU1RDBCOTQ0JmFsPTE1JmJsPTEmcz00MDUxMDgmdGQ9JnN0PTEmdmw9NjAwLjAmYXA9MyZuYXA9NjAwMzAmbnBvPTYwMDMwJmRjPTExNTYxNTA4JnNpZD1iYWUxYzEzZWZmZmE0MzYxOThhNzk5ZmI0ZTQ4MjY0NyZjcj0xJnByPTM2ODEmb2lkdHlwZT0zMDA1MDI2JTdDMCZkcT1hdXRvJTdDbXA0JnVyaT0mYmFrPTAmcGM9NDUwMCZvbmVpZD0mZWZmPTEmYWRzaWQ9MTUyODI2MDYzMDA5MzU5Mzg0ODEyJmJkPWFwcGxlJm1kbD1pUGhvbmUxMCUyQzMmdGFnPSZhY2lwPTEwNi4xMS4zNC4xOSZpcD0xMS4xMzkuMTEzLjQwJmh0Y2g9X19odGNoX18mdHA9MiZwcnA9MzQmcmVxaWQ9MGI4ZTBlNWMwMDAyOTg5MDViMTc2ODE2MDAwMDJhODcmcGlkPTY0YjY4NDdlOTkyYzRjNDUmYWxpaWQ9V3VsRDRSNno1T2tEQUlQWFlpUXJwVFlzJnBvPTImeWlkPSZzZXg9JmFnZT0mZHZ3PTExMjUmZHZoPTI0MzYmb3N2PTExLjMuMSZuZXQ9MTAwMCZ2cj0mbGlkPTgwMDA4NDImc3I9JnBhaWQ9ZmFsc2Umb2lkPTMwMDUwMjYmYXRpZD0wJnJlc3Q9MzUmcHZlcj0mc3Zlcj0xLjAuMjgmZnU9MCZ2aXQ9JnNjPSZzY2l0aWQ9JmdkPSZmbG93bWFyaz1hZHhfcF9iaWQlM0FkZWZhdWx0JTdDYWR4X3ZfYmlkJTNBbW9kZWx2MyU3Q3Nka191ZSUzQUMlN0NhZHhfbWl4X2JpZCUzQUUlN0NhZF9mJTNBQiU3Q2FkX3VlJTNBZGVmJTdDeW1iJTNBZGVmJTdDYWRjbG9zZSUzQWRlZmF1bHQlN0NjYWNoZV9vcHQlM0FCJTdDYWRjdHIlM0FCJTdDZHNwX3JhbmslM0FBJTdDZmVlZCUzQUIlN0Nwcm8lM0FDJTdDY2xpY2tfemVybyUzQWRlZmF1bHQlN0NmZWVkc19zb3J0X2FsZ28lM0FleHAzJTdDeWtmZWVkJTNBZGVmYXVsdCU3Q3BhdXNlX2Nsb3NlJTNBZGVmYXVsdCU3Q2ZlZWRfZGJwJTNBQiU3Q2FkeF9kYnAlM0FBJnZwPSZhcHBjPSZ3aW50PW1kZXZpY2UmcGx0eXBlPSZhYnQ9JnNraXA9MCZzYXZzPSZvcz0wJmR0PTEmYXZzPTcuMy4yLjcwNTM4JmFuPSZjaWQ9Jm9sZEJ1Y2tldFBhdGg9Mi04JmJ1Y2tldFBhdGg9Mi04JmlzQ3BtPTEmaXNUaWVQaWFuPTEmcHM9MCZwcD03JmFkdmlkPTkwMTMwNTMwNiZtYj0xJmF3PWEmdmM9ZmFsc2UmaWRmYT0yRUU3MTJBRi1GNzJFLTQ4QzUtOTUyMy1GRjFGNTVEMEI5NDQmb3VpZD1jZDY5YTdjZTE4MzRjYjhlZGFkNmFkZWVlZThmYmE1YTQ3MjNiN2MwJm1hYz0maW09JmFpZD0mZ3VpZD03MDY2NzA3YzViZGMzOGFmMTYyMWVhZjk0YTZmZTc3OSZzcz0wLjAmbG90PSZsYXQ9JmlzcGNvZGU9Q1VDQyZ1dWlkPSZib3g9JmFsaV90cmFja2lkPTcwXzBiOGUwZTVjMDAwMjk4OTA1YjE3NjgxNjAwMDIyYTg3JmV0eXBlPTIwMCJ9XSwiSUUiOiIzMDA3MTgyIiwiU1VFIjpbeyJTREsiOiIwIiwiVSI6Imh0dHA6Ly9lbXMueW91a3UuY29tL2V2ZW50P2U9SGVNaGl5S05UZDZKeW4wc3EtcnAwcm0xUUpLSnV5X2t4bU1iU1ZtdHJSdjd0TEJJeXduaFRpdlpNRVVtMy1YQUhwNW96ZjB1VGFzS1FDTkpyN0Q2UGE5U1hKWklmMnNOSkFhc3BScE5ib2xRQ01kVzBUaE9IRFVyZXJRT2xKNHlndk9uaXBhZ3lEZWZIUUZXeEktbG1JcHBmYUxKako0UmcwWFhOZmEtTTQyVWpPYWF1RHV0bEJpV2ZUc2F3WnVVY0RTOFg4SzFoZGxlWmY3dk9lVWZudmFFZXo1cndncWV6ajNRRnJ3OGhPSEFNaFBDM0ZsWl8tRzlKOUJ2NGpHSWp4WjAzTHNIaTJuc0p2RVpSS1dCWnc5QjZZcGpJTVcwLVlfV2RBM2RZb0VKTGN4ZnpxMXVldkFHY2M2T2pTcTNqTFlzZElablNNVmRXR1ZvMHJPM2VlLWtidEZaRjJ0UGlCakhUVTJrdjduYnhseUZlWHVPNDJTcmNLNmF0RW1EZ2F1OXJNd0k1Vkd3OVRlczZ1bjRJcVhfQ2ppdWR1RXlfNS1na1BNaHBUNno4UnI0MEVzNGhWQVpZdEhOMXpkWktmS2JOYm1WenRvVnpudmhXYjZWRTNMRTFuLUJ6Mnoxa3BkdGdVR2g0bkpJMGs3a1lOOTFfNUhpc25kNng5WUtBaHZBX2lZS3Nyb2hUcWEwSlRTemY1X0U4eURUUnhuempSMlhHQ2tzWnpXN0dkQjdfcjlkMjZjZk9fQllNN3pSeGdVOEV4eUdjZGV1WW96dHlRTXBkQ04xdXJvR2ozU3B5MHlyY1NwTFFMV2wtOVdUVzluUEgyMWVoUkF0bEwybFA0VGJidF9GZ2Zwd1J3ZllSeHByMVRIdFJxeTA0V0pMdXJHc2JEdGtSUUF6VEZERVBOYW9kX25BLWpYY2VzeUpoODRQTXhxVldjTjlhM0EwU2JDNHRRJnBpZD02MDAzMCZodGNoPV9faHRjaF9fJnZlPTE1In0seyJTREsiOiIwIiwiVSI6Imh0dHA6Ly92YWwuYXRtLnlvdWt1LmNvbS9vdmVyP3Y9OTEwNjc3MjE4JmN0PWxpdmUxJmFpZGlmPTViM2ZhZDJlMzkyZjI4OTE4MjY5OTljNTRjMjdhZmNjJmNzPSZjYT01MDkxNjM4JmllPTMwMDcxODImdWlkPSZjaz0yRUU3MTJBRi1GNzJFLTQ4QzUtOTUyMy1GRjFGNTVEMEI5NDQmYWw9MTUmYmw9MSZzPTQwNTEwOCZ0ZD0mc3Q9MSZ2bD02MDAuMCZhcD0zJm5hcD02MDAzMCZucG89NjAwMzAmZGM9MTE1NjE1MDgmc2lkPWJhZTFjMTNlZmZmYTQzNjE5OGE3OTlmYjRlNDgyNjQ3JmNyPTEmcHI9MzY4MSZvaWR0eXBlPTMwMDUwMjYlN0MwJmRxPWF1dG8lN0NtcDQmdXJpPSZiYWs9MCZwYz00NTAwJm9uZWlkPSZlZmY9MSZhZHNpZD0xNTI4MjYwNjMwMDkzNTkzODQ4MTImYmQ9YXBwbGUmbWRsPWlQaG9uZTEwJTJDMyZ0YWc9JmFjaXA9MTA2LjExLjM0LjE5JmlwPTExLjEzOS4xMTMuNDAmaHRjaD1fX2h0Y2hfXyZ0cD0yJnBycD0zNCZyZXFpZD0wYjhlMGU1YzAwMDI5ODkwNWIxNzY4MTYwMDAwMmE4NyZwaWQ9NjRiNjg0N2U5OTJjNGM0NSZhbGlpZD1XdWxENFI2ejVPa0RBSVBYWWlRcnBUWXMmcG89MiZ5aWQ9JnNleD0mYWdlPSZkdnc9MTEyNSZkdmg9MjQzNiZvc3Y9MTEuMy4xJm5ldD0xMDAwJnZyPSZsaWQ9ODAwMDg0MiZzcj0mcGFpZD1mYWxzZSZvaWQ9MzAwNTAyNiZhdGlkPTAmcmVzdD0zNSZwdmVyPSZzdmVyPTEuMC4yOCZmdT0wJnZpdD0mc2M9JnNjaXRpZD0mZ2Q9JmZsb3dtYXJrPWFkeF9wX2JpZCUzQWRlZmF1bHQlN0NhZHhfdl9iaWQlM0Ftb2RlbHYzJTdDc2RrX3VlJTNBQyU3Q2FkeF9taXhfYmlkJTNBRSU3Q2FkX2YlM0FCJTdDYWRfdWUlM0FkZWYlN0N5bWIlM0FkZWYlN0NhZGNsb3NlJTNBZGVmYXVsdCU3Q2NhY2hlX29wdCUzQUIlN0NhZGN0ciUzQUIlN0Nkc3BfcmFuayUzQUElN0NmZWVkJTNBQiU3Q3BybyUzQUMlN0NjbGlja196ZXJvJTNBZGVmYXVsdCU3Q2ZlZWRzX3NvcnRfYWxnbyUzQWV4cDMlN0N5a2ZlZWQlM0FkZWZhdWx0JTdDcGF1c2VfY2xvc2UlM0FkZWZhdWx0JTdDZmVlZF9kYnAlM0FCJTdDYWR4X2RicCUzQUEmdnA9JmFwcGM9JndpbnQ9bWRldmljZSZwbHR5cGU9JmFidD0mc2tpcD0wJnNhdnM9Jm9zPTAmZHQ9MSZhdnM9Ny4zLjIuNzA1MzgmYW49JmNpZD0mb2xkQnVja2V0UGF0aD0yLTgmYnVja2V0UGF0aD0yLTgmaXNDcG09MSZpc1RpZVBpYW49MSZwcz0wJnBwPTcmYWR2aWQ9OTAxMzA1MzA2Jm1iPTEmYXc9YSZ2Yz1mYWxzZSZpZGZhPTJFRTcxMkFGLUY3MkUtNDhDNS05NTIzLUZGMUY1NUQwQjk0NCZvdWlkPWNkNjlhN2NlMTgzNGNiOGVkYWQ2YWRlZWVlOGZiYTVhNDcyM2I3YzAmbWFjPSZpbT0mYWlkPSZndWlkPTcwNjY3MDdjNWJkYzM4YWYxNjIxZWFmOTRhNmZlNzc5JnNzPTAuMCZsb3Q9JmxhdD0maXNwY29kZT1DVUNDJnV1aWQ9JmJveD0mZXR5cGU9MzAwIn1dLCJBVFgiOiIiLCJBTCI6MTV9XSwiRkciOjB9";
    	System.out.println(decodeBase64(adInfo));
    }
    
}
