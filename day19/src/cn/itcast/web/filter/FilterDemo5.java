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
		    //将request和response转成http类型的子类型
		    HttpServletRequest request = (HttpServletRequest) req;
		    HttpServletResponse response = (HttpServletResponse) res;
		    //取得访问的客户端url
		    String url = request.getRequestURI();
		    //判断url是否以.jsp结尾的，是就不能缓存，否则接能缓存
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
		    //放行资源
		    chain.doFilter(request, response);
           
	}

	
	

}
