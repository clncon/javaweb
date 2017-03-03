package cn.itcast.java.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GzipFileter implements Filter {

	
	public void destroy() {
		

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    MyResponse myresponse = new MyResponse(response);
	    chain.doFilter(request,myresponse.getProxy());
	    ByteArrayOutputStream bout = new ByteArrayOutputStream();
	    //取得缓存中的数据
	    byte[] buf = myresponse.getBytes();
	    //打印此时数据的长度
	     System.out.println("压缩前:"+buf.length);
	     //压缩数据
	     GZIPOutputStream gout = new GZIPOutputStream(bout);
	     gout.write(buf);
	     gout.flush();
	     gout.close();
	     //取得压缩数据
	      buf = bout.toByteArray();
	      System.out.println("压缩后:"+buf.length);
	      //在浏览器上显示数据
	      response.setHeader("Content-Encoding","gzip");
	      response.setHeader("Content-Length",buf.length+"");
	      response.getOutputStream().write(buf);
	      
	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
class MyResponse{
	private HttpServletResponse response;
	//缓存
	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
	public MyResponse(HttpServletResponse response){
		this.response = response;
	}
	public byte[] getBytes(){
		return bout.toByteArray();
	}
	public HttpServletResponse getProxy(){
		return (HttpServletResponse) Proxy.newProxyInstance
				(MyResponse.class.getClassLoader(), 
				 response.getClass().getInterfaces(),
				new InvocationHandler() {
					
					
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						 if("getOutputStream".equals(method.getName())){
							  return new MyServletOutPutStream(bout);
						 }
						 else{
							 return method.invoke(response, args);
						 }
					}
				});
	}
	
}
class MyServletOutPutStream extends ServletOutputStream{
	private ByteArrayOutputStream bout;
	public MyServletOutPutStream(ByteArrayOutputStream bout){
		this.bout=bout;
	}
	
	public void write(int b) throws IOException {
	
		
	}
public void write(byte[] buf) throws IOException {
	  bout.write(buf);
	  bout.flush();
		
	}
}