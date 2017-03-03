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

		 //获取唯一的ServletContext对象
		ServletContext  context = this.getServletContext();
		//取得ServletContext对象中存储的数据
	    String username = (String) context.getAttribute("USERNAME");
	    response.getWriter().write(username);
	}

}
