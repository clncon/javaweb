package cn.itcast.web.mail.create;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class Demo3 {

	//基于Mime协议写一封复杂邮件(文本+附件)
	public static void main(String[] args) throws Exception, Exception{
		//创建一封邮件
		  MimeMessage message = new MimeMessage
				  (Session.
			    getDefaultInstance(new Properties()));
		     //设置邮件的发送方
		     message.setFrom(new InternetAddress("aaa@km.com"));
		     //设置邮件的接收方
		     message.setRecipient(RecipientType.TO,new InternetAddress("bbb@qq.com"));
		     //设置邮件的主题
		     message.setSubject("text+attachment");
		  //设置邮件的文本部分
		     MimeBodyPart text = new MimeBodyPart();
		     text.setContent("this is a attachment","text/html;charset=ISO8859-1");
		    //设置邮件的附件部分
		     MimeBodyPart attach = new MimeBodyPart();
		     //创建读取附件的数据源
		      DataHandler dh = new
		    		  DataHandler
		    		  (new FileDataSource
		    				 ("src/cn/itcast/web/mail/config/meinv3.jpg"));
		      //设置附件的名字
		        attach.setFileName(dh.getName());
		      //将附件添加到附件部分
		      attach.setDataHandler(dh);
		//设置文本和附件的关联关系
		      MimeMultipart mm = new MimeMultipart();
		      mm.addBodyPart(text);
		      mm.addBodyPart(attach);
		      mm.setSubType("mixed");
		      //设置整个邮件的关系
		      message.setContent(mm);
		//将邮件存入硬盘中
             message.writeTo(new FileOutputStream("d:\\demo3.eml"));
	}

}
