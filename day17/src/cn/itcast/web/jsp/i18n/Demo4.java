package cn.itcast.web.jsp.i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class Demo4 {

	public static void main(String[] args) {
		 //ÑÝÊ¾MessageFormat
		String patten="On {0}, a hurricance destroyed {1} houses and caused {2} of damage.";
		MessageFormat mf = new MessageFormat(patten,Locale.CHINA);
		String str = mf.format(new Object[]{new Date(),99,"$1000000"});
         System.out.println(str);
	}

}
