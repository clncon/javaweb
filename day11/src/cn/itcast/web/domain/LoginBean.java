package cn.itcast.web.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LoginBean {
	private  Map<String,String> error = new LinkedHashMap<String,String>();
    private String username;
    private String password;
    private String email;
    
	public LoginBean(){}
    public Map<String, String> getError() {
		return error;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}

	public boolean vlidate(User user){
		boolean flag = false;
		username = user.getUsername();
		password = user.getPassword();
		email = user.getEmail();
		
		if(isvlidateUsername(username)&
		   isvlidatePassword(password)&
		   isvlidateEamil(email)){
			flag = true;
		}
		
		return flag;
		
	}
	private boolean isvlidateUsername(String username){
		boolean flag = false;
		if(username!=null&&username.trim().length()>0){
			if(username.matches("[\u3406-\uFA29]+")){
				flag = true;
			}
			else{
				error.put("username", "�û�����ʽ����ȷ");
			}
		}
			
	    else{
	    	  error.put("username", "�û�������");
	    }
		return flag;
	}
	private boolean isvlidatePassword(String password){
		boolean flag = false;
		if(password!=null&&password.trim().length()>0){
			if(password.matches("[0-9]{6}")){
				flag = true;
			}
			else{
				error.put("password", "�����������λ������");
			}
		}
			
	    else{
	    	  error.put("password", "���������");
	    }
		return flag;
	}
	private boolean isvlidateEamil(String email){
		boolean flag = false;
		if(email!=null&&email.trim().length()>0){
			if(email.matches("\\w+@\\w+(\\.\\w+)+")){
				flag = true;
			}
			else{
				error.put("email", "����ĸ�ʽ����ȷ");
			}
		}
			
	    else{
	    	  error.put("email", "���������");
	    }
		return flag;
	}
}
