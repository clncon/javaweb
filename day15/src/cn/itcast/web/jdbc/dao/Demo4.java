package cn.itcast.web.jdbc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itcast.web.jdbc.domain.User;
import cn.itcast.web.jdbc.util.jdbcUtils;

public class Demo4 {
	//演示ResultSetHandler借口的各个实现类
	
	@Test
	public void testBeanHandler() throws Exception{
		String sql = "select * from user where id = ?";
		QueryRunner query = new QueryRunner(jdbcUtils.getCds());
		User user = (User)query.query(sql, new Object[]{2}, new BeanHandler<User>(User.class));
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		System.out.println(user.getSalary());
		
	}
	@Test
	public void testBeanListHandler() throws Exception{
		String sql = "select * from user";
		QueryRunner query = new QueryRunner(jdbcUtils.getCds());
		List<User> userlist = (List<User>)query.query(sql, new BeanListHandler(User.class));
		for(User user : userlist) {
			System.out.println(user.getId());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println(user.getBirthday());
			System.out.println(user.getSalary());
	}
	
	
	}
	@Test
	public void testArrayHandler() throws Exception{
		String sql = "select * from user where id = ?";
		QueryRunner query = new QueryRunner(jdbcUtils.getCds());
		Object[] userArry = (Object[])query.query(sql,new Object[]{2},new ArrayHandler());
		for(int i=0;i<userArry.length;i++){
	     	System.out.println(userArry[i]);
		}
	}
    @Test
    public void testArrayListHandler() throws Exception{
    	String sql = "select * from user";
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	List<Object[]> userArrayList = runner.query(sql, new ArrayListHandler());
    	for(Object[] userarry:userArrayList){
    	     System.out.println("编号："+userarry[0]);
    	     System.out.println("用户名："+userarry[1]);
    	     
    	}
    }
    @Test
    public void testMapHandler() throws Exception{
    	String sql = "select * from user";
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	Map<String, Object> map = runner.query(sql,new MapHandler());
		System.out.println("用户名:" + map.get("username"));

         /*for(Map.Entry<String, Object> entry:userMap.entrySet()){
        	 System.out.println(entry.getKey()+":"+entry.getValue());
         }  */	   
    }
    @Test
    public void testMapListHandler() throws Exception{
    	String sql = "select * from user";
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
    	List<Map<String, Object>> userMapList = runner.query(sql, new MapListHandler());
    	for(Map<String,Object> map :userMapList){
    		for(Map.Entry<String,Object> entry:map.entrySet()){
    			System.out.println(entry.getKey()+":"+entry.getValue());
    		}
    	}
    }
    @Test
    public void testScalarHandler() throws Exception{
    	QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select count(*) from user";
		Long sum = (Long) runner.query(sql,new ScalarHandler());
		System.out.println("共有" + sum + "人");
    }
}
