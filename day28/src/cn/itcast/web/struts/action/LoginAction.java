package cn.itcast.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import cn.itcast.web.struts.dao.UserDao;

public class LoginAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 //获得用户请求的数据
		  String username= request.getParameter("username");
		  String email = request.getParameter("email");
		  UserDao dao = new UserDao();
		  boolean flag = dao.check(username, email);
		  ActionErrors errors = new ActionErrors();
		   
             if(flag){
                   ActionMessage message = new ActionMessage("image/MsgError.gif",false);
                         errors.add("tip", message);                 
             }else{
            	 ActionMessage message = new ActionMessage("image/MsgSent.gif",false);
            	 errors.add("tip", message);
             }
              this.saveErrors(request, errors);
		  return mapping.getInputForward();
	}
    
}
