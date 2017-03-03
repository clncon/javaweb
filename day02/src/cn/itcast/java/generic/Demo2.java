package cn.itcast.java.generic;

//自定义泛型方法，类
public class Demo2 {
  public static void main(String[] argc){
	 String  numA="100";
	 String  numB="200";
	 System.out.println("numA"+numA);
	 System.out.println("numB"+numB);
	 Swap(numA,numB);
	 
  }
  public static <T> void Swap(T numA,T numB){
	  T Temp;
	  Temp = numA;
	  numA = numB;
	  numB = Temp;
	  System.out.println("numA"+numA);
	  System.out.println("numB"+numB);
  }
	
}
