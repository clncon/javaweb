package cn.itcast.web.vote.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.vote.entity.Admin;
import cn.itcast.web.vote.service.VoteService;

public class loginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          String username = request.getParameter("username");
          String password = request.getParameter("password");
           VoteService voteService = new VoteService();
           try {
			Admin admin = voteService.finAdminByUsernameAndPassword(username, password);
			  if(!(admin==null)){
				 request.getRequestDispatcher("/WEB-INF/jsp/manager.jsp")
				 .forward(request, response); 
				 
			  }
			  else{
				  request.setAttribute("message","π‹¿Ì‘±√¸¡Ó¥ÌŒÛ");
				  request.
				  getRequestDispatcher("/WEB-INF/jsp/message.jsp")
				  .forward(request, response);
			  }
			
			
		} catch (Exception e) {
			request.setAttribute("message","µ«¬º ß∞‹");
			  request.
			  getRequestDispatcher("/WEB-INF/jsp/message.jsp")
			  .forward(request, response);
		}
          
		
	}

}
