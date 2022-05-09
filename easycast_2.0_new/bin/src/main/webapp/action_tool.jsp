<%@page import="java.util.*"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.io.IOException"%>
<%@page import="java.text.SimpleDateFormat"%>

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
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final Log logger = LogUtil.getLog();

	//	private static final Log logger = LogUtil.getLog();
	//private String a = null;
	String update_date(String cast_id, String cast_priority, String idea_id) {
		try {
			String root = getServletContext().getRealPath("/");
			Torque.init(root + "WEB-INF/classes/conf/Torque.properties");
			String a;
			if (idea_id != null && !"".equals(idea_id)) {
				//int idea_id_int = Integer.parseInt(idea_id);
				DBConnection.getInstance("atm").execSql(
						"update idea_time set status = 0 where idea_id in ( "
								+ idea_id + ")");
				//a = "update idea_time set status = 0 where idea_id = " +  idea_id_int;

				//return idea_id;
			}

			if (cast_id != null && !"".equals(cast_id) && cast_priority != null
					&& !"".equals(cast_priority)) {
				//int cast_id_int = Integer.parseInt(cast_id);
				//int cast_priority_int = Integer.parseInt(cast_priority);

				DBConnection.getInstance("atm").execSql(
						"update ad_cast set type_priority = " + cast_priority
								+ " where id in (" + cast_id + ")");
				//return "unok";			
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.error(e.getStackTrace(), e);
			System.out.println("***************" + e.getStackTrace());
			logger.error(e.getStackTrace(), e);
		}

		return "ok";
	}

	String delayDate(String startDate_date, String endDate_date,
			String delay_idea_id) throws Exception {
		long day;
		Date temp;
		Date temp_1;
		Date temp_3;
		Date temp_4;
		if (startDate_date != null && !"".equals(startDate_date)
				&& endDate_date != null && !"".equals(endDate_date)
				&& delay_idea_id != null && !"".equals(delay_idea_id)) {
			Date startDate = sdf.parse(startDate_date);
			Date endDate = sdf.parse(endDate_date);
			int delay_idea_id_int = Integer.parseInt(delay_idea_id);

			//check ad_cast.cast_way
			String sql1 = "select cast_way from ad_cast where id in(select cast_id from idea where id = "
					+ delay_idea_id_int + ");";


			ArrayList al2 = DBConnection.getInstance("atm").execQuerySql7(sql1);
			String c = (al2.get(0).toString()).substring(1, al2.get(0)
					.toString().length() - 1)
					+ "";
			System.out.println("cast_way is: " + c);
			if (c.contains("cpm")) {
				day = (endDate.getTime() - startDate.getTime())
						/ (24 * 60 * 60 * 1000) + 1;
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
				String sql = "select id from dc order by id desc limit " + day
						+ ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
						sql);

				int kk[] = new int[al1.size()];

				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1
							.get(0).toString().length() - 1)
							+ "";
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
				
				String sql2 = "select lun from cast_cpm where cast_id in(select cast_id from idea where id = " + delay_idea_id_int + ") order by id desc limit 1;";

				ArrayList al3 = DBConnection.getInstance("atm").execQuerySql7(sql2);
				String c2 = (al3.get(0).toString()).substring(1, al3.get(0)
						.toString().length() - 1)
						+ "";
				System.out.println("lun is: " + c2);
				
				String sql4 = "select cast_id from cast_cpm where cast_id in(select cast_id from idea where id = " + delay_idea_id_int + ") order by id desc limit 1;";
				ArrayList al4 = DBConnection.getInstance("atm").execQuerySql6(sql4);
				String d1 = (al4.get(0).toString()).substring(1, al4.get(0)
						.toString().length() - 1)
						+ "";

				int i1 = Integer.parseInt(d1);
				
				day = (endDate.getTime() - startDate.getTime())
						/ (24 * 60 * 60 * 1000) + 1;
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

				day = (endDate.getTime() - startDate.getTime())
						/ (24 * 60 * 60 * 1000) + 1;
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
				String sql = "select id from dc order by id desc limit " + day
						+ ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
						sql);

				int kk[] = new int[al1.size()];

				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1
							.get(0).toString().length() - 1)
							+ "";
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


				day = (endDate.getTime() - startDate.getTime())
						/ (24 * 60 * 60 * 1000) + 1;
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
				String sql = "select id from dc order by id desc limit " + day
						+ ";";
				ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
						sql);

				int kk[] = new int[al1.size()];

				for (int iii = 0; iii < al1.size(); iii++) {
					String aaa = (al1.get(iii).toString()).substring(1, al1
							.get(0).toString().length() - 1)
							+ "";
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

			
			
			}else{

				Calendar calendar;
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

			
			}

		}
		return "ok";

	}%>
<%
	String cast_id = request.getParameter("cast_id");
	String cast_priority = request.getParameter("cast_priority");
	String idea_id = request.getParameter("idea_id");

	String startDateRow = request.getParameter("startDateRow");
	String endDateRow = request.getParameter("endDateRow");

	String delay_idea_id = request.getParameter("delay_idea_id");

	String delayDate = delayDate(startDateRow, endDateRow,
			delay_idea_id);

	String update_date = update_date(cast_id, cast_priority, idea_id);

	out.println("<a href='ad_tool.jsp'>返回</a>" + update_date
			+ delayDate);
	//out.println("<a href='ad_tool.jsp'>返回</a>");
%>