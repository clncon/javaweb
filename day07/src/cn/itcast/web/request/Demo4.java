package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo4 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//∑¿µ¡¡¥
		response.setHeader("Expires", "-1");
          String referer = request.getHeader("Referer");
          if(referer!=null&&referer.equals("http://localhost:8080/day07/index.html")){
        	  request.getRequestDispatcher("/download.html").
        	   forward(request, response);
          }
          else{
        	  request.getRequestDispatcher("/ad.html")
        	  .forward(request, response);
        	  
          }
		
		
	}

}
