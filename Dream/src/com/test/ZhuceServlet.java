package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.UserBiz;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.SHA1jiami;
import com.dream.entity.User;

/**
 * 用户的控制层
 * 
 * @author 葛睿 2016-3-9下午10:22:49
 */
public class ZhuceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
//注册
	public void doPost(HttpServletRequest request, HttpServletResponse response)
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
			request.setAttribute("errMs", "你的输入不正确！");
			request.getRequestDispatcher("zhuce.jsp")
					.forward(request, response);
		} else {

			if (uPwd.equals(uPwd1)) {// 2次输入密码一致
				this.zhuceRand(request, response);

			} else {
				request.getSession().setAttribute("errMs", "对不起您输入的不正确");
				response.sendRedirect(request.getContextPath() + "/zhuce.jsp");

			}
		

	

	
	}

	
}

	private void zhuceRand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String rand = request.getParameter("rand");                        // 获取用户输入的验证码
		String sRand = (String) request.getSession().getAttribute("sRand");// 获取生产的验证码
		String uPhone = request.getParameter("uPhone");
		String uPwd = request.getParameter("uPwd");
		String uMail = request.getParameter("uMail");
		String uName = request.getParameter("uName");
		if (rand == null || "".equals(rand)) {
			request.setAttribute("errMs", "请输入正确的验证码！");
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

				response.sendRedirect(request.getContextPath() + "/user.jsp");
			} else {
				request.setAttribute("errMs", "请输入正确的验证码！");
				request.getRequestDispatcher("zhuce.jsp").forward(request,
						response);
			}
		}

	}
}
