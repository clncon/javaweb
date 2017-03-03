package cn.itcast.web.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.web.jdbc.jdbcUtils;

public class crud {
     @Test
     public void create(){
    	Connection conn =null;
    	Statement stat = null;
    	ResultSet rs = null;
    	String sql = "insert into user(id,name,birthday,entry_date,job,salary)" +
    			"values(1,'思思','2011-5-8','2011-12-31','computer',3000)";
    	conn = jdbcUtils.getMySqlConnection();
    	try {
			stat = conn.createStatement();
			int i = stat.executeUpdate(sql);
			System.out.println(i>0 ? "成功":"失败");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 jdbcUtils.close(rs);
			 jdbcUtils.close(stat);
			 jdbcUtils.close(conn);
		}
    	
     }
     @Test
     public void read(){
    	 Connection conn =null;
     	 Statement stat = null;
     	 ResultSet rs = null;
     	 String sql = "select * from user where salary>4000";
     	 
     	 conn = jdbcUtils.getMySqlConnection();
     	 try {
			stat = conn.createStatement();
			rs = stat .executeQuery(sql);
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
			 jdbcUtils.close(stat);
			 jdbcUtils.close(conn);
		}
    	 
     }
     @Test
     public void update(){
    	 Connection conn =null;
     	 Statement stat = null;
     	 
     	 String sql = "update user set name = '多多' where id = 3";
     	 
     	 conn = jdbcUtils.getMySqlConnection();
     	     try {
				stat = conn.createStatement();
				int i = stat.executeUpdate(sql);
				System.out.println(i>0?"成功":"失败");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				 jdbcUtils.close(stat);
				 jdbcUtils.close(conn);
			}
     	 
     }
     @Test
     public void delete(){
    	 Connection conn =null;
     	 Statement stat = null;
     	 String sql = "delete from user where id =5";
     	 conn = jdbcUtils.getMySqlConnection();
     	    try {
				stat = conn.createStatement();
				int i = stat.executeUpdate(sql);
				System.out.println(i>0?"成功":"失败");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				 jdbcUtils.close(stat);
				 jdbcUtils.close(conn);
			}
    	 
     }
     @Test
     public void read(String username){
    	 Connection conn =null;
     	 Statement stat = null;
     	 ResultSet rs = null;
     	 String sql = "select * from user where name = '"+username+"'";
     	 
     	 conn = jdbcUtils.getMySqlConnection();
     	 try {
			stat = conn.createStatement();
			rs = stat .executeQuery(sql);
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
			 jdbcUtils.close(stat);
			 jdbcUtils.close(conn);
		}
    	 
     }
     @Test
     public void createTable(String tableName){
    	 Connection conn =null;
     	 Statement stat = null;
     	 String sql = "create table "+tableName+"(name int primary key)";
     	 conn = jdbcUtils.getMySqlConnection();
     	    try {
				stat = conn.createStatement();
				int i = stat.executeUpdate(sql);
				System.out.println(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				 jdbcUtils.close(stat);
				 jdbcUtils.close(conn);
			}
    	 
     }
     public void deleteTable(String tableName){
    	 Connection conn =null;
     	 Statement stat = null;
     	 String sql = "drop table if exists "+tableName+"";
     	 conn = jdbcUtils.getMySqlConnection();
     	    try {
				stat = conn.createStatement();
				int i = stat.executeUpdate(sql);
				System.out.println(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				 jdbcUtils.close(stat);
				 jdbcUtils.close(conn);
			}
     }
     public static void main(String[] args) {
		crud crud = new crud();
		//crud.read("思思");
		//crud.createTable("system");
		crud.deleteTable("system");
	}
}
