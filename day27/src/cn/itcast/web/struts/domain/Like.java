package cn.itcast.web.struts.domain;

public enum Like {
   sing("sing","����"),dance("dance","����"),net("net","����"),play("play","��Ϸ");
   
   private String value;
   private String desc;
   
   private Like(String value,String desc){
	   this.value=value;
	   this.desc = desc;
   }

public String getValue() {
	return value;
}

public String getDesc() {
	return desc;
}


   
}
