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
	//这是一个用于收集Session的集合
    private List<HttpSession> listSession = new ArrayList<HttpSession>();
    //设置一个定时器
     private Timer timer = new Timer();
    public SessionScanner(){
    	 //保证这是一个线程安全的list集合
    	Collections.synchronizedList(this.listSession);
    }
	public void sessionCreated(HttpSessionEvent se) {
		  HttpSession session = se.getSession();
		  System.out.println("session的产生:"+session.getId()+new Date().toLocaleString());
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
		 System.out.println("session的销毁:"+session.getId()+":"+new Date().toLocaleString());

	}

	public void contextDestroyed(ServletContextEvent sce) {
		 //当context销毁时结束定时器
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
		//因为要对listSession集合进行迭代并且进行增删操作，故使用ListIterator
		ListIterator<HttpSession> listiter = listSession.listIterator();
		while (listiter.hasNext()) {
			//取得集合中的Session对象
			HttpSession session = listiter.next();
			//判断是否已经超过一分钟未使用
			int middle = (int) ((System.currentTimeMillis()-session.getLastAccessedTime())/1000);
			//已经超过一分钟未使用了
			if (middle > 60) {
				//手动清除session
				session.invalidate();
				//从集合中取出已经死去的Session集合
				listiter.remove();
			}
			
		}
	}
		
	}
	
}