package cn.itcast.web.jdbc.dao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.web.jdbc.domain.User;
import cn.itcast.web.jdbc.util.jdbcUtils;

public class Demo2 {

	//ʹ��Ԫ����+�����Ż�CURD����
	public static void main(String[] args) throws Exception {
		//String sql = "insert into user(username,password,birthday,salary)values(?,?,?,?)";
		//String sql = "update user set salary = ? where username = ?";
		//String sql = "delete from user where id = ?";
       // update(sql,new Object[]{1});
		String sql = "select * from user where id =?";
		  
		User user = (User)Query(sql,new Object[]{2},User.class);
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		System.out.println(user.getSalary());
	}
     public static void update(String sql,Object[] obj) throws Exception{
    	 Connection conn = null;
    	 PreparedStatement pstmt = null;
    	//ResultSet rs = null;
    	 
    	 conn = jdbcUtils.getMySqlConnection();
    	 pstmt = conn.prepareStatement(sql);
    	 ParameterMetaData pamd = pstmt.getParameterMetaData();
    	 int size = pamd.getParameterCount(); 
    	 for(int i = 0;i<size;i++){
    		 pstmt.setObject(i+1, obj[i]);
    	 }
    	 pstmt.executeUpdate();
    	 jdbcUtils.close(pstmt);
    	 jdbcUtils.close(conn);
     }
     public static Object Query(String sql, Object[] objects, Class class1) throws Exception{
    	 //���÷��䷽������javaBean����
    	 Object obj = class1.newInstance();
    	 //��ȡ���ݿ�����
    	 Connection conn = jdbcUtils.getMySqlConnection();
    	 PreparedStatement pstmt = conn.prepareStatement(sql);
    	 //��ȡ����Ԫ���ݶ���
    	 ParameterMetaData pamd = pstmt.getParameterMetaData();
    	 int size =pamd.getParameterCount();
    	 for(int i=0;i<size;i++){
    		 //��������ֵ
    		 pstmt.setObject(i+1, objects[i]);
    	 }
    	 ResultSet rs =pstmt.executeQuery();
    	 if(rs.next()){
    		 //ȡ��ResultSetԪ���ݶ���
    		  ResultSetMetaData rsmd = rs.getMetaData();
    		  //��ȡ������ݵ��и���
    		  size = rsmd.getColumnCount();
    		  for(int i=0;i<size;i++){
    			  //��ȡÿһ�е�����
    			 String columnName = rsmd.getColumnName(i+1);
    			 //����BeanUtils��ܴ���Bean������
    			 BeanUtils.setProperty(obj,columnName,rs.getObject(i+1));
    		  }
    		  
    	 }
    	   jdbcUtils.close(rs);
    	   jdbcUtils.close(pstmt);
    	   jdbcUtils.close(conn);
    	 return obj;
     }
}
