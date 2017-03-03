package cn.itcast.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.decorator.MyResponse;

public class GzipFilter implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
	       HttpServletRequest request = (HttpServletRequest) req;
	       HttpServletResponse response = (HttpServletResponse) res;
	       
	       MyResponse myresponse =  new MyResponse(response);
	       //���е�ShowServlet
	       chain.doFilter(request, myresponse);
	       ByteArrayOutputStream bout = new ByteArrayOutputStream();
	       byte[] data = myresponse.getBuff();
	       System.out.println("ѹ��ǰ���ݴ�С:"+data.length);
	       //ѹ��
	        GZIPOutputStream gzip = new GZIPOutputStream(bout);
	        gzip.write(data);
	        gzip.flush();
	        gzip.close();
	        
	        data = bout.toByteArray();
	        System.out.println("ѹ��������ݵĳ���:"+data.length);
	        
	        
	        //���ѹ���������
	           //������ѹ�����ݺ�ѹ�����ݵĳ���
	           response.setHeader(" Content-Encoding","Gzip");
	           response.setHeader("Content-Length", data.length+"");
	        response.getOutputStream().write(data);

	}

	
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
