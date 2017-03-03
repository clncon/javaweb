package com.dream.dao;

import java.util.List;
import com.dream.entity.Purchase;
import com.dream.entity.view.Pugousst;

/**
 * 购买接口
 * 
 * @author 晓风 2016-3-4上午10:25:31
 */
/**
 * @author 葛睿 2016-3-24下午4:00:36
 */
public interface PurchaseDao {
	/**
	 * 查询购物下单信息
	 * 
	 * @param pc
	 */
	public List<Purchase> search();

	/**
	 * 添加下单信息
	 * 
	 * @param pc
	 */

	public void add(Purchase pc);

	/**
	 * 更新下单信息
	 * 
	 * @param pId
	 */

	public void update(Purchase pc);

	/**
	 * 删除下单信息
	 * 
	 * @return
	 */

	public void delete(Integer pId);

	/**
	 * 查询购买店面商品信息
	 * 
	 * @return
	 */

	public List<Pugousst> searchPugousst();

	/**
	 * 根据买家ID 店面ID 商品ID 查询数据
	 * 
	 * @param pUid
	 * @param pSid
	 * @param pGid
	 * @return
	 */
	public Purchase searchPurchase(int pUid, int pSid, int pGid);

	/**
	 * 根据购买ID查询信息
	 * 
	 * @param pId
	 * @return
	 */
	public Purchase search(int pId);

}
