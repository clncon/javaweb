package cn.itcast.java.test;

import cn.itcast.java.dao.dao3.topicDao;
import cn.itcast.java.dao.dao3.typeDao;
import cn.itcast.java.domain.Topic;
import cn.itcast.java.domain.Type;

public class testDao3 {

	
	public static void main(String[] args) throws Exception {
		 typeDao typedao = new typeDao(); 
		 topicDao topicdao = new topicDao(); 
		 Type type = typedao.findTById(1);
		Topic topic = topicdao.findTById(2);
	    System.out.println(type.getId()+":"+type.getTitle());
	   System.out.println(topic.getId()+":"+topic.getTitle());
		

	}

}
