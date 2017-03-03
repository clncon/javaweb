package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		    //这里访问ShowServlet的url被拦截，
		    // System.out.println("doFilter");
		     
		   /* 放行到ShowServlet,如果不放行，则一直在filter中，
		    由于filter是不会显现在页面中,故很容易被忽略*/
		      chain.doFilter(request, response);

	}


	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
