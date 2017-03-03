package cn.itacst.web.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itacst.web.servlet.domain.Up;
import cn.itacst.web.servlet.util.jdbcUtils;

public class upDao {
	  //增加一个up对象
	  public void addUp(Up up) throws Exception{
		  QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
		  String sql = "insert into Up(username,uuidFileName,fileRealName) value(?,?,?)";
		  qr.update(jdbcUtils.getMySqlConnection(),sql,new Object[]{up.getUsername(),up.getUuidFileName(),up.getFileRealName()});
	  }
       
      public List<Up> findAllFile() throws SQLException{
    	   List<Up> listUp = null;
    	  QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
    	  String sql = "select * from up";
    	  listUp = qr.query(sql, new BeanListHandler<Up>(Up.class));
    	  return listUp;
      } 
      //根据指定的uuid名查找唯一的Up对象
      public Up findUUidFileUp(String uuidFileName) throws SQLException{
    	  Up up = null;
    	  QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
    	  String sql = "select * from up where uuidFileName=?";
    	  up = qr.query(sql,uuidFileName,new BeanHandler<Up>(Up.class));
    	  return up;
    	  
      }
}
