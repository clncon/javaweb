package cn.itcast.web.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.decorator.MyResponse;

public class CacheFilter implements Filter {
	private Map<String,byte[]> map =
			new LinkedHashMap<String,byte[]>();

	public void destroy() {
		

	}


	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
	       //1.获取客户端的uri
		     String uri = request.getRequestURI();
		   //2.从内存中取出对应的资源内容
		     byte[] data = map.get(uri);
		      
		   //3.如果没有的话
		       if(data==null){
		    	   MyResponse myresponse = new MyResponse(response);
		    	   chain.doFilter(request, myresponse);
		    	   data = myresponse.getBuff();
		    	   map.put(uri, data);
		    	   System.out.println("从服务器中获取");
		       }
		   //4.如果存在的话就输出
		       response.getOutputStream().write(data);

	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
