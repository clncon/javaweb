package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.UserBiz;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.SHA1jiami;
import com.dream.entity.User;

/**
 * �û��Ŀ��Ʋ�
 * 
 * @author ��� 2016-3-9����10:22:49
 */
public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		if (todo != null) {                            
			if ("loginUser".equals(todo)) {            // �û���¼
				this.loginUser(request, response);
			} else if ("loginRand".equals(todo)) {     // ��¼�˶���֤��
				this.loginRand(request, response);
			} else if ("zhuce".equals(todo)) {         // ע��
				this.zhuce(request, response);
			} else if ("ajax".equals(todo)) {          // ajax��֤�û��Ƿ����
				this.ajax(request, response);
			} else if ("loginOut".equals(todo)) {      // �˳�
				this.loginOut(request, response);
			} else if ("UserAddress".equals(todo)) {   // ��ȡ�û����ջ���ַ
				this.UserAddress(request, response);
			} else if ("searchjibenziliao".equals(todo)) { // ��ѯ�û���������
				this.searchjibenziliao(request, response);
			} else if ("updateUser".equals(todo)) {        // �޸��û���������
				this.updateUser(request, response);
			} else if ("addAddress".equals(todo)) {        // ��ӵ�ַ
				this.addAddress(request, response);
			} else if ("mimaxiugaiajax".equals(todo)) {    // �����޸�ʹ��ajax
				mimaxiugaiajax(request, response);
			} else if ("mimaxiugai".equals(todo)) {        // userҳ��������޸�
				this.mimaxiugai(request, response);
			}
		}
	}// end todo��Ϊ��

	// �����޸�ʹ��ajax
	private void mimaxiugaiajax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String password1 = request.getParameter("password1");
		// System.out.println(password1);
		// String upwd=(String) request.getSession().getAttribute("upwd");
		User user = (User) request.getSession().getAttribute("user");
		String password = SHA1jiami.SHA1Digest(password1);
		Boolean bool = true;
		if (password.equals(user.getuPwd())) {
			bool = true;
		} else {
			bool = false;
		}
		PrintWriter out = response.getWriter();

		out.print(bool);
		out.flush(); // ���
		out.close(); // �ر�
	}

	// �����ջ���ַ
	private void addAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String province=request.getParameter("province");
		// String city=request.getParameter("city");
		String address = request.getParameter("address");
		User user = (User) request.getSession().getAttribute("user");
		UserBiz ub = new UserBizImpl();
		User user1 = ub.searchUser(user.getuPhone());
		String address1 = user1.getuAddress();
		String allAddress = address1 + "@" + address;
		user1.setuAddress(allAddress);
		ub.updateUser(user1);
		request.getRequestDispatcher("shouhuodizhi.jsp").forward(request,
				response);
	}

	// �޸��û���������
	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String uPhone=request.getParameter("uPhone");
		// String uName=request.getParameter("uName");
		String sex = request.getParameter("sex");
		String uMail = request.getParameter("uMail");
		String uBir = request.getParameter("uBir");
		String uAddress = request.getParameter("uAddress");
		Integer uId = Integer.valueOf(request.getParameter("uid"));
		// System.out.println("uid:" + uId +"  uMail:"+ uMail +"  uBir:"+ uBir
		// +"  uAddress:"+ uAddress +"  Sex:"+ sex);
		UserBiz ub = new UserBizImpl();
		// User user = new User();
		User user = (User) request.getSession().getAttribute("user");
		// user.setuPhone(uPhone);
		// user.setuName(uName);
		user.setSex(sex);
		user.setuMail(uMail);
		user.setuBir(uBir);
		user.setuAddress(uAddress);
		user.setuId(uId);
		ub.updateUser(user);
		this.searchjibenziliao(request, response);
	}

	// ��ѯ�û���������
	private void searchjibenziliao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String uPhone = user.getuPhone();
		UserBiz uz = new UserBizImpl();
		User us = uz.searchUser(uPhone);
		// request.setAttribute("us", us);
		request.getSession().setAttribute("user", us);
		request.getRequestDispatcher("jibenziliao.jsp").forward(request,
				response);
	}

	// ��ȡ�û����ջ���ַ
	private void UserAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user"); // ��ȡsession�е�����
		String uAddress = user.getuAddress();
		request.setAttribute("uAddress", uAddress);
		request.getRequestDispatcher("shouhuodizhi.jsp").forward(request,
				response);
	}

	// userҳ��������޸�
	private void mimaxiugai(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String password1 = request.getParameter("password1"); // ��ȡ�޸�ҳ�������
		User user1 = (User) request.getSession().getAttribute("user"); // ��ȡsession�е�����
		String SAUpwd = SHA1jiami.SHA1Digest(password1);
		String upwd = user1.getuPwd();

		if (SAUpwd.equals(upwd)) {
			String password2 = request.getParameter("password2"); // ��ȡ�����������
			String password3 = request.getParameter("password3");
			if (password2.equals(password3)) { // ������������
				UserBiz ub = new UserBizImpl();
				String Supwd = SHA1jiami.SHA1Digest(password3);
				user1.setuPwd(Supwd);

				ub.updateUser(user1);
				request.getRequestDispatcher("user.jsp").forward(request,
						response);
			} else {
				request.getRequestDispatcher("mimaxiugai.jsp").forward(request,
						response);
			}
		} else if (!password1.equals(upwd)) {
			request.getRequestDispatcher("mimaxiugai.jsp").forward(request,
					response);
		}
	}

	// �˳�
	private void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("gwc");
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	// ajax��֤�û��Ƿ����
	private void ajax(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		UserBiz ub = new UserBizImpl();
		String uPhone = request.getParameter("uPhone");
		// System.out.println(uPhone);
		Boolean bool = ub.checkUser(uPhone); // ��ѯ�Ƿ��д��û�
		// System.out.println(bool);
		PrintWriter out = response.getWriter();
		out.print(bool);
		out.flush(); // ���
		out.close(); // �ر�
		out.close();

	}

	// ע��
	private void zhuce(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uPhone = request.getParameter("uPhone");
		String uPwd = request.getParameter("uPwd");
		String uPwd1 = request.getParameter("uPwd1");
		String uMail = request.getParameter("uMail");
		String uName = request.getParameter("uName");

		if (uPhone == null || "".equals(uPhone) || uPwd == null
				|| "".equals(uPwd) || uPwd1 == null || "".equals(uPwd1)
				|| uMail == null || "".equals(uMail) || uName == null
				|| "".equals(uName)) {
			request.setAttribute("errMs", "������벻��ȷ��");
			request.getRequestDispatcher("zhuce.jsp")
					.forward(request, response);
		} else {

			if (uPwd.equals(uPwd1)) {// 2����������һ��
				this.zhuceRand(request, response);

			} else {
				request.getSession().setAttribute("errMs", "�Բ���������Ĳ���ȷ");
				response.sendRedirect(request.getContextPath() + "/zhuce.jsp");

			}

		}

	}

	// ��¼�˶���֤��
	private void loginRand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String rand = request.getParameter("rand");// ��ȡ�û��������֤��
		String sRand = (String) request.getSession().getAttribute("sRand");// ��ȡ��������֤��

		if (rand == null || "".equals(rand)) {
			request.setAttribute("errMs", "��������ȷ����֤�룡");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			if (rand.equals(sRand)) {

				this.loginUser(request, response);
			} else {
				request.setAttribute("errMs", "��������ȷ����֤�룡");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}
		}
	}

	private void zhuceRand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String rand = request.getParameter("rand");                        // ��ȡ�û��������֤��
		String sRand = (String) request.getSession().getAttribute("sRand");// ��ȡ��������֤��
		String uPhone = request.getParameter("uPhone");
		String uPwd = request.getParameter("uPwd");
		String uMail = request.getParameter("uMail");
		String uName = request.getParameter("uName");
		if (rand == null || "".equals(rand)) {
			request.setAttribute("errMs", "��������ȷ����֤�룡");
			request.getRequestDispatcher("zhuce.jsp")
					.forward(request, response);
		} else {
			if (rand.equals(sRand)) {
				UserBiz ub = new UserBizImpl();
				User user = new User();
				user.setuPhone(uPhone);
				user.setuPwd(uPwd);
				user.setuName(uName);
				user.setuMail(uMail);
				ub.addUser(user);

				User user1 = ub.searchUser(uPhone);

				request.getSession().setAttribute("user", user1);
				
				Cookie registerCookies = new Cookie("register_phone",user1.getuPhone());
				registerCookies.setMaxAge(24*60*60);
				response.addCookie(registerCookies);

				response.sendRedirect(request.getContextPath() + "/user.jsp");
			} else {
				request.setAttribute("errMs", "��������ȷ����֤�룡");
				request.getRequestDispatcher("zhuce.jsp").forward(request,
						response);
			}
		}

	}

	// �û���¼
	private void loginUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uPhone = request.getParameter("uPhone");       // ��ȡ�û����û���
		String uPwd = request.getParameter("uPwd");           // ��ȡ�û�������
		// System.out.println(uPhone);
		// System.out.println(uPwd);
		if (uPhone == null || "".equals(uPhone) || uPwd == null
				|| "".equals(uPwd)) {
			request.getSession().setAttribute("errMs", "��������û�������������");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			UserBiz ub = new UserBizImpl();
			User user = ub.loginUser(uPhone, uPwd);
			if (user != null) {
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("user.jsp").forward(request,response);
				// response.sendRedirect(request.getContextPath()+"/user.jsp");
			} else if (user == null) {
				request.getSession().setAttribute("errMs", "��������û�������������");
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}

		}
	}
}
