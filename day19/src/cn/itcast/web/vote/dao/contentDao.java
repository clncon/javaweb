package cn.itcast.web.vote.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.web.vote.entity.Content;
import cn.itcast.web.vote.utils.jdbcUtils;

public class contentDao {
	//����id�Ų���ĳλ��ѡ�˵���ϸ��Ϣ
   public Content findContentById(int id) throws SQLException{
	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	   String sql = "select * from content where id=?";
	   Content content = runner.query(sql, id,new BeanHandler<Content>(Content.class));
	   return content;
   }
}
