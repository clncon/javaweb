package cn.itcast.web.mail.util;

public class test {

	
	public static void main(String[] args) {
		try {
			MessageUtil.sendMessage("bbb@qq.com","����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
