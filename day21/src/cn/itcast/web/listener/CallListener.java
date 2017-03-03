package cn.itcast.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class CallListener implements ServletRequestListener{
      private static Map<String,String> map = new HashMap<String,String>();
      //实例变量
      private int counter;
      //创建一个锁
      Object lock = new Object();
      static{
    	  map.put("127.0.0.1","合肥");
    	  map.put("192.168.1.105","北京");
    	  map.put("192.168.1.102","广州");
    	  map.put("192.168.1.103","南京");
    	  
      }
	
	public void requestDestroyed(ServletRequestEvent sre) {
		
		
	}

	
	public void requestInitialized(ServletRequestEvent sre) {
		//防止多线程的问题
		 synchronized (lock) {
			this.counter++;
		}
		//取得request对象
	    HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
	    //取得访问者的ip地址
	    String ip = request.getRemoteAddr();
	    //根据ip查找对应的地址
	    String addr = map.get(ip);
	    request.setAttribute("ip", ip);
	    request.setAttribute("counter", this.counter);
	    //如果不存在就默认地址为上海
	    if(addr==null){
	    	request.setAttribute("address","上海");
	    }else{
	    	request.setAttribute("address", addr);
	    }
	     
		
	}

}
