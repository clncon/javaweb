package com.dream.dao;
import java.util.List;
import com.dream.entity.Orders;
import com.dream.entity.view.Orpu;
import com.dream.entity.view.Ougp;

/**
 * 订单接口
 * 
 * @author 晓风 2016-3-4上午10:25:16
 */
public interface OrderDao {

	/**
	 * 根据订单状态和用户ID查询订单
	 * 
	 * @param oStatus
	 * @param uId
	 * @return
	 */
	public List<Ougp> searchOugpByStatus(String oStatus, Integer uId);

	/**
	 * 根据订单ID更新订单状态
	 * 
	 * @param od
	 */
	public void updateostatusByOid(Orders od);

	/**
	 * 根据用户ID查询用户
	 * 
	 * @param uId
	 * @return
	 */
	public List<Ougp> searchOugpByUid(Integer uId);

	/**
	 * 根据下单ID查询订单
	 * 
	 * @param oPid
	 * @return
	 */
	public Orders searchOrder(int oPid);

	/**
	 * 查询订单信息
	 * 
	 * @return
	 */
	public List<Orders> search();

	/**
	 * 添加订单信息
	 * 
	 * @param od
	 */
	public void add(Orders od);

	/**
	 * 修改订单信息
	 * 
	 * @param od
	 */
	public void update(Orders od);

	/**
	 * 删除订单信息
	 * 
	 * @param oId
	 */
	public void delete(Integer oId);

	// /**
	// * 购买订单用户店面信息
	// * @return
	// */
	// public List<Orpuusst> searchOrpuusst();
	/**
	 * 查询购买订单信息
	 */
	public List<Orpu> searchOrpu();

	/**
	 * 根据订单编号查询
	 * 
	 * @param oId
	 * @return
	 */
	public Orders searchByOId(Integer oId);

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
	 * 订单 购买 商品 用户 查询id
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

	/**
	 * 订单 购买 商品 用户 oid查询
	 * 
	 * @param oId
	 * @return
	 */
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
	 * 添加订单
	 * 
	 * @param orders
	 */
	public void addOrders(Orders orders);
}
