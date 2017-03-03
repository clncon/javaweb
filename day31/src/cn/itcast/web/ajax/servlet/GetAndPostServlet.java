package cn.itcast.web.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAndPostServlet extends HttpServlet {

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  System.out.println("GetServlet:doPost");
		  request.setCharacterEncoding("UTF-8");
		  String username = request.getParameter("username");
			 String msg=null;
			 if(username.equals("込込")){
				 msg="images/MsgError.gif";
			 }else{
				 msg="images/MsgSent.gif";
			 }
			 response.setContentType("text/xml;charset=utf-8");
			 PrintWriter pw = response.getWriter();
			 pw.write("<root>");
			    pw.write("<res>");
			       pw.write(msg);
			    pw.write("</res>");
			 pw.write("</root>");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       System.out.println("GetServlet:doGet");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		 username = new String(username.getBytes("ISO-8859-1"),"utf-8");
		 if(username.equals("込込")){
			 response.getWriter().write("images/MsgError.gif");
		 }else{
			 response.getWriter().write("images/MsgSent.gif");
			 
		 }
	}
   
}
