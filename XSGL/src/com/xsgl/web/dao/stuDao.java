package com.xsgl.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xsgl.web.domain.Student;
import com.xsgl.web.util.jdbcUtils;

public class stuDao {
	
	   //��ѯ�ж��ٰ༶
	 public int QueryClassNumber() throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
	     String sql = "select count(distinct(myclass)) from student";
	     Object[] array = runner.query(sql, new ArrayHandler());
	     Long temp = (Long) array[0];
	     int classes = temp.intValue();
	     return classes;
	 }
	   //���ݰ༶����ѯѧ������
	  public int QueryStudentCountByClass(String myclass) throws SQLException{
		  QueryRunner runner  = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select count(*) from student where myclass=?";
		  Object[] array = runner.query(sql, myclass, new ArrayHandler());
		   Long temp = (Long) array[0];
		   int students = temp.intValue();
		   return students; 
	  }
	  //���ݿ�Ŀ�Ͱ༶����ѯ������ѧ��������
	  public int QueryStudentCountByFail(String course,String myclass) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql  = "select count(*) from student where "+course+"<60 and myclass=?";
		  Object[] array = runner.query(sql, myclass, new ArrayHandler());
		  Long temp = (Long) array[0];
		  int students = temp.intValue();
		  return students;
		  
	  }
	   //���ݿ�Ŀ�Ͱ༶����ѯ����ѧ��������
	  public int QueryStudentCountByGreat(String course,String myclass) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql  = "select count(*) from student where "+course+">=90 and myclass=?";
		  Object[] array = runner.query(sql, myclass, new ArrayHandler());
		  Long temp = (Long) array[0];
		  int students = temp.intValue();
		  return students; 
	  }
	   //����ѧ�ŵĴ�С������
	   public List<Student> OrderStudentById(String order) throws SQLException{
		    QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		    String sql = "select * from student order by id "+order;
		    List<Student> liststu = runner.query(sql,new BeanListHandler<Student>(Student.class));
		    return liststu;
		    
	   }
	   //����Ӣ��ɼ�������
	   public List<Student> OrderStudentByEnglish(String order) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "select * from student order by english "+order;
		   List<Student> liststu = runner.query(sql, new BeanListHandler<Student>(Student.class));
		   return liststu;
	   }
	    //������ѧ�ɼ�������
	   public List<Student> OrderStudentByMath(String order) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "select * from student order by math "+order;
		   List<Student> liststu = runner.query(sql, new BeanListHandler<Student>(Student.class));
		   return liststu;
	   }
	    //����Ӣ��ɼ�������
	   public List<Student> OrderStudentByChinese(String order) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "select * from student order by chinese "+order;
		   List<Student> liststu = runner.query(sql, new BeanListHandler<Student>(Student.class));
		   return liststu;
	   }
	   //�����ܳɼ�������
	   public List<Student> OrderStudentBySum(String order) throws SQLException{
		   QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		   String sql = "select * from student order by (english+math+chinese)"+order;
		   List<Student> liststu = runner.query(sql, new BeanListHandler<Student>(Student.class));
		   return liststu;
	   }
	  //����ָ����idɾ��һ��ѧ����Ϣ
	  public void DeleteStudentById(int id) throws SQLException{
		  QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
		  String sql = "delete from student where id = ?";
		  qr.update(sql,id);
	  }
     //����id����һ�����ݿ����Ϣ
	  public void UpdateStudentById(Student stu) throws SQLException{
		 QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
		 String sql = "update student set Name=?,Gender=?,myClass=?,English=?,Math=?,Chinese=? where Id=?";
		 qr.update(sql, new Object[]{stu.getName(),stu.getGender(),stu.getMyClass(),stu.getEnglish(),stu.getMath(),stu.getChinese(),stu.getId()});
	  }
	  //����ָ����id����һ�����ݿ���Ϣ
	  public Student findStudentById(int id) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		  String sql = "select * from student where Id=?";
		  Student stu = runner.query(sql,id,new BeanHandler<Student>(Student.class));
		  return stu;
	  }
    //����������������Ϣ����������뵽һ��list�����еķ���
	public List<Student> findAllStudent(int start,int size) throws SQLException{
		List<Student> listStudent = null;
		QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
	    String sql = "select * from student limit ?,?";
	   listStudent = qr.query(sql, new Object[]{start,size},new BeanListHandler<Student>(Student.class));
	   return listStudent;
	}
	//�������ݿ�һ���ж�������¼
	public int findAllRecorder() throws SQLException{
		int allRecorder=0;
		QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
		String sql = "select count(*) from student";
		Object[] array = qr.query(sql, new ArrayHandler());
	     Long temp = (Long)array[0];
		allRecorder = temp.intValue();
		return allRecorder;
	}
	//����һ����¼
	public void addRecorder(Student student) throws SQLException {
		QueryRunner qr = new QueryRunner(jdbcUtils.getCds());
		/*System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getGender());
		System.out.println(student.getMyClass());
		System.out.println(student.getEnglish());
		System.out.println(student.getMath());
		System.out.println(student.getChinese());*/
		String sql = "insert into student(Id,Name,Gender,myClass,English,Math,Chinese) value(?,?,?,?,?,?,?)";
		qr.update(sql, new Object[]{student.getId(),student.getName(),student.getGender(),student.getMyClass(),student.getEnglish(),student.getMath(),student.getChinese()});
	}
	//������������ѧ����Ϣ
	public List<Student> selectStudentByName(String name) throws SQLException{
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select * from student where Name=?";
	     List<Student> liststu = runner.query(sql, name, new BeanListHandler<Student>(Student.class));
	     return liststu;

	}
	//���ݰ༶������ѧ����Ϣ
	public List<Student> selectStudentByClass(String Class) throws SQLException{
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select * from student where myClass=?";
	     List<Student> liststu = runner.query(sql, Class, new BeanListHandler<Student>(Student.class));
	     return liststu;
	}
	//����Ӣ��ɼ�����ѯ
	public List<Student> selectStudentByEnglish(int low_grades,int high_grades) throws SQLException{
		QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		String sql = "select * from student where English >=? and English<=?";
		List<Student> liststu = runner.query(sql, new Object[]{low_grades,high_grades},new BeanListHandler<Student>(Student.class));
		return liststu;
	}
	 //������ѧ�ɼ���ѯ
	public List<Student> selectStudentByMath(int low_grades,int high_grades) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		 String sql = "select * from student where Math>=? and Math<=?";
		 List<Student> liststu = runner.query(sql, new Object[]{low_grades,high_grades}, new BeanListHandler<Student>(Student.class));
		 return liststu;
		
	}
	//�������ĳɼ���ѯ
	public List<Student> selectStudentByChinese(int low_grades,int high_grades) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getCds());
		 String sql = "select * from student where Chinese>=? and Chinese<=?";
		 List<Student> liststu = runner.query(sql, new Object[]{low_grades,high_grades}, new BeanListHandler<Student>(Student.class));
		 return liststu;
		
	}
}
