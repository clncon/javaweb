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
	  //设置计时器
      private Timer timer = new Timer();
       //创建一个收集Session的集合
      private List<HttpSession> listSession = new ArrayList<HttpSession>();
      
	  public SessionScannerListener(){
		     //保证这个集合是线程安全的
		    listSession = Collections.synchronizedList(listSession);
	  }
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	
	public void contextInitialized(ServletContextEvent arg0) {
		  //设置计时器每1s执行一次
		  timer.scheduleAtFixedRate(new MyTimerTask(listSession), 0, 1*1000);
	}

	
	public void sessionCreated(HttpSessionEvent se) {
		 HttpSession session = se.getSession();
		     synchronized (listSession) {
		    	  //将最新的session放入到集合中，注意要线程安全
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
		//如果session集合有元素的话
 		 if(listSession.size()>0){
            //遍历所有的Session对象
 			 synchronized (listSession) {
				
			
 			 for(HttpSession session:listSession){
 				 //取得该session对应的属性user
 				 User user = (User) session.getAttribute("user");
 				 if(user!=null){
 				 //取得session最后一次访问和当前时间的差
 				 int mid = (int) ((System.currentTimeMillis() - session.getLastAccessedTime())/1000);
 				 //System.out.println("mid:"+mid);
 				 //如果超过10s
 				  if(mid>1200){
 					   //System.out.println("mid>10");
 					  //从session集合中去除该session
 					   listSession.remove(session);
 					   //取得在线用户集合
 					  List<String> listuserName = (List<String>) session.getServletContext().getAttribute("listuserName");
 					  //从在线用户集合集合中去除该用户
 					    listuserName.remove(user.getUsername());
 					    //销毁session
 					    session.removeAttribute("user");
 					    //session.invalidate();
 					    
 					    
 				  }
 				 }else{
 					 //安全登录
 				 }
 			 }
		  }
 		  }
	}
	
}
