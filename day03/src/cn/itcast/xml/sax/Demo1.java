package cn.itcast.xml.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;





public class Demo1 {
	public static void main(String[] agrs) throws Exception{
	//建立SAXParserFactory对象
	SAXParserFactory Factory = SAXParserFactory .newInstance();
	//建立SAXParser解析器对象
	SAXParser  saxparser = Factory.newSAXParser();
	//解析xml文件
	 saxparser.parse(new File("src/cn/itcast/xml/sax/car.xml"), new Handler());
	}
 
}

