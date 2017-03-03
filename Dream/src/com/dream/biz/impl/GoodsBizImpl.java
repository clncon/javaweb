package com.dream.biz.impl;

/**
 * ��Ʒҵ���ʵ����
 * @author ��ϼ
 *2016-3-8����1:22:10
 *
 */

import java.util.List;

import com.dream.biz.GoodsBiz;
import com.dream.dao.GoodsDao;
import com.dream.dao.impl.GoodsDaoImpl;
import com.dream.entity.Goods;

public class GoodsBizImpl implements GoodsBiz {
	GoodsDao dao = new GoodsDaoImpl();

	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 */
	@Override
	public void addGoods(Goods goods) {
		dao.add(goods);

	}

	/**
	 * ɾ����Ʒ
	 */
	@Override
	public void deleteGoods(int gId) {
		dao.delete(gId);

	}

	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 */
	@Override
	public void updateGoods(Goods goods) {
		dao.update(goods);

	}

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return
	 */
	@Override
	public List<Goods> searchGoods() {
		List<Goods> listgoods = dao.search();
		return listgoods;
	}

	/**
	 * ������Ʒid��ѯ��Ʒ
	 * 
	 * @param gId
	 * @return
	 */
	@Override
	public Goods searchGoods(int gId) {
		Goods goods = dao.search(gId);
		return goods;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param pageNo
	 *            ��ʼ��λ��
	 * @param pageSize
	 *            ��ҳ��С
	 * @return
	 */
	@Override
	public List<Goods> searchPage_Goods(Integer pageNo, Integer pageSize) {
		List<Goods> listgoodspage = dao.searchPage_Goods(pageNo, pageSize);
		return listgoodspage;
	}

	/**
	 * ��Ʒ����
	 * 
	 * @return
	 */
	@Override
	public Integer searchGoodsCount() {
		Integer count = dao.searchGoodsCount();
		return count;
	}

	/**
	 * �������ֲ�ѯ��Ʒ
	 */
	@Override
	public Goods searchByGname(String gName) {
		Goods goods = dao.searchByGname(gName);
		return goods;
	}

	/**
	 * κ��ϼ ƴ��������ѯ
	 */
	@Override
	public List<Goods> searchByCondition(Goods goods) {
		List<Goods> listgoods = dao.searchByCondition(goods);
		return listgoods;
	}

}
