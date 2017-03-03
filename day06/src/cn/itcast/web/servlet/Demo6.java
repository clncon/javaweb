package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String uri =request.getRequestURI();
            //如果是一个HTML静态文件
            if(uri!=null&&uri.endsWith("html")){
            String html = this.getServletConfig().getInitParameter("html");
            if(html!=null){
            long htmltime = Long.parseLong(html)*1000+System.currentTimeMillis();
            response.setDateHeader("Expires", htmltime);
            }
            }
            
	}

}
