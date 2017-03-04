package cn.itcast.java.enumration3;

public class student {
	private String name;
	private grades gs;

	public grades getGs() {
		return gs;
	}

	public student(String name){
     this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setGs(grades gs){
		this.gs = gs;
	}
}

