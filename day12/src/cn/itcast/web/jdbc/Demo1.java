package cn.itcast.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Demo1 {

	//��ʹ��jdbc��½���ݿ�
	public static void main(String[] args) throws Exception {
		//ע�����ݿ�����
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//��ȡ���ݿ�����
		Connection conn = 
				DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:3306/mydb2", "root", "root");
		//������ݿ�ִ�ж���
		String sql = "select * from user";
		Statement stat = conn.createStatement();
		//��ȡ���ݿ�Ľ������
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
