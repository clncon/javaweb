package cn.itcast.java.beanutils;




import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.Test;

public class Demo1 {
	//@Test
	/*public void test1() throws Exception{
		Student st = new Student();
		BeanUtils bu = new BeanUtils();
		bu.setProperty(st, "name", "lili");
		bu.setProperty(st, "age", "50");
		String s =bu.getProperty(st, "name");
		String age = bu.getProperty(st, "age");
              System.out.println(s);
              System.out.println(age);
		
	} */
	@Test
	 public void test2() throws Exception{
		BeanUtils bu = new BeanUtils();
		Student st = new Student();
		ConvertUtils.register(new Converter(){
			public Object convert(Class type,Object value){
				String borns = (String)value;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return sdf.parse(borns);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
		}, java.util.Date.class);
		
		bu.setProperty(st, "born", "1995-01-05");
		String bo = bu.getProperty(st, "born");
		System.out.println(bo);
	}
	

}
