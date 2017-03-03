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

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

public class Demo4 {

	//基于Mime创建一封复杂邮件(1文本+2邮件+2副图片)
	public static void main(String[] args) throws Exception, Exception {
		//创建一封邮件
		MimeMessage message = 
				new MimeMessage
				(Session.
						getDefaultInstance(new Properties()));
		//设置邮件的发送方
		message.setFrom(new InternetAddress("aaa@km.com"));
		//设置邮件的接收方
		message.setRecipient(RecipientType.TO,
				new InternetAddress("bbb@qq.com"));
		 //设置邮件的主题
		message.setSubject("文本和两幅图片和两个附件");
		//设置邮件的文本部分
		 MimeBodyPart text = new MimeBodyPart();
		 text.setContent("这里有两个附件 和 两幅图片:<br/>" +
		 		"第一幅:<br/><img src='cid:imageId1'><br/>第二幅:<br/>" +
		 		"<img src='cid:imageId2'/>","text/html;charset=utf-8");
		//设置图片部分
		  //这是第一封图片
		    MimeBodyPart image1 = new MimeBodyPart();
		      //设置邮件的数据源
		      DataHandler dh = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/meinv.jpg"));
		      //将数据源加入到image1上的
		       image1.setDataHandler(dh);
		       //设置邮件中图片的id
		       image1.setContentID("imageId1");
		       //设置第二幅图片
		       MimeBodyPart image2 = new MimeBodyPart();
		        DataHandler dh2 = 
		        		new 
		        		DataHandler(
		        				new FileDataSource("src/cn/itcast/web/mail/config/meinv3.jpg"));
		        image2.setDataHandler(dh2);
		        image2.setContentID("imageId2");
		       //将文本和图片进行关联并封装
		        MimeMultipart mm = new MimeMultipart();
		        mm.addBodyPart(text);
		        mm.addBodyPart(image1);
		        mm.addBodyPart(image2);
		        mm.setSubType("related");
		        //将文本和图片变成一个整体
		        MimeBodyPart temp = new MimeBodyPart();
		        temp.setContent(mm);
		        //设置第一个附件
		        MimeBodyPart attach = new MimeBodyPart();
		          //设置数据源
		           DataHandler dh3 = 
		        		   new DataHandler(
		        				   new FileDataSource(
		        						   "src/cn/itcast/web/mail/config/RADWIMPS-夢灯籠-(动画电影《你的名字。》片头曲).mp3"));
		           //将数据源添加到附件部分
		           attach.setDataHandler(dh3);
		           //设置附件的名字
		           attach.setFileName(MimeUtility.encodeText(dh3.getName()));
		           //设置第二个附件
		             MimeBodyPart attach2 = new MimeBodyPart();
		             DataHandler dh4 = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/RADWIMPS-前前前世(Movie Ver.).mp3"));
		             attach2.setDataHandler(dh4);
		             attach2.setFileName(MimeUtility.encodeText(dh4.getName()));
		             //将附件和(文本+图片)关联起来
		             MimeMultipart mm2 = new MimeMultipart();
		             mm2.addBodyPart(temp);
		             mm2.addBodyPart(attach);
		             mm2.addBodyPart(attach2);
		             mm2.setSubType("mixed");
		             
		             //将(文本+图片+附件)和邮件关联起来
		              message.setContent(mm2);
		              //存入硬盘中
		              message.writeTo(new FileOutputStream("D:\\dem4.eml"));
		             

	}

}
