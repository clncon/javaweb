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
            response.getWriter().write("��ǰʱ��[GET]Ϊ��"+new Date().toLocaleString());
            String username = request.getParameter("username");
            System.out.println("�û���[GET]��"+username);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.getWriter().write("��ǰʱ��[POST]Ϊ��"+new Date().toLocaleString());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("�û���[POST]��"+username);
		System.out.println("����[POST]:"+password);

	
	}

}
