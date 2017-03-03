package cn.itcast.bbs.form;

import java.util.HashMap;
import java.util.Map;

import cn.itcast.bbs.domain.User;

public class RegisterForm {
	private String username ;
	private String password ;
	private String gender;
	private String email; 
	private Map<String,String> errors = new HashMap<String,String>();
	
	public RegisterForm(User user){
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.gender = user.getGender();
		this.email = user.getEmail();
	}

	 //验证所有输入的用户信息
	 public boolean Validate(){
		 boolean flag = false;
		   flag= this.validateEmail(email);
		     if(
				 this.validateName(username)&
				 this.validatePassword(password)&
				 this.validateEmail(email)
				 )
		     {
			 flag=true;
		     }
		 return flag;
	 }
	  //验证邮箱必须填+格式
	private boolean validateEmail(String email) {
		 boolean flag= false;
		 if(email!=null&&email.trim().length()>0){
			 if(email.matches("\\w+@\\w+(\\.\\w+)+")){
				 flag=true;
			 }else{
				 this.errors.put("email","<font color='red'>邮箱格式不正确</font>");
			 }
		 }else{
			 this.errors.put("email", "<font color='red'>邮箱必须填</font>");
		 }
		return flag;
	}
     //密码必须填+6位数字
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
    //用户名必填+中文
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

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
    
}
