package cn.itcast.java.proxy.exe2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LiyuchunProxy{
	//取得代理的对象
     private Liyuchun liyuchun = new Liyuchun();
     
     //动态的产生代理的对象
     
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
										    		System.out.println("出场费不够");
										    	}
										    }
										    else if("dance".equals(method.getName())){
										    	if("5".equals(args[0])){
										    		return method.invoke(liyuchun, args);
										    	}else{
										    		System.out
															.println("出场费不足");
										    	}
										    }
										    else if("eat".equals(method.getName())){
										    	if("8".equals(args[0])){
										    		System.out
															.println("今天没空");
										    	}
										    	else {
										    		System.out
															.println("钱不够");
										    	}
										    }
										
									    return null;
									}
								});
    	  return star;
    	   
      }
     


}
