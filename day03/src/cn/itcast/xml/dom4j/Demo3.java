package cn.itcast.xml.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

//DOM4J其它API使用
public class Demo3 {
	//1.String->XML
	@Test
	public void Test1() throws Exception{
	  	String text = "<root>这是根节点</root>";
	    Document doucument = DocumentHelper.parseText(text);
	    OutputStream ops = 
	                 new FileOutputStream(new File("src/cn/itcast/xml/dom4j/newXml.xml"));
	    OutputFormat opf = OutputFormat.createPrettyPrint();
	    XMLWriter xmlWriter = new XMLWriter(ops,opf);
	    xmlWriter.write(doucument);
	    xmlWriter.close();
	}
	@Test
	//创建xml文件
	public void Test2() throws Exception{
		Document document = DocumentHelper.createDocument();
		document.addElement("root").setText("这是根节点");
		OutputStream ops = 
				new FileOutputStream(new File("src/cn/itcast/xml/dom4j/null.xml"));
		OutputFormat opf = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(ops,opf);
		xmlWriter.write(document);
		xmlWriter.close();
	} 
	@Test
	 //在指定位置差入element
	public void Test3() throws Exception{
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("src/cn/itcast/xml/dom4j/car.xml"));
		Element rootElement = document.getRootElement();
		Element newElement = DocumentHelper.createElement("汽车");
		newElement.setText("this is my car");
		List<Element> elements = rootElement.elements();
		elements.add(1, newElement);
		OutputStream ops = 
				new FileOutputStream(new File("src/cn/itcast/xml/dom4j/car.xml"));
		OutputFormat opf = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(ops,opf);
		xmlWriter.write(document);
		xmlWriter.close();
		
		
	}
	@Test
	//XML->String
	public void Test4() throws Exception{
		SAXReader saxReader = new SAXReader();
	    Document document = saxReader.read(new File("src/cn/itcast/xml/dom4j/car.xml"));
	    Element rootElement = document.getRootElement();
	    List<Element> elements = rootElement.elements();
	    Element fristElement = elements.get(0);
	    Element element = fristElement.element("车牌");
	    System.out.println(element.asXML());
	    //System.out.println(document.asXML());
	}
	
	

}
