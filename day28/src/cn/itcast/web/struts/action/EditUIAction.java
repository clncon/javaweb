package cn.itcast.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.itcast.web.struts.dao.UserDao;
import cn.itcast.web.struts.domain.Student;
import cn.itcast.web.struts.form.LoginForm;

public class EditUIAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    //ȡ��LoginForm
		    LoginForm loginForm = (LoginForm) form;
		    //������ݿ��е����ݲ���װ��Student
		    UserDao userdao = new UserDao();
		     Student student = userdao.findStudentById(1);
		     //��bean�е�����һ���Ե��뵽LoginForm��
		      BeanUtils.copyProperties(loginForm, student);
		return mapping.findForward("toEditJsp");
	}
       
}
