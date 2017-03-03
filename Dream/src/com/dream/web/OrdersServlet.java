package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.GoodsBiz;
import com.dream.biz.OrderBiz;
import com.dream.biz.PurchaseBiz;
import com.dream.biz.UserBiz;
import com.dream.biz.impl.GoodsBizImpl;
import com.dream.biz.impl.OrderBizImpl;
import com.dream.biz.impl.PurchaseBizImpl;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.Page;
import com.dream.entity.Goods;
import com.dream.entity.Orders;
import com.dream.entity.Purchase;
import com.dream.entity.Store;
import com.dream.entity.User;
import com.dream.entity.view.Ougp;

public class OrdersServlet extends HttpServlet {

	OrderBiz ob = new OrderBizImpl();
	UserBiz ub = new UserBizImpl();
	PurchaseBiz pb = new PurchaseBizImpl();
	GoodsBiz gb = new GoodsBizImpl();
	Orders orders = new Orders();
	Purchase purchase = new Purchase();
	Goods goods = new Goods();
	User user = new User();
	Integer pagesize = 5;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		if ("searchOrders".equals(todo)) {                   //查询订单
			this.searchOrders(request, response);
		} else if ("addOrders".equals(todo)) {               //增加订单
			this.addOrders(request, response);
		} else if ("deleteOrders".equals(todo)) {            //删除订单
			this.deleteOrders(request, response);
		} else if ("updateOrders".equals(todo)) {            //修改订单
			this.updateOrders(request, response);
		} else if ("searchupdateOrders".equals(todo)) {      //根据查询的订单号来修改订单（后台）
			this.searchupdateOrders(request, response);
		} else if ("searchOrders2".equals(todo)) {           //根据买家ID查询订单   
			this.searchOrders2(request, response);
		} else if ("searchOrders2ByStatus".equals(todo)) {   //根据订单状态及买家ID来查询
			this.searchOrders2ByStatus(request, response);
		} else if ("searchupdateOrders2".equals(todo)) {     //根据查询的订单号来修改订单（前台）
			this.searchupdateOrders2(request, response); 
		}
	}

	//根据查询的订单号来修改订单（前台）
	private void searchupdateOrders2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer oid = Integer.valueOf(request.getParameter("oid"));
		Orders orders = ob.searchOrdersByOId(oid);
		String oStatusStr = request.getParameter("oStatus");
		String oStatus = null;
		if (oStatusStr != null && !"".equals(oStatusStr)) {
			oStatus = new String(oStatusStr.getBytes("ISO-8859-1"), "UTF-8");
			orders.setoStatus(oStatus);
		}
		ob.updateostatusByOid(orders);
		this.searchOrders2(request, response);

	}

	//根据订单状态及买家ID来查询
	private void searchOrders2ByStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String oStatusStr = request.getParameter("oStatus");
		String oStatus = null;
		if (oStatusStr != null && !"".equals(oStatusStr)) {
			oStatus = new String(oStatusStr.getBytes("ISO-8859-1"), "UTF-8");
		}
		String gname = request.getParameter("gname");
		User user = (User) request.getSession().getAttribute("user");
		User user1 = ub.searchUser(user.getuPhone());
		List<Ougp> listOugp = ob.searchOugpByStatus(oStatus, user1.getuId());
		request.setAttribute("listOugp", listOugp);
		request.getRequestDispatcher("wodedingdan.jsp").forward(request,
				response);
	}

	//根据买家ID查询订单   
	private void searchOrders2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String gname = request.getParameter("gname");
		User user = (User) request.getSession().getAttribute("user");
		User user1 = ub.searchUser(user.getuPhone());
		List<Ougp> listougp = ob.searchOugpByUid(user1.getuId());
		request.setAttribute("listOugp", listougp);
		request.getRequestDispatcher("wodedingdan.jsp").forward(request,
				response);

	}

	//查询订单
	private void searchOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Page page = new Page();
		String pageNoStr = request.getParameter("pageNo");
		Store store = (Store) request.getSession().getAttribute("store");
		Ougp ougp = new Ougp();
		ougp.setpSid(store.getsId());
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
		Integer count = ob.searchAllOugpCount(ougp);// 记录总数

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
		List<Ougp> listougp = ob.searchOugp(ougp, page.getPageNo(),
				page.getPageSize());
		request.setAttribute("page", page);
		request.setAttribute("listOugp", listougp);
		request.getRequestDispatcher("admin/dingdanguanli.jsp").forward(
				request, response);
	}

	//根据查询的订单号来修改订单（后台）
	private void searchupdateOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer oId = Integer.valueOf(request.getParameter("oid"));
		Ougp ougp = ob.searchByOid(oId);
		// System.out.println(ougp.toString());
		request.setAttribute("ougp", ougp);
		request.getRequestDispatcher("admin/updateorder.jsp").forward(request,
				response);
		// response.sendRedirect(request.getContextPath()+"/admin/updateorder.jsp");

	}

	//修改订单
	private void updateOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String ostartdate = request.getParameter("ostartdate");
		String ostatus = request.getParameter("ostatus");
		String oenddate = request.getParameter("oenddate");
		String uname = request.getParameter("uname");
		String gname = request.getParameter("gname");
		Integer pnum = Integer.valueOf(request.getParameter("pnum"));
		// Double gprice=Double.valueOf(request.getParameter("gprice"));
		String oaddress = request.getParameter("oaddress");
		orders.setoStartdate(ostartdate);
		orders.setoStatus(ostatus);
		orders.setoEnddate(oenddate);
		User u = ub.searchUser(uname);
		Goods g = gb.searchByGname(gname);
		purchase.setpNum(pnum);
		Purchase tempPc = pb.searchPurchase(u.getuId(), 1, g.getgId());
		orders.setoPid(tempPc.getpId());
		orders.setoAddress(oaddress);
		Purchase pc = new Purchase(1, g.getgId(), u.getuId(), pnum);
		pb.update(pc);
		ob.updateOrders(orders);
		this.searchOrders(request, response);

	}

	//删除订单
	private void deleteOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer oid = Integer.valueOf(request.getParameter("oid"));
		Orders tempOd = ob.searchOrdersByOId(oid);
		ob.deleteOrders(oid);
		pb.delete(tempOd.getoPid());
		this.searchOrders(request, response);
	}

	//增加订单
	private void addOrders(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String ostartdate = request.getParameter("ostartdate");
		String ostatus = request.getParameter("ostatus");
		String oenddate = request.getParameter("oenddate");
		String uname = request.getParameter("uname");
		String gname = request.getParameter("gname");
		Integer pnum = 0;
		if (request.getParameter("pnum") == null
				|| "".equals(request.getParameter("pnum"))) {
			pnum = 0;
		} else {
			pnum = Integer.valueOf(request.getParameter("pnum"));
		}
		double gprice = 0;
		if (request.getParameter("gprice") == null
				|| "".equals(request.getParameter("gprice"))) {
			gprice = 0.0;
		} else {
			gprice = Double.valueOf(request.getParameter("gprice"));
		}
		String oaddress = request.getParameter("oaddress");

		if (ostartdate == null || "".equals(ostartdate) || ostatus == null
				|| "".equals(ostatus) || oenddate == null
				|| "".equals(oenddate) || uname == null || "".equals(uname)
				|| gname == null || "".equals(gname) || pnum == 0
				|| "".equals(pnum) || gprice == 0 || "".equals(gprice)
				|| oaddress == null || "".equals(oaddress)) {
			response.sendRedirect(request.getContextPath()
					+ "/admin/addOrders.jsp");
		} else {
			orders.setoStartdate(ostartdate);
			orders.setoStatus(ostatus);
			orders.setoEnddate(oenddate);
			// user.setuName(uname);
			// goods.setgName(gname);
			User u = ub.searchUser(uname);// 拿用户的id
			Goods g = gb.searchByGname(gname);
			purchase.setpNum(pnum);
			Purchase tempPc = pb.searchPurchase(u.getuId(), 1, g.getgId());
			orders.setoPid(tempPc.getpId());
			orders.setoAddress(oaddress);
			Purchase pc = new Purchase(1, g.getgId(), u.getuId(), pnum);
			pb.add(pc);
			ob.addOrders(orders);
			this.searchOrders(request, response);

		}
	}

	// private void searchOrders(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	//
	// List<Ougp> listOu= ob.searchOugp();
	// request.setAttribute("listOugp", listOu);
	// request.getRequestDispatcher("admin/dingdanguanli.jsp").forward(request,
	// response);
	//
	// }

}
