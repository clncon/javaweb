package cn.itcast.web.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;




public class jdbcUtils {
	
	static String driver;
	static 	String url;
	static 	String user;
	static 	String password;
		
	  
	   //���ز���
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
	  //ע������
	  static {
		    try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	//ȡ�����ݿ�����
  public static Connection getMySqlConnection(){
	  Connection conn=null;
	  try {
		conn = DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return conn;
  }
  //�ر�rs��
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
  //�ر�stat��
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
  //�ر�conn��
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
