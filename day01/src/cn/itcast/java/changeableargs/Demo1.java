package cn.itcast.java.changeableargs;
//可变参数的应用
public class Demo1 {

 	public static void main(String[] args) {
     method("nana","lili,mimi,wewe");		
 
	}
	 public static void method(String a,String ...agrs){
		 System.out.println("第一个字符串是"+a);
		 System.out.println("可变参数");
		 for(String str:agrs){
			 System.out.println(str);
		 }
		 
	 }

}
