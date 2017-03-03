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

public class CheckAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    //取得用户输入的参数
		   String username = request.getParameter("username");
		    //对用户数据进行解码
		      byte[] buf = username.getBytes("ISO-8859-1");
		      //对用户数据进行编码
		       username = new String(buf,"UTF-8");
		     //建立dao
		     UserDao userdao = new UserDao();
		      //判断用户是否存在
		    boolean flag =  userdao.check(username);
		     //创建错误集合
		     ActionErrors errors = new ActionErrors();
		     
		    if(flag){
		         ActionMessage message = new ActionMessage("该用户名已存在",false);
		                      errors.add("tip", message);
		    }else{
		    	
		    	ActionMessage message = new ActionMessage("该用户名可以注册",false);
		    	errors.add("tip", message);
		    }
		     this.saveErrors(request, errors);
		return mapping.findForward("toRegisterJsp");
	}
      
}
