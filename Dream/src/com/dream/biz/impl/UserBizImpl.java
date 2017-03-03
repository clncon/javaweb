package com.dream.biz.impl;

import java.util.List;

import com.dream.biz.UserBiz;
import com.dream.comm.SHA1jiami;
import com.dream.dao.UserDao;
import com.dream.dao.impl.UserDaoImpl;
import com.dream.entity.User;

/**
 * �û�ҵ���ʵ��
 * 
 */
public class UserBizImpl implements UserBiz {

	/*
	 * �����û� ��� 2016-3-8����11:36:57
	 */
	@Override
	public void addUser(User user) {
		UserDao ud = new UserDaoImpl();
		String SAUpwd = SHA1jiami.SHA1Digest(user.getuPwd());// ���������
		user.setuPwd(SAUpwd); // �����ܴ�����User��
		ud.addUser(user); // �Ӵ��û����ӵ����ݿ���

	}

	/*
	 * �Ñ��ĵ�� ��� 2016-3-8����11:37:22
	 */
	@Override
	public User loginUser(String uPhone, String uPwd) {
		UserDao ud = new UserDaoImpl();
		User loginUser = ud.checkUser(uPhone);// �����û�����ѯ���ݿ��е�����

		if (loginUser == null) {
			return null;
		} else {
			String SAUpwd = SHA1jiami.SHA1Digest(uPwd);// �����û����������
			if (loginUser.getuPwd().equals(SAUpwd)) {
				// loginUser.setuPwd(null);//���û�����Ϊ��
				return loginUser;
			}

		}

		return null;

	}

	/*
	 * ɾ���û� ��� 2016-3-8����11:37:46
	 */
	@Override
	public void deleteUser(String uName) {
		UserDao ud = new UserDaoImpl();
		ud.delete(uName);
	}

	/*
	 * �����û� ��� 2016-3-8����11:37:54
	 */
	@Override
	public void updateUser(User user) {

		UserDao ud = new UserDaoImpl();
		ud.update(user);

	}

	/*
	 * ����Ƿ������û� ���2016-3-9����9:22:11
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
	 * ����Ȩ�޲�ѯ κ��ϼ (non-Javadoc)
	 * 
	 * @see com.dream.biz.UserBiz#searchUflog(java.lang.Integer)
	 */
	@Override
	public List<User> searchUflag(User user, Integer pageNo, Integer pageSize) {
		UserDao ud = new UserDaoImpl();

		return ud.searchUflag(user, pageNo, pageSize);
	}

	/**
	 * �����û�����ѯ�û�
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
	 * κ��ϼ ����Ȩ�޷�ҳ���û���¼��
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
	 * ��ѯ�û�����
	 */
	@Override
	public Integer searchCount(User user) {
		UserDao ud = new UserDaoImpl();
		Integer count = ud.searchCount(user);
		return count;
	}

	/**
	 * �����û�ID��ѯ�û�
	 */
	@Override
	public User searchUser(Integer uId) {
		UserDao ud = new UserDaoImpl();

		return ud.searchUser(uId);
	}

	/**
	 * κ��ϼ ����Idɾ�û�
	 */
	@Override
	public void delete(Integer uId) {
		UserDao ud = new UserDaoImpl();
		ud.delete(uId);

	}

	/**
	 * �����û�Ȩ�޲�ѯ�û�
	 */
	@Override
	public List<User> searchUflag(Integer uFlag) {
		UserDao dao = new UserDaoImpl();
		List<User> listvip = dao.searchUflag(uFlag);
		return listvip;
	}

}
