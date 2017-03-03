/*package cn.itacst.web.servlet.upload;

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
import cn.itacst.web.servlet.util.uploadUtil;


public class uploadServlet3 extends HttpServlet {*/

	
	/*public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method = request.getParameter("method");
         if(method!=null){
         	if("upload".equals(method)){
         		
         		this.upload(request, response);
         	}
         	
         }
		
	}*/
    
       



	/*protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/upload.jsp").forward(request, response);
	}*/




	/*protected void upload(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		     
				try {*/
				
			/*	User user = uploadUtil.doupload(request);
				String uploadPath = request.getServletContext().getRealPath(uploadUtil.uploadPath);
				List<Up> list = new ArrayList<Up>();
				 //写到硬盘
				uploadUtil.doSave(user,uploadPath,list);
				 //写到数据库
				  Service upservice =  new Service();
				  upservice.addUps(list);
				 request.setAttribute("MESSAGE", "上传成功");
 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		     }
		     catch (NoUpFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 request.setAttribute("MESSAGE", "没有上传文件");
		 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
				} catch (FileSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 request.setAttribute("MESSAGE", "文件大小必须小于200KB");
		 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
				} catch (UpFileTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 request.setAttribute("MESSAGE", "文件类型只能是.jpg的");
		 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
				}
				catch(Exception e){
					e.printStackTrace();
					 request.setAttribute("MESSAGE", "上传失败");
		 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
				}
		      
       
}
}*/
