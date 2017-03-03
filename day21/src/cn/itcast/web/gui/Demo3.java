package cn.itcast.web.gui;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import cn.itcast.web.dao.sysDao;

public class Demo3 {

	
	public static void main(String[] args) {
		
		//创建时钟对象
		 Timer timer = new Timer();
		 //设置每5秒执行一次的任务
		 timer.schedule(new myTimerTack(),0, 5000);

	}

}
class myTimerTack extends TimerTask{

	
	public void run() {
		String uuid = UUID.randomUUID().toString();
		
		try {
			sysDao sysdao = new sysDao();
			sysdao.initSystemInitTable("systemInit",uuid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
