package cn.itcast.web.zhuangbei.service;

import cn.itcast.web.zhuangbei.domain.Borrow;

public class testBorrow {

	
	public static void main(String[] args) throws Exception {
		EquipService service = new EquipService();
		  Borrow borrow = new Borrow();
		  borrow.setName("รÞาย");
		  borrow.setCount(24);
		  service.addBorrow(borrow);

	}

}
