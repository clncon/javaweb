package cn.itcast.java.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {
	

	public static void main(String[] args) {
		int Stringnum=0;
		int Intnum=0;
		int Doublenum=0;
		int Booleannum=0;
		int Charnum=0;
		List li = new ArrayList<Object>();
		li.add("liii");
		li.add("didi");
		li.add(10);
		li.add(2.23);
		li.add(true);
		li.add("5.645");
		li.add(false);
		li.add('l');
		Iterator it = li.iterator();
		
		while(it.hasNext()){
            Object obj = it.next();
            if(obj instanceof String){
            	Stringnum++;
            }
            else if (obj instanceof Integer){
                     Intnum++;            	
            }
            else if(obj instanceof Double){
            	Doublenum++;
            }
            else if(obj instanceof Boolean){
            	Booleannum++;
            }
            else if(obj instanceof Character){
            	Charnum++;
            }
            
		}
		System.out.println(Stringnum);
		System.out.println(Intnum);
		System.out.println(Doublenum);
		System.out.println(Booleannum);
		System.out.println(Charnum);
		

	}

}
