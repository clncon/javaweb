package cn.itcast.java.reflect;

import java.lang.reflect.Field;

public class Demo3 {

	public static void main(String[] args) throws ClassNotFoundException, Exception{
		Class c = Class.forName("cn.itcast.java.reflect.Person");
		Person p = new Person("hh",41);
		 Field f = c.getField("name");
         f.set(p,"lili");
         System.out.println("用户名："+p.getName());
         Field f2 = c.getDeclaredField("age");
         f2.setAccessible(true);
         f2.set(p,20);
         System.out.println("年龄："+p.getAge());
        
	}
	

}
