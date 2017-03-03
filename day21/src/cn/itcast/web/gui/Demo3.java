package cn.itcast.web.gui;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import cn.itcast.web.dao.sysDao;

public class Demo3 {

	
	public static void main(String[] args) {
		
		//����ʱ�Ӷ���
		 Timer timer = new Timer();
		 //����ÿ5��ִ��һ�ε�����
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
