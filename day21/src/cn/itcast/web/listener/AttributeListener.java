package cn.itcast.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

public class AttributeListener implements ServletContextAttributeListener,
ServletRequestAttributeListener,HttpSessionAttributeListener{

	//属性增加
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("属性增加");
		String name = arg0.getName();
		String value = (String) arg0.getValue();
		System.out.println(name+":"+value);
	}

     //属性删除
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("属性删除");
		String name = arg0.getName();
		 //打印的是被删除的值
		String value = (String) arg0.getValue();
		System.out.println(name+":"+value);

	}

    //属性修改
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
	    System.out.println("属性修改");
	    String name  = arg0.getName();
	    //显示的是被修改之前的值
	    String value = (String) arg0.getValue();
	    System.out.println(name+":"+value);
	    
	    
	}

	//request属性的增加
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("属性增加");
		String name =  srae.getName();
		String value =  (String) srae.getValue();
		System.out.println(name+":"+value);
		
	}

     //request属性删除
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("属性删除");
		String name =  srae.getName();
		 //打印的是被删除的值
		String value =  (String) srae.getValue();
		System.out.println(name+":"+value);
		
		
	}

	//request的属性修改
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("属性修改");
		String name =  srae.getName();
		//打印的是被修改之前的值
		String value =  (String) srae.getValue();
		System.out.println(name+":"+value);
		
		
	}

	//Session属性增加
	public void attributeAdded(HttpSessionBindingEvent event) {
	    System.out.println("Session属性增加");
	    String name = event.getName();
	    String value = (String) event.getValue();
	    System.out.println(name+":"+value);
		
	}

	//Session属性的删除
	public void attributeRemoved(HttpSessionBindingEvent event) {
		  System.out.println("Session属性删除");
		    String name = event.getName();
		    String value = (String) event.getValue();
		    System.out.println(name+":"+value);
		
	}

     //Session属性的修改
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Session属性的修改");
		String name = event.getName();
		String value = (String) event.getValue();
		System.out.println(name+":"+value);
		
	}

	

}
