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
            //ȡ�ù��ﳵ
            Car car = (Car) request.getSession().getAttribute("car");
            //�ж��Ƿ��й��ﳵ
           if(car==null){
        	   
        	   car = new Car();
        	   //�����ﳵ�󶨵�session��
        	   request.getSession().setAttribute("car", car);
           }
           //����
           Service service = new Service();
            service.buyBook(id,car);
            //�ض���
            request.getRequestDispatcher("/view/shopcar.jsp").forward(request, response);
		
	}

}
