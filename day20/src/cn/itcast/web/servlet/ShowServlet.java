package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           /* ServletOutputStream sout  = response.getOutputStream();
           sout.write("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA".getBytes());
		*/
           response.setContentType("text/html;charset=utf-8");
		   PrintWriter pw = response.getWriter();
		   pw.write("��������������������������������������������������������������������"+"</br>");
		   pw.write("�й��й��й��й��й��й��й��й��й��й��й��й��й��й��й��й��й�"+"</br>");
		   pw.write("Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��Ӣ��"+"</br>");
	}

}
