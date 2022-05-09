package com.youku.atm.easycast;

import java.net.URLEncoder;


import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class GetYksInfo {
	
	public static String getData(String idd, int pf) {
		if (!StringUtil.isEmptyString(idd)) {
			//106.11.186.41 vip下线
			StringBuilder urlInfo = new StringBuilder("http://pre-yks.youku.com").append("/yks/get.json?uip=127.0.0.1&vid=").append(idd).append("&pt=video,error,stream&dv=pc&");
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
	
	private static int arraySearch(String[] array, String key) {
		for (int i = 0; i < array.length; i++) {
			if (key.equals(array[i]))
				return i;
		}
		return -1;
	}
	
	public static String getUrlInfo(String type) {

		// TODO Auto-generated method stub
		
		String[] dq = new String[] { "flv", "mp4", "hd2"};
		
	    final String[][] tableStHd = {
	    	    //    dq          hdyks       hdtype      nhd       st
	    	    //   清晰度       K服务接口  清晰度类型 清晰度数字 视频格式	
	    	        /////{"mp4",       "mp4hd",     "mp4",     "1",     "mp4" },
	            {"flv",       "mp4sd",     "flv",     "0",     "mp4" },
	            {"mp4",       "mp4hd",     "mp4",     "1",     "mp4" },
	            {"hd2",       "mp4hd2v2",  "hd2",     "2",     "mp4" },
	            {"3gphd",     "3gphd",     "3gphd",   "0",     "mp4" },
	            {"m3u8",      "mp4sd",     "flv",     "0",     "m3u8"},
	            {"m3u8_mp4",  "mp4hd",     "mp4",     "1",     "m3u8"},
	            {"m3u8_hd2",  "mp4hd2v2",  "hd2",     "2",     "m3u8"},
	            {"m3u8_hd3",  "mp4hd3v2",  "hd3",     "3",     "m3u8"},

	    	    };
		
		int pfMax = arraySearch(dq, "3gphd") >= 0 ? 2 : 1;
		
		for(int pf = 1; pf <= pfMax; pf++) { // 3gphd 要用 pf=2 来获取 其他的都用 pf=1
			String json = null;
			try {
				json = getData("756252221", pf);
				 
				//json = getData("945450111", pf);
				System.out.println(json);
				if (json == null || json.length() == 0) {
					continue;
				}

				JSONObject jobject = JSONObject.fromObject(json);
				if (!jobject.has("dataset") || jobject.getJSONObject("dataset").isNullObject()) {
					continue;
				}
				if (!jobject.getJSONObject("dataset").has("stream")) {
					continue;
				}
				JSONArray streamArray = jobject.getJSONObject("dataset").getJSONArray("stream");
				if (streamArray.isEmpty()) {
					continue;
				}
				for (int i = 0; i < (pf == 2 ? 1 : dq.length); i++) {
					String u = null, st = null, hdstr = null, hdtype = null, hdnum = null,size=null,width=null,height=null;
					String dq1 = pf == 2 ? "3gphd" : dq[i];

					for (int j = 0; j < tableStHd.length; j++) {
						if (tableStHd[j][0].equals(dq1)) {
							hdstr = tableStHd[j][1];
							hdtype = tableStHd[j][2];
							hdnum = tableStHd[j][3];
							st = tableStHd[j][4];
							break;
						}
					}
					if (pf == 1 && dq[i].equals("3gphd")) {
						continue;
					}

					try {
						if (hdstr == null)
							// if(hdstr == null || !streamfileids.has(hdstr))
							continue;

						JSONObject streamObj = null;
						for (int m = 0; m < streamArray.size(); ++m) {
							if (streamArray.getJSONObject(m).has("stream_type")
									&& streamArray.getJSONObject(m).getString("stream_type").equals(hdstr)) {
								streamObj = streamArray.getJSONObject(m);
								break;
							}
						}

						if (streamObj == null) {
							continue;
						}

						if (st.equals("m3u8")) {
							
						} else {
							//String key = streamObj.getJSONArray("segs").getJSONObject(0).getString("key");
							//String fileid = streamObj.getJSONArray("segs").getJSONObject(0).getString("fileid");
							if("size".equals(type)) {
								size=streamObj.getString("size");
								//System.out.println("size is : " + size);
								return size;
							}
							
							if("dimension".equals(type)) {
								width=streamObj.getString("width");
								height=streamObj.getString("height");
								
								//System.out.println("width is : " + width);
								//System.out.println("height is : " + height);
								
								return width + "," + height;
							}
							
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			} catch (JSONException e) {
				//Ec.ADS.log("getFlvUrls error: " + playurl + "\n" + json + "\n\n", e);
			}
			
		}
		return "unok param is wrong";	
	}

	public static void main(String[] args) {
		String size = getUrlInfo("dimension");
		System.out.println(size);
	}

}
