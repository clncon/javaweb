package cn.itcast.java.addfor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


//新强型for循环迭代数组，集合（set/list/map二种方式[keySet()/entrySet()]）
public class Demo1 {

	public static void main(String[] args) {
		Set<String>  s = new HashSet<String>();
		s.add("lili");
		s.add("hehe");
		s.add("mimi");
		for(String value:s){
			System.out.println(value);
		}
	     Map<String,Integer> m = new HashMap<String,Integer>();
           m.put("lili",20);
           m.put("hehe",30);
           m.put("mimi",40);
           Set<Map.Entry<String,Integer>> set = m.entrySet();
           Iterator<Map.Entry<String,Integer>> it= set.iterator();
           while(it.hasNext())
           {
        	   Entry<String,Integer> en = it.next();
        	   System.out.println(en.getKey()+"=="+en.getValue());
           }
         /*  Set<String> sd = m.keySet();
           Iterator<String>  it = sd.iterator();
           while (it.hasNext()) {
        	   String st = it.next();
        	   int i = m.get(st);
        	   System.out.println(st+"=="+i);
			
		}*/
	}

}
