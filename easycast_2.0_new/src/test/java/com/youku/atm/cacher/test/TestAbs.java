package com.youku.atm.cacher.test;

import java.util.Date;

public class TestAbs extends PrivateClass2{

	@Override
	protected String test() {
		
		return null;
	}
	
	public static void main(String[] args) {
		
		System.out.println(System.currentTimeMillis());
		int i = 185200560;
		System.out.println(i);
		int kk;
		if(true){
			kk = 2;
		}else{
			kk = 3;
		}

		System.out.println(kk);
		String startWith = "gary";
		if(!startWith.startsWith("k")){
			System.out.println(new Date());
			System.out.println(System.currentTimeMillis());
			System.out.println(new Date(System.currentTimeMillis()));
			//new Date
		}
	}
	
	

}
