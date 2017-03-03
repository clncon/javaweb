package cn.itcast.web.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     //服务端产生Cookie
             /*Cookie cookie = new Cookie("username","jack");
             //设置Cookie的生存时间
             cookie.setMaxAge(1*24*60*60);
             //向服务端添加Cookie
          
             response.addCookie(cookie);*/
          /* String name = cookie.getName();
             String value = cookie.getValue();
             String comment = cookie.getComment();
             String domain = cookie.getDomain();
             String path = cookie.getPath();
             int  maxAge = cookie.getMaxAge();
             int  version = cookie.getVersion();
             boolean secure = cookie.getSecure();
             PrintWriter pw = response.getWriter();
             pw.write("name:"+name+"<br/>");
             pw.write("value:"+value+"<br/>");
             pw.write("comment:"+comment+"<br/>");
             pw.write("domain:"+domain+"<br/>");
             pw.write("path:"+path+"<br/>");
             pw.write("maxAge:"+maxAge+"<br/>");
             pw.write("version:"+version+"<br/>");
             pw.write("secure:"+secure+"<br/>");*/
             Cookie[] cookies = request.getCookies();
             Cookie usernameCookie = null;
             for(Cookie c:cookies){
            	 if(c.getName().equals("username")){
            		 usernameCookie = c;
            		 break;
            	 }
            	
            	 }
             if(usernameCookie!=null){
        		 System.out.println("name:"+ usernameCookie.getName());
                 System.out.println("value:"+ usernameCookie.getValue());
                 System.out.println("path"+ usernameCookie.getPath());
                 System.out.println("maxAge"+ usernameCookie.getMaxAge());
            	 
             }
            
             
	
	}

}
