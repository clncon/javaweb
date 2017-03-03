package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.dream.comm.BaseDaoMysql;
import com.dream.dao.UserDao;
import com.dream.entity.User;

/**
 * �û��ӿڵ�ʵ����
 * 
 * @author ��ҫ 2016-3-4����11:10:28
 */
public class UserDaoImpl extends BaseDaoMysql implements UserDao {

	/**
	 * ����û���Ϣ
	 * 
	 */
	@Override
	public void add(User user) {
		String sql = " insert into user (uName,uPwd,sex,uBir,uPhone,uMail,uAddress,uFlag,uLevel)values(?,?,?,?,?,?,?,?,?) ";
		List<Object> args = new ArrayList<Object>();
		args.add(user.getuName()); // ����
		args.add(user.getuPwd()); // �û�����
		args.add(user.getSex()); // �Ա�
		args.add(user.getuBir()); // ����
		args.add(user.getuPhone()); // �绰
		args.add(user.getuMail()); // ����
		args.add(user.getuAddress()); // ���õ�ַ
		args.add(user.getuFlag()); // Ȩ�� ��ͨ�û� ���� ��̨����
		args.add(user.getuLevel()); // ��Ա�ȼ�
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����û���ɾ��
	 */
	@Override
	public void delete(String uName) {
		String sql = " delete from user where uname=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(uName);// ����
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����û�
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
			args.add(user.getuPwd()); // �û�����
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
		// args.add(user.getuName()); // ����
		//
		// args.add(user.getuBir()); // ����
		// args.add(user.getuPhone()); // �绰
		// args.add(user.getuMail()); // ����
		// args.add(user.getuAddress()); // ���õ�ַ
		// args.add(user.getuFlag()); // Ȩ�� ��ͨ�û� ���� ��̨����
		// args.add(user.getuLevel()); // ��Ա�ȼ�
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
	 * ��ѯ�����û� (non-Javadoc)
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
					// ��װ
					user.setuId((Integer) (rows.get("uid")));// ID
					user.setuName((String) rows.get("uname"));// ����
					user.setuPwd((String) rows.get("upwd"));// ����
					user.setSex((String) rows.get("sex"));// �Ա�
					user.setuBir((String) rows.get("ubir"));// ����
					user.setuPhone((String) rows.get("uphone"));// �绰
					user.setuMail((String) rows.get("umail")); // ����
					user.setuAddress((String) rows.get("uaddress"));// ���õ�ַ
					user.setuFlag((String) rows.get("uflag"));// Ȩ�� :��ͨ�û�    ����    ��̨�� �� Ա
					user.setuLevel((String) rows.get("ulevel"));// ��Ա�ȼ�
					// ��ӵ�������
					listUser.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	/**
	 *�����û��绰��ѯ�û� 
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
				// ��װ
				user.setuId((Integer) (rows.get("uid")));// ID
				user.setuName((String) rows.get("uname"));// ����
				user.setuPwd((String) rows.get("upwd"));// ����
				user.setSex((String) rows.get("sex"));// �Ա�
				user.setuBir((String) rows.get("ubir"));// ����
				user.setuPhone((String) rows.get("uphone"));// �绰
				user.setuMail((String) rows.get("umail")); // ����
				user.setuAddress((String) rows.get("uaddress"));// ���õ�ַ
				user.setuFlag((String) rows.get("uflag"));// Ȩ�� ��ͨ�û� ���� ��̨����
				user.setuLevel((String) rows.get("ulevel"));// ��Ա�ȼ�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * ��ҳ��ѯ�û�
	 * 
	 */
	@Override
	public List<User> searchPage_User(Integer pageNo, Integer pageSize) {
		List<User> listUser = new ArrayList<User>(); // ��ѯ�����û���Ϣ
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
					user.setuName((String) rows.get("uname"));// ����
					user.setuPwd((String) rows.get("upwd"));// ����
					user.setSex((String) rows.get("sex"));// �Ա�
					user.setuBir((String) rows.get("ubir"));// ����
					user.setuPhone((String) rows.get("uphone"));// �绰
					user.setuMail((String) rows.get("umail")); // ����
					user.setuAddress((String) rows.get("uaddress"));// ���õ�ַ
					user.setuFlag((String) rows.get("uflag"));// Ȩ�� ��ͨ�û� ���� ��̨����
					user.setuLevel((String) rows.get("ulevel"));// ��Ա�ȼ�
					listUser.add(user); // ���user
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	/**
	 * ��¼��
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
	 * �����û��绰��ѯ�û�������Ҫ��Ϣ
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
				// ��װ
				user.setuId((Integer) (rows.get("uid")));// ID
				user.setuName((String) rows.get("uname"));// ����
				user.setuPwd((String) rows.get("upwd"));// ����
				user.setuPhone((String) rows.get("uPhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * ע���û���������
	 * 
	 */
	@Override
	public void addUser(User user) {
		String sql = " insert into user (uPhone,uPwd,umail,uName)values(?,?,?,?) ";
		List<Object> args = new ArrayList<Object>();
		args.add(user.getuPhone()); // ����
		args.add(user.getuPwd()); // �û�����
		args.add(user.getuMail());
		args.add(user.getuName());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * κ��ϼ ����Ȩ�޷�ҳ��ѯ
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
		//System.out.println("��ҳ" + sql);
		try {
			Result rs = excuteQuery(sql.toString(), args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					User tempuser = new User();
					Map rows = rs.getRows()[i];
					// ��װ
					tempuser.setuId(new Integer(rows.get("uid").toString()));// ID
					tempuser.setuName((String) rows.get("uname"));// ����
					tempuser.setuPwd((String) rows.get("upwd"));// ����
					tempuser.setSex((String) rows.get("sex"));// �Ա�
					tempuser.setuBir((String) rows.get("ubir"));// ����
					tempuser.setuPhone((String) rows.get("uphone"));// �绰
					tempuser.setuMail((String) rows.get("umail")); // ����
					tempuser.setuAddress((String) rows.get("uaddress"));// ���õ�ַ
					tempuser.setuFlag((String) rows.get("uflag"));// Ȩ��: ��ͨ�û�     ����    ��̨����
					tempuser.setuLevel((String) rows.get("ulevel"));// ��Ա�ȼ�
					listUser.add(tempuser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	// /**
	// * κ��ϼ
	// * ����Ȩ�޷�ҳ��ѯ��¼��
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
	// * κ��ϼ
	// * ����Ȩ�޷�ҳ��ѯ��¼��
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
	 * �����û�id���û�
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
				// ��װ
				user.setuId((Integer) (uId));// ID
				user.setuName((String) rows.get("uname"));// ����
				user.setuPwd((String) rows.get("upwd"));// ����
				user.setSex((String) rows.get("sex"));// �Ա�
				user.setuBir((String) rows.get("ubir"));// ����
				user.setuPhone((String) rows.get("uphone"));// �绰
				user.setuMail((String) rows.get("umail")); // ����
				user.setuAddress((String) rows.get("uaddress"));// ���õ�ַ
				user.setuFlag((String) rows.get("uflag"));// Ȩ�� ��ͨ�û� ���� ��̨����
				user.setuLevel((String) rows.get("ulevel"));// ��Ա�ȼ�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * �����û�idɾ�û�
	 * 
	 */
	@Override
	public void delete(Integer uId) {
		String sql = " delete from user where uid=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(uId);// ����
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����û�Ȩ�޲�ѯ�û�
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
					// ��װ
					user.setuId((Integer) rows.get("uid"));// ID
					user.setuName((String) rows.get("uname"));// ����
					user.setuPwd((String) rows.get("upwd"));// ����
					user.setSex((String) rows.get("sex"));// �Ա�
					user.setuBir((String) rows.get("ubir"));// ����
					user.setuPhone((String) rows.get("uphone"));// �绰
					user.setuMail((String) rows.get("umail")); // ����
					user.setuAddress((String) rows.get("uaddress"));// ���õ�ַ
					user.setuFlag((String) rows.get("uflag"));// Ȩ�� ��ͨ�û� ���� ��̨����
					user.setuLevel((String) rows.get("ulevel"));// ��Ա�ȼ�
					listUser.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	/**
	 * �����û�Ȩ�޲�ѯ��¼��
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
		//System.out.println("��¼��" + sql);
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
