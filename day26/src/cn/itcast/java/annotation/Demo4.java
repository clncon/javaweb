package cn.itcast.java.annotation;

import java.lang.reflect.Method;

public class Demo4 {
	@Role
    public static void execute(String username,String password) throws Exception, Exception{
		  //ȡ��Demo����ֽ������
		  Class clazz = Demo4.class;
		  //�÷���ķ�ʽȡ��Demo4�ķ���
		   Method method = clazz.getMethod("execute", String.class,String.class);
		   //ȡ�ö����ڷ����ϵ�ע��
		    Role roleClass = method.getAnnotation(Role.class);
		    //ȥ��ע���ֵ��
		     String user = roleClass.user();
		     String pwd = roleClass.password();
		     if(user.equals(username)&&pwd.equals(password)){
		    	 find();
		     }else{
		    	 System.out.println("δ��ִ��find()����");
		     }
    	
    }

	private static void find() {
		System.out.println("��¼�ɹ�");
		
	}
	public static void main(String[] args) throws Exception {
		Demo4.execute("jack","1234654");
	}
}
