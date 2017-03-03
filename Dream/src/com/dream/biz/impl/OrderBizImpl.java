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
 * 订单业务层实现类
 * 
 */
public class OrderBizImpl extends BaseDaoMysql implements OrderBiz {

	OrderDao dao = new OrderDaoImpl();

	/**
	 * 查询全部订单信息
	 */
	@Override
	public List<Ougp> searchOugpByStatus(String oStatus, Integer uId) {
		List<Ougp> listougp = dao.searchOugpByStatus(oStatus, uId);
		return listougp;
	}

	/**
	 * 根据订单ID更新订单状态
	 */
	@Override
	public void updateostatusByOid(Orders od) {
		dao.updateostatusByOid(od);
	}

	/**
	 * 根据用户ID查询订单信息
	 */
	@Override
	public List<Ougp> searchOugpByUid(Integer uId) {

		return dao.searchOugpByUid(uId);
	}

	/**
	 * 查询订单
	 */
	@Override
	public List<Orders> searchOrders() {

		return dao.search();
	}

	/**
	 * 添加订单信息
	 */
	@Override
	public void addOrders(Orders od) {
		dao.add(od);

	}

	/**
	 * 修改订单信息
	 * 
	 */
	@Override
	public void updateOrders(Orders od) {
		dao.update(od);

	}

	/**
	 * 删除订单信息
	 * 
	 * 
	 */
	@Override
	public void deleteOrders(Integer oId) {
		dao.delete(oId);

	}

	// /**
	// * 购买订单用户店面信息
	// *
	// * @return
	// */
	// @Override
	// public List<Orpuusst> searchOrpuusst() {
	//
	// return dao.searchOrpuusst();
	// }
	/**
	 * 根据订单编号查询
	 * 
	 */
	@Override
	public Orders searchOrdersByOId(Integer oId) {

		return dao.searchByOId(oId);
	}

	/**
	 * 分页查询订单信息
	 */
	@Override
	public List<Orders> searchPage_Orders(Integer pageNo, Integer pageSize) {

		return dao.searchPage_Orders(pageNo, pageSize);
	}

	/**
	 * 订单总数
	 */
	@Override
	public Integer searchOrdersCount() {

		return dao.searchOrdersCount();
	}

	/**
	 * 购买订单信息
	 */
	@Override
	public List<Orpu> searchOrpu() {
		List<Orpu> listorpu = dao.searchOrpu();

		return listorpu;
	}

	/**
	 * 根据订单ID联表查询
	 */
	@Override
	public Ougp searchByOid(Integer oId) {

		return dao.searchByOid(oId);
	}

	/**
	 * 联表查询
	 */
	@Override
	public List<Ougp> searchOugp() {
		List<Ougp> listougp = dao.searchOugp();
		return listougp;
	}

	/**
	 * 联表查询
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
	 * 分页联表查询
	 */
	@Override
	public List<Ougp> searchOugp(Ougp ougp, Integer pageNo, Integer pageSize) {
		List<Ougp> listougp = dao.searchOugp(ougp, pageNo, pageSize);
		return listougp;
	}

	/**
	 * 联表查询记录数
	 */
	@Override
	public Integer searchAllOugpCount(Ougp ougp) {
		Integer count = dao.searchAllOugpCount(ougp);
		return count;
	}

	/**
	 * 增加订单
	 */
	@Override
	public void add(Orders orders) {
		dao.addOrders(orders);

	}

	/**
	 * 根据下单ID查询订单
	 */
	@Override
	public Orders searchOrder(int oPid) {

		return dao.searchOrder(oPid);
	}

}
