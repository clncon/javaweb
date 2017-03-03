package cn.itcast.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class onlineListener implements HttpSessionListener{
	public void sessionCreated(HttpSessionEvent se){
		//取得Session
		HttpSession session = se.getSession();
		
		 //如果session是新产生的
		if(session.isNew()){
			//取得ServletContext对象
			 ServletContext context = session.getServletContext();
			 //取得访问次序
			 Integer access = (Integer) context.getAttribute("access");
			 //取得在线人数
			 Integer counter = (Integer) context.getAttribute("counter");
			 System.out.println(access+":"+counter);
			 //如果在线人数为空
			  if(access==null){
				  access=1;
			  }else
			  {
				  access++;
			  }
			  //如果counter为空的话
			  if(counter==null){
				  counter=1;
			  }else
			  {
				   counter++;
			  }
			 session.setAttribute("access",counter);
			 context.setAttribute("counter",counter);
		}

	}


	public void sessionDestroyed(HttpSessionEvent se) {

	}

}
