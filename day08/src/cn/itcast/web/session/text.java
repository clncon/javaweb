package cn.itcast.web.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class text extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter pw =    response.getWriter();
	        String id = UUID.randomUUID().toString();
	          HttpSession session = request.getSession();
	          session.setAttribute("ID", id);

	          pw.println(" <html>");
	          pw.println(" <title> <head>display message </head> </title>");
	          pw.println(" <body>");
	          pw.write("<form method = 'Get' action = '/day08/Demo1'>");
	          pw.write("����:<input type = 'text' name = 'username'/>");
	          pw.write("<input type = 'hidden' name ='id' value='"+id+"'/>");
	          pw.write("<input type = 'submit' value = '����'/>");
	          pw.write("</form>");
	          pw.println(" </body>");


	          pw.flush();
	          pw.close();

	}

}
