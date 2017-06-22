package c3po.iyunmai;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Seconds;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;


public class c3poMain {

	public static String querySql1 = "select count(*) from menu";
	public static String querySql2 = "select Food from menu";
	public static String querySql3 = "select * from menu";
	public static String insertSql1 = "insert into menu1 values (?,?,?,?,?,?)";
	public static void main(String[] args) {
		//queryObjectList();
		//insertObjectList();
		insertObjectListDefault();
		//insertObjectListByString();
	}
	
	public static void queryObject(){
		Object o = new Object();
		Connection con1 = null;
		try {
			con1 = c3poUtil.getConnection();
			o = c3poUtil.executeQueryObject(con1, querySql1);
			System.out.println(o.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			c3poUtil.close(con1);
		}
	}
	
	//要想返回一个对象的list必须用List<List<Object>>或者List<Object[]>
	public static void queryObjectList(){
		List<Object[]> ol = new ArrayList<Object[]>();
		Connection con2 = null;
		try {
			con2 = c3poUtil.getConnection();
			ol = c3poUtil.queryList(con2, querySql2);
			System.out.println(ol.size());
			for(Object[] o : ol){
				System.out.println(o[0]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			c3poUtil.close(con2);
		}
	}

	//一个事务，手动提交
	public static void insertObjectList(){
		List<List<Object>> oll = new ArrayList<List<Object>>();
		int[] result = null;Connection con = null;
		try {
			con = c3poUtil.getConnection();
			con.setAutoCommit(false);
			oll = c3poUtil.executeQueryRowList(con, querySql3);
			Date startDate = new Date();
			result = c3poUtil.executeBatchUpdate(con,insertSql1,oll);
			/*for(List<Object> ol : oll){
				int id = Integer.valueOf(ol.get(0).toString());
				String food = ol.get(1).toString();
				double extraFee = Double.valueOf(ol.get(2).toString());
				double price = Double.valueOf(ol.get(3).toString());
				int resId = Integer.valueOf(ol.get(4).toString());
				Timestamp createTime = Timestamp.valueOf(ol.get(5).toString());
				c3poUtil.executeUpdate(con, insertSql1, id,food,extraFee,price,resId,createTime);
			}*/
			con.commit();
			Date endDate = new Date();
			long haomiao = endDate.getTime() - startDate.getTime();
			System.out.println("插入"+result.length+" 条记录，用时 "+haomiao+" 毫秒");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			c3poUtil.close(con);
		}
	}
	//默认自动提交。每条sql一个事务
	public static void insertObjectListDefault(){
		List<List<Object>> oll = new ArrayList<List<Object>>();
		int[] result = null;Connection con = null;
		try {
			con = c3poUtil.getConnection();
			oll = c3poUtil.executeQueryRowList(con, querySql3);
			Date startDate = new Date();
			result = c3poUtil.executeBatchUpdate(con,insertSql1,oll);
			/*for(List<Object> ol : oll){
				int id = Integer.valueOf(ol.get(0).toString());
				String food = ol.get(1).toString();
				double extraFee = Double.valueOf(ol.get(2).toString());
				double price = Double.valueOf(ol.get(3).toString());
				int resId = Integer.valueOf(ol.get(4).toString());
				Timestamp createTime = Timestamp.valueOf(ol.get(5).toString());
				c3poUtil.executeUpdate(con, insertSql1, id,food,extraFee,price,resId,createTime);
			}*/
			Date endDate = new Date();
			long haomiao = endDate.getTime() - startDate.getTime();
			System.out.println("插入"+result.length+" 条记录，用时 "+haomiao+" 毫秒");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			c3poUtil.close(con);
		}
	}
	//批量插入时，要拼接字符串，如果有特殊字符可以用转义解决
	public static void insertObjectListByString(){
		List<List<Object>> oll = new ArrayList<List<Object>>();
		Connection con = null;
		try {
			con = c3poUtil.getConnection();
			con.setAutoCommit(false);
			oll = c3poUtil.executeQueryRowList(con, querySql3);
			
			StringBuilder  insertSql2 = new StringBuilder();
			insertSql2.append("insert into menu1 values");
			int n = 0,num = 0;
			for(List<Object> ol : oll){
				
				n++;
				int id = Integer.valueOf(ol.get(0).toString());
				String food = ol.get(1).toString();
				double extraFee = Double.valueOf(ol.get(2).toString());
				double price = Double.valueOf(ol.get(3).toString());
				int resId = Integer.valueOf(ol.get(4).toString());
				Timestamp createTime = Timestamp.valueOf(ol.get(5).toString());
				if(n==oll.size()){
					//insertSql2.append("("+id+",'"+food+"',"+extraFee+","+price+","+resId+",'"+createTime+"');");//错误的拼接方式
					insertSql2.append("(")
					.append(id).append(",'")
					.append(food).append("',")
					.append(extraFee).append(",")
					.append(price).append(",")
					.append(resId).append(",'")
					.append(createTime)
					.append("');");
				}else{
					//insertSql2.append("("+id+",'"+food+"',"+extraFee+","+price+","+resId+",'"+createTime+"'),");
					insertSql2.append("(")
					.append(id).append(",'")
					.append(food).append("',")
					.append(extraFee).append(",")
					.append(price).append(",")
					.append(resId).append(",'")
					.append(createTime)
					.append("'),");
				}
			}
			Date startDate = new Date();
			num = c3poUtil.executeUpdate(con, insertSql2.toString());
			con.commit();
			Date endDate = new Date();
			long haomiao = endDate.getTime() - startDate.getTime();
			System.out.println("插入"+num+" 条记录，用时 "+haomiao+" 毫秒");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			c3poUtil.close(con);
		}
	}
}
