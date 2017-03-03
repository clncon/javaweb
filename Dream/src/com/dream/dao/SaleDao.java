package com.dream.dao;

import java.util.List;
import com.dream.entity.Sale;

/**
 * 销售的接口
 * 
 * @author 葛睿 2016-3-3下午9:44:59
 */
public interface SaleDao {
	/**
	 * 增加销售
	 */
	public void add(Sale sale);

	/**
	 * 删除销售
	 */
	public void delete(int saId);

	/**
	 * 更改销售信息
	 */
	public void update(Sale sale);

	/**
	 * 查询销售信息
	 * 
	 * @return
	 */
	public List<Sale> search();

	/**
	 * 根据销售id查询销售信息
	 * 
	 * @return
	 */
	public Sale searchSale(int saId);

}
