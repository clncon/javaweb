package cn.itcast.web.jsp.el;

public class CheckPasswd {
   public static boolean check(String pwd1,String pwd2){
	   boolean flag=true;
	   if(pwd1.equals("")||pwd2.equals("")){
		   System.out.printf("���������");
		   flag=false;
         
		   
	   }
	   else if(pwd1.length()!=6||pwd2.length()!=6){
		   System.out.println("���������6λ");
		    flag=false;
	   }
	   else if(!pwd1.equals(pwd2)){
		   System.out.println("������������벻һ��");
		   flag=false;
	   }
	   return flag;
   }
}
