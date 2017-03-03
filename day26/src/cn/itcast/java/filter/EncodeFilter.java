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
//创建代理的类
class MyRequest {
	 //被代理的对象
	 HttpServletRequest request;
	 public MyRequest(HttpServletRequest request){
		 this.request = request;
	 }
	 //得到被代理的对象
	  public  HttpServletRequest getProxy(){
		 return (HttpServletRequest) Proxy.newProxyInstance(MyRequest.class.getClassLoader(), 
				                                             request.getClass().getInterfaces(),
				                                             new InvocationHandler() {
																
																
																public Object invoke(Object proxy, Method method, Object[] args)
																		throws Throwable {
																	 if("getParameter".equals(method.getName())){
																		 if("get".equalsIgnoreCase(request.getMethod())){
																			  //取得请求体中的值
																			 String value = request.getParameter((String)args[0]);
																			 //按照iso8859-1方式解码
																			 byte[] buf = value.getBytes("iso8859-1");
																			 //按utf-8方式编码
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