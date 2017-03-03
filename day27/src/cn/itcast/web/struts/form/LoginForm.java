package cn.itcast.web.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;



public class LoginForm extends ActionForm {

   

	private String username;
    private String password1;
    private String password2;
    
    public LoginForm(){}
    
    public String getUsername() {
    	return username;
    }
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	    //校验表单数据
		public ActionErrors validate(ActionMapping mapping,
				HttpServletRequest request) {
			    //错误集合
			   ActionErrors errors = new ActionErrors();
			    //用户名必须填+英文加数字
			    if(username!=null&&username.trim().length()>0){
			    	  //判断用户填入的信息是否是英文和数字
			    	 if(!username.matches("[a-zA-Z0-9]+")){
			    		 ActionMessage message = new ActionMessage("username.format",true);
			    		 errors.add("username", message);
			    	 }
			    	 ;
			    }else{
			    	 //错误的信息
			    	ActionMessage message = new ActionMessage("username.required",true);
			    	//将错误信息加入到错误集合中
			    	 errors.add("username", message);
			    }
			    //密码必须填+必须是数字六位
			      if(password1!=null&&password1.trim().length()>0){
			    	    if(!password1.matches("[0-9]{6}")){
			    	    	ActionMessage message = new ActionMessage("password.format",true);
			    	    	errors.add("password1",message);
			    	    }
			    	    ;
			      }else{
			    	  ActionMessage message = new ActionMessage("password.required",true);
			    	  errors.add("password1", message);
			      }
			      //密码2必须填+必须是数字六位
			      if(password2!=null&&password2.trim().length()>0){
			    	    if(password2.matches("[0-9]{6}")){
			    	    	if(!password2.equals(password1)){
			    	    		ActionMessage message = new ActionMessage("password.compare",true);
			    	    		errors.add("password2", message);
			    	    	}
			    	    	;
			    	    }else{
			    	    	ActionMessage message = new ActionMessage("password.format",true);
			    	    	errors.add("password2",message);
			    	    }
			    	    ;
			      }else{
			    	  ActionMessage message = new ActionMessage("password.required",true);
			    	  errors.add("password2", message);
			      }
			   return errors;
		}
}
