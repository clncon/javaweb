package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.biz.PurchaseBiz;
import com.dream.biz.impl.PurchaseBizImpl;
import com.dream.entity.Purchase;
import com.dream.entity.view.Pugousst;
/**
 * 
 * @author  Ïþ·ç 
 *2016-3-8ÏÂÎç3:02:10
 */
public class TestPurchaseBizImpl {

	PurchaseBiz pbiz=new PurchaseBizImpl();
	
	//@Test
	public void testSearch() {
		List<Purchase> listPC=pbiz.search();
		for (Purchase pc : listPC) {
			System.out.println(pc.toString());
		}
	}

	//@Test
	public void testAdd() {
		Purchase pc = new Purchase(1, 3, 11, 20);
		pbiz.add(pc);
	}

	//@Test
	public void testUpdate() {
		Purchase pc= new Purchase();
		pc.setpId(5);
		pc.setpNum(33);
		pbiz.update(pc);
	}

	//@Test
	public void testDelete() {
		pbiz.delete(4);
	}

	@Test
	public void testSearchPugousst() {
		List<Pugousst> list=pbiz.searchPugousst();
		for (Pugousst p : list) {
			 System.out.println(p.toString());
		}
	}

}
