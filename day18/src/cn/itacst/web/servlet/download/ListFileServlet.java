package cn.itacst.web.servlet.download;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itacst.web.servlet.domain.Up;
import cn.itacst.web.servlet.service.Service;



public class ListFileServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    Service upservice = new Service();
		    try {
				List<Up> uplist = upservice.findAllFile();
				request.setAttribute("uplist",uplist);
				request.getRequestDispatcher("/download.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("MESSAGE","≤È’“œ¬‘ÿ“≥√Ê ß∞‹");
				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
			}
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	 
}
