package cn.itcast.java.annotation;

public class Demo2 {
  /*�Զ���ע��*/
	
	@myAnnotation(age = 30, gender = "male", name = "jack")
	public void jump(){};
	@youAnnotation
	public void sleep(){};
	@theyAnnotation(value = { "�绰","����","����" })
	public void buy(){}
	@theyAnnotation({"��Ϸ","����"})
	public void play(){}
}
