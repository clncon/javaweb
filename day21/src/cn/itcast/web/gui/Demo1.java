package cn.itcast.web.gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Demo1 {

	
	public static void main(String[] args) {
		//�½�һ������
		Frame frame = new Frame();
		//���ô���Ĵ�С
		 frame.setSize(300,200);
		 //���ô����λ��
		 frame.setLocation(200, 300);
		 //���ô����ǿɼ���
		 frame.setVisible(true);
		  //�Ƚ����ҵļ�����
		   WindowListener  listener = new myWindowsListener();
		 //�������һ��windowsListener������
		
		 frame.addWindowListener(listener);

	}

}
class myWindowsListener extends WindowAdapter
{

	public void windowClosing(WindowEvent e) {
		    //ȡ�ô������
        	Frame frame = (Frame) e.getSource();
        	//���ô�����󲻿ɼ�
        	frame.setVisible(false);
        	//�˳�����
        	System.exit(1);
	}
	
}
