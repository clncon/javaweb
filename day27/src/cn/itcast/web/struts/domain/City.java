package cn.itcast.web.struts.domain;

public enum City {
    bj("bj","����"),sh("sh","�Ϻ�"),gz("gz","�Ϻ�"),cq("cg","����");
    
    private String value;
    private String desc;
    
    
    private City(String value,String desc){
    	this.value=value;
    	this.desc=desc;
    }


	public String getValue() {
		return value;
	}


	public String getDesc() {
		return desc;
	}
    
}
