package com.dream.biz;

import java.util.List;

import com.dream.entity.Repertory;
import com.dream.entity.view.Regost;
/**
 * 
 * @author ��ϼ
 *2016-3-8����1:58:42
 *
 */
public interface RepertoryBiz {
	 /**
	  * �����ԃ��Ϣ
	 * @return
	 */
	public List<Regost> searchRepertory();
	/**
	 * ���������ѯ
	 */
	public List<Regost> search(Regost regost);
	 /**
	  * ��ϼ
	  * ��ҳ��ѯ
	  */
	public List<Regost> searchPage_Repertory(Regost regost,Integer pageNo,Integer pageSize);
	/**
	 * ��ϼ
	 * ��¼����
	 */
	public Integer searchRepertoryCount(Regost regost);
	/**
	 * ��ѯ��Ʒ����
	 * @param regost
	 * @return
	 */
	public Integer  searchGiftCount(Regost regost);
	/**
	 *������Ʒid����������ѯ
	 * @param gid
	 * @return
	 */
	public  Regost searchBygId(Integer gid);
	/**
	 * Сƽ
	 * �����ѯ��Ʒ
	 * @param regost
	 * @return
	 */
	public List<Regost> searchGift(Regost regost);
	/**
	 * ��ϼ
	 * �����ҳ��ѯ��Ʒ
	 * @param regost
	 * @return
	 */
	public List<Regost> searchGift(Regost regost,Integer pageNo,Integer pageSize);
	/**
	 * ��ϼ
	 * ���ӿ��
	 */
	public void addRepertory(Repertory re);
	/**
	 * ��ϼ
	 * ɾ�����
	 */
	public void deletRepertory(Repertory re);
}