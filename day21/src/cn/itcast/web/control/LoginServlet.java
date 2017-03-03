package cn.itcast.web.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		if(username!=null && username.trim().length()>0){
			HttpSession session = request.getSession();
			//将用户名绑定到HttpSession中,事件触发
			session.setAttribute("username",username);
			response.sendRedirect(request.getContextPath()+"/welcome.jsp");
		}
	}
}
