package cn.itcast.web.ajax.dao;

import cn.itcast.web.ajax.domain.Image;

public class ImageDao {
   public Image findImageById(int id){
	   Image image = new Image();
	   image.setId(id);
	   if(id==1){
		   image.setName("����");
		   image.setAuthor("ѧ��");
		   
	   }else if(id==2){
		   image.setName("��Ȩ");
		   image.setAuthor("����");
	   }
	    
	   return image;
	   
   }
}
