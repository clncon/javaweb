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
		//���������˵�����
		URL url = new URL("http://localhost:8080/day26/Server");
		//ȡ�������˵�����
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.setDoOutput(true);
		  //�����˷�������
		 OutputStream os =  uc.getOutputStream();
		 PrintWriter pw = new PrintWriter(os);
		 String username = "�ܿ�";
		 username = URLEncoder.encode(username, "UTF-8");
		 pw.write("username="+username+"&password=123456");
		 pw.flush();
		 os.close();
		 pw.close();
		int code = uc.getResponseCode();
		System.out.println(code);
		 /*ȡ�÷���˵���Ӧ
		//ȡ�÷���˵�������
		InputStream is = uc.getInputStream();
		 byte[] buf = new byte[1024];
		 int len=0;
		 while((len=is.read(buf))>0){
		 //�������˵�����
			 System.out.println(new String(buf));
		 }*/

	}

}
