package cn.itcast.web.domian;

public class checkBean {
	public boolean vlidate(String name,String username){
		boolean flag = false;
		if(name.equals(username)){
			flag = true;
		}
		return flag;
	}

}
