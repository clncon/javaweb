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

import cn.itcast.web.decorator.MyRequest;

public class EncodingFilter implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		     HttpServletRequest request = (HttpServletRequest) req;
		     HttpServletResponse response = (HttpServletResponse) res;
		     
		       MyRequest myRequest = new MyRequest(request);
		       chain.doFilter(myRequest, response);
	}


	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

}
