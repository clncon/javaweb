package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.StoreBiz;
import com.dream.comm.BaseDaoMysql;
import com.dream.dao.StoreDao;
import com.dream.dao.impl.StoreDaoImpl;
import com.dream.entity.Store;

/**
 * 
 */
public class StoreBizImpl extends BaseDaoMysql implements StoreBiz {

	StoreDao dao = new StoreDaoImpl();

	/**
	 * 添加所有信息
	 */
	@Override
	public void add(Store store) {
		dao.add(store);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(int sid) {
		dao.delete(sid);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(Store store) {
		dao.update(store);
	}

	/**
	 * 查询
	 */
	@Override
	public List<Store> search() {
		List<Store> listStore = dao.search();
		return listStore;
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public Store searchStore(int sid) {
		Store store = dao.searchStore(sid);
		return store;
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<Store> searchPage_Store(Integer pageNo, Integer pageSize) {
		List<Store> searchPage_Store = dao.searchPage_Store(pageNo, pageSize);
		return searchPage_Store;
	}

	/**
	 * 记录总数
	 */
	@Override
	public Integer searchStoreCount() {
		Integer count = dao.searchStoreCount();
		return count;
	}

	/**
	 * 根据店主ID查询店面信息
	 */
	@Override
	public Store searchStoreBySuid(Integer sUid) {
		Store store = dao.searchStoreBySuid(sUid);
		return store;
	}

}
