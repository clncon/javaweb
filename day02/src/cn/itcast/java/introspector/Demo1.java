package cn.itcast.java.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

//用SUN提供内省（Intropector）API操作JavaBean属性
public class Demo1 {
      @Test
	public void test1() throws Exception {
		Student st = new Student();
		PropertyDescriptor pd = new PropertyDescriptor("name", Student.class);
         Method md = pd.getWriteMethod();
         md.invoke(st,"lili");
         Method md2 = pd.getReadMethod();
        String returnValue =  (String)md2.invoke(st,null);
        System.out.println(returnValue);
	} 
      @Test
      //属性和get()方法数量一致;
   public void test2() throws Exception{
    	    //BeanInfo表示Student对象所有属性集合的情况
    	  BeanInfo bi = Introspector.getBeanInfo(Student.class);
    	  //将Student对象所有的属性存入属性描述集合中
    	  PropertyDescriptor[] pd = bi.getPropertyDescriptors();
    	  for(PropertyDescriptor p:pd){
    		  System.out.println(p.getName());
    	  }
    	       
      }
      

}
