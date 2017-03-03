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
/*if(province.equals("吉林省")){
	   listCity.add(new City(1,"长春"));
	   listCity.add(new City(2,"吉林市"));
	   listCity.add(new City(3,"松原"));
	   listCity.add(new City(4,"松原"));
	  
	   
}else if(province.equals("辽宁省")){
	   listCity.add(new City(1,"沈阳"));
	   listCity.add(new City(2,"大连"));
	   listCity.add(new City(3,"鞍山"));
	   listCity.add(new City(4,"抚顺"));
	   listCity.add(new City(5,"铁岭"));
	  
}else if(province.equals("山东省")){
listCity.add(new City(1,"济南"));
listCity.add(new City(2,"青岛"));
listCity.add(new City(3,"威海"));
	   
}
JsonConfig jsonconfig = new JsonConfig();
jsonconfig.setExcludes(new String[]{"id"});
JSONArray jsonarray = JSONArray.fromObject(listCity, jsonconfig);
String jsonString = jsonarray.toString();
System.out.println(jsonString);
pw.write(jsonString);*/
/*pw.write("<root>");
if(province.equals("吉林省")){
	pw.write("<city>长春[吉林省]</city>"); 
	pw.write("<city>吉林市[吉林省]</city>"); 
	pw.write("<city>松原[吉林省]</city>"); 
	pw.write("<city>通化[吉林省]</city>"); 
	
}else if(province.equals("辽宁省")){
	pw.write("<city>沈阳[辽宁省]</city>"); 
	pw.write("<city>大连[辽宁省]</city>"); 
	pw.write("<city>鞍山[辽宁省]</city>"); 
	pw.write("<city>抚顺[辽宁省]</city>"); 
	pw.write("<city>铁岭[辽宁省]</city>"); 
	
}else if(province.equals("山东省")){
	pw.write("<city>济南[山东省]</city>"); 
	pw.write("<city>青岛[山东省]</city>"); 
	pw.write("<city>威海[山东省]</city>"); 
	
	
}
pw.write("</root>");
*/