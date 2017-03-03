package cn.itcast.web.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionScanner implements HttpSessionListener,ServletContextListener{
	//����һ�������ռ�Session�ļ���
    private List<HttpSession> listSession = new ArrayList<HttpSession>();
    //����һ����ʱ��
     private Timer timer = new Timer();
    public SessionScanner(){
    	 //��֤����һ���̰߳�ȫ��list����
    	Collections.synchronizedList(this.listSession);
    }
	public void sessionCreated(HttpSessionEvent se) {
		  HttpSession session = se.getSession();
		  System.out.println("session�Ĳ���:"+session.getId()+new Date().toLocaleString());
		  synchronized (this.listSession) {
			if (session.isNew()) {
				this.listSession.add(session);
			}
		}

	}

	public void contextInitialized(ServletContextEvent sce) {
		timer.schedule(new sessionTimerTask(this.listSession), 0, 1000);
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		 HttpSession session = se.getSession();
		 System.out.println("session������:"+session.getId()+":"+new Date().toLocaleString());

	}

	public void contextDestroyed(ServletContextEvent sce) {
		 //��context����ʱ������ʱ��
		  timer.cancel();
		
	}


}
class sessionTimerTask extends TimerTask{
    private List<HttpSession> listSession;
    public sessionTimerTask(List<HttpSession> listSession){
    	this.listSession=listSession;
    }

	public void run() {
     synchronized (this.listSession) {
		//��ΪҪ��listSession���Ͻ��е������ҽ�����ɾ��������ʹ��ListIterator
		ListIterator<HttpSession> listiter = listSession.listIterator();
		while (listiter.hasNext()) {
			//ȡ�ü����е�Session����
			HttpSession session = listiter.next();
			//�ж��Ƿ��Ѿ�����һ����δʹ��
			int middle = (int) ((System.currentTimeMillis()-session.getLastAccessedTime())/1000);
			//�Ѿ�����һ����δʹ����
			if (middle > 60) {
				//�ֶ����session
				session.invalidate();
				//�Ӽ�����ȡ���Ѿ���ȥ��Session����
				listiter.remove();
			}
			
		}
	}
		
	}
	
}