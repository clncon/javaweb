package cn.itcast.web.mail.base;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Demo1 {

	
	public static void main(String[] args) throws IOException {
		//Base64���ܷ�ʽ
		String username = "aaa@km.com";
		String  password = "123456";
		BASE64Encoder encoder = new BASE64Encoder();
		//����
		username = encoder.encode(username.getBytes());
		password = encoder.encode(password.getBytes());
        System.out.println(username+":"+password);
        //����
         BASE64Decoder decorder = new BASE64Decoder();
         username="YWFhQGttLmNvbQ==";
         password="MTIzNDU2";
         byte[] buff1 = decorder.decodeBuffer(username);
         byte[] buff2 = decorder.decodeBuffer(password);
         username = new String(buff1,"UTF-8");
         password = new String(buff2,"UTF-8");
         System.out.println("�û���:"+username);
         System.out.println("����:"+password);
	}

}
