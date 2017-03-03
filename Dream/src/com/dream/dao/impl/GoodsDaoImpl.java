package com.dream.dao.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.jstl.sql.Result;
import com.dream.comm.BaseDaoMysql;
import com.dream.dao.GoodsDao;
import com.dream.entity.Goods;

/**
 * 商品的实现类
 * 
 * @author 小平 2016-3-4上午10:44:54
 */
public class GoodsDaoImpl extends BaseDaoMysql implements GoodsDao {
	/**
	 * 添加商品信息
	 */
	@Override
	public void add(Goods goods) {
		String sql = "insert into goods(gname,gprice,gtype,gaddress,gpic,gdescribe) values(?,?,?,?,?,?)";
		List<Object> args = new ArrayList<Object>();
		args.add(goods.getgName());
		args.add(goods.getgPrice());
		args.add(goods.getgType());
		args.add(goods.getgAddress());
		args.add(goods.getgPic());
		args.add(goods.getgDescribe());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除商品信息
	 */
	@Override
	public void delete(int gId) {
		String sql = " delete from goods where gid=?";
		List<Object> args = new ArrayList<Object>();
		args.add(gId);
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改商品信息
	 */
	@Override
	public void update(Goods goods) {
		// String sql =
		// " update goods set  gname=? , gprice=? , gtype=? ,  gaddress=? , gpic=? , gdescribe=? where gid=?";
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("  update goods set gname=gname ");
		if (goods.getgName() != null) {
			sql.append(" ,gname=? ");
			args.add(goods.getgName());
		}
		if (goods.getgPrice() != 0) {
			sql.append(" , gprice=? ");
			args.add(goods.getgPrice());
		}
		if (goods.getgType() != null) {
			sql.append(", gtype=? ");
			args.add(goods.getgType());
		}
		if (goods.getgAddress() != null) {
			sql.append(", gaddress=? ");
			args.add(goods.getgAddress());
		}
		if (goods.getgPic() != null) {
			sql.append(" , gpic=? ");
			args.add(goods.getgPic());
		}
		if (goods.getgDescribe() != null) {
			sql.append(" , gdescribe=? ");
			args.add(goods.getgDescribe());
		}
		sql.append("  where  gid=? ");
		args.add(goods.getgId());
		//System.out.println(sql);
		// args.add(goods.getgName());
		// args.add(goods.getgPrice());
		// args.add(goods.getgType());
		// args.add(goods.getgAddress());
		// args.add(goods.getgPic());
		// args.add(goods.getgDescribe());
		// args.add(goods.getgId());
		// System.out.println(sql);
		try {
			excuteUpdate(sql.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询全部商品信息
	 * 
	 * @see com.dream.dao.GoodsDao#search()
	 */
	@Override
	public List<Goods> search() {
		List<Goods> listGS = new ArrayList<Goods>();
		String sql = "select * from goods ";
		List<Object> args = new ArrayList<Object>();// 参数 ==？的个数
		try {
			Result rs = excuteQuery(sql, args);// 返回一个结果集
			// 返回的数据行是大于0的
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map row = rs.getRows()[i];// 返回一行数据
					Goods goods = new Goods();// 做数据的封装
					goods.setgId(new Integer(row.get("gid").toString()));
					goods.setgName(row.get("gname").toString());
					goods.setgPrice(new Double(row.get("gprice").toString()));
					goods.setgType(row.get("gtype").toString());
					goods.setgAddress(row.get("gaddress").toString());
					goods.setgPic(row.get("gpic").toString());
					goods.setgDescribe(row.get("gdescribe").toString());
					// 添加到集合中
					listGS.add(goods);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listGS;// 返回listGS值
	}

	/**
	 * 根据Id查询商品信息
	 * 
	 * @see com.dream.dao.GoodsDao#search(int)
	 */
	@Override
	public Goods search(int gId) {
		String sql = "select * from goods  where gid=? ";
		List<Object> args = new ArrayList<Object>();// 参数 ==？的个数
		args.add(gId);
		Goods goods = null; // 做数据的封装
		try {
			Result rs = excuteQuery(sql, args);// 返回一个结果集
			// 返回的数据行是大于0的
			if (rs != null && rs.getRowCount() > 0) {
				goods = new Goods();
				Map row = rs.getRows()[0];// 返回一行数据
				goods.setgId(new Integer(row.get("gid").toString()));
				goods.setgName(row.get("gname").toString());
				goods.setgPrice(new Double(row.get("gprice").toString()));
				goods.setgType(row.get("gtype").toString());
				goods.setgAddress(row.get("gaddress").toString());
				goods.setgPic(row.get("gpic").toString());
				goods.setgDescribe(row.get("gdescribe").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}

	/**
	 * 分页查询商品信息
	 */
	@Override
	public List<Goods> searchPage_Goods(Integer pageNo, Integer pageSize) {
		List<Goods> listGS = new ArrayList<Goods>();
		StringBuffer sql = new StringBuffer("select * from goods ");
		sql.append("where 1=1");
		List<Object> args = new ArrayList<Object>();
		if (pageNo <= 0) {
			pageNo = 1;
		}
		// 分页
		if (pageNo > 0 && pageSize >= 1) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(",");
			sql.append(pageSize);
		}
		try {
			System.out.println("查询的语句：" + sql.toString());
			Result rs = this.excuteQuery(sql.toString(), args);// 返回一个结果集
			// 返回的数据行是大于0的
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map row = rs.getRows()[i];// 返回一行数据
					Goods goods = new Goods();// 做数据的封装
					goods.setgId(new Integer(row.get("gid").toString()));
					goods.setgName(row.get("gname").toString());
					goods.setgPrice(new Double(row.get("gprice").toString()));
					goods.setgType(row.get("gtype").toString());
					goods.setgAddress(row.get("gaddress").toString());
					goods.setgPic(row.get("gpic").toString());
					goods.setgDescribe(row.get("gdescribe").toString());
					// 添加到集合中
					listGS.add(goods);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listGS;// 返回listGS值
	}

	/**
	 * 商品总数
	 */
	@Override
	public Integer searchGoodsCount() {
		Integer count = 0;
		String sql = " select count(*) as count from goods";
		try {
			Result rs = excuteQuery(sql, null);
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
	 * 根据名字查询
	 * 
	 */
	@Override
	public Goods searchByGname(String gName) {
		String sql = "select * from goods  where gname=? ";
		List<Object> args = new ArrayList<Object>();// 参数 ==？的个数
		args.add(gName);
		Goods goods = new Goods();// 做数据的封装
		try {
			Result rs = excuteQuery(sql, args);// 返回一个结果集
			// 返回的数据行是大于0的
			if (rs != null && rs.getRowCount() > 0) {
				Map row = rs.getRows()[0];// 返回一行数据
				goods.setgId(new Integer(row.get("gid").toString()));
				goods.setgName(row.get("gname").toString());
				goods.setgPrice(new Double(row.get("gprice").toString()));
				goods.setgType(row.get("gtype").toString());
				goods.setgAddress(row.get("gaddress").toString());
				goods.setgPic(row.get("gpic").toString());
				goods.setgDescribe(row.get("gdescribe").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}

	/**
	 * 拼接条件查询
	 */
	@Override
	public List<Goods> searchByCondition(Goods goods) {
		List<Goods> listgoods = new ArrayList<Goods>();
		StringBuffer sql = new StringBuffer("select * from goods  where 1=1 ");
		List<Object> args = new ArrayList<Object>();// 参数 ==？的个数
		if (goods.getgType() != null) {
			sql.append(" and gtype=? ");
			args.add(goods.getgType());
		} else if (goods.getgAddress() != null) {
			sql.append(" and gaddress=? ");
			args.add(goods.getgAddress());
		} else if (goods.getgPrice() != 0) {
			sql.append(" ORDER BY gprice ASC ");
		}
		try {
			Result rs = excuteQuery(sql.toString(), args);// 返回一个结果集
			// 返回的数据行是大于0的
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map row = rs.getRows()[i];// 返回一行数据
					goods.setgId(new Integer(row.get("gid").toString()));
					goods.setgName(row.get("gname").toString());
					goods.setgPrice(new Double(row.get("gprice").toString()));
					goods.setgType(row.get("gtype").toString());
					goods.setgAddress(row.get("gaddress").toString());
					goods.setgPic(row.get("gpic").toString());
					goods.setgDescribe(row.get("gdescribe").toString());
					listgoods.add(goods);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listgoods;
	}
}
