package com.dream.biz;

import java.util.List;

import com.dream.entity.User;

/**
 * 用户的业务层
 * 
 * @author 葛睿 2016-3-8上午10:58:45
 */
public interface UserBiz {
	/**
	 * 注冊用戶
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 用戶的登录
	 * 
	 * @param uName
	 * @param uPwd
	 * @return
	 */
	public User loginUser(String uPhone, String uPwd);

	/**
	 * 删除用户
	 */
	public void deleteUser(String uName);

	/**
	 * 更改用户
	 */
	public void updateUser(User user);

	/**
	 * 检查用户是否存在
	 * 
	 * @return
	 */
	public boolean checkUser(String uPhone);

	/**
	 * 魏陈霞 根据权限查用户
	 * 
	 * @param uFlog
	 */
	public List<User> searchUflag(User user, Integer pageNo, Integer pageSize);

	/**
	 * 魏陈霞 根据权限分页查用户记录数
	 * 
	 * @param uFlog
	 */
	// public Integer searchVipCount();
	// public Integer searchUserCount();
	public Integer searchCount(User user);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param uName
	 * @return
	 */
	public User searchUser(String uPhone);

	/**
	 * 魏陈霞 根据用户id查询用户
	 * 
	 * @param uName
	 * @return
	 */
	public User searchUser(Integer uId);

	/**
	 * 魏陈霞 根据id删除用户
	 */
	public void delete(Integer uId);

	/**
	 * 根据权限查询用户
	 * @param uFlag
	 * @return
	 */
	public List<User> searchUflag(Integer uFlag);

}
