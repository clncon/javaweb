package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.biz.ActivityBiz;
import com.dream.biz.impl.ActivityBizImpl;
import com.dream.entity.Activity;
import com.dream.entity.view.AcGoods;

public class TestActivityBizImpl {

	ActivityBiz biz=new ActivityBizImpl();
	
	
	//@Test
	public void testAdd() {
		Activity ac=new Activity();
		ac.setaGid(4);
		ac.setAprice(25);
		ac.setAdate("2016.11.11");
		ac.setApic("xx.jpg");
		biz.add(ac);
	}

	//@Test
	public void testDelete() {
		biz.delete(2);
	}

	@Test
	public void testUpdate() {
		Activity ac=new Activity();
		ac.setaGid(1);
		ac.setAprice(28);
		ac.setAdate("2016.12.11");
		ac.setApic("xxp.jpg");
		ac.setaId(1);
		biz.update(ac);
	}

	//@Test
	public void testSearchById() {
		AcGoods as=biz.searchById(1);
		System.out.println("根据Id查询"+as);
	}

	@Test
	public void testSearch() {
		List<AcGoods> listas=biz.search();
		System.out.println("查询全部活动信息：");
		for (AcGoods acGoods : listas) {
			System.out.println(acGoods.toString());
		}
	}

}
