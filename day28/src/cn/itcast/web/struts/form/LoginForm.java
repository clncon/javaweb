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
		    //�û���������+Ӣ�ļ�����
		    if(username!=null&&username.trim().length()>0){
		    	  //�ж��û��������Ϣ�Ƿ���Ӣ�ĺ�����
		    	 if(!username.matches("[a-zA-Z0-9]+")){
		    		 ActionMessage message = new ActionMessage("�û�����������ĸ������",false);
		    		 errors.add("username", message);
		    	 }
		    	 ;
		    }else{
		    	 //�������Ϣ
		    	ActionMessage message = new ActionMessage("username.required",true);
		    	//��������Ϣ���뵽���󼯺���
		    	 errors.add("username", message);
		    }
		    if(email!=null&&email.trim().length()>0){
	        	if(!email.matches("\\w+@\\w+(\\.\\w+)+")){
	        		
	        		ActionMessage message = new ActionMessage("�����ʽ����ȷ",false);
	        		errors.add("email", message);
	        	}
	        }
	        else{
	        	ActionMessage message = new ActionMessage("���������",false);
	        	errors.add("email", message);
	        }
		return errors;
	}
     */
     
}
