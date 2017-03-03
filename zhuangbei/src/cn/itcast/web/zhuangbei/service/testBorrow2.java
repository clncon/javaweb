package cn.itcast.web.zhuangbei.service;

import cn.itcast.web.zhuangbei.domain.Borrow;

public class testBorrow2 {

	
	public static void main(String[] args) throws Exception {
	  EquipService service = new EquipService();
	  Borrow borrow = new Borrow();
	   borrow.setId(6);
	   borrow.setName("รÞาย");
	   borrow.setCount(24);
	  service.deleteBorrow(borrow);

	}

}
