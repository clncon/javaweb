package com.dream.comm;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class BaseDaoMysql {
 
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/dream?useUnicode=true&characterEncoding=utf-8";
	//private static final String URL = "jdbc:mysql://192.169.31.215:3306/dream?useUnicode=true&characterEncoding=utf-8";

	private static final String USER = "root";
	private static final String PWD = "123456";

	//private static final String USER = "sys";
	//private static final String PWD = "orcl";

	private Connection openCon() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PWD);
	}

	private void closeAll(ResultSet rs, PreparedStatement ps, 

Connection con)
			throws Exception {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (ps != null) {
			ps.close();
			ps = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
	}
	/**
	 * 
	 * @param sql  语句
	 * @param args  sql参数 （要注意顺序）
	 * @return  行数    
	 * @throws Exception
	 */
	protected int excuteUpdate(String sql, List args) throws 

Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.openCon();
			ps = con.prepareStatement(sql);
			setValues(args, ps);
			return ps.executeUpdate();
		} finally {
			this.closeAll(null, ps, con);
		}
	}
	/**
	 * 查询 方法
	 * @param sql  select * from  where username=?
	 * @param args
	 * @return
	 * @throws Exception
	 */
	protected Result excuteQuery(String sql, List args) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = this.openCon();
			ps = con.prepareStatement(sql);
			setValues(args, ps);
			rs = ps.executeQuery();
			return ResultSupport.toResult(rs);
		} finally {
			this.closeAll(null, ps, con);
		}
	}
	/**
	 * 参数的封装
	 * @param args  参数
	 * @param ps    
	 * @throws SQLException
	 */
	private void setValues(List args, PreparedStatement ps) throws SQLException {
		if (ps != null && args != null) {
			for (int i = 0; i < args.size(); i++) {
				ps.setObject(i + 1, args.get(i));
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		BaseDaoMysql db=new BaseDaoMysql();
		try {
			System.out.println("execute... 请等待...");
			Connection conn= db.openCon();
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
		
	}
	
}
