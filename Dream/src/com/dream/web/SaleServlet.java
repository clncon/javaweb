package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.SaleBiz;
import com.dream.biz.impl.SaleBizImpl;
import com.dream.entity.Sale;

/**
 * 销售的servlet
 * 
 * @author 小平 2016-3-10下午3:31:46
 */
public class SaleServlet extends HttpServlet {

	SaleBiz sb = new SaleBizImpl();
	Sale sale = new Sale();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		if (todo != null) {
			if ("searchSale".equals(todo)) {            // 查询销售业绩
				this.searchSale(request, response);
			}
		}
	}

	// 查询销售业绩
	private void searchSale(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Integer saId=Integer.valueOf(request.getParameter("said"));
		Sale sale = sb.serachSale(2);
		request.setAttribute("sale11", sale);
		request.getRequestDispatcher("admin/sale.jsp").forward(request,
				response);

	}
}
