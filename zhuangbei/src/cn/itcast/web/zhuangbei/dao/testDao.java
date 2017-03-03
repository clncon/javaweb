package cn.itcast.web.zhuangbei.dao;

import java.sql.SQLException;

import cn.itcast.web.zhuangbei.Exception.CountException;
import cn.itcast.web.zhuangbei.domain.Borrow;
import cn.itcast.web.zhuangbei.service.EquipService;

public class testDao {
	public static void main(String[] args) throws SQLException, CountException {
		EquipService es = new EquipService();
		 Borrow borrow = new Borrow();
		 borrow.setCount(2);
		 borrow.setName("ÊÖ»ú");
		 es.addBorrow(borrow);
		
	}

}
