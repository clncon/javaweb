package cn.itcast.web.servlet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Demo7 extends HttpServlet {
	
	protected long getLastModified(HttpServletRequest req) {
		System.out.println("modified");
		String path = req.getServletContext().getRealPath("/doc/aa.txt");
		File file = new File(path);
		return file.lastModified();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  System.out.println("doGet");
          InputStream is = this.getServletContext().getResourceAsStream("/doc/aa.txt");
          OutputStream os = response.getOutputStream();
          byte[] buf = new byte[1024];
          int len = 0;
          while((len=is.read(buf))>0){
        	  os.write(buf, 0, len);
          }
          is.close();
          os.close();
		
	}


}
