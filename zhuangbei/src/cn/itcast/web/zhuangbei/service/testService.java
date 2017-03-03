package cn.itcast.web.zhuangbei.service;

import java.util.List;

import cn.itcast.web.zhuangbei.domain.Borrow;
import cn.itcast.web.zhuangbei.domain.Equipment;

public class testService {

	public static void main(String[] args) throws Exception {
		EquipService service = new EquipService();
	/*	Equipment equiment = new Equipment();
		equiment.setName("手表");
		equiment.setCount(123);
		equiment.setFunction("了解时间");
		equiment.setPosition(6);
		service.addEquiment(equiment);*/
		List<Borrow> listBorrow = service.findAllBorrow();
		System.out.println(listBorrow.size());

	}

}
