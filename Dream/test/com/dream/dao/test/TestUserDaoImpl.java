package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.comm.Page;
import com.dream.dao.UserDao;
import com.dream.dao.impl.UserDaoImpl;
import com.dream.entity.User;


/**
 * �û���Ϣ�Ĳ���
 * @author ��ҫ
 *2016-3-4����5:11:44
 */
public class TestUserDaoImpl {
       
	   UserDao dao= new UserDaoImpl();
	   User user= new User();
	//@Test
	/*
	 * ��������û���Ϣ
	 */
	public void testAdd() {
//		User user= new User("gerui", "12313", "��", "1992.12.13", "123123", "12@qq.com", "���պϷ�", "normal", "VIP1");		     
		
	//	dao.add(user);
	}

	@Test
    /*
     * ����ɾ���û���Ϣ
     */
	public void testDelete() {
		
	//	dao.delete("gerui");
		dao.delete(30);
	}

	//@Test
	/*
	 * ���Ը����û���Ϣ
	 * 
	 */
	public void testUpdate() {
		  user.setuPwd("999");
		  user.setSex("��");
		  user.setuId(11);
		  user.setuBir("23123");
		  user.setuFlag("0");
		  dao.update(user);
		
//		 user.setuName("kxl");
//		 user.setuPwd("55555");
//		 user.setuFlag("������");
//		 user.setSex("Ů");
//		 user.setuAddress("������");
//		 user.setuBir("������");
//		 user.setuLevel("vip����");
//		 user.setuPhone("������");
//		 user.setuMail("������");
//		 user.setuId(12);
//		 dao.update(user);
	}

	//@Test
	/*
	 * ���Բ�ѯ�����û�
	 */
	public void testSearch() {
//		List<User> list=dao.search();
//		for (User user : list) {
//			System.out.println(user.toString());
//		}
//		
	}

	//@Test
	/*
	 * �������û�����ѯ�û�
	 */
	public void testSearchUser() {

   User user = dao.searchUser("��ϼ");		 
      System.out.println(user.toString());
	
	}


	@Test
	/*
	 * ���Է�ҳ    ������
	 */
	public void testsearchPage_User(){
		Page page=new Page(0,2);
		User user=new User();
		user.setuFlag("1");
//		user.setuPhone("1806030227");
		
		System.out.println("dfd"+dao.searchCount(user));
		page.setTotalCount(dao.searchCount(user));
//		List<User> list= dao.searchPage_User(page.getPageNo(), page.getPageSize());	
//		for (User user : list) {
//			System.out.println(user.toString());
//		}
		System.out.println("dfsdf");
		
		List<User> list=dao.searchUflag(user, page.getPageNo(), page.getPageSize());
		System.out.println(list.toString());
		for (User user1 : list) {
		System.out.println("gfhgf"+user1.toString());
	}
	}
	
	/*
	 * ������ҳ��     ������
	 */
	//@Test
	public void testsearchUserCount(){
		
		System.out.println("�����ܵ��û�����"+dao.searchCount(user));
	}
	/*
	 * ����Ȩ�޲�ѯ�û�
	 */
	//@Test
	public void testSearchUflag() {

//		//System.out.println(dao.searchUflag(1, 2, 3));
//		List<User> user=dao.searchUflag(1, 2, 1);
//		for (User user2 : user) {
//			System.out.println(user2);
//		}
//		
		}
	/*
	 * ����Id��ѯ�û�
	 */
	//@Test
	public void testSearchuId() {

		System.out.println(dao.searchUser(11));
		
		}
}
