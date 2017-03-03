package cn.itcast.java.annotation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class Demo3 {
      /*利用注解的方法来连接数据库*/
	  @DBInfo
	  public static Connection getConnection() throws Exception, Exception{
		  Connection conn = null;
		  //取得Demo3字节码对象
		  Class<Demo3> clazz = Demo3.class;
		  //利用反射的方法取得Demo类的方法
		  Method method = clazz.getMethod("getConnection",null);
		  //取得定义在方法上的注解
		    DBInfo DBInfoClass = method.getAnnotation(DBInfo.class);
		   //取得注解的各个属性值
		    String driver = DBInfoClass.driver();
		    String url = DBInfoClass.url();
		    String user = DBInfoClass.user();
		    String password = DBInfoClass.password();
		   Class.forName(driver);
		   conn = DriverManager.getConnection(url, user, password);
		  return conn;
		  
	  }
	  public static void main(String[] args) throws Exception {
		    Connection conn = getConnection();
		    if(conn!=null){
		    	System.out.println("取得连接");
		    }else{
		    	System.out.println("未取得连接");
		    	
		    }
	} 
}
