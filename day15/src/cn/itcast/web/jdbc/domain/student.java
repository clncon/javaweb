package cn.itcast.web.jdbc.domain;

import java.util.ArrayList;
import java.util.List;

public class student {
	private int id;
	private String name;
	private List<teacher> listTeacher = new ArrayList<teacher>();
	
	public student(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<teacher> getListTeacher() {
		return listTeacher;
	}

	public void setListTeacher(List<teacher> listTeacher) {
		this.listTeacher = listTeacher;
	}
	
	

}
