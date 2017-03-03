package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.dao.PurchaseDao;
import com.dream.dao.impl.PurchaseDaoImpl;
import com.dream.entity.Purchase;
import com.dream.entity.view.Pugousst;

/**
 * 
 * @author  Ïþ·ç 
 *2016-3-8ÏÂÎç1:59:51
 */
public class TestPurchaseDaoImpl {
      PurchaseDao pd= new PurchaseDaoImpl();
      
	//@Test
	public void testSearch() {
	List<Purchase> list=pd.search();
		   for (Purchase p : list) {
			System.out.println(p.toString());
		}
	}

	@Test
	public void testAdd() {
		Purchase pc = new Purchase(1, 1, 11, 10);
		pd.add(pc);
	
		
	}

	//@Test
	public void testUpdate() {
		Purchase pc= new Purchase();
		pc.setpId(1);
		pc.setpNum(33);
		pd.update(pc);
		
	}

	//@Test
	public void testDelete() {
		
		pd.delete(1);
		
	}

	@Test
	public void testSearchPugost() {
		List<Pugousst> list=pd.searchPugousst();
		for (Pugousst p : list) {
			 System.out.println(p.toString());
		}
	}

}
