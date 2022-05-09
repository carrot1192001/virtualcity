/**
 *
 */
package com.youku.atm.easycast;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 视频相关工具
 *
 * @author zhangdawei,zhangyunfeng,tangjiang
 * @date 2015年6月5日
 */
public class VideoUtil {

	private static Pattern regex_vid = Pattern.compile("\\w+X(.+).html?");

	public static String[] preLoadRst = new String[] { "flv", "mp4", "hd2", "3gphd", "m3u8", "m3u8_mp4", "m3u8_hd2",
			"m3u8_hd3" };

    private static final String[][] tableStHd = {
    //    dq          hdyks       hdtype      nhd       st
    //   清晰度       K服务接口  清晰度类型 清晰度数字 视频格式	
        {"flv",       "mp4sd",     "flv",     "0",     "mp4" },
        {"mp4",       "mp4hd",     "mp4",     "1",     "mp4" },
        {"hd2",       "mp4hd2v2",  "hd2",     "2",     "mp4" },
        {"3gphd",     "3gphd",     "3gphd",   "0",     "mp4" },
        {"m3u8",      "mp4sd",     "flv",     "0",     "m3u8"},
        {"m3u8_mp4",  "mp4hd",     "mp4",     "1",     "m3u8"},
        {"m3u8_hd2",  "mp4hd2v2",  "hd2",     "2",     "m3u8"},
        {"m3u8_hd3",  "mp4hd3v2",  "hd3",     "3",     "m3u8"},
    };

    public static int[] seeds = new int[]{9,7,5};

	public static String getVidByUrl(String urlString) {
		if (urlString == null) {
			return "";
		}
		if (!urlString.toLowerCase().startsWith("http")) {
			return calVid(urlString);
		}
		if (urlString.toLowerCase().startsWith(IdeaUrlConstant.PLAYURL.TUDOU_PREFIX)) {
//			String vid = getTdVidByUrlCode(getTdUrlCode(urlString));
//			return vid == null ? "" : vid;
			return "";
		}
		Matcher m = regex_vid.matcher(urlString);
		if (m.find()) {
			String id = m.group(1);
			return calVid(id);
		}
		return "";
	}

	public static String calVid(String code) {
		String id = new String(Base64.decodeBase64(code));
		if (StringUtil.isPositiveInteger(id)) {
			return String.valueOf(Long.valueOf(id) >> 2);
		}
		return "";
	}

	private static String getTdVidByUrlCode(String code) {
		String vid = null;
		JSONObject json = null;
		try {
			String vidUrl = getTdVidUrlByCode(code);
			json = JSONObject.fromObject(vidUrl);
			vid = json.getString("iid");
		} catch (Exception e) {
			//Ec.ADS.log("土豆playurl获得视频VID出错！code=" + code + " json=" + json, e);
		}
		return vid;
	}

	/**
	 * 根据ideaUrl的content获得播放文件地址
	 *
	 * @param playurl
	 * @return
	 */
    public static Map<String, String> getFileUrlByPlayUrl(String playurl) {
		if (playurl.toLowerCase().startsWith(IdeaUrlConstant.PLAYURL.TUDOU_PREFIX)
				&& playurl.toLowerCase().endsWith(IdeaUrlConstant.PLAYURL.POSTFIX)) {
			return VideoUtil.getTdFileUrls(playurl, VideoUtil.preLoadRst);
		} else {
			System.out.println("ok");
			return VideoUtil.getFlvUrlsNew(playurl, VideoUtil.preLoadRst);
		}
	}

    /**
     * 去K服务升级时需要做灰度发布，同时保存K服务地址和CDN地址供灰度发布使用，等完全切到CDN后，此方法及相关逻辑即可废弃
     * @param playurl
     * @return
     */
    @Deprecated
    public static Map<String, String> getFileUrlByPlayUrl_K(String playurl) {
        if (playurl.toLowerCase().startsWith(IdeaUrlConstant.PLAYURL.TUDOU_PREFIX)
                && playurl.toLowerCase().endsWith(IdeaUrlConstant.PLAYURL.POSTFIX)) {
            return VideoUtil.getTdFileUrls(playurl, VideoUtil.preLoadRst);
        } else {
            return VideoUtil.getFlvUrls_K(playurl, VideoUtil.preLoadRst);
        }
    }



