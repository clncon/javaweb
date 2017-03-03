package cn.itcast.xml.example1;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		LogingUI logui = new LogingUI();
		LogingBusiness loginbu = new LogingBusiness();
		User user = logui.input();
		boolean bo = loginbu.Check(user);
		logui.output(bo);
	}

}
