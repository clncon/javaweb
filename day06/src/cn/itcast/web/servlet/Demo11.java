package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo11 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            //��ÿͻ��˵�����Ĳ���
		 String username = (String) request.getParameter("username");
		    //ȡ��Ψһ��ServletContext����
		 ServletContext context = this.getServletContext();
		 context.setAttribute("USERNAME", username);
		
	}

}
