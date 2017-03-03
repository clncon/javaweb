package cn.itcast.bbs.test;

import java.util.List;

import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.service.BbsService;

public class testTopic {

	
	public static void main(String[] args) throws Exception {
		 BbsService bbs = new BbsService();
		 List<Topic> listTopic = bbs.findTopicBytype(3);
		 for(Topic topic:listTopic){
			 System.out.println(topic.getTitle()+":"+topic.getName()+":"+topic.getReplyCount());
		 }

	}

}
