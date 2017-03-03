package cn.itcast.web.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import cn.itcast.web.decorator.MyBufferedReader;

public class Test1 {

	
	public static void main(String[] args) throws Exception {
		/*
		 * 装饰的设计思想即是当本类的中的部分方法不满足我们的要求时，
		 * 我们新创建一个类，并将本类作为一个参数传给新建类
		 * 在对本类的部分方法进行改写，
		 * 这样做的好处是避免对父类的所有方法都进行重写或继承，从而优化系统
		 * */
		BufferedReader br = 
				new BufferedReader(new FileReader("E:\\text.txt"));
		MyBufferedReader mbr = new MyBufferedReader(br);
		String line;
		while((line=mbr.ReadLine())!=null){
			System.out.println(line);
		}
		mbr.close();
		
	}

}
