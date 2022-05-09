package com.youku.atm.easycast;

public class landingPageCover {
	
	public static String covertUrl(String url) {
		try {
			/*老版本的替换规则，有冲突，改进
			url=url.replaceAll("%", "!9999!");	
			url=url.replaceAll("&", "!url!");
			url=url.replaceAll("#", "!35!");
			url=url.replaceAll("=", "!61!");
			url=url.replaceAll("\\?", "!63!");
			url=url.replaceAll("×", "!215!");
			url=url.replaceAll("\\+", "!20!");
			 */			
			url = url.replaceAll("percent_esc", "%");
			url = url.replaceAll("and_esc", "&");
			url = url.replaceAll("sharp_esc", "#");
			url = url.replaceAll("equal_esc", "=");
			url = url.replaceAll("interrogation_esc", "\\\\?");
			url = url.replaceAll("add_esc", "\\\\+");
			url = url.replaceAll("dollar_esc", "\\\\$");
			return url;
			//return URLEncoder.encode(url,"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return url;
		}
	}
	
	public static void main(String[] args) {
		
		String afterConvertUrl = covertUrl("https://ad.doubleclick.net/ddm/trackclk/N4517.3177147YOUKU-APPLE/B20690981.214229613;dc_trk_aidequal_esc413188675;dc_trk_cidequal_esc97571915;dc_latequal_esc;dc_rdidequal_esc;tag_for_child_directed_treatmentequal_escinterrogation_eschttps://itunes.apple.com/WebObjects/MZStore.woa/wa/viewFeatureinterrogation_escidequal_esc1318750618and_escmtequal_esc1and_esclsequal_esc1and_escappequal_escmusicinterrogation_esclsequal_esc1and_escmtequal_esc1and_escappequal_escmusicand_escitscgequal_esc9103and_escatequal_esc1000lGLand_escctequal_esc021218-cn-m-CNY-youkumidgeshou-cny");
		System.out.println(afterConvertUrl);
	}

}
