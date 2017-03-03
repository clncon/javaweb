package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    response.setContentType("text/html;charset=UTF-8");
           PrintWriter  pw = response.getWriter();
           ServletContext context = this.getServletContext();
           String ip = (String) context.getAttribute("IP");
           String address = (String) context.getAttribute("ADDRESS");
           String username = (String) context.getAttribute("USERNAME");
           
           pw.write("»¶Ó­"+username+"·ÃÎÊ±¾ÍøÕ¾"+"<br/>");
           pw.write("ÄúµÄip:"+ip+"<br/>");
           pw.write("¹éÊôµØ:"+address);
           
		
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   this.doPost(req, resp);
	}
	

}
