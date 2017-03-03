package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.comm.Page;
import com.dream.dao.RepertoryDao;
import com.dream.dao.impl.RepertoryDaoImpl;
import com.dream.entity.Comment;
import com.dream.entity.Repertory;
import com.dream.entity.view.Regost;

public class TestRepertoryDaoImpl {
	static RepertoryDao dao=new RepertoryDaoImpl();
	@Test
	public void testSearch() {
		
//		Regost regost=new Regost();
//		regost.setgType("Ó£ÌÒ");
//		regost.setgPrice(1);
//		List<Regost> list=dao.search(regost);
//	
////		List<Regost> list=dao.search();
//		for (Regost re : list) {
//			System.out.println(re.toString());
//		}
		Regost re=dao.searchBygId(1);
		System.out.println(re);
	}
	//³ÂÏ¼
	//@Test
	public void searchPage_Repertory(){
		Page page=new Page(1,2);
		Regost regost=new Regost();
//		regost.setsId(1);
		regost.setgType("»ðÁú¹û");
		//page.setTotalCount(dao.searchRepertoryCount(regost));
		//System.out.println("ÓÐ¼¸Ò³£º"+page.getPageCount());
	List<Regost> listReg=dao.searchPage_Repertory(regost, page.getPageNo(), page.getPageSize());
	for (Regost regost1 : listReg) {
		System.out.println(regost1);
	}
	}
	
}
