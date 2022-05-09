package com.youku.atm.cacher.test;

import java.security.MessageDigest;
import java.util.Date;

public class GetMd5 {

	public static String getMD5Str(String str) {
		str = "youkuatm" + str + "atm5!%^&*(#0";
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
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	public static void main(String[] args) {
		
		System.out.println(GetMd5.getMD5Str("http://www.luyuan.cn/"));
		System.out.println(new Date());
		

	}

}
