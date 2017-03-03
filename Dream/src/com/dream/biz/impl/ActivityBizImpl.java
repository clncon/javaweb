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
	 * 添加活动
	 */
	@Override
	public void add(Activity ac) {
		dao.add(ac);

	}

	/**
	 * 删除活动
	 */
	@Override
	public void delete(int aId) {
		dao.delete(aId);

	}

	/**
	 * 更新活动
	 */
	@Override
	public void update(Activity ac) {
		dao.update(ac);

	}

	/**
	 * 根据活动ID查询
	 */
	@Override
	public AcGoods searchById(int aId) {
		AcGoods as = dao.searchById(aId);
		return as;
	}

	/**
	 * 查询
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
	 * 根据活动ID删除活动
	 */
	@Override
	public void deleteByaGid(int aGid) {
		dao.deleteByaGid(aGid);

	}

	/**
	 * 分页查询活动
	 */
	@Override
	public List<AcGoods> searchPage(String adate, Integer pageNo,
			Integer pageSize) {
		List<AcGoods> listac = dao.searchPage(adate, pageNo, pageSize);
		return listac;
	}

	/**
	 * 查询总记录数
	 */
	@Override
	public Integer searchCount(String adate) {
		Integer count = dao.searchCount(adate);
		return count;
	}

}
