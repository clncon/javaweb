package cn.itcast.web.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  response.setContentType("text/html;charset = UTF-8");
		  response.getWriter().
		  write("ª∂”≠"+request.getSession().getAttribute("USERNAME")+"π‚¡Ÿ±æÕ¯’æ");
	}

}
