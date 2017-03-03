package cn.itcast.web.mail.create;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Demo2 {
     //根据MIME协议写一封复杂的邮件(文本+图片)
	public static void main(String[] args) throws Exception, MessagingException {
	  //创建一封邮件
		MimeMessage mime = new 
				MimeMessage(Session
			.getDefaultInstance(new Properties()));
		//设置邮件的发送方信息
	     mime.setFrom(new InternetAddress("aaa@km.com"));
	    //设置邮件的接收方信息
	     mime.setRecipient(RecipientType.TO, new InternetAddress("bbb@qq.com"));
	     //设置邮件的主题
	     mime.setSubject("text+image");
	     //设置邮件的文本结构
	     MimeBodyPart body = new MimeBodyPart();
	     //设置文本
	     body.setContent("this is a <br/><img src='cid:imageId'/> <br/> picture","text/html;charset=ISO8859-1");
	     //设置图片结构
	     MimeBodyPart image = new MimeBodyPart();
	     //读取图片
	     DataHandler dh = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/meinv.jpg"));
	     //加入图片
	      image.setDataHandler(dh);
	      //为图片设置唯一的Id
	      image.setContentID("imageId");
	      //设置图片和文本的关系
	        MimeMultipart mm = new MimeMultipart();
	      mm.addBodyPart(body);
	      mm.addBodyPart(image);
	      //设置依赖关系
	      mm.setSubType("related");
	      //设置整个邮件的关系
	     mime.setContent(mm);
	     //将邮件写入硬盘
	     mime.writeTo(new FileOutputStream("D:\\demo2.eml"));
	      

	}

}
