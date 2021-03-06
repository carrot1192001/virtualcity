package com.youku.ad.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;

public class StringUtil {

	/**
	 * object转换为String 
	 * @param obj
	 * @return
	 */
	public static String ObjectToStr(Object obj) {
		if (obj == null || "null".equals(obj))
			return "";
		else
			return String.valueOf(obj);
	}

	/**
	 * 如果解析失败，返回0
	 */
	public static int objectToInt(Object obj) {
	    return objectToInt(obj, 0);
	}
	
	/**
	 * obj转换为double，异常返回0
	 * @param obj
	 * @return
	 */
	public static double objectToDouble(Object obj) {
		try {
	        return Double.parseDouble(String.valueOf(obj));
        } catch (Exception e) {
            return 0;
        }
	}
	
	/**
     * 如果解析失败，返回给定的defaultValue
     */
	public static int objectToInt(Object obj, int defaultValue) {
	    try {
	        return Integer.parseInt(String.valueOf(obj));
        } catch (Exception e) {
            return defaultValue;
        }
	}
	
    /**
     * Utility class to peform common String manipulation algorithms.
     */

    public static double TrimPrefixZero(String str) {
        double value = 0;
        if ((str == null) || (str.equalsIgnoreCase(""))) {
            return 0;
        }
        char ch = ' ';
        for (int i = 0; i < str.trim().length(); i++) {
            ch = str.charAt(i);
            if (ch == 0)
                continue;
            else
                value = Double.parseDouble(str.substring(i, str.length()));
        }
        return value;
    }

    /**
     * 说明: ISO_8559_1字符转换为GBK字符
     * 
     * @param 需要转换的字符
     * @return 转换后的GBK字符
     */
    public static String IsoToGBK(String strIn) {
        String strOut = null;
        if (strIn == null)
            return "";
        try {
            byte[] b = strIn.getBytes("ISO8859_1");
            strOut = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
        }

        return strOut;
    }

    /**
     * 说明: GBK字符转换为ISO_8559_1字符
     * 
     * @param 需要转换的GBK字符
     * @return 转换后的ISO_8559_1字符
     */
    public static String GBKToIso(String strIn) {
        byte[] b;
        String strOut = null;
        if (strIn == null)
            return "";
        try {
            b = strIn.getBytes("GBK");

            strOut = new String(b, "ISO8859_1");

        } catch (UnsupportedEncodingException e) {
        }

        return strOut;
    }

    /**
     * 说明：GBK字符转换为UTF8编码
     * 
     * @param strIn
     *            需要转换的GBK字符
     * @return 转换后的UTF8字符
     */
    public static String GBKToUtf8(String strIn) {
        byte[] b;
        String strOut = null;
        if (strIn == null)
            return "";
        try {
            b = strIn.getBytes("GBK");

            strOut = new String(b, "UTF8");

        } catch (UnsupportedEncodingException e) {
        }

        return strOut;
    }

