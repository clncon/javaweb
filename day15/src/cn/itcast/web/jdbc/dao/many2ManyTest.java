package cn.itcast.web.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.web.jdbc.domain.student;
import cn.itcast.web.jdbc.domain.teacher;

public class many2ManyTest {

	public static void main(String[] args) throws SQLException {
		//1.���������ʦ���󣬲���ֵ
		teacher t1 = new teacher();
		t1.setName("��");
		teacher t2 = new teacher();
		t2.setName("��");
		//2.�������ѧ��������ֵ
		student s1 = new student();
		s1.setName("С��");
		student s2 = new student();
		s2.setName("С��");
		//3.��teacher�������studnet����
		List<student> listStudent = new ArrayList<student>();
		listStudent.add(s1);
		listStudent.add(s2);
		t1.setListStudent(listStudent);
		t2.setListStudent(listStudent);
		//4.��student�������teacher����
		List<teacher> listTeacher = new ArrayList<teacher>();
		listTeacher.add(t1);
		listTeacher.add(t2);
		s1.setListTeacher(listTeacher);
		s2.setListTeacher(listTeacher);
		//5.���浽���ݿ���
		Dao dao = new Dao();
		dao.save(s1);
	}

}
