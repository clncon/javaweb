package cn.itcast.web.struts.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

public class MyRequestProcess extends RequestProcessor {

	
	public void process(HttpServletRequest request, HttpServletResponse reponse)
			throws IOException, ServletException {
		  request.setCharacterEncoding("UTF-8");
		super.process(request, reponse);
	}
       
}
