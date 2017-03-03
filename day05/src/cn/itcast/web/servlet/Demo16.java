package cn.itcast.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo16 extends HttpServlet {

	private ServletConfig config;
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration  enumer = config.getInitParameterNames();
		while(enumer.hasMoreElements()){
			String key = (String) enumer.nextElement();
			String value = config.getInitParameter(key);
			System.out.println(key+": "+value);
			
		}
		
	}




	@Override
	public void init(ServletConfig config) throws ServletException {
		  this.config = config;
	}

}
