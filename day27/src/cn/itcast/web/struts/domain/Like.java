package cn.itcast.web.struts.domain;

public enum Like {
   sing("sing","³ª¸è"),dance("dance","ÌøÎè"),net("net","ÉÏÍø"),play("play","ÓÎÏ·");
   
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
