package cn.itcast.web.struts.db;

public class DB {

	public static boolean check(String username, String password1, String password2) {
		boolean flag=false;
		if(username!=null&&password1!=null&&password2!=null&&
				username.trim().length()>0&&
				password1.trim().length()>0&&
				password2.trim().length()>0&&
				password1.equals(password2)){
			flag=true;
		}
		return flag;
		
	}

}
