package cn.itcast.web.gui;




import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo2 {

	public static void main(String[] args){
		//����һ��Timer�࣬���ڰ���������ظ�ִ��
		Timer timer = new Timer();
		//��ָ���������ظ�ִ��
		//1.����ִ�е�һ����ͣ5s�ٰ�1s���ִ��
		//timer.schedule(new MyTimerTack(),5000,1000);
		//2.ÿ��1sִ��һ��
		//timer.schedule(new MyTimerTack(),1000);
		//��δ����ĳ��ʱ��ִ��
		 Calendar calendar = Calendar.getInstance();
		 calendar.set(2016,11,4,15,1,40);
		 Date date = calendar.getTime();
		timer.schedule(new weTimerTack(),date);
		
		
		
	} 
}
//ʵ��TimerTack
class weTimerTack extends TimerTask{

	
	public void run() {
		Date date  = new Date();
		System.out.println(date.toLocaleString());
	}
	
}