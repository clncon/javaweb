package cn.itcast.bbs.form;

import java.util.HashMap;
import java.util.Map;

import cn.itcast.bbs.domain.User;

public class LoginForm {
	 private String username;
	 private String password;
	 private  Map<String,String> errors= new HashMap<String,String>();
	 public LoginForm(User user){
		 this.username = user.getUsername();
		 this.password=user.getPassword();
		 
	 }
	  //验证用户的输入
	 public boolean validate(){
		 boolean flag = false;
		 if(this.validateName(username)&
		  this.validatePassword(password)){
			 flag=true;
		 }
		 return flag;
	 }
	  //验证用户的密码
	private boolean validatePassword(String password) {
		boolean flag = false;
		 if(password!=null&&password.trim().length()>0){
			 if(password.matches("[0-9]{6}")){
				 flag=true;
			 }else{
				 this.errors.put("password", "<font color='red'>密码必须是6位的数字</font>");
			 }
		 }else{
			 this.errors.put("password", "<font color='red'>密码必须填</font>");
		 }
		return flag;
	}
	 //验证用户的用户名
	private boolean validateName(String username) {
		 boolean flag=false;
		 if(username!=null&&username.trim().length()>0){
			 if(username.matches("[\u4E00-\uFA29]+")){
				 flag=true;
			 }
			 else{
				 this.errors.put("username","<font color='red'>用户名必须是中文</font>");
			 }
		 }else{
			 
			 this.errors.put("username", "<font color='red'>用户名信息必须填</font>");
		 }
		return flag;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	 

}
