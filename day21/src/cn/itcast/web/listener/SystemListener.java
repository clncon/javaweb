package cn.itcast.web.listener;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.itcast.web.dao.sysDao;

public class SystemListener implements ServletContextListener {
    private sysDao sysdao = new sysDao();

	public void contextDestroyed(ServletContextEvent arg0) {
		 try {
			sysdao.dropSystemInitTable("systemInit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void contextInitialized(ServletContextEvent arg0) {
		  try {
			  //������
			sysdao.createSystemInitTable("systemInit");
			//����Timer
			 Timer timer = new Timer();
			 //ÿ��3s���һ������
			 timer.schedule(new initTimerTack(), 0, 3000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
 //������
class initTimerTack extends TimerTask{

	public void run() {
		 String uuid = UUID.randomUUID().toString();
		 sysDao sysdao = new sysDao();
		 try {
			sysdao.initSystemInitTable("systemInit", uuid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
