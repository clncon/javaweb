package cn.itcast.web.decorator;

import java.io.BufferedReader;
import java.io.IOException;



public class MyBufferedReader {
	private BufferedReader br ;
	private int no;
	public MyBufferedReader(BufferedReader br){
		this.br=br;
	}
	public String ReadLine() throws Exception{
		String str=null;
		 str = br.readLine();
		 if(str!=null){
			 no++;
			 str = no+":"+str;
		 }
		 return str;
	}
	public void close() throws Exception{
		br.close();
	}
	
	
	
}
