package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.web.jdbc.entity.User;

import com.mysql.jdbc.PreparedStatement;

public class userDao implements IUserDao{
	 //用户登录
       public boolean find(String username,String password){
    	   boolean flag = false;
    	   Connection conn =null;
       	 PreparedStatement pstat = null;
       	 ResultSet rs = null;
       	 String sql = "select * from user where username = ? and password = ?";
       	 
       	 conn = jdbcUtils.getMySqlConnection();
       	 try {
  			pstat = (PreparedStatement) conn.prepareStatement(sql);
  			pstat.setString(1,username);
  			pstat.setString(2,password);
  			rs = pstat .executeQuery();
  			if(rs.next()){
  				flag= true;
  			}
  			
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}finally{
  			 jdbcUtils.close(rs);
  			 jdbcUtils.close(pstat);
  			 jdbcUtils.close(conn);
  		}
      	  
        return flag;	 
      }
        //用户注册
       public boolean add(User user){	    
    	   Connection conn =null;
    	   PreparedStatement pstat = null;
    	   boolean flag = false;
    	   String sql = "insert into User(username,password,birthday,salary)values(?,?,?,?)";

    	   conn = jdbcUtils.getMySqlConnection();
    	   try {
    		   pstat = (PreparedStatement) conn.prepareStatement(sql);
    		   pstat.setString(1,user.getUsername());
    		   pstat.setString(2,user.getPassword());
    		   pstat.setDate(3,new Date(user.getBirthday().getTime()));
    		   pstat.setFloat(4, user.getSalary());
    		   int i = pstat .executeUpdate();
    		   if(i!=0){
    			   flag= true;
    		   }

    	   } catch (Exception e) {
    		   // TODO Auto-generated catch block
    		   e.printStackTrace();
    	   }finally{
    		   
    		   jdbcUtils.close(pstat);
    		   jdbcUtils.close(conn);
    	   }  
               return flag;
       }
        //分页
       public List<User> find(int start,int size){
    	   
    	   Connection conn =null;
    	   PreparedStatement pstat = null;
    	   ResultSet rs = null;
    	   List<User> list = new ArrayList<User>();
    	   String sql = "select * from user limit ?,?";
    	   try {
    		   conn = jdbcUtils.getMySqlConnection();
			   pstat = (PreparedStatement) conn.prepareStatement(sql);
			   pstat.setInt(1,start);
			   pstat.setInt(2, size);
               rs = pstat.executeQuery();
               while(rs.next()){
            	   User user = new User();
            	   int id = rs.getInt("id");
            	   //从数据库中取出值
            	  String username = rs.getString("username");
            	  String password = rs.getString("password");
            	  Date birthday = rs.getDate("birthday");
            	  float salary = rs.getFloat("salary");
            	  //存入User对象中
            	  user.setId(id);
            	  user.setUsername(username);
            	  user.setPassword(password);
            	  user.setBirthday(birthday);
            	  user.setSalary(salary);
            	  list.add(user);            	   
               }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 jdbcUtils.close(rs);
			 jdbcUtils.close(pstat);
			 jdbcUtils.close(conn);
		}
    	   return list;
    	  
       }
       
       public int getAllRecordNO(){
    	   int allrecordNO=0;
    	   Connection conn =null;
    	   PreparedStatement pstat = null;
    	   ResultSet rs = null;
    	   String sql = "select count(*) from user";
    	   try {
    		   conn = jdbcUtils.getMySqlConnection();
			   pstat = (PreparedStatement) conn.prepareStatement(sql);
			   rs = pstat.executeQuery();
			   if(rs.next())
			   {
				   Long temp = (Long) rs.getObject(1);
				   allrecordNO = temp.intValue();
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   finally{
    		   jdbcUtils.close(rs);
  			 jdbcUtils.close(pstat);
  			 jdbcUtils.close(conn);
  		}
    	   
    	   return allrecordNO;
       }
}

