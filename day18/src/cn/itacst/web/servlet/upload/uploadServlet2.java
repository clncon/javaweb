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
		    
        
		  //�����ַ�ʽ��ʹ�ñ���д�õ�jar��
		//�����ϴ�����Ĺ�������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//���û��������Ļ����СΪ100KB
	      factory.setSizeThreshold(100*1024);
		//ȡ����ʱ���Ŀ¼��·��
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		//ȡ���ϴ��ļ�·��
		   String uploadPath = this.getServletContext().getRealPath("WEB-INF/upload");
		 //������ʱ��ŵ�Ŀ¼
		factory.setRepository(new File(tempPath));
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
			  try {
				List<FileItem> fileItems = sfu.parseRequest(request);
				//ѭ���ж�����ͨ�ֶλ����ϴ��ֶ�
	          for(FileItem fileItem:fileItems){
	        	   if(fileItem.isFormField()){
	        		   //����ͨ�ֶ�
	        		   String fileName = fileItem.getFieldName();
	        		   String fileValue = fileItem.getString("UTF-8");
	        		   System.out.println(fileName+":"+fileValue);
	        		   
	        		   
	        	   }
	        	   else
	        	   {
	        		   //���ϴ��ֶ�
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
	        		   //ȡ���ļ�������
	        		   InputStream is= fileItem.getInputStream();
	        		   
	        		    //���ļ����뵽uploadĿ¼��
	        		    
	        		    //ʹ��һ����UUIDǰ׺���ļ���
	        		    fileName= makeUuidFileName(fileName);
	        		    //����һ�����������Ŀ¼
	        		     String uuidFilePath = makeUuidFilePath(uploadPath,fileName);
	        		    //����һ�������
	        		    OutputStream os = new FileOutputStream(new File(uuidFilePath+"/"+fileName));
	        		    byte[] buff = new byte[1024];
	        		    int length=0;
	        		    while((length=is.read(buff))>0){
	        		    	os.write(buff, 0, length);
	        		    }
	        		    is.close();
	        		    os.close();
	        		    fileItem.delete();
	        		    request.setAttribute("MESSAGE", "�ϴ��ɹ�");
	    				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	        		    
	        		  
	        		   
	        	   }
	        	  
	          }
			} catch (Exception e) {
				
				e.printStackTrace();
				request.setAttribute("MESSAGE", "�ϴ�ʧ����");
				request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
			}
			
			  
			  //��һ�ַ�ʽ�ϴ��ļ����е��������֧��·������
			    /* String username =  request.getParameter("username");
			     String upfile = request.getParameter("upfile"); 
			       System.out.println("username:"+username);
			       System.out.println("upfile:"+upfile);
		*/
			//�ڶ��ַ�ʽ�ϴ��ļ�����ȡ��ת���ַ����鷳
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
