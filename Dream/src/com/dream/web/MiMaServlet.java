package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.UserBiz;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.RandomYzm;
import com.dream.comm.SHA1jiami;
import com.dream.entity.User;
import com.ruanwei.interfacej.Test;

public class MiMaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		if (todo != null) {
			if ("yzm".equals(todo)) { // ������֤��
				this.yzm(request, response);
			} else if ("shezhimima".equals(todo)) { // ��������
				this.shezhimima(request, response);
			} else if ("xinmima".equals(todo)) { // ������
				this.xinmima(request, response);
			}
		}

	}

	// ������
	private void xinmima(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uPwd = request.getParameter("uPwd");
		String pass = SHA1jiami.SHA1Digest(uPwd);
		// User user1=(User)request.getAttribute("tel");
		String uPhone = (String) request.getSession().getAttribute("tel");
		UserBiz ub = new UserBizImpl();
		User user2 = ub.searchUser(uPhone);
		//System.out.println(user2.toString());
		User user = new User();
		user.setuId(user2.getuId());
		user.setuPwd(pass);
		ub.updateUser(user);
		request.getRequestDispatcher("wangjiMM3.jsp")
				.forward(request, response);

	}

	// ��������
	private void shezhimima(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String yzm1 = request.getParameter("yzm");
		if (yzm1 != null) {
			int yzm = Integer.parseInt(yzm1);
			int rand = yzm(request, response);
			//System.out.println(rand);
			if (yzm == rand) {
				response.sendRedirect(request.getContextPath()
						+ "/wangjiMM2.jsp");
			} else {
				request.setAttribute("ERR", "�Բ����������֤�벻��ȷ");
				request.getRequestDispatcher("wangjiMM.jsp").forward(request,
						response);
			}

		}

	}

	// ������֤��
	private static int yzm(HttpServletRequest request,
			HttpServletResponse response) {
		String uPhone = request.getParameter("uPhone");
		request.getSession().setAttribute("tel", uPhone);
		// System.out.println(uPhone);
		RandomYzm r = new RandomYzm();
		int rand = r.Randyzm();
		String ms = "������ҵ��������֤���ǣ�" +703049+"��ף��ʹ����졾��֮�ӡ�";
		Test.sendMs(uPhone, ms);
		//System.out.println(rand);
		return 703049;
	}

}