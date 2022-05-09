package com.youku.atm.cacher.test;

public class TestConvertUrl {
	
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
			url = url.replaceAll("%", "percent_esc");
			url = url.replaceAll("&", "and_esc");
			url = url.replaceAll("#", "sharp_esc");
			url = url.replaceAll("=", "equal_esc");
			url = url.replaceAll("\\?", "interrogation_esc");
			url = url.replaceAll("\\+", "add_esc");
			url = url.replaceAll("\\$", "dollar_esc");
			return url;
			//return URLEncoder.encode(url,"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return url;
		}
	}
	
	public static String covertUrlops(String url) {
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
			url = url.replaceAll("%", "percent_esc");
			url = url.replaceAll("&", "and_esc");
			url = url.replaceAll("#", "sharp_esc");
			url = url.replaceAll("=", "equal_esc");
			url = url.replaceAll("\\?", "interrogation_esc");
			url = url.replaceAll("\\+", "add_esc");
			url = url.replaceAll("\\$", "dollar_esc");
			
			url = url.replaceAll("percent_esc", "%");
			url = url.replaceAll("and_esc", "&");
			url = url.replaceAll("sharp_esc", "#");
			url = url.replaceAll("equal_esc", "=");
			url = url.replaceAll("interrogation_esc", "\\?");
			url = url.replaceAll("add_esc", "\\+");
			url = url.replaceAll("dollar_esc", "\\$");
			
			return url;
			//return URLEncoder.encode(url,"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return url;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String afterconvert= TestConvertUrl.covertUrl("https://t.6kw.com/index.php?tuiId=100589__IDFA__&muid=__IDFAMD5__&callback=_callback_&noredirect=true");
		System.out.println(afterconvert);
		
		String backToOriginal = TestConvertUrl.covertUrlops("http://uri6.com/tkio/BBN7Nnainterrogation_escidfaequal_escsharp_escsharp_escIDFAsharp_escsharp_escand_escmuidequal_escsharp_escsharp_escIDFAMD5sharp_escsharp_escand_esccallbackequal_escsharp_esccallbacksharp_escand_escnoredirectequal_esctrue");
				System.out.println(backToOriginal);
	}

}
