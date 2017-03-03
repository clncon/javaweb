package cn.itcast.java.dao.dao1;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.java.dao.dao2.BaseDao;
import cn.itcast.java.domain.Type;
import cn.itcast.java.utils.jdbcUtils;

public class typeDao {

	public Type findTypeById(int id) throws Exception{
		Type type=null;
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select * from type where id = ?";
		type =runner.query(sql, id, new BeanHandler<Type>(Type.class));
		return type;
	}
     
	}

