package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class Demo3 {

	public void statementBatch(){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql1 = "insert into user(username,password,birthday,salary)values('keke','369541','1995-06-12',4500)";
		String sql2 = "update user set salary = 2000 where username = 'xixi'";
		try {
			conn = jdbcUtils.getMySqlConnection();
			stmt = conn.createStatement();
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			int[] i = stmt.executeBatch();
			System.out.println(i[0]+":"+i[1]);
			stmt.clearBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.close(rs);
			jdbcUtils.close(stmt);
			jdbcUtils.close(conn);
		}
	}
	public void preparedBatch(){
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into user(username,password,birthday,salary)values(?,?,?,?)";
		try {
			conn = jdbcUtils.getMySqlConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			long begin = System.currentTimeMillis();
			for(int i=0;i<1000;i++){
				pstmt.setString(1, "jack"+i);
				pstmt.setString(2, "111111");
				pstmt.setDate(3, new Date(12345));
				pstmt.setFloat(4, 5000);
				pstmt.addBatch();
				if(i%100==0){
					//执行sql
					pstmt.executeBatch();
					//清空批处理器
					pstmt.clearBatch();
				}
			}
			pstmt.executeBatch();
		     pstmt.clearBatch();
		     long end = System.currentTimeMillis();
		     System.out.println((end-begin)/1000+"秒");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.close(rs);
			jdbcUtils.close(pstmt);
			jdbcUtils.close(conn);
		}
	}
	
	public static void main(String[] args) {
		Demo3 demo3 = new Demo3();
		//demo3.statementBatch();
		demo3.preparedBatch();
	}

}
