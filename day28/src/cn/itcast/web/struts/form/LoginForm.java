package cn.itcast.web.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {
     private String username;
     private String email;

     
      
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	/*public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		 ActionErrors errors = new ActionErrors();
		    //用户名必须填+英文加数字
		    if(username!=null&&username.trim().length()>0){
		    	  //判断用户填入的信息是否是英文和数字
		    	 if(!username.matches("[a-zA-Z0-9]+")){
		    		 ActionMessage message = new ActionMessage("用户名必须是字母加数字",false);
		    		 errors.add("username", message);
		    	 }
		    	 ;
		    }else{
		    	 //错误的信息
		    	ActionMessage message = new ActionMessage("username.required",true);
		    	//将错误信息加入到错误集合中
		    	 errors.add("username", message);
		    }
		    if(email!=null&&email.trim().length()>0){
	        	if(!email.matches("\\w+@\\w+(\\.\\w+)+")){
	        		
	        		ActionMessage message = new ActionMessage("邮箱格式不正确",false);
	        		errors.add("email", message);
	        	}
	        }
	        else{
	        	ActionMessage message = new ActionMessage("邮箱必须填",false);
	        	errors.add("email", message);
	        }
		return errors;
	}
     */
     
}
