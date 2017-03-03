package cn.itcast.xml.sax;


import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		
		//����SAXParserFactory
		SAXParserFactory Factory = SAXParserFactory.newInstance();
		//����SAXParserj������
		SAXParser saxParser = Factory.newSAXParser();
        //����xml�ļ�
		saxParser.parse(new File("src/cn/itcast/xml/sax/car.xml"), new Handler());
		/*System.out.println(mycar.getCarLog());
		System.out.println(mycar.getCarTime());
		System.out.println(mycar.getCarProduce());
		System.out.println(mycar.getCarprice());*/
		for(car mycar3 : Handler.getListcar()){
			System.out.println(mycar3 .getCarLog());
			System.out.println(mycar3.getCarTime());
			System.out.println(mycar3.getCarProduce());
			System.out.println(mycar3.getCarprice());
		}
		
	}

}
