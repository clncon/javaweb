package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import cn.itcast.web.jdbc.util.jdbcUtils;



public class Demo1 {

	//��ʾ����Ԫ���ݵ��÷�
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = jdbcUtils.getMySqlConnection();
		//3. ResultSetMetaData
		 String sql = "select * from user";
	     pstmt = conn.prepareStatement(sql);
		 ResultSetMetaData rsmd = pstmt.getMetaData();
		 int size = rsmd.getColumnCount();
		 for(int i = 0;i<size;i++){
			 //���ÿһ�е�����
			 String columnName =rsmd.getColumnName(i+1);
			 //���ÿһ�е�����
			 String columnType = rsmd.getColumnTypeName(i+1);
			 System.out.println(columnName+":"+columnType);
			 
		 }
		//2.ParameterMetaData
		/*String sql = "insert into user(username,password,birthday,salary)values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		ParameterMetaData pamd = pstmt.getParameterMetaData();
		int size = pamd.getParameterCount();
		System.out.println("����"+size+"������");*/
	  //1.DataBaseMetaData
		/*DatabaseMetaData dbmd = (DatabaseMetaData) conn.getMetaData();
		int major = dbmd.getDatabaseMajorVersion();
		 int minor = dbmd.getDatabaseMinorVersion();
		  String productName  = dbmd.getDatabaseProductName();
		  String username = dbmd.getUserName();
		  String dirver = dbmd.getDriverName();
		  String url = dbmd.getURL();
		   int  level = dbmd.getDefaultTransactionIsolation();
		  System.out.println("major:"+major);
		  System.out.println("minor:"+minor);
		  System.out.println("productName:"+productName);
		  System.out.println("username:"+username);
		  System.out.println("dirver:"+dirver);
		  System.out.println("url:"+url);
		  System.out.println("level:"+level);*/


	}

}
