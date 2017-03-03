package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.RepertoryBiz;
import com.dream.dao.RepertoryDao;
import com.dream.dao.impl.RepertoryDaoImpl;
import com.dream.entity.Repertory;
import com.dream.entity.view.Regost;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * 
 */
public class RepertoryBizImpl implements RepertoryBiz {
	static RepertoryDao dao = new RepertoryDaoImpl();

	/**
	 * 多表查詢信息
	 * 
	 * @return
	 */
	@Override
	public List<Regost> searchRepertory() {
		List<Regost> listRegost = dao.search();
		return listRegost;
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<Regost> searchPage_Repertory(Regost regost, Integer pageNo,
			Integer pageSize) {
		List<Regost> listRegostpage = dao.searchPage_Repertory(regost, pageNo,
				pageSize);
		return listRegostpage;
	}

	/**
	 * 记录总数
	 */
	@Override
	public Integer searchRepertoryCount(Regost regost) {
		Integer count = dao.searchRepertoryCount(regost);
		return count;
	}

	/**
	 * 记录总数
	 */
	@Override
	public Integer searchGiftCount(Regost regost) {
		Integer count = dao.searchGiftCount(regost);
		return count;
	}

	/**
	 * 陈霞 多表条件查询
	 */
	@Override
	public List<Regost> search(Regost regost) {
		List<Regost> list = dao.search(regost);
		return list;
	}

	/**
	 * 兴鹏 多表Id查询
	 */
	@Override
	public Regost searchBygId(Integer gid) {
		Regost rogest = dao.searchBygId(gid);
		return rogest;
	}

	/**
	 * 多表查询礼品
	 */
	@Override
	public List<Regost> searchGift(Regost regost) {
		List<Regost> listgift = dao.searchGift(regost);
		return listgift;
	}

	/**
	 * 陈霞 多表分页查询礼品
	 * 
	 * @param regost
	 * @return
	 */
	@Override
	public List<Regost> searchGift(Regost regost, Integer pageNo,
			Integer pageSize) {
		List<Regost> list = dao.searchGift(regost, pageNo, pageSize);
		return list;
	}

	/**
	 * 陈霞 添加库存
	 */
	@Override
	public void addRepertory(Repertory re) {
		dao.addRepertory(re);

	}

	/**
	 * 陈霞 删除库存
	 */
	public void deletRepertory(Repertory re) {
		dao.deletRepertory(re);
	}

}
