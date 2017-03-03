package cn.itcast.web.ajax.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.itcast.web.ajax.domain.Province;

public class jsonTest {
     //使用第三工具把javaBean对象或者集合转换成json字符串
	public static void main(String[] args) {
		//创建javaBean的对象
	  Province province1 = new Province(1,"广东省");
	  Province province2 = new Province(2,"安徽省");
	  Province province3 = new Province(3,"河北省");
	  List<Province> listProvince= new ArrayList<Province>();
	    listProvince.add(province1);
	    listProvince.add(province2);
	    listProvince.add(province3);
	  //设置javaBean或集合在转换成json字符串时，不包含id属性
	  JsonConfig jsonconfig = new JsonConfig();
	  jsonconfig.setExcludes(new String[]{"id"});
	  //通过javaBean对象创建jsonArray对象
	  JSONArray jsonarray = JSONArray.fromObject(listProvince,jsonconfig);
	  //将javaBean对象转换成json字符串
	   String jsonString = jsonarray.toString();
	   System.out.println("JSONSTRING:"+jsonString);
	}

}
