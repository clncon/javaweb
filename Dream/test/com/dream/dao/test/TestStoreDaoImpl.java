package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.comm.Page;
import com.dream.dao.StoreDao;
import com.dream.dao.impl.StoreDaoImpl;
import com.dream.entity.Store;
/**
 * 
 * @author  晓风 
 *2016-3-10下午2:56:29
 */
public class TestStoreDaoImpl {
	 
	  StoreDao dao= new StoreDaoImpl(); 
	//@Test
	public void testAdd() {
		Store store=new Store("123", "123", "123" , 4);
		dao.add(store);
		
		
	}

	//@Test
	public void testDelete() {
		 dao.delete(2);
		
	}

	//@Test
	public void testUpdate() {
		Store store = new Store();
		store.setsId(1);
		store.setsAddress("asd");
		dao.update(store);
		
	}

	//@Test
	public void testSearch() {
		List<Store> list= dao.search();
		 for (Store s : list) {
			System.out.println(s.toString());
		}
	}

	//@Test
	public void testSearchStore() {
		    Store s= dao.searchStore(1);
		     System.out.println(s.toString());
		 
	}

	//@Test
	public void testsearchPage_Store(){
		Page page=new Page(1,4);
		page.setTotalCount(dao.searchStoreCount());
		System.out.println("数据 有多少条： "+page.getTotalCount());
		System.out.println("每页的大小: "+page.getPageSize());
		System.out.println("共有几页："+page.getPageCount());
		
		List<Store> list=dao.searchPage_Store(page.getPageNo(), page.getPageSize());
		System.out.println("一共查到："+list.size()+"条");
		
		for (Store store : list) {
			System.out.println(store);
		}
		
	}
	
	@Test
	public void testsearchStoreBySuid(){
		Store store=dao.searchStoreBySuid(24);
		System.out.println("根据店主ID查店面信息："+store);
	}
	
}
