package cn.itcast.java.dao.dao2;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.java.utils.jdbcUtils;

public class BaseDao<T>{
	private Class clazz;
	private String tableName;
	public BaseDao(Class clazz,String tableName){
		this.clazz=clazz;
		this.tableName=tableName;
		
	}
	public T findTById(int id) throws Exception{
		T t = null;
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select * from "+tableName+" where id= ?";
		t = runner.query(sql, id,new BeanHandler<T>(clazz));
		return t;
	}
}
