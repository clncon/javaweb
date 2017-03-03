package cn.itcast.xml.example3.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.itcast.xml.example3.domain.Student;

public class StudentDao {
	public boolean create(Student student) throws Exception{
		boolean flag = false;
		if(student != null)
		{
			Document document = getDocument();
			Element rootElement = document.getRootElement();
			Element studentElement = rootElement.addElement("student");
			
			studentElement.addAttribute("id", student.getId());
			Element nameElement = studentElement.addElement("name");
			nameElement.addText(student.getName());
			Element ageElement = studentElement.addElement("age");
			ageElement.addText(student.getAge());
			write2Xml(document);
			flag = true;
		}
		return flag;
	}
	public boolean upDate(Student student) throws Exception{
		 boolean flag = false;
		if(student != null){
			
			Document document = getDocument();
			Element rootElement = document.getRootElement();
			String Xpath = "//student[id  = '"+student.getId()+"']";
			Element studentElement = (Element) rootElement.selectSingleNode(Xpath);
			if(student.getName()!=null){
				studentElement.addText(student.getName());
			}
			if(student.getAge()!=null){
				studentElement.addText(student.getAge());
			}
			flag = true;
		}
		return flag;
	}
	public boolean Read(Student student ) throws Exception{
		boolean flag = false;
		if(student!=null){
			Document document = getDocument();
			Element rootElement = document.getRootElement();
		    String XPath = "//student[id = '"+student.getId()+"']";
		    Element studentElement = (Element) rootElement.selectSingleNode(XPath);
		    String studentName = studentElement.elementText("name");
		    String studentAge = studentElement.elementText("age");
		    System.out.println(student.getId());
		    if(studentName!=null){
		    	System.out.print("name:"+studentName);
		    }
		    if(studentAge!=null){
		    	System.out.print("age"+studentAge);
		    }
		    flag = true;
		}
		return flag;
	}
	public boolean delete(Student student) throws Exception{
		boolean flag = false;
		if(student != null){
			Document document = getDocument();
			Element rootElement = document.getRootElement();
			String XPath = "//student[id = '"+student.getId()+"']";
			Element studentElement = (Element) rootElement.selectSingleNode(XPath);
			rootElement.remove(studentElement);
		}
		return flag;
	}

	private void write2Xml(Document document) throws FileNotFoundException, UnsupportedEncodingException, IOException {
		OutputStream ops = new FileOutputStream("src/cn/itcast/xml/example3/db/students.xml");
		OutputFormat opf = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(ops,opf);
		xmlWriter.write(document);
		xmlWriter.close();
	}

	private Document getDocument() throws DocumentException {
		SAXReader  saxReader = new SAXReader();
		Document document = 
				   saxReader.read(new File("src/cn/itcast/xml/example3/db/students.xml"));
		return document;
	}

}
