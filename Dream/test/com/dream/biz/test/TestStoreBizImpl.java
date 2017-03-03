package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.biz.StoreBiz;
import com.dream.biz.impl.StoreBizImpl;
import com.dream.comm.Page;
import com.dream.entity.Store;
/**
 * 
 * @author  晓风 
 *2016-3-8下午3:01:15
 */
public class TestStoreBizImpl {

	StoreBiz sbiz=new StoreBizImpl();
	
	//@Test
	public void testAdd() {
		Store store=new Store("小平水果店", "119", "龙岩市长汀", 5);
		sbiz.add(store);
	}

	//@Test
	public void testDelete() {
		sbiz.delete(5);
	}

	//@Test
	public void testUpdate() {
		Store store = new Store();
		store.setsId(6);
		store.setsAddress("宇宙");
		sbiz.update(store);
	}

	//@Test
	public void testSearch() {
		List<Store> list= sbiz.search();
		 for (Store s : list) {
			System.out.println(s.toString());
		}
	}

	//@Test
	public void testSearchStore() {
		Store s= sbiz.searchStore(1);
	    System.out.println(s.toString());
	}

	//@Test
	public void testSearchPage_Store() {
		Page page=new Page(1,4);
		page.setTotalCount(sbiz.searchStoreCount());
		System.out.println("数据 有多少条： "+page.getTotalCount());
		System.out.println("每页的大小: "+page.getPageSize());
		System.out.println("共有几页："+page.getPageCount());
		
		List<Store> list=sbiz.searchPage_Store(page.getPageNo(), page.getPageSize());
		System.out.println("一共查到："+list.size()+"条");
		
		for (Store store : list) {
			System.out.println(store);
		}
	}
	
	@Test
	public void testsearchStoreBySuid(){
		Store store=sbiz.searchStoreBySuid(25);
		System.out.println("根据店主ID查店面信息："+store);

	}

}
