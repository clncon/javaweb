package com.dream.dao;

import java.util.List;
import com.dream.entity.Purchase;
import com.dream.entity.view.Pugousst;

/**
 * ����ӿ�
 * 
 * @author ���� 2016-3-4����10:25:31
 */
/**
 * @author ��� 2016-3-24����4:00:36
 */
public interface PurchaseDao {
	/**
	 * ��ѯ�����µ���Ϣ
	 * 
	 * @param pc
	 */
	public List<Purchase> search();

	/**
	 * ����µ���Ϣ
	 * 
	 * @param pc
	 */

	public void add(Purchase pc);

	/**
	 * �����µ���Ϣ
	 * 
	 * @param pId
	 */

	public void update(Purchase pc);

	/**
	 * ɾ���µ���Ϣ
	 * 
	 * @return
	 */

	public void delete(Integer pId);

	/**
	 * ��ѯ���������Ʒ��Ϣ
	 * 
	 * @return
	 */

	public List<Pugousst> searchPugousst();

	/**
	 * �������ID ����ID ��ƷID ��ѯ����
	 * 
	 * @param pUid
	 * @param pSid
	 * @param pGid
	 * @return
	 */
	public Purchase searchPurchase(int pUid, int pSid, int pGid);

	/**
	 * ���ݹ���ID��ѯ��Ϣ
	 * 
	 * @param pId
	 * @return
	 */
	public Purchase search(int pId);

}
