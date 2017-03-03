package cn.itcast.web.jdbc.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.itcast.web.jdbc.Service.userService;
import cn.itcast.web.jdbc.dao.Demo2;
import cn.itcast.web.jdbc.entity.Page;
import cn.itcast.web.jdbc.entity.User;

public class userServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String method =request.getParameter("method");
            if(method!=null){
            if("login".equals(method)){
            	this.login(request, response);
            }
            else if("register".equals(method)){
            	this.register(request, response);
            }
            else if("upload".equals(method)){
            	this.upload(request, response);
            }
            }
		
	}
	
	
	
	
	protected void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      String filepath = request.getParameter("filepath");
	      Demo2 demo2 = new Demo2();
	      boolean flag = demo2.write(filepath);
	      if(flag){
	    	  request.setAttribute("message", "写入成功");
	    	  request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	      }else{
	    	  request.setAttribute("message", "写入失败");
	    	  request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	      }
	}



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      this.fy(request, response);
	}
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     String username = request.getParameter("username");
		     String password = request.getParameter("password");
		     userService service = new userService();
		     boolean flag = service.login(username, password);
		     if(flag){
		    	  request.setAttribute("message", "登陆成功");
		    	 request.
		    	 getRequestDispatcher("/WEB-INF/message.jsp")
		    	 .forward(request, response);
		     }
		     else{
		    	  request.setAttribute("message", "登陆失败");
			    	 request.
			    	 getRequestDispatcher("/WEB-INF/message.jsp")
			    	 .forward(request, response);
		     }
	}


	
	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		ConvertUtils.register(new DateLocaleConverter(Locale.getDefault(),"yyyy-MM-dd")
		,java.util.Date.class);
		Enumeration<String> enumName = request.getParameterNames();
		while(enumName.hasMoreElements()){
                 String key =enumName.nextElement();
                 if(!key.equals("method")){
                 String[] values = request.getParameterValues(key);
                 try {
					BeanUtils.setProperty(user, key, values);
				} catch (Exception e) {
					
			      e.printStackTrace();
				}
            }
	}
		
		userService service = new userService();
		boolean flag = service.register(user);
		if(flag){
			request.setAttribute("message", "注册成功");
			request.getRequestDispatcher("/WEB-INF/message.jsp")
			.forward(request, response);
			
		}
		else{
			request.setAttribute("message", "注册失败");
			request.getRequestDispatcher("/WEB-INF/message.jsp")
			.forward(request, response);
		}
	}
     //分发页面
	protected void fy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     String page = request.getParameter("page");
		     if(page==null){
		    	 page="1";
		     }
		     int currPageNO= Integer.parseInt(page);
		    userService service = new userService();
		    Page pageNO = service.fy(currPageNO);
		    request.setAttribute("pageNO", pageNO);
		    request.getRequestDispatcher("/WEB-INF/fy.jsp").forward(request, response);
	}

	
	
}
