package cn.itacst.web.servlet.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itacst.web.servlet.domain.Up;
import cn.itacst.web.servlet.service.Service;
import cn.itacst.web.servlet.util.uploadUtil;

public class downloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   //获取文件的uuid名称
           String uuidfileName=request.getParameter("uuidfileName");
           //对文件名进行解码
            byte[] tempName = uuidfileName.getBytes("ISO8859-1");
             uuidfileName = new String(tempName,"UTF-8");
             System.out.println(uuidfileName);
             
              //获取文件真实名
               Service service = new Service();
             
			try {
				Up up = service.findUuidFileUp(uuidfileName);
				String fileRealName = up.getFileRealName();
				System.out.println(fileRealName);
	              String filePath = this.getServletContext().getRealPath(uploadUtil.uploadPath);
	              String fileRealPath = uploadUtil.makeUuidFilePath(filePath, uuidfileName);
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
