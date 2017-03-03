package cn.itcast.bbs.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.bbs.domain.Admin;
import cn.itcast.bbs.utils.jdbcUtils;

public class AdminDao {
   //根据板块查询作者
	public Admin findAdminByTitle(String title) throws SQLException{
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		 String sql = "select * from Admin where title=?";
		Admin admin =runner.query(sql, title, new BeanHandler<Admin>(Admin.class));
		return admin;
		
	}
}
