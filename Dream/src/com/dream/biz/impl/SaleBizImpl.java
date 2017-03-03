package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.SaleBiz;
import com.dream.dao.SaleDao;
import com.dream.dao.impl.SaleDaoImpl;
import com.dream.entity.Sale;

/**
 * 销售信息业的实现
 * 
 */
public class SaleBizImpl implements SaleBiz {

	/*
	 * 增加销售信息 胡建耀 2016-3-8下午1:54:14
	 */
	@Override
	public void addSale(Sale sale) {
		SaleDao ad = new SaleDaoImpl();
		ad.add(sale);

	}

	/*
	 * 删除销售信息 胡建耀 2016-3-8下午1:54:58
	 */
	@Override
	public void deleteSale(int saId) {
		SaleDao ad = new SaleDaoImpl();
		ad.delete(saId);

	}

	/*
	 * 修改销售信息 胡建耀 2016-3-8下午1:55:11
	 */
	@Override
	public void updateSale(Sale sale) {
		SaleDaoImpl ad = new SaleDaoImpl();
		ad.update(sale);

	}

	/*
	 * 查询全部销售信息 胡建耀 2016-3-8下午1:55:26
	 */
	@Override
	public List<Sale> searchSale() {
		SaleDao ad = new SaleDaoImpl();

		return ad.search();
	}

	/*
	 * 根据ID查询销售信息 胡建耀 2016-3-8下午1:55:36
	 */
	@Override
	public Sale serachSale(int saId) {
		SaleDao ad = new SaleDaoImpl();
		return ad.searchSale(saId);
	}

}
