package cn.itcast.web.jdbc.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.web.jdbc.util.jdbcUtils;

public class Demo3 {
    //ÑÝÊ¾DBUtils
	public static void main(String[] args) throws Exception {
	   String sql = "insert into user(username,password,birthday,salary)values(?,?,?,?)";
	   QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
	   qr.update(sql,new Object[]{"jack","111111","2001-06-29",5000});

	}

}