    /**
     * 土豆的视频素材按优酷的方式，广告视频不分片返回数据
     *
     * @param playurl
     * @param dqs
     * @return
     */
	public static Map<String, String> getTdFileUrls(String playurl, String... dqs) {
		Map<String, List<String>> resultMap = getTdFileUrls(playurl);
		String vid = getTdVidByUrlCode(getTdUrlCode(playurl));
		// dq -> URL
		Map<String, String> rsMap = null;
		if (resultMap != null) {
			rsMap = new HashMap<String, String>();
			Set<Entry<String, List<String>>> rsSet = resultMap.entrySet();
			for (Entry<String, List<String>> rs : rsSet) {
				// dqNum转换成dq
				String dqNum = rs.getKey();
				String dq = dqNum;
				String m3u8_dq = "";
				if ("1".equals(dqNum) || "2".equals(dqNum) || "12".equals(dqNum)) {
					dq = "flv";
					m3u8_dq = "m3u8";
				} else if ("3".equals(dqNum) || "13".equals(dqNum) || "52".equals(dqNum) || "53".equals(dqNum)
						|| "54".equals(dqNum) || "55".equals(dqNum)) {
					dq = "mp4";
					// 针对m3u8，只要有播放页的视频，它存在的码流率就会有m3u8文件
					// 52,53,54,55是MP4文件，其它2,12,3,13,4,14,5,15，99（原画整段）,19（原画切片）都是f4v文件
					// MP4是安卓H5的,也就是MP4的话是没有m3u8格式
					m3u8_dq = Integer.parseInt(dqNum) > 13 ? "" : "m3u8_mp4";
				} else if ("4".equals(dqNum) || "5".equals(dqNum) || "14".equals(dqNum) || "15".equals(dqNum)) {
					dq = "hd2";
					m3u8_dq = "m3u8_hd";
				}
				// m3u8的暂时这么处理
				if (m3u8_dq.length() > 0) {
					rsMap.put(m3u8_dq, getTdM3U8VideoUrl(vid, dqNum));
				}
				rsMap.put(dq, rs.getValue().get(0));
			}
		}
		return rsMap;
	}

	/**
	 * 获取土豆url的视频素材，分片
	 *
	 * @param playurl
	 * @return
	 */
	public static Map<String, List<String>> getTdFileUrls(String playurl) {
		if (playurl == null || playurl.length() <= 0) {
			return null;
		}

		String jsonStr = getTdPlayListJsonById(getTdUrlCode(playurl));

		// json解析
		// dqNum -> URLs
		Map<String, List<String>> resultMap = null;
		if (jsonStr != null && jsonStr.length() > 0) {
			resultMap = new HashMap<String, List<String>>();
			JSONObject json = JSONObject.fromObject(jsonStr);
			Iterator<?> jsonIt = json.keys();
			while (jsonIt.hasNext()) {
				try {
					String dq = (String) jsonIt.next();
					JSONArray segs = json.getJSONArray(dq);
					if (StringUtil.isNumeric(dq)) {
						putTdFileUrls(resultMap, dq, segs);
					}
				} catch (Exception e) {
					//Ec.ADS.log("土豆playurl转换出错！", e);
				}
			}
		}
		return resultMap;
	}

	/**
	 * 获得土豆URL中的code
	 *
	 * @param playurl
	 * @return
	 */
	private static String getTdUrlCode(String playurl) {
		String urlCode = "";
		try {
			if (playurl.endsWith("/")) {
				playurl = playurl.substring(0, playurl.length() - 1);
			}
			int pos = playurl.lastIndexOf("/");
			if (playurl.contains(IdeaUrlConstant.PLAYURL.POSTFIX)) {
				urlCode = playurl.substring(pos + 1, playurl.lastIndexOf(IdeaUrlConstant.PLAYURL.POSTFIX));
			} else {
				urlCode = playurl.substring(pos + 1, playurl.length());
			}
			return urlCode;
		} catch (Exception e) {
			//Ec.ADS.log("土豆playurl错误：" + playurl, e);
			return null;
		}
	}

