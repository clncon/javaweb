package cn.itcast.web.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.itcast.web.struts.form.LoginForm;
import cn.itcast.web.struts.form.RegisteForm;

public class RegisterAndLoginAction extends MappingDispatchAction {

	
	public ActionForward RegisterMethod(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   System.out.println("注册成功");
		  RegisteForm registerform = (RegisteForm) form;
		    System.out.println(registerform.getUsername());
		    System.out.println(registerform.getEmail());
		return null;
	}
     

	public ActionForward LoginMethod(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   System.out.println("登录成功");
		  LoginForm loginform = (LoginForm) form;
		  System.out.println(loginform.getUsername());
		return null;
	}
}
