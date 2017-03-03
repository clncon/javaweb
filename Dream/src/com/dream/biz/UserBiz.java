package com.dream.biz;

import java.util.List;

import com.dream.entity.User;

/**
 * �û���ҵ���
 * 
 * @author ��� 2016-3-8����10:58:45
 */
public interface UserBiz {
	/**
	 * ע���Ñ�
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * �Ñ��ĵ�¼
	 * 
	 * @param uName
	 * @param uPwd
	 * @return
	 */
	public User loginUser(String uPhone, String uPwd);

	/**
	 * ɾ���û�
	 */
	public void deleteUser(String uName);

	/**
	 * �����û�
	 */
	public void updateUser(User user);

	/**
	 * ����û��Ƿ����
	 * 
	 * @return
	 */
	public boolean checkUser(String uPhone);

	/**
	 * κ��ϼ ����Ȩ�޲��û�
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
	 * ����Ȩ�޲�ѯ�û�
	 * @param uFlag
	 * @return
	 */
	public List<User> searchUflag(Integer uFlag);

}
