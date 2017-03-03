package com.dream.biz;

import java.util.List;

import com.dream.entity.Goods;

/**
 * 商品业务层接口
 * 
 * @author 陈霞 2016-3-8下午1:22:10
 * 
 */

public interface GoodsBiz {
	/**
	 * 增加商品
	 * 
	 * @param goods
	 */
	public void addGoods(Goods goods);

	/**
	 * 删除商品
	 */
	public void deleteGoods(int gId);

	/**
	 * 更改商品
	 * 
	 * @param goods
	 */
	public void updateGoods(Goods goods);

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	public List<Goods> searchGoods();

	/**
	 * 根据商品id查询商品
	 * 
	 * @param gId
	 * @return
	 */
	public Goods searchGoods(int gId);

	/**
	 * 根据商品名字查询商品
	 * 
	 * @param gName
	 * @return
	 */
	public Goods searchByGname(String gName);

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 *            开始的位置
	 * @param pageSize
	 *            分页大小
	 * @return
	 */
	public List<Goods> searchPage_Goods(Integer pageNo, Integer pageSize);

	/**
	 * 商品总数
	 * 
	 * @return
	 */
	public Integer searchGoodsCount();

	/**
	 * 魏陈霞 拼接条件查询
	 */
	public List<Goods> searchByCondition(Goods goods);

}
