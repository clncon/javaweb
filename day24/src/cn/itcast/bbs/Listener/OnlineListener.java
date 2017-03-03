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
		   String name = se.getName();//���Ұ󶨵Ķ��������
		   Object obj = se.getValue();//���Ұ󶨵Ķ����ֵ
		   if(obj instanceof User){
			    //ȷ����HttpSession�󶨵���User����
			    if("user".equals(name)){
			    	//�󶨵Ķ�������ֽ�user
			    	 //ȡ�����ߵ�������
			    	 Integer online = (Integer) se.getSession().getServletContext().getAttribute("online");
			    	 if(online==null){
			    		 //�����������Ϊ��
			    		  online=1;
			    	 }else{
			    		 online++;
			    		 
			    	 }
			    	  //������������
			    	 se.getSession().getServletContext().setAttribute("online", online);
			    	 
			    	 //���÷��ʴ���
			    	 ServletContext context = se.getSession().getServletContext();
			    	 //��ȡ��ǰ�ķ��ʴ���
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
		//��ȡ�������������
		   String name = se.getName();
		   //��ȡ������
		    Object obj  = se.getValue();
		    if(obj instanceof User){
		    	//�жν��Ķ���ʱΪUser����
		    	 if("user".equals(name)){
		    		 //�жν����������Ϊuser
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
