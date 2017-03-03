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

	//����Mime����һ�⸴���ʼ�(1�ı�+2�ʼ�+2��ͼƬ)
	public static void main(String[] args) throws Exception, Exception {
		//����һ���ʼ�
		MimeMessage message = 
				new MimeMessage
				(Session.
						getDefaultInstance(new Properties()));
		//�����ʼ��ķ��ͷ�
		message.setFrom(new InternetAddress("aaa@km.com"));
		//�����ʼ��Ľ��շ�
		message.setRecipient(RecipientType.TO,
				new InternetAddress("bbb@qq.com"));
		 //�����ʼ�������
		message.setSubject("�ı�������ͼƬ����������");
		//�����ʼ����ı�����
		 MimeBodyPart text = new MimeBodyPart();
		 text.setContent("�������������� �� ����ͼƬ:<br/>" +
		 		"��һ��:<br/><img src='cid:imageId1'><br/>�ڶ���:<br/>" +
		 		"<img src='cid:imageId2'/>","text/html;charset=utf-8");
		//����ͼƬ����
		  //���ǵ�һ��ͼƬ
		    MimeBodyPart image1 = new MimeBodyPart();
		      //�����ʼ�������Դ
		      DataHandler dh = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/meinv.jpg"));
		      //������Դ���뵽image1�ϵ�
		       image1.setDataHandler(dh);
		       //�����ʼ���ͼƬ��id
		       image1.setContentID("imageId1");
		       //���õڶ���ͼƬ
		       MimeBodyPart image2 = new MimeBodyPart();
		        DataHandler dh2 = 
		        		new 
		        		DataHandler(
		        				new FileDataSource("src/cn/itcast/web/mail/config/meinv3.jpg"));
		        image2.setDataHandler(dh2);
		        image2.setContentID("imageId2");
		       //���ı���ͼƬ���й�������װ
		        MimeMultipart mm = new MimeMultipart();
		        mm.addBodyPart(text);
		        mm.addBodyPart(image1);
		        mm.addBodyPart(image2);
		        mm.setSubType("related");
		        //���ı���ͼƬ���һ������
		        MimeBodyPart temp = new MimeBodyPart();
		        temp.setContent(mm);
		        //���õ�һ������
		        MimeBodyPart attach = new MimeBodyPart();
		          //��������Դ
		           DataHandler dh3 = 
		        		   new DataHandler(
		        				   new FileDataSource(
		        						   "src/cn/itcast/web/mail/config/RADWIMPS-���ƻ\-(������Ӱ��������֡���Ƭͷ��).mp3"));
		           //������Դ��ӵ���������
		           attach.setDataHandler(dh3);
		           //���ø���������
		           attach.setFileName(MimeUtility.encodeText(dh3.getName()));
		           //���õڶ�������
		             MimeBodyPart attach2 = new MimeBodyPart();
		             DataHandler dh4 = new DataHandler(new FileDataSource("src/cn/itcast/web/mail/config/RADWIMPS-ǰǰǰ��(Movie Ver.).mp3"));
		             attach2.setDataHandler(dh4);
		             attach2.setFileName(MimeUtility.encodeText(dh4.getName()));
		             //��������(�ı�+ͼƬ)��������
		             MimeMultipart mm2 = new MimeMultipart();
		             mm2.addBodyPart(temp);
		             mm2.addBodyPart(attach);
		             mm2.addBodyPart(attach2);
		             mm2.setSubType("mixed");
		             
		             //��(�ı�+ͼƬ+����)���ʼ���������
		              message.setContent(mm2);
		              //����Ӳ����
		              message.writeTo(new FileOutputStream("D:\\dem4.eml"));
		             

	}

}
