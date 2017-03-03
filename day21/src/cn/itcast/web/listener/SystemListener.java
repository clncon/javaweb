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
			  //创建表
			sysdao.createSystemInitTable("systemInit");
			//创建Timer
			 Timer timer = new Timer();
			 //每隔3s添加一个数据
			 timer.schedule(new initTimerTack(), 0, 3000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
 //任务类
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
