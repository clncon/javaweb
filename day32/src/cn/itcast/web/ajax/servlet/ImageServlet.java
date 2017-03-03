package cn.itcast.web.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.itcast.web.ajax.dao.ImageDao;
import cn.itcast.web.ajax.domain.Image;

public class ImageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           int id = Integer.parseInt(request.getParameter("id"));
           System.out.println("id:"+id);
           String jsonString = null;
           ImageDao imagedao = new ImageDao();
           Image image = imagedao.findImageById(id);
          JSONArray jsonarray = JSONArray.fromObject(image);
           jsonString = jsonarray.toString();
           System.out.println(jsonString);
           response.setContentType("text/html;charset=utf-8");
           response.getWriter().write(jsonString);
           
	
	}

}
