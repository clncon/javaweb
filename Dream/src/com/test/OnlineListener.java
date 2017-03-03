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
		//在线人数统计监听器实现类 
public class OnlineListener implements ServletContextListener,
		HttpSessionAttributeListener, HttpSessionListener,
		HttpSessionBindingListener {
	private ServletContext application = null;  
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//初始化一个application对象  
        this.application = arg0.getServletContext();  
        //设置一个列表属性，用于保存在想用户名  
        this.application.setAttribute("online", new LinkedList<String>()); 

	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//取得用户名列表  
        List<String> online = (List<String>) this.application  
                .getAttribute("online");  
        if ("uPhonee".equals(arg0.getName())) {  
            //将当前用户名添加到列表中  
            online.add((String) arg0.getValue());  
        }  
        //将添加后的列表重新设置到application属性中  
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
