package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.biz.OrderBiz;
import com.dream.biz.impl.OrderBizImpl;
import com.dream.comm.Page;
import com.dream.entity.Goods;
import com.dream.entity.Orders;
import com.dream.entity.view.Orpu;

/**
 * ����ҵ��������
 * @author Сƽ
 *2016-3-8����1:51:23
 */
public class TestOrderBizImpl {

	OrderBiz biz=new OrderBizImpl();
	/**
	 * ��ѯȫ��������Ϣ
	 */
	//@Test
	public void testSearchOrders() {
		List<Orders> list=biz.searchOrders();
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}

	/**
	 * ��Ӷ�����Ϣ
	 */
	//@Test
	public void testAddOrders() {
		Orders orders=new Orders();
		orders.setoPid(1);
//		orders.setoUid(12);
//		orders.setoSid(2);
		orders.setoStatus("��������");
		orders.setoAddress("������˼�������԰����");
		orders.setoStartdate("2016-03-05");
		orders.setoEnddate("2016-03-07");
		biz.addOrders(orders);
	}

	/**
	 * �޸Ķ�����Ϣ
	 */
	@Test
	public void testUpdateOrders() {
		Orders orders=new Orders();
		
//		orders.setoUid(12);
//		orders.setoSid(2);
		orders.setoStatus("��������");
		orders.setoAddress("������˼�������԰���ڹ���·2��");
		orders.setoStartdate("2016-03-06");
		orders.setoEnddate("2016-03-08");
		orders.setoPid(2);
		biz.updateOrders(orders);
	}

	/**
	 * ɾ��������Ϣ
	 */
	//@Test
	public void testDeleteOrders() {
		biz.deleteOrders(2);
	}

//	/**
//	 * ���򶩵��û�������Ϣ
//	 */
//	//@Test
//	public void testSearchOrpuusst() {
//		List<Orpuusst> list=biz.searchOrpuusst();
//		for (Orpuusst orpuusst : list) {
//			System.out.println(orpuusst);
//		}
//	}
	/**
	 * ���򶩵���Ϣ
	 */
	//@Test
	public void testSearchOrpuusst() {
		List<Orpu> list=biz.searchOrpu();
		for (Orpu orpu : list) {
			System.out.println("111");
			System.out.println(orpu);
		}
	}

	//@Test
	public void testSearchOrdersByOId() {
		
	System.out.println(biz.searchOrdersByOId(2));
		
	}

	@Test
	public void testSearchPage_Orders() {
		Page page=new Page(2, 2);
		page.setTotalCount(biz.searchOrdersCount());
		
		System.out.println("���� �ж������� "+page.getTotalCount());
		System.out.println("ÿҳ�Ĵ�С "+page.getPageSize());
		System.out.println("���м�ҳ��"+page.getPageCount());
		System.out.println("��ǰ��"+page.getPageNo());
		
		List<Orders> list=biz.searchPage_Orders(page.getPageNo(), page.getPageSize());
		System.out.println("һ���鵽 ��"+list.size());
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}

	@Test
	public void testSearchOrdersCount() {
		
	}

}
