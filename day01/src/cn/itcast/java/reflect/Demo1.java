package cn.itcast.java.reflect;

public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class c1 = String.class;
		Class c2 = new String().getClass();
		Class c3 = Class.forName("java.lang.String");
		if(c1==c2)
			System.out.println("c1==c2");
		else if (c1==c3)
			System.out.println("c1==c3");
		else if (c2==c3)
			System.out.println("c2==c3");
		else 
			System.out.println("c1!=c2!=c3");
		

	}

}
