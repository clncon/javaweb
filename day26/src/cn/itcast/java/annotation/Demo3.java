package cn.itcast.java.annotation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class Demo3 {
      /*����ע��ķ������������ݿ�*/
	  @DBInfo
	  public static Connection getConnection() throws Exception, Exception{
		  Connection conn = null;
		  //ȡ��Demo3�ֽ������
		  Class<Demo3> clazz = Demo3.class;
		  //���÷���ķ���ȡ��Demo��ķ���
		  Method method = clazz.getMethod("getConnection",null);
		  //ȡ�ö����ڷ����ϵ�ע��
		    DBInfo DBInfoClass = method.getAnnotation(DBInfo.class);
		   //ȡ��ע��ĸ�������ֵ
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
		    	System.out.println("ȡ������");
		    }else{
		    	System.out.println("δȡ������");
		    	
		    }
	} 
}
