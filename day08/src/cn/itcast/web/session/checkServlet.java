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

public class checkServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     response.setContentType("text/html;charset=UTF-8");
             PrintWriter pw = response.getWriter();
             HttpSession session = request.getSession();
             List<String> bookList = (List<String>) session.getAttribute("car");
             if(bookList==null){
            	 pw.write("你还没有购物");
             }
             else{
            	 pw.write("你所购买的商品是<br/>");
            	 for(String c:bookList){
            		 pw.write(c+"<br/>");
            	 }
             }
	}

}