	private static void putTdFileUrls(Map<String, List<String>> resultMap, String dq, JSONArray segs) {
		for (int i = 0; i < segs.size(); i++) {
			String segId = segs.getJSONObject(i).getString("k");
			String fileUrl = getTdVideoUrlById2(segId, dq);
			if (fileUrl != null && fileUrl.length() > 0) {
				List<String> fileUrlList = resultMap.get(dq);
				if (fileUrlList == null) {
					fileUrlList = new ArrayList<String>();
					resultMap.put(dq, fileUrlList);
				}
				fileUrlList.add(fileUrl);
			}
		}
	}

	private static String getTdM3U8VideoUrl(String vid, String hd) {
		if (vid != null && vid.length() > 0 && hd != null && hd.length() > 0) {
			return "http://vr.tudou.com/v2proxy/v2.m3u8?debug=1&it=" + vid + "&st=" + hd;
		}
		return null;
	}

	private static String getTdVideoUrlById2(String id, String hd) {
		if (id != null && id.length() > 0 && hd != null && hd.length() > 0) {
			return "http://v2.tudou.com/f?sj=1&ft=redir&id=" + id + "&sid=11000&hd=" + hd;
		}
		return null;
	}

	private static String getTdPlayListJsonById(String id) {
		if (id != null && id.length() > 0) {
			// 加60秒超时
			try {
				return NetUtil.requestGet("http://www.tudou.com/outplay/goto/getItemSegs.action?code=" + id, 600000);
			} catch (IOException e) {
				//Ec.ADS.log("http://www.tudou.com/outplay/goto/getItemSegs.action?code=" + id, e);
			}
		}
		return null;
	}

	private static String getTdVidUrlByCode(String code) {
		if (code != null && code.length() > 0) {
			// 加60秒超时
			try {
				return NetUtil.requestGet("http://www.tudou.com/tvp/getItemInfo.action?ic=" + code, 600000);
			} catch (IOException e) {
				//Ec.ADS.log("http://www.tudou.com/tvp/getItemInfo.action?ic=" + code, e);
			}
		}
		return null;
	}

