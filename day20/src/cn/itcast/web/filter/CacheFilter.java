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
	       //1.��ȡ�ͻ��˵�uri
		     String uri = request.getRequestURI();
		   //2.���ڴ���ȡ����Ӧ����Դ����
		     byte[] data = map.get(uri);
		      
		   //3.���û�еĻ�
		       if(data==null){
		    	   MyResponse myresponse = new MyResponse(response);
		    	   chain.doFilter(request, myresponse);
		    	   data = myresponse.getBuff();
		    	   map.put(uri, data);
		    	   System.out.println("�ӷ������л�ȡ");
		       }
		   //4.������ڵĻ������
		       response.getOutputStream().write(data);

	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
