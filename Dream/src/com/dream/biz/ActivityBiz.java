package com.dream.biz;

import java.util.List;

import com.dream.entity.Activity;
import com.dream.entity.view.AcGoods;

/**
 * �biz��Ľӿ�
 * 
 */
public interface ActivityBiz {

	/**
	 * ���ӻ
	 * 
	 * @param ac
	 */
	public void add(Activity ac);

	/**
	 * ɾ���
	 * 
	 * @param aId
	 */
	public void delete(int aId);

	/**
	 * ����aGidɾ���
	 */
	public void deleteByaGid(int aGid);

	/**
	 * ���Ļ
	 * 
	 * @param ac
	 */
	public void update(Activity ac);

	/**
	 * ��ѯ�
	 * 
	 * @param aId
	 * @return
	 */
	public AcGoods searchById(int aId);

	/**
	 * ��ѯ���л
	 * 
	 * @return
	 */
	public List<AcGoods> search();

	/**
	 * ���ݻ���ڲ�ѯ
	 * 
	 * @param adata
	 * @return
	 */
	public List<AcGoods> searchByadate(String adate);

	/**
	 * ��ҳ�������ڲ�ѯ���л
	 * 
	 * @return
	 */
	public List<AcGoods> searchPage(String adate, Integer pageNo,
			Integer pageSize);

	/**
	 * ��ҳ�������ڲ�ѯ���м�¼��
	 * 
	 * @return
	 */
	public Integer searchCount(String adate);
}
