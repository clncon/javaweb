package cn.itcast.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//��������һ�����������ģʽ
public class MyServletContextListener implements ServletContextListener
{
    public MyServletContextListener(){
    	System.out.println("�ղεĹ��췽��");
    	System.out.println(this.hashCode());
    }

	public void contextDestroyed(ServletContextEvent event) {
		
		System.out.println("contextDestroyed: ����");
	    System.out.println(this.hashCode());
	}

	
	public void contextInitialized(ServletContextEvent event) {
		
		 System.out.println("contextInitialized: ����");
		 System.out.println(this.hashCode());
	}
   
}
