package com.youku.atm.easycast;

import java.util.HashMap;
import java.util.Map;

/**
 * @author licuihua
 * @date 2013-6-5
 */
public class VideoIdeaTotalService {
	protected Map<String,String> ideaMap = new HashMap<String,String>();
	protected static Map<String,String> adtypePositionMap = new HashMap<String,String>();//视频类广告投放类型和广告位的映射关系
	static
	{
		
		adtypePositionMap.put("1","1");
		adtypePositionMap.put("2","2");
		adtypePositionMap.put("4","3");
		adtypePositionMap.put("15","4");
		adtypePositionMap.put("20","6");
		adtypePositionMap.put("66","7");
		adtypePositionMap.put("99","8");
		adtypePositionMap.put("86","9");
		adtypePositionMap.put("87","10");
		adtypePositionMap.put("88","11");
		adtypePositionMap.put("24","12");
		adtypePositionMap.put("25","13");
		adtypePositionMap.put("26","14");
		adtypePositionMap.put("27","15");
		adtypePositionMap.put("28","16");
		adtypePositionMap.put("29","17");
		adtypePositionMap.put("30","18");
		adtypePositionMap.put("31","19");
		adtypePositionMap.put("43","20");
		adtypePositionMap.put("45","22");
		adtypePositionMap.put("46","23");
		adtypePositionMap.put("48","45");
		adtypePositionMap.put("49","49");
		adtypePositionMap.put("50","50");
		adtypePositionMap.put("160","60");
		adtypePositionMap.put("161","61");
		adtypePositionMap.put("162","62");
		adtypePositionMap.put("163","63");
		adtypePositionMap.put("164","64");
		adtypePositionMap.put("165","65");
		adtypePositionMap.put("166","66");
		adtypePositionMap.put("167","67");
		adtypePositionMap.put("168","68");
		adtypePositionMap.put("169","69");
		adtypePositionMap.put("70","70");
		adtypePositionMap.put("71","71");
		adtypePositionMap.put("72","72");
		adtypePositionMap.put("73","73");
		adtypePositionMap.put("74","74");
		adtypePositionMap.put("75","75");
		adtypePositionMap.put("76","76");		
		adtypePositionMap.put("1100","3164");
		adtypePositionMap.put("80","80");
	}
	
	public static int getPositionIdByAdType(int ad_type_id){
		return Integer.parseInt(adtypePositionMap.get(ad_type_id+""));
	}
}
