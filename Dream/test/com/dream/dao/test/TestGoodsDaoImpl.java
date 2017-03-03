package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.comm.Page;
import com.dream.dao.GoodsDao;
import com.dream.dao.impl.GoodsDaoImpl;
import com.dream.entity.Goods;
/**
 * ��Ʒdao��� ������
 * @author Сƽ
 *2016-3-4����12:36:08
 */
public class TestGoodsDaoImpl {
	
	GoodsDao dao=new GoodsDaoImpl();
	
	
/**
 * �����Ʒ��Ϣ
 * 
 */
	
	//@Test
	public void testAdd() {
		Goods goods=new Goods();
		goods.setgName("Խ�ϻ�����");
		goods.setgPrice(39.00);
		goods.setgType("������");
		goods.setgAddress("Խ��");
		goods.setgPic("huolongguo.jpg");
		goods.setgDescribe("���ʺóԵĵĻ�����");
		dao.add(goods);
	}
/**
 * ɾ����Ʒ��Ϣ
 */
	//@Test
	public void testDelete() {
		
	dao.delete(2);
	}
/**
 * �޸���Ʒ��Ϣ
 */
	@Test
	public void testUpdate() {
		Goods goods=new Goods();
		goods.setgName("���ɱ�����");
		goods.setgPrice(38.00);
		goods.setgType("����");
		goods.setgAddress("���ɱ�");
		goods.setgPic("fengli.jpg");
		goods.setgDescribe("���ʺóԵĵķ���");
		goods.setgId(1);
		dao.update(goods);
	}
/**
 * ��ѯȫ����Ʒ��Ϣ
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
 * ����id��ѯ��Ʒ��Ϣ
 */
	@Test
	public void testSearchInt() {
		Goods goods=dao.search(3);
		System.out.println("����id��ѯ��Ʒ��Ϣ:"+goods.toString());
	}
	
	@Test
	public void testSearchPage_Goods(){
		Page page=new Page(1, 5);
		page.setTotalCount(dao.searchGoodsCount());
		
		System.out.println("���� �ж������� "+page.getTotalCount());
		System.out.println("ÿҳ�Ĵ�С "+page.getPageSize());
		System.out.println("���м�ҳ��"+page.getPageCount());
		System.out.println("��ǰ��"+page.getPageNo());
		
		List<Goods> list=dao.searchPage_Goods(page.getPageNo(), page.getPageSize());
		System.out.println("һ���鵽 ��"+list.size());
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}

}
