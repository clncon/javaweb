package cn.itcast.web.request;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.domain.modelBean;

public class Demo7 extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
           ServletContext context = this.getServletContext();
		    
		    //建立javaBean对象
		    String username = request.getParameter("username");
		     modelBean  mb = new modelBean();
		     if(mb.validate(username)){
		    	 context.setAttribute("USERNAME", username);
		    	 request.getRequestDispatcher("/listShow")
		    	 .forward(request, response);
		    	 
		     }
		     else{
		    	 
		    	 request.getRequestDispatcher("/WEB-INF/fail.html").forward(request, response);
		     }
		     
		     
		    
	
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //转发
	      request.getRequestDispatcher("/WEB-INF/view.html").forward(request, response);
	
	}
}
