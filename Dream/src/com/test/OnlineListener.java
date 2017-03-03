package com.test;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
		//��������ͳ�Ƽ�����ʵ���� 
public class OnlineListener implements ServletContextListener,
		HttpSessionAttributeListener, HttpSessionListener,
		HttpSessionBindingListener {
	private ServletContext application = null;  
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//��ʼ��һ��application����  
        this.application = arg0.getServletContext();  
        //����һ���б����ԣ����ڱ��������û���  
        this.application.setAttribute("online", new LinkedList<String>()); 

	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//ȡ���û����б�  
        List<String> online = (List<String>) this.application  
                .getAttribute("online");  
        if ("uPhonee".equals(arg0.getName())) {  
            //����ǰ�û�����ӵ��б���  
            online.add((String) arg0.getValue());  
        }  
        //����Ӻ���б��������õ�application������  
        this.application.setAttribute("online", online); 

	}
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}
	  
	

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	

}
