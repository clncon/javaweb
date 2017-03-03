package cn.itcast.web.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.web.jdbc.domain.Department;
import cn.itcast.web.jdbc.domain.Employee;

public class one2ManyTest {

	public static void main(String[] args) throws SQLException {
		//1.建立部门对象Department并赋值
		  Department department = new Department();
		  department.setName("软件部");
		  
		//2.建立多个员工对象
		  Employee employee1= new Employee();
		  employee1.setName("小张");
		  Employee employee2 = new Employee();
		  employee2.setName("小何");
		  List<Employee> listEmployee = new ArrayList<Employee>();
		  listEmployee.add(employee1);
		  listEmployee.add(employee2);
		  //3.绑定到department对像中
		  department.setListEmpoyee(listEmployee);
		  //4.将department对象绑定到employee对象中
		  employee1.setDepartment(department);
		  employee2.setDepartment(department);
		  
		  //5.保存到数据库中
		  Dao dao = new Dao();
		  dao.save(department);
		  
	}

}
