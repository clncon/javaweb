package cn.itcast.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Demo2 {
	//关于dom的cud操作
     //1.create
	@Test
	public void createElement() throws Exception{
		//获得Domcument对象
		Document document = getDocument();
		//创建新的元素节点汽车
		Element newCarElement = document.createElement("汽车");
		//设置新元素文本的内容
		newCarElement.setTextContent("这是我的汽车");
		//取得根节点的元素
		Element rootElement = document.getDocumentElement();
		//将新元素放到根节点元素里最后的一个汽车元素之后
		rootElement.appendChild(newCarElement);
		//写入到本地硬盘
		write2xml(document);
		
	   	
	}
	@Test
	public void delete() throws Exception{
		Document document = getDocument();
		//定位到要删除的元素节点
		Element rootElement = document.getDocumentElement();
		NodeList  carElement = rootElement.getElementsByTagName("汽车");
		Element SecondCarElement = (Element) carElement.item(1);
		Element carPriceElement = (Element) SecondCarElement.getElementsByTagName("单价").item(0);
		carPriceElement.setTextContent("");
		//写入到本地硬盘
		write2xml(document);
		
		
	}
	@Test
	public void upDate() throws Exception{
		Document document = getDocument();
		//定位到需要更改的元素节点
		Element rootElement = document.getDocumentElement();
		NodeList  carElement = rootElement.getElementsByTagName("汽车");
		Element SecondCarElement = (Element) carElement.item(1);
		Element carPriceElement = (Element) SecondCarElement.getElementsByTagName("单价").item(0);
		carPriceElement.setTextContent("98");
		//写入到本地硬盘
				write2xml(document);
				
		
	}

	public void write2xml(Document document)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		TransformerFactory Factory = TransformerFactory.newInstance();
		Transformer transformer = Factory.newTransformer();
		DOMSource  xmlSource = new DOMSource(document); 
		StreamResult  xmlResult = new StreamResult(new File("src/cn/itcast/xml/dom/car.xml"));
		transformer.transform(xmlSource, xmlResult);
	}

	public Document getDocument() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentbuilder = Factory.newDocumentBuilder();
		Document document = documentbuilder.parse(new File("src/cn/itcast/xml/dom/car.xml"));
		return document;
	}

}
