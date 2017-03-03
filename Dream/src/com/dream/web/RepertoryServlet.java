package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.CommentBiz;
import com.dream.biz.GoodsBiz;
import com.dream.biz.RepertoryBiz;
import com.dream.biz.UserBiz;
import com.dream.biz.impl.CommentBizImpl;
import com.dream.biz.impl.GoodsBizImpl;
import com.dream.biz.impl.RepertoryBizImpl;
import com.dream.biz.impl.UserBizImpl;
import com.dream.comm.Page;
import com.dream.dao.RepertoryDao;
import com.dream.dao.impl.RepertoryDaoImpl;
import com.dream.entity.Comment;
import com.dream.entity.Goods;
import com.dream.entity.Repertory;
import com.dream.entity.view.Regost;

public class RepertoryServlet extends HttpServlet {
	Integer pagesize = 8;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		if (todo != null) {
			if ("searchfruit".equals(todo)) {             // 查询所有的水果
				this.searchfruit(request, response);
			} else if ("searchCondition".equals(todo)) {  // 条件查询商品
				this.searchCondition(request, response);
			} else if ("searchGname".equals(todo)) {      //根据商品名称查询
				this.searchGname(request, response);
			} else if ("searchBygid".equals(todo)) {      // 根据商品id查询
				this.searchBygid(request, response);
			} else if ("searchBycGname".equals(todo)) {   // 购买页面的评论
				this.searchBycGname(request, response);
			} else if ("searchhuiyuan".equals(todo)) {    // 会员页面购买
				this.searchhuiyuan(request, response);
			} else if ("searchBycGname2".equals(todo)) {  // 会员页面购买
				this.searchBycGname2(request, response);
			}else if ("searchGiftCondition".equals(todo)) {     //条件查询
				this.searchGiftCondition(request, response);
			} 
		}
	}


	// 会员页面购买
	private void searchhuiyuan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RepertoryBiz rb = new RepertoryBizImpl();
		Integer gid = Integer.valueOf(request.getParameter("gid")); // 获得gid
		Regost regost = rb.searchBygId(gid);
		request.getSession().setAttribute("regost", regost);
		// System.out.println("进来了吗？");
		this.searchBycGname2(request, response);

	}

	// 会员页面购买
	private void searchBycGname2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CommentBiz cb = new CommentBizImpl();
		Integer gid = Integer.valueOf(request.getParameter("gid"));
		GoodsBiz goodsbiz = new GoodsBizImpl();
		Goods goods = goodsbiz.searchGoods(gid);
		//System.out.println(goods.toString());
		List<Comment> listcomment = cb.searchBygName(goods.getgName());
		request.setAttribute("listcomment", listcomment);
		request.setAttribute("goods", goods.getgPic());
		request.getRequestDispatcher("huiyuangoumai.jsp").forward(request,
				response);

	}

	// /**
	// * 根据店面Id分页查询所有商品（后台）
	// * @throws IOException
	// * @throws ServletException
	// */
	// private void searchGoodsBySid(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// RepertoryBiz rb=new RepertoryBizImpl();
	// Page page=new Page();
	// Regost regost=new Regost();
	// String pageNoStr=request.getParameter("pageNo");
	// String sids=request.getParameter("sid");
	// Integer pageNo=0;
	// Integer sid=0;
	// if (sids!=null&&!"".equals(sids)) {
	// sid=Integer.valueOf(sids);
	// regost.setsId(1);
	// }
	// if (pageNoStr!=null&&!"".equals(pageNoStr)) {
	// pageNo=Integer.valueOf(pageNoStr);
	// if (pageNo>0) {
	// page.setPageNo(pageNo);
	// }else {
	// page.setPageNo(1);
	// }
	// }else {
	// page.setPageNo(1);
	// }
	// Integer count=rb.searchRepertoryCount(regost);//记录总数
	//
	//
	// if (count%pagesize!=0) {
	// count=count/pagesize+1;
	// }else{
	// count=count/pagesize;
	// if (count==0) {
	// count=1;
	// }
	// }
	// page.setPageSize(pagesize);//当前页面显示数量
	// page.setPageCount(count);
	// List<Regost> listGoods=rb.searchPage_Repertory(regost, page.getPageNo(),
	// page.getPageSize());
	// request.setAttribute("page", page);
	// request.setAttribute("listGoods", listGoods);
	// //转发到 单次请求域
	// request.getRequestDispatcher("admin/goods.jsp").forward(request,
	// response);
	// }

	//条件查询
	private void searchGiftCondition(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RepertoryBiz rb = new RepertoryBizImpl();
		Page page = new Page();
		Regost regost = new Regost();
		String gprices = request.getParameter("gprice");
		Double gprice = null;
		if (gprices != null && !"".equals(gprices)) {
			gprice = Double.parseDouble(gprices);
			regost.setgPrice(gprice);
		}
		RepertoryBiz biz = new RepertoryBizImpl();
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
		Integer count = rb.searchGiftCount(regost);// 记录总数
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
		List<Regost> listgtype = biz.searchGift(regost, page.getPageNo(),
				page.getPageSize());
		for (Regost regost2 : listgtype) {
			//System.out.println(regost2);
		}
		request.setAttribute("listgtype", listgtype);
		request.getSession().setAttribute("regost", regost);
		request.setAttribute("page", page);
		request.getRequestDispatcher("gift.jsp").forward(request, response);

	}

	// /**
	// * 根据商品类型多表查询礼品信息
	// * @param request
	// * @param response
	// * @throws ServletException
	// * @throws IOException
	// */
	// private void searchGtype(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// RepertoryBiz rz=new RepertoryBizImpl();
	//
	// //List<Regost> listgtype=rz.searchByGtype("礼盒");
	// Regost regost =new Regost();
	// regost.setgType("礼盒");
	// Page page=new Page();
	// String pageNoStr=request.getParameter("pageNo");
	// Integer pageNo=0;
	// if (pageNoStr!=null&&!"".equals(pageNoStr)) {
	// pageNo=Integer.valueOf(pageNoStr);
	// if (pageNo>0) {
	// page.setPageNo(pageNo);
	// }else {
	// page.setPageNo(1);
	// }
	// }else {
	// page.setPageNo(1);
	// }
	// Integer count=rz.searchRepertoryCount(regost);//记录总数
	//
	//
	// if (count%pagesize!=0) {
	// count=count/pagesize+1;
	// }else{
	// count=count/pagesize;
	// if (count==0) {
	// count=1;
	// }
	// }
	// page.setPageSize(pagesize);//当前页面显示数量
	// page.setPageCount(count);
	// List<Regost> listgtype=rz.searchPage_Repertory(regost, page.getPageNo(),
	// page.getPageSize());//多表条件查询
	// request.getSession().setAttribute("regost", regost);
	// request.setAttribute("page", page);
	// request.setAttribute("listgtype", listgtype);
	// for (Regost regost2 : listgtype) {
	// System.out.println("礼品"+regost2);
	// }
	// request.getRequestDispatcher("gift.jsp").forward(request, response);
	//
	// }
	// 购买页面的评论
	private void searchBycGname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CommentBiz cb = new CommentBizImpl();
		String gids = request.getParameter("gid");
		Integer gid = 0;
		Comment comm=new Comment();
		if (gids != null && !"".equals(gids)) {
			gid = Integer.valueOf(gids);
		}
		//System.out.println("页面上的" + gid);
		GoodsBiz goodsbiz = new GoodsBizImpl();
		Goods goods = goodsbiz.searchGoods(gid);
		//System.out.println(goods.toString());
		comm.setcGname(goods.getgName());
		Integer count = cb.searchCommentCount(comm);
		List<Comment> listcomment = cb.searchBygName(goods.getgName());
		request.setAttribute("listcomment", listcomment);
		request.setAttribute("goods", goods.getgPic());
		request.setAttribute("count", count);
		request.getRequestDispatcher("goumai.jsp").forward(request, response);

	}

	// 根据商品id查询
	private void searchBygid(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RepertoryBiz rb = new RepertoryBizImpl();
		// Integer gid=Integer.valueOf(request.getParameter("gid")); //获得gid
		String gids = request.getParameter("gid");
		Integer gid = 0;
		//System.out.println("idid" + gids);
		if (gids != null && !"".equals(gids)) {
			gid = Integer.valueOf(gids);
		}
		Regost regost = rb.searchBygId(gid);
		request.getSession().setAttribute("regost", regost);
		request.setAttribute("gid", gid);
		//System.out.println("单个的商品" + regost);
		this.searchBycGname(request, response);

	}

	// 类型查询商品
	private void searchGname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Regost regost = new Regost();
		Page page = new Page();
		RepertoryBiz rb = new RepertoryBizImpl();
		String gnames = request.getParameter("gname");
		String gname = "%" + gnames + "%";
		//System.out.println("页面上的名字" + gname);
		regost.setgName(gname);
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
		Integer count = rb.searchRepertoryCount(regost);// 记录总数
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
		List<Regost> list = rb.searchPage_Repertory(regost, page.getPageNo(),
				page.getPageSize());

		// System.out.println("打印"+list.toString());
		request.setAttribute("page", page);
		request.setAttribute("listregost", list);
		request.getSession().setAttribute("regost", regost);
		request.getRequestDispatcher("fruit.jsp").forward(request, response);

	}

	// 条件查询商品
	private void searchCondition(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Regost regost = new Regost();
		Page page = new Page();
		RepertoryBiz rb = new RepertoryBizImpl();
		String gtypes = request.getParameter("gtype");
		//System.out.println("类型：" + gtypes);
		String gtype = null;
		if (gtypes != null && !"".equals(gtypes)) {
			gtype = new String(gtypes.getBytes("ISO-8859-1"), "UTF-8");
			//System.out.println("转换类型：" + gtype);
		}
		//System.out.println("页面上的类型" + gtype);
		String gaddresss = request.getParameter("gaddress");
		String gaddress = null;
		if (gaddresss != null && !"".equals(gaddresss)) {
			gaddress = new String(gaddresss.getBytes("ISO-8859-1"), "UTF-8");
		}
		//System.out.println("页面上的地址" + gaddress);
		double gprice = 0;
		String gprices = request.getParameter("gprice");
		//System.out.println("页面上的价格：" + gprices);
		if (gprices != null && !"".equals(gprices)) {
			gprice = Double.parseDouble(request.getParameter("gprice"));
			regost.setgPrice(gprice);
		}
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
		regost.setgType(gtype);
		regost.setgAddress(gaddress);
		Integer count = rb.searchRepertoryCount(regost);// 记录总数

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
		List<Regost> list = rb.searchPage_Repertory(regost, page.getPageNo(),
				page.getPageSize());
		// System.out.println("打印"+list.toString());
		request.setAttribute("page", page);
		request.setAttribute("listregost", list);
		request.getSession().setAttribute("regost", regost);
		request.getRequestDispatcher("fruit.jsp").forward(request, response);

	}

	// 查询全部商品
	private void searchfruit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RepertoryBiz rb = new RepertoryBizImpl(); // 调用业务层中的库存 查询
		List<Regost> listregost = rb.searchRepertory(); // dao层中的查询库存的方法
		// System.out.println(listregost.toString());
		request.setAttribute("listregost", listregost); // 将查询到的库存信息放到listregost中
		// Integer gid=Integer.valueOf(request.getParameter("gid"));
		// GoodsBiz gb=new GoodsBizImpl();
		// Goods goods=gb.searchGoods(gid);
		// request.setAttribute("goods", goods);
		request.getRequestDispatcher("fruit.jsp").forward(request, response);
	}

}
