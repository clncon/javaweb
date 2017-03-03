package cn.itcast.java.proxy.exe2;

public class Fans {

	
	public static void main(String[] args) {
		LiyuchunProxy lp = new LiyuchunProxy();
		Star  star = lp.getProxy();
		star.eat("8");

	}

}
