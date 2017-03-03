package cn.itcast.web.crm.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.web.crm.domain.Customer;
import cn.itcast.web.crm.domain.Page;
import cn.itcast.web.crm.service.CrmService;

public class CrmServlet extends HttpServlet {

	
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String method = request.getParameter("method");
            if("findAllCustomer".equals(method)){
            	this.findAllCustomer(request, response);
            }else if("findCustomerById".equals(method)){
            	this.findCustomerById(request, response);
            }else if("deleteCustomerById".equals(method)){
            	   this.deleteCustomerById(request, response);
            }else if("toAddJsp".equals(method)){
            	 request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
            }
		
	}

	
     

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		  String method = request.getParameter("method");
		  if(method!=null){
			   if("add".equals(method)){
				   this.add(request, response);
			   }else if("update".equals(method)){
				   this.update(request, response);
			   }
			  
		  }
	}


    
	
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    int id = Integer.parseInt(request.getParameter("id"));
		    Customer newCustomer = new Customer();
		    Enumeration<String> enumes = request.getParameterNames();
		    while(enumes.hasMoreElements()){
		    	String key = enumes.nextElement();
		    	String[] vlaues = request.getParameterValues(key);
		    	try {
		    		//注意！！！！！！！！！
		    		if(!"method".equals(key)){
					BeanUtils.setProperty(newCustomer,key, vlaues);
		    		}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("message", "更新客户信息失败");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				} 
		    }
		    try {
		    	newCustomer.setId(id);
		    	CrmService service = new CrmService();
				service.updateCustomerById(newCustomer);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "更新客户信息失败");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
		    request.setAttribute("message", "更新客户信息成功");
		    request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		    
	}




	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Customer customer = new  Customer();
			Enumeration<String> enumes = request.getParameterNames();
			while(enumes.hasMoreElements()){
				String key = enumes.nextElement();
				String[] vlaues = request.getParameterValues(key);
				if(!key.equals("method")){
				BeanUtils.setProperty(customer, key, vlaues);
				}
			}
			CrmService service = new CrmService();
			service.addCustomer(customer);
			request.setAttribute("message","新增用户信息成功");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		         catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("message","新增用户信息失败");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
					
				}
		
		    
	}
	public void findAllCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  try {
			  
			 int currPageNO = Integer.parseInt(request.getParameter("currPageNO"));
			 CrmService crmservice = new CrmService();
			 Page page = crmservice.findAllCustomer(currPageNO);
			 request.setAttribute("page", page);
			 request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message","查询所有客户信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request,response);
		}
		  

	}


	protected void findCustomerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  try {
			  int id = Integer.parseInt(request.getParameter("id"));
			  CrmService crmService = new CrmService();
			  Customer customer = crmService.findCustomerById(id);
			  request.setAttribute("customer", customer);
			  request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "查询个人信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
	}

	
	protected void deleteCustomerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    try {
		        String strId = request.getParameter("strId");
		        String[] ids = strId.split("_");
		    	CrmService service = new CrmService();
		    	for(int i=0;i<ids.length;i++)
				{
		    		int id = Integer.parseInt(ids[i]);
		    		service.deleteCustomerById(id);
				
				}
				 request.setAttribute("message", "删除个人信息成功");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", "删除个人信息失误");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
	}

	
	
	
	

}
