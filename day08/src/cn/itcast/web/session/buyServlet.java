package cn.itcast.web.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class buyServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		    
		     response.setContentType("text/html;charset=UTF-8");
             String id = request.getParameter("id");
             int intId = Integer.parseInt(id);
             String[] buff ={"红楼梦","盗墓笔记","三国演义","水浒传","java web"};
             String bookName = buff[intId];
             HttpSession session = request.getSession();
               List<String> car = (List<String>) session.getAttribute("car");
               if(car==null){
            	   car = new ArrayList<String>();
            	   session.setAttribute("car", car);
               }
               car.add(bookName);
             response.sendRedirect("/day08/view.html");
                          
	}

}
