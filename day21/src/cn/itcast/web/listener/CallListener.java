package cn.itcast.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class CallListener implements ServletRequestListener{
      private static Map<String,String> map = new HashMap<String,String>();
      //ʵ������
      private int counter;
      //����һ����
      Object lock = new Object();
      static{
    	  map.put("127.0.0.1","�Ϸ�");
    	  map.put("192.168.1.105","����");
    	  map.put("192.168.1.102","����");
    	  map.put("192.168.1.103","�Ͼ�");
    	  
      }
	
	public void requestDestroyed(ServletRequestEvent sre) {
		
		
	}

	
	public void requestInitialized(ServletRequestEvent sre) {
		//��ֹ���̵߳�����
		 synchronized (lock) {
			this.counter++;
		}
		//ȡ��request����
	    HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
	    //ȡ�÷����ߵ�ip��ַ
	    String ip = request.getRemoteAddr();
	    //����ip���Ҷ�Ӧ�ĵ�ַ
	    String addr = map.get(ip);
	    request.setAttribute("ip", ip);
	    request.setAttribute("counter", this.counter);
	    //��������ھ�Ĭ�ϵ�ַΪ�Ϻ�
	    if(addr==null){
	    	request.setAttribute("address","�Ϻ�");
	    }else{
	    	request.setAttribute("address", addr);
	    }
	     
		
	}

}
