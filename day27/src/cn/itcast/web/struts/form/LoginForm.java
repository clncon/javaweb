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

	    //У�������
		public ActionErrors validate(ActionMapping mapping,
				HttpServletRequest request) {
			    //���󼯺�
			   ActionErrors errors = new ActionErrors();
			    //�û���������+Ӣ�ļ�����
			    if(username!=null&&username.trim().length()>0){
			    	  //�ж��û��������Ϣ�Ƿ���Ӣ�ĺ�����
			    	 if(!username.matches("[a-zA-Z0-9]+")){
			    		 ActionMessage message = new ActionMessage("username.format",true);
			    		 errors.add("username", message);
			    	 }
			    	 ;
			    }else{
			    	 //�������Ϣ
			    	ActionMessage message = new ActionMessage("username.required",true);
			    	//��������Ϣ���뵽���󼯺���
			    	 errors.add("username", message);
			    }
			    //���������+������������λ
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
			      //����2������+������������λ
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
