package cn.itcast.web.jdbc.util;

import java.sql.Connection;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcUtils3 {
	 private static ComboPooledDataSource cds=null;
	 static{
		 cds = new ComboPooledDataSource(); 
		 
	 }
	 public static Connection getMySqlConnection() throws Exception{
		  return cds.getConnection();
		}
	 
}
