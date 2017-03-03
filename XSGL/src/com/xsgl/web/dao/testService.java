package com.xsgl.web.dao;

import java.util.List;
import java.util.Map;

import com.xsgl.web.domain.MyClass;
import com.xsgl.web.service.stuService;

public class testService {

	
	public static void main(String[] args) throws Exception {
		stuService  stuservice = new stuService();
		Map<String, List<MyClass>> map = 
				stuservice.
				QueryAllClassByCourse("english");
		
        List<MyClass>  listMyClass = map.get("english");
        for(MyClass myclass:listMyClass){
        	System.out.println("��������:"+myclass.getUnfail());
        	System.out.println("������:"+myclass.getOutstanding());
        }
	}

}
