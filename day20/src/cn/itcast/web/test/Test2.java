package cn.itcast.web.test;

import java.util.Date;

import cn.itcast.web.decorator.MyDate;

public class Test2 {

	
	public static void main(String[] args) {
		Date date = new Date();
		MyDate mydate = new MyDate(date);
        System.out.println(mydate.toLocalString());
	}

}
