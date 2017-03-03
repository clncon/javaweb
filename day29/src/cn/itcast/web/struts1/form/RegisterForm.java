package cn.itcast.web.struts1.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class RegisterForm extends ValidatorForm {
     private String username;
     private String password;
     
     public RegisterForm(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 //ÑéÖ¤Ä£¿é
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
	    System.out.println("validate:registerForm");
		return super.validate(arg0, arg1);
	}
     
     
}
