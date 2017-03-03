package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.dao.SaleDao;
import com.dream.dao.impl.SaleDaoImpl;
import com.dream.entity.Sale;
/**
 * 销售dao层的测试类
 * @author 小平
 *2016-3-4下午3:51:19
 */
public class TestSaleDaoImpl {
	
	SaleDao dao=new SaleDaoImpl();
	Sale sale=new Sale();

	/**
	 * 添加销售信息
	 */
	//@Test
	public void testAdd() {
		
		
		sale.setSaNum(6);
		sale.setSaPrice(50);
		sale.setSaVisitor(30);
		sale.setSaSname("当然果园");
		dao.add(sale);
		 
	}

	/**
	 * 删除销售信息
	 */
	@Test
	public void testDelete() {

		dao.delete(4);
	}

	/**
	 * 修改销售信息
	 */
	@Test
	public void testUpdate() {

		sale.setSaNum(3);
		sale.setSaPrice(15);
		sale.setSaVisitor(20);
		//sale.setSaSname("当然果园");
		sale.setSaId(2);
		dao.update(sale);
		
	}

	/**
	 * 查询全部销售信息
	 */
	@Test
	public void testSearch() {
	
		List<Sale> listsa=dao.search();
		
		for (Sale sale : listsa) {
			System.out.println(sale.toString());
		}
	}

	/**
	 * 根据ID查销售信息
	 */
	@Test
	public void testSearchSale() {
		Sale sale=dao.searchSale(3);
		System.out.println("根据ID查销售信息："+sale.toString());
		
		
	}

}
