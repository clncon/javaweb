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

	//基于MIME协议创建一个简单的邮件
	public static void main(String[] args) throws Exception, MessagingException {
	   //创建一封简单的邮件
		MimeMessage mime = 
				new MimeMessage
				(Session.getDefaultInstance(new Properties()));
		//设置发送方信息
		 mime.setFrom(new InternetAddress("aaa@km.com"));
		 //设置接收方的信息
		 mime.setRecipient(RecipientType.TO, new InternetAddress("bbb@qq.com"));
		 //设置邮件的主题
		 mime.setSubject("test");
		 //设置邮件的内容
		 mime.setContent("hello! welcome to join us!","text/html;charset=ISO8859-1");
		 //将邮件保存到硬盘中
		 mime.writeTo(new FileOutputStream("D:\\demo1.eml"));

	}

}
