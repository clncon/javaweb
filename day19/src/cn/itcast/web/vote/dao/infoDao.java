package cn.itcast.web.vote.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.web.vote.entity.Info;
import cn.itcast.web.vote.utils.jdbcUtils;

public class infoDao {
	//查询所有的投票人信息
	 public List<Info> findInfoAll() throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		 String sql = "select ip,max(votetime) as votetime from info group by ip";
		 List<Info> listinfo = runner.query(sql, new BeanListHandler<Info>(Info.class));
		 return listinfo;
	 }
	//根据ip查找Info
	  public Info findInfoById(String ip) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select ip,max(votetime) as votetime from info where ip=? group by ip";
		  Info info = runner.query(sql, ip, new BeanHandler<Info>(Info.class));
		  return info;
	  }
	 //向info表中添加一条信息
    public void addInfo(Info info) throws SQLException{
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	String sql = "insert into info(ip)values(?)";
    	runner.update(sql,info.getIp());
    }
}
