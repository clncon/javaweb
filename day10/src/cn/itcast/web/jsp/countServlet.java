package cn.itcast.web.jsp;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.web.domain.countBean;

public class countServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            double firstNumber = Double.parseDouble(request.getParameter("firstNumber"));
            double secondNumber = Double.parseDouble(request.getParameter("secondNumber"));
            String operator = request.getParameter("operator");
            countBean cb = countBean.getBean();
            cb.setFirstNumber(firstNumber);
            cb.setSecondNumber(secondNumber);
            cb.setOperator(operator);
           
           /* BeanUtils bu = new BeanUtils();
            try {
				bu.setProperty(cb, "firstNumber", firstNumber);
				bu.setProperty(cb, "secondNumber", firstNumber);
				bu.setProperty(cb, "operator", operator);
			} catch (IllegalAccessException e) {
		
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				
				e.printStackTrace();
			}*/
            cb.counting(firstNumber, secondNumber, operator);
            request.getRequestDispatcher("/count.jsp").forward(request, response);
	}

}
