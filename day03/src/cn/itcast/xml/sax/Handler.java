package cn.itcast.xml.sax;



import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	//�洢Ԫ����
	private String QName;
    private car mycar;
	//�洢car����
	private static List<car> listcar=new ArrayList<car>();
	//��ʼ��ȡxml�ļ�
	public void startDocument(){
       System.out.println("��ʼ����XML�ļ�");
	}
    //��ȡxml�ļ�����
	public void endDocument(){
		System.out.println("��������XML�ļ�");
	}
	//��ʼ��ȡԪ��
	public void startElement(String uri,
			                String locaName,
			                String qName,
			                Attributes attributes
			                ){
		
		if("����".equals(qName)){
			mycar = new car();
		}
		 QName = qName;
	     String cartime = attributes.getValue("����ʱ��");
          if(attributes.getLength()>0)
	       {
         	 mycar.setCarTime(cartime);
	       }
        // System.out.println("<"+qName+">");		
	}
    //��ȡԪ�ؽ���
	public void endElement(String uri,
			               String localName,
			               String qName
			               ){
		//System.out.println("</"+qName+">");
		 
	   if(qName.equals("����")){
		  
	    	listcar.add(mycar);
	    	//System.out.println(listcar.size());
	    }
	}
	//��ȡԪ��ֵ
	public void characters(char[] ch,int start,int length){
		String content = new String(ch,start,length);
		 if(content.trim().length()>0)
		 {
			 switch(QName){
			 case "����": mycar.setCarLog(content); break;
			 case "����": mycar.setCarProduce(content); break;
			 case "����": mycar.setCarprice(content);break;
			 
			 }
			 //System.out.println(content);		
		}
		
	}
	public static List<car> getListcar(){
		return listcar;
		
	}
	
}