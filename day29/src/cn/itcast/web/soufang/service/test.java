package cn.itcast.web.soufang.service;


import java.util.List;

import cn.itcast.web.soufang.domain.House;

public class test {

	
	public static void main(String[] args) throws Exception {
		  House house = new House();
		  house.setId(1);
		  house.setArea("�����");
		  house.setAddress("");
		  house.setSpace("��������");
		  HouseService hs = new HouseService();
		  List<House> listHouse = hs.findHouseByHouse(house);
		  System.out.println(listHouse.size());

	}

}
