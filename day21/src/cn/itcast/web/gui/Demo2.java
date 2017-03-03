package cn.itcast.web.gui;




import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo2 {

	public static void main(String[] args){
		//创建一个Timer类，用于安排任务的重复执行
		Timer timer = new Timer();
		//让指定的任务重复执行
		//1.设置执行第一次先停5s再按1s间隔执行
		//timer.schedule(new MyTimerTack(),5000,1000);
		//2.每隔1s执行一次
		//timer.schedule(new MyTimerTack(),1000);
		//在未来的某个时刻执行
		 Calendar calendar = Calendar.getInstance();
		 calendar.set(2016,11,4,15,1,40);
		 Date date = calendar.getTime();
		timer.schedule(new weTimerTack(),date);
		
		
		
	} 
}
//实现TimerTack
class weTimerTack extends TimerTask{

	
	public void run() {
		Date date  = new Date();
		System.out.println(date.toLocaleString());
	}
	
}