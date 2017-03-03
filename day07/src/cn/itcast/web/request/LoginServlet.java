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
		map.put("127.0.0.1","�Ϸ�");
		map.put("192.168.0.104","����");
		map.put("192.168.0.105","�Ϻ�");
		map.put("192.168.0.106","����");
		map.put("192.168.0.107","�Ͼ�");
		map.put("192.168.0.108","����");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  //����post���ͷ�ʽ�ı���
		   request.setCharacterEncoding("UTF-8");
		     //��ȡip��ַ
		    String ip = request.getRemoteAddr();
		     //��ȡjavaBean����
		    ipCheckBean ipcb = new ipCheckBean();
		    String address = ipcb.ipCheck(ip, map);
		    //��ȡ������
		    String username = request.getParameter("username");
		    //��ȡServletContext���󣬷�װֵ
		    ServletContext context =this.getServletContext();
            context.setAttribute("IP", ip);
            context.setAttribute("ADDRESS", address);
            context.setAttribute("USERNAME", username);
            
            //ת��
            //request.getRequestDispatcher("/showServlet").forward(request, response);
		    response.sendRedirect("/day07/showServlet");
          
	
	}
	

}
