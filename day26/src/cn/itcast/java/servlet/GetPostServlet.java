package cn.itcast.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GetPostServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //��ȡ�û���
            String value = request.getParameter("username");
            String method = request.getMethod();
           // ��ӡ�û���
            System.out.println("�û���["+method+"]"+":"+value);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             this.doGet(request, response);
	}

}
