package cn.itcast.java.proxy.exe1;

public class Fans {

	
	public static void main(String[] args) {
		/*静态代理*/
		 //取得代理员对象
		 LiyuchunProxy lp = new LiyuchunProxy();
		//取得被代理的对象
		 Star star = lp.getProxy();
		 //调用代理对象的方法
		  star.sing();


	}

}
