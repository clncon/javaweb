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

public class FilterDemo5 implements Filter {
     private FilterConfig filterConfig;

	public void destroy() {
	

	}

    public void init(FilterConfig filterConfig) throws ServletException {
		   this.filterConfig=filterConfig;

	     }
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		    //��request��responseת��http���͵�������
		    HttpServletRequest request = (HttpServletRequest) req;
		    HttpServletResponse response = (HttpServletResponse) res;
		    //ȡ�÷��ʵĿͻ���url
		    String url = request.getRequestURI();
		    //�ж�url�Ƿ���.jsp��β�ģ��ǾͲ��ܻ��棬������ܻ���
		    if(url!=null&&url.endsWith(".jsp")){
		    	response.setDateHeader("Expires", -1);
		    	response.setHeader("Cache-Control","no-cache");
		    	response.setHeader("Pragma","no-cache");
		    }else if(url!=null&&url.endsWith(".html")){
		    	String time = filterConfig.getInitParameter("time");
		      long totalTime = System.currentTimeMillis()+Long.parseLong(time)*1000;
		      response.setDateHeader("Expires", totalTime);
		      response.setHeader("Cache-Control", totalTime/1000+"");
		      response.setHeader("Pragma", totalTime/1000+"");
		    	
		    }
		    //������Դ
		    chain.doFilter(request, response);
           
	}

	
	

}
