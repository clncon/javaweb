package cn.itcast.web.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import cn.itcast.web.decorator.MyBufferedReader;

public class Test1 {

	
	public static void main(String[] args) throws Exception {
		/*
		 * װ�ε����˼�뼴�ǵ�������еĲ��ַ������������ǵ�Ҫ��ʱ��
		 * �����´���һ���࣬����������Ϊһ�����������½���
		 * �ڶԱ���Ĳ��ַ������и�д��
		 * �������ĺô��Ǳ���Ը�������з�����������д��̳У��Ӷ��Ż�ϵͳ
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
