package cn.itcast.web.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.web.utils.jdbcUtils;

public class sysDao {
  
    public void createSystemInitTable(String tablename) throws SQLException{
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	String sql = "create table "+tablename+"(id varchar(40) primary key," +
    			"curr_time timestamp not null)";
                	runner.update(sql);
              
    }
    public void initSystemInitTable(String tablename,String uuid) throws SQLException{
    QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
      String  sql = "insert into "+tablename+"(id)values(?)";
      runner.update(sql, uuid);
    }
    public void dropSystemInitTable(String tablename) throws SQLException{
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	String sql = "drop table "+tablename;
    	runner.update(sql);
    }
}
