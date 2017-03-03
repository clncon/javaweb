package cn.itcast.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import cn.itcast.web.jdbc.jdbcUtils;





//jdbc��װ
public class Demo3 {
	
   public static void main(String[] args) {
	   Connection conn=null;
	   Statement stat = null;
	   ResultSet rs = null;
	   String sql = "select * from user";
	   try {
         String url = jdbcUtils.url;

		   //��ȡ���ݿ�����
		   conn = jdbcUtils.getMySqlConnection();

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
	   finally{
		   jdbcUtils.close(rs);
		   jdbcUtils.close(stat);
		   jdbcUtils.close(conn);
	   }
   }
}
