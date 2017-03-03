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
		//使用类加载器来读取文件，只能加载src目录下的文件
           //取得当前对象的字节码对象
		    Class clazz = this.getClass();
		    //取得当前对象的类加载器
		    ClassLoader cl = clazz.getClassLoader();
		    //取得读取文件的流对象
		    InputStream is = cl.getResourceAsStream("/config.properties");
		    Properties props = new Properties();
		    props.load(is);
		    response.getWriter().write(props.getProperty("email"));
		
	}

}
