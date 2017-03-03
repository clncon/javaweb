package cn.itcast.java.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo4 {

	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add("sfd");
		ls.add("kkl");
		ls.add("ks");
		ls.add("kk");
		resverse(ls);

	}
	public static void resverse(List<String> li ){
	  Iterator it = li.iterator();
	  String[] str = new String[10];
	  int i= 0;
	   while(it.hasNext()){
		   //System.out.println(it.next());
		   str[i] = (String) it.next();
		   i++;
		   
	   }
	  
	   for(int n = str.length-1;n>=0;n--){
		   System.out.println(str[n]);
	   }
	}
	

}
