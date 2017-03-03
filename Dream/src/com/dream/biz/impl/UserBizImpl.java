package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.UserBiz;
import com.dream.comm.SHA1jiami;
import com.dream.dao.UserDao;
import com.dream.dao.impl.UserDaoImpl;
import com.dream.entity.User;

/**
 * 用户业务的实现
 * 
 */
public class UserBizImpl implements UserBiz {

	/*
	 * 增加用户 葛睿 2016-3-8上午11:36:57
	 */
	@Override
	public void addUser(User user) {
		UserDao ud = new UserDaoImpl();
		String SAUpwd = SHA1jiami.SHA1Digest(user.getuPwd());// 让密码加密
		user.setuPwd(SAUpwd); // 将加密串放在User中
		ud.addUser(user); // 加此用户增加到数据库中

	}

	/*
	 * 用戶的登陸 葛睿 2016-3-8上午11:37:22
	 */
	@Override
	public User loginUser(String uPhone, String uPwd) {
		UserDao ud = new UserDaoImpl();
		User loginUser = ud.checkUser(uPhone);// 根据用户名查询数据库中的数据

		if (loginUser == null) {
			return null;
		} else {
			String SAUpwd = SHA1jiami.SHA1Digest(uPwd);// 加密用户输入的密码
			if (loginUser.getuPwd().equals(SAUpwd)) {
				// loginUser.setuPwd(null);//让用户密码为空
				return loginUser;
			}

		}

		return null;

	}

	/*
	 * 删除用户 葛睿 2016-3-8上午11:37:46
	 */
	@Override
	public void deleteUser(String uName) {
		UserDao ud = new UserDaoImpl();
		ud.delete(uName);
	}

	/*
	 * 更改用户 葛睿 2016-3-8上午11:37:54
	 */
	@Override
	public void updateUser(User user) {

		UserDao ud = new UserDaoImpl();
		ud.update(user);

	}

	/*
	 * 检查是否有这用户 葛睿2016-3-9下午9:22:11
	 */
	@Override
	public boolean checkUser(String uPhone) {
		UserDao ud = new UserDaoImpl();
		if (ud.searchUser(uPhone) != null) {
			return true;

		} else {
			return false;
		}
	}

	/*
	 * 根据权限查询 魏陈霞 (non-Javadoc)
	 * 
	 * @see com.dream.biz.UserBiz#searchUflog(java.lang.Integer)
	 */
	@Override
	public List<User> searchUflag(User user, Integer pageNo, Integer pageSize) {
		UserDao ud = new UserDaoImpl();

		return ud.searchUflag(user, pageNo, pageSize);
	}

	/**
	 * 根据用户名查询用户
	 * 
	 * @param uName
	 * @return
	 */
	@Override
	public User searchUser(String uPhone) {
		UserDao ud = new UserDaoImpl();

		return ud.searchUser(uPhone);
	}

	/**
	 * 魏陈霞 根据权限分页查用户记录数
	 * 
	 * @param uFlog
	 */
	// @Override
	// public Integer searchVipCount() {
	// UserDao ud=new UserDaoImpl();
	// Integer count=ud.searchVipCount();
	// return count;
	// }
	// @Override
	// public Integer searchUserCount() {
	// UserDao ud=new UserDaoImpl();
	// Integer count=ud.searchUserCount();
	// return count;
	// }
	/**
	 * 查询用户总数
	 */
	@Override
	public Integer searchCount(User user) {
		UserDao ud = new UserDaoImpl();
		Integer count = ud.searchCount(user);
		return count;
	}

	/**
	 * 根据用户ID查询用户
	 */
	@Override
	public User searchUser(Integer uId) {
		UserDao ud = new UserDaoImpl();

		return ud.searchUser(uId);
	}

	/**
	 * 魏陈霞 根据Id删用户
	 */
	@Override
	public void delete(Integer uId) {
		UserDao ud = new UserDaoImpl();
		ud.delete(uId);

	}

	/**
	 * 根据用户权限查询用户
	 */
	@Override
	public List<User> searchUflag(Integer uFlag) {
		UserDao dao = new UserDaoImpl();
		List<User> listvip = dao.searchUflag(uFlag);
		return listvip;
	}

}
