package cn.itcast.java.autobox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//List���ϼ���int�ͺ�ȡ��Integer��������/
public class Demo1 {

	public static void main(String[] args) {
		 List<Integer> l = new ArrayList<Integer>();
		  l.add(10);
		  l.add(20);
		  l.add(30);
		  l.add(40);
		  Iterator<Integer> it = l.iterator();
		  while (it.hasNext()){
			  Integer in = it.next();
			  System.out.println(in);
		  }
	 
		  
 
	}

}
