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
		              //���ַ���ѹ����GZIPOutputStream�У�
		              ByteArrayOutputStream baos = new ByteArrayOutputStream();
		              GZIPOutputStream gs = new GZIPOutputStream(baos);
		              System.out.println("ѹ��ǰ�ĳ��ȣ�"+data.length()+"");
		               gs.write(data.getBytes());
		               gs.flush();
		               gs.close();
		               //ȡ��ѹ���������
		               byte[] buf = baos.toByteArray();
		               System.out.println("ѹ����ĳ��ȣ�"+buf.length+"");
		               //��ѹ���������������������
		               response.setHeader("content-Encoding", "gzip");
		               response.setHeader("content-length", buf.length+"");
		               //���ֽڵ���ʽ�������
		               response.getOutputStream().write(buf);
		               
		               
		            
	}

	
}
