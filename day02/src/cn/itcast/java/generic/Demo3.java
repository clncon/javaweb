package cn.itcast.java.generic;

import java.util.ArrayList;
import java.util.List;
//����ͨ���
public class Demo3 {

	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add("100");
		ls.add("200");
		ls.add("300");
		length(ls);

	}
	public static void length(List<?> li){
		System.out.println("����"+li.size());
	}

}
