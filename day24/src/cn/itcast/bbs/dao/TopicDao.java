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
	   //��������ͨ��id
	   public void updateTopicById(int id,Topic topic) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "update topic set title=?,content=? where id=?";
		   //System.out.println(new Date(System.currentTimeMillis()));
		   runner.update(sql, new Object[]{topic.getTitle(),topic.getContent(),id});
	   }
	   //��ָ�������������һ������
	    public void addTopicByType_Id(Topic topic,int type_id) throws SQLException{
	    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	    	String sql = "insert into topic(title,name,content,type_id)values(?,?,?,?)";
	    	 // System.out.println(new Date(System.currentTimeMillis()));
	    	runner.update(sql, new Object[]{topic.getTitle(),topic.getName(),topic.getContent(),type_id});
	    }
	   //���ݰ������ڲ�ѯ���µ�����
	   public Topic findTopicByTypeAndNewDate(int type_id) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "select * from topic where type_id=? order by time desc";
		   Topic topic = runner.query(sql, type_id, new BeanHandler<Topic>(Topic.class));
		   return topic;
	   }
	  //���ݰ��ȡ��������
	  public int findTopicNumByType(int type_id) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select count(*) from topic where type_id=?";
		  Object[] objs = runner.query(sql, type_id, new ArrayHandler());
		  Long temp = (Long) objs[0];
		  int topicNum = temp.intValue();
		  return topicNum;
	  }
	 //����id��������
	 public Topic findTopicByid(int id) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		 String sql = "select * from topic where id=?";
		 Topic topic = runner.query(sql, id,new BeanHandler<Topic>(Topic.class));
		 return topic;
	 }
	 //����ָ����Type_id������topic
	   public List<Topic> findTopicByType(int typeid) throws SQLException{
		  QueryRunner  runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select * from topic where type_id=? order by time desc";
		 List<Topic> listTopic = 
				 runner.query(sql, typeid, new BeanListHandler<Topic>(Topic.class));
		 return listTopic;
		   
	   }

}
