package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.jstl.sql.Result;
import com.dream.comm.BaseDaoMysql;
import com.dream.dao.ActivityDao;
import com.dream.entity.Activity;
import com.dream.entity.User;
import com.dream.entity.view.AcGoods;

public class ActivityDaoImpl extends BaseDaoMysql implements ActivityDao {

	/**
	 * 添加活动信息
	 */
	@Override
	public void add(Activity ac) {
		String sql = " insert into activity(agid,aprice,adate,apic) values(?,?,?,?)  ";
		List<Object> args = new ArrayList<Object>();
		args.add(ac.getaGid());
		args.add(ac.getAprice());
		args.add(ac.getAdate());
		args.add(ac.getApic());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据aid删除活动
	 */
	@Override
	public void delete(int aId) {
		String sql = " delete from activity where aid= ?";
		List<Object> args = new ArrayList<Object>();
		args.add(aId);
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更改商品活动信息
	 */
	@Override
	public void update(Activity ac) {
		StringBuffer sql = new StringBuffer(" update activity set aid=aid ");
		List<Object> args = new ArrayList<Object>();
		if (ac.getAprice() != 0) {
			sql.append(" , aprice=? ");
			args.add(ac.getAprice());
		}
		if (ac.getAdate() != null) {
			sql.append(" , adate=?  ");
			args.add(ac.getAdate());
		}
		if (ac.getApic() != null) {
			sql.append(" , apic=? ");
			args.add(ac.getApic());
		}
		sql.append(" where agid=? ");
		args.add(ac.getaGid());
		try {
			excuteUpdate(sql.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据aId查询商品活动信息
	 */
	@Override
	public AcGoods searchById(int aId) {
		String sql = " SELECT * from activity LEFT JOIN goods ON activity.agid = goods.gid where aId=?  ";
		AcGoods ag = null;
		List<Object> args = new ArrayList<Object>();
		args.add(aId);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				ag = new AcGoods();
				ag.setaId((Integer) rows.get("aid"));
				ag.setaGid((Integer) rows.get("agid"));
				ag.setAprice((Double) rows.get("aprice"));
				ag.setAdate(rows.get("adate").toString());
				ag.setApic(rows.get("apic").toString());
				ag.setgId((Integer) rows.get("gid"));
				ag.setgName(rows.get("gname").toString());
				ag.setgPrice((Double) rows.get("gprice"));
				ag.setgType(rows.get("gtype").toString());
				ag.setgAddress(rows.get("gaddress").toString());
				ag.setgPic(rows.get("gpic").toString());
				ag.setgDescribe(rows.get("gdescribe").toString());

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ag;
	}

	/**
	 * 查询全部商品活动信息
	 */
	@Override
	public List<AcGoods> search() {
		String sql = " SELECT * from activity LEFT JOIN goods ON activity.agid = goods.gid   ";
		List<AcGoods> listas = new ArrayList<AcGoods>();
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					AcGoods ag = new AcGoods();
					ag.setaId((Integer) rows.get("aid"));
					ag.setaGid((Integer) rows.get("agid"));
					ag.setAprice((Double) rows.get("aprice"));
					ag.setAdate(rows.get("adate").toString());
					ag.setApic(rows.get("apic").toString());
					ag.setgId((Integer) rows.get("gid"));
					ag.setgName(rows.get("gname").toString());
					ag.setgPrice((Double) rows.get("gprice"));
					ag.setgType(rows.get("gtype").toString());
					ag.setgAddress(rows.get("gaddress").toString());
					ag.setgPic(rows.get("gpic").toString());
					ag.setgDescribe(rows.get("gdescribe").toString());
					listas.add(ag);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listas;
	}

	/**
	 * 根据活动日期查询商品活动
	 * 
	 */
	@Override
	public List<AcGoods> searchByadate(String adate) {
		String sql = " SELECT * from activity LEFT JOIN goods ON activity.agid = goods.gid where adate=?  ";
		List<AcGoods> listas = new ArrayList<AcGoods>();
		List<Object> args = new ArrayList<Object>();
		args.add(adate);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					AcGoods ag = new AcGoods();
					ag.setaId((Integer) rows.get("aid"));
					ag.setaGid((Integer) rows.get("agid"));
					ag.setAprice((Double) rows.get("aprice"));
					ag.setAdate(rows.get("adate").toString());
					ag.setApic(rows.get("apic").toString());
					ag.setgId((Integer) rows.get("gid"));
					ag.setgName(rows.get("gname").toString());
					ag.setgPrice((Double) rows.get("gprice"));
					ag.setgType(rows.get("gtype").toString());
					ag.setgAddress(rows.get("gaddress").toString());
					ag.setgPic(rows.get("gpic").toString());
					ag.setgDescribe(rows.get("gdescribe").toString());
					listas.add(ag);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listas;
	}

	/**
	 * 根据aGid删除商品活动信息
	 */
	@Override
	public void deleteByaGid(int aGid) {
		String sql = " delete from activity where agid= ?";
		List<Object> args = new ArrayList<Object>();
		args.add(aGid);
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 魏陈霞 根据日期活动商品分页
	 */
	@Override
	public List<AcGoods> searchPage(String adate, Integer pageNo,
			Integer pageSize) {
		StringBuffer sql = new StringBuffer(
				" select * from activity LEFT JOIN goods ON activity.agid = goods.gid where adate=? ");
		List<AcGoods> listas = new ArrayList<AcGoods>();
		List<Object> args = new ArrayList<Object>();
		args.add(adate);
		if (pageNo < 0) {
			pageNo = 1;
		}
		if (pageNo > 0 && pageSize >= 1) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(",");
			sql.append(pageSize);
		}
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					AcGoods ag = new AcGoods();
					ag.setaId((Integer) rows.get("aid"));
					ag.setaGid((Integer) rows.get("agid"));
					ag.setAprice((Double) rows.get("aprice"));
					ag.setAdate(rows.get("adate").toString());
					ag.setApic(rows.get("apic").toString());
					ag.setgId((Integer) rows.get("gid"));
					ag.setgName(rows.get("gname").toString());
					ag.setgPrice((Double) rows.get("gprice"));
					ag.setgType(rows.get("gtype").toString());
					ag.setgAddress(rows.get("gaddress").toString());
					ag.setgPic(rows.get("gpic").toString());
					ag.setgDescribe(rows.get("gdescribe").toString());
					listas.add(ag);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listas;
	}

	/**
	 * 魏陈霞 根据日期活动商品记录数
	 */
	@Override
	public Integer searchCount(String adate) {
		int count = 0;
		String sql = " select  count(*) as count from activity LEFT JOIN goods ON activity.agid = goods.gid where adate=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(adate);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map row = rs.getRows()[0];
				count = Integer.valueOf(row.get("count").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
