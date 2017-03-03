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

  //参数收集器
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
		       //生日必须填+生日符合格式
		       if(birthday!=null&&birthday.trim().length()>0){
		    	   try {
					DateLocaleConverter dlc = new DateLocaleConverter(
							Locale.CHINA, "yyyy-MM-dd");
					dlc.convert(birthday);
				} catch (Exception e) {
					 ActionMessage message = new ActionMessage("日期格式不正确",false);
					   errors.add("birthday", message);
				}
		       }else{
		    	   ActionMessage message = new ActionMessage("生日必须填",false);
		    	    errors.add("birthday", message);
		       }
		     //收入必须符合格式+必填
		       if(income!=null&&income.trim().length()>0){
		    	     if(!income.matches("[0-9]{4}")){
		    	    	 
		    	    	 ActionMessage message = new ActionMessage("收入格式不正确",false);
		    	    	 errors.add("income", message);
		    	     }
		       }else{
		    	   ActionMessage message = new ActionMessage("收入必须填",false);
		    	   errors.add("income", message);
		       }
		       //邮箱必须填+格式正确
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
		         //城市必须填+城市在枚举中
		        if(city!=null&&city.trim().length()>0){
		        	 try {
						City.valueOf(city);
					} catch (Exception e) {
						ActionMessage message = new ActionMessage("所选项不在枚举中",false);
			        	errors.add("email", message);
					}
		        }else{
		        	ActionMessage message = new ActionMessage("城市必须选",false);
		        	errors.add("city", message);
		        }
		        //爱好必须选+在枚举值中
		         if(likes!=null&&likes.length>0){
		        	   for(String like:likes){
		        		   try {
							Like.valueOf(like);
						} catch (Exception e) {
							ActionMessage message = new ActionMessage("爱好不在选项中",false);
				        	errors.add("likes", message);
						}
		        	   }
		         }else{
		        	 ActionMessage message = new ActionMessage("爱好必须选",false);
			        	errors.add("likes", message);
		         }
		   return errors;
	}
	
      
      
      
}
