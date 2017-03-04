package cn.itcast.java.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo1 {

	public static void main(String[] args) throws Exception {
        //文件的复制
		InputStream fis = new FileInputStream("c://saveDir//1.jpg");
		OutputStream fos = new FileOutputStream("c://2.jpg");
        byte[] buff = new byte[1024];
        while(fis.read(buff)!=-1){
        	  fos.write(buff);
        }
        fos.close();
        fis.close();
        

	}

}
