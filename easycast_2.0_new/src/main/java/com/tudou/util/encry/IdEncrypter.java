package com.tudou.util.encry;

import com.tudou.util.encry.java.IdEncrypterForjava;

/**
 * ��java��id��code��ת
 * 
 * @author chentong
 * @date 2014-3-24
 */
public class IdEncrypter {
	public static String encrypt(int id) {
		return IdEncrypterForjava.encodeVid(id);
	}

	public static int decrypt(String code) {
		return IdEncrypterForjava.decodeVid(code);
	}
	
	public static void main(String[] args) {
		
		int kk = decrypt("-4FEdfe-fQs");
		System.out.println(kk);
	}
}