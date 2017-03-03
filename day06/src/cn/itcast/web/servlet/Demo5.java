package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo5 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ʹ�������������ȡ�ļ���ֻ�ܼ���srcĿ¼�µ��ļ�
           //ȡ�õ�ǰ������ֽ������
		    Class clazz = this.getClass();
		    //ȡ�õ�ǰ������������
		    ClassLoader cl = clazz.getClassLoader();
		    //ȡ�ö�ȡ�ļ���������
		    InputStream is = cl.getResourceAsStream("/config.properties");
		    Properties props = new Properties();
		    props.load(is);
		    response.getWriter().write(props.getProperty("email"));
		
	}

}
