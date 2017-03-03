package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.dream.comm.BaseDaoMysql;
import com.dream.dao.PurchaseDao;
import com.dream.entity.Purchase;
import com.dream.entity.view.Pugousst;

/**
 * 购买接口的实现类
 * 
 * @author 晓风 2016-3-4下午3:26:15
 */
public class PurchaseDaoImpl extends BaseDaoMysql implements PurchaseDao {

	/*
	 * (non-Javadoc)查询下单的东西
	 * 
	 * @see com.dream.dao.PurchaseDao#search()
	 */
	@Override
	public List<Purchase> search() {
		List<Purchase> listPC = new ArrayList<Purchase>();
		List<Object> args = new ArrayList<Object>();
		String sql = "select * from purchase";
		try {
			Result rt = excuteQuery(sql, args);
			if (rt != null && rt.getRowCount() > 0) {
				for (int i = 0; i < rt.getRowCount(); i++) {
					Map<String, Object> rows = rt.getRows()[i];
					Purchase pc = new Purchase();
					pc.setpGid((Integer) rows.get("pgid"));
					pc.setpId((Integer) rows.get("pid"));
					pc.setpNum((Integer) rows.get("pnum"));
					pc.setpSid((Integer) rows.get("psid"));
					pc.setpUid((Integer) rows.get("puid"));
					listPC.add(pc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPC;
	}

	/*
	 * (non-Javadoc) 增加下单
	 * 
	 * @see com.dream.dao.PurchaseDao#add(com.dream.entity.Purchase)
	 */
	@Override
	public void add(Purchase pc) {
		String sql = "  insert into purchase(psid,pgid,puid,pnum) values(?,?,?,?)  ";
		List<Object> args = new ArrayList<Object>();
		args.add(pc.getpSid());
		args.add(pc.getpGid());
		args.add(pc.getpUid());
		args.add(pc.getpNum());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc) 更改下单的数量
	 * 
	 * @see com.dream.dao.PurchaseDao#update(com.dream.entity.Purchase)
	 */
	@Override
	public void update(Purchase pc) {
		String sql = " update purchase  set pnum=? where pid = ? ";
		List<Object> args = new ArrayList<Object>();
		args.add(pc.getpNum());
		args.add(pc.getpId());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc) 删除购买
	 * 
	 * @see com.dream.dao.PurchaseDao#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer pId) {
		String sql = " delete   from purchase  where   pid=?";
		List<Object> args = new ArrayList<Object>();
		args.add(pId);
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 查询购买店面商品信息
	 * 
	 * @see com.dream.dao.PurchaseDao#searchPugost()
	 */
	@Override
	public List<Pugousst> searchPugousst() {
		String sql = " select  *  from  purchase LEFT JOIN store on (purchase.psid=store.sid) LEFT JOIN goods  ON  (purchase.pgid=goods.gid) LEFT JOIN user on purchase.puid=user.uid ";
		List<Pugousst> listPu = new ArrayList<Pugousst>();
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Pugousst pu = new Pugousst();
					pu.setpId((Integer) rows.get("pid"));
					pu.setgId((Integer) rows.get("gid"));
					pu.setgAddress(rows.get("gaddress").toString());
					pu.setgName(rows.get("gname").toString());
					pu.setgPrice((Double) rows.get("gprice"));
					pu.setgType(rows.get("gtype").toString());
					pu.setpNum((Integer) rows.get("pnum"));
					pu.setsAddress(rows.get("saddress").toString());
					pu.setsName(rows.get("sname").toString());
					pu.setsPhone(rows.get("sphone").toString());
					pu.setsName(rows.get("sname").toString());// 店名
					pu.setuName(rows.get("uname").toString());// 买家名字
					pu.setSex(rows.get("sex").toString());// 买家性别
					pu.setuBir(rows.get("ubir").toString());// 买家生日
					pu.setuPhone(rows.get("uphone").toString());// 买家电话
					pu.setuMail(rows.get("umail").toString()); // 买家邮箱
					pu.setuAddress(rows.get("uaddress").toString());// 买家常用地址
					pu.setuLevel(rows.get("ulevel").toString());// 买家会员等级
					listPu.add(pu);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPu;
	}

	/*
	 * 根据用户ID、店面ID、商品ID查询购买下单信息
	 */
	@Override
	public Purchase searchPurchase(int pUid, int pSid, int pGid) {
		List<Object> args = new ArrayList<Object>();
		String sql = "select * from purchase  where  puid=? and pgid=? and psid=?  ";
		args.add(pUid);
		args.add(pGid);
		args.add(pSid);
		Purchase pc = null;
		try {
			Result rt = excuteQuery(sql, args);
			if (rt != null && rt.getRowCount() > 0) {

				Map<String, Object> rows = rt.getRows()[0];
				pc = new Purchase();
				pc.setpGid((Integer) rows.get("pgid"));
				pc.setpId((Integer) rows.get("pid"));
				pc.setpNum((Integer) rows.get("pnum"));
				pc.setpSid((Integer) rows.get("psid"));
				pc.setpUid((Integer) rows.get("puid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pc;
	}

	/*
	 * 根据下单ID查询下单信息
	 */
	@Override
	public Purchase search(int pId) {
		List<Object> args = new ArrayList<Object>();
		String sql = "select * from purchase   where pid=?  ";
		args.add(pId);
		Purchase pc = null;
		try {
			Result rt = excuteQuery(sql, args);
			if (rt != null && rt.getRowCount() > 0) {
				Map<String, Object> rows = rt.getRows()[0];
				pc = new Purchase();
				pc.setpGid((Integer) rows.get("pgid"));
				pc.setpId((Integer) rows.get("pid"));
				pc.setpNum((Integer) rows.get("pnum"));
				pc.setpSid((Integer) rows.get("psid"));
				pc.setpUid((Integer) rows.get("puid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pc;
	}

}
