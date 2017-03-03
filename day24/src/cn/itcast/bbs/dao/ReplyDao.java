package cn.itcast.bbs.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bbs.domain.Reply;
import cn.itcast.bbs.utils.jdbcUtils;

public class ReplyDao {
	
	
	   //添加一条回复在指定的主题下
	   public void addReplyByTopic_IdAndReply(int topic_id,Reply reply) throws SQLException{
		    QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		    String sql = "insert into reply(title,name,content,topic_id)values(?,?,?,?)";
		    runner.update(sql, new Object[]{reply.getTitle(),reply.getName(),reply.getContent(),topic_id});
	   }
	  //查找指定的主题下所有的回复
	 public List<Reply> findAllReplyByTopic_Id(int topic_id) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select * from reply where topic_id=? order by time desc";
		  List<Reply> listReply = runner.query(sql, topic_id, new BeanListHandler<Reply>(Reply.class));
		  return listReply;
	 }
	 //根据topic_id查询回复的个数
	public int findReplyCountByTopic_id(int topic_id) throws Exception{
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select count(*) from reply where topic_id=?";
		Object[] arry = runner.query(sql, topic_id, new ArrayHandler());
		Long temp = (Long) arry[0];
		int count = temp.intValue();
		return count;
		
	}

}
