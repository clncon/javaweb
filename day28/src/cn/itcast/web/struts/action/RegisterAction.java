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
		      //判断是否是重复提交
		     if(this.isTokenValid(request)){
		    	 System.out.println("提交成功");
		    	 RegisterForm registerform =  (RegisterForm)form;
		    	 System.out.println("用户名:"+registerform.getUsername());
		    	 System.out.println("密码:"+registerform.getPassword());
		    	 System.out.println("性别:"+registerform.getGender());
		    	 System.out.println("城市:"+registerform.getCity());
		    	 System.out.print("爱好:");
		    	 for(String like:registerform.getLikes()){
		    		 System.out.println(like+"\t");
		    	 }
		    	 //将这个标示符从HttpSession中删除
		    	   this.resetToken(request);
		    	  
		    	   UserDao userdao = new  UserDao();
		    	    User user = new User();
		    	    //将registerForm中数据导入到user中
		    	   BeanUtils.copyProperties(user, registerform);
		    	  /* boolean flag = userdao.check(user);
		    	   ActionErrors errors = new ActionErrors();
		    	   if(flag){
		    		  // System.out.println("该用户存在数据库中");
		    		   ActionMessage message = new ActionMessage("该用户已经存在", false);
		    		   errors.add("tip", message);
		    	   }else{
		    		   //System.out.println("该用户不存在数据库中");
		    		   ActionMessage message = new ActionMessage("该用户可以注册", false);
		    		   errors.add("tip", message);
		    	   }
		    	    this.saveErrors(request, errors);*/
		    	   System.out.println("生日:"+user.getBirthday().toLocaleString());
		     }else{
		    	 
		    	 System.out.println("重复提交");
		     }
		     
		    return mapping.getInputForward();
	}
       
}
