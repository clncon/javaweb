package cn.itcast.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.itcast.web.struts.form.RegisterForm;

public class RegisterAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		   request.setCharacterEncoding("utf-8");
		  RegisterForm registerForm = (RegisterForm) form;
		    String username = registerForm.getUsername();
		    String password = registerForm.getPassword1();
		   System.out.println("用户名:"+username);
		   System.out.println("密码:"+password);
		   /*request.setAttribute("username", username);
		   request.setAttribute("password", password);*/
			/*	return new ActionForward("/success.jsp", false);*/
		   return mapping.findForward("toSuccessJsp");//这种方式需要在struts-config.xml中配置forward标签
		
	}
      
}
