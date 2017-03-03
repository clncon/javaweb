package com.dream.dao;

import java.util.List;

import com.dream.entity.User;

/**
 * �û��Ľӿ�
 * 
 * @author ��� 2016-3-3����9:17:10
 */
public interface UserDao {

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public void add(User user);

	/**
	 * ɾ���û�
	 */
	public void delete(String uName);

	/**
	 * �����û�
	 * 
	 * @param uName
	 */
	public void update(User user);

	/**
	 * ��ѯ�����û�
	 * 
	 * @return
	 */
	public List<User> search();

	/**
	 * �����û�����ѯ�û�
	 * 
	 * @param uName
	 * @return
	 */
	public User searchUser(String uPhone);

	/**
	 * κ��ϼ �����û�id��ѯ�û�
	 * 
	 * @param uName
	 * @return
	 */
	public User searchUser(Integer uId);

	/**
	 * κ��ϼ ����idɾ���û�
	 */
	public void delete(Integer uId);

	/**
	 * κ��ϼ ����Ȩ�޷�ҳ���û�
	 * 
	 * @param uFlog
	 */

	public List<User> searchUflag(User user, Integer pageNo, Integer pageSize);

	/**
	 * κ��ϼ ����Ȩ�޷�ҳ���û���¼��
	 * 
	 * @param uFlog
	 */
	// public Integer searchVipCount();
	// public Integer searchUserCount();
	public Integer searchCount(User user);

	/**
	 * ��ҳ��ѯ ������
	 * 
	 * @param uId
	 * @return
	 */
	public List<User> searchPage_User(Integer pageNo, Integer pageSize);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public Integer searchAllUserCount();

	/**
	 * ��ѯ�û�
	 * 
	 * @param uName
	 * @return
	 */
	public User checkUser(String uPhone);

	/**
	 * ���� ע���û���������
	 * 
	 * @param uName
	 * @param uPwd
	 */
	public void addUser(User user);

	/**
	 * �����û�Ȩ�޲�ѯ�û�
	 * 
	 * @param uFlag
	 * @return
	 */
	public List<User> searchUflag(Integer uFlag);

}
