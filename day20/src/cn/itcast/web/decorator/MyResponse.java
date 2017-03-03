package cn.itcast.web.decorator;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper{
	private HttpServletResponse response;
	PrintWriter pw;
	//������
	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
    public MyResponse(HttpServletResponse response){
	  super(response);
	  this.response=response;
     }
      //ȡ�����������
    public MyServletOutPutStream getOutputStream(){
    	return new MyServletOutPutStream(bout);
    }
    //��ȡprintWrite���������
    public PrintWriter getWriter(){
    	try {
			 pw = new PrintWriter(new OutputStreamWriter(bout,"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return pw;
    }
    //�����������������ֽ���ʽ���
    public byte[] getBuff(){
    	//ע������Ҫ��pw�е����е�����ȫ��ˢ�³�ȥ����Ȼ���ܻ�ʹ������ʾ����
    	if(pw!=null){
    		pw.flush();
    	}
    	return bout.toByteArray();
    }
}
 class MyServletOutPutStream extends ServletOutputStream{
	private ByteArrayOutputStream bout;
	public MyServletOutPutStream(ByteArrayOutputStream bout){
		this.bout=bout;
	}
	public void write(int i ){};
	public void write(byte[] buff){
		 //������д�뻺������
		try {
			bout.write(buff);
			bout.flush();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	};
}
 
