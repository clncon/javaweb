package cn.itcast.java.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//Junit测试在类加载前后执行
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
