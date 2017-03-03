package cn.itacst.web.servlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itacst.web.servlet.domain.Up;
import cn.itacst.web.servlet.domain.User;
import cn.itacst.web.servlet.exception.FileSizeException;
import cn.itacst.web.servlet.exception.NoUpFileException;
import cn.itacst.web.servlet.exception.UpFileTypeException;

public final class uploadUtil {
      //获得上传文件的临时目录和真实目录
	   public static String tempPath = "/WEB-INF/temp";
	   public static String uploadPath = "/WEB-INF/upload";
	   private static List<FileItem> list ;
	   //取得真实的文件名
	   public static String getRealName(String fileName){
		   int index = fileName.lastIndexOf("\\");
 		  if(index>0)
 		  {
 			  fileName = fileName.substring(index+1);

     		   
 		  }
		   return fileName;
	   }
	    //文件复制
	   public static void doSave(InputStream is,String uuidFilePath,String uuidFileName){
		   OutputStream os = null;
		   try {
			   os = new FileOutputStream(new File(uuidFilePath+"/"+uuidFileName));
			   byte[] buff = new byte[1024];
			   int length=0;
			   while((length=is.read(buff))>0){
				   os.write(buff, 0, length);
			   }
		   } catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }

		   try {
			   if(is!=null){
				   is.close();
			   }
		   } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		   try {
			   if(os!=null)
			   {
				   os.close();
			   }
		   } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }

	   }
	    //文件上传
	   public static User doupload(HttpServletRequest request,List<Up> list) throws ServletException, FileUploadException, IOException, NoUpFileException, FileSizeException, UpFileTypeException{
		   User user  = new User();
		   DiskFileItemFactory factory = new DiskFileItemFactory();
		   //设置缓冲区最大的缓冲大小为100KB
		   factory.setSizeThreshold(100*1024);
		   String temp = request.getServletContext().getRealPath(uploadUtil.tempPath);
		   factory.setRepository(new File(temp));
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
			
				   List<FileItem> fileItems = sfu.parseRequest(request);
				   //循环判断是普通字段还是上传字段
				   for(FileItem fileItem:fileItems){
					   if(fileItem.isFormField()){
						   //是普通字段
						   String fileValue = fileItem.getString("UTF-8");
						   user.setUsername(fileValue);
					   }
					   else
					   {     //如果没有文件上传
						    if(fileItem.getSize()==0){
						    	throw new NoUpFileException();
						    }
						    //如果上传文件的大小大于200kb
						    if(fileItem.getSize()>200*1024){
						    	throw new FileSizeException();
						    	
						    }
						     //如果上传文件不是以.jpg结尾的话
						     if(!fileItem.getName().endsWith(".jpg")){
						    	 throw new UpFileTypeException();
						    	 
						     }
						     String fileRealName= uploadUtil.getRealName(fileItem.getName());
						   user.getFileItems().add(fileItem);
						   Up up = new Up();
						   up.setFileRealName(uploadUtil.getRealName(fileRealName));
						   up.setUuidFileName(uploadUtil.makeUuidFileName(fileRealName));
						   up.setUsername(user.getUsername());
						   list.add(up);
						      
					   }
				   }
				   
			   }
	   
		   return user;
	   }

      public static void doSave(User user,String uploadpath,List<Up> listup) throws Exception{
    	   //取得用户上传的文件
    	   List<FileItem> list = user.getFileItems();
    	    int index = 0;
    	   for(FileItem fileItem:list){
    		 
    		   //取得文件输入流
    		   InputStream is = fileItem.getInputStream();
    		   //获得文件真实名
    		    String fileRealName = fileItem.getName();
    		    fileRealName = uploadUtil.getRealName(fileRealName);
    		    //获得uuid的名字
    		    String uuidFileName = listup.get(index).getUuidFileName();
    		    //获得文件真实路径
    		     String uuidFilePath = uploadUtil.makeUuidFilePath(uploadpath, uuidFileName);
    		   uploadUtil.doSave(is, uuidFilePath, uuidFileName);
    		   fileItem.delete();
    		   index++;
    	   }
    	   
    	  
      }
	    //生成随机前缀的文件名的
	  public static String makeUuidFileName(String uuidfileName){
			String uuidFileName=null;
			 String uuid = UUID.randomUUID().toString();
			 uuidFileName= uuid+"_"+uuidfileName;
			return uuidFileName;
			
			
		}
	    //生成随机的目录
	 public static String makeUuidFilePath(String uploadPath,String uuidFileName){
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
