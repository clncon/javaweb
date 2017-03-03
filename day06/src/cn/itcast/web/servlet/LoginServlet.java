package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//獲得login.html的參數
		response.setContentType("text/html;charset=UTF-8");
          String name = request.getParameter("username");
          String password= request.getParameter("password");
          String checkcode= request.getParameter("checkcode");
          System.out.println("username:"+name);
          System.out.println("password:"+password);
          System.out.println("checkcode:"+checkcode);
          /*
          //建立loginBean对象
          LoginBean logb = new LoginBean(); 
          boolean bool = logb.validate(name);
          //判断布尔值的结果
          if(bool){
        	  this.getServletContext().
        	  getRequestDispatcher("/success.html").
        	  forward(request, response);
          }
          {
        	  this.getServletContext().
        	  getRequestDispatcher("/fail.html").
        	  forward(request, response);
          }
		
	*/}

	}
