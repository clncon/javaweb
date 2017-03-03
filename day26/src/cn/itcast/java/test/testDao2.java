package cn.itcast.java.test;

import cn.itcast.java.dao.dao2.topicDao;
import cn.itcast.java.dao.dao2.typeDao;
import cn.itcast.java.domain.Topic;
import cn.itcast.java.domain.Type;




public class testDao2 {

	
	public static void main(String[] args) throws Exception {
		 typeDao typedao = new typeDao(Type.class,"type"); 
		 topicDao topicdao = new topicDao(Topic.class,"topic"); 
		 Type type = typedao.findTById(2);
		Topic topic = topicdao.findTById(2);
	    System.out.println(type.getId()+":"+type.getTitle());
	   System.out.println(topic.getId()+":"+topic.getTitle());
		

	}

}
