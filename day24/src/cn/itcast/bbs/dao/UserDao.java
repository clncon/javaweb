package cn.itcast.bbs.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.utils.jdbcUtils;

public class UserDao {
   //登录用户
	public User login(User user) throws SQLException{
		User u = null;
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select * from user where username=? and password=?";
		u = runner.query(sql, new Object[]{user.getUsername(),user.getPassword()}, new BeanHandler<User>(User.class));
		return u;
		
	}
   //注册用户信息
   public boolean Register(User user) {
	   boolean flag=false;
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	     String sql = "insert into user(username,password,gender,email)values(?,?,?,?)";
	     try {
			runner.update(sql, new Object[]{user.getUsername(),user.getPassword(),user.getGender(),user.getEmail()});
			flag=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	   return flag;
   }
}
