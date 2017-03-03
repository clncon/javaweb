package com.xsgl.web.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.xsgl.web.domain.Root;
import com.xsgl.web.util.jdbcUtils;

public class rootDao {
	//查看数据库是否有此管理员的信息
    public Root checkRoot(String rootName,String rootPassword) throws SQLException{
      Root root = new Root();
      QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
       String sql = "select * from root where rootName= ? and rootPassword=?";
		root = (Root)qr.query(sql,new Object[]{rootName,rootPassword},new BeanHandler<Root>(Root.class));
		return root;   	
   
    }
}
