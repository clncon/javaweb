package cn.itcast.xml.example3;

import cn.itcast.xml.example3.dao.StudentDao;
import cn.itcast.xml.example3.domain.Student;
import cn.itcast.xml.example3.ui.StudentUI;

public class Demo {

	public static void main(String[] args) throws Exception {
		StudentUI ui = new StudentUI();
		Student student = ui.input();
		StudentDao dao = new StudentDao();
		boolean flag = dao.create(student);
		ui.output(flag);

	}

}
