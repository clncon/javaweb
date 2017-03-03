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
           //取得Context对象
		  ServletContext context = request.getServletContext();
		   //取得map集合
		  Map<String,HttpSession> map = (Map<String, HttpSession>) this.getAttribute("MAP");
		  //取得客户端穿过来的用户名
		   String name  = request.getParameter("Name");
		   //解码
		    byte[] buff =name.getBytes("ISO8859-1");
		    //再用UTF-8编码
		     name = new String(buff,"utf-8");
		   //取得对应用户名的Session
		   HttpSession session = map.get(name);
		   System.out.println(map.size());
		   //从集合中取出这个session
		    map.remove(name);
		    //session.removeAttribute(name);
		    //销毁这个Session
		    session.invalidate();
		  //重定向到manager.jsp
		     //request.getRequestDispatcher("/manager.jsp").forward(request, response);
		   System.out.println(request.getContextPath());
		  response.sendRedirect(request.getContextPath()+"/manager.jsp");
		
	}

}
