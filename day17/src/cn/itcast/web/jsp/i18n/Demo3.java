package cn.itcast.web.jsp.i18n;

import java.text.NumberFormat;
import java.util.Locale;

public class Demo3 {

	
	public static void main(String[] args) throws Exception {
	   //��ʾNumberFormat��
		   //��ʾInteger
		  /*NumberFormat nf = NumberFormat.getIntegerInstance(Locale.CHINA);
		   Long num = (Long) nf.parse("123");
		   System.out.println(num);*/
		   //��ʾCurrency
		    /* NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		     Long num = (Long) nf.parse("��3654");
		     System.out.println(num);*/
		    //��ʾ�ٷֱ�
		      NumberFormat nf = NumberFormat.getPercentInstance(Locale.CHINA);
		        Double percent = (Double) nf.parse("50%");
		         System.out.println(percent);
	}

}
