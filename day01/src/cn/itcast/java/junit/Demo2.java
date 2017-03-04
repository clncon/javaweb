package cn.itcast.java.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Junit测试在方法前后执行
public class Demo2 {
	@Before
	  public void Setup(){
		System.out.println("Setup");
	}
	@Test
	public void test(){
		System.out.println("hello");
	}
	
	@After
	public void tearDown(){
		System.out.println("tearDown");
		
	}
}
