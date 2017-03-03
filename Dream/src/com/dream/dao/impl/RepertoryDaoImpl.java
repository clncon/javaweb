package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;
import javax.swing.ListCellRenderer;

import com.dream.comm.BaseDaoMysql;
import com.dream.dao.RepertoryDao;
import com.dream.entity.Repertory;
import com.dream.entity.view.Regost;

/**
 * 库存的实现类
 * 
 * @author 林兴鹏 2016-3-4下午4:41:41
 * 
 */
public class RepertoryDaoImpl extends BaseDaoMysql implements RepertoryDao {

	/**
	 * 联表查询店面商品库存信息
	 * 
	 * @return
	 */
	@Override
	public List<Regost> search() {
		String sql = " SELECT * FROM repertory  left JOIN goods on (repertory.rgid=goods.gid ) left join store on repertory.rsid=store.sid  ";
		List<Regost> list = new ArrayList<Regost>();
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Regost regost = new Regost();
					regost.setgId((Integer) rows.get("gid"));
					regost.setgName(rows.get("gname").toString());
					regost.setgType(rows.get("gtype").toString());
					regost.setgAddress(rows.get("gaddress").toString());
					regost.setgPic(rows.get("gpic").toString());
					regost.setgDescribe(rows.get("gdescribe").toString());
					regost.setgPrice(new Double(rows.get("gprice").toString()));
					regost.setrNum((Integer) rows.get("rnum"));
					regost.setgName(rows.get("gname").toString());
					regost.setsPhone(rows.get("sphone").toString());
					regost.setsAddress(rows.get("saddress").toString());
					regost.setsName(rows.get("sname").toString());
					list.add(regost);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 陈霞 分页查询
	 */
	@Override
	public List<Regost> searchPage_Repertory(Regost regost, Integer pageNo,
			Integer pageSize) {
		List<Regost> list = new ArrayList<Regost>();
		StringBuffer sql = new StringBuffer(
				" SELECT * FROM repertory  left JOIN goods on (repertory.rgid=goods.gid ) left join store on repertory.rsid=store.sid  WHERE 1=1 ");
		List<Object> args = new ArrayList<Object>();
		if (regost.getgName() != null && !"".equals(regost.getgName())) {
			sql.append(" and gName like ? ");
			args.add(regost.getgName());
		} else if (regost.getsId() != 0 && !"".equals(regost.getsId())) {
			sql.append(" and sId=? ");
			args.add(regost.getsId());
		} else if (regost.getgType() != null) {
			sql.append(" and gtype like ? ");
			args.add(regost.getgType());
		} else if (regost.getgAddress() != null) {
			sql.append(" and gaddress like ? ");
			args.add(regost.getgAddress());
		} else if (regost.getgPrice() != 0) {
			if (regost.getgPrice() == 1) {
				sql.append(" ORDER BY gprice asc ");// 升序
			} else if (regost.getgPrice() == 2) {
				sql.append(" ORDER BY gprice desc ");
			}
		}
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > 0 && pageSize >= 0) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(" , ");
			sql.append(pageSize);
		}
		//System.out.println("分页：" + sql);
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Regost tempregost = new Regost();
					tempregost.setgId((Integer) rows.get("gid"));
					tempregost.setgName(rows.get("gname").toString());
					tempregost.setgType(rows.get("gtype").toString());
					tempregost.setgAddress(rows.get("gaddress").toString());
					tempregost.setgPic(rows.get("gpic").toString());
					tempregost.setgDescribe(rows.get("gdescribe").toString());
					tempregost.setrNum((Integer) rows.get("rnum"));
					tempregost.setgName(rows.get("gname").toString());
					tempregost.setgPrice(new Double(rows.get("gprice")
							.toString()));
					tempregost.setsId((Integer) rows.get("sid"));
					tempregost.setsPhone(rows.get("sphone").toString());
					tempregost.setsName(rows.get("sname").toString());
					tempregost.setsAddress(rows.get("saddress").toString());
					list.add(tempregost);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 陈霞 记录总数
	 */
	@Override
	public Integer searchRepertoryCount(Regost regost) {
		Integer count = 0;
		StringBuffer sql = new StringBuffer(
				" select count(*) as count from repertory  left JOIN goods on (repertory.rgid=goods.gid ) left join store on repertory.rsid=store.sid  WHERE 1=1  ");
		List<Object> args = new ArrayList<Object>();
		if (regost.getsId() != 0 && !"".equals(regost.getsId())) {
			sql.append(" and sId=? ");
			args.add(regost.getsId());
		} else if (regost.getgName() != null && !"".equals(regost.getgName())) {
			sql.append(" and gName like ? ");
			args.add(regost.getgName());
		} else if (regost.getsId() != 0 && !"".equals(regost.getsId())) {
			sql.append(" and sId=? ");
			args.add(regost.getsId());
		} else if (regost.getgType() != null) {
			sql.append(" and gtype like ? ");
			args.add(regost.getgType());
		} else if (regost.getgAddress() != null) {
			sql.append(" and gaddress like ? ");
			args.add(regost.getgAddress());
		} else if (regost.getgPrice() != 0) {
			if (regost.getgPrice() == 1) {
				sql.append(" ORDER BY gprice asc ");// 升序
			} else if (regost.getgPrice() == 2) {
				sql.append(" ORDER BY gprice desc ");
			}
		}
		try {
			Result r = excuteQuery(sql.toString(), args);
			Map rows = r.getRows()[0];
			count = Integer.valueOf(rows.get("count").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 陈霞 记录总数
	 */
	@Override
	public Integer searchGiftCount(Regost regost) {
		Integer count = 0;
		String sql = " select count(*) as count from repertory  left JOIN goods on (repertory.rgid=goods.gid ) left join store on repertory.rsid=store.sid  WHERE 1=1 and gtype='礼盒' ";
		try {
			Result r = excuteQuery(sql.toString(), null);
			Map rows = r.getRows()[0];
			count = Integer.valueOf(rows.get("count").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 魏陈霞 多表条件查询
	 */
	@Override
	public List<Regost> search(Regost regost) {

		StringBuffer sql = new StringBuffer(
				" SELECT * FROM repertory  left JOIN goods on (repertory.rgid=goods.gid ) left join store on repertory.rsid=store.sid where 1=1 ");
		List<Regost> list = new ArrayList<Regost>();
		List<Object> args = new ArrayList<Object>();
		if (regost.getgType() != null) {
			sql.append(" and gtype=? ");
			args.add(regost.getgType());
		} else if (regost.getgAddress() != null) {
			sql.append(" and gaddress=? ");
			args.add(regost.getgAddress());
		} else if (regost.getsId() != 0) {
			sql.append(" and sid=? ");
			args.add(regost.getsId());
		} else if (regost.getgPrice() != 0) {
			if (regost.getgPrice() == 1) {
				sql.append(" ORDER BY gprice asc ");// 升序
			} else if (regost.getgPrice() == 2) {
				sql.append(" ORDER BY gprice desc ");
			}
		}
		//System.out.println("多表条件查询" + sql.toString());
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Regost tempregost = new Regost();
					tempregost.setgId((Integer) rows.get("gid"));
					tempregost.setgName(rows.get("gname").toString());
					tempregost.setgType(rows.get("gtype").toString());
					tempregost.setgAddress(rows.get("gaddress").toString());
					tempregost.setgPic(rows.get("gpic").toString());
					tempregost.setgDescribe(rows.get("gdescribe").toString());
					tempregost.setgPrice(Double.parseDouble((rows.get("gprice")
							.toString())));
					tempregost.setrNum((Integer) rows.get("rnum"));
					tempregost.setgName(rows.get("gname").toString());
					tempregost.setsId((Integer) rows.get("sid"));
					tempregost.setsPhone(rows.get("sphone").toString());
					tempregost.setsName(rows.get("sname").toString());
					tempregost.setsAddress(rows.get("saddress").toString());
					list.add(tempregost);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据商品ID联表查询店面商品库存信息
	 * 
	 */
	@Override
	public Regost searchBygId(Integer gid) {
		String sql = " SELECT * FROM repertory  left JOIN goods on (repertory.rgid=goods.gid ) left join store on (repertory.rsid=store.sid) where gid=?  ";
		List<Regost> list = new ArrayList<Regost>();
		List<Object> args = new ArrayList<Object>();
		args.add(gid);
		Regost regost = null;
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				regost = new Regost();
				regost.setgId((Integer) rows.get("gid"));
				regost.setgName(rows.get("gname").toString());
				regost.setgType(rows.get("gtype").toString());
				regost.setgPrice(Double.parseDouble(rows.get("gprice")
						.toString()));
				regost.setgAddress(rows.get("gaddress").toString());
				regost.setgPic(rows.get("gpic").toString());
				regost.setgDescribe(rows.get("gdescribe").toString());
				regost.setrNum((Integer) rows.get("rnum"));
				regost.setgName(rows.get("gname").toString());
				regost.setsName(rows.get("sname").toString());
				regost.setsPhone(rows.get("sphone").toString());
				regost.setsAddress(rows.get("saddress").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return regost;
	}

	/**
	 * 多表查询礼品信息
	 */
	@Override
	public List<Regost> searchGift(Regost regost) {
		StringBuffer sql = new StringBuffer(
				" SELECT * FROM repertory  left JOIN goods on (repertory.rgid=goods.gid ) left join store on repertory.rsid=store.sid where gtype='礼盒' ");
		List<Regost> list = new ArrayList<Regost>();
		List<Object> args = new ArrayList<Object>();
		if (regost.getgPrice() != 0) {
			if (regost.getgPrice() == 1) {
				sql.append(" ORDER BY gprice asc ");// 升序
			} else if (regost.getgPrice() == 2) {
				sql.append(" ORDER BY gprice desc ");
			}
		}
		//System.out.println("多表条件查询" + sql.toString());
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Regost tempregost = new Regost();
					tempregost.setgId((Integer) rows.get("gid"));
					tempregost.setgName(rows.get("gname").toString());
					tempregost.setgType(rows.get("gtype").toString());
					tempregost.setgAddress(rows.get("gaddress").toString());
					tempregost.setgPic(rows.get("gpic").toString());
					tempregost.setgDescribe(rows.get("gdescribe").toString());
					tempregost.setgPrice(Double.parseDouble((rows.get("gprice")
							.toString())));
					tempregost.setrNum((Integer) rows.get("rnum"));
					tempregost.setgName(rows.get("gname").toString());
					tempregost.setsPhone(rows.get("sphone").toString());
					tempregost.setsAddress(rows.get("saddress").toString());
					tempregost.setsName(rows.get("sname").toString());
					list.add(tempregost);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 分页查询礼盒库存
	 * 
	 */
	@Override
	public List<Regost> searchGift(Regost regost, Integer pageNo,
			Integer pageSize) {
		StringBuffer sql = new StringBuffer(
				" SELECT * FROM repertory  left JOIN goods on (repertory.rgid=goods.gid ) left join store on repertory.rsid=store.sid where gtype='礼盒' ");
		List<Regost> list = new ArrayList<Regost>();
		List<Object> args = new ArrayList<Object>();
		if (regost.getgPrice() != 0) {
			if (regost.getgPrice() == 1) {
				sql.append(" ORDER BY gprice asc ");// 升序
			} else if (regost.getgPrice() == 2) {
				sql.append(" ORDER BY gprice desc ");
			}
		}
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > 0 && pageSize >= 0) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(" , ");
			sql.append(pageSize);
		}
		//System.out.println("分页多表礼品查询：" + sql);
		// System.out.println("多表条件查询"+sql.toString());
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Regost tempregost = new Regost();
					tempregost.setgId((Integer) rows.get("gid"));
					tempregost.setgName(rows.get("gname").toString());
					tempregost.setgType(rows.get("gtype").toString());
					tempregost.setgAddress(rows.get("gaddress").toString());
					tempregost.setgPic(rows.get("gpic").toString());
					tempregost.setgDescribe(rows.get("gdescribe").toString());
					tempregost.setgPrice(Double.parseDouble((rows.get("gprice").toString())));
					tempregost.setrNum((Integer) rows.get("rnum"));
					tempregost.setgName(rows.get("gname").toString());
					tempregost.setsPhone(rows.get("sphone").toString());
					tempregost.setsAddress(rows.get("saddress").toString());
					tempregost.setsName(rows.get("sname").toString());
					list.add(tempregost);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 陈霞 添加库存
	 * 
	 */
	@Override
	public void addRepertory(Repertory re) {
		String sql = " insert into Repertory(rgid,rnum,rsid) values(?,?,?)  ";
		List<Object> args = new ArrayList<Object>();
		args.add(re.getrGid());
		args.add(re.getrNum());
		args.add(re.getrSid());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 陈霞 删除库存
	 */
	public void deletRepertory(Repertory re) {
		String sql = " delete  from Repertory where rgid=? and rsid=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(re.getrGid());
		args.add(re.getrSid());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
