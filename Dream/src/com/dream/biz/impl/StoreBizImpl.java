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
	 * ���������Ϣ
	 */
	@Override
	public void add(Store store) {
		dao.add(store);
	}

	/**
	 * ɾ��
	 */
	@Override
	public void delete(int sid) {
		dao.delete(sid);
	}

	/**
	 * ����
	 */
	@Override
	public void update(Store store) {
		dao.update(store);
	}

	/**
	 * ��ѯ
	 */
	@Override
	public List<Store> search() {
		List<Store> listStore = dao.search();
		return listStore;
	}

	/**
	 * ����ID��ѯ
	 */
	@Override
	public Store searchStore(int sid) {
		Store store = dao.searchStore(sid);
		return store;
	}

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public List<Store> searchPage_Store(Integer pageNo, Integer pageSize) {
		List<Store> searchPage_Store = dao.searchPage_Store(pageNo, pageSize);
		return searchPage_Store;
	}

	/**
	 * ��¼����
	 */
	@Override
	public Integer searchStoreCount() {
		Integer count = dao.searchStoreCount();
		return count;
	}

	/**
	 * ���ݵ���ID��ѯ������Ϣ
	 */
	@Override
	public Store searchStoreBySuid(Integer sUid) {
		Store store = dao.searchStoreBySuid(sUid);
		return store;
	}

}
