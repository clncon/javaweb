package com.dream.biz;

import java.util.List;

import com.dream.entity.Comment;

/**
 * 
 * @author 林兴鹏 2016-3-8下午1:39:24
 * 
 */
public interface CommentBiz {
	/**
	 * 添加评论
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment);

	/**
	 * 删除评论
	 * 
	 * @param comment
	 */
	public void deleteComment(Comment comment);

	/**
	 * 更新评论
	 * 
	 * @param comment
	 */
	public void updateComment(Comment comment);

	/**
	 * 查询评论
	 * 
	 * @return
	 */
	public List<Comment> searchComment();

	/**
	 * 通过评论ID查询评论
	 * 
	 * @param cid
	 * @return
	 */
	public Comment findById(Integer cId);

	/**
	 * 分页查询评论对象 陈霞
	 * 
	 * @param cGname
	 * @param pageNo
	 * @param pageSize
	 * @return 评论对象
	 */
	public List<Comment> searchPage_Comment(Comment comm, Integer pageNo,
			Integer pageSize);

	/**
	 * 根据商品名字查询评论
	 * 
	 * @return
	 */
	public List<Comment> searchBygName(String cGname);

	/**
	 * 记录总数 陈霞
	 * 
	 * @return 记录总数
	 */
	public Integer searchCommentCount();

	/**
	 * 记录总数 陈霞
	 * 
	 * @return 记录总数
	 */
	public Integer searchCommentCount(Comment comm);
}
