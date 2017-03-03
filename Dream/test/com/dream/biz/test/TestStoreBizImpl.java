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
 * @author  ���� 
 *2016-3-8����3:01:15
 */
public class TestStoreBizImpl {

	StoreBiz sbiz=new StoreBizImpl();
	
	//@Test
	public void testAdd() {
		Store store=new Store("Сƽˮ����", "119", "�����г�͡", 5);
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
		store.setsAddress("����");
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
		System.out.println("���� �ж������� "+page.getTotalCount());
		System.out.println("ÿҳ�Ĵ�С: "+page.getPageSize());
		System.out.println("���м�ҳ��"+page.getPageCount());
		
		List<Store> list=sbiz.searchPage_Store(page.getPageNo(), page.getPageSize());
		System.out.println("һ���鵽��"+list.size()+"��");
		
		for (Store store : list) {
			System.out.println(store);
		}
	}
	
	@Test
	public void testsearchStoreBySuid(){
		Store store=sbiz.searchStoreBySuid(25);
		System.out.println("���ݵ���ID�������Ϣ��"+store);

	}

}
