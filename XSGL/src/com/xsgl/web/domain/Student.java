package com.xsgl.web.domain;

public class Student {
	 private int id ;
	 private String name;
	 private String gender;
	 private String myClass; 
	 private int english;
	 private int math;
	 private int chinese;
	 private int total_point;
	 private float average;
	 public Student(){
	 }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public String getMyClass() {
		return myClass;
	}
	public void setMyClass(String myClass) {
		this.myClass = myClass;
	}
	public int getTotal_point() {
		this.total_point=this.getChinese()+this.getEnglish()+this.getMath();
		return total_point;
	}
	public float getAverage() {
		this.average=this.getTotal_point()/3;
		return average;
	}
	 
}
