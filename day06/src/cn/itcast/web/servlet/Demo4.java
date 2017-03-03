package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo4 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*		��ͳ��ʽ
	    InputStream is = new FileInputStream("src/config.properties");
		Properties pro = new Properties();
		pro.load(is);
		String value = pro.getProperty("email");
		System.out.println(value);*/
		//ʹ��ServletContext��������ļ���ע���ļ���·��
		ServletContext context = this.getServletContext();
		InputStream is = context.getResourceAsStream("/config.properties");
		Properties props = new Properties();
		props.load(is);
		String value = props.getProperty("email");
		response.getWriter().write(value);
	}

}
