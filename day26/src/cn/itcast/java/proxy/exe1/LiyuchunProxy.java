package cn.itcast.java.proxy.exe1;

public class LiyuchunProxy implements Star{
	//����������Ķ���
	private Liyuchun liyuchun = new Liyuchun();
	public void sing() {
		//���ñ�����ķ���
		liyuchun.sing();
	}
  //���ڽӿڱ��
	 public Star getProxy(){
		 return liyuchun;
	 }

}
