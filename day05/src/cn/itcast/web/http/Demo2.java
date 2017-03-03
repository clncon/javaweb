package cn.itcast.web.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo2
 */
@WebServlet("/Demo2")
public class Demo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo2() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		              String data ="ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
		              //将字符串压缩到GZIPOutputStream中；
		              ByteArrayOutputStream baos = new ByteArrayOutputStream();
		              GZIPOutputStream gs = new GZIPOutputStream(baos);
		              System.out.println("压缩前的长度："+data.length()+"");
		               gs.write(data.getBytes());
		               gs.flush();
		               gs.close();
		               //取出压缩后的数据
		               byte[] buf = baos.toByteArray();
		               System.out.println("压缩后的长度："+buf.length+"");
		               //将压缩后的数据输出到浏览器中
		               response.setHeader("content-Encoding", "gzip");
		               response.setHeader("content-length", buf.length+"");
		               //以字节的形式进行输出
		               response.getOutputStream().write(buf);
		               
		               
		            
	}

	
}
