package cn.itcast.java.reflect;

import java.lang.reflect.Constructor;

public class Demo2 {

	public static void main(String[] args) throws Exception{
		//ȡ��Person����ֽ������
	  Class cs = Class.forName("cn.itcast.java.reflect.Person");
	   //ȡ�ø����Ψһ���췽��
	/*  Constructor con = cs.getDeclaredConstructor(null);
	  
	  //���÷�public�����Ŀɷ����ԣ�Ĭ��Ϊfalse
	  con.setAccessible(true);
	  
	  //��������
	    Person  P  = (Person) con.newInstance(null);*/
	  //ȡ��Ψһ�Ĺ��췽��
	  Constructor c  = cs.getConstructor(String.class,int.class);
	   //����ʵ��
	    Person p1 = (Person) c.newInstance("lolo",20);
	    
	     
    
	    
	    
		

	}

}
