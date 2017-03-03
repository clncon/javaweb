package cn.itcast.xml.dom4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo4 {
	public static void main(String[] args)throws Exception{
		List<carDemo> co = new ArrayList<carDemo>();
		SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/cn/itcast/xml/dom4j/car.xml"));
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for(Element li : elements){
        	carDemo car  = new carDemo();
           String carTime = li.element("����").attributeValue("����ʱ��");
        	car.setCarTime(carTime);
        	String carLog = li.elementText("����");
        	car.setCarLog(carLog);
        	String carProduce = li.elementText("����");
        	car.setCarProduce(carProduce);
        	String carprice = li.elementText("����");
        	double carPrice = Double.parseDouble(carprice);
        	car.setCarPrice(carPrice);
        	co.add(car);
        	
        	
        }
        Collections.sort(co);
        show(co);
       
        
        
	}
	public static void show(List<carDemo> e){
		for(carDemo co : e){
			System.out.println("����:"+co.getCarLog()+"......����ʱ��:"+co.getCarTime());
			System.out.println("������:"+co.getCarProduce()+"......����:"+co.getCarPrice()+"");
		}
			
		
	}
	

}
