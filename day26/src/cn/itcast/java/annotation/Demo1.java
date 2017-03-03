package cn.itcast.java.annotation;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
  /*演示annotation三个基本的注解*/
	//override注解表示注解的方法是重载的，如果不符合重载的规范，就会报错
	@Override
	public String toString(){
		return null;
	};
	//deprecated表示方法是过时的
	@Deprecated
	public void run(){
		
	};
	//supperssWarnings表示对编译器对警告信息，一种抑制情况
	@SuppressWarnings("all")
	public void show(){
		List list = new ArrayList();
	}
}
