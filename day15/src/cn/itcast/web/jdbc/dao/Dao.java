package cn.itcast.web.jdbc.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import cn.itcast.web.jdbc.domain.Department;
import cn.itcast.web.jdbc.domain.Employee;
import cn.itcast.web.jdbc.domain.student;
import cn.itcast.web.jdbc.domain.teacher;
import cn.itcast.web.jdbc.util.jdbcUtils;

public class Dao {

	public void save(Department department) throws SQLException {
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		//1.�����ݿ��в���һ��department��¼
		String sql = "insert into department(name) values(?)";
			runner.update(sql, department.getName());
		//2.��ȡ�����¼��id�ţ�������
			String sqlId = "select id from department where name = ?";
            Object[] IdArray = runner.query(sqlId, department.getName(),new ArrayHandler());
            int did = (Integer)IdArray[0];
        //3.������ֵ��employee��¼һ��������ݿ�
            String sqle = "insert into employee(name,did) values(?,?)";
            for(Employee e:department.getListEmpoyee()){
            	runner.update(sqle,new Object[]{e.getName(),did});
            }
            
            
            
	}

	public void save(student s) throws SQLException {
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		
		   //1.��student���в���һ����¼
		  String sql = "insert into student(name) values(?)";
		     runner.update(sql,s.getName());
		     
		   //2.��ȡstudent�������
		    String sqlSid = "select id from student where name = ?";
		    Object[] arraySid= runner.query(sqlSid, s.getName(), new ArrayHandler());
		    int sid = (Integer)arraySid[0];
		    
		    //3.��teacher���в��������¼
		     String sql2 = "insert into teacher(name) values(?)";
		     for(teacher t :s.getListTeacher()){
		    	 runner.update(sql2, t.getName());
		    	 //4.ȡ��teacher�������
		    	 String sqlTid = "select id from teacher where name = ?";
		    	 Object[] tidArray = runner.query(sqlTid, t.getName(), new ArrayHandler());
		    	 int tid = (Integer) tidArray[0];
		    	 
		    	 //5.�����ֵ���뵽middle���У�������Ĺ���
		    	 String sql3 = "insert into middle(tid,sid) values(?,?)";
		    	 runner.update(sql3, new Object[]{tid,sid});
		    	  
		     }
	}

}
