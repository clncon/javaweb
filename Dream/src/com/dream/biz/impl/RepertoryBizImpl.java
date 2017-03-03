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
	 * ����ԃ��Ϣ
	 * 
	 * @return
	 */
	@Override
	public List<Regost> searchRepertory() {
		List<Regost> listRegost = dao.search();
		return listRegost;
	}

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public List<Regost> searchPage_Repertory(Regost regost, Integer pageNo,
			Integer pageSize) {
		List<Regost> listRegostpage = dao.searchPage_Repertory(regost, pageNo,
				pageSize);
		return listRegostpage;
	}

	/**
	 * ��¼����
	 */
	@Override
	public Integer searchRepertoryCount(Regost regost) {
		Integer count = dao.searchRepertoryCount(regost);
		return count;
	}

	/**
	 * ��¼����
	 */
	@Override
	public Integer searchGiftCount(Regost regost) {
		Integer count = dao.searchGiftCount(regost);
		return count;
	}

	/**
	 * ��ϼ ���������ѯ
	 */
	@Override
	public List<Regost> search(Regost regost) {
		List<Regost> list = dao.search(regost);
		return list;
	}

	/**
	 * ���� ���Id��ѯ
	 */
	@Override
	public Regost searchBygId(Integer gid) {
		Regost rogest = dao.searchBygId(gid);
		return rogest;
	}

	/**
	 * ����ѯ��Ʒ
	 */
	@Override
	public List<Regost> searchGift(Regost regost) {
		List<Regost> listgift = dao.searchGift(regost);
		return listgift;
	}

	/**
	 * ��ϼ ����ҳ��ѯ��Ʒ
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
	 * ��ϼ ��ӿ��
	 */
	@Override
	public void addRepertory(Repertory re) {
		dao.addRepertory(re);

	}

	/**
	 * ��ϼ ɾ�����
	 */
	public void deletRepertory(Repertory re) {
		dao.deletRepertory(re);
	}

}
