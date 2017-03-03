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
		    	 //1.��ȡJNDI�еĺ�����Context
				Context context = new InitialContext();
				//2.Զ�̲���web������
				Context envCtx =  (Context) context.lookup("java:comp/env");
			   //3.��web��������Զ�̲���DPCP���ӳ�
				 DataSource ds = (DataSource) envCtx.lookup("tomcatDS");
			  //4.�����ӳ���ȡ��һ������
				conn = ds.getConnection();
				if(conn!=null){
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().write("ȡ������");
					conn.close();
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}

	}

}
