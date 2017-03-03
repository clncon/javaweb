package cn.itcast.xml.example3.domain;

public class Student {
	private String id;
	private String name;
	private String  age;
	private static Student student;
	private Student(){}
	public static Student getStudent(){
		if(student == null)
	    {
	      student = new Student();
	      
	    }
		return student;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	

}
