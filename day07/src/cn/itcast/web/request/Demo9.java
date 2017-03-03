package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo9 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/common/head.html")
		.include(request, response);
		response.getOutputStream().write("<hr/>".getBytes());
		response.getOutputStream().write("我是主体内容".getBytes("UTF-8"));
		response.getOutputStream().write("<hr/>".getBytes());
		request.getRequestDispatcher("/common/foot.html")
		.include(request, response);
		response.getOutputStream().write("<hr/>".getBytes());
		
             
	}

}
