package cn.itcast.web.vote.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.web.vote.entity.Vote;
import cn.itcast.web.vote.utils.jdbcUtils;

public class voteDao {
    //���ս���ķ�ʽ��������������Ϣ
	
	  public List<Vote> findAllVoteByDesc() throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select * from vote order by ticket desc";
		  List<Vote> listVoteDesc=
				  runner.
				  query(sql,new BeanListHandler<Vote>(Vote.class));
		  return listVoteDesc;
	  }
	 //�������еĲ�ѡ�������Ϣ
	
	 public List<Vote> findAllVote() throws SQLException{
		  
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql="select * from vote";
		  List<Vote> listVote= 
				  runner.query
				  (sql, new BeanListHandler<Vote>(Vote.class));
		  return listVote;
	 }
	 //����id�Ų���ĳλ�ض���Vote����Ϣ
	 public Vote findVoteById(int id) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());;
		 String sql = "select * from vote where id=?";
		 Vote vote = runner.query(sql, id,new BeanHandler<Vote>(Vote.class));
		 return vote;
	 }
	 //����id��������vote���Ʊ��
	  public void updateVoteById(int id) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "update vote set ticket=ticket+1 where id = ?";
		  runner.update(sql,id);
	  }
}
