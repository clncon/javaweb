package cn.itcast.web.decorator;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class MyDate {
   private Date date;
   public MyDate(Date date){
	   
	  this.date=date;
   }
   public String toLocalString(){
	   String dateStr=null;
	   DateFormat df = DateFormat.
			   getDateTimeInstance
			   (DateFormat.FULL,DateFormat.MEDIUM,Locale.CHINA);
	   dateStr=df.format(date);
	   return dateStr;
   }
}
