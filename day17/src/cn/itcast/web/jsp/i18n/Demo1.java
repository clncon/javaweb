package cn.itcast.web.jsp.i18n;

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

public class Demo1 {

	
	public static void main(String[] args) throws Exception {
		 //演示DateFormat对象
		  //取得日期
		  //DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,Locale.CHINA);
		  //取得日期和时间
		    /*DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL,Locale.CHINA);
		   //格式化日期对象
		       String date = df.format(new Date());
		       System.out.println(date);*/
		
		 String str = "2016年11月13日 星期日";
		 DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,Locale.CHINA);
		    Date date = df.parse(str);
		    System.out.println(date.toLocaleString());
		
	}

}
