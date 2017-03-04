package cn.itcast.java.reflect;

public class Person {
	public   String name;
	private int age;
	public  Person(String name,int age){
		System.out.println("Myname is "+name+"age is"+age);
	}
	private Person(){
		System.out.println("hello Person");
		
	}
	public void  show (){
		System.out.println("hello");
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	 public void show(String[] likes,double salary){
    	 System.out.println("likes"+likes+" salary"+salary);
     }
	 private  int  haha(){
		 System.out.println("haha");
		 return 3;
	 }
	 public static  void main(String[] agrs){
		 System.out.println("------");
	 }

}
