package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.StoreBiz;
import com.dream.biz.UserBiz;
import com.dream.biz.impl.StoreBizImpl;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.Page;
import com.dream.entity.Store;
import com.dream.entity.User;

/**
 * ������Ϣ
 * 
 * @author ��ҫ 2016-3-10����11:03:27
 */
public class StoreServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		if ("searchStore".equals(todo)) {          // ��ѯ����
			this.searchStore(request, response);
		} else if ("updateStore".equals(todo)) {   // ���µ���
			this.updateStore(request, response);
		} else if ("MyStore".equals(todo)) {       // ���ݵ���ID��ȡ������Ϣ
			this.MyStore(request, response);
		} else if ("addStore".equals(todo)) {      // �����̵�
			this.addStore(request, response);
		}
	}

	// �����̵�
	private void addStore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sPhone = request.getParameter("sPhone");
		String sAddress = request.getParameter("sAddress");
		String sName = request.getParameter("sName");
		StoreBiz sb = new StoreBizImpl();
		UserBiz ub = new UserBizImpl();
		User user = (User) request.getSession().getAttribute("user");
		User user1 = ub.searchUser(user.getuPhone());
		user1.setuFlag("2");
		ub.updateUser(user1);
		Store store = new Store();
		store.setsName(sName);
		store.setsPhone(sPhone);
		store.setsAddress(sAddress);
		store.setSuid(user1.getuId());
		sb.add(store);
		// request.setAttribute("store", store);
		request.getSession().setAttribute("store", store);
		response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
		// request.getRequestDispatcher("admin/index.jsp").forward(request,
		// response);
	}

	// �ҵ��ŵ�
	private void MyStore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		Integer uid = user.getuId();
		StoreBiz sb = new StoreBizImpl();
		Store store = sb.searchStoreBySuid(uid);
		request.getSession().setAttribute("store", store);
		response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
		// request.getRequestDispatcher("admin/index.jsp").forward(request,
		// response);
	}

	// ���µ���
	private void updateStore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sPhone = request.getParameter("sPhone");
		String sAddress = request.getParameter("sAddress");
		String sName = request.getParameter("sName");
		StoreBiz sb = new StoreBizImpl();
		Store store = new Store();
		store.setsName(sName);
		store.setsPhone(sPhone);
		store.setsAddress(sAddress);
		sb.update(store);
		this.searchStore(request, response);
	}

	// ��ѯ����
	private void searchStore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StoreBiz sb = new StoreBizImpl();
		UserBiz ub = new UserBizImpl();
		User user = (User) request.getSession().getAttribute("user");
		User user1 = ub.searchUser(user.getuPhone());
		Store store = sb.searchStoreBySuid(user1.getuId());
		request.setAttribute("store", store);
		request.getRequestDispatcher("admin/dianmianxinxi.jsp").forward(
				request, response);
	}

}
