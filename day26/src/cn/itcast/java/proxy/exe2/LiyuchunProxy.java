package cn.itcast.java.proxy.exe2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LiyuchunProxy{
	//ȡ�ô���Ķ���
     private Liyuchun liyuchun = new Liyuchun();
     
     //��̬�Ĳ�������Ķ���
     
      public Star getProxy(){
    	  Star star = (Star)Proxy.newProxyInstance
    			                (LiyuchunProxy.class.getClassLoader(),
    			                 liyuchun.getClass().getInterfaces(), 
    			                   new InvocationHandler() {
									
								
									public Object invoke(Object proxy, 
											Method method,
											Object[] args)
											throws Throwable {
										    if("sing".equals(method.getName())){
										    	if("3".equals(args[0])){
										    		return method.invoke(liyuchun, args);
										    	}
										    	else{
										    		System.out.println("�����Ѳ���");
										    	}
										    }
										    else if("dance".equals(method.getName())){
										    	if("5".equals(args[0])){
										    		return method.invoke(liyuchun, args);
										    	}else{
										    		System.out
															.println("�����Ѳ���");
										    	}
										    }
										    else if("eat".equals(method.getName())){
										    	if("8".equals(args[0])){
										    		System.out
															.println("����û��");
										    	}
										    	else {
										    		System.out
															.println("Ǯ����");
										    	}
										    }
										
									    return null;
									}
								});
    	  return star;
    	   
      }
     


}
