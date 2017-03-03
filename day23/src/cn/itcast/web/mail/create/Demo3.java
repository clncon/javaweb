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

	//����MimeЭ��дһ�⸴���ʼ�(�ı�+����)
	public static void main(String[] args) throws Exception, Exception{
		//����һ���ʼ�
		  MimeMessage message = new MimeMessage
				  (Session.
			    getDefaultInstance(new Properties()));
		     //�����ʼ��ķ��ͷ�
		     message.setFrom(new InternetAddress("aaa@km.com"));
		     //�����ʼ��Ľ��շ�
		     message.setRecipient(RecipientType.TO,new InternetAddress("bbb@qq.com"));
		     //�����ʼ�������
		     message.setSubject("text+attachment");
		  //�����ʼ����ı�����
		     MimeBodyPart text = new MimeBodyPart();
		     text.setContent("this is a attachment","text/html;charset=ISO8859-1");
		    //�����ʼ��ĸ�������
		     MimeBodyPart attach = new MimeBodyPart();
		     //������ȡ����������Դ
		      DataHandler dh = new
		    		  DataHandler
		    		  (new FileDataSource
		    				 ("src/cn/itcast/web/mail/config/meinv3.jpg"));
		      //���ø���������
		        attach.setFileName(dh.getName());
		      //��������ӵ���������
		      attach.setDataHandler(dh);
		//�����ı��͸����Ĺ�����ϵ
		      MimeMultipart mm = new MimeMultipart();
		      mm.addBodyPart(text);
		      mm.addBodyPart(attach);
		      mm.setSubType("mixed");
		      //���������ʼ��Ĺ�ϵ
		      message.setContent(mm);
		//���ʼ�����Ӳ����
             message.writeTo(new FileOutputStream("d:\\demo3.eml"));
	}

}
