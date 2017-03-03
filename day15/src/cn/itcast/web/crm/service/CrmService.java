package cn.itcast.web.crm.service;

import java.sql.SQLException;

import cn.itcast.web.crm.dao.CrmDao;
import cn.itcast.web.crm.domain.Customer;
import cn.itcast.web.crm.domain.Page;

public class CrmService {
	CrmDao crmdao = new CrmDao();
	//�������ݿ����һ����Ϣ
	public void updateCustomerById(Customer customer) throws Exception{
		crmdao.updateCustomerById(customer);
	}
	//�����ݿ����һ���ͻ���Ϣ
	public void addCustomer(Customer customer) throws Exception{
		crmdao.addCustomer(customer);
	}
	//�������еĿͻ���Ϣ����ָ���Ĳ���
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
	   //ͨ��id�Ų�ѯָ���Ŀͻ���Ϣ
	public Customer findCustomerById(int id) throws SQLException{
		Customer customer = crmdao.findCustomerById(id);
		return customer;
		
	}
	   //ͨ��id��ɾ��ָ���Ŀͻ�
	public void deleteCustomerById(int id) throws SQLException{
		crmdao.deleteCustomerById(id);
	}

}
