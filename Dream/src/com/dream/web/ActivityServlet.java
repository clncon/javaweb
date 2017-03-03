package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.ActivityBiz;
import com.dream.biz.GoodsBiz;
import com.dream.biz.UserBiz;
import com.dream.biz.impl.ActivityBizImpl;
import com.dream.biz.impl.GoodsBizImpl;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.Page;
import com.dream.dao.GoodsDao;
import com.dream.dao.impl.GoodsDaoImpl;
import com.dream.entity.Activity;
import com.dream.entity.Goods;
import com.dream.entity.view.AcGoods;

/**
 * ���servlet
 * 
 * @author Сƽ 2016-3-11����2:30:06
 */
public class ActivityServlet extends HttpServlet {

	Integer pagesize = 5;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String todo = request.getParameter("todo");
		if (todo != null) {
			if ("searchActivity".equals(todo)) { // ��ѯ˫ʮһ�Ļ
				this.searchActivity(request, response);
			} else if ("searchActivityByaId".equals(todo)) { // ���ݻID��ѯ�
				this.searchActivityByaId(request, response);
			} else if ("addActivity".equals(todo)) { // ��ӻ
				this.addActivity(request, response);
			} else if ("updateActivity".equals(todo)) { // ���»
				this.updateActivity(request, response);
			} else if ("searchActivity12".equals(todo)) { // ��ѯ˫ʮ���Ļ
				this.searchActivity12(request, response);
			} else if ("searchAnniversary".equals(todo)) { // ��ѯ������
				this.searchAnniversary(request, response);
			} else if ("deleteActivity".equals(todo)) { // ɾ���
				this.deleteActivity(request, response);
			}
		}

	}

	/**
	 * ������Ʒ����ɾ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteActivity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer aGid = Integer.valueOf(request.getParameter("aGid"));
		// System.out.println("��Ʒ����Ϊ��"+aGid);
		ActivityBiz az = new ActivityBizImpl();
		az.deleteByaGid(aGid);
		this.searchActivity(request, response);
	}

	private void searchActivityByaId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ActivityBiz az = new ActivityBizImpl();
		Integer aId = Integer.valueOf(request.getParameter("aId"));
		AcGoods acgoods = az.searchById(aId);
		request.setAttribute("acgoods", acgoods);
		request.getRequestDispatcher("admin/updateActivity.jsp").forward(
				request, response);
	}

	// /**
	// * ��ѯ��������Ʒ�
	// * @param request
	// *
	// * @param response
	// * @throws ServletException
	// * @throws IOException
	// */
	// private void searchAnniversary(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// ActivityBiz az=new ActivityBizImpl();
	//
	// List<AcGoods> listAnniversary=az.searchByadate("2016.03.11");
	// request.setAttribute("listAnniversary", listAnniversary);
	// request.getRequestDispatcher("admin/zhounianqing.jsp").forward(request,
	// response);
	// }
	/**
	 * ��ҳ��ѯ��������Ʒ�
	 * 
	 * @param request
	 * 
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void searchAnniversary(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ActivityBiz az = new ActivityBizImpl();
		Page page = new Page();
		String pageNoStr = request.getParameter("pageNo");
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
		Integer count = az.searchCount("2016.12.12");// ��¼����

		if (count % pagesize != 0) {
			count = count / pagesize + 1;
		} else {
			count = count / pagesize;
			if (count == 0) {
				count = 1;
			}
		}
		page.setPageSize(pagesize);// ��ǰҳ����ʾ����
		page.setPageCount(count);
		request.setAttribute("page", page);
		// List<AcGoods> listActivity=az.search();
		List<AcGoods> listActivity = az.searchPage("2016.12.12",
				page.getPageNo(), page.getPageSize());
		request.setAttribute("listActivity", listActivity);
		request.getRequestDispatcher("admin/zhounianqing.jsp").forward(request,
				response);
	}

	// /**
	// * ��ѯ˫ʮ����Ʒ�
	// * @param request
	// * @param response
	// * @throws ServletException
	// * @throws IOException
	// */
	// private void searchActivity12(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// ActivityBiz az=new ActivityBizImpl();
	//
	// List<AcGoods> listActivity12=az.searchByadate("2016.12.12");
	// request.setAttribute("listActivity12", listActivity12);
	// request.getRequestDispatcher("admin/12.jsp").forward(request, response);
	//
	// }
	/**
	 * ��ҳ��ѯ˫ʮ����Ʒ�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void searchActivity12(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ActivityBiz az = new ActivityBizImpl();
		Page page = new Page();
		String pageNoStr = request.getParameter("pageNo");
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
		Integer count = az.searchCount("2016.12.12");// ��¼����

		if (count % pagesize != 0) {
			count = count / pagesize + 1;
		} else {
			count = count / pagesize;
			if (count == 0) {
				count = 1;
			}
		}
		page.setPageSize(pagesize);// ��ǰҳ����ʾ����
		page.setPageCount(count);
		request.setAttribute("page", page);
		// List<AcGoods> listActivity=az.search();
		List<AcGoods> listActivity = az.searchPage("2016.12.12",
				page.getPageNo(), page.getPageSize());
		request.setAttribute("listActivity", listActivity);
		request.getRequestDispatcher("admin/12.jsp").forward(request, response);

	}

	/**
	 * ������Ʒ�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateActivity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String agname = request.getParameter("agname");
		Integer aGid = Integer.valueOf(request.getParameter("aGid"));
		double aprice = Double.valueOf(request.getParameter("aprice"));
		String adate = request.getParameter("adate");
		String apic = request.getParameter("apic");
		// GoodsDao g= new GoodsDaoImpl();
		// Goods goods=g.searchGoods(agname);
		// GoodsBiz gb=new GoodsBizImpl();
		// Goods goods=gb.searchGoods(agname);
		// System.out.println(goods.getgId());
		// System.out.println(aGid);
		ActivityBiz az = new ActivityBizImpl();
		Activity ac = new Activity();
		ac.setAprice(aprice);
		ac.setApic(apic);
		ac.setAdate(adate);
		ac.setaGid(aGid);
		// ac.setaGid(goods.getgId());
		az.update(ac);

		this.searchActivity(request, response);

	}

	/**
	 * �����Ʒ�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addActivity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String agname = request.getParameter("agname");
		String aprice1 = request.getParameter("aprice");
		// System.out.println(aprice1);
		double aprice = 0;
		if (aprice1 == null || "".equals(aprice1)) {
			aprice = 0;
		} else {
			aprice = Double.valueOf(request.getParameter("aprice"));
		}
		String adate = request.getParameter("adate");
		String apic = request.getParameter("apic");
		if (agname == null || "".equals(agname) || aprice == 0
				|| "".equals(aprice) || adate == null || "".equals(adate)
				|| apic == null || "".equals(apic)) {
			response.sendRedirect(request.getContextPath()
					+ "/admin/addActivity.jsp");
		} else {
			// GoodsDao g= new GoodsDaoImpl();
			// Goods goods=g.searchGoods(agname);
			GoodsBiz gb = new GoodsBizImpl();
			Goods goods = gb.searchByGname(agname);
			ActivityBiz az = new ActivityBizImpl();
			Activity ac = new Activity();
			ac.setAprice(aprice);
			ac.setApic(apic);
			ac.setAdate(adate);
			ac.setaGid(goods.getgId());
			az.add(ac);
			this.searchActivity(request, response);
		}
	}

	// /**
	// * ��ѯ˫ʮһ��Ʒ�
	// * @param request
	// * @param response
	// * @throws ServletException
	// * @throws IOException
	// */
	// private void searchActivity(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// ActivityBiz az=new ActivityBizImpl();
	// // List<AcGoods> listActivity=az.search();
	//
	// List<AcGoods> listActivity=az.searchByadate("2016.11.11");
	// request.setAttribute("listActivity", listActivity);
	// request.getRequestDispatcher("admin/1111.jsp").forward(request,
	// response);
	//
	//
	// }
	/**
	 * ��ҳ��ѯ˫ʮһ��Ʒ�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void searchActivity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ActivityBiz az = new ActivityBizImpl();
		Page page = new Page();
		String pageNoStr = request.getParameter("pageNo");
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
		Integer count = az.searchCount("2016.11.11");// ��¼����

		if (count % pagesize != 0) {
			count = count / pagesize + 1;
		} else {
			count = count / pagesize;
			if (count == 0) {
				count = 1;
			}
		}
		page.setPageSize(pagesize);// ��ǰҳ����ʾ����
		page.setPageCount(count);
		request.setAttribute("page", page);
		// List<AcGoods> listActivity=az.search();
		List<AcGoods> listActivity = az.searchPage("2016.11.11",
				page.getPageNo(), page.getPageSize());
		request.setAttribute("listActivity", listActivity);
		request.getRequestDispatcher("admin/1111.jsp").forward(request,
				response);

	}

}
