package com.dream.dao;
import java.util.List;
import com.dream.entity.Goods;

/**
 * 商品的接口
 * 
 * @author 葛睿 2016-3-3下午9:24:40
 */
public interface GoodsDao {
	/**
	 * 增加商品
	 * 
	 * @param goods
	 */
	public void add(Goods goods);

	/**
	 * 删除商品
	 */
	public void delete(int gId);

	/**
	 * 更改商品
	 * 
	 * @param goods
	 */
	public void update(Goods goods);

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	public List<Goods> search();

	/**
	 * 根据商品id查询商品
	 * 
	 * @param gId
	 * @return
	 */
	public Goods search(int gId);

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
	 * 根据名字查询
	 * 
	 * @param gName
	 * @return
	 */
	public Goods searchByGname(String gName);

	/**
	 * 魏陈霞 拼接条件查询
	 */
	public List<Goods> searchByCondition(Goods goods);
}
