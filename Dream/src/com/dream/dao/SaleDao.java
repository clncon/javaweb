package com.dream.dao;

import java.util.List;
import com.dream.entity.Sale;

/**
 * ���۵Ľӿ�
 * 
 * @author ��� 2016-3-3����9:44:59
 */
public interface SaleDao {
	/**
	 * ��������
	 */
	public void add(Sale sale);

	/**
	 * ɾ������
	 */
	public void delete(int saId);

	/**
	 * ����������Ϣ
	 */
	public void update(Sale sale);

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @return
	 */
	public List<Sale> search();

	/**
	 * ��������id��ѯ������Ϣ
	 * 
	 * @return
	 */
	public Sale searchSale(int saId);

}
