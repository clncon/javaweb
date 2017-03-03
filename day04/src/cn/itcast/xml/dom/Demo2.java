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
	//����dom��cud����
     //1.create
	@Test
	public void createElement() throws Exception{
		//���Domcument����
		Document document = getDocument();
		//�����µ�Ԫ�ؽڵ�����
		Element newCarElement = document.createElement("����");
		//������Ԫ���ı�������
		newCarElement.setTextContent("�����ҵ�����");
		//ȡ�ø��ڵ��Ԫ��
		Element rootElement = document.getDocumentElement();
		//����Ԫ�طŵ����ڵ�Ԫ��������һ������Ԫ��֮��
		rootElement.appendChild(newCarElement);
		//д�뵽����Ӳ��
		write2xml(document);
		
	   	
	}
	@Test
	public void delete() throws Exception{
		Document document = getDocument();
		//��λ��Ҫɾ����Ԫ�ؽڵ�
		Element rootElement = document.getDocumentElement();
		NodeList  carElement = rootElement.getElementsByTagName("����");
		Element SecondCarElement = (Element) carElement.item(1);
		Element carPriceElement = (Element) SecondCarElement.getElementsByTagName("����").item(0);
		carPriceElement.setTextContent("");
		//д�뵽����Ӳ��
		write2xml(document);
		
		
	}
	@Test
	public void upDate() throws Exception{
		Document document = getDocument();
		//��λ����Ҫ���ĵ�Ԫ�ؽڵ�
		Element rootElement = document.getDocumentElement();
		NodeList  carElement = rootElement.getElementsByTagName("����");
		Element SecondCarElement = (Element) carElement.item(1);
		Element carPriceElement = (Element) SecondCarElement.getElementsByTagName("����").item(0);
		carPriceElement.setTextContent("98");
		//д�뵽����Ӳ��
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
