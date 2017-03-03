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
	//缓冲区
	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
    public MyResponse(HttpServletResponse response){
	  super(response);
	  this.response=response;
     }
      //取得这个缓冲流
    public MyServletOutPutStream getOutputStream(){
    	return new MyServletOutPutStream(bout);
    }
    //获取printWrite这个缓冲流
    public PrintWriter getWriter(){
    	try {
			 pw = new PrintWriter(new OutputStreamWriter(bout,"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return pw;
    }
    //将缓冲流的数据以字节形式输出
    public byte[] getBuff(){
    	//注意这里要把pw中的所有的数据全部刷新出去，不然可能会使数据显示不了
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
		 //将数据写入缓冲流中
		try {
			bout.write(buff);
			bout.flush();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	};
}
 
