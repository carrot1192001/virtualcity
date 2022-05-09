package com.youku.atm.cacher.test;

import java.io.UnsupportedEncodingException;

public class TestUnicodeToChinese {
	
	 public static String decodeUnicode(String theString) {    
		  
	     char aChar;    
	  
	      int len = theString.length();    
	  
	     StringBuffer outBuffer = new StringBuffer(len);    
	  
	     for (int x = 0; x < len;) {    
	  
	      aChar = theString.charAt(x++);    
	  
	      if (aChar == '\\') {    
	  
	       aChar = theString.charAt(x++);    
	  
	       if (aChar == 'u') {    
	  
	        // Read the xxxx    
	  
	        int value = 0;    
	  
	        for (int i = 0; i < 4; i++) {    
	  
	         aChar = theString.charAt(x++);    
	  
	         switch (aChar) {    
	  
	         case '0':    
	  
	         case '1':    
	  
	         case '2':    
	  
	         case '3':    
	  
	        case '4':    
	  
	         case '5':    
	  
	          case '6':    
	           case '7':    
	           case '8':    
	           case '9':    
	            value = (value << 4) + aChar - '0';    
	            break;    
	           case 'a':    
	           case 'b':    
	           case 'c':    
	           case 'd':    
	           case 'e':    
	           case 'f':    
	            value = (value << 4) + 10 + aChar - 'a';    
	           break;    
	           case 'A':    
	           case 'B':    
	           case 'C':    
	           case 'D':    
	           case 'E':    
	           case 'F':    
	            value = (value << 4) + 10 + aChar - 'A';    
	            break;    
	           default:    
	            throw new IllegalArgumentException(    
	              "Malformed   \\uxxxx   encoding.");    
	           }    
	  
	         }    
	          outBuffer.append((char) value);    
	         } else {    
	          if (aChar == 't')    
	           aChar = '\t';    
	          else if (aChar == 'r')    
	           aChar = '\r';    
	  
	          else if (aChar == 'n')    
	  
	           aChar = '\n';    
	  
	          else if (aChar == 'f')    
	  
	           aChar = '\f';    
	  
	          outBuffer.append(aChar);    
	  
	         }    
	  
	        } else   
	  
	        outBuffer.append(aChar);    
	  
	       }    
	  
	       return outBuffer.toString();    
	  
	      }   
	
	public static void main(String[] args) {
		
//		TestUnicodeToChinese tt = new TestUnicodeToChinese();
//		System.out.println(tt.decodeUnicode("%E9%82%93%E8%B6%85|%E5%BC%A0%E9%9D%93%E9%A2%96|"));
//	    try {
//	    	// Convert from Unicode to UTF-8
//	    	String string1 = "%E9%82%93%E8%B6%85|%E5%BC%A0%E9%9D%93%E9%A2%96|";
//	    	byte[] utf8 = string1.getBytes("UTF-8");
//	    	// Convert from UTF-8 to Unicode
//	    	string1 = new String(utf8, "UTF-8");
//		    System.out.println(string1);
//	    	} catch (UnsupportedEncodingException e) {
//	    	}
//	    String ascii="\u66dd\u6768\u5e42\u6000\u7537\u5a74";  
//	    System.out.println(ascii);  
//	    try {
//			String result = java.net.URLDecoder.decode("%u9093%u8D85|%u5F20%u9753%u9896","UTF-8");
//			System.out.println(result);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    String aaa = "1234".charAt(1) + "";
	    System.out.println(aaa);
//	    int k = Integer.parseInt(aaa);
//	    System.out.println(k);

		
	}

}
