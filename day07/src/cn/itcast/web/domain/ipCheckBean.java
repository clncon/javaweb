package cn.itcast.web.domain;

import java.util.Map;

public class ipCheckBean {
	//ͨ��ip��ȡ������
	public String ipCheck(String ip,Map map){
	     String adderess = (String) map.get(ip);
	     if(adderess!=null){
	     return adderess;
	     }
	     else{
	    	 return "�ݲ�֪";
	     }
		
		
	}

}
