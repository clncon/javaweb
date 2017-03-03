package cn.itcast.web.struts.form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
   private String username;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}
   
}
