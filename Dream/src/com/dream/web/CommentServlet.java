package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.CommentBiz;
import com.dream.biz.impl.CommentBizImpl;
import com.dream.comm.Page;
import com.dream.entity.Comment;
import com.dream.entity.Goods;

public class CommentServlet extends HttpServlet {
	CommentBiz biz = new CommentBizImpl();
	Integer pagesize = 5;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		Page page = new Page();
		if (todo != null) {
			if ("searchAllComment".equals(todo)) {               //查询所有评论
				this.searchAllComment(request, response);
			} else if ("searchnameComment".equals(todo)) {       //根据商品名字查询评论
				this.searchnameComment(request, response);
			} else if (todo.equals("searchComment")) {           //查询评论，分页
				this.searchComment(request, response, page);
			}
		}

	}

	//查询评论，分页
	private void searchComment(HttpServletRequest request,
			HttpServletResponse response, Page page) throws ServletException,
			IOException {
		String pageNoStr = request.getParameter("pageNo");
		String cgname = request.getParameter("cgname");
		String cdate = request.getParameter("cdate");
		Comment comm = new Comment();
		if (cdate != null && !"".equals(cdate)) {
			comm.setcDate(cdate);
		}
		if (cgname != null && !"".equals(cgname)) {
			comm.setcGname(cgname);
		}
		if (pageNoStr != null && !pageNoStr.equals("")) {
			int pageNo = Integer.valueOf(pageNoStr);
			if (pageNo > 0) {
				page.setPageNo(pageNo);
			} else {
				page.setPageNo(1);
			}
		} else {
			page.setPageNo(1);
		}
		Integer count = biz.searchCommentCount(comm);// 记录总数
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
		List<Comment> listcom = biz.searchPage_Comment(comm, page.getPageNo(),
				page.getPageSize());
		request.setAttribute("page", page);
		request.setAttribute("listcom", listcom);
		this.searchnameComment(request, response);
		request.getRequestDispatcher("admin/comment.jsp").forward(request,
				response);
	}

	// private void searchnameComment(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// String cGname=request.getParameter("cgname");
	// List<Comment> listcom=biz.searchBygName(cGname);
	// request.setAttribute("listcom", listcom);
	// request.getRequestDispatcher("admin/commentone.jsp").forward(request,
	// response);
	//
	//
	// }

	//查询所有评论
	private void searchAllComment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Comment> listcom = biz.searchComment();
		request.setAttribute("listcom", listcom);
		this.searchnameComment(request, response);
		request.getRequestDispatcher("admin/comment.jsp").forward(request,
				response);

	}

	//根据商品名字查询评论
	private void searchnameComment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Comment> listcomname = biz.searchComment();
		request.setAttribute("listcomname", listcomname);
		// request.getRequestDispatcher("admin/comment.jsp").forward(request,
		// response);

	}
}
