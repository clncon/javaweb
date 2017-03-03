package cn.itcast.web.vote.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.web.vote.entity.Address;
import cn.itcast.web.vote.utils.jdbcUtils;

public class addressDao {
	   //根据ip查找查找对应的Address
       public Address findAddressByip(String ip) throws SQLException{
    	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	   String sql = "select * from Address where ip=?";
    	   Address address  = runner.query(sql, ip, new BeanHandler(Address.class));
    	   return address;
       }
}
