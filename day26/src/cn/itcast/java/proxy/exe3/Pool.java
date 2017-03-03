package cn.itcast.java.proxy.exe3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;

public class Pool {
   private static LinkedList<Connection> pool = new LinkedList<Connection>();
   
    static{
    	 for(int i=0;i<10;i++){
    		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1/bbs","root","root");
				pool.add(conn);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
    	 }
    	
    }
    public Connection getConnection(){
    	 final Connection conn = pool.removeFirst();
    	return (Connection) Proxy.newProxyInstance
    			(Pool.class.getClassLoader(),
    			conn.getClass().getInterfaces(),
    			 new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						  if("close".equals(method.getName())){
							  //如果方法是close那么就将连接返回给连接池的最后一位
							  pool.addLast(conn);
							  //返回null
							  return null;
						  }else{
							  return method.invoke(conn, args);
						  }
					}
				});
    }
	public int getSize() {
		
		return pool.size();
	}
}
