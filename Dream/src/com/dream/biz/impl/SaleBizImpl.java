package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.SaleBiz;
import com.dream.dao.SaleDao;
import com.dream.dao.impl.SaleDaoImpl;
import com.dream.entity.Sale;

/**
 * ������Ϣҵ��ʵ��
 * 
 */
public class SaleBizImpl implements SaleBiz {

	/*
	 * ����������Ϣ ����ҫ 2016-3-8����1:54:14
	 */
	@Override
	public void addSale(Sale sale) {
		SaleDao ad = new SaleDaoImpl();
		ad.add(sale);

	}

	/*
	 * ɾ��������Ϣ ����ҫ 2016-3-8����1:54:58
	 */
	@Override
	public void deleteSale(int saId) {
		SaleDao ad = new SaleDaoImpl();
		ad.delete(saId);

	}

	/*
	 * �޸�������Ϣ ����ҫ 2016-3-8����1:55:11
	 */
	@Override
	public void updateSale(Sale sale) {
		SaleDaoImpl ad = new SaleDaoImpl();
		ad.update(sale);

	}

	/*
	 * ��ѯȫ��������Ϣ ����ҫ 2016-3-8����1:55:26
	 */
	@Override
	public List<Sale> searchSale() {
		SaleDao ad = new SaleDaoImpl();

		return ad.search();
	}

	/*
	 * ����ID��ѯ������Ϣ ����ҫ 2016-3-8����1:55:36
	 */
	@Override
	public Sale serachSale(int saId) {
		SaleDao ad = new SaleDaoImpl();
		return ad.searchSale(saId);
	}

}
