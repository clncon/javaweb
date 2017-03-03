package cn.itcast.web.crm.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.web.crm.domain.Customer;
import cn.itcast.web.crm.domain.Page;

public class serviceTest {

	public static void main(String[] args) throws SQLException {
		CrmService service = new CrmService();
		Page page = service.findAllCustomer(1);
	    System.out.println(page.getAllPageNO());
	}

}
