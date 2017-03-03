package cn.itcast.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.itcast.web.struts.db.DB;
import cn.itcast.web.struts.form.LoginForm;

public class LoginAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   String path=null;
		    request.setCharacterEncoding("UTF-8");
		    LoginForm loginform = (LoginForm)form;
		    String username= loginform.getUsername();
		    String password1 = loginform.getPassword1();
		    String password2 = loginform.getPassword2();
		    boolean flag = DB.check(username,password1,password2);
		    if(flag){
		    	path="toSuccessJsp";
		    }
		    else{
		    	path="toFailJsp";
		    }
				return mapping.findForward(path);
		  
	}
     
}
