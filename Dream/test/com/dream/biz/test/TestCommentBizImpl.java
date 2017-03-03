package com.dream.biz.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.dao.CommentDao;
import com.dream.dao.impl.CommentDaoImpl;
import com.dream.entity.Comment;

/**
 * ����ʵ����Ĳ���
 * 
 * @author ������
 * 2016-3-8����1:57:05
 * 
 */
public class TestCommentBizImpl {

	Comment comment=new Comment();
	CommentDao dao=new CommentDaoImpl();
	/**
	 * ������۲���
	 */
	//@Test
	public void testAddComment() {
		comment.setcGname("���ɱ�����");
		comment.setcContent("����ɵ����");
		comment.setcDate("2016-3-4");
		comment.setcIp("192.169.31.243");
		comment.setcAuthor("����");
		dao.add(comment);
	}

	/**
	 * ɾ�����۲���
	 */
	//@Test
	public void testDeleteComment() {
		comment.setcId(2);
		dao.delete(comment);
	}

	/**
	 * �������۲���
	 */
	//@Test
	public void testUpdateComment() {
		comment.setcGname("���ɱ�����");
		comment.setcContent("���ó�");
		comment.setcDate("2016-3-2");
		comment.setcIp("192.169.31.241");
		comment.setcAuthor("��ϼ");
		comment.setcId(3);
		dao.update(comment);
	}

	/**
	 * ���۲�ѯ����
	 */
	//@Test
	public void testSearchComment() {
		 List<Comment> list= dao.search();
		    for (Comment comment : list) {
				System.out.println(comment.toString());
	}
	}
	/**
	 * ͨ��ID��ѯ���۲���
	 */
	@Test
	public void testFindById() {
		Comment comment=dao.search(2);
		System.out.println(comment.toString());
	}

}

