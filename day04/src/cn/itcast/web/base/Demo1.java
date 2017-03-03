package cn.itcast.web.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		
		while(true)
		{
			Socket s= ss.accept();
		
		
		//获取输入
		BufferedReader br = new BufferedReader(new FileReader("D:/abc.html"));
		//获得输出流
		OutputStream os = s.getOutputStream();
	    String line = null;
		while((line = br.readLine())!=null){
			os.write(line.getBytes());
		}
		//ss.close();
		s.close();
         br.close();
		os.close();
		}
          
	}

}
