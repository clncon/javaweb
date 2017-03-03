package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo2 implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		    //Filter的调用顺序和xml的配置顺寻有关
		    //System.out.println("dofilter2");
		    chain.doFilter(request, response);

	}


	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

}
