package cn.itcast.web.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import cn.itcast.web.ajax.dao.CityDao;
import cn.itcast.web.ajax.domain.City;



public class CityServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           System.out.println("CityServlet:DoGet");
		   String province = request.getParameter("province");
		   province = new String(province.getBytes("ISO8859-1"),"utf-8");
		   System.out.println(province);
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter pw = response.getWriter();
		   String jsonString = null;
		   CityDao citydao = new CityDao();
		   try {
			List<City>listCity = citydao.findAllCityByProvince(province);
			 if(listCity!=null){
				 JsonConfig  jsonconfig = new JsonConfig();
				 jsonconfig.setExcludes(new String[]{"id","province_name"});
				 JSONArray jsonarray = JSONArray.fromObject(listCity,jsonconfig);
				 jsonString=jsonarray.toString();
				 System.out.println(jsonString);
				 pw.write(jsonString);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

	
}
/*if(province.equals("����ʡ")){
	   listCity.add(new City(1,"����"));
	   listCity.add(new City(2,"������"));
	   listCity.add(new City(3,"��ԭ"));
	   listCity.add(new City(4,"��ԭ"));
	  
	   
}else if(province.equals("����ʡ")){
	   listCity.add(new City(1,"����"));
	   listCity.add(new City(2,"����"));
	   listCity.add(new City(3,"��ɽ"));
	   listCity.add(new City(4,"��˳"));
	   listCity.add(new City(5,"����"));
	  
}else if(province.equals("ɽ��ʡ")){
listCity.add(new City(1,"����"));
listCity.add(new City(2,"�ൺ"));
listCity.add(new City(3,"����"));
	   
}
JsonConfig jsonconfig = new JsonConfig();
jsonconfig.setExcludes(new String[]{"id"});
JSONArray jsonarray = JSONArray.fromObject(listCity, jsonconfig);
String jsonString = jsonarray.toString();
System.out.println(jsonString);
pw.write(jsonString);*/
/*pw.write("<root>");
if(province.equals("����ʡ")){
	pw.write("<city>����[����ʡ]</city>"); 
	pw.write("<city>������[����ʡ]</city>"); 
	pw.write("<city>��ԭ[����ʡ]</city>"); 
	pw.write("<city>ͨ��[����ʡ]</city>"); 
	
}else if(province.equals("����ʡ")){
	pw.write("<city>����[����ʡ]</city>"); 
	pw.write("<city>����[����ʡ]</city>"); 
	pw.write("<city>��ɽ[����ʡ]</city>"); 
	pw.write("<city>��˳[����ʡ]</city>"); 
	pw.write("<city>����[����ʡ]</city>"); 
	
}else if(province.equals("ɽ��ʡ")){
	pw.write("<city>����[ɽ��ʡ]</city>"); 
	pw.write("<city>�ൺ[ɽ��ʡ]</city>"); 
	pw.write("<city>����[ɽ��ʡ]</city>"); 
	
	
}
pw.write("</root>");
*/