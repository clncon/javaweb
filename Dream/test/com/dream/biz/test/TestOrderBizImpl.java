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
 * 订单业务层测试类
 * @author 小平
 *2016-3-8下午1:51:23
 */
public class TestOrderBizImpl {

	OrderBiz biz=new OrderBizImpl();
	/**
	 * 查询全部订单信息
	 */
	//@Test
	public void testSearchOrders() {
		List<Orders> list=biz.searchOrders();
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}

	/**
	 * 添加订单信息
	 */
	//@Test
	public void testAddOrders() {
		Orders orders=new Orders();
		orders.setoPid(1);
//		orders.setoUid(12);
//		orders.setoSid(2);
		orders.setoStatus("正在送往");
		orders.setoAddress("厦门市思明区软件园二期");
		orders.setoStartdate("2016-03-05");
		orders.setoEnddate("2016-03-07");
		biz.addOrders(orders);
	}

	/**
	 * 修改订单信息
	 */
	@Test
	public void testUpdateOrders() {
		Orders orders=new Orders();
		
//		orders.setoUid(12);
//		orders.setoSid(2);
		orders.setoStatus("正在送往");
		orders.setoAddress("厦门市思明区软件园二期观日路2号");
		orders.setoStartdate("2016-03-06");
		orders.setoEnddate("2016-03-08");
		orders.setoPid(2);
		biz.updateOrders(orders);
	}

	/**
	 * 删除订单信息
	 */
	//@Test
	public void testDeleteOrders() {
		biz.deleteOrders(2);
	}

//	/**
//	 * 购买订单用户店面信息
//	 */
//	//@Test
//	public void testSearchOrpuusst() {
//		List<Orpuusst> list=biz.searchOrpuusst();
//		for (Orpuusst orpuusst : list) {
//			System.out.println(orpuusst);
//		}
//	}
	/**
	 * 购买订单信息
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
		
		System.out.println("数据 有多少条： "+page.getTotalCount());
		System.out.println("每页的大小 "+page.getPageSize());
		System.out.println("共有几页："+page.getPageCount());
		System.out.println("当前在"+page.getPageNo());
		
		List<Orders> list=biz.searchPage_Orders(page.getPageNo(), page.getPageSize());
		System.out.println("一共查到 ："+list.size());
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}

	@Test
	public void testSearchOrdersCount() {
		
	}

}
