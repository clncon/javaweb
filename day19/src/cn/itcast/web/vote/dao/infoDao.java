package cn.itcast.web.vote.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.web.vote.entity.Info;
import cn.itcast.web.vote.utils.jdbcUtils;

public class infoDao {
	//��ѯ���е�ͶƱ����Ϣ
	 public List<Info> findInfoAll() throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		 String sql = "select ip,max(votetime) as votetime from info group by ip";
		 List<Info> listinfo = runner.query(sql, new BeanListHandler<Info>(Info.class));
		 return listinfo;
	 }
	//����ip����Info
	  public Info findInfoById(String ip) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select ip,max(votetime) as votetime from info where ip=? group by ip";
		  Info info = runner.query(sql, ip, new BeanHandler<Info>(Info.class));
		  return info;
	  }
	 //��info�������һ����Ϣ
    public void addInfo(Info info) throws SQLException{
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	String sql = "insert into info(ip)values(?)";
    	runner.update(sql,info.getIp());
    }
}
