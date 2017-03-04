package cn.itcast.java.addfor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//向List集合并发存取元素引起的问题
public class Demo2 {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		li.add(10);
		li.add(20);
		li.add(30);
		li.add(40);
		ListIterator<Integer> lit = li.listIterator();
		while(lit.hasNext()){
			Integer in = lit.next();
			System.out.println(in);
			lit.add(50);
		}
     System.out.println(li.size());
	}

}
