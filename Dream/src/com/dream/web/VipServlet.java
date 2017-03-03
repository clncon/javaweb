package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.UserBiz;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.Page;
import com.dream.entity.User;

public class VipServlet extends HttpServlet {
	Integer pagesize = 5;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		// System.out.println(todo);
		if (todo != null) {
			if ("searchVip".equals(todo)) { // 查询VIP
				this.searchVip(request, response);
			} else if ("searchUser".equals(todo)) { // 分页查询不是VIP的用户信息
				this.searchUser(request, response);
			} else if ("addVip".equals(todo)) { // 增加VIP
				this.addVip(request, response);
			} else if ("updateVip".equals(todo)) { // 修改VIP
				this.updateVip(request, response);
			} else if ("searchUpdateVip".equals(todo)) { // 查询需要修改的VIP
				this.searchUpdateVip(request, response);
			} else if ("delVip".equals(todo)) { // 删除VIP
				this.delVip(request, response);
			}
		}

	}

	// private void searchVipAjax(HttpServletRequest request,
	// HttpServletResponse response) throws IOException {
	// Integer spagesize =Integer.parseInt( request.getParameter("pagesize"));
	//
	// System.out.println(spagesize);
	//
	// UserBiz ub=new UserBizImpl();
	// Page page=new Page();
	// String pageNoStr=request.getParameter("pageNo");
	// if (pageNoStr!=null&&"".equals(pageNoStr)) {
	// Integer pageNo=Integer.valueOf(pageNoStr);
	// if (pageNo>0) {
	// page.setPageNo(pageNo);
	// }else {
	// page.setPageNo(1);
	// }
	// }else {
	// page.setPageNo(1);
	// }
	// Integer count=ub.searchVipCount();//记录总数
	//
	// int pagesize=Integer.valueOf(request.getParameter("pagesize"));
	//
	//
	// System.out.println("页面上"+pagesize);
	// page.setPageSize(pagesize);//当前页面显示数量
	// page.setPageCount(count/pagesize);
	//
	// List<User> listvip=ub.searchUflag(1, page.getPageNo(),
	// page.getPageSize());//会员
	//
	// PrintWriter out = response.getWriter();
	// response.setContentType("text/html");
	// // response.setHeader(arg0, arg1);
	// out.print(listvip);
	// out.flush(); //清空
	// out.close(); //关闭
	// // out.close();
	// }

	// //删除
	// private void delVip(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// // Integer uid=Integer.valueOf(request.getParameter("uid"));
	// String uids=request.getParameter("uid");
	// Integer uid=Integer.valueOf(uids);
	// System.out.println("删除"+uid);
	// UserBiz ub=new UserBizImpl();
	// ub.delete(uid);
	// this.searchVip(request,response);
	// }

	// 查询修改的会员
	private void searchUpdateVip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uids = request.getParameter("uid");       
		Integer uid = Integer.valueOf(uids);
		// System.out.println("修改"+uid);
		UserBiz ub = new UserBizImpl();
		User vip = ub.searchUser(uid);
		// System.out.println("修改"+vip.toString());
		request.setAttribute("vip", vip);
		request.getRequestDispatcher("admin/updatehuiyuan.jsp").forward(
				request, response);

	}

	// 修改会员
	private void updateVip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uPhone = request.getParameter("uPhone");
		String uName = request.getParameter("uName");
		String sex = request.getParameter("sex");
		String uMail = request.getParameter("uMail");
		String uAddress = request.getParameter("uAddress");
		String uLevel = request.getParameter("uLevel");
		Integer uId = Integer.valueOf(request.getParameter("uid"));
		UserBiz ub = new UserBizImpl();
		User vip = new User();
		vip.setuPhone(uPhone);
		vip.setuName(uName);
		vip.setSex(sex);
		vip.setuMail(uMail);
		vip.setuAddress(uAddress);
		vip.setuLevel(uLevel);
		vip.setuId(uId);
		ub.updateUser(vip);
		User user = ub.searchUser(uId);
		// System.out.println(user.toString());
		this.searchVip(request, response);
	}

	// 添加会员(将普通用户变为会员)
	private void addVip(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBiz ub = new UserBizImpl();
		User vip = new User();
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		vip.setuFlag("1");
		vip.setuId(uid);
		ub.updateUser(vip);
		this.searchVip(request, response);

	}

	// 删除会员(将会员变为普通用户)
	private void delVip(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBiz ub = new UserBizImpl();
		User vip = new User();
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		vip.setuFlag("0");
		vip.setuId(uid);
		ub.updateUser(vip);
		this.searchVip(request, response);

	}

	// //查询不是会员的用户信息
	// private void searchUser(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// UserBiz ub=new UserBizImpl();
	// Page page=new Page();
	// List<User> listuser=ub.searchUflag(0, page.getPageNo(),
	// page.getPageSize());
	// request.setAttribute("listuser", listuser);
	// for (User user : listuser) {
	// System.out.println(user);
	// }
	// request.getRequestDispatcher("admin/addhuiyuan.jsp").forward(request,
	// response);
	//
	// }
	// 分页查询不是会员的用户信息
	private void searchUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserBiz ub = new UserBizImpl();
		Page page = new Page();
		User user = new User();
		user.setuFlag("0");
		String pageNoStr = request.getParameter("pageNo");
		String uphone = request.getParameter("uphone");
		if (uphone != null && !"".equals(uphone)) {
			uphone = "%" + uphone + "%";
			user.setuPhone(uphone);
		}
		Integer pageNo = 0;
		// System.out.println(pageNoStr);
		if (pageNoStr != null && !"".equals(pageNoStr)) {
			pageNo = Integer.valueOf(pageNoStr);
			if (pageNo > 0) {
				page.setPageNo(pageNo);
			} else {
				page.setPageNo(1);
			}
		} else {
			page.setPageNo(1);
		}
		Integer count = ub.searchCount(user);// 记录总数

		if (count % pagesize != 0) {
			count = count / pagesize + 1;
		} else {
			count = count / pagesize;
			if (count == 0) {
				count = 1;
			}
		}
		page.setPageSize(pagesize);// 当前页面显示数量
		page.setPageCount(count);
		request.setAttribute("page", page);
		List<User> listuser = ub.searchUflag(user, page.getPageNo(),
				page.getPageSize());// 用户
		request.setAttribute("listuser", listuser);
		for (User user1 : listuser) {
			// System.out.println("不是会员"+user1);
		}
		request.getRequestDispatcher("admin/addhuiyuan.jsp").forward(request,
				response);

	}

	// //查询会员信息
	// private void searchVip(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// UserBiz ub=new UserBizImpl();
	// List<User> listvip=ub.searchUflag(1);
	// request.setAttribute("listvip", listvip);
	// request.getRequestDispatcher("admin/huiyuanguanli.jsp").forward(request,
	// response);
	//
	// }

	// 分页查询会员信息
	private void searchVip(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserBiz ub = new UserBizImpl();
		Page page = new Page();
		User user = new User();
		user.setuFlag("1");
		String pageNoStr = request.getParameter("pageNo");
		String uphone = request.getParameter("uphone");
		if (uphone != null && !"".equals(uphone)) {
			uphone = "%" + uphone + "%";
			user.setuPhone(uphone);
		}
		// System.out.println(pageNoStr);
		Integer pageNo = 0;
		if (pageNoStr != null && !"".equals(pageNoStr)) {
			pageNo = Integer.valueOf(pageNoStr);
			if (pageNo > 0) {
				page.setPageNo(pageNo);
			} else {
				page.setPageNo(1);
			}
		} else {
			page.setPageNo(1);
		}

		Integer count = ub.searchCount(user);// 记录总数

		// Integer pagesize=Integer.valueOf(request.getParameter("pagesize"));
		// System.out.println("页面上"+pagesize);

		if (count % pagesize != 0) {
			count = count / pagesize + 1;
		} else {
			count = count / pagesize;
			if (count == 0) {
				count = 1;
			}
		}
		page.setPageSize(pagesize);// 当前页面显示数量
		page.setPageCount(count);
		List<User> listvip = ub.searchUflag(user, page.getPageNo(),
				page.getPageSize());// 会员
		// System.out.println("会员信息:"+listvip);
		for (User user1 : listvip) {
			// System.out.println(user1.toString());
		}
		request.setAttribute("listvip", listvip);
		request.setAttribute("page", page);
		// request.getSession().setAttribute("listvip", listvip);
		request.getRequestDispatcher("admin/huiyuanguanli.jsp").forward(
				request, response);

	}

}
