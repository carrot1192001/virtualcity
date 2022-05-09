package com.youku.atm.cacher.test;

public class TestJiecheng {
	public static void main(String[] args) {
		System.out.println(trytest());
	}

	private static int trytest() {
		try {
			return 1;
		} finally {
			return 2;
		}
	}
}


