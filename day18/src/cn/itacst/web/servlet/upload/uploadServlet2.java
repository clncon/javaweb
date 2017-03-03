package cn.itacst.web.servlet.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class uploadServlet2 extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String method = request.getParameter("method");
         if(method!=null){
         	if("upload".equals(method)){
         		
         		this.upload(request, response);
         	}
         	
         }
		
	}
    
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/upload.jsp").forward(request, response);
	}




	protected void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
        
		  //第三种方式，使用别人写好的jar包
		//产生上传对象的工厂对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置缓冲区最大的缓冲大小为100KB
	      factory.setSizeThreshold(100*1024);
		//取得临时存放目录的路径
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		//取得上传文件路径
		   String uploadPath = this.getServletContext().getRealPath("WEB-INF/upload");
		 //设置临时存放的目录
		factory.setRepository(new File(tempPath));
		//取得上传对象（核心）
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//设置上传对象文件的编码
		 sfu.setHeaderEncoding("UTF-8");
		//判断客户端文件是否是以MIME协议方式上传
		  boolean flag = ServletFileUpload.isMultipartContent(request);
		  if(!flag){
			  //如果不是则抛出异常  
			  throw new ServletException();
		  }
		  else 
			 
		  {
			//如果是以MIME方式传输
			 //取得FileItem对象，他封装客户端发来的所有信息
			 //FileItem有两种形态即普通字段和上传字段
			  try {
				List<FileItem> fileItems = sfu.parseRequest(request);
				//循环判断是普通字段还是上传字段
	          for(FileItem fileItem:fileItems){
	        	   if(fileItem.isFormField()){
	        		   //是普通字段
	        		   String fileName = fileItem.getFieldName();
	        		   String fileValue = fileItem.getString("UTF-8");
	        		   System.out.println(fileName+":"+fileValue);
	        		   
	        		   
	        	   }
	        	   else
	        	   {
	        		   //是上传字段
	        		   String fileName = fileItem.getName();
	        		   
		        		  int index = fileName.lastIndexOf("\\");
		        		  if(index>0)
		        		  {
		        			  fileName = fileName.substring(index+1);
		        			  System.out.println(fileName);
			        		   
		        		  }else
		        		  {
		        			  System.out.println(fileName);
		        		  }
	        		   //取得文件输入流
	        		   InputStream is= fileItem.getInputStream();
	        		   
	        		    //将文件输入到upload目录下
	        		    
	        		    //使用一个有UUID前缀的文件名
	        		    fileName= makeUuidFileName(fileName);
	        		    //创建一个随机产生的目录
	        		     String uuidFilePath = makeUuidFilePath(uploadPath,fileName);
	        		    //创建一个输出流
	        		    OutputStream os = new FileOutputStream(new File(uuidFilePath+"/"+fileName));
	        		    byte[] buff = new byte[1024];
	        		    int length=0;
	        		    while((length=is.read(buff))>0){
	        		    	os.write(buff, 0, length);
	        		    }
	        		    is.close();
	        		    os.close();
	        		    fileItem.delete();
	        		    request.setAttribute("MESSAGE", "上传成功");
	    				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	        		    
	        		  
	        		   
	        	   }
	        	  
	          }
			} catch (Exception e) {
				
				e.printStackTrace();
				request.setAttribute("MESSAGE", "上传失败了");
				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
			}
			
			  
			  //第一种方式上传文件，有的浏览器不支持路径传输
			    /* String username =  request.getParameter("username");
			     String upfile = request.getParameter("upfile"); 
			       System.out.println("username:"+username);
			       System.out.println("upfile:"+upfile);
		*/
			//第二种方式上传文件，截取和转换字符很麻烦
			   /*InputStream is = request.getInputStream();
			   OutputStream os = response.getOutputStream();
			   byte[] buff = new byte[1024];
			   int length=0;
			   if((length=is.read(buff))>0){
				    os.write(buff, 0, length);
				   
			   }
			   is.close();
			   os.close(); 
			   */
		  }
		    
		  } 
	
	private String makeUuidFileName(String uuidfileName){
		String uuidFileName=null;
		 String uuid = UUID.randomUUID().toString();
		 uuidFileName= uuid+"_"+uuidfileName;
		return uuidFileName;
		
		
	}
	private String makeUuidFilePath(String uploadPath,String uuidFileName){
		  //定义随机生成的目标目录的名称
		  String uuidFilePath=null;
		  //生成一个随机数
		   int random = uuidFileName.hashCode();
		   //确定第一层的随机目录
		   int dir1 = random & 0xF;
		   //确定第二层的随机目录
		   int dir2 = dir1>>4 & 0xF;
		   File filePath = new File(uploadPath+"/"+dir1 + "/"+dir2);
		   if(!filePath.exists()){
			   filePath.mkdirs();
			   
		   }
		   uuidFilePath = filePath.getPath();
		  return uuidFilePath;
		
	}
}
