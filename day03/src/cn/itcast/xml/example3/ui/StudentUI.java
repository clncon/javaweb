package cn.itcast.xml.example3.ui;

import java.util.Scanner;

import cn.itcast.xml.example3.domain.Student;

public class StudentUI {
	public Student input(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("id:");
		String studentId = scanner.nextLine();
		System.out.print("name:");
		String studentName = scanner.nextLine();
		System.out.print("age:");
		String studentAge = scanner.nextLine();
		Student student =Student.getStudent();
		student.setId(studentId);
		student.setName(studentName);
		student.setAge(studentAge);
		return student;
	}
	public void output(boolean flag){
		if(flag){
			System.out.println("创建成功");
		}
		else
		{
			System.out.println("创建失败");
		}
	}

}
