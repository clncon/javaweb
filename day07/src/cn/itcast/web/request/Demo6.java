package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo6 extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get方式解决中文乱码的问题
            byte[] buf = request.getParameter("username").getBytes("ISO8859-1");
            String username = new String(buf,"UTF-8");
            System.out.println("client:"+username);
	}

}
