package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.dream.comm.BaseDaoMysql;
import com.dream.dao.UserDao;
import com.dream.entity.User;

/**
 * 用户接口的实现类
 * 
 * @author 建耀 2016-3-4上午11:10:28
 */
public class UserDaoImpl extends BaseDaoMysql implements UserDao {

	/**
	 * 添加用护信息
	 * 
	 */
	@Override
	public void add(User user) {
		String sql = " insert into user (uName,uPwd,sex,uBir,uPhone,uMail,uAddress,uFlag,uLevel)values(?,?,?,?,?,?,?,?,?) ";
		List<Object> args = new ArrayList<Object>();
		args.add(user.getuName()); // 名字
		args.add(user.getuPwd()); // 用户密码
		args.add(user.getSex()); // 性别
		args.add(user.getuBir()); // 生日
		args.add(user.getuPhone()); // 电话
		args.add(user.getuMail()); // 邮箱
		args.add(user.getuAddress()); // 常用地址
		args.add(user.getuFlag()); // 权限 普通用户 卖家 后台管理
		args.add(user.getuLevel()); // 会员等级
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据用户名删除
	 */
	@Override
	public void delete(String uName) {
		String sql = " delete from user where uname=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(uName);// 名字
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新用护
	 * 
	 */
	@Override
	public void update(User user) {
		// String sql =
		// " update user set uname=?,upwd=?,sex=?,uBir=?,uphone=?,umail=?,uaddress=?,uflag=?,ulevel=? where uid=? ";
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(" update user set  upwd =upwd ");
		if (user.getuPwd() != null) {
			sql.append(" , upwd=? ");
			args.add(user.getuPwd()); // 用户密码
		}
		if (user.getSex() != null) {
			sql.append(" , sex=? ");
			args.add(user.getSex());
		}
		if (user.getuBir() != null) {
			sql.append(" , ubir=? ");
			args.add(user.getuBir());
		}
		if (user.getuPhone() != null) {
			sql.append(" , uphone=? ");
			args.add(user.getuPhone());
		}
		if (user.getuMail() != null) {
			sql.append(" , umail=? ");
			args.add(user.getuMail());
		}
		if (user.getuAddress() != null) {
			sql.append(" , uaddress=? ");
			args.add(user.getuAddress());
		}
		if (user.getuFlag() != null) {
			sql.append(" , uflag=? ");
			args.add(user.getuFlag());
		}
		if (user.getuLevel() != null) {
			sql.append(" , ulevel=? ");
			args.add(user.getuLevel());
		}
		sql.append("  where uid =? ");
		args.add(user.getuId());
		//System.out.println(sql);
		try {
			excuteUpdate(sql.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//
		// args.add(user.getuName()); // 名字
		//
		// args.add(user.getuBir()); // 生日
		// args.add(user.getuPhone()); // 电话
		// args.add(user.getuMail()); // 邮箱
		// args.add(user.getuAddress()); // 常用地址
		// args.add(user.getuFlag()); // 权限 普通用户 卖家 后台管理
		// args.add(user.getuLevel()); // 会员等级
		// args.add(user.getuId()); // ID
		//
		// try {
		// excuteUpdate(sql, args);
		//
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		// }

	}

	/*
	 * 查询所有用户 (non-Javadoc)
	 * 
	 * @see com.dream.dao.UserDao#search()
	 */
	@Override
	public List<User> search() {
		String sql = " select * from User ";
		List<User> listUser = new ArrayList<User>();
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					User user = new User();
					// 封装
					user.setuId((Integer) (rows.get("uid")));// ID
					user.setuName((String) rows.get("uname"));// 名字
					user.setuPwd((String) rows.get("upwd"));// 密码
					user.setSex((String) rows.get("sex"));// 性别
					user.setuBir((String) rows.get("ubir"));// 生日
					user.setuPhone((String) rows.get("uphone"));// 电话
					user.setuMail((String) rows.get("umail")); // 邮箱
					user.setuAddress((String) rows.get("uaddress"));// 常用地址
					user.setuFlag((String) rows.get("uflag"));// 权限 :普通用户    卖家    后台管 理 员
					user.setuLevel((String) rows.get("ulevel"));// 会员等级
					// 添加到集合中
					listUser.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	/**
	 *根据用户电话查询用户 
	 * 
	 */
	@Override
	public User searchUser(String uPhone) {
		String sql = " select * from User where uPhone=? ";
		// List<User> listUser = new ArrayList<User>();
		List<Object> args = new ArrayList<Object>();
		args.add(uPhone);
		User user = null;
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				user = new User();
				Map rows = rs.getRows()[0];
				// 封装
				user.setuId((Integer) (rows.get("uid")));// ID
				user.setuName((String) rows.get("uname"));// 名字
				user.setuPwd((String) rows.get("upwd"));// 密码
				user.setSex((String) rows.get("sex"));// 性别
				user.setuBir((String) rows.get("ubir"));// 生日
				user.setuPhone((String) rows.get("uphone"));// 电话
				user.setuMail((String) rows.get("umail")); // 邮箱
				user.setuAddress((String) rows.get("uaddress"));// 常用地址
				user.setuFlag((String) rows.get("uflag"));// 权限 普通用户 卖家 后台管理
				user.setuLevel((String) rows.get("ulevel"));// 会员等级
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 分页查询用户
	 * 
	 */
	@Override
	public List<User> searchPage_User(Integer pageNo, Integer pageSize) {
		List<User> listUser = new ArrayList<User>(); // 查询到的用户信息
		StringBuffer sql = new StringBuffer(" select * from user ");
		List args = new ArrayList();
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
			Result rs = this.excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					User user = new User();
					user.setuId((Integer) (rows.get("uid")));// ID
					user.setuName((String) rows.get("uname"));// 名字
					user.setuPwd((String) rows.get("upwd"));// 密码
					user.setSex((String) rows.get("sex"));// 性别
					user.setuBir((String) rows.get("ubir"));// 生日
					user.setuPhone((String) rows.get("uphone"));// 电话
					user.setuMail((String) rows.get("umail")); // 邮箱
					user.setuAddress((String) rows.get("uaddress"));// 常用地址
					user.setuFlag((String) rows.get("uflag"));// 权限 普通用户 卖家 后台管理
					user.setuLevel((String) rows.get("ulevel"));// 会员等级
					listUser.add(user); // 添加user
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	/**
	 * 记录数
	 * 
	 */
	@Override
	public Integer searchAllUserCount() {
		int count = 0;
		String sql = " select  count(*) as count from user ";
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				Map row = rs.getRows()[0];
				count = Integer.valueOf((String) row.get("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 根据用户电话查询用户部分主要信息
	 * 
	 */
	@Override
	public User checkUser(String uPhone) {
		String sql = " select * from User where uPhone=? ";
		// List<User> listUser = new ArrayList<User>();
		List<Object> args = new ArrayList<Object>();
		args.add(uPhone);
		User user = null;
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				user = new User();
				// 封装
				user.setuId((Integer) (rows.get("uid")));// ID
				user.setuName((String) rows.get("uname"));// 名字
				user.setuPwd((String) rows.get("upwd"));// 密码
				user.setuPhone((String) rows.get("uPhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 注册用户名及密码
	 * 
	 */
	@Override
	public void addUser(User user) {
		String sql = " insert into user (uPhone,uPwd,umail,uName)values(?,?,?,?) ";
		List<Object> args = new ArrayList<Object>();
		args.add(user.getuPhone()); // 名字
		args.add(user.getuPwd()); // 用户密码
		args.add(user.getuMail());
		args.add(user.getuName());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 魏陈霞 根据权限分页查询
	 * 
	 */
	@Override
	public List<User> searchUflag(User user, Integer pageNo, Integer pageSize) {
		StringBuffer sql = new StringBuffer(
				" select * from User where uFlag=uflag  ");
		List<User> listUser = new ArrayList<User>();
		List<Object> args = new ArrayList<Object>();
		if (user.getuFlag() != null) {
			sql.append("  and uflag=? ");
			args.add(user.getuFlag());
		}
		if (user.getuPhone() != null) {
			sql.append(" and uphone like ? ");
			args.add(user.getuPhone());
		}
		if (pageNo < 0) {
			pageNo = 1;
		}
		if (pageNo > 0 && pageSize >= 1) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(",");
			sql.append(pageSize);
		}
		//System.out.println("分页" + sql);
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					User tempuser = new User();
					Map rows = rs.getRows()[i];
					// 封装
					tempuser.setuId(new Integer(rows.get("uid").toString()));// ID
					tempuser.setuName((String) rows.get("uname"));// 名字
					tempuser.setuPwd((String) rows.get("upwd"));// 密码
					tempuser.setSex((String) rows.get("sex"));// 性别
					tempuser.setuBir((String) rows.get("ubir"));// 生日
					tempuser.setuPhone((String) rows.get("uphone"));// 电话
					tempuser.setuMail((String) rows.get("umail")); // 邮箱
					tempuser.setuAddress((String) rows.get("uaddress"));// 常用地址
					tempuser.setuFlag((String) rows.get("uflag"));// 权限: 普通用户     卖家    后台管理
					tempuser.setuLevel((String) rows.get("ulevel"));// 会员等级
					listUser.add(tempuser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	// /**
	// * 魏陈霞
	// * 根据权限分页查询记录数
	// */
	// @Override
	// public Integer searchVipCount() {
	// int count=0;
	// String sql=" select  count(*) as count from user where Uflag=1";
	// try {
	// Result rs=excuteQuery(sql,null);
	// if(rs!=null && rs.getRowCount()>0){
	// Map row=rs.getRows()[0];
	// count=Integer.valueOf((String)row.get("count"));
	// }
	// } catch (Exception e) {
	// // 
	// e.printStackTrace();
	// }
	// return count;
	// }
	// /**
	// * 魏陈霞
	// * 根据权限分页查询记录数
	// */
	// @Override
	// public Integer searchUserCount() {
	// int count=0;
	// String sql=" select  count(*) as count from user where Uflag=0";
	// try {
	// Result rs=excuteQuery(sql,null);
	// if(rs!=null && rs.getRowCount()>0){
	// Map row=rs.getRows()[0];
	// count=Integer.valueOf((String)row.get("count"));
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return count;
	// }
	/**
	 * 根据用户id查用户
	 * 
	 */
	@Override
	public User searchUser(Integer uId) {
		String sql = " select * from User where uid=? ";
		// List<User> listUser = new ArrayList<User>();
		List<Object> args = new ArrayList<Object>();
		args.add(uId);
		User user = null;
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				user = new User();
				// 封装
				user.setuId((Integer) (uId));// ID
				user.setuName((String) rows.get("uname"));// 名字
				user.setuPwd((String) rows.get("upwd"));// 密码
				user.setSex((String) rows.get("sex"));// 性别
				user.setuBir((String) rows.get("ubir"));// 生日
				user.setuPhone((String) rows.get("uphone"));// 电话
				user.setuMail((String) rows.get("umail")); // 邮箱
				user.setuAddress((String) rows.get("uaddress"));// 常用地址
				user.setuFlag((String) rows.get("uflag"));// 权限 普通用户 卖家 后台管理
				user.setuLevel((String) rows.get("ulevel"));// 会员等级
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 根据用户id删用户
	 * 
	 */
	@Override
	public void delete(Integer uId) {
		String sql = " delete from user where uid=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(uId);// 名字
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据用户权限查询用户
	 * 
	 */
	@Override
	public List<User> searchUflag(Integer uFlag) {
		StringBuffer sql = new StringBuffer(
				" select * from User where uFlag=? ");
		List<User> listUser = new ArrayList<User>();
		List<Object> args = new ArrayList<Object>();
		args.add(uFlag);
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					User user = new User();
					Map rows = rs.getRows()[i];
					// 封装
					user.setuId((Integer) rows.get("uid"));// ID
					user.setuName((String) rows.get("uname"));// 名字
					user.setuPwd((String) rows.get("upwd"));// 密码
					user.setSex((String) rows.get("sex"));// 性别
					user.setuBir((String) rows.get("ubir"));// 生日
					user.setuPhone((String) rows.get("uphone"));// 电话
					user.setuMail((String) rows.get("umail")); // 邮箱
					user.setuAddress((String) rows.get("uaddress"));// 常用地址
					user.setuFlag((String) rows.get("uflag"));// 权限 普通用户 卖家 后台管理
					user.setuLevel((String) rows.get("ulevel"));// 会员等级
					listUser.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	/**
	 * 根据用户权限查询记录数
	 * 
	 */
	@Override
	public Integer searchCount(User user) {
		int count = 0;
		StringBuffer sql = new StringBuffer(
				" select  count(*) as count from user where Uflag=uflag ");
		List<Object> args = new ArrayList<Object>();
		if (user.getuFlag() != null) {
			sql.append(" and uflag=? ");
			args.add(user.getuFlag());
		}
		if (user.getuPhone() != null) {
			sql.append(" and uphone like ? ");
			args.add(user.getuPhone());
		}
		//System.out.println("记录数" + sql);
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
}
