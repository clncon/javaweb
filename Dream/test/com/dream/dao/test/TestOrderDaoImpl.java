package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.criteria.Order;

import org.junit.Test;

import com.dream.dao.OrderDao;
import com.dream.dao.impl.OrderDaoImpl;
import com.dream.entity.Orders;
import com.dream.entity.view.Orpu;


public class TestOrderDaoImpl {
        
	 OrderDao od = new OrderDaoImpl();
	@Test
	public void testSearch() {
		
		 List< Orders> list = od.search();
		 for (Orders order : list) {
			System.out.println(order.toString());
		}
		
	}

	@Test
	public void testAdd() {
		// Orders od1= new Orders(1, 11, "1", "11", "11", "11");
		//od.add(od1);
		
	}

	//@Test
	public void testUpdate() {
		Orders o= new Orders();

		 o.setoAddress("123");
		 o.setoPid(1);
		od.update(o);
		
		
	}

	//@Test
	public void testDelete() {
		 od.delete(7);
	}

//	@Test
//	public void testSearchOrpuusst() {
//		List<Orpuusst> list=od.searchOrpuusst();
//		 for (Orpuusst o : list) {
//			System.out.println(o.toString());
//		}
//	}
	/**
	 * ∂©µ•π∫¬Ú≤‚ ‘
	 */
	@Test
	public void testSearchOrpu() {
		List<Orpu> list=od.searchOrpu();
		for (Orpu orpu : list) {
			
			System.out.println(orpu.toString());
		}
	}
	
	

	//@Test
	public void testSearchByOId() {
		od.searchByOId(1);
		
	}

}
