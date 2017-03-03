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
		//��ȡdom4j�Ľ���������
		Document document = getDocument();
		 Element rootElement = document.getRootElement();
		//��xml���һ����ǩ
		List<Element> elements = rootElement.elements();
		Element secondElement = (Element)elements.get(0);
	    secondElement.addElement("����").setText("46");
	    //���ڴ��xml�ļ����뱾��
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
		//��ȡ���ص�xml�ļ�
		Document document = saxReader.read(new File("src/cn/itcast/xml/dom4j/car.xml"));
		return document;
	}
	 @Test
	public void updata() throws Exception{
		 Document document = getDocument();
		 //��ȡ���ڵ����
		 Element rootElement = document.getRootElement();
		 //�޸�xml�ļ��е�һ��Ԫ��
		 List<Element> elements = rootElement.elements();
		 Element firstElment = elements.get(0);
		  Element upElement = firstElment.element("����");
		   upElement.setText("45");
		  writeXml(document);
	 } 
	 @Test
	 public void delete() throws Exception{
		 //��ȡdocument����
		 Document document  = getDocument();
		 //��ȡ���ڵ�
		 Element rootElement = document.getRootElement();
		 //��λ����ɾ����Ԫ��
		 List<Element> elements = rootElement.elements();
		 Element element = elements.get(0);
		 Element deElement = element.element("����");
		 element.remove(deElement);
		 writeXml(document);
 
	 }
	
	

}
