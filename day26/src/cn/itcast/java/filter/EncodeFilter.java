package cn.itcast.java.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter {

	
	public void destroy() {
		

	}


	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		    HttpServletRequest request = (HttpServletRequest) req;
		    HttpServletResponse response = (HttpServletResponse) res;
		    MyRequest myrequest = new MyRequest(request);
	        chain.doFilter(myrequest.getProxy(), response);

	}

	
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
//�����������
class MyRequest {
	 //������Ķ���
	 HttpServletRequest request;
	 public MyRequest(HttpServletRequest request){
		 this.request = request;
	 }
	 //�õ�������Ķ���
	  public  HttpServletRequest getProxy(){
		 return (HttpServletRequest) Proxy.newProxyInstance(MyRequest.class.getClassLoader(), 
				                                             request.getClass().getInterfaces(),
				                                             new InvocationHandler() {
																
																
																public Object invoke(Object proxy, Method method, Object[] args)
																		throws Throwable {
																	 if("getParameter".equals(method.getName())){
																		 if("get".equalsIgnoreCase(request.getMethod())){
																			  //ȡ���������е�ֵ
																			 String value = request.getParameter((String)args[0]);
																			 //����iso8859-1��ʽ����
																			 byte[] buf = value.getBytes("iso8859-1");
																			 //��utf-8��ʽ����
																			 value = new String(buf,"utf-8");
																			 return value;
																		 }else if("post".equalsIgnoreCase(request.getMethod())){
																			 request.setCharacterEncoding("utf-8");
																			 String value = request.getParameter((String)args[0]);
																			 return value;
																		
																	 } 
																	 }else {
																		 return method.invoke(request, args);
																	 }
																	return null;
																}
															});
		  
	  } 
}