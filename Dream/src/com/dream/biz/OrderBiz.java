package com.dream.biz;

import java.util.List;

import com.dream.entity.Orders;
import com.dream.entity.view.Orpu;
import com.dream.entity.view.Ougp;

/**
 * ����ҵ���Ľӿ�
 * 
 * @author Сƽ 2016-3-8����1:28:16
 */
public interface OrderBiz {
	/**
	 * ���ݶ���״̬���û�ID�����ѯ
	 * @param oStatus
	 * @param uId
	 * @return
	 */
	public List<Ougp> searchOugpByStatus(String oStatus, Integer uId);

	/**
	 * ���ݶ���ID�޸Ķ���״̬
	 * @param od
	 */
	public void updateostatusByOid(Orders od);

	/**
	 * �������ID�����ѯ
	 * @param uId
	 * @return
	 */
	public List<Ougp> searchOugpByUid(Integer uId);

	/**
	 * �����µ�ID��ѯ����
	 * @param oPid
	 * @return
	 */
	public Orders searchOrder(int oPid);

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @return
	 */
	public List<Orders> searchOrders();

	/**
	 * ��Ӷ�����Ϣ
	 * 
	 * @param od
	 */
	public void addOrders(Orders od);

	/**
	 * �޸Ķ�����Ϣ
	 * 
	 * @param od
	 */
	public void updateOrders(Orders od);

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param oId
	 */
	public void deleteOrders(Integer oId);

	// /**
	// * ���򶩵��û�������Ϣ
	// * @return
	// */
	// public List<Orpuusst> searchOrpuusst();
	/**
	 * ���򶩵���Ϣ
	 */
	public List<Orpu> searchOrpu();

	/**
	 * ���ݶ�����Ų�ѯ
	 * 
	 * @param oId
	 * @return
	 */
	public Orders searchOrdersByOId(Integer oId);

	/**
	 * ��ҳ
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Orders> searchPage_Orders(Integer pageNo, Integer pageSize);

	/**
	 * ��ѯ����ҳ
	 * 
	 * @return
	 */
	public Integer searchOrdersCount();

	/**
	 * ������Ӳ�ѯ ��ѯid
	 * 
	 * @param oId
	 * @return
	 */
	public Ougp searchByOid(Integer oId);

	/**
	 * ���� ���� ��Ʒ �û� ��ѯ
	 * 
	 * @return
	 */
	public List<Ougp> searchOugp();

	public Ougp searchById(Integer oId);

	// /**
	// * ���� ���� ��Ʒ �û� ��ҳ��ѯ
	// * @return
	// */
	// public List<Ougp> searchOugp(Integer pageNo, Integer pageSize);
	// /**
	// * ��¼��
	// * @return
	// */
	// public Integer searchAllOugpCount() ;
	/**
	 * ���� ���� ��Ʒ �û� ��ҳ��ѯ
	 * 
	 * @return
	 */
	public List<Ougp> searchOugp(Ougp ougp, Integer pageNo, Integer pageSize);

	/**
	 * ��¼��
	 * 
	 * @return
	 */
	public Integer searchAllOugpCount(Ougp ougp);

	/**
	 * ���Ӷ���
	 * @param orders
	 */
	public void add(Orders orders);
}
