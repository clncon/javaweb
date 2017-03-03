package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.UserBiz;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.SHA1jiami;
import com.dream.entity.User;


public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("GBK");
		String uPhone = request.getParameter("uPhone");       // 获取用户的用户名
		String uPwd = request.getParameter("uPwd");           // 获取用户的密码
		// System.out.println(uPhone);
		// System.out.println(uPwd);
		 if(uPhone != null && !uPhone.equals("")) {     
	            request.getSession().setAttribute("uPhone",uPhone);       
	        }  
	        //从应用上下文中获取在线用户名列表  
	        List<String> online = (List<String>)getServletContext().getAttribute("online");     
	          
	        response.setContentType("text/html;charset=utf-8");  
	        PrintWriter out = response.getWriter();  
	        out.println("<HTML>");  
	        out.println("  <HEAD><TITLE>用户列表</TITLE></HEAD>");  
	        out.println("  <BODY>");  
	        out.println("当前用户是：" + uPhone);  
	        out.print("    <hr/><h3>在线用户列表</h3>");  
	  
	        int size = online == null ? 0 : online.size();  
	        for (int i = 0; i < size; i++) {  
	            if(i > 0){  
	                out.println("<br/>");  
	            }  
	            out.println(i + 1 + "." + online.get(i));  
	        }  
	          
	        //注意: 要对链接URL进行自动重写处理    
	        out.println("  </BODY>");  
	        out.println("</HTML>");  
	        out.flush();  
	        out.close();  
		}
}
