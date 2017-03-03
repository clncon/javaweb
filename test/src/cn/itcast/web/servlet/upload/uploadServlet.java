package cn.itcast.web.servlet.upload;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itacst.web.servlet.domain.User;
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
			throws ServletException, IOException {
	
				
				try {
					User user = uploadUtil.doupload(request);
					String uploadPath = request.getServletContext().getRealPath(uploadUtil.uploadPath);
					uploadUtil.doSave(user,uploadPath);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 request.setAttribute("MESSAGE", "上传成功");
 				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
     		    
			
       
}
}
