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
		//ʹ��getOutputStream()��ʾ����
		//response.getOutputStream().write("1".getBytes());
		//ʹ��getOutputStream()��ʾ����
		//response.getOutputStream().write("�Ǻ�".getBytes("UTF-8"));
		//ʹ��getWriter()��ʾ����
		response.setContentType("text/html;charset = UTF-8");
		response.getWriter().write("��Һ�");

	}

}
