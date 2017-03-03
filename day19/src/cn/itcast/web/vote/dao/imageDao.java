package cn.itcast.web.vote.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.web.vote.entity.Image;
import cn.itcast.web.vote.utils.jdbcUtils;

public class imageDao {
	//根据id查找对应的Image对象
	  public Image findImageById(int id) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String  sql = "select * from image where cid=?";
		  Image image = runner.query(sql, id, new BeanHandler<Image>(Image.class));
		  return image;
	  }
}
