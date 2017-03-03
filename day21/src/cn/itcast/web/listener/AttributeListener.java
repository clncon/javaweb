package cn.itcast.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

public class AttributeListener implements ServletContextAttributeListener,
ServletRequestAttributeListener,HttpSessionAttributeListener{

	//��������
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("��������");
		String name = arg0.getName();
		String value = (String) arg0.getValue();
		System.out.println(name+":"+value);
	}

     //����ɾ��
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("����ɾ��");
		String name = arg0.getName();
		 //��ӡ���Ǳ�ɾ����ֵ
		String value = (String) arg0.getValue();
		System.out.println(name+":"+value);

	}

    //�����޸�
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
	    System.out.println("�����޸�");
	    String name  = arg0.getName();
	    //��ʾ���Ǳ��޸�֮ǰ��ֵ
	    String value = (String) arg0.getValue();
	    System.out.println(name+":"+value);
	    
	    
	}

	//request���Ե�����
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("��������");
		String name =  srae.getName();
		String value =  (String) srae.getValue();
		System.out.println(name+":"+value);
		
	}

     //request����ɾ��
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("����ɾ��");
		String name =  srae.getName();
		 //��ӡ���Ǳ�ɾ����ֵ
		String value =  (String) srae.getValue();
		System.out.println(name+":"+value);
		
		
	}

	//request�������޸�
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("�����޸�");
		String name =  srae.getName();
		//��ӡ���Ǳ��޸�֮ǰ��ֵ
		String value =  (String) srae.getValue();
		System.out.println(name+":"+value);
		
		
	}

	//Session��������
	public void attributeAdded(HttpSessionBindingEvent event) {
	    System.out.println("Session��������");
	    String name = event.getName();
	    String value = (String) event.getValue();
	    System.out.println(name+":"+value);
		
	}

	//Session���Ե�ɾ��
	public void attributeRemoved(HttpSessionBindingEvent event) {
		  System.out.println("Session����ɾ��");
		    String name = event.getName();
		    String value = (String) event.getValue();
		    System.out.println(name+":"+value);
		
	}

     //Session���Ե��޸�
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Session���Ե��޸�");
		String name = event.getName();
		String value = (String) event.getValue();
		System.out.println(name+":"+value);
		
	}

	

}
