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
	  //���ݿγ̵Ĳ����������������ʾÿ���༶�����
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
	  //���ݿγ̵Ĳ����������������ʾÿ���༶�����
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
	  //���ݿγ����������������ʾÿ���༶�����
	  public Map<String,List<MyClass>> QueryAllClassByGreateInDesc(String course) throws Exception{
		  Map<String,List<MyClass>> map = null;
		  try {
			 //ȡ�ô��и��༶ĳ�ſγ������map����
			map = this.QueryAllClassByCourse(course);
			//ȡ�ô��и��༶��ĳ�ſγ̵������list����
	      List<MyClass> listClassDesc = map.get(course);
	      //�Լ����е��������ݽ�����������
	      Collections.sort(listClassDesc,new Comparator<MyClass>(){

			//�����ڲ���
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
	  //���ݿγ����������������ʾÿ���༶�����
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
	  //���ݿγ̲�ѯ���а༶���
	  public Map<String,List<MyClass>> QueryAllClassByCourse(String course) throws Exception{
	    Map<String, List<MyClass> > map = new HashMap<String, List<MyClass>>();
	    List<MyClass> listMyclass = new ArrayList<MyClass>();
	       try {
	    	   DecimalFormat  df = new DecimalFormat("##.00");
	    	    //ѭ��ÿ���༶
			  for(int i=1;i<=studao.QueryClassNumber();i++){
				  //Ϊÿ���༶����������
				  MyClass myclass = new MyClass();
				  //ȡ��ÿ���༶���е�ѧ������
				  double allstuOfClass = studao.QueryStudentCountByClass("0"+i+"��");
				  //System.out.println(allstuOfClass);
				 //ȡ��ÿ���༶�ÿγ̼��������
				  double allUnFailstuOfCourse = studao.QueryStudentCountByFail(course, "0"+i+"��");
				 // System.out.println(allUnFailstuOfCourse);
				 //����ÿ���༶�ÿγ̵ļ�����
				 double unFailRate =Double.parseDouble(df.format(allUnFailstuOfCourse/allstuOfClass));
				// System.out.println(unFailRate);
				 //ȡ��ÿ���༶�ÿγ����������
				 double allGreatestuOfCourse = studao.QueryStudentCountByGreat(course, "0"+i+"��");
				 //System.out.println(allGreatestuOfCourse );
				 //����ÿ���༶�ÿγ̵�������
				double GreateRate = Double.parseDouble(df.format(allGreatestuOfCourse/allstuOfClass));
				//System.out.println(GreateRate);
				 //���뵽MyClass������
				 myclass.setMyclass("0"+i+"��");
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
	  //����ѧ��������
	  public List<Student> OrderStudentById(String order) throws SQLException{
		  return studao.OrderStudentById(order);
	  }
	   //����Ӣ��ɼ�������
	  public List<Student> OrderStudentByEnglish(String order) throws SQLException{
		  return studao.OrderStudentByEnglish(order);
	  }
	  //������ѧ�ɼ�������
	  public List<Student> OrderStudentByMath(String order) throws SQLException{
		  return studao.OrderStudentByMath(order);
	  }
	  //�������ĳɼ�������
	  public List<Student> OrderStudentByChinese(String order) throws SQLException{
		  return studao.OrderStudentByChinese(order);
	  }
	  //�����ֳܷɼ�������
	  public List<Student> OrderStudentBySum(String order) throws SQLException{
		  return studao.OrderStudentBySum(order);
	  }
	  //����ѧ����Ӣ��ɼ���ѯ
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
	   //������ѧ�ĳɼ���ѯѧ��
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
	  //�������ĳɼ���ѯ
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
	  //ɾ��һ��ѧ����Ϣͨ��Id
	  public void deleteStudentById(int id) throws SQLException{
		  studao.DeleteStudentById(id);
	  }
	  //����id�Ų���һ��ѧ����Ϣ
	  public Student findStudentById(int id) throws SQLException{
		  return studao.findStudentById(id);
	  }
	  //����id�Ÿ����û���Ϣ
	  public void UpdateStudentById(Student stu) throws SQLException{
		  studao.UpdateStudentById(stu);
	  }
	 //�������ݿ����еļ�¼��
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
	//����һ����¼
	public void addRecorder(Student student) throws SQLException{
		studao.addRecorder(student);
		
	}
	//����ѧ����������ѯ��Ϣ
	public List<Student> findStudentByName(String name) throws SQLException{
		return studao.selectStudentByName(name);
	}
	//����ѧ���༶��ѯ��Ϣ
	public List<Student> findStudentByClass(String Class) throws SQLException{
		return studao.selectStudentByClass(Class);
	}
}
