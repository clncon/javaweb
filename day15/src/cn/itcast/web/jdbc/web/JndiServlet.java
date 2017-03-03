package cn.itcast.web.jdbc.web;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class JndiServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		        Connection conn=null;
		     try {
		    	 //1.获取JNDI中的核心类Context
				Context context = new InitialContext();
				//2.远程查找web服务器
				Context envCtx =  (Context) context.lookup("java:comp/env");
			   //3.在web服务器中远程查找DPCP连接池
				 DataSource ds = (DataSource) envCtx.lookup("tomcatDS");
			  //4.从连接池中取得一个连接
				conn = ds.getConnection();
				if(conn!=null){
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().write("取得连接");
					conn.close();
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	}

}
