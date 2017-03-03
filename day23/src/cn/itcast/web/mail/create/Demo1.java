package cn.itcast.web.mail.create;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Demo1 {

	//����MIMEЭ�鴴��һ���򵥵��ʼ�
	public static void main(String[] args) throws Exception, MessagingException {
	   //����һ��򵥵��ʼ�
		MimeMessage mime = 
				new MimeMessage
				(Session.getDefaultInstance(new Properties()));
		//���÷��ͷ���Ϣ
		 mime.setFrom(new InternetAddress("aaa@km.com"));
		 //���ý��շ�����Ϣ
		 mime.setRecipient(RecipientType.TO, new InternetAddress("bbb@qq.com"));
		 //�����ʼ�������
		 mime.setSubject("test");
		 //�����ʼ�������
		 mime.setContent("hello! welcome to join us!","text/html;charset=ISO8859-1");
		 //���ʼ����浽Ӳ����
		 mime.writeTo(new FileOutputStream("D:\\demo1.eml"));

	}

}
