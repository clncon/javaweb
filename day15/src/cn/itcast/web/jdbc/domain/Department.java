package cn.itcast.web.jdbc.domain;

import java.util.ArrayList;
import java.util.List;

public class Department {
   private int id;
   private String name;
   private List<Employee> listEmpoyee = new ArrayList<Employee>();
   
   public Department(){}

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

public List<Employee> getListEmpoyee() {
	return listEmpoyee;
}

public void setListEmpoyee(List<Employee> listEmpoyee) {
	this.listEmpoyee = listEmpoyee;
}
   
   
}
