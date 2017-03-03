package cn.itcast.web.crm.service;

import java.sql.SQLException;

import cn.itcast.web.crm.dao.CrmDao;
import cn.itcast.web.crm.domain.Customer;
import cn.itcast.web.crm.domain.Page;

public class CrmService {
	CrmDao crmdao = new CrmDao();
	//更新数据库里的一条信息
	public void updateCustomerById(Customer customer) throws Exception{
		crmdao.updateCustomerById(customer);
	}
	//向数据库插入一条客户信息
	public void addCustomer(Customer customer) throws Exception{
		crmdao.addCustomer(customer);
	}
	//查找所有的客户信息根据指定的参数
	public Page findAllCustomer(int currentPageNO) throws SQLException{
		Page page = new Page();
	try {
		    page.setCurrentPageNO(currentPageNO);
			page.setAllRecordNo(crmdao.findAllRecord());
			int start = (currentPageNO-1)*page.getPerpageNo();
			page.setListCustomer(crmdao.findAllCustomer(start, page.getPerpageNo()));
	} catch (SQLException e){		
			e.printStackTrace();
			throw e;
		}
		
		return page;
	}
	   //通过id号查询指定的客户信息
	public Customer findCustomerById(int id) throws SQLException{
		Customer customer = crmdao.findCustomerById(id);
		return customer;
		
	}
	   //通过id号删除指定的客户
	public void deleteCustomerById(int id) throws SQLException{
		crmdao.deleteCustomerById(id);
	}

}
