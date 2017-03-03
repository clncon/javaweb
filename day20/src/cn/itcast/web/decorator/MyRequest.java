package cn.itcast.web.decorator;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper{
    private HttpServletRequest request;
    /*
     * ע��װ�ε����ָ��ǿԭ���ķ�����������ȥ�ı�ԭ���ķ���
     * */
    public MyRequest(HttpServletRequest request){
    	super(request);
    	this.request=request;
    }
    public String getParameter(String name){
    	 String value=null;
    	 String method = request.getMethod();
    	 if("GET".equals(method)){
    		value = request.getParameter(name);//����
    	    byte[] buff;
			try {
				buff = value.getBytes("ISO8859-1");//����
				value = new String(buff,"UTF-8");//��UTF-8����
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
