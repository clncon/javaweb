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
		 //������Դ
		   chain.doFilter(request, myresponse);
		   //��ȡ����
		   byte[] buff = myresponse.getBuff();
		   //���ֽ�ת�����ַ���
		   String data = new String(buff,"UTF-8");
		   //�ж��ַ����Ƿ���"�й�"
		   if(data.contains("�й�")){
			   //���й��滻�ɳ�����
			   data = data.replaceAll("�й�","<font size='44'><a href='#'" +
			   		"" +
			   		">�й�</a></font>");
		   }
		   //���
		     response.getWriter().write(data);
		   
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

}
