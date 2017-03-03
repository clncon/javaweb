package cn.itcast.web.session;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class exitServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            ServletContext context = this.getServletContext();
            List<String> listName = (List<String>)context.getAttribute("listName");
            listName.remove(request.getSession().getAttribute("USERNAME"));
            request.getSession().removeAttribute("USERNAME");
            
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            
		
	}

}
