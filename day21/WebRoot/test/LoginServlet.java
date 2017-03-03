package cn.itcast.web.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
             String name = request.getParameter("username");
             HttpSession session = request.getSession();
             session.setAttribute("Name", name);
		     response.sendRedirect(request.getContextPath()+"/welcome.jsp");
	}

}
