package cn.itcast.web.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.web.domian.checkBean;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String username = request.getParameter("username");
           //��username�������
            HttpSession session = request.getSession();
            session.setAttribute("USERNAME", username);
           String checkcodeClient = request.getParameter("checkcode");
           String checkcodeServlet = (String) request.getSession().getAttribute("CHECKCODE");
           //����javaBean����
           checkBean cb = new checkBean();
           if(cb.vlidate(checkcodeClient, checkcodeServlet)){
        	   request.getRequestDispatcher("/showServlet").forward(request, response);
           }
           else{
        	   request.getRequestDispatcher("/message.html").forward(request, response);
           }
		
	}

}
