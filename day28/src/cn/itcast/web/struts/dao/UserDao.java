package cn.itcast.web.struts.dao;

import cn.itcast.web.struts.domain.Student;
import cn.itcast.web.struts.domain.User;

public class UserDao {
	 //根据id查询用户信息
	  public Student findStudentById(int id){
		  Student student = new Student();
		  student.setUsername("jack");
		  student.setEmail("jack@outlook.com");
		  return student;
	  }
	//根据用户名和邮箱查看用户是否在数据库中，有为true 没有为false
	 public boolean check(String username,String email){
		 boolean flag=false;
		 if("haha".equals(username)&&"haha@qq.com".equals(email)){
			 flag=true;
		 }
		 return flag;
	 }
	//检查该用户名是否在数据库中
	public boolean check(String username){
		boolean flag=false;
		if("呵呵".equals(username)){
			 flag=true;
		}
		return flag;
	}
	  //检查用户是否在数据库中
   public boolean check(User user){
	    boolean flag=false;
	    if("呵呵".equals(user.getUsername())
	    		
	    		&&
	    		
	     "123456".equals(user.getPassword())){
	    	flag=true;
	    }
	    return flag;
   }
}
