package cn.itcast.web.login;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.web.domain.LoginBean;
import cn.itcast.web.domain.User;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/login.jsp")
            .forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		   //建立对象
		User user = new User();

		//获取表单参数
		Enumeration<String> enumer= request.getParameterNames();
		while(enumer.hasMoreElements()){
			String name = enumer.nextElement();
			String[] values = request.getParameterValues(name);
			//封装进Beanutils
			try {
				BeanUtils.setProperty(user, name, values);
			} catch (Exception e) {

				e.printStackTrace();

			}

		}
		LoginBean loginbean = new LoginBean();
		boolean flag = loginbean.vlidate(user);
		if(flag){
			request.setAttribute("LoginBean", loginbean);
			request.getRequestDispatcher("/WEB-INF/success.jsp")
			.forward(request, response);
			
		}
		else{
			request.setAttribute("LoginBean", loginbean);
			request.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(request, response);
		}
	}
}

