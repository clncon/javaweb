package cn.itcast.web.mail.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MessageUtil {
	   private MessageUtil(){}
       public static void sendMessage(String email,String username) throws Exception{
    	 //创建邮件的发送环境变量
    	  Properties props = new Properties();
    	  props.put("mail.transport.protocol","smtp");
    	  props.put("mail.host", "127.0.0.1");
    	  Session session = Session.getDefaultInstance(props);
    	  
    	  //得到传输协议
    	  Transport thransport = session.getTransport();
    	  thransport.connect("aaa@km.com","123456");
    	  
    	  //创建一封邮件
    	     Message message = CreateMessage(session,email,username);
    	  //取得和邮件服务器的连接
              //发送邮件
              thransport.send(message);
              thransport.close();
    	     
    	   
       }
	private static Message CreateMessage(Session session, String email, String username) throws Exception, Exception {
		  MimeMessage message = new MimeMessage(session);
		  message.setFrom(new InternetAddress("aaa@km.com"));
		  message.setRecipient(RecipientType.TO, new InternetAddress(email));
		  message.setSubject("注册信息");
		  message.setContent("恭喜<font color='red' size='44'>"+username+"</font>注册成功","text/html;charset=utf-8");
		  return message;
		
	}
}
