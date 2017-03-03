package cn.itcast.web.struts.domain;

public enum City {
    bj("bj","北京"),sh("sh","上海"),gz("gz","上海"),cq("cg","重庆");
    
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
