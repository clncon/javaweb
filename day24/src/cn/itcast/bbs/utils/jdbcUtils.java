package cn.itcast.bbs.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtils {
	 private static ComboPooledDataSource cds=null;
	 private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	 static{
		 cds = new ComboPooledDataSource(); 
		 
	 }
	 //取得数据源
	 public static ComboPooledDataSource getCds() {
		return cds;
	}


	public static Connection getMySqlConnection() throws Exception{
		 Connection conn = tl.get();
		  if(conn==null){
			  conn = cds.getConnection();
			  tl.set(conn);
		  }	 
		  return conn;
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
	 public static void begin() throws Exception{
		 Connection conn = getMySqlConnection();
		 conn.setAutoCommit(false);	 
	 }
	 public static void commit() throws Exception{
		 Connection conn = getMySqlConnection();
		 conn.commit();
	 }
	 public static void rollback() throws Exception{
		 Connection conn = getMySqlConnection();
		 conn.rollback();
		 
	 }
	 public  static void closeConnection() throws Exception{
		 Connection conn = getMySqlConnection();
		 conn.close();
		 tl.remove();
		 
	 }
}
