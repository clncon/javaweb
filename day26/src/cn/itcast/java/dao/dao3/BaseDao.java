package cn.itcast.java.dao.dao3;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.java.utils.jdbcUtils;

public class BaseDao<T>{
	private Class clazz;
	private String tableName;
	public BaseDao(){
		//取得BaseDao的字节码对象
		 Class basedaoClass = this.getClass();
		 //取得BaseDao的泛型类型
		  Type type = (Type)basedaoClass.getGenericSuperclass();
		  //取得BaseDao的参数化的类型
		     ParameterizedType pt = (ParameterizedType)type;
		   //取得实例化的参数类型
		     Type[] types = pt.getActualTypeArguments();
		     this.clazz = (Class) types[0];
		   //取得表名
		    int index = this.clazz.getName().lastIndexOf(".");
		    this.tableName = this.clazz.getName().substring(index+1).toLowerCase();
		 
	}
	public T findTById(int id) throws Exception{
		T t = null;
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select * from "+tableName+" where id= ?";
		t = runner.query(sql, id,new BeanHandler<T>(clazz));
		return t;
	}
}
