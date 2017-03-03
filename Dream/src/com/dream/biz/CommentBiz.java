package com.dream.biz;

import java.util.List;

import com.dream.entity.Comment;

/**
 * 
 * @author ������ 2016-3-8����1:39:24
 * 
 */
public interface CommentBiz {
	/**
	 * �������
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment);

	/**
	 * ɾ������
	 * 
	 * @param comment
	 */
	public void deleteComment(Comment comment);

	/**
	 * ��������
	 * 
	 * @param comment
	 */
	public void updateComment(Comment comment);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<Comment> searchComment();

	/**
	 * ͨ������ID��ѯ����
	 * 
	 * @param cid
	 * @return
	 */
	public Comment findById(Integer cId);

	/**
	 * ��ҳ��ѯ���۶��� ��ϼ
	 * 
	 * @param cGname
	 * @param pageNo
	 * @param pageSize
	 * @return ���۶���
	 */
	public List<Comment> searchPage_Comment(Comment comm, Integer pageNo,
			Integer pageSize);

	/**
	 * ������Ʒ���ֲ�ѯ����
	 * 
	 * @return
	 */
	public List<Comment> searchBygName(String cGname);

	/**
	 * ��¼���� ��ϼ
	 * 
	 * @return ��¼����
	 */
	public Integer searchCommentCount();

	/**
	 * ��¼���� ��ϼ
	 * 
	 * @return ��¼����
	 */
	public Integer searchCommentCount(Comment comm);
}
