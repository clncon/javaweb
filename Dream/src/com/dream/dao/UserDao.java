package com.dream.dao;

import java.util.List;

import com.dream.entity.User;

/**
 * 用户的接口
 * 
 * @author 葛睿 2016-3-3下午9:17:10
 */
public interface UserDao {

	/**
	 * 增加用户
	 * 
	 * @param user
	 */
	public void add(User user);

	/**
	 * 删除用户
	 */
	public void delete(String uName);

	/**
	 * 更改用户
	 * 
	 * @param uName
	 */
	public void update(User user);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> search();

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
	 * 魏陈霞 根据权限分页查用户
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
	 * 分页查询 林兴鹏
	 * 
	 * @param uId
	 * @return
	 */
	public List<User> searchPage_User(Integer pageNo, Integer pageSize);

	/**
	 * 查询总数
	 * 
	 * @return
	 */
	public Integer searchAllUserCount();

	/**
	 * 查询用户
	 * 
	 * @param uName
	 * @return
	 */
	public User checkUser(String uPhone);

	/**
	 * 晓风 注册用户名和密码
	 * 
	 * @param uName
	 * @param uPwd
	 */
	public void addUser(User user);

	/**
	 * 根据用户权限查询用户
	 * 
	 * @param uFlag
	 * @return
	 */
	public List<User> searchUflag(Integer uFlag);

}
