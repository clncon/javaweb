package cn.itcast.xml.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.BeforeClass;
import org.junit.Test;

public class Demo2 {
	

	@Test
	public void create() throws Exception{
		//获取dom4j的解析器对象
		Document document = getDocument();
		 Element rootElement = document.getRootElement();
		//向xml添加一条标签
		List<Element> elements = rootElement.elements();
		Element secondElement = (Element)elements.get(0);
	    secondElement.addElement("单价").setText("46");
	    //将内存的xml文件存入本地
	    writeXml(document);
	  
	}
	private void writeXml(Document document) throws FileNotFoundException, UnsupportedEncodingException, IOException {
		OutputStream ops = new FileOutputStream("src/cn/itcast/xml/dom4j/car.xml");
	    OutputFormat opf = OutputFormat.createPrettyPrint();
	     XMLWriter xmlWriter = new XMLWriter(ops,opf);
	     xmlWriter.write(document);
	     xmlWriter.close();
	}
	private Document getDocument() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		//获取本地的xml文件
		Document document = saxReader.read(new File("src/cn/itcast/xml/dom4j/car.xml"));
		return document;
	}
	 @Test
	public void updata() throws Exception{
		 Document document = getDocument();
		 //获取根节点对象
		 Element rootElement = document.getRootElement();
		 //修改xml文件中的一个元素
		 List<Element> elements = rootElement.elements();
		 Element firstElment = elements.get(0);
		  Element upElement = firstElment.element("单价");
		   upElement.setText("45");
		  writeXml(document);
	 } 
	 @Test
	 public void delete() throws Exception{
		 //获取document对象
		 Document document  = getDocument();
		 //获取根节点
		 Element rootElement = document.getRootElement();
		 //定位到需删除的元素
		 List<Element> elements = rootElement.elements();
		 Element element = elements.get(0);
		 Element deElement = element.element("单价");
		 element.remove(deElement);
		 writeXml(document);
 
	 }
	
	

}
