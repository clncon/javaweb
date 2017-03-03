package cn.itcast.web.http;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo4
 */
@WebServlet("/Demo4")
public class Demo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-disposition", "attachment; filename=Watch_Dogs.jpg");
		FileInputStream fins = new FileInputStream("D:\\Watch_Dogs.jpg");
	     ServletOutputStream ops = response.getOutputStream();
	     byte[] buffer = new byte[1024];
	     int len=0;
	     while((len = fins.read(buffer))>0){
	    	 ops.write(buffer, 0, len);
	     }
	     fins.close();
	     ops.close();
		
		
		
		
		
	}


	

}
