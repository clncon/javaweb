package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.dream.biz.impl.SaleBizImpl;
import com.dream.dao.SaleDao;
import com.dream.entity.Sale;
/**
 * ҵ���������Ϣ�Ĳ�����
 * @author ��ҫ
 *2016-3-8����1:59:46
 */
public class TextSaleBizImpl {
	SaleBizImpl sd=new SaleBizImpl();
	Sale sale=new Sale();
	
/*
 * ����������Ϣ
 */
    //@Test
	public void testAddSale() {
//		sale.setSaNum(555);  //����������
//		sale.setSaPrice(20000);//���۽��
//		sale.setSaVisitor(888);//�ÿ�����
//		sale.setSaSname("��Ȼ��԰");
//		sd.addSale(sale);
	}
/*
 * ɾ��������Ϣ
 */
	@Test
	public void testDeleteSale() {
//		sd.deleteSale(4);
		
	}
/*
 * �޸�������Ϣ
 */
	@Test
	public void testUpdateSale() {
//		sale.setSaNum(1);
//		sale.setSaPrice(1);
//		sale.setSaVisitor(1);
//		sale.setSaSname("��Ȼ��԰");
//		sale.setSaId(2);
//		sd.updateSale(sale);
		
	}
/*
 * ��ѯȫ��������Ϣ
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
