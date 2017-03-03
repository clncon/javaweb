package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.dream.comm.BaseDaoMysql;
import com.dream.dao.SaleDao;
import com.dream.entity.Goods;
import com.dream.entity.Sale;

/**
 * ���۵�ʵ����
 * 
 * @author Сƽ 2016-3-4����2:52:41
 * 
 */
public class SaleDaoImpl extends BaseDaoMysql implements SaleDao {

	/**
	 * ���������Ϣ
	 */
	@Override
	public void add(Sale sale) {
		String sql = "insert into sale(sanum,saprice,savisitor,sasname) values(?,?,?,?)";
		List<Object> args = new ArrayList<Object>();
		args.add(sale.getSaNum());
		args.add(sale.getSaPrice());
		args.add(sale.getSaVisitor());
		args.add(sale.getSaSname());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ��������Ϣ
	 */
	@Override
	public void delete(int saId) {
		String sql = "delete from sale where said=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(saId);
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �޸�������Ϣ
	 */
	@Override
	public void update(Sale sale) {
		// String sql =
		// " update sale set  sanum=? , saprice=? , savisitor=? ,  sasname=? where said=?";
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(" update sale set sanum=sanum ");
		if (sale.getSaNum() != 0) {
			sql.append("  ,sanum=? ");
			args.add(sale.getSaNum());
		}
		if (sale.getSaPrice() != 0) {
			sql.append(" , saprice =? ");
			args.add(sale.getSaPrice());
		}
		if (sale.getSaSname() != null) {
			sql.append(" , sasname=? ");
			args.add(sale.getSaSname());

		}
		if (sale.getSaVisitor() != 0) {
			sql.append(" , savisitor=? ");
			args.add(sale.getSaVisitor());
		}
		sql.append("  where said=? ");
		args.add(sale.getSaId());

		// args.add(sale.getSaNum());
		// args.add(sale.getSaPrice());
		// args.add(sale.getSaVisitor());
		// args.add(sale.getSaSname());
		// args.add(sale.getSaId());
		//
		try {
			excuteUpdate(sql.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ѯȫ��������Ϣ
	 */
	@Override
	public List<Sale> search() {
		List<Sale> listSA = new ArrayList<Sale>();
		String sql = "select * from sale ";
		List<Object> args = new ArrayList<Object>();// ���� ==���ĸ���
		try {
			Result rs = excuteQuery(sql, args);// ����һ�������
			// ���ص��������Ǵ���0��
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map row = rs.getRows()[i];// ����һ������
					Sale sale = new Sale();// �����ݵķ�װ
					sale.setSaId(new Integer(row.get("said").toString()));
					sale.setSaNum(new Integer(row.get("sanum").toString()));
					sale.setSaPrice(new Double(row.get("saprice").toString()));
					sale.setSaVisitor(new Integer(row.get("savisitor").toString()));
					sale.setSaSname(row.get("sasname").toString());
					// ��ӵ�������
					listSA.add(sale);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listSA;
	}

	/**
	 * ��������ID��ѯ����ҵ��
	 * 
	 */
	@Override
	public Sale searchSale(int saId) {
		List<Sale> listSA = new ArrayList<Sale>();
		String sql = "select * from sale where said=? ";
		List<Object> args = new ArrayList<Object>();//
		args.add(saId);
		Sale sale = null;// �����ݵķ�װ
		try {
			Result rs = excuteQuery(sql, args);// ����һ�������
			// ���ص��������Ǵ���0��
			if (rs != null && rs.getRowCount() > 0) {
				sale = new Sale();
				Map row = rs.getRows()[0];// ����һ������
				sale.setSaId(new Integer(row.get("said").toString()));
				sale.setSaNum(new Integer(row.get("sanum").toString()));
				sale.setSaPrice(new Double(row.get("saprice").toString()));
				sale.setSaVisitor(new Integer(row.get("savisitor").toString()));
				sale.setSaSname(row.get("sasname").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sale;
	}
}
