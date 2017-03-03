package cn.itcast.web.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   response.setContentType("text/html;charset=UTF-8");
		   PrintWriter pw =  response.getWriter();
		   String name = request.getParameter("name");
		   if(name==null)
		   {
			   name="default";
		   }
		   //取得客户端的Cookie
		   Cookie[] cookies = request.getCookies();
		   if(cookies==null){
			   //生成Cookie
			   Cookie  cookie = new Cookie("name_"+name,System.currentTimeMillis()+"");
			   //设置cookie的生存时间
			   cookie.setMaxAge(1*24*60*60);
			   //向服务器添加cookie
			   response.addCookie(cookie);
			   //设置响应信息
			 
			   pw.write("欢迎"+name+"首次访问本网站<br/>");
			   pw.write("访问时间为"+new Date().toLocaleString());
		   }
		   else
		   {
			   Cookie nameCookie = null;
			   for(Cookie c:cookies){
				   if(c.getName().equals("name_"+name)){
					   nameCookie = c;
					   break;
				   }
				   
			   }
			   if(nameCookie!=null){
				   Long strtime = Long.parseLong(nameCookie.getValue());
				   pw.write("欢迎"+name+"再次访问<br/>");
				   pw.write("上次访问时间:"+new Date(strtime).toLocaleString());
				   Cookie  cookie = new Cookie("name_"+name,System.currentTimeMillis()+"");
				   //设置cookie的生存时间
				   cookie.setMaxAge(1*24*60*60);
				   //向服务器添加cookie
				   response.addCookie(cookie);
			   }
			   
		   }

		
	}

}
