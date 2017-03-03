package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.ActivityBiz;
import com.dream.comm.BaseDaoMysql;
import com.dream.dao.ActivityDao;
import com.dream.dao.impl.ActivityDaoImpl;
import com.dream.entity.Activity;
import com.dream.entity.view.AcGoods;

/**
 * 
 */
public class ActivityBizImpl extends BaseDaoMysql implements ActivityBiz {

	ActivityDao dao = new ActivityDaoImpl();

	/**
	 * ��ӻ
	 */
	@Override
	public void add(Activity ac) {
		dao.add(ac);

	}

	/**
	 * ɾ���
	 */
	@Override
	public void delete(int aId) {
		dao.delete(aId);

	}

	/**
	 * ���»
	 */
	@Override
	public void update(Activity ac) {
		dao.update(ac);

	}

	/**
	 * ���ݻID��ѯ
	 */
	@Override
	public AcGoods searchById(int aId) {
		AcGoods as = dao.searchById(aId);
		return as;
	}

	/**
	 * ��ѯ
	 */
	@Override
	public List<AcGoods> search() {
		List<AcGoods> listas = dao.search();

		return listas;
	}

	/**
	 * 
	 */
	@Override
	public List<AcGoods> searchByadate(String adate) {
		List<AcGoods> listag = dao.searchByadate(adate);
		return listag;
	}

	/**
	 * ���ݻIDɾ���
	 */
	@Override
	public void deleteByaGid(int aGid) {
		dao.deleteByaGid(aGid);

	}

	/**
	 * ��ҳ��ѯ�
	 */
	@Override
	public List<AcGoods> searchPage(String adate, Integer pageNo,
			Integer pageSize) {
		List<AcGoods> listac = dao.searchPage(adate, pageNo, pageSize);
		return listac;
	}

	/**
	 * ��ѯ�ܼ�¼��
	 */
	@Override
	public Integer searchCount(String adate) {
		Integer count = dao.searchCount(adate);
		return count;
	}

}
