package cn.itcast.web.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            System.out.println("AjaxServlet:doGet");
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            System.out.println("name:"+name);
            System.out.println("gender:"+gender);
            response.getWriter().write("success");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AjaxServlet:doPost");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		System.out.println("name:"+name);
		System.out.println("gender:"+gender);
		response.getWriter().write("success");

	}

}
