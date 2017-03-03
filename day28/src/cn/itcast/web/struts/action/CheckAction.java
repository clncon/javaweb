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
		    //ȡ���û�����Ĳ���
		   String username = request.getParameter("username");
		    //���û����ݽ��н���
		      byte[] buf = username.getBytes("ISO-8859-1");
		      //���û����ݽ��б���
		       username = new String(buf,"UTF-8");
		     //����dao
		     UserDao userdao = new UserDao();
		      //�ж��û��Ƿ����
		    boolean flag =  userdao.check(username);
		     //�������󼯺�
		     ActionErrors errors = new ActionErrors();
		     
		    if(flag){
		         ActionMessage message = new ActionMessage("���û����Ѵ���",false);
		                      errors.add("tip", message);
		    }else{
		    	
		    	ActionMessage message = new ActionMessage("���û�������ע��",false);
		    	errors.add("tip", message);
		    }
		     this.saveErrors(request, errors);
		return mapping.findForward("toRegisterJsp");
	}
      
}
