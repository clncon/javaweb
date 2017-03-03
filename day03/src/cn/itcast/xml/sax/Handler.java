package cn.itcast.xml.sax;



import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	//存储元素名
	private String QName;
    private car mycar;
	//存储car对象
	private static List<car> listcar=new ArrayList<car>();
	//开始读取xml文件
	public void startDocument(){
       System.out.println("开始解析XML文件");
	}
    //读取xml文件结束
	public void endDocument(){
		System.out.println("结束解析XML文件");
	}
	//开始读取元素
	public void startElement(String uri,
			                String locaName,
			                String qName,
			                Attributes attributes
			                ){
		
		if("汽车".equals(qName)){
			mycar = new car();
		}
		 QName = qName;
	     String cartime = attributes.getValue("出产时间");
          if(attributes.getLength()>0)
	       {
         	 mycar.setCarTime(cartime);
	       }
        // System.out.println("<"+qName+">");		
	}
    //读取元素结束
	public void endElement(String uri,
			               String localName,
			               String qName
			               ){
		//System.out.println("</"+qName+">");
		 
	   if(qName.equals("汽车")){
		  
	    	listcar.add(mycar);
	    	//System.out.println(listcar.size());
	    }
	}
	//读取元素值
	public void characters(char[] ch,int start,int length){
		String content = new String(ch,start,length);
		 if(content.trim().length()>0)
		 {
			 switch(QName){
			 case "车牌": mycar.setCarLog(content); break;
			 case "产地": mycar.setCarProduce(content); break;
			 case "单价": mycar.setCarprice(content);break;
			 
			 }
			 //System.out.println(content);		
		}
		
	}
	public static List<car> getListcar(){
		return listcar;
		
	}
	
}