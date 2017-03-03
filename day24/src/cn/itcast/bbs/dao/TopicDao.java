package cn.itcast.bbs.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.Type;
import cn.itcast.bbs.utils.jdbcUtils;

public class TopicDao {
	   //更新主题通过id
	   public void updateTopicById(int id,Topic topic) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "update topic set title=?,content=? where id=?";
		   //System.out.println(new Date(System.currentTimeMillis()));
		   runner.update(sql, new Object[]{topic.getTitle(),topic.getContent(),id});
	   }
	   //在指定的主题下添加一个主题
	    public void addTopicByType_Id(Topic topic,int type_id) throws SQLException{
	    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	    	String sql = "insert into topic(title,name,content,type_id)values(?,?,?,?)";
	    	 // System.out.println(new Date(System.currentTimeMillis()));
	    	runner.update(sql, new Object[]{topic.getTitle(),topic.getName(),topic.getContent(),type_id});
	    }
	   //根据板块和日期查询最新的主题
	   public Topic findTopicByTypeAndNewDate(int type_id) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "select * from topic where type_id=? order by time desc";
		   Topic topic = runner.query(sql, type_id, new BeanHandler<Topic>(Topic.class));
		   return topic;
	   }
	  //根据板块取得主题数
	  public int findTopicNumByType(int type_id) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select count(*) from topic where type_id=?";
		  Object[] objs = runner.query(sql, type_id, new ArrayHandler());
		  Long temp = (Long) objs[0];
		  int topicNum = temp.intValue();
		  return topicNum;
	  }
	 //根据id查找主题
	 public Topic findTopicByid(int id) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		 String sql = "select * from topic where id=?";
		 Topic topic = runner.query(sql, id,new BeanHandler<Topic>(Topic.class));
		 return topic;
	 }
	 //根据指定的Type_id来查找topic
	   public List<Topic> findTopicByType(int typeid) throws SQLException{
		  QueryRunner  runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select * from topic where type_id=? order by time desc";
		 List<Topic> listTopic = 
				 runner.query(sql, typeid, new BeanListHandler<Topic>(Topic.class));
		 return listTopic;
		   
	   }

}
