package com.dream.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.dream.entity.Goods;
import com.dream.entity.Orders;
import com.dream.entity.Purchase;
import com.dream.entity.User;
import com.dream.entity.view.Orpu;
import com.dream.entity.view.Ougp;
import com.dream.entity.view.Regost;

public class GouwuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String todo = request.getParameter("todo");
		if (todo != null) {
			if ("gouwuche".equals(todo)) {               //������
				this.gouwuche(request, response);
			} else if ("jiesuan".equals(todo)) {         //����
				this.jiesuan(request, response);
			} else if ("ajax".equals(todo)) {            
				this.ajax(request, response);
				// }else if("jiejie".equals(todo)){
				// this.jiejie(request, response);
				// }
				// } else if ("deletegowu".equals(todo)) {
				// this.deletegowu(request, response);
				// }
			}
		}

	}

	// private void deletegowu(HttpServletRequest request,
	// HttpServletResponse response) {
	// String gId = request.getParameter("gId");
	// User user = (User) request.getSession().getAttribute("user");
	// Map<Integer, List<Ougp>> gwc = (Map<Integer, List<Ougp>>)
	// request.getSession().getAttribute("gwc");
	// List<Ougp> list = gwc.get(user.getuId());
	// //list.remove();
	//
	//
	// }

	// private void jiejie(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// String num1 = request.getParameter("num");
	// System.out.println(num1);
	//
	//
	// int num = Integer.parseInt(request.getParameter("pnum"));
	// User user = (User)request.getSession().getAttribute("user");
	// Map<Integer, List<Ougp>> gwc=( Map<Integer, List<Ougp>>)
	// request.getSession().getAttribute("gwc");
	// List<Ougp> list= gwc.get(user.getuId());
	// for (Ougp ougp : list) {
	// ougp.setpNum(num);
	// }
	// request.getRequestDispatcher("jiesuan.jsp").forward(request, response);
	// }

	private void ajax(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String address1 = request.getParameter("address");
		String address = null;
		if (address1 != null && !"".equals(address1)) {
			address = new String(address1.getBytes("ISO-8859-1"), "UTF-8");
			// System.out.println("ת�����ͣ�" + address1);
		}
		User user = (User) request.getSession().getAttribute("user");
		user.setuAddress(address);
		UserBiz ub = new UserBizImpl();
		ub.updateUser(user);
		// System.out.println(address);
		// System.out.println(user.toString());
	}

	private void jiesuan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String zongjia=request.getParameter("zongjia");//�����ܼ�
		// request.getSession().setAttribute("zongjia", zongjia);
		// int gId= request.getParameter("gId");
		// System.out.println(gId);
		// int pum=Integer.parseInt(request.getParameter("num"));//��Ʒ������
		// double
		// gprice=Double.parseDouble(request.getParameter("gprice"));//��Ʒ�ļ۸�
		// User user=(User)request.getSession().getAttribute("user");//�û�
		// Map<Integer, List<Ougp>> gouwu=( Map<Integer, List<Ougp>>)
		// request.getSession().getAttribute("gwc");
		// List<Ougp> listOugp= gouwu.get(user.getuId());
		// for (Ougp ougp : listOugp) {
		// //ougp.setpNum(pum);
		// ougp.setgPrice(gprice);
		// }//���ﳵ���ݸı�
		//
		// double zongjia=Double.parseDouble(request.getParameter("zongjia"));
		// request.setAttribute("zongjia", zongjia);
		String date = request.getParameter("date");
		User user = (User) request.getSession().getAttribute("user");
		UserBiz ub = new UserBizImpl();
		User user1 = ub.searchUser(user.getuPhone());
		Map<Integer, List<Ougp>> gwc = (Map<Integer, List<Ougp>>) request
				.getSession().getAttribute("gwc");
		List<Ougp> list = gwc.get(user.getuId());
		OrderBiz ob = new OrderBizImpl();
		PurchaseBiz pb = new PurchaseBizImpl();
		Regost regost = (Regost) request.getSession().getAttribute("regost");
		for (Ougp ougp : list) {// psid,pgid,puid,pnum

			Purchase pc = new Purchase();

			pc.setpSid(2);
			pc.setpGid(ougp.getgId());
			pc.setpUid(user.getuId());
			pc.setpNum(ougp.getpNum());
			pb.add(pc);
			Purchase tempPur = pb.searchPurchase(pc.getpUid(), pc.getpSid(),
					pc.getpGid());
			Orders orders = new Orders();
			// oPid,oStartdate,oAddress
			// System.out.println(user1.getuAddress());
			orders.setoAddress(user1.getuAddress());
			orders.setoStartdate(date);
			orders.setoPid(tempPur.getpId());
			orders.setoStatus("δ���");
			ob.add(orders);

			Orders o = ob.searchOrder(tempPur.getpId());
			request.getSession().setAttribute("oid", o.getoId());
		}

		request.setAttribute("list", list);
		request.getSession().removeAttribute("gwc");
		request.getRequestDispatcher("success.jsp").forward(request, response);

	}

	private void gouwuche(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {// �û���Ϊ��

			int gId = Integer.parseInt(request.getParameter("gId"));// ��Ʒ��ID
			int add = Integer.parseInt(request.getParameter("add"));// ���������
			GoodsBiz gb = new GoodsBizImpl();
			Goods goods = gb.searchGoods(gId);// �õ������Ʒ
			UserBiz ub = new UserBizImpl();
			User tempUser = ub.searchUser(user.getuId());// �õ�����û���������Ϣ;
			// System.out.println(ub.searchUser(user.getuId()).getuMail());
			// System.out.println(tempUser.toString());
			Map<Integer, List<Ougp>> gouwu = (Map<Integer, List<Ougp>>) request
					.getSession().getAttribute("gwc");
			if (gouwu == null) {// ��һ�ν���

				Map<Integer, List<Ougp>> gwc = new HashMap<Integer, List<Ougp>>();// ����һ�����ﳵ
				List<Ougp> listOugp = new ArrayList<Ougp>();// ���ﳵ�еĶ���
				Ougp ougp = new Ougp();
				ougp.setgId(gId);
				ougp.setgName(goods.getgName());// ������Ʒ
				ougp.setgPrice(goods.getgPrice());// ��Ʒ�ĵ���
				ougp.setpNum(add);// ��������
				ougp.setgPic(goods.getgPic());// ͼƬ
				// System.out.println(ougp.toString());
				// ougp.setoAddress(tempUser.getuAddress());//������ַ
				// ougp.setoStartdate("2016.3.1");//��������
				listOugp.add(ougp);
				gwc.put(tempUser.getuId(), listOugp);
				request.getSession().setAttribute("gwc", gwc);// ����Ϣ���빺�ﳵ��
				request.getRequestDispatcher("gouwuche.jsp").forward(request,
						response);

			} else {// �ڶ��ν���
				List<Ougp> listOugp = gouwu.get(user.getuId());
				Boolean newOug = false;// û�е�ǰҪ�������Ʒ
				for (Ougp ougp : listOugp) {
					if (gId == ougp.getgId()) {// �д���Ʒ
						newOug = true;
						int a = ougp.getpNum() + add;
						ougp.setpNum(a);// ֻ������

					}
				}
				if (!newOug) {// û�д���Ʒ
					Ougp newOugp = new Ougp();
					newOugp.setgId(gId);
					newOugp.setgName(goods.getgName());
					newOugp.setpNum(add);
					newOugp.setgPrice(goods.getgPrice());
					newOugp.setgPic(goods.getgPic());
					listOugp.add(newOugp);

					request.getRequestDispatcher("gouwuche.jsp").forward(
							request, response);
				} else {// �д���Ʒ
					request.getRequestDispatcher("gouwuche.jsp").forward(
							request, response);

				}

			}

		} else {// �û�Ϊ��
			response.sendRedirect(request.getContextPath() + "/login.jsp");

		}

	}

}
