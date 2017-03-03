package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.dao.CommentDao;
import com.dream.dao.impl.CommentDaoImpl;
import com.dream.entity.Comment;

/**
 * 评论实现类的测试
 * 
 * @author 林兴鹏
 * 2016-3-8下午1:57:05
 * 
 */
public class TestCommentBizImpl {

	Comment comment=new Comment();
	CommentDao dao=new CommentDaoImpl();
	/**
	 * 添加评论测试
	 */
	//@Test
	public void testAddComment() {
		comment.setcGname("菲律宾凤梨");
		comment.setcContent("你是傻逼吗");
		comment.setcDate("2016-3-4");
		comment.setcIp("192.169.31.243");
		comment.setcAuthor("晓风");
		dao.add(comment);
	}

	/**
	 * 删除评论测试
	 */
	//@Test
	public void testDeleteComment() {
		comment.setcId(2);
		dao.delete(comment);
	}

	/**
	 * 更新评论测试
	 */
	//@Test
	public void testUpdateComment() {
		comment.setcGname("菲律宾凤梨");
		comment.setcContent("不好吃");
		comment.setcDate("2016-3-2");
		comment.setcIp("192.169.31.241");
		comment.setcAuthor("陈霞");
		comment.setcId(3);
		dao.update(comment);
	}

	/**
	 * 评论查询测试
	 */
	//@Test
	public void testSearchComment() {
		 List<Comment> list= dao.search();
		    for (Comment comment : list) {
				System.out.println(comment.toString());
	}
	}
	/**
	 * 通过ID查询评论测试
	 */
	@Test
	public void testFindById() {
		Comment comment=dao.search(2);
		System.out.println(comment.toString());
	}

}

