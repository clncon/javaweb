package cn.itcast.web.struts.action;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import cn.itcast.web.struts.dao.UserDao;
import cn.itcast.web.struts.domain.User;
import cn.itcast.web.struts.form.RegisterForm;

public class RegisterAction extends Action {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		     request.setCharacterEncoding("UTF-8");
		      //�ж��Ƿ����ظ��ύ
		     if(this.isTokenValid(request)){
		    	 System.out.println("�ύ�ɹ�");
		    	 RegisterForm registerform =  (RegisterForm)form;
		    	 System.out.println("�û���:"+registerform.getUsername());
		    	 System.out.println("����:"+registerform.getPassword());
		    	 System.out.println("�Ա�:"+registerform.getGender());
		    	 System.out.println("����:"+registerform.getCity());
		    	 System.out.print("����:");
		    	 for(String like:registerform.getLikes()){
		    		 System.out.println(like+"\t");
		    	 }
		    	 //�������ʾ����HttpSession��ɾ��
		    	   this.resetToken(request);
		    	  
		    	   UserDao userdao = new  UserDao();
		    	    User user = new User();
		    	    //��registerForm�����ݵ��뵽user��
		    	   BeanUtils.copyProperties(user, registerform);
		    	  /* boolean flag = userdao.check(user);
		    	   ActionErrors errors = new ActionErrors();
		    	   if(flag){
		    		  // System.out.println("���û��������ݿ���");
		    		   ActionMessage message = new ActionMessage("���û��Ѿ�����", false);
		    		   errors.add("tip", message);
		    	   }else{
		    		   //System.out.println("���û����������ݿ���");
		    		   ActionMessage message = new ActionMessage("���û�����ע��", false);
		    		   errors.add("tip", message);
		    	   }
		    	    this.saveErrors(request, errors);*/
		    	   System.out.println("����:"+user.getBirthday().toLocaleString());
		     }else{
		    	 
		    	 System.out.println("�ظ��ύ");
		     }
		     
		    return mapping.getInputForward();
	}
       
}
