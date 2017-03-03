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

	//发送一封简单邮件
	public static void main(String[] args) throws Exception {
		//设置发送邮件的环境
		Properties props = new Properties();
		//设置邮件的传送协议
		props.setProperty("mail.transport.protocol","smtp");
		//设置邮件服务器的主机号
		props.setProperty("mail.host","127.0.0.1");
		 //设置Session
		Session session = Session.getDefaultInstance(props);
		
		//取得邮件传输协议
		 Transport thransport = session.getTransport();
		 //创建一封邮件
         Message message = createMessage(session);
         //连接邮件服务器
          thransport.connect();
         //将邮件发送出去
         thransport.send(message);
         //关闭连接
         thransport.close();
	}

	private static Message createMessage(Session session) throws Exception, Exception {
		 MimeMessage message = new MimeMessage(session);
		 message.setFrom(new InternetAddress("aaa@km.com"));
		 message.setRecipient(RecipientType.CC,new InternetAddress("bbb@qq.com"));
		 message.setSubject("注册");
		 message.
		 setContent
		 ("恭喜<font color='red'>你的名字</font>注册成功","text/html;charset=utf-8");
		 
		return message;
	}

}
