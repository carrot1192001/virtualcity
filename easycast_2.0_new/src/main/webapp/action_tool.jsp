<%@page import="org.apache.jcs.utils.timing.SleepUtil"%>
<%@page import="java.util.*"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.io.IOException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="org.apache.torque.util.Criteria"%>
<%@page import="com.youku.atm.easycast.*"%>
<%@page import="com.youku.atm.om.*"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="org.apache.torque.TorqueException"%>
<%@page import="org.apache.torque.util.Criteria"%>
<%@page import="org.apache.torque.Torque"%>
<%@page import="com.youku.atm.easycast.DBConnection"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="com.youku.atm.busmodule.utils.LogUtil"%>
<%@page import="com.youku.atm.easycast.Util"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>

<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="redis.clients.jedis.Jedis"%>
<%@page import="redis.clients.jedis.JedisPoolConfig"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final Log logger = LogUtil.getLog();
	private static Jedis jedis;

	//	private static final Log logger = LogUtil.getLog();
	//private String a = null;
	String update_date(String cast_id, String cast_priority, String idea_id,String idea_id_norevert) {
		try {
			String root = getServletContext().getRealPath("/");
			Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
			String a;
			if (idea_id != null && !"".equals(idea_id)) {
				//int idea_id_int = Integer.parseInt(idea_id);
				DBConnection.getInstance("atm").execSql("update idea_time set status = 0 where idea_id in ( " + idea_id + ")");
			}			
			if (idea_id_norevert != null && !"".equals(idea_id_norevert)) {
				//int idea_id_int = Integer.parseInt(idea_id);
				DBConnection.getInstance("atm").execSql(
						"update ad_cast set status = 0 where id in (select cast_id from idea where id = "
								+ idea_id_norevert + ")");
			}
			if (cast_id != null && !"".equals(cast_id) && cast_priority != null
					&& !"".equals(cast_priority)) {
				//int cast_id_int = Integer.parseInt(cast_id);
				//int cast_priority_int = Integer.parseInt(cast_priority);
				DBConnection.getInstance("atm").execSql("update ad_cast set type_priority = " + cast_priority + " where id in (" + cast_id + ")");		
			}
		} catch (Exception e) {
			System.out.println(e);
			logger.error(e.getStackTrace(), e);
			System.out.println("***************" + e.getStackTrace());
			logger.error(e.getStackTrace(), e);
		}
		return "ok";
	}	
	String update_Idea_url_id(String idea_id,String idea_url){
		String update_url_sql = "";
		int showtime = 0;
		String update_showtime = "";
		if(idea_id != null && !"".equals(idea_id)&& idea_url != null && !"".equals(idea_url)){
			idea_url = idea_url.replace("\'","''");
			update_url_sql = "update idea_url set content = '" + idea_url + "' where idea_id = " + idea_id + ";";
			DBConnection.getInstance("atm").execSql(update_url_sql);
			//check showtime
			showtime = EasyCastUtil.getVideoLength(idea_url);
			update_showtime = "update idea set showtime = '" + showtime + "' where id = " + idea_id + ";";
			DBConnection.getInstance("atm").execSql(update_showtime);		
		}	
		return "ok";
	}	
	String update_Idea_url_id_click(String idea_id_url_click,String update_idea_url_click){
		String update_url_sql = "";
		if(idea_id_url_click != null && !"".equals(idea_id_url_click)&&
				update_idea_url_click != null && !"".equals(update_idea_url_click)){
			//update_idea_url_click = update_idea_url_click.replace("\'","''");
			//covertUrl(update_idea_url_click);
			update_url_sql = "update idea_monitor set url = '" + update_idea_url_click + "' where idea_id = " + idea_id_url_click + " and type = 1" + ";";
			DBConnection.getInstance("atm").execSql(update_url_sql);
		}	
		return "ok";
	}
	//idea_monitor type=1或者type=10 才做替换(todo)-类型：1=点击地址/10自定义点击跳转地址
	 String covertUrl(String url) {
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
	
	String urlEncode(String url_encode){
		try{
			if(url_encode != null && !"".equals(url_encode)){
				return URLEncoder.encode(url_encode,"utf-8");
			}else{
				return "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "ok";
	}
	String delayDate(String startDate_date, String endDate_date, String delay_idea_id) throws Exception {
		long day;
		Date temp;
		Date temp_1;
		Date temp_3;
		Date temp_4;
		Date temp_5;
		Date temp_6;
		Date temp_7;
		if (startDate_date != null && !"".equals(startDate_date) && endDate_date != null && !"".equals(endDate_date) && delay_idea_id != null && !"".equals(delay_idea_id)) {
			Date startDate = sdf.parse(startDate_date);
			Date endDate = sdf.parse(endDate_date);
			int delay_idea_id_int = Integer.parseInt(delay_idea_id);
			//check ad_cast.cast_way
			String sql1 = "select cast_way from ad_cast where id in(select cast_id from idea where id = " + delay_idea_id_int + ");";
			ArrayList al2 = DBConnection.getInstance("atm").execQuerySql7(sql1);
			String c = (al2.get(0).toString()).substring(1, al2.get(0).toString().length() - 1) + "";
			System.out.println("cast_way is: " + c);	
			//check ad_cast.ad_type_id
			String sql11 = "select ad_type_id from ad_cast where id in(select cast_id from idea where id = " + delay_idea_id_int + ");";      
			System.out.println("sql11 is : " + sql11);
			ArrayList al22 = DBConnection.getInstance("atm").execQuerySql6(sql11);
			String cc = (al22.get(0).toString()).substring(1, al22.get(0).toString().length() - 1) + "";
			System.out.println("ad_cast.ad_type_id is : " + cc);			
			if (c.contains("cpm")&&!cc.contains("1100")) {
				System.out.println("delay-1###################################################################");
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp = startDate;
				Calendar calendar;
				while (temp.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp);
					try {
						Dc dc = new Dc();
						dc.setTargetDate(temp);
						//dc.setCpc(10);
						dc.setCpm(1000);
						dc.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp = EasyCastUtil.getTomorrow(temp);
				}
				//get dc_id
				String sql = "select id from dc order by id desc limit " + day + ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
				int kk[] = new int[al1.size()];
				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
					int k = Integer.parseInt(aaa);
					kk[iii] = k;
				}
				//swap pos
				//int[] nums = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < kk.length / 2; i++) {
					int temp_2 = kk[i];
					kk[i] = kk[kk.length - i - 1];
					kk[kk.length - i - 1] = temp_2;
				}
				temp_1 = startDate;
				int j = 0;
				while (temp_1.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_1);
					//++j;
					try {
							IdeaTime ideaTime = new IdeaTime();
							ideaTime.setIdeaId(delay_idea_id_int);
							ideaTime.setStatus(1);
							ideaTime.setStarttime(calendar.getTime());				
							calendar.set(Calendar.HOUR, 23);
							calendar.set(Calendar.MINUTE, 59);
							calendar.set(Calendar.SECOND, 59);
							ideaTime.setEndtime(calendar.getTime());
							ideaTime.setDcId(kk[j]);
							ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					j++;
					temp_1 = EasyCastUtil.getTomorrow(temp_1);
				}

			} else if(c.contains("lun")){
				System.out.println("delay-2###################################################################");
				String sql2 = "select lun from cast_cpm where cast_id in(select cast_id from idea where id = " + delay_idea_id_int + ") order by id desc limit 1;";
				ArrayList al3 = DBConnection.getInstance("atm").execQuerySql7(sql2);
				String c2 = (al3.get(0).toString()).substring(1, al3.get(0).toString().length() - 1) + "";
				System.out.println("lun is: " + c2);
				String sql4 = "select cast_id from cast_cpm where cast_id in(select cast_id from idea where id = " + delay_idea_id_int + ") order by id desc limit 1;";
				ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
				String d1 = (al4.get(0).toString()).substring(1, al4.get(0).toString().length() - 1) + "";
				int i1 = Integer.parseInt(d1);			
				day = (endDate.getTime() - startDate.getTime())/ (24 * 60 * 60 * 1000) + 1;
				temp_4 = startDate;
				Calendar calendar;
				while (temp_4.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_4);
					try {
						CastCpm castcpm = new CastCpm();
						castcpm.setCastId(i1);
						castcpm.setCpm(0);
						castcpm.setCpc(0);
						castcpm.setLun(c2);
						castcpm.setPercent(0);
						castcpm.setTargetDate(temp_4);
						castcpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_4 = EasyCastUtil.getTomorrow(temp_4);
				}			
				temp_3 = startDate;
				while (temp_3.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_3);
					//++j;
					try {
							IdeaTime ideaTime = new IdeaTime();
							ideaTime.setIdeaId(delay_idea_id_int);
							ideaTime.setStatus(1);
							ideaTime.setStarttime(calendar.getTime());
							calendar.set(Calendar.HOUR, 23);
							calendar.set(Calendar.MINUTE, 59);
							calendar.set(Calendar.SECOND, 59);
							ideaTime.setEndtime(calendar.getTime());
							ideaTime.setDcId(0);
							ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_3 = EasyCastUtil.getTomorrow(temp_3);
				}
			}else if(c.contains("cpp")){
				System.out.println("delay-3###################################################################");
				day = (endDate.getTime() - startDate.getTime())/ (24 * 60 * 60 * 1000) + 1;
				temp = startDate;
				Calendar calendar;
				while (temp.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp);
					try {
						Dc dc = new Dc();
						dc.setTargetDate(temp);
						//dc.setCpc(10);
						dc.setCpp(1000);
						dc.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp = EasyCastUtil.getTomorrow(temp);
				}
				//get dc_id
				String sql = "select id from dc order by id desc limit " + day + ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
				int kk[] = new int[al1.size()];
				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
					int k = Integer.parseInt(aaa);
					kk[iii] = k;
				}
				//swap pos
				//int[] nums = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < kk.length / 2; i++) {
					int temp_2 = kk[i];
					kk[i] = kk[kk.length - i - 1];
					kk[kk.length - i - 1] = temp_2;
				}               
				temp_1 = startDate;
				int j = 0;
				while (temp_1.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_1);
					//++j;
					try {
							IdeaTime ideaTime = new IdeaTime();
							ideaTime.setIdeaId(delay_idea_id_int);
							ideaTime.setStatus(1);
							ideaTime.setStarttime(calendar.getTime());							
							calendar.set(Calendar.HOUR, 23);
							calendar.set(Calendar.MINUTE, 59);
							calendar.set(Calendar.SECOND, 59);
							ideaTime.setEndtime(calendar.getTime());
							ideaTime.setDcId(kk[j]);
							ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					j++;
					temp_1 = EasyCastUtil.getTomorrow(temp_1);
				}			
			}else if(c.contains("cpv")){
				System.out.println("delay-4###################################################################");
				day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000) + 1;
				temp = startDate;
				Calendar calendar;
				while (temp.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp);
					try {
						Dc dc = new Dc();
						dc.setTargetDate(temp);
						//dc.setCpc(10);
						dc.setCpv(1000);
						dc.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp = EasyCastUtil.getTomorrow(temp);
				}
				//get dc_id
				String sql = "select id from dc order by id desc limit " + day + ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
				int kk[] = new int[al1.size()];
				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
					int k = Integer.parseInt(aaa);
					kk[iii] = k;
				}
				//swap pos
				//int[] nums = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < kk.length / 2; i++) {
					int temp_2 = kk[i];
					kk[i] = kk[kk.length - i - 1];
					kk[kk.length - i - 1] = temp_2;
				}              
				temp_1 = startDate;
				int j = 0;
				while (temp_1.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_1);
					//++j;
					try {
							IdeaTime ideaTime = new IdeaTime();
							ideaTime.setIdeaId(delay_idea_id_int);
							ideaTime.setStatus(1);
							ideaTime.setStarttime(calendar.getTime());						
							calendar.set(Calendar.HOUR, 23);
							calendar.set(Calendar.MINUTE, 59);
							calendar.set(Calendar.SECOND, 59);
							ideaTime.setEndtime(calendar.getTime());
							ideaTime.setDcId(kk[j]);
							ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					j++;
					temp_1 = EasyCastUtil.getTomorrow(temp_1);
				}			
			}			
			if(cc.contains("1100")&&c.contains("cpm")){
				System.out.println("delay-5###################################################################");
				System.out.println("cc is: " + cc);
			    String sql5 = "select cast_id from idea where id = " + delay_idea_id_int + ";";
				ArrayList al5 = DBConnection.getInstance("atm").execQuerySql6(sql5);
				String d5 = (al5.get(0).toString()).substring(1, al5.get(0).toString().length() - 1) + "";
				int i5 = Integer.parseInt(d5);				
				day = (endDate.getTime() - startDate.getTime())/ (24 * 60 * 60 * 1000) + 1;
				temp_5 = startDate;
				Calendar calendar;
				while (temp_5.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_5);
					try {
						VhcastCpm vhcastcpm = new VhcastCpm();
						vhcastcpm.setCastId(i5);
						vhcastcpm.setCpm(1000);
						vhcastcpm.setCpc(0);
						vhcastcpm.setLun("");
						vhcastcpm.setPercent(0);
						vhcastcpm.setTargetDate(temp_5);
						vhcastcpm.save();
						Dc dc = new Dc();
						dc.setTargetDate(temp_5);
						//dc.setCpc(10);
						dc.setCpm(1000);
						dc.save();									
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_5 = EasyCastUtil.getTomorrow(temp_5);
				}			
				temp_6 = startDate;
				while (temp_6.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_6);
					//++j;
					try {
						    VhideaCpm vhideaCpm = new VhideaCpm();
							vhideaCpm.setIdeaId(delay_idea_id_int);						
							vhideaCpm.setCpm(1000);
							vhideaCpm.setCpc(0);
							vhideaCpm.setRate(0);
							vhideaCpm.setTargetDate(temp_6);
							vhideaCpm.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					temp_6 = EasyCastUtil.getTomorrow(temp_6);
				}			
				//get dc_id
				String sql = "select id from dc order by id desc limit " + day + ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(sql);
				int kk[] = new int[al1.size()];
				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1.get(0).toString().length() - 1) + "";
					int k = Integer.parseInt(aaa);
					kk[iii] = k;
				}
				//swap pos
				//int[] nums = { 1, 2, 3, 4, 5, 6 };
				for (int i = 0; i < kk.length / 2; i++) {
					int temp_2 = kk[i];
					kk[i] = kk[kk.length - i - 1];
					kk[kk.length - i - 1] = temp_2;
				}			
				temp_7 = startDate;
                int j = 0;
				while (temp_7.compareTo(endDate) <= 0) {
					calendar = Calendar.getInstance();
					calendar.setTime(temp_7);
					//++j;
					try {
						VhideaTime ideaTime = new VhideaTime();
							ideaTime.setIdeaId(delay_idea_id_int);
							ideaTime.setStatus(1);
							ideaTime.setStarttime(calendar.getTime());						
							calendar.set(Calendar.HOUR, 23);
							calendar.set(Calendar.MINUTE, 59);
							calendar.set(Calendar.SECOND, 59);
							ideaTime.setEndtime(calendar.getTime());
							ideaTime.setDcId(kk[j]);
							ideaTime.save();
					} catch (Exception e) {
						e.printStackTrace();
					}
					j++;
					temp_7 = EasyCastUtil.getTomorrow(temp_7);			
				}						
				}
		}
		return "ok";
	}	
	
	//重启服务器
