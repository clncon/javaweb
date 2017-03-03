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
		   //��ȡ�ļ���uuid����
           String uuidfileName=request.getParameter("uuidfileName");
           //���ļ������н���
            byte[] tempName = uuidfileName.getBytes("ISO8859-1");
             uuidfileName = new String(tempName,"UTF-8");
             //����ļ�����ʵ�ļ���
              int index = uuidfileName.indexOf("_");
              String fileRealName = uuidfileName.substring(index+1);
              //����������ļ�Ŀ¼
               String uploadFullPath = request.getServletContext().getRealPath(uploadUtil.uploadPath);
           //����ļ�����ʵ·��
             String fileRealPath= uploadUtil.makeUuidFilePath(uploadFullPath,uuidfileName);
             System.out.println(fileRealPath);
             System.out.println(uuidfileName);
             //�����ļ�������Ӧͷ
             response.setHeader("Content-Disposition","attachment; " +
             		"filename="+URLEncoder.encode(fileRealName, "UTF-8"));
             //��ʼ���ط���
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
