package com.dream.dao;
import java.util.List;
import com.dream.entity.Comment;

/**
 * 评论的接口
 * 
 * @author 葛睿 2016-3-3下午9:42:22
 */
public interface CommentDao {

	/**
	 * 添加评论
	 * 
	 * @param comment
	 * @return 状态
	 */
	public void add(Comment comment);

	/**
	 * 修改评论
	 * 
	 * @param comment
	 * @return 状态
	 */
	public void update(Comment comment);

	/**
	 * 删除评论
	 * 
	 * @param comment
	 * @return 状态
	 */
	public void delete(Comment comment);

	/**
	 * 查询评论
	 * 
	 * @return 评论列表
	 */
	public List<Comment> search();

	/**
	 * 查询评论对象
	 * 
	 * @param cId
	 * @return 评论对象
	 */
	public Comment search(Integer cId);

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
	 * 记录总数 陈霞
	 * 
	 * @return 记录总数
	 */
	public Integer searchCommentCount();

	/**
	 * 兴鹏 根据商品名字查询评论
	 * 
	 * @return
	 */
	public List<Comment> searchBygName(String cGname);

	/**
	 * 记录总数 陈霞
	 * 
	 * @return 记录总数
	 */
	public Integer searchCommentCount(Comment comm);
}
