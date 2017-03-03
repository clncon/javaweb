package cn.itcast.web.struts.form;



import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;





public class RegisterForm extends ActionForm {
      private String username;
      private String password;
      private String gender;
      private String city;
      private String[] likes;
      private String birthday;
      private String method;
      
      public RegisterForm(){
    	 //System.out.println("RegisterForm()");
      }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		//System.out.println("setUsername()");
		username = processEncode(username);
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		gender = processEncode(gender);
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		city = processEncode(city);
		this.city = city;
	}
	public String[] getLikes() {
		return likes;
	}
	
	public void setLikes(String[] likes) {
		String[] newLikes= new String[likes.length];
		 int i=0;
		for(String like:likes){
			like = processEncode(like);
			newLikes[i]=like;
			i++;
		}
		this.likes = newLikes;
	}
    
	

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		 this.method = request.getMethod();
		 if("POST".equalsIgnoreCase(this.method)){
			 try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// System.out.println("validate()");
		  //错误集合
		   ActionErrors errors = new ActionErrors();
		    //用户名必须填+英文加数字
		    if(username!=null&&username.trim().length()>0){
		    	  //判断用户填入的信息是否是英文和数字
		    	 if(!username.matches("[\u3400-\uFA29]+")){
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
		      if(password!=null&&password.trim().length()>0){
		    	    if(!password.matches("[0-9]{6}")){
		    	    	ActionMessage message = new ActionMessage("password.format",true);
		    	    	errors.add("password",message);
		    	    }
		    	    ;
		      }else{
		    	  ActionMessage message = new ActionMessage("password.required",true);
		    	  errors.add("password", message);
		      }
		      if(birthday!=null&&birthday.trim().length()>0){
		    	   DateLocaleConverter dlc = new DateLocaleConverter(Locale.CHINA, "yyyy-MM-dd");
		    	   try {
					dlc.convert(birthday);
				} catch (Exception e) {
					// TODO: handle exception
					ActionMessage message = new ActionMessage("生日格式不正确",false);
					errors.add("birthday", message);
				}
		      }else{
		    	  ActionMessage message = new ActionMessage("生日必须填",false);
		    	  errors.add("birthday", message);
		      }
		       
		   return errors;
	}
	  //用于将Get方式发送的表单编码
	private String processEncode(String argument) {
		if("GET".equalsIgnoreCase(this.method)){
			try {
				byte[] buff = argument.getBytes("ISO-8859-1");
				argument = new String(buff,"UTF-8");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return argument;
	}
      
}
