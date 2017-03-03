package cn.itcast.web.mail.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.mail.util.MessageUtil;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
           if((username!=null&&email!=null)&&(username.trim().length()>0&&email.trim().length()>0)){
        	   try {
        		   //����ע��ɹ��ʼ�
        		   //System.out.println(username);
        		 //  System.out.println(email);
				MessageUtil.sendMessage(email,username);
				//ת����ע��ɹ�ҳ��
				request.setAttribute("message","ע��ɹ�");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message","ע��ʧ��");
				response.sendRedirect(request.getContextPath()+"/message.jsp");
			}
           }  
            	
	}
		
}
