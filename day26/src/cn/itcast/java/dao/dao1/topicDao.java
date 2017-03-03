package cn.itcast.java.dao.dao1;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.java.domain.Topic;
import cn.itcast.java.utils.jdbcUtils;

public class topicDao {
    public Topic findTopicById(int id) throws Exception{
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	String sql = "select * from topic where id = ?";
    	Topic topic = runner.query(sql, id, new BeanHandler<Topic>(Topic.class));
    	return topic;
    }
}
