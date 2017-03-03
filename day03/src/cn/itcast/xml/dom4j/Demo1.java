package cn.itcast.xml.dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
//import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Demo1 {
	 public static void main (String[] args) throws Exception
	 {
		 //获取dom4j对象解析器
		 SAXReader saxReader = new SAXReader();
         //读取硬盘中的xml文件
		 Document document = saxReader.read(new File("src/cn/itcast/xml/dom4j/car.xml"));
		 //获取根节点的元素对象
		 Element rootElement = document.getRootElement();
		 //获取根节点的全部子节点的集合
		 List<Element>  elements = rootElement.elements();
		 //打印各个节点的内容
		 for(Element el : elements)
		{
			System.out.println(el.elementText("车牌"));
			System.out.println(el.element("车牌").attributeValue("出产时间"));
			System.out.println(el.elementText("产地"));
			
		}
	 }

}
