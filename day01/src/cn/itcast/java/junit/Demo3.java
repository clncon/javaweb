package cn.itcast.java.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//Junit�����������ǰ��ִ��
public class Demo3 {
  @BeforeClass
   public static void setBeforeClass(){
	System.out.println("setBeforeClass");
  }
   @Test
   public void test(){
	   System.out.println("hello");
   }
   @AfterClass
   public static void tearDownAfterClass(){
	  System.out.println("tearDownAfterClass");   
   }
}
