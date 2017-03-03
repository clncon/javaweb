package cn.itcast.web.domain;

public class modelBean {
	public boolean validate(String name){
		boolean flag = false;
		if(name!=null&&name.matches("[\u3400-\uFA29]+"))
		{
			flag = true;
			
		}
		
		return flag;
		
	}

}
