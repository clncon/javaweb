package cn.itcast.web.struts.dao;

import cn.itcast.web.struts.domain.Student;
import cn.itcast.web.struts.domain.User;

public class UserDao {
	 //����id��ѯ�û���Ϣ
	  public Student findStudentById(int id){
		  Student student = new Student();
		  student.setUsername("jack");
		  student.setEmail("jack@outlook.com");
		  return student;
	  }
	//�����û���������鿴�û��Ƿ������ݿ��У���Ϊtrue û��Ϊfalse
	 public boolean check(String username,String email){
		 boolean flag=false;
		 if("haha".equals(username)&&"haha@qq.com".equals(email)){
			 flag=true;
		 }
		 return flag;
	 }
	//�����û����Ƿ������ݿ���
	public boolean check(String username){
		boolean flag=false;
		if("�Ǻ�".equals(username)){
			 flag=true;
		}
		return flag;
	}
	  //����û��Ƿ������ݿ���
   public boolean check(User user){
	    boolean flag=false;
	    if("�Ǻ�".equals(user.getUsername())
	    		
	    		&&
	    		
	     "123456".equals(user.getPassword())){
	    	flag=true;
	    }
	    return flag;
   }
}
