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
	  //��֤�û�������
	 public boolean validate(){
		 boolean flag = false;
		 if(this.validateName(username)&
		  this.validatePassword(password)){
			 flag=true;
		 }
		 return flag;
	 }
	  //��֤�û�������
	private boolean validatePassword(String password) {
		boolean flag = false;
		 if(password!=null&&password.trim().length()>0){
			 if(password.matches("[0-9]{6}")){
				 flag=true;
			 }else{
				 this.errors.put("password", "<font color='red'>���������6λ������</font>");
			 }
		 }else{
			 this.errors.put("password", "<font color='red'>���������</font>");
		 }
		return flag;
	}
	 //��֤�û����û���
	private boolean validateName(String username) {
		 boolean flag=false;
		 if(username!=null&&username.trim().length()>0){
			 if(username.matches("[\u4E00-\uFA29]+")){
				 flag=true;
			 }
			 else{
				 this.errors.put("username","<font color='red'>�û�������������</font>");
			 }
		 }else{
			 
			 this.errors.put("username", "<font color='red'>�û�����Ϣ������</font>");
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
