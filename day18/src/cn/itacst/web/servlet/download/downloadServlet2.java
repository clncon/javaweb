package cn.itacst.web.servlet.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itacst.web.servlet.util.uploadUtil;

public class downloadServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   //获取文件的uuid名称
           String uuidfileName=request.getParameter("uuidfileName");
           //对文件名进行解码
            byte[] tempName = uuidfileName.getBytes("ISO8859-1");
             uuidfileName = new String(tempName,"UTF-8");
             //获得文件的真实文件名
              int index = uuidfileName.indexOf("_");
              String fileRealName = uuidfileName.substring(index+1);
              //获得完整的文件目录
               String uploadFullPath = request.getServletContext().getRealPath(uploadUtil.uploadPath);
           //获得文件的真实路径
             String fileRealPath= uploadUtil.makeUuidFilePath(uploadFullPath,uuidfileName);
             System.out.println(fileRealPath);
             System.out.println(uuidfileName);
             //设置文件下载响应头
             response.setHeader("Content-Disposition","attachment; " +
             		"filename="+URLEncoder.encode(fileRealName, "UTF-8"));
             //开始下载服务
              InputStream is =  new FileInputStream(fileRealPath+"/"+uuidfileName);
              OutputStream os =  response.getOutputStream();
              int len=0;
              byte[] buf = new byte[1024];
              while((len=is.read(buf))>0){
            	  
            	  os.write(buf);
              }
             
              is.close();
              os.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
