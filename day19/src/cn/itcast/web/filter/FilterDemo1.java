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
		    //�������ShowServlet��url�����أ�
		    // System.out.println("doFilter");
		     
		   /* ���е�ShowServlet,��������У���һֱ��filter�У�
		    ����filter�ǲ���������ҳ����,�ʺ����ױ�����*/
		      chain.doFilter(request, response);

	}


	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
