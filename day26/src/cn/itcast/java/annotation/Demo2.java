package cn.itcast.java.annotation;

public class Demo2 {
  /*自定义注解*/
	
	@myAnnotation(age = 30, gender = "male", name = "jack")
	public void jump(){};
	@youAnnotation
	public void sleep(){};
	@theyAnnotation(value = { "电话","电视","电脑" })
	public void buy(){}
	@theyAnnotation({"游戏","足球"})
	public void play(){}
}
