package cn.itcast.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Demo1 {
	public static void main(String[] agrs) throws Exception{
	//����dom�������Ĺ���
	DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
	//����dom������
	DocumentBuilder documentbuilder = Factory.newDocumentBuilder();
	//����xml�ļ�
	Document domcument =  documentbuilder.parse(new File("src/cn/itcast/xml/dom/car.xml"));
	 //��λ���ڵ�
	 Element rootElement = domcument.getDocumentElement();
	 //��λ�������ڵ�
	 NodeList carElementList = (NodeList) rootElement.getElementsByTagName("����");
			 System.out.println("��"+carElementList.getLength()+"������");
	 //��λ����һ�������ĳ��Ʊ�ǩ����ӡ����ֵ��������ֵ
			 Element FirstcarElement = (Element) carElementList.item(0);
			 Element carBendElement = (Element) FirstcarElement.getElementsByTagName("����").item(0);
			 String carTime = carBendElement.getAttribute("����ʱ��");
			 String carBend = carBendElement.getTextContent();
			 System.out.print("����ʱ�� :  "+carTime+"���� : "+carBend);
			 
			 
	}
}
