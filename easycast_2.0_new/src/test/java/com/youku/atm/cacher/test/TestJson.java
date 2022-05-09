//package com.youku.atm.cacher.test;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
//import net.sf.json.JSONObject;
//import net.sf.json.JsonConfig;
//
//import com.youku.atm.busmodule.utils.JSONUtil;
//
//
//
//
//public class TestJson {
//
//		public static final JSONObject toJSON(Object obj)
//		{
//			try
//			{
//				System.err.println("---------------- "+obj.toString());
//				JsonConfig jc = new JsonConfig();
//				jc.setAllowNonStringKeys(true);
//				return JSONObject.fromObject(obj,jc);  
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				return new JSONObject();
//			}
//		}
//		
//		public static void main(String[] args)
//		{
//			MLunbo1 lun = new MLunbo1();
//			Map<Integer,MLunbo1> map1 = new HashMap<Integer,MLunbo1>();
//			Map<String,Map<Integer,MLunbo1>> map = new HashMap<String,Map<Integer,MLunbo1>>();
//			map1.put(1, lun);
//			map.put("3_1", map1);
//			System.out.println(JSONUtil.toJSON(map));
//		}
//
//}
