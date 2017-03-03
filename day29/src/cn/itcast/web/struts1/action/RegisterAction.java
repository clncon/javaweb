package cn.itcast.web.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.validator.DynaValidatorForm;

import cn.itcast.web.struts1.form.RegisterForm;

public class RegisterAction extends MappingDispatchAction {

	//用户注册
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	    System.out.println("用户注册!");
	    DynaValidatorForm dvf = (DynaValidatorForm) form;
	    
	    
                // int i = 10/0;    
	    
	     response.getWriter().write("用户名："+dvf.get("username")+"<br/>");
	     response.getWriter().write("密码："+dvf.get("password")+"<br/>");
	     response.getWriter().write("生日："+dvf.get("birthday")+"<br/>");
	     response.getWriter().write("邮箱："+dvf.get("email")+"<br/>");
	     response.getWriter().write("薪水："+dvf.get("salary")+"<br/>");
		return  mapping.findForward("toSuccessJsp");
	}
          
}
