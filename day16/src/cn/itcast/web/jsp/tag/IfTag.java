package cn.itcast.web.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport {
	 //用于记录是否满足条件
     private boolean flag;

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
	public void doTag() throws JspException, IOException {
		 if(this.flag){
			 this.getJspBody().invoke(null);
		 }
	}
     
     
}
