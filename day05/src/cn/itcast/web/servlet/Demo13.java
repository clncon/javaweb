package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo13 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter pw = response.getWriter();
	 pw.write("<form method = 'post',action = '#'>");
		 pw.write("�û���:"+"<input type = 'text',name = 'username'/><br/>");
		 pw.write("����:"+"<input type = 'password',name= 'userpassword'/><br/>");
		 pw.write("<select name = 'role'>");
		 pw.write("<option vlaue ='��ͨ�û�' selected>��ͨ�û�</option>");
		 pw.write("<option value = '����Ա'>����Ա</option>");
		 pw.write("</select>");
		 pw.write("<input type = 'submit' value = '�ύ'>");
		 pw.write("</form>");
		 
	}

}
