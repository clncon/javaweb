package cn.itcast.web.mail.send;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo1 {

	//����һ����ʼ�
	public static void main(String[] args) throws Exception {
		//���÷����ʼ��Ļ���
		Properties props = new Properties();
		//�����ʼ��Ĵ���Э��
		props.setProperty("mail.transport.protocol","smtp");
		//�����ʼ���������������
		props.setProperty("mail.host","127.0.0.1");
		 //����Session
		Session session = Session.getDefaultInstance(props);
		
		//ȡ���ʼ�����Э��
		 Transport thransport = session.getTransport();
		 //����һ���ʼ�
         Message message = createMessage(session);
         //�����ʼ�������
          thransport.connect();
         //���ʼ����ͳ�ȥ
         thransport.send(message);
         //�ر�����
         thransport.close();
	}

	private static Message createMessage(Session session) throws Exception, Exception {
		 MimeMessage message = new MimeMessage(session);
		 message.setFrom(new InternetAddress("aaa@km.com"));
		 message.setRecipient(RecipientType.CC,new InternetAddress("bbb@qq.com"));
		 message.setSubject("ע��");
		 message.
		 setContent
		 ("��ϲ<font color='red'>�������</font>ע��ɹ�","text/html;charset=utf-8");
		 
		return message;
	}

}
