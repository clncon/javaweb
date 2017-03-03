package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.biz.RepertoryBiz;
import com.dream.biz.impl.RepertoryBizImpl;
import com.dream.comm.Page;
import com.dream.entity.view.Regost;
/**
 * 
 * @author ³ÂÏ¼
 *2016-3-8ÏÂÎç2:13:48
 *
 */
public class TestRepertoryBizImpl {
	RepertoryBiz biz=new RepertoryBizImpl();
	@Test
	public void testSearchRepertory() {
//		//List<Regost> list=biz.searchRepertory();
//		Regost regost=new Regost();
//		regost.setgType("Ó£ÌÒ");
//		List<Regost> list=biz.search(regost);
//		System.out.println("sdsdfsd"+list.toString());
//		for (Regost regost1 : list) {
//			System.out.println(regost1);
//		}
		Regost re=biz.searchBygId(1);
		System.out.println(re);
	}

	//@Test
	public void testSearchPage_Repertory() {
		Page page=new Page(1,2);
		Regost regost=new Regost();
		List<Regost> list=biz.searchPage_Repertory(regost, page.getPageNo(),page.getPageSize());
		for (Regost regost1 : list) {
			System.out.println(regost);
		}
	}

	//@Test
	public void testSearchRepertoryCount() {
		Regost regost=new Regost();
		System.out.println(biz.searchRepertoryCount(regost));
	}

}
