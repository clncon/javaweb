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
		 * 第一个参数：要连接的主机名称，
		 * 第二个参数:要连接的主机端口
		 * */
		Socket socket =  new Socket("127.0.0.1",25);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		//构造一个读取行数据的流
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine());
		//确定登录服务器的用户
		os.write("ehlo km\r\n".getBytes());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		//授权登录服务器
		os.write("auth login\r\n".getBytes());
		System.out.println(br.readLine());
		//用户名
		os.write("YWFhQGttLmNvbQ==\r\n".getBytes());
		System.out.println(br.readLine());
		//密码
		os.write("MTIzNDU2\r\n".getBytes());
		System.out.println(br.readLine());
		//确定发送邮件的用户
		os.write("mail from:<aaa@km.com>\r\n".getBytes());
		System.out.println(br.readLine());
		//确定接收邮件的用户
		os.write("rcpt to:<bbb@qq.com>\r\n".getBytes());
		System.out.println(br.readLine());
		//表示邮件中的内容
		os.write("data\r\n".getBytes());
		System.out.println(br.readLine());
		//在邮件中显示发送方
		os.write("from:aaa@km.com\r\n".getBytes());
		//System.out.println(br.readLine());
		//在邮件中显示接收方
		os.write("to:bbb@qq.com\r\n".getBytes());
		//System.out.println(br.readLine());
		//显示主题
		os.write("subject:test\r\n".getBytes());
		//System.out.println(br.readLine());
		//编辑邮件内容
		os.write("hello! bbbdsadasdasasd\r\n".getBytes());
		//System.out.println(br.readLine());
		//表示结束编写邮件内容
		os.write(".\r\n".getBytes());
		//System.out.println(br.readLine());
		//退出邮件服务器
		os.write("quit\r\n".getBytes());
		//关闭流
		is.close();
	    os.close();	
		
		

	}

}
