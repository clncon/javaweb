package cn.itcast.java.annotation;

import java.lang.reflect.Method;

public class Demo4 {
	@Role
    public static void execute(String username,String password) throws Exception, Exception{
		  //取得Demo类的字节码对象
		  Class clazz = Demo4.class;
		  //用反射的方式取得Demo4的方法
		   Method method = clazz.getMethod("execute", String.class,String.class);
		   //取得定义在方法上的注解
		    Role roleClass = method.getAnnotation(Role.class);
		    //去得注解的值、
		     String user = roleClass.user();
		     String pwd = roleClass.password();
		     if(user.equals(username)&&pwd.equals(password)){
		    	 find();
		     }else{
		    	 System.out.println("未能执行find()方法");
		     }
    	
    }

	private static void find() {
		System.out.println("登录成功");
		
	}
	public static void main(String[] args) throws Exception {
		Demo4.execute("jack","1234654");
	}
}
