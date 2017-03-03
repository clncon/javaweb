package com.xsgl.web.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xsgl.web.domain.MyClass;
import com.xsgl.web.domain.Student;
import com.xsgl.web.service.stuService;

public class OrderServlet extends HttpServlet {
   private stuService stuservice = new stuService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String select = request.getParameter("select");
           if("id".equals(select)){
        	    this.OrederStudentById(request, response);
           }else if("myclass".equals(select)){
        	       this.OrderAllClass(request, response);
        	   }
        	   
       
           
           else{
        	   String course = request.getParameter("course");
        	   if("english".equals(course)){
        		   this.OrderStudentByEnglish(request, response);
        	   }else if("math".equals(course)){
        		   this.OrderStudentByMath(request, response);
        	   }else if("chinese".equals(course)){
        		    this.OrderStudentByChinese(request,response);
        	   }else if("sum".equals(course)){
        		    this.OrderStudentBySum(request, response);
        	   }
           }
		
	}
	  //通过总分来排序

	protected void OrderAllClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String course = request.getParameter("course");
		String selectClass = request.getParameter("selectClass");
		String order = request.getParameter("order");
		request.setAttribute("SELECT",selectClass);
		if(course.equals("english")){
			request.setAttribute("COURSE","英语");
			
		}else if(course.equals("math")){
			request.setAttribute("COURSE","数学");
			
		}
		else if(course.equals("chinese")){
			request.setAttribute("COURSE","语文");
			
		}
		
		Map<String,List<MyClass>> map=null;
		try {
	    if("great".equals(selectClass)&&"asc".equals(order)){
			map = stuservice.QueryAllClassByGreateInAsc(course);
		    List<MyClass> listClassByAsc = map.get(course);
			request.setAttribute("LISTCLASS",listClassByAsc);
			request.getRequestDispatcher("/WEB-INF/jsp/listAllClass.jsp").forward(request, response);
	    }	
	    else if("great".equals(selectClass)&&"desc".equals(order)){
	    	map = stuservice.QueryAllClassByGreateInDesc(course);
			List<MyClass> listClassByDesc = map.get(course);
			request.setAttribute("LISTCLASS",listClassByDesc);
			request.getRequestDispatcher("/WEB-INF/jsp/listAllClass.jsp").forward(request, response);
	    }else if("fail".equals(selectClass)&&"asc".equals(order)){
	    	map = stuservice.QueryAllClassByFailInAsc(course);
	    	 List<MyClass> listClassByAsc = map.get(course);
		     request.setAttribute("LISTCLASS",listClassByAsc);
	    	request.getRequestDispatcher("/WEB-INF/jsp/listAllClass.jsp").forward(request, response);
	    	
	    }else if("fail".equals(selectClass)&&"Desc".equals(order)){
	    	map = stuservice.QueryAllClassByFailInDesc(course);
	    	 List<MyClass> listClassByDesc = map.get(course);
		     request.setAttribute("LISTCLASS",listClassByDesc);
	    	request.getRequestDispatcher("/WEB-INF/jsp/listAllClass.jsp").forward(request, response);
	    	
	    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","排序每个班级的失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
		}
	  
			
		
		
	}
    //通过总分来排序
	protected void OrderStudentBySum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String order = request.getParameter("order");
		try {
			List<Student> liststu = stuservice.OrderStudentBySum(order);
			request.setAttribute("LISTSTU", liststu);
			request.getRequestDispatcher("/WEB-INF/jsp/orderStudent.jsp").forward(request, response);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","<font color='red' size='44'>排序失败</font>");
			request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			
		}
	}
	 //通过语文成绩来排序
	
	protected void OrderStudentByChinese(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    String order = request.getParameter("order");
		    try {
				List<Student> liststu = stuservice.OrderStudentByChinese(order);
				request.setAttribute("LISTSTU", liststu);
				request.getRequestDispatcher("/WEB-INF/jsp/orderStudent.jsp").forward(request, response);
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message","<font color='red' size='44'>排序失败</font>");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
				
			}
	}

	 //通过数学成绩来排序
	
	

		protected void OrderStudentByMath(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			  String order = request.getParameter("order");
			  try {
				List<Student> liststu = stuservice.OrderStudentByMath(order);
				request.setAttribute("LISTSTU", liststu);
				request.getRequestDispatcher("/WEB-INF/jsp/orderStudent.jsp").forward(request, response);
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message","<font color='red' size='44'>排序失败</font>");
				request.getRequestDispatcher("/WEB-INF/jsp/orderStudent.jsp").forward(request, response);
				
			}
		}
     //通过英语成绩来排序
	
	
	protected void OrderStudentByEnglish(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   String order  = request.getParameter("order");
		   try {
			List<Student> liststu = stuservice.OrderStudentByEnglish(order);
			request.setAttribute("LISTSTU", liststu);
			request.getRequestDispatcher("/WEB-INF/jsp/orderStudent.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","<font color='red' size='44'>排序失败</font>");
			request.getRequestDispatcher("/WEB-INF/jsp/orderStudent.jsp").forward(request, response);
			
		}
	}
   

	//通过id来排序
	protected void OrederStudentById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    String order = request.getParameter("order");
		    try {
				List<Student> liststu = stuservice.OrderStudentById(order);
				request.setAttribute("LISTSTU", liststu);
				request.getRequestDispatcher("/WEB-INF/jsp/orderStudent.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message","<font color='red' size='44'>排序失败</font>");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			}
	}

	
	}
	


