package cn.itcast.web.jsp.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class Demo5 {

	
	public static void main(String[] args) {
		//占位符的其他方式
		String patten = "At {0, time, short} on {0, date}, {1} destroyed'\n";
		 MessageFormat mf = new MessageFormat(patten,Locale.CHINA); 
		  String message = mf.format(new Object[]{new Date(),99});
		  System.out.println(message);

	}

}
