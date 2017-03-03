package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listShow extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   response.setContentType("text/html;charset=UTF-8");
		    String username = (String) this.getServletContext().getAttribute("USERNAME");
		    response.getWriter().write("ª∂”≠"+username+"π‚¡Ÿ±æÕ¯’æ");
            
		
	}

}
