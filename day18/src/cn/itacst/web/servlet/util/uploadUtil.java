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
      //����ϴ��ļ�����ʱĿ¼����ʵĿ¼
	   public static String tempPath = "/WEB-INF/temp";
	   public static String uploadPath = "/WEB-INF/upload";
	   private static List<FileItem> list ;
	   //ȡ����ʵ���ļ���
	   public static String getRealName(String fileName){
		   int index = fileName.lastIndexOf("\\");
 		  if(index>0)
 		  {
 			  fileName = fileName.substring(index+1);

     		   
 		  }
		   return fileName;
	   }
	    //�ļ�����
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
	    //�ļ��ϴ�
	   public static User doupload(HttpServletRequest request,List<Up> list) throws ServletException, FileUploadException, IOException, NoUpFileException, FileSizeException, UpFileTypeException{
		   User user  = new User();
		   DiskFileItemFactory factory = new DiskFileItemFactory();
		   //���û��������Ļ����СΪ100KB
		   factory.setSizeThreshold(100*1024);
		   String temp = request.getServletContext().getRealPath(uploadUtil.tempPath);
		   factory.setRepository(new File(temp));
		   //ȡ���ϴ����󣨺��ģ�
		   ServletFileUpload sfu = new ServletFileUpload(factory);
		   //�����ϴ������ļ��ı���
		   sfu.setHeaderEncoding("UTF-8");
		   //�жϿͻ����ļ��Ƿ�����MIMEЭ�鷽ʽ�ϴ�
		   boolean flag = ServletFileUpload.isMultipartContent(request);
		   if(!flag){
			   //����������׳��쳣  
			   throw new ServletException();
		   }
		   else 

		   {
			   //�������MIME��ʽ����
			   //ȡ��FileItem��������װ�ͻ��˷�����������Ϣ
			   //FileItem��������̬����ͨ�ֶκ��ϴ��ֶ�
			
				   List<FileItem> fileItems = sfu.parseRequest(request);
				   //ѭ���ж�����ͨ�ֶλ����ϴ��ֶ�
				   for(FileItem fileItem:fileItems){
					   if(fileItem.isFormField()){
						   //����ͨ�ֶ�
						   String fileValue = fileItem.getString("UTF-8");
						   user.setUsername(fileValue);
					   }
					   else
					   {     //���û���ļ��ϴ�
						    if(fileItem.getSize()==0){
						    	throw new NoUpFileException();
						    }
						    //����ϴ��ļ��Ĵ�С����200kb
						    if(fileItem.getSize()>200*1024){
						    	throw new FileSizeException();
						    	
						    }
						     //����ϴ��ļ�������.jpg��β�Ļ�
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
    	   //ȡ���û��ϴ����ļ�
    	   List<FileItem> list = user.getFileItems();
    	    int index = 0;
    	   for(FileItem fileItem:list){
    		 
    		   //ȡ���ļ�������
    		   InputStream is = fileItem.getInputStream();
    		   //����ļ���ʵ��
    		    String fileRealName = fileItem.getName();
    		    fileRealName = uploadUtil.getRealName(fileRealName);
    		    //���uuid������
    		    String uuidFileName = listup.get(index).getUuidFileName();
    		    //����ļ���ʵ·��
    		     String uuidFilePath = uploadUtil.makeUuidFilePath(uploadpath, uuidFileName);
    		   uploadUtil.doSave(is, uuidFilePath, uuidFileName);
    		   fileItem.delete();
    		   index++;
    	   }
    	   
    	  
      }
	    //�������ǰ׺���ļ�����
	  public static String makeUuidFileName(String uuidfileName){
			String uuidFileName=null;
			 String uuid = UUID.randomUUID().toString();
			 uuidFileName= uuid+"_"+uuidfileName;
			return uuidFileName;
			
			
		}
	    //���������Ŀ¼
	 public static String makeUuidFilePath(String uploadPath,String uuidFileName){
			  //����������ɵ�Ŀ��Ŀ¼������
			  String uuidFilePath=null;
			  //����һ�������
			   int random = uuidFileName.hashCode();
			   //ȷ����һ������Ŀ¼
			   int dir1 = random & 0xF;
			   //ȷ���ڶ�������Ŀ¼
			   int dir2 = dir1>>4 & 0xF;
			   File filePath = new File(uploadPath+"/"+dir1 + "/"+dir2);
			   if(!filePath.exists()){
				   filePath.mkdirs();
				   
			   }
			   uuidFilePath = filePath.getPath();
			  return uuidFilePath;
			
		}
}
