package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterDemo6 implements Filter {

	
	public void destroy() {
		

	}

	
	


	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse)res;
	        
	        //获得request的密码
	         String username = request.getParameter("username");
	         String password = request.getParameter("password");
	         if(username!=null&&password!=null){
	        	if(username.equals("jack")&&password.equals("123456")){
	        		 chain.doFilter(request, response);
	        	}
	        	else{
	        		request.setAttribute("message","用户名或密码不正确");
	        		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request,response);
	        		
	        	}
	        	
	         }else 
	        	 {
	        	 request.setAttribute("message","用户名或密码不能为空");
	        	 request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request,response);
	        	 }
	}





	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

}
