package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.OrderBiz;
import com.dream.comm.BaseDaoMysql;
import com.dream.dao.OrderDao;
import com.dream.dao.impl.OrderDaoImpl;
import com.dream.entity.Orders;
import com.dream.entity.view.Orpu;
import com.dream.entity.view.Ougp;

/**
 * ����ҵ���ʵ����
 * 
 */
public class OrderBizImpl extends BaseDaoMysql implements OrderBiz {

	OrderDao dao = new OrderDaoImpl();

	/**
	 * ��ѯȫ��������Ϣ
	 */
	@Override
	public List<Ougp> searchOugpByStatus(String oStatus, Integer uId) {
		List<Ougp> listougp = dao.searchOugpByStatus(oStatus, uId);
		return listougp;
	}

	/**
	 * ���ݶ���ID���¶���״̬
	 */
	@Override
	public void updateostatusByOid(Orders od) {
		dao.updateostatusByOid(od);
	}

	/**
	 * �����û�ID��ѯ������Ϣ
	 */
	@Override
	public List<Ougp> searchOugpByUid(Integer uId) {

		return dao.searchOugpByUid(uId);
	}

	/**
	 * ��ѯ����
	 */
	@Override
	public List<Orders> searchOrders() {

		return dao.search();
	}

	/**
	 * ��Ӷ�����Ϣ
	 */
	@Override
	public void addOrders(Orders od) {
		dao.add(od);

	}

	/**
	 * �޸Ķ�����Ϣ
	 * 
	 */
	@Override
	public void updateOrders(Orders od) {
		dao.update(od);

	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * 
	 */
	@Override
	public void deleteOrders(Integer oId) {
		dao.delete(oId);

	}

	// /**
	// * ���򶩵��û�������Ϣ
	// *
	// * @return
	// */
	// @Override
	// public List<Orpuusst> searchOrpuusst() {
	//
	// return dao.searchOrpuusst();
	// }
	/**
	 * ���ݶ�����Ų�ѯ
	 * 
	 */
	@Override
	public Orders searchOrdersByOId(Integer oId) {

		return dao.searchByOId(oId);
	}

	/**
	 * ��ҳ��ѯ������Ϣ
	 */
	@Override
	public List<Orders> searchPage_Orders(Integer pageNo, Integer pageSize) {

		return dao.searchPage_Orders(pageNo, pageSize);
	}

	/**
	 * ��������
	 */
	@Override
	public Integer searchOrdersCount() {

		return dao.searchOrdersCount();
	}

	/**
	 * ���򶩵���Ϣ
	 */
	@Override
	public List<Orpu> searchOrpu() {
		List<Orpu> listorpu = dao.searchOrpu();

		return listorpu;
	}

	/**
	 * ���ݶ���ID�����ѯ
	 */
	@Override
	public Ougp searchByOid(Integer oId) {

		return dao.searchByOid(oId);
	}

	/**
	 * �����ѯ
	 */
	@Override
	public List<Ougp> searchOugp() {
		List<Ougp> listougp = dao.searchOugp();
		return listougp;
	}

	/**
	 * �����ѯ
	 */
	@Override
	public Ougp searchById(Integer oId) {
		Ougp ougp = dao.searchById(oId);
		return ougp;
	}

	// @Override
	// public List<Ougp> searchOugp(Integer pageNo, Integer pageSize) {
	// List<Ougp> listougp=dao.searchOugp(pageNo, pageSize);
	// return listougp;
	// }
	//
	//
	// @Override
	// public Integer searchAllOugpCount() {
	// Integer count=dao.searchAllOugpCount();
	// return count;
	// }
	/**
	 * ��ҳ�����ѯ
	 */
	@Override
	public List<Ougp> searchOugp(Ougp ougp, Integer pageNo, Integer pageSize) {
		List<Ougp> listougp = dao.searchOugp(ougp, pageNo, pageSize);
		return listougp;
	}

	/**
	 * �����ѯ��¼��
	 */
	@Override
	public Integer searchAllOugpCount(Ougp ougp) {
		Integer count = dao.searchAllOugpCount(ougp);
		return count;
	}

	/**
	 * ���Ӷ���
	 */
	@Override
	public void add(Orders orders) {
		dao.addOrders(orders);

	}

	/**
	 * �����µ�ID��ѯ����
	 */
	@Override
	public Orders searchOrder(int oPid) {

		return dao.searchOrder(oPid);
	}

}
