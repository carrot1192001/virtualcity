package com.youku.atm.cacher.test;

public class TestAppSearchBannerTemplate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String newJs = "SCRIPT_START var "+"img_"+idea_id+"= document.createElement(\"img\");";
//        newJs = newJs+"img_"+idea_id+".width=0;";
//        newJs = newJs+"img_"+idea_id+".height=0;";
//        newJs = newJs+"img_"+idea_id+".src=\""+app_search_banner_youkupip_showurl+"\";";
//        newJs = newJs+"document.getElementsByTagName('HEAD').item(0).appendChild("+"img_"+idea_id+");";
//        newJs = newJs +" SCRIPT_END ";
		String template ="HTML_START<div align=\"center\" class=\"mod\" id=\"s_h_!ideaid!\"><a href=\"http://vid.atm.youku.com/htmlclick?p=!positionid!&pp=!ppositionid!&pg=!pageid!&&ca=!castid!&ie=!ideaid!&k=!key!&u=!u!&uri=!userID!\" target=\"_blank\"><img src=\"!RES!\" border=\"0\"/></a></div>HTML_END";
System.out.println(template);
	}

}


