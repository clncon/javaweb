package com.dream.biz;

import java.util.List;

import com.dream.entity.Orders;
import com.dream.entity.view.Orpu;
import com.dream.entity.view.Ougp;

/**
 * 订单业务层的接口
 * 
 * @author 小平 2016-3-8下午1:28:16
 */
public interface OrderBiz {
	/**
	 * 根据订单状态和用户ID联表查询
	 * @param oStatus
	 * @param uId
	 * @return
	 */
	public List<Ougp> searchOugpByStatus(String oStatus, Integer uId);

	/**
	 * 根据订单ID修改订单状态
	 * @param od
	 */
	public void updateostatusByOid(Orders od);

	/**
	 * 根据买家ID联表查询
	 * @param uId
	 * @return
	 */
	public List<Ougp> searchOugpByUid(Integer uId);

	/**
	 * 根据下单ID查询订单
	 * @param oPid
	 * @return
	 */
	public Orders searchOrder(int oPid);

	/**
	 * 查询订单信息
	 * 
	 * @return
	 */
	public List<Orders> searchOrders();

	/**
	 * 添加订单信息
	 * 
	 * @param od
	 */
	public void addOrders(Orders od);

	/**
	 * 修改订单信息
	 * 
	 * @param od
	 */
	public void updateOrders(Orders od);

	/**
	 * 删除订单信息
	 * 
	 * @param oId
	 */
	public void deleteOrders(Integer oId);

	// /**
	// * 购买订单用户店面信息
	// * @return
	// */
	// public List<Orpuusst> searchOrpuusst();
	/**
	 * 购买订单信息
	 */
	public List<Orpu> searchOrpu();

	/**
	 * 根据订单编号查询
	 * 
	 * @param oId
	 * @return
	 */
	public Orders searchOrdersByOId(Integer oId);

	/**
	 * 分页
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Orders> searchPage_Orders(Integer pageNo, Integer pageSize);

	/**
	 * 查询多少页
	 * 
	 * @return
	 */
	public Integer searchOrdersCount();

	/**
	 * 多表连接查询 查询id
	 * 
	 * @param oId
	 * @return
	 */
	public Ougp searchByOid(Integer oId);

	/**
	 * 订单 购买 商品 用户 查询
	 * 
	 * @return
	 */
	public List<Ougp> searchOugp();

	public Ougp searchById(Integer oId);

	// /**
	// * 订单 购买 商品 用户 分页查询
	// * @return
	// */
	// public List<Ougp> searchOugp(Integer pageNo, Integer pageSize);
	// /**
	// * 记录数
	// * @return
	// */
	// public Integer searchAllOugpCount() ;
	/**
	 * 订单 购买 商品 用户 分页查询
	 * 
	 * @return
	 */
	public List<Ougp> searchOugp(Ougp ougp, Integer pageNo, Integer pageSize);

	/**
	 * 记录数
	 * 
	 * @return
	 */
	public Integer searchAllOugpCount(Ougp ougp);

	/**
	 * 增加订单
	 * @param orders
	 */
	public void add(Orders orders);
}
