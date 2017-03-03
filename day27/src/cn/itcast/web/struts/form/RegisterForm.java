package cn.itcast.web.struts.form;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import cn.itcast.web.struts.domain.City;
import cn.itcast.web.struts.domain.Like;

  //�����ռ���
public class RegisterForm extends ActionForm {
	private String username;
	private String password1;
	private String password2;
	private String gender;
	private String birthday;
	private String income;
	private String city;
	private String[] likes;
	private String email;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String[] getLikes() {
		return likes;
	}
	public void setLikes(String[] likes) {
		this.likes = likes;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
		       //���ձ�����+���շ��ϸ�ʽ
		       if(birthday!=null&&birthday.trim().length()>0){
		    	   try {
					DateLocaleConverter dlc = new DateLocaleConverter(
							Locale.CHINA, "yyyy-MM-dd");
					dlc.convert(birthday);
				} catch (Exception e) {
					 ActionMessage message = new ActionMessage("���ڸ�ʽ����ȷ",false);
					   errors.add("birthday", message);
				}
		       }else{
		    	   ActionMessage message = new ActionMessage("���ձ�����",false);
		    	    errors.add("birthday", message);
		       }
		     //���������ϸ�ʽ+����
		       if(income!=null&&income.trim().length()>0){
		    	     if(!income.matches("[0-9]{4}")){
		    	    	 
		    	    	 ActionMessage message = new ActionMessage("�����ʽ����ȷ",false);
		    	    	 errors.add("income", message);
		    	     }
		       }else{
		    	   ActionMessage message = new ActionMessage("���������",false);
		    	   errors.add("income", message);
		       }
		       //���������+��ʽ��ȷ
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
		         //���б�����+������ö����
		        if(city!=null&&city.trim().length()>0){
		        	 try {
						City.valueOf(city);
					} catch (Exception e) {
						ActionMessage message = new ActionMessage("��ѡ���ö����",false);
			        	errors.add("email", message);
					}
		        }else{
		        	ActionMessage message = new ActionMessage("���б���ѡ",false);
		        	errors.add("city", message);
		        }
		        //���ñ���ѡ+��ö��ֵ��
		         if(likes!=null&&likes.length>0){
		        	   for(String like:likes){
		        		   try {
							Like.valueOf(like);
						} catch (Exception e) {
							ActionMessage message = new ActionMessage("���ò���ѡ����",false);
				        	errors.add("likes", message);
						}
		        	   }
		         }else{
		        	 ActionMessage message = new ActionMessage("���ñ���ѡ",false);
			        	errors.add("likes", message);
		         }
		   return errors;
	}
	
      
      
      
}
