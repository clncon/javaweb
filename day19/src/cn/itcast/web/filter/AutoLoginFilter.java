package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoLoginFilter implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		     //取得HTTP协议的请求和响应对象
		     HttpServletRequest request = (HttpServletRequest) req;
		     HttpServletResponse response = (HttpServletResponse) res;
		     String up=null;
		     
		     
		     //取得用户的Cookie
		     
		     Cookie[] cookies = request.getCookies();
		     //取得Cookie的值
              for(Cookie cookie:cookies){
            	 up = cookie.getValue();
            	     break;
            	  }
              String[] both = up.split("_");
        	  if(both[0].equals("jack")&&both[1].equals("123")){
        		  request.getSession().setAttribute("username", both[0]);
             
               
           
	}
        	//放行资源
        	   chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	

	}

}
