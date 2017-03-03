package com.xsgl.web.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xsgl.web.exception.NoRootException;
import com.xsgl.web.service.loginService;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //访问该servlet直接转发到登录页面
         request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //将登录提交的页面分发到login方法中
            String method = request.getParameter("method");
            if("Login".equals(method)){
            	this.Login(request, response);
            	
            }
		
	}



	protected void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		  //取得输入的用户名和密码
		 String rootName = request.getParameter("rootName");
         String rootPassword = request.getParameter("rootPassword");
          loginService loginService = new loginService();
              
			try {
				boolean flag = loginService.checkRoot(rootName, rootPassword);
				  //如果存在该用户，转发到学生信息管理的界面
				if(flag){
				   request.getRequestDispatcher("/WEB-INF/jsp/XSGL.jsp").forward(request, response);
				}
				else{
					 //如果不存在该管理员用户，则转发到错误处理页面
					request.setAttribute("message","你输入的有户名和密码不存在");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				}
			
			}catch(Exception e){
				e.printStackTrace();
				//如果不存在该管理员用户，则转发到错误处理页面
				request.setAttribute("message","你输入的有户名和密码不存在");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
		  
	}
    
}
