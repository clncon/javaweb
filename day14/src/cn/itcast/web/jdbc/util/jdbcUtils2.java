package cn.itcast.web.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import cn.itcast.web.jdbc.domian.Account;

public class jdbcUtils2 {
	private static String driver;
	private static 	String url;
	private static 	String user;
	private static 	String password;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();	
	  
	   //加载参数
	  static {
		  Properties prop = new Properties();
		  InputStream is = 
				  jdbcUtils.class.getClassLoader()
				  .getResourceAsStream("cn/itcast/web/jdbc/config/db.properties");
		  
		  try {
			  prop.load(is);
			  
		  } catch (IOException e) {

			  e.printStackTrace();
		  } 
		  driver = prop.getProperty("driver");
		  url = prop.getProperty("url");
		  user = prop.getProperty("user");
		  password = prop.getProperty("password");
	  }
	  //注册驱动
	  static {
		    try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	//取得数据库连接
  public static Connection getMySqlConnection(){
	  Connection conn=null;
	  try {
		  if(conn==null){
		   conn = DriverManager.getConnection(url, user, password);
		    tl.set(conn);
		  }
		  conn = tl.get();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return conn;
  }
  //关闭rs流
  public static void close(ResultSet rs){
	  //boolean flag = false;
	  if(rs!=null){
			try {
				rs.close();
				//flag = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  //return flag;
  }
  //关闭stat流
  public static void close(Statement stas){
	  //boolean flag = false;
	  if(stas!=null){
			try {
				stas.close();
				//flag = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  //return flag;
  }
  //关闭conn流
  public static void close(Connection conn){
	  //boolean flag = false;
	  if(conn!=null){
			try {
				conn.close();
				//flag = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  //return flag;
  }

}


