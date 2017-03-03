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
	       //放行到ShowServlet
	       chain.doFilter(request, myresponse);
	       ByteArrayOutputStream bout = new ByteArrayOutputStream();
	       byte[] data = myresponse.getBuff();
	       System.out.println("压缩前数据大小:"+data.length);
	       //压缩
	        GZIPOutputStream gzip = new GZIPOutputStream(bout);
	        gzip.write(data);
	        gzip.flush();
	        gzip.close();
	        
	        data = bout.toByteArray();
	        System.out.println("压缩后的数据的长度:"+data.length);
	        
	        
	        //输出压缩后的数据
	           //声明是压缩数据和压缩数据的长度
	           response.setHeader(" Content-Encoding","Gzip");
	           response.setHeader("Content-Length", data.length+"");
	        response.getOutputStream().write(data);

	}

	
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
