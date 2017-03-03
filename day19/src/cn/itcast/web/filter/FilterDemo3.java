package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo3 implements Filter {


	public void destroy() {
		
      System.out.println("destory");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 /* Filter的生命周期
		  1.init()在创建Filter时执行一次，以后不执行
		  2.doFilter()在每次访问被拦截的Servlet时执行一次，执行多次
		  3.destroy()在销毁Filter时执行一次，其余不执行*/
		  System.out.println("doFilter");
         chain.doFilter(request,response);
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		 System.out.println("init");

	}

}
