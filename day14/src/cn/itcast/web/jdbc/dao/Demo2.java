package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

import cn.itcast.web.jdbc.util.jdbcUtils;

public class Demo2 {
     
	//�ֶ���ʾ���������api
	public static void main(String[] args) {
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  ResultSet rs =null;
	  String sqlA = "update account set salary = salary-1000 where name = 'aaa'";
	  String sqlB = "update account set salary = salary+1000 where name = 'bbb'";
	  String sqlC = "insert into account(name,salary) values('ccc',3000)";
	  Savepoint sp = null;
	  try {
		  conn = jdbcUtils.getMySqlConnection();
		  //���������ֶ�����
		   conn.setAutoCommit(false);
		   //ִ�е�һ��sql
    		pstmt = conn.prepareStatement(sqlA);
    		 pstmt.executeUpdate();
    		
    	   //ִ�еڶ���sql
    		pstmt = conn.prepareStatement(sqlB);
    		pstmt.executeUpdate();
    		//����һ���ع���
    		sp = conn.setSavepoint();
    		Integer.parseInt("abc");
    		
  
    		//ִ�е�����sql���
    		pstmt = conn.prepareStatement(sqlC);
    		pstmt.executeUpdate();
    		//���������ֹ��ύ
    		conn.commit();
	} catch (Exception e) {
		e.printStackTrace();
		try {
			conn.rollback(sp);
			conn.commit();
		} catch (Exception e1) {
			
			
		}
	}finally{
		jdbcUtils.close(rs);
		jdbcUtils.close(pstmt);
		jdbcUtils.close(conn);
		
	}
	}
}
