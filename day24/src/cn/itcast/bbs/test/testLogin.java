package cn.itcast.bbs.test;

import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.service.BbsService;

public class testLogin {

	
	public static void main(String[] args) throws Exception {
		
		User user = new User();
		user.setUsername("沈召权");
		user.setPassword("147654");
		BbsService bbs = new BbsService();
		user = bbs.login(user);
		if(user!=null){
			System.out.println(user.getUsername()+":"+user.getPassword());
		}else{
			System.out.println("无此用户");
		}

	}

}
