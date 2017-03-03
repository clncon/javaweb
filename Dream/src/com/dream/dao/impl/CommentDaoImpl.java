package com.dream.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.dream.comm.BaseDaoMysql;
import com.dream.dao.CommentDao;
import com.dream.entity.Comment;

/**
 * 评论接口的实现类
 * 
 * @author 林兴鹏 2016-3-4下午2:03:13
 * 
 */
public class CommentDaoImpl extends BaseDaoMysql implements CommentDao {

	/**
	 * 添加评论
	 * 
	 * @param comment
	 */
	@Override
	public void add(Comment comment) {
		String sql = " insert into Comment (cgname,cContent,cDate,cIp,cAuthor) values (?,?,?,?,?) ";
		List<Object> args = new ArrayList<Object>();
		args.add(comment.getcGname());
		args.add(comment.getcContent());
		args.add(comment.getcDate());
		args.add(comment.getcIp());
		args.add(comment.getcAuthor());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新评论
	 * 
	 * @param comment
	 */
	@Override
	public void update(Comment comment) {
		// String sql =
		// " update comment set cGname=?,cContent=?,cDate=?,cIp=?,cAuthor=? where cId=? ";
		List<Object> args = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(
				" update comment set cGname=cGname  ");
		if (comment.getcGname() != null) {
			sql.append(" cGname=? ");
		}
		if (comment.getcContent() != null) {
			sql.append(", ccontent =? ");
			args.add(comment.getcContent());
		}
		if (comment.getcDate() != null) {
			sql.append(" , cDate=? ");
			args.add(comment.getcDate());
		}
		if (comment.getcIp() != null) {
			sql.append(" , cIp=? ");
			args.add(comment.getcIp());
		}
		if (comment.getcAuthor() != null) {
			sql.append(" , cAuthor=? ");
			args.add(comment.getcAuthor());
		}
		sql.append(" , cId=? ");
		args.add(comment.getcId());
		// args.add(comment.getcGname());
		// args.add(comment.getcContent());
		// args.add(comment.getcDate());
		// args.add(comment.getcIp());
		// args.add(comment.getcAuthor());
		// args.add(comment.getcId());
		try {
			excuteUpdate(sql.toString(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除评论
	 * 
	 * @param comment
	 */
	@Override
	public void delete(Comment comment) {
		String sql = " delete from comment where cid=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(comment.getcId());
		try {
			excuteUpdate(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询评论
	 * 
	 * @return
	 */
	@Override
	public List<Comment> search() {
		List<Comment> listcom = new ArrayList<Comment>();
		String sql = " select * from comment ";
		try {
			Result rs = excuteQuery(sql, null);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Comment comment = new Comment();
					comment.setcId((Integer) rows.get("cId"));
					comment.setcGname(rows.get("cGname").toString());
					comment.setcContent(rows.get("cContent").toString());
					comment.setcDate(rows.get("cDate").toString());
					comment.setcIp(rows.get("cIp").toString());
					comment.setcAuthor(rows.get("cAuthor").toString());
					listcom.add(comment);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcom;
	}

	/**
	 * 根据评论ID查询评论
	 * 
	 * @param cId
	 * @return
	 */
	@Override
	public Comment search(Integer cId) {
		String sql = " select * from comment where cid=? ";
		List<Object> args = new ArrayList<Object>();
		Comment comment = null;
		args.add(cId);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				Map rows = rs.getRows()[0];
				comment = new Comment();
				comment.setcId((Integer) rows.get("cId"));
				comment.setcGname(rows.get("cGname").toString());
				comment.setcContent(rows.get("cContent").toString());
				comment.setcDate(rows.get("cDate").toString());
				comment.setcIp(rows.get("cIp").toString());
				comment.setcAuthor(rows.get("cAuthor").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	}

	/**
	 * 分页查询评论
	 * 
	 * @param comm
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Comment> searchPage_Comment(Comment comm, Integer pageNo,
			Integer pageSize) {
		List<Comment> listcom = new ArrayList<Comment>();
		StringBuffer sql = new StringBuffer(" select * from Comment ");
		List<Object> args = new ArrayList<Object>();
		sql.append(" where 1=1 ");
		if (comm.getcGname() != null && !"".equals(comm.getcGname())) {
			sql.append(" and cGname like ? ");
			args.add(comm.getcGname());
		}
		if (comm.getcDate() != null && !"".equals(comm.getcDate())) {
			sql.append(" and cdate=? ");
			args.add(comm.getcDate());
		}
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > 0 && pageSize >= 0) {
			sql.append(" limit ");
			sql.append((pageNo - 1) * pageSize);
			sql.append(" , ");
			sql.append(pageSize);
		}
		try {
			Result r = excuteQuery(sql.toString(), args);
			if (r != null && r.getRowCount() >= 0) {
				for (int i = 0; i < r.getRowCount(); i++) {
					Map rows = r.getRows()[i];
					Comment comment = new Comment();
					comment.setcId((Integer) rows.get("cId"));
					comment.setcGname(rows.get("cGname").toString());
					comment.setcContent(rows.get("cContent").toString());
					comment.setcDate(rows.get("cDate").toString());
					comment.setcIp(rows.get("cIp").toString());
					comment.setcAuthor(rows.get("cAuthor").toString());
					listcom.add(comment);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcom;
	}

	/**
	 * 查询评论总数
	 * 
	 * @return
	 */
	@Override
	public Integer searchCommentCount() {
		Integer count = 0;
		String sql = " select count(*) as count from Comment ";
		try {
			Result r = excuteQuery(sql, null);
			Map rows = r.getRows()[0];
			count = Integer.valueOf(rows.get("count").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 根据商品名称查询评论
	 * 
	 * @param cGname
	 * @return
	 */
	@Override
	public List<Comment> searchBygName(String cGname) {
		List<Comment> listcomment = new ArrayList<Comment>();
		String sql = " select * from comment where cGname=? ";
		List<Object> args = new ArrayList<Object>();
		args.add(cGname);
		try {
			Result rs = excuteQuery(sql, args);
			if (rs != null && rs.getRowCount() > 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map rows = rs.getRows()[i];
					Comment comment = new Comment();
					comment.setcId((Integer) rows.get("cId"));
					comment.setcGname(rows.get("cGname").toString());
					comment.setcContent(rows.get("cContent").toString());
					comment.setcDate(rows.get("cDate").toString());
					comment.setcIp(rows.get("cIp").toString());
					comment.setcAuthor(rows.get("cAuthor").toString());
					// System.out.println("we5445fh4"+comment.getcContent());
					listcomment.add(comment);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcomment;
	}

	/**
	 * 查询评论总数
	 * 
	 */
	@Override
	public Integer searchCommentCount(Comment comm) {
		Integer count = 0;
		StringBuffer sql = new StringBuffer(
				" select count(*) as count from Comment where 1=1  ");
		List<Object> args = new ArrayList<Object>();
		if (comm.getcGname() != null && !"".equals(comm.getcGname())) {
			sql.append(" and cgname like ? ");
			args.add(comm.getcGname());
		}
		if (comm.getcDate() != null && !"".equals(comm.getcDate())) {
			sql.append(" and cdate=? ");
			args.add(comm.getcDate());
		}
		try {
			Result r = excuteQuery(sql.toString(), args);
			Map rows = r.getRows()[0];
			count = Integer.valueOf(rows.get("count").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
