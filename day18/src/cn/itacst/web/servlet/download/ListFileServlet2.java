package cn.itacst.web.servlet.download;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itacst.web.servlet.util.uploadUtil;

public class ListFileServlet2 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   //取得下载文件的目录，即upload目录
		   String uploadRealPath = request.getServletContext().getRealPath(uploadUtil.uploadPath);
		   //创建一个Map<uuid文件名,文件名>
		    Map<String,String> map = new HashMap<String,String>();
		   getFiles(uploadRealPath,map);
		   request.setAttribute("MAP", map);
		  request.getRequestDispatcher("/download.jsp").forward(request, response);
	}
    private void getFiles(String uploadPath, Map<String, String> map){
        File file = new File(uploadPath);
    	if(file.isFile()){
    	  String uuidFileName = file.getName();
    	  int index = uuidFileName.indexOf("_");
    	  String realName = uuidFileName.substring(index+1);
    	  map.put(uuidFileName,realName);
    	}
    	else
    	{
    		File[] files = file.listFiles();
    		for(File file2:files){
    			getFiles(file2.getPath(),map);
    		}
    		
    	}
    	
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	 
}
