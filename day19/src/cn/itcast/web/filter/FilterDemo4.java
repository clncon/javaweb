package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo4 implements Filter {
     private FilterConfig  filterConfig;
	

     
	
	public void destroy() {
		
		
	}
    public void init(FilterConfig filterConfig) throws ServletException {
		 this.filterConfig=filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	        String encode = filterConfig.getInitParameter("encode");
	        //统一post请求和响应的编码方式
	        request.setCharacterEncoding(encode);
	        response.setContentType("text/html;charset="+encode);
	        chain.doFilter(request, response);
	}


	

}
