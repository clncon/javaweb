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

import cn.itcast.web.decorator.MyResponse;

public class ThransferFilter implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) req;
		 HttpServletResponse response = (HttpServletResponse) res;
		   MyResponse myresponse = new MyResponse(response); 
		 //放行资源
		   chain.doFilter(request, myresponse);
		   //获取数据
		   byte[] buff = myresponse.getBuff();
		   //将字节转换成字符串
		   String data = new String(buff,"UTF-8");
		   //判断字符串是否含有"中国"
		   if(data.contains("中国")){
			   //将中国替换成超连接
			   data = data.replaceAll("中国","<font size='44'><a href='#'" +
			   		"" +
			   		">中国</a></font>");
		   }
		   //输出
		     response.getWriter().write(data);
		   
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

}
