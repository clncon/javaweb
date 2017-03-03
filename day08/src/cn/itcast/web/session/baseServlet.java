package cn.itcast.web.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.domain.checkBean;

public class baseServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		  String username = request.getParameter("username");
		 //String password = request.getParameter("password");
		   if(new checkBean().vlidate(username)){
			   request.getSession();
				  request.setAttribute("USERNAME", username);
				  out.write("欢迎"+username+"光临主页");
				  out.write("<a href = '/day08/LogoutServlet'>退出系统</a>");
		   }
		   else
		   {
			   response.sendRedirect("/day08/Login.html");
		   }
		 
	}

}
