package cn.itcast.web.jdbc.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.itcast.web.jdbc.exception.NOAccountException;
import cn.itcast.web.jdbc.exception.NOMoneyException;
import cn.itcast.web.jdbc.service.thransferService2;

public class thransferServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 String method = request.getParameter("method");
		 if(method!=null&&"withDrow".equals(method)){
				 this.withDrow(request, response);
				 return;	 
		 }
		
		 try {
			 int sid = Integer.parseInt(request.getParameter("sid")); 
			 int tid = Integer.parseInt(request.getParameter("tid")); 
			 float salary = Float.parseFloat(request.getParameter("salary"));
			thransferService2 ts2 = new thransferService2();
			ts2.transfer(sid, tid, salary);
			request.setAttribute("message", "转账成功");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "转账失败");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		}
		 
	}

	
	protected void withDrow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       try {
	    	   int id = Integer.parseInt(request.getParameter("id"));
	    	   float money = Float.parseFloat(request.getParameter("money"));
	    	   thransferService2 ts2 = new thransferService2();
			   ts2.withdrow(id, money);
			   request.setAttribute("message", "交易成功，请取走你的钞票");
		       request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		} catch (NOMoneyException e) {
			request.setAttribute("message", "金额已经不足，请先存款");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		} catch (NOAccountException e) {
			request.setAttribute("message", "该账户不存在，请确认后重新输入");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		} catch(Exception e){			
			request.setAttribute("message", "交易失败，请重新输入");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		}
	       
	       
	}
	

}
