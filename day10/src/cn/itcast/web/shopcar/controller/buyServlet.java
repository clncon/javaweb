package cn.itcast.web.shopcar.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.domain.Book;
import cn.itcast.web.domain.Car;
import cn.itcast.web.shopcar.service.Service;

public class buyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             String id = request.getParameter("id");
            //取得购物车
            Car car = (Car) request.getSession().getAttribute("car");
            //判断是否有购物车
           if(car==null){
        	   
        	   car = new Car();
        	   //将购物车绑定到session中
        	   request.getSession().setAttribute("car", car);
           }
           //买书
           Service service = new Service();
            service.buyBook(id,car);
            //重定向
            request.getRequestDispatcher("/view/shopcar.jsp").forward(request, response);
		
	}

}
