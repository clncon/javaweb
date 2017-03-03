package cn.itcast.web.decorator;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper{
    private HttpServletRequest request;
    /*
     * 注意装饰的设计指增强原来的方法，而不是去改变原来的方法
     * */
    public MyRequest(HttpServletRequest request){
    	super(request);
    	this.request=request;
    }
    public String getParameter(String name){
    	 String value=null;
    	 String method = request.getMethod();
    	 if("GET".equals(method)){
    		value = request.getParameter(name);//乱码
    	    byte[] buff;
			try {
				buff = value.getBytes("ISO8859-1");//解码
				value = new String(buff,"UTF-8");//按UTF-8编码
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else if("POST".equals(method)){
			 try {
				request.setCharacterEncoding("UTF-8");
				value = request.getParameter("username");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		 }
  
    	 
    	 return value;
    }
}
