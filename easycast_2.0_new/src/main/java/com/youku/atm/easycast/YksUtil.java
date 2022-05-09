package com.youku.atm.easycast;

import java.util.HashMap;
import java.util.Map;

public class YksUtil {

	//private static YksService yksService;

	public static String getData(String idd, int pf) {
		//106.11.186.41 vip 下线
				String yksUrl = "http://pre-yks.youku.com";
				if (!StringUtil.isEmptyString(idd)) {
					StringBuilder urlInfo = new StringBuilder(yksUrl).append("/yks/get.json?uip=127.0.0.1&vid=").append(idd).append("&pt=video,error,stream&dv=pc&");
					try {
						if (pf == 1) {
							urlInfo.append("dv=pc");
						}
						if (pf == 2) {
							urlInfo.append("dv=mobile");
						}
						urlInfo.append("&uid=94210860&ct=50&ext={hasMp4:1}");
						return NetUtil.requestGet(urlInfo.toString(), 600000);
					} catch (Exception e) {
						//Ec.CENTER.log("yksService error: " + urlInfo.toString(), e);
					}
				}
				return null;
			}
}
