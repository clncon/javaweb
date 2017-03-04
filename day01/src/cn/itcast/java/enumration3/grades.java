package cn.itcast.java.enumration3;

public enum grades {
	A("A","90-100"),
	B("B","80-89"),
	C("C","70-79"),
	D("D","60-69"),
	E("E","<59");
	private String st;
	private String desc;
	private grades(String st,String desc){
		this.st = st;
		this.desc = desc;
	}
	public String getSt() {
		return st;
	}
	public String getDesc() {
		return desc;
	}
	

}
