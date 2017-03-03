package cn.itcast.xml.example1;

import java.util.Scanner;

public class LogingUI {
	public User input(){
		User user  = User.getUser();
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("用户名：");
	    String userName = scanner.nextLine();
	    System.out.print("密码：");
	    String userPassword = scanner.nextLine();
	    user.setUserName(userName);
	    user.setUserPassword(userPassword);
	    return user;
	     
	}
	public void output(boolean flag){
		if(flag){
			System.out.println("登陆成功！");
		}
		else{
			System.out.println("登录失败！");
		}
	}
	

}
