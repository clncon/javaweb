package com.xsgl.web.service;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xsgl.web.dao.stuDao;
import com.xsgl.web.domain.MyClass;
import com.xsgl.web.domain.Page;
import com.xsgl.web.domain.Student;
import com.xsgl.web.exception.gradesException;

public class stuService {

	  stuDao studao = new stuDao();
	  //根据课程的不及格率来降序的显示每个班级的情况
	  public Map<String,List<MyClass>> QueryAllClassByFailInDesc(String course) throws Exception{
		  Map<String,List<MyClass>> map = null;
		  try {
			map = this.QueryAllClassByCourse(course);
			List<MyClass> listClassDesc = map.get(course);
			Collections.sort(listClassDesc, new Comparator<MyClass>() {

				
				public int compare(MyClass o1, MyClass o2) {
					if(o1.getUnfail()>o2.getUnfail()){
						return -1;
				}
					return 1;
				}
				
			});
			map.put(course, listClassDesc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		  return map;
	  }
	  //根据课程的不及格率来升序的显示每个班级的情况
	   public Map<String,List<MyClass>> QueryAllClassByFailInAsc(String course) throws Exception{
		   Map<String,List<MyClass>> map = null;
		   try {
			map = this.QueryAllClassByCourse(course);
			List<MyClass> listClassAsc = map.get(course);
			Collections.sort(listClassAsc,new Comparator<MyClass>() {

				public int compare(MyClass o1, MyClass o2) {
					if(o1.getUnfail()>=o2.getUnfail()){
						/*System.out.println(o1.getUnfail());
						System.out.println(o2.getUnfail());
						System.out.println("1");*/
					    return 1;
					}
					/*System.out.println(o1.getUnfail());
					System.out.println(o2.getUnfail());
					 System.out.println("-1");*/
						return -1;
				}
				
				
			});
			map.put(course, listClassAsc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		    return map;
	   }
	  //根据课程优秀率来降序的显示每个班级的情况
	  public Map<String,List<MyClass>> QueryAllClassByGreateInDesc(String course) throws Exception{
		  Map<String,List<MyClass>> map = null;
		  try {
			 //取得存有各班级某门课程情况的map对象
			map = this.QueryAllClassByCourse(course);
			//取得存有各班级的某门课程的情况的list集合
	      List<MyClass> listClassDesc = map.get(course);
	      //对集合中的所有数据进行重新排序
	      Collections.sort(listClassDesc,new Comparator<MyClass>(){

			//匿名内部类
			public int compare(MyClass o1, MyClass o2) {
				if(o1.getOutstanding()>o2.getOutstanding()){
					return -1;
				}
				return 1;
			}
	    	  
		});
	      map.put(course, listClassDesc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		  return map;
	  }
	  //根据课程优秀率来升序的显示每个班级的情况
	  public Map<String,List<MyClass>> QueryAllClassByGreateInAsc(String course) throws Exception{
		  Map<String,List<MyClass>> map = null;
		      try {
		    	 map  = this.QueryAllClassByCourse(course);
				List<MyClass> listClassAsc = map.get(course);
				Collections.sort(listClassAsc, new Comparator<MyClass>(){
					public int compare(MyClass o1, MyClass o2) {
						if(o1.getOutstanding()>=o2.getOutstanding()){
							return 1;
						}
						return -1;
					}
					
				});
				 map.put(course, listClassAsc);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
				 
			}
		      return map;
	  }
	  //根据课程查询所有班级情况
	  public Map<String,List<MyClass>> QueryAllClassByCourse(String course) throws Exception{
	    Map<String, List<MyClass> > map = new HashMap<String, List<MyClass>>();
	    List<MyClass> listMyclass = new ArrayList<MyClass>();
	       try {
	    	   DecimalFormat  df = new DecimalFormat("##.00");
	    	    //循环每个班级
			  for(int i=1;i<=studao.QueryClassNumber();i++){
				  //为每个班级建立个对象
				  MyClass myclass = new MyClass();
				  //取得每个班级所有的学生人数
				  double allstuOfClass = studao.QueryStudentCountByClass("0"+i+"班");
				  //System.out.println(allstuOfClass);
				 //取得每个班级该课程及格的人数
				  double allUnFailstuOfCourse = studao.QueryStudentCountByFail(course, "0"+i+"班");
				 // System.out.println(allUnFailstuOfCourse);
				 //计算每个班级该课程的及格率
				 double unFailRate =Double.parseDouble(df.format(allUnFailstuOfCourse/allstuOfClass));
				// System.out.println(unFailRate);
				 //取得每个班级该课程优秀的人数
				 double allGreatestuOfCourse = studao.QueryStudentCountByGreat(course, "0"+i+"班");
				 //System.out.println(allGreatestuOfCourse );
				 //计算每个班级该课程的优秀率
				double GreateRate = Double.parseDouble(df.format(allGreatestuOfCourse/allstuOfClass));
				//System.out.println(GreateRate);
				 //放入到MyClass对象中
				 myclass.setMyclass("0"+i+"班");
				 myclass.setUnfail(unFailRate);
				 myclass.setOutstanding(GreateRate);
				 listMyclass.add(myclass);
				 
			   }
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new Exception();
		}
	        map.put(course, listMyclass);
	        return map;
	  }
	  //根据学号来排序
	  public List<Student> OrderStudentById(String order) throws SQLException{
		  return studao.OrderStudentById(order);
	  }
	   //根据英语成绩来排序
	  public List<Student> OrderStudentByEnglish(String order) throws SQLException{
		  return studao.OrderStudentByEnglish(order);
	  }
	  //根据数学成绩来排序
	  public List<Student> OrderStudentByMath(String order) throws SQLException{
		  return studao.OrderStudentByMath(order);
	  }
	  //根据语文成绩来排序
	  public List<Student> OrderStudentByChinese(String order) throws SQLException{
		  return studao.OrderStudentByChinese(order);
	  }
	  //根据总分成绩来排序
	  public List<Student> OrderStudentBySum(String order) throws SQLException{
		  return studao.OrderStudentBySum(order);
	  }
	  //根据学生的英语成绩查询
	  public List<Student> findStudentByEnglish(String grade) throws gradesException, SQLException{
		  try{
		   String[] grades = grade.split("_");
		   int low_grade = Integer.parseInt(grades[0]);
		   int high_grade = Integer.parseInt(grades[1]);
		   if(low_grade>high_grade){
			   throw new gradesException();
		   }
		   return studao.selectStudentByEnglish(low_grade, high_grade);
		  }
		  catch(SQLException e){
			  e.printStackTrace();
			  throw e;
		  }
		  catch(Exception e){
			  throw new gradesException();
		  }
		   
	  }
	   //根据数学的成绩查询学生
	  public List<Student> findStudentByMath(String grade) throws gradesException, SQLException{
		  try{
		   String[] grades = grade.split("_");
		   int low_grade = Integer.parseInt(grades[0]);
		   int high_grade = Integer.parseInt(grades[1]);
		   if(low_grade>high_grade){
			   throw new gradesException();
		   }
		   return studao.selectStudentByMath(low_grade, high_grade);
		  }
		  catch(SQLException e){
			  e.printStackTrace();
			  throw e;
		  }
		  catch(Exception e){
			  throw new gradesException();
		  }
		   
	  }
	  //根据语文成绩查询
	  public List<Student> findStudentByChinese(String grade) throws gradesException, SQLException{
		  try{
		   String[] grades = grade.split("_");
		   int low_grade = Integer.parseInt(grades[0]);
		   int high_grade = Integer.parseInt(grades[1]);
		   if(low_grade>high_grade){
			   throw new gradesException();
		   }
		   return studao.selectStudentByChinese(low_grade, high_grade);
		  }
		  catch(SQLException e){
			  e.printStackTrace();
			  throw e;
		  }
		  catch(Exception e){
			  throw new gradesException();
		  }
		   
	  }
	  //删除一条学生信息通过Id
	  public void deleteStudentById(int id) throws SQLException{
		  studao.DeleteStudentById(id);
	  }
	  //根据id号查找一名学生信息
	  public Student findStudentById(int id) throws SQLException{
		  return studao.findStudentById(id);
	  }
	  //根据id号更新用户信息
	  public void UpdateStudentById(Student stu) throws SQLException{
		  studao.UpdateStudentById(stu);
	  }
	 //查找数据库所有的记录数
	public Page findAllStudent(int currentPageNo) throws SQLException{
		Page page = new Page();
		try {
			page.setCurrentPageNo(currentPageNo);
			page.setAllRecoderNo(studao.findAllRecorder());
			int start = (currentPageNo-1)*page.getPerPageNo();
			page.setListStudent(studao.findAllStudent(start, page.getPerPageNo()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
		return page;
	}
	//增加一条记录
	public void addRecorder(Student student) throws SQLException{
		studao.addRecorder(student);
		
	}
	//根据学生姓名来查询信息
	public List<Student> findStudentByName(String name) throws SQLException{
		return studao.selectStudentByName(name);
	}
	//根据学生班级查询信息
	public List<Student> findStudentByClass(String Class) throws SQLException{
		return studao.selectStudentByClass(Class);
	}
}
