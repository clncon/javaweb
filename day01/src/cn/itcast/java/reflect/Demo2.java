package cn.itcast.java.reflect;

import java.lang.reflect.Constructor;

public class Demo2 {

	public static void main(String[] args) throws Exception{
		//取得Person类的字节码对象
	  Class cs = Class.forName("cn.itcast.java.reflect.Person");
	   //取得该类的唯一构造方法
	/*  Constructor con = cs.getDeclaredConstructor(null);
	  
	  //设置非public方法的可访问性，默认为false
	  con.setAccessible(true);
	  
	  //创建事例
	    Person  P  = (Person) con.newInstance(null);*/
	  //取得唯一的构造方法
	  Constructor c  = cs.getConstructor(String.class,int.class);
	   //创建实例
	    Person p1 = (Person) c.newInstance("lolo",20);
	    
	     
    
	    
	    
		

	}

}
