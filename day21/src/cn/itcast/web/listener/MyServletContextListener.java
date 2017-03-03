package cn.itcast.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//监听器是一个单例的设计模式
public class MyServletContextListener implements ServletContextListener
{
    public MyServletContextListener(){
    	System.out.println("空参的构造方法");
    	System.out.println(this.hashCode());
    }

	public void contextDestroyed(ServletContextEvent event) {
		
		System.out.println("contextDestroyed: 销毁");
	    System.out.println(this.hashCode());
	}

	
	public void contextInitialized(ServletContextEvent event) {
		
		 System.out.println("contextInitialized: 创建");
		 System.out.println(this.hashCode());
	}
   
}
