package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;


import com.mysql.jdbc.PreparedStatement;

import cn.itcast.web.jdbc.dao.jdbcUtils;

public class crud {
	 public void read(float salarys){
    	 Connection conn =null;
     	 PreparedStatement pstat = null;
     	 ResultSet rs = null;
     	 String sql = "select * from user where salary > ?";
     	 
     	 conn = jdbcUtils.getMySqlConnection();
     	 try {
			pstat = (PreparedStatement) conn.prepareStatement(sql);
			pstat.setFloat(1,salarys);
			rs = pstat .executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date birthday = rs.getDate("birthday");
				Date entry_date = rs.getDate("entry_date");
				String job = rs.getString("job");
				float salary = rs.getFloat("salary");
				System.out.println(id+":"+name+":"+birthday+":"+entry_date+":"+job+":"+salary);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 jdbcUtils.close(rs);
			 jdbcUtils.close(pstat);
			 jdbcUtils.close(conn);
		}
    	 
     }
	 public static void main(String[] args) {
		crud crud = new crud();
		 crud.read(4000);
	}
}
