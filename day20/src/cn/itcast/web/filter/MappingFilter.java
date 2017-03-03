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
		     ��Filter�п���ͨ��������Ӧ����Ϣ��ӳ����Ӧ������
		      REQUEST,FORWARD,INCLUDE�ȵ�
		      
		   */
	       System.out.println("mapping:doFilter:A");
	       chain.doFilter(request, response);
	       System.out.println("mapping:doFilter:B");
	       //request.getRequestDispatcher("/err_500.jsp").forward(request, response);
	       System.out.println("������Ϣ����д��....");

	}

	
	public void init(FilterConfig arg0) throws ServletException {
	

	}

}
