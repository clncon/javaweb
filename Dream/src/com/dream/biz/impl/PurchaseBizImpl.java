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
	 * 查询
	 */
	@Override
	public List<Purchase> search() {
		List<Purchase> listPC = dao.search();
		return listPC;
	}

	/**
	 * 添加
	 */
	@Override
	public void add(Purchase pc) {
		dao.add(pc);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(Purchase pc) {
		dao.update(pc);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer pId) {
		dao.delete(pId);
	}

	/**
	 * 联表查询（购买表，商品表，店面表）
	 */
	@Override
	public List<Pugousst> searchPugousst() {
		List<Pugousst> listPugost = dao.searchPugousst();
		return listPugost;
	}

	/**
	 * 根据用户ID  店面ID  购买ID 查询
	 */
	@Override
	public Purchase searchPurchase(int pUid, int pSid, int pGid) {

		return dao.searchPurchase(pUid, pSid, pGid);
	}

	/**
	 * 根据购买ID查询
	 */
	@Override
	public Purchase search(int pId) {

		return dao.search(pId);
	}

}
