package cn.itcast.java.reflect;

import java.lang.reflect.Method;

public class Demo4 {

	public static void main(String[] args) throws Exception {
		Class cla = Class.forName("cn.itcast.java.reflect.Person");
		Person p = new Person("kj",11);
        /*  Method m = cla.getMethod("show",null);
          m.invoke(p, null);
          Method m2 = cla.getMethod("show",String[].class,double.class);
             m2.invoke(p,new String[]{"swing,paino"},2000);*/
		Method m3 = cla.getDeclaredMethod("haha", null);
		m3.setAccessible(true);
		int returnValue = (int) m3.invoke(p, null);
		    System.out.println(returnValue);
             
	}

}
