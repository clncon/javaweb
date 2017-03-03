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
			if ("searchfruit".equals(todo)) {             // ��ѯ���е�ˮ��
				this.searchfruit(request, response);
			} else if ("searchCondition".equals(todo)) {  // ������ѯ��Ʒ
				this.searchCondition(request, response);
			} else if ("searchGname".equals(todo)) {      //������Ʒ���Ʋ�ѯ
				this.searchGname(request, response);
			} else if ("searchBygid".equals(todo)) {      // ������Ʒid��ѯ
				this.searchBygid(request, response);
			} else if ("searchBycGname".equals(todo)) {   // ����ҳ�������
				this.searchBycGname(request, response);
			} else if ("searchhuiyuan".equals(todo)) {    // ��Աҳ�湺��
				this.searchhuiyuan(request, response);
			} else if ("searchBycGname2".equals(todo)) {  // ��Աҳ�湺��
				this.searchBycGname2(request, response);
			}else if ("searchGiftCondition".equals(todo)) {     //������ѯ
				this.searchGiftCondition(request, response);
			} 
		}
	}


	// ��Աҳ�湺��
	private void searchhuiyuan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RepertoryBiz rb = new RepertoryBizImpl();
		Integer gid = Integer.valueOf(request.getParameter("gid")); // ���gid
		Regost regost = rb.searchBygId(gid);
		request.getSession().setAttribute("regost", regost);
		// System.out.println("��������");
		this.searchBycGname2(request, response);

	}

	// ��Աҳ�湺��
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
	// * ���ݵ���Id��ҳ��ѯ������Ʒ����̨��
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
	// Integer count=rb.searchRepertoryCount(regost);//��¼����
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
	// page.setPageSize(pagesize);//��ǰҳ����ʾ����
	// page.setPageCount(count);
	// List<Regost> listGoods=rb.searchPage_Repertory(regost, page.getPageNo(),
	// page.getPageSize());
	// request.setAttribute("page", page);
	// request.setAttribute("listGoods", listGoods);
	// //ת���� ����������
	// request.getRequestDispatcher("admin/goods.jsp").forward(request,
	// response);
	// }

	//������ѯ
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
		Integer count = rb.searchGiftCount(regost);// ��¼����
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
	// * ������Ʒ���Ͷ���ѯ��Ʒ��Ϣ
	// * @param request
	// * @param response
	// * @throws ServletException
	// * @throws IOException
	// */
	// private void searchGtype(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// RepertoryBiz rz=new RepertoryBizImpl();
	//
	// //List<Regost> listgtype=rz.searchByGtype("���");
	// Regost regost =new Regost();
	// regost.setgType("���");
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
	// Integer count=rz.searchRepertoryCount(regost);//��¼����
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
	// page.setPageSize(pagesize);//��ǰҳ����ʾ����
	// page.setPageCount(count);
	// List<Regost> listgtype=rz.searchPage_Repertory(regost, page.getPageNo(),
	// page.getPageSize());//���������ѯ
	// request.getSession().setAttribute("regost", regost);
	// request.setAttribute("page", page);
	// request.setAttribute("listgtype", listgtype);
	// for (Regost regost2 : listgtype) {
	// System.out.println("��Ʒ"+regost2);
	// }
	// request.getRequestDispatcher("gift.jsp").forward(request, response);
	//
	// }
	// ����ҳ�������
	private void searchBycGname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CommentBiz cb = new CommentBizImpl();
		String gids = request.getParameter("gid");
		Integer gid = 0;
		Comment comm=new Comment();
		if (gids != null && !"".equals(gids)) {
			gid = Integer.valueOf(gids);
		}
		//System.out.println("ҳ���ϵ�" + gid);
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

	// ������Ʒid��ѯ
	private void searchBygid(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RepertoryBiz rb = new RepertoryBizImpl();
		// Integer gid=Integer.valueOf(request.getParameter("gid")); //���gid
		String gids = request.getParameter("gid");
		Integer gid = 0;
		//System.out.println("idid" + gids);
		if (gids != null && !"".equals(gids)) {
			gid = Integer.valueOf(gids);
		}
		Regost regost = rb.searchBygId(gid);
		request.getSession().setAttribute("regost", regost);
		request.setAttribute("gid", gid);
		//System.out.println("��������Ʒ" + regost);
		this.searchBycGname(request, response);

	}

	// ���Ͳ�ѯ��Ʒ
	private void searchGname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Regost regost = new Regost();
		Page page = new Page();
		RepertoryBiz rb = new RepertoryBizImpl();
		String gnames = request.getParameter("gname");
		String gname = "%" + gnames + "%";
		//System.out.println("ҳ���ϵ�����" + gname);
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
		List<Regost> list = rb.searchPage_Repertory(regost, page.getPageNo(),
				page.getPageSize());

		// System.out.println("��ӡ"+list.toString());
		request.setAttribute("page", page);
		request.setAttribute("listregost", list);
		request.getSession().setAttribute("regost", regost);
		request.getRequestDispatcher("fruit.jsp").forward(request, response);

	}

	// ������ѯ��Ʒ
	private void searchCondition(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Regost regost = new Regost();
		Page page = new Page();
		RepertoryBiz rb = new RepertoryBizImpl();
		String gtypes = request.getParameter("gtype");
		//System.out.println("���ͣ�" + gtypes);
		String gtype = null;
		if (gtypes != null && !"".equals(gtypes)) {
			gtype = new String(gtypes.getBytes("ISO-8859-1"), "UTF-8");
			//System.out.println("ת�����ͣ�" + gtype);
		}
		//System.out.println("ҳ���ϵ�����" + gtype);
		String gaddresss = request.getParameter("gaddress");
		String gaddress = null;
		if (gaddresss != null && !"".equals(gaddresss)) {
			gaddress = new String(gaddresss.getBytes("ISO-8859-1"), "UTF-8");
		}
		//System.out.println("ҳ���ϵĵ�ַ" + gaddress);
		double gprice = 0;
		String gprices = request.getParameter("gprice");
		//System.out.println("ҳ���ϵļ۸�" + gprices);
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
		List<Regost> list = rb.searchPage_Repertory(regost, page.getPageNo(),
				page.getPageSize());
		// System.out.println("��ӡ"+list.toString());
		request.setAttribute("page", page);
		request.setAttribute("listregost", list);
		request.getSession().setAttribute("regost", regost);
		request.getRequestDispatcher("fruit.jsp").forward(request, response);

	}

	// ��ѯȫ����Ʒ
	private void searchfruit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RepertoryBiz rb = new RepertoryBizImpl(); // ����ҵ����еĿ�� ��ѯ
		List<Regost> listregost = rb.searchRepertory(); // dao���еĲ�ѯ���ķ���
		// System.out.println(listregost.toString());
		request.setAttribute("listregost", listregost); // ����ѯ���Ŀ����Ϣ�ŵ�listregost��
		// Integer gid=Integer.valueOf(request.getParameter("gid"));
		// GoodsBiz gb=new GoodsBizImpl();
		// Goods goods=gb.searchGoods(gid);
		// request.setAttribute("goods", goods);
		request.getRequestDispatcher("fruit.jsp").forward(request, response);
	}

}