    public static String ToUtf8(byte[] bytes) {
        String strOut = null;
        try {
            strOut = new String(bytes, "UTF8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }

        return strOut;
    }

    // Constants used by escapeHTMLTags
    private static final char[] QUOTE_ENCODE = "&quot;".toCharArray();
    private static final char[] AMP_ENCODE = "&amp;".toCharArray();
    private static final char[] LT_ENCODE = "&lt;".toCharArray();
    private static final char[] GT_ENCODE = "&gt;".toCharArray();

    /**
     * Replaces all instances of oldString with newString in line.
     * 
     * @param line
     *            the String to search to perform replacements on
     * @param oldString
     *            the String that should be replaced by newString
     * @param newString
     *            the String that will replace all instances of oldString
     * 
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replace(String line, String oldString,
            String newString) {
        if (line == null) {
            return null;
        }
        int i = 0;
        if ((i = line.indexOf(oldString, i)) >= 0) {
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i = line.indexOf(oldString, i)) > 0) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }

    /**
     * Replaces all instances of oldString with newString in line with the added
     * feature that matches of newString in oldString ignore case.
     * 
     * @param line
     *            the String to search to perform replacements on
     * @param oldString
     *            the String that should be replaced by newString
     * @param newString
     *            the String that will replace all instances of oldString
     * 
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replaceIgnoreCase(String line, String oldString,
            String newString) {
        if (line == null) {
            return null;
        }
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }

    /**
     * Replaces all instances of oldString with newString in line with the added
     * feature that matches of newString in oldString ignore case. The count
     * paramater is set to the number of replaces performed.
     * 
     * @param line
     *            the String to search to perform replacements on
     * @param oldString
     *            the String that should be replaced by newString
     * @param newString
     *            the String that will replace all instances of oldString
     * @param count
     *            a value that will be updated with the number of replaces
     *            performed.
     * 
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replaceIgnoreCase(String line, String oldString,
            String newString, int[] count) {
        if (line == null) {
            return null;
        }
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            int counter = 0;
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
                counter++;
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            count[0] = counter;
            return buf.toString();
        }
        return line;
    }

    /**
     * Replaces all instances of oldString with newString in line. The count
     * Integer is updated with number of replaces.
     * 
     * @param line
     *            the String to search to perform replacements on
     * @param oldString
     *            the String that should be replaced by newString
     * @param newString
     *            the String that will replace all instances of oldString
     * 
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replace(String line, String oldString,
            String newString, int[] count) {
        if (line == null) {
            return null;
        }
        int i = 0;
        if ((i = line.indexOf(oldString, i)) >= 0) {
            int counter = 0;
            counter++;
            char[] line2 = line.toCharArray();
            char[] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i = line.indexOf(oldString, i)) > 0) {
                counter++;
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            count[0] = counter;
            return buf.toString();
        }
        return line;
    }

    /**
     * This method takes a string which may contain HTML tags (ie, &lt;b&gt;,
     * &lt;table&gt;, etc) and converts the '&lt'' and '&gt;' characters to
     * their HTML escape sequences.
     * 
     * @param in
     *            the text to be converted.
     * @return the input string with the characters '&lt;' and '&gt;' replaced
     *         with their HTML escape sequences.
     */
    public static final String escapeHTMLTags(String in) {
        if (in == null) {
            return null;
        }
        char ch;
        int i = 0;
        int last = 0;
        char[] input = in.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int) (len * 1.3));
        for (; i < len; i++) {
            ch = input[i];
            if (ch > '>') {
                continue;
            } else if (ch == '<') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(LT_ENCODE);
            } else if (ch == '>') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(GT_ENCODE);
            }
        }
        if (last == 0) {
            return in;
        }
        if (i > last) {
            out.append(input, last, i - last);
        }
        return out.toString();
    }

    /**
     * Used by the hash method.
     */
    private static MessageDigest digest = null;

    /**
     * Hashes a String using the Md5 algorithm and returns the result as a
     * String of hexadecimal numbers. This method is synchronized to avoid
     * excessive MessageDigest object creation. If calling this method becomes a
     * bottleneck in your code, you may wish to maintain a pool of MessageDigest
     * objects instead of using this method.
     * <p>
     * A hash is a one-way function -- that is, given an input, an output is
     * easily computed. However, given the output, the input is almost
     * impossible to compute. This is useful for passwords since we can store
     * the hash and a hacker will then have a very hard time determining the
     * original password.
     * <p>
     * In Jive, every time a user logs in, we simply take their plain text
     * password, compute the hash, and compare the generated hash to the stored
     * hash. Since it is almost impossible that two passwords will generate the
     * same hash, we know if the user gave us the correct password or not. The
     * only negative to this system is that password recovery is basically
     * impossible. Therefore, a reset password method is used instead.
     * 
     * @param data
     *            the String to compute the hash of.
     * @return a hashed version of the passed-in String
     */
    public synchronized static final String hash(String data) {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException nsae) {
                System.err.println("Failed to load the MD5 MessageDigest. "
                        + "Jive will be unable to function normally.");
                nsae.printStackTrace();
            }
        }
        // Now, compute hash.
        digest.update(data.getBytes());
        return encodeHex(digest.digest());
    }

    /**
     * Turns an array of bytes into a String representing each byte as an
     * unsigned hex number.
     * <p>
     * Method by Santeri Paavolainen, Helsinki Finland 1996<br>
     * (c) Santeri Paavolainen, Helsinki Finland 1996<br>
     * Distributed under LGPL.
     * 
     * @param bytes
     *            an array of bytes to convert to a hex-string
     * @return generated hex string
     */
    public static final String encodeHex(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        int i;

        for (i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            System.out.println(bytes[i]);
            System.out.println(((int) bytes[i]) & 0xFF);
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static final String MD5(String text) {
        MessageDigest dig;
        try {
            dig = MessageDigest.getInstance("MD5");
            dig.update(text.getBytes());
            return encodeHex(dig.digest());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Turns a hex encoded string into a byte array. It is specifically meant to
     * "reverse" the toHex(byte[]) method.
     * 
     * @param hex
     *            a hex encoded String to transform into a byte array.
     * @return a byte array representing the hex String[
     */
    public static final byte[] decodeHex(String hex) {
        char[] chars = hex.toCharArray();
        byte[] bytes = new byte[chars.length / 2];
        int byteCount = 0;
        for (int i = 0; i < chars.length; i += 2) {
            byte newByte = 0x00;
            newByte |= hexCharToByte(chars[i]);
            newByte <<= 4;
            newByte |= hexCharToByte(chars[i + 1]);
            bytes[byteCount] = newByte;
            byteCount++;
        }
        return bytes;
    }

    public static byte[] int2byte(int in[], byte out[]) {
        int inpos = 0;
        int outpos = 0;
        for (; inpos < 4; inpos++) {
            out[outpos++] = (byte) (in[inpos] & 0xff);
            out[outpos++] = (byte) (in[inpos] >>> 8 & 0xff);
            out[outpos++] = (byte) (in[inpos] >>> 16 & 0xff);
            out[outpos++] = (byte) (in[inpos] >>> 24 & 0xff);
        }
        return out;
    }

    public static byte[] int2byte(int in) {
        int inpos = 0;
        int outpos = 0;
        byte[] out = new byte[2];
        for (int i = 0; i < 1; i++) {
            out[outpos++] = (byte) (in & 0xff);
            out[outpos++] = (byte) (in >>> 8 & 0xff);
        }
        return out;
    }

    /**
     * Returns the the byte value of a hexadecmical char (0-f). It's assumed
     * that the hexidecimal chars are lower case as appropriate.
     * 
     * @param ch
     *            a hexedicmal character (0-f)
     * @return the byte value of the character (0x00-0x0F)
     */
    private static final byte hexCharToByte(char ch) {
        switch (ch) {
        case '0':
            return 0x00;
        case '1':
            return 0x01;
        case '2':
            return 0x02;
        case '3':
            return 0x03;
        case '4':
            return 0x04;
        case '5':
            return 0x05;
        case '6':
            return 0x06;
        case '7':
            return 0x07;
        case '8':
            return 0x08;
        case '9':
            return 0x09;
        case 'a':
            return 0x0A;
        case 'b':
            return 0x0B;
        case 'c':
            return 0x0C;
        case 'd':
            return 0x0D;
        case 'e':
            return 0x0E;
        case 'f':
            return 0x0F;
        }
        return 0x00;
    }

    /**
     * 将整型数值转换为8进制字符编码
     * 
     * @param Value
     * @return
     */
    private static final byte IntToHex(int Value) {
        switch (Value) {
        case 0:
            return 0x7f;
        case 1:
            return 0x3f;
        case 2:
            return 0x1f;
        case 3:
            return 0x0f;
        case 4:
            return 0x07;
        case 5:
            return 0x03;
        case 6:
            return 0x01;
        case 7:
            return 0x00;
        }
        return 0x7f;
    }

    // *********************************************************************
    // * Base64 - a simple base64 encoder and decoder.
    // *
    // * Copyright (c) 1999, Bob Withers - bwit@pobox.com
    // *
    // * This code may be freely used for any purpose, either personal
    // * or commercial, provided the authors copyright notice remains
    // * intact.
    // *********************************************************************

    /**
     * Encodes a String as a base64 String.
     * 
     * @param data
     *            a String to encode.
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
     * @param data
     *            a byte array to encode.
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
            if (++i < len)
                c |= (data[i] >> 4) & 0x0f;

            ret.append(cvt.charAt(c));
            if (i < len) {
                c = (data[i] << 2) & 0x3f;
                if (++i < len)
                    c |= (data[i] >> 6) & 0x03;

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

    /**
     * Decodes a base64 aray of bytes.
     * 
     * @param data
     *            a base64 encode byte array to decode.
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

    private static final int fillchar = '=';
    private static final String cvt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz" + "0123456789+/";

    /**
     * Converts a line of text into an array of lower case words using a
     * BreakIterator.wordInstance().
     * <p>
     * 
     * This method is under the Jive Open Source Software License and was
     * written by Mark Imbriaco.
     * 
     * @param text
     *            a String of text to convert into an array of words
     * @return text broken up into an array of words.
     */
    public static final String[] toLowerCaseWordArray(String text) {
        if (text == null || text.length() == 0) {
            return new String[0];
        }

        ArrayList wordList = new ArrayList();
        BreakIterator boundary = BreakIterator.getWordInstance();
        boundary.setText(text);
        int start = 0;

        for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary
                .next()) {
            String tmp = text.substring(start, end).trim();
            // Remove characters that are not needed.
            tmp = replace(tmp, "+", "");
            tmp = replace(tmp, "/", "");
            tmp = replace(tmp, "\\", "");
            tmp = replace(tmp, "#", "");
            tmp = replace(tmp, "*", "");
            tmp = replace(tmp, ")", "");
            tmp = replace(tmp, "(", "");
            tmp = replace(tmp, "&", "");
            if (tmp.length() > 0) {
                wordList.add(tmp);
            }
        }
        return (String[]) wordList.toArray(new String[wordList.size()]);
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

    /**
     * Pseudo-random number generator object for use with randomString(). The
     * Random class is not considered to be cryptographically secure, so only
     * use these random Strings for low to medium security applications.
     */
    private static Random randGen = new Random();

    /**
     * Array of numbers and letters of mixed case. Numbers appear in the list
     * twice so that there is a more equal chance that a number will be picked.
     * We can use the array to get a random number or letter by picking a random
     * array index.
     */
    private static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
            + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    /**
     * Returns a random String of numbers and letters (lower and upper case) of
     * the specified length. The method uses the Random class that is built-in
     * to Java which is suitable for low to medium grade security uses. This
     * means that the output is only pseudo random, i.e., each number is
     * mathematically generated so is not truly random.
     * <p>
     * 
     * The specified length must be at least one. If not, the method will return
     * null.
     * 
     * @param length
     *            the desired length of the random String to return.
     * @return a random String of numbers and letters of the specified length.
     */
    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        // Create a char buffer to put random letters and numbers in.
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
    }

    /**
     * Intelligently chops a String at a word boundary (whitespace) that occurs
     * at the specified index in the argument or before. However, if there is a
     * newline character before <code>length</code>, the String will be
     * chopped there. If no newline or whitespace is found in
     * <code>string</code> up to the index <code>length</code>, the String
     * will chopped at <code>length</code>.
     * <p>
     * For example, chopAtWord("This is a nice String", 10) will return "This is
     * a" which is the first word boundary less than or equal to 10 characters
     * into the original String.
     * 
     * @param string
     *            the String to chop.
     * @param length
     *            the index in <code>string</code> to start looking for a
     *            whitespace boundary at.
     * @return a substring of <code>string</code> whose length is less than or
     *         equal to <code>length</code>, and that is chopped at
     *         whitespace.
     */
    public static final String chopAtWord(String string, int length) {
        if (string == null) {
            return string;
        }

        char[] charArray = string.toCharArray();
        int sLength = string.length();
        if (length < sLength) {
            sLength = length;
        }

        // First check if there is a newline character before length; if so,
        // chop word there.
        for (int i = 0; i < sLength - 1; i++) {
            // Windows
            if (charArray[i] == '\r' && charArray[i + 1] == '\n') {
                return string.substring(0, i + 1);
            }
            // Unix
            else if (charArray[i] == '\n') {
                return string.substring(0, i);
            }
        }
        // Also check boundary case of Unix newline
        if (charArray[sLength - 1] == '\n') {
            return string.substring(0, sLength - 1);
        }

        // Done checking for newline, now see if the total string is less than
        // the specified chop point.
        if (string.length() < length) {
            return string;
        }

        // No newline, so chop at the first whitespace.
        for (int i = length - 1; i > 0; i--) {
            if (charArray[i] == ' ') {
                return string.substring(0, i).trim();
            }
        }

        // Did not find word boundary so return original String chopped at
        // specified length.
        return string.substring(0, length);
    }

    /**
     * Escapes all necessary characters in the String so that it can be used in
     * an XML doc.
     * 
     * @param string
     *            the string to escape.
     * @return the string with appropriate characters escaped.
     */
    public static final String escapeForXML(String string) {
        if (string == null) {
            return null;
        }
        char ch;
        int i = 0;
        int last = 0;
        char[] input = string.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int) (len * 1.3));
        for (; i < len; i++) {
            ch = input[i];
            if (ch > '>') {
                continue;
            } else if (ch == '<') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(LT_ENCODE);
            } else if (ch == '&') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(AMP_ENCODE);
            } else if (ch == '"') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(QUOTE_ENCODE);
            }
        }
        if (last == 0) {
            return string;
        }
        if (i > last) {
            out.append(input, last, i - last);
        }
        return out.toString();
    }

    /**
     * Unescapes the String by converting XML escape sequences back into normal
     * characters.
     * 
     * @param string
     *            the string to unescape.
     * @return the string with appropriate characters unescaped.
     */
    public static final String unescapeFromXML(String string) {
        string = replace(string, "&lt;", "<");
        string = replace(string, "&gt;", ">");
        string = replace(string, "&quot;", "\"");
        return replace(string, "&amp;", "&");
    }

    private static final char[] zeroArray = "0000000000000000".toCharArray();

    /**
     * Pads the supplied String with 0's to the specified length and returns the
     * result as a new String. For example, if the initial String is "9999" and
     * the desired length is 8, the result would be "00009999". This type of
     * padding is useful for creating numerical values that need to be stored
     * and sorted as character data. Note: the current implementation of this
     * method allows for a maximum <tt>length</tt> of 16.
     * 
     * @param string
     *            the original String to pad.
     * @param length
     *            the desired length of the new padded String.
     * @return a new String padded with the required number of 0's.
     */
    public static final String zeroPadString(String string, int length) {
        if (string == null || string.length() > length) {
            return string;
        }
        StringBuffer buf = new StringBuffer(length);
        buf.append(zeroArray, 0, length - string.length()).append(string);
        return buf.toString();
    }

    /**
     * Formats a Date as a fifteen character long String made up of the Date's
     * padded millisecond value.
     * 
     * @return a Date encoded as a String.
     */
    public static final String dateToMillis(Date date) {
        return zeroPadString(Long.toString(date.getTime()), 15);
    }

    /**
     * 隐藏手机号码的中间四位数字
     * 
     * @param mobile
     * @return
     */
    public static final String HiddenMobile(String mobile) {
        if (mobile == null) {
            return mobile;
        }
        String start = mobile.substring(0, 3);
        String hidden = "****";
        String end = mobile.substring(7, mobile.length());
        return start + hidden + end;
    }

    /**
     * 说明:统一将字符串变小写
     * 
     * @param str
     * @return
     */
    public static final String toLower(String str) {
        return str.toLowerCase();
    }

    public static final String formatString(String str) {
        if (str == null)
            return "";
        else
            return str;
    }

    public static final String[] toArray(String str, int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must > 1, while num is "
                    + num);
        }

        String[] result = new String[num];
        for (int i = 0; i < num; i++) {
            result[i] = str;
        }
        return result;
    }

    public static final String join(List<String> list, String del) {

        return join(list.toArray(new String[list.size()]), del);
    }

    public static final String join(String[] array, String del) {
        if (array == null || array.length == 0) {
            // throw new IllegalArgumentException("array.length must >= 1");
            return null;
        }

        if (del == null) {
            throw new IllegalArgumentException("del must NOT be null");
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < array.length - 1; i++) {
            buffer.append(array[i]);
            buffer.append(del);
        }

        buffer.append(array[array.length - 1]);
        return buffer.toString();
    }

    public static final String copyMe(String str, int num, String del) {
        return join(toArray(str, num), del);
    }

    /**
     * 单字符分割字符串
     * 
     * @param str
     * @param separator
     * @return
     */
    public static List<String> split(String str, char separator) {
    	char[] arr = str.toCharArray();
        List<String> list = new ArrayList<String>();
        int start = 0;
        int end = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == separator) {
                end = i;
                list.add(new String(arr, start, end - start));
                start = i + 1;
                if (i == len -1)
                	list.add(new String());
            } else if (i == len - 1)
            	list.add(new String(arr, start, len - start));
        }
        return list;
    }
    
    /**
     * 多字符分割字符串
     * 
     * @param str
     * @param separator
     * @return
     */
    public static List<String> splitStr(String str, String separator) {
        List<String> list = new ArrayList<String>();
        String[] keys = str.split(separator);
        for (String key : keys) {
        	list.add(key);
		}
        return list;
    }
    
    

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int parse(String s, int bound, boolean upper) {
        if (isInteger(s)) {
            int result = Integer.parseInt(s);
            if (upper) {
                if (result > bound) {
                    return bound;
                } else {
                    return result;
                }
            } else {
                if (result < bound) {
                    return bound;
                } else {
                    return result;
                }
            }
        }

        return bound;
    }

	/**
	 * 
	 * 
	 * @param string
	 * @param subString
	 * @param caseSensitive
	 * @return
	 */
	static public boolean contains(String string, String subString, boolean caseSensitive) {
		if (!caseSensitive) {
			string = string.toLowerCase();
			subString = subString.toLowerCase();
		}
		Pattern p = Pattern.compile(subString, Pattern.MULTILINE);
		return p.matcher(string).find();
	}

	/**
	 * 
	 * @param string
	 * @param subString
	 * @return
	 */
	static public boolean contains(String string, String subString) {
		return contains(string, subString, true);
	}	
	
	
    /**
     * str中是否包含 key
     * @param str
     * @param key
     * @return
     */
    public static boolean hasValue(String str,String key,char separator)
    {
        if (str != null && key != null) {
        	char[] chars = str.toCharArray();
            char[] keys = key.toCharArray();
            int keystart = 0;
            int keyend = 0;

out:            for (int i = 0; i <= chars.length - keys.length; i++) {
	                if (chars[i] == separator) {
	                    keyend = i;	
	                    if (keyend - keystart == keys.length) {
	                        for (int j = keystart; j < keyend; j++) {
	                            if (chars[j] != keys[j - keystart]) {
	                            	keystart = i + 1;
	                                continue out;
	                            }
	                        }
	                        return true;
	                    }
	                    keystart = i + 1;
	                    continue;
	                }
                
                if (chars.length-keys.length==keystart)
                {
	                for (int j = keystart; j < chars.length; j++) {
	                    if (chars[j] != keys[j - keystart]) {
	                        return false;
	                    }
	                }
	                return true;
                }
            }

        }
        return false;
    }
    
	static Pattern pattern_num = Pattern.compile("[0-9]+"); 

    public static boolean isNumeric(String str){ 
    	if(str == null || str.length() == 0){
    		return false;
    	}
        return pattern_num.matcher(str).matches();    
    }

	// 是否是正整数 str > 0     str = [1-9][0-9]*
	public static boolean isPositiveInteger(String str) {
    	if(str == null || str.length() == 0){
    		return false;
    	}
		char ch = str.charAt(0);
		if(ch < '1' || ch > '9')
			return false;
		for(int i=1; i < str.length(); i++) {
			ch = str.charAt(i);
			if(ch < '0' || ch > '9')
				return false;
		}
		return true;
	}
	/* 这个有点慢 比上面一个慢20倍
	static Pattern patternPositiveInteger = Pattern.compile("[1-9][0-9]*"); 
	public static boolean isPositiveIntegerV2(String str) {
    	if(str == null || str.length() == 0){
    		return false;
    	}
        return patternPositiveInteger.matcher(str).matches();    
	}
	//*/

	// 判断一个字符串像不像一个MD5值, 32位16进制数
	public static boolean likeMD5(String str) {
		if(str == null || str.length() != 32) {
			return false;
		}
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if( !(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'f' || ch >= 'A' && ch <= 'F') ) {
				return false;
			}
		}
		return true;
	}
	

	public static String gzip(String str) {
		if(str == null || str.length() == 0) {
			return "";
		}
		try{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			GZIPOutputStream gzipos = new GZIPOutputStream(bos);
			gzipos.write(str.getBytes("iso8859-1"), 0, str.length());
			gzipos.flush();
			gzipos.finish();
			gzipos.close();
			byte[] bytes = bos.toByteArray();
			return StringUtil.encodeBase64(bytes).replace("+","-").replace("/","_").replace("=",".");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String ungzip(String str) {
		if(str == null || str.length() == 0) {
			return "";
		}
		try{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] bytes = StringUtil.decodeBase64(str.replace("-","+").replace("_","/").replace(".","=")).getBytes("iso8859-1");
			GZIPInputStream gzipis = new GZIPInputStream(new ByteArrayInputStream(bytes));
			byte[] bs = new byte[256];
			int rn = 0;
			while((rn = gzipis.read(bs, 0, 256)) >= 0) {
				bos.write(bs, 0, rn);
			}
			gzipis.close();
			return new String(bos.toByteArray());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * null或"null"返回空字符串。 
	 * @param str
	 * @return
	 */
	public static String removeNullStr(String str) {
		if (null == str || "null".equals(str))
			return "";
		else
			return str;
	}
    
    public static void main(String[] args) {
		long t1=0,t2=0;
		int times = 100 * 10000;

		t1 = System.currentTimeMillis();

		for(int i=0;i<times;i++) {
			isNumeric("1234567abc");
		}

		t2 = System.currentTimeMillis();
		System.out.println("isNumeric t="+(t2-t1));

		t1 = System.currentTimeMillis();

		for(int i=0;i<times;i++) {
			isPositiveInteger("1234567abc");
		}

		t2 = System.currentTimeMillis();
		System.out.println("isPositiveInteger t="+(t2-t1));
		
		/*
		t1 = System.currentTimeMillis();

		for(int i=0;i<times;i++) {
			isPositiveIntegerV2("1234567abc");
		}

		t2 = System.currentTimeMillis();
		System.out.println("isPositiveIntegerV2 t="+(t2-t1));
		*/
		String[] strs = new String[]{null,"","0","1","2","9","01","03","09","11","13","19","22","30","91","0a","01a","00a","001","000123","a","1a","a1","12a","12","a12","ab12","abc","123","12345"};
		for(int i=0;i<strs.length;i++) {
			String str = strs[i];
			System.out.println("str =\t"+str+"\t isPositiveInteger="+isPositiveInteger(str));
		}

    	System.out.println(isNumeric(null));
        // System.out.println(htmlToJs("sadasfdasfdasfsafdsafdsafsaf\n\r\\/'\"asdfasdfsadfasd"));
        // long start = System.currentTimeMillis();
        // for(int i=0;i<1000000;i++){
        // StringUtil.test();
        // }
        // System.out.println(System.currentTimeMillis()-start);
        // System.out.println(StringUtil.test());
        // System.out.println(StringUtil.getUniqCookie(null, null));
        //
        // System.out.println(StringUtil.copyMe("int", 2, ","));
        // System.out.println(StringUtil.copyMe("str", 6, ","));
        // System.out.println(StringUtil.copyMe("int", 8, ","));
        //
        // System.out
        // .println("ID,时间,一级分类,二级分类,广告投放,素材,省份,城市,banner展示数,banner点击数,banner自动关闭数,banner手动关闭数,video播放完成,video手动关闭数,IP数量,cookie数量"
        // .split(",").length);
        // System.out.println("ID,时间".split(",").length);
        // System.out.println("一级分类,二级分类,广告投放,素材,省份,城市".split(",").length);
        // System.out
        // .println("banner展示数,banner点击数,banner自动关闭数,banner手动关闭数,video播放完成,video手动关闭数,IP数量,cookie数量"
        // .split(",").length);
        System.out
                .println(StringUtil
                        .decodeBase64("cD0yJnU9ey9pbmZvLmNoaW5hLmFsaWJhYmEuY29tL25ld3Mvc3ViamVjdC92MzAwMDEwMy1zNTAyNTAzOS5odG1sP2hlYWQ9bm8mY29zaXRlPXlvdWt1JmxvY2F0aW9uPXN0b3Bfc3RyZWV0fSZtPXtHRVR9JnM9ezIwMH0mcj17aHR0cDovL3N0YXRpYy55b3VrdS5jb20vdjEuMC4wMjI0L3Yvc3dmL3FwbGF5ZXIuc3dmfSZhPXstfSZiPXstfSZjPXstfQ=="
                                .getBytes()));
    }
}
