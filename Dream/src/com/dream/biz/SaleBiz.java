package com.dream.biz;

import java.util.List;

import com.dream.entity.Sale;

/**
 * 销售信息的业务层
 * 
 * @author 建耀 2016-3-8下午1:50:24
 */
public interface SaleBiz {

	/**
	 * 增加销售信息
	 */
	public void addSale(Sale sale);

	/**
	 * 删除销售信息
	 */
	public void deleteSale(int saId);

	/**
	 * 修改销售信息
	 */
	public void updateSale(Sale sale);

	/**
	 * 查询全部销售信息
	 */
	public List<Sale> searchSale();

	/**
	 * 根据ID查询销售信息
	 */
	public Sale serachSale(int saId);

}
