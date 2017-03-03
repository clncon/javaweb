package cn.itcast.web.ajax.dao;

import cn.itcast.web.ajax.domain.Image;

public class ImageDao {
   public Image findImageById(int id){
	   Image image = new Image();
	   image.setId(id);
	   if(id==1){
		   image.setName("刘备");
		   image.setAuthor("学神");
		   
	   }else if(id==2){
		   image.setName("孙权");
		   image.setAuthor("哈哈");
	   }
	    
	   return image;
	   
   }
}
