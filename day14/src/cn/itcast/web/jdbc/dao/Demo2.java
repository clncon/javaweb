package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

import cn.itcast.web.jdbc.util.jdbcUtils;

public class Demo2 {
     
	//手动显示操作事务的api
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
		  //设置事物手动开启
		   conn.setAutoCommit(false);
		   //执行第一个sql
    		pstmt = conn.prepareStatement(sqlA);
    		 pstmt.executeUpdate();
    		
    	   //执行第二个sql
    		pstmt = conn.prepareStatement(sqlB);
    		pstmt.executeUpdate();
    		//设置一个回滚点
    		sp = conn.setSavepoint();
    		Integer.parseInt("abc");
    		
  
    		//执行第三条sql语句
    		pstmt = conn.prepareStatement(sqlC);
    		pstmt.executeUpdate();
    		//设置事务手工提交
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
