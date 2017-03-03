package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.dao.ActivityDao;
import com.dream.dao.impl.ActivityDaoImpl;
import com.dream.entity.Activity;
import com.dream.entity.view.AcGoods;

public class TestActivityDaoImpl {

	
	ActivityDao dao=new ActivityDaoImpl();
	//@Test
	public void testAdd() {
		Activity ac=new Activity();
		ac.setaGid(4);
		ac.setAprice(25);
		ac.setAdate("2016.11.11");
		ac.setApic("xx.jpg");
		dao.add(ac);
	}

	//@Test
	public void testDelete() {
		dao.delete(2);
	}

	//@Test
	public void testUpdate() {
		Activity ac=new Activity();
		ac.setaGid(4);
		ac.setAprice(25);
		ac.setAdate("2016.11.11");
		ac.setApic("xx.jpg");
		ac.setaId(1);
		dao.update(ac);
	}

	//@Test
	public void testSearchById() {
		AcGoods as=dao.searchById(1);
		System.out.println("根据Id查询"+as);
	}

	//@Test
	public void testSearch() {
		List<AcGoods> listas=dao.search();
		System.out.println("查询全部活动信息：");
		for (AcGoods acGoods : listas) {
			System.out.println(acGoods.toString());
		}
	}
	@Test
	public void testSearchByadate(){
		List<AcGoods> listas=dao.searchByadate("2016.11.11");
		System.out.println("根据日期查询活动信息：");
		for (AcGoods acGoods : listas) {
			System.out.println(acGoods.toString());
		}
		
	}

}
