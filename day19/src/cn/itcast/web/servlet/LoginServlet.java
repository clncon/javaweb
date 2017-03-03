package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            //取得用户输入的用户名和密码
		    String username = request.getParameter("username");
		    String password = request.getParameter("password");
		    
		    //验证用户名和密码
		    if(username!=null&&password!=null&&username.trim().length()>0&&password.trim().length()>0){
		    	if(username.equals("jack")&&password.equals("123")){
		    	//将用户名和密码存入Cookie中
		    	 Cookie cookie = new Cookie("usernameAndpassword",username+"_"+password);
		    	 cookie.setMaxAge(24*60);
		    	 response.addCookie(cookie);
		    	 //将用户信息存入Session中
		    	 request.getSession().setAttribute("username", username);
		    	 request.getSession().setAttribute("password", password);
		    	 //将页面转发到指定的jsp页面
		    	 request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		    	}
		    	
		    }
	}
}
