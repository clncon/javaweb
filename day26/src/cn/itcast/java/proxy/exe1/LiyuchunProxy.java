package cn.itcast.java.proxy.exe1;

public class LiyuchunProxy implements Star{
	//创建被代理的对象
	private Liyuchun liyuchun = new Liyuchun();
	public void sing() {
		//调用被代理的方法
		liyuchun.sing();
	}
  //基于接口编程
	 public Star getProxy(){
		 return liyuchun;
	 }

}
