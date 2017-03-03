package cn.itcast.bbs.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.itcast.bbs.domain.User;

public class OnlineListener implements HttpSessionAttributeListener,
		ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	public void attributeAdded(HttpSessionBindingEvent se) {
		   String name = se.getName();//查找绑定的对象的名字
		   Object obj = se.getValue();//查找绑定的对象的值
		   if(obj instanceof User){
			    //确定向HttpSession绑定的是User对象
			    if("user".equals(name)){
			    	//绑定的对象的名字叫user
			    	 //取得在线的总人数
			    	 Integer online = (Integer) se.getSession().getServletContext().getAttribute("online");
			    	 if(online==null){
			    		 //如果在线人数为空
			    		  online=1;
			    	 }else{
			    		 online++;
			    		 
			    	 }
			    	  //设置在线人数
			    	 se.getSession().getServletContext().setAttribute("online", online);
			    	 
			    	 //设置访问次序
			    	 ServletContext context = se.getSession().getServletContext();
			    	 //获取当前的访问次序
			    	 Integer caller = (Integer) context.getAttribute("caller");
			    	 
			    	   if(caller==null){
			    		   caller=1;
			    	   }else{
			    		   caller++;
			    	   }
			    	   context.setAttribute("caller",caller);
			    	   se.getSession().setAttribute("caller", caller);
			    }
		   }
		   
	}

	
	public void attributeRemoved(HttpSessionBindingEvent se) {
		//获取解绑对象的属性名
		   String name = se.getName();
		   //获取解绑对象
		    Object obj  = se.getValue();
		    if(obj instanceof User){
		    	//判段解绑的对象时为User对象
		    	 if("user".equals(name)){
		    		 //判段解绑对象的名字为user
		    		  HttpSession session = se.getSession();
		    		  ServletContext context = session.getServletContext();
		    		  Integer online = (Integer) context.getAttribute("online");
		    		  online--;
		    		  context.setAttribute("online", online);
		    		  }
		    }

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

}
