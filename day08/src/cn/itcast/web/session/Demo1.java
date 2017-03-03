package cn.itcast.web.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demo1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     response.setContentType("html/text;charset=UTF-8");
		     PrintWriter pw = response.getWriter();
             HttpSession session = request.getSession();
             String cientId =(String)session.getAttribute("ID");
             String id = request.getParameter("id");
             if(id.equals(cientId)){
            	 System.out.println(request.getParameter("username"));
            	  session.removeAttribute("ID");
             }
             else
             {
            	 pw.write("请不要重复提交");
             }
	}

}
