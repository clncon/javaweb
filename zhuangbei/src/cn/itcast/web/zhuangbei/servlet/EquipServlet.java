package cn.itcast.web.zhuangbei.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.web.zhuangbei.Exception.CountException;
import cn.itcast.web.zhuangbei.domain.Borrow;
import cn.itcast.web.zhuangbei.domain.Equipment;
import cn.itcast.web.zhuangbei.service.EquipService;

public class EquipServlet extends HttpServlet {


	EquipService equipservice = new EquipService();
	 //删除一条借贷信息
	protected void deleteBorrow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   try {
			   int id = Integer.parseInt(request.getParameter("id"));
   			   Borrow borrow = equipservice.findBorrowById(id);
   			   equipservice.deleteBorrow(borrow);
   			   request.setAttribute("Message", "删除借贷信息成功");
   			   request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("Message", "删除借贷信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		   
	}
	 
	//添加一条借贷信息
	protected void addBorrow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		  Enumeration<String> eumes = request.getParameterNames();
		   Borrow borrow = new Borrow();
		  while(eumes.hasMoreElements()){
			  String key = eumes.nextElement();
			  String[] values = request.getParameterValues(key);
			  if(!key.equals("method")){
			  BeanUtils.copyProperty(borrow, key, values);
			  }
		  }
		  System.out.println(borrow.getName()+":"+borrow.getCount());
		  equipservice.addBorrow(borrow);
		  request.setAttribute("Message", "添加借贷信息成功");
		  request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		  catch(CountException e){
			  e.printStackTrace();
			  request.setAttribute("Message", "库存已经不足");
			  request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		  }
		catch(Exception e){
			e.printStackTrace();
			request.setAttribute("Message", "添加借贷信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
			
		}
		   
	}
	//查找所有的借贷的装备信息
	protected void findAllBorrow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  try {
			List<Borrow> listborrow = equipservice.findAllBorrow();
			request.setAttribute("listborrow",listborrow);
			request.getRequestDispatcher("/WEB-INF/jsp/listBorrow.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("Message","查询所有借贷信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		}
	}

	 
	 //删除一条装备信息
	protected void deleteEquipment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    int id = Integer.parseInt(request.getParameter("id"));
		    try {
				equipservice.deleteEquipmentById(id);
				request.setAttribute("Message","删除成功");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("Message","删除失败");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				
				e.printStackTrace();
			}
	}

	
	//添加一条装备信息
	protected void addEquiment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			Enumeration<String> enumers = request.getParameterNames();
			Equipment equipment = new Equipment();
			while(enumers.hasMoreElements()){
				String key = enumers.nextElement();
				String[] values = request.getParameterValues(key);
				if(!"method".equals(key)){
					BeanUtils.copyProperty(equipment, key, values);
				}

			}
			equipservice.addEquiment(equipment);
			request.setAttribute("Message","添加装备信息成功");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		} catch( Exception e) {
			request.setAttribute("Message","添加装备信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
             e.printStackTrace();
		} 
	}
	//查询所有的装备信息
	protected void findAllEquipment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		    try {
				List<Equipment> listEquiment = equipservice.findAllEquiment();
				request.setAttribute("ListEquiment", listEquiment);
				request.getRequestDispatcher("/WEB-INF/jsp/listEquipment.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("Message","查询失败");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				e.printStackTrace();
			}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		    String method = request.getParameter("method");
            if("findAllEquipment".equals(method)){
            	this.findAllEquipment(request, response);
            }else if("toAddEquipmentJsp".equals(method)){
                request.getRequestDispatcher("/WEB-INF/jsp/addEquipment.jsp").forward(request, response);
            }else if("addEquiment".equals(method)){
            	this.addEquiment(request, response);
            }else if("deleteEquipment".equals(method)){
            	this.deleteEquipment(request, response);
            }else if("findAllBorrow".equals(method)){
            	this.findAllBorrow(request, response);
            }else if("toAddBorrowJsp".equals(method)){
            	 String  name = request.getParameter("name");
            	  byte[] buf = name.getBytes("ISO8859-1"); 
            	  name = new String(buf,"utf-8");
            	request.setAttribute("Name",name);
            	request.getRequestDispatcher("/WEB-INF/jsp/addBorrow.jsp").forward(request, response);
            }else if("addBorrow".equals(method)){
            	this.addBorrow(request, response);
            }else if("deleteBorrow".equals(method)){
            	this.deleteBorrow(request, response);
            }else if("setPosition".equals(method)){
            	String position = request.getParameter("position");
            	request.setAttribute("Position", position);
            	request.getRequestDispatcher("/WEB-INF/jsp/position.jsp").forward(request, response);
            }
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
         //转到doGet
		 this.doGet(request, response);
		
	}
    
}
