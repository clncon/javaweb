package cn.itcast.web.jsp.el;

public class CheckPasswd {
   public static boolean check(String pwd1,String pwd2){
	   boolean flag=true;
	   if(pwd1.equals("")||pwd2.equals("")){
		   System.out.printf("密码必须填");
		   flag=false;
         
		   
	   }
	   else if(pwd1.length()!=6||pwd2.length()!=6){
		   System.out.println("密码必须是6位");
		    flag=false;
	   }
	   else if(!pwd1.equals(pwd2)){
		   System.out.println("两次输入的密码不一致");
		   flag=false;
	   }
	   return flag;
   }
}
