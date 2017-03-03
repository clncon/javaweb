package com.dream.biz.impl;

import java.util.List;
import com.dream.biz.CommentBiz;
import com.dream.dao.CommentDao;
import com.dream.dao.impl.CommentDaoImpl;
import com.dream.entity.Comment;

/**
 * ����ҵ��ɵ�ʵ����
 * 
 * 
 */
public class CommentBizImpl implements CommentBiz {

	/**
	 * ��������
	 */
	@Override
	public void addComment(Comment comment) {
		CommentDao cd = new CommentDaoImpl();
		cd.add(comment);

	}

	/**
	 * ɾ������
	 */
	@Override
	public void deleteComment(Comment comment) {
		CommentDao cd = new CommentDaoImpl();
		cd.delete(comment);
	}

	/**
	 * ��������
	 */
	@Override
	public void updateComment(Comment comment) {
		CommentDao cd = new CommentDaoImpl();
		cd.update(comment);
	}

	/**
	 * ��ѯ����
	 */
	@Override
	public List<Comment> searchComment() {
		CommentDao cd = new CommentDaoImpl();

		return cd.search();
	}

	/**
	 * ��������ID��ѯ
	 */
	@Override
	public Comment findById(Integer cId) {
		CommentDao cd = new CommentDaoImpl();

		return cd.search(cId);
	}

	/**
	 * ��ҳ��ѯ����
	 */
	@Override
	public List<Comment> searchPage_Comment(Comment comm, Integer pageNo,
			Integer pageSize) {
		CommentDao cd = new CommentDaoImpl();
		List<Comment> listcom = cd.searchPage_Comment(comm, pageNo, pageSize);
		return listcom;
	}

	/**
	 * ������Ʒ���ֲ�ѯ����
	 */
	@Override
	public List<Comment> searchBygName(String cGname) {
		CommentDao cd = new CommentDaoImpl();
		List<Comment> listcomment = cd.searchBygName(cGname);
		return listcomment;
	}

	/**
	 * ��ѯ��������
	 */
	@Override
	public Integer searchCommentCount() {
		CommentDao cd = new CommentDaoImpl();
		Integer count = cd.searchCommentCount();
		return count;
	}

	/**
	 * ��¼���� ��ϼ
	 * 
	 * @return ��¼����
	 */
	@Override
	public Integer searchCommentCount(Comment comm) {
		CommentDao cd = new CommentDaoImpl();
		Integer count = cd.searchCommentCount(comm);
		return count;
	}

}