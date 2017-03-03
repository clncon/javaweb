package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2 extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request对象获取头信息的方法

		//response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		 /*String accept = request.getHeader("Accept");
		 String acceptLanguage = request.getHeader("Accept-Language");
		 String userAgent = request.getHeader("user-Agent");
		 String host = request.getHeader("host");
		 pw.write("accept:"+accept);
		 pw.write("acceptLanguage:"+acceptLanguage);
		 pw.write("userAgent:"+userAgent);
		 pw.write("host:"+host);*/
		 
		 Enumeration<String> enums =  request.getHeaderNames();
		 while((enums).hasMoreElements()){
			 String key = enums.nextElement();
			 Enumeration<String> enumer = request.getHeaders(key);
			 while(enumer.hasMoreElements()){
				 String value = enumer.nextElement();
				 pw.write(key+"<->"+value+"\n");
			 }
		 }
	
	}

}
