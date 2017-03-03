package com.dream.biz;

import java.util.List;

import com.dream.entity.Purchase;
import com.dream.entity.view.Pugousst;
/**
 * 
 * @author  ���� 
 *2016-3-8����3:07:22
 */
public interface PurchaseBiz {

	/**
	 * ��ѯ�����µ���Ϣ
	 * @param pc
	 */
	public List<Purchase> search();
	/**
	 * ����µ���Ϣ
	 * @param pc
	 */
	
	public void add(Purchase pc);
	/**
	 * �����µ���Ϣ
	 * @param pId
	 */
	
	public void update(Purchase pc);
	/**
	 * ɾ���µ���Ϣ
	 * @return
	 */
	
	public void delete(Integer pId);
	/**
	 * ��ѯ���������Ʒ��Ϣ
	 * @return
	 */
	
	public List<Pugousst> searchPugousst();
	/**
	 * �������ID  ��ƷID  ����ID��ѯ
	 * @param pUid
	 * @param pSid
	 * @param pGid
	 * @return
	 */
	 public  Purchase searchPurchase(int pUid,int pSid,int pGid);
	 /**
	  * ���ݹ���ID��ѯ
	  * @param pId
	  * @return
	  */
	  public  Purchase search(int pId);
}
