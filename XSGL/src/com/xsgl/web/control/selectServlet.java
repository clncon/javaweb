package com.xsgl.web.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xsgl.web.domain.Page;
import com.xsgl.web.domain.Student;
import com.xsgl.web.exception.gradesException;
import com.xsgl.web.service.stuService;

public class selectServlet extends HttpServlet {
	 private stuService stuservice = new stuService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");
         String select = request.getParameter("select");
         String course = request.getParameter("course");
         System.out.println(course);
         if(select.equals("id")){
        	 request.setAttribute("select",select);
        	this.selectId(request, response);
         }else if(select.equals("name")){
        	 request.setAttribute("select",select);
        	 this.selectName(request, response);
         }else if(select.equals("myClass")){
        	 request.setAttribute("select",select);
        	 this.selectClass(request, response);
         }else if(course.equals("english")){
        	 
        	 this.findStudentByEnglish(request, response);
         }else if(course.equals("math")){
        	 this.findStudentByMath(request, response);
         }else if(course.equals("chinese")){
        	 this.findStudentByChinese(request, response);
         }
		
	}

      
	 //����ѧ����Ӣ��ɼ���ѯ
	protected void findStudentByEnglish(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     try {
		    	 String selectname = request.getParameter("selectname");
		    	 request.setAttribute("selectname", selectname);
				List<Student> liststu = stuservice.findStudentByEnglish(selectname);
				Page page = new Page();
				page.setListStudent(liststu);
				request.setAttribute("Page", page);
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			} catch (gradesException e) {
				
				e.printStackTrace();
				request.setAttribute("message", "�밴�ո�ʽ��д");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "��ѯ");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			}
	}
   
     //����ѧ����ѧ�ɼ���ѯ
	protected void findStudentByMath(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     String selectname = request.getParameter("selectname");
		     request.setAttribute("selectname", selectname);
		     try {
				List<Student> liststu = stuservice.findStudentByMath(selectname);
				Page page = new Page();
				page.setListStudent(liststu);
				request.setAttribute("Page", page);
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			} catch (gradesException e) {
				
				e.printStackTrace();
				request.setAttribute("message", "�밴�ո�ʽ��д");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "��ѯ");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			}
	}
    //�������ĳɼ���ѯ
	protected void findStudentByChinese(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     String selectname = request.getParameter("selectname");
		     request.setAttribute("selectname", selectname);
		     try {
				List<Student> liststu = stuservice.findStudentByChinese(selectname);
				Page page = new Page();
				page.setListStudent(liststu);
				request.setAttribute("Page", page);
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			} catch (gradesException e) {
				
				e.printStackTrace();
				request.setAttribute("message", "�밴�ո�ʽ��д");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "��ѯ");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			}
	}
   
	//����id�Ų�ѯѧ����Ϣ
	protected void selectId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		 
		 try {
			 String selectname = request.getParameter("selectname");
			 request.setAttribute("selectname", selectname);
			 int id = Integer.parseInt(selectname);
			  Page page = new Page();
			List<Student> liststu = new ArrayList<Student>();
			Student student= stuservice.findStudentById(id);
			liststu.add(student);
			page.setListStudent(liststu);
			request.setAttribute("Page",page);
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			
		 }
			catch(Exception e){
			    e.printStackTrace();
			    request.setAttribute("message","��ѯidʧ��");
			    request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			    
			}
	}


	//����ѧ��������ѯ��Ϣ
	protected void selectName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   String name = request.getParameter("selectname");
		   request.setAttribute("selectname", name);
		  // System.out.println(name);
		   try {
			List<Student> liststu = stuservice.findStudentByName(name);
			Page page = new Page();
			page.setListStudent(liststu);
			request.setAttribute("Page",page);
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "��ѯ����ʧ��");
			request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
		}
	}



	protected void selectClass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  
		String myClass = request.getParameter("selectname");
		request.setAttribute("selectname", myClass);
		
		try {
			List<Student> liststu = stuservice.findStudentByClass(myClass);
			Page page = new Page();
			page.setListStudent(liststu);
			request.setAttribute("Page",page);
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message","��ѯ�༶ʧ��");
			request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
		}
		
	}
	
   
}
