package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class Demo4 {
       public static void main(String[] args) {
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		 String sql = "insert into user(username,password,birthday,Salary)values('marry','000000','1993-10-26',3000)";
		 
		 try {
			 conn = jdbcUtils.getMySqlConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
			Long temp = (Long) rs.getObject(1);
			int id = temp.intValue();
			System.out.println("Ö÷¼üÖµ"+id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
