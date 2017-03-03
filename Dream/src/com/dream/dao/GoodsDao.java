package com.dream.dao;
import java.util.List;
import com.dream.entity.Goods;

/**
 * ��Ʒ�Ľӿ�
 * 
 * @author ��� 2016-3-3����9:24:40
 */
public interface GoodsDao {
	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 */
	public void add(Goods goods);

	/**
	 * ɾ����Ʒ
	 */
	public void delete(int gId);

	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 */
	public void update(Goods goods);

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return
	 */
	public List<Goods> search();

	/**
	 * ������Ʒid��ѯ��Ʒ
	 * 
	 * @param gId
	 * @return
	 */
	public Goods search(int gId);

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
	 * �������ֲ�ѯ
	 * 
	 * @param gName
	 * @return
	 */
	public Goods searchByGname(String gName);

	/**
	 * κ��ϼ ƴ��������ѯ
	 */
	public List<Goods> searchByCondition(Goods goods);
}
