package cn.itcast.web.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import cn.itcast.web.jdbc.util.jdbcUtils;

public class Demo1 {
     //使用jdbc操作存储过程
	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement  cstmt = null;
		ResultSet rs = null;
		//调用存储过程的sql语句
		String sql = "{call add_pro(?,?,?)}";
		
		try {
			//获取数据库连接
			conn = jdbcUtils.getMySqlConnection();
			cstmt = conn.prepareCall(sql);
			//设置参数值
			cstmt.setInt(1, 100);
			cstmt.setInt(2, 100);
			//注册输出参数
			cstmt.registerOutParameter(3, Types.INTEGER);
			//执行该sql语句
			boolean flag = cstmt.execute();
			//取得输出参数值
			
				int out = cstmt.getInt(3);
				System.out.println("flag="+flag);
				System.out.println("out="+out);
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.close(rs);
			jdbcUtils.close(cstmt);
			jdbcUtils.close(conn);
			
		}

	}

}
