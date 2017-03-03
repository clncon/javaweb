package com.dream.biz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dream.biz.UserBiz;
import com.dream.biz.impl.UserBizImpl;
import com.dream.entity.User;

public class TestUserBizImpl {
       
	 UserBiz ub= new UserBizImpl();
	//@Test
	public void testAddUser() {
		
		 User user= new User();
		 user.setuName("ge");
		 user.setuPwd("222");
		 ub.addUser(user);
		   
	}

	//@Test
	public void testCheckUser() {
		    ub.loginUser("ge", "222");
	}
	//@Test
	public void testdeleteUser() {
		      ub.deleteUser("ge");
	}
	//@Test
	public void testUpdateUser() {
		 User user = new User();
		 
		 user.setuPwd("222222112");
		 user.setuId(11);
		ub.updateUser(user);
	}
	//@Test
	public void testSearchUflag() {
//		   System.out.println(ub.searchUflag(user, 2, 3)); 
	}
	//@Test
	public void testSearchUName() {
		  User user= ub.searchUser("≥¬œº");
		  System.out.println(user.toString());
	}
	/*
	 * ≤‚ ‘Id≤È—Ø”√ªß
	 */
	@Test
	public void testSearchuId() {
		
		System.out.println(ub.searchUser(11));
		
		}
	
}
