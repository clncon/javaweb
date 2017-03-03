package com.dream.biz.impl;

import java.util.List;
import com.dream.biz.CommentBiz;
import com.dream.dao.CommentDao;
import com.dream.dao.impl.CommentDaoImpl;
import com.dream.entity.Comment;

/**
 * 评论业务成的实现类
 * 
 * 
 */
public class CommentBizImpl implements CommentBiz {

	/**
	 * 增加评论
	 */
	@Override
	public void addComment(Comment comment) {
		CommentDao cd = new CommentDaoImpl();
		cd.add(comment);

	}

	/**
	 * 删除评论
	 */
	@Override
	public void deleteComment(Comment comment) {
		CommentDao cd = new CommentDaoImpl();
		cd.delete(comment);
	}

	/**
	 * 更新评论
	 */
	@Override
	public void updateComment(Comment comment) {
		CommentDao cd = new CommentDaoImpl();
		cd.update(comment);
	}

	/**
	 * 查询评论
	 */
	@Override
	public List<Comment> searchComment() {
		CommentDao cd = new CommentDaoImpl();

		return cd.search();
	}

	/**
	 * 根据评论ID查询
	 */
	@Override
	public Comment findById(Integer cId) {
		CommentDao cd = new CommentDaoImpl();

		return cd.search(cId);
	}

	/**
	 * 分页查询评论
	 */
	@Override
	public List<Comment> searchPage_Comment(Comment comm, Integer pageNo,
			Integer pageSize) {
		CommentDao cd = new CommentDaoImpl();
		List<Comment> listcom = cd.searchPage_Comment(comm, pageNo, pageSize);
		return listcom;
	}

	/**
	 * 根据商品名字查询评论
	 */
	@Override
	public List<Comment> searchBygName(String cGname) {
		CommentDao cd = new CommentDaoImpl();
		List<Comment> listcomment = cd.searchBygName(cGname);
		return listcomment;
	}

	/**
	 * 查询评论总数
	 */
	@Override
	public Integer searchCommentCount() {
		CommentDao cd = new CommentDaoImpl();
		Integer count = cd.searchCommentCount();
		return count;
	}

	/**
	 * 记录总数 陈霞
	 * 
	 * @return 记录总数
	 */
	@Override
	public Integer searchCommentCount(Comment comm) {
		CommentDao cd = new CommentDaoImpl();
		Integer count = cd.searchCommentCount(comm);
		return count;
	}

}