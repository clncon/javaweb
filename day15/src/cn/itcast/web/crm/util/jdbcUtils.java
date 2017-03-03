package cn.itcast.web.crm.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtils {
	 private static ComboPooledDataSource cds=null;
	 static{
		 cds = new ComboPooledDataSource(); 
		 
	 }
	 //取得数据源
	 public static ComboPooledDataSource getCds() {
		return cds;
	}


	public static Connection getMySqlConnection() throws Exception{
		  return cds.getConnection();
		}
	 
	
	 public static void close(ResultSet rs) throws SQLException{
		 if(rs!=null){
			 rs.close();
		 }
	 }
	 public static void close(PreparedStatement stmt) throws SQLException{
		 if(stmt!=null){
			 stmt.close();
		 }
	 }
	 public static void close(Connection conn) throws SQLException{
		 if(conn!=null){
			 conn.close();
		 }
	 }
	 
}
