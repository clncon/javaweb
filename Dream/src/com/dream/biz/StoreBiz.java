package com.dream.biz;

import java.util.List;

import com.dream.entity.Store;

/**
 * 
 * @author ���� 2016-3-8����2:12:53
 */
public interface StoreBiz {

	/**
	 * ���ӵ���
	 */
	public void add(Store store);

	/**
	 * ɾ������
	 */
	public void delete(int sid);

	/**
	 * ���ĵ�����Ϣ
	 * 
	 * @param store
	 */
	public void update(Store store);

	/**
	 * ' ��ѯ���е�����Ϣ
	 * 
	 * @return
	 */
	public List<Store> search();

	/**
	 * ��ѯһ�����������������Ϣ
	 * 
	 * @return
	 */
	public Store searchStore(int sid);

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Store> searchPage_Store(Integer pageNo, Integer pageSize);

	/**
	 * ��¼����
	 * 
	 * @return
	 */
	public Integer searchStoreCount();

	/**
	 * ������ ���ݵ���ID��ѯ������Ϣ
	 * 
	 * @param sUid
	 * @return
	 */
	public Store searchStoreBySuid(Integer sUid);
}
