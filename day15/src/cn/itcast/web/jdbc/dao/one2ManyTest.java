package cn.itcast.web.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.web.jdbc.domain.Department;
import cn.itcast.web.jdbc.domain.Employee;

public class one2ManyTest {

	public static void main(String[] args) throws SQLException {
		//1.�������Ŷ���Department����ֵ
		  Department department = new Department();
		  department.setName("�����");
		  
		//2.�������Ա������
		  Employee employee1= new Employee();
		  employee1.setName("С��");
		  Employee employee2 = new Employee();
		  employee2.setName("С��");
		  List<Employee> listEmployee = new ArrayList<Employee>();
		  listEmployee.add(employee1);
		  listEmployee.add(employee2);
		  //3.�󶨵�department������
		  department.setListEmpoyee(listEmployee);
		  //4.��department����󶨵�employee������
		  employee1.setDepartment(department);
		  employee2.setDepartment(department);
		  
		  //5.���浽���ݿ���
		  Dao dao = new Dao();
		  dao.save(department);
		  
	}

}
