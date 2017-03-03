package cn.itcast.bbs.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.bbs.domain.Address;
import cn.itcast.bbs.utils.jdbcUtils;

public class AddressDao {
	//����ָ����ip��ѯ��Ӧ�ĵ�ַ
	 public Address findAddressByIp(String ip ) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		 String sql = "select * from address where ip=?";
		 Address address = runner.query(sql, ip, new BeanHandler<Address>(Address.class));
		 return address;
	 }

}
