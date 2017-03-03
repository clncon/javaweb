package cn.itcast.web.control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KickServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           //ȡ��Context����
		  ServletContext context = request.getServletContext();
		   //ȡ��map����
		  Map<String,HttpSession> map = (Map<String, HttpSession>) this.getAttribute("MAP");
		  //ȡ�ÿͻ��˴��������û���
		   String name  = request.getParameter("Name");
		   //����
		    byte[] buff =name.getBytes("ISO8859-1");
		    //����UTF-8����
		     name = new String(buff,"utf-8");
		   //ȡ�ö�Ӧ�û�����Session
		   HttpSession session = map.get(name);
		   System.out.println(map.size());
		   //�Ӽ�����ȡ�����session
		    map.remove(name);
		    //session.removeAttribute(name);
		    //�������Session
		    session.invalidate();
		  //�ض���manager.jsp
		     //request.getRequestDispatcher("/manager.jsp").forward(request, response);
		   System.out.println(request.getContextPath());
		  response.sendRedirect(request.getContextPath()+"/manager.jsp");
		
	}

}
