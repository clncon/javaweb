package cn.itcast.java.enumration3;

public class Demo1 {
	public static void main(String[] agrs){
	    student st = new student("lili");
	    st.setGs(grades.B);
		System.out.println("myname is "+st.getName());
		System.out.println("�ȼ�Ϊ" + st.getGs().getSt());
		System.out.println("����Ϊ"+st.getGs().getDesc());
	}

}
