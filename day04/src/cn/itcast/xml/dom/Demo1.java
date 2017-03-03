package cn.itcast.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Demo1 {
	public static void main(String[] agrs) throws Exception{
	//建立dom解析器的工厂
	DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
	//建立dom解析器
	DocumentBuilder documentbuilder = Factory.newDocumentBuilder();
	//加载xml文件
	Document domcument =  documentbuilder.parse(new File("src/cn/itcast/xml/dom/car.xml"));
	 //定位根节点
	 Element rootElement = domcument.getDocumentElement();
	 //定位到汽车节点
	 NodeList carElementList = (NodeList) rootElement.getElementsByTagName("汽车");
			 System.out.println("有"+carElementList.getLength()+"辆汽车");
	 //定位到第一辆汽车的车牌标签并打印它的值，和属性值
			 Element FirstcarElement = (Element) carElementList.item(0);
			 Element carBendElement = (Element) FirstcarElement.getElementsByTagName("车牌").item(0);
			 String carTime = carBendElement.getAttribute("出产时间");
			 String carBend = carBendElement.getTextContent();
			 System.out.print("出产时间 :  "+carTime+"车牌 : "+carBend);
			 
			 
	}
}
