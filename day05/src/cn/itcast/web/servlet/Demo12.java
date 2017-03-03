package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo12 extends GenericServlet

{
    public void service(ServletRequest req, ServletResponse res){
    	res.setContentType("text/html; charset=UTF-8");
    	try {
			res.getWriter().write("ª∂”≠ π”√Java Servlet£°");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
