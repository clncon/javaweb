package cn.itcast.java.proxy.exe1;

public class Fans {

	
	public static void main(String[] args) {
		/*��̬����*/
		 //ȡ�ô���Ա����
		 LiyuchunProxy lp = new LiyuchunProxy();
		//ȡ�ñ�����Ķ���
		 Star star = lp.getProxy();
		 //���ô������ķ���
		  star.sing();


	}

}
