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

public class FilterDemo7 implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		   HttpServletRequest request = (HttpServletRequest) req;
		   HttpServletResponse response = (HttpServletResponse) res;
		   
		   request.setCharacterEncoding("UTF-8");
		   
		   String username=request.getParameter("username");
		   String password = request.getParameter("password");
		   String user = request.getParameter("user");
		   
		   if(username!=null&&password!=null&&username.trim().length()>0&&password.trim().length()>0){
			    if(user.equals("admin")){
			    	request.setAttribute("message","欢迎管理员<font color='red'>"+username+"</font>");
			    	request.setAttribute("flag", "admin");
			    	
			    }else 
			    {
			    	request.setAttribute("message","欢迎一般用户<font color='red'>"+username+"</font>");
			    	request.setAttribute("flag", "user");
			    }
			    chain.doFilter(request, response);
		   }
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
