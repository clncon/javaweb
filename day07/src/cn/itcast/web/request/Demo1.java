package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request对象的常用方法
		   /* String uri = request.getRequestURI();
		    String url = request.getRequestURL().toString();
		    String query = request.getQueryString();
		    String pathInfo = request.getPathInfo();
		    System.out.println("uri="+uri);
		    System.out.println("url="+url);
		    System.out.println("query="+query);
		    System.out.println("pathInfo="+pathInfo);*/
		
		    String adderess = request.getRemoteAddr();
		    String host = request.getRemoteHost();
		    int port = request.getRemotePort();
		    PrintWriter pw =response.getWriter();
		    pw.write("Client\n");
		    pw.write("adderess="+adderess+"\n");
		    pw.write("host="+host+"\n");
		    pw.write("prot="+port+"\n");
		    
		    String seradderess = request.getLocalAddr();
		    String serhost = request.getLocalName();
		    int serport = request.getLocalPort();
		    
		    pw.write("Server\n");
		    pw.write("seradderss="+seradderess+"\n");
		    pw.write("serhost="+serhost+"\n");
		    pw.write("serport="+serport+"\n");
		   

	}
	
}
