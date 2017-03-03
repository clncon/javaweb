package cn.itcast.web.ajax.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.itcast.web.ajax.domain.Province;

public class jsonTest {
     //ʹ�õ������߰�javaBean������߼���ת����json�ַ���
	public static void main(String[] args) {
		//����javaBean�Ķ���
	  Province province1 = new Province(1,"�㶫ʡ");
	  Province province2 = new Province(2,"����ʡ");
	  Province province3 = new Province(3,"�ӱ�ʡ");
	  List<Province> listProvince= new ArrayList<Province>();
	    listProvince.add(province1);
	    listProvince.add(province2);
	    listProvince.add(province3);
	  //����javaBean�򼯺���ת����json�ַ���ʱ��������id����
	  JsonConfig jsonconfig = new JsonConfig();
	  jsonconfig.setExcludes(new String[]{"id"});
	  //ͨ��javaBean���󴴽�jsonArray����
	  JSONArray jsonarray = JSONArray.fromObject(listProvince,jsonconfig);
	  //��javaBean����ת����json�ַ���
	   String jsonString = jsonarray.toString();
	   System.out.println("JSONSTRING:"+jsonString);
	}

}
