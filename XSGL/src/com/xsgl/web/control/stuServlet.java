package com.xsgl.web.control;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xsgl.web.domain.Page;
import com.xsgl.web.domain.Student;
import com.xsgl.web.service.stuService;

public class stuServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           String method = request.getParameter("method");
           if("findAllStudent".equals(method)){
        	   this.findAllStudent(request, response);
           }else if("toAddJsp".equals(method)){
        	   request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
           }else if("findStudentById".equals(method)){
        	    this.findStudentById(request, response);
           }else if("deleteStudent".equals(method)){
        	   this.deleteStudent(request, response);
           }
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
		    String method = request.getParameter("method");
		    if("add".equals(method)){
		    	this.add(request, response);
		    }else if("update".equals(method)){
		    	this.update(request, response);
		    }
	}
	//ɾ���û�����Ϣ
	
	protected void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   String strId = request.getParameter("strId");
		   stuService stuservice = new stuService();
		   int id=0;
		 try {
		     String[] ids = strId.split("_");
		     for(int i=0;i<ids.length;i++){
			   id = Integer.parseInt(ids[i]);
				stuservice.deleteStudentById(id);
				request.setAttribute("message","ɾ��ѧ����Ϣ�ɹ�");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
		     }
		 } catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("message","ɾ��ѧ����Ϣʧ��");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
			}
		   
	}

	//����ѧ������Ϣ
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = new Student();
		Enumeration<String> enumers = request.getParameterNames();
		while(enumers.hasMoreElements()){
			String key = enumers.nextElement();
			String[] values = request.getParameterValues(key);
			if(!key.equals("method")){
				try {
					BeanUtils.setProperty(student, key, values);
				} catch (Exception e) {

					e.printStackTrace();
					request.setAttribute("message","����ѧ����Ϣʧ��");
					request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
				} 
			}

		}
		stuService stuService = new stuService();
		student.setId(id);
		try {
			stuService.UpdateStudentById(student);
			request.setAttribute("message","����ѧ����Ϣ�ɹ�");
			request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
			request.setAttribute("message","����ѧ����Ϣʧ��");
			request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
		}
	}
	//����ĳ��ѧ����Ϣͨ��id
	
	


	protected void findStudentById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     int id = Integer.parseInt(request.getParameter("id"));
		     stuService service = new stuService();
	         try {
				Student stu = service.findStudentById(id);
				request.setAttribute("Stu", stu);
				request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request,response);
			} catch (SQLException e) {
				request.setAttribute("message","��ѯѧ����Ϣʧ��");
				request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
				e.printStackTrace();
			}	     
	}
    



	//�������е�ѧ����Ϣ
	public void findAllStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            
            try {
            	request.setCharacterEncoding("UTF-8");
            	int currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
                stuService stuService = new stuService();
				Page page = stuService.findAllStudent(currentPageNo);
				request.setAttribute("Page", page);
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message","��ѯѧ������Ϣʧ��");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
	}


	//����һ����¼
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Student student = new Student();
			Enumeration<String> enumers = request.getParameterNames();
			while(enumers.hasMoreElements()){
				String key = enumers.nextElement();
				//System.out.println(key);
			
				String[] values = request.getParameterValues(key);
				    if(!key.equals("method")){
					BeanUtils.setProperty(student,key,values);
				    }

			
			}
         //System.out.println(student.getChinese());
		stuService service = new stuService();
		service.addRecorder(student);
		request.setAttribute("message","����û���Ϣ�ɹ�");
		request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		request.setAttribute("message","����û���Ϣʧ��");
		request.getRequestDispatcher("/WEB-INF/jsp/message2.jsp").forward(request, response);
	}
	
	
	}
	}

