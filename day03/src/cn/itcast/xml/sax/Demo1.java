package cn.itcast.xml.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;





public class Demo1 {
	public static void main(String[] agrs) throws Exception{
	//����SAXParserFactory����
	SAXParserFactory Factory = SAXParserFactory .newInstance();
	//����SAXParser����������
	SAXParser  saxparser = Factory.newSAXParser();
	//����xml�ļ�
	 saxparser.parse(new File("src/cn/itcast/xml/sax/car.xml"), new Handler());
	}
 
}

