package cn.itcast.web.jdbc.domain;

import java.util.ArrayList;
import java.util.List;

public class teacher {
   private int id;
   private String name;
   private List<student> listStudent = new ArrayList<student>();
   
   public teacher(){}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<student> getListStudent() {
	return listStudent;
}

public void setListStudent(List<student> listStudent) {
	this.listStudent = listStudent;
}
   
   
}
