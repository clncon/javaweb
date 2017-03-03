package cn.itcast.xml.example1;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class LogingBusiness {
	
		public boolean Check(User user) throws Exception{
			
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new File("src/cn/itcast/xml/xpath/user.xml"));
			String XPath = "//user[@username = '"+user.getUserName()+"' and @userpassword = '"+user.getUserPassword()+"']";
			Element element = (Element) document.selectSingleNode(XPath);
			//System.out.println(element);
			if(element!=null){
				return true;
			}
			else{
				return false;
			}
		}
	}


