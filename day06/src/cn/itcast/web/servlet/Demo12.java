package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo12 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 //��ȡΨһ��ServletContext����
		ServletContext  context = this.getServletContext();
		//ȡ��ServletContext�����д洢������
	    String username = (String) context.getAttribute("USERNAME");
	    response.getWriter().write(username);
	}

}
