package cn.itcast.web.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Demo2 {
//�ع�jdbc
	public static void main(String[] args) {
		Connection conn =null;
		Statement stat = null;
		ResultSet rs = null;
		
		
	
		//ע��jdbc�����������÷��䷽����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���ݿ�����
			conn = 
					DriverManager.getConnection("jdbc:mysql://127.0.0.1/mydb2","root","root");
			//��ȡ���ݿ�ִ�ж���
			String sql = "select * from user";
		    stat = conn.createStatement();
			//��ȡ���ݿ�������
			rs = stat.executeQuery(sql);
			while(rs.next()){
				String name = rs.getString("username");
				int id = rs.getInt("id");
				Date birthday = rs.getDate("birthday");
				float salary = rs.getFloat("salary");
				System.out.println(id+":"+name+":"+birthday+":"+salary);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		//�ͷ���Դ
		finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
