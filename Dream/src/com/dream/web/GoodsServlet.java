package com.dream.web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.biz.GoodsBiz;
import com.dream.biz.RepertoryBiz;
import com.dream.biz.impl.GoodsBizImpl;
import com.dream.biz.impl.RepertoryBizImpl;
import com.dream.comm.Page;
import com.dream.entity.Goods;
import com.dream.entity.Repertory;
import com.dream.entity.Store;
import com.dream.entity.view.Regost;

/**
 * 
 * @author ���� 2016-3-10����7:55:24
 */
public class GoodsServlet extends HttpServlet {

	GoodsBiz gb = new GoodsBizImpl();
	Goods goods = new Goods();
	Integer pagesize = 5;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String todo = request.getParameter("todo");
		if ("searchGoods".equals(todo)) {               //��ѯ��Ʒ
			this.searchGoods(request, response);
		} else if ("deleteGoods".equals(todo)) {        //ɾ����Ʒ
			this.deleteGoods(request, response);
		} else if ("updateGoods".equals(todo)) {        //������Ʒ
			this.updateGoods(request, response);
		} else if ("searchupdateGoods".equals(todo)) {  //���ݲ�ѯ������Ʒ���޸���Ʒ
			this.searchupdateGoods(request, response);
		} else if ("searchnameGoods".equals(todo)) {    //�������ֲ�ѯ��Ʒ
			this.searchnameGoods(request, response);
		} else if ("searchAllGoods".equals(todo)) {     //��ѯ���е���Ʒ
			this.searchAllGoods(request, response);
		} else if ("addGoods".equals(todo)) {           //�����Ʒ
			this.addGoods(request, response);
		} else if ("searchAllGoods2".equals(todo)) {    //���ݵ����ID��ȡ������Ʒ
			this.searchAllGoods2(request, response);
		}
	}

	//���ݵ����ID��ȡ������Ʒ
	private void searchAllGoods2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Store store = (Store) request.getSession().getAttribute("store");
		RepertoryBiz rb = new RepertoryBizImpl();
		Regost regost = new Regost();
		// String sids=request.getParameter("sid");
		// Integer sid=0;
		// if (sids!=null&&!"".equals(sids)) {
		// sid=Integer.valueOf(sids);
		// regost.setsId(sid);
		// }
		regost.setsId(store.getsId());
		List<Regost> listGoods = rb.search(regost);
		request.setAttribute("listGoods", listGoods);
		// ת���� ����������
		this.searchAllGoods(request, response);
		// request.getRequestDispatcher("admin/goods.jsp").forward(request,
		// response);

	}

	//�����Ʒ
	private void addGoods(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Store store = (Store) request.getSession().getAttribute("store");
		Goods goods = new Goods();
		GoodsBiz gb = new GoodsBizImpl();
		Repertory re = new Repertory();
		RepertoryBiz rb = new RepertoryBizImpl();
		// Store store=new Store();
		// StoreBiz sb=new StoreBizImpl();
		Integer sid = store.getSuid();
		String gname = request.getParameter("gname");
		String gprice1 = request.getParameter("gprice");
		double gprice = 0;
		if (gprice1 == null || "".equals(gprice1)) {
			gprice = 0;
		} else {
			gprice = Double.parseDouble(request.getParameter("gprice"));
		}
		String gtype = request.getParameter("gtype");
		String gaddress = request.getParameter("gaddress");
		String gpic = request.getParameter("gpic");
		String gdescribe = request.getParameter("gdescribe");
		if (gname == null || "".equals(gname) || gprice == 0
				|| "".equals(gprice) || gtype == null || "".equals(gtype)
				|| gaddress == null || "".equals(gaddress) || gpic == null
				|| "".equals(gpic) || gdescribe == null || "".equals(gdescribe)) {
			response.sendRedirect(request.getContextPath()
					+ "/admin/addgoods.jsp");
		} else {
			goods.setgName(gname);
			goods.setgPrice(gprice);
			goods.setgType(gtype);
			goods.setgAddress(gaddress);
			goods.setgPic(gpic);
			goods.setgDescribe(gdescribe);
			gb.addGoods(goods);

		}
		Goods goods1 = gb.searchByGname(gname);
		String rnums = request.getParameter("rnum");
		Integer rnum = 0;
		if (rnums != null && !"".equals(rnums)) {
			rnum = Integer.valueOf(rnums);
			re.setrGid(goods1.getgId());
			// System.out.println("������ƷId"+goods1.getgId());
			re.setrNum(rnum);
			re.setrSid(sid);
			rb.addRepertory(re);
		}
		this.searchGoods(request, response);

	}

	// �������ֲ���Ʒ
	private void searchnameGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String gName = request.getParameter("gname");
		Goods goods = gb.searchByGname(gName);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("admin/goodsone.jsp").forward(request,
				response);

	}

	// �鿴Ҫ�޸ĵ���Ʒ
	private void searchupdateGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer gId = Integer.valueOf(request.getParameter("gid"));
		// String gid= request.getParameter("gid");
		// Integer gId=Integer.valueOf(gid);
		Goods goods = gb.searchGoods(gId);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("admin/goodsxiugai.jsp").forward(request,
				response);
	}

	//������Ʒ
	private void updateGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String gname = request.getParameter("gname");
		Double gprice = Double.parseDouble(request.getParameter("gprice"));
		String gtype = request.getParameter("gtype");
		String gaddress = request.getParameter("gaddress");
		String gpic = request.getParameter("gpic");
		String gdescribe = request.getParameter("gdescribe");
		Integer gid = Integer.valueOf(request.getParameter("gid"));
		goods.setgName(gname);
		goods.setgPrice(gprice);
		goods.setgType(gtype);
		goods.setgAddress(gaddress);
		goods.setgPic(gpic);
		goods.setgDescribe(gdescribe);
		goods.setgId(gid);
		gb.updateGoods(goods);
		this.searchGoods(request, response);
	}

	//ɾ����Ʒ
	private void deleteGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Store store = (Store) request.getSession().getAttribute("store");
		RepertoryBiz rb = new RepertoryBizImpl();
		Repertory re = new Repertory();
		String gidStr = request.getParameter("gid");
		// System.out.println("��Ʒ"+gidStr);
		Integer gid = 0;
		if (gidStr != null && !"".equals(gidStr)) {
			gid = Integer.valueOf(gidStr);
		}
		re.setrGid(gid);
		re.setrSid(store.getSuid());// �̶�

		rb.deletRepertory(re);
		gb.deleteGoods(gid);
		this.searchGoods(request, response);

	}

	// /**
	// * ��Ʒ���
	// * @param request
	// * @param response
	// * @throws IOException
	// * @throws ServletException
	// */
	// private void addGoods(HttpServletRequest request,
	// HttpServletResponse response) throws IOException, ServletException {
	//
	// String gname=request.getParameter("gname");
	// String gprice1= request.getParameter("gprice");
	// double gprice=0;
	// if(gprice1==null || "".equals(gprice1)){
	// gprice=0;
	//
	// }else{
	// gprice= Double.parseDouble(request.getParameter("gprice"));
	// }
	//
	// String gtype=request.getParameter("gtype");
	// String gaddress=request.getParameter("gaddress");
	// String gpic=request.getParameter("gpic");
	// String gdescribe=request.getParameter("gdescribe");
	// if(gname==null || "".equals(gname) || gprice==0 || "".equals(gprice) ||
	// gtype==null || "".equals(gtype)
	// || gaddress==null || "".equals(gaddress) || gpic==null || "".equals(gpic)
	// || gdescribe==null || "".equals(gdescribe)
	// ){
	//
	// response.sendRedirect(request.getContextPath()+"/admin/addgoods.jsp");
	// }else{
	// goods.setgName(gname);
	// goods.setgPrice(gprice);
	// goods.setgType(gtype);
	// goods.setgAddress(gaddress);
	// goods.setgPic(gpic);
	// goods.setgDescribe(gdescribe);
	// gb.addGoods(goods);
	//
	// this.searchGoods(request, response);
	// }
	//
	// }
	
	//��ѯ���е���Ʒ
	private void searchAllGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//
		// List<Goods> listGoods=gb.searchGoods();
		// request.setAttribute("listGoods", listGoods);
		Store store = (Store) request.getSession().getAttribute("store");
		RepertoryBiz rb = new RepertoryBizImpl();
		Regost regost = new Regost();
		// String sids=request.getParameter("sid");
		// Integer sid=0;
		// if (sids!=null&&!"".equals(sids)) {
		// sid=Integer.valueOf(sids);
		// regost.setsId(sid);
		// }
		regost.setsId(store.getsId());
		List<Regost> listGood = rb.search(regost);
		request.setAttribute("listGood", listGood);
		// ת���� ����������
		request.getRequestDispatcher("admin/goods.jsp").forward(request,
				response);
	}

	//��ѯ��Ʒ
	private void searchGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Store store = (Store) request.getSession().getAttribute("store");
		RepertoryBiz rb = new RepertoryBizImpl();
		Page page = new Page();
		Regost regost = new Regost();
		String pageNoStr = request.getParameter("pageNo");
		// String sids=request.getParameter("sid");
		Integer pageNo = 0;
		// Integer sid=0;
		regost.setsId(store.getSuid());// �̶�
		// if (sids!=null&&!"".equals(sids)) {
		// sid=Integer.valueOf(sids);
		// regost.setsId(sid);
		// }
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
		Integer count = rb.searchRepertoryCount(regost);// ��¼����

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
		List<Regost> listGoods = rb.searchPage_Repertory(regost,
				page.getPageNo(), page.getPageSize());
		request.setAttribute("page", page);
		request.setAttribute("listGoods", listGoods);
		// ת���� ����������
		this.searchAllGoods(request, response);
		// request.getRequestDispatcher("admin/goods.jsp").forward(request,
		// response);
		// Page page=new Page();
		// GoodsBiz gb=new GoodsBizImpl();
		// String pageNoStr=request.getParameter("pageNo");
		// if (pageNoStr!=null&&!pageNoStr.equals("")) {
		// Integer pageNo=Integer.valueOf(pageNoStr);
		// if (pageNo>0) {
		// page.setPageNo(pageNo);
		// }else{
		// page.setPageNo(1);
		// }
		// }else{
		// page.setPageNo(1);
		// }
		// page.setPageSize(pagesize);
		// page.setTotalCount(gb.searchGoodsCount());
		//
		// List<Goods> listGoods=gb.searchPage_Goods(page.getPageNo(),
		// page.getPageSize());
		// request.setAttribute("listGoods", listGoods);
		// request.setAttribute("page", page);
		//
		// //ת���� ����������
		// request.getRequestDispatcher("admin/goods.jsp").forward(request,
		// response);
		// }
	}
}
