package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.PurchaseBiz;
import com.dream.comm.BaseDaoMysql;
import com.dream.dao.PurchaseDao;
import com.dream.dao.impl.PurchaseDaoImpl;
import com.dream.entity.Purchase;
import com.dream.entity.view.Pugousst;

/**
 * 
 */
public class PurchaseBizImpl extends BaseDaoMysql implements PurchaseBiz {

	PurchaseDao dao = new PurchaseDaoImpl();

	/**
	 * ��ѯ
	 */
	@Override
	public List<Purchase> search() {
		List<Purchase> listPC = dao.search();
		return listPC;
	}

	/**
	 * ���
	 */
	@Override
	public void add(Purchase pc) {
		dao.add(pc);
	}

	/**
	 * ����
	 */
	@Override
	public void update(Purchase pc) {
		dao.update(pc);
	}

	/**
	 * ɾ��
	 */
	@Override
	public void delete(Integer pId) {
		dao.delete(pId);
	}

	/**
	 * �����ѯ���������Ʒ�������
	 */
	@Override
	public List<Pugousst> searchPugousst() {
		List<Pugousst> listPugost = dao.searchPugousst();
		return listPugost;
	}

	/**
	 * �����û�ID  ����ID  ����ID ��ѯ
	 */
	@Override
	public Purchase searchPurchase(int pUid, int pSid, int pGid) {

		return dao.searchPurchase(pUid, pSid, pGid);
	}

	/**
	 * ���ݹ���ID��ѯ
	 */
	@Override
	public Purchase search(int pId) {

		return dao.search(pId);
	}

}
