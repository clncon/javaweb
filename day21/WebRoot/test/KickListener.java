package cn.itcast.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class KickListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//ȡ��Session���Ե�����
		String name = arg0.getName();
		//ȡ��Session���Ե�ֵ
		String value = (String) arg0.getValue();
		//�ж��������Ƿ�Ϊusername
		 if(name.equals("Name")){
			 //ȡ��session
		   HttpSession session = arg0.getSession();
		   //ȡ��Context
		   ServletContext context = session.getServletContext();
		   //ȡ��Map����
		   Map<String,HttpSession> map = 
				   (Map<String, HttpSession>) context.getAttribute("MAP");
		    //�жμ����Ƿ�Ϊ��
		     if(map==null){
		    	 //Ϊ�յĻ����½�һ������
		    	 map  = new HashMap<String,HttpSession>();
		    
		     }
		     //���û�����session���뵽map��
		     map.put(value, session);
		     System.out.println(map.size());
		   //����map���ϵ�context��
		   context.setAttribute("MAP",map);
		 }
		 
	}


	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}


	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		

	}

}
