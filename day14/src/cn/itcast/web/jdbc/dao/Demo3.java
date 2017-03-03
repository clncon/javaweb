package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.web.jdbc.util.jdbcUtils;

public class Demo3 {

	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql =  "select * from account";

		try {
			conn = jdbcUtils.getMySqlConnection();
			//设置事物的隔离级别
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//暂停操作观察效果
			 Thread.sleep(10*1000);
			 conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.close(rs);
			jdbcUtils.close(pstmt);
			jdbcUtils.close(conn);
			
		}
		
		
	}

}
