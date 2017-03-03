package cn.itcast.web.vote.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.web.vote.entity.Vote;
import cn.itcast.web.vote.utils.jdbcUtils;

public class voteDao {
    //按照降序的方式查找所有人物信息
	
	  public List<Vote> findAllVoteByDesc() throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select * from vote order by ticket desc";
		  List<Vote> listVoteDesc=
				  runner.
				  query(sql,new BeanListHandler<Vote>(Vote.class));
		  return listVoteDesc;
	  }
	 //查找所有的参选人物的信息
	
	 public List<Vote> findAllVote() throws SQLException{
		  
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql="select * from vote";
		  List<Vote> listVote= 
				  runner.query
				  (sql, new BeanListHandler<Vote>(Vote.class));
		  return listVote;
	 }
	 //根据id号查找某位特定的Vote的信息
	 public Vote findVoteById(int id) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());;
		 String sql = "select * from vote where id=?";
		 Vote vote = runner.query(sql, id,new BeanHandler<Vote>(Vote.class));
		 return vote;
	 }
	 //根据id号来更新vote表的票数
	  public void updateVoteById(int id) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "update vote set ticket=ticket+1 where id = ?";
		  runner.update(sql,id);
	  }
}
