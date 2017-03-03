package cn.itcast.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo17 extends HttpServlet {

	
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     //获取在xml的文件路径
             ServletConfig config =this.getServletConfig();
             String filepath = config.getInitParameter("filepath");
             File file = new File(filepath);
             //设置响应头表示以下载的方式处理文件
             response.setHeader("content-disposition", "attachment; filename="+file.getName());
             //进行流处理
             InputStream  is = new FileInputStream(file);
             OutputStream os = response.getOutputStream();
             byte[] buffer = new byte[1024];
             int len=0;
             while((len=is.read(buffer))>0){
            	 os.write(buffer, 0, len);
            	 
             }
             os.close();
             is.close();
             
		
	}


}
