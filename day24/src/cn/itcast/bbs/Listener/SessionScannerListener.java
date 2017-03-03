package cn.itcast.bbs.Listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.itcast.bbs.domain.User;

public class SessionScannerListener implements HttpSessionListener,
		ServletContextListener {
	  //���ü�ʱ��
      private Timer timer = new Timer();
       //����һ���ռ�Session�ļ���
      private List<HttpSession> listSession = new ArrayList<HttpSession>();
      
	  public SessionScannerListener(){
		     //��֤����������̰߳�ȫ��
		    listSession = Collections.synchronizedList(listSession);
	  }
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	
	public void contextInitialized(ServletContextEvent arg0) {
		  //���ü�ʱ��ÿ1sִ��һ��
		  timer.scheduleAtFixedRate(new MyTimerTask(listSession), 0, 1*1000);
	}

	
	public void sessionCreated(HttpSessionEvent se) {
		 HttpSession session = se.getSession();
		     synchronized (listSession) {
		    	  //�����µ�session���뵽�����У�ע��Ҫ�̰߳�ȫ
			     listSession.add(session);	
			}
	}

	
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
	}

}
class MyTimerTask extends TimerTask{
	private List<HttpSession> listSession;
    public MyTimerTask(List<HttpSession> listSession){
    	  this.listSession=listSession;
    }

	public void run() {
		 //System.out.println("run");
		//���session������Ԫ�صĻ�
 		 if(listSession.size()>0){
            //�������е�Session����
 			 synchronized (listSession) {
				
			
 			 for(HttpSession session:listSession){
 				 //ȡ�ø�session��Ӧ������user
 				 User user = (User) session.getAttribute("user");
 				 if(user!=null){
 				 //ȡ��session���һ�η��ʺ͵�ǰʱ��Ĳ�
 				 int mid = (int) ((System.currentTimeMillis() - session.getLastAccessedTime())/1000);
 				 //System.out.println("mid:"+mid);
 				 //�������10s
 				  if(mid>1200){
 					   //System.out.println("mid>10");
 					  //��session������ȥ����session
 					   listSession.remove(session);
 					   //ȡ�������û�����
 					  List<String> listuserName = (List<String>) session.getServletContext().getAttribute("listuserName");
 					  //�������û����ϼ�����ȥ�����û�
 					    listuserName.remove(user.getUsername());
 					    //����session
 					    session.removeAttribute("user");
 					    //session.invalidate();
 					    
 					    
 				  }
 				 }else{
 					 //��ȫ��¼
 				 }
 			 }
		  }
 		  }
	}
	
}
