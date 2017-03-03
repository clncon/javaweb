package cn.itcast.web.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	//session的创建
	public void sessionCreated(HttpSessionEvent arg0) {
		   HttpSession session = arg0.getSession();
		 
			   System.out.println("sessionCreated:");
			   System.out.println(session.getId()+":"+new Date().toLocaleString());
		   
	}

    //session的销毁
	public void sessionDestroyed(HttpSessionEvent arg0) {
	      HttpSession session = arg0.getSession();
	     
	    	  System.out.println("sessionDestroyed:");
	    	  System.out.println(session.getId()+":"+new Date().toLocaleString());
	   

	}

}
