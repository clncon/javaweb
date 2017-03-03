package cn.itcast.web.jsp.i18n;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Demo2 {

	
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd",Locale.CHINA);
		 Date date = sdf.parse("2016-11-13");
		  Calendar cal = Calendar.getInstance(Locale.CHINA);
		  cal.setTime(date);
		   System.out.println(cal.get(Calendar.YEAR)+"年");
		   System.out.println(cal.get(Calendar.MONTH)+"月");
		   System.out.println(cal.get(Calendar.DATE)+"日");
		   System.out.println("星期"+cal.get(Calendar.DAY_OF_WEEK));
		   System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		

	}

}
