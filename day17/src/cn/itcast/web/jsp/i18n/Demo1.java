package cn.itcast.web.jsp.i18n;

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

public class Demo1 {

	
	public static void main(String[] args) throws Exception {
		 //��ʾDateFormat����
		  //ȡ������
		  //DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,Locale.CHINA);
		  //ȡ�����ں�ʱ��
		    /*DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL,Locale.CHINA);
		   //��ʽ�����ڶ���
		       String date = df.format(new Date());
		       System.out.println(date);*/
		
		 String str = "2016��11��13�� ������";
		 DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,Locale.CHINA);
		    Date date = df.parse(str);
		    System.out.println(date.toLocaleString());
		
	}

}
