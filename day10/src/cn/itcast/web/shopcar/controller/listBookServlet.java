package cn.itcast.web.shopcar.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.domain.Book;
import cn.itcast.web.shopcar.service.Service;

public class listBookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取图书列表
             Service service = new Service();
             Map<String,Book> map  = service.findAllBook();
             request.setAttribute("MAP", map);
             
         //转发至表现层
             request.getRequestDispatcher("/view/listBook.jsp").forward(request, response);
	}

}
