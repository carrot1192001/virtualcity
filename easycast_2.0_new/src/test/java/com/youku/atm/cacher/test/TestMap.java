package com.youku.atm.cacher.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap ;
import java.util.Map ;
import java.util.Iterator ;
import java.util.Set ;
public class TestMap{
	public static void main(String args[]){
		Map<Long,String> map = null; // 声明Map对象，其中key和value的类型为String
		map = new HashMap<Long,String>() ;
		map.put(1L,"www.mldn.cn") ;	// 增加内容
		map.put(2L,"www.zhinangtuan.net.cn") ;	// 增加内容
		map.put(3L,"www.mldnjava.cn") ;	// 增加内容
//		Set<Long> keys = map.keySet() ;	// 得到全部的key
//		Iterator<Long> iter = keys.iterator() ;
//		while(iter.hasNext()){
//			Long str = iter.next() ;
//			//System.out.print(str + "、") ;
//			System.out.println("key is : " + str);
//		}
		System.out.println(map.get(1L));
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//		try {
//			System.out.println(sdf.parse(sdf.format(new Date())));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		try {
			System.out.println(sdf2.parse(sdf1.format(new Date())+" 23:59:59"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
