package cn.itcast.java.phone2web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Server extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  response.setContentType("text/html;charset=GBK");
            response.getWriter().write("当前时间[GET]为："+new Date().toLocaleString());
            String username = request.getParameter("username");
            System.out.println("用户名[GET]："+username);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getWriter().write("当前时间[POST]为："+new Date().toLocaleString());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("用户名[POST]："+username);
		System.out.println("密码[POST]:"+password);

	
	}

}
