package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MappingFilter implements Filter {


	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		  /*
		     在Filter中可以通过配置相应的信息来映射相应的请求
		      REQUEST,FORWARD,INCLUDE等等
		      
		   */
	       System.out.println("mapping:doFilter:A");
	       chain.doFilter(request, response);
	       System.out.println("mapping:doFilter:B");
	       //request.getRequestDispatcher("/err_500.jsp").forward(request, response);
	       System.out.println("错误信息正在写入....");

	}

	
	public void init(FilterConfig arg0) throws ServletException {
	

	}

}
