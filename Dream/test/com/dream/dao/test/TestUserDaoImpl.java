package com.dream.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.dream.comm.Page;
import com.dream.dao.UserDao;
import com.dream.dao.impl.UserDaoImpl;
import com.dream.entity.User;


/**
 * 用户信息的测试
 * @author 建耀
 *2016-3-4下午5:11:44
 */
public class TestUserDaoImpl {
       
	   UserDao dao= new UserDaoImpl();
	   User user= new User();
	//@Test
	/*
	 * 测试添加用户信息
	 */
	public void testAdd() {
//		User user= new User("gerui", "12313", "男", "1992.12.13", "123123", "12@qq.com", "安徽合肥", "normal", "VIP1");		     
		
	//	dao.add(user);
	}

	@Test
    /*
     * 测试删除用户信息
     */
	public void testDelete() {
		
	//	dao.delete("gerui");
		dao.delete(30);
	}

	//@Test
	/*
	 * 测试更改用户信息
	 * 
	 */
	public void testUpdate() {
		  user.setuPwd("999");
		  user.setSex("男");
		  user.setuId(11);
		  user.setuBir("23123");
		  user.setuFlag("0");
		  dao.update(user);
		
//		 user.setuName("kxl");
//		 user.setuPwd("55555");
//		 user.setuFlag("。。。");
//		 user.setSex("女");
//		 user.setuAddress("。。。");
//		 user.setuBir("。。。");
//		 user.setuLevel("vip两万");
//		 user.setuPhone("。。。");
//		 user.setuMail("。。。");
//		 user.setuId(12);
//		 dao.update(user);
	}

	//@Test
	/*
	 * 测试查询所有用户
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
	 * 测试用用户名查询用户
	 */
	public void testSearchUser() {

   User user = dao.searchUser("陈霞");		 
      System.out.println(user.toString());
	
	}


	@Test
	/*
	 * 测试分页    林兴鹏
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
	 * 测试总页数     林兴鹏
	 */
	//@Test
	public void testsearchUserCount(){
		
		System.out.println("测试总的用户数："+dao.searchCount(user));
	}
	/*
	 * 测试权限查询用户
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
	 * 测试Id查询用户
	 */
	//@Test
	public void testSearchuId() {

		System.out.println(dao.searchUser(11));
		
		}
}
