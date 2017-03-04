package cn.itcast.java.enumration3;

public class Demo1 {
	public static void main(String[] agrs){
	    student st = new student("lili");
	    st.setGs(grades.B);
		System.out.println("myname is "+st.getName());
		System.out.println("等级为" + st.getGs().getSt());
		System.out.println("区间为"+st.getGs().getDesc());
	}

}
