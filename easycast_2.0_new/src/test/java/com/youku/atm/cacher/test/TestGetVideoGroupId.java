//package com.youku.atm.cacher.test;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import com.tudou.itemcodecrypt.ItemCodeCrypt;
//import com.youku.atm.easycast.Util;
//
//public class TestGetVideoGroupId {
//	
//	String getVideoGroupId(String video_group_area1){
//		String vids[] = video_group_area1.split("\r?\n");
//		String vid_str = "";
//		String playlist_str = "";
//		for (int i = 0; i < vids.length; i++) {
//			String tmp = vids[i];
//			tmp = tmp.replaceAll("\\s", "");
//			if ("".equals(tmp))
//				continue;
//			try {
//				vid_str += getResult(tmp);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return vid_str;
//
//	}
//	
//	String getResult(String urlString) throws Exception {
//
//		if (urlString == null) {
//			return "";
//		}
//
//		if (!urlString.toLowerCase().startsWith("http")) {
//			return urlString;
//		}
//
//		String regex = "\\w+X(.+).html";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(urlString);
//
//		if (m.find()) {
//			String id = m.group(1);
//			id = Util.decodeBase64(id);
//			int idd = Integer.parseInt(id) >> 2;
//			return idd + "";
//		}
//
//		return "";
//	}
//	
//	String insertVideoGroupTD(String video_group_area1) {
//		Set<String> vgset = new HashSet();
//		String playlist_str = "";
//		try {
//			String vid_str = "";
//
//			Pattern tudouPattern = Pattern
//					.compile(
//							"http\\:\\/\\/\\w+\\.tudou\\.com/programs/view/([a-zA-Z_0-9\\-]{11}).*|"
//									+ // 单视频播放页
//									"http\\:\\/\\/\\w+\\.tudou\\.com/playlist/id/?(\\d+)|"
//									+ "http\\:\\/\\/\\w+\\.tudou\\.com/playlist/album/id(\\d+).html|"
//									+ "http\\:\\/\\/\\w+\\.tudou\\.com/playlist/p/a(\\d+).html|"
//									+ "http\\:\\/\\/\\[作品\\](\\d+)-.*|"
//									+ //作品正则表达式匹配
//									"http\\:\\/\\/\\w+\\.tudou\\.com/albumcover/([a-zA-Z_0-9\\-]{11}).html|"
//									+ //剧集过渡页改版、剧集封面 
//									"http\\:\\/\\/\\w+\\.tudou\\.com/listcover/([a-zA-Z_0-9\\-]{11}).html|"
//									+
//
//									"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
//									+ // 豆单播放页 
//									"http\\:\\/\\/\\w+\\.tudou\\.com/listplay/([a-zA-Z_0-9\\-]{11}).html|"
//									+ // 豆单播放页 
//									"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
//									+ // 剧集播放页
//									"http\\:\\/\\/\\w+\\.tudou\\.com/albumplay/([a-zA-Z_0-9\\-]{11}).html|"
//									+ // 剧集播放页
//									"http\\:\\/\\/\\w+\\.tudou\\.com/oplay/[a-zA-Z_0-9\\-]{11}/([a-zA-Z_0-9\\-]{11}).html|"
//									+ // 周边播放页
//									"http\\:\\/\\/\\w+\\.tudou\\.com/plcover/([a-zA-Z_0-9\\-]{11}).*|"
//									+ //// 豆单封面
//									"(\\d+)", Pattern.CASE_INSENSITIVE);
//
//			if (video_group_area1 != null && video_group_area1.length() != 0) {
//				Matcher m = tudouPattern.matcher(video_group_area1);
//				String tudou_vids = "";
//
//				List<Long> lidlist = new ArrayList<Long>();
//				List<Long> aidlist = new ArrayList<Long>();
//
//				while (m.find()) {
//					try {
//						boolean b = m.matches();
//						if (b) {
//							tudou_vids += video_group_area1 ;
//						} else {
//							tudou_vids += video_group_area1 + "(无法匹配)";
//						}
//						if (m.group(1) != null) {
//							vid_str += ""
//									+ ItemCodeCrypt.getItemId(m.group(1));
//						} else if (m.group(2) != null) {
//							Long pid = stringToLong(m.group(2), -1);
//							if (pid != -1)
//								lidlist.add(pid);
//						} else if (m.group(3) != null) {
//							Long albumId = stringToLong(m.group(3), -1);
//							if (albumId != -1)
//								vid_str += "" + m.group(14) ;
//						} else if (m.group(4) != null) {
//							Long albumId = stringToLong(m.group(4), -1);
//							if (albumId != -1)
//								aidlist.add(albumId);
//						} else if (m.group(6) != null) { //剧集过渡页改版      
//							Long albumId = ItemCodeCrypt.getItemId(m.group(6));
//							if (albumId != -1)
//								aidlist.add(albumId);
//						} else if (m.group(7) != null) {
//							Long pid = ItemCodeCrypt.getItemId(m.group(7));
//							if (pid != -1)
//								lidlist.add(pid);
//						} else if (m.group(8) != null) {
//							Long pid = ItemCodeCrypt.getItemId(m.group(8));
//							if (pid != -1)
//								vid_str += "" + pid.toString() ;
//						} else if (m.group(9) != null) {
//							Long pid = ItemCodeCrypt.getItemId(m.group(9));
//							if (pid != -1)
//								lidlist.add(pid); // 节目、豆单
//						} else if (m.group(10) != null) {
//							Long pid = ItemCodeCrypt.getItemId(m.group(10));
//							if (pid != -1)
//								vid_str += "" + pid.toString() ;
//						} else if (m.group(11) != null) {
//							Long pid = ItemCodeCrypt.getItemId(m.group(11));
//							if (pid != -1)
//								aidlist.add(pid); // 节目、非豆单
//						} else if (m.group(12) != null) {
//							Long pid = ItemCodeCrypt.getItemId(m.group(12));
//							if (pid != -1)
//								vid_str += "" + pid.toString() ;
//						} else if (m.group(13) != null) {
//							Long pid = ItemCodeCrypt.getItemId(m.group(13));
//							if (pid != -1)
//								lidlist.add(pid); // 节目、豆单
//						} else if (m.group(14) != null) {
//							vid_str += "" + m.group(14);
//						}
//						return vid_str;
//						
//					} catch (Exception e) {
//						System.out.println("Failed to parse item url "
//								+ m.group());
//					}
//				}
//			}
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		
//		return "null exception";
//		
//
//	}
//	
//	public static Long stringToLong(String stringValue, long defaultValue) {
//		Long intValue = defaultValue;
//		if (stringValue != null) {
//			try {
//				intValue = Long.parseLong(stringValue);
//			} catch (NumberFormatException ex) {
//				intValue = defaultValue;
//			}
//		}
//		return intValue;
//	}
//	
//	public static void main(String[] args) {
//		TestGetVideoGroupId ll = new TestGetVideoGroupId();
//		//System.out.println(ll.getVideoGroupId("http://v.youku.com/v_show/id_XNzQwNDYyNDg4.html")+"test");
//		//http://www.tudou.com/albumplay/hN4YldIJscA/hBFW03RYtgw.html
//		
//		//System.out.println(ll.getVideoGroupId("http://www.tudou.com/albumplay/hN4YldIJscA/hBFW03RYtgw.html"));
//		
//		System.out.println(ll.insertVideoGroupTD("http://www.tudou.com/programs/view/N3EkZXsiQLI/")+"test");
//	}
//
//}
