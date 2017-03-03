package cn.itcast.bbs.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bbs.domain.Type;
import cn.itcast.bbs.utils.jdbcUtils;

public class TypeDao {
	    //����ָ����id��ѯ��Ӧ�İ��
	   public Type findTypeById(int id) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "select * from type where id=?";
		   Type type = runner.query(sql, id, new BeanHandler<Type>(Type.class));
		    return type;
	   }
	   //��ѯ���еİ��
        public List<Type> findAllByType() throws SQLException{
        	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
        	String sql = "select * from type";
        	List<Type> listAllType = runner.query(sql, new BeanListHandler<Type>(Type.class));
        	return listAllType;
        }
        //���ݰ�������µ������
          public void updateClickByType(int type_id) throws SQLException{
        	   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
        	   String sql = "update type set click=click+1 where id=?";
        	   runner.update(sql, type_id);
          }
}
