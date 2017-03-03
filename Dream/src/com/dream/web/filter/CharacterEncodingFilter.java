package com.dream.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����ַ�����
 * @author Administrator
 * ����
 *  <filter> 
	 <filter-name>CharacterEncodingFilter</filter-name>
     <filter-class>com.dream.web.CharacterEncodingFilter</filter-class>	
	 </filter>
	<filter-mapping>
	<filter-name>CharacterEncodingFilter</filter-name>
	<url-pattern>/*</url-pattern>
	</filter-mapping>
 */
public class CharacterEncodingFilter extends HttpServlet implements Filter {
     
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		 HttpServletRequest request=(HttpServletRequest)req;      
		 HttpServletResponse response=(HttpServletResponse)res;
		 request.setCharacterEncoding("UTF-8");//�����ַ�����ΪUTF-8
		 response.setCharacterEncoding("UTF-8") ;
         // ����������
		// ��������������Ҫ һ����
		  fc.doFilter(req, res);
	}
     
	@Override
	public void init(FilterConfig fc) throws ServletException {
		        String strNum=fc.getInitParameter("pageNum");
		        System.out.println(strNum);
  
	}

}
