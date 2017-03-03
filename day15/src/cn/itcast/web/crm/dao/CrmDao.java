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
	//�������ݿ��е�һ����¼
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
	//�����ݿ�����һ���û���Ϣ
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
	//�������еĿͻ���Ϣ����ָ���Ĳ���
   public List<Customer> findAllCustomer(int start,int size) throws SQLException{
	   List<Customer> listCustomer = null;
	   String sql = "select * from customer limit ?,?";
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   listCustomer =  runner.query(sql, new Object[]{start,size}, new BeanListHandler<Customer>(Customer.class));
	   return listCustomer;   
   }
   //�����ܵļ�¼��
   public int  findAllRecord() throws SQLException{
	   int allRecord = 0;
	   String sql = "select count(*) from customer";
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   Object[] array = runner.query(sql, new ArrayHandler());
          Long temp = (Long) array[0];
          allRecord = temp.intValue();
	   return allRecord;
   }
    //ͨ��id�Ų�ѯָ���Ŀͻ���Ϣ
   public Customer findCustomerById(int id) throws SQLException{
	   Customer customer = new Customer();
	   String sql = "select * from customer where id=?";
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   customer =(Customer)runner.query(sql,id,new BeanHandler<Customer>(Customer.class));
	   return customer;
	   
   }
   //ͨ��id��ɾ��ָ���Ŀͻ�
   public void deleteCustomerById(int id) throws SQLException{
	   String sql = "delete from customer where id = ?";
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   runner.update(sql, id);
   }
}
