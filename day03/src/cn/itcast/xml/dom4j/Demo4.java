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
           String carTime = li.element("车牌").attributeValue("出产时间");
        	car.setCarTime(carTime);
        	String carLog = li.elementText("车牌");
        	car.setCarLog(carLog);
        	String carProduce = li.elementText("产地");
        	car.setCarProduce(carProduce);
        	String carprice = li.elementText("单价");
        	double carPrice = Double.parseDouble(carprice);
        	car.setCarPrice(carPrice);
        	co.add(car);
        	
        	
        }
        Collections.sort(co);
        show(co);
       
        
        
	}
	public static void show(List<carDemo> e){
		for(carDemo co : e){
			System.out.println("车牌:"+co.getCarLog()+"......出产时间:"+co.getCarTime());
			System.out.println("出产地:"+co.getCarProduce()+"......单价:"+co.getCarPrice()+"");
		}
			
		
	}
	

}
