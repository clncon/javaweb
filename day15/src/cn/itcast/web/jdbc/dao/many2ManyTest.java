package cn.itcast.web.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.web.jdbc.domain.student;
import cn.itcast.web.jdbc.domain.teacher;

public class many2ManyTest {

	public static void main(String[] args) throws SQLException {
		//1.创建多个老师对象，并赋值
		teacher t1 = new teacher();
		t1.setName("赵");
		teacher t2 = new teacher();
		t2.setName("何");
		//2.创建多个学生，并赋值
		student s1 = new student();
		s1.setName("小王");
		student s2 = new student();
		s2.setName("小李");
		//3.让teacher对象关联studnet对象
		List<student> listStudent = new ArrayList<student>();
		listStudent.add(s1);
		listStudent.add(s2);
		t1.setListStudent(listStudent);
		t2.setListStudent(listStudent);
		//4.让student对象关联teacher对象
		List<teacher> listTeacher = new ArrayList<teacher>();
		listTeacher.add(t1);
		listTeacher.add(t2);
		s1.setListTeacher(listTeacher);
		s2.setListTeacher(listTeacher);
		//5.保存到数据库中
		Dao dao = new Dao();
		dao.save(s1);
	}

}
