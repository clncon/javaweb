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
		 //��ȡdom4j���������
		 SAXReader saxReader = new SAXReader();
         //��ȡӲ���е�xml�ļ�
		 Document document = saxReader.read(new File("src/cn/itcast/xml/dom4j/car.xml"));
		 //��ȡ���ڵ��Ԫ�ض���
		 Element rootElement = document.getRootElement();
		 //��ȡ���ڵ��ȫ���ӽڵ�ļ���
		 List<Element>  elements = rootElement.elements();
		 //��ӡ�����ڵ������
		 for(Element el : elements)
		{
			System.out.println(el.elementText("����"));
			System.out.println(el.element("����").attributeValue("����ʱ��"));
			System.out.println(el.elementText("����"));
			
		}
	 }

}
