package cn.itcast.bbs.test;

import java.util.List;

import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.service.BbsService;

public class testTopic_2 {
   public static void main(String[] args) throws Exception {
	    BbsService bbsservice = new BbsService();
	    List<Topic> listtopic = bbsservice.findTopicBytype(1);
	    for(Topic topic:listtopic){
	    	System.out.println(topic.getType().getTitle()+":"+topic.getType().getId());
	    }
	    
}
}
