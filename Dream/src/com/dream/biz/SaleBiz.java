package com.dream.biz;

import java.util.List;

import com.dream.entity.Sale;

/**
 * ������Ϣ��ҵ���
 * 
 * @author ��ҫ 2016-3-8����1:50:24
 */
public interface SaleBiz {

	/**
	 * ����������Ϣ
	 */
	public void addSale(Sale sale);

	/**
	 * ɾ��������Ϣ
	 */
	public void deleteSale(int saId);

	/**
	 * �޸�������Ϣ
	 */
	public void updateSale(Sale sale);

	/**
	 * ��ѯȫ��������Ϣ
	 */
	public List<Sale> searchSale();

	/**
	 * ����ID��ѯ������Ϣ
	 */
	public Sale serachSale(int saId);

}
