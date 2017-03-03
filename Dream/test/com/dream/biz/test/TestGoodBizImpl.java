package com.dream.biz.test;
/**
 * 商品业务层测试类
 * @author 陈霞
 *2016-3-8下午1:22:10
 *
 */

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.biz.GoodsBiz;

import com.dream.biz.impl.GoodsBizImpl;
import com.dream.comm.Page;
import com.dream.entity.Goods;

public class TestGoodBizImpl {
	GoodsBiz biz=new GoodsBizImpl();
	//@Test
	public void testAddGoods() {
		Goods goods=new Goods();
		goods.setgName("越南火龙果");
		goods.setgPrice(39.00);
		goods.setgType("火龙果");
		goods.setgAddress("越南");
		goods.setgPic("huolongguo.jpg");
		goods.setgDescribe("新鲜好吃的的火龙果");
		biz.addGoods(goods);
	}

	//@Test
	public void testDeleteGoods() {
		biz.deleteGoods(1);
	}

	@Test
	public void testUpdateGoods() {
		Goods goods=new Goods();
		goods.setgName("越南火龙果");
		goods.setgPrice(39.00);
		goods.setgType("火龙果");
		goods.setgAddress("越南");
		goods.setgPic("huolongguo.jpg");
		goods.setgDescribe("新鲜好吃的的火龙果");
		biz.updateGoods(goods);
	}

	@Test
	public void testSearchGoods() {
		List<Goods> list=biz.searchGoods();
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}

	@Test
	public void testSearchGoodsInt() {
		Goods goods=biz.searchGoods(1);
		System.out.println(goods);
	}

	@Test
	public void testSearchPage_Goods() {
		Page page=new Page(1,4);
		List<Goods> list=biz.searchPage_Goods(page.getPageNo(), page.getPageSize());
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}

	@Test
	public void testSearchGoodsCount() {
	System.out.println(biz.searchGoodsCount());	
	}

}
