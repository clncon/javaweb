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
		//ȡ��BaseDao���ֽ������
		 Class basedaoClass = this.getClass();
		 //ȡ��BaseDao�ķ�������
		  Type type = (Type)basedaoClass.getGenericSuperclass();
		  //ȡ��BaseDao�Ĳ�����������
		     ParameterizedType pt = (ParameterizedType)type;
		   //ȡ��ʵ�����Ĳ�������
		     Type[] types = pt.getActualTypeArguments();
		     this.clazz = (Class) types[0];
		   //ȡ�ñ���
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
