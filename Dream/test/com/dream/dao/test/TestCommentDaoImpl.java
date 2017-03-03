package com.dream.dao.test;



import java.util.List;

import org.junit.Test;

import com.dream.comm.Page;
import com.dream.dao.CommentDao;
import com.dream.dao.impl.CommentDaoImpl;
import com.dream.entity.Comment;


/**
 * @author ������
 * 2016-3-4����2:53:24
 * 
 */
public class TestCommentDaoImpl {

	/**
	 * �����������
	 */
	Comment comment=new Comment();
	CommentDao dao=new CommentDaoImpl();
	//@Test
	public void testAdd() {
		comment.setcGname("���ɱ�����");
		comment.setcContent("����ɵ����");
		comment.setcDate("2016-3-4");
		comment.setcIp("192.169.31.243");
		comment.setcAuthor("����");
		dao.add(comment);
		
	}

	/**
	 * ���Ը�������   cGname=?,cContent=?,cDate=?,cIp=?,cAuthor=?) where cId=?
	 */
	//@Test
	public void testUpdate() {
		comment.setcGname("���ɱ�����");
		comment.setcContent("���ó�");
		comment.setcDate("2016-3-2");
		comment.setcIp("192.169.31.241");
		comment.setcAuthor("��ϼ");
		comment.setcId(3);
		dao.update(comment);
	}

	//@Test
	public void testDelete() {
		comment.setcId(2);
		dao.delete(comment);
	}

	//@Test
	public void testSearch() {
	
		 List<Comment> list= dao.search();
		    for (Comment comment : list) {
				System.out.println(comment.toString());
				
			}
	}

	@Test
	public void testSearchInteger() {

				System.out.println(dao.search(2));
				
			}
	
	//��ϼ
	//@Test
		public void searchPage_Comment() {
			Page page=new Page(1,2);
			page.setTotalCount(30);
			System.out.println("�м�ҳ��"+page.getPageCount());
			Comment comm=new Comment();
		List<Comment> listcom=dao.searchPage_Comment(comm, page.getPageNo(), page.getPageSize());
		for (Comment comment : listcom) {
			System.out.println(comment);
		}
					
					
				}
	//��ϼ
	//@Test
	public void searchCommentCount() {
				System.out.println("��¼����:"+dao.searchCommentCount());
			
				
			}
	
	
	}