	/**
	 * 最新版本的取素材url的方法,直接调用接口获取url
	 *
	 * @param playurl
	 * @param dq:该参数的值，如果是移动端实际是dq和rst综合来决定的，如果是pc端，则只会取值为flv/mp4/hd2
	 * @return map的key:dq,value:dq对应的实际素材url
	 */
	@SuppressWarnings("deprecation")
    public static Map<String, String> getFlvUrlsNew(String playurl, String... dq) {
		Map<String, String> map = new HashMap<String, String>();
		String vid = getVidByUrl(playurl);
		String vid64 = getVid64ByUrl(playurl);

		int pfMax = arraySearch(dq, "3gphd") >= 0 ? 2 : 1;

		String sid = "" + new Date().getTime() + (1000 + (new Date().getTime() % 1000))
				+ ((int) (Math.random() * 9000) + 1000);
		String sidNew = "0" + sid.substring(1);
		String token = Integer.toString((int) (Math.random() * 9000) + 1000);

		String m3u8_ep = null, m3u8Md5 = null;
		String now = "" + System.currentTimeMillis();

		for (int pf = 1; pf <= pfMax; pf++) { // 3gphd 要用 pf=2 来获取 其他的都用 pf=1
			String json = null;
			try {
				if ("testing".equals("")) {
					json = getPlayListJsonById(vid, pf);
				} else {
					json = YksUtil.getData(vid, pf);
				}
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
					String u = null, st = null, hdstr = null, hdtype = null, hdnum = null;
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
							m3u8_ep = m3u8_ep != null ? m3u8_ep : URLEncoder.encode(eprac(encrypt50(sid + "_" + vid64
									+ "_" + token + "_ctype50")));
							String secret = "A$ZSzIEu0EQ4NbZLacVhByT1";
							m3u8Md5 = m3u8Md5 != null ? m3u8Md5 : "&m3u8Md5="+EncryptUtil.md5("ctype=50&sid="+sid+"&ups_userid=&ups_ytid=&utid=&vid="+vid64+secret);
							u = "http://pl-ali.youku.com/playlist/m3u8?keyframe=0&vid=" + vid64 + "&type=" + hdtype
									+ "&ts=" + now + "&sid=" + sid + "&ctype=50&token=" + token + "&ev=1&oip="
									+ 0x7f000001 + "&ep=" + m3u8_ep + m3u8Md5;
						} else {
							String key = streamObj.getJSONArray("segs").getJSONObject(0).getString("key");
							String fileid = streamObj.getJSONArray("segs").getJSONObject(0).getString("fileid");
							if (fileid != null) {
								String host = "vali.cp31.ott.cibntv.net";

								String abkey = "A";
								String secret = "A$ZSzIEu0EQ4NbZLacVhByT1";
								// bkey secret "r4Dg5omXgidZtzcs81oY1."
								String vkey = EncryptUtil.md5("/"+fileid+"."+st+"?ctype=50&sid="+sidNew+"_00"+secret);

								String sign = EncryptUtil.md5(sidNew + ":@$ml6eU80E#Fbc.aA4YnbH8aUM9i0cSR0");
								
								String filePath = "/"+fileid+"."+st;
								
								String secKey = genSec(filePath, host);

                                u = "http://" + host + "/youku/" + secKey + filePath + "?sid="
                                        + sidNew + "_00_" + abkey + vkey + "&sign=" + sign
                                        + "&ctype=50&hd=" + hdnum;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (u != null) {
						map.put(dq1, u);
					}
				}
			} catch (JSONException e) {
				//Ec.ADS.log("getFlvUrls error: " + playurl + "\n" + json + "\n\n", e);
			}
		}
		return map;
	}

