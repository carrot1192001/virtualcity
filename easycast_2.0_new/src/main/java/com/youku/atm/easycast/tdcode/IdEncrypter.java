package com.youku.atm.easycast.tdcode;

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
}