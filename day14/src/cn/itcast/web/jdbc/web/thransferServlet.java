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
			request.setAttribute("message", "ת�˳ɹ�");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "ת��ʧ��");
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
			   request.setAttribute("message", "���׳ɹ�����ȡ����ĳ�Ʊ");
		       request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		} catch (NOMoneyException e) {
			request.setAttribute("message", "����Ѿ����㣬���ȴ��");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		} catch (NOAccountException e) {
			request.setAttribute("message", "���˻������ڣ���ȷ�Ϻ���������");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		} catch(Exception e){			
			request.setAttribute("message", "����ʧ�ܣ�����������");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		}
	       
	       
	}
	

}
