package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//获取表单数据，要对表单数据做是否为空和是否为空串的判断
public class Demo5 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     //post方式解决中文乱码的问题
		      request.setCharacterEncoding("UTF-8");
		     String username = request.getParameter("username");
		     String password = request.getParameter("password");
		     String gender =  request.getParameter("gender");
		     String[] likes = request.getParameterValues("likes");
		     String filepath = request.getParameter("upfile");
		     String city = request.getParameter("city");
		     String words = request.getParameter("words");
		     String id = request.getParameter("id");
		     
		     System.out.println("username= "+username);
		     System.out.println("password= "+password);
		     System.out.println("gender= "+gender);
		     System.out.println("likes= "+likes.length);
		     System.out.println("upfile= "+filepath);
		     System.out.println("city= "+city);
		     System.out.println("words= "+words);
		     System.out.println("id= "+id);
		     
	}

}
