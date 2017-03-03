package cn.itcast.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class onlineListener implements HttpSessionListener{
	public void sessionCreated(HttpSessionEvent se){
		//ȡ��Session
		HttpSession session = se.getSession();
		
		 //���session���²�����
		if(session.isNew()){
			//ȡ��ServletContext����
			 ServletContext context = session.getServletContext();
			 //ȡ�÷��ʴ���
			 Integer access = (Integer) context.getAttribute("access");
			 //ȡ����������
			 Integer counter = (Integer) context.getAttribute("counter");
			 System.out.println(access+":"+counter);
			 //�����������Ϊ��
			  if(access==null){
				  access=1;
			  }else
			  {
				  access++;
			  }
			  //���counterΪ�յĻ�
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
