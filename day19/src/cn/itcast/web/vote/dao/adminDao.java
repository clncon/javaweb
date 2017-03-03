package cn.itcast.web.vote.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.web.vote.entity.Admin;
import cn.itcast.web.vote.utils.jdbcUtils;

public class adminDao {
    //�����û����������ѯΨһ��admin����
	public Admin findAdminByUsernameAndPassword(String username,String password) throws SQLException{
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select * from Admin where username=? and password=?";
		Admin admin = runner.
				query(sql, new Object[]{username,password}, 
						new BeanHandler<Admin>(Admin.class));
		return admin;
	}
}
