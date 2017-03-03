package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.dream.comm.BaseDaoMysql;
import com.dream.dao.StoreDao;
import com.dream.entity.Store;
import com.dream.entity.User;

/**
 * �û������ʵ����
 * 
 * @author ��ҫ 2016-3-4����12:52:13
 */
public class StoreDaoImpl extends BaseDaoMysql implements StoreDao {
	/*
	 * ���ӵ��� (non-Javadoc)
	 * 
	 * @see com.dream.dao.StoreDao#add(com.dream.entity.Store)
	 */
	@Override
	public void add(Store store) {
		String sql = " insert into  store(sname,sphone,sAddress,suid) values(?,?,?,?)";
		List<Object> args = new ArrayList<Object>();
		args.add(store.getsName()); // ����
		args.add(store.getsPhone()); // �绰
		args.add(store.getsAddress());// ���õ�ַ
		args.add(store.getSuid()); // ����ID
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ɾ������ (non-Javadoc)
	 * 
	 * @see com.dream.dao.StoreDao#delete(int)
	 */
	@Override
	public void delete(int sid) {
		String sql = " delete from store where sid=?  ";
		List<Object> args = new ArrayList<Object>();
		args.add(sid);
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ���ĵ�����Ϣ (non-Javadoc)
	 * 
	 * @see com.dream.dao.StoreDao#update(com.dream.entity.Store)
	 */
	@Override
	public void update(Store store) {
		// String sql = " update store set  saddress=? where sid=?  ";
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(" update store set sname=sname  ");
		// if(store.getsName()!=null){
		// sql.append("  sname=? ");
		// args.add(store.getsName());
		// }
		if (store.getsAddress() != null) {
			sql.append(" , saddress=? ");
			args.add(store.getsAddress());
		}
		if (store.getsPhone() != null) {
			sql.append(" , sphone =? ");
			args.add(store.getsPhone());
		}
		if (store.getSuid() != 0) {
			sql.append(" , suid =? ");
			args.add(store.getSuid());
		}
		// sql.append(" where  sid = ? ");
		sql.append(" where  sname = ? ");
		args.add(store.getsName());
		// args.add(store.getsAddress());
		// args.add(store.getsId());
		try {
			excuteUpdate(sql.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ��ѯ���е�����Ϣ (non-Javadoc)
	 * 
	 * @see com.dream.dao.StoreDao#search()
	 */
	@Override
	public List<Store> search() {
		String sql = " select * from store ";
		List<Store> listStore = new ArrayList<Store>();
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Store store = new Store();
					store.setsId(new Integer(rows.get("sid").toString()));
					store.setsPhone(rows.get("sphone").toString());
					store.setsName(rows.get("sname").toString());
					store.setsAddress(rows.get("saddress").toString());
					store.setSuid(new Integer(rows.get("suid").toString()));
					listStore.add(store);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStore;
	}

	/*
	 * ��ѯһ�����������Ϣ (non-Javadoc)
	 * 
	 * @see com.dream.dao.StoreDao#searchStore()
	 */
	@Override
	public Store searchStore(int sid) {
		String sql = " select * from store where sid=? ";
		Store store = null;
		List<Object> args = new ArrayList<Object>();
		args.add(sid);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				store = new Store();
				// ��װ
				store.setsId(new Integer(rows.get("sid").toString()));// ID
				store.setsName(rows.get("sname").toString());// ����
				store.setsPhone(rows.get("sphone").toString());// �绰
				store.setsAddress(rows.get("saddress").toString());// ��ַ
				store.setSuid(new Integer(rows.get("suid").toString()));// ����ID
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;
	}

	/*
	 * ��ҳ��ѯ ������
	 * 
	 * @param pageNo
	 * 
	 * @param pageSize
	 * 
	 * @return
	 */
	@Override
	public List<Store> searchPage_Store(Integer pageNo, Integer pageSize) {
		List<Store> list = new ArrayList<Store>();
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(" select * from store ");
		sql.append(" where 1=1 ");
		if (pageNo < 0) {
			pageNo = 1;
		}
		if (pageNo > 0 && pageSize >= 1) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(",");
			sql.append(pageSize);
			//System.out.println("��ѯ�����" + sql.toString());
			try {
				Result rt = this.excuteQuery(sql.toString(), args);
				if (rt != null && rt.getRowCount() > 0) {
					for (int i = 0; i < rt.getRowCount(); i++) {
						Map rows = rt.getRows()[i];
						Store store = new Store();
						store.setsId(new Integer(rows.get("sid").toString()));// ID
						store.setsPhone(rows.get("sphone").toString());// �绰
						store.setsName(rows.get("sname").toString());// ����
						store.setsAddress(rows.get("saddress").toString());// ��ַ
						store.setSuid(new Integer(rows.get("suid").toString()));// ����ID
						list.add(store);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/*
	 * ��¼���� ������
	 */
	@Override
	public Integer searchStoreCount() {
		Integer count = 0;
		String sql = " select count(*) as count from store";
		Result rt;
		try {
			rt = excuteQuery(sql, null);
			if (rt != null && rt.getRowCount() > 0) {
				Map row = rt.getRows()[0];
				count = Integer.valueOf(row.get("count").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * ������ ���ݵ���ID��ѯ������Ϣ
	 */
	@Override
	public Store searchStoreBySuid(Integer sUid) {
		String sql = "select * from store  where suid=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(sUid);
		Store store = null;
		try {
			Result rt = excuteQuery(sql, args);
			if (rt != null && rt.getRowCount() > 0) {
				store = new Store();
				// for (int i = 0; i < rt.getRowCount(); i++) {}
				Map row = rt.getRows()[0];
				store.setsId(new Integer(row.get("sid").toString()));
				store.setsName(row.get("sname").toString());
				store.setsPhone(row.get("sphone").toString());
				store.setsAddress(row.get("saddress").toString());
				store.setSuid(new Integer(row.get("suid").toString()));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;
	}

}
