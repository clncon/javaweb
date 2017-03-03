package cn.itcast.web.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUIServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String userName = request.getParameter("username");
           HttpSession session = request.getSession();
           ServletContext context = this.getServletContext();
           List<String> listName = (List<String>) context.getAttribute("listName");
           if(listName==null){
        	      listName = new ArrayList<String>();
        	      listName.add(userName);
        	      session.setAttribute("USERNAME", userName);
        	      context.setAttribute("listName", listName);
        	      request.getRequestDispatcher("/WEB-INF/welcom.jsp")
   			   .forward(request, response);
           }
           else
           {
        	  for(String c : listName){
        		   if(c.equals(userName)){
        			   request.getRequestDispatcher("/WEB-INF/message.jsp")
        			   .forward(request, response);
        			   return;
        		   }
   	  
        	  }
        	    listName.add(userName);
			   session.setAttribute("USERNAME", userName);
			   request.getRequestDispatcher("/WEB-INF/welcom.jsp")
			   .forward(request, response);
        	   
           }
	}

}
