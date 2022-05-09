package com.youku.atm.easycast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.geekplus.ark.om.TWorkstation;

import com.youku.atm.om.AdOrder;
import com.youku.atm.om.AdOrderPeer;
import com.youku.atm.om.IdeaTime;

public class DBConnection {

    Log logger = LogFactory.getLog(getClass());

    private String dbname = "";

    private DBConnection() {
        dbname = "atmunit";
    }

    private DBConnection(String name) {
        dbname = name;
    }

    public static DBConnection getInstance() {
        return new DBConnection();

    }

    public static DBConnection getInstance(String name) {
        return new DBConnection(name);
    }

    public Connection getConnection() throws TorqueException {
        return Torque.getConnection(dbname);
       
    }

    //直接执行修改性质的sql语句
    public boolean execSql(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        } finally {
            close(stmt);
            close(conn);
        }
    }

   

    //返回一个大的list，里面每条记录封装在一个小list里
    public ArrayList execQuerySql2(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList arrayList = new ArrayList();

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int coluNum = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                ArrayList list = new ArrayList();
                for (int i = 1; i <= coluNum; i++) {
                    list.add(rs.getObject(i));
                }
                arrayList.add(list);
            }
            return arrayList;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }
    
    
    //返回一个list，多条记录的话按顺序排列
    public ArrayList execQuerySql3(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList arrayList = new ArrayList();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int coluNum = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= coluNum; i++) {
                    arrayList.add(rs.getObject(i));
                }
            }
            return arrayList;
        } catch (Exception e) {  
        	e.printStackTrace();
        	logger.error(e.getMessage(), e);
            return null;
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }
    
  
    
    //同execQuerySql2，只是数据都为int类型
    public ArrayList execQuerySql6(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList arrayList = new ArrayList();

        try {
            conn = getConnection();
            stmt = conn.createStatement();
          //  logger.debug("sql=" + sql);
            rs = stmt.executeQuery(sql);
            int coluNum = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                ArrayList list = new ArrayList();
                for (int i = 1; i <= coluNum; i++) {
                    // list.add(String.valueOf(rs.getObject(i)));
                	 try {
                		 list.add(rs.getInt(i));
                	 } catch (Exception e) {
                		 e.printStackTrace();
                	 }
                }
                arrayList.add(list);
            }
            return arrayList;
        } catch (Exception e) {
        	e.printStackTrace();
        	logger.error(e.getMessage(), e);
            return null;
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }
   
    
    
    public ArrayList execQuerySql7(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList arrayList = new ArrayList();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int coluNum = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                ArrayList list = new ArrayList();
                for (int i = 1; i <= coluNum; i++) {
                	String key = resultSetMetaData.getColumnName(i);
                    Object value = null;
                    String colName = resultSetMetaData.getColumnTypeName(i);
                    if(colName.equals("VARCHAR")){
                    	list.add(rs.getString(i));
                    }else if(colName.equals("UNKNOWN")){
                    	list.add(rs.getString(i));
                    }
                }
                arrayList.add(list);
            }
            return arrayList;
        } catch (Exception e) {
        	e.printStackTrace();
        	logger.error(e.getMessage(), e);
            return null;
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }
    
    

    public ArrayList execQuerySql8(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList arrayList = new ArrayList();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int coluNum = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= coluNum; i++) {
                    arrayList.add(rs.getString(i)); 
                }
            }
            return arrayList;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    public ArrayList execQuerySql9(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList arrayList = new ArrayList();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int coluNum = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                ArrayList list = new ArrayList();
                for (int i = 1; i <= coluNum; i++) {
                	if(i==5||i==4){  
                		list.add(rs.getString(i));
                	}else{
                		list.add(rs.getLong(i));
                	}
                }
                arrayList.add(list);
            }
            return arrayList;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    /**
     * 每一条记录是一个Map；此Map中以列名为key，以列值为value；
     * 注意：总是企图对每一列调用ResultSet.getObject()取列值，
     * 但是如果该列的数据类型为UNKNOWN，那么就调用ResultSet.getString()来取列值
     */
    public List<Map<String, Object>> execQuerySql_map(String sql) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int coluNum = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                Map<String, Object> record = new HashMap<String, Object>();
                for (int i = 1; i <= coluNum; i++) {
                    String key = resultSetMetaData.getColumnName(i);
                    Object value = null;
                    if (resultSetMetaData.getColumnTypeName(i)
                            .equalsIgnoreCase("UNKNOWN")) {
                        value = rs.getString(i);
                    } else {
                        value = rs.getObject(i);
                    }

                    record.put(key, value);

                    if (logger.isDebugEnabled()) {
                        String typeName = resultSetMetaData
                                .getColumnTypeName(i);

                        String className = resultSetMetaData
                                .getColumnClassName(i);

                        StringBuffer buffer = new StringBuffer();
                        buffer.append("Column " + i + ": ");
                        buffer.append("ColumnName = " + key + ", ");
                        buffer.append("ColumnTypeName = " + typeName + ", ");
                        buffer.append("ColumnClassName = " + className + ", ");
                        buffer.append("value = " + value + ", ");
                        buffer.append("valueClassName = "
                                + (value == null ? "null" : value.getClass())
                                + ", ");
                    }
                }
                result.add(record);
            }
            return result;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    private void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void close(Connection connection) {
        try {
            if (connection != null) {
                Torque.closeConnection(connection);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
    public static void main(String[] args) throws TorqueException {
		//Torque.init("I:/adtest_git_vhtml/easycast_2.0/src/main/resources/conf/Torque.properties");
    	Torque.init("F:\\gary_geek\\easycast_2.0_new\\src\\main\\resources\\conf\\Torque.properties");
		ArrayList al10 = DBConnection.getInstance("ark").execQuerySql6(
				"select id from t_workstation order by id desc limit 1");
		
		System.out.println(al10.get(0));
//		
//		if (al10.size() != 0) {
//			AdOrder adOrder = new AdOrder();
//			adOrder.setId(107511);
//			adOrder.setName("teset_order107588");
//            adOrder.setIndustryId(1);
//            adOrder.setSubIndustryId(1);
//            adOrder.setCategoryId(1);
//			adOrder.setCustomId(1);
//			adOrder.setCustomName("test");
//		
//			adOrder.setType(0);
//			adOrder.setStatus(3);
//			try {
//				adOrder.save();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else{
//				Criteria c = new Criteria();
//				//c.add(AdOrderPeer.ORDER_TYPE, AdOrder_C.ORDER_TYPE_SALE);
//				c.add(AdOrderPeer.STATUS, 3);
//				int[] type ={0,2};
//				c.addIn(AdOrderPeer.TYPE, type);
//			    
//				//c.add(AdOrderPeer.LOCK_STATE, AdOrder_C.LOCK_STATE_LOCK);
//				c.addDescendingOrderByColumn(AdOrderPeer.ID);
//
//				try {
//					List<AdOrder> orderList = AdOrderPeer.doSelect(c);
//				} catch (TorqueException e) {
//					e.printStackTrace();
//				}
//
//		}
		
		
		TWorkstation ws = new TWorkstation();
		//it.setId(6500025);
		ws.setId(30);
		ws.setWorkstationName("test_torque_name1");
		ws.setLocationX(1);
		ws.setLocationY(2);
		ws.setAngle(90);
		ws.setStopPointIds("26767676");
		ws.setCreatorUsername("test");
		ws.setCreationTime(new Date());
		ws.setUpdatorUsername("gary");
		ws.setUpdateTime(new Date());
		ws.setStatus(1);
		ws.setFloorId(2);
		ws.setCellType("test");
		ws.setWidth(23);
		ws.setLength(56);
		ws.setDescr("blabal");
		ws.setRestartCell(2);
		ws.setHostcellcode("2342");
		try {
			ws.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//Boolean flag = DBConnection.getInstance("atm").execSql("update ad_cast set name = 'test_torque22222' where id = 1");
		//System.out.println(flag);
//		@SuppressWarnings("rawtypes")
//		ArrayList al = DBConnection.getInstance("atm").execQuerySql6("select id from ad_cast order by id desc limit 1");
//        String a = (al.get(0).toString()).charAt(1)+"";		
//		int i=Integer.parseInt(a);
//		System.out.println(i);
		
//		@SuppressWarnings("rawtypes")
//		ArrayList al = DBConnection.getInstance("atm").execQuerySql6("select id from dc where target_date>='2014-07-01 00:00:00' and target_date<='2014-07-01 00:00:00';");
//        int kk[]=new int[al.size()];
//		for(int i=0;i<al.size();i++){
//			System.out.println(al.get(i).toString());
//			String a = (al.get(i).toString()).charAt(1)+"";		
//			int k=Integer.parseInt(a);
//			kk[i]=k;
//        }
//        for(int i=0;i<kk.length;i++){
//        	//System.out.println(kk[i]);
//        }
//        
//        System.out.println("ligang".charAt(0));
//        String test = "[ligang]";
//        System.out.println(test.substring(1,test.length()-1));
		
		//test(kk);
		
//		ArrayList al1 = DBConnection.getInstance("atm").execQuerySql6(
//				"select id from campaign order by id desc limit 1");
		
//		if(al1.size()==0){
//			System.out.println("it is size o");
//		}else{
//			String d = (al1.get(0).toString()).substring(1,al1.get(0).toString().length()-1) + "";
//
//			int i1 = Integer.parseInt(d);
//			
//			System.out.println(i1);
//		}
		
	}

}
