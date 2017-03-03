package cn.itcast.java.phone2web;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class phone {

	
	public static void main(String[] args) throws Exception {
		//创建与服务端的连接
		URL url = new URL("http://localhost:8080/day26/Server");
		//取得与服务端的连接
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.setDoOutput(true);
		  //向服务端发送请求
		 OutputStream os =  uc.getOutputStream();
		 PrintWriter pw = new PrintWriter(os);
		 String username = "杰克";
		 username = URLEncoder.encode(username, "UTF-8");
		 pw.write("username="+username+"&password=123456");
		 pw.flush();
		 os.close();
		 pw.close();
		int code = uc.getResponseCode();
		System.out.println(code);
		 /*取得服务端的响应
		//取得服务端的输入流
		InputStream is = uc.getInputStream();
		 byte[] buf = new byte[1024];
		 int len=0;
		 while((len=is.read(buf))>0){
		 //输出服务端的数据
			 System.out.println(new String(buf));
		 }*/

	}

}
