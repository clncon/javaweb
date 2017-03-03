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

	 //��֤����������û���Ϣ
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
	  //��֤���������+��ʽ
	private boolean validateEmail(String email) {
		 boolean flag= false;
		 if(email!=null&&email.trim().length()>0){
			 if(email.matches("\\w+@\\w+(\\.\\w+)+")){
				 flag=true;
			 }else{
				 this.errors.put("email","<font color='red'>�����ʽ����ȷ</font>");
			 }
		 }else{
			 this.errors.put("email", "<font color='red'>���������</font>");
		 }
		return flag;
	}
     //���������+6λ����
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
    //�û�������+����
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
