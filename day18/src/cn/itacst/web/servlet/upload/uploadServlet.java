package cn.itacst.web.servlet.upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itacst.web.servlet.domain.Up;
import cn.itacst.web.servlet.domain.User;
import cn.itacst.web.servlet.exception.FileSizeException;
import cn.itacst.web.servlet.exception.NoUpFileException;
import cn.itacst.web.servlet.exception.UpFileTypeException;
import cn.itacst.web.servlet.service.Service;
import cn.itacst.web.servlet.util.jdbcUtils;
import cn.itacst.web.servlet.util.uploadUtil;


public class uploadServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method = request.getParameter("method");
         if(method!=null){
         	if("upload".equals(method)){
         		
         		this.upload(request, response);
         	}
         	
         }
		
	}
    
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/upload.jsp").forward(request, response);
	}




	protected void upload(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		     
				try {
				
				List<Up> list = new ArrayList<Up>();
				User user = uploadUtil.doupload(request,list);
				String uploadPath = request.getServletContext().getRealPath(uploadUtil.uploadPath);
				//���￪ʼ
				jdbcUtils.begin();
				//д�����ݿ�
				Service upservice =  new Service();
				upservice.addUps(list);
				   //int i = 10/0;
				 //д��Ӳ��
				uploadUtil.doSave(user,uploadPath,list);
				  //�����ύ
				  jdbcUtils.commit();
				 request.setAttribute("MESSAGE", "�ϴ��ɹ�");
 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		     }
		     catch (NoUpFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 request.setAttribute("MESSAGE", "û���ϴ��ļ�");
		 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
				} catch (FileSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 request.setAttribute("MESSAGE", "�ļ���С����С��200KB");
		 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
				} catch (UpFileTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 request.setAttribute("MESSAGE", "�ļ�����ֻ����.jpg��");
		 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
				}
				catch(Exception e){
					e.printStackTrace();
					 try {
						 //����ع�
						jdbcUtils.rollback();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						request.setAttribute("MESSAGE","�ع�����ʧ��");
						request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
						e1.printStackTrace();
					}
					 request.setAttribute("MESSAGE", "�ϴ�ʧ��");
		 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
				}
		      
       
}
}
