package cn.itcast.web.shopcar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.domain.Car;
import cn.itcast.web.shopcar.service.Service;

public class deleteBookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String id = request.getParameter("id");
            Car car = (Car) request.getSession().getAttribute("car");
            if(car!=null){
		     Service service = new Service();
		     service.deleteBook(id,car);
            }
		     
		     //×ª·¢
		     request.getRequestDispatcher("/view/shopcar.jsp").forward(request, response);
	}

}
