package cn.itcast.xml.xpath;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//ʹ��Xpath��ȡ�õڶ��������Ĳ���
public class Demo1 {

	public static void main(String[] args) throws Exception {
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("src/cn/itcast/xml/xpath/car.xml"));
		String XPath = "//����";
		//List<Element> element = document.selectNodes(XPath);
       /* for(Element el : element){
        	System.out.println(el.getText());
        }*/
		Element element = (Element) document.selectSingleNode(XPath);
		System.out.println(element.getText());
	}

}