    private static Map<String, String> getFlvUrls_K(String playurl, String... dq) {

        Map<String, String> map = new HashMap<String, String>();
        String vid = getVidByUrl(playurl);
        String vid64 = getVid64ByUrl(playurl);

        int pfMax = arraySearch(dq, "3gphd") >= 0 ? 2 : 1;

        String sid = "" + new Date().getTime() + (1000 + (new Date().getTime() % 1000))
                + ((int) (Math.random() * 9000) + 1000);
        String sidNew = "0" + sid.substring(1);
        String token = Integer.toString((int) (Math.random() * 9000) + 1000);

        String m3u8_ep = null, m3u8Md5 = null;
        String now = "" + System.currentTimeMillis();

        for (int pf = 1; pf <= pfMax; pf++) { // 3gphd 要用 pf=2 来获取 其他的都用 pf=1
            String json = null;
            try {
                if ("testing".equals("")) {
                    json = getPlayListJsonById(vid, pf);
                } else {
                    json = YksUtil.getData(vid, pf);
                }
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
                int ts = getVideoLength2(jobject);
                if (streamArray.isEmpty()) {
                    continue;
                }
                for (int i = 0; i < (pf == 2 ? 1 : dq.length); i++) {
                    String u = null, st = null, hdstr = null, hdtype = null, hdnum = null;
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
                            if (streamArray.getJSONObject(m).has("stream_type") && streamArray
                                    .getJSONObject(m).getString("stream_type").equals(hdstr)) {
                                streamObj = streamArray.getJSONObject(m);
                                break;
                            }
                        }

                        if (streamObj == null) {
                            continue;
                        }

                        if (st.equals("m3u8")) {
                            m3u8_ep = m3u8_ep != null ? m3u8_ep
                                    : URLEncoder.encode(eprac(encrypt50(
                                            sid + "_" + vid64 + "_" + token + "_ctype50")));
                            String secret = "A$ZSzIEu0EQ4NbZLacVhByT1";
                            m3u8Md5 = m3u8Md5 != null ? m3u8Md5
                                    : "&m3u8Md5=" + EncryptUtil.md5("ctype=50&sid=" + sid
                                            + "&ups_userid=&ups_ytid=&utid=&vid=" + vid64 + secret);
                            u = "http://pl-ali.youku.com/playlist/m3u8?keyframe=0&vid=" + vid64
                                    + "&type=" + hdtype + "&ts=" + now + "&sid=" + sid
                                    + "&ctype=50&token=" + token + "&ev=1&oip=" + 0x7f000001
                                    + "&ep=" + m3u8_ep + m3u8Md5;
                        } else {
                            String key = streamObj.getJSONArray("segs").getJSONObject(0)
                                    .getString("key");
                            String fileid = streamObj.getJSONArray("segs").getJSONObject(0)
                                    .getString("fileid");
                            if (fileid != null) {
                                String abkey = "A";
                                String secret = "A$ZSzIEu0EQ4NbZLacVhByT1";
                                // bkey secret "r4Dg5omXgidZtzcs81oY1."
                                String vkey = EncryptUtil.md5("/" + fileid + "." + st
                                        + "?ctype=50&sid=" + sidNew + "_00" + secret);

                                String sign = EncryptUtil
                                        .md5(sidNew + ":@$ml6eU80E#Fbc.aA4YnbH8aUM9i0cSR0");

                                int tsR = ((int) (Math.random() * 370) + 50);// 420随机数
                                String ep = URLEncoder.encode(eprac(encrypt50(
                                        sidNew + "_" + fileid + "_" + token + "_ctype50")));

                                u = "http://k.youku.com/player/getFlvPath/sid/" + sidNew + "_00_"
                                        + abkey + vkey + "/st/" + st + "/fileid/" + fileid + "?K="
                                        + key + "&hd=" + hdnum + "&myp=0&ts=" + tsR
                                        + (Math.random() <= 0.3 ? "&ymovie=1" : "")
                                        + "&ypp=0&ctype=10&ev=1&token=" + token + "&oip="
                                        + (0x7f000001) + "&sign=" + sign + "&ep=" + ep + "&vl="
                                        + ts;

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (u != null) {
                        map.put(dq1, u);
                    }
                }
            } catch (JSONException e) {
                //Ec.ADS.log("getFlvUrls error: " + playurl + "\n" + json + "\n\n", e);
            }
        }
        return map;
    }

	// 暂无用处啊
	public static String getVid64ByUrl(String urlString) {
		if (urlString == null) {
			return "";
		}
		if (!urlString.toLowerCase().startsWith("http")) {
			return urlString;
		}
		Matcher m = regex_vid.matcher(urlString);
		if (m.find()) {
			String id = m.group(1);
			return "X" + id;
		}
		return "";
	}

	private static int arraySearch(String[] array, String key) {
		for (int i = 0; i < array.length; i++) {
			if (key.equals(array[i]))
				return i;
		}
		return -1;
	}

	private static String getPlayListJsonById(String idd, int pf) {
		if (idd != null && idd.length() > 0) {
			// 加60秒超时
			try {
				if (pf == 1) { // pc
					return NetUtil.requestGet("http://pre-yks.youku.com/yks/get.json?uip=127.0.0.1&vid=" + idd
							+ "&pt=video,error,stream&dv=pc&uid=94210860&ct=50&ext={hasMp4:1}", 600000);
				} else if (pf == 2) { // mobile
					return NetUtil.requestGet("http://pre-yks.youku.com/yks/get.json?uip=127.0.0.1&vid=" + idd
							+ "&pt=video,error,stream&dv=mobile&uid=94210860&ct=50&ext={hasMp4:1}", 600000);
				}
			} catch (IOException e) {
//				Ec.log("http://10.103.188.118/yks/get.json?uip=127.0.0.1&vid=" + idd
//						+ "&pt=video,error,stream&dv=pc&uid=94210860&ct=50", e);
			}
		}
		return null;
	}

    private static int atoi(String s, int radix) {
        try {
            return Integer.parseInt(s, radix);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String genSec(String filePath, String host) {
        StringBuilder sb = new StringBuilder(filePath);

        Random rand = new Random();
        int idx = rand.nextInt(seeds.length);
        int seed = seeds[idx];
        // current timestamp in seconds
        long now = System.currentTimeMillis() / 1000;

        int flvIdx = atoi(sb.substring(9,11), 16);
        int plus = atoi(sb.substring(50,54), 16);
        int ts = atoi(sb.substring(11,19),16);
        long timestamp = (now-ts)*2/7200 + plus;
        long i = timestamp*(seed+flvIdx-1);
        String tmpKey = String.format("%x", i);
        String key ="6" + String.valueOf(seed) + String.valueOf(tmpKey.length()+2);

        int ip;
        String[] tmpIp = host.split("\\.", 4);
        if (tmpIp.length < 4) {
            ip = 0;
        } else {
            int[] ipNum = new int[tmpIp.length];
            for (int j = 1; j < tmpIp.length; j++) {
                ipNum[j] = atoi(tmpIp[j], 10);
            }
            ip = ipNum[3] + ipNum[2]<<8 + ipNum[1]<<16;
        }
        //ip = 0;

        /**
         * payload format
         * [RAND][$seed+1][$len][($ip + $now/3600)*$seed] [RAND]
         * [3B]  [2B]      [1B] [XB]                      [4B]
         */
        int payloadSeed = rand.nextInt(30) + 48;
        String payloadSeedStr = String.format("%x", payloadSeed);
        double payload = ip+now/3600.0;
        String payloadStr = String.format("%x", (int)(payload*(payloadSeed-1)));
        String rand1 = String.format("%x", rand.nextInt(4095-1023)+1023);
        String rand2 = String.format("%x", rand.nextInt(28671-8191)+8191);
        String res = String.format("%s%s%s%s%d%s%s", key, tmpKey, rand1, payloadSeedStr, payloadStr.length(), payloadStr, rand2);
        return res.toUpperCase();
    }


	private static String encrypt50(String str) {
		String des_key = "8b6ddbcc";
		try {
			String r = encrypt(str, des_key);
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String strs = Base64.encodeBase64String(bt);
		strs = strs.replace("\r\n", "").replace("\r", "").replace("\n", "");
		return strs;
	}

	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		byte[] dataWithPadding = data;
		if((data.length % 8) != 0) {
			int newLen = data.length + 8 - (data.length % 8);
			dataWithPadding = Arrays.copyOf(data, newLen);
			for(int i=data.length;i<dataWithPadding.length;i++) {
				dataWithPadding[i] = ' ';
			}
		}

		return cipher.doFinal(dataWithPadding);
	}

	public static int getVideoLength2(JSONObject jo) {
		try {
			if (jo == null || !jo.has("data") || jo.getJSONArray("data").size() == 0
					|| !jo.getJSONArray("data").getJSONObject(0).has("seconds")) {
				return 0;
			}
			String seconds = jo.getJSONArray("data").getJSONObject(0).getString("seconds");
			return Math.round(Float.parseFloat(seconds));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return 15;
	}

	private static String eprac(String str) {
		int r = (int) (Math.random() * 9); // 0-8
		String ep = (r + 1) + str.substring(0, r) + "a" + str.substring(r, r + r) + "c"
				+ str.substring(r + r, str.length());
		return ep;
	}
	
	public static String getUrlByVid(String vid) {
		try {
			if (StringUtil.isPositiveInteger(vid)) {
				String idStr = String.valueOf(Long.valueOf(vid) << 2);
				idStr = new String(Base64.encodeBase64(idStr.getBytes()));
				return new StringBuilder().append(IdeaUrlConstant.PLAYURL.YOUKU_PREFIX).append("/v_show/id_X").append(idStr).append(".html").toString();
			}
		} catch (Exception e) {
			//Ec.ADS.log("Change vid to video url error,please check", e, Ec.DIM_COMMON_ERR);
		}
		return "";
	}
	
	public static void main(String[] args){
		String vid="MjY3MTQ2MDE0OA==";
		System.out.println(calVid(vid));
		System.out.println(getFileUrlByPlayUrl("https://v.youku.com/v_show/id_XMzY0OTE3MTk4MA==.html"));
	}
}
