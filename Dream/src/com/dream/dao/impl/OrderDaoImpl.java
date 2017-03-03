package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.dream.comm.BaseDaoMysql;
import com.dream.dao.OrderDao;
import com.dream.entity.Orders;
import com.dream.entity.User;
import com.dream.entity.view.Orpu;
import com.dream.entity.view.Ougp;

/**
 * 订单实现
 * 
 * @author 陈霞 2016-3-4上午10:31:29
 * 
 */

public class OrderDaoImpl extends BaseDaoMysql implements OrderDao {

	/**
	 * 根据订单状态和买家ID查询
	 * 
	 */
	@Override
	public List<Ougp> searchOugpByStatus(String oStatus, Integer uId) {
		List<Ougp> listougp = new ArrayList<Ougp>();
		String sql = "  select *  from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON (purchase.puid=USER.uid)  where  oStatus=? and uid=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(oStatus);
		args.add(uId);
		Ougp ougp = null;
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					ougp = new Ougp(); // 订单 用户 商品 购买表
					ougp.setoId(Integer.valueOf(rows.get("oid").toString()));
					ougp.setoStatus(rows.get("oStatus").toString());
					ougp.setgName(rows.get("gname").toString());
					ougp.setpNum((Integer) rows.get("pNum"));
					ougp.setgPrice(Double.valueOf(rows.get("gPrice").toString()));
					ougp.setgPic(rows.get("gPic").toString());
					ougp.setoAddress(rows.get("oAddress").toString());
					ougp.setuPhone(rows.get("uPhone").toString());
					listougp.add(ougp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listougp;
	}

	/**
	 * 根据订单ID修改订单状态
	 * 
	 */
	@Override
	public void updateostatusByOid(Orders od) {
		List<Object> args = new ArrayList<Object>();
		String sql = " update orders set ostatus=? where oid=? ";
		args.add(od.getoStatus());
		args.add(od.getoId());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据买家ID联表查询订单
	 * 
	 */
	@Override
	public List<Ougp> searchOugpByUid(Integer uId) {
		List<Ougp> listougp = new ArrayList<Ougp>();
		List<Object> args = new ArrayList<Object>();
		String sql = " select *  from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON  (purchase.puid=USER.uid) where uid=?  ";
		args.add(uId);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Ougp ougp = new Ougp();
					ougp.setgId((Integer) (rows.get("gid")));
					ougp.setoId((Integer) rows.get("oid"));
					ougp.setpId((Integer) rows.get("pid"));
					ougp.setoStatus((String) rows.get("oStatus"));
					ougp.setgName((String) rows.get("gname"));
					ougp.setpNum((Integer) rows.get("pNum"));
					ougp.setgPrice((Double) (rows.get("gPrice")));
					ougp.setgPic((String) rows.get("gPic"));
					listougp.add(ougp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listougp;
	}

	/**
	 * 查询订单信息
	 * 
	 * @return
	 */
	@Override
	public List<Orders> search() {
		String sql = " select * from  orders ";
		List<Object> args = new ArrayList<Object>();
		List<Orders> listorder = new ArrayList<Orders>();
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Orders order = new Orders();
					order.setoPid((Integer) rows.get("oPid"));
					// order.setoUid((Integer)rows.get("oUid"));
					// order.setoSid((Integer)(String)rows.get("oSid"));
					order.setoStatus((String) rows.get("oStatus"));
					order.setoStartdate((String) rows.get("oStartdate"));
					order.setoEnddate((String) rows.get("oEnddate"));
					order.setoAddress((String) rows.get("oAddress"));
					listorder.add(order);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listorder;
	}

	/**
	 * 添加订单信息
	 * 
	 * @param od
	 */
	@Override
	public void add(Orders od) {
		String sql = " insert into orders(oPid,oStatus,oStartdate,oEnddate,oAddress) values(?,?,?,?,?) ";
		List<Object> args = new ArrayList<Object>();
		args.add(od.getoPid());
		// args.add(od.getoUid());
		// args.add(od.getoSid());
		args.add(od.getoStatus());
		args.add(od.getoStartdate());
		args.add(od.getoEnddate());
		args.add(od.getoAddress());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改订单信息
	 * 
	 * @param od
	 */
	@Override
	public void update(Orders od) {
		// String
		// sql=" update orders set oUid=?,oStatus=?,oStartdate=?,oEnddate=?,oAddress=? where oPid=? ";
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("update orders set oid=oid ");
		// args.add(od.getoUid());
		if (od.getoAddress() != null) {
			sql.append(" , oaddress=? ");
			args.add(od.getoAddress());
		}
		if (od.getoEnddate() != null) {
			sql.append(" , oenddate=? ");
			args.add(od.getoEnddate());
		}
		if (od.getoStartdate() != null) {
			sql.append(" , ostartdate=? ");
			args.add(od.getoStartdate());
		}
		if (od.getoStatus() != null) {
			sql.append(" , ostatus=? ");
			args.add(od.getoStatus());
		}
		// if (od.getoSid()!=0) {
		// sql.append(" , osid=?  ");
		// args.add(od.getoSid());
		// }
		sql.append(" where opid=? ");
		args.add(od.getoPid());
		// args.add(od.getoUid());
		// args.add(od.getoStatus());
		// args.add(od.getoStartdate());
		// args.add(od.getoEnddate());
		// args.add(od.getoAddress());
		// args.add(od.getoPid());
		try {
			excuteUpdate(sql.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除订单信息
	 * 
	 * @param oId
	 */
	@Override
	public void delete(Integer oId) {
		String sql = " delete  from orders where oId=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(oId);
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查询购买订单信息
	 */
	@Override
	public List<Orpu> searchOrpu() {
		List<Orpu> listo = new ArrayList<Orpu>();
		String sql = " select * from orders LEFT JOIN purchase ON orders.opid=purchase.pid  ";
		List<Object> args = new ArrayList<Object>();
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Orpu op = new Orpu();
					op.setoId((Integer) rows.get("oid"));
					op.setpId((Integer) rows.get("pid"));
					op.setpSid((Integer) rows.get("psid"));
					op.setoUid((Integer) rows.get("oUid"));
					op.setoAddress((String) rows.get("oaddress"));
					op.setoEnddate((String) rows.get("oenddate"));
					op.setoStartdate((String) rows.get("ostartdate"));
					op.setoStatus((String) rows.get("ostatus"));
					op.setpNum((Integer) rows.get("pnum"));
					listo.add(op);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listo;
	}

	/**
	 * 根据订单编号查询
	 * 
	 * @param oId
	 * @return private int oPid; //购买下单ID private int oSid;//店面ID private int
	 *         oUid;//用户id private String oStatus;//订单状态 private String
	 *         oStartdate;//下单时间 private String oEnddate;//送达时间 private String
	 *         oAddress;//订单地址
	 */
	@Override
	public Orders searchByOId(Integer oId) {
		Orders order = null;
		String sql = " select * from orders where oid=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(oId);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				order = new Orders();
				Map rows = rs.getRows()[0];
				order.setoId((Integer) rows.get("oid"));
				order.setoPid((Integer) rows.get("oPid"));
				// order.setoUid((Integer)(String)rows.get("oUid"));
				// order.setoSid((Integer)(String)rows.get("oSid"));
				order.setoStatus((String) rows.get("oStatus"));
				order.setoStartdate((String) rows.get("oStartdate"));
				order.setoEnddate((String) rows.get("oEnddate"));
				order.setoAddress((String) rows.get("oAddress"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

	/**
	 * 分页
	 * 
	 */
	@Override
	public List<Orders> searchPage_Orders(Integer pageNo, Integer pageSize) {
		List<Orders> listOrder = new ArrayList();
		// sql语句
		StringBuffer sql = new StringBuffer(" select * from orders ");
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > 0 && pageSize >= 1) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(",");
			sql.append(pageSize);
		}
		try {
			Result rs = excuteQuery(sql.toString(), null);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Orders order = new Orders();
					order.setoPid((Integer) rows.get("oPid"));
					// order.setoUid((Integer)rows.get("oUid"));
					// order.setoSid((Integer)(String)rows.get("oSid"));
					order.setoStatus((String) rows.get("oStatus"));
					order.setoStartdate((String) rows.get("oStartdate"));
					order.setoEnddate((String) rows.get("oEnddate"));
					order.setoAddress((String) rows.get("oAddress"));
					listOrder.add(order);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOrder;
	}

	/**
	 *查询订单记录数
	 * 
	 */
	@Override
	public Integer searchOrdersCount() {
		Integer count = 0;
		String sql = " select count(*) as count from Orders  ";
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				count = Integer.parseInt((String) rows.get("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 根据订单ID联表查询
	 * 
	 */
	@Override
	public Ougp searchByOid(Integer oId) {
		String sql = "  select *  from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON (purchase.puid=USER.uid)  where  oId=?  ";
		List<Object> args = new ArrayList<Object>();
		args.add(oId);
		Ougp ougp = null;
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				ougp = new Ougp(); // 订单 用户 商品 购买表
				ougp.setoId((Integer) rows.get("oid"));
				ougp.setoStartdate((String) rows.get("oStartdate"));
				ougp.setoStatus((String) rows.get("oStatus"));
				ougp.setoEnddate((String) rows.get("oEnddate"));
				ougp.setuName((String) rows.get("uname"));
				ougp.setgName((String) rows.get("gname"));
				ougp.setpNum((Integer) rows.get("pNum"));
				ougp.setgPrice((Double) rows.get("gPrice"));
				ougp.setoAddress((String) rows.get("oAddress"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ougp;
	}

	/**
	 * 联表查询
	 * 
	 */
	@Override
	public List<Ougp> searchOugp() {
		List<Ougp> listougp = new ArrayList<Ougp>();
		String sql = " select *  from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON  (purchase.puid=USER.uid)   ";
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Ougp ougp = new Ougp();
					ougp.setoId((Integer) rows.get("oId"));
					ougp.setoStartdate((String) rows.get("oStartdate"));
					ougp.setoStatus((String) rows.get("oStatus"));
					ougp.setoEnddate((String) rows.get("oEnddate"));
					ougp.setuName((String) rows.get("uName"));
					ougp.setgName((String) rows.get("gName"));
					ougp.setpNum((Integer) rows.get("pNum"));
					ougp.setgPrice(Double.valueOf((String) rows.get("gPrice")));
					ougp.setoAddress((String) rows.get("oAddress"));
					listougp.add(ougp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listougp;
	}

	/**
	 * 根据订单ID联表查询
	 * 
	 */
	@Override
	public Ougp searchById(Integer oId) {
		String sql = " select *  from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON  (purchase.puid=USER.uid)  where oId=?  ";
		List<Object> args = new ArrayList<Object>();
		args.add(oId);
		Ougp ougp = null;
		Result rs;
		try {
			rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				ougp = new Ougp();
				ougp.setoId((Integer) rows.get("oId"));
				ougp.setoStartdate((String) rows.get("oStartdate"));
				ougp.setoStatus((String) rows.get("oStatus"));
				ougp.setoEnddate((String) rows.get("oEnddate"));
				ougp.setuName((String) rows.get("uName"));
				ougp.setgName((String) rows.get("gName"));
				ougp.setpNum((Integer) rows.get("pNum"));
				ougp.setgPrice(Double.valueOf((String) rows.get("gPrice")));
				ougp.setoAddress((String) rows.get("oAddress"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ougp;
	}

	// @Override
	// public List<Ougp> searchOugp(Integer pageNo, Integer pageSize) {
	// List<Ougp> listOugp=new ArrayList<Ougp>(); //查询到的用户信息
	// StringBuffer sql=new
	// StringBuffer(" select *  from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON  (purchase.puid=USER.uid)   ");
	//
	// if(pageNo<=0){
	// pageNo=1;
	// }
	// if(pageNo>0 && pageSize>=1){
	// sql.append(" limit ");
	// sql.append((pageNo-1)*pageSize);
	// sql.append(" , ");
	// sql.append(pageSize);
	//
	// }
	// try {
	// Result rs=excuteQuery(sql.toString(), null);
	// if(rs!=null && rs.getRowCount()>0){
	// for (int i = 0; i <rs.getRowCount(); i++) {
	// Map rows=rs.getRows()[i];
	// Ougp ougp=new Ougp();
	//
	// ougp.setoId((Integer)rows.get("oId"));
	// ougp.setoStartdate((String)rows.get("oStartdate"));
	// ougp.setoStatus((String)rows.get("oStatus"));
	// ougp.setoEnddate((String)rows.get("oEnddate"));
	// ougp.setuName((String)rows.get("uName"));
	// ougp.setgName((String)rows.get("gName"));
	// ougp.setpNum((Integer)rows.get("pNum"));
	// ougp.setgPrice((Double) rows.get("gPrice"));
	// ougp.setoAddress((String)rows.get("oAddress"));
	//
	// listOugp.add(ougp);
	// }
	// }
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return listOugp;
	//
	// }
	//
	// @Override
	// public Integer searchAllOugpCount() {
	// int count=0;
	// String
	// sql=" select  count(*) as count from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON  (purchase.puid=USER.uid) ";
	// try {
	// Result rs=excuteQuery(sql,null);
	// if(rs!=null && rs.getRowCount()>0){
	// Map row=rs.getRows()[0];
	// count=Integer.valueOf(row.get("count").toString());
	// }
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return count;
	// }
	
	/**
	 * 分页联表查询
	 * 
	 */
	@Override
	public List<Ougp> searchOugp(Ougp ougp, Integer pageNo, Integer pageSize) {
		List<Ougp> listOugp = new ArrayList<Ougp>(); // 查询到的用户信息
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(
				" select *  from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON  (purchase.puid=USER.uid) where 1=1  ");
		Ougp tempougp = null;
		if (ougp.getpSid() != 0) {
			sql.append(" and psid=? ");
			args.add(ougp.getpSid());
		}
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > 0 && pageSize >= 1) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(" , ");
			sql.append(pageSize);
		}
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					tempougp = new Ougp();
					tempougp.setoId((Integer) rows.get("oId"));
					tempougp.setoStartdate((String) rows.get("oStartdate"));
					tempougp.setoStatus((String) rows.get("oStatus"));
					tempougp.setoEnddate((String) rows.get("oEnddate"));
					tempougp.setuName((String) rows.get("uName"));
					tempougp.setgName((String) rows.get("gName"));
					tempougp.setpNum((Integer) rows.get("pNum"));
					tempougp.setgPrice((Double) rows.get("gPrice"));
					tempougp.setoAddress((String) rows.get("oAddress"));
					listOugp.add(tempougp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOugp;
	}

	/**
	 * 联表查询记录数
	 * 
	 */
	@Override
	public Integer searchAllOugpCount(Ougp ougp) {
		int count = 0;
		StringBuffer sql = new StringBuffer(
				" select  count(*) as count from orders left join purchase ON (orders.opid=purchase.pid) LEFT JOIN goods ON (purchase.pgid=goods.gid) LEFT JOIN user ON  (purchase.puid=USER.uid) where 1=1 ");
		List<Object> args = new ArrayList<Object>();
		if (ougp.getpSid() != 0) {
			sql.append(" and psid=? ");
			args.add(ougp.getpSid());
		}
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				Map row = rs.getRows()[0];
				count = Integer.valueOf(row.get("count").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 添加订单
	 * 
	 */
	@Override
	public void addOrders(Orders orders) {
		String sql = " insert into orders(oPid,oStatus,oStartdate,oAddress) values(?,?,?,?) ";
		List<Object> args = new ArrayList<Object>();
		args.add(orders.getoPid());
		// args.add(od.getoUid());
		// args.add(od.getoSid());
		args.add(orders.getoStatus());
		args.add(orders.getoStartdate());
		// args.add(od.getoEnddate());
		args.add(orders.getoAddress());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	/**
	 * 根据下单ID查询订单
	 * 
	 */
	@Override
	public Orders searchOrder(int oPid) {
		String sql = " select *  from orders where opid=? ";
		List<Object> args = new ArrayList<Object>();
		Orders order = null;
		args.add(oPid);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				order = new Orders();
				Map rows = rs.getRows()[0];
				order.setoId((Integer) rows.get("oid"));
				order.setoPid((Integer) rows.get("oPid"));
				// order.setoUid((Integer)(String)rows.get("oUid"));
				// order.setoSid((Integer)(String)rows.get("oSid"));
				order.setoStatus((String) rows.get("oStatus"));
				order.setoStartdate((String) rows.get("oStartdate"));
				order.setoEnddate((String) rows.get("oEnddate"));
				order.setoAddress((String) rows.get("oAddress"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
}
