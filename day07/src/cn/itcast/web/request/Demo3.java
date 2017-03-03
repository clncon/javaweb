package cn.itcast.web.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.web.domain.userDemo;

public class Demo3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取URL的参数对应的值
            String username = request.getParameter("username");
            int  age = Integer.parseInt(request.getParameter("age"));
            double salary = Double.parseDouble(request.getParameter("salary"));
            String[] likes = request.getParameterValues("likes");
            //获取javaBean对象和BeanUtils对象
            userDemo user = new userDemo();
            BeanUtils bu = new BeanUtils();
            try {
				bu.setProperty(user, "username", username);
				bu.setProperty(user, "age", age);
				bu.setProperty(user, "salary", salary);
				bu.setProperty(user, "likes", likes);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
            PrintWriter pw = response.getWriter();
            pw.write("Name:"+user.getUsername()+"<br/>");
            pw.write("age:"+user.getAge()+"<br/>");
            pw.write("Salary:"+String.valueOf(user.getSalary())+"<br/>");
            pw.write("likes:"+user.getLikes().length+"<br/>");
            
	}
               
            
            
	
	}


