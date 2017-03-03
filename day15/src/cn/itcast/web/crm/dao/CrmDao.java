package cn.itcast.web.crm.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.web.crm.domain.Customer;
import cn.itcast.web.jdbc.util.jdbcUtils;

public class CrmDao {
	//更新数据库中的一条记录
	public void updateCustomerById(Customer customer) throws Exception{
		String sql = "update customer set name=?,address=?,tel=?,email=? where id =?";
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		try {
			runner.update(sql, new Object[]{
					customer.getName(),
					customer.getAddress(),
					customer.getTel(),
					customer.getEmail(),
					customer.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	//向数据库增加一条用户信息
	public void addCustomer(Customer customer) throws Exception{
		String sql = "insert into customer(name,gender,address,tel,email,birthday)values(?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		runner.update
		(sql, new Object[]{
				customer.getName(),
				customer.getGender(),
				customer.getAddress(),
				customer.getTel(),
				customer.getEmail(),
				new Date(customer.getBirthday().getTime())});
	}
	//查找所有的客户信息根据指定的参数
   public List<Customer> findAllCustomer(int start,int size) throws SQLException{
	   List<Customer> listCustomer = null;
	   String sql = "select * from customer limit ?,?";
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   listCustomer =  runner.query(sql, new Object[]{start,size}, new BeanListHandler<Customer>(Customer.class));
	   return listCustomer;   
   }
   //查找总的记录数
   public int  findAllRecord() throws SQLException{
	   int allRecord = 0;
	   String sql = "select count(*) from customer";
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   Object[] array = runner.query(sql, new ArrayHandler());
          Long temp = (Long) array[0];
          allRecord = temp.intValue();
	   return allRecord;
   }
    //通过id号查询指定的客户信息
   public Customer findCustomerById(int id) throws SQLException{
	   Customer customer = new Customer();
	   String sql = "select * from customer where id=?";
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   customer =(Customer)runner.query(sql,id,new BeanHandler<Customer>(Customer.class));
	   return customer;
	   
   }
   //通过id号删除指定的客户
   public void deleteCustomerById(int id) throws SQLException{
	   String sql = "delete from customer where id = ?";
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   runner.update(sql, id);
   }
}
