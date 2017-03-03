package cn.itcast.web.request;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet {
     

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String username = request.getParameter("username");
		  String password = request.getParameter("password");
		  if(username==null||password==null){
			  request.getRequestDispatcher("/down/loginDown.html").
			  forward(request, response);
			 
			  
		  }
		  else{
			  ServletContext context = this.getServletContext();
				InputStream is = context.
				getResourceAsStream("/WEB-INF/classes/cn/itcast/web/request/config.properties");
				Properties pros = new Properties();
				pros.load(is);
				String value = pros.getProperty(username);
				
				if(value!=null&&value.equals(password)){
					File file = new File("D:/Watch_Dogs.jpg");
					response.setHeader("content-disposition", "attachment;filename="+file.getName());
				}
				else{
					request.getRequestDispatcher("/down/message.html").forward(request, response);
				}
			 
		  }
		  
           
	
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		 String password = req.getParameter("password");
		ServletContext context = this.getServletContext();
		InputStream is = context.
		getResourceAsStream("/WEB-INF/classes/cn/itcast/web/request/config.properties");
		Properties pros = new Properties();
		pros.load(is);
		String value = pros.getProperty(username);
		
		if(value!=null&&value.equals(password)){
			File file = new File("D:/Watch_Dogs.jpg");
			resp.setHeader("content-disposition", "attachment;filename="+file.getName());
		}
		else{
			req.getRequestDispatcher("/down/message.html").forward(req, resp);
		}
		   
	}
	

}
