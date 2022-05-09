//package com.youku.atm.easycast;
//import java.util.Iterator;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class TestJson {
//
//	public static void main(String[] args) {
//		String str1 = "{'TI':[{'value':'aa1','count':10},{'value':'aa2','count':15},{'value':'aa3','count':20}]}";
//		String str2 = "{'castEmbed':[{'videoId':123,'breakId':'adunit01_start', 'startTime':1200, 'showTime':15 }]}";
//		String str = "{'castEmbed':[{'videoId':123,'breakId':'adunit01_start', 'startTime':1200, 'showTime':15 },{'videoId':456,'breakId':'adunit02_start', 'startTime':1100, 'showTime':15}]}";
//		JSONArray newArray = new JSONArray();
//		//JSONObject newJson = new JSONObject();
//		try {
//			JSONObject obj = new JSONObject(str);
//			Iterator it = obj.keys();
//			while (it.hasNext()) {
//				String key = (String) it.next();
//				System.out.println("key is: " + key);
//				String value = obj.getString(key);
//				System.out.println("value is: " + value);
//				JSONArray array = obj.getJSONArray(key);
//				for(int i=0;i<array.length();i++){
//					JSONObject jsonobject = array.getJSONObject(i);
//					jsonobject.put("name", key);
//					jsonobject.put("exp", key+"="+jsonobject.getString("videoId"));
//					System.out.println(jsonobject.getString("videoId"));
//					System.out.println(jsonobject.getString("breakId"));
//					newArray.put(jsonobject);
//				}
//			}
//			//newJson.put("groups",newArray);
//			//System.out.println(newJson);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//}
