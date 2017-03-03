package cn.itcast.xml.example1;

public class User {
	private String userName;
	private String userPassword;
	private static User user;
	private User(){
	}
	public static User getUser(){
		user  =  new User();
		return user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
