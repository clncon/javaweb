package cn.itcast.java.changeableargs;
//�ɱ������Ӧ��
public class Demo1 {

 	public static void main(String[] args) {
     method("nana","lili,mimi,wewe");		
 
	}
	 public static void method(String a,String ...agrs){
		 System.out.println("��һ���ַ�����"+a);
		 System.out.println("�ɱ����");
		 for(String str:agrs){
			 System.out.println(str);
		 }
		 
	 }

}
