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
		 /* Filter����������
		  1.init()�ڴ���Filterʱִ��һ�Σ��Ժ�ִ��
		  2.doFilter()��ÿ�η��ʱ����ص�Servletʱִ��һ�Σ�ִ�ж��
		  3.destroy()������Filterʱִ��һ�Σ����಻ִ��*/
		  System.out.println("doFilter");
         chain.doFilter(request,response);
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		 System.out.println("init");

	}

}
