package cn.itcast.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class KickListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//取得Session属性的名字
		String name = arg0.getName();
		//取得Session属性的值
		String value = (String) arg0.getValue();
		//判断属性名是否为username
		 if(name.equals("Name")){
			 //取得session
		   HttpSession session = arg0.getSession();
		   //取得Context
		   ServletContext context = session.getServletContext();
		   //取得Map集合
		   Map<String,HttpSession> map = 
				   (Map<String, HttpSession>) context.getAttribute("MAP");
		    //判段集合是否为空
		     if(map==null){
		    	 //为空的话，新建一个集合
		    	 map  = new HashMap<String,HttpSession>();
		    
		     }
		     //将用户名和session加入到map中
		     map.put(value, session);
		     System.out.println(map.size());
		   //设置map集合到context中
		   context.setAttribute("MAP",map);
		 }
		 
	}


	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}


	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		

	}

}
