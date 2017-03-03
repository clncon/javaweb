package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.comm.Page;
import com.dream.dao.GoodsDao;
import com.dream.dao.impl.GoodsDaoImpl;
import com.dream.entity.Goods;
/**
 * 商品dao层的 测试类
 * @author 小平
 *2016-3-4下午12:36:08
 */
public class TestGoodsDaoImpl {
	
	GoodsDao dao=new GoodsDaoImpl();
	
	
/**
 * 添加商品信息
 * 
 */
	
	//@Test
	public void testAdd() {
		Goods goods=new Goods();
		goods.setgName("越南火龙果");
		goods.setgPrice(39.00);
		goods.setgType("火龙果");
		goods.setgAddress("越南");
		goods.setgPic("huolongguo.jpg");
		goods.setgDescribe("新鲜好吃的的火龙果");
		dao.add(goods);
	}
/**
 * 删除商品信息
 */
	//@Test
	public void testDelete() {
		
	dao.delete(2);
	}
/**
 * 修改商品信息
 */
	@Test
	public void testUpdate() {
		Goods goods=new Goods();
		goods.setgName("菲律宾凤梨");
		goods.setgPrice(38.00);
		goods.setgType("凤梨");
		goods.setgAddress("菲律宾");
		goods.setgPic("fengli.jpg");
		goods.setgDescribe("新鲜好吃的的凤梨");
		goods.setgId(1);
		dao.update(goods);
	}
/**
 * 查询全部商品信息
 * 
 */
	//@Test
	public void testSearch() {
		
		List<Goods> listgs=dao.search();
		
		for (Goods goods : listgs) {
			System.out.println(goods.toString());
		}
		
	}
/**
 * 根据id查询商品信息
 */
	@Test
	public void testSearchInt() {
		Goods goods=dao.search(3);
		System.out.println("根据id查询商品信息:"+goods.toString());
	}
	
	@Test
	public void testSearchPage_Goods(){
		Page page=new Page(1, 5);
		page.setTotalCount(dao.searchGoodsCount());
		
		System.out.println("数据 有多少条： "+page.getTotalCount());
		System.out.println("每页的大小 "+page.getPageSize());
		System.out.println("共有几页："+page.getPageCount());
		System.out.println("当前在"+page.getPageNo());
		
		List<Goods> list=dao.searchPage_Goods(page.getPageNo(), page.getPageSize());
		System.out.println("一共查到 ："+list.size());
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}

}
