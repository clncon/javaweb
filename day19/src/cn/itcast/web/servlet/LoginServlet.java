package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            //ȡ���û�������û���������
		    String username = request.getParameter("username");
		    String password = request.getParameter("password");
		    
		    //��֤�û���������
		    if(username!=null&&password!=null&&username.trim().length()>0&&password.trim().length()>0){
		    	if(username.equals("jack")&&password.equals("123")){
		    	//���û������������Cookie��
		    	 Cookie cookie = new Cookie("usernameAndpassword",username+"_"+password);
		    	 cookie.setMaxAge(24*60);
		    	 response.addCookie(cookie);
		    	 //���û���Ϣ����Session��
		    	 request.getSession().setAttribute("username", username);
		    	 request.getSession().setAttribute("password", password);
		    	 //��ҳ��ת����ָ����jspҳ��
		    	 request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		    	}
		    	
		    }
	}
}
