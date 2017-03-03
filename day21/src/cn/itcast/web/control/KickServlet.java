package cn.itcast.web.control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//踢人功能
public class KickServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ip = request.getRemoteAddr();

		if ("127.0.0.1".equals(ip)) {

			// 解码
			String username = request.getParameter("username");
			byte[] buf = username.getBytes("ISO8859-1");
			username = new String(buf, "UTF-8");
            
			// 从ServletContext中取得Map对象
			Map<String, HttpSession> map = (Map<String, HttpSession>) this.getServletContext().getAttribute("map");

			// 根据用户名查找对应的HttpSession
			HttpSession session = map.get(username);

			// 将该用户名从Map中移除
			map.remove(username);

			// 强行销毁该HttpSession
			session.invalidate();

			// 重写向到manager.jsp
			response.sendRedirect(request.getContextPath() + "/manager.jsp");

		}
	}
}
