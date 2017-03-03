package cn.itcast.web.servlet;

public class LoginBean {
	public boolean validate(String name){
		boolean flag = false;
		if(name!=null&&name.equals("jack")){
			return true;
		}
				return flag;
	}

}
