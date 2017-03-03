package cn.itcast.web.struts.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

public class MyActionServlet extends ActionServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	             request.setCharacterEncoding("UTF-8");
	             super.doPost(request, response);
	}
        
}
