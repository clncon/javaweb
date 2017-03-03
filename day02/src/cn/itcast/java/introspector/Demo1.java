package cn.itcast.java.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

//��SUN�ṩ��ʡ��Intropector��API����JavaBean����
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
      //���Ժ�get()��������һ��;
   public void test2() throws Exception{
    	    //BeanInfo��ʾStudent�����������Լ��ϵ����
    	  BeanInfo bi = Introspector.getBeanInfo(Student.class);
    	  //��Student�������е����Դ�����������������
    	  PropertyDescriptor[] pd = bi.getPropertyDescriptors();
    	  for(PropertyDescriptor p:pd){
    		  System.out.println(p.getName());
    	  }
    	       
      }
      

}
