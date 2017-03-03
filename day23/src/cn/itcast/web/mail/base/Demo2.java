package cn.itcast.web.mail.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Demo2 {

	
	public static void main(String[] args) throws Exception, IOException {
		/*
		 * ��һ��������Ҫ���ӵ��������ƣ�
		 * �ڶ�������:Ҫ���ӵ������˿�
		 * */
		Socket socket =  new Socket("127.0.0.1",25);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//����һ����ȡ�����ݵ���
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine());
		//ȷ����¼���������û�
		os.write("ehlo km\r\n".getBytes());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		//��Ȩ��¼������
		os.write("auth login\r\n".getBytes());
		System.out.println(br.readLine());
		//�û���
		os.write("YWFhQGttLmNvbQ==\r\n".getBytes());
		System.out.println(br.readLine());
		//����
		os.write("MTIzNDU2\r\n".getBytes());
		System.out.println(br.readLine());
		//ȷ�������ʼ����û�
		os.write("mail from:<aaa@km.com>\r\n".getBytes());
		System.out.println(br.readLine());
		//ȷ�������ʼ����û�
		os.write("rcpt to:<bbb@qq.com>\r\n".getBytes());
		System.out.println(br.readLine());
		//��ʾ�ʼ��е�����
		os.write("data\r\n".getBytes());
		System.out.println(br.readLine());
		//���ʼ�����ʾ���ͷ�
		os.write("from:aaa@km.com\r\n".getBytes());
		//System.out.println(br.readLine());
		//���ʼ�����ʾ���շ�
		os.write("to:bbb@qq.com\r\n".getBytes());
		//System.out.println(br.readLine());
		//��ʾ����
		os.write("subject:test\r\n".getBytes());
		//System.out.println(br.readLine());
		//�༭�ʼ�����
		os.write("hello! bbbdsadasdasasd\r\n".getBytes());
		//System.out.println(br.readLine());
		//��ʾ������д�ʼ�����
		os.write(".\r\n".getBytes());
		//System.out.println(br.readLine());
		//�˳��ʼ�������
		os.write("quit\r\n".getBytes());
		//�ر���
		is.close();
	    os.close();	
		
		

	}

}
