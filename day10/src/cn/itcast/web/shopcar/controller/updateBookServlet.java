package cn.itcast.web.shopcar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.domain.Car;
import cn.itcast.web.shopcar.service.Service;

public class updateBookServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String id = request.getParameter("id");
           int num = Integer.parseInt(request.getParameter("num"));
           
          Car car = (Car)request.getSession().getAttribute("car");
          if(car!=null){
        	   Service service = new Service();
        	   service.updateBook(id,num,car);
          }
         response.sendRedirect("/day10/view/shopcar.jsp");
	}

}
