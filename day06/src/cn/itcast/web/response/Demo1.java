package cn.itcast.web.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//使用getOutputStream()显示数字
		//response.getOutputStream().write("1".getBytes());
		//使用getOutputStream()显示汉字
		//response.getOutputStream().write("那好".getBytes("UTF-8"));
		//使用getWriter()显示中文
		response.setContentType("text/html;charset = UTF-8");
		response.getWriter().write("大家好");

	}

}
