package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.dao.SaleDao;
import com.dream.dao.impl.SaleDaoImpl;
import com.dream.entity.Sale;
/**
 * ����dao��Ĳ�����
 * @author Сƽ
 *2016-3-4����3:51:19
 */
public class TestSaleDaoImpl {
	
	SaleDao dao=new SaleDaoImpl();
	Sale sale=new Sale();

	/**
	 * ���������Ϣ
	 */
	//@Test
	public void testAdd() {
		
		
		sale.setSaNum(6);
		sale.setSaPrice(50);
		sale.setSaVisitor(30);
		sale.setSaSname("��Ȼ��԰");
		dao.add(sale);
		 
	}

	/**
	 * ɾ��������Ϣ
	 */
	@Test
	public void testDelete() {

		dao.delete(4);
	}

	/**
	 * �޸�������Ϣ
	 */
	@Test
	public void testUpdate() {

		sale.setSaNum(3);
		sale.setSaPrice(15);
		sale.setSaVisitor(20);
		//sale.setSaSname("��Ȼ��԰");
		sale.setSaId(2);
		dao.update(sale);
		
	}

	/**
	 * ��ѯȫ��������Ϣ
	 */
	@Test
	public void testSearch() {
	
		List<Sale> listsa=dao.search();
		
		for (Sale sale : listsa) {
			System.out.println(sale.toString());
		}
	}

	/**
	 * ����ID��������Ϣ
	 */
	@Test
	public void testSearchSale() {
		Sale sale=dao.searchSale(3);
		System.out.println("����ID��������Ϣ��"+sale.toString());
		
		
	}

}
