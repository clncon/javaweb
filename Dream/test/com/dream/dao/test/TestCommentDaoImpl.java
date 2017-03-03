package com.dream.dao.test;



import java.util.List;

import org.junit.Test;

import com.dream.comm.Page;
import com.dream.dao.CommentDao;
import com.dream.dao.impl.CommentDaoImpl;
import com.dream.entity.Comment;


/**
 * @author 林兴鹏
 * 2016-3-4下午2:53:24
 * 
 */
public class TestCommentDaoImpl {

	/**
	 * 测试添加评论
	 */
	Comment comment=new Comment();
	CommentDao dao=new CommentDaoImpl();
	//@Test
	public void testAdd() {
		comment.setcGname("菲律宾凤梨");
		comment.setcContent("你是傻逼吗");
		comment.setcDate("2016-3-4");
		comment.setcIp("192.169.31.243");
		comment.setcAuthor("晓风");
		dao.add(comment);
		
	}

	/**
	 * 测试更新评论   cGname=?,cContent=?,cDate=?,cIp=?,cAuthor=?) where cId=?
	 */
	//@Test
	public void testUpdate() {
		comment.setcGname("菲律宾凤梨");
		comment.setcContent("不好吃");
		comment.setcDate("2016-3-2");
		comment.setcIp("192.169.31.241");
		comment.setcAuthor("陈霞");
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
	
	//陈霞
	//@Test
		public void searchPage_Comment() {
			Page page=new Page(1,2);
			page.setTotalCount(30);
			System.out.println("有几页："+page.getPageCount());
			Comment comm=new Comment();
		List<Comment> listcom=dao.searchPage_Comment(comm, page.getPageNo(), page.getPageSize());
		for (Comment comment : listcom) {
			System.out.println(comment);
		}
					
					
				}
	//陈霞
	//@Test
	public void searchCommentCount() {
				System.out.println("记录总数:"+dao.searchCommentCount());
			
				
			}
	
	
	}


