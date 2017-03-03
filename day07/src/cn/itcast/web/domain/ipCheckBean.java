package cn.itcast.web.domain;

import java.util.Map;

public class ipCheckBean {
	//通过ip获取归属地
	public String ipCheck(String ip,Map map){
	     String adderess = (String) map.get(ip);
	     if(adderess!=null){
	     return adderess;
	     }
	     else{
	    	 return "暂不知";
	     }
		
		
	}

}
