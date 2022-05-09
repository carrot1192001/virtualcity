package com.youku.ad.castv2.virtualcity;

import com.youku.ad.util.Util;
import com.youku.ad.util.CookieManager;

public class VirtualCookie
{
	public static final String virtualCitySecretKey = "2e37e9d369823fbdf230bf4ff8c6d82b";
    
	private String provinceId;
	private String cityId;

	public static long vcityUseCount = 0;
	public static long vcityUseCountNextTime = 0;

	public String getProvinceId() {
		return provinceId;
	}
	public String getCityId() {
		return cityId;
	}

	public boolean valid(CookieManager cookieManager) {
		String ck = cookieManager.getCookie("vcity");
		if(ck == null || ck.length() == 0) {
			return false;
		}
		String[] cks = ck.split("_");
		if(cks.length != 4) {
			return false;
		}
		provinceId = cks[0];
		cityId = cks[1];
		long   expire = parseLong(cks[2]);
		String md5str = cks[3];

		long now = System.currentTimeMillis();
		if(expire < now) {
			return false;
		}

		if(!md5str.equals(makeMD5(provinceId, cityId, expire))) {
			return false;
		}
		if(now > vcityUseCountNextTime) {
			vcityUseCountNextTime = now + 86400000;
			vcityUseCount = 0;
		}
		vcityUseCount ++;

		return true;
	}

	public static String makeMD5(String provinceId, String cityId, long expire) {
		return Util.md5(provinceId + "_" + cityId + "_" + expire + "_" + virtualCitySecretKey);
	}

	static long parseLong(String str) {
		if(str == null || str.length() == 0)
			return 0;
		try{
			return Long.parseLong(str);
		}catch(Exception e){
		}
		return 0;
	}

}
