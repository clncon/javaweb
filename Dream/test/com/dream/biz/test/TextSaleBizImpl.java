package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.dream.biz.impl.SaleBizImpl;
import com.dream.dao.SaleDao;
import com.dream.entity.Sale;
/**
 * 业务层销售信息的测试类
 * @author 建耀
 *2016-3-8下午1:59:46
 */
public class TextSaleBizImpl {
	SaleBizImpl sd=new SaleBizImpl();
	Sale sale=new Sale();
	
/*
 * 增加销售信息
 */
    //@Test
	public void testAddSale() {
//		sale.setSaNum(555);  //订单的数量
//		sale.setSaPrice(20000);//销售金额
//		sale.setSaVisitor(888);//访客数量
//		sale.setSaSname("当然果园");
//		sd.addSale(sale);
	}
/*
 * 删除销售信息
 */
	@Test
	public void testDeleteSale() {
//		sd.deleteSale(4);
		
	}
/*
 * 修改销售信息
 */
	@Test
	public void testUpdateSale() {
//		sale.setSaNum(1);
//		sale.setSaPrice(1);
//		sale.setSaVisitor(1);
//		sale.setSaSname("当然果园");
//		sale.setSaId(2);
//		sd.updateSale(sale);
		
	}
/*
 * 查询全部销售信息
 */
	@Test
	public void testSearchSale() {
//		List<Sale> listsale=sd.searchSale();
//		for (Sale sale : listsale) {
//			System.out.println(sale.toString());
//		}
		
	}

	@Test
	public void testSerachSale() {
		Sale sale=sd.serachSale(7);
		System.out.println(sale.toString());
		
		
	}

}
