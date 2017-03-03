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

	//�û�ע��
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
	    System.out.println("�û�ע��!");
	    DynaValidatorForm dvf = (DynaValidatorForm) form;
	    
	    
                // int i = 10/0;    
	    
	     response.getWriter().write("�û�����"+dvf.get("username")+"<br/>");
	     response.getWriter().write("���룺"+dvf.get("password")+"<br/>");
	     response.getWriter().write("���գ�"+dvf.get("birthday")+"<br/>");
	     response.getWriter().write("���䣺"+dvf.get("email")+"<br/>");
	     response.getWriter().write("нˮ��"+dvf.get("salary")+"<br/>");
		return  mapping.findForward("toSuccessJsp");
	}
          
}
