package cn.itcast.web.gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Demo1 {

	
	public static void main(String[] args) {
		//新建一个窗体
		Frame frame = new Frame();
		//设置窗体的大小
		 frame.setSize(300,200);
		 //设置窗体的位置
		 frame.setLocation(200, 300);
		 //设置窗体是可见的
		 frame.setVisible(true);
		  //先建立我的监听器
		   WindowListener  listener = new myWindowsListener();
		 //给窗体加一个windowsListener监听器
		
		 frame.addWindowListener(listener);

	}

}
class myWindowsListener extends WindowAdapter
{

	public void windowClosing(WindowEvent e) {
		    //取得窗体对象
        	Frame frame = (Frame) e.getSource();
        	//设置窗体对象不可见
        	frame.setVisible(false);
        	//退出程序
        	System.exit(1);
	}
	
}
