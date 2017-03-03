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
     //����MIMEЭ��дһ�⸴�ӵ��ʼ�(�ı�+ͼƬ)
	public static void main(String[] args) throws Exception, MessagingException {
	  //����һ���ʼ�
		MimeMessage mime = new 
				MimeMessage(Session
			.getDefaultInstance(new Properties()));
		//�����ʼ��ķ��ͷ���Ϣ
	     mime.setFrom(new InternetAddress("aaa@km.com"));
	    //�����ʼ��Ľ��շ���Ϣ
	     mime.setRecipient(RecipientType.TO, new InternetAddress("bbb@qq.com"));
	     //�����ʼ�������
	     mime.setSubject("text+image");
	     //�����ʼ����ı��ṹ
	     MimeBodyPart body = new MimeBodyPart();
	     //�����ı�
	     body.setContent("this is a <br/><img src='cid:imageId'/> <br/> picture","text/html;charset=ISO8859-1");
	     //����ͼƬ�ṹ
	     MimeBodyPart image = new MimeBodyPart();
	     //��ȡͼƬ
	     DataHandler dh = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/meinv.jpg"));
	     //����ͼƬ
	      image.setDataHandler(dh);
	      //ΪͼƬ����Ψһ��Id
	      image.setContentID("imageId");
	      //����ͼƬ���ı��Ĺ�ϵ
	        MimeMultipart mm = new MimeMultipart();
	      mm.addBodyPart(body);
	      mm.addBodyPart(image);
	      //����������ϵ
	      mm.setSubType("related");
	      //���������ʼ��Ĺ�ϵ
	     mime.setContent(mm);
	     //���ʼ�д��Ӳ��
	     mime.writeTo(new FileOutputStream("D:\\demo2.eml"));
	      

	}

}
