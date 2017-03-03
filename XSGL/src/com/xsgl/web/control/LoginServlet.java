package com.xsgl.web.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xsgl.web.exception.NoRootException;
import com.xsgl.web.service.loginService;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //���ʸ�servletֱ��ת������¼ҳ��
         request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //����¼�ύ��ҳ��ַ���login������
            String method = request.getParameter("method");
            if("Login".equals(method)){
            	this.Login(request, response);
            	
            }
		
	}



	protected void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		  //ȡ��������û���������
		 String rootName = request.getParameter("rootName");
         String rootPassword = request.getParameter("rootPassword");
          loginService loginService = new loginService();
              
			try {
				boolean flag = loginService.checkRoot(rootName, rootPassword);
				  //������ڸ��û���ת����ѧ����Ϣ����Ľ���
				if(flag){
				   request.getRequestDispatcher("/WEB-INF/jsp/XSGL.jsp").forward(request, response);
				}
				else{
					 //��������ڸù���Ա�û�����ת����������ҳ��
					request.setAttribute("message","��������л��������벻����");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				}
			
			}catch(Exception e){
				e.printStackTrace();
				//��������ڸù���Ա�û�����ת����������ҳ��
				request.setAttribute("message","��������л��������벻����");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
		  
	}
    
}
