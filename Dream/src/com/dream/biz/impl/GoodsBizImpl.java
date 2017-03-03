package com.dream.biz.impl;

/**
 * 商品业务层实现类
 * @author 陈霞
 *2016-3-8下午1:22:10
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
	 * 增加商品
	 * 
	 * @param goods
	 */
	@Override
	public void addGoods(Goods goods) {
		dao.add(goods);

	}

	/**
	 * 删除商品
	 */
	@Override
	public void deleteGoods(int gId) {
		dao.delete(gId);

	}

	/**
	 * 更改商品
	 * 
	 * @param goods
	 */
	@Override
	public void updateGoods(Goods goods) {
		dao.update(goods);

	}

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	@Override
	public List<Goods> searchGoods() {
		List<Goods> listgoods = dao.search();
		return listgoods;
	}

	/**
	 * 根据商品id查询商品
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
	 * 分页查询
	 * 
	 * @param pageNo
	 *            开始的位置
	 * @param pageSize
	 *            分页大小
	 * @return
	 */
	@Override
	public List<Goods> searchPage_Goods(Integer pageNo, Integer pageSize) {
		List<Goods> listgoodspage = dao.searchPage_Goods(pageNo, pageSize);
		return listgoodspage;
	}

	/**
	 * 商品总数
	 * 
	 * @return
	 */
	@Override
	public Integer searchGoodsCount() {
		Integer count = dao.searchGoodsCount();
		return count;
	}

	/**
	 * 根据名字查询商品
	 */
	@Override
	public Goods searchByGname(String gName) {
		Goods goods = dao.searchByGname(gName);
		return goods;
	}

	/**
	 * 魏陈霞 拼接条件查询
	 */
	@Override
	public List<Goods> searchByCondition(Goods goods) {
		List<Goods> listgoods = dao.searchByCondition(goods);
		return listgoods;
	}

}
