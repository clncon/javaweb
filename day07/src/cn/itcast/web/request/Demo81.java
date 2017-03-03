package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo81 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                PrintWriter pw = response.getWriter();
                pw.write("Demo81");
                pw.flush();
                pw.close();
               
                request.getRequestDispatcher("/Demo82")
                .forward(request, response);
                
	}

}
