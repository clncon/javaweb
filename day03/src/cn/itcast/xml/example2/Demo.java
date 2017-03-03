package cn.itcast.xml.example2;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) throws Exception {
		//获取硬盘中的xml文件
		SAXReader saxReader  = new SAXReader();
		Document document  = saxReader.read(new File("src/cn/itcast/xml/example2/Properties.xml"));
		//获取xml中指定的内容
		String XPath = "//className";
		String XPath2 = "//classMethod";
		String XPath3 = "//argType";
		String XPath4 = "//argValue";
		Element element = (Element) document.selectSingleNode(XPath);
		List<Element> element2 = (List<Element>) document.selectNodes(XPath2);
		Element element3 = (Element) document.selectSingleNode(XPath3);
		Element element4 = (Element) document.selectSingleNode(XPath4);
		//对xml中的 内容进行解析
		String className = element.getText();
        String classMethod = element2.get(1).getText();
        String argType = element3.getText();
        String argValue = element4.getText();
       // System.out.println("className:"+className+"...."+"classMethod:"+classMethod);
        //应用反射的技术来处理class
         Class clazz = Class.forName(className);
         Method method = clazz.getMethod(classMethod, Class.forName(argType));
               method.invoke(clazz.newInstance(), argValue);
        
	}

}