/* 	void resinRestart(){
		try {
			SSH ssh = new SSH("10.10.72.208", 22022, "root", "adtest208");
			//ssh.execCommand("cd /;ls -l> out.txt");
			//ssh.execCommand("cd /opt/ligang;mysql;source atm-schema_2014_06_12.sql");
			//ssh.execCommand("mkdir ligangnew_new");
			ssh.execCommand("service resin restart");
			ssh.closeconn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void resinRestart1(){
		try {
			SSH ssh = new SSH("10.10.72.207", 22022, "root", "adtest207");
			//ssh.execCommand("cd /;ls -l> out.txt");
			//ssh.execCommand("cd /opt/ligang;mysql;source atm-schema_2014_06_12.sql");
			//ssh.execCommand("mkdir ligangnew_new");
			ssh.execCommand("service resin restart");
			ssh.closeconn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */
	
	void tairOpt(String opt,String tairName,String key,String value){}	
	
	String FileContentMd5(String file_content_md5){
		
        try {
    		return IdeaMd5Util.getUrlFileMd5(file_content_md5, "urlContentMd5","/opt");
        } catch (Exception ex) {
        	return "exception";
        }
	}
	%>
<%
	String cast_id = request.getParameter("cast_id");
	String cast_priority = request.getParameter("cast_priority");
	String idea_id = request.getParameter("idea_id");

	String startDateRow = request.getParameter("startDateRow");
	String endDateRow = request.getParameter("endDateRow");

	String delay_idea_id = request.getParameter("delay_idea_id");
	
	String idea_id_norevert = request.getParameter("idea_id_norevert");
	
	String idea_id_url = request.getParameter("idea_id_url");
	
	String update_idea_url = request.getParameter("update_idea_url");
	
	String idea_id_url_click = request.getParameter("idea_id_url_click");
	
	String update_idea_url_click = request.getParameter("update_idea_url_click");
	
	String update_idea_url_convert = covertUrl(update_idea_url_click.replace("\'","''"));
	
	//is_resin_restart
	String is_resin_restart = request.getParameter("is_resin_restart");
	
	String is_resin_restart1 = request.getParameter("is_resin_restart1");
	
	String idea_url_encode = request.getParameter("idea_url_encode");

	String delayDate = delayDate(startDateRow, endDateRow, delay_idea_id);

	String update_date = update_date(cast_id, cast_priority, idea_id,idea_id_norevert);
	
	String updated_Idea_url = update_Idea_url_id(idea_id_url,update_idea_url);	
	
	String updated_Idea_url_click = update_Idea_url_id_click(idea_id_url_click,update_idea_url_convert);
	
	String urlencode = urlEncode(idea_url_encode);
		
	String file_content_md5 = request.getParameter("file_content_md5");
	String fileContentMd5 = FileContentMd5(file_content_md5);
	
/* 	if("1".equals(is_resin_restart)){
		resinRestart();
	}
	
	if("2".equals(is_resin_restart1)){
		resinRestart1();
	} */
		
	//is_load_ad
	String is_load_ad = request.getParameter("is_load_ad");
	if("1".equals(is_load_ad)&&is_load_ad!=null){
		EasyCastUtil.load_ad();
	}
	
	String tair_opt = request.getParameter("tair_opt");
	String tair_name = request.getParameter("tair_name");
	String tair_key = request.getParameter("tair_key");
	String tair_value = request.getParameter("tair_value");
	//tairOpt(tair_opt, tair_name, tair_key, tair_value);
    
	out.println("<a href='ad_tool.jsp'>返回</a>" + update_date
			+ delayDate + "  " + urlencode + fileContentMd5);
	//out.println("<a href='ad_tool.jsp'>返回</a>");
%>