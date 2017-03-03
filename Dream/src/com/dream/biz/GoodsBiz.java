package com.dream.biz;

import java.util.List;

import com.dream.entity.Goods;

/**
 * ��Ʒҵ���ӿ�
 * 
 * @author ��ϼ 2016-3-8����1:22:10
 * 
 */

public interface GoodsBiz {
	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 */
	public void addGoods(Goods goods);

	/**
	 * ɾ����Ʒ
	 */
	public void deleteGoods(int gId);

	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 */
	public void updateGoods(Goods goods);

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return
	 */
	public List<Goods> searchGoods();

	/**
	 * ������Ʒid��ѯ��Ʒ
	 * 
	 * @param gId
	 * @return
	 */
	public Goods searchGoods(int gId);

	/**
	 * ������Ʒ���ֲ�ѯ��Ʒ
	 * 
	 * @param gName
	 * @return
	 */
	public Goods searchByGname(String gName);

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param pageNo
	 *            ��ʼ��λ��
	 * @param pageSize
	 *            ��ҳ��С
	 * @return
	 */
	public List<Goods> searchPage_Goods(Integer pageNo, Integer pageSize);

	/**
	 * ��Ʒ����
	 * 
	 * @return
	 */
	public Integer searchGoodsCount();

	/**
	 * κ��ϼ ƴ��������ѯ
	 */
	public List<Goods> searchByCondition(Goods goods);

}
