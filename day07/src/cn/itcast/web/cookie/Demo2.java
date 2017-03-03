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
		   //ȡ�ÿͻ��˵�Cookie
		   Cookie[] cookies = request.getCookies();
		   if(cookies==null){
			   //����Cookie
			   Cookie  cookie = new Cookie("name_"+name,System.currentTimeMillis()+"");
			   //����cookie������ʱ��
			   cookie.setMaxAge(1*24*60*60);
			   //����������cookie
			   response.addCookie(cookie);
			   //������Ӧ��Ϣ
			 
			   pw.write("��ӭ"+name+"�״η��ʱ���վ<br/>");
			   pw.write("����ʱ��Ϊ"+new Date().toLocaleString());
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
				   pw.write("��ӭ"+name+"�ٴη���<br/>");
				   pw.write("�ϴη���ʱ��:"+new Date(strtime).toLocaleString());
				   Cookie  cookie = new Cookie("name_"+name,System.currentTimeMillis()+"");
				   //����cookie������ʱ��
				   cookie.setMaxAge(1*24*60*60);
				   //����������cookie
				   response.addCookie(cookie);
			   }
			   
		   }

		
	}

}
