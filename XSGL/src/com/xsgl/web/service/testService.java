package com.xsgl.web.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xsgl.web.domain.MyClass;

public class testService {
     public static void main(String[] args) throws Exception {
		   stuService stuservice = new stuService();
		   Map<String,List<MyClass>> map = stuservice.QueryAllClassByGreateInAsc("chinese");
		    List<MyClass> listClassInAsc = map.get("chinese");
		    for(MyClass myclass:listClassInAsc){
		    	 System.out.println(myclass.getOutstanding());
		    }
		  
	}
}
