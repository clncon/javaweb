package cn.itcast.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Demo1 {

	//简单使用jdbc登陆数据库
	public static void main(String[] args) throws Exception {
		//注册数据库驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//获取数据库连接
		Connection conn = 
				DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:3306/mydb2", "root", "root");
		//获得数据库执行对象
		String sql = "select * from user";
		Statement stat = conn.createStatement();
		//获取数据库的结果对象
          ResultSet rs =stat.executeQuery(sql);
          while(rs.next()){
        	  Object name = rs.getObject("username");
               System.out.println(name);        	  
          }
          rs.close();
          stat.close();
          conn.close();
	}

}
