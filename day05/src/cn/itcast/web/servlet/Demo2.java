package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2 extends HttpServlet {
	public Demo2(){
		System.out.println("Demo2()");
	}

	
	public void destroy() {
		System.out.println("destroy()");
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet()");
		
	}

	public void init() throws ServletException {
		System.out.println("init()");
	}

}
