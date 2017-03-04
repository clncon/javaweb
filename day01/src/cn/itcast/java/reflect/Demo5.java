package cn.itcast.java.reflect;

import java.lang.reflect.Method;

public class Demo5 {
//通过反射解析main方法 
	public static void main(String[] args) throws Exception {
		Class cc = Class.forName("cn.itcast.java.reflect.Person");
		 Person pr = new Person("jj",441);
		 Method mm = cc.getMethod("main",String[].class);
		 mm.invoke(pr, (Object) new String[]{"ss","c"});

	}

}
