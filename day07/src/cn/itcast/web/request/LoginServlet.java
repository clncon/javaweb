package cn.itcast.web.request;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.domain.ipCheckBean;

public class LoginServlet extends HttpServlet {
 private Map<String,String> map = new HashMap<String,String>();
	
	
	public void init() throws ServletException {
		map.put("127.0.0.1","合肥");
		map.put("192.168.0.104","北京");
		map.put("192.168.0.105","上海");
		map.put("192.168.0.106","广州");
		map.put("192.168.0.107","南京");
		map.put("192.168.0.108","重庆");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  //设置post发送方式的编码
		   request.setCharacterEncoding("UTF-8");
		     //获取ip地址
		    String ip = request.getRemoteAddr();
		     //获取javaBean对象
		    ipCheckBean ipcb = new ipCheckBean();
		    String address = ipcb.ipCheck(ip, map);
		    //获取表单数据
		    String username = request.getParameter("username");
		    //获取ServletContext对象，封装值
		    ServletContext context =this.getServletContext();
            context.setAttribute("IP", ip);
            context.setAttribute("ADDRESS", address);
            context.setAttribute("USERNAME", username);
            
            //转发
            //request.getRequestDispatcher("/showServlet").forward(request, response);
		    response.sendRedirect("/day07/showServlet");
          
	
	}
	

}
